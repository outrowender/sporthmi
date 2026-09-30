/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  de.mib.swdiagnosis.online.OnlineDiag
 */
package de.audi.tghu.online.app;

import de.audi.atip.activator.AbstractActivator;
import de.audi.atip.browser.IBrowserHandler;
import de.audi.atip.diag.sw.AbstractSwDiagnosis;
import de.audi.atip.diag.sw.SwDiagnosisManager;
import de.audi.atip.interapp.ADBHMIAppService;
import de.audi.atip.interapp.FactResetService;
import de.audi.atip.interapp.IConnectivityOnlineStateListener;
import de.audi.atip.interapp.IConnectivityRHMIStateListener;
import de.audi.atip.interapp.INaviFormattingService;
import de.audi.atip.interapp.MapService;
import de.audi.atip.interapp.NaviADBService;
import de.audi.atip.interapp.NaviMyAudiImport;
import de.audi.atip.interapp.NaviService;
import de.audi.atip.interapp.OnlineHMIService;
import de.audi.atip.interapp.OnlineServiceListener;
import de.audi.atip.interapp.PortalAuthenticationService;
import de.audi.atip.interapp.SDSService;
import de.audi.atip.interapp.eni.ENIServiceOnline;
import de.audi.atip.interapp.media.IMediaDrawerContext;
import de.audi.atip.interapp.media.IMediaOnlinePlayerService;
import de.audi.atip.interapp.media.IMediaService;
import de.audi.atip.interapp.messaging.IMessagingOnlineService;
import de.audi.atip.interapp.messaging.folderbrowsing.IFolderBrowsingService;
import de.audi.atip.interapp.navigation.previewmap.IPreviewMap;
import de.audi.atip.interapp.online.IOnlineSDSMyAudiServiceListener;
import de.audi.atip.interapp.online.IOperatorCallNaviService;
import de.audi.atip.interapp.online.IOperatorCallSDSService;
import de.audi.atip.interapp.online.IRemoteHMIEsimLicenseListener;
import de.audi.atip.interapp.online.IRemoteHMIMediaOnlineServiceListener;
import de.audi.atip.interapp.online.MobileKeyStatusDisplayService;
import de.audi.atip.interapp.online.OnlinePOICall;
import de.audi.atip.interapp.tts.TTSService;
import de.audi.atip.interapp.tts.TTSSessionBasedService;
import de.audi.atip.log.LogChannel;
import de.audi.atip.phone.ITelService;
import de.audi.atip.phone.ITelServiceConnectivity;
import de.audi.atip.storage.IStorageAccess;
import de.audi.atip.variant.IGUIVariantProvider;
import de.audi.atip.variant.IIDMapper;
import de.audi.remotehmi.IRemoteHMI;
import de.audi.tghu.online.app.JokerKeyHandler;
import de.audi.tghu.online.app.Online;
import de.audi.tghu.online.app.OnlineEnv;
import de.audi.tghu.online.app.onlinedest.OnlineDestinationController;
import de.audi.tghu.online.app.operatorcall.AbstractOperatorCallMain;
import de.audi.tghu.online.app.operatorcall.handler.TestHandler;
import de.audi.tghu.online.app.osr.OnlineLogoProvider;
import de.audi.tghu.online.app.osr.OnlineService;
import de.audi.tghu.online.app.osr.OnlineServiceRegistrationSubsystem;
import de.audi.tghu.online.app.osr.auth.T2AuthenticationService;
import de.audi.tghu.online.app.osr.license.LicenseCollectionService;
import de.audi.tghu.online.app.remotehmi.OnlineModelBankAccess;
import de.audi.tghu.online.app.remotehmi.OnlineRemoteHMIActivator;
import de.audi.tghu.online.app.remotehmi.RemoteHMIDSIAccess;
import de.audi.tghu.online.app.remotehmi.RemoteHMIService;
import de.audi.tghu.online.app.standard.IMobileKeyLicenseListener;
import de.audi.tghu.online.app.standard.IStandardController;
import de.audi.tghu.online.app.standard.OnlineI18NHandler;
import de.audi.tghu.online.app.standard.PrivacyFeatureStorageAccess;
import de.audi.tghu.online.app.standard.SimpleServiceRegistrationListener;
import de.mib.swdiagnosis.online.OnlineDiag;
import java.lang.reflect.Field;
import java.util.Dictionary;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.online.DSIDestinationImport;
import org.dsi.ifc.online.DSIOnlineServiceRegistration;
import org.dsi.ifc.online.DSIOperatorCall;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;
import org.osgi.framework.ServiceRegistration;
import org.osgi.util.tracker.ServiceTracker;
import org.osgi.util.tracker.ServiceTrackerCustomizer;

public abstract class AbstractOnlineActivator
extends AbstractActivator
implements ServiceTrackerCustomizer,
IGUIVariantProvider {
    private static final String[] REQUIRED_SERVICES = new String[]{(class$de$audi$atip$interapp$navigation$previewmap$IPreviewMap == null ? (class$de$audi$atip$interapp$navigation$previewmap$IPreviewMap = AbstractOnlineActivator.class$("de.audi.atip.interapp.navigation.previewmap.IPreviewMap")) : class$de$audi$atip$interapp$navigation$previewmap$IPreviewMap).getName(), (class$de$audi$atip$interapp$media$IMediaDrawerContext == null ? (class$de$audi$atip$interapp$media$IMediaDrawerContext = AbstractOnlineActivator.class$("de.audi.atip.interapp.media.IMediaDrawerContext")) : class$de$audi$atip$interapp$media$IMediaDrawerContext).getName(), (class$de$audi$atip$interapp$online$IOperatorCallNaviService == null ? (class$de$audi$atip$interapp$online$IOperatorCallNaviService = AbstractOnlineActivator.class$("de.audi.atip.interapp.online.IOperatorCallNaviService")) : class$de$audi$atip$interapp$online$IOperatorCallNaviService).getName(), (class$de$audi$atip$interapp$online$IOperatorCallSDSService == null ? (class$de$audi$atip$interapp$online$IOperatorCallSDSService = AbstractOnlineActivator.class$("de.audi.atip.interapp.online.IOperatorCallSDSService")) : class$de$audi$atip$interapp$online$IOperatorCallSDSService).getName(), (class$de$audi$atip$diag$sw$SwDiagnosisManager == null ? (class$de$audi$atip$diag$sw$SwDiagnosisManager = AbstractOnlineActivator.class$("de.audi.atip.diag.sw.SwDiagnosisManager")) : class$de$audi$atip$diag$sw$SwDiagnosisManager).getName(), (class$org$dsi$ifc$online$DSIOnlineServiceRegistration == null ? (class$org$dsi$ifc$online$DSIOnlineServiceRegistration = AbstractOnlineActivator.class$("org.dsi.ifc.online.DSIOnlineServiceRegistration")) : class$org$dsi$ifc$online$DSIOnlineServiceRegistration).getName(), (class$de$audi$atip$interapp$SDSService == null ? (class$de$audi$atip$interapp$SDSService = AbstractOnlineActivator.class$("de.audi.atip.interapp.SDSService")) : class$de$audi$atip$interapp$SDSService).getName(), (class$de$audi$atip$interapp$NaviADBService == null ? (class$de$audi$atip$interapp$NaviADBService = AbstractOnlineActivator.class$("de.audi.atip.interapp.NaviADBService")) : class$de$audi$atip$interapp$NaviADBService).getName(), (class$de$audi$atip$interapp$NaviService == null ? (class$de$audi$atip$interapp$NaviService = AbstractOnlineActivator.class$("de.audi.atip.interapp.NaviService")) : class$de$audi$atip$interapp$NaviService).getName(), (class$de$audi$atip$interapp$INaviFormattingService == null ? (class$de$audi$atip$interapp$INaviFormattingService = AbstractOnlineActivator.class$("de.audi.atip.interapp.INaviFormattingService")) : class$de$audi$atip$interapp$INaviFormattingService).getName(), (class$de$audi$atip$interapp$ADBHMIAppService == null ? (class$de$audi$atip$interapp$ADBHMIAppService = AbstractOnlineActivator.class$("de.audi.atip.interapp.ADBHMIAppService")) : class$de$audi$atip$interapp$ADBHMIAppService).getName(), (class$de$audi$atip$interapp$NaviMyAudiImport == null ? (class$de$audi$atip$interapp$NaviMyAudiImport = AbstractOnlineActivator.class$("de.audi.atip.interapp.NaviMyAudiImport")) : class$de$audi$atip$interapp$NaviMyAudiImport).getName(), (class$de$audi$atip$phone$ITelService == null ? (class$de$audi$atip$phone$ITelService = AbstractOnlineActivator.class$("de.audi.atip.phone.ITelService")) : class$de$audi$atip$phone$ITelService).getName(), (class$de$audi$atip$interapp$online$IRemoteHMIMediaOnlineServiceListener == null ? (class$de$audi$atip$interapp$online$IRemoteHMIMediaOnlineServiceListener = AbstractOnlineActivator.class$("de.audi.atip.interapp.online.IRemoteHMIMediaOnlineServiceListener")) : class$de$audi$atip$interapp$online$IRemoteHMIMediaOnlineServiceListener).getName(), (class$de$audi$atip$interapp$online$IRemoteHMIEsimLicenseListener == null ? (class$de$audi$atip$interapp$online$IRemoteHMIEsimLicenseListener = AbstractOnlineActivator.class$("de.audi.atip.interapp.online.IRemoteHMIEsimLicenseListener")) : class$de$audi$atip$interapp$online$IRemoteHMIEsimLicenseListener).getName(), (class$de$audi$atip$interapp$online$IOnlineSDSMyAudiServiceListener == null ? (class$de$audi$atip$interapp$online$IOnlineSDSMyAudiServiceListener = AbstractOnlineActivator.class$("de.audi.atip.interapp.online.IOnlineSDSMyAudiServiceListener")) : class$de$audi$atip$interapp$online$IOnlineSDSMyAudiServiceListener).getName(), (class$org$dsi$ifc$online$DSIDestinationImport == null ? (class$org$dsi$ifc$online$DSIDestinationImport = AbstractOnlineActivator.class$("org.dsi.ifc.online.DSIDestinationImport")) : class$org$dsi$ifc$online$DSIDestinationImport).getName(), (class$org$dsi$ifc$online$DSIOperatorCall == null ? (class$org$dsi$ifc$online$DSIOperatorCall = AbstractOnlineActivator.class$("org.dsi.ifc.online.DSIOperatorCall")) : class$org$dsi$ifc$online$DSIOperatorCall).getName(), (class$de$audi$atip$interapp$IConnectivityOnlineStateListener == null ? (class$de$audi$atip$interapp$IConnectivityOnlineStateListener = AbstractOnlineActivator.class$("de.audi.atip.interapp.IConnectivityOnlineStateListener")) : class$de$audi$atip$interapp$IConnectivityOnlineStateListener).getName(), (class$de$audi$atip$interapp$online$OnlinePOICall == null ? (class$de$audi$atip$interapp$online$OnlinePOICall = AbstractOnlineActivator.class$("de.audi.atip.interapp.online.OnlinePOICall")) : class$de$audi$atip$interapp$online$OnlinePOICall).getName(), (class$de$audi$atip$browser$IBrowserHandler == null ? (class$de$audi$atip$browser$IBrowserHandler = AbstractOnlineActivator.class$("de.audi.atip.browser.IBrowserHandler")) : class$de$audi$atip$browser$IBrowserHandler).getName(), (class$de$audi$remotehmi$IRemoteHMI == null ? (class$de$audi$remotehmi$IRemoteHMI = AbstractOnlineActivator.class$("de.audi.remotehmi.IRemoteHMI")) : class$de$audi$remotehmi$IRemoteHMI).getName(), (class$de$audi$atip$interapp$tts$TTSService == null ? (class$de$audi$atip$interapp$tts$TTSService = AbstractOnlineActivator.class$("de.audi.atip.interapp.tts.TTSService")) : class$de$audi$atip$interapp$tts$TTSService).getName(), (class$de$audi$atip$interapp$MapService == null ? (class$de$audi$atip$interapp$MapService = AbstractOnlineActivator.class$("de.audi.atip.interapp.MapService")) : class$de$audi$atip$interapp$MapService).getName(), (class$de$audi$atip$interapp$media$IMediaOnlinePlayerService == null ? (class$de$audi$atip$interapp$media$IMediaOnlinePlayerService = AbstractOnlineActivator.class$("de.audi.atip.interapp.media.IMediaOnlinePlayerService")) : class$de$audi$atip$interapp$media$IMediaOnlinePlayerService).getName(), (class$de$audi$atip$interapp$media$IMediaService == null ? (class$de$audi$atip$interapp$media$IMediaService = AbstractOnlineActivator.class$("de.audi.atip.interapp.media.IMediaService")) : class$de$audi$atip$interapp$media$IMediaService).getName(), (class$de$audi$atip$interapp$OnlineServiceListener == null ? (class$de$audi$atip$interapp$OnlineServiceListener = AbstractOnlineActivator.class$("de.audi.atip.interapp.OnlineServiceListener")) : class$de$audi$atip$interapp$OnlineServiceListener).getName(), (class$de$audi$atip$interapp$OnlineHMIService == null ? (class$de$audi$atip$interapp$OnlineHMIService = AbstractOnlineActivator.class$("de.audi.atip.interapp.OnlineHMIService")) : class$de$audi$atip$interapp$OnlineHMIService).getName(), (class$de$audi$atip$interapp$PortalAuthenticationService == null ? (class$de$audi$atip$interapp$PortalAuthenticationService = AbstractOnlineActivator.class$("de.audi.atip.interapp.PortalAuthenticationService")) : class$de$audi$atip$interapp$PortalAuthenticationService).getName(), (class$de$audi$atip$interapp$IConnectivityRHMIStateListener == null ? (class$de$audi$atip$interapp$IConnectivityRHMIStateListener = AbstractOnlineActivator.class$("de.audi.atip.interapp.IConnectivityRHMIStateListener")) : class$de$audi$atip$interapp$IConnectivityRHMIStateListener).getName(), (class$de$audi$atip$interapp$messaging$IMessagingOnlineService == null ? (class$de$audi$atip$interapp$messaging$IMessagingOnlineService = AbstractOnlineActivator.class$("de.audi.atip.interapp.messaging.IMessagingOnlineService")) : class$de$audi$atip$interapp$messaging$IMessagingOnlineService).getName(), (class$de$audi$atip$interapp$messaging$folderbrowsing$IFolderBrowsingService == null ? (class$de$audi$atip$interapp$messaging$folderbrowsing$IFolderBrowsingService = AbstractOnlineActivator.class$("de.audi.atip.interapp.messaging.folderbrowsing.IFolderBrowsingService")) : class$de$audi$atip$interapp$messaging$folderbrowsing$IFolderBrowsingService).getName(), (class$de$audi$atip$phone$ITelServiceConnectivity == null ? (class$de$audi$atip$phone$ITelServiceConnectivity = AbstractOnlineActivator.class$("de.audi.atip.phone.ITelServiceConnectivity")) : class$de$audi$atip$phone$ITelServiceConnectivity).getName(), (class$de$audi$atip$interapp$eni$ENIServiceOnline == null ? (class$de$audi$atip$interapp$eni$ENIServiceOnline = AbstractOnlineActivator.class$("de.audi.atip.interapp.eni.ENIServiceOnline")) : class$de$audi$atip$interapp$eni$ENIServiceOnline).getName(), (class$de$audi$atip$interapp$online$MobileKeyStatusDisplayService == null ? (class$de$audi$atip$interapp$online$MobileKeyStatusDisplayService = AbstractOnlineActivator.class$("de.audi.atip.interapp.online.MobileKeyStatusDisplayService")) : class$de$audi$atip$interapp$online$MobileKeyStatusDisplayService).getName(), (class$de$audi$atip$interapp$FactResetService == null ? (class$de$audi$atip$interapp$FactResetService = AbstractOnlineActivator.class$("de.audi.atip.interapp.FactResetService")) : class$de$audi$atip$interapp$FactResetService).getName()};
    protected LogChannel logChannel;
    private OnlineServiceRegistrationSubsystem onlineServiceRegistrationSubsystem;
    private RemoteHMIService remoteHMIService;
    private IStandardController standardController;
    private IMobileKeyLicenseListener mobileKeyLicenseListener;
    private LicenseCollectionService licenseCollectionService;
    private OnlineRemoteHMIActivator remoteHmiActivator;
    private ServiceTracker serviceTrackerOnline;
    private OnlineDestinationController onlineDestHandler;
    private AbstractOperatorCallMain operatorCallController;
    private OnlineI18NHandler i18nHandler;
    private OnlineLogoProvider logoProviderService;
    private OnlineModelBankAccess modelBank;
    private JokerKeyHandler jokerKeyHandler;
    private OnlineEnv onlineEnv;
    private IIDMapper textConstants;
    private IIDMapper smEventConstants;
    private PrivacyFeatureStorageAccess privacyFeatureStorageAccess;
    private SimpleServiceRegistrationListener serviceRegistrationListener;
    private IPreviewMap previewMap;
    private IMediaDrawerContext mediaDrawerContext;
    private IOperatorCallNaviService operatorCallNaviService;
    private IOperatorCallSDSService operatorCallSDSService;
    private SwDiagnosisManager diagnosisManager;
    private DSIOnlineServiceRegistration dsiOnlineServiceRegistration;
    private SDSService sdsService;
    private NaviADBService naviAdbService;
    private NaviService naviService;
    private INaviFormattingService naviFormattingService;
    private ADBHMIAppService adbHmiAppService;
    private NaviMyAudiImport naviMyAudiImport;
    private ITelService telService;
    private IRemoteHMIMediaOnlineServiceListener remoteHMIMediaOnlineServiceListener;
    private IRemoteHMIEsimLicenseListener remoteHMIEsimLicenseListener;
    private IOnlineSDSMyAudiServiceListener onlineSdsMyAudiServiceListener;
    private DSIDestinationImport dsiDestinationImport;
    private DSIOperatorCall dsiOperatorCall;
    private IConnectivityOnlineStateListener connectivityOnlineStateListener;
    private OnlinePOICall onlinePOICall;
    private IRemoteHMI remoteHmi;
    private TTSService ttsService;
    private MapService mapService;
    private IMediaOnlinePlayerService mediaOnlinePlayerService;
    private IMediaService mediaService;
    private OnlineServiceListener onlineServiceListener;
    private OnlineHMIService onlineHMIService;
    private PortalAuthenticationService portalAuthenticationService;
    private IConnectivityRHMIStateListener connectivityRHMIStateListener;
    private IMessagingOnlineService messagingOnlineService;
    private IFolderBrowsingService folderBrowsingService;
    private ITelServiceConnectivity telServiceConnectivity;
    private ENIServiceOnline eniServiceOnline;
    private MobileKeyStatusDisplayService mobileKeyStatusDisplayService;
    private FactResetService factoryResetService;
    private HashMap browserHandlers = new HashMap();
    protected boolean useRemoteHmi;
    protected boolean useEni;
    protected boolean privacyModeFeatureAvailable = true;
    private ServiceRegistration authenticationServiceRegistration;
    static /* synthetic */ Class class$de$audi$atip$interapp$navigation$previewmap$IPreviewMap;
    static /* synthetic */ Class class$de$audi$atip$interapp$media$IMediaDrawerContext;
    static /* synthetic */ Class class$de$audi$atip$interapp$online$IOperatorCallNaviService;
    static /* synthetic */ Class class$de$audi$atip$interapp$online$IOperatorCallSDSService;
    static /* synthetic */ Class class$de$audi$atip$diag$sw$SwDiagnosisManager;
    static /* synthetic */ Class class$org$dsi$ifc$online$DSIOnlineServiceRegistration;
    static /* synthetic */ Class class$de$audi$atip$interapp$SDSService;
    static /* synthetic */ Class class$de$audi$atip$interapp$NaviADBService;
    static /* synthetic */ Class class$de$audi$atip$interapp$NaviService;
    static /* synthetic */ Class class$de$audi$atip$interapp$INaviFormattingService;
    static /* synthetic */ Class class$de$audi$atip$interapp$ADBHMIAppService;
    static /* synthetic */ Class class$de$audi$atip$interapp$NaviMyAudiImport;
    static /* synthetic */ Class class$de$audi$atip$phone$ITelService;
    static /* synthetic */ Class class$de$audi$atip$interapp$online$IRemoteHMIMediaOnlineServiceListener;
    static /* synthetic */ Class class$de$audi$atip$interapp$online$IRemoteHMIEsimLicenseListener;
    static /* synthetic */ Class class$de$audi$atip$interapp$online$IOnlineSDSMyAudiServiceListener;
    static /* synthetic */ Class class$org$dsi$ifc$online$DSIDestinationImport;
    static /* synthetic */ Class class$org$dsi$ifc$online$DSIOperatorCall;
    static /* synthetic */ Class class$de$audi$atip$interapp$IConnectivityOnlineStateListener;
    static /* synthetic */ Class class$de$audi$atip$interapp$online$OnlinePOICall;
    static /* synthetic */ Class class$de$audi$atip$browser$IBrowserHandler;
    static /* synthetic */ Class class$de$audi$remotehmi$IRemoteHMI;
    static /* synthetic */ Class class$de$audi$atip$interapp$tts$TTSService;
    static /* synthetic */ Class class$de$audi$atip$interapp$MapService;
    static /* synthetic */ Class class$de$audi$atip$interapp$media$IMediaOnlinePlayerService;
    static /* synthetic */ Class class$de$audi$atip$interapp$media$IMediaService;
    static /* synthetic */ Class class$de$audi$atip$interapp$OnlineServiceListener;
    static /* synthetic */ Class class$de$audi$atip$interapp$OnlineHMIService;
    static /* synthetic */ Class class$de$audi$atip$interapp$PortalAuthenticationService;
    static /* synthetic */ Class class$de$audi$atip$interapp$IConnectivityRHMIStateListener;
    static /* synthetic */ Class class$de$audi$atip$interapp$messaging$IMessagingOnlineService;
    static /* synthetic */ Class class$de$audi$atip$interapp$messaging$folderbrowsing$IFolderBrowsingService;
    static /* synthetic */ Class class$de$audi$atip$phone$ITelServiceConnectivity;
    static /* synthetic */ Class class$de$audi$atip$interapp$eni$ENIServiceOnline;
    static /* synthetic */ Class class$de$audi$atip$interapp$online$MobileKeyStatusDisplayService;
    static /* synthetic */ Class class$de$audi$atip$interapp$FactResetService;
    static /* synthetic */ Class class$de$audi$atip$power$PowerEventListener;
    static /* synthetic */ Class class$de$audi$atip$interapp$ADBHMIAppServiceListener;
    static /* synthetic */ Class class$de$audi$atip$interapp$eni$ENIServiceOnlineListener;
    static /* synthetic */ Class class$de$audi$atip$hmi$HMIApplication;
    static /* synthetic */ Class class$de$audi$atip$interapp$online$IOnlineDataStateListener;
    static /* synthetic */ Class class$de$audi$atip$onlinelogo$IOnlineLogoProvider;
    static /* synthetic */ Class class$de$audi$atip$msg$MsgListener;
    static /* synthetic */ Class class$org$dsi$ifc$base$DSIListener;
    static /* synthetic */ Class class$org$dsi$ifc$online$DSIOnlineServiceRegistrationListener;
    static /* synthetic */ Class class$de$audi$atip$i18n$I18NTarget;
    static /* synthetic */ Class class$de$audi$atip$interapp$online$IOnlineDestinationService;
    static /* synthetic */ Class class$org$dsi$ifc$online$DSIDestinationImportListener;
    static /* synthetic */ Class class$org$dsi$ifc$online$DSIOperatorCallListener;
    static /* synthetic */ Class class$de$audi$atip$interapp$online$IOnlineSDSMyAudiService;
    static /* synthetic */ Class class$de$audi$atip$interapp$terminalmode$ITerminalModeUpdateListener;
    static /* synthetic */ Class class$de$audi$atip$interapp$online$IOnlineService;

    protected static final Hashtable createServiceProperties() {
        Hashtable hashtable = new Hashtable();
        hashtable.put("ApplicationName", "AppOnline");
        hashtable.put("moduleID", new Integer(Online.getInstance().getId()));
        return hashtable;
    }

    public void start(BundleContext bundleContext) {
        super.start(bundleContext);
        Online.getInstance().initialize(this.framework);
        Online.getInstance().setOnlineDiag(this.getOnlineDiag());
        this.logChannel = Online.getInstance().getLogChannel();
        this.readPrivacyModeFeatureCoding();
        this.textConstants = this.createTextConstants();
        this.smEventConstants = this.createSmEventConstantsMapper();
        this.onlineEnv = new OnlineEnv(this.framework, this.getTextConstantsMapper(), this.getSMEventConstantsMapper());
        this.jokerKeyHandler = new JokerKeyHandler(this.framework, this);
        this.modelBank = new OnlineModelBankAccess(this.framework.getHMIService());
        this.createI18NHandler();
        this.useRemoteHmi = Online.getInstance().isRemoteHMICoded();
        this.useEni = Online.getInstance().isEniCoded();
    }

    private void createI18NHandler() {
        this.i18nHandler = new OnlineI18NHandler(this.getI18NTextFields(), this.logChannel, this.framework.getHMIService());
        if (this.licenseCollectionService != null) {
            this.i18nHandler.addLanguageChangedListener(this.licenseCollectionService);
        }
    }

    protected final void initServiceTrackers() {
        this.serviceTrackerOnline = new ServiceTracker(this.bundleContext, REQUIRED_SERVICES, (ServiceTrackerCustomizer)this);
        this.serviceTrackerOnline.open();
    }

    protected final void readPrivacyModeFeatureCodingCore() {
        this.logChannel.log(1000000, "AbstractOnlineActivator#readPrivacyModeFeatureCoding called");
        IStorageAccess iStorageAccess = this.getFramework().getStorageMgr();
        this.logChannel.log(10000000, "AbstractOnlineActivator#readPrivacyModeFeatureCoding: storage: %1, log: %2.", (Object)iStorageAccess, (Object)this.logChannel);
        this.privacyFeatureStorageAccess = new PrivacyFeatureStorageAccess(iStorageAccess, this.logChannel);
        this.privacyModeFeatureAvailable = this.privacyFeatureStorageAccess.isPrivacyFeatureAvailable();
        this.logChannel.log(1000000, "AbstractOnlineActivator#readPrivacyModeFeatureCoding privacy feature: %1", this.privacyModeFeatureAvailable);
    }

    protected final void registerPowerManagerListener() {
        if (this.standardController != null && this.standardController.getPowerManagerListener() != null) {
            this.registerService((class$de$audi$atip$power$PowerEventListener == null ? (class$de$audi$atip$power$PowerEventListener = AbstractOnlineActivator.class$("de.audi.atip.power.PowerEventListener")) : class$de$audi$atip$power$PowerEventListener).getName(), this.standardController.getPowerManagerListener(), (Dictionary)AbstractOnlineActivator.createServiceProperties());
        }
    }

    public final void stop(BundleContext bundleContext) {
        super.stop(bundleContext);
        this.closeTracker(this.serviceTrackerOnline);
        this.logChannel.log(10000000, "AbstractOnlineActivator#stop() - AppOnline Bundle stopped");
    }

    public final void modifiedService(ServiceReference serviceReference, Object object) {
    }

    public final Object addingService(ServiceReference serviceReference) {
        Object object = this.bundleContext.getService(serviceReference);
        Object object2 = serviceReference.getProperty("DEVICE_NAME");
        Object object3 = serviceReference.getProperty("DEVICE_INSTANCE");
        this.logChannel.log(10000000, "AbstractOnlineHighActivator#addingService() - service: %3, deviceName: %1, deviceInstance: %2", object2, object3, object);
        boolean bl = false;
        if (object instanceof IPreviewMap) {
            if (this.previewMap != null) {
                this.logChannel.log(100000, "AbstractOnlineActivator#addingService replacing service %1 with %2", (Object)this.previewMap, object);
            }
            this.setPreviewMap((IPreviewMap)object);
            bl = true;
        }
        if (object instanceof IMediaDrawerContext) {
            if (this.mediaDrawerContext != null) {
                this.logChannel.log(100000, "AbstractOnlineActivator#addingService replacing service %1 with %2", (Object)this.mediaDrawerContext, object);
            }
            this.setMediaDrawerContext((IMediaDrawerContext)object);
            bl = true;
        }
        if (object instanceof IOperatorCallNaviService) {
            if (this.operatorCallNaviService != null) {
                this.logChannel.log(100000, "AbstractOnlineActivator#addingService replacing service %1 with %2", (Object)this.operatorCallNaviService, object);
            }
            this.setOperatorCallNaviService((IOperatorCallNaviService)object);
            bl = true;
        }
        if (object instanceof IOperatorCallSDSService) {
            if (this.operatorCallSDSService != null) {
                this.logChannel.log(100000, "AbstractOnlineActivator#addingService replacing service %1 with %2", (Object)this.operatorCallSDSService, object);
            }
            this.setOperatorCallSDSService((IOperatorCallSDSService)object);
            bl = true;
        }
        if (object instanceof SwDiagnosisManager) {
            if (this.diagnosisManager != null) {
                this.logChannel.log(100000, "AbstractOnlineActivator#addingService replacing service %1 with %2", (Object)this.diagnosisManager, object);
            }
            this.setSwDiagnosisManager((SwDiagnosisManager)object);
            bl = true;
        }
        if (object instanceof DSIOnlineServiceRegistration) {
            if (this.dsiOnlineServiceRegistration != null) {
                this.logChannel.log(100000, "AbstractOnlineActivator#addingService replacing service %1 with %2", (Object)this.dsiOnlineServiceRegistration, object);
            }
            this.setDsiOnlineServiceRegistration((DSIOnlineServiceRegistration)object);
            bl = true;
        }
        if (object instanceof SDSService) {
            if (this.sdsService != null) {
                this.logChannel.log(100000, "AbstractOnlineActivator#addingService replacing service %1 with %2", (Object)this.sdsService, object);
            }
            this.setSdsService(this.sdsService);
            bl = true;
        }
        if (object instanceof NaviADBService) {
            if (this.naviAdbService != null) {
                this.logChannel.log(100000, "AbstractOnlineActivator#addingService replacing service %1 with %2", (Object)this.naviAdbService, object);
            }
            this.setNaviAdbService((NaviADBService)object);
            bl = true;
        }
        if (object instanceof NaviService) {
            if (this.naviService != null) {
                this.logChannel.log(100000, "AbstractOnlineActivator#addingService replacing service %1 with %2", (Object)this.naviService, object);
            }
            this.setNaviService((NaviService)object);
            bl = true;
        }
        if (object instanceof INaviFormattingService) {
            if (this.naviFormattingService != null) {
                this.logChannel.log(100000, "AbstractOnlineActivator#addingService replacing service %1 with %2", (Object)this.naviFormattingService, object);
            }
            this.setNaviFormattingService((INaviFormattingService)object);
            bl = true;
        }
        if (object instanceof ADBHMIAppService) {
            if (this.adbHmiAppService != null) {
                this.logChannel.log(100000, "AbstractOnlineActivator#addingService replacing service %1 with %2", (Object)this.adbHmiAppService, object);
            }
            this.setAdbHmiAppService((ADBHMIAppService)object);
            bl = true;
        }
        if (object instanceof NaviMyAudiImport) {
            if (this.naviMyAudiImport != null) {
                this.logChannel.log(100000, "AbstractOnlineActivator#addingService replacing service %1 with %2", (Object)this.naviMyAudiImport, object);
            }
            this.setNaviMyAudiImport((NaviMyAudiImport)object);
            bl = true;
        }
        if (object instanceof ITelService) {
            if (this.telService != null) {
                this.logChannel.log(100000, "AbstractOnlineActivator#addingService replacing service %1 with %2", (Object)this.telService, object);
            }
            this.setTelService((ITelService)object);
            bl = true;
        }
        if (object instanceof IRemoteHMIMediaOnlineServiceListener) {
            if (this.remoteHMIMediaOnlineServiceListener != null) {
                this.logChannel.log(100000, "AbstractOnlineActivator#addingService replacing service %1 with %2", (Object)this.remoteHMIMediaOnlineServiceListener, object);
            }
            this.setRemoteHMIMediaOnlineServiceListener((IRemoteHMIMediaOnlineServiceListener)object);
            bl = true;
        }
        if (object instanceof IRemoteHMIEsimLicenseListener) {
            if (this.remoteHMIEsimLicenseListener != null) {
                this.logChannel.log(100000, "AbstractOnlineActivator#addingService replacing service %1 with %2", (Object)this.remoteHMIEsimLicenseListener, object);
            }
            this.setRemoteHMIEsimLicenseListener((IRemoteHMIEsimLicenseListener)object);
            bl = true;
        }
        if (object instanceof IOnlineSDSMyAudiServiceListener) {
            if (this.onlineSdsMyAudiServiceListener != null) {
                this.logChannel.log(100000, "AbstractOnlineActivator#addingService replacing service %1 with %2", (Object)this.onlineSdsMyAudiServiceListener, object);
            }
            this.setOnlineSDSMyAudiServiceListener((IOnlineSDSMyAudiServiceListener)object);
            bl = true;
        }
        if (object instanceof DSIDestinationImport) {
            if (this.dsiDestinationImport != null) {
                this.logChannel.log(100000, "AbstractOnlineActivator#addingService replacing service %1 with %2", (Object)this.dsiDestinationImport, object);
            }
            this.setDsiDestinationImport((DSIDestinationImport)object);
            bl = true;
        }
        if (object instanceof DSIOperatorCall) {
            if (this.dsiOperatorCall != null) {
                this.logChannel.log(100000, "AbstractOnlineActivator#addingService replacing service %1 with %2", (Object)this.dsiOperatorCall, object);
            }
            this.setDsiOperatorCall((DSIOperatorCall)object);
            bl = true;
        }
        if (object instanceof IConnectivityOnlineStateListener) {
            if (this.connectivityOnlineStateListener != null) {
                this.logChannel.log(100000, "AbstractOnlineActivator#addingService replacing service %1 with %2", (Object)this.connectivityOnlineStateListener, object);
            }
            this.setConnectivityOnlineStateListener((IConnectivityOnlineStateListener)object);
            bl = true;
        }
        if (object instanceof OnlinePOICall) {
            if (this.onlinePOICall != null) {
                this.logChannel.log(100000, "AbstractOnlineActivator#addingService replacing service %1 with %2", (Object)this.onlinePOICall, object);
            }
            this.setOnlinePOICall((OnlinePOICall)object);
            bl = true;
        }
        if (object instanceof IBrowserHandler) {
            bl = this.addBrowserHandler((IBrowserHandler)object, object3);
        }
        if (object instanceof IRemoteHMI) {
            if (this.remoteHmi != null) {
                this.logChannel.log(100000, "AbstractOnlineActivator#addingService replacing service %1 with %2", (Object)this.remoteHmi, object);
            }
            this.setRemoteHmi((IRemoteHMI)object);
            bl = true;
        }
        if (object instanceof TTSService) {
            if (this.ttsService != null) {
                this.logChannel.log(100000, "AbstractOnlineActivator#addingService replacing service %1 with %2", (Object)this.ttsService, object);
            }
            bl = this.addTTSService((TTSService)object, serviceReference);
        }
        if (object instanceof MapService) {
            if (this.mapService != null) {
                this.logChannel.log(100000, "AbstractOnlineActivator#addingService replacing service %1 with %2", (Object)this.mapService, object);
            }
            this.setMapService((MapService)object);
            bl = true;
        }
        if (object instanceof IMediaOnlinePlayerService) {
            if (this.mediaOnlinePlayerService != null) {
                this.logChannel.log(100000, "AbstractOnlineActivator#addingService replacing service %1 with %2", (Object)this.mediaOnlinePlayerService, object);
            }
            this.setMediaOnlinePlayerService((IMediaOnlinePlayerService)object);
            bl = true;
        }
        if (object instanceof IMediaService) {
            if (this.mediaService != null) {
                this.logChannel.log(100000, "AbstractOnlineActivator#addingService replacing service %1 with %2", (Object)this.mediaService, object);
            }
            this.setMediaService((IMediaService)object);
            bl = true;
        }
        if (object instanceof OnlineServiceListener) {
            if (this.onlineServiceListener != null) {
                this.logChannel.log(100000, "AbstractOnlineActivator#addingService replacing service %1 with %2", (Object)this.onlineServiceListener, object);
            }
            this.setOnlineServiceListener((OnlineServiceListener)object);
            bl = true;
        }
        if (object instanceof OnlineHMIService) {
            if (this.onlineHMIService != null) {
                this.logChannel.log(100000, "AbstractOnlineActivator#addingService replacing service %1 with %2", (Object)this.onlineHMIService, object);
            }
            this.setOnlineHMIService((OnlineHMIService)object);
            bl = true;
        }
        if (object instanceof PortalAuthenticationService) {
            if (this.portalAuthenticationService != null) {
                this.logChannel.log(100000, "AbstractOnlineActivator#addingService replacing service %1 with %2", (Object)this.portalAuthenticationService, object);
            }
            this.setPortalAuthenticationService((PortalAuthenticationService)object);
            bl = true;
        }
        if (object instanceof IConnectivityRHMIStateListener) {
            if (this.connectivityRHMIStateListener != null) {
                this.logChannel.log(100000, "AbstractOnlineActivator#addingService replacing service %1 with %2", (Object)this.connectivityRHMIStateListener, object);
            }
            this.setConnectivityRHMIStateListener((IConnectivityRHMIStateListener)object);
            bl = true;
        }
        if (object instanceof IMessagingOnlineService) {
            if (this.messagingOnlineService != null) {
                this.logChannel.log(100000, "AbstractOnlineActivator#addingService replacing service %1 with %2", (Object)this.messagingOnlineService, object);
            }
            this.setMessagingOnlineService((IMessagingOnlineService)object);
            bl = true;
        }
        if (object instanceof IFolderBrowsingService) {
            if (this.folderBrowsingService != null) {
                this.logChannel.log(100000, "AbstractOnlineActivator#addingService replacing service %1 with %2", (Object)this.folderBrowsingService, object);
            }
            this.setFolderBrowsingService((IFolderBrowsingService)object);
            bl = true;
        }
        if (object instanceof ITelServiceConnectivity) {
            if (this.telServiceConnectivity != null) {
                this.logChannel.log(100000, "AbstractOnlineActivator#addingService replacing service %1 with %2", (Object)this.telServiceConnectivity, object);
            }
            this.setTelServiceConnectivity((ITelServiceConnectivity)object);
            bl = true;
        }
        if (object instanceof ENIServiceOnline) {
            if (this.eniServiceOnline != null) {
                this.logChannel.log(100000, "AbstractOnlineActivator#addingService replacing service %1 with %2", (Object)this.eniServiceOnline, object);
            }
            this.setEniServiceOnline((ENIServiceOnline)object);
            bl = true;
        }
        if (object instanceof MobileKeyStatusDisplayService) {
            if (this.mobileKeyStatusDisplayService != null) {
                this.logChannel.log(100000, "AbstractOnlineActivator#addingService replacing service %1 with %2", (Object)this.mobileKeyStatusDisplayService, object);
            }
            this.setMobileKeyStatusDisplayService((MobileKeyStatusDisplayService)object);
            bl = true;
        }
        if (object instanceof FactResetService) {
            if (this.factoryResetService != null) {
                this.logChannel.log(100000, "AbstractOnlineActivator#addingService replacing service %1 with %2", (Object)this.factoryResetService, object);
            }
            this.setFactResetService((FactResetService)object);
            bl = true;
        }
        if (!bl) {
            this.logChannel.log(100000, "AbstractOnlineHighActivator#addingService() - track unwanted service=%1", object);
            this.getBundleContext().ungetService(serviceReference);
            return null;
        }
        return object;
    }

    public final void removedService(ServiceReference serviceReference, Object object) {
        this.logChannel.log(10000000, "AbstractOnlineActivator#removedService() - service=%1", object);
        boolean bl = false;
        if (object instanceof IPreviewMap) {
            if (!object.equals(this.previewMap)) {
                this.logChannel.log(100000, "AbstractOnlineActivator#removedService service: %1, used: %2", object, (Object)this.previewMap);
            }
            this.setPreviewMap(null);
            bl = true;
        }
        if (object instanceof IMediaDrawerContext) {
            if (!object.equals(this.mediaDrawerContext)) {
                this.logChannel.log(100000, "AbstractOnlineActivator#removedService service: %1, used: %2", object, (Object)this.mediaDrawerContext);
            }
            this.setMediaDrawerContext(null);
            bl = true;
        }
        if (object instanceof IOperatorCallNaviService) {
            if (!object.equals(this.operatorCallNaviService)) {
                this.logChannel.log(100000, "AbstractOnlineActivator#removedService service: %1, used: %2", object, (Object)this.operatorCallNaviService);
            }
            this.setOperatorCallNaviService(null);
            bl = true;
        }
        if (object instanceof IOperatorCallSDSService) {
            if (!object.equals(this.operatorCallSDSService)) {
                this.logChannel.log(100000, "AbstractOnlineActivator#removedService service: %1, used: %2", object, (Object)this.operatorCallSDSService);
            }
            this.setOperatorCallSDSService(null);
            bl = true;
        }
        if (object instanceof SwDiagnosisManager) {
            if (!object.equals(this.diagnosisManager)) {
                this.logChannel.log(100000, "AbstractOnlineActivator#removedService service: %1, used: %2", object, (Object)this.diagnosisManager);
            }
            this.setSwDiagnosisManager(null);
            bl = true;
        }
        if (object instanceof DSIOnlineServiceRegistration) {
            if (!object.equals(this.dsiOnlineServiceRegistration)) {
                this.logChannel.log(100000, "AbstractOnlineActivator#removedService service: %1, used: %2", object, (Object)this.dsiOnlineServiceRegistration);
            }
            this.setDsiOnlineServiceRegistration(null);
            bl = true;
        }
        if (object instanceof SDSService) {
            if (!object.equals(this.sdsService)) {
                this.logChannel.log(100000, "AbstractOnlineActivator#removedService service: %1, used: %2", object, (Object)this.sdsService);
            }
            this.setSdsService(null);
            bl = true;
        }
        if (object instanceof NaviADBService) {
            if (!object.equals(this.naviAdbService)) {
                this.logChannel.log(100000, "AbstractOnlineActivator#removedService service: %1, used: %2", object, (Object)this.naviAdbService);
            }
            this.setNaviAdbService(null);
            bl = true;
        }
        if (object instanceof NaviService) {
            if (!object.equals(this.naviService)) {
                this.logChannel.log(100000, "AbstractOnlineActivator#removedService service: %1, used: %2", object, (Object)this.naviService);
            }
            this.setNaviService(null);
            bl = true;
        }
        if (object instanceof INaviFormattingService) {
            if (!object.equals(this.naviFormattingService)) {
                this.logChannel.log(100000, "AbstractOnlineActivator#removedService service: %1, used: %2", object, (Object)this.naviFormattingService);
            }
            this.setNaviFormattingService(null);
            bl = true;
        }
        if (object instanceof ADBHMIAppService) {
            if (!object.equals(this.adbHmiAppService)) {
                this.logChannel.log(100000, "AbstractOnlineActivator#removedService service: %1, used: %2", object, (Object)this.adbHmiAppService);
            }
            this.setAdbHmiAppService(null);
            bl = true;
        }
        if (object instanceof NaviMyAudiImport) {
            if (!object.equals(this.naviMyAudiImport)) {
                this.logChannel.log(100000, "AbstractOnlineActivator#removedService service: %1, used: %2", object, (Object)this.naviMyAudiImport);
            }
            this.setNaviMyAudiImport(null);
            bl = true;
        }
        if (object instanceof ITelService) {
            if (!object.equals(this.telService)) {
                this.logChannel.log(100000, "AbstractOnlineActivator#removedService service: %1, used: %2", object, (Object)this.telService);
            }
            this.setTelService(null);
            bl = true;
        }
        if (object instanceof IRemoteHMIMediaOnlineServiceListener) {
            if (!object.equals(this.remoteHMIMediaOnlineServiceListener)) {
                this.logChannel.log(100000, "AbstractOnlineActivator#removedService service: %1, used: %2", object, (Object)this.remoteHMIMediaOnlineServiceListener);
            }
            this.setRemoteHMIMediaOnlineServiceListener(null);
            bl = true;
        }
        if (object instanceof IRemoteHMIEsimLicenseListener) {
            if (!object.equals(this.remoteHMIEsimLicenseListener)) {
                this.logChannel.log(100000, "AbstractOnlineActivator#removedService service: %1, used: %2", object, (Object)this.remoteHMIEsimLicenseListener);
            }
            this.setRemoteHMIEsimLicenseListener(null);
            bl = true;
        }
        if (object instanceof IOnlineSDSMyAudiServiceListener) {
            if (!object.equals(this.onlineSdsMyAudiServiceListener)) {
                this.logChannel.log(100000, "AbstractOnlineActivator#removedService service: %1, used: %2", object, (Object)this.onlineSdsMyAudiServiceListener);
            }
            this.setOnlineSDSMyAudiServiceListener(null);
            bl = true;
        }
        if (object instanceof DSIDestinationImport) {
            if (!object.equals(this.dsiDestinationImport)) {
                this.logChannel.log(100000, "AbstractOnlineActivator#removedService service: %1, used: %2", object, (Object)this.dsiDestinationImport);
            }
            this.setDsiDestinationImport(null);
            bl = true;
        }
        if (object instanceof DSIOperatorCall) {
            if (!object.equals(this.dsiOperatorCall)) {
                this.logChannel.log(100000, "AbstractOnlineActivator#removedService service: %1, used: %2", object, (Object)this.dsiOperatorCall);
            }
            this.setDsiOperatorCall(null);
            bl = true;
        }
        if (object instanceof IConnectivityOnlineStateListener) {
            if (!object.equals(this.connectivityOnlineStateListener)) {
                this.logChannel.log(100000, "AbstractOnlineActivator#removedService service: %1, used: %2", object, (Object)this.connectivityOnlineStateListener);
            }
            this.setConnectivityOnlineStateListener(null);
            bl = true;
        }
        if (object instanceof OnlinePOICall) {
            if (!object.equals(this.onlinePOICall)) {
                this.logChannel.log(100000, "AbstractOnlineActivator#removedService service: %1, used: %2", object, (Object)this.onlinePOICall);
            }
            this.setOnlinePOICall(null);
            bl = true;
        }
        if (object instanceof IBrowserHandler) {
            this.removeBrowserHandler((IBrowserHandler)object);
            bl = true;
        }
        if (object instanceof TTSService) {
            if (!object.equals(this.ttsService)) {
                this.logChannel.log(100000, "AbstractOnlineActivator#removedService service: %1, used: %2", object, (Object)this.ttsService);
            }
            this.removeTTSService();
            bl = true;
        }
        if (object instanceof MapService) {
            if (!object.equals(this.mapService)) {
                this.logChannel.log(100000, "AbstractOnlineActivator#removedService service: %1, used: %2", object, (Object)this.mapService);
            }
            this.setMapService(null);
            bl = true;
        }
        if (object instanceof IMediaOnlinePlayerService) {
            if (!object.equals(this.mediaOnlinePlayerService)) {
                this.logChannel.log(100000, "AbstractOnlineActivator#removedService service: %1, used: %2", object, (Object)this.mediaOnlinePlayerService);
            }
            this.setMediaOnlinePlayerService(null);
            bl = true;
        }
        if (object instanceof IMediaService) {
            if (!object.equals(this.mediaService)) {
                this.logChannel.log(100000, "AbstractOnlineActivator#removedService service: %1, used: %2", object, (Object)this.mediaService);
            }
            this.setMediaService(null);
            bl = true;
        }
        if (object instanceof OnlineServiceListener) {
            if (!object.equals(this.onlineServiceListener)) {
                this.logChannel.log(100000, "AbstractOnlineActivator#removedService service: %1, used: %2", object, (Object)this.onlineServiceListener);
            }
            this.setOnlineServiceListener(null);
            bl = true;
        }
        if (object instanceof OnlineHMIService) {
            if (!object.equals(this.onlineHMIService)) {
                this.logChannel.log(100000, "AbstractOnlineActivator#removedService service: %1, used: %2", object, (Object)this.onlineHMIService);
            }
            this.setOnlineHMIService(null);
            bl = true;
        }
        if (object instanceof PortalAuthenticationService) {
            if (!object.equals(this.portalAuthenticationService)) {
                this.logChannel.log(100000, "AbstractOnlineActivator#removedService service: %1, used: %2", object, (Object)this.portalAuthenticationService);
            }
            this.setPortalAuthenticationService(null);
            bl = true;
        }
        if (object instanceof IConnectivityRHMIStateListener) {
            if (!object.equals(this.connectivityRHMIStateListener)) {
                this.logChannel.log(100000, "AbstractOnlineActivator#removedService service: %1, used: %2", object, (Object)this.connectivityRHMIStateListener);
            }
            this.setConnectivityRHMIStateListener(null);
            bl = true;
        }
        if (object instanceof IMessagingOnlineService) {
            if (!object.equals(this.messagingOnlineService)) {
                this.logChannel.log(100000, "AbstractOnlineActivator#removedService service: %1, used: %2", object, (Object)this.messagingOnlineService);
            }
            this.setMessagingOnlineService(null);
            bl = true;
        }
        if (object instanceof IFolderBrowsingService) {
            if (!object.equals(this.folderBrowsingService)) {
                this.logChannel.log(100000, "AbstractOnlineActivator#removedService service: %1, used: %2", object, (Object)this.folderBrowsingService);
            }
            this.setFolderBrowsingService(null);
            bl = true;
        }
        if (object instanceof ITelServiceConnectivity) {
            if (!object.equals(this.telServiceConnectivity)) {
                this.logChannel.log(100000, "AbstractOnlineActivator#removedService service: %1, used: %2", object, (Object)this.telServiceConnectivity);
            }
            this.setTelServiceConnectivity(null);
            bl = true;
        }
        if (object instanceof ENIServiceOnline) {
            if (!object.equals(this.eniServiceOnline)) {
                this.logChannel.log(100000, "AbstractOnlineActivator#removedService service: %1, used: %2", object, (Object)this.eniServiceOnline);
            }
            this.setEniServiceOnline(null);
            bl = true;
        }
        if (object instanceof MobileKeyStatusDisplayService) {
            if (!object.equals(this.mobileKeyStatusDisplayService)) {
                this.logChannel.log(100000, "AbstractOnlineActivator#removedService service: %1, used: %2", object, (Object)this.mobileKeyStatusDisplayService);
            }
            this.setMobileKeyStatusDisplayService(null);
            bl = true;
        }
        if (object instanceof FactResetService) {
            if (!object.equals(this.factoryResetService)) {
                this.logChannel.log(100000, "AbstractOnlineActivator#removedService service: %1, used: %2", object, (Object)this.factoryResetService);
            }
            this.setFactResetService(null);
            bl = true;
        }
        if (bl) {
            this.getBundleContext().ungetService(serviceReference);
        }
    }

    public OnlineDestinationController getOnlineDestinationHandler() {
        return this.onlineDestHandler;
    }

    public final AbstractOperatorCallMain getOperatorCallHandler() {
        return this.operatorCallController;
    }

    protected final void registerAdbListener() {
        if (this.onlineDestHandler != null) {
            this.registerService((class$de$audi$atip$interapp$ADBHMIAppServiceListener == null ? (class$de$audi$atip$interapp$ADBHMIAppServiceListener = AbstractOnlineActivator.class$("de.audi.atip.interapp.ADBHMIAppServiceListener")) : class$de$audi$atip$interapp$ADBHMIAppServiceListener).getName(), (Object)this.onlineDestHandler, (Dictionary)AbstractOnlineActivator.createServiceProperties());
        }
    }

    protected final void registerENIListener() {
        if (this.standardController != null) {
            this.registerService((class$de$audi$atip$interapp$eni$ENIServiceOnlineListener == null ? (class$de$audi$atip$interapp$eni$ENIServiceOnlineListener = AbstractOnlineActivator.class$("de.audi.atip.interapp.eni.ENIServiceOnlineListener")) : class$de$audi$atip$interapp$eni$ENIServiceOnlineListener).getName(), (Object)this.standardController.getEniServiceListener(), (Dictionary)AbstractOnlineActivator.createServiceProperties());
        }
    }

    public final void startOperatorCallByJokerKey(int n, int n2, int n3, int n4) {
        if (this.operatorCallController != null) {
            this.operatorCallController.startOperatorCallByJokerKey(n, n2, n3, n4);
        }
    }

    protected void registerOnlineServices() {
        this.logChannel.log(10000000, "AbstractOnlineActivator#registerOnlineServices: - register online service");
        this.registerService((class$de$audi$atip$hmi$HMIApplication == null ? (class$de$audi$atip$hmi$HMIApplication = AbstractOnlineActivator.class$("de.audi.atip.hmi.HMIApplication")) : class$de$audi$atip$hmi$HMIApplication).getName(), (Object)Online.getInstance(), (Dictionary)AbstractOnlineActivator.createServiceProperties());
    }

    protected void registerOnlineRoamingService() {
        if (this.onlineServiceRegistrationSubsystem != null && this.onlineServiceRegistrationSubsystem.getContainer() != null) {
            this.registerService((class$de$audi$atip$interapp$online$IOnlineDataStateListener == null ? (class$de$audi$atip$interapp$online$IOnlineDataStateListener = AbstractOnlineActivator.class$("de.audi.atip.interapp.online.IOnlineDataStateListener")) : class$de$audi$atip$interapp$online$IOnlineDataStateListener).getName(), (Object)this.onlineServiceRegistrationSubsystem.getContainer(), (Dictionary)AbstractOnlineActivator.createServiceProperties());
        }
    }

    protected void registerLogoProviderService() {
        this.registerService((class$de$audi$atip$onlinelogo$IOnlineLogoProvider == null ? (class$de$audi$atip$onlinelogo$IOnlineLogoProvider = AbstractOnlineActivator.class$("de.audi.atip.onlinelogo.IOnlineLogoProvider")) : class$de$audi$atip$onlinelogo$IOnlineLogoProvider).getName(), (Object)this.logoProviderService, (Dictionary)AbstractOnlineActivator.createServiceProperties());
    }

    protected void registerMsgListener() {
        this.registerService((class$de$audi$atip$msg$MsgListener == null ? (class$de$audi$atip$msg$MsgListener = AbstractOnlineActivator.class$("de.audi.atip.msg.MsgListener")) : class$de$audi$atip$msg$MsgListener).getName(), (Object)this.onlineServiceRegistrationSubsystem, (Dictionary)AbstractOnlineActivator.createServiceProperties());
        if (this.operatorCallController != null) {
            this.registerService((class$de$audi$atip$msg$MsgListener == null ? (class$de$audi$atip$msg$MsgListener = AbstractOnlineActivator.class$("de.audi.atip.msg.MsgListener")) : class$de$audi$atip$msg$MsgListener).getName(), (Object)this.operatorCallController.getFactorySettingsController(), (Dictionary)AbstractOnlineActivator.createServiceProperties());
        }
    }

    public IIDMapper getTextConstantsMapper() {
        return this.textConstants;
    }

    protected OnlineI18NHandler getTextConstantsConverter() {
        return this.i18nHandler;
    }

    public IIDMapper getSMEventConstantsMapper() {
        return this.smEventConstants;
    }

    protected PrivacyFeatureStorageAccess getPrivacyFeatureStorageAccess() {
        return this.privacyFeatureStorageAccess;
    }

    public OnlineEnv getOnlineEnvironment() {
        return this.onlineEnv;
    }

    protected boolean isBreakdownCallCoded() {
        return this.framework.getSysConst(4155) == 1 || Boolean.getBoolean("BreakdownEnabled");
    }

    protected boolean isPoiCallCoded() {
        return this.framework.getSysConst(4154) == 1 || Boolean.getBoolean("PoiCallEnabled");
    }

    protected boolean isConciergeCallCoded() {
        return this.framework.getSysConst(4153) == 1 || Boolean.getBoolean("ConciergeEnabled");
    }

    protected boolean isOperatorCallCoded() {
        return this.isBreakdownCallCoded() || this.isPoiCallCoded() || this.isConciergeCallCoded();
    }

    protected void setButtonModelStatus() {
        this.framework.getHmiServiceApp().getButtonModel(205).setStatus(0);
    }

    private void setPreviewMap(IPreviewMap iPreviewMap) {
        this.previewMap = iPreviewMap;
        if (this.remoteHmiActivator != null) {
            this.remoteHmiActivator.setPreviewMap(iPreviewMap);
        }
        if (this.operatorCallController != null) {
            this.operatorCallController.setPreviewMapService(iPreviewMap);
        }
    }

    private void setMediaDrawerContext(IMediaDrawerContext iMediaDrawerContext) {
        this.mediaDrawerContext = iMediaDrawerContext;
        if (this.remoteHmiActivator != null) {
            this.remoteHmiActivator.setMediaDrawerContext(iMediaDrawerContext);
        }
    }

    private void setOperatorCallNaviService(IOperatorCallNaviService iOperatorCallNaviService) {
        this.operatorCallNaviService = iOperatorCallNaviService;
        if (this.operatorCallController != null) {
            this.operatorCallController.testNaviService(iOperatorCallNaviService);
        }
    }

    private void setOperatorCallSDSService(IOperatorCallSDSService iOperatorCallSDSService) {
        this.operatorCallSDSService = iOperatorCallSDSService;
        if (TestHandler.isSDSSimulation()) {
            this.operatorCallController.testSDS(iOperatorCallSDSService);
        }
    }

    private void setSwDiagnosisManager(SwDiagnosisManager swDiagnosisManager) {
        if (swDiagnosisManager != null) {
            swDiagnosisManager.addDiagGateway((AbstractSwDiagnosis)this.getOnlineDiag());
        } else {
            this.diagnosisManager.removeDiagGateway((AbstractSwDiagnosis)Online.getInstance().getOnlineDiag());
        }
        this.diagnosisManager = swDiagnosisManager;
    }

    private void setDsiOnlineServiceRegistration(DSIOnlineServiceRegistration dSIOnlineServiceRegistration) {
        this.dsiOnlineServiceRegistration = dSIOnlineServiceRegistration;
        if (dSIOnlineServiceRegistration != null) {
            dSIOnlineServiceRegistration.setInventoryFinished(true);
            if (this.serviceRegistrationListener != null) {
                dSIOnlineServiceRegistration.setNotification(6, (DSIListener)this.serviceRegistrationListener);
            }
        }
        if (this.onlineServiceRegistrationSubsystem != null) {
            this.onlineServiceRegistrationSubsystem.setDsi(dSIOnlineServiceRegistration);
        }
        this.setDsiOnlineServiceRegistrationVariant(this.dsiOnlineServiceRegistration);
    }

    private void setSdsService(SDSService sDSService) {
        this.sdsService = sDSService;
        if (this.remoteHmiActivator != null) {
            this.remoteHmiActivator.setSdsService(sDSService);
        }
    }

    private void setNaviAdbService(NaviADBService naviADBService) {
        this.naviAdbService = naviADBService;
        if (this.onlineDestHandler != null) {
            this.onlineDestHandler.setNaviADBService(naviADBService);
        }
        if (this.remoteHmiActivator != null) {
            this.remoteHmiActivator.setNaviAdbService(naviADBService);
        }
    }

    private void setNaviService(NaviService naviService) {
        this.naviService = naviService;
        if (this.onlineDestHandler != null) {
            this.onlineDestHandler.setNaviService(naviService);
        }
        if (this.remoteHmiActivator != null) {
            this.remoteHmiActivator.setNaviService(naviService);
        }
        if (this.operatorCallController != null) {
            this.operatorCallController.setNaviService(naviService);
        }
    }

    private void setNaviFormattingService(INaviFormattingService iNaviFormattingService) {
        this.naviFormattingService = iNaviFormattingService;
        if (this.remoteHmiActivator != null) {
            this.remoteHmiActivator.setNaviFormattingService(iNaviFormattingService);
        }
        if (this.operatorCallController != null) {
            this.operatorCallController.setNaviFormattingService(iNaviFormattingService);
        }
    }

    private void setAdbHmiAppService(ADBHMIAppService aDBHMIAppService) {
        this.adbHmiAppService = aDBHMIAppService;
        if (this.onlineDestHandler != null) {
            this.onlineDestHandler.setAdbService(aDBHMIAppService);
        }
    }

    private void setNaviMyAudiImport(NaviMyAudiImport naviMyAudiImport) {
        this.naviMyAudiImport = naviMyAudiImport;
        if (this.onlineDestHandler != null) {
            this.onlineDestHandler.setNaviMyAduiService(naviMyAudiImport);
        }
    }

    private void setTelService(ITelService iTelService) {
        this.telService = iTelService;
        if (this.onlineDestHandler != null) {
            this.onlineDestHandler.setTelephoneService(iTelService);
        }
        if (this.remoteHmiActivator != null) {
            this.remoteHmiActivator.setTelService(iTelService);
        }
        if (this.operatorCallController != null) {
            this.operatorCallController.setTelService(iTelService);
        }
    }

    private void setRemoteHMIMediaOnlineServiceListener(IRemoteHMIMediaOnlineServiceListener iRemoteHMIMediaOnlineServiceListener) {
        this.remoteHMIMediaOnlineServiceListener = iRemoteHMIMediaOnlineServiceListener;
        if (this.remoteHmiActivator != null) {
            this.remoteHmiActivator.setRemoteHMIMediaOnlineServiceListener(iRemoteHMIMediaOnlineServiceListener);
        }
    }

    private void setRemoteHMIEsimLicenseListener(IRemoteHMIEsimLicenseListener iRemoteHMIEsimLicenseListener) {
        this.remoteHMIEsimLicenseListener = iRemoteHMIEsimLicenseListener;
        if (this.remoteHmiActivator != null) {
            this.remoteHmiActivator.setRemoteHMIEsimLicenseListener(iRemoteHMIEsimLicenseListener);
        }
    }

    private void setOnlineSDSMyAudiServiceListener(IOnlineSDSMyAudiServiceListener iOnlineSDSMyAudiServiceListener) {
        this.onlineSdsMyAudiServiceListener = iOnlineSDSMyAudiServiceListener;
        if (this.onlineDestHandler != null) {
            this.onlineDestHandler.setSdsServiceListener(iOnlineSDSMyAudiServiceListener);
        }
    }

    private void setDsiDestinationImport(DSIDestinationImport dSIDestinationImport) {
        this.dsiDestinationImport = dSIDestinationImport;
        if (this.onlineDestHandler != null) {
            this.onlineDestHandler.setDsiDestImport(dSIDestinationImport);
        }
    }

    private void setDsiOperatorCall(DSIOperatorCall dSIOperatorCall) {
        this.dsiOperatorCall = dSIOperatorCall;
        if (this.operatorCallController != null) {
            this.operatorCallController.setDSI(dSIOperatorCall);
        }
    }

    private void setConnectivityOnlineStateListener(IConnectivityOnlineStateListener iConnectivityOnlineStateListener) {
        this.connectivityOnlineStateListener = iConnectivityOnlineStateListener;
        if (this.remoteHmiActivator != null) {
            this.remoteHmiActivator.setConnectivityOnlineStateListener(iConnectivityOnlineStateListener);
        }
    }

    private void setOnlinePOICall(OnlinePOICall onlinePOICall) {
        this.onlinePOICall = onlinePOICall;
        if (this.remoteHmiActivator != null) {
            this.remoteHmiActivator.setOnlinePOICall(onlinePOICall);
        }
    }

    private boolean addBrowserHandler(IBrowserHandler iBrowserHandler, Object object) {
        boolean bl = false;
        if (iBrowserHandler != null) {
            if (object instanceof Integer) {
                Integer n = (Integer)object;
                this.browserHandlers.put(iBrowserHandler, object);
                if (this.remoteHmiActivator != null) {
                    this.remoteHmiActivator.setBrowserHandler(iBrowserHandler, n);
                }
                bl = true;
            } else {
                this.logChannel.log(100000, "AbstractOnlineActivator#setBrowserHandler: deviceInstance is no Integer!");
            }
        } else {
            this.logChannel.log(100000, "AbstractOnlineActivator#addBrowserHandler: browserHandler is null!");
        }
        return bl;
    }

    private void removeBrowserHandler(IBrowserHandler iBrowserHandler) {
        if (iBrowserHandler != null && this.browserHandlers.containsKey(iBrowserHandler)) {
            Integer n = (Integer)this.browserHandlers.get(iBrowserHandler);
            this.remoteHmiActivator.setBrowserHandler(null, n);
        }
    }

    private void setRemoteHmi(IRemoteHMI iRemoteHMI) {
        this.remoteHmi = iRemoteHMI;
        if (this.remoteHmiActivator != null) {
            this.remoteHmiActivator.setRemoteHmi(iRemoteHMI);
        }
    }

    private boolean addTTSService(TTSService tTSService, ServiceReference serviceReference) {
        Object object = serviceReference.getProperty("TTS_CLIENT_ID");
        if (TTSService.CLIENT_ID_REMOTE_HMI.equals(object) && tTSService instanceof TTSSessionBasedService) {
            this.ttsService = tTSService;
            if (this.remoteHmiActivator != null) {
                this.remoteHmiActivator.setTtsService((TTSSessionBasedService)tTSService);
            }
            return true;
        }
        return false;
    }

    private void removeTTSService() {
        this.ttsService = null;
        if (this.remoteHmiActivator != null) {
            this.remoteHmiActivator.setTtsService(null);
        }
    }

    private void setMapService(MapService mapService) {
        this.mapService = mapService;
        if (this.remoteHmiActivator != null) {
            this.remoteHmiActivator.setMapService(mapService);
        }
    }

    private void setMediaOnlinePlayerService(IMediaOnlinePlayerService iMediaOnlinePlayerService) {
        this.mediaOnlinePlayerService = iMediaOnlinePlayerService;
        if (this.remoteHmiActivator != null) {
            this.remoteHmiActivator.setOnlineMediaService(iMediaOnlinePlayerService);
        }
    }

    private void setMediaService(IMediaService iMediaService) {
        this.mediaService = iMediaService;
        if (this.remoteHmiActivator != null) {
            this.remoteHmiActivator.setMediaService(iMediaService);
        }
    }

    private void setOnlineServiceListener(OnlineServiceListener onlineServiceListener) {
        this.onlineServiceListener = onlineServiceListener;
        if (this.remoteHmiActivator != null) {
            this.remoteHmiActivator.setSDSOnlineServiceListener(onlineServiceListener);
        }
    }

    private void setOnlineHMIService(OnlineHMIService onlineHMIService) {
        this.onlineHMIService = onlineHMIService;
        if (this.remoteHmiActivator != null) {
            this.remoteHmiActivator.setOnlineHMIService(onlineHMIService);
        }
    }

    private void setPortalAuthenticationService(PortalAuthenticationService portalAuthenticationService) {
        this.portalAuthenticationService = portalAuthenticationService;
        if (this.remoteHmiActivator != null) {
            this.remoteHmiActivator.setPortalAuthenticationService(portalAuthenticationService);
        }
    }

    private void setConnectivityRHMIStateListener(IConnectivityRHMIStateListener iConnectivityRHMIStateListener) {
        this.connectivityRHMIStateListener = iConnectivityRHMIStateListener;
        if (this.remoteHmiActivator != null) {
            this.remoteHmiActivator.setConnectivityStateListener(iConnectivityRHMIStateListener);
        }
    }

    private void setMessagingOnlineService(IMessagingOnlineService iMessagingOnlineService) {
        this.messagingOnlineService = iMessagingOnlineService;
        if (this.remoteHmiActivator != null) {
            this.remoteHmiActivator.setOnlineMessagingService(iMessagingOnlineService);
        }
    }

    private void setFolderBrowsingService(IFolderBrowsingService iFolderBrowsingService) {
        this.folderBrowsingService = iFolderBrowsingService;
        if (this.remoteHmiActivator != null) {
            this.remoteHmiActivator.setFolderBrowsingService(iFolderBrowsingService);
        }
    }

    private void setTelServiceConnectivity(ITelServiceConnectivity iTelServiceConnectivity) {
        this.telServiceConnectivity = iTelServiceConnectivity;
        this.setTelServiceConnectivityVariant(iTelServiceConnectivity);
    }

    private void setEniServiceOnline(ENIServiceOnline eNIServiceOnline) {
        this.eniServiceOnline = eNIServiceOnline;
        if (this.standardController != null) {
            this.standardController.setEniServiceOnline(eNIServiceOnline);
        }
        this.setEniServiceOnlineVariant(eNIServiceOnline);
    }

    private void setMobileKeyStatusDisplayService(MobileKeyStatusDisplayService mobileKeyStatusDisplayService) {
        this.mobileKeyStatusDisplayService = mobileKeyStatusDisplayService;
        this.setMobileKeyStatusDisplayServiceVariant(mobileKeyStatusDisplayService);
    }

    private void setFactResetService(FactResetService factResetService) {
        this.factoryResetService = factResetService;
        this.setFactResetServiceVariant(factResetService);
    }

    protected final void setOnlineServiceRegistrationSubsystem(OnlineServiceRegistrationSubsystem onlineServiceRegistrationSubsystem) {
        if (onlineServiceRegistrationSubsystem == null) {
            return;
        }
        this.onlineServiceRegistrationSubsystem = onlineServiceRegistrationSubsystem;
        if (this.dsiOnlineServiceRegistration != null) {
            onlineServiceRegistrationSubsystem.setDsi(this.dsiOnlineServiceRegistration);
        }
        this.logoProviderService = new OnlineLogoProvider(onlineServiceRegistrationSubsystem);
        if (this.remoteHMIService != null) {
            this.remoteHMIService.setCoreServiceLanguageListener(onlineServiceRegistrationSubsystem);
        }
        if (this.licenseCollectionService != null) {
            onlineServiceRegistrationSubsystem.setLicenseListener(this.licenseCollectionService);
            this.licenseCollectionService.setOnlineServiceRegistration(onlineServiceRegistrationSubsystem);
        }
    }

    protected final OnlineServiceRegistrationSubsystem getOnlineServiceRegistrationSubsystem() {
        return this.onlineServiceRegistrationSubsystem;
    }

    protected void registerOnlineRegistrationService() {
        if (this.onlineServiceRegistrationSubsystem != null && this.onlineServiceRegistrationSubsystem.getDSIListener() != null) {
            this.registerDSIListener((class$org$dsi$ifc$base$DSIListener == null ? (class$org$dsi$ifc$base$DSIListener = AbstractOnlineActivator.class$("org.dsi.ifc.base.DSIListener")) : class$org$dsi$ifc$base$DSIListener).getName(), this.onlineServiceRegistrationSubsystem.getDSIListener(), (class$org$dsi$ifc$online$DSIOnlineServiceRegistrationListener == null ? (class$org$dsi$ifc$online$DSIOnlineServiceRegistrationListener = AbstractOnlineActivator.class$("org.dsi.ifc.online.DSIOnlineServiceRegistrationListener")) : class$org$dsi$ifc$online$DSIOnlineServiceRegistrationListener).getName(), 0);
        }
    }

    protected final void setRemoteHmiService(RemoteHMIService remoteHMIService) {
        if (remoteHMIService == null) {
            return;
        }
        this.remoteHMIService = remoteHMIService;
        if (this.onlineServiceRegistrationSubsystem != null) {
            remoteHMIService.setCoreServiceLanguageListener(this.onlineServiceRegistrationSubsystem);
        }
        if (this.standardController != null) {
            remoteHMIService.getDsiAccess().addDSIListener((RemoteHMIDSIAccess.IRemoteHMIDSIListener)((Object)this.standardController));
            this.standardController.setRemoteHmiService(remoteHMIService);
        }
        if (this.operatorCallController != null) {
            this.operatorCallController.setOnlineServiceProvider(remoteHMIService.getOnlineServiceProvider());
            remoteHMIService.setOperatorCallController(this.operatorCallController);
        }
        if (this.licenseCollectionService != null) {
            remoteHMIService.setLicenseHandler(this.licenseCollectionService);
        }
    }

    protected final RemoteHMIService getRemoteHmiService() {
        return this.remoteHMIService;
    }

    protected final void setOnlinePoiCall(OnlinePOICall onlinePOICall) {
        this.onlinePOICall = onlinePOICall;
    }

    protected final OnlinePOICall getOnlinePOICall() {
        return this.onlinePOICall;
    }

    protected final MobileKeyStatusDisplayService getMobileKeyStatusDisplayService() {
        return this.mobileKeyStatusDisplayService;
    }

    protected final void setStandardController(IStandardController iStandardController) {
        if (iStandardController == null) {
            return;
        }
        this.standardController = iStandardController;
        if (this.remoteHMIService != null) {
            this.remoteHMIService.getDsiAccess().addDSIListener((RemoteHMIDSIAccess.IRemoteHMIDSIListener)((Object)iStandardController));
            iStandardController.setRemoteHmiService(this.remoteHMIService);
        }
        if (this.licenseCollectionService != null) {
            iStandardController.setLicenseCollectionService(this.licenseCollectionService);
        }
        if (this.eniServiceOnline != null) {
            iStandardController.setEniServiceOnline(this.eniServiceOnline);
        }
        if (this.mobileKeyLicenseListener != null) {
            iStandardController.setMobileKeyLicenseListener(this.mobileKeyLicenseListener);
        }
    }

    protected final void setMobileKeyLicenseListener(IMobileKeyLicenseListener iMobileKeyLicenseListener) {
        if (iMobileKeyLicenseListener == null) {
            return;
        }
        this.mobileKeyLicenseListener = iMobileKeyLicenseListener;
        if (this.standardController != null) {
            this.standardController.setMobileKeyLicenseListener(iMobileKeyLicenseListener);
        }
    }

    protected final void setLicenseCollectionService(LicenseCollectionService licenseCollectionService) {
        this.licenseCollectionService = licenseCollectionService;
        if (this.standardController != null) {
            this.standardController.setLicenseCollectionService(licenseCollectionService);
        }
        if (this.i18nHandler != null) {
            this.i18nHandler.addLanguageChangedListener(licenseCollectionService);
        }
        if (this.remoteHMIService != null) {
            this.remoteHMIService.setLicenseHandler(licenseCollectionService);
        }
        if (this.onlineServiceRegistrationSubsystem != null) {
            this.onlineServiceRegistrationSubsystem.setLicenseListener(licenseCollectionService);
            licenseCollectionService.setOnlineServiceRegistration(this.onlineServiceRegistrationSubsystem);
        }
    }

    protected final void setSimpleServiceRegistrationListener(SimpleServiceRegistrationListener simpleServiceRegistrationListener) {
        this.serviceRegistrationListener = simpleServiceRegistrationListener;
    }

    protected final IStandardController getStandardController() {
        return this.standardController;
    }

    protected final void setRemoteHmiActivator(OnlineRemoteHMIActivator onlineRemoteHMIActivator) {
        if (onlineRemoteHMIActivator == null) {
            return;
        }
        this.remoteHmiActivator = onlineRemoteHMIActivator;
        Iterator iterator = this.browserHandlers.keySet().iterator();
        while (iterator.hasNext()) {
            IBrowserHandler iBrowserHandler = (IBrowserHandler)iterator.next();
            Integer n = (Integer)this.browserHandlers.get(iBrowserHandler);
            this.remoteHmiActivator.setBrowserHandler(iBrowserHandler, n);
            iterator.next();
        }
        if (this.ttsService instanceof TTSSessionBasedService) {
            this.remoteHmiActivator.setTtsService((TTSSessionBasedService)this.ttsService);
        }
        if (this.connectivityOnlineStateListener != null) {
            this.remoteHmiActivator.setConnectivityOnlineStateListener(this.connectivityOnlineStateListener);
        }
        if (this.connectivityRHMIStateListener != null) {
            this.remoteHmiActivator.setConnectivityStateListener(this.connectivityRHMIStateListener);
        }
        if (this.folderBrowsingService != null) {
            this.remoteHmiActivator.setFolderBrowsingService(this.folderBrowsingService);
        }
        if (this.mapService != null) {
            this.remoteHmiActivator.setMapService(this.mapService);
        }
        if (this.mediaDrawerContext != null) {
            this.remoteHmiActivator.setMediaDrawerContext(this.mediaDrawerContext);
        }
        if (this.mediaOnlinePlayerService != null) {
            this.remoteHmiActivator.setOnlineMediaService(this.mediaOnlinePlayerService);
        }
        if (this.mediaService != null) {
            this.remoteHmiActivator.setMediaService(this.mediaService);
        }
        if (this.messagingOnlineService != null) {
            this.remoteHmiActivator.setOnlineMessagingService(this.messagingOnlineService);
        }
        if (this.naviAdbService != null) {
            this.remoteHmiActivator.setNaviAdbService(this.naviAdbService);
        }
        if (this.naviFormattingService != null) {
            this.remoteHmiActivator.setNaviFormattingService(this.naviFormattingService);
        }
        if (this.naviService != null) {
            this.remoteHmiActivator.setNaviService(this.naviService);
        }
        if (this.onlineHMIService != null) {
            this.remoteHmiActivator.setOnlineHMIService(this.onlineHMIService);
        }
        if (this.onlinePOICall != null) {
            this.remoteHmiActivator.setOnlinePOICall(this.onlinePOICall);
        }
        if (this.onlineServiceListener != null) {
            this.remoteHmiActivator.setSDSOnlineServiceListener(this.onlineServiceListener);
        }
        if (this.portalAuthenticationService != null) {
            this.remoteHmiActivator.setPortalAuthenticationService(this.portalAuthenticationService);
        }
        if (this.previewMap != null) {
            this.remoteHmiActivator.setPreviewMap(this.previewMap);
        }
        if (this.remoteHmi != null) {
            this.remoteHmiActivator.setRemoteHmi(this.remoteHmi);
        }
        if (this.remoteHMIEsimLicenseListener != null) {
            this.remoteHmiActivator.setRemoteHMIEsimLicenseListener(this.remoteHMIEsimLicenseListener);
        }
        if (this.remoteHMIMediaOnlineServiceListener != null) {
            this.remoteHmiActivator.setRemoteHMIMediaOnlineServiceListener(this.remoteHMIMediaOnlineServiceListener);
        }
        if (this.sdsService != null) {
            this.remoteHmiActivator.setSdsService(this.sdsService);
        }
        if (this.telService != null) {
            this.remoteHmiActivator.setTelService(this.telService);
        }
    }

    protected final OnlineRemoteHMIActivator getRemoteHmiActivator() {
        return this.remoteHmiActivator;
    }

    protected final JokerKeyHandler getJokerKeyHandler() {
        return this.jokerKeyHandler;
    }

    protected final OnlineModelBankAccess getModelBank() {
        return this.modelBank;
    }

    protected final FactResetService getFactResetService() {
        return this.factoryResetService;
    }

    protected final void setOnlineEnv(OnlineEnv onlineEnv) {
        this.onlineEnv = onlineEnv;
    }

    protected final IIDMapper getTextConstants() {
        return this.textConstants;
    }

    protected final void setTextConstants(IIDMapper iIDMapper) {
        this.textConstants = iIDMapper;
    }

    protected final void setSmEventConstants(IIDMapper iIDMapper) {
        this.smEventConstants = iIDMapper;
    }

    protected final void setOnlineDestinationController(OnlineDestinationController onlineDestinationController) {
        this.onlineDestHandler = onlineDestinationController;
    }

    protected final void initOSRApplication() {
        try {
            OnlineServiceRegistrationSubsystem onlineServiceRegistrationSubsystem = new OnlineServiceRegistrationSubsystem(this.framework, this);
            this.setOnlineServiceRegistrationSubsystem(onlineServiceRegistrationSubsystem);
            this.getOnlineDiag().setORS(onlineServiceRegistrationSubsystem);
            if (this.useRemoteHmi && this.remoteHMIService != null) {
                this.remoteHMIService.setCoreServiceLanguageListener(onlineServiceRegistrationSubsystem);
            }
        }
        catch (Exception exception) {
            this.logChannel.log(10000, "AbstractOnlineActivator#initOSRApplication() - Exception occured: %1", (Throwable)exception);
        }
        this.initOSRApplicationVariant();
    }

    protected final void initRemoteHmi() {
        Object object;
        try {
            object = this.createRemoteHMIService();
            if (object == null) {
                this.logChannel.log(1000000, "AbstractOnlineActivator#initRemoteHmi() RemoteHMI not available");
                return;
            }
            ((RemoteHMIService)object).setPrivacyModeFeatureAvailable(this.privacyModeFeatureAvailable);
            this.setRemoteHmiService((RemoteHMIService)object);
            Online.getInstance().setRemoteHMIService((RemoteHMIService)object);
            this.setRemoteHmiActivator(new OnlineRemoteHMIActivator(Online.getInstance().getLogChannel(), this.framework, (RemoteHMIService)object));
        }
        catch (Exception exception) {
            this.logChannel.log(10000, "AbstractOnlineActivator#initRemoteHmi: could not initialize remoteHmi, exception %1", (Throwable)exception);
        }
        object = this.modelBank.getChoiceModel(2300074);
        object.setStatus(this.useRemoteHmi ? 1 : 0);
    }

    protected final void finalizeOperatorCallControllerCreation(AbstractOperatorCallMain abstractOperatorCallMain) {
        this.operatorCallController = abstractOperatorCallMain;
        if (this.remoteHMIService != null) {
            abstractOperatorCallMain.setOnlineServiceProvider(this.remoteHMIService.getOnlineServiceProvider());
            this.remoteHMIService.setOperatorCallController(abstractOperatorCallMain);
        }
    }

    protected final void registerOnlineI18NHandler() {
        if (this.i18nHandler != null) {
            this.logChannel.log(10000000, "AbstractOnlineActivator#registerOnlineI18NHandler");
            Hashtable hashtable = new Hashtable();
            hashtable.put("DEVICE_NAME", (class$de$audi$atip$i18n$I18NTarget == null ? (class$de$audi$atip$i18n$I18NTarget = AbstractOnlineActivator.class$("de.audi.atip.i18n.I18NTarget")) : class$de$audi$atip$i18n$I18NTarget).getName());
            hashtable.put("DEVICE_INSTANCE", new Integer(0));
            hashtable.put("LANG_COMPONENT_TYPE", "LANG_COMPONENT_HMI");
            hashtable.put("NOTIFY_BY_REGISTRATION_STRATEGY", "UPDATE_AFTER_REGISTRATION");
            this.registerService((class$de$audi$atip$i18n$I18NTarget == null ? (class$de$audi$atip$i18n$I18NTarget = AbstractOnlineActivator.class$("de.audi.atip.i18n.I18NTarget")) : class$de$audi$atip$i18n$I18NTarget).getName(), (Object)this.i18nHandler, (Dictionary)hashtable);
        }
    }

    protected final void registerOperatorCallLanguageService() {
        if (this.operatorCallController != null) {
            this.logChannel.log(10000000, "AbstractOnlineActivator#registerOperatorCallLanguageService - register I18N service");
            Hashtable hashtable = new Hashtable();
            hashtable.put("DEVICE_NAME", (class$de$audi$atip$i18n$I18NTarget == null ? (class$de$audi$atip$i18n$I18NTarget = AbstractOnlineActivator.class$("de.audi.atip.i18n.I18NTarget")) : class$de$audi$atip$i18n$I18NTarget).getName());
            hashtable.put("DEVICE_INSTANCE", new Integer(0));
            hashtable.put("LANG_COMPONENT_TYPE", "LANG_COMPONENT_HMI");
            hashtable.put("NOTIFY_BY_REGISTRATION_STRATEGY", "UPDATE_AFTER_REGISTRATION");
            this.registerService((class$de$audi$atip$i18n$I18NTarget == null ? (class$de$audi$atip$i18n$I18NTarget = AbstractOnlineActivator.class$("de.audi.atip.i18n.I18NTarget")) : class$de$audi$atip$i18n$I18NTarget).getName(), (Object)this.operatorCallController, (Dictionary)hashtable);
        }
    }

    protected final void registerOperatorCallSdsService() {
        if (this.operatorCallController != null && this.operatorCallController.getSdsHandler() != null) {
            this.registerService((class$de$audi$atip$interapp$online$IOperatorCallSDSService == null ? (class$de$audi$atip$interapp$online$IOperatorCallSDSService = AbstractOnlineActivator.class$("de.audi.atip.interapp.online.IOperatorCallSDSService")) : class$de$audi$atip$interapp$online$IOperatorCallSDSService).getName(), (Object)this.operatorCallController.getSdsHandler(), (Dictionary)AbstractOnlineActivator.createServiceProperties());
        }
    }

    protected final void registerOperatorCallNaviService() {
        if (this.operatorCallController != null) {
            this.registerService((class$de$audi$atip$interapp$online$IOperatorCallNaviService == null ? (class$de$audi$atip$interapp$online$IOperatorCallNaviService = AbstractOnlineActivator.class$("de.audi.atip.interapp.online.IOperatorCallNaviService")) : class$de$audi$atip$interapp$online$IOperatorCallNaviService).getName(), (Object)this.operatorCallController.getNaviHandler(), (Dictionary)AbstractOnlineActivator.createServiceProperties());
        }
    }

    protected final void registerOnlineDestinationService() {
        if (this.onlineDestHandler != null) {
            this.registerService((class$de$audi$atip$interapp$online$IOnlineDestinationService == null ? (class$de$audi$atip$interapp$online$IOnlineDestinationService = AbstractOnlineActivator.class$("de.audi.atip.interapp.online.IOnlineDestinationService")) : class$de$audi$atip$interapp$online$IOnlineDestinationService).getName(), (Object)this.onlineDestHandler, (Dictionary)AbstractOnlineActivator.createServiceProperties());
        }
    }

    protected final void registerDSIdestImportListener() {
        if (this.onlineDestHandler != null && this.onlineDestHandler.getDsiListener() != null) {
            this.registerDSIListener((class$org$dsi$ifc$base$DSIListener == null ? (class$org$dsi$ifc$base$DSIListener = AbstractOnlineActivator.class$("org.dsi.ifc.base.DSIListener")) : class$org$dsi$ifc$base$DSIListener).getName(), this.onlineDestHandler.getDsiListener(), (class$org$dsi$ifc$online$DSIDestinationImportListener == null ? (class$org$dsi$ifc$online$DSIDestinationImportListener = AbstractOnlineActivator.class$("org.dsi.ifc.online.DSIDestinationImportListener")) : class$org$dsi$ifc$online$DSIDestinationImportListener).getName(), 0);
        }
    }

    protected final void registerDSIoperatorCallListener() {
        if (this.operatorCallController != null && this.operatorCallController.getDsiListener() != null) {
            this.registerDSIListener((class$org$dsi$ifc$base$DSIListener == null ? (class$org$dsi$ifc$base$DSIListener = AbstractOnlineActivator.class$("org.dsi.ifc.base.DSIListener")) : class$org$dsi$ifc$base$DSIListener).getName(), this.operatorCallController.getDsiListener(), (class$org$dsi$ifc$online$DSIOperatorCallListener == null ? (class$org$dsi$ifc$online$DSIOperatorCallListener = AbstractOnlineActivator.class$("org.dsi.ifc.online.DSIOperatorCallListener")) : class$org$dsi$ifc$online$DSIOperatorCallListener).getName(), 0);
        }
    }

    protected final void registerOnlineDestSdsService() {
        if (this.onlineDestHandler != null && this.onlineDestHandler.getSdsService() != null) {
            this.registerService((class$de$audi$atip$interapp$online$IOnlineSDSMyAudiService == null ? (class$de$audi$atip$interapp$online$IOnlineSDSMyAudiService = AbstractOnlineActivator.class$("de.audi.atip.interapp.online.IOnlineSDSMyAudiService")) : class$de$audi$atip$interapp$online$IOnlineSDSMyAudiService).getName(), (Object)this.onlineDestHandler.getSdsService(), (Dictionary)AbstractOnlineActivator.createServiceProperties());
        }
    }

    protected final void registerTerminalModeUpdateListener() {
        if (this.operatorCallController != null) {
            this.registerService((class$de$audi$atip$interapp$terminalmode$ITerminalModeUpdateListener == null ? (class$de$audi$atip$interapp$terminalmode$ITerminalModeUpdateListener = AbstractOnlineActivator.class$("de.audi.atip.interapp.terminalmode.ITerminalModeUpdateListener")) : class$de$audi$atip$interapp$terminalmode$ITerminalModeUpdateListener).getName(), (Object)this.operatorCallController.getTerminalModeUpdateListener(), (Dictionary)AbstractOnlineActivator.createServiceProperties());
        }
    }

    public final void registerOnlineApplicationService(OnlineService onlineService) {
        this.logChannel.log(10000000, "AbstractOnlineActivator#registerOnlineApplicationService: applicationId: %1", (Object)onlineService.getApplicationId());
        Hashtable hashtable = new Hashtable();
        hashtable.put("ONLINE_APP_ID", onlineService.getApplicationId());
        ServiceRegistration serviceRegistration = this.getBundleContext().registerService((class$de$audi$atip$interapp$online$IOnlineService == null ? (class$de$audi$atip$interapp$online$IOnlineService = AbstractOnlineActivator.class$("de.audi.atip.interapp.online.IOnlineService")) : class$de$audi$atip$interapp$online$IOnlineService).getName(), (Object)onlineService, (Dictionary)hashtable);
        onlineService.setServiceRegistration(serviceRegistration);
    }

    public final void unregisterOnlineApplicationService(OnlineService onlineService) {
        this.logChannel.log(10000000, "AbstractOnlineActivator#unregisterOnlineApplicationService applicationId: %1", (Object)onlineService.getApplicationId());
        ServiceRegistration serviceRegistration = onlineService.getServiceRegistration();
        if (serviceRegistration != null) {
            serviceRegistration.unregister();
            onlineService.setServiceRegistration(null);
            this.logChannel.log(10000000, "AbstractOnlineActivator#unregisterOnlineApplicationService: applicationId: %1 service unregistered", (Object)onlineService.getApplicationId());
            return;
        }
    }

    public final void registerAuthenticationService(T2AuthenticationService t2AuthenticationService) {
        Hashtable hashtable = new Hashtable();
        this.authenticationServiceRegistration = this.getBundleContext().registerService((class$de$audi$atip$interapp$PortalAuthenticationService == null ? (class$de$audi$atip$interapp$PortalAuthenticationService = AbstractOnlineActivator.class$("de.audi.atip.interapp.PortalAuthenticationService")) : class$de$audi$atip$interapp$PortalAuthenticationService).getName(), (Object)t2AuthenticationService, (Dictionary)hashtable);
        this.logChannel.log(1000000, "AbstractOnlineActivator#registerAuthenticationService: T2 Authenticationservice registered");
    }

    public final void unregisterAuthenticationService() {
        if (this.authenticationServiceRegistration != null) {
            this.authenticationServiceRegistration.unregister();
            this.authenticationServiceRegistration = null;
            this.logChannel.log(1000000, "AbstractOnlineActivator#unregisterAuthenticationService: T2 Authenticationservice unregistered");
        }
    }

    protected void finalizeStart() {
        this.setButtonModelStatus();
        this.registerServices();
        this.initServiceTrackers();
    }

    protected abstract Field[] getI18NTextFields();

    protected abstract void readPrivacyModeFeatureCoding();

    protected abstract IIDMapper createTextConstants();

    protected abstract IIDMapper createSmEventConstantsMapper();

    protected abstract int getShutdownPopupId();

    public abstract int getDrawerCategory();

    protected abstract RemoteHMIService createRemoteHMIService();

    protected abstract void registerServices();

    protected abstract OnlineDiag getOnlineDiag();

    protected abstract void setDsiOnlineServiceRegistrationVariant(DSIOnlineServiceRegistration var1);

    protected abstract void setTelServiceConnectivityVariant(ITelServiceConnectivity var1);

    protected abstract void setEniServiceOnlineVariant(ENIServiceOnline var1);

    protected abstract void setMobileKeyStatusDisplayServiceVariant(MobileKeyStatusDisplayService var1);

    protected abstract void initOSRApplicationVariant();

    protected abstract void setFactResetServiceVariant(FactResetService var1);

    static /* synthetic */ Class class$(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new NoClassDefFoundError().initCause(classNotFoundException);
        }
    }
}

