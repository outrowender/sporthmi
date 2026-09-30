/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  de.mib.swdiagnosis.phone.IPhoneDiagComponent
 */
package de.audi.app.phone.evo.epm;

import de.audi.app.phone.core.AbstractPhoneComponent;
import de.audi.app.phone.core.ITelApplication;
import de.audi.app.phone.core.ap.IActionProxyListener;
import de.audi.app.phone.core.dsi.TelDefaultDSIResponseListener;
import de.audi.app.phone.core.epm.ITelEPMHandler;
import de.audi.app.phone.core.state.IGlobalTelephoneStateStruct;
import de.mib.swdiagnosis.phone.IPhoneDiagComponent;
import java.util.Map;
import org.dsi.ifc.telephoneng.SuppServiceResponseStruct;

public class TelEPMHandler
extends AbstractPhoneComponent
implements IActionProxyListener {
    private static final int INCOMING_CALL_SWITCH_TO_TEL_WAITING = 0;
    private static final int INCOMING_CALL_TRIGGER_SWITCH_TO_TEL = 1;
    private static final int SWITCH_TO_PREVIOUS_CONTEXT = 0;
    private static final int STAY_IN_TELEPHONE_CONTEXT = 1;
    private static final int CONTEXT_NOT_TEL = 0;
    private static final int CONTEXT_TEL_MANUAL = 1;
    private static final int CONTEXT_TEL_EPM_CALL = 2;
    private volatile boolean hkTelPressed;
    private volatile boolean switchToTelIncomingCall;
    private volatile boolean switchToTelOutgoingCall;
    private volatile boolean telAppEntered;
    private volatile int context;
    private final boolean isMMIKombi;
    private final EPMResponseListener responseListener = new EPMResponseListener();
    private volatile IGlobalTelephoneStateStruct telephoneState;

    public TelEPMHandler(ITelApplication iTelApplication) {
        super(iTelApplication, "App.Phone.Main");
        this.isMMIKombi = this.getApplication().getFrameworkAccess().getKombiType() == 4;
    }

    public void init() {
        this.getApplication().getGlobalTelephoneStateManager().registerListener(this);
        this.getApplication().getActionProxyDispatcher().addActionProxyListener(22, this);
        this.getApplication().getActionProxyDispatcher().addActionProxyListener(7, this);
        this.getApplication().getActionProxyDispatcher().addActionProxyListener(8, this);
        this.getApplication().getActionProxyDispatcher().addActionProxyListener(9, this);
        this.getApplication().getActionProxyDispatcher().addActionProxyListener(17, this);
        this.getApplication().getActionProxyDispatcher().addActionProxyListener(24, this);
        this.getChoiceModel(300691).setStatus(0);
        this.getApplication().addDiagnosisComponent(new TelEPMDiag());
        this.getApplication().getTelephoneDSIAccess().addGlobalDSIResponseListener(this.responseListener);
    }

    public void deinit() {
        this.getApplication().getGlobalTelephoneStateManager().removeListener(this);
        this.getApplication().getActionProxyDispatcher().removeActionProxyListener(22, this);
        this.getApplication().getActionProxyDispatcher().removeActionProxyListener(7, this);
        this.getApplication().getActionProxyDispatcher().removeActionProxyListener(8, this);
        this.getApplication().getActionProxyDispatcher().removeActionProxyListener(9, this);
        this.getApplication().getActionProxyDispatcher().removeActionProxyListener(17, this);
        this.getApplication().getActionProxyDispatcher().removeActionProxyListener(24, this);
        this.getApplication().getTelephoneDSIAccess().removeGlobalDSIResponseListener(this.responseListener);
    }

    public void updateGlobalTelephoneStateProperty(int n, IGlobalTelephoneStateStruct iGlobalTelephoneStateStruct) {
        this.telephoneState = iGlobalTelephoneStateStruct;
    }

    private boolean isTerminalValid(int n) {
        return this.isMMIKombi ? n == 0 || n == 1 : n == 0;
    }

    private boolean isIdle() {
        IGlobalTelephoneStateStruct iGlobalTelephoneStateStruct = this.telephoneState;
        if (iGlobalTelephoneStateStruct != null && iGlobalTelephoneStateStruct.getConnectedGatewayState().isLowPrioritySOSEmergencyCallType()) {
            return false;
        }
        if (iGlobalTelephoneStateStruct != null && iGlobalTelephoneStateStruct.getCallState() != null) {
            return iGlobalTelephoneStateStruct.getCallState().isIdle();
        }
        return false;
    }

    public void actionProxyCallPerformed(int n, Map map) {
        switch (n) {
            case 7: {
                this.telAppEntered = true;
                if (this.hkTelPressed) {
                    this.log.log(10000000, "[TelEPMHandler#actionProxyCallPerformed] Tel app entered via HK_TEL.");
                    this.context = 1;
                    this.stayInTelephoneContextAfterTransitionToIdle();
                    this.hkTelPressed = false;
                    break;
                }
                if (this.switchToTelIncomingCall) {
                    this.log.log(10000000, "[TelEPMHandler#actionProxyCallPerformed] Tel app entered via accepting incoming call.");
                    this.context = 2;
                    this.switchToPreviousContextAfterTransitionToIdle();
                    this.switchToTelIncomingCall = false;
                    break;
                }
                if (this.switchToTelOutgoingCall) {
                    this.log.log(10000000, "[TelEPMHandler#actionProxyCallPerformed] Tel app entered via outgoing call.");
                    this.context = 2;
                    this.switchToPreviousContextAfterTransitionToIdle();
                    this.switchToTelOutgoingCall = false;
                    break;
                }
                this.log.log(10000000, "[TelEPMHandler#actionProxyCallPerformed] Tel app entered (not HK_TEL or ACCEPT_CALL)");
                this.context = 1;
                this.stayInTelephoneContextAfterTransitionToIdle();
                break;
            }
            case 17: {
                if (this.context != 2 || this.isIdle()) break;
                this.log.log(10000000, "[TelEPMHandler#actionProxyCallPerformed] intellicall reduced view left - staying in telephone");
                this.stayInTelephoneContextAfterTransitionToIdle();
                break;
            }
            case 9: {
                this.hkTelPressed = true;
                if (this.context != 2 || this.isIdle()) break;
                this.log.log(10000000, "[TelEPMHandler#actionProxyCallPerformed] HK_TEL pressed, staying in telephone.");
                this.stayInTelephoneContextAfterTransitionToIdle();
                break;
            }
            case 22: {
                this.switchToTelIncomingCall = true;
                break;
            }
            case 8: {
                this.telAppEntered = false;
                this.context = 0;
                this.resetSwitchToTelephoneModels();
                break;
            }
            case 24: {
                this.switchToTelOutgoingCall = true;
                break;
            }
            default: {
                this.log.log(10000000, "[TelEPMHandler#actionProxyCallPerformed] no handling for method %1", (long)n);
            }
        }
    }

    private void resetSwitchToTelephoneModels() {
        this.getChoiceModel(3996).setValue(0);
        this.getChoiceModel(300691).setStatus(0);
    }

    private void stayInTelephoneContextAfterTransitionToIdle() {
        this.log.log(1000000, "[TelEPMHandler#stayInTelephoneContextAfterTransitionToIdle]");
        this.getChoiceModel(300691).setValue(1);
    }

    private void switchToPreviousContextAfterTransitionToIdle() {
        this.log.log(1000000, "[TelEPMHandler#switchToPreviousContextAfterTransitionToIdle]");
        this.getChoiceModel(300691).setValue(0);
    }

    public EPMResponseListener getResponseListener() {
        return this.responseListener;
    }

    private class TelEPMDiag
    implements IPhoneDiagComponent {
        private TelEPMDiag() {
        }

        public void cmdEPMOutgoingCallSwitchNavToTelephone(String string) {
            TelEPMHandler.this.getApplication().getTelephoneDSIAccess().dialNumber(string, 0);
            TelEPMHandler.this.getApplication().getFrameworkAccess().getHMIService().fireSMEvent(0, 400225);
        }
    }

    private class EPMResponseListener
    extends TelDefaultDSIResponseListener
    implements ITelEPMHandler {
        private EPMResponseListener() {
        }

        public void responseAcceptCall(int n, int n2) {
            if (TelEPMHandler.this.telAppEntered) {
                TelEPMHandler.this.log.log(10000000, "[TelEPMHandler.EPMResponseListener#responseAcceptCall] call accepted but already in telephone --> NOP!");
            } else if (n == 0 && TelEPMHandler.this.isTerminalValid(n2)) {
                TelEPMHandler.this.log.log(1000000, "[TelEPMHandler.EPMResponseListener#responseAcceptCall] call accepted - switching to telephone.");
                this.triggerSwitchToTelephoneIncomingCall();
            } else {
                TelEPMHandler.this.log.log(1000000, "[TelEPMHandler.EPMResponseListener#responseAcceptCall] result=%1, terminalID=%2 --> NOP!", (long)n, (long)n2);
            }
        }

        public void responseDialNumber(int n, int n2, SuppServiceResponseStruct suppServiceResponseStruct, int n3) {
            TelEPMHandler.this.log.log(1000000, "[TelEPMHandler.EPMResponseListener#responseDialNumber]");
            this.triggerSwitchToTelephoneOutgoingCall();
        }

        private void triggerSwitchToTelephoneOutgoingCall() {
            TelEPMHandler.this.getChoiceModel(300691).setStatus(1);
        }

        private void triggerSwitchToTelephoneIncomingCall() {
            TelEPMHandler.this.getChoiceModel(3996).setValue(1);
        }

        public void responseSetMICMuteState(int n, int n2) {
            if (n == 0 && TelEPMHandler.this.isTerminalValid(n2)) {
                TelEPMHandler.this.log.log(1000000, "[TelEPMHandler.EPMResponseListener#setMICMuteStateResponse] staying in telephone");
                TelEPMHandler.this.stayInTelephoneContextAfterTransitionToIdle();
            }
        }

        public void responseSetHandsFreeMode(int n, int n2) {
            if (n == 0 && TelEPMHandler.this.isTerminalValid(n2)) {
                TelEPMHandler.this.log.log(1000000, "[TelEPMHandler.EPMResponseListener#responseSetHandsFreeMode] staying in telephone");
                TelEPMHandler.this.stayInTelephoneContextAfterTransitionToIdle();
            }
        }

        public void responseSwapCalls(int n, int n2) {
            if (n == 0 && TelEPMHandler.this.isTerminalValid(n2)) {
                TelEPMHandler.this.log.log(1000000, "[TelEPMHandler.EPMResponseListener#responseSwapCalls] staying in telephone");
                TelEPMHandler.this.stayInTelephoneContextAfterTransitionToIdle();
            }
        }
    }
}

