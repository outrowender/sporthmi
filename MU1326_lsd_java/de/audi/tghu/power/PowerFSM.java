/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.power;

import de.audi.atip.log.LogChannel;
import de.audi.atip.msg.MsgDistributor;
import de.audi.atip.power.IPowerManager;
import de.audi.atip.power.PowerEventListener;
import de.audi.tghu.power.ExtPowerState;
import de.audi.tghu.power.PowerManager;
import de.esolutions.fw.util.commons.Buffer;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import org.dsi.ifc.powermanagement.ClampSignal;

public final class PowerFSM {
    private final int terminalID;
    private State lastState;
    private State currentState;
    private final State onState = new On();
    private final State onNoDisplayState = new OnNoDisplay();
    private final State standbyState = new Standby();
    private final State standbyRestrictedState = new StandbyRestricted();
    private final State onMuteState = new OnMute();
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

    private void setState(State state) {
        this.fsmLog.log(10000000, "[PowerFSM.setState] state=%1, currentState=%2", (Object)state, (Object)this.currentState);
        this.extLog.log(10000000, "[PowerFSM.setState] %2 --> %1", (Object)state, (Object)this.currentState);
        if (!state.equals(this.currentState)) {
            this.lastState = this.currentState;
            this.lastState.onExit();
            this.currentState = state;
            this.currentState.onEnter();
        }
    }

    public String getCurrentPSName() {
        return this.currentState.getName();
    }

    public ExtPowerState getExtPowerState() {
        return this.extPSData;
    }

    protected void addListener(PowerEventListener powerEventListener) {
        this.fsmLog.log(10000000, "PowerFSM.addListener: PowerEventListener = %1", (Object)powerEventListener);
        this.listeners.add(powerEventListener);
        if (this.lastTrigger != -1) {
            try {
                powerEventListener.notifyPowerTriggerAction(this.lastTrigger, this.terminalID);
            }
            catch (Exception exception) {
                this.fsmLog.log(10000, "Exception on call addListener PowerEventListeners!", (Throwable)exception);
            }
        }
        powerEventListener.notifyPowerListenerOnEnterState(this.currentState.stateID, this.terminalID);
        ClampSignal clampSignal = this.extPSData.getCarClampState();
        powerEventListener.updateClampState(clampSignal.isClampS(), clampSignal.isClamp15(), clampSignal.isClampX(), clampSignal.isClamp50());
    }

    protected void removeListener(PowerEventListener powerEventListener) {
        this.fsmLog.log(10000000, "PowerFSM.removeListener: PowerEventListener = %1", (Object)powerEventListener);
        if (this.listeners.remove(powerEventListener)) {
            this.fsmLog.log(10000000, "PowerFSM.removeListener: PowerEventListener found and removed");
        }
    }

    private void notifyListenersOnTriggerAction(int n) {
        this.fsmLog.log(10000000, "PowerFSM.notifyListenersOnTriggerAction(trigger=%1), terminalID=%2", (long)n, (long)this.terminalID);
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
        this.fsmLog.log(10000000, "PowerFSM.notifyListenersOnClampStateChange(ClampSignal=%1), terminalID=%2", (Object)clampSignal, (long)this.terminalID);
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
            this.fsmLog.log(10000000, "*** Listener=%1, consumes %2ms", (Object)powerEventListener, this.pwrMgr.getFramework().getMonotonicTime() - l);
        }
    }

    protected void triggerPowerState(int n, int n2) {
        Buffer buffer = new Buffer(100).append(this.terminalID).append(" # ").append(this.currentState.getName());
        this.notifyListenersOnTriggerAction(n);
        State state = this.currentState;
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
        buffer.append(this.currentState.getName());
        this.fsmLog.log(10000000, "PowerFSM.triggerPowerState: TerminalID=%1", (Object)buffer);
        this.extLog.log(10000000, "PowerFSM.triggerPowerState: TerminalID=%1", (Object)buffer);
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
        this.fsmLog.log(10000000, "[PowerFSM.triggerExtendedPowerState] state=%1", (long)n);
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
        this.fsmLog.log(10000000, "setClampSState(state=%1)", (Object)clampSignal);
        this.extLog.log(10000000, "setClampSState(state=%1)", (Object)clampSignal);
        if (this.pwrMgr.getFramework().isEvoStd()) {
            ClampSignal clampSignal2 = this.extPSData.getCarClampState();
            if (clampSignal2.clamp15 == clampSignal.clamp15 && clampSignal2.clampS == clampSignal.clampS) {
                this.fsmLog.log(100000, "Old clamp state was equal to new clamp state (%1): clampStateSignal will be ignored", (Object)clampSignal);
                this.extLog.log(100000, "Old clamp state was equal to new clamp state (%1): clampStateSignal will be ignored", (Object)clampSignal);
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
        this.fsmLog.log(10000000, "setDSIDisplayManagement()");
        this.currentState.setDSIDisplayManagement();
    }

    public void keyPTTPressed() {
        this.fsmLog.log(10000000, "keyPTTPressed");
        this.extLog.log(10000000, "keyPTTPressed");
        this.currentState.keyPTTPressed();
    }

    public void displayButtonTyped(int n) {
        this.fsmLog.log(10000000, "displayButtonTyped(keyEvent=%1)", (long)n);
        this.extLog.log(10000000, "displayButtonTyped(keyEvent=%1)", (long)n);
        if (this.extPSData.isSteeringInterventionActive()) {
            this.fsmLog.log(10000000, "IGNORE displayButton, steering intervention is active");
            return;
        }
        this.currentState.displayButtonTyped();
    }

    public void hardKeyTyped(int n) {
        this.fsmLog.log(10000000, "hardKeyTyped(keyEvent=%1)", (long)n);
        this.extLog.log(10000000, "hardKeyTyped(keyEvent=%1)", (long)n);
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

    private final class On
    extends State {
        public On() {
            super(0, IPowerManager.HMI_STATE_NAMES[0]);
        }

        protected void onEnter() {
            super.onEnter();
            PowerFSM.this.pwrMgr.processOn(PowerFSM.this.extPSData, PowerFSM.this.terminalID);
        }

        protected void onExit() {
            super.onExit();
        }

        protected void triggerOff() {
            PowerFSM.this.setState(PowerFSM.this.standbyState);
        }

        protected void triggerOn() {
            switch (PowerFSM.this.lastOn) {
                case 1: {
                    this.setDSIDisplayManagement();
                    break;
                }
                case 2: {
                    if (PowerFSM.this.extPSData.isAnyCarPopupActive()) {
                        PowerFSM.this.fsmLog.log(10000000, "Ignore On.triggerOn() # isSeatControlActive=%1, isRearviewActive=%2, isDriveSelectActive=%3", PowerFSM.this.extPSData.isSeatControlActive(), PowerFSM.this.extPSData.isRearviewActive(), PowerFSM.this.extPSData.isDriveSelectActive());
                        break;
                    }
                    PowerFSM.this.setState(PowerFSM.this.onNoDisplayState);
                    break;
                }
            }
        }

        protected void triggerOnDiag() {
            PowerFSM.this.lastState = PowerFSM.this.onState;
        }

        protected void triggerOnTel() {
            PowerFSM.this.lastState = PowerFSM.this.onState;
        }

        protected void triggerOnSWDL() {
            PowerFSM.this.lastState = PowerFSM.this.onState;
        }

        protected void triggerStandby(int n) {
            if (PowerFSM.this.extPSData.isSteeringInterventionActive()) {
                PowerFSM.this.setState(PowerFSM.this.onMuteState);
            } else if (PowerFSM.this.extPSData.isAnyCarPopupActive() && n != 6) {
                PowerFSM.this.setState(PowerFSM.this.onMuteState);
            } else if (!PowerFSM.this.extPSData.getCarClampState().isClampS()) {
                this.sendWLCMessage();
                if ((PowerFSM.this.extPSData.isWirelessChargingActive() || PowerFSM.this.extPSData.isOnlineHintActive()) && n != 6) {
                    PowerFSM.this.setState(PowerFSM.this.onMuteState);
                } else {
                    PowerFSM.this.setState(PowerFSM.this.standbyState);
                }
            } else {
                PowerFSM.this.setState(PowerFSM.this.standbyState);
            }
        }

        protected void triggerStandbyRestricted() {
            PowerFSM.this.setState(PowerFSM.this.standbyRestrictedState);
        }

        protected void triggerCustomerSWDL() {
            PowerFSM.this.setState(PowerFSM.this.standbyState);
        }

        protected void triggerStandbyPwrSave() {
            if (PowerFSM.this.extPSData.isAnyCarPopupActive() || PowerFSM.this.extPSData.isSteeringInterventionActive()) {
                PowerFSM.this.fsmLog.log(10000000, "Ignore On.triggerStandbyPwrSave() # isSeatControlActive=%1, isRearviewActive=%2, isDriveSelectActive=%3", PowerFSM.this.extPSData.isSeatControlActive(), PowerFSM.this.extPSData.isRearviewActive(), PowerFSM.this.extPSData.isDriveSelectActive());
            } else if (!PowerFSM.this.extPSData.getCarClampState().isClampS()) {
                if (!PowerFSM.this.extPSData.isWirelessChargingActive()) {
                    PowerFSM.this.fsmLog.log(10000000, "PowerFSM: On.triggerStandbyPwrSave(): sendWLCMessage() because !extPSData.isWirelessChargingActive()");
                    this.sendWLCMessage();
                } else {
                    PowerFSM.this.fsmLog.log(10000000, "PowerFSM: On.triggerStandbyPwrSave(): sendWLCMessage() suppressed");
                }
                if (PowerFSM.this.extPSData.isWirelessChargingActive()) {
                    PowerFSM.this.fsmLog.log(10000000, "Ignore On.triggerStandbyPwrSave() # isWirelessChargingActive=%1", PowerFSM.this.extPSData.isWirelessChargingActive());
                } else {
                    PowerFSM.this.setState(PowerFSM.this.standbyState);
                }
            } else {
                PowerFSM.this.setState(PowerFSM.this.standbyState);
            }
        }

        protected void triggerUrgentTmc(boolean bl) {
            if (!bl) {
                if (PowerFSM.this.isTel()) {
                    PowerFSM.this.fsmLog.log(10000000, "Ignore On.triggerUrgentTmc() while phone is active!");
                } else if (this.checkOnCondition()) {
                    PowerFSM.this.fsmLog.log(10000000, "Ignore On.triggerUrgentTmc() while relevant external power states are active!");
                } else {
                    switch (PowerFSM.this.lastOn) {
                        case 0: {
                            PowerFSM.this.setState(PowerFSM.this.standbyState);
                            break;
                        }
                        case 1: {
                            PowerFSM.this.setState(PowerFSM.this.onState);
                            break;
                        }
                        case 2: {
                            PowerFSM.this.setState(PowerFSM.this.onNoDisplayState);
                            break;
                        }
                    }
                }
            }
        }

        private boolean checkOnCondition() {
            return PowerFSM.this.extPSData.isSeatControlActive() || PowerFSM.this.extPSData.isRearviewActive() || PowerFSM.this.extPSData.isQ21MessageActive() || PowerFSM.this.extPSData.isUrgentTmcActive() || PowerFSM.this.extPSData.isWirelessChargingActive();
        }

        protected void setAudioDeviceService() {
            PowerFSM.this.pwrMgr.getPwrAudioHandler().demute(PowerFSM.this.terminalID);
        }

        protected void setHMIReady() {
            if (PowerFSM.this.extPSData.isQ21MessageActive()) {
                PowerFSM.this.pwrMgr.showQ21Warning(PowerFSM.this.extPSData.isHMIReady(), PowerFSM.this.terminalID);
            }
        }

        protected void setAMAvailable() {
            PowerFSM.this.pwrMgr.getPwrAudioHandler().demute(PowerFSM.this.terminalID);
        }

        protected void releaseStanbyMute() {
            PowerFSM.this.pwrMgr.getPwrAudioHandler().demute(PowerFSM.this.terminalID);
        }

        protected void displayButtonTyped() {
            PowerFSM.this.lastOn = 2;
            PowerFSM.this.setState(PowerFSM.this.onNoDisplayState);
        }

        protected void hardKeyTyped() {
            PowerFSM.this.lastOn = 1;
        }

        protected void setDSIDisplayManagement() {
            PowerFSM.this.pwrMgr.getNativeDisplayHandler().activateDisplay(PowerFSM.this.terminalID, PowerFSM.this.extPSData);
        }

        protected void triggerQ0() {
            if (!PowerFSM.this.extPSData.isAnyCarPopupActive() && !PowerFSM.this.isTelDiagSwdl()) {
                switch (PowerFSM.this.lastOn) {
                    case 0: {
                        PowerFSM.this.setState(PowerFSM.this.standbyState);
                        break;
                    }
                    case 1: {
                        PowerFSM.this.setState(PowerFSM.this.onState);
                        break;
                    }
                    case 2: {
                        PowerFSM.this.setState(PowerFSM.this.onNoDisplayState);
                        break;
                    }
                }
            }
        }

        protected void triggerCarStateChange(boolean bl) {
            if (!(bl || PowerFSM.this.extPSData.isAnyCarPopupActive() || PowerFSM.this.isTelDiagSwdl() || PowerFSM.this.extPSData.isQ21MessageActive())) {
                switch (PowerFSM.this.lastOn) {
                    case 0: {
                        PowerFSM.this.setState(PowerFSM.this.standbyState);
                        break;
                    }
                    case 1: {
                        PowerFSM.this.setState(PowerFSM.this.onState);
                        break;
                    }
                    case 2: {
                        PowerFSM.this.setState(PowerFSM.this.onNoDisplayState);
                        break;
                    }
                }
            }
        }

        protected void triggerClimateChange(boolean bl) {
            if (!bl) {
                switch (PowerFSM.this.lastOn) {
                    case 0: {
                        PowerFSM.this.setState(PowerFSM.this.standbyState);
                        break;
                    }
                    case 1: {
                        PowerFSM.this.setState(PowerFSM.this.onState);
                        break;
                    }
                    case 2: {
                        PowerFSM.this.setState(PowerFSM.this.onNoDisplayState);
                        break;
                    }
                }
            }
        }

        protected void triggerCritTempr() {
            PowerFSM.this.pwrMgr.processCritcalTemperature(PowerFSM.this.extPSData.isHMIReady(), PowerFSM.this.terminalID);
        }
    }

    private abstract class State {
        private final int stateID;
        private final String name;

        public State(int n, String string) {
            this.stateID = n;
            this.name = string;
        }

        private final String getName() {
            return this.name;
        }

        protected void onEnter() {
            PowerFSM.this.fsmLog.log(10000000, "call onEnter PowerEventListeners (State=%1, terminalID=%2)", (Object)this.name, (long)PowerFSM.this.terminalID);
            ListIterator listIterator = PowerFSM.this.listeners.listIterator();
            while (listIterator.hasNext()) {
                try {
                    ((PowerEventListener)listIterator.next()).notifyPowerListenerOnEnterState(this.stateID, PowerFSM.this.terminalID);
                }
                catch (Exception exception) {
                    PowerFSM.this.fsmLog.log(10000, "Exception on call onEnter PowerEventListeners!", (Throwable)exception);
                }
            }
        }

        protected void onExit() {
            PowerFSM.this.fsmLog.log(10000000, "call onExit PowerEventListeners (State=%1, terminalID=%2)", (Object)this.name, (long)PowerFSM.this.terminalID);
            ListIterator listIterator = PowerFSM.this.listeners.listIterator();
            while (listIterator.hasNext()) {
                try {
                    ((PowerEventListener)listIterator.next()).notifyPowerListenerOnExitState(this.stateID, PowerFSM.this.terminalID);
                }
                catch (Exception exception) {
                    PowerFSM.this.fsmLog.log(10000, "Exception on call onExit PowerEventListeners!", (Throwable)exception);
                }
            }
        }

        protected void triggerOff() {
        }

        protected void triggerOn() {
        }

        abstract void triggerStandby(int var1);

        protected void triggerCritTempr() {
        }

        protected void triggerStandbyRestricted() {
        }

        protected void triggerOnDiag() {
        }

        protected void triggerCustomerSWDL() {
        }

        protected void triggerOnTel() {
        }

        protected void triggerOnSWDL() {
        }

        protected void triggerStandbyPwrSave() {
        }

        protected void setAudioDeviceService() {
            PowerFSM.this.pwrMgr.getPwrAudioHandler().mute(PowerFSM.this.terminalID);
        }

        protected void setHMIReady() {
            if (PowerFSM.this.extPSData.isQ21MessageActive()) {
                PowerFSM.this.pwrMgr.showQ21Warning(PowerFSM.this.extPSData.isHMIReady(), PowerFSM.this.terminalID);
                this.triggerQ21();
            }
        }

        protected void releaseStanbyMute() {
        }

        protected void triggerQ21() {
        }

        protected void triggerQ0() {
        }

        protected void triggerCarStateChange(boolean bl) {
        }

        protected void triggerClimateChange(boolean bl) {
        }

        protected void setDSIDisplayManagement() {
        }

        protected void displayButtonTyped() {
        }

        protected void hardKeyTyped() {
        }

        protected void keyPTTPressed() {
        }

        protected void setAMAvailable() {
        }

        protected void triggerWirelessCharging() {
        }

        protected void triggerOnlineHint() {
        }

        protected void triggerUrgentTmc(boolean bl) {
        }

        protected void triggerCarClampState() {
        }

        protected void sendWLCMessage() {
            PowerFSM.this.fsmLog.log(10000000, "PowerFSM.sendWLCMessage()");
            MsgDistributor msgDistributor = PowerFSM.this.pwrMgr.getFramework().getMsgDistrib();
            if (msgDistributor != null) {
                msgDistributor.sendMessage(102);
            }
        }
    }

    private final class OnMute
    extends State {
        public OnMute() {
            super(4, IPowerManager.HMI_STATE_NAMES[4]);
        }

        protected void onEnter() {
            super.onEnter();
            PowerFSM.this.pwrMgr.processOnMute(PowerFSM.this.extPSData, PowerFSM.this.terminalID);
        }

        protected void onExit() {
            super.onExit();
        }

        protected void triggerOff() {
            PowerFSM.this.setState(PowerFSM.this.standbyState);
        }

        protected void triggerOn() {
            if (PowerFSM.this.lastOn == 0 || PowerFSM.this.lastOn == 1) {
                PowerFSM.this.lastOn = 1;
                PowerFSM.this.setState(PowerFSM.this.onState);
            }
        }

        protected void displayButtonTyped() {
            PowerFSM.this.setState(PowerFSM.this.standbyState);
        }

        protected void hardKeyTyped() {
            PowerFSM.this.lastOn = 1;
            PowerFSM.this.setState(PowerFSM.this.onState);
        }

        protected void triggerStandby(int n) {
            if (PowerFSM.this.extPSData.isSteeringInterventionActive()) {
                PowerFSM.this.fsmLog.log(10000000, "Ignore OnMute.triggerStandby() # steeringInterventionActive");
            } else if (PowerFSM.this.extPSData.isAnyCarPopupActive() && n != 6) {
                PowerFSM.this.fsmLog.log(10000000, "Ignore OnMute.triggerStandby() # isSeatControlActive=%1, isRearviewActive=%2", PowerFSM.this.extPSData.isSeatControlActive(), PowerFSM.this.extPSData.isRearviewActive());
            } else if (!PowerFSM.this.extPSData.getCarClampState().isClampS()) {
                this.sendWLCMessage();
                if (PowerFSM.this.extPSData.isWirelessChargingActive() && n != 6) {
                    PowerFSM.this.fsmLog.log(10000000, "Ignore OnMute.triggerStandby() # isWirelessChargingActive=%1", PowerFSM.this.extPSData.isWirelessChargingActive());
                } else {
                    PowerFSM.this.setState(PowerFSM.this.standbyState);
                }
            } else if (PowerFSM.this.extPSData.isAnyCarPopupActive()) {
                PowerFSM.this.fsmLog.log(10000000, "Ignore OnMute.triggerStandby() # isSeatControlActive=%1, isRearviewActive=%2, isDriveSelectActive=%3", PowerFSM.this.extPSData.isSeatControlActive(), PowerFSM.this.extPSData.isRearviewActive(), PowerFSM.this.extPSData.isDriveSelectActive());
            } else {
                PowerFSM.this.setState(PowerFSM.this.standbyState);
            }
        }

        protected void triggerStandbyRestricted() {
            PowerFSM.this.setState(PowerFSM.this.standbyRestrictedState);
        }

        protected void triggerOnDiag() {
            PowerFSM.this.setState(PowerFSM.this.onState);
        }

        protected void triggerOnSWDL() {
            PowerFSM.this.setState(PowerFSM.this.onState);
        }

        protected void triggerStandbyPwrSave() {
            if (PowerFSM.this.extPSData.isAnyCarPopupActive() || PowerFSM.this.extPSData.isSteeringInterventionActive()) {
                PowerFSM.this.fsmLog.log(10000000, "Ignore OnMute.triggerStandbyPwrSave() # isSeatControlActive=%1, isRearviewActive=%2", PowerFSM.this.extPSData.isSeatControlActive(), PowerFSM.this.extPSData.isRearviewActive());
            } else if (!PowerFSM.this.extPSData.getCarClampState().isClampS()) {
                if (!PowerFSM.this.extPSData.isWirelessChargingActive()) {
                    PowerFSM.this.fsmLog.log(10000000, "PowerFSM: OnMute.triggerStandbyPwrSave(): sendWLCMessage() because !extPSData.isWirelessChargingActive()");
                    this.sendWLCMessage();
                } else {
                    PowerFSM.this.fsmLog.log(10000000, "PowerFSM: OnMute.triggerStandbyPwrSave(): sendWLCMessage() suppressed");
                }
                if (PowerFSM.this.extPSData.isWirelessChargingActive()) {
                    PowerFSM.this.fsmLog.log(10000000, "Ignore OnMute.triggerStandbyPwrSave() # isWirelessChargingActive=%1", PowerFSM.this.extPSData.isWirelessChargingActive());
                } else {
                    PowerFSM.this.setState(PowerFSM.this.standbyState);
                }
            } else {
                PowerFSM.this.setState(PowerFSM.this.standbyState);
            }
        }

        protected void setDSIDisplayManagement() {
            PowerFSM.this.pwrMgr.getNativeDisplayHandler().activateDisplay(PowerFSM.this.terminalID, PowerFSM.this.extPSData);
        }

        protected void triggerCarStateChange(boolean bl) {
            if (!(bl || PowerFSM.this.extPSData.isAnyCarPopupActive() || PowerFSM.this.isTelDiagSwdl() || PowerFSM.this.extPSData.isQ21MessageActive())) {
                switch (PowerFSM.this.lastOn) {
                    case 0: {
                        if (!PowerFSM.this.extPSData.getCarClampState().isClampS()) {
                            this.sendWLCMessage();
                            if (PowerFSM.this.extPSData.isWirelessChargingActive()) {
                                PowerFSM.this.setState(PowerFSM.this.onMuteState);
                                break;
                            }
                            PowerFSM.this.setState(PowerFSM.this.standbyState);
                            break;
                        }
                        PowerFSM.this.setState(PowerFSM.this.standbyState);
                        break;
                    }
                    case 1: {
                        PowerFSM.this.setState(PowerFSM.this.onState);
                        break;
                    }
                    case 2: {
                        PowerFSM.this.setState(PowerFSM.this.onNoDisplayState);
                        break;
                    }
                }
            }
        }

        protected void triggerClimateChange(boolean bl) {
            if (!bl) {
                switch (PowerFSM.this.lastOn) {
                    case 0: {
                        PowerFSM.this.setState(PowerFSM.this.standbyState);
                        break;
                    }
                    case 1: {
                        PowerFSM.this.setState(PowerFSM.this.onState);
                        break;
                    }
                    case 2: {
                        PowerFSM.this.setState(PowerFSM.this.onNoDisplayState);
                        break;
                    }
                }
            }
        }

        protected void triggerCritTempr() {
            PowerFSM.this.pwrMgr.processCritcalTemperature(PowerFSM.this.extPSData.isHMIReady(), PowerFSM.this.terminalID);
        }

        protected void setAMAvailable() {
            PowerFSM.this.pwrMgr.getPwrAudioHandler().updateAMAvailableFromFSMStandby();
        }

        protected void triggerWirelessCharging() {
            if (!(PowerFSM.this.extPSData.isWirelessChargingActive() || PowerFSM.this.extPSData.getCarClampState().isClampS() || PowerFSM.this.extPSData.isAnyCarPopupActive())) {
                PowerFSM.this.setState(PowerFSM.this.standbyState);
            }
        }

        protected void triggerOnlineHint() {
            if (!(PowerFSM.this.extPSData.isOnlineHintActive() || PowerFSM.this.extPSData.getCarClampState().isClampS() || PowerFSM.this.extPSData.isAnyCarPopupActive())) {
                PowerFSM.this.setState(PowerFSM.this.standbyState);
            }
        }

        protected void triggerUrgentTmc(boolean bl) {
            if (!bl) {
                if (PowerFSM.this.isTel()) {
                    PowerFSM.this.fsmLog.log(10000000, "Ignore OnMute.triggerUrgentTmc() while phone is active!");
                } else if (PowerFSM.this.extPSData.isRearviewActive() || PowerFSM.this.extPSData.isWirelessChargingActive()) {
                    PowerFSM.this.fsmLog.log(10000000, "Ignore OnMute.triggerUrgentTmc() while relevant external power states are active!");
                } else {
                    PowerFSM.this.setState(PowerFSM.this.standbyState);
                }
            }
        }
    }

    private final class Standby
    extends State {
        public Standby() {
            super(2, IPowerManager.HMI_STATE_NAMES[2]);
        }

        protected void onEnter() {
            PowerFSM.this.pwrMgr.processStandby(PowerFSM.this.extPSData, PowerFSM.this.terminalID);
            super.onEnter();
        }

        protected void onExit() {
            super.onExit();
        }

        protected void displayButtonTyped() {
            PowerFSM.this.setState(PowerFSM.this.onState);
        }

        protected void hardKeyTyped() {
            PowerFSM.this.lastOn = 1;
            PowerFSM.this.setState(PowerFSM.this.onState);
        }

        protected void triggerOn() {
            if (PowerFSM.this.lastOn == 0 || PowerFSM.this.lastOn == 1) {
                PowerFSM.this.lastOn = 1;
                PowerFSM.this.setState(PowerFSM.this.onState);
            }
        }

        protected void triggerStandbyRestricted() {
            PowerFSM.this.setState(PowerFSM.this.standbyRestrictedState);
        }

        protected void triggerOnDiag() {
            PowerFSM.this.setState(PowerFSM.this.onState);
        }

        protected void triggerOnTel() {
            PowerFSM.this.setState(PowerFSM.this.onMuteState);
        }

        protected void triggerOnSWDL() {
            PowerFSM.this.setState(PowerFSM.this.onState);
        }

        protected void triggerCarStateChange(boolean bl) {
            if (bl) {
                PowerFSM.this.setState(PowerFSM.this.onMuteState);
            }
        }

        protected void triggerClimateChange(boolean bl) {
            if (bl) {
                PowerFSM.this.setState(PowerFSM.this.onMuteState);
            }
        }

        protected void setHMIReady() {
            this.onEnter();
        }

        protected void setAMAvailable() {
            PowerFSM.this.pwrMgr.getPwrAudioHandler().updateAMAvailableFromFSMStandby();
        }

        void triggerStandby(int n) {
        }

        protected void triggerCarClampState() {
            if (!PowerFSM.this.extPSData.getCarClampState().isClampS()) {
                this.sendWLCMessage();
                if (PowerFSM.this.extPSData.isWirelessChargingActive()) {
                    PowerFSM.this.setState(PowerFSM.this.onMuteState);
                }
            }
        }

        protected void triggerUrgentTmc(boolean bl) {
            if (bl) {
                PowerFSM.this.setState(PowerFSM.this.onMuteState);
            }
        }
    }

    private final class OnNoDisplay
    extends State {
        public OnNoDisplay() {
            super(1, IPowerManager.HMI_STATE_NAMES[1]);
        }

        protected void onEnter() {
            super.onEnter();
            PowerFSM.this.pwrMgr.processOnNoDisplay(PowerFSM.this.extPSData, PowerFSM.this.terminalID);
        }

        protected void onExit() {
            super.onExit();
        }

        protected void triggerOff() {
            PowerFSM.this.setState(PowerFSM.this.standbyState);
        }

        protected void triggerStandby(int n) {
            if (PowerFSM.this.extPSData.isSteeringInterventionActive()) {
                PowerFSM.this.fsmLog.log(10000000, "[OnNoDisplay.triggerStandby]-->HMI_ON_MUTE because of isSteeringInterventionActive=%1", PowerFSM.this.extPSData.isSteeringInterventionActive());
                PowerFSM.this.setState(PowerFSM.this.onMuteState);
            } else if (!PowerFSM.this.extPSData.getCarClampState().isClampS()) {
                this.sendWLCMessage();
                if (PowerFSM.this.extPSData.isWirelessChargingActive() && n != 6) {
                    PowerFSM.this.setState(PowerFSM.this.onMuteState);
                } else {
                    PowerFSM.this.setState(PowerFSM.this.standbyState);
                }
            } else {
                PowerFSM.this.setState(PowerFSM.this.standbyState);
            }
        }

        protected void triggerCritTempr() {
            PowerFSM.this.fsmLog.log(10000000, "[OnNoDisplay.triggerCritTempr]");
            PowerFSM.this.pwrMgr.processCritcalTemperature(PowerFSM.this.extPSData.isHMIReady(), PowerFSM.this.terminalID);
            PowerFSM.this.setState(PowerFSM.this.onState);
        }

        protected void triggerStandbyRestricted() {
            PowerFSM.this.setState(PowerFSM.this.standbyRestrictedState);
        }

        protected void triggerOnDiag() {
            PowerFSM.this.setState(PowerFSM.this.onState);
        }

        protected void triggerOnTel() {
            PowerFSM.this.setState(PowerFSM.this.onState);
        }

        protected void triggerCustomerSWDL() {
            PowerFSM.this.setState(PowerFSM.this.standbyState);
        }

        protected void triggerOnSWDL() {
            PowerFSM.this.setState(PowerFSM.this.onState);
        }

        protected void triggerStandbyPwrSave() {
            if (PowerFSM.this.extPSData.isAnyCarPopupActive() || PowerFSM.this.extPSData.isSteeringInterventionActive()) {
                PowerFSM.this.fsmLog.log(10000000, "Ignore OnNoDisplay.triggerStandbyPwrSave() # isSeatControlActive=%1, isRearviewActive=%2", PowerFSM.this.extPSData.isSeatControlActive(), PowerFSM.this.extPSData.isRearviewActive());
            } else {
                PowerFSM.this.setState(PowerFSM.this.standbyState);
            }
        }

        protected void triggerQ21() {
            PowerFSM.this.setState(PowerFSM.this.onState);
        }

        protected void triggerUrgentTmc(boolean bl) {
            if (bl) {
                PowerFSM.this.setState(PowerFSM.this.onState);
            }
        }

        protected void displayButtonTyped() {
            PowerFSM.this.lastOn = 1;
            PowerFSM.this.setState(PowerFSM.this.onState);
            PowerFSM.this.lastState = PowerFSM.this.onState;
        }

        protected void hardKeyTyped() {
            PowerFSM.this.lastOn = 1;
            PowerFSM.this.setState(PowerFSM.this.onState);
        }

        protected void setHMIReady() {
            PowerFSM.this.pwrMgr.getPwrAudioHandler().demute(PowerFSM.this.terminalID);
        }

        protected void setAMAvailable() {
            PowerFSM.this.pwrMgr.getPwrAudioHandler().demute(PowerFSM.this.terminalID);
        }

        protected void releaseStanbyMute() {
            PowerFSM.this.pwrMgr.getPwrAudioHandler().demute(PowerFSM.this.terminalID);
        }

        protected void keyPTTPressed() {
            PowerFSM.this.setState(PowerFSM.this.onState);
        }

        protected void triggerCarStateChange(boolean bl) {
            if (bl) {
                PowerFSM.this.setState(PowerFSM.this.onState);
            }
        }

        protected void triggerClimateChange(boolean bl) {
            if (bl) {
                PowerFSM.this.setState(PowerFSM.this.onState);
            }
        }
    }

    private final class StandbyRestricted
    extends State {
        public StandbyRestricted() {
            super(3, IPowerManager.HMI_STATE_NAMES[3]);
        }

        protected void onEnter() {
            super.onEnter();
            PowerFSM.this.pwrMgr.processStandby(PowerFSM.this.extPSData, PowerFSM.this.terminalID);
        }

        protected void onExit() {
            super.onExit();
        }

        protected void triggerOff() {
            PowerFSM.this.setState(PowerFSM.this.standbyState);
        }

        protected void triggerOn() {
            if (PowerFSM.this.lastOn == 0 || PowerFSM.this.lastOn == 1) {
                PowerFSM.this.lastOn = 1;
                PowerFSM.this.setState(PowerFSM.this.onState);
            }
        }

        protected void triggerStandby(int n) {
            PowerFSM.this.setState(PowerFSM.this.standbyState);
        }

        protected void triggerOnDiag() {
            PowerFSM.this.setState(PowerFSM.this.onState);
        }

        protected void triggerOnSWDL() {
            PowerFSM.this.setState(PowerFSM.this.onState);
        }

        protected void triggerOnTel() {
            PowerFSM.this.setState(PowerFSM.this.onState);
        }

        protected void triggerCritTempr() {
            PowerFSM.this.fsmLog.log(10000000, "[StandbyResticted.triggerCritTempr]");
            PowerFSM.this.pwrMgr.processCritcalTemperature(PowerFSM.this.extPSData.isHMIReady(), PowerFSM.this.terminalID);
        }

        protected void triggerStandbyPwrSave() {
            if (PowerFSM.this.extPSData.isAnyCarPopupActive() || PowerFSM.this.extPSData.isSteeringInterventionActive()) {
                PowerFSM.this.fsmLog.log(10000000, "Ignore StandbyResticted.triggerStandbyPwrSave() # isSeatControlActive=%1, isRearviewActive=%2", PowerFSM.this.extPSData.isSeatControlActive(), PowerFSM.this.extPSData.isRearviewActive());
            } else {
                PowerFSM.this.setState(PowerFSM.this.standbyState);
            }
        }

        protected void triggerCarClampState() {
            if (!PowerFSM.this.extPSData.getCarClampState().isClampS()) {
                this.sendWLCMessage();
                if (PowerFSM.this.extPSData.isWirelessChargingActive()) {
                    PowerFSM.this.setState(PowerFSM.this.onMuteState);
                }
            }
        }
    }
}

