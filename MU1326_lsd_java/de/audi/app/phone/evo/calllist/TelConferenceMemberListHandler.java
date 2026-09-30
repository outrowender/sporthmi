/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.phone.evo.calllist;

import de.audi.app.phone.core.AbstractPhoneComponent;
import de.audi.app.phone.core.ITelApplication;
import de.audi.app.phone.core.calllist.ConferenceCall;
import de.audi.app.phone.core.calllist.PhoneCallListRowBase;
import de.audi.app.phone.core.calllist.SingleCall;
import de.audi.app.phone.core.dsi.ITelDSIMobileEquipmentDeviceState;
import de.audi.app.phone.core.dsi.TelDefaultDSIResponseListener;
import de.audi.app.phone.core.state.IGlobalTelephoneStateStruct;
import de.audi.app.phone.core.util.PhoneUtils;
import de.audi.app.phone.core.util.TelLoggingUtils;
import de.audi.app.phone.evo.calllist.PhoneCallListRowEvo;
import de.audi.atip.hmi.model.BufferedListModel;
import de.audi.atip.hmi.model.ListListener;
import de.audi.atip.hmi.model.ModelGroup;
import de.audi.atip.hmi.modelaccess.ListModelApp;
import de.audi.atip.hmi.modelaccess.ResourceLocatorModelApp;
import org.dsi.ifc.global.ResourceLocator;

public class TelConferenceMemberListHandler
extends AbstractPhoneComponent
implements ListListener {
    private volatile IGlobalTelephoneStateStruct telephoneState;

    public TelConferenceMemberListHandler(ITelApplication iTelApplication) {
        super(iTelApplication, "App.Phone.Main");
    }

    public void init() {
        super.init();
        this.getApplication().getGlobalTelephoneStateManager().registerListener(this);
        this.getConferenceMemberList().setListListener(this);
        this.getConferenceMemberList().setMaxRows(3);
        this.getConferenceMemberList().setMaxColumns(14);
        this.getConferenceMemberList().setListListener(this);
        this.getResourceLocatorModel(300793).setStatus(0);
    }

    public void deinit() {
        super.deinit();
        this.getApplication().getGlobalTelephoneStateManager().removeListener(this);
        this.getConferenceMemberList().resetListener();
    }

    public void updateGlobalTelephoneStateProperty(int n, IGlobalTelephoneStateStruct iGlobalTelephoneStateStruct) {
        this.telephoneState = iGlobalTelephoneStateStruct;
        if (n == 65544 || n == 131080 || n == 196616) {
            this.updateConferenceMemberList(iGlobalTelephoneStateStruct);
        }
    }

    private void updateConferenceMemberList(IGlobalTelephoneStateStruct iGlobalTelephoneStateStruct) {
        BufferedListModel bufferedListModel = (BufferedListModel)this.getConferenceMemberList();
        try {
            ConferenceCall conferenceCall;
            ITelDSIMobileEquipmentDeviceState iTelDSIMobileEquipmentDeviceState;
            bufferedListModel.beginTransaction();
            bufferedListModel.clear();
            ITelDSIMobileEquipmentDeviceState iTelDSIMobileEquipmentDeviceState2 = iTelDSIMobileEquipmentDeviceState = iGlobalTelephoneStateStruct != null ? iGlobalTelephoneStateStruct.getCallLeadingDevice() : null;
            if (iTelDSIMobileEquipmentDeviceState != null && iTelDSIMobileEquipmentDeviceState.getCallState() != null && (conferenceCall = iTelDSIMobileEquipmentDeviceState.getCallState().getConferenceCall()) != null) {
                SingleCall[] singleCallArray = conferenceCall.getMembers();
                for (int i2 = 0; i2 < singleCallArray.length; ++i2) {
                    this.log.log(10000000, "[TelConferenceMemberListHandler#updateConferenceMemberList] member=%1", (Object)singleCallArray[i2]);
                    PhoneCallListRowEvo phoneCallListRowEvo = new PhoneCallListRowEvo(singleCallArray[i2], iGlobalTelephoneStateStruct, this.log);
                    bufferedListModel.addRow(phoneCallListRowEvo);
                }
            }
            bufferedListModel.endTransaction();
        }
        catch (Exception exception) {
            this.log.log(10000, "[TelConferenceMemberListHandler#updateConferenceMemberList] %1", (Throwable)exception);
        }
    }

    private ListModelApp getConferenceMemberList() {
        return this.getListModel(300675);
    }

    public void itemReleased(int n, int n2, int n3, int n4) {
    }

    public void itemSelected(int n, int n2, int n3, int n4) {
        if (n == this.getConferenceMemberList().getID()) {
            ITelDSIMobileEquipmentDeviceState iTelDSIMobileEquipmentDeviceState;
            ListModelApp listModelApp = this.getListModel(n);
            ITelDSIMobileEquipmentDeviceState iTelDSIMobileEquipmentDeviceState2 = iTelDSIMobileEquipmentDeviceState = this.telephoneState != null ? this.telephoneState.getCallLeadingDevice() : null;
            if (iTelDSIMobileEquipmentDeviceState != null && iTelDSIMobileEquipmentDeviceState.getCallState() != null && iTelDSIMobileEquipmentDeviceState.getCallState().isHasOnHoldConferenceCall()) {
                this.log.log(1000000, "[TelConferenceMemberListHandler#itemSelected] conference is on hold, not possible to remove member.");
                listModelApp.fireEvent(n4);
            } else {
                PhoneCallListRowBase phoneCallListRowBase = (PhoneCallListRowBase)listModelApp.getRow(n2);
                int n5 = phoneCallListRowBase.getCallID();
                final ModelGroup modelGroup = new ModelGroup();
                modelGroup.add(listModelApp);
                this.log.log(10000000, "[TelConferenceMemberListHandler#itemSelected] hanging up conference member with id %1", (long)n5);
                this.getChoiceModel(301021).setStatus(0);
                this.getApplication().getTelephoneDSIAccess().hangupCall(n5, n4, true, new TelDefaultDSIResponseListener(){

                    public void responseHangupCall(int n, int n2) {
                        TelConferenceMemberListHandler.this.log.log(1000000, "[TelConferenceMemberListHandler.itemSelected(...).new TelDefaultDSIResponseListener() {...}#responseHangupCall] result=%1", (long)n);
                        TelConferenceMemberListHandler.this.getChoiceModel(301021).setStatus(1);
                        modelGroup.flush();
                        modelGroup.removeAll();
                    }
                });
                listModelApp.fireEvent(n4);
            }
        }
    }

    public void itemFocused(int n, int n2, int n3, int n4) {
        if (n == this.getConferenceMemberList().getID()) {
            this.log.log(1000000, "[TelConferenceMemberListHandler#itemFocused] %1", (Object)TelLoggingUtils.itemFocused(n, n2, n3, n4));
            ResourceLocatorModelApp resourceLocatorModelApp = this.getResourceLocatorModel(300793);
            if (n2 >= 0) {
                PhoneCallListRowEvo phoneCallListRowEvo = (PhoneCallListRowEvo)this.getConferenceMemberList().getRow(n2);
                ResourceLocator resourceLocator = phoneCallListRowEvo.getPicture();
                if (PhoneUtils.isPictureAvailable(resourceLocator)) {
                    resourceLocatorModelApp.setResourceLocator(resourceLocator.getId(), resourceLocator.getUrl());
                    resourceLocatorModelApp.setStatus(1);
                } else {
                    resourceLocatorModelApp.setResourceLocator(-1, ResourceLocatorModelApp.UNDEFINED_URI);
                    resourceLocatorModelApp.setStatus(0);
                }
            } else {
                resourceLocatorModelApp.setResourceLocator(-1, ResourceLocatorModelApp.UNDEFINED_URI);
                resourceLocatorModelApp.setStatus(0);
            }
        }
    }
}

