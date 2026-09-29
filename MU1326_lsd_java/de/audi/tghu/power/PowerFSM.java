/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.power;

import de.audi.atip.log.LogChannel;
import de.audi.atip.power.PowerEventListener;
import de.audi.tghu.power.ExtPowerState;
import de.audi.tghu.power.PowerFSM$On;
import de.audi.tghu.power.PowerFSM$OnMute;
import de.audi.tghu.power.PowerFSM$OnNoDisplay;
import de.audi.tghu.power.PowerFSM$Standby;
import de.audi.tghu.power.PowerFSM$StandbyRestricted;
import de.audi.tghu.power.PowerFSM$State;
import de.audi.tghu.power.PowerManager;
import de.esolutions.fw.util.commons.Buffer;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import org.dsi.ifc.powermanagement.ClampSignal;

public final class PowerFSM {
    private final int terminalID;
    private PowerFSM$State lastState;
    private PowerFSM$State currentState;
    private final PowerFSM$State onState = new PowerFSM$On(this);
    private final PowerFSM$State onNoDisplayState = new PowerFSM$OnNoDisplay(this);
    private final PowerFSM$State standbyState = new PowerFSM$Standby(this);
    private final PowerFSM$State standbyRestrictedState = new PowerFSM$StandbyRestricted(this);
    private final PowerFSM$State onMuteState = new PowerFSM$OnMute(this);
    private final ExtPowerState extPSData;
    private int lastTrigger = -1;
    private int lastOn = 0;
    private final LogChannel fsmLog;
    private final LogChannel extLog;
    private final PowerManager pwrMgr;
    private boolean isHMIReadySet;
    private List listeners = new LinkedList();
    private int lastTriggeredPowerEvent = 2;
    private boolean diag;

    protected PowerFSM(int n, PowerManager powerManager) {
        this.terminalID = n;
        this.pwrMgr = powerManager;
        this.fsmLog = powerManager.getFramework().getLogChannel("Fw.Power.FSM");
        this.extLog = powerManager.getFramework().getLogChannel("Ext.Power");
        this.extPSData = new ExtPowerState(powerManager, this.fsmLog, this.extLog, this.terminalID);
        this.lastState = this.standbyState;
        this.currentState = this.standbyState;
    }

    private void setState(PowerFSM$State powerFSM$State) {
        this.fsmLog.log(-2137614336, "[PowerFSM.setState] state=%1, currentState=%2", (Object)powerFSM$State, (Object)this.currentState);
        this.extLog.log(-2137614336, "[PowerFSM.setState] %2 --> %1", (Object)powerFSM$State, (Object)this.currentState);
        if (!powerFSM$State.equals(this.currentState)) {
            this.lastState = this.currentState;
            this.lastState.onExit();
            this.currentState = powerFSM$State;
            this.currentState.onEnter();
        }
    }

    public String getCurrentPSName() {
        return PowerFSM$State.access$000(this.currentState);
    }

    public ExtPowerState getExtPowerState() {
        return this.extPSData;
    }

    protected void addListener(PowerEventListener powerEventListener) {
        this.fsmLog.log(-2137614336, "PowerFSM.addListener: PowerEventListener = %1", (Object)powerEventListener);
        this.listeners.add(powerEventListener);
        if (this.lastTrigger != -1) {
            try {
                powerEventListener.notifyPowerTriggerAction(this.lastTrigger, this.terminalID);
            }
            catch (Exception exception) {
                this.fsmLog.log(10000, "Exception on call addListener PowerEventListeners!", (Throwable)exception);
            }
        }
        powerEventListener.notifyPowerListenerOnEnterState(PowerFSM$State.access$100(this.currentState), this.terminalID);
        ClampSignal clampSignal = this.extPSData.getCarClampState();
        powerEventListener.updateClampState(clampSignal.isClampS(), clampSignal.isClamp15(), clampSignal.isClampX(), clampSignal.isClamp50());
    }

    protected void removeListener(PowerEventListener powerEventListener) {
        this.fsmLog.log(-2137614336, "PowerFSM.removeListener: PowerEventListener = %1", (Object)powerEventListener);
        if (this.listeners.remove(powerEventListener)) {
            this.fsmLog.log(-2137614336, "PowerFSM.removeListener: PowerEventListener found and removed");
        }
    }

    private void notifyListenersOnTriggerAction(int n) {
        this.fsmLog.log(-2137614336, "PowerFSM.notifyListenersOnTriggerAction(trigger=%1), terminalID=%2", (long)n, (long)this.terminalID);
        this.lastTrigger = n;
        ListIterator listIterator = this.listeners.listIterator();
        while (listIterator.hasNext()) {
            try {
                ((PowerEventListener)listIterator.next()).notifyPowerTriggerAction(n, this.terminalID);
            }
            catch (Exception exception) {
                this.fsmLog.log(10000, "Exception in notifyListenersOnTriggerAction(trigger=%1)!", (long)n, (Throwable)exception);
            }
        }
    }

    void notifyListenersOnClampStateChange() {
        ClampSignal clampSignal = this.extPSData.getCarClampState();
        this.fsmLog.log(-2137614336, "PowerFSM.notifyListenersOnClampStateChange(ClampSignal=%1), terminalID=%2", (Object)clampSignal, (long)this.terminalID);
        ListIterator listIterator = this.listeners.listIterator();
        long l = 0L;
        while (listIterator.hasNext()) {
            if (this.fsmLog.isDebug()) {
                l = this.pwrMgr.getFramework().getMonotonicTime();
            }
            PowerEventListener powerEventListener = (PowerEventListener)listIterator.next();
            try {
                powerEventListener.updateClampState(clampSignal.isClampS(), clampSignal.isClamp15(), clampSignal.isClampX(), clampSignal.isClamp50());
            }
            catch (Exception exception) {
                this.fsmLog.log(10000, "Exception in notifyListenersOnClampStateChange(ClampSignal=%1)!", (Object)clampSignal, (Throwable)exception);
            }
            if (!this.fsmLog.isDebug()) continue;
            this.fsmLog.log(-2137614336, "*** Listener=%1, consumes %2ms", (Object)powerEventListener, this.pwrMgr.getFramework().getMonotonicTime() - l);
        }
    }

    protected void triggerPowerState(int n, int n2) {
        Buffer buffer = new Buffer(100).append(this.terminalID).append(" # ").append(PowerFSM$State.access$000(this.currentState));
        this.notifyListenersOnTriggerAction(n);
        PowerFSM$State powerFSM$State = this.currentState;
        this.lastTriggeredPowerEvent = n;
        switch (n) {
            case 0: {
                buffer.append(" -> triggerOff() -> ");
                this.currentState.triggerOff();
                break;
            }
            case 1: {
                buffer.append(" -> triggerOn() -> ");
                this.currentState.triggerOn();
                break;
            }
            case 2: {
                buffer.append(" -> triggerStandby() -> ");
                this.lastOn = 0;
                this.currentState.triggerStandby(n2);
                break;
            }
            case 3: {
                buffer.append(" -> triggerCritTempr() -> ");
                this.currentState.triggerCritTempr();
                break;
            }
            case 4: {
                buffer.append(" -> triggerStandbyRestricted() -> ");
                this.lastOn = 0;
                this.currentState.triggerStandbyRestricted();
                break;
            }
            case 5: {
                buffer.append(" -> triggerOnDiag() -> ");
                this.currentState.triggerOnDiag();
                break;
            }
            case 6: {
                buffer.append(" -> triggerCustomerSWDL() -> ");
                this.currentState.triggerCustomerSWDL();
                break;
            }
            case 7: {
                buffer.append(" -> triggerOnTel() -> ");
                this.currentState.triggerOnTel();
                break;
            }
            case 8: {
                buffer.append(" -> triggerOnSWDL() -> ");
                this.currentState.triggerOnSWDL();
                break;
            }
            case 9: {
                buffer.append(" -> triggerStandbyPwrSave() -> ");
                this.currentState.triggerStandbyPwrSave();
                break;
            }
            case 10: {
                buffer.append(" -> triggerOnDelay() -> ");
                break;
            }
        }
        this.updateDiagState(n);
        buffer.append(PowerFSM$State.access$000(this.currentState));
        this.fsmLog.log(-2137614336, "PowerFSM.triggerPowerState: TerminalID=%1", (Object)buffer);
        this.extLog.log(-2137614336, "PowerFSM.triggerPowerState: TerminalID=%1", (Object)buffer);
    }

    private void updateDiagState(int n) {
        if (n == 5) {
            this.pwrMgr.updateDiag(true, this.extPSData.isHMIReady(), this.terminalID);
            this.diag = true;
        } else if (this.diag) {
            this.pwrMgr.updateDiag(false, this.extPSData.isHMIReady(), this.terminalID);
            this.diag = false;
        }
    }

    public void triggerExtendedPowerState(int n) {
        this.fsmLog.log(-2137614336, "[PowerFSM.triggerExtendedPowerState] state=%1", (long)n);
        this.extPSData.setExtendedPowerState(n, this);
    }

    public void setHMIReady() {
        this.extPSData.setHMIReady(true);
        this.pwrMgr.getPwrAudioHandler().enableAudioHandling();
        this.currentState.setHMIReady();
        this.informDSIHmiReady();
    }

    public void informDSIHmiReady() {
        if (!this.isHMIReadySet) {
            this.pwrMgr.getPwrDSIHandler().setHMIReady();
            this.isHMIReadySet = true;
        }
    }

    public void releaseStanbyMute() {
        this.currentState.releaseStanbyMute();
    }

    public void setClampState(ClampSignal clampSignal) {
        this.fsmLog.log(-2137614336, "setClampSState(state=%1)", (Object)clampSignal);
        this.extLog.log(-2137614336, "setClampSState(state=%1)", (Object)clampSignal);
        if (this.pwrMgr.getFramework().isEvoStd()) {
            ClampSignal clampSignal2 = this.extPSData.getCarClampState();
            if (clampSignal2.clamp15 == clampSignal.clamp15 && clampSignal2.clampS == clampSignal.clampS) {
                this.fsmLog.log(-1601830656, "Old clamp state was equal to new clamp state (%1): clampStateSignal will be ignored", (Object)clampSignal);
                this.extLog.log(-1601830656, "Old clamp state was equal to new clamp state (%1): clampStateSignal will be ignored", (Object)clampSignal);
                return;
            }
        }
        this.updateClamp15(this.extPSData.getCarClampState().clamp15, clampSignal.clamp15);
        this.extPSData.setCarClampState(clampSignal);
        this.triggerCarClampState();
        this.notifyListenersOnClampStateChange();
    }

    private void updateClamp15(boolean bl, boolean bl2) {
        if (this.extPSData.isHMIReady()) {
            if (bl && !bl2) {
                this.pwrMgr.clamp15TurnedOff(this.terminalID);
            } else if (!bl && bl2) {
                this.pwrMgr.clamp15TurnedOn(this.terminalID);
            }
        }
    }

    public void setDSIDisplayManagement() {
        this.fsmLog.log(-2137614336, "setDSIDisplayManagement()");
        this.currentState.setDSIDisplayManagement();
    }

    public void keyPTTPressed() {
        this.fsmLog.log(-2137614336, "keyPTTPressed");
        this.extLog.log(-2137614336, "keyPTTPressed");
        this.currentState.keyPTTPressed();
    }

    public void displayButtonTyped(int n) {
        this.fsmLog.log(-2137614336, "displayButtonTyped(keyEvent=%1)", (long)n);
        this.extLog.log(-2137614336, "displayButtonTyped(keyEvent=%1)", (long)n);
        if (this.extPSData.isSteeringInterventionActive()) {
            this.fsmLog.log(-2137614336, "IGNORE displayButton, steering intervention is active");
            return;
        }
        this.currentState.displayButtonTyped();
    }

    public void hardKeyTyped(int n) {
        this.fsmLog.log(-2137614336, "hardKeyTyped(keyEvent=%1)", (long)n);
        this.extLog.log(-2137614336, "hardKeyTyped(keyEvent=%1)", (long)n);
        this.currentState.hardKeyTyped();
    }

    public void triggerQ21() {
        this.currentState.triggerQ21();
    }

    public void triggerQ0() {
        this.currentState.triggerQ0();
    }

    public void triggerCarStateChange(boolean bl) {
        this.currentState.triggerCarStateChange(bl);
    }

    public void triggerClimateChange(boolean bl) {
        this.currentState.triggerClimateChange(bl);
    }

    public void setAudioDeviceService() {
        this.currentState.setAudioDeviceService();
    }

    public void setAMAvailable() {
        this.currentState.setAMAvailable();
    }

    public void setOriginHMIStateOnRVCtoOn() {
    }

    public void triggerWirelessCharging() {
        this.currentState.triggerWirelessCharging();
    }

    public void triggerOnlineHint() {
        this.currentState.triggerOnlineHint();
    }

    public void triggerUrgentTmc(boolean bl) {
        this.currentState.triggerUrgentTmc(bl);
    }

    protected void triggerCarClampState() {
        this.currentState.triggerCarClampState();
    }

    private boolean isTelDiagSwdl() {
        return this.lastTriggeredPowerEvent == 7 || this.lastTriggeredPowerEvent == 5 || this.lastTriggeredPowerEvent == 8;
    }

    private boolean isTel() {
        return this.lastTriggeredPowerEvent == 7;
    }

    static /* synthetic */ int access$200(PowerFSM powerFSM) {
        return powerFSM.terminalID;
    }

    static /* synthetic */ LogChannel access$300(PowerFSM powerFSM) {
        return powerFSM.fsmLog;
    }

    static /* synthetic */ List access$400(PowerFSM powerFSM) {
        return powerFSM.listeners;
    }

    static /* synthetic */ PowerManager access$500(PowerFSM powerFSM) {
        return powerFSM.pwrMgr;
    }

    static /* synthetic */ ExtPowerState access$600(PowerFSM powerFSM) {
        return powerFSM.extPSData;
    }

    static /* synthetic */ PowerFSM$State access$700(PowerFSM powerFSM) {
        return powerFSM.onState;
    }

    static /* synthetic */ void access$800(PowerFSM powerFSM, PowerFSM$State state) {
        powerFSM.setState(state);
    }

    static /* synthetic */ int access$902(PowerFSM powerFSM, int n) {
        powerFSM.lastOn = n;
        return powerFSM.lastOn;
    }

    static /* synthetic */ int access$900(PowerFSM powerFSM) {
        return powerFSM.lastOn;
    }

    static /* synthetic */ PowerFSM$State access$1000(PowerFSM powerFSM) {
        return powerFSM.standbyRestrictedState;
    }

    static /* synthetic */ PowerFSM$State access$1100(PowerFSM powerFSM) {
        return powerFSM.onMuteState;
    }

    static /* synthetic */ PowerFSM$State access$1200(PowerFSM powerFSM) {
        return powerFSM.standbyState;
    }

    static /* synthetic */ PowerFSM$State access$1300(PowerFSM powerFSM) {
        return powerFSM.onNoDisplayState;
    }

    static /* synthetic */ PowerFSM$State access$1402(PowerFSM powerFSM, PowerFSM$State state) {
        powerFSM.lastState = state;
        return powerFSM.lastState;
    }

    static /* synthetic */ boolean access$1500(PowerFSM powerFSM) {
        return powerFSM.isTel();
    }

    static /* synthetic */ boolean access$1600(PowerFSM powerFSM) {
        return powerFSM.isTelDiagSwdl();
    }
}

