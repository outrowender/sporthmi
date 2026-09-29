/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.phone.evo.entertainmentdrawer.dataelements;

import de.audi.app.addressbook.core.common.ADBModelUtils;
import de.audi.app.phone.core.ITelApplication;
import de.audi.app.phone.core.calllist.AbstractPhoneCall;
import de.audi.app.phone.core.dsi.ITelDSIMobileEquipmentDeviceState;
import de.audi.app.phone.core.state.CallStateStruct;
import de.audi.app.phone.core.state.IGlobalTelephoneStateStruct;
import de.audi.app.phone.core.util.PhoneUtils;
import de.audi.app.phone.evo.entertainmentdrawer.dataelements.AbstractDataEntertainmentDrawerElement;
import de.audi.atip.hmi.model.HMIResourceLocator;
import java.util.LinkedList;
import java.util.List;

public class EntertainmentDrawerElementIncomingCallDataModels
extends AbstractDataEntertainmentDrawerElement {
    private final List incomingCallModels = new LinkedList();
    private int callType;
    private String telText;
    private String callName;
    private int phoneType;
    private HMIResourceLocator resourceLocator;

    private static boolean hasDisconnectingCall(CallStateStruct callStateStruct) {
        return callStateStruct != null ? callStateStruct.isHasDisconnectingCall() : false;
    }

    public EntertainmentDrawerElementIncomingCallDataModels(ITelApplication iTelApplication) {
        super(iTelApplication, 0);
        this.addAllModelsToInternalList();
    }

    @Override
    public List getModels() {
        return this.incomingCallModels;
    }

    @Override
    public void updateValues() {
        CallStateStruct callStateStruct;
        CallStateStruct callStateStruct2 = this.getCurrentStateStruct() != null ? (this.getCurrentStateStruct().getCallLeadingDevice() != null ? this.getCurrentStateStruct().getCallLeadingDevice().getCallState() : null) : (callStateStruct = null);
        CallStateStruct callStateStruct3 = this.getCurrentStateStruct() != null ? (this.getCurrentStateStruct().getNonCallLeadingDevice() != null ? this.getCurrentStateStruct().getNonCallLeadingDevice().getCallState() : null) : null;
        AbstractPhoneCall abstractPhoneCall = callStateStruct != null ? callStateStruct.getIncomingCall() : null;
        AbstractPhoneCall abstractPhoneCall2 = callStateStruct3 != null ? callStateStruct3.getIncomingCall() : null;
        this.updateIncomingCallModels(abstractPhoneCall, abstractPhoneCall2, this.getCurrentStateStruct());
    }

    private void updateIncomingCallModels(AbstractPhoneCall abstractPhoneCall, AbstractPhoneCall abstractPhoneCall2, IGlobalTelephoneStateStruct iGlobalTelephoneStateStruct) {
        if (iGlobalTelephoneStateStruct != null && abstractPhoneCall != null && iGlobalTelephoneStateStruct.getCallLeadingDevice() != null) {
            this.log.log(-2137614336, "[EntertainmentDrawerElementIncomingCallDataModels#updateIncomingCallModels] incoming call on call leading phone detected - showing popup.");
            this.setIncomingCallmodels(abstractPhoneCall, iGlobalTelephoneStateStruct, this.getNameForDrawerLabel(iGlobalTelephoneStateStruct.getCallLeadingDevice()));
        } else if (iGlobalTelephoneStateStruct != null && abstractPhoneCall2 != null && iGlobalTelephoneStateStruct.getNonCallLeadingDevice() != null && iGlobalTelephoneStateStruct.getCallLeadingDevice() != null && !EntertainmentDrawerElementIncomingCallDataModels.hasDisconnectingCall(iGlobalTelephoneStateStruct.getCallLeadingDevice().getCallState())) {
            this.log.log(-2137614336, "[EntertainmentDrawerElementIncomingCallDataModels#updateIncomingCallModels] incoming call on non call leading phone detected - showing popup.");
            this.setIncomingCallmodels(abstractPhoneCall2, iGlobalTelephoneStateStruct, this.getNameForDrawerLabel(iGlobalTelephoneStateStruct.getNonCallLeadingDevice()));
        } else {
            this.setIncommingCallTelephoneText("");
            this.setCallNameLabel("");
            this.setCallPhoneTypeIconModel(9);
            this.setCallPictureResourceLocator(new HMIResourceLocator(-1, HMIResourceLocator.UNDEFINED_URI));
        }
    }

    private void setIncomingCallmodels(AbstractPhoneCall abstractPhoneCall, IGlobalTelephoneStateStruct iGlobalTelephoneStateStruct, String string) {
        String string2 = iGlobalTelephoneStateStruct.getDisplayName(abstractPhoneCall.getTelRemName(), abstractPhoneCall.getTelRemNumber());
        this.setIncommingCallTelephoneText(string);
        this.updateCallTypeImage(abstractPhoneCall);
        this.setCallNameLabel(string2);
        this.setCallPhoneTypeIconModel(ADBModelUtils.getIconTypeForPhoneNumber(abstractPhoneCall.getTelRemNumberType()));
        this.setCallPictureResourceLocator(abstractPhoneCall.getHMIResourceLocator());
    }

    private String getNameForDrawerLabel(ITelDSIMobileEquipmentDeviceState iTelDSIMobileEquipmentDeviceState) {
        return this.isHFPorSAP(iTelDSIMobileEquipmentDeviceState) ? this.getBtDeviceName(iTelDSIMobileEquipmentDeviceState) : this.getSIMText();
    }

    private boolean isHFPorSAP(ITelDSIMobileEquipmentDeviceState iTelDSIMobileEquipmentDeviceState) {
        return iTelDSIMobileEquipmentDeviceState != null ? iTelDSIMobileEquipmentDeviceState.getTelMode() == 3 || iTelDSIMobileEquipmentDeviceState.getTelMode() == 2 || iTelDSIMobileEquipmentDeviceState.getTelMode() == 1 : false;
    }

    private String getBtDeviceName(ITelDSIMobileEquipmentDeviceState iTelDSIMobileEquipmentDeviceState) {
        return iTelDSIMobileEquipmentDeviceState != null ? (iTelDSIMobileEquipmentDeviceState.getPhoneInformation() != null ? (iTelDSIMobileEquipmentDeviceState.getPhoneInformation().getMeFriendlyName() != null ? iTelDSIMobileEquipmentDeviceState.getPhoneInformation().getMeFriendlyName() : "") : "") : "";
    }

    private String getSIMText() {
        return this.getApplication().getTextFactory() != null ? this.getApplication().getTextFactory().getText(13) : "";
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
        this.incomingCallModels.add(this.getChoiceModel(-1114176512));
        this.incomingCallModels.add(this.getLabelModel(4509));
        this.incomingCallModels.add(this.getLabelModel(-1936325632));
        this.incomingCallModels.add(this.getChoiceModel(-1969880064));
        this.incomingCallModels.add(this.getResourceLocatorModel(-1953102848));
    }

    private void setTelCallTypeChoiceValue(int n) {
        this.getChoiceModel(-1114176512).setValue(n);
        this.callType = n;
    }

    private void setIncommingCallTelephoneText(String string) {
        this.getLabelModel(4509).setText(string);
        this.telText = string;
    }

    private void setCallNameLabel(String string) {
        this.getLabelModel(-1936325632).setText(string);
        this.callName = string;
    }

    private void setCallPhoneTypeIconModel(int n) {
        this.getChoiceModel(-1969880064).setValue(n);
        this.phoneType = n;
    }

    private void setCallPictureResourceLocator(HMIResourceLocator hMIResourceLocator) {
        this.getResourceLocatorModel(-1953102848).setResourceLocator(hMIResourceLocator);
        this.resourceLocator = hMIResourceLocator;
    }

    public int getIncomingCallCallType() {
        return this.callType;
    }

    public String getIncomingCallTelText() {
        return this.telText;
    }

    public String getIncomingCallCallName() {
        return this.callName;
    }

    public int getIncomingCallPhoneType() {
        return this.phoneType;
    }

    public HMIResourceLocator getIncomingCallPicture() {
        return this.resourceLocator;
    }
}

