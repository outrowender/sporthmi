/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.messaging.core.callback;

import de.audi.app.messaging.core.application.AbstractMsgApplication;
import de.audi.app.messaging.core.callback.CallbackNumberListRow;
import de.audi.app.messaging.core.component.AbstractMessagingComponent;
import de.audi.app.messaging.core.osgi.MessagingBundleContext;
import de.audi.app.messaging.core.util.PhoneServices;
import de.audi.app.messaging.core.util.Strings;
import de.audi.atip.hmi.model.DefaultButtonListener;
import de.audi.atip.hmi.model.DefaultListListener;
import de.audi.atip.hmi.modelaccess.ListModelApp;
import org.dsi.ifc.organizer.AdbEntry;
import org.dsi.ifc.organizer.PhoneData;

public final class CallbackNumberList
extends AbstractMessagingComponent {
    private final ListModelApp listModel;
    private AdbEntry adbEntry;
    private static final int ACTION_DIAL = 0;
    private static final int ACTION_PREPARE = 1;
    private static final int ACTION_DIAL_PORSCHE = 1;
    private static final int ACTION_PREPARE_PORSCHE = 0;

    public CallbackNumberList(MessagingBundleContext messagingBundleContext) {
        super(messagingBundleContext, "App.Messaging.Main");
        this.listModel = this.framework.getHmiServiceApp().getListModel(2200145);
    }

    public void init(AbstractMsgApplication abstractMsgApplication) {
        super.init(abstractMsgApplication);
        this.listModel.setMaxColumns(2);
        this.listModel.setMaxRows(5);
        this.listModel.setListListener(new MyListListener());
        MyButtonListener myButtonListener = new MyButtonListener();
        this.framework.getHmiServiceApp().getButtonModel(2200171).setButtonListener(myButtonListener);
        this.framework.getHmiServiceApp().getButtonModel(2200382).setButtonListener(myButtonListener);
        this.framework.getHmiServiceApp().getButtonModel(2200418).setButtonListener(myButtonListener);
    }

    public void clear() {
        this.listModel.clear();
    }

    public int getLength() {
        return this.listModel.getLength();
    }

    public void setContent(String string) {
        this.log.log(10000000, "[CallbackNumberList#setContent] phoneNumber = %1", (Object)string);
        this.adbEntry = null;
        PhoneData phoneData = new PhoneData(string, 0, -1);
        this.setPhoneData(new PhoneData[]{phoneData});
    }

    public void setContent(AdbEntry adbEntry) {
        this.log.log(10000000, "[CallbackNumberList#setContent] adbEntry = %1", (Object)adbEntry);
        this.adbEntry = adbEntry;
        this.setPhoneData(adbEntry.getPhoneData());
    }

    private void setPhoneData(PhoneData[] phoneDataArray) {
        this.log.log(10000000, "[CallbackNumberList#setPhoneData]");
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
        this.log.log(10000000, "[CallbackNumberList#callNumber] rowIndex = %1", (long)n);
        CallbackNumberListRow callbackNumberListRow = (CallbackNumberListRow)this.listModel.getRow(n);
        String string = callbackNumberListRow.getNumber();
        if (this.adbEntry == null) {
            PhoneServices.callUnmatchedNumber(string, this.log, this.msgApp);
        } else {
            PhoneServices.callMatchedNumber(string, this.adbEntry, n, this.log, this.msgApp);
        }
    }

    private void prepareNumber(int n) {
        this.log.log(10000000, "[CallbackNumberList#prepareNumber] rowIndex = %1", (long)n);
        CallbackNumberListRow callbackNumberListRow = (CallbackNumberListRow)this.listModel.getRow(n);
        String string = callbackNumberListRow.getNumber();
        if (this.adbEntry == null) {
            PhoneServices.prepareUnmatchedNumber(string, this.log, this.msgApp);
        } else {
            PhoneServices.prepareMatchedNumber(string, this.adbEntry, n, this.log, this.msgApp);
        }
    }

    private void callbackButton(int n, int n2, boolean bl) {
        this.log.log(1000000, "[CallbackNumberList#callbackButton] modelID = %1", (long)n);
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
            this.log.log(100000, "[CallbackNumberList#callbackButton] No callback number available.");
        }
    }

    private class MyListListener
    extends DefaultListListener {
        private MyListListener() {
        }

        public void itemSelected(int n, int n2, int n3, int n4) {
            CallbackNumberList.this.log.log(1000000, "[CallbackNumberList#itemSelected] row = %1, col = %2", (long)n2, (long)n3);
            CallbackNumberList.this.callNumber(n2, n3);
        }
    }

    private class MyButtonListener
    extends DefaultButtonListener {
        private MyButtonListener() {
        }

        public void keyTyped(int n, int n2, int n3) {
            if (n == 2200171 || n == 2200382 || n == 2200418) {
                CallbackNumberList.this.callbackButton(n, n3, n != 2200418);
            } else {
                CallbackNumberList.this.log.log(10000, "[CallbackNumberList#keyTyped] Unexpected modelID = %1", (long)n);
            }
        }
    }
}

