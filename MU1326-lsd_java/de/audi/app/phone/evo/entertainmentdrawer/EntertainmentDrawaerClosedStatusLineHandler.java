/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.phone.evo.entertainmentdrawer;

import de.audi.app.phone.core.AbstractPhoneComponent;
import de.audi.app.phone.core.ITelApplication;
import de.audi.app.phone.core.calllist.AbstractPhoneCall;
import de.audi.app.phone.core.dsi.ITelDSIMobileEquipmentDeviceState;
import de.audi.app.phone.core.state.CallStateStruct;
import de.audi.app.phone.core.state.IGlobalTelephoneStateStruct;
import de.audi.app.phone.core.util.PhoneUtils;
import de.audi.app.phone.evo.entertainmentdrawer.EntertainmentDrawaerClosedStatusLineHandler$StatusLineHandlerLanguageUpdateListener;
import de.audi.atip.hmi.modelaccess.ChoiceModelApp;
import de.audi.atip.interapp.bap.ecall.data.PhoneCall;
import de.audi.atip.interapp.phone.IEcallState;

public class EntertainmentDrawaerClosedStatusLineHandler
extends AbstractPhoneComponent {
    private IGlobalTelephoneStateStruct stateStruct;

    public EntertainmentDrawaerClosedStatusLineHandler(ITelApplication iTelApplication) {
        super(iTelApplication, "App.Phone.EntertainmentDrawer");
        this.addSubPhoneComponent(new EntertainmentDrawaerClosedStatusLineHandler$StatusLineHandlerLanguageUpdateListener(this, iTelApplication));
    }

    @Override
    public void init() {
        super.init();
        this.getApplication().getGlobalTelephoneStateManager().registerListener(this);
    }

    @Override
    public void deinit() {
        super.deinit();
        this.getApplication().getGlobalTelephoneStateManager().removeListener(this);
    }

    @Override
    public void updateGlobalTelephoneStateProperty(int n, IGlobalTelephoneStateStruct iGlobalTelephoneStateStruct) {
        if (n == 0x8000100 || n == 0x8000200 || n == 0x8000300 || n == 0xC000400) {
            this.stateStruct = iGlobalTelephoneStateStruct;
            this.refreshDrawerLabel();
        }
    }

    private void refreshDrawerLabel() {
        if (this.stateStruct != null && this.stateStruct.getConnectedGatewayState().isCustomerCallAllowed()) {
            this.setupEntartainmentDrawerLabel(this.stateStruct);
        } else if (this.stateStruct != null && this.stateStruct.getConnectedGatewayState() != null && this.stateStruct.getConnectedGatewayState().isLowPrioritySOSEmergencyCallType()) {
            this.setupEntartainmentDrawerLabelForLowPrioritySOSCall(this.stateStruct.getConnectedGatewayState());
        } else {
            this.log.log(-2137614336, "EntertainmentDrawaerClosedStatusLineHandler#updateGlobalTelephoneStateProperty(): customer call is't allowed.");
        }
    }

    private void setupEntartainmentDrawerLabelForLowPrioritySOSCall(IEcallState iEcallState) {
        this.log.log(1078071040, "EntertainmentDrawaerClosedStatusLineHandler#setupEntartainmentDrawerLabelForLowPrioritySOSCall()");
        this.setupCallStateIconForEDEcall(iEcallState.getCall());
        this.getLabelModel(2140603392).setText(PhoneUtils.getSOSCallTextConstant(this.getApplication().geEmergencyTextFactory(), iEcallState.getEmergencyNumberToBeDialed()));
    }

    private void setupEntartainmentDrawerLabel(IGlobalTelephoneStateStruct iGlobalTelephoneStateStruct) {
        CallStateStruct callStateStruct;
        ITelDSIMobileEquipmentDeviceState iTelDSIMobileEquipmentDeviceState = iGlobalTelephoneStateStruct.getCallLeadingDevice();
        ITelDSIMobileEquipmentDeviceState iTelDSIMobileEquipmentDeviceState2 = iGlobalTelephoneStateStruct.getNonCallLeadingDevice();
        CallStateStruct callStateStruct2 = iTelDSIMobileEquipmentDeviceState != null ? iTelDSIMobileEquipmentDeviceState.getCallState() : null;
        CallStateStruct callStateStruct3 = callStateStruct = iTelDSIMobileEquipmentDeviceState2 != null ? iTelDSIMobileEquipmentDeviceState2.getCallState() : null;
        if (callStateStruct2 != null) {
            if (callStateStruct2.isHasIncomingCall()) {
                this.refreshUIModelsForCall(iTelDSIMobileEquipmentDeviceState, callStateStruct2.getIncomingCall());
            } else if (callStateStruct != null && callStateStruct.isHasIncomingCall()) {
                this.refreshUIModelsForCall(iTelDSIMobileEquipmentDeviceState2, callStateStruct.getIncomingCall());
            } else if (callStateStruct2.isHasDisconnectingCall()) {
                this.refreshUIModelsForCall(iTelDSIMobileEquipmentDeviceState, callStateStruct2.getDisconnectingCall());
            } else if (callStateStruct2.isHasOutgoingCall()) {
                this.refreshUIModelsForCall(iTelDSIMobileEquipmentDeviceState, callStateStruct2.getOutgoingCall());
            } else if (callStateStruct2.isHasActiveCall()) {
                this.refreshUIModelsForCall(iTelDSIMobileEquipmentDeviceState, callStateStruct2.getActiveCall());
            } else if (callStateStruct2.isHasOnHoldCall()) {
                this.refreshUIModelsForCall(iTelDSIMobileEquipmentDeviceState, callStateStruct2.getHeldCall());
            } else {
                this.log.log(-1601830656, "[EntertainmentDrawaerClosedStatusLineHandler#setupEntartainmentDrawerLabel] NOP %1", (Object)callStateStruct2);
            }
        }
    }

    private void refreshUIModelsForCall(ITelDSIMobileEquipmentDeviceState iTelDSIMobileEquipmentDeviceState, AbstractPhoneCall abstractPhoneCall) {
        this.setupCallStateIconForED(abstractPhoneCall);
        this.setupTextForEntartainmentDrawerLabel(iTelDSIMobileEquipmentDeviceState, abstractPhoneCall);
    }

    private void setupCallStateIconForEDEcall(PhoneCall phoneCall) {
        switch (phoneCall.getState()) {
            case 5: {
                this.getEntertainmentDrawerCallStateIconChoiceModel().setValue(1);
                break;
            }
            case 0: 
            case 4: {
                this.getEntertainmentDrawerCallStateIconChoiceModel().setValue(2);
                break;
            }
            default: {
                this.getEntertainmentDrawerCallStateIconChoiceModel().setValue(0);
            }
        }
    }

    private void setupCallStateIconForED(AbstractPhoneCall abstractPhoneCall) {
        switch (abstractPhoneCall.getTelCallState()) {
            case 6: 
            case 8: {
                this.getEntertainmentDrawerCallStateIconChoiceModel().setValue(1);
                break;
            }
            case 5: {
                this.getEntertainmentDrawerCallStateIconChoiceModel().setValue(2);
                break;
            }
            default: {
                this.getEntertainmentDrawerCallStateIconChoiceModel().setValue(0);
            }
        }
    }

    private ChoiceModelApp getEntertainmentDrawerCallStateIconChoiceModel() {
        return this.getChoiceModel(-1751710720);
    }

    private void setupTextForEntartainmentDrawerLabel(ITelDSIMobileEquipmentDeviceState iTelDSIMobileEquipmentDeviceState, AbstractPhoneCall abstractPhoneCall) {
        String string = iTelDSIMobileEquipmentDeviceState.getDisplayName(abstractPhoneCall);
        this.log.log(-2137614336, "EntertainmentDrawaerClosedStatusLineHandler#setupTextForEntartainmentDrawerLabel(): closed status line Text: %1", (Object)string);
        this.getLabelModel(2140603392).setText(string);
    }

    static /* synthetic */ void access$100(EntertainmentDrawaerClosedStatusLineHandler entertainmentDrawaerClosedStatusLineHandler) {
        entertainmentDrawaerClosedStatusLineHandler.refreshDrawerLabel();
    }
}

