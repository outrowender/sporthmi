/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.system.locking;

import de.audi.app.system.locking.AbstractDsiCarVehicleStateListener;
import de.audi.app.system.locking.ILockingEvaluator;
import de.audi.app.system.locking.ILockingInformationProvider;
import de.audi.app.system.locking.LockingBitLogger;
import de.audi.app.system.locking.LockingBitWrapper;
import de.audi.atip.base.IFrameworkAccess;
import de.audi.atip.hmi.HMIService;
import de.audi.atip.hmi.event.ATIPEventListener;
import de.audi.atip.hmi.event.LockingEvent;
import de.audi.atip.log.LogChannel;
import de.audi.atip.power.PowerEventListener;
import de.audi.atip.timer.Timer;
import de.audi.atip.timer.TimerListener;
import org.dsi.ifc.base.DSIBase;
import org.dsi.ifc.carvehiclestates.DSICarVehicleStates;
import org.dsi.ifc.carvehiclestates.DynamicVehicleInfoMidFrequent;
import org.dsi.ifc.carvehiclestates.DynamicVehicleInfoMidFrequentViewOptions;
import org.dsi.ifc.generalvehiclestates.DSIGeneralVehicleStates;

public abstract class AbstractLockingEvaluator
extends AbstractDsiCarVehicleStateListener
implements ILockingEvaluator,
ILockingInformationProvider,
TimerListener,
PowerEventListener {
    protected final IFrameworkAccess fw;
    protected final LogChannel logChannel;
    protected boolean currentLockingState = false;
    protected DSICarVehicleStates carVehicleStateDsi = null;
    protected DSIGeneralVehicleStates generalVehicleStateDsi = null;
    protected DynamicVehicleInfoMidFrequent dynamicVehicleInfoMidFrequent = null;
    protected DynamicVehicleInfoMidFrequentViewOptions dynamicVehicleInfoMidFrequentViewOptions = null;
    protected int automaticGearShiftTransMode = 0;
    protected boolean speedThresholdExeeded = false;
    protected boolean parkingBrakeEngaged = true;
    protected boolean clamp15 = true;
    private final Object MUTEX = new Object();
    private int originalBit1State = -1;
    private int originalBit2State = -1;
    private boolean originalBitValuesStored = false;
    private int logInvalideModeThreshold;
    private int logInvalidModeCounter = this.logInvalideModeThreshold = 20;
    private Timer recheckLockingBitsTimer = null;

    public AbstractLockingEvaluator(IFrameworkAccess iFrameworkAccess) {
        this.fw = iFrameworkAccess;
        this.logChannel = iFrameworkAccess.getLogChannel("App.System.Locking");
        iFrameworkAccess.getHMIService().getChoiceModel(5583).setValue(this.currentLockingState ? 1 : 0);
        this.sendNotification();
    }

    public final void updateDynamicVehicleInfoMidFrequent(DynamicVehicleInfoMidFrequent dynamicVehicleInfoMidFrequent, int n) {
        if (n == 1) {
            this.dynamicVehicleInfoMidFrequent = dynamicVehicleInfoMidFrequent;
            this.startEvaluationProcess();
        }
    }

    public void updateDynamicVehicleInfoMidFrequentViewOptions(DynamicVehicleInfoMidFrequentViewOptions dynamicVehicleInfoMidFrequentViewOptions, int n) {
        if (n == 1) {
            this.dynamicVehicleInfoMidFrequentViewOptions = dynamicVehicleInfoMidFrequentViewOptions;
            this.startEvaluationProcess();
        }
    }

    public final void updateAutomaticGearShiftTransMode(int n, int n2) {
        if (n2 == 1) {
            this.automaticGearShiftTransMode = n;
            this.startEvaluationProcess();
        }
    }

    public final void updateVehicleStandstill(boolean bl, int n) {
        if (n == 1) {
            this.speedThresholdExeeded = !bl;
            this.startEvaluationProcess();
        }
    }

    public final void updateParkingBrake(boolean bl, int n) {
        if (n == 1) {
            this.parkingBrakeEngaged = bl;
            this.startEvaluationProcess();
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public final void startEvaluationProcess() {
        this.logChannel.log(10000000, "AbstractLockingEvaluator#startEvaluationProcess() --> Entered");
        Object object = this.MUTEX;
        synchronized (object) {
            if (LockingBitWrapper.ready()) {
                if (this.recheckLockingBitsTimer != null) {
                    this.recheckLockingBitsTimer.cancel();
                    this.recheckLockingBitsTimer = null;
                }
                this.evaluateConditions();
            } else {
                this.logChannel.log(10000000, "AbstractLockingEvaluator#startEvaluationProcess() - Locking Bits not ready, setting up a timer to recheck.");
                if (this.recheckLockingBitsTimer == null) {
                    this.recheckLockingBitsTimer = new Timer("Recheck Lockingbits", 1000L, false, this);
                }
                this.recheckLockingBitsTimer.restart();
            }
        }
        this.logChannel.log(10000000, "AbstractLockingEvaluator#startEvaluationProcess() <-- Exit");
    }

    private void evaluateConditions() {
        this.logChannel.log(10000000, "AbstractLockingEvaluator#evaluateConditions() --> Entered");
        if (this.logChannel.isDebug()) {
            LockingBitLogger.start(this.fw);
        } else {
            LockingBitLogger.stop();
        }
        boolean bl = this.currentLockingState;
        int n = LockingBitWrapper.getFunctionalBitState(166);
        int n2 = LockingBitWrapper.getFunctionalBitState(167);
        if (n == -1 || n2 == -1) {
            if (this.logInvalidModeCounter % this.logInvalideModeThreshold == 0) {
                this.logChannel.log(10000, "AbstractLockingEvaluator#evaluateConditions() - The bits for the locking mode are not set! Can not identify logic for evaluation. Locking will not take place!");
                this.logChannel.log(10000000, "AbstractLockingEvaluator#evaluateConditions() <-- Returning for missing parameters");
                this.logInvalidModeCounter = 0;
            }
            ++this.logInvalidModeCounter;
            return;
        }
        if (n == 0 && n2 == 0) {
            bl = this.evaluateSpeedDefinition();
        } else if (n == 1 && n2 == 0) {
            bl = this.evaluateNhtsaDefinition();
        } else if (n == 0 && n2 == 1) {
            bl = this.evaluateEngineOffDefinition();
        } else if (n == 1 && n2 == 1) {
            bl = true;
        }
        if (bl != this.currentLockingState) {
            this.logChannel.log(10000000, "AbstractLockingEvaluator#evaluateConditions() - A new locking state has been identified. Previous state=%1, new state=%2", this.currentLockingState, bl);
            this.currentLockingState = bl;
            this.fw.getHMIService().getChoiceModel(5583).setValue(this.currentLockingState ? 1 : 0);
            this.sendNotification();
        }
        this.logChannel.log(10000000, "AbstractLockingEvaluator#evaluateConditions() <-- Returning");
    }

    private void sendNotification() {
        this.logChannel.log(10000000, "AbstractLockingEvaluator#sendNotification() --> Entered");
        this.sendEvent();
        this.sendMessage();
        this.logChannel.log(10000000, "AbstractLockingEvaluator#sendNotification() <-- Returning");
    }

    private void sendEvent() {
        this.logChannel.log(10000000, "AbstractLockingEvaluator#sendEvent() --> Entered");
        HMIService hMIService = this.fw.getHMIService();
        LockingEvent lockingEvent = new LockingEvent((ATIPEventListener)hMIService.getRootWindow(0), this.currentLockingState);
        hMIService.getEventDispatcher().postEvent(lockingEvent);
        this.logChannel.log(10000000, "AbstractLockingEvaluator#sendEvent() <-- Returning");
    }

    private void sendMessage() {
        this.logChannel.log(10000000, "AbstractLockingEvaluator#sendMessage() --> Entered");
        this.fw.getMsgDistrib().sendMessage(this.currentLockingState ? 206 : 207);
        this.logChannel.log(10000000, "AbstractLockingEvaluator#sendMessage() <-- Returning");
    }

    public final void setDiagnosisTestmode(boolean bl) {
        if (!this.originalBitValuesStored) {
            this.originalBit1State = LockingBitWrapper.getFunctionalBitState(166);
            this.originalBit2State = LockingBitWrapper.getFunctionalBitState(167);
            this.originalBitValuesStored = true;
        }
        if (bl) {
            LockingBitWrapper.setFunctionBitState(166, 1);
            LockingBitWrapper.setFunctionBitState(167, 1);
        } else {
            LockingBitWrapper.setFunctionBitState(166, this.originalBit1State);
            LockingBitWrapper.setFunctionBitState(167, this.originalBit2State);
        }
    }

    public final void setDSI(DSIBase dSIBase) {
        this.logChannel.log(10000000, "AbstractLockingEvaluator#setDSI(%1) --> Entered", (Object)dSIBase);
        this.fw.getStartupMgr().logStartupEvent("AbstractLockingEvaluator#setDSI(" + dSIBase + ") --> Entered");
        if (dSIBase instanceof DSIGeneralVehicleStates) {
            this.generalVehicleStateDsi = (DSIGeneralVehicleStates)dSIBase;
            this.generalVehicleStateDsi.setNotification(this);
        } else if (dSIBase instanceof DSICarVehicleStates) {
            this.carVehicleStateDsi = (DSICarVehicleStates)dSIBase;
            this.carVehicleStateDsi.setNotification(this);
        }
        this.logChannel.log(10000000, "AbstractLockingEvaluator#setDSI() <-- Returning");
    }

    public final void releaseDSI() {
        this.logChannel.log(10000000, "AbstractLockingEvaluator#releaseDSI() --> Entered");
        this.fw.getStartupMgr().logStartupEvent("AbstractLockingEvaluator#releaseDSI() --> Entered");
        this.carVehicleStateDsi.clearNotification(this);
        this.carVehicleStateDsi = null;
        this.generalVehicleStateDsi.clearNotification(this);
        this.generalVehicleStateDsi = null;
        this.startEvaluationProcess();
    }

    protected void finalize() throws Throwable {
        this.releaseDSI();
        super.finalize();
    }

    public void fireTimer(Timer timer) {
        if (timer.equals(this.recheckLockingBitsTimer)) {
            this.startEvaluationProcess();
        }
    }

    public void cancelTimer(Timer timer) {
    }

    public void notifyPowerListenerOnEnterState(int n, int n2) {
    }

    public void notifyPowerListenerOnExitState(int n, int n2) {
    }

    public void notifyPowerTriggerAction(int n, int n2) {
    }

    public void updateClampState(boolean bl, boolean bl2, boolean bl3, boolean bl4) {
        this.clamp15 = bl2;
        this.startEvaluationProcess();
    }
}

