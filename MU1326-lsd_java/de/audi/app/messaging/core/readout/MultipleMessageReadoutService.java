/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.messaging.core.readout;

import de.audi.app.messaging.core.accounts.AccountFilter$Builder;
import de.audi.app.messaging.core.accounts.AccountList;
import de.audi.app.messaging.core.accounts.IAccountFilter;
import de.audi.app.messaging.core.application.AbstractMsgApplication;
import de.audi.app.messaging.core.component.AbstractMessagingComponent;
import de.audi.app.messaging.core.folderbrowsing.EntryList;
import de.audi.app.messaging.core.indication.NewMessageIndicationManager;
import de.audi.app.messaging.core.osgi.IServiceRegistry;
import de.audi.app.messaging.core.osgi.MessagingBundleContext;
import de.audi.app.messaging.core.osgi.ServiceFilterBuilder;
import de.audi.app.messaging.core.osgi.ServiceProperties;
import de.audi.app.messaging.core.readout.MultipleMessageReadoutService$1;
import de.audi.app.messaging.core.readout.MultipleMessageReadoutService$2;
import de.audi.app.messaging.core.readout.MultipleMessageReadoutService$3;
import de.audi.app.messaging.core.readout.MultipleMessageReadoutService$4;
import de.audi.app.messaging.core.readout.MultipleMessageReadoutService$5;
import de.audi.app.messaging.core.readout.MultipleMessageReadoutService$6;
import de.audi.app.messaging.core.readout.MultipleMessageReadoutService$7;
import de.audi.app.messaging.core.readout.MultipleMessageReadoutService$8;
import de.audi.app.messaging.core.readout.MultipleMessageReadoutService$DiagPlugIn;
import de.audi.app.messaging.core.readout.MultipleMessageReadoutService$EntryListObserver;
import de.audi.app.messaging.core.readout.MultipleMessageReadoutService$SetMessageHandler;
import de.audi.app.messaging.core.swdiagnosis.IDiagPlugIn;
import de.audi.app.messaging.core.swdiagnosis.IDiagProvider;
import de.audi.app.messaging.core.util.ListEntries;
import de.audi.app.messaging.core.viewmessage.SelectedMessage$ISetMessageResultHandler;
import de.audi.atip.interapp.messaging.IMultipleMessageReadoutService;
import de.audi.atip.interapp.messaging.IMultipleMessageReadoutServiceListener;
import de.audi.atip.log.LogChannel;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.Set;
import org.dsi.ifc.messaging.ListEntry;
import org.dsi.ifc.messaging.MatchedAddress;
import org.dsi.ifc.messaging.MessageListEntry;
import org.dsi.ifc.messaging.MessagingAccount;
import org.osgi.framework.Filter;
import org.osgi.util.tracker.ServiceTracker;
import org.osgi.util.tracker.ServiceTrackerCustomizer;

public class MultipleMessageReadoutService
extends AbstractMessagingComponent
implements IDiagProvider,
IMultipleMessageReadoutService {
    public static final int STATE_IDLE;
    public static final int STATE_ACTIVE;
    private volatile int messageType = 0;
    private volatile int state = 0;
    private volatile Collection currentMessages = new ArrayList(25);
    private volatile Iterator iter;
    private volatile IMultipleMessageReadoutServiceListener multipleMessageReadoutServiceListener;
    private volatile SelectedMessage$ISetMessageResultHandler setMessageResultHandler = new MultipleMessageReadoutService$SetMessageHandler(this, null);
    private boolean newMessageMode = false;
    private volatile IAccountFilter dialogAccountFilter = null;
    static /* synthetic */ Class class$de$audi$atip$interapp$messaging$IMultipleMessageReadoutService;
    static /* synthetic */ Class class$de$audi$atip$interapp$messaging$IMultipleMessageReadoutServiceListener;

    public MultipleMessageReadoutService(MessagingBundleContext messagingBundleContext) {
        super(messagingBundleContext, "App.Messaging.Main");
    }

    @Override
    public void init(AbstractMsgApplication abstractMsgApplication) {
        super.init(abstractMsgApplication);
        abstractMsgApplication.getMessagingSwDiagnosis().registerDiagProvider(this);
        abstractMsgApplication.getEntryList().addObserver(new MultipleMessageReadoutService$EntryListObserver(this, null));
        this.multipleMessageReadoutServiceListener = new MultipleMessageReadoutService$1(this);
    }

    @Override
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

    private ServiceTracker createServiceTracker() {
        String string = ServiceFilterBuilder.createFilterString("objectClass", (class$de$audi$atip$interapp$messaging$IMultipleMessageReadoutServiceListener == null ? (class$de$audi$atip$interapp$messaging$IMultipleMessageReadoutServiceListener = MultipleMessageReadoutService.class$("de.audi.atip.interapp.messaging.IMultipleMessageReadoutServiceListener")) : class$de$audi$atip$interapp$messaging$IMultipleMessageReadoutServiceListener).getName());
        Filter filter = this.bundleContext.createFilter(string);
        MultipleMessageReadoutService$2 multipleMessageReadoutService$2 = new MultipleMessageReadoutService$2(this, this.log, this.bundleContext);
        return new ServiceTracker(this.bundleContext, filter, (ServiceTrackerCustomizer)multipleMessageReadoutService$2);
    }

    public int getDialogState() {
        return this.state;
    }

    @Override
    public void requestBeginDialog(boolean bl, int n) {
        this.msgApp.getExecutorManager().getInternalTaskDispatcher().execute(new MultipleMessageReadoutService$3(this, bl, n));
    }

    @Override
    public void requestEndDialog() {
        this.msgApp.getExecutorManager().getInternalTaskDispatcher().execute(new MultipleMessageReadoutService$4(this));
    }

    @Override
    public boolean isMessageAvailable() {
        boolean bl = this.iter != null && this.iter.hasNext();
        this.log.log(-2137614336, "MultipleMessageReadoutService#isMessageAvailable(): %1 ", bl);
        return bl;
    }

    @Override
    public void requestNextMessage() {
        this.msgApp.getExecutorManager().getInternalTaskDispatcher().execute(new MultipleMessageReadoutService$5(this));
    }

    public void triggerGetNewMessagesFromCurrentSelectedAccount() {
        if (this.state == 1 && this.newMessageMode) {
            this.currentMessages = this.getNewMessages();
            this.log.log(-2137614336, "[MultipleMessageReadoutService$updateCurrentFolder] copied %1 messages", (long)this.currentMessages.size());
        }
    }

    private Collection getNewMessages() {
        this.log.log(-2137614336, "[MultipleMessageReadoutService#getNewMessages] Copying new messages.");
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
        this.log.log(-2137614336, "[MultipleMessageReadoutService#getOldMessages] Copying inbox messages.");
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
            this.log.log(1078071040, "[MultipleMessageReadoutService#attemptAutoSelectAccount] No account for current filter available.");
        } else if (accountList.getLength() == 1) {
            this.log.log(1078071040, "[MultipleMessageReadoutService#attemptAutoSelectAccount] Auto-selecting the only available account.");
            accountList.selectAccount(0);
            bl = true;
        }
        return bl;
    }

    private IAccountFilter getAccountFilter(boolean bl, int n) {
        AccountFilter$Builder accountFilter$Builder = new AccountFilter$Builder();
        int n2 = n == 1 ? 1 : (n == 2 ? 2 : 0);
        accountFilter$Builder.accountType(n2);
        if (bl) {
            Set set = this.msgApp.getNewMessageIndicationManager().getNewMessageAccountSet();
            accountFilter$Builder.newMessagesOnly(true, set);
        }
        return accountFilter$Builder.build();
    }

    private MessageListEntry buildEntryFromId(String string) {
        MessageListEntry messageListEntry = new MessageListEntry();
        messageListEntry.matchedAddress = new MatchedAddress();
        messageListEntry.recipients = new String[0];
        messageListEntry.messageID = string;
        messageListEntry.type = this.messageType == 2 ? 2 : 1;
        return messageListEntry;
    }

    @Override
    public IDiagPlugIn[] createDiagPlugIns() {
        return new IDiagPlugIn[]{new MultipleMessageReadoutService$DiagPlugIn(this)};
    }

    private void emitResponseBeginDialog(int n) {
        this.msgApp.getExecutorManager().getExternalTaskDispatcher().execute(new MultipleMessageReadoutService$6(this, n));
    }

    private void emitResponseNextMessage(int n) {
        this.msgApp.getExecutorManager().getExternalTaskDispatcher().execute(new MultipleMessageReadoutService$7(this, n));
    }

    private void emitResponseEndDialog(int n) {
        this.msgApp.getExecutorManager().getExternalTaskDispatcher().execute(new MultipleMessageReadoutService$8(this, n));
    }

    static /* synthetic */ LogChannel access$000(MultipleMessageReadoutService multipleMessageReadoutService) {
        return multipleMessageReadoutService.log;
    }

    static /* synthetic */ void access$100(MultipleMessageReadoutService multipleMessageReadoutService, int n) {
        multipleMessageReadoutService.emitResponseNextMessage(n);
    }

    static /* synthetic */ LogChannel access$200(MultipleMessageReadoutService multipleMessageReadoutService) {
        return multipleMessageReadoutService.log;
    }

    static /* synthetic */ LogChannel access$500(MultipleMessageReadoutService multipleMessageReadoutService) {
        return multipleMessageReadoutService.log;
    }

    static /* synthetic */ LogChannel access$600(MultipleMessageReadoutService multipleMessageReadoutService) {
        return multipleMessageReadoutService.log;
    }

    static /* synthetic */ LogChannel access$700(MultipleMessageReadoutService multipleMessageReadoutService) {
        return multipleMessageReadoutService.log;
    }

    static /* synthetic */ Class class$(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new NoClassDefFoundError().initCause(classNotFoundException);
        }
    }

    static /* synthetic */ int access$802(MultipleMessageReadoutService multipleMessageReadoutService, int n) {
        multipleMessageReadoutService.state = n;
        return multipleMessageReadoutService.state;
    }

    static /* synthetic */ IMultipleMessageReadoutServiceListener access$902(MultipleMessageReadoutService multipleMessageReadoutService, IMultipleMessageReadoutServiceListener iMultipleMessageReadoutServiceListener) {
        multipleMessageReadoutService.multipleMessageReadoutServiceListener = iMultipleMessageReadoutServiceListener;
        return multipleMessageReadoutService.multipleMessageReadoutServiceListener;
    }

    static /* synthetic */ LogChannel access$1000(MultipleMessageReadoutService multipleMessageReadoutService) {
        return multipleMessageReadoutService.log;
    }

    static /* synthetic */ int access$800(MultipleMessageReadoutService multipleMessageReadoutService) {
        return multipleMessageReadoutService.state;
    }

    static /* synthetic */ boolean access$1102(MultipleMessageReadoutService multipleMessageReadoutService, boolean bl) {
        multipleMessageReadoutService.newMessageMode = bl;
        return multipleMessageReadoutService.newMessageMode;
    }

    static /* synthetic */ int access$1202(MultipleMessageReadoutService multipleMessageReadoutService, int n) {
        multipleMessageReadoutService.messageType = n;
        return multipleMessageReadoutService.messageType;
    }

    static /* synthetic */ AbstractMsgApplication access$1300(MultipleMessageReadoutService multipleMessageReadoutService) {
        return multipleMessageReadoutService.msgApp;
    }

    static /* synthetic */ IAccountFilter access$1400(MultipleMessageReadoutService multipleMessageReadoutService) {
        return multipleMessageReadoutService.dialogAccountFilter;
    }

    static /* synthetic */ IAccountFilter access$1402(MultipleMessageReadoutService multipleMessageReadoutService, IAccountFilter iAccountFilter) {
        multipleMessageReadoutService.dialogAccountFilter = iAccountFilter;
        return multipleMessageReadoutService.dialogAccountFilter;
    }

    static /* synthetic */ int access$1200(MultipleMessageReadoutService multipleMessageReadoutService) {
        return multipleMessageReadoutService.messageType;
    }

    static /* synthetic */ IAccountFilter access$1500(MultipleMessageReadoutService multipleMessageReadoutService, boolean bl, int n) {
        return multipleMessageReadoutService.getAccountFilter(bl, n);
    }

    static /* synthetic */ LogChannel access$1600(MultipleMessageReadoutService multipleMessageReadoutService) {
        return multipleMessageReadoutService.log;
    }

    static /* synthetic */ boolean access$1700(MultipleMessageReadoutService multipleMessageReadoutService) {
        return multipleMessageReadoutService.attemptAutoSelectAccount();
    }

    static /* synthetic */ AbstractMsgApplication access$1800(MultipleMessageReadoutService multipleMessageReadoutService) {
        return multipleMessageReadoutService.msgApp;
    }

    static /* synthetic */ LogChannel access$1900(MultipleMessageReadoutService multipleMessageReadoutService) {
        return multipleMessageReadoutService.log;
    }

    static /* synthetic */ void access$2000(MultipleMessageReadoutService multipleMessageReadoutService, int n) {
        multipleMessageReadoutService.emitResponseBeginDialog(n);
    }

    static /* synthetic */ LogChannel access$2100(MultipleMessageReadoutService multipleMessageReadoutService) {
        return multipleMessageReadoutService.log;
    }

    static /* synthetic */ AbstractMsgApplication access$2200(MultipleMessageReadoutService multipleMessageReadoutService) {
        return multipleMessageReadoutService.msgApp;
    }

    static /* synthetic */ LogChannel access$2300(MultipleMessageReadoutService multipleMessageReadoutService) {
        return multipleMessageReadoutService.log;
    }

    static /* synthetic */ AbstractMsgApplication access$2400(MultipleMessageReadoutService multipleMessageReadoutService) {
        return multipleMessageReadoutService.msgApp;
    }

    static /* synthetic */ void access$2500(MultipleMessageReadoutService multipleMessageReadoutService, int n) {
        multipleMessageReadoutService.emitResponseEndDialog(n);
    }

    static /* synthetic */ Iterator access$2600(MultipleMessageReadoutService multipleMessageReadoutService) {
        return multipleMessageReadoutService.iter;
    }

    static /* synthetic */ boolean access$1100(MultipleMessageReadoutService multipleMessageReadoutService) {
        return multipleMessageReadoutService.newMessageMode;
    }

    static /* synthetic */ LogChannel access$2700(MultipleMessageReadoutService multipleMessageReadoutService) {
        return multipleMessageReadoutService.log;
    }

    static /* synthetic */ AbstractMsgApplication access$2800(MultipleMessageReadoutService multipleMessageReadoutService) {
        return multipleMessageReadoutService.msgApp;
    }

    static /* synthetic */ SelectedMessage$ISetMessageResultHandler access$2900(MultipleMessageReadoutService multipleMessageReadoutService) {
        return multipleMessageReadoutService.setMessageResultHandler;
    }

    static /* synthetic */ AbstractMsgApplication access$3000(MultipleMessageReadoutService multipleMessageReadoutService) {
        return multipleMessageReadoutService.msgApp;
    }

    static /* synthetic */ MessageListEntry access$3100(MultipleMessageReadoutService multipleMessageReadoutService, String string) {
        return multipleMessageReadoutService.buildEntryFromId(string);
    }

    static /* synthetic */ LogChannel access$3200(MultipleMessageReadoutService multipleMessageReadoutService) {
        return multipleMessageReadoutService.log;
    }

    static /* synthetic */ AbstractMsgApplication access$3300(MultipleMessageReadoutService multipleMessageReadoutService) {
        return multipleMessageReadoutService.msgApp;
    }

    static /* synthetic */ AbstractMsgApplication access$3400(MultipleMessageReadoutService multipleMessageReadoutService) {
        return multipleMessageReadoutService.msgApp;
    }

    static /* synthetic */ LogChannel access$3500(MultipleMessageReadoutService multipleMessageReadoutService) {
        return multipleMessageReadoutService.log;
    }

    static /* synthetic */ AbstractMsgApplication access$3700(MultipleMessageReadoutService multipleMessageReadoutService) {
        return multipleMessageReadoutService.msgApp;
    }

    static /* synthetic */ AbstractMsgApplication access$3800(MultipleMessageReadoutService multipleMessageReadoutService) {
        return multipleMessageReadoutService.msgApp;
    }

    static /* synthetic */ Collection access$3902(MultipleMessageReadoutService multipleMessageReadoutService, Collection collection) {
        multipleMessageReadoutService.currentMessages = collection;
        return multipleMessageReadoutService.currentMessages;
    }

    static /* synthetic */ Collection access$4000(MultipleMessageReadoutService multipleMessageReadoutService) {
        return multipleMessageReadoutService.getOldMessages();
    }

    static /* synthetic */ Collection access$3900(MultipleMessageReadoutService multipleMessageReadoutService) {
        return multipleMessageReadoutService.currentMessages;
    }

    static /* synthetic */ LogChannel access$4100(MultipleMessageReadoutService multipleMessageReadoutService) {
        return multipleMessageReadoutService.log;
    }

    static /* synthetic */ LogChannel access$4200(MultipleMessageReadoutService multipleMessageReadoutService) {
        return multipleMessageReadoutService.log;
    }

    static /* synthetic */ AbstractMsgApplication access$4300(MultipleMessageReadoutService multipleMessageReadoutService) {
        return multipleMessageReadoutService.msgApp;
    }

    static /* synthetic */ AbstractMsgApplication access$4400(MultipleMessageReadoutService multipleMessageReadoutService) {
        return multipleMessageReadoutService.msgApp;
    }

    static /* synthetic */ LogChannel access$4500(MultipleMessageReadoutService multipleMessageReadoutService) {
        return multipleMessageReadoutService.log;
    }

    static /* synthetic */ IMultipleMessageReadoutServiceListener access$900(MultipleMessageReadoutService multipleMessageReadoutService) {
        return multipleMessageReadoutService.multipleMessageReadoutServiceListener;
    }

    static /* synthetic */ LogChannel access$4600(MultipleMessageReadoutService multipleMessageReadoutService) {
        return multipleMessageReadoutService.log;
    }

    static /* synthetic */ LogChannel access$4700(MultipleMessageReadoutService multipleMessageReadoutService) {
        return multipleMessageReadoutService.log;
    }

    static /* synthetic */ AbstractMsgApplication access$4800(MultipleMessageReadoutService multipleMessageReadoutService) {
        return multipleMessageReadoutService.msgApp;
    }

    static /* synthetic */ LogChannel access$4900(MultipleMessageReadoutService multipleMessageReadoutService) {
        return multipleMessageReadoutService.log;
    }

    static /* synthetic */ LogChannel access$5000(MultipleMessageReadoutService multipleMessageReadoutService) {
        return multipleMessageReadoutService.log;
    }

    static /* synthetic */ LogChannel access$5100(MultipleMessageReadoutService multipleMessageReadoutService) {
        return multipleMessageReadoutService.log;
    }

    static /* synthetic */ LogChannel access$5200(MultipleMessageReadoutService multipleMessageReadoutService) {
        return multipleMessageReadoutService.log;
    }
}

