/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.messaging.core.application;

import de.audi.app.messaging.core.accounts.AccountManager;
import de.audi.app.messaging.core.addressbook.MessagingAdbHandler;
import de.audi.app.messaging.core.application.MessagingHmiApplication;
import de.audi.app.messaging.core.audio.AudioManager;
import de.audi.app.messaging.core.callback.CallbackNumberList;
import de.audi.app.messaging.core.cluster.ClusterManager;
import de.audi.app.messaging.core.component.AbstractMessagingComponent;
import de.audi.app.messaging.core.component.IMessagingComponent;
import de.audi.app.messaging.core.compose.AbstractOrganizerSearch;
import de.audi.app.messaging.core.compose.InterpretationGuessItem;
import de.audi.app.messaging.core.compose.NewMessage;
import de.audi.app.messaging.core.concurrent.ExecutorManager;
import de.audi.app.messaging.core.contactimport.ImportContactController;
import de.audi.app.messaging.core.deletemessage.DeleteMessageController;
import de.audi.app.messaging.core.dictation.EulaManager;
import de.audi.app.messaging.core.dictation.LicenseManager;
import de.audi.app.messaging.core.dictation.MessagingDictationService;
import de.audi.app.messaging.core.dsi.messaging.DsiMessagingAccess;
import de.audi.app.messaging.core.dsi.messaging.DsiMessagingPrimaryListener;
import de.audi.app.messaging.core.dsi.messagingconfig.DsiMessagingConfigAccess;
import de.audi.app.messaging.core.dsi.messagingconfig.DsiMessagingConfigPrimaryListener;
import de.audi.app.messaging.core.extracteditems.ExtractedMailAddressList;
import de.audi.app.messaging.core.extracteditems.ExtractedNumberList;
import de.audi.app.messaging.core.folderbrowsing.EntryList;
import de.audi.app.messaging.core.folderbrowsing.EntryListToolTip;
import de.audi.app.messaging.core.folderbrowsing.FolderNavigator;
import de.audi.app.messaging.core.folderbrowsing.IEntryListRowDataFactory;
import de.audi.app.messaging.core.guide.AbstractActionProxyService;
import de.audi.app.messaging.core.guide.ITextLookup;
import de.audi.app.messaging.core.guide.ModelAccess;
import de.audi.app.messaging.core.indication.NewMessageIndicationManager;
import de.audi.app.messaging.core.messagingservice.MessagingService;
import de.audi.app.messaging.core.osgi.AbstractMessagingTrackerCustomizer;
import de.audi.app.messaging.core.osgi.IServiceRegistry;
import de.audi.app.messaging.core.osgi.MessagingBundleContext;
import de.audi.app.messaging.core.osgi.ServiceFilterBuilder;
import de.audi.app.messaging.core.powerstate.PowerStateHandler;
import de.audi.app.messaging.core.readout.MessageReader;
import de.audi.app.messaging.core.readout.MessagingReadoutService;
import de.audi.app.messaging.core.settings.SettingsManager;
import de.audi.app.messaging.core.setup.SetupManager;
import de.audi.app.messaging.core.swdiagnosis.MessagingSwDiagnosis;
import de.audi.app.messaging.core.templates.NaviGateway;
import de.audi.app.messaging.core.templates.TemplateList;
import de.audi.app.messaging.core.uniqueid.UniqueIdDispenser;
import de.audi.app.messaging.core.util.TextEditorUtil;
import de.audi.app.messaging.core.viewmessage.MessageOptionsManager;
import de.audi.app.messaging.core.viewmessage.RecipientList;
import de.audi.app.messaging.core.viewmessage.SelectedMessage;
import de.audi.atip.base.IFrameworkAccess;
import de.audi.atip.interapp.ADBHMIAppService;
import de.audi.atip.interapp.SDSService;
import de.audi.atip.phone.ITelService;
import org.osgi.framework.BundleContext;
import org.osgi.framework.Filter;
import org.osgi.framework.InvalidSyntaxException;
import org.osgi.framework.ServiceReference;
import org.osgi.util.tracker.ServiceTracker;
import org.osgi.util.tracker.ServiceTrackerCustomizer;

public abstract class AbstractMsgApplication
extends AbstractMessagingComponent
implements IMessagingComponent {
    private final UniqueIdDispenser uniqueIdDispenser;
    private final DsiMessagingAccess dsiMessagingAccess;
    private final DsiMessagingPrimaryListener dsiMessagingPrimaryListener;
    private final DsiMessagingConfigAccess dsiMessagingConfigAccess;
    private final DsiMessagingConfigPrimaryListener dsiMessagingConfigPrimaryListener;
    private final ModelAccess modelAccess;
    private final ExecutorManager executorManager;
    private final AbstractActionProxyService actionProxyService;
    private final ITextLookup textLookup;
    private final MessagingService messagingService;
    private final MessageReader messageReader;
    private final AccountManager accountManager;
    private final EntryList entryList;
    private final ExtractedNumberList extractedNumberList;
    private ExtractedMailAddressList extractedMailAddressList;
    private final RecipientList recipientList;
    private final TemplateList templateList;
    private final NaviGateway naviGateway;
    private final FolderNavigator folderNavigator;
    private final NewMessage newMessage;
    private final SelectedMessage selectedMessage;
    private final MessageOptionsManager messageOptionsManager;
    private final CallbackNumberList callbackNumberList;
    private final ImportContactController importContactController;
    private final DeleteMessageController deleteMessageController;
    private final MessagingReadoutService messagingReadoutService;
    private final SettingsManager settingsManager;
    private final AudioManager audioManager;
    private final SetupManager setupManager;
    private final TextEditorUtil textEditorUtil;
    private final InterpretationGuessItem interpretationGuessItem;
    private final MessagingAdbHandler messagingAdbHandler;
    private final AbstractOrganizerSearch organizerSearch;
    private final MessagingSwDiagnosis messagingSwDiagnosis;
    private volatile ADBHMIAppService adbHmiAppService;
    private volatile ITelService telService;
    private volatile SDSService sdsService;
    private volatile MessagingDictationService messagingDictationService;
    private IEntryListRowDataFactory entryListRowDataFactory;
    static /* synthetic */ Class class$de$audi$atip$interapp$ADBHMIAppService;
    static /* synthetic */ Class class$de$audi$atip$phone$ITelService;
    static /* synthetic */ Class class$de$audi$atip$interapp$SDSService;

    public AbstractMsgApplication(MessagingBundleContext messagingBundleContext) {
        super(messagingBundleContext, "App.Messaging.Main");
        this.log.log(10000000, "[MsgApplication#MsgApplication] Creating application components.");
        this.uniqueIdDispenser = new UniqueIdDispenser(messagingBundleContext);
        this.addComponent(this.uniqueIdDispenser);
        this.executorManager = new ExecutorManager(messagingBundleContext);
        this.addComponent(this.executorManager);
        this.addComponent(new MessagingHmiApplication(messagingBundleContext));
        this.dsiMessagingAccess = new DsiMessagingAccess(messagingBundleContext);
        this.dsiMessagingPrimaryListener = new DsiMessagingPrimaryListener(messagingBundleContext);
        this.dsiMessagingConfigAccess = new DsiMessagingConfigAccess(messagingBundleContext);
        this.dsiMessagingConfigPrimaryListener = new DsiMessagingConfigPrimaryListener(messagingBundleContext);
        this.addComponent(this.dsiMessagingAccess);
        this.addComponent(this.dsiMessagingPrimaryListener);
        this.addComponent(this.dsiMessagingConfigAccess);
        this.addComponent(this.dsiMessagingConfigPrimaryListener);
        this.modelAccess = new ModelAccess(messagingBundleContext);
        this.actionProxyService = this.createActionProxyService(messagingBundleContext);
        this.textLookup = this.createTextLookup(messagingBundleContext);
        this.addComponent(this.modelAccess);
        this.addComponent(this.actionProxyService);
        this.addComponent(this.textLookup);
        this.textEditorUtil = new TextEditorUtil(messagingBundleContext);
        this.addComponent(this.textEditorUtil);
        this.accountManager = new AccountManager(messagingBundleContext);
        this.addComponent(this.accountManager);
        this.folderNavigator = new FolderNavigator(messagingBundleContext);
        this.entryList = new EntryList(messagingBundleContext);
        this.addComponent(this.folderNavigator);
        this.addComponent(this.entryList);
        this.addComponent(new EntryListToolTip(messagingBundleContext));
        this.selectedMessage = new SelectedMessage(messagingBundleContext);
        this.messageOptionsManager = new MessageOptionsManager(messagingBundleContext);
        this.recipientList = new RecipientList(messagingBundleContext);
        this.callbackNumberList = new CallbackNumberList(messagingBundleContext);
        this.extractedNumberList = new ExtractedNumberList(messagingBundleContext);
        this.extractedMailAddressList = new ExtractedMailAddressList(messagingBundleContext);
        this.importContactController = new ImportContactController(messagingBundleContext);
        this.addComponent(this.selectedMessage);
        this.addComponent(this.messageOptionsManager);
        this.addComponent(this.recipientList);
        this.addComponent(this.extractedNumberList);
        this.addComponent(this.extractedMailAddressList);
        this.addComponent(this.callbackNumberList);
        this.addComponent(this.importContactController);
        this.deleteMessageController = new DeleteMessageController(messagingBundleContext);
        this.addComponent(this.deleteMessageController);
        this.messageReader = new MessageReader(messagingBundleContext);
        this.messagingReadoutService = new MessagingReadoutService(messagingBundleContext);
        this.addComponent(this.messageReader);
        this.addComponent(this.messagingReadoutService);
        this.templateList = new TemplateList(messagingBundleContext);
        this.naviGateway = new NaviGateway(messagingBundleContext);
        this.newMessage = new NewMessage(messagingBundleContext);
        this.addComponent(this.templateList);
        this.addComponent(this.newMessage);
        this.addComponent(this.naviGateway);
        this.audioManager = new AudioManager(messagingBundleContext);
        this.addComponent(this.audioManager);
        this.addComponent(new PowerStateHandler(messagingBundleContext));
        this.settingsManager = new SettingsManager(messagingBundleContext);
        this.setupManager = new SetupManager(messagingBundleContext);
        this.addComponent(this.settingsManager);
        this.addComponent(this.setupManager);
        this.interpretationGuessItem = new InterpretationGuessItem(messagingBundleContext);
        this.messagingAdbHandler = new MessagingAdbHandler(messagingBundleContext);
        this.organizerSearch = this.createOrganizerSearch(messagingBundleContext);
        this.addComponent(this.interpretationGuessItem);
        this.addComponent(this.messagingAdbHandler);
        this.addComponent(this.organizerSearch);
        this.addComponent(new ClusterManager(messagingBundleContext));
        this.messagingDictationService = new MessagingDictationService(messagingBundleContext);
        this.addComponent(this.messagingDictationService);
        if (this.framework.getSysConstManager().getAdaptationANP().isOnlineDictationAvailable()) {
            this.addComponent(new EulaManager(messagingBundleContext));
            this.addComponent(new LicenseManager(messagingBundleContext));
        }
        this.messagingService = new MessagingService(messagingBundleContext);
        this.addComponent(this.messagingService);
        this.messagingSwDiagnosis = new MessagingSwDiagnosis(messagingBundleContext);
        this.addComponent(this.messagingSwDiagnosis);
    }

    public void connect(IServiceRegistry iServiceRegistry) {
        try {
            super.connect(iServiceRegistry);
            iServiceRegistry.addTracker(this.createServiceTracker());
        }
        catch (Exception exception) {
            this.log.log(10000, "[AbstractMsgApplication#connect] An error occurred: ", (Throwable)exception);
        }
    }

    public final IFrameworkAccess getFramework() {
        return this.framework;
    }

    public final BundleContext getBundleContext() {
        return this.bundleContext;
    }

    public final UniqueIdDispenser getUniqueIdDispenser() {
        return this.uniqueIdDispenser;
    }

    public final DsiMessagingAccess getDsiMessagingAccess() {
        return this.dsiMessagingAccess;
    }

    public final DsiMessagingPrimaryListener getDsiMessagingPrimaryListener() {
        return this.dsiMessagingPrimaryListener;
    }

    public final DsiMessagingConfigAccess getDsiMessagingConfigAccess() {
        return this.dsiMessagingConfigAccess;
    }

    public final DsiMessagingConfigPrimaryListener getDsiMessagingConfigPrimaryListener() {
        return this.dsiMessagingConfigPrimaryListener;
    }

    public final ModelAccess getModelAccess() {
        return this.modelAccess;
    }

    public final AbstractActionProxyService getActionProxyService() {
        return this.actionProxyService;
    }

    public final ITextLookup getTextLookup() {
        return this.textLookup;
    }

    public final MessagingService getMessagingService() {
        return this.messagingService;
    }

    public final MessageReader getMessageReader() {
        return this.messageReader;
    }

    public ExecutorManager getExecutorManager() {
        return this.executorManager;
    }

    public final AccountManager getAccountManager() {
        return this.accountManager;
    }

    public final EntryList getEntryList() {
        return this.entryList;
    }

    public final ExtractedNumberList getExtractedNumberList() {
        return this.extractedNumberList;
    }

    public ExtractedMailAddressList getExtractedMailAddressList() {
        return this.extractedMailAddressList;
    }

    public abstract NewMessageIndicationManager getNewMessageIndicationManager();

    public final RecipientList getRecipientList() {
        return this.recipientList;
    }

    public final TemplateList getTemplateList() {
        return this.templateList;
    }

    public final MessagingSwDiagnosis getMessagingSwDiagnosis() {
        return this.messagingSwDiagnosis;
    }

    public final FolderNavigator getFolderNavigator() {
        return this.folderNavigator;
    }

    public final NewMessage getNewMessage() {
        return this.newMessage;
    }

    public final SelectedMessage getSelectedMessage() {
        return this.selectedMessage;
    }

    public final MessageOptionsManager getMessageOptionsManager() {
        return this.messageOptionsManager;
    }

    public CallbackNumberList getCallbackNumberList() {
        return this.callbackNumberList;
    }

    public ImportContactController getImportContactController() {
        return this.importContactController;
    }

    public DeleteMessageController getDeleteMessageController() {
        return this.deleteMessageController;
    }

    public final MessagingReadoutService getMessagingReadoutService() {
        return this.messagingReadoutService;
    }

    public final SettingsManager getSettingsManager() {
        return this.settingsManager;
    }

    public final AudioManager getAudioManager() {
        return this.audioManager;
    }

    public final SetupManager getSetupManager() {
        return this.setupManager;
    }

    public final TextEditorUtil getTextEditorUtil() {
        return this.textEditorUtil;
    }

    public final InterpretationGuessItem getInterpretationGuessItem() {
        return this.interpretationGuessItem;
    }

    public final MessagingAdbHandler getMessagingAdbHandler() {
        return this.messagingAdbHandler;
    }

    public final AbstractOrganizerSearch getOrganizerSearch() {
        return this.organizerSearch;
    }

    public final ADBHMIAppService getAdbHmiAppService() {
        return this.adbHmiAppService;
    }

    private final void setAdbHmiAppService(ADBHMIAppService aDBHMIAppService) {
        this.adbHmiAppService = aDBHMIAppService;
    }

    public IEntryListRowDataFactory getEntryListRowDataFactory() {
        return this.entryListRowDataFactory;
    }

    public void setEntryListRowDataFactory(IEntryListRowDataFactory iEntryListRowDataFactory) {
        this.entryListRowDataFactory = iEntryListRowDataFactory;
    }

    public NaviGateway getNaviGateway() {
        return this.naviGateway;
    }

    public final ITelService getTelService() {
        return this.telService;
    }

    private final void setTelService(ITelService iTelService) {
        this.telService = iTelService;
    }

    public final SDSService getSdsService() {
        return this.sdsService;
    }

    public final MessagingDictationService getMessagingDictationService() {
        return this.messagingDictationService;
    }

    private final void setSdsService(SDSService sDSService) {
        this.sdsService = sDSService;
    }

    protected abstract AbstractActionProxyService createActionProxyService(MessagingBundleContext var1);

    protected abstract ITextLookup createTextLookup(MessagingBundleContext var1);

    protected abstract AbstractOrganizerSearch createOrganizerSearch(MessagingBundleContext var1);

    private ServiceTracker createServiceTracker() throws InvalidSyntaxException {
        ServiceFilterBuilder serviceFilterBuilder = new ServiceFilterBuilder();
        serviceFilterBuilder.beginOr();
        serviceFilterBuilder.addProperty("objectClass", (class$de$audi$atip$interapp$ADBHMIAppService == null ? (class$de$audi$atip$interapp$ADBHMIAppService = AbstractMsgApplication.class$("de.audi.atip.interapp.ADBHMIAppService")) : class$de$audi$atip$interapp$ADBHMIAppService).getName());
        serviceFilterBuilder.addProperty("objectClass", (class$de$audi$atip$phone$ITelService == null ? (class$de$audi$atip$phone$ITelService = AbstractMsgApplication.class$("de.audi.atip.phone.ITelService")) : class$de$audi$atip$phone$ITelService).getName());
        serviceFilterBuilder.addProperty("objectClass", (class$de$audi$atip$interapp$SDSService == null ? (class$de$audi$atip$interapp$SDSService = AbstractMsgApplication.class$("de.audi.atip.interapp.SDSService")) : class$de$audi$atip$interapp$SDSService).getName());
        serviceFilterBuilder.endOr();
        String string = serviceFilterBuilder.createFilterString();
        Filter filter = this.bundleContext.createFilter(string);
        AbstractMessagingTrackerCustomizer abstractMessagingTrackerCustomizer = new AbstractMessagingTrackerCustomizer(this.log, this.bundleContext){

            public void addService(ServiceReference serviceReference, Object object) {
                if (object instanceof ADBHMIAppService) {
                    AbstractMsgApplication.this.setAdbHmiAppService((ADBHMIAppService)object);
                } else if (object instanceof ITelService) {
                    AbstractMsgApplication.this.setTelService((ITelService)object);
                } else {
                    AbstractMsgApplication.this.setSdsService((SDSService)object);
                }
            }

            public void removeService(ServiceReference serviceReference, Object object) {
                if (object instanceof ADBHMIAppService) {
                    AbstractMsgApplication.this.setAdbHmiAppService(null);
                } else if (object instanceof ITelService) {
                    AbstractMsgApplication.this.setTelService(null);
                } else {
                    AbstractMsgApplication.this.setSdsService(null);
                }
            }
        };
        return new ServiceTracker(this.bundleContext, filter, (ServiceTrackerCustomizer)abstractMessagingTrackerCustomizer);
    }

    static /* synthetic */ Class class$(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new NoClassDefFoundError().initCause(classNotFoundException);
        }
    }
}

