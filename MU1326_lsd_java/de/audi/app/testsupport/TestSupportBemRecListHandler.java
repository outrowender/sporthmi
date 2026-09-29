/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.testsupport;

import de.audi.app.testsupport.TestSupportReceiverSession;
import de.audi.app.testsupport.TestSupportReceiverSessionHandler;
import de.audi.atip.base.IFrameworkAccess;
import de.audi.atip.hmi.model.list.BaseListModelApp;
import de.audi.atip.hmi.model.list.BaseListModelListener;
import de.audi.atip.hmi.model.list.EvoListRow;
import de.audi.atip.hmi.modelaccess.LabelModelApp;
import de.audi.atip.log.LogChannel;
import de.audi.atip.testsupport.ITestSupportDataReceiver;
import de.audi.atip.testsupport.TestSupportDataReceiverEntry;

public class TestSupportBemRecListHandler
implements BaseListModelListener {
    private final LogChannel logChannel;
    private final IFrameworkAccess frameworkAccess;
    private BaseListModelApp receiversListModel;
    private BaseListModelApp receiversDataModel;
    private LabelModelApp receiverNameModel;
    private TestSupportReceiverSessionHandler sessionHandler;
    private final Object mutex = new Object();
    private static final int RECEIVERS_LIST_COLUMNS;
    private static final int RECEIVERS_LIST_COL_NAME;
    private static final int RECEIVERS_LIST_COL_ID;
    private static final int RECEIVER_DETAILS_LIST_COLUMNS;
    private static final int RECEIVER_DETAILS_LIST_COL_TEXT;
    private static final int RECEIVER_DETAILS_LIST_COL_CHECKBOX;
    private static final int RECEIVER_DETAILS_LIST_COL_ENTRYID;
    private static final int RECEIVER_DETAILS_LIST_COL_LLD;
    private static final int RECEIVER_DETAILS_LIST_LLD_ACTION;
    private static final int RECEIVER_DETAILS_LIST_LLD_CHECKBOX;
    private volatile int currentSelectedReceiverID;

    public TestSupportBemRecListHandler(IFrameworkAccess iFrameworkAccess, LogChannel logChannel) {
        this.logChannel = logChannel;
        this.frameworkAccess = iFrameworkAccess;
    }

    protected void init() {
        this.receiversListModel = this.frameworkAccess.getHmiServiceApp().getBaseListModel(144647168);
        this.receiversDataModel = this.frameworkAccess.getHmiServiceApp().getBaseListModel(127869952);
        this.receiverNameModel = this.frameworkAccess.getHmiServiceApp().getLabelModel(161424384);
        this.receiversListModel.setListener(this);
        this.receiversDataModel.setListener(this);
    }

    protected void deinit() {
        this.receiversListModel.resetListener();
        this.receiversDataModel.resetListener();
    }

    protected void setSessionHandler(TestSupportReceiverSessionHandler testSupportReceiverSessionHandler) {
        this.sessionHandler = testSupportReceiverSessionHandler;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    protected void addReceiverEntry(int n, String string) {
        Object object = this.mutex;
        synchronized (object) {
            EvoListRow evoListRow = new EvoListRow(n, 2);
            evoListRow.setText(0, string);
            evoListRow.setInteger(1, n);
            this.receiversListModel.append(evoListRow);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    protected void removeReceiverEntry(int n) {
        Object object = this.mutex;
        synchronized (object) {
            this.receiversListModel.remove(n);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void entriesUpdated(int n) {
        Object object = this.mutex;
        synchronized (object) {
            if (this.currentSelectedReceiverID == n) {
                this.updateReceiverDetails(n);
            }
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private void receiverSelected(int n) {
        Object object = this.mutex;
        synchronized (object) {
            this.currentSelectedReceiverID = n;
            String string = this.sessionHandler.getSession(n).getReceiver().getName();
            this.receiverNameModel.setText(string != null && string.length() > 0 ? string : new StringBuffer().append("UNKNOWN RECEIVER, ID: ").append(n).toString());
            this.updateReceiverDetails(n);
            this.receiversListModel.fireEvent(0);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private void entrySelected(int n) {
        Object object = this.mutex;
        synchronized (object) {
            try {
                ITestSupportDataReceiver iTestSupportDataReceiver = this.sessionHandler.getSession(this.currentSelectedReceiverID).getReceiver();
                iTestSupportDataReceiver.entrySelected(n);
            }
            catch (Exception exception) {
                this.logChannel.log(-1601830656, "[TestSupportBemRdcHandler#entrySelected] exception occured", (Throwable)exception);
            }
        }
    }

    private void updateReceiverDetails(int n) {
        TestSupportReceiverSession testSupportReceiverSession = this.sessionHandler.getSession(n);
        ITestSupportDataReceiver iTestSupportDataReceiver = testSupportReceiverSession.getReceiver();
        TestSupportDataReceiverEntry[] testSupportDataReceiverEntryArray = iTestSupportDataReceiver.getEntries();
        this.receiversDataModel.removeAll();
        if (testSupportDataReceiverEntryArray.length != 0) {
            for (int i2 = 0; i2 < testSupportDataReceiverEntryArray.length; ++i2) {
                EvoListRow evoListRow = new EvoListRow(testSupportDataReceiverEntryArray[i2].getId(), 4);
                evoListRow.setInteger(3, testSupportDataReceiverEntryArray[i2].isCheckBox() ? 1 : 0);
                evoListRow.setText(0, testSupportDataReceiverEntryArray[i2].getDescription());
                evoListRow.setInteger(2, testSupportDataReceiverEntryArray[i2].getId());
                evoListRow.setInteger(1, testSupportDataReceiverEntryArray[i2].isChecked() ? 1 : 0);
                this.receiversDataModel.append(evoListRow);
            }
        }
    }

    @Override
    public void itemSelected(EvoListRow evoListRow, int n, int n2, int n3, int n4) {
        this.logChannel.log(1078071040, "[TestSupportBemRdcHandler#itemSelected] modelID='%1', row='%2'", (Object)Integer.toString(n), (Object)evoListRow.toString());
        switch (n) {
            case 2400008: {
                this.receiverSelected(this.getSessionIDofRow(evoListRow));
                break;
            }
            case 2400007: {
                this.entrySelected(this.getEntryIDofRow(evoListRow));
                break;
            }
        }
    }

    @Override
    public void itemReleased(EvoListRow evoListRow, int n, int n2, int n3, int n4) {
    }

    @Override
    public void itemLongSelected(EvoListRow evoListRow, int n, int n2, int n3, int n4) {
    }

    @Override
    public void itemFocused(EvoListRow evoListRow, int n, int n2, int n3, int n4) {
    }

    private int getSessionIDofRow(EvoListRow evoListRow) {
        return (Integer)evoListRow.getCell(1);
    }

    private int getEntryIDofRow(EvoListRow evoListRow) {
        return (Integer)evoListRow.getCell(2);
    }
}

