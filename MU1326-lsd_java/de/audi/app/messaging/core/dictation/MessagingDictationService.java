/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  de.mib.swdiagnosis.msg.core.dictation.MessagingDictationServiceDiagPlugIn
 */
package de.audi.app.messaging.core.dictation;

import de.audi.app.messaging.core.accounts.AccountFilter$Builder;
import de.audi.app.messaging.core.accounts.AccountList;
import de.audi.app.messaging.core.accounts.IAccountFilter;
import de.audi.app.messaging.core.application.AbstractMsgApplication;
import de.audi.app.messaging.core.component.AbstractMessagingComponent;
import de.audi.app.messaging.core.compose.NewMessage;
import de.audi.app.messaging.core.compose.SelectedRecipientList;
import de.audi.app.messaging.core.concurrent.CopyOnWriteArrayList;
import de.audi.app.messaging.core.dictation.MessagingDictationService$1;
import de.audi.app.messaging.core.dictation.MessagingDictationService$10;
import de.audi.app.messaging.core.dictation.MessagingDictationService$11;
import de.audi.app.messaging.core.dictation.MessagingDictationService$12;
import de.audi.app.messaging.core.dictation.MessagingDictationService$13;
import de.audi.app.messaging.core.dictation.MessagingDictationService$14;
import de.audi.app.messaging.core.dictation.MessagingDictationService$15;
import de.audi.app.messaging.core.dictation.MessagingDictationService$16;
import de.audi.app.messaging.core.dictation.MessagingDictationService$2;
import de.audi.app.messaging.core.dictation.MessagingDictationService$3;
import de.audi.app.messaging.core.dictation.MessagingDictationService$4;
import de.audi.app.messaging.core.dictation.MessagingDictationService$5;
import de.audi.app.messaging.core.dictation.MessagingDictationService$6;
import de.audi.app.messaging.core.dictation.MessagingDictationService$7;
import de.audi.app.messaging.core.dictation.MessagingDictationService$8;
import de.audi.app.messaging.core.dictation.MessagingDictationService$9;
import de.audi.app.messaging.core.dictation.MessagingDictationService$AccountManagerListener;
import de.audi.app.messaging.core.osgi.IServiceRegistry;
import de.audi.app.messaging.core.osgi.MessagingBundleContext;
import de.audi.app.messaging.core.osgi.ServiceFilterBuilder;
import de.audi.app.messaging.core.osgi.ServiceProperties;
import de.audi.app.messaging.core.swdiagnosis.IDiagPlugIn;
import de.audi.app.messaging.core.swdiagnosis.IDiagProvider;
import de.audi.app.messaging.core.util.Strings;
import de.audi.atip.hmi.modelaccess.ChoiceModelApp;
import de.audi.atip.hmi.modelaccess.TextEditorModelDDApp;
import de.audi.atip.interapp.IMessagingDictationService;
import de.audi.atip.interapp.IMessagingDictationService$CompositionState;
import de.audi.atip.interapp.IMessagingDictationServiceListener;
import de.audi.atip.log.LogChannel;
import de.mib.swdiagnosis.msg.core.dictation.MessagingDictationServiceDiagPlugIn;
import org.dsi.ifc.messaging.MatchedAddress;
import org.dsi.ifc.messaging.MessagingAccount;
import org.osgi.framework.Filter;
import org.osgi.util.tracker.ServiceTracker;
import org.osgi.util.tracker.ServiceTrackerCustomizer;

public final class MessagingDictationService
extends AbstractMessagingComponent
implements IMessagingDictationService,
IDiagProvider {
    private volatile IMessagingDictationServiceListener messagingDictationServiceListener;
    private final CopyOnWriteArrayList messagingDictationServiceListeners = new CopyOnWriteArrayList();
    private volatile boolean isDialogInProgress = false;
    private volatile boolean hasDialogFailed = false;
    private volatile boolean isAccountSelected = false;
    private volatile IAccountFilter dialogAccountFilter = null;
    static /* synthetic */ Class class$de$audi$atip$interapp$IMessagingDictationService;
    static /* synthetic */ Class class$de$audi$atip$interapp$IMessagingDictationServiceListener;

    public MessagingDictationService(MessagingBundleContext messagingBundleContext) {
        super(messagingBundleContext, "App.Messaging.Main");
    }

    @Override
    public void init(AbstractMsgApplication abstractMsgApplication) {
        super.init(abstractMsgApplication);
        abstractMsgApplication.getAccountManager().addListener(new MessagingDictationService$AccountManagerListener(this, null));
        abstractMsgApplication.getMessagingSwDiagnosis().registerDiagProvider(this);
    }

    @Override
    public void connect(IServiceRegistry iServiceRegistry) {
        try {
            super.connect(iServiceRegistry);
            iServiceRegistry.registerService((class$de$audi$atip$interapp$IMessagingDictationService == null ? (class$de$audi$atip$interapp$IMessagingDictationService = MessagingDictationService.class$("de.audi.atip.interapp.IMessagingDictationService")) : class$de$audi$atip$interapp$IMessagingDictationService).getName(), (Object)this, ServiceProperties.createServiceProperties());
            iServiceRegistry.addTracker(this.createServiceTracker());
        }
        catch (Exception exception) {
            this.log.log(10000, "[MessagingDictationService#connect] An error occurred: ", (Throwable)exception);
        }
    }

    private ServiceTracker createServiceTracker() {
        String string = ServiceFilterBuilder.createFilterString("objectClass", (class$de$audi$atip$interapp$IMessagingDictationServiceListener == null ? (class$de$audi$atip$interapp$IMessagingDictationServiceListener = MessagingDictationService.class$("de.audi.atip.interapp.IMessagingDictationServiceListener")) : class$de$audi$atip$interapp$IMessagingDictationServiceListener).getName());
        Filter filter = this.bundleContext.createFilter(string);
        MessagingDictationService$1 messagingDictationService$1 = new MessagingDictationService$1(this, this.log, this.bundleContext);
        return new ServiceTracker(this.bundleContext, filter, (ServiceTrackerCustomizer)messagingDictationService$1);
    }

    public void addListener(IMessagingDictationServiceListener iMessagingDictationServiceListener) {
        this.log.log(-2137614336, "[MessagingDictationService#addListener] listener = %1", (Object)iMessagingDictationServiceListener);
        this.messagingDictationServiceListeners.add(iMessagingDictationServiceListener);
    }

    private void beginDialogNew(int n, boolean bl) {
        this.log.log(-2137614336, "[MessagingDictationService#beginDialogNew] msgType = %2, accountAutoSelect = %1", bl, (long)n);
        AccountList accountList = this.msgApp.getAccountManager().getDialogAccountList();
        accountList.removeAccountFilter(this.dialogAccountFilter);
        AccountFilter$Builder accountFilter$Builder = new AccountFilter$Builder();
        accountFilter$Builder.accountType(this.mapTypeToAccountTypeFilter(n)).sendSupportOnly(true);
        this.dialogAccountFilter = accountFilter$Builder.build();
        accountList.addAccountFilter(this.dialogAccountFilter);
        int n2 = accountList.getLength();
        if (n2 == 0) {
            this.log.log(-2137614336, "[MessagingDictationService#beginDialogNew] No account of the requested type available.");
        } else {
            if (n2 == 1 || bl) {
                MessagingAccount messagingAccount = this.msgApp.getAccountManager().getSelectedAccount();
                if (messagingAccount != null && accountList.contains(messagingAccount.getAccountID())) {
                    this.setAccountSelected(true);
                }
                if (!this.isAccountSelected()) {
                    if (accountList.getLength() < 1) {
                        throw new IllegalStateException("No account at list index 0.");
                    }
                    accountList.selectAccount(0);
                }
            }
            this.msgApp.getNewMessage().getMessageCreator().composeNew();
        }
    }

    private int mapTypeToAccountTypeFilter(int n) {
        switch (n) {
            case 1: {
                return 1;
            }
            case 2: {
                return 2;
            }
        }
        return 0;
    }

    private void beginDialogContinue() {
        this.log.log(-2137614336, "[MessagingDictationService#beginDialogContinue]");
        this.setAccountSelected(true);
        this.msgApp.getNewMessage().getMessageCreator().composeContinue();
    }

    private void beginDialogEdit() {
        this.log.log(-2137614336, "[MessagingDictationService#beginDialogEdit]");
        this.setAccountSelected(true);
        this.msgApp.getNewMessage().getMessageCreator().composeEdit();
    }

    private void beginDialogReply(boolean bl) {
        this.log.log(-2137614336, "[MessagingDictationService#beginDialogReply] replyAll = %1", bl);
        this.setAccountSelected(true);
        this.msgApp.getNewMessage().getMessageCreator().composeReply(bl);
    }

    private void beginDialogForward() {
        this.log.log(-2137614336, "[MessagingDictationService#beginDialogForward]");
        this.setAccountSelected(true);
        this.msgApp.getNewMessage().getMessageCreator().composeForward();
    }

    private boolean isAccountSelected() {
        return this.isAccountSelected;
    }

    private void setAccountSelected(boolean bl) {
        this.log.log(-2137614336, "[MessagingDictationService#setAccountSelected] isAccountSelected = %1", bl);
        this.isAccountSelected = bl;
    }

    public IMessagingDictationService$CompositionState getCompositionState() {
        int n = 0;
        if (this.isAccountSelected()) {
            n = this.msgApp.getAccountManager().isEmailMode() ? 2 : 1;
        }
        NewMessage newMessage = this.msgApp.getNewMessage();
        SelectedRecipientList selectedRecipientList = newMessage.getSelectedRecipientList();
        MatchedAddress matchedAddress = selectedRecipientList.getPrimaryRecipient();
        String string = "";
        if (matchedAddress != null && !Strings.isNullOrEmpty(matchedAddress.getName())) {
            string = matchedAddress.getName();
        }
        return new IMessagingDictationService$CompositionState(this.isDialogInProgress, this.hasDialogFailed, this.isAccountSelected(), n, this.msgApp.getTemplateList().getTemplateCount(), !selectedRecipientList.isEmpty(), string, !Strings.isNullOrEmpty(newMessage.getSubject()), !Strings.isNullOrEmpty(newMessage.getBody()));
    }

    private static int toInternalRecipientType(int n) {
        int n2 = 0;
        switch (n) {
            case 0: {
                n2 = 0;
                break;
            }
            case 1: {
                n2 = 1;
                break;
            }
            case 2: {
                n2 = 2;
                break;
            }
            case 3: {
                n2 = 3;
                break;
            }
            default: {
                throw new IllegalArgumentException();
            }
        }
        return n2;
    }

    private void emitResponseBeginDialog(int n) {
        this.msgApp.getExecutorManager().getExternalTaskDispatcher().execute(new MessagingDictationService$2(this, n));
    }

    private void emitResponseEndDialog(int n) {
        this.msgApp.getExecutorManager().getExternalTaskDispatcher().execute(new MessagingDictationService$3(this, n));
    }

    private void emitResponseAddRecipient(int n) {
        this.msgApp.getExecutorManager().getExternalTaskDispatcher().execute(new MessagingDictationService$4(this, n));
    }

    private void emitResponseClearRecipients(int n) {
        this.msgApp.getExecutorManager().getExternalTaskDispatcher().execute(new MessagingDictationService$5(this, n));
    }

    private void emitResponseSendMessage(int n) {
        this.msgApp.getExecutorManager().getExternalTaskDispatcher().execute(new MessagingDictationService$6(this, n));
    }

    private void emitResponseNextDialogStep(int n) {
        this.msgApp.getExecutorManager().getExternalTaskDispatcher().execute(new MessagingDictationService$7(this, n));
    }

    private void emitUpdateCompositionState(IMessagingDictationService$CompositionState iMessagingDictationService$CompositionState) {
        this.msgApp.getExecutorManager().getExternalTaskDispatcher().execute(new MessagingDictationService$8(this, iMessagingDictationService$CompositionState));
    }

    @Override
    public TextEditorModelDDApp getSubjectEditorModel() {
        return this.msgApp.getNewMessage().getSubjectTextEditor();
    }

    @Override
    public TextEditorModelDDApp getBodyEditorModel() {
        return this.msgApp.getNewMessage().getBodyTextEditor();
    }

    @Override
    public ChoiceModelApp getSubjectEditorInputModeModel() {
        return this.framework.getHmiServiceApp().getChoiceModel(1754472704);
    }

    @Override
    public ChoiceModelApp getBodyEditorInputModeModel() {
        return this.framework.getHmiServiceApp().getChoiceModel(1737695488);
    }

    @Override
    public void indicateSubjectEditorModelWrite() {
        this.msgApp.getExecutorManager().getInternalTaskDispatcher().execute(new MessagingDictationService$9(this));
    }

    @Override
    public void indicateBodyEditorModelWrite() {
        this.msgApp.getExecutorManager().getInternalTaskDispatcher().execute(new MessagingDictationService$10(this));
    }

    @Override
    public void requestBeginDialog(int n, int n2, boolean bl) {
        this.msgApp.getExecutorManager().getInternalTaskDispatcher().execute(new MessagingDictationService$11(this, n, n2, bl));
    }

    @Override
    public void requestEndDialog() {
        this.msgApp.getExecutorManager().getInternalTaskDispatcher().execute(new MessagingDictationService$12(this));
    }

    @Override
    public void requestDialogStep(int n) {
        this.msgApp.getExecutorManager().getInternalTaskDispatcher().execute(new MessagingDictationService$13(this, n));
    }

    @Override
    public void requestAddRecipient(int n, String string, long l, String string2) {
        this.msgApp.getExecutorManager().getInternalTaskDispatcher().execute(new MessagingDictationService$14(this, n, string, l, string2));
    }

    @Override
    public void requestClearRecipients(int n) {
        this.msgApp.getExecutorManager().getInternalTaskDispatcher().execute(new MessagingDictationService$15(this, n));
    }

    @Override
    public void requestSendMessage() {
        this.msgApp.getExecutorManager().getInternalTaskDispatcher().execute(new MessagingDictationService$16(this));
    }

    @Override
    public byte freezeDynamicLists() {
        this.log.log(1078071040, "[MessagingDictationService#freezeDynamicLists]");
        return 0;
    }

    @Override
    public byte unfreezeDynamicLists() {
        this.log.log(1078071040, "[MessagingDictationService#unfreezeDynamicLists]");
        return 0;
    }

    @Override
    public IDiagPlugIn[] createDiagPlugIns() {
        return new IDiagPlugIn[]{new MessagingDictationServiceDiagPlugIn((IMessagingDictationService)this)};
    }

    static /* synthetic */ Class class$(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new NoClassDefFoundError().initCause(classNotFoundException);
        }
    }

    static /* synthetic */ boolean access$102(MessagingDictationService messagingDictationService, boolean bl) {
        messagingDictationService.isDialogInProgress = bl;
        return messagingDictationService.isDialogInProgress;
    }

    static /* synthetic */ boolean access$202(MessagingDictationService messagingDictationService, boolean bl) {
        messagingDictationService.hasDialogFailed = bl;
        return messagingDictationService.hasDialogFailed;
    }

    static /* synthetic */ void access$300(MessagingDictationService messagingDictationService, boolean bl) {
        messagingDictationService.setAccountSelected(bl);
    }

    static /* synthetic */ IMessagingDictationServiceListener access$402(MessagingDictationService messagingDictationService, IMessagingDictationServiceListener iMessagingDictationServiceListener) {
        messagingDictationService.messagingDictationServiceListener = iMessagingDictationServiceListener;
        return messagingDictationService.messagingDictationServiceListener;
    }

    static /* synthetic */ LogChannel access$500(MessagingDictationService messagingDictationService) {
        return messagingDictationService.log;
    }

    static /* synthetic */ IMessagingDictationServiceListener access$400(MessagingDictationService messagingDictationService) {
        return messagingDictationService.messagingDictationServiceListener;
    }

    static /* synthetic */ CopyOnWriteArrayList access$600(MessagingDictationService messagingDictationService) {
        return messagingDictationService.messagingDictationServiceListeners;
    }

    static /* synthetic */ LogChannel access$700(MessagingDictationService messagingDictationService) {
        return messagingDictationService.log;
    }

    static /* synthetic */ LogChannel access$800(MessagingDictationService messagingDictationService) {
        return messagingDictationService.log;
    }

    static /* synthetic */ LogChannel access$900(MessagingDictationService messagingDictationService) {
        return messagingDictationService.log;
    }

    static /* synthetic */ LogChannel access$1000(MessagingDictationService messagingDictationService) {
        return messagingDictationService.log;
    }

    static /* synthetic */ LogChannel access$1100(MessagingDictationService messagingDictationService) {
        return messagingDictationService.log;
    }

    static /* synthetic */ LogChannel access$1200(MessagingDictationService messagingDictationService) {
        return messagingDictationService.log;
    }

    static /* synthetic */ LogChannel access$1300(MessagingDictationService messagingDictationService) {
        return messagingDictationService.log;
    }

    static /* synthetic */ LogChannel access$1400(MessagingDictationService messagingDictationService) {
        return messagingDictationService.log;
    }

    static /* synthetic */ LogChannel access$1500(MessagingDictationService messagingDictationService) {
        return messagingDictationService.log;
    }

    static /* synthetic */ LogChannel access$1600(MessagingDictationService messagingDictationService) {
        return messagingDictationService.log;
    }

    static /* synthetic */ LogChannel access$1700(MessagingDictationService messagingDictationService) {
        return messagingDictationService.log;
    }

    static /* synthetic */ LogChannel access$1800(MessagingDictationService messagingDictationService) {
        return messagingDictationService.log;
    }

    static /* synthetic */ LogChannel access$1900(MessagingDictationService messagingDictationService) {
        return messagingDictationService.log;
    }

    static /* synthetic */ LogChannel access$2000(MessagingDictationService messagingDictationService) {
        return messagingDictationService.log;
    }

    static /* synthetic */ LogChannel access$2100(MessagingDictationService messagingDictationService) {
        return messagingDictationService.log;
    }

    static /* synthetic */ LogChannel access$2200(MessagingDictationService messagingDictationService) {
        return messagingDictationService.log;
    }

    static /* synthetic */ LogChannel access$2300(MessagingDictationService messagingDictationService) {
        return messagingDictationService.log;
    }

    static /* synthetic */ LogChannel access$2400(MessagingDictationService messagingDictationService) {
        return messagingDictationService.log;
    }

    static /* synthetic */ LogChannel access$2500(MessagingDictationService messagingDictationService) {
        return messagingDictationService.log;
    }

    static /* synthetic */ LogChannel access$2600(MessagingDictationService messagingDictationService) {
        return messagingDictationService.log;
    }

    static /* synthetic */ boolean access$100(MessagingDictationService messagingDictationService) {
        return messagingDictationService.isDialogInProgress;
    }

    static /* synthetic */ LogChannel access$2700(MessagingDictationService messagingDictationService) {
        return messagingDictationService.log;
    }

    static /* synthetic */ AbstractMsgApplication access$2800(MessagingDictationService messagingDictationService) {
        return messagingDictationService.msgApp;
    }

    static /* synthetic */ void access$2900(MessagingDictationService messagingDictationService, IMessagingDictationService$CompositionState iMessagingDictationService$CompositionState) {
        messagingDictationService.emitUpdateCompositionState(iMessagingDictationService$CompositionState);
    }

    static /* synthetic */ LogChannel access$3000(MessagingDictationService messagingDictationService) {
        return messagingDictationService.log;
    }

    static /* synthetic */ LogChannel access$3100(MessagingDictationService messagingDictationService) {
        return messagingDictationService.log;
    }

    static /* synthetic */ AbstractMsgApplication access$3200(MessagingDictationService messagingDictationService) {
        return messagingDictationService.msgApp;
    }

    static /* synthetic */ LogChannel access$3300(MessagingDictationService messagingDictationService) {
        return messagingDictationService.log;
    }

    static /* synthetic */ LogChannel access$3400(MessagingDictationService messagingDictationService) {
        return messagingDictationService.log;
    }

    static /* synthetic */ LogChannel access$3500(MessagingDictationService messagingDictationService) {
        return messagingDictationService.log;
    }

    static /* synthetic */ void access$3600(MessagingDictationService messagingDictationService, int n, boolean bl) {
        messagingDictationService.beginDialogNew(n, bl);
    }

    static /* synthetic */ void access$3700(MessagingDictationService messagingDictationService) {
        messagingDictationService.beginDialogContinue();
    }

    static /* synthetic */ void access$3800(MessagingDictationService messagingDictationService) {
        messagingDictationService.beginDialogEdit();
    }

    static /* synthetic */ void access$3900(MessagingDictationService messagingDictationService, boolean bl) {
        messagingDictationService.beginDialogReply(bl);
    }

    static /* synthetic */ void access$4000(MessagingDictationService messagingDictationService) {
        messagingDictationService.beginDialogForward();
    }

    static /* synthetic */ LogChannel access$4100(MessagingDictationService messagingDictationService) {
        return messagingDictationService.log;
    }

    static /* synthetic */ LogChannel access$4200(MessagingDictationService messagingDictationService) {
        return messagingDictationService.log;
    }

    static /* synthetic */ void access$4300(MessagingDictationService messagingDictationService, int n) {
        messagingDictationService.emitResponseBeginDialog(n);
    }

    static /* synthetic */ LogChannel access$4400(MessagingDictationService messagingDictationService) {
        return messagingDictationService.log;
    }

    static /* synthetic */ LogChannel access$4500(MessagingDictationService messagingDictationService) {
        return messagingDictationService.log;
    }

    static /* synthetic */ AbstractMsgApplication access$4600(MessagingDictationService messagingDictationService) {
        return messagingDictationService.msgApp;
    }

    static /* synthetic */ IAccountFilter access$4700(MessagingDictationService messagingDictationService) {
        return messagingDictationService.dialogAccountFilter;
    }

    static /* synthetic */ AbstractMsgApplication access$4800(MessagingDictationService messagingDictationService) {
        return messagingDictationService.msgApp;
    }

    static /* synthetic */ AbstractMsgApplication access$4900(MessagingDictationService messagingDictationService) {
        return messagingDictationService.msgApp;
    }

    static /* synthetic */ LogChannel access$5000(MessagingDictationService messagingDictationService) {
        return messagingDictationService.log;
    }

    static /* synthetic */ void access$5100(MessagingDictationService messagingDictationService, int n) {
        messagingDictationService.emitResponseEndDialog(n);
    }

    static /* synthetic */ LogChannel access$5200(MessagingDictationService messagingDictationService) {
        return messagingDictationService.log;
    }

    static /* synthetic */ LogChannel access$5300(MessagingDictationService messagingDictationService) {
        return messagingDictationService.log;
    }

    static /* synthetic */ LogChannel access$5400(MessagingDictationService messagingDictationService) {
        return messagingDictationService.log;
    }

    static /* synthetic */ AbstractMsgApplication access$5500(MessagingDictationService messagingDictationService) {
        return messagingDictationService.msgApp;
    }

    static /* synthetic */ LogChannel access$5600(MessagingDictationService messagingDictationService) {
        return messagingDictationService.log;
    }

    static /* synthetic */ void access$5700(MessagingDictationService messagingDictationService, int n) {
        messagingDictationService.emitResponseNextDialogStep(n);
    }

    static /* synthetic */ LogChannel access$5800(MessagingDictationService messagingDictationService) {
        return messagingDictationService.log;
    }

    static /* synthetic */ LogChannel access$5900(MessagingDictationService messagingDictationService) {
        return messagingDictationService.log;
    }

    static /* synthetic */ LogChannel access$6000(MessagingDictationService messagingDictationService) {
        return messagingDictationService.log;
    }

    static /* synthetic */ AbstractMsgApplication access$6100(MessagingDictationService messagingDictationService) {
        return messagingDictationService.msgApp;
    }

    static /* synthetic */ AbstractMsgApplication access$6200(MessagingDictationService messagingDictationService) {
        return messagingDictationService.msgApp;
    }

    static /* synthetic */ AbstractMsgApplication access$6300(MessagingDictationService messagingDictationService) {
        return messagingDictationService.msgApp;
    }

    static /* synthetic */ LogChannel access$6400(MessagingDictationService messagingDictationService) {
        return messagingDictationService.log;
    }

    static /* synthetic */ void access$6500(MessagingDictationService messagingDictationService, int n) {
        messagingDictationService.emitResponseAddRecipient(n);
    }

    static /* synthetic */ LogChannel access$6600(MessagingDictationService messagingDictationService) {
        return messagingDictationService.log;
    }

    static /* synthetic */ LogChannel access$6700(MessagingDictationService messagingDictationService) {
        return messagingDictationService.log;
    }

    static /* synthetic */ int access$6800(int n) {
        return MessagingDictationService.toInternalRecipientType(n);
    }

    static /* synthetic */ LogChannel access$6900(MessagingDictationService messagingDictationService) {
        return messagingDictationService.log;
    }

    static /* synthetic */ AbstractMsgApplication access$7000(MessagingDictationService messagingDictationService) {
        return messagingDictationService.msgApp;
    }

    static /* synthetic */ LogChannel access$7100(MessagingDictationService messagingDictationService) {
        return messagingDictationService.log;
    }

    static /* synthetic */ void access$7200(MessagingDictationService messagingDictationService, int n) {
        messagingDictationService.emitResponseClearRecipients(n);
    }

    static /* synthetic */ LogChannel access$7300(MessagingDictationService messagingDictationService) {
        return messagingDictationService.log;
    }

    static /* synthetic */ LogChannel access$7400(MessagingDictationService messagingDictationService) {
        return messagingDictationService.log;
    }

    static /* synthetic */ AbstractMsgApplication access$7500(MessagingDictationService messagingDictationService) {
        return messagingDictationService.msgApp;
    }

    static /* synthetic */ LogChannel access$7600(MessagingDictationService messagingDictationService) {
        return messagingDictationService.log;
    }

    static /* synthetic */ void access$7700(MessagingDictationService messagingDictationService, int n) {
        messagingDictationService.emitResponseSendMessage(n);
    }

    static /* synthetic */ LogChannel access$7900(MessagingDictationService messagingDictationService) {
        return messagingDictationService.log;
    }

    static /* synthetic */ AbstractMsgApplication access$8000(MessagingDictationService messagingDictationService) {
        return messagingDictationService.msgApp;
    }

    static /* synthetic */ AbstractMsgApplication access$8100(MessagingDictationService messagingDictationService) {
        return messagingDictationService.msgApp;
    }
}

