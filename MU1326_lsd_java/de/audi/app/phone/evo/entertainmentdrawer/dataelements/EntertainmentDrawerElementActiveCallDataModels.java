/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.phone.evo.entertainmentdrawer.dataelements;

import de.audi.app.phone.core.ITelApplication;
import de.audi.app.phone.core.calllist.AbstractPhoneCall;
import de.audi.app.phone.core.dsi.ITelDSIMobileEquipmentDeviceState;
import de.audi.app.phone.core.state.CallStateStruct;
import de.audi.app.phone.core.util.PhoneUtils;
import de.audi.app.phone.evo.entertainmentdrawer.dataelements.AbstractDataEntertainmentDrawerElement;
import de.audi.atip.hmi.model.HMIResourceLocator;
import de.audi.atip.interapp.bap.ecall.data.PhoneCall;
import de.audi.atip.interapp.phone.IEcallState;
import java.util.LinkedList;
import java.util.List;

public class EntertainmentDrawerElementActiveCallDataModels
extends AbstractDataEntertainmentDrawerElement {
    private final List activeCallModels = new LinkedList();
    private int callTypeImage;
    private int telText;
    private String callName;
    private int phoneCallType;
    private HMIResourceLocator resourceLocator;

    private static int getActionText(AbstractPhoneCall abstractPhoneCall, ITelDSIMobileEquipmentDeviceState iTelDSIMobileEquipmentDeviceState) {
        switch (abstractPhoneCall.getTelCallState()) {
            case 4: {
                if (iTelDSIMobileEquipmentDeviceState.getTelMode() == 3 && iTelDSIMobileEquipmentDeviceState.getHandsFreeMode() == 4) {
                    return 9;
                }
                if (iTelDSIMobileEquipmentDeviceState.getmICMuteState() == 0) {
                    return 8;
                }
                if (abstractPhoneCall.isConferenceCall()) {
                    return 7;
                }
                return 4;
            }
            case 1: 
            case 2: {
                return 3;
            }
            case 6: {
                return abstractPhoneCall.isConferenceCall() ? 6 : 5;
            }
            case 5: {
                return 2;
            }
        }
        return 0;
    }

    private static int getActionText(PhoneCall phoneCall) {
        switch (phoneCall.getState()) {
            case 2: {
                return 4;
            }
            case 3: {
                return 3;
            }
            case 5: {
                return 5;
            }
            case 4: {
                return 2;
            }
        }
        return 0;
    }

    private static int getCallType(AbstractPhoneCall abstractPhoneCall, ITelDSIMobileEquipmentDeviceState iTelDSIMobileEquipmentDeviceState) {
        int n = -1;
        if (abstractPhoneCall != null) {
            if (abstractPhoneCall.isConferenceCall() && abstractPhoneCall.getTelCallType() == 4) {
                n = 5;
            } else {
                String string = abstractPhoneCall.getTelRemNumber();
                if (string == null || string.length() == 0) {
                    n = 4;
                } else if (iTelDSIMobileEquipmentDeviceState.isEmergencyNumber(string) && abstractPhoneCall.getTelCallType() == 3) {
                    n = 3;
                } else if (iTelDSIMobileEquipmentDeviceState.isMailboxNumber(string)) {
                    n = 0;
                } else if (iTelDSIMobileEquipmentDeviceState.isInfoNumber(string) && abstractPhoneCall.getTelCallType() == 5) {
                    n = 1;
                } else if (iTelDSIMobileEquipmentDeviceState.isBreakdownNumber(string) && abstractPhoneCall.getTelCallType() == 6) {
                    n = 2;
                }
            }
        }
        return n;
    }

    public EntertainmentDrawerElementActiveCallDataModels(ITelApplication iTelApplication) {
        super(iTelApplication, 1);
        this.addAllModelsToInternalList();
    }

    public List getModels() {
        return this.activeCallModels;
    }

    public void updateValues() {
        boolean bl;
        CallStateStruct callStateStruct;
        ITelDSIMobileEquipmentDeviceState iTelDSIMobileEquipmentDeviceState = this.getCurrentStateStruct() != null ? this.getCurrentStateStruct().getCallLeadingDevice() : null;
        CallStateStruct callStateStruct2 = callStateStruct = iTelDSIMobileEquipmentDeviceState != null ? iTelDSIMobileEquipmentDeviceState.getCallState() : null;
        boolean bl2 = this.getCurrentStateStruct() != null ? (this.getCurrentStateStruct().getConnectedGatewayState() != null ? this.getCurrentStateStruct().getConnectedGatewayState().isLowPrioritySOSEmergencyCallType() : false) : (bl = false);
        if (bl) {
            this.log.log(1000000, "EntertainmentDrawerElementActiveCallDataModels#setActiveCallModels(): has low priority SOS call ");
            this.setEmergencyCallActive(this.getCurrentStateStruct().getConnectedGatewayState());
            return;
        }
        if (callStateStruct == null) {
            this.log.log(100000, "[EntertainmentDrawerElementActiveCallDataModels#setActiveCallModels] call state is null!");
            return;
        }
        if (callStateStruct.isHasDisconnectingCall()) {
            this.log.log(10000000, "[EntertainmentDrawerElementActiveCallDataModels#setActiveCallModels] has disconnecting call %1 ", (Object)callStateStruct.getDisconnectingCall());
            this.setActiveCallmodels(callStateStruct.getDisconnectingCall(), iTelDSIMobileEquipmentDeviceState);
        } else if (callStateStruct.isHasOutgoingCall()) {
            this.log.log(1000000, "EntertainmentDrawerElementActiveCallDataModels#setActiveCallModels(): has outgoing call %1 ", (Object)callStateStruct.getOutgoingCall());
            this.setActiveCallmodels(callStateStruct.getOutgoingCall(), iTelDSIMobileEquipmentDeviceState);
        } else if (callStateStruct.isHasActiveCall()) {
            this.log.log(10000000, "[EntertainmentDrawerElementActiveCallDataModels#setActiveCallModels] has active call %1", (Object)callStateStruct.getActiveCall());
            this.setActiveCallmodels(callStateStruct.getActiveCall(), iTelDSIMobileEquipmentDeviceState);
        } else if (callStateStruct.isHasOnHoldCall()) {
            this.log.log(10000000, "[EntertainmentDrawerElementActiveCallDataModels#setActiveCallModels] has held call %1 ", (Object)callStateStruct.getHeldCall());
            this.setActiveCallmodels(callStateStruct.getHeldCall(), iTelDSIMobileEquipmentDeviceState);
        } else {
            this.log.log(10000000, "[EntertainmentDrawerElementActiveCallDataModels#setActiveCallModels] reseting updating model for callState %1 ", (Object)callStateStruct);
            this.setActiveCallTelephoneText(0);
            this.setCallNameLabel("");
            this.setCallPhoneTypeIconModel(-1);
            this.setCallPictureResourceLocator(new HMIResourceLocator(-1, HMIResourceLocator.UNDEFINED_URI));
        }
    }

    private void setEmergencyCallActive(IEcallState iEcallState) {
        this.setActiveCallTelephoneText(EntertainmentDrawerElementActiveCallDataModels.getActionText(this.getCurrentStateStruct().getConnectedGatewayState().getCall()));
        this.setCallNameLabel(PhoneUtils.getSOSCallTextConstant(this.getApplication().geEmergencyTextFactory(), iEcallState.getEmergencyNumberToBeDialed()));
        this.setCallPhoneTypeIconModel(3);
        this.setCallPictureResourceLocator(new HMIResourceLocator(-1, HMIResourceLocator.UNDEFINED_URI));
    }

    private void setActiveCallmodels(AbstractPhoneCall abstractPhoneCall, ITelDSIMobileEquipmentDeviceState iTelDSIMobileEquipmentDeviceState) {
        this.setActiveCallTelephoneText(EntertainmentDrawerElementActiveCallDataModels.getActionText(abstractPhoneCall, iTelDSIMobileEquipmentDeviceState));
        this.updateCallTypeImage(abstractPhoneCall);
        this.setCallNameLabel(iTelDSIMobileEquipmentDeviceState.getDisplayName(abstractPhoneCall));
        this.setCallPhoneTypeIconModel(EntertainmentDrawerElementActiveCallDataModels.getCallType(abstractPhoneCall, iTelDSIMobileEquipmentDeviceState));
        this.setCallPictureResourceLocator(abstractPhoneCall.getHMIResourceLocator());
    }

    private void updateCallTypeImage(AbstractPhoneCall abstractPhoneCall) {
        if (abstractPhoneCall.isConferenceCall()) {
            this.setTelCallTypeChoiceValue(2);
        } else {
            int n = PhoneUtils.isPictureAvailable(abstractPhoneCall.getTelRemPictureId()) ? 1 : 0;
            this.setTelCallTypeChoiceValue(n);
        }
    }

    private void addAllModelsToInternalList() {
        this.activeCallModels.add(this.getChoiceModel(300989));
        this.activeCallModels.add(this.getChoiceModel(300941));
        this.activeCallModels.add(this.getLabelModel(300931));
        this.activeCallModels.add(this.getChoiceModel(300930));
        this.activeCallModels.add(this.getResourceLocatorModel(300932));
    }

    private void setTelCallTypeChoiceValue(int n) {
        this.getChoiceModel(300989).setValue(n);
        this.callTypeImage = n;
    }

    private void setActiveCallTelephoneText(int n) {
        this.getChoiceModel(300941).setValue(n);
        this.telText = n;
    }

    private void setCallNameLabel(String string) {
        this.getLabelModel(300931).setText(string);
        this.callName = string;
    }

    private void setCallPhoneTypeIconModel(int n) {
        this.getChoiceModel(300930).setValue(n);
        this.phoneCallType = n;
    }

    private void setCallPictureResourceLocator(HMIResourceLocator hMIResourceLocator) {
        this.getResourceLocatorModel(300932).setResourceLocator(hMIResourceLocator);
        this.resourceLocator = hMIResourceLocator;
    }

    public String getActiveCallCallName() {
        return this.callName;
    }

    public int getActiveCallTelText() {
        return this.telText;
    }

    public int getActiveCallPhoneCallType() {
        return this.phoneCallType;
    }

    public int getActiveCallCallTypeImage() {
        return this.callTypeImage;
    }

    public HMIResourceLocator getActiveCallResourceLocator() {
        return this.resourceLocator;
    }

    private static final class ActionTextValues {
        private static final int DEFAULT = 0;
        private static final int DISCONNECTING = 2;
        private static final int OUTGOING_CALL = 3;
        private static final int ACTIVE_CALL = 4;
        private static final int HOLD = 5;
        private static final int CONFERENCE_HOLD = 6;
        private static final int ACTIVE_CONFERENCE = 7;
        private static final int MUTE = 8;
        private static final int AUDIO_ON_ME = 9;

        private ActionTextValues() {
        }
    }
}

