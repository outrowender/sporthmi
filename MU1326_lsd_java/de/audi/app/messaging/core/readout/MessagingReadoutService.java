/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  de.mib.swdiagnosis.msg.core.readout.MessagingReadoutServiceDiagPlugIn
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
import de.audi.app.messaging.core.readout.IReadable;
import de.audi.app.messaging.core.readout.MessagingReadoutService$1;
import de.audi.app.messaging.core.readout.MessagingReadoutService$10;
import de.audi.app.messaging.core.readout.MessagingReadoutService$11;
import de.audi.app.messaging.core.readout.MessagingReadoutService$2;
import de.audi.app.messaging.core.readout.MessagingReadoutService$3;
import de.audi.app.messaging.core.readout.MessagingReadoutService$4;
import de.audi.app.messaging.core.readout.MessagingReadoutService$5;
import de.audi.app.messaging.core.readout.MessagingReadoutService$6;
import de.audi.app.messaging.core.readout.MessagingReadoutService$7;
import de.audi.app.messaging.core.readout.MessagingReadoutService$8;
import de.audi.app.messaging.core.readout.MessagingReadoutService$9;
import de.audi.app.messaging.core.readout.MessagingReadoutService$AccountListObserver;
import de.audi.app.messaging.core.readout.MessagingReadoutService$DialogState;
import de.audi.app.messaging.core.readout.MessagingReadoutService$EntryListObserver;
import de.audi.app.messaging.core.swdiagnosis.IDiagPlugIn;
import de.audi.app.messaging.core.swdiagnosis.IDiagProvider;
import de.audi.app.messaging.core.util.ListEntries;
import de.audi.atip.interapp.IMessagingReadoutService;
import de.audi.atip.interapp.IMessagingReadoutServiceListener;
import de.audi.atip.log.LogChannel;
import de.esolutions.fw.util.commons.Buffer;
import de.mib.swdiagnosis.msg.core.readout.MessagingReadoutServiceDiagPlugIn;
import java.util.Set;
import org.dsi.ifc.messaging.ListEntry;
import org.dsi.ifc.messaging.MessagingAccount;
import org.osgi.framework.Filter;
import org.osgi.util.tracker.ServiceTracker;
import org.osgi.util.tracker.ServiceTrackerCustomizer;

public final class MessagingReadoutService
extends AbstractMessagingComponent
implements IMessagingReadoutService,
IDiagProvider {
    private static final int STATE_IDLE;
    private static final int STATE_ACTIVE;
    private static final int RQ_NONE;
    private static final int RQ_READOUT_MESSAGE;
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

    @Override
    public void init(AbstractMsgApplication abstractMsgApplication) {
        super.init(abstractMsgApplication);
        abstractMsgApplication.getAccountManager().getDialogAccountList().addObserver(new MessagingReadoutService$AccountListObserver(this, null));
        abstractMsgApplication.getEntryList().addObserver(new MessagingReadoutService$EntryListObserver(this, null));
        abstractMsgApplication.getMessagingSwDiagnosis().registerDiagProvider(this);
    }

    @Override
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

    private ServiceTracker createServiceTracker() {
        String string = ServiceFilterBuilder.createFilterString("objectClass", (class$de$audi$atip$interapp$IMessagingReadoutServiceListener == null ? (class$de$audi$atip$interapp$IMessagingReadoutServiceListener = MessagingReadoutService.class$("de.audi.atip.interapp.IMessagingReadoutServiceListener")) : class$de$audi$atip$interapp$IMessagingReadoutServiceListener).getName());
        Filter filter = this.bundleContext.createFilter(string);
        MessagingReadoutService$1 messagingReadoutService$1 = new MessagingReadoutService$1(this, this.log, this.bundleContext);
        return new ServiceTracker(this.bundleContext, filter, (ServiceTrackerCustomizer)messagingReadoutService$1);
    }

    private void setReadoutSessionState(int n) {
        this.log.log(-2137614336, "[MessagingReadoutService#setReadoutSessionState] state = %1", (long)n);
        this.state = n;
    }

    private void logIllegalState(String string, int n, int n2) {
        this.log.log(-1601830656, "%1 Invalid request: currentState = %2, currentRequest = %3", (Object)string, (Object)String.valueOf(n), (Object)String.valueOf(n2));
    }

    public MessagingReadoutService$DialogState getDialogState() {
        return new MessagingReadoutService$DialogState(this.state == 1, this.messageAutoSelected, null);
    }

    public void notifyTtsSessionStarted() {
        this.msgApp.getExecutorManager().getInternalTaskDispatcher().execute(new MessagingReadoutService$2(this));
    }

    public void notifyTtsSessionStopped() {
        this.msgApp.getExecutorManager().getInternalTaskDispatcher().execute(new MessagingReadoutService$3(this));
    }

    private void setMessageAutoSelected(boolean bl) {
        this.messageAutoSelected = bl;
        int n = bl ? 1 : 0;
        this.framework.getHmiServiceApp().getChoiceModel(-342744832).setValue(n);
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

    private void emitResponseBeginDialog(int n) {
        this.msgApp.getExecutorManager().getExternalTaskDispatcher().execute(new MessagingReadoutService$4(this, n));
    }

    private void emitResponseEndDialog(int n) {
        this.msgApp.getExecutorManager().getExternalTaskDispatcher().execute(new MessagingReadoutService$5(this, n));
    }

    private void emitResponseReadoutMessage(int n) {
        this.msgApp.getExecutorManager().getExternalTaskDispatcher().execute(new MessagingReadoutService$6(this, n));
    }

    private void emitIndicateFolderContentListItemSelected(boolean bl) {
        this.msgApp.getExecutorManager().getExternalTaskDispatcher().execute(new MessagingReadoutService$7(this, bl));
    }

    @Override
    public void requestBeginDialog(boolean bl, int n, int n2) {
        this.msgApp.getExecutorManager().getInternalTaskDispatcher().execute(new MessagingReadoutService$8(this, n, n2, bl));
    }

    @Override
    public void requestEndDialog() {
        this.msgApp.getExecutorManager().getInternalTaskDispatcher().execute(new MessagingReadoutService$9(this));
    }

    @Override
    public void requestReadoutMessage() {
        this.msgApp.getExecutorManager().getInternalTaskDispatcher().execute(new MessagingReadoutService$10(this));
    }

    @Override
    public String requestReadoutText() {
        this.log.log(1078071040, "[MessagingReadoutService#requestReadoutText]");
        Buffer buffer = new Buffer();
        if (this.msgApp.getSelectedMessage().isInDetailView()) {
            IReadable iReadable = this.msgApp.getMessageReader().getReadableProvider().getReadable();
            if (iReadable != null) {
                while (iReadable.hasNextSpeakTask()) {
                    buffer.append(iReadable.nextSpeakTask());
                }
            } else {
                this.log.log(-2137614336, "[MessagingReadoutService#requestReadoutText] readable is NULL");
            }
        }
        this.log.log(-2137614336, "[MessagingReadoutService#requestReadoutText] readout: %1", (Object)buffer.toString());
        return buffer.toString();
    }

    @Override
    public void requestBeginLastSelectedEntry() {
        this.msgApp.getExecutorManager().getInternalTaskDispatcher().execute(new MessagingReadoutService$11(this));
    }

    private void attemptAutoSelectAccount() {
        AccountList accountList = this.msgApp.getAccountManager().getDialogAccountList();
        if (accountList.getLength() == 1) {
            this.log.log(1078071040, "[MessagingReadoutService#attemptAutoSelectAccount] Auto-selecting the only available account.");
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
                this.log.log(1078071040, "[MessagingReadoutService#attemptAutoSelectMessage] List is empty except for one message. Attempting to auto-select that message.");
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
                    this.log.log(1078071040, "[MessagingReadoutService#attemptAutoSelectMessage] Account contains exactly one new message and that message is cached in the list. Attempting to auto-select that message.");
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

    @Override
    public byte freezeDynamicLists() {
        this.log.log(1078071040, "[MessagingReadoutService#freezeDynamicLists]");
        return 0;
    }

    @Override
    public byte unfreezeDynamicLists() {
        this.log.log(1078071040, "[MessagingReadoutService#unfreezeDynamicLists]");
        return 0;
    }

    @Override
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

    static /* synthetic */ int access$202(MessagingReadoutService messagingReadoutService, int n) {
        messagingReadoutService.state = n;
        return messagingReadoutService.state;
    }

    static /* synthetic */ int access$302(MessagingReadoutService messagingReadoutService, int n) {
        messagingReadoutService.currentRequest = n;
        return messagingReadoutService.currentRequest;
    }

    static /* synthetic */ IMessagingReadoutServiceListener access$402(MessagingReadoutService messagingReadoutService, IMessagingReadoutServiceListener iMessagingReadoutServiceListener) {
        messagingReadoutService.messagingReadoutServiceListener = iMessagingReadoutServiceListener;
        return messagingReadoutService.messagingReadoutServiceListener;
    }

    static /* synthetic */ LogChannel access$600(MessagingReadoutService messagingReadoutService) {
        return messagingReadoutService.log;
    }

    static /* synthetic */ int access$300(MessagingReadoutService messagingReadoutService) {
        return messagingReadoutService.currentRequest;
    }

    static /* synthetic */ void access$700(MessagingReadoutService messagingReadoutService, int n) {
        messagingReadoutService.emitResponseReadoutMessage(n);
    }

    static /* synthetic */ LogChannel access$800(MessagingReadoutService messagingReadoutService) {
        return messagingReadoutService.log;
    }

    static /* synthetic */ LogChannel access$900(MessagingReadoutService messagingReadoutService) {
        return messagingReadoutService.log;
    }

    static /* synthetic */ IMessagingReadoutServiceListener access$400(MessagingReadoutService messagingReadoutService) {
        return messagingReadoutService.messagingReadoutServiceListener;
    }

    static /* synthetic */ LogChannel access$1000(MessagingReadoutService messagingReadoutService) {
        return messagingReadoutService.log;
    }

    static /* synthetic */ LogChannel access$1100(MessagingReadoutService messagingReadoutService) {
        return messagingReadoutService.log;
    }

    static /* synthetic */ LogChannel access$1200(MessagingReadoutService messagingReadoutService) {
        return messagingReadoutService.log;
    }

    static /* synthetic */ LogChannel access$1300(MessagingReadoutService messagingReadoutService) {
        return messagingReadoutService.log;
    }

    static /* synthetic */ LogChannel access$1400(MessagingReadoutService messagingReadoutService) {
        return messagingReadoutService.log;
    }

    static /* synthetic */ LogChannel access$1500(MessagingReadoutService messagingReadoutService) {
        return messagingReadoutService.log;
    }

    static /* synthetic */ LogChannel access$1600(MessagingReadoutService messagingReadoutService) {
        return messagingReadoutService.log;
    }

    static /* synthetic */ LogChannel access$1700(MessagingReadoutService messagingReadoutService) {
        return messagingReadoutService.log;
    }

    static /* synthetic */ int access$200(MessagingReadoutService messagingReadoutService) {
        return messagingReadoutService.state;
    }

    static /* synthetic */ void access$1800(MessagingReadoutService messagingReadoutService, String string, int n, int n2) {
        messagingReadoutService.logIllegalState(string, n, n2);
    }

    static /* synthetic */ boolean access$1902(MessagingReadoutService messagingReadoutService, boolean bl) {
        messagingReadoutService.newMessageMode = bl;
        return messagingReadoutService.newMessageMode;
    }

    static /* synthetic */ void access$2000(MessagingReadoutService messagingReadoutService, boolean bl) {
        messagingReadoutService.setMessageAutoSelected(bl);
    }

    static /* synthetic */ AbstractMsgApplication access$2100(MessagingReadoutService messagingReadoutService) {
        return messagingReadoutService.msgApp;
    }

    static /* synthetic */ AbstractMsgApplication access$2200(MessagingReadoutService messagingReadoutService) {
        return messagingReadoutService.msgApp;
    }

    static /* synthetic */ AbstractMsgApplication access$2300(MessagingReadoutService messagingReadoutService) {
        return messagingReadoutService.msgApp;
    }

    static /* synthetic */ IAccountFilter access$2400(MessagingReadoutService messagingReadoutService) {
        return messagingReadoutService.dialogAccountFilter;
    }

    static /* synthetic */ IAccountFilter access$2402(MessagingReadoutService messagingReadoutService, IAccountFilter iAccountFilter) {
        messagingReadoutService.dialogAccountFilter = iAccountFilter;
        return messagingReadoutService.dialogAccountFilter;
    }

    static /* synthetic */ IAccountFilter access$2500(MessagingReadoutService messagingReadoutService, boolean bl, int n) {
        return messagingReadoutService.getAccountFilter(bl, n);
    }

    static /* synthetic */ void access$2600(MessagingReadoutService messagingReadoutService) {
        messagingReadoutService.attemptAutoSelectAccount();
    }

    static /* synthetic */ void access$2700(MessagingReadoutService messagingReadoutService, boolean bl) {
        messagingReadoutService.attemptAutoSelectMessage(bl);
    }

    static /* synthetic */ void access$2800(MessagingReadoutService messagingReadoutService, int n) {
        messagingReadoutService.setReadoutSessionState(n);
    }

    static /* synthetic */ LogChannel access$2900(MessagingReadoutService messagingReadoutService) {
        return messagingReadoutService.log;
    }

    static /* synthetic */ void access$3000(MessagingReadoutService messagingReadoutService, int n) {
        messagingReadoutService.emitResponseBeginDialog(n);
    }

    static /* synthetic */ LogChannel access$3100(MessagingReadoutService messagingReadoutService) {
        return messagingReadoutService.log;
    }

    static /* synthetic */ AbstractMsgApplication access$3200(MessagingReadoutService messagingReadoutService) {
        return messagingReadoutService.msgApp;
    }

    static /* synthetic */ AbstractMsgApplication access$3300(MessagingReadoutService messagingReadoutService) {
        return messagingReadoutService.msgApp;
    }

    static /* synthetic */ AbstractMsgApplication access$3400(MessagingReadoutService messagingReadoutService) {
        return messagingReadoutService.msgApp;
    }

    static /* synthetic */ LogChannel access$3500(MessagingReadoutService messagingReadoutService) {
        return messagingReadoutService.log;
    }

    static /* synthetic */ void access$3600(MessagingReadoutService messagingReadoutService, int n) {
        messagingReadoutService.emitResponseEndDialog(n);
    }

    static /* synthetic */ LogChannel access$3700(MessagingReadoutService messagingReadoutService) {
        return messagingReadoutService.log;
    }

    static /* synthetic */ AbstractMsgApplication access$3800(MessagingReadoutService messagingReadoutService) {
        return messagingReadoutService.msgApp;
    }

    static /* synthetic */ LogChannel access$3900(MessagingReadoutService messagingReadoutService) {
        return messagingReadoutService.log;
    }

    static /* synthetic */ AbstractMsgApplication access$4000(MessagingReadoutService messagingReadoutService) {
        return messagingReadoutService.msgApp;
    }

    static /* synthetic */ AbstractMsgApplication access$4100(MessagingReadoutService messagingReadoutService) {
        return messagingReadoutService.msgApp;
    }

    static /* synthetic */ AbstractMsgApplication access$4200(MessagingReadoutService messagingReadoutService) {
        return messagingReadoutService.msgApp;
    }

    static /* synthetic */ LogChannel access$4300(MessagingReadoutService messagingReadoutService) {
        return messagingReadoutService.log;
    }

    static /* synthetic */ LogChannel access$4400(MessagingReadoutService messagingReadoutService) {
        return messagingReadoutService.log;
    }

    static /* synthetic */ LogChannel access$4500(MessagingReadoutService messagingReadoutService) {
        return messagingReadoutService.log;
    }

    static /* synthetic */ LogChannel access$4700(MessagingReadoutService messagingReadoutService) {
        return messagingReadoutService.log;
    }

    static /* synthetic */ AbstractMsgApplication access$4800(MessagingReadoutService messagingReadoutService) {
        return messagingReadoutService.msgApp;
    }

    static /* synthetic */ void access$4900(MessagingReadoutService messagingReadoutService, boolean bl) {
        messagingReadoutService.emitIndicateFolderContentListItemSelected(bl);
    }

    static /* synthetic */ AbstractMsgApplication access$5000(MessagingReadoutService messagingReadoutService) {
        return messagingReadoutService.msgApp;
    }

    static /* synthetic */ LogChannel access$5100(MessagingReadoutService messagingReadoutService) {
        return messagingReadoutService.log;
    }

    static /* synthetic */ boolean access$1900(MessagingReadoutService messagingReadoutService) {
        return messagingReadoutService.newMessageMode;
    }

    static /* synthetic */ AbstractMsgApplication access$5200(MessagingReadoutService messagingReadoutService) {
        return messagingReadoutService.msgApp;
    }

    static /* synthetic */ AbstractMsgApplication access$5300(MessagingReadoutService messagingReadoutService) {
        return messagingReadoutService.msgApp;
    }

    static /* synthetic */ LogChannel access$5500(MessagingReadoutService messagingReadoutService) {
        return messagingReadoutService.log;
    }

    static /* synthetic */ AbstractMsgApplication access$5600(MessagingReadoutService messagingReadoutService) {
        return messagingReadoutService.msgApp;
    }

    static /* synthetic */ AbstractMsgApplication access$5700(MessagingReadoutService messagingReadoutService) {
        return messagingReadoutService.msgApp;
    }
}

