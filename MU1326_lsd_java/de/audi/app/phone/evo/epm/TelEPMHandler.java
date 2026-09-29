/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.phone.evo.epm;

import de.audi.app.phone.core.AbstractPhoneComponent;
import de.audi.app.phone.core.ITelApplication;
import de.audi.app.phone.core.ap.IActionProxyListener;
import de.audi.app.phone.core.state.IGlobalTelephoneStateStruct;
import de.audi.app.phone.evo.epm.TelEPMHandler$EPMResponseListener;
import de.audi.app.phone.evo.epm.TelEPMHandler$TelEPMDiag;
import de.audi.atip.hmi.modelaccess.ChoiceModelApp;
import de.audi.atip.log.LogChannel;
import java.util.Map;

public class TelEPMHandler
extends AbstractPhoneComponent
implements IActionProxyListener {
    private static final int INCOMING_CALL_SWITCH_TO_TEL_WAITING;
    private static final int INCOMING_CALL_TRIGGER_SWITCH_TO_TEL;
    private static final int SWITCH_TO_PREVIOUS_CONTEXT;
    private static final int STAY_IN_TELEPHONE_CONTEXT;
    private static final int CONTEXT_NOT_TEL;
    private static final int CONTEXT_TEL_MANUAL;
    private static final int CONTEXT_TEL_EPM_CALL;
    private volatile boolean hkTelPressed;
    private volatile boolean switchToTelIncomingCall;
    private volatile boolean switchToTelOutgoingCall;
    private volatile boolean telAppEntered;
    private volatile int context;
    private final boolean isMMIKombi;
    private final TelEPMHandler$EPMResponseListener responseListener = new TelEPMHandler$EPMResponseListener(this, null);
    private volatile IGlobalTelephoneStateStruct telephoneState;

    public TelEPMHandler(ITelApplication iTelApplication) {
        super(iTelApplication, "App.Phone.Main");
        this.isMMIKombi = this.getApplication().getFrameworkAccess().getKombiType() == 4;
    }

    @Override
    public void init() {
        this.getApplication().getGlobalTelephoneStateManager().registerListener(this);
        this.getApplication().getActionProxyDispatcher().addActionProxyListener(22, this);
        this.getApplication().getActionProxyDispatcher().addActionProxyListener(7, this);
        this.getApplication().getActionProxyDispatcher().addActionProxyListener(8, this);
        this.getApplication().getActionProxyDispatcher().addActionProxyListener(9, this);
        this.getApplication().getActionProxyDispatcher().addActionProxyListener(17, this);
        this.getApplication().getActionProxyDispatcher().addActionProxyListener(24, this);
        this.getChoiceModel(-1818885120).setStatus(0);
        this.getApplication().addDiagnosisComponent(new TelEPMHandler$TelEPMDiag(this, null));
        this.getApplication().getTelephoneDSIAccess().addGlobalDSIResponseListener(this.responseListener);
    }

    @Override
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

    @Override
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

    @Override
    public void actionProxyCallPerformed(int n, Map map) {
        switch (n) {
            case 7: {
                this.telAppEntered = true;
                if (this.hkTelPressed) {
                    this.log.log(-2137614336, "[TelEPMHandler#actionProxyCallPerformed] Tel app entered via HK_TEL.");
                    this.context = 1;
                    this.stayInTelephoneContextAfterTransitionToIdle();
                    this.hkTelPressed = false;
                    break;
                }
                if (this.switchToTelIncomingCall) {
                    this.log.log(-2137614336, "[TelEPMHandler#actionProxyCallPerformed] Tel app entered via accepting incoming call.");
                    this.context = 2;
                    this.switchToPreviousContextAfterTransitionToIdle();
                    this.switchToTelIncomingCall = false;
                    break;
                }
                if (this.switchToTelOutgoingCall) {
                    this.log.log(-2137614336, "[TelEPMHandler#actionProxyCallPerformed] Tel app entered via outgoing call.");
                    this.context = 2;
                    this.switchToPreviousContextAfterTransitionToIdle();
                    this.switchToTelOutgoingCall = false;
                    break;
                }
                this.log.log(-2137614336, "[TelEPMHandler#actionProxyCallPerformed] Tel app entered (not HK_TEL or ACCEPT_CALL)");
                this.context = 1;
                this.stayInTelephoneContextAfterTransitionToIdle();
                break;
            }
            case 17: {
                if (this.context != 2 || this.isIdle()) break;
                this.log.log(-2137614336, "[TelEPMHandler#actionProxyCallPerformed] intellicall reduced view left - staying in telephone");
                this.stayInTelephoneContextAfterTransitionToIdle();
                break;
            }
            case 9: {
                this.hkTelPressed = true;
                if (this.context != 2 || this.isIdle()) break;
                this.log.log(-2137614336, "[TelEPMHandler#actionProxyCallPerformed] HK_TEL pressed, staying in telephone.");
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
                this.log.log(-2137614336, "[TelEPMHandler#actionProxyCallPerformed] no handling for method %1", (long)n);
            }
        }
    }

    private void resetSwitchToTelephoneModels() {
        this.getChoiceModel(3996).setValue(0);
        this.getChoiceModel(-1818885120).setStatus(0);
    }

    private void stayInTelephoneContextAfterTransitionToIdle() {
        this.log.log(1078071040, "[TelEPMHandler#stayInTelephoneContextAfterTransitionToIdle]");
        this.getChoiceModel(-1818885120).setValue(1);
    }

    private void switchToPreviousContextAfterTransitionToIdle() {
        this.log.log(1078071040, "[TelEPMHandler#switchToPreviousContextAfterTransitionToIdle]");
        this.getChoiceModel(-1818885120).setValue(0);
    }

    public TelEPMHandler$EPMResponseListener getResponseListener() {
        return this.responseListener;
    }

    static /* synthetic */ boolean access$200(TelEPMHandler telEPMHandler) {
        return telEPMHandler.telAppEntered;
    }

    static /* synthetic */ LogChannel access$300(TelEPMHandler telEPMHandler) {
        return telEPMHandler.log;
    }

    static /* synthetic */ boolean access$400(TelEPMHandler telEPMHandler, int n) {
        return telEPMHandler.isTerminalValid(n);
    }

    static /* synthetic */ LogChannel access$500(TelEPMHandler telEPMHandler) {
        return telEPMHandler.log;
    }

    static /* synthetic */ LogChannel access$600(TelEPMHandler telEPMHandler) {
        return telEPMHandler.log;
    }

    static /* synthetic */ LogChannel access$700(TelEPMHandler telEPMHandler) {
        return telEPMHandler.log;
    }

    static /* synthetic */ ChoiceModelApp access$800(TelEPMHandler telEPMHandler, int n) {
        return telEPMHandler.getChoiceModel(n);
    }

    static /* synthetic */ ChoiceModelApp access$900(TelEPMHandler telEPMHandler, int n) {
        return telEPMHandler.getChoiceModel(n);
    }

    static /* synthetic */ LogChannel access$1000(TelEPMHandler telEPMHandler) {
        return telEPMHandler.log;
    }

    static /* synthetic */ void access$1100(TelEPMHandler telEPMHandler) {
        telEPMHandler.stayInTelephoneContextAfterTransitionToIdle();
    }

    static /* synthetic */ LogChannel access$1200(TelEPMHandler telEPMHandler) {
        return telEPMHandler.log;
    }

    static /* synthetic */ LogChannel access$1300(TelEPMHandler telEPMHandler) {
        return telEPMHandler.log;
    }

    static /* synthetic */ ITelApplication access$1400(TelEPMHandler telEPMHandler) {
        return telEPMHandler.getApplication();
    }

    static /* synthetic */ ITelApplication access$1500(TelEPMHandler telEPMHandler) {
        return telEPMHandler.getApplication();
    }
}

