/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.messaging.core.accounts;

import de.audi.app.messaging.core.accounts.AccountFilter;
import de.audi.app.messaging.core.accounts.AccountList;
import de.audi.app.messaging.core.accounts.Accounts;
import de.audi.app.messaging.core.accounts.IAccountFilter;
import de.audi.app.messaging.core.accounts.IAccountManagerListener;
import de.audi.app.messaging.core.application.AbstractMsgApplication;
import de.audi.app.messaging.core.component.AbstractMessagingComponent;
import de.audi.app.messaging.core.component.IMessagingComponent;
import de.audi.app.messaging.core.concurrent.CopyOnWriteArrayList;
import de.audi.app.messaging.core.dsi.messaging.DsiMessagingEmptyListener;
import de.audi.app.messaging.core.indication.INewMessageIndicationManagerObserver;
import de.audi.app.messaging.core.osgi.MessagingBundleContext;
import de.audi.app.messaging.core.setup.SetupManager;
import de.audi.app.messaging.core.swdiagnosis.IDiagPlugIn;
import de.audi.app.messaging.core.swdiagnosis.IDiagProvider;
import de.audi.app.messaging.core.util.Arrays;
import de.audi.app.messaging.core.util.Logs;
import de.audi.app.messaging.core.util.Maps;
import de.audi.app.messaging.core.util.Strings;
import de.audi.atip.hmi.IHMIServiceApp;
import de.audi.atip.util.Util;
import de.esolutions.fw.util.commons.Buffer;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.dsi.ifc.messaging.MessagingAccount;

public final class AccountManager
extends AbstractMessagingComponent
implements IMessagingComponent,
IDiagProvider {
    public static final int NUM_ACCOUNTS_MAX = 12;
    public static final int ACCOUNT_TEXT_TYPE_MOBILE_DYNAMIC = 0;
    public static final int ACCOUNT_TEXT_TYPE_MOBILE_STATIC = 1;
    public static final int ACCOUNT_TEXT_TYPE_SIM = 2;
    private static final int MESSAGING_MODE_SMS = 0;
    private static final int MESSAGING_MODE_EMAIL = 1;
    private MessagingAccount[] accounts = new MessagingAccount[0];
    private final Map accountMap = new HashMap(Maps.getInitialHashMapCapacity(12, 75));
    private final AccountList dialogAccountList;
    private final AccountList smsAccountList;
    private final AccountList emailAccountList;
    private MessagingAccount selectedAccount = null;
    private MessagingAccount lastSelectedAccount = null;
    private int messagingMode = 0;
    private int numSmsAccounts = 0;
    private int numEmailAccounts = 0;
    private int numSmsSendSupportAccounts = 0;
    private int numEmailSendSupportAccounts = 0;
    private final CopyOnWriteArrayList accountManagerListeners = new CopyOnWriteArrayList();

    public AccountManager(MessagingBundleContext messagingBundleContext) {
        super(messagingBundleContext, "App.Messaging.Main");
        IHMIServiceApp iHMIServiceApp = this.framework.getHmiServiceApp();
        this.dialogAccountList = new AccountList(messagingBundleContext, iHMIServiceApp.getBaseListModel(2200526), "Dialog");
        this.smsAccountList = new AccountList(messagingBundleContext, iHMIServiceApp.getBaseListModel(2200528), "SMS");
        this.emailAccountList = new AccountList(messagingBundleContext, iHMIServiceApp.getBaseListModel(2200527), "E-Mail");
        this.addComponent(this.dialogAccountList);
        this.addComponent(this.smsAccountList);
        this.addComponent(this.emailAccountList);
    }

    public void init(AbstractMsgApplication abstractMsgApplication) {
        super.init(abstractMsgApplication);
        this.smsAccountList.addAccountFilter(AccountFilter.ACCOUNT_FILTER_SMS_ONLY);
        this.emailAccountList.addAccountFilter(AccountFilter.ACCOUNT_FILTER_EMAIL_ONLY);
        this.setAvailableAccounts();
        this.setSelectedAccount(null);
        abstractMsgApplication.getDsiMessagingPrimaryListener().addSubscriber(new MyDsiMessagingListener());
        abstractMsgApplication.getNewMessageIndicationManager().addObserver(new NewMessageIndicationManagerObserver());
        abstractMsgApplication.getMessagingSwDiagnosis().registerDiagProvider(this);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void dispose() {
        Object object = this.messagingBundleContext.getMessagingHmiLock();
        synchronized (object) {
            super.dispose();
            this.accounts = new MessagingAccount[0];
            this.accountMap.clear();
            this.setAvailableAccounts();
            this.setSelectedAccount(null);
            this.lastSelectedAccount = null;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public MessagingAccount[] getAccounts() {
        Object object = this.messagingBundleContext.getMessagingHmiLock();
        synchronized (object) {
            return this.accounts;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public MessagingAccount getSelectedAccount() {
        Object object = this.messagingBundleContext.getMessagingHmiLock();
        synchronized (object) {
            return this.selectedAccount;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public MessagingAccount getLastSelectedAccount() {
        Object object = this.messagingBundleContext.getMessagingHmiLock();
        synchronized (object) {
            this.checkLastAccountLoss();
            return this.lastSelectedAccount;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public MessagingAccount getAccount(int n) {
        Object object = this.messagingBundleContext.getMessagingHmiLock();
        synchronized (object) {
            return (MessagingAccount)this.accountMap.get(Util.createInteger(n));
        }
    }

    public boolean isEmailMode() {
        int n = this.framework.getHmiServiceApp().getChoiceModel(2200505).getValue();
        return n == 1;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void selectAccount(int n) {
        Object object = this.messagingBundleContext.getMessagingHmiLock();
        synchronized (object) {
            MessagingAccount messagingAccount;
            if (this.log.isDebug()) {
                this.log.log(10000000, "[AccountManager#selectAccount] accountId = %1", (long)n);
            }
            if ((messagingAccount = this.getAccount(n)) == null) {
                this.log.log(10000, "[AccountManager#selectAccount] Cannot find account ID = %1", (long)n);
            }
            this.setSelectedAccount(messagingAccount);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public boolean isAccTypeSelected(int n) {
        Object object = this.messagingBundleContext.getMessagingHmiLock();
        synchronized (object) {
            boolean bl = false;
            if (this.selectedAccount != null && Accounts.supportsSend(this.selectedAccount)) {
                bl = n == 0 ? true : (n == 1 ? Accounts.supportsSms(this.selectedAccount) : this.selectedAccount.isSupportsEMail());
            }
            return bl;
        }
    }

    public AccountList getDialogAccountList() {
        return this.dialogAccountList;
    }

    public AccountList getSmsAccountList() {
        return this.smsAccountList;
    }

    public AccountList getEmailAccountList() {
        return this.emailAccountList;
    }

    public void addFilterToAllLists(IAccountFilter iAccountFilter) {
        this.smsAccountList.addAccountFilter(iAccountFilter);
        this.emailAccountList.addAccountFilter(iAccountFilter);
        this.dialogAccountList.addAccountFilter(iAccountFilter);
        this.filtersChanged();
    }

    public void removeFilterFromAllLists(IAccountFilter iAccountFilter) {
        this.smsAccountList.removeAccountFilter(iAccountFilter);
        this.emailAccountList.removeAccountFilter(iAccountFilter);
        this.dialogAccountList.removeAccountFilter(iAccountFilter);
        this.filtersChanged();
    }

    public static String getDynamicAccountName(MessagingAccount messagingAccount, String string) {
        String string2 = "";
        String string3 = messagingAccount.getAccountName();
        if (!Strings.isNullOrEmpty(string3)) {
            string2 = string3;
        } else if (!Strings.isNullOrEmpty(string)) {
            string2 = string;
        }
        return string2;
    }

    public static int getAccountTextType(boolean bl, String string) {
        int n = 0;
        n = !bl ? 2 : (Strings.isNullOrEmpty(string) ? 1 : 0);
        return n;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public String toString() {
        Object object = this.messagingBundleContext.getMessagingHmiLock();
        synchronized (object) {
            Buffer buffer = new Buffer();
            buffer.append("AccountManager {accounts = ");
            buffer.append(Arrays.toMultiLineString(this.accounts));
            buffer.append(", selectedAccount = ");
            buffer.append(this.selectedAccount);
            buffer.append(", lastSelectedAccount = ");
            buffer.append(this.lastSelectedAccount);
            buffer.append('}');
            return buffer.toString();
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private void checkAccountLoss() {
        Object object = this.messagingBundleContext.getMessagingHmiLock();
        synchronized (object) {
            if (this.isAccountLoss(this.selectedAccount)) {
                this.log.log(1000000, "[AccountManager#checkAccountLoss] Selected account lost: %1", (Object)this.selectedAccount);
                this.setSelectedAccount(null);
            }
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private void checkLastAccountLoss() {
        Object object = this.messagingBundleContext.getMessagingHmiLock();
        synchronized (object) {
            if (this.isAccountLoss(this.lastSelectedAccount)) {
                this.log.log(1000000, "[AccountManager#checkLastAccountLoss] Last account lost: %1", (Object)this.lastSelectedAccount);
                this.lastSelectedAccount = null;
            }
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private boolean isAccountLoss(MessagingAccount messagingAccount) {
        Object object = this.messagingBundleContext.getMessagingHmiLock();
        synchronized (object) {
            if (messagingAccount != null) {
                Integer n = Util.createInteger(messagingAccount.getAccountID());
                boolean bl = this.accountMap.containsKey(n);
                boolean bl2 = !bl;
                return bl2;
            }
            return false;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private void setSelectedAccount(MessagingAccount messagingAccount) {
        Object object = this.messagingBundleContext.getMessagingHmiLock();
        synchronized (object) {
            this.log.log(10000000, "[AccountManager#setSelectedAccount] messagingAccount = %1, lastMessagingAccount = %2", (Object)String.valueOf(messagingAccount), (Object)String.valueOf(this.selectedAccount));
            this.lastSelectedAccount = this.selectedAccount;
            this.selectedAccount = messagingAccount;
            this.setMessagingMode(this.selectedAccount != null ? this.selectedAccount.isSupportsEMail() : false);
            this.setSelectedAccountCapabilities();
            int n = messagingAccount == null ? 1 : 0;
            this.framework.getHmiServiceApp().getChoiceModel(2200143).setValue(n);
            SetupManager setupManager = this.msgApp.getSetupManager();
            if (messagingAccount != null && setupManager != null) {
                this.msgApp.getSetupManager().logSystemProperties();
            }
            this.emitSelectedAccountChanged();
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private void setMessagingMode(boolean bl) {
        Object object = this.messagingBundleContext.getMessagingHmiLock();
        synchronized (object) {
            int n;
            this.log.log(10000000, "[AccountManager#setMessagingMode] isEmailMode = %1", bl);
            int n2 = n = bl ? 1 : 0;
            if (this.messagingMode != n) {
                this.msgApp.getNewMessage().clear();
            }
            this.messagingMode = n;
            this.framework.getHmiServiceApp().getChoiceModel(2200505).setValue(n);
        }
    }

    private void setSelectedAccountCapabilities() {
        this.log.log(10000000, "[AccountManager#setSelectedAccountCapabilities]");
        MessagingAccount messagingAccount = this.getSelectedAccount();
        this.signalSendSupport(messagingAccount);
        this.signalDraftSupport(messagingAccount);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private void setAvailableAccounts() {
        Object object = this.messagingBundleContext.getMessagingHmiLock();
        synchronized (object) {
            this.numSmsAccounts = this.smsAccountList.getNumSmsAccounts();
            this.numEmailAccounts = this.emailAccountList.getNumEmailAccounts();
            this.numSmsSendSupportAccounts = this.smsAccountList.getNumSendSmsAccounts();
            this.numEmailSendSupportAccounts = this.emailAccountList.getNumSendEmailAccounts();
            this.log.log(1000000, new StringBuffer().append("[AccountManager#setAvailableAccounts] numSmsSendSupportAccounts = %1, numEmailSendSupportAccounts = %2, isSendSmsSupportedByPrimaryDevice = ").append(this.smsAccountList.isSendSmsSupportedByPrimaryDevice()).append(", isSendEmailSupportedByPrimaryDevice = ").append(this.emailAccountList.isSendEmailSupportedByPrimaryDevice()).toString(), (long)this.numSmsSendSupportAccounts, (long)this.numEmailSendSupportAccounts);
            IHMIServiceApp iHMIServiceApp = this.framework.getHmiServiceApp();
            iHMIServiceApp.getChoiceModel(4170).setValue(this.numSmsAccounts);
            iHMIServiceApp.getChoiceModel(4171).setValue(this.numEmailAccounts);
            iHMIServiceApp.getChoiceModel(155).setValue(this.numSmsSendSupportAccounts);
            iHMIServiceApp.getChoiceModel(154).setValue(this.numEmailSendSupportAccounts);
            this.emitUpdateAvailableAccounts(this.accountManagerListeners);
        }
    }

    private void filtersChanged() {
        this.setSelectedAccount(null);
        this.setAvailableAccounts();
    }

    private void signalSendSupport(MessagingAccount messagingAccount) {
        boolean bl = messagingAccount != null ? Accounts.supportsSend(messagingAccount) : false;
        this.log.log(10000000, "[AccountManager#signalSendSupport] Account supports sending messages: %1", bl);
        int n = bl ? 1 : 0;
        this.framework.getHmiServiceApp().getChoiceModel(2200130).setValue(n);
    }

    private void signalDraftSupport(MessagingAccount messagingAccount) {
        boolean bl = messagingAccount != null ? Accounts.supportsDrafts(messagingAccount) : false;
        this.log.log(10000000, "[AccountManager#signalDraftSupport] Account supports drafts: %1", bl);
        int n = bl ? 1 : 0;
        this.framework.getHmiServiceApp().getChoiceModel(2200172).setValue(n);
    }

    public void addListener(IAccountManagerListener iAccountManagerListener) {
        this.log.log(10000000, "[AccountManager#addListener] listener = %1", (Object)iAccountManagerListener);
        this.accountManagerListeners.add(iAccountManagerListener);
        ArrayList arrayList = new ArrayList(1);
        arrayList.add(iAccountManagerListener);
        this.emitUpdateAvailableAccounts(arrayList);
    }

    public void emitSelectedAccountChanged() {
        Iterator iterator = this.accountManagerListeners.iterator();
        while (iterator.hasNext()) {
            try {
                ((IAccountManagerListener)iterator.next()).selectedAccountChanged();
            }
            catch (Exception exception) {
                Logs.logException(this.log, exception, "[AccountManager#emitSelectedAccountChanged]");
            }
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void emitUpdateAvailableAccounts(Collection collection) {
        Object object = this.messagingBundleContext.getMessagingHmiLock();
        synchronized (object) {
            Iterator iterator = collection.iterator();
            while (iterator.hasNext()) {
                try {
                    IAccountManagerListener iAccountManagerListener = (IAccountManagerListener)iterator.next();
                    iAccountManagerListener.updateAvailableAccounts(this.numSmsAccounts, this.numEmailAccounts, this.numSmsSendSupportAccounts, this.numEmailSendSupportAccounts);
                }
                catch (Exception exception) {
                    Logs.logException(this.log, exception, "[AccountManager#emitUpdateAvailableAccounts]");
                }
            }
        }
    }

    public IDiagPlugIn[] createDiagPlugIns() {
        return new IDiagPlugIn[]{new DiagPlugIn()};
    }

    static /* synthetic */ MessagingAccount[] access$802(AccountManager accountManager, MessagingAccount[] messagingAccountArray) {
        accountManager.accounts = messagingAccountArray;
        return messagingAccountArray;
    }

    final class DiagPlugIn
    implements IDiagPlugIn {
        DiagPlugIn() {
        }

        public Object getDialogAccountList() {
            return AccountManager.this.dialogAccountList;
        }

        public Object getSmsAccountList() {
            return AccountManager.this.smsAccountList;
        }

        public Object getEmailAccountList() {
            return AccountManager.this.emailAccountList;
        }

        public Object getAccountManager() {
            return AccountManager.this;
        }
    }

    private class MyDsiMessagingListener
    extends DsiMessagingEmptyListener {
        private MyDsiMessagingListener() {
        }

        /*
         * WARNING - Removed try catching itself - possible behaviour change.
         */
        public void updateMessagingAccounts(MessagingAccount[] messagingAccountArray, int n) {
            Object object = AccountManager.this.messagingBundleContext.getMessagingHmiLock();
            synchronized (object) {
                MessagingAccount messagingAccount;
                AccountManager.this.log.log(10000000, "[AccountManager#updateMessagingAccounts] accounts.length = %1", (long)messagingAccountArray.length);
                AccountManager.access$802(AccountManager.this, messagingAccountArray);
                AccountManager.this.accountMap.clear();
                for (int i2 = 0; i2 < messagingAccountArray.length; ++i2) {
                    MessagingAccount messagingAccount2 = messagingAccountArray[i2];
                    AccountManager.this.accountMap.put(Util.createInteger(messagingAccount2.getAccountID()), messagingAccount2);
                }
                if (AccountManager.this.selectedAccount != null && (messagingAccount = AccountManager.this.getAccount(AccountManager.this.selectedAccount.getAccountID())) != null) {
                    AccountManager.this.selectedAccount = messagingAccount;
                }
                AccountManager.this.checkAccountLoss();
                AccountManager.this.setSelectedAccountCapabilities();
                AccountManager.this.setAvailableAccounts();
            }
        }
    }

    private class NewMessageIndicationManagerObserver
    implements INewMessageIndicationManagerObserver {
        private NewMessageIndicationManagerObserver() {
        }

        public void indicateIndicationStateChanged(int n) {
            AccountManager.this.log.log(10000000, "[AccountManager#indicateIndicationStateChanged] stateAspect = %1", (long)n);
            if (n == 0) {
                AccountManager.this.dialogAccountList.refresh();
                AccountManager.this.smsAccountList.refresh();
                AccountManager.this.emailAccountList.refresh();
            }
        }
    }
}

