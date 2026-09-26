/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.phone.core.sim;

import de.audi.app.phone.core.AbstractPhoneComponent;
import de.audi.app.phone.core.ITelApplication;
import de.audi.app.phone.core.sim.AbstractTelLockStateDSIHandler$LockStateDiag;
import de.audi.app.phone.core.sim.AbstractTelLockStateDSIHandler$TelLockStateResponseListener;
import de.audi.app.phone.core.state.IGlobalTelephoneStateStruct;
import de.audi.atip.log.LogChannel;
import org.dsi.ifc.telephoneng.LockStateStruct;

public abstract class AbstractTelLockStateDSIHandler
extends AbstractPhoneComponent {
    static final int STATE_UNKNOWN;
    static final int STATE_NO_LOCK;
    static final int STATE_UNLOCK_IN_PROGRESS;
    static final int STATE_PIN_REQUIRED;
    static final int STATE_PIN_REQUIRED_WRONG_PIN_ENTERED;
    static final int STATE_PUK_REQUIRED;
    static final int STATE_PUK_REQUIRED_WRONG_PIN_ENTERED_PUK_REQUIRED;
    static final int STATE_PUK_REQUIRED_WRONG_PUK_ENTERED;
    static final int STATE_PUK_BLOCKED;
    static final int STATE_SIM_NOT_FUNC;
    private volatile LockStateStruct lockStateStruct;
    private volatile boolean manualUnlockInProgress;
    private volatile int internalLockState = 0;
    private volatile IGlobalTelephoneStateStruct telephoneState;

    protected static String getStateName(int n) {
        switch (n) {
            case 0: {
                return "STATE_UNKNOWN";
            }
            case 1: {
                return "STATE_NO_LOCK";
            }
            case 2: {
                return "STATE_UNLOCK_IN_PROGRESS";
            }
            case 3: {
                return "STATE_PIN_REQUIRED";
            }
            case 4: {
                return "STATE_PIN_REQUIRED_WRONG_PIN_ENTERED";
            }
            case 5: {
                return "STATE_PUK_REQUIRED";
            }
            case 6: {
                return "STATE_PUK_REQUIRED_WRONG_PIN_ENTERED_PUK_REQUIRED";
            }
            case 7: {
                return "STATE_PUK_REQUIRED_WRONG_PUK_ENTERED";
            }
            case 8: {
                return "STATE_PUK_BLOCKED";
            }
            case 9: {
                return "STATE_SIM_NOT_FUNC";
            }
        }
        return new StringBuffer().append("Unknown state ").append(n).toString();
    }

    public AbstractTelLockStateDSIHandler(ITelApplication iTelApplication) {
        super(iTelApplication, "App.Phone.LockState");
    }

    @Override
    public void init() {
        super.init();
        this.getApplication().getGlobalTelephoneStateManager().registerListener(this);
        this.getApplication().addDiagnosisComponent(new AbstractTelLockStateDSIHandler$LockStateDiag(this));
    }

    @Override
    public void deinit() {
        super.deinit();
        this.getApplication().getGlobalTelephoneStateManager().removeListener(this);
    }

    @Override
    public void updateGlobalTelephoneStateProperty(int n, IGlobalTelephoneStateStruct iGlobalTelephoneStateStruct) {
        this.telephoneState = iGlobalTelephoneStateStruct;
        if (this.processLockStateUpdate(n, iGlobalTelephoneStateStruct)) {
            LockStateStruct lockStateStruct = this.getLockStateStruct(iGlobalTelephoneStateStruct);
            if (lockStateStruct != null) {
                if (this.hasChanged(lockStateStruct)) {
                    this.updateLockState(lockStateStruct);
                } else {
                    this.log.log(1078071040, "[AbstractTelLockStateDSIHandler#updateGlobalTelephoneStateProperty] lock state has not changed, ignoring update %1", (Object)lockStateStruct);
                }
            } else {
                this.log.log(-1601830656, "[AbstractTelLockStateDSIHandler#updateGlobalTelephoneStateProperty] lock state is null --> NOP!");
            }
        }
    }

    private boolean hasChanged(LockStateStruct lockStateStruct) {
        if (this.lockStateStruct == null) {
            return true;
        }
        if (lockStateStruct == null) {
            return false;
        }
        return this.lockStateStruct.getTelLockState() != lockStateStruct.getTelLockState() || this.lockStateStruct.getTelRetryCounter() != lockStateStruct.getTelRetryCounter();
    }

    protected IGlobalTelephoneStateStruct getTelephoneState() {
        return this.telephoneState;
    }

    private void setInternalLockState(int n) {
        this.log.log(1078071040, "[AbstractTelLockStateDSIHandler#setInternalLockState] state=%1", (Object)AbstractTelLockStateDSIHandler.getStateName(n));
        this.internalLockState = n;
    }

    int getInternalLockState() {
        return this.internalLockState;
    }

    protected void updateLockState(LockStateStruct lockStateStruct) {
        this.lockStateStruct = lockStateStruct;
        int n = lockStateStruct.getTelLockState();
        switch (n) {
            case 0: {
                this.setInternalLockState(0);
                this.processLockStateUnknown();
                break;
            }
            case 2: {
                if (this.manualUnlockInProgress) {
                    this.log.log(1078071040, "[AbstractTelLockStateDSIHandler#updateLockState] LOCKSTATE_NO_LOCK but manual unlock in progress, waiting for result");
                    break;
                }
                this.setInternalLockState(1);
                this.processNoLock(false);
                break;
            }
            case 3: {
                if (this.manualUnlockInProgress) {
                    this.log.log(1078071040, "[AbstractTelLockStateDSIHandler#updateLockState] LOCKSTATE_PIN_REQUIRED but manual unlock in progress, waiting for result");
                    break;
                }
                this.setInternalLockState(3);
                this.processPINRequired(lockStateStruct.getTelRetryCounter());
                break;
            }
            case 5: {
                if (this.manualUnlockInProgress) {
                    this.log.log(1078071040, "[AbstractTelLockStateDSIHandler#updateLockState] LOCKSTATE_PUK_REQUIRED but manual unlock in progress, waiting for result");
                    break;
                }
                this.setInternalLockState(5);
                this.processPUKRequired(lockStateStruct.getTelRetryCounter());
                break;
            }
            case 7: {
                if (this.manualUnlockInProgress) {
                    this.log.log(1078071040, "[AbstractTelLockStateDSIHandler#updateLockState] LOCKSTATE_PUK_BLOCKED, but manual unlock in progress, waiting for result");
                    break;
                }
                this.setInternalLockState(8);
                this.processPUKBlocked();
                break;
            }
            case 11: {
                this.setInternalLockState(9);
                this.processSIMNotFunctioning();
                break;
            }
            case 1: {
                this.log.log(-2137614336, "[AbstractTelLockStateDSIHandler#updateLockState] LOCKSTATE_UNLOCK_INPR");
                break;
            }
            default: {
                this.log.log(1078071040, "PhoneLockStateHandler#updateLockState: Unhandled lockState %1 ", (long)n);
                this.setInternalLockState(0);
                this.processUnhandledLockState(n);
            }
        }
    }

    protected abstract boolean processLockStateUpdate(int n, IGlobalTelephoneStateStruct iGlobalTelephoneStateStruct) {
    }

    protected abstract LockStateStruct getLockStateStruct(IGlobalTelephoneStateStruct iGlobalTelephoneStateStruct) {
    }

    protected abstract void processWrongPINEntered(int n, int n2) {
    }

    protected abstract void processWrongPINEnteredPUKRequired(int n, int n2) {
    }

    protected abstract void processWrongPUKEntered(int n, int n2) {
    }

    protected abstract void processSIMNotFunctioning() {
    }

    protected abstract void processPUKBlocked() {
    }

    protected abstract void processManualUnlockInProgress(boolean bl) {
    }

    protected abstract void processLockStateUnknown() {
    }

    protected abstract void processNoLock(boolean bl) {
    }

    protected abstract void processPINRequired(int n) {
    }

    protected abstract void processPUKRequired(int n) {
    }

    protected abstract void processUnhandledLockState(int n) {
    }

    protected final void unlockSIMwithPIN(String string, int n) {
        this.log.log(1078071040, "[AbstractTelLockStateDSIHandler#unlockSIMwithPIN] pin=%1", (Object)string);
        this.manualUnlockInProgress = true;
        this.processManualUnlockInProgress(true);
        this.getApplication().getTelephoneDSIAccess().unlockSIMWithPIN(string, n, true, new AbstractTelLockStateDSIHandler$TelLockStateResponseListener(this, 0));
    }

    protected final void unlockSIMWithPUK(String string, String string2, int n) {
        this.log.log(1078071040, "[AbstractTelLockStateDSIHandler#unlockSIMWithPUK] pukCode=%1, newPinCode=%2, terminalID=%3", (Object)string, (Object)string2, (long)n);
        this.manualUnlockInProgress = true;
        this.processManualUnlockInProgress(true);
        this.getApplication().getTelephoneDSIAccess().unlockSIMWithPUK(string, string2, n, true, new AbstractTelLockStateDSIHandler$TelLockStateResponseListener(this, 1));
    }

    static /* synthetic */ LogChannel access$000(AbstractTelLockStateDSIHandler abstractTelLockStateDSIHandler) {
        return abstractTelLockStateDSIHandler.log;
    }

    static /* synthetic */ LockStateStruct access$102(AbstractTelLockStateDSIHandler abstractTelLockStateDSIHandler, LockStateStruct lockStateStruct) {
        abstractTelLockStateDSIHandler.lockStateStruct = lockStateStruct;
        return abstractTelLockStateDSIHandler.lockStateStruct;
    }

    static /* synthetic */ LogChannel access$200(AbstractTelLockStateDSIHandler abstractTelLockStateDSIHandler) {
        return abstractTelLockStateDSIHandler.log;
    }

    static /* synthetic */ LogChannel access$300(AbstractTelLockStateDSIHandler abstractTelLockStateDSIHandler) {
        return abstractTelLockStateDSIHandler.log;
    }

    static /* synthetic */ void access$400(AbstractTelLockStateDSIHandler abstractTelLockStateDSIHandler, int n) {
        abstractTelLockStateDSIHandler.setInternalLockState(n);
    }

    static /* synthetic */ boolean access$500(AbstractTelLockStateDSIHandler abstractTelLockStateDSIHandler) {
        return abstractTelLockStateDSIHandler.manualUnlockInProgress;
    }

    static /* synthetic */ LogChannel access$600(AbstractTelLockStateDSIHandler abstractTelLockStateDSIHandler) {
        return abstractTelLockStateDSIHandler.log;
    }

    static /* synthetic */ LogChannel access$700(AbstractTelLockStateDSIHandler abstractTelLockStateDSIHandler) {
        return abstractTelLockStateDSIHandler.log;
    }

    static /* synthetic */ boolean access$502(AbstractTelLockStateDSIHandler abstractTelLockStateDSIHandler, boolean bl) {
        abstractTelLockStateDSIHandler.manualUnlockInProgress = bl;
        return abstractTelLockStateDSIHandler.manualUnlockInProgress;
    }

    static /* synthetic */ LogChannel access$800(AbstractTelLockStateDSIHandler abstractTelLockStateDSIHandler) {
        return abstractTelLockStateDSIHandler.log;
    }
}

