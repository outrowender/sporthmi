/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.testsupport;

import de.audi.app.testsupport.TestSupportIDGenerator;
import de.audi.app.testsupport.TestSupportSession;
import de.audi.app.testsupport.TestSupportSessionHandler;
import de.audi.atip.base.IFrameworkAccess;
import de.audi.atip.hmi.model.ChoiceListener;
import de.audi.atip.hmi.model.list.BaseListModelApp;
import de.audi.atip.hmi.model.list.BaseListModelListener;
import de.audi.atip.hmi.model.list.EvoListRow;
import de.audi.atip.hmi.modelaccess.ChoiceModelApp;
import de.audi.atip.hmi.modelaccess.LabelModelApp;
import de.audi.atip.log.LogChannel;

public class TestSupportBemProvListHandler
implements BaseListModelListener,
ChoiceListener {
    private final LogChannel logChannel;
    private static final int PROVIDERS_LIST_COLUMNS;
    private static final int PROVIDERS_LIST_COL_NAME;
    private static final int PROVIDERS_LIST_COL_ID;
    private static final int PROVIDER_DETAILS_LIST_COLUMNS;
    private static final int PROVIDER_DETAILS_LIST_COL_TEXT;
    private static final int CHECKBOX_OFF;
    private static final int CHECKBOX_ON;
    private BaseListModelApp providersListModel;
    private BaseListModelApp providersDataModel;
    private ChoiceModelApp providersOsoSelectionModel;
    private ChoiceModelApp providersListSelectionModel;
    private LabelModelApp providersDetailLabelModel;
    private volatile int currentSelectedProvider;
    private TestSupportSessionHandler sessionHandler;
    private final Object mutex = new Object();
    private final IFrameworkAccess frameworkAccess;
    private final TestSupportIDGenerator idGenerator = new TestSupportIDGenerator();

    protected TestSupportBemProvListHandler(IFrameworkAccess iFrameworkAccess, LogChannel logChannel) {
        this.logChannel = logChannel;
        this.frameworkAccess = iFrameworkAccess;
    }

    protected void setSessionHandler(TestSupportSessionHandler testSupportSessionHandler) {
        this.sessionHandler = testSupportSessionHandler;
    }

    protected void init() {
        this.logChannel.log(1078071040, "[TestSupportBEMHandler#init]");
        this.providersListModel = this.frameworkAccess.getHmiServiceApp().getBaseListModel(111092736);
        this.providersDataModel = this.frameworkAccess.getHmiServiceApp().getBaseListModel(94315520);
        this.providersOsoSelectionModel = this.frameworkAccess.getHmiServiceApp().getChoiceModel(60761088);
        this.providersListSelectionModel = this.frameworkAccess.getHmiServiceApp().getChoiceModel(77538304);
        this.providersDetailLabelModel = this.frameworkAccess.getHmiServiceApp().getLabelModel(27206656);
        this.providersListModel.setListener(this);
        this.providersOsoSelectionModel.setChoiceListener(this);
        this.providersListSelectionModel.setChoiceListener(this);
    }

    protected void deinit() {
        this.logChannel.log(1078071040, "[TestSupportBEMHandler#deinit]");
        this.providersListModel.resetListener();
        this.providersOsoSelectionModel.resetListener();
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    protected void addMenuEntry(int n, String string) {
        this.logChannel.log(1078071040, "[TestSupportBemRdvHandler#addMenuEntry] id='%2', name='%1'", (Object)string, (long)n);
        EvoListRow evoListRow = new EvoListRow(n, 2);
        evoListRow.setText(1, string);
        evoListRow.setInteger(0, n);
        Object object = this.mutex;
        synchronized (object) {
            this.providersListModel.append(evoListRow);
        }
    }

    protected void removeMenuEntry(int n) {
        this.logChannel.log(1078071040, "[TestSupportBemRdvHandler#removeMenuEntry] id='%1'", (long)n);
        this.sessionHandler.getSession(n).setStatus(1);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    protected void updateData(int n) {
        this.logChannel.log(1078071040, "[TestSupportBemRdvHandler#updateData] id='%1'", (long)n);
        Object object = this.mutex;
        synchronized (object) {
            TestSupportSession testSupportSession;
            if (n == this.currentSelectedProvider && ((testSupportSession = this.sessionHandler.getSession(this.currentSelectedProvider)).getStatus() == 2 || testSupportSession.getStatus() == 3)) {
                this.fillListWithCurrentData();
            }
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private void providerSelected(EvoListRow evoListRow) {
        this.logChannel.log(1078071040, "[TestSupportBemRdvHandler#providerSelected] row='%1'", (Object)evoListRow);
        Object object = this.mutex;
        synchronized (object) {
            this.currentSelectedProvider = this.getProviderIDofRow(evoListRow);
            TestSupportSession testSupportSession = this.sessionHandler.getSession(this.currentSelectedProvider);
            if (testSupportSession.getStatus() == 2) {
                this.fillListWithCurrentData();
                this.providersListSelectionModel.setValue(1);
                this.providersOsoSelectionModel.setValue(0);
            } else if (testSupportSession.getStatus() == 3) {
                this.fillListWithCurrentData();
                this.providersListSelectionModel.setValue(1);
                this.providersOsoSelectionModel.setValue(1);
            } else {
                this.providersListSelectionModel.setValue(0);
                this.providersOsoSelectionModel.setValue(0);
                this.clearList();
            }
            this.providersDetailLabelModel.setText(testSupportSession.getProvider().getDataProviderName());
        }
        this.providersListModel.fireEvent(0);
    }

    private void fillListWithCurrentData() {
        int n;
        String[] stringArray = this.sessionHandler.getSession(this.currentSelectedProvider).getData();
        if (this.logChannel.isInfo()) {
            for (n = 0; n < stringArray.length; ++n) {
                this.logChannel.log(1078071040, "[TestSupportBemRdvHandler#fillListWithCurrentData] line %2 = '%1'", (Object)stringArray[n], (long)n);
            }
        }
        this.clearList();
        this.idGenerator.reset();
        for (n = 0; n < stringArray.length; ++n) {
            EvoListRow evoListRow = new EvoListRow(this.idGenerator.getID(), 2);
            evoListRow.setText(1, stringArray[n]);
            this.providersDataModel.append(evoListRow);
        }
    }

    private void clearList() {
        this.providersDataModel.removeAll();
    }

    private void osoSelected(boolean bl) {
        this.logChannel.log(1078071040, "[TestSupportBemRdvHandler#osoSelected] selected='%1'", bl);
        this.providersOsoSelectionModel.setValue(bl ? 1 : 0);
        this.sessionHandler.getSession(this.currentSelectedProvider).setStatus(bl ? 3 : 2);
        this.sessionHandler.updateOSOStatus(this.currentSelectedProvider);
        if (this.providersListSelectionModel.getValue() == 0 && bl) {
            this.providersListSelectionModel.setValue(1);
            this.fillListWithCurrentData();
        }
    }

    private void olsSelected(boolean bl) {
        this.logChannel.log(1078071040, "[TestSupportBemRdvHandler#olsSelected] selected='%1'", bl);
        TestSupportSession testSupportSession = this.sessionHandler.getSession(this.currentSelectedProvider);
        int n = testSupportSession.getStatus();
        testSupportSession.setStatus(bl ? 2 : 1);
        if (!bl && n == 3) {
            this.providersOsoSelectionModel.setValue(0);
            this.sessionHandler.updateOSOStatus(this.currentSelectedProvider);
        }
        this.providersListSelectionModel.setValue(bl ? 1 : 0);
        if (bl) {
            this.fillListWithCurrentData();
        } else {
            this.clearList();
        }
    }

    @Override
    public void keyPressed(int n, int n2, int n3) {
    }

    @Override
    public void keyReleased(int n, int n2, int n3) {
    }

    @Override
    public void keyTyped(int n, int n2, int n3) {
    }

    @Override
    public void keyLongTyped(int n, int n2, int n3) {
    }

    @Override
    public void itemFocused(int n, int n2, int n3, int n4) {
    }

    @Override
    public void itemSelected(int n, int n2, int n3, int n4) {
        this.logChannel.log(1078071040, "[TestSupportBemRdvHandler#itemSelected] modelID='%1', row='%2'", (long)n, (long)n2);
        switch (n) {
            case 2400004: {
                this.olsSelected(n2 == 1);
                break;
            }
            case 2400003: {
                this.osoSelected(n2 == 1);
                break;
            }
        }
    }

    @Override
    public void itemReleased(EvoListRow evoListRow, int n, int n2, int n3, int n4) {
    }

    @Override
    public void itemSelected(EvoListRow evoListRow, int n, int n2, int n3, int n4) {
        this.logChannel.log(1078071040, "[TestSupportBemRdvHandler#itemSelected] (2) modelID='%1', row='%2'", (Object)Integer.toString(n), (Object)evoListRow.toString());
        switch (n) {
            case 2400006: {
                this.providerSelected(evoListRow);
                break;
            }
        }
    }

    @Override
    public void itemLongSelected(EvoListRow evoListRow, int n, int n2, int n3, int n4) {
    }

    @Override
    public void itemFocused(EvoListRow evoListRow, int n, int n2, int n3, int n4) {
    }

    private int getProviderIDofRow(EvoListRow evoListRow) {
        return (Integer)evoListRow.getCell(0);
    }

    public IFrameworkAccess getFramework() {
        return this.frameworkAccess;
    }
}

