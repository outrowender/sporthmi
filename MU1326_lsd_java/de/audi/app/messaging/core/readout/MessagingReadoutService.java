/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  de.mib.swdiagnosis.msg.core.readout.MessagingReadoutServiceDiagPlugIn
 */
package de.audi.app.messaging.core.readout;

import de.audi.app.messaging.core.accounts.AccountFilter;
import de.audi.app.messaging.core.accounts.AccountList;
import de.audi.app.messaging.core.accounts.IAccountFilter;
import de.audi.app.messaging.core.accounts.IAccountListObserver;
import de.audi.app.messaging.core.application.AbstractMsgApplication;
import de.audi.app.messaging.core.component.AbstractMessagingComponent;
import de.audi.app.messaging.core.folderbrowsing.EntryList;
import de.audi.app.messaging.core.folderbrowsing.IEntryListObserver;
import de.audi.app.messaging.core.indication.NewMessageIndicationManager;
import de.audi.app.messaging.core.osgi.AbstractMessagingTrackerCustomizer;
import de.audi.app.messaging.core.osgi.IServiceRegistry;
import de.audi.app.messaging.core.osgi.MessagingBundleContext;
import de.audi.app.messaging.core.osgi.ServiceFilterBuilder;
import de.audi.app.messaging.core.osgi.ServiceProperties;
import de.audi.app.messaging.core.readout.IReadable;
import de.audi.app.messaging.core.swdiagnosis.IDiagPlugIn;
import de.audi.app.messaging.core.swdiagnosis.IDiagProvider;
import de.audi.app.messaging.core.util.ListEntries;
import de.audi.app.messaging.core.util.Logs;
import de.audi.atip.interapp.IMessagingReadoutService;
import de.audi.atip.interapp.IMessagingReadoutServiceListener;
import de.esolutions.fw.util.commons.Buffer;
import de.mib.swdiagnosis.msg.core.readout.MessagingReadoutServiceDiagPlugIn;
import java.util.Set;
import org.dsi.ifc.messaging.ListEntry;
import org.dsi.ifc.messaging.MessagingAccount;
import org.osgi.framework.Filter;
import org.osgi.framework.InvalidSyntaxException;
import org.osgi.framework.ServiceReference;
import org.osgi.util.tracker.ServiceTracker;
import org.osgi.util.tracker.ServiceTrackerCustomizer;

public final class MessagingReadoutService
extends AbstractMessagingComponent
implements IMessagingReadoutService,
IDiagProvider {
    private static final int STATE_IDLE = 0;
    private static final int STATE_ACTIVE = 1;
    private static final int RQ_NONE = 0;
    private static final int RQ_READOUT_MESSAGE = 1;
    private volatile IMessagingReadoutServiceListener messagingReadoutServiceListener;
    private volatile int state = 0;
    private volatile int currentRequest = 0;
    private boolean newMessageMode = false;
    private boolean messageAutoSelected = false;
    private volatile IAccountFilter dialogAccountFilter = null;
    static /* synthetic */ Class class$de$audi$atip$interapp$IMessagingReadoutService;
    static /* synthetic */ Class class$de$audi$atip$interapp$IMessagingReadoutServiceListener;

    public MessagingReadoutService(MessagingBundleContext messagingBundleContext) {
        super(messagingBundleContext, "App.Messaging.Main");
    }

    public void init(AbstractMsgApplication abstractMsgApplication) {
        super.init(abstractMsgApplication);
        abstractMsgApplication.getAccountManager().getDialogAccountList().addObserver(new AccountListObserver());
        abstractMsgApplication.getEntryList().addObserver(new EntryListObserver());
        abstractMsgApplication.getMessagingSwDiagnosis().registerDiagProvider(this);
    }

    public void connect(IServiceRegistry iServiceRegistry) {
        try {
            super.connect(iServiceRegistry);
            iServiceRegistry.registerService((class$de$audi$atip$interapp$IMessagingReadoutService == null ? (class$de$audi$atip$interapp$IMessagingReadoutService = MessagingReadoutService.class$("de.audi.atip.interapp.IMessagingReadoutService")) : class$de$audi$atip$interapp$IMessagingReadoutService).getName(), (Object)this, ServiceProperties.createServiceProperties());
            iServiceRegistry.addTracker(this.createServiceTracker());
        }
        catch (Exception exception) {
            this.log.log(10000, "[MessagingReadoutService#connect] An error occurred: ", (Throwable)exception);
        }
    }

    private ServiceTracker createServiceTracker() throws InvalidSyntaxException {
        String string = ServiceFilterBuilder.createFilterString("objectClass", (class$de$audi$atip$interapp$IMessagingReadoutServiceListener == null ? (class$de$audi$atip$interapp$IMessagingReadoutServiceListener = MessagingReadoutService.class$("de.audi.atip.interapp.IMessagingReadoutServiceListener")) : class$de$audi$atip$interapp$IMessagingReadoutServiceListener).getName());
        Filter filter = this.bundleContext.createFilter(string);
        AbstractMessagingTrackerCustomizer abstractMessagingTrackerCustomizer = new AbstractMessagingTrackerCustomizer(this.log, this.bundleContext){

            public void addService(ServiceReference serviceReference, Object object) {
                MessagingReadoutService.this.state = 0;
                MessagingReadoutService.this.currentRequest = 0;
                MessagingReadoutService.this.messagingReadoutServiceListener = (IMessagingReadoutServiceListener)object;
            }

            public void removeService(ServiceReference serviceReference, Object object) {
                MessagingReadoutService.this.state = 0;
                MessagingReadoutService.this.currentRequest = 0;
                MessagingReadoutService.this.messagingReadoutServiceListener = null;
            }
        };
        return new ServiceTracker(this.bundleContext, filter, (ServiceTrackerCustomizer)abstractMessagingTrackerCustomizer);
    }

    private void setReadoutSessionState(int n) {
        this.log.log(10000000, "[MessagingReadoutService#setReadoutSessionState] state = %1", (long)n);
        this.state = n;
    }

    private void logIllegalState(String string, int n, int n2) {
        this.log.log(100000, "%1 Invalid request: currentState = %2, currentRequest = %3", (Object)string, (Object)String.valueOf(n), (Object)String.valueOf(n2));
    }

    public DialogState getDialogState() {
        return new DialogState(this.state == 1, this.messageAutoSelected);
    }

    public void notifyTtsSessionStarted() {
        this.msgApp.getExecutorManager().getInternalTaskDispatcher().execute(new Runnable(){

            public void run() {
                MessagingReadoutService.this.log.log(10000000, "[MessagingReadoutService#notifyTtsSessionStarted]");
                if (MessagingReadoutService.this.currentRequest == 1) {
                    MessagingReadoutService.this.emitResponseReadoutMessage(0);
                    MessagingReadoutService.this.currentRequest = 0;
                }
            }
        });
    }

    public void notifyTtsSessionStopped() {
        this.msgApp.getExecutorManager().getInternalTaskDispatcher().execute(new Runnable(){

            public void run() {
                MessagingReadoutService.this.log.log(10000000, "[MessagingReadoutService#notifyTtsSessionStopped]");
                if (MessagingReadoutService.this.currentRequest == 1) {
                    MessagingReadoutService.this.emitResponseReadoutMessage(1);
                    MessagingReadoutService.this.currentRequest = 0;
                }
            }
        });
    }

    private void setMessageAutoSelected(boolean bl) {
        this.messageAutoSelected = bl;
        int n = bl ? 1 : 0;
        this.framework.getHmiServiceApp().getChoiceModel(2200299).setValue(n);
    }

    private IAccountFilter getAccountFilter(boolean bl, int n) {
        AccountFilter.Builder builder = new AccountFilter.Builder();
        int n2 = n == 1 ? 1 : (n == 2 ? 2 : 0);
        builder.accountType(n2);
        if (bl) {
            Set set = this.msgApp.getNewMessageIndicationManager().getNewMessageAccountSet();
            builder.newMessagesOnly(true, set);
        }
        return builder.build();
    }

    private void emitResponseBeginDialog(final int n) {
        this.msgApp.getExecutorManager().getExternalTaskDispatcher().execute(new Runnable(){

            public void run() {
                try {
                    MessagingReadoutService.this.log.log(1000000, "[MessagingReadoutService#emitResponseBeginDialog] result = %1", (long)n);
                    MessagingReadoutService.this.messagingReadoutServiceListener.responseBeginDialog(n);
                }
                catch (Exception exception) {
                    Logs.logException(MessagingReadoutService.this.log, exception, "[MessagingReadoutService#emitResponseSendMessage]");
                }
            }
        });
    }

    private void emitResponseEndDialog(final int n) {
        this.msgApp.getExecutorManager().getExternalTaskDispatcher().execute(new Runnable(){

            public void run() {
                try {
                    MessagingReadoutService.this.log.log(1000000, "[MessagingReadoutService#emitResponseEndDialog] result = %1", (long)n);
                    MessagingReadoutService.this.messagingReadoutServiceListener.responseEndDialog(n);
                }
                catch (Exception exception) {
                    Logs.logException(MessagingReadoutService.this.log, exception, "[MessagingReadoutService#emitResponseEndDialog]");
                }
            }
        });
    }

    private void emitResponseReadoutMessage(final int n) {
        this.msgApp.getExecutorManager().getExternalTaskDispatcher().execute(new Runnable(){

            public void run() {
                try {
                    MessagingReadoutService.this.log.log(1000000, "[MessagingReadoutService#emitResponseReadoutMessage] result = %1", (long)n);
                    MessagingReadoutService.this.messagingReadoutServiceListener.responseReadoutMessage(n);
                }
                catch (Exception exception) {
                    Logs.logException(MessagingReadoutService.this.log, exception, "[MessagingReadoutService#emitResponseReadoutMessage]");
                }
            }
        });
    }

    private void emitIndicateFolderContentListItemSelected(final boolean bl) {
        this.msgApp.getExecutorManager().getExternalTaskDispatcher().execute(new Runnable(){

            public void run() {
                try {
                    MessagingReadoutService.this.log.log(1000000, "[MessagingReadoutService#indicateFolderContentListItemSelected] isFolder = %1", bl);
                    MessagingReadoutService.this.messagingReadoutServiceListener.indicateFolderContentListItemSelected(bl);
                }
                catch (Exception exception) {
                    Logs.logException(MessagingReadoutService.this.log, exception, "[MessagingReadoutService#indicateFolderContentListItemSelected]");
                }
            }
        });
    }

    public void requestBeginDialog(final boolean bl, final int n, final int n2) {
        this.msgApp.getExecutorManager().getInternalTaskDispatcher().execute(new Runnable(){

            /*
             * WARNING - Removed try catching itself - possible behaviour change.
             */
            public void run() {
                int n3 = 0;
                try {
                    MessagingReadoutService.this.log.log(1000000, "[MessagingReadoutService#requestBeginDialog] newMsgMode = %3, messageType = %1, selectLevel = %2", (long)n, (long)n2, bl);
                    if (MessagingReadoutService.this.state != 0) {
                        MessagingReadoutService.this.logIllegalState("[MessagingReadoutService#requestBeginDialog]", MessagingReadoutService.this.state, MessagingReadoutService.this.currentRequest);
                        n3 = 3;
                    } else {
                        boolean bl4;
                        MessagingReadoutService.this.newMessageMode = bl;
                        MessagingReadoutService.this.setMessageAutoSelected(false);
                        boolean bl2 = n2 == 0;
                        boolean bl3 = bl4 = n2 == 0 || n2 == 1;
                        if (bl2) {
                            MessagingReadoutService.this.msgApp.getEntryList().signalListReady(false);
                        }
                        if (bl4) {
                            MessagingReadoutService.this.msgApp.getSelectedMessage().signalMessageContentsReady(0);
                        }
                        AccountList accountList = MessagingReadoutService.this.msgApp.getAccountManager().getDialogAccountList();
                        accountList.removeAccountFilter(MessagingReadoutService.this.dialogAccountFilter);
                        MessagingReadoutService.this.dialogAccountFilter = MessagingReadoutService.this.getAccountFilter(bl, n);
                        accountList.addAccountFilter(MessagingReadoutService.this.dialogAccountFilter);
                        if (n2 == 0) {
                            MessagingReadoutService.this.attemptAutoSelectAccount();
                        } else if (n2 == 1) {
                            MessagingReadoutService.this.attemptAutoSelectMessage(bl);
                        }
                        MessagingReadoutService.this.setReadoutSessionState(1);
                    }
                }
                catch (Exception exception) {
                    Logs.logException(MessagingReadoutService.this.log, exception, "[MessagingReadoutService#requestBeginDialog]");
                    n3 = 1;
                }
                finally {
                    MessagingReadoutService.this.emitResponseBeginDialog(n3);
                }
            }
        });
    }

    public void requestEndDialog() {
        this.msgApp.getExecutorManager().getInternalTaskDispatcher().execute(new Runnable(){

            /*
             * WARNING - Removed try catching itself - possible behaviour change.
             */
            public void run() {
                int n = 0;
                try {
                    MessagingReadoutService.this.log.log(1000000, "[MessagingReadoutService#requestEndDialog]");
                    MessagingReadoutService.this.msgApp.getEntryList().signalListReady(true);
                    MessagingReadoutService.this.msgApp.getSelectedMessage().signalMessageContentsReady(1);
                    AccountList accountList = MessagingReadoutService.this.msgApp.getAccountManager().getDialogAccountList();
                    accountList.removeAccountFilter(MessagingReadoutService.this.dialogAccountFilter);
                    MessagingReadoutService.this.setReadoutSessionState(0);
                    MessagingReadoutService.this.currentRequest = 0;
                }
                catch (Exception exception) {
                    Logs.logException(MessagingReadoutService.this.log, exception, "[MessagingReadoutService#requestEndDialog]");
                    n = 1;
                }
                finally {
                    MessagingReadoutService.this.emitResponseEndDialog(n);
                }
            }
        });
    }

    public void requestReadoutMessage() {
        this.msgApp.getExecutorManager().getInternalTaskDispatcher().execute(new Runnable(){

            /*
             * WARNING - Removed try catching itself - possible behaviour change.
             */
            public void run() {
                int n = 0;
                try {
                    MessagingReadoutService.this.log.log(1000000, "[MessagingReadoutService#requestReadoutMessage]");
                    if (MessagingReadoutService.this.state != 1 || MessagingReadoutService.this.currentRequest != 0) {
                        MessagingReadoutService.this.logIllegalState("[MessagingReadoutService#requestReadoutMessage]", MessagingReadoutService.this.state, MessagingReadoutService.this.currentRequest);
                        n = 3;
                    } else {
                        MessagingReadoutService.this.currentRequest = 1;
                        MessagingReadoutService.this.msgApp.getMessageReader().start();
                    }
                }
                catch (Exception exception) {
                    Logs.logException(MessagingReadoutService.this.log, exception, "[MessagingReadoutService#requestReadoutMessage]");
                    n = 1;
                }
                finally {
                    if (n != 0) {
                        MessagingReadoutService.this.emitResponseReadoutMessage(n);
                    }
                }
            }
        });
    }

    public String requestReadoutText() {
        this.log.log(1000000, "[MessagingReadoutService#requestReadoutText]");
        Buffer buffer = new Buffer();
        if (this.msgApp.getSelectedMessage().isInDetailView()) {
            IReadable iReadable = this.msgApp.getMessageReader().getReadableProvider().getReadable();
            if (iReadable != null) {
                while (iReadable.hasNextSpeakTask()) {
                    buffer.append(iReadable.nextSpeakTask());
                }
            } else {
                this.log.log(10000000, "[MessagingReadoutService#requestReadoutText] readable is NULL");
            }
        }
        this.log.log(10000000, "[MessagingReadoutService#requestReadoutText] readout: %1", (Object)buffer.toString());
        return buffer.toString();
    }

    public void requestBeginLastSelectedEntry() {
        this.msgApp.getExecutorManager().getInternalTaskDispatcher().execute(new Runnable(){

            /*
             * WARNING - Removed try catching itself - possible behaviour change.
             */
            public void run() {
                int n = 0;
                try {
                    if (MessagingReadoutService.this.state != 0) {
                        MessagingReadoutService.this.logIllegalState("[MessagingReadoutService#requestBeginLastSelectedEntry]", MessagingReadoutService.this.state, MessagingReadoutService.this.currentRequest);
                        n = 3;
                    } else {
                        MessagingReadoutService.this.setMessageAutoSelected(false);
                        MessagingReadoutService.this.msgApp.getEntryList().signalListReady(false);
                        AccountList accountList = MessagingReadoutService.this.msgApp.getAccountManager().getDialogAccountList();
                        MessagingAccount messagingAccount = MessagingReadoutService.this.msgApp.getAccountManager().getLastSelectedAccount();
                        if (messagingAccount != null) {
                            MessagingReadoutService.this.log.log(1000000, "[MessagingReadoutService#requestBeginLastSelectedEntry] Selecting last account %1.", (Object)String.valueOf(messagingAccount));
                            accountList.selectAccount(accountList.getRowIndexByAccount(messagingAccount));
                        } else {
                            MessagingReadoutService.this.log.log(100000, "[MessagingReadoutService#requestBeginLastSelectedEntry] Last account is null!");
                            n = 3;
                        }
                        MessagingReadoutService.this.setReadoutSessionState(1);
                    }
                }
                catch (Exception exception) {
                    Logs.logException(MessagingReadoutService.this.log, exception, "[MessagingReadoutService#requestBeginLastSelectedEntry]");
                    n = 1;
                }
                finally {
                    MessagingReadoutService.this.emitResponseBeginDialog(n);
                }
            }
        });
    }

    private void attemptAutoSelectAccount() {
        AccountList accountList = this.msgApp.getAccountManager().getDialogAccountList();
        if (accountList.getLength() == 1) {
            this.log.log(1000000, "[MessagingReadoutService#attemptAutoSelectAccount] Auto-selecting the only available account.");
            accountList.selectAccount(0);
        }
    }

    private void attemptAutoSelectMessage(boolean bl) {
        boolean bl2;
        EntryList entryList;
        int n;
        boolean bl3;
        block4: {
            NewMessageIndicationManager newMessageIndicationManager;
            Set set;
            Object object;
            block3: {
                bl3 = false;
                n = 0;
                entryList = this.msgApp.getEntryList();
                if (bl || entryList.getLength() != 1) break block3;
                object = entryList.getEntry(0);
                if (object == null || !ListEntries.isMessage((ListEntry)object)) break block4;
                this.log.log(1000000, "[MessagingReadoutService#attemptAutoSelectMessage] List is empty except for one message. Attempting to auto-select that message.");
                bl3 = true;
                n = 0;
                break block4;
            }
            if (bl && entryList.getLength() > 0 && (object = this.msgApp.getAccountManager().getSelectedAccount()) != null && (set = (newMessageIndicationManager = this.msgApp.getNewMessageIndicationManager()).getNewMessageIDs(((MessagingAccount)object).getAccountID())).size() == 1) {
                ListEntry listEntry;
                String string = (String)set.iterator().next();
                for (int i2 = 0; i2 < entryList.getLength() && (listEntry = entryList.getEntry(i2)) != null; ++i2) {
                    String string2;
                    if (!ListEntries.isMessage(listEntry) || !string.equals(string2 = listEntry.getMessageListEntry().getMessageID())) continue;
                    this.log.log(1000000, "[MessagingReadoutService#attemptAutoSelectMessage] Account contains exactly one new message and that message is cached in the list. Attempting to auto-select that message.");
                    bl3 = true;
                    n = i2;
                    break;
                }
            }
        }
        if (bl3 && (bl2 = entryList.selectEntry(n))) {
            this.setMessageAutoSelected(true);
        }
    }

    public byte freezeDynamicLists() {
        this.log.log(1000000, "[MessagingReadoutService#freezeDynamicLists]");
        return 0;
    }

    public byte unfreezeDynamicLists() {
        this.log.log(1000000, "[MessagingReadoutService#unfreezeDynamicLists]");
        return 0;
    }

    public IDiagPlugIn[] createDiagPlugIns() {
        return new IDiagPlugIn[]{new MessagingReadoutServiceDiagPlugIn((IMessagingReadoutService)this)};
    }

    static /* synthetic */ Class class$(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new NoClassDefFoundError().initCause(classNotFoundException);
        }
    }

    public static final class DialogState {
        private final boolean isActive;
        private final boolean messageAutoSelected;

        private DialogState(boolean bl, boolean bl2) {
            this.isActive = bl;
            this.messageAutoSelected = bl2;
        }

        public boolean isActive() {
            return this.isActive;
        }

        public boolean messageAutoSelected() {
            return this.messageAutoSelected;
        }
    }

    private final class EntryListObserver
    extends IEntryListObserver.EmptyImplementation {
        private EntryListObserver() {
        }

        public void indicateItemSelected(final ListEntry listEntry, long l) {
            MessagingReadoutService.this.msgApp.getExecutorManager().getInternalTaskDispatcher().execute(new Runnable(){

                public void run() {
                    MessagingReadoutService.this.log.log(10000000, "[MessagingReadoutService$EntryListObserver#indicateItemSelected]");
                    if (MessagingReadoutService.this.state == 1) {
                        boolean bl = ListEntries.isFolder(listEntry);
                        if (bl) {
                            MessagingReadoutService.this.msgApp.getEntryList().signalListReady(false);
                        }
                        MessagingReadoutService.this.emitIndicateFolderContentListItemSelected(bl);
                    }
                }
            });
        }

        public void indicateListDataResponseOnFolderChange() {
            MessagingReadoutService.this.msgApp.getExecutorManager().getInternalTaskDispatcher().execute(new Runnable(){

                public void run() {
                    MessagingReadoutService.this.log.log(10000000, "[MessagingReadoutService$EntryListObserver#indicateListDataResponseOnFolderChange]");
                    if (MessagingReadoutService.this.state == 1) {
                        MessagingReadoutService.this.attemptAutoSelectMessage(MessagingReadoutService.this.newMessageMode);
                    }
                    MessagingReadoutService.this.msgApp.getEntryList().signalListReady(true);
                }
            });
        }
    }

    private final class AccountListObserver
    extends IAccountListObserver.EmptyImplementation {
        private AccountListObserver() {
        }

        public void indicateItemSelected(MessagingAccount messagingAccount) {
            MessagingReadoutService.this.msgApp.getExecutorManager().getInternalTaskDispatcher().execute(new Runnable(){

                public void run() {
                    MessagingReadoutService.this.log.log(10000000, "[MessagingReadoutService$AccountListObserver#indicateItemSelected]");
                    if (MessagingReadoutService.this.state == 1) {
                        MessagingReadoutService.this.msgApp.getFolderNavigator().changeFolderDirect(-3, false);
                    }
                }
            });
        }
    }
}

