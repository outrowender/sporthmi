/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  de.mib.swdiagnosis.phone.IPhoneDiagComponent
 */
package de.audi.app.phone.core.terminalmode;

import de.audi.app.phone.core.AbstractPhoneComponent;
import de.audi.app.phone.core.ITelApplication;
import de.audi.app.phone.core.PhoneServiceProvider;
import de.audi.app.phone.core.state.CallStateStruct;
import de.audi.app.phone.core.state.IGlobalTelephoneStateListener;
import de.audi.app.phone.core.state.IGlobalTelephoneStateStruct;
import de.audi.atip.interapp.terminalmode.DefaultTerminalModeUpdateListener;
import de.audi.atip.interapp.terminalmode.TerminalModeDevice;
import de.mib.swdiagnosis.phone.IPhoneDiagComponent;

public class TelTerminalModeHandler
extends AbstractPhoneComponent {
    private static final int ENABLE_CAR_PLAY_DISCLAIMER = 1;
    private static final int DISABLE_CAR_PLAY_DISCLAIMER = 0;
    private final PhoneServiceProvider terminalModeUpdateListnerService;
    private final DefaultTerminalModeUpdateListener tmUpdateListener;
    private final AbstractState active = new TMActiveState();
    private final AbstractState inactive;
    private volatile AbstractState state = this.inactive = new TMInactiveState();
    private volatile IGlobalTelephoneStateStruct telStateStruct;
    private volatile TerminalModeDevice activeDevice;
    private volatile int nadModeBeforeTM = 0;
    static /* synthetic */ Class class$de$audi$atip$interapp$terminalmode$ITerminalModeUpdateListener;

    public TelTerminalModeHandler(ITelApplication iTelApplication) {
        super(iTelApplication, "App.Phone.Main");
        this.tmUpdateListener = new TerminalModeUpdateListener();
        this.terminalModeUpdateListnerService = new PhoneServiceProvider((class$de$audi$atip$interapp$terminalmode$ITerminalModeUpdateListener == null ? (class$de$audi$atip$interapp$terminalmode$ITerminalModeUpdateListener = TelTerminalModeHandler.class$("de.audi.atip.interapp.terminalmode.ITerminalModeUpdateListener")) : class$de$audi$atip$interapp$terminalmode$ITerminalModeUpdateListener).getName(), this.tmUpdateListener, null, iTelApplication.getBundleContext(), this.log);
    }

    public void init() {
        super.init();
        this.getApplication().getGlobalTelephoneStateManager().registerListener(this);
        this.getApplication().getGlobalTelephoneStateManager().registerListener(new IGlobalTelephoneStateListener(){

            public void updateGlobalTelephoneStateProperty(int n, IGlobalTelephoneStateStruct iGlobalTelephoneStateStruct) {
                TelTerminalModeHandler.this.getApplication().getGlobalTelephoneStateManager().removeListener(this);
                TelTerminalModeHandler.this.terminalModeUpdateListnerService.startService();
            }
        });
        this.getApplication().addDiagnosisComponent(new TelTerminalModeDiag());
    }

    public void deinit() {
        super.deinit();
        this.getApplication().getGlobalTelephoneStateManager().removeListener(this);
        this.terminalModeUpdateListnerService.stopService();
    }

    private void transitionToState(AbstractState abstractState) {
        this.state = abstractState;
        this.log.log(1000000, "[TelTerminalModeHandler#transitionToState] Transition to a new state: %1", (Object)abstractState.toString());
        this.state.enter();
    }

    public void updateGlobalTelephoneStateProperty(int n, IGlobalTelephoneStateStruct iGlobalTelephoneStateStruct) {
        this.telStateStruct = iGlobalTelephoneStateStruct;
    }

    static /* synthetic */ Class class$(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new NoClassDefFoundError().initCause(classNotFoundException);
        }
    }

    private abstract class AbstractState {
        private AbstractState() {
        }

        public abstract void updateActiveDeviceState();

        public abstract void enter();
    }

    private class TMActiveState
    extends AbstractState {
        private TMActiveState() {
        }

        public void updateActiveDeviceState() {
            if (TelTerminalModeHandler.this.activeDevice.isActive()) {
                TelTerminalModeHandler.this.log.log(10000000, "[TelTerminalModeHandler(TMActiveState)#updateActiveDeviceState] CP/AA session is already active");
            } else {
                TelTerminalModeHandler.this.transitionToState(TelTerminalModeHandler.this.inactive);
            }
        }

        public void enter() {
            int n = TelTerminalModeHandler.this.telStateStruct.getNadMode();
            TelTerminalModeHandler.this.nadModeBeforeTM = n;
            TelTerminalModeHandler.this.log.log(10000000, "[TelTerminalModeHandler(TMActiveState)#enter] current nadMode: %1", (long)n);
            if (this.isHangupCallNeeded()) {
                TelTerminalModeHandler.this.getApplication().getCallControl().hangupCall(0);
            }
        }

        private boolean isHangupCallNeeded() {
            if (TelTerminalModeHandler.this.telStateStruct != null) {
                boolean bl;
                boolean bl2;
                boolean bl3 = bl2 = TelTerminalModeHandler.this.telStateStruct.getNadInstanceState() != null;
                boolean bl4 = bl2 ? !TelTerminalModeHandler.this.telStateStruct.getNadInstanceState().getCallState().isIdle() : (bl = false);
                if (bl2 && bl) {
                    return !this.isSomeSpecificCallAvailable(TelTerminalModeHandler.this.telStateStruct.getNadInstanceState().getCallState());
                }
            }
            return false;
        }

        private boolean isSomeSpecificCallAvailable(CallStateStruct callStateStruct) {
            return callStateStruct.isHasBCall() || callStateStruct.isHasBreakdownCall() || callStateStruct.isHasCCall() || callStateStruct.isHasEmergencyCall() || callStateStruct.isHasInfoCall() || callStateStruct.isHasOperatorCall() || callStateStruct.isHasPCall();
        }

        public String toString() {
            return "TMActiveState";
        }
    }

    private class TMInactiveState
    extends AbstractState {
        private TMInactiveState() {
        }

        public void updateActiveDeviceState() {
            if (TelTerminalModeHandler.this.activeDevice.isActive()) {
                TelTerminalModeHandler.this.transitionToState(TelTerminalModeHandler.this.active);
            } else {
                TelTerminalModeHandler.this.log.log(10000000, "[TelTerminalModeHandler(TMInactiveState)#updateActiveDeviceState] CP/AA session is inactive: %1", (Object)this.toString());
            }
        }

        public void enter() {
            if (TelTerminalModeHandler.this.telStateStruct.isSimCardInserted() && !TelTerminalModeHandler.this.telStateStruct.isESIMActive() && TelTerminalModeHandler.this.telStateStruct.getNadMode() != 1 && TelTerminalModeHandler.this.nadModeBeforeTM == 1) {
                TelTerminalModeHandler.this.log.log(1000000, "[TelTerminalModeHandler(TMInactiveState)#enter] changing NadMode back to V&D");
                TelTerminalModeHandler.this.getApplication().getTelephoneDSIAccess().requestSetNadMode(1, 0);
            } else {
                TelTerminalModeHandler.this.log.log(1000000, "[TelTerminalModeHandler(TMInactiveState)#enter] current NadMode=%1 stays unchanged, nadModeBeforeTM=%2", (long)TelTerminalModeHandler.this.telStateStruct.getNadMode(), (long)TelTerminalModeHandler.this.nadModeBeforeTM);
            }
        }

        public String toString() {
            return "TMInactiveState";
        }
    }

    class TelTerminalModeDiag
    implements IPhoneDiagComponent {
        TelTerminalModeDiag() {
        }

        public void cmdUpdateActiveDeviceState(int n, boolean bl) {
            TerminalModeDevice terminalModeDevice = new TerminalModeDevice("devID", "TMdevice", n, bl, true, bl);
            TelTerminalModeHandler.this.tmUpdateListener.updateActiveDeviceState(terminalModeDevice);
        }
    }

    private class TerminalModeUpdateListener
    extends DefaultTerminalModeUpdateListener {
        private TerminalModeUpdateListener() {
        }

        public void updateActiveDeviceState(TerminalModeDevice terminalModeDevice) {
            TelTerminalModeHandler.this.log.log(1000000, "[TelTerminalModeHandler#updateActiveDeviceState] pActiveDevice=%1", (Object)terminalModeDevice);
            TelTerminalModeHandler.this.activeDevice = terminalModeDevice;
            if (terminalModeDevice.isActive() && terminalModeDevice.getConnectionMethod() == 1) {
                this.showDisclaimer();
                TelTerminalModeHandler.this.getButtonModel(2500431).setStatus(0);
            } else {
                this.removeDisclaimer();
                TelTerminalModeHandler.this.getButtonModel(2500431).setStatus(1);
            }
            TelTerminalModeHandler.this.state.updateActiveDeviceState();
        }

        private void showDisclaimer() {
            TelTerminalModeHandler.this.getChoiceModel(301049).setValue(1);
            TelTerminalModeHandler.this.log.log(10000000, "[TelTerminalModeHandler#showCarPlayDisclaimer] showing disclaimer. Model with ID=%1 is set to [%2].", 301049L, 1L);
        }

        private void removeDisclaimer() {
            TelTerminalModeHandler.this.getChoiceModel(301049).setValue(0);
            TelTerminalModeHandler.this.log.log(10000000, "[TelTerminalModeHandler#showCarPlayDisclaimer] removing disclaimer. Model with ID=%1 is set to [%2].", 301049L, 0L);
        }
    }
}

