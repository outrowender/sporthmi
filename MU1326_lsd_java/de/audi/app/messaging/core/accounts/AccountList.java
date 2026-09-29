/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.messaging.core.accounts;

import de.audi.app.messaging.core.accounts.AbstractAccountListRow;
import de.audi.app.messaging.core.accounts.AccountList$AccountManagerListener;
import de.audi.app.messaging.core.accounts.AccountList$EntryListObserver;
import de.audi.app.messaging.core.accounts.AccountList$MyDsiMessagingListener;
import de.audi.app.messaging.core.accounts.AccountList$MyListListener;
import de.audi.app.messaging.core.accounts.AccountList$SetupManagerObserver;
import de.audi.app.messaging.core.accounts.AccountTooltipRow;
import de.audi.app.messaging.core.accounts.Accounts;
import de.audi.app.messaging.core.accounts.CoreAccountListRowFactory;
import de.audi.app.messaging.core.accounts.IAccountFilter;
import de.audi.app.messaging.core.accounts.IAccountListObserver;
import de.audi.app.messaging.core.accounts.IAccountListRowFactory;
import de.audi.app.messaging.core.application.AbstractMsgApplication;
import de.audi.app.messaging.core.component.AbstractMessagingComponent;
import de.audi.app.messaging.core.concurrent.CopyOnWriteArrayList;
import de.audi.app.messaging.core.osgi.IServiceRegistry;
import de.audi.app.messaging.core.osgi.MessagingBundleContext;
import de.audi.app.messaging.core.osgi.ServiceProperties;
import de.audi.app.messaging.core.util.Arrays;
import de.audi.app.messaging.core.util.Logs;
import de.audi.atip.base.IFrameworkAccess;
import de.audi.atip.hmi.model.ListRow;
import de.audi.atip.hmi.model.ModelGroup;
import de.audi.atip.hmi.model.list.BaseListModelApp;
import de.audi.atip.hmi.modelaccess.TooltipModelApp;
import de.audi.atip.interapp.messaging.devicerole.DeviceRoleInfo;
import de.audi.atip.interapp.messaging.devicerole.IDeviceRoleObserver;
import de.audi.atip.log.LogChannel;
import de.esolutions.fw.util.commons.Buffer;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import org.dsi.ifc.messaging.MessagingAccount;

public final class AccountList
extends AbstractMessagingComponent
implements IDeviceRoleObserver {
    public static final String INSTANCE_DIALOG;
    public static final String INSTANCE_SMS;
    public static final String INSTANCE_E_MAIL;
    private final String instanceId;
    private final BaseListModelApp listModel;
    private final CopyOnWriteArrayList accountListObservers = new CopyOnWriteArrayList();
    private final TooltipModelApp tooltipModel;
    private MessagingAccount[] accounts = new MessagingAccount[0];
    private final Set accountFilterSet = new HashSet();
    private MessagingAccount selectedAccount = null;
    private volatile boolean isFolderContentListBusy = false;
    private IAccountListRowFactory accountListRowFactory;
    private int numSmsAccounts;
    private int numEmailAccounts;
    private int numSendSmsAccounts;
    private int numSendEmailAccounts;
    private DeviceRoleInfo primaryDevice;
    private volatile boolean isSendSmsSupportedByPrimaryDevice = false;
    private volatile boolean isSendEmailSupportedByPrimaryDevice = false;
    static /* synthetic */ Class class$de$audi$atip$interapp$messaging$devicerole$IDeviceRoleObserver;

    public AccountList(MessagingBundleContext messagingBundleContext, BaseListModelApp baseListModelApp, String string) {
        super(messagingBundleContext, "App.Messaging.Main");
        this.instanceId = string;
        this.tooltipModel = this.framework.getHmiServiceApp().getTooltipModel(1318199552);
        this.listModel = baseListModelApp;
        this.accountListRowFactory = new CoreAccountListRowFactory();
    }

    @Override
    public void init(AbstractMsgApplication abstractMsgApplication) {
        this.msgApp = abstractMsgApplication;
        super.init(abstractMsgApplication);
        this.tooltipModel.setMaxColumns(5);
        this.tooltipModel.setMaxRows(2);
        this.listModel.setListener(new AccountList$MyListListener(this, null));
        abstractMsgApplication.getSetupManager().addObserver(new AccountList$SetupManagerObserver(this, null));
        abstractMsgApplication.getEntryList().addObserver(new AccountList$EntryListObserver(this, null));
        abstractMsgApplication.getAccountManager().addListener(new AccountList$AccountManagerListener(this, null));
        abstractMsgApplication.getDsiMessagingPrimaryListener().addSubscriber(new AccountList$MyDsiMessagingListener(this, null));
    }

    public void addObserver(IAccountListObserver iAccountListObserver) {
        this.log.log(-2137614336, "[AccountList(%1)#addObserver] observer = %2", (Object)this.instanceId, (Object)iAccountListObserver);
        this.accountListObservers.add(iAccountListObserver);
    }

    @Override
    public void connect(IServiceRegistry iServiceRegistry) {
        super.connect(iServiceRegistry);
        iServiceRegistry.registerService((class$de$audi$atip$interapp$messaging$devicerole$IDeviceRoleObserver == null ? (class$de$audi$atip$interapp$messaging$devicerole$IDeviceRoleObserver = AccountList.class$("de.audi.atip.interapp.messaging.devicerole.IDeviceRoleObserver")) : class$de$audi$atip$interapp$messaging$devicerole$IDeviceRoleObserver).getName(), (Object)this, ServiceProperties.createServiceProperties());
    }

    public int getLength() {
        return this.listModel.getLength();
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public boolean contains(int n) {
        Object object = this.messagingBundleContext.getMessagingHmiLock();
        synchronized (object) {
            boolean bl = false;
            for (int i2 = 0; i2 < this.getLength(); ++i2) {
                MessagingAccount messagingAccount = this.getAccountByRowIndex(i2);
                if (messagingAccount == null || messagingAccount.getAccountID() != n) continue;
                bl = true;
                break;
            }
            return bl;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public boolean addAccountFilter(IAccountFilter iAccountFilter) {
        Object object = this.messagingBundleContext.getMessagingHmiLock();
        synchronized (object) {
            boolean bl = false;
            if (iAccountFilter == null) {
                this.log.log(-2137614336, "[AccountList(%1)#addAccountFilter] accountFilter = %2", (Object)this.instanceId, (Object)String.valueOf(iAccountFilter));
            } else {
                if (this.log.isDebug()) {
                    this.log.log(-2137614336, "[AccountList(%1)#addAccountFilter] System.identityHashCode(accountFilter) = %2, accountFilter.getDescription() = %3", (Object)this.instanceId, (Object)String.valueOf(System.identityHashCode(iAccountFilter)), (Object)iAccountFilter.getDescription());
                }
                bl = this.accountFilterSet.add(iAccountFilter);
                this.refresh();
            }
            return bl;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public boolean removeAccountFilter(IAccountFilter iAccountFilter) {
        Object object = this.messagingBundleContext.getMessagingHmiLock();
        synchronized (object) {
            boolean bl = false;
            if (iAccountFilter == null) {
                this.log.log(-2137614336, "[AccountList(%1)#addAccountFilter] accountFilter = %2", (Object)this.instanceId, (Object)String.valueOf(iAccountFilter));
            } else {
                if (this.log.isDebug()) {
                    this.log.log(-2137614336, "[AccountList(%1)#removeAccountFilter] System.identityHashCode(accountFilter) = %2, accountFilter.getDescription() = %3", (Object)this.instanceId, (Object)String.valueOf(System.identityHashCode(iAccountFilter)), (Object)iAccountFilter.getDescription());
                }
                bl = this.accountFilterSet.remove(iAccountFilter);
                this.refresh();
            }
            return bl;
        }
    }

    private boolean isAcceptedByFilters(MessagingAccount messagingAccount) {
        boolean bl = true;
        Iterator iterator = this.accountFilterSet.iterator();
        while (iterator.hasNext()) {
            IAccountFilter iAccountFilter = (IAccountFilter)iterator.next();
            if (iAccountFilter.accept(messagingAccount)) continue;
            bl = false;
            break;
        }
        return bl;
    }

    public MessagingAccount getAccountByRowIndex(int n) {
        MessagingAccount messagingAccount = null;
        if (n >= 0 && n < this.listModel.getLength()) {
            messagingAccount = this.getAccountListRow(n).getMessagingAccount();
        }
        return messagingAccount;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public int getRowIndexByAccount(MessagingAccount messagingAccount) {
        Object object = this.messagingBundleContext.getMessagingHmiLock();
        synchronized (object) {
            int n = -1;
            if (messagingAccount != null) {
                for (int i2 = 0; i2 < this.getLength(); ++i2) {
                    MessagingAccount messagingAccount2 = this.getAccountByRowIndex(i2);
                    if (messagingAccount2.getAccountID() != messagingAccount.getAccountID()) continue;
                    n = i2;
                    break;
                }
            }
            return n;
        }
    }

    public void selectAccount(int n) {
        if (n >= 0 && n < this.getLength()) {
            this.setSelection(n, false);
            MessagingAccount messagingAccount = this.getAccountByRowIndex(n);
            int n2 = messagingAccount.getAccountID();
            if (this.log.isDebug()) {
                this.log.log(-2137614336, "[AccountList(%1)#accountSelected] index = %2, accountID = %3", (Object)this.instanceId, (long)n, (long)n2);
            }
            this.msgApp.getAccountManager().selectAccount(n2);
            this.emitIndicateItemSelected(messagingAccount);
        } else {
            this.log.log(10000, "[AccountList(%1)#accountSelected] No list row at index = %2", (Object)this.instanceId, (long)n);
        }
    }

    public void selectFirstAccount(int n) {
        this.log.log(-2137614336, "[AccountList(%1)#selectFirstAccount] accType = %2", (Object)this.instanceId, (long)n);
        for (int i2 = 0; i2 < this.listModel.getLength(); ++i2) {
            MessagingAccount messagingAccount = this.getAccountByRowIndex(i2);
            if (!Accounts.supportsSend(messagingAccount) || n != 0 && (n != 1 || !Accounts.supportsSms(messagingAccount)) && (n != 2 || !messagingAccount.isSupportsEMail())) continue;
            this.selectAccount(i2);
            break;
        }
    }

    public String toString() {
        Object[] objectArray = new MessagingAccount[this.listModel.getLength()];
        for (int i2 = 0; i2 < this.listModel.getLength(); ++i2) {
            objectArray[i2] = this.getAccountByRowIndex(i2);
        }
        Buffer buffer = new Buffer();
        buffer.append("AccountList {instanceId = ");
        buffer.append(this.instanceId);
        buffer.append(", list entries = ");
        buffer.append(Arrays.toMultiLineString(objectArray));
        buffer.append('}');
        return buffer.toString();
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void refresh() {
        Object object = this.messagingBundleContext.getMessagingHmiLock();
        synchronized (object) {
            this.log.log(-2137614336, "[AccountList(%1)#refresh] instanceID=%1", (Object)this.instanceId);
            this.countTheNumberOfSMSndEMailAccountsThatPassCurrentAccountFilter(this.accounts);
            this.updateIsSMSorEMAILSupportedByThePrimaryModels(this.isSendSmsSupportedByPrimaryDevice, this.isSendEmailSupportedByPrimaryDevice);
            this.fillAccountListModelWithAccountsPassingCurrentFilter(this.accounts);
        }
    }

    public void setRowFactory(IAccountListRowFactory iAccountListRowFactory) {
        this.accountListRowFactory = iAccountListRowFactory;
    }

    private void countTheNumberOfSMSndEMailAccountsThatPassCurrentAccountFilter(MessagingAccount[] messagingAccountArray) {
        this.numSmsAccounts = 0;
        this.numEmailAccounts = 0;
        this.numSendSmsAccounts = 0;
        this.numSendEmailAccounts = 0;
        this.isSendSmsSupportedByPrimaryDevice = false;
        this.isSendEmailSupportedByPrimaryDevice = false;
        if (messagingAccountArray != null) {
            for (int i2 = 0; i2 < messagingAccountArray.length; ++i2) {
                boolean bl;
                boolean bl2;
                MessagingAccount messagingAccount = messagingAccountArray[i2];
                if (messagingAccount == null || !this.isAcceptedByFilters(messagingAccount)) continue;
                if (messagingAccount.isSupportsEMail()) {
                    ++this.numEmailAccounts;
                    if (!Accounts.supportsSend(messagingAccount)) continue;
                    ++this.numSendEmailAccounts;
                    boolean bl3 = bl2 = this.primaryDevice != null ? messagingAccount.getBtDeviceAddress().equals(this.primaryDevice.getBtDeviceAddress()) : false;
                    if (!bl2) continue;
                    this.isSendEmailSupportedByPrimaryDevice = true;
                    continue;
                }
                ++this.numSmsAccounts;
                if (!Accounts.supportsSend(messagingAccount)) continue;
                ++this.numSendSmsAccounts;
                bl2 = this.primaryDevice != null ? this.primaryDevice.isSimDevice() && this.primaryDevice.getSimCardId().equals(messagingAccount.simCardId) : false;
                boolean bl4 = bl = this.primaryDevice != null ? messagingAccount.getBtDeviceAddress().equals(this.primaryDevice.getBtDeviceAddress()) : false;
                if (!bl2 && !bl) continue;
                this.isSendSmsSupportedByPrimaryDevice = true;
            }
        }
    }

    private void updateIsSMSorEMAILSupportedByThePrimaryModels(boolean bl, boolean bl2) {
        if (this.instanceId != null && this.instanceId.equals("Dialog")) {
            this.framework.getHmiServiceApp().getChoiceModel(4646).setValue(bl ? 1 : 0);
            this.framework.getHmiServiceApp().getChoiceModel(4649).setValue(bl2 ? 1 : 0);
        }
    }

    private void clearAccountSelection() {
        if (this.selectedAccount != null && this.getRowIndexByAccount(this.selectedAccount) == -1) {
            this.setSelection(-1, true);
        }
    }

    private void fillAccountListModelWithAccountsPassingCurrentFilter(MessagingAccount[] messagingAccountArray) {
        ModelGroup modelGroup = new ModelGroup();
        modelGroup.add(this.listModel);
        this.listModel.removeAll();
        int n = 0;
        int n2 = 0;
        if (messagingAccountArray != null) {
            for (int i2 = 0; i2 < messagingAccountArray.length; ++i2) {
                MessagingAccount messagingAccount = messagingAccountArray[i2];
                int n3 = -1;
                if (messagingAccount == null || !this.isAcceptedByFilters(messagingAccount)) continue;
                if (this.numEmailAccounts > 1 && messagingAccount.isSupportsEMail()) {
                    n3 = ++n2;
                } else if (this.numSmsAccounts > 1 && Accounts.supportsSms(messagingAccount)) {
                    n3 = ++n;
                }
                boolean bl = this.msgApp.getSetupManager().isBasedOnBtConnection(messagingAccount);
                String string = this.msgApp.getSetupManager().getBtDeviceName(messagingAccount);
                boolean bl2 = this.msgApp.getNewMessageIndicationManager().hasNewMessages(messagingAccount.getAccountID());
                int n4 = this.msgApp.getNewMessageIndicationManager().getNewMessageCount(messagingAccount.getAccountID());
                AbstractAccountListRow abstractAccountListRow = this.accountListRowFactory.create(messagingAccount, n3, bl, string, bl2, n4);
                this.listModel.append(abstractAccountListRow);
            }
        }
        this.clearAccountSelection();
        modelGroup.flush();
        modelGroup.removeAll();
    }

    private AbstractAccountListRow getAccountListRow(int n) {
        return (AbstractAccountListRow)this.listModel.getRow(n);
    }

    private void setTooltip(AbstractAccountListRow abstractAccountListRow) {
        try {
            this.log.log(-2137614336, "[AccountList(%1)#setTooltip] Account name = %2", (Object)this.instanceId, (Object)abstractAccountListRow.getMessagingAccount().getAccountName());
            this.tooltipModel.clear();
            AccountTooltipRow accountTooltipRow = new AccountTooltipRow(abstractAccountListRow, 0);
            AccountTooltipRow accountTooltipRow2 = new AccountTooltipRow(abstractAccountListRow, 1);
            this.tooltipModel.setData(new ListRow[]{accountTooltipRow, accountTooltipRow2});
        }
        catch (Exception exception) {
            Logs.logException(this.log, exception, "[AccountList({0})#setTooltip]", new Object[]{this.instanceId});
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private void setSelection(int n, boolean bl) {
        Object object = this.messagingBundleContext.getMessagingHmiLock();
        synchronized (object) {
            if (this.log.isDebug()) {
                this.log.log(-2137614336, "[AccountList(%1)#setSelection] rowIndex = %2, isObservedAccountChange = %3", (Object)String.valueOf(this.instanceId), (Object)String.valueOf(n), (Object)String.valueOf(bl));
            }
            int n2 = this.listModel.getSelected() == null ? -1 : this.listModel.getSelected().getIndex();
            this.emitIndicateSelectionPending(n2, n, bl);
            this.listModel.setSelectedIndex(n);
            this.selectedAccount = this.getAccountByRowIndex(n);
        }
    }

    public int getNumSmsAccounts() {
        return this.numSmsAccounts;
    }

    public int getNumEmailAccounts() {
        return this.numEmailAccounts;
    }

    public int getNumSendSmsAccounts() {
        return this.numSendSmsAccounts;
    }

    public int getNumSendEmailAccounts() {
        return this.numSendEmailAccounts;
    }

    public boolean isSendSmsSupportedByPrimaryDevice() {
        return this.isSendSmsSupportedByPrimaryDevice;
    }

    public boolean isSendEmailSupportedByPrimaryDevice() {
        return this.isSendEmailSupportedByPrimaryDevice;
    }

    private void emitIndicateSelectionPending(int n, int n2, boolean bl) {
        this.log.log(-2137614336, "[AccountList(%1)#emitIndicateSelectionPending]", (Object)this.instanceId);
        Iterator iterator = this.accountListObservers.iterator();
        while (iterator.hasNext()) {
            try {
                ((IAccountListObserver)iterator.next()).indicateSelectionPending(n, n2, bl);
            }
            catch (Exception exception) {
                Logs.logException(this.log, exception, "[AccountList({0})#emitIndicateSelectionPending]", new Object[]{this.instanceId});
            }
        }
    }

    private void emitIndicateItemSelected(MessagingAccount messagingAccount) {
        this.log.log(-2137614336, "[AccountList(%1)#emitIndicateItemSelected]", (Object)this.instanceId);
        Iterator iterator = this.accountListObservers.iterator();
        while (iterator.hasNext()) {
            try {
                ((IAccountListObserver)iterator.next()).indicateItemSelected(messagingAccount);
            }
            catch (Exception exception) {
                Logs.logException(this.log, exception, "[AccountList({0})#emitIndicateItemSelected]", new Object[]{this.instanceId});
            }
        }
    }

    private void emitIndicateItemSelectedWhileBusy(MessagingAccount messagingAccount) {
        this.log.log(-2137614336, "[AccountList(%1)#emitIndicateItemSelectedWhilyBusy]", (Object)this.instanceId);
        Iterator iterator = this.accountListObservers.iterator();
        while (iterator.hasNext()) {
            try {
                ((IAccountListObserver)iterator.next()).indicateItemSelectedWhilyBusy(messagingAccount);
            }
            catch (Exception exception) {
                Logs.logException(this.log, exception, "[AccountList({0})#emitIndicateItemSelectedWhilyBusy]", new Object[]{this.instanceId});
            }
        }
    }

    @Override
    public void updateDeviceRoleInfo(DeviceRoleInfo deviceRoleInfo) {
        this.log.log(1078071040, "[AccountList#updateDeviceRoleInfo] primaryDeviceInfo = %1", (Object)deviceRoleInfo);
        this.primaryDevice = deviceRoleInfo;
        this.refresh();
    }

    static /* synthetic */ Class class$(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new NoClassDefFoundError().initCause(classNotFoundException);
        }
    }

    static /* synthetic */ MessagingBundleContext access$500(AccountList accountList) {
        return accountList.messagingBundleContext;
    }

    static /* synthetic */ LogChannel access$600(AccountList accountList) {
        return accountList.log;
    }

    static /* synthetic */ String access$700(AccountList accountList) {
        return accountList.instanceId;
    }

    static /* synthetic */ boolean access$800(AccountList accountList) {
        return accountList.isFolderContentListBusy;
    }

    static /* synthetic */ LogChannel access$900(AccountList accountList) {
        return accountList.log;
    }

    static /* synthetic */ IFrameworkAccess access$1000(AccountList accountList) {
        return accountList.framework;
    }

    static /* synthetic */ void access$1100(AccountList accountList, int n, boolean bl) {
        accountList.setSelection(n, bl);
    }

    static /* synthetic */ void access$1200(AccountList accountList, MessagingAccount messagingAccount) {
        accountList.emitIndicateItemSelectedWhileBusy(messagingAccount);
    }

    static /* synthetic */ LogChannel access$1300(AccountList accountList) {
        return accountList.log;
    }

    static /* synthetic */ LogChannel access$1400(AccountList accountList) {
        return accountList.log;
    }

    static /* synthetic */ AbstractAccountListRow access$1500(AccountList accountList, int n) {
        return accountList.getAccountListRow(n);
    }

    static /* synthetic */ void access$1600(AccountList accountList, AbstractAccountListRow abstractAccountListRow) {
        accountList.setTooltip(abstractAccountListRow);
    }

    static /* synthetic */ MessagingBundleContext access$1700(AccountList accountList) {
        return accountList.messagingBundleContext;
    }

    static /* synthetic */ LogChannel access$1800(AccountList accountList) {
        return accountList.log;
    }

    static /* synthetic */ MessagingAccount[] access$1902(AccountList accountList, MessagingAccount[] messagingAccountArray) {
        accountList.accounts = messagingAccountArray;
        return messagingAccountArray;
    }

    static /* synthetic */ LogChannel access$2000(AccountList accountList) {
        return accountList.log;
    }

    static /* synthetic */ LogChannel access$2100(AccountList accountList) {
        return accountList.log;
    }

    static /* synthetic */ boolean access$802(AccountList accountList, boolean bl) {
        accountList.isFolderContentListBusy = bl;
        return accountList.isFolderContentListBusy;
    }

    static /* synthetic */ LogChannel access$2200(AccountList accountList) {
        return accountList.log;
    }

    static /* synthetic */ AbstractMsgApplication access$2300(AccountList accountList) {
        return accountList.msgApp;
    }
}

