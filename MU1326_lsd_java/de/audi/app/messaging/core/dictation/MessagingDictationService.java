/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  de.mib.swdiagnosis.msg.core.dictation.MessagingDictationServiceDiagPlugIn
 */
package de.audi.app.messaging.core.dictation;

import de.audi.app.messaging.core.accounts.AccountFilter;
import de.audi.app.messaging.core.accounts.AccountList;
import de.audi.app.messaging.core.accounts.IAccountFilter;
import de.audi.app.messaging.core.accounts.IAccountManagerListener;
import de.audi.app.messaging.core.application.AbstractMsgApplication;
import de.audi.app.messaging.core.component.AbstractMessagingComponent;
import de.audi.app.messaging.core.compose.NewMessage;
import de.audi.app.messaging.core.compose.SelectedRecipientList;
import de.audi.app.messaging.core.concurrent.CopyOnWriteArrayList;
import de.audi.app.messaging.core.folderbrowsing.FolderNavigator;
import de.audi.app.messaging.core.osgi.AbstractMessagingTrackerCustomizer;
import de.audi.app.messaging.core.osgi.IServiceRegistry;
import de.audi.app.messaging.core.osgi.MessagingBundleContext;
import de.audi.app.messaging.core.osgi.ServiceFilterBuilder;
import de.audi.app.messaging.core.osgi.ServiceProperties;
import de.audi.app.messaging.core.swdiagnosis.IDiagPlugIn;
import de.audi.app.messaging.core.swdiagnosis.IDiagProvider;
import de.audi.app.messaging.core.util.Logs;
import de.audi.app.messaging.core.util.Strings;
import de.audi.atip.hmi.modelaccess.ChoiceModelApp;
import de.audi.atip.hmi.modelaccess.TextEditorModelDDApp;
import de.audi.atip.interapp.IMessagingDictationService;
import de.audi.atip.interapp.IMessagingDictationServiceListener;
import de.mib.swdiagnosis.msg.core.dictation.MessagingDictationServiceDiagPlugIn;
import java.util.Iterator;
import org.dsi.ifc.messaging.MatchedAddress;
import org.dsi.ifc.messaging.MessagingAccount;
import org.osgi.framework.Filter;
import org.osgi.framework.InvalidSyntaxException;
import org.osgi.framework.ServiceReference;
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

    public void init(AbstractMsgApplication abstractMsgApplication) {
        super.init(abstractMsgApplication);
        abstractMsgApplication.getAccountManager().addListener(new AccountManagerListener());
        abstractMsgApplication.getMessagingSwDiagnosis().registerDiagProvider(this);
    }

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

    private ServiceTracker createServiceTracker() throws InvalidSyntaxException {
        String string = ServiceFilterBuilder.createFilterString("objectClass", (class$de$audi$atip$interapp$IMessagingDictationServiceListener == null ? (class$de$audi$atip$interapp$IMessagingDictationServiceListener = MessagingDictationService.class$("de.audi.atip.interapp.IMessagingDictationServiceListener")) : class$de$audi$atip$interapp$IMessagingDictationServiceListener).getName());
        Filter filter = this.bundleContext.createFilter(string);
        AbstractMessagingTrackerCustomizer abstractMessagingTrackerCustomizer = new AbstractMessagingTrackerCustomizer(this.log, this.bundleContext){

            public void addService(ServiceReference serviceReference, Object object) {
                MessagingDictationService.this.isDialogInProgress = false;
                MessagingDictationService.this.hasDialogFailed = false;
                MessagingDictationService.this.setAccountSelected(false);
                MessagingDictationService.this.messagingDictationServiceListener = (IMessagingDictationServiceListener)object;
            }

            public void removeService(ServiceReference serviceReference, Object object) {
                MessagingDictationService.this.isDialogInProgress = false;
                MessagingDictationService.this.hasDialogFailed = false;
                MessagingDictationService.this.setAccountSelected(false);
                MessagingDictationService.this.messagingDictationServiceListener = null;
            }
        };
        return new ServiceTracker(this.bundleContext, filter, (ServiceTrackerCustomizer)abstractMessagingTrackerCustomizer);
    }

    public void addListener(IMessagingDictationServiceListener iMessagingDictationServiceListener) {
        this.log.log(10000000, "[MessagingDictationService#addListener] listener = %1", (Object)iMessagingDictationServiceListener);
        this.messagingDictationServiceListeners.add(iMessagingDictationServiceListener);
    }

    private void beginDialogNew(int n, boolean bl) {
        this.log.log(10000000, "[MessagingDictationService#beginDialogNew] msgType = %2, accountAutoSelect = %1", bl, (long)n);
        AccountList accountList = this.msgApp.getAccountManager().getDialogAccountList();
        accountList.removeAccountFilter(this.dialogAccountFilter);
        AccountFilter.Builder builder = new AccountFilter.Builder();
        builder.accountType(this.mapTypeToAccountTypeFilter(n)).sendSupportOnly(true);
        this.dialogAccountFilter = builder.build();
        accountList.addAccountFilter(this.dialogAccountFilter);
        int n2 = accountList.getLength();
        if (n2 == 0) {
            this.log.log(10000000, "[MessagingDictationService#beginDialogNew] No account of the requested type available.");
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
        this.log.log(10000000, "[MessagingDictationService#beginDialogContinue]");
        this.setAccountSelected(true);
        this.msgApp.getNewMessage().getMessageCreator().composeContinue();
    }

    private void beginDialogEdit() {
        this.log.log(10000000, "[MessagingDictationService#beginDialogEdit]");
        this.setAccountSelected(true);
        this.msgApp.getNewMessage().getMessageCreator().composeEdit();
    }

    private void beginDialogReply(boolean bl) {
        this.log.log(10000000, "[MessagingDictationService#beginDialogReply] replyAll = %1", bl);
        this.setAccountSelected(true);
        this.msgApp.getNewMessage().getMessageCreator().composeReply(bl);
    }

    private void beginDialogForward() {
        this.log.log(10000000, "[MessagingDictationService#beginDialogForward]");
        this.setAccountSelected(true);
        this.msgApp.getNewMessage().getMessageCreator().composeForward();
    }

    private boolean isAccountSelected() {
        return this.isAccountSelected;
    }

    private void setAccountSelected(boolean bl) {
        this.log.log(10000000, "[MessagingDictationService#setAccountSelected] isAccountSelected = %1", bl);
        this.isAccountSelected = bl;
    }

    public IMessagingDictationService.CompositionState getCompositionState() {
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
        return new IMessagingDictationService.CompositionState(this.isDialogInProgress, this.hasDialogFailed, this.isAccountSelected(), n, this.msgApp.getTemplateList().getTemplateCount(), !selectedRecipientList.isEmpty(), string, !Strings.isNullOrEmpty(newMessage.getSubject()), !Strings.isNullOrEmpty(newMessage.getBody()));
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

    private void emitResponseBeginDialog(final int n) {
        this.msgApp.getExecutorManager().getExternalTaskDispatcher().execute(new Runnable(){

            public void run() {
                try {
                    MessagingDictationService.this.log.log(1000000, "[MessagingDictationService#emitResponseBeginDialog] result = %1", (long)n);
                    MessagingDictationService.this.messagingDictationServiceListener.responseBeginDialog(n);
                    Iterator iterator = MessagingDictationService.this.messagingDictationServiceListeners.iterator();
                    while (iterator.hasNext()) {
                        try {
                            ((IMessagingDictationServiceListener)iterator.next()).responseBeginDialog(n);
                        }
                        catch (Exception exception) {
                            Logs.logException(MessagingDictationService.this.log, exception, "[MessagingDictationService#emitResponseBeginDialog]");
                        }
                    }
                }
                catch (Exception exception) {
                    Logs.logException(MessagingDictationService.this.log, exception, "[MessagingDictationService#emitResponseBeginDialog]");
                }
            }
        });
    }

    private void emitResponseEndDialog(final int n) {
        this.msgApp.getExecutorManager().getExternalTaskDispatcher().execute(new Runnable(){

            public void run() {
                try {
                    MessagingDictationService.this.log.log(1000000, "[MessagingDictationService#emitResponseEndDialog] result = %1", (long)n);
                    MessagingDictationService.this.messagingDictationServiceListener.responseEndDialog(n);
                    Iterator iterator = MessagingDictationService.this.messagingDictationServiceListeners.iterator();
                    while (iterator.hasNext()) {
                        try {
                            ((IMessagingDictationServiceListener)iterator.next()).responseEndDialog(n);
                        }
                        catch (Exception exception) {
                            Logs.logException(MessagingDictationService.this.log, exception, "[MessagingDictationService#emitResponseEndDialog]");
                        }
                    }
                }
                catch (Exception exception) {
                    Logs.logException(MessagingDictationService.this.log, exception, "[MessagingDictationService#emitResponseEndDialog]");
                }
            }
        });
    }

    private void emitResponseAddRecipient(final int n) {
        this.msgApp.getExecutorManager().getExternalTaskDispatcher().execute(new Runnable(){

            public void run() {
                try {
                    MessagingDictationService.this.log.log(1000000, "[MessagingDictationService#emitResponseAddRecipient] result = %1", (long)n);
                    MessagingDictationService.this.messagingDictationServiceListener.responseAddRecipient(n);
                    Iterator iterator = MessagingDictationService.this.messagingDictationServiceListeners.iterator();
                    while (iterator.hasNext()) {
                        try {
                            ((IMessagingDictationServiceListener)iterator.next()).responseAddRecipient(n);
                        }
                        catch (Exception exception) {
                            Logs.logException(MessagingDictationService.this.log, exception, "[MessagingDictationService#emitResponseAddRecipient]");
                        }
                    }
                }
                catch (Exception exception) {
                    Logs.logException(MessagingDictationService.this.log, exception, "[MessagingDictationService#emitResponseAddRecipient]");
                }
            }
        });
    }

    private void emitResponseClearRecipients(final int n) {
        this.msgApp.getExecutorManager().getExternalTaskDispatcher().execute(new Runnable(){

            public void run() {
                try {
                    MessagingDictationService.this.log.log(1000000, "[MessagingDictationService#emitResponseClearRecipients] result = %1", (long)n);
                    MessagingDictationService.this.messagingDictationServiceListener.responseClearRecipients(n);
                    Iterator iterator = MessagingDictationService.this.messagingDictationServiceListeners.iterator();
                    while (iterator.hasNext()) {
                        try {
                            ((IMessagingDictationServiceListener)iterator.next()).responseClearRecipients(n);
                        }
                        catch (Exception exception) {
                            Logs.logException(MessagingDictationService.this.log, exception, "[MessagingDictationService#emitResponseClearRecipients]");
                        }
                    }
                }
                catch (Exception exception) {
                    Logs.logException(MessagingDictationService.this.log, exception, "[MessagingDictationService#emitResponseClearRecipients]");
                }
            }
        });
    }

    private void emitResponseSendMessage(final int n) {
        this.msgApp.getExecutorManager().getExternalTaskDispatcher().execute(new Runnable(){

            public void run() {
                try {
                    MessagingDictationService.this.log.log(1000000, "[MessagingDictationService#emitResponseSendMessage] result = %1", (long)n);
                    MessagingDictationService.this.messagingDictationServiceListener.responseSendMessage(n);
                    Iterator iterator = MessagingDictationService.this.messagingDictationServiceListeners.iterator();
                    while (iterator.hasNext()) {
                        try {
                            ((IMessagingDictationServiceListener)iterator.next()).responseSendMessage(n);
                        }
                        catch (Exception exception) {
                            Logs.logException(MessagingDictationService.this.log, exception, "[MessagingDictationService#emitResponseSendMessage]");
                        }
                    }
                }
                catch (Exception exception) {
                    Logs.logException(MessagingDictationService.this.log, exception, "[MessagingDictationService#emitResponseSendMessage]");
                }
            }
        });
    }

    private void emitResponseNextDialogStep(final int n) {
        this.msgApp.getExecutorManager().getExternalTaskDispatcher().execute(new Runnable(){

            public void run() {
                try {
                    MessagingDictationService.this.log.log(1000000, "[MessagingDictationService#emitResponseNextDialogStep] result = %1", (long)n);
                    MessagingDictationService.this.messagingDictationServiceListener.responseNextDialogStep(n);
                    Iterator iterator = MessagingDictationService.this.messagingDictationServiceListeners.iterator();
                    while (iterator.hasNext()) {
                        try {
                            ((IMessagingDictationServiceListener)iterator.next()).responseNextDialogStep(n);
                        }
                        catch (Exception exception) {
                            Logs.logException(MessagingDictationService.this.log, exception, "[MessagingDictationService#emitResponseNextDialogStep]");
                        }
                    }
                }
                catch (Exception exception) {
                    Logs.logException(MessagingDictationService.this.log, exception, "[MessagingDictationService#emitResponseNextDialogStep]");
                }
            }
        });
    }

    private void emitUpdateCompositionState(final IMessagingDictationService.CompositionState compositionState) {
        this.msgApp.getExecutorManager().getExternalTaskDispatcher().execute(new Runnable(){

            public void run() {
                try {
                    MessagingDictationService.this.log.log(1000000, "[MessagingDictationService#emitUpdateCompositionState] compositionState = %1", (Object)compositionState);
                    MessagingDictationService.this.messagingDictationServiceListener.updateCompositionState(compositionState);
                    Iterator iterator = MessagingDictationService.this.messagingDictationServiceListeners.iterator();
                    while (iterator.hasNext()) {
                        try {
                            ((IMessagingDictationServiceListener)iterator.next()).updateCompositionState(compositionState);
                        }
                        catch (Exception exception) {
                            Logs.logException(MessagingDictationService.this.log, exception, "[MessagingDictationService#emitUpdateCompositionState]");
                        }
                    }
                }
                catch (Exception exception) {
                    Logs.logException(MessagingDictationService.this.log, exception, "[MessagingDictationService#emitUpdateCompositionState]");
                }
            }
        });
    }

    public TextEditorModelDDApp getSubjectEditorModel() {
        return this.msgApp.getNewMessage().getSubjectTextEditor();
    }

    public TextEditorModelDDApp getBodyEditorModel() {
        return this.msgApp.getNewMessage().getBodyTextEditor();
    }

    public ChoiceModelApp getSubjectEditorInputModeModel() {
        return this.framework.getHmiServiceApp().getChoiceModel(2200424);
    }

    public ChoiceModelApp getBodyEditorInputModeModel() {
        return this.framework.getHmiServiceApp().getChoiceModel(2200423);
    }

    public void indicateSubjectEditorModelWrite() {
        this.msgApp.getExecutorManager().getInternalTaskDispatcher().execute(new Runnable(){

            public void run() {
                try {
                    MessagingDictationService.this.log.log(1000000, "[MessagingDictationService#indicateSubjectEditorModelWrite] isDialogInProgress = %1", MessagingDictationService.this.isDialogInProgress);
                    if (MessagingDictationService.this.isDialogInProgress) {
                        MessagingDictationService.this.msgApp.getNewMessage().subjectChanged(false);
                        MessagingDictationService.this.emitUpdateCompositionState(MessagingDictationService.this.getCompositionState());
                    }
                }
                catch (Exception exception) {
                    Logs.logException(MessagingDictationService.this.log, exception, "[MessagingDictationService#indicateSubjectEditorModelWrite]");
                }
            }
        });
    }

    public void indicateBodyEditorModelWrite() {
        this.msgApp.getExecutorManager().getInternalTaskDispatcher().execute(new Runnable(){

            public void run() {
                try {
                    MessagingDictationService.this.log.log(1000000, "[MessagingDictationService#indicateBodyEditorModelWrite] isDialogInProgress = %1", MessagingDictationService.this.isDialogInProgress);
                    if (MessagingDictationService.this.isDialogInProgress) {
                        MessagingDictationService.this.msgApp.getNewMessage().bodyChanged(false);
                        MessagingDictationService.this.emitUpdateCompositionState(MessagingDictationService.this.getCompositionState());
                    }
                }
                catch (Exception exception) {
                    Logs.logException(MessagingDictationService.this.log, exception, "[MessagingDictationService#indicateBodyEditorModelWrite]");
                }
            }
        });
    }

    public void requestBeginDialog(final int n, final int n2, final boolean bl) {
        this.msgApp.getExecutorManager().getInternalTaskDispatcher().execute(new Runnable(){

            /*
             * WARNING - Removed try catching itself - possible behaviour change.
             */
            public void run() {
                int n3 = 0;
                MessagingDictationService.this.hasDialogFailed = false;
                try {
                    MessagingDictationService.this.log.log(1000000, "[MessagingDictationService#requestBeginDialog] compositionMode = %1, msgType = %2, accountAutoSelect = %3", (long)n, (long)n2, bl);
                    if (MessagingDictationService.this.isDialogInProgress) {
                        MessagingDictationService.this.log.log(10000, "[MessagingDictationService#requestBeginDialog] Illegal state: A dialog is already in progress.");
                        n3 = 3;
                    } else {
                        MessagingDictationService.this.setAccountSelected(false);
                        if (n == 0) {
                            MessagingDictationService.this.beginDialogNew(n2, bl);
                        } else if (n == 1) {
                            MessagingDictationService.this.beginDialogContinue();
                        } else if (n == 2) {
                            MessagingDictationService.this.beginDialogEdit();
                        } else if (n == 3) {
                            MessagingDictationService.this.beginDialogReply(false);
                        } else if (n == 4) {
                            MessagingDictationService.this.beginDialogReply(true);
                        } else if (n == 5) {
                            MessagingDictationService.this.beginDialogForward();
                        } else {
                            MessagingDictationService.this.log.log(10000, "[MessagingDictationService#requestBeginDialog] Illegal argument: compositionMode = %1", (long)n);
                            n3 = 2;
                        }
                        if (n3 == 0) {
                            MessagingDictationService.this.isDialogInProgress = true;
                        }
                    }
                }
                catch (Exception exception) {
                    Logs.logException(MessagingDictationService.this.log, exception, "[MessagingDictationService#requestBeginDialog]");
                    n3 = 1;
                }
                finally {
                    MessagingDictationService.this.emitUpdateCompositionState(MessagingDictationService.this.getCompositionState());
                    MessagingDictationService.this.emitResponseBeginDialog(n3);
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
                    MessagingDictationService.this.log.log(1000000, "[MessagingDictationService#requestEndDialog]");
                    if (!MessagingDictationService.this.isDialogInProgress) {
                        MessagingDictationService.this.log.log(10000, "[MessagingDictationService#requestEndDialog] Illegal state: There is no dialog in progress.");
                        n = 3;
                    } else {
                        AccountList accountList = MessagingDictationService.this.msgApp.getAccountManager().getDialogAccountList();
                        accountList.removeAccountFilter(MessagingDictationService.this.dialogAccountFilter);
                        MessagingAccount messagingAccount = MessagingDictationService.this.msgApp.getAccountManager().getSelectedAccount();
                        FolderNavigator folderNavigator = MessagingDictationService.this.msgApp.getFolderNavigator();
                        if (messagingAccount != null && !folderNavigator.getCurrentFolder().isValid()) {
                            folderNavigator.changeFolderDirect(-8, false);
                        }
                    }
                }
                catch (Exception exception) {
                    Logs.logException(MessagingDictationService.this.log, exception, "[MessagingDictationService#requestEndDialog]");
                    n = 1;
                }
                finally {
                    MessagingDictationService.this.isDialogInProgress = false;
                    MessagingDictationService.this.emitUpdateCompositionState(MessagingDictationService.this.getCompositionState());
                    MessagingDictationService.this.emitResponseEndDialog(n);
                }
            }
        });
    }

    public void requestDialogStep(final int n) {
        this.msgApp.getExecutorManager().getInternalTaskDispatcher().execute(new Runnable(){

            /*
             * WARNING - Removed try catching itself - possible behaviour change.
             */
            public void run() {
                int n3 = 0;
                try {
                    MessagingDictationService.this.log.log(1000000, "[MessagingDictationService#requestDialogStep] dialogStep = %1", (long)n);
                    if (!MessagingDictationService.this.isDialogInProgress) {
                        MessagingDictationService.this.log.log(10000, "[MessagingDictationService#requestDialogStep] Illegal state: There is no dialog in progress.");
                        n3 = 3;
                    } else if (n != 2 && n != 0 && n != 3 && n != 1) {
                        MessagingDictationService.this.log.log(10000, "[MessagingDictationService#requestDialogStep] Illegal argument: dialogStep = %1", (long)n);
                        n3 = 2;
                    } else {
                        int n2;
                        switch (n) {
                            case 2: {
                                n2 = 2;
                                break;
                            }
                            case 0: {
                                n2 = 0;
                                break;
                            }
                            case 3: {
                                n2 = 3;
                                break;
                            }
                            case 1: {
                                n2 = 1;
                                break;
                            }
                            default: {
                                n2 = 0;
                            }
                        }
                        MessagingDictationService.this.msgApp.getNewMessage().setCursorPosition(n2);
                    }
                }
                catch (Exception exception) {
                    Logs.logException(MessagingDictationService.this.log, exception, "[MessagingDictationService#requestDialogStep]");
                    n3 = 1;
                }
                finally {
                    MessagingDictationService.this.emitResponseNextDialogStep(n3);
                }
            }
        });
    }

    public void requestAddRecipient(final int n, final String string, final long l, final String string2) {
        this.msgApp.getExecutorManager().getInternalTaskDispatcher().execute(new Runnable(){

            /*
             * WARNING - Removed try catching itself - possible behaviour change.
             */
            public void run() {
                int n2 = 0;
                try {
                    MessagingDictationService.this.log.log(1000000, "[MessagingDictationService#requestAddRecipient] recipientType = %1, addressOrNumber = %2, entryID = %3, combinedName = %4", (Object)String.valueOf(n), (Object)String.valueOf(string), (Object)String.valueOf(l), (Object)String.valueOf(string2));
                    if (!MessagingDictationService.this.isDialogInProgress) {
                        MessagingDictationService.this.log.log(10000, "[MessagingDictationService#requestBeginDialog] Illegal state: There is no dialog in progress.");
                        n2 = 3;
                    } else if (n == 0) {
                        MessagingDictationService.this.log.log(10000, "[MessagingDictationService#requestAddRecipient] Illegal argument: recipientType = %1", (long)n);
                        n2 = 2;
                    } else {
                        MatchedAddress[] matchedAddressArray = new MatchedAddress[]{new MatchedAddress(string, string2, l, null)};
                        if (n == 1) {
                            MessagingDictationService.this.msgApp.getNewMessage().getSelectedRecipientList().addRecipientsTo(matchedAddressArray);
                        } else if (n == 2) {
                            MessagingDictationService.this.msgApp.getNewMessage().getSelectedRecipientList().addRecipientsCc(matchedAddressArray);
                        } else if (n == 2) {
                            MessagingDictationService.this.msgApp.getNewMessage().getSelectedRecipientList().addRecipientsCc(matchedAddressArray);
                        }
                    }
                }
                catch (Exception exception) {
                    Logs.logException(MessagingDictationService.this.log, exception, "[MessagingDictationService#requestAddRecipient]");
                    n2 = 1;
                }
                finally {
                    MessagingDictationService.this.emitUpdateCompositionState(MessagingDictationService.this.getCompositionState());
                    MessagingDictationService.this.emitResponseAddRecipient(n2);
                }
            }
        });
    }

    public void requestClearRecipients(final int n) {
        this.msgApp.getExecutorManager().getInternalTaskDispatcher().execute(new Runnable(){

            /*
             * WARNING - Removed try catching itself - possible behaviour change.
             */
            public void run() {
                block8: {
                    int n3 = 0;
                    try {
                        MessagingDictationService.this.log.log(1000000, "[MessagingDictationService#requestClearRecipients] recipientType = %1", (long)n);
                        if (!MessagingDictationService.this.isDialogInProgress) {
                            MessagingDictationService.this.log.log(10000, "[MessagingDictationService#requestClearRecipients] Illegal state: There is no dialog in progress.");
                            n3 = 3;
                            break block8;
                        }
                        int n2 = 0;
                        try {
                            n2 = MessagingDictationService.toInternalRecipientType(n);
                        }
                        catch (IllegalArgumentException illegalArgumentException) {
                            MessagingDictationService.this.log.log(10000, "[MessagingDictationService#requestClearRecipients] Illegal argument: recipientType = %1", (long)n);
                            n3 = 2;
                        }
                        MessagingDictationService.this.msgApp.getNewMessage().getSelectedRecipientList().clear(n2);
                    }
                    catch (Exception exception) {
                        Logs.logException(MessagingDictationService.this.log, exception, "[MessagingDictationService#requestClearRecipients]");
                        n3 = 1;
                    }
                    finally {
                        MessagingDictationService.this.emitUpdateCompositionState(MessagingDictationService.this.getCompositionState());
                        MessagingDictationService.this.emitResponseClearRecipients(n3);
                    }
                }
            }
        });
    }

    public void requestSendMessage() {
        this.msgApp.getExecutorManager().getInternalTaskDispatcher().execute(new Runnable(){

            /*
             * WARNING - Removed try catching itself - possible behaviour change.
             */
            public void run() {
                int n = 0;
                try {
                    MessagingDictationService.this.log.log(1000000, "[MessagingDictationService#requestSendMessage]");
                    if (!MessagingDictationService.this.isDialogInProgress) {
                        MessagingDictationService.this.log.log(10000, "[MessagingDictationService#requestSendMessage] Illegal state: There is no dialog in progress.");
                        n = 3;
                    } else {
                        MessagingDictationService.this.msgApp.getNewMessage().getSendMessageController().sendButton(2200231, 0);
                    }
                }
                catch (Exception exception) {
                    Logs.logException(MessagingDictationService.this.log, exception, "[MessagingDictationService#requestSendMessage]");
                    n = 1;
                }
                finally {
                    MessagingDictationService.this.emitResponseSendMessage(n);
                }
            }
        });
    }

    public byte freezeDynamicLists() {
        this.log.log(1000000, "[MessagingDictationService#freezeDynamicLists]");
        return 0;
    }

    public byte unfreezeDynamicLists() {
        this.log.log(1000000, "[MessagingDictationService#unfreezeDynamicLists]");
        return 0;
    }

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

    private final class AccountManagerListener
    extends IAccountManagerListener.DefaultAccountManagerListener {
        private AccountManagerListener() {
        }

        public void selectedAccountChanged() {
            MessagingDictationService.this.msgApp.getExecutorManager().getInternalTaskDispatcher().execute(new Runnable(){

                public void run() {
                    MessagingDictationService.this.log.log(10000000, "[MessagingDictationService#selectedAccountChanged]");
                    if (MessagingDictationService.this.isDialogInProgress) {
                        if (MessagingDictationService.this.msgApp.getAccountManager().getSelectedAccount() == null) {
                            MessagingDictationService.this.hasDialogFailed = true;
                        } else {
                            MessagingDictationService.this.setAccountSelected(true);
                        }
                        MessagingDictationService.this.emitUpdateCompositionState(MessagingDictationService.this.getCompositionState());
                    }
                }
            });
        }
    }
}

