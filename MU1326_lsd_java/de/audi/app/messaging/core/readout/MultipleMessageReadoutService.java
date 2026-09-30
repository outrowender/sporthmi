/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.messaging.core.readout;

import de.audi.app.messaging.core.accounts.AccountFilter;
import de.audi.app.messaging.core.accounts.AccountList;
import de.audi.app.messaging.core.accounts.IAccountFilter;
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
import de.audi.app.messaging.core.viewmessage.SelectedMessage;
import de.audi.atip.interapp.messaging.IMultipleMessageReadoutService;
import de.audi.atip.interapp.messaging.IMultipleMessageReadoutServiceListener;
import de.esolutions.fw.util.commons.Buffer;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.Set;
import org.dsi.ifc.messaging.ListEntry;
import org.dsi.ifc.messaging.MatchedAddress;
import org.dsi.ifc.messaging.MessageDetails;
import org.dsi.ifc.messaging.MessageListEntry;
import org.dsi.ifc.messaging.MessagingAccount;
import org.osgi.framework.Filter;
import org.osgi.framework.InvalidSyntaxException;
import org.osgi.framework.ServiceReference;
import org.osgi.util.tracker.ServiceTracker;
import org.osgi.util.tracker.ServiceTrackerCustomizer;

public class MultipleMessageReadoutService
extends AbstractMessagingComponent
implements IDiagProvider,
IMultipleMessageReadoutService {
    public static final int STATE_IDLE = 0;
    public static final int STATE_ACTIVE = 1;
    private volatile int messageType = 0;
    private volatile int state = 0;
    private volatile Collection currentMessages = new ArrayList(25);
    private volatile Iterator iter;
    private volatile IMultipleMessageReadoutServiceListener multipleMessageReadoutServiceListener;
    private volatile SelectedMessage.ISetMessageResultHandler setMessageResultHandler = new SetMessageHandler();
    private boolean newMessageMode = false;
    private volatile IAccountFilter dialogAccountFilter = null;
    static /* synthetic */ Class class$de$audi$atip$interapp$messaging$IMultipleMessageReadoutService;
    static /* synthetic */ Class class$de$audi$atip$interapp$messaging$IMultipleMessageReadoutServiceListener;

    public MultipleMessageReadoutService(MessagingBundleContext messagingBundleContext) {
        super(messagingBundleContext, "App.Messaging.Main");
    }

    public void init(AbstractMsgApplication abstractMsgApplication) {
        super.init(abstractMsgApplication);
        abstractMsgApplication.getMessagingSwDiagnosis().registerDiagProvider(this);
        abstractMsgApplication.getEntryList().addObserver(new EntryListObserver());
        this.multipleMessageReadoutServiceListener = new IMultipleMessageReadoutServiceListener(){

            public void responseNextMessage(int n, String string) {
                MultipleMessageReadoutService.this.log.log(1000000, "[IMultipleMessageReadoutServiceListener#responseNextMessage] result = %2, message = %1", (Object)string, (long)n);
            }

            public void responseEndDialog(int n) {
                MultipleMessageReadoutService.this.log.log(1000000, "[IMultipleMessageReadoutServiceListener#responseEndDialog] result = %1", (long)n);
            }

            public void responseBeginDialog(int n) {
                MultipleMessageReadoutService.this.log.log(1000000, "[IMultipleMessageReadoutServiceListener#responseBeginDialog] result = %1", (long)n);
            }
        };
    }

    public void connect(IServiceRegistry iServiceRegistry) {
        try {
            super.connect(iServiceRegistry);
            iServiceRegistry.registerService((class$de$audi$atip$interapp$messaging$IMultipleMessageReadoutService == null ? (class$de$audi$atip$interapp$messaging$IMultipleMessageReadoutService = MultipleMessageReadoutService.class$("de.audi.atip.interapp.messaging.IMultipleMessageReadoutService")) : class$de$audi$atip$interapp$messaging$IMultipleMessageReadoutService).getName(), (Object)this, ServiceProperties.createServiceProperties());
            iServiceRegistry.addTracker(this.createServiceTracker());
        }
        catch (Exception exception) {
            this.log.log(10000, "[IMultipleMessageReadoutServiceListener#connect] An error occurred: ", (Throwable)exception);
        }
    }

    private ServiceTracker createServiceTracker() throws InvalidSyntaxException {
        String string = ServiceFilterBuilder.createFilterString("objectClass", (class$de$audi$atip$interapp$messaging$IMultipleMessageReadoutServiceListener == null ? (class$de$audi$atip$interapp$messaging$IMultipleMessageReadoutServiceListener = MultipleMessageReadoutService.class$("de.audi.atip.interapp.messaging.IMultipleMessageReadoutServiceListener")) : class$de$audi$atip$interapp$messaging$IMultipleMessageReadoutServiceListener).getName());
        Filter filter = this.bundleContext.createFilter(string);
        AbstractMessagingTrackerCustomizer abstractMessagingTrackerCustomizer = new AbstractMessagingTrackerCustomizer(this.log, this.bundleContext){

            public void addService(ServiceReference serviceReference, Object object) {
                MultipleMessageReadoutService.this.state = 0;
                MultipleMessageReadoutService.this.multipleMessageReadoutServiceListener = (IMultipleMessageReadoutServiceListener)object;
            }

            public void removeService(ServiceReference serviceReference, Object object) {
                MultipleMessageReadoutService.this.state = 0;
                MultipleMessageReadoutService.this.multipleMessageReadoutServiceListener = null;
            }
        };
        return new ServiceTracker(this.bundleContext, filter, (ServiceTrackerCustomizer)abstractMessagingTrackerCustomizer);
    }

    public int getDialogState() {
        return this.state;
    }

    public void requestBeginDialog(final boolean bl, final int n) {
        this.msgApp.getExecutorManager().getInternalTaskDispatcher().execute(new Runnable(){

            /*
             * WARNING - Removed try catching itself - possible behaviour change.
             */
            public void run() {
                int n2 = 0;
                try {
                    MultipleMessageReadoutService.this.log.log(10000000, "MultipleMessageReadoutService#requestBeginDialog()");
                    if (MultipleMessageReadoutService.this.state != 0) {
                        n2 = 3;
                    }
                    MultipleMessageReadoutService.this.state = 1;
                    MultipleMessageReadoutService.this.newMessageMode = bl;
                    MultipleMessageReadoutService.this.messageType = n;
                    AccountList accountList = MultipleMessageReadoutService.this.msgApp.getAccountManager().getDialogAccountList();
                    accountList.removeAccountFilter(MultipleMessageReadoutService.this.dialogAccountFilter);
                    MultipleMessageReadoutService.this.dialogAccountFilter = MultipleMessageReadoutService.this.getAccountFilter(bl, MultipleMessageReadoutService.this.messageType);
                    accountList.addAccountFilter(MultipleMessageReadoutService.this.dialogAccountFilter);
                    MultipleMessageReadoutService.this.log.log(1000000, "MultipleMessageReadoutService#requestBeginDialog(): filter type %1 matched to %2 accounts.", (long)n, (long)accountList.getLength());
                    MultipleMessageReadoutService.this.attemptAutoSelectAccount();
                    MultipleMessageReadoutService.this.msgApp.getEntryList().signalListReady(false);
                }
                catch (Exception exception) {
                    Logs.logException(MultipleMessageReadoutService.this.log, exception, "[MultipleMessageReadoutService#requestBeginDialog]");
                    n2 = 1;
                    MultipleMessageReadoutService.this.emitResponseBeginDialog(n2);
                }
                finally {
                    MultipleMessageReadoutService.this.emitResponseBeginDialog(n2);
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
                    MultipleMessageReadoutService.this.log.log(1000000, "[MultipleMessageReadoutService#requestEndDialog]");
                    AccountList accountList = MultipleMessageReadoutService.this.msgApp.getAccountManager().getDialogAccountList();
                    accountList.removeAccountFilter(MultipleMessageReadoutService.this.dialogAccountFilter);
                    MultipleMessageReadoutService.this.state = 0;
                }
                catch (Exception exception) {
                    Logs.logException(MultipleMessageReadoutService.this.log, exception, "[MultipleMessageReadoutService#requestEndDialog]");
                    n = 1;
                }
                finally {
                    MultipleMessageReadoutService.this.msgApp.getEntryList().signalListReady(true);
                    MultipleMessageReadoutService.this.emitResponseEndDialog(n);
                }
            }
        });
    }

    public boolean isMessageAvailable() {
        boolean bl = this.iter != null && this.iter.hasNext();
        this.log.log(10000000, "MultipleMessageReadoutService#isMessageAvailable(): %1 ", bl);
        return bl;
    }

    public void requestNextMessage() {
        this.msgApp.getExecutorManager().getInternalTaskDispatcher().execute(new Runnable(){

            public void run() {
                int n = 1;
                try {
                    if (MultipleMessageReadoutService.this.state == 0) {
                        n = 3;
                        MultipleMessageReadoutService.this.emitResponseNextMessage(n);
                    } else if (MultipleMessageReadoutService.this.iter != null && MultipleMessageReadoutService.this.iter.hasNext()) {
                        if (!MultipleMessageReadoutService.this.newMessageMode) {
                            MessageListEntry messageListEntry = (MessageListEntry)MultipleMessageReadoutService.this.iter.next();
                            MultipleMessageReadoutService.this.log.log(1000000, "[MultipleMessageReadoutService#requestNextMessage] Requesting old message %1.", (Object)messageListEntry.getMessageID());
                            MultipleMessageReadoutService.this.msgApp.getMessageOptionsManager().setFocusedMessageListEntry(messageListEntry);
                            MultipleMessageReadoutService.this.msgApp.getSelectedMessage().requestSetMessage(messageListEntry, 0, MultipleMessageReadoutService.this.setMessageResultHandler);
                        } else {
                            String string = (String)MultipleMessageReadoutService.this.iter.next();
                            MessageListEntry messageListEntry = MultipleMessageReadoutService.this.buildEntryFromId(string);
                            MultipleMessageReadoutService.this.log.log(1000000, "[MultipleMessageReadoutService#requestNextMessage] Requesting new message %1.", (Object)string);
                            MultipleMessageReadoutService.this.msgApp.getMessageOptionsManager().setFocusedMessageListEntry(messageListEntry);
                            MultipleMessageReadoutService.this.msgApp.getSelectedMessage().requestSetMessage(messageListEntry, 0, MultipleMessageReadoutService.this.setMessageResultHandler);
                        }
                    } else {
                        n = 4;
                        MultipleMessageReadoutService.this.emitResponseNextMessage(n);
                    }
                }
                catch (Exception exception) {
                    Logs.logException(MultipleMessageReadoutService.this.log, exception, "[MultipleMessageReadoutService#requestNextMessage]");
                    MultipleMessageReadoutService.this.emitResponseNextMessage(n);
                }
            }
        });
    }

    public void triggerGetNewMessagesFromCurrentSelectedAccount() {
        if (this.state == 1 && this.newMessageMode) {
            this.currentMessages = this.getNewMessages();
            this.log.log(10000000, "[MultipleMessageReadoutService$updateCurrentFolder] copied %1 messages", (long)this.currentMessages.size());
        }
    }

    private Collection getNewMessages() {
        this.log.log(10000000, "[MultipleMessageReadoutService#getNewMessages] Copying new messages.");
        Collection collection = Collections.EMPTY_SET;
        MessagingAccount messagingAccount = this.msgApp.getAccountManager().getSelectedAccount();
        if (messagingAccount != null) {
            NewMessageIndicationManager newMessageIndicationManager = this.msgApp.getNewMessageIndicationManager();
            collection = new ArrayList(newMessageIndicationManager.getNewMessageIDs(messagingAccount.getAccountID()));
        }
        this.iter = collection.iterator();
        return collection;
    }

    private Collection getOldMessages() {
        this.log.log(10000000, "[MultipleMessageReadoutService#getOldMessages] Copying inbox messages.");
        ArrayList arrayList = new ArrayList();
        EntryList entryList = this.msgApp.getEntryList();
        for (int i2 = 0; i2 < entryList.getLength(); ++i2) {
            ListEntry listEntry = entryList.getEntry(i2);
            if (listEntry == null || !ListEntries.isMessage(listEntry)) continue;
            arrayList.add(listEntry.getMessageListEntry());
        }
        this.iter = arrayList.iterator();
        return arrayList;
    }

    private boolean attemptAutoSelectAccount() {
        boolean bl = false;
        AccountList accountList = this.msgApp.getAccountManager().getDialogAccountList();
        if (accountList.getLength() == 0) {
            this.log.log(1000000, "[MultipleMessageReadoutService#attemptAutoSelectAccount] No account for current filter available.");
        } else if (accountList.getLength() == 1) {
            this.log.log(1000000, "[MultipleMessageReadoutService#attemptAutoSelectAccount] Auto-selecting the only available account.");
            accountList.selectAccount(0);
            bl = true;
        }
        return bl;
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

    private MessageListEntry buildEntryFromId(String string) {
        MessageListEntry messageListEntry = new MessageListEntry();
        messageListEntry.matchedAddress = new MatchedAddress();
        messageListEntry.recipients = new String[0];
        messageListEntry.messageID = string;
        messageListEntry.type = this.messageType == 2 ? 2 : 1;
        return messageListEntry;
    }

    public IDiagPlugIn[] createDiagPlugIns() {
        return new IDiagPlugIn[]{new DiagPlugIn()};
    }

    private void emitResponseBeginDialog(final int n) {
        this.msgApp.getExecutorManager().getExternalTaskDispatcher().execute(new Runnable(){

            public void run() {
                try {
                    MultipleMessageReadoutService.this.log.log(1000000, "[MultipleMessageReadoutService#emitResponseBeginDialog] result = %1", (long)n);
                    MultipleMessageReadoutService.this.multipleMessageReadoutServiceListener.responseBeginDialog(n);
                }
                catch (Exception exception) {
                    Logs.logException(MultipleMessageReadoutService.this.log, exception, "[MultipleMessageReadoutService#emitResponseBeginDialog]");
                }
            }
        });
    }

    private void emitResponseNextMessage(final int n) {
        this.msgApp.getExecutorManager().getExternalTaskDispatcher().execute(new Runnable(){

            public void run() {
                try {
                    Buffer buffer = new Buffer();
                    MultipleMessageReadoutService.this.log.log(1000000, "[MultipleMessageReadoutService#emitResponseNextMessage] result = %1", (long)n);
                    if (n == 0) {
                        IReadable iReadable = MultipleMessageReadoutService.this.msgApp.getMessageReader().getReadableProvider().getReadable();
                        if (iReadable != null) {
                            while (iReadable.hasNextSpeakTask()) {
                                buffer.append(iReadable.nextSpeakTask());
                            }
                        } else {
                            MultipleMessageReadoutService.this.log.log(100000, "[MultipleMessageReadoutService#emitResponseNextMessage] readable is NULL");
                        }
                    }
                    MultipleMessageReadoutService.this.multipleMessageReadoutServiceListener.responseNextMessage(n, buffer.toString());
                }
                catch (Exception exception) {
                    Logs.logException(MultipleMessageReadoutService.this.log, exception, "[MultipleMessageReadoutService#emitResponseNextMessage]");
                }
            }
        });
    }

    private void emitResponseEndDialog(final int n) {
        this.msgApp.getExecutorManager().getExternalTaskDispatcher().execute(new Runnable(){

            public void run() {
                try {
                    MultipleMessageReadoutService.this.log.log(1000000, "[MultipleMessageReadoutService#emitResponseEndDialog] result = %1", (long)n);
                    MultipleMessageReadoutService.this.multipleMessageReadoutServiceListener.responseEndDialog(n);
                }
                catch (Exception exception) {
                    Logs.logException(MultipleMessageReadoutService.this.log, exception, "[MultipleMessageReadoutService#emitResponseEndDialog]");
                }
            }
        });
    }

    static /* synthetic */ Class class$(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new NoClassDefFoundError().initCause(classNotFoundException);
        }
    }

    final class DiagPlugIn
    implements IDiagPlugIn {
        DiagPlugIn() {
        }

        public void cmdMultipleMessageBeginDialog(boolean bl, int n) {
            MultipleMessageReadoutService.this.requestBeginDialog(bl, n);
        }

        public void cmdMultipleMessageRequestNextMessage() {
            MultipleMessageReadoutService.this.requestNextMessage();
        }

        public void cmdMultipleMessageEndDialog() {
            MultipleMessageReadoutService.this.requestNextMessage();
        }
    }

    private final class EntryListObserver
    extends IEntryListObserver.EmptyImplementation {
        private EntryListObserver() {
        }

        public void indicateListDataResponseOnFolderChange() {
            MultipleMessageReadoutService.this.msgApp.getExecutorManager().getInternalTaskDispatcher().execute(new Runnable(){

                public void run() {
                    if (MultipleMessageReadoutService.this.state == 1) {
                        if (MultipleMessageReadoutService.this.msgApp.getFolderNavigator().getCurrentFolder().isValid() && MultipleMessageReadoutService.this.msgApp.getFolderNavigator().getCurrentFolder().getHmiFolderType() == 4) {
                            if (!MultipleMessageReadoutService.this.newMessageMode) {
                                MultipleMessageReadoutService.this.currentMessages = MultipleMessageReadoutService.this.getOldMessages();
                                MultipleMessageReadoutService.this.log.log(10000000, "[MultipleMessageReadoutService$EntryListObserver#indicateListDataResponseOnFolderChange] copied %1 messages", (long)MultipleMessageReadoutService.this.currentMessages.size());
                            }
                            MultipleMessageReadoutService.this.emitResponseBeginDialog(0);
                        } else {
                            MultipleMessageReadoutService.this.log.log(100000, "[MultipleMessageReadoutService$EntryListObserver#indicateListDataResponseOnFolderChange] folder change failed", (long)MultipleMessageReadoutService.this.currentMessages.size());
                            MultipleMessageReadoutService.this.emitResponseBeginDialog(1);
                        }
                    }
                    MultipleMessageReadoutService.this.msgApp.getEntryList().signalListReady(true);
                }
            });
        }
    }

    private class SetMessageHandler
    implements SelectedMessage.ISetMessageResultHandler {
        private SetMessageHandler() {
        }

        public void responseSetMessage(boolean bl, MessageDetails messageDetails) {
            if (bl) {
                MultipleMessageReadoutService.this.log.log(10000000, "[MultipleMessageReadoutService#responseSetMessage] Message set.");
                MultipleMessageReadoutService.this.emitResponseNextMessage(0);
            } else {
                MultipleMessageReadoutService.this.log.log(100000, "[MultipleMessageReadoutService#responseSetMessage] Message could not be loaded.");
                MultipleMessageReadoutService.this.emitResponseNextMessage(1);
            }
        }
    }
}

