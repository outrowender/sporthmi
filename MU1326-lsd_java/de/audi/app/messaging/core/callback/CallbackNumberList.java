/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.messaging.core.callback;

import de.audi.app.messaging.core.application.AbstractMsgApplication;
import de.audi.app.messaging.core.callback.CallbackNumberList$MyButtonListener;
import de.audi.app.messaging.core.callback.CallbackNumberList$MyListListener;
import de.audi.app.messaging.core.callback.CallbackNumberListRow;
import de.audi.app.messaging.core.component.AbstractMessagingComponent;
import de.audi.app.messaging.core.osgi.MessagingBundleContext;
import de.audi.app.messaging.core.util.PhoneServices;
import de.audi.app.messaging.core.util.Strings;
import de.audi.atip.hmi.modelaccess.ListModelApp;
import de.audi.atip.log.LogChannel;
import org.dsi.ifc.organizer.AdbEntry;
import org.dsi.ifc.organizer.PhoneData;

public final class CallbackNumberList
extends AbstractMessagingComponent {
    private final ListModelApp listModel;
    private AdbEntry adbEntry;
    private static final int ACTION_DIAL;
    private static final int ACTION_PREPARE;
    private static final int ACTION_DIAL_PORSCHE;
    private static final int ACTION_PREPARE_PORSCHE;

    public CallbackNumberList(MessagingBundleContext messagingBundleContext) {
        super(messagingBundleContext, "App.Messaging.Main");
        this.listModel = this.framework.getHmiServiceApp().getListModel(1368531200);
    }

    @Override
    public void init(AbstractMsgApplication abstractMsgApplication) {
        super.init(abstractMsgApplication);
        this.listModel.setMaxColumns(2);
        this.listModel.setMaxRows(5);
        this.listModel.setListListener(new CallbackNumberList$MyListListener(this, null));
        CallbackNumberList$MyButtonListener callbackNumberList$MyButtonListener = new CallbackNumberList$MyButtonListener(this, null);
        this.framework.getHmiServiceApp().getButtonModel(1804738816).setButtonListener(callbackNumberList$MyButtonListener);
        this.framework.getHmiServiceApp().getButtonModel(1049829632).setButtonListener(callbackNumberList$MyButtonListener);
        this.framework.getHmiServiceApp().getButtonModel(1653809408).setButtonListener(callbackNumberList$MyButtonListener);
    }

    public void clear() {
        this.listModel.clear();
    }

    public int getLength() {
        return this.listModel.getLength();
    }

    public void setContent(String string) {
        this.log.log(-2137614336, "[CallbackNumberList#setContent] phoneNumber = %1", (Object)string);
        this.adbEntry = null;
        PhoneData phoneData = new PhoneData(string, 0, -1);
        this.setPhoneData(new PhoneData[]{phoneData});
    }

    public void setContent(AdbEntry adbEntry) {
        this.log.log(-2137614336, "[CallbackNumberList#setContent] adbEntry = %1", (Object)adbEntry);
        this.adbEntry = adbEntry;
        this.setPhoneData(adbEntry.getPhoneData());
    }

    private void setPhoneData(PhoneData[] phoneDataArray) {
        this.log.log(-2137614336, "[CallbackNumberList#setPhoneData]");
        this.listModel.clear();
        for (int i2 = 0; i2 < phoneDataArray.length; ++i2) {
            if (Strings.isNullOrEmpty(phoneDataArray[i2].getNumber()) || !Strings.isValidNumber(phoneDataArray[i2].getNumber())) continue;
            CallbackNumberListRow callbackNumberListRow = new CallbackNumberListRow(phoneDataArray[i2]);
            this.listModel.addRow(callbackNumberListRow);
        }
    }

    private void callNumber(int n, int n2) {
        if (this.framework.getSysConst(4168) == 7 || this.framework.getSysConst(4168) == 5) {
            this.proceedActionForPorsche(n, n2);
        } else {
            this.proceedActionForAudi(n, n2);
        }
    }

    private void proceedActionForPorsche(int n, int n2) {
        if (n2 == 1) {
            this.callNumber(n);
        } else if (n2 == 0) {
            this.prepareNumber(n);
        }
    }

    private void proceedActionForAudi(int n, int n2) {
        if (n2 == 0) {
            this.callNumber(n);
        } else if (n2 == 1) {
            this.prepareNumber(n);
        }
    }

    private void callNumber(int n) {
        this.log.log(-2137614336, "[CallbackNumberList#callNumber] rowIndex = %1", (long)n);
        CallbackNumberListRow callbackNumberListRow = (CallbackNumberListRow)this.listModel.getRow(n);
        String string = callbackNumberListRow.getNumber();
        if (this.adbEntry == null) {
            PhoneServices.callUnmatchedNumber(string, this.log, this.msgApp);
        } else {
            PhoneServices.callMatchedNumber(string, this.adbEntry, n, this.log, this.msgApp);
        }
    }

    private void prepareNumber(int n) {
        this.log.log(-2137614336, "[CallbackNumberList#prepareNumber] rowIndex = %1", (long)n);
        CallbackNumberListRow callbackNumberListRow = (CallbackNumberListRow)this.listModel.getRow(n);
        String string = callbackNumberListRow.getNumber();
        if (this.adbEntry == null) {
            PhoneServices.prepareUnmatchedNumber(string, this.log, this.msgApp);
        } else {
            PhoneServices.prepareMatchedNumber(string, this.adbEntry, n, this.log, this.msgApp);
        }
    }

    private void callbackButton(int n, int n2, boolean bl) {
        this.log.log(1078071040, "[CallbackNumberList#callbackButton] modelID = %1", (long)n);
        int n3 = this.listModel.getLength();
        if (n3 > 1) {
            this.framework.getHmiServiceApp().getModelApp(n).fireEvent(n2);
        } else if (n3 == 1) {
            if (bl) {
                this.callNumber(0);
            } else {
                this.prepareNumber(0);
            }
        } else {
            this.log.log(-1601830656, "[CallbackNumberList#callbackButton] No callback number available.");
        }
    }

    static /* synthetic */ LogChannel access$200(CallbackNumberList callbackNumberList) {
        return callbackNumberList.log;
    }

    static /* synthetic */ void access$300(CallbackNumberList callbackNumberList, int n, int n2) {
        callbackNumberList.callNumber(n, n2);
    }

    static /* synthetic */ void access$400(CallbackNumberList callbackNumberList, int n, int n2, boolean bl) {
        callbackNumberList.callbackButton(n, n2, bl);
    }

    static /* synthetic */ LogChannel access$500(CallbackNumberList callbackNumberList) {
        return callbackNumberList.log;
    }
}

