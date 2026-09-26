/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  de.audi.atip.utils.generics.GList
 *  de.audi.atip.utils.generics.Generics
 *  de.audi.atip.utils.injector.Injector
 *  de.audi.atip.utils.reactive.properties.LoggingPropertyFactory
 */
package de.audi.app.terminalmode.core;

import de.audi.app.terminalmode.IContext;
import de.audi.app.terminalmode.ITerminalLogger$LogScope;
import de.audi.app.terminalmode.ITerminalModeComponent;
import de.audi.app.terminalmode.ITerminalModeConfiguration;
import de.audi.app.terminalmode.SmartphoneManager$SmartphoneType;
import de.audi.app.terminalmode.core.ITerminalModeApplicationFactory;
import de.audi.app.terminalmode.core.TerminalModeApplication$1;
import de.audi.app.terminalmode.core.TerminalModeContext;
import de.audi.app.terminalmode.osgi.ServiceManagerImpl;
import de.audi.atip.base.IFrameworkAccess;
import de.audi.atip.utils.generics.GIterator;
import de.audi.atip.utils.generics.GList;
import de.audi.atip.utils.generics.Generics;
import de.audi.atip.utils.injector.IInjector;
import de.audi.atip.utils.injector.Injector;
import de.audi.atip.utils.injector.Injector$IConfig;
import de.audi.atip.utils.reactive.bindings.ServiceBindings;
import de.audi.atip.utils.reactive.properties.LoggingPropertyFactory;
import java.util.Collection;
import org.osgi.framework.BundleContext;

public class TerminalModeApplication {
    private static final String LOGCLASS;
    private final TerminalModeContext contextBuilder;
    private final IContext context;
    private final GList terminalModeComponents = Generics.newArrayList();
    private final IInjector injector;
    static /* synthetic */ Class class$de$audi$atip$base$IFrameworkAccess;
    static /* synthetic */ Class class$de$audi$app$terminalmode$ITerminalModeConfiguration;
    static /* synthetic */ Class class$org$osgi$framework$BundleContext;
    static /* synthetic */ Class class$de$audi$atip$hmi$IHMIServiceApp;
    static /* synthetic */ Class class$de$audi$atip$storage$IStorageAccess;
    static /* synthetic */ Class class$de$esolutions$fw$util$commons$timeout$ITimeSource;
    static /* synthetic */ Class class$de$audi$app$terminalmode$ITerminalLogger;
    static /* synthetic */ Class class$de$audi$atip$log$LogChannel;
    static /* synthetic */ Class class$de$esolutions$fw$util$commons$job$DispatcherBase;
    static /* synthetic */ Class class$de$audi$atip$utils$dispatching$IDispatcher;
    static /* synthetic */ Class class$de$audi$app$terminalmode$smartphone$SmartphoneProperties;
    static /* synthetic */ Class class$de$audi$app$terminalmode$smartphone$IDSISmartphoneManager$ISmartphoneProperties;
    static /* synthetic */ Class class$de$audi$app$terminalmode$util$IStreamableStorageContainer;
    static /* synthetic */ Class class$de$audi$app$terminalmode$audio$AudioManager;
    static /* synthetic */ Class class$de$audi$app$terminalmode$audio$IAudioManager;
    static /* synthetic */ Class class$de$audi$app$terminalmode$device$TMDeviceFactory;
    static /* synthetic */ Class class$de$audi$app$terminalmode$core$TerminalModeContext;
    static /* synthetic */ Class class$de$audi$app$terminalmode$IContext;
    static /* synthetic */ Class class$de$audi$app$terminalmode$dsi$DSISmartphoneManagerProxy;
    static /* synthetic */ Class class$de$audi$app$terminalmode$smartphone$IDSISmartphoneManager;
    static /* synthetic */ Class class$de$audi$tghu$command$CommandListManager;
    static /* synthetic */ Class class$de$audi$app$terminalmode$smartphone$HardKeyDSIListener;
    static /* synthetic */ Class class$de$audi$app$terminalmode$device$DeviceManager;
    static /* synthetic */ Class class$de$audi$app$terminalmode$device$IDeviceManager;
    static /* synthetic */ Class class$de$audi$app$terminalmode$dsi$smartphoneintegration$ISMIDSIControllerListener;
    static /* synthetic */ Class class$de$audi$app$terminalmode$osgi$ServiceManagerImpl;
    static /* synthetic */ Class class$de$audi$app$terminalmode$osgi$IServiceManager;
    static /* synthetic */ Class class$de$audi$app$terminalmode$PhoneAppHandler;
    static /* synthetic */ Class class$de$audi$app$terminalmode$NaviAppHandler;
    static /* synthetic */ Class class$de$audi$app$terminalmode$keyevents$TMKeyEventsHandler;
    static /* synthetic */ Class class$de$audi$app$terminalmode$dsi$keypanel$TMDSIKeyPanelControllerImpl;
    static /* synthetic */ Class class$de$audi$app$terminalmode$keyevents$TMTouchscreenVBListener;
    static /* synthetic */ Class class$de$audi$app$terminalmode$keyevents$TMVirtualButtonListener;
    static /* synthetic */ Class class$de$audi$app$terminalmode$bt$dsi$BTDSIController;
    static /* synthetic */ Class class$de$audi$app$terminalmode$bt$dsi$IBTDSIControllerListenerUpdateProvider;
    static /* synthetic */ Class class$de$audi$app$terminalmode$diagnosis$DiagnosisManagerImpl;
    static /* synthetic */ Class class$de$audi$app$terminalmode$diagnosis$IDiagnosisManager;
    static /* synthetic */ Class class$de$audi$app$terminalmode$events$TerminalModeEventBus;
    static /* synthetic */ Class class$de$audi$app$terminalmode$events$IEventBus;
    static /* synthetic */ Class class$de$audi$app$terminalmode$statemachine$StateHandlerImpl;
    static /* synthetic */ Class class$de$audi$app$terminalmode$statemachine$IStateHandler;
    static /* synthetic */ Class class$de$audi$app$terminalmode$actionproxy$ActionProxyDispatcherImpl;
    static /* synthetic */ Class class$de$audi$app$terminalmode$actionproxy$IActionProxyDispatcher;
    static /* synthetic */ Class class$de$audi$app$terminalmode$FactoryResetMessageHandler;
    static /* synthetic */ Class class$de$audi$app$terminalmode$dsi$smartphoneintegration$SmartphoneIntegrationDSILifecycleController;
    static /* synthetic */ Class class$de$audi$app$terminalmode$dsi$smartphoneintegration$ISmartphoneIntegrationDSIController;
    static /* synthetic */ Class class$de$audi$app$terminalmode$CommandListHelper;
    static /* synthetic */ Class class$de$audi$app$terminalmode$NightDayModeHandler;
    static /* synthetic */ Class class$de$audi$app$terminalmode$INightDayModeHandler;
    static /* synthetic */ Class class$de$audi$app$terminalmode$device$DeviceVariantsHandling;
    static /* synthetic */ Class class$de$audi$app$terminalmode$device$IDeviceVariantsHandling;
    static /* synthetic */ Class class$de$audi$app$terminalmode$logging$TerminalModeLoggingDecoratorFactory;
    static /* synthetic */ Class class$de$audi$app$terminalmode$audio$AudibleStateSyncer;
    static /* synthetic */ Class class$de$audi$app$terminalmode$HardKeyListener;
    static /* synthetic */ Class class$de$audi$app$terminalmode$combi$TerminalModeBapCombi;
    static /* synthetic */ Class class$de$audi$app$terminalmode$diagnosis$DiagnosisServiceTracker;
    static /* synthetic */ Class class$de$audi$app$terminalmode$diagnosis$DiagnosisProvider;
    static /* synthetic */ Class class$de$audi$app$terminalmode$ExternalEventsListener;
    static /* synthetic */ Class class$de$audi$app$terminalmode$SDSAppHandler;
    static /* synthetic */ Class class$de$audi$app$terminalmode$TMInterAppHandler;
    static /* synthetic */ Class class$de$audi$app$terminalmode$AutomaticDeviceActivator;
    static /* synthetic */ Class class$de$audi$app$terminalmode$hmi$NewDeviceHMIHandler;
    static /* synthetic */ Class class$de$audi$app$terminalmode$hmi$CurrentPlayingTrackHandler;
    static /* synthetic */ Class class$de$audi$app$terminalmode$hmi$SmartphoneRouteGuidanceHMIHandler;
    static /* synthetic */ Class class$de$audi$app$terminalmode$interapp$HighPriorityResourceTracker;
    static /* synthetic */ Class class$de$audi$app$terminalmode$smartphone$MFLPhoneButtonsListener;
    static /* synthetic */ Class class$de$audi$app$terminalmode$device$TMDeviceStorekeeper;
    static /* synthetic */ Class class$de$audi$app$terminalmode$interapp$BluetoothWaker;
    static /* synthetic */ Class class$de$audi$atip$utils$reactive$properties$PropertyFactory;
    static /* synthetic */ Class class$de$audi$atip$utils$reactive$bindings$IServiceBindings;
    static /* synthetic */ Class class$de$audi$app$terminalmode$interapp$OnlinePOICallHandler;
    static /* synthetic */ Class class$de$audi$app$terminalmode$SmartphoneManager$SmartphoneType;
    static /* synthetic */ Class class$de$audi$app$terminalmode$dsi$androidauto2$DSIAndroidAuto2TransferObjectFactory;
    static /* synthetic */ Class class$de$audi$app$terminalmode$dsi$androidauto2$IDSIAndroidAuto2TransferObjectFactory;
    static /* synthetic */ Class class$de$audi$app$terminalmode$dsi$androidauto2$DSIAndroidAuto2Proxy;
    static /* synthetic */ Class class$org$dsi$ifc$androidauto2$DSIAndroidAuto2;
    static /* synthetic */ Class class$de$audi$app$terminalmode$smartphone$androidauto2$AndroidAuto2RequestHandler;
    static /* synthetic */ Class class$de$audi$app$terminalmode$smartphone$androidauto2$IAndroidAuto2RequestHandler;
    static /* synthetic */ Class class$de$audi$app$terminalmode$smartphone$androidauto2$AndroidAuto2DSIManager;
    static /* synthetic */ Class class$de$audi$app$terminalmode$SmartphoneManager;
    static /* synthetic */ Class class$de$audi$app$terminalmode$smartphone$IDSISmartphoneManagerListener;
    static /* synthetic */ Class class$de$audi$app$terminalmode$smartphone$androidauto2$AndroidAuto2ListenerDistributor;
    static /* synthetic */ Class class$org$dsi$ifc$androidauto2$DSIAndroidAuto2Listener;
    static /* synthetic */ Class class$de$audi$app$terminalmode$dsi$androidauto2$DSIAndroidAuto2DSIController;
    static /* synthetic */ Class class$de$audi$app$terminalmode$smartphone$androidauto2$AndroidAuto2Subsystem;
    static /* synthetic */ Class class$de$audi$app$terminalmode$ITMDeviceSubsystem;
    static /* synthetic */ Class class$de$audi$app$terminalmode$dsi$IDSIControllerStateListener;
    static /* synthetic */ Class class$de$audi$app$terminalmode$smartphone$androidauto2$AndroidAuto2KeyEventsController;
    static /* synthetic */ Class class$de$audi$app$terminalmode$keyevents$ITerminalModeDSIKeyEventsController;
    static /* synthetic */ Class class$de$audi$app$terminalmode$smartphone$androidauto2$AndroidAuto2EventListener;
    static /* synthetic */ Class class$de$audi$app$terminalmode$smartphone$androidauto2$mic$AndroidAuto2MicHandler;
    static /* synthetic */ Class class$de$audi$app$terminalmode$smartphone$androidauto2$mic$IAndroidAuto2MicHandler;
    static /* synthetic */ Class class$de$audi$app$terminalmode$smartphone$androidauto2$nav$AndroidAuto2NavHandler;
    static /* synthetic */ Class class$de$audi$app$terminalmode$smartphone$androidauto2$nav$IAndroidAuto2NavHandler;
    static /* synthetic */ Class class$de$audi$app$terminalmode$smartphone$androidauto2$audio$AndroidAuto2AudioHandler;
    static /* synthetic */ Class class$de$audi$app$terminalmode$smartphone$androidauto2$audio$IAndroidAuto2AudioHandler;
    static /* synthetic */ Class class$de$audi$app$terminalmode$smartphone$androidauto2$video$AndroidAuto2VideoHandler;
    static /* synthetic */ Class class$de$audi$app$terminalmode$smartphone$androidauto2$video$IAndroidAuto2VideoHandler;
    static /* synthetic */ Class class$de$audi$app$terminalmode$smartphone$androidauto2$voice$AndroidAuto2VoiceSessionHandler;
    static /* synthetic */ Class class$de$audi$app$terminalmode$dsi$carplay$CarplayDSILifecycleController;
    static /* synthetic */ Class class$de$audi$app$terminalmode$dsi$carplay$DSICarplayTransferObjectFactory;
    static /* synthetic */ Class class$de$audi$app$terminalmode$dsi$carplay$IDSICarplayTransferObjectFactory;
    static /* synthetic */ Class class$de$audi$app$terminalmode$smartphone$carplay$CarplaySmartphoneProperties;
    static /* synthetic */ Class class$de$audi$app$terminalmode$smartphone$carplay$CarPlayDSIManager;
    static /* synthetic */ Class class$de$audi$app$terminalmode$dsi$carplay$ICarplayDSIControllerListener;
    static /* synthetic */ Class class$de$audi$app$terminalmode$dsi$carplay$DSICarplaySafeProxy;
    static /* synthetic */ Class class$de$audi$app$terminalmode$dsi$carplay$DSICarplaySafe;
    static /* synthetic */ Class class$de$audi$app$terminalmode$dsi$carplay$CarplayDSILifecycleController$DSICarplayListenerImpl;
    static /* synthetic */ Class class$org$dsi$ifc$carplay$DSICarplayListener;
    static /* synthetic */ Class class$de$audi$app$terminalmode$dsi$carlife$DSICarlifeProxy;
    static /* synthetic */ Class class$org$dsi$ifc$carlife$DSICarlife;
    static /* synthetic */ Class class$de$audi$app$terminalmode$smartphone$carlife$CarlifeDSIManager;
    static /* synthetic */ Class class$de$audi$app$terminalmode$smartphone$carlife$CarlifeListenerDistributor;
    static /* synthetic */ Class class$org$dsi$ifc$carlife$DSICarlifeListener;
    static /* synthetic */ Class class$de$audi$app$terminalmode$dsi$carlife$CarlifeDSIController;
    static /* synthetic */ Class class$de$audi$app$terminalmode$smartphone$carlife$CarlifeSubsystem;
    static /* synthetic */ Class class$de$audi$app$terminalmode$smartphone$carlife$CarlifeKeyEventsController;
    static /* synthetic */ Class class$de$audi$app$terminalmode$smartphone$carlife$CarlifeEventListener;
    static /* synthetic */ Class class$de$audi$app$terminalmode$smartphone$carlife$DSIMHIConstantsMapper;
    static /* synthetic */ Class class$de$audi$app$terminalmode$smartphone$carlife$CarlifeDSIRequestModeHandler;
    static /* synthetic */ Class class$de$audi$app$terminalmode$smartphone$carlife$CarlifeHMISetModeHandler;
    static /* synthetic */ Class class$de$audi$app$terminalmode$smartphone$carlife$CarlifeDSIAppNotInstalledManager;
    static /* synthetic */ Class class$de$audi$app$terminalmode$audio$SpeechReset;

    public TerminalModeApplication(BundleContext bundleContext, IFrameworkAccess iFrameworkAccess, ITerminalModeConfiguration iTerminalModeConfiguration, ITerminalModeApplicationFactory iTerminalModeApplicationFactory) {
        this.injector = Injector.createInjector((Injector$IConfig)new TerminalModeApplication$1(this, iFrameworkAccess, iTerminalModeConfiguration, bundleContext), (boolean)iFrameworkAccess.isSimulator());
        this.contextBuilder = (TerminalModeContext)this.injector.getInstance(class$de$audi$app$terminalmode$IContext == null ? (class$de$audi$app$terminalmode$IContext = TerminalModeApplication.class$("de.audi.app.terminalmode.IContext")) : class$de$audi$app$terminalmode$IContext);
        this.context = this.contextBuilder;
        this.terminalModeComponents.add(this.injector.getInstance(class$de$audi$app$terminalmode$smartphone$IDSISmartphoneManager == null ? (class$de$audi$app$terminalmode$smartphone$IDSISmartphoneManager = TerminalModeApplication.class$("de.audi.app.terminalmode.smartphone.IDSISmartphoneManager")) : class$de$audi$app$terminalmode$smartphone$IDSISmartphoneManager));
        this.terminalModeComponents.add(this.injector.getInstance(class$de$audi$app$terminalmode$audio$AudioManager == null ? (class$de$audi$app$terminalmode$audio$AudioManager = TerminalModeApplication.class$("de.audi.app.terminalmode.audio.AudioManager")) : class$de$audi$app$terminalmode$audio$AudioManager));
        this.terminalModeComponents.add(this.injector.getInstance(class$de$audi$app$terminalmode$device$DeviceManager == null ? (class$de$audi$app$terminalmode$device$DeviceManager = TerminalModeApplication.class$("de.audi.app.terminalmode.device.DeviceManager")) : class$de$audi$app$terminalmode$device$DeviceManager));
        this.terminalModeComponents.add(this.injector.getInstance(class$de$audi$app$terminalmode$dsi$smartphoneintegration$SmartphoneIntegrationDSILifecycleController == null ? (class$de$audi$app$terminalmode$dsi$smartphoneintegration$SmartphoneIntegrationDSILifecycleController = TerminalModeApplication.class$("de.audi.app.terminalmode.dsi.smartphoneintegration.SmartphoneIntegrationDSILifecycleController")) : class$de$audi$app$terminalmode$dsi$smartphoneintegration$SmartphoneIntegrationDSILifecycleController));
        this.terminalModeComponents.add(this.injector.getInstance(class$de$audi$app$terminalmode$actionproxy$ActionProxyDispatcherImpl == null ? (class$de$audi$app$terminalmode$actionproxy$ActionProxyDispatcherImpl = TerminalModeApplication.class$("de.audi.app.terminalmode.actionproxy.ActionProxyDispatcherImpl")) : class$de$audi$app$terminalmode$actionproxy$ActionProxyDispatcherImpl));
        this.terminalModeComponents.add(this.injector.getInstance(class$de$audi$app$terminalmode$statemachine$StateHandlerImpl == null ? (class$de$audi$app$terminalmode$statemachine$StateHandlerImpl = TerminalModeApplication.class$("de.audi.app.terminalmode.statemachine.StateHandlerImpl")) : class$de$audi$app$terminalmode$statemachine$StateHandlerImpl));
        this.terminalModeComponents.add(this.injector.getInstance(class$de$audi$app$terminalmode$PhoneAppHandler == null ? (class$de$audi$app$terminalmode$PhoneAppHandler = TerminalModeApplication.class$("de.audi.app.terminalmode.PhoneAppHandler")) : class$de$audi$app$terminalmode$PhoneAppHandler));
        this.terminalModeComponents.add(this.injector.getInstance(class$de$audi$app$terminalmode$NaviAppHandler == null ? (class$de$audi$app$terminalmode$NaviAppHandler = TerminalModeApplication.class$("de.audi.app.terminalmode.NaviAppHandler")) : class$de$audi$app$terminalmode$NaviAppHandler));
        this.terminalModeComponents.add(this.injector.getInstance(class$de$audi$app$terminalmode$INightDayModeHandler == null ? (class$de$audi$app$terminalmode$INightDayModeHandler = TerminalModeApplication.class$("de.audi.app.terminalmode.INightDayModeHandler")) : class$de$audi$app$terminalmode$INightDayModeHandler));
        this.terminalModeComponents.add(this.injector.getInstance(class$de$audi$app$terminalmode$device$IDeviceVariantsHandling == null ? (class$de$audi$app$terminalmode$device$IDeviceVariantsHandling = TerminalModeApplication.class$("de.audi.app.terminalmode.device.IDeviceVariantsHandling")) : class$de$audi$app$terminalmode$device$IDeviceVariantsHandling));
        this.terminalModeComponents.add(this.injector.getInstance(class$de$audi$app$terminalmode$keyevents$TMKeyEventsHandler == null ? (class$de$audi$app$terminalmode$keyevents$TMKeyEventsHandler = TerminalModeApplication.class$("de.audi.app.terminalmode.keyevents.TMKeyEventsHandler")) : class$de$audi$app$terminalmode$keyevents$TMKeyEventsHandler));
        this.terminalModeComponents.add(this.injector.getInstance(class$de$audi$app$terminalmode$keyevents$TMVirtualButtonListener == null ? (class$de$audi$app$terminalmode$keyevents$TMVirtualButtonListener = TerminalModeApplication.class$("de.audi.app.terminalmode.keyevents.TMVirtualButtonListener")) : class$de$audi$app$terminalmode$keyevents$TMVirtualButtonListener));
        this.terminalModeComponents.add(this.injector.getInstance(SmartphoneManager$SmartphoneType.CARPLAY, class$de$audi$app$terminalmode$smartphone$carplay$CarPlayDSIManager == null ? (class$de$audi$app$terminalmode$smartphone$carplay$CarPlayDSIManager = TerminalModeApplication.class$("de.audi.app.terminalmode.smartphone.carplay.CarPlayDSIManager")) : class$de$audi$app$terminalmode$smartphone$carplay$CarPlayDSIManager));
        this.terminalModeComponents.add(this.injector.getInstance(SmartphoneManager$SmartphoneType.CARPLAY, class$de$audi$app$terminalmode$smartphone$carplay$CarplaySmartphoneProperties == null ? (class$de$audi$app$terminalmode$smartphone$carplay$CarplaySmartphoneProperties = TerminalModeApplication.class$("de.audi.app.terminalmode.smartphone.carplay.CarplaySmartphoneProperties")) : class$de$audi$app$terminalmode$smartphone$carplay$CarplaySmartphoneProperties));
        this.terminalModeComponents.add(this.injector.getInstance(SmartphoneManager$SmartphoneType.ANDROIDAUTO2, class$de$audi$app$terminalmode$smartphone$androidauto2$AndroidAuto2Subsystem == null ? (class$de$audi$app$terminalmode$smartphone$androidauto2$AndroidAuto2Subsystem = TerminalModeApplication.class$("de.audi.app.terminalmode.smartphone.androidauto2.AndroidAuto2Subsystem")) : class$de$audi$app$terminalmode$smartphone$androidauto2$AndroidAuto2Subsystem));
        this.terminalModeComponents.add(this.injector.getInstance(SmartphoneManager$SmartphoneType.CARLIFE, class$de$audi$app$terminalmode$smartphone$carlife$CarlifeSubsystem == null ? (class$de$audi$app$terminalmode$smartphone$carlife$CarlifeSubsystem = TerminalModeApplication.class$("de.audi.app.terminalmode.smartphone.carlife.CarlifeSubsystem")) : class$de$audi$app$terminalmode$smartphone$carlife$CarlifeSubsystem));
        this.terminalModeComponents.add(this.injector.getInstance(SmartphoneManager$SmartphoneType.CARLIFE, class$de$audi$app$terminalmode$smartphone$carlife$CarlifeDSIRequestModeHandler == null ? (class$de$audi$app$terminalmode$smartphone$carlife$CarlifeDSIRequestModeHandler = TerminalModeApplication.class$("de.audi.app.terminalmode.smartphone.carlife.CarlifeDSIRequestModeHandler")) : class$de$audi$app$terminalmode$smartphone$carlife$CarlifeDSIRequestModeHandler));
        this.terminalModeComponents.add(this.injector.getInstance(SmartphoneManager$SmartphoneType.CARLIFE, class$de$audi$app$terminalmode$smartphone$carlife$CarlifeDSIAppNotInstalledManager == null ? (class$de$audi$app$terminalmode$smartphone$carlife$CarlifeDSIAppNotInstalledManager = TerminalModeApplication.class$("de.audi.app.terminalmode.smartphone.carlife.CarlifeDSIAppNotInstalledManager")) : class$de$audi$app$terminalmode$smartphone$carlife$CarlifeDSIAppNotInstalledManager));
        this.terminalModeComponents.add(this.injector.getInstance(class$de$audi$app$terminalmode$audio$AudibleStateSyncer == null ? (class$de$audi$app$terminalmode$audio$AudibleStateSyncer = TerminalModeApplication.class$("de.audi.app.terminalmode.audio.AudibleStateSyncer")) : class$de$audi$app$terminalmode$audio$AudibleStateSyncer));
        this.terminalModeComponents.add(this.injector.getInstance(class$de$audi$app$terminalmode$HardKeyListener == null ? (class$de$audi$app$terminalmode$HardKeyListener = TerminalModeApplication.class$("de.audi.app.terminalmode.HardKeyListener")) : class$de$audi$app$terminalmode$HardKeyListener));
        this.terminalModeComponents.add(this.injector.getInstance(class$de$audi$app$terminalmode$combi$TerminalModeBapCombi == null ? (class$de$audi$app$terminalmode$combi$TerminalModeBapCombi = TerminalModeApplication.class$("de.audi.app.terminalmode.combi.TerminalModeBapCombi")) : class$de$audi$app$terminalmode$combi$TerminalModeBapCombi));
        this.terminalModeComponents.add(this.injector.getInstance(class$de$audi$app$terminalmode$diagnosis$DiagnosisServiceTracker == null ? (class$de$audi$app$terminalmode$diagnosis$DiagnosisServiceTracker = TerminalModeApplication.class$("de.audi.app.terminalmode.diagnosis.DiagnosisServiceTracker")) : class$de$audi$app$terminalmode$diagnosis$DiagnosisServiceTracker));
        this.terminalModeComponents.add(this.injector.getInstance(class$de$audi$app$terminalmode$diagnosis$DiagnosisProvider == null ? (class$de$audi$app$terminalmode$diagnosis$DiagnosisProvider = TerminalModeApplication.class$("de.audi.app.terminalmode.diagnosis.DiagnosisProvider")) : class$de$audi$app$terminalmode$diagnosis$DiagnosisProvider));
        this.terminalModeComponents.add(this.injector.getInstance(class$de$audi$app$terminalmode$ExternalEventsListener == null ? (class$de$audi$app$terminalmode$ExternalEventsListener = TerminalModeApplication.class$("de.audi.app.terminalmode.ExternalEventsListener")) : class$de$audi$app$terminalmode$ExternalEventsListener));
        this.terminalModeComponents.add(this.injector.getInstance(class$de$audi$app$terminalmode$SDSAppHandler == null ? (class$de$audi$app$terminalmode$SDSAppHandler = TerminalModeApplication.class$("de.audi.app.terminalmode.SDSAppHandler")) : class$de$audi$app$terminalmode$SDSAppHandler));
        this.terminalModeComponents.add(this.injector.getInstance(class$de$audi$app$terminalmode$TMInterAppHandler == null ? (class$de$audi$app$terminalmode$TMInterAppHandler = TerminalModeApplication.class$("de.audi.app.terminalmode.TMInterAppHandler")) : class$de$audi$app$terminalmode$TMInterAppHandler));
        this.terminalModeComponents.add(this.injector.getInstance(class$de$audi$app$terminalmode$AutomaticDeviceActivator == null ? (class$de$audi$app$terminalmode$AutomaticDeviceActivator = TerminalModeApplication.class$("de.audi.app.terminalmode.AutomaticDeviceActivator")) : class$de$audi$app$terminalmode$AutomaticDeviceActivator));
        this.terminalModeComponents.add(this.injector.getInstance(class$de$audi$app$terminalmode$hmi$CurrentPlayingTrackHandler == null ? (class$de$audi$app$terminalmode$hmi$CurrentPlayingTrackHandler = TerminalModeApplication.class$("de.audi.app.terminalmode.hmi.CurrentPlayingTrackHandler")) : class$de$audi$app$terminalmode$hmi$CurrentPlayingTrackHandler));
        this.terminalModeComponents.add(this.injector.getInstance(ITerminalLogger$LogScope.HMI, class$de$audi$app$terminalmode$hmi$SmartphoneRouteGuidanceHMIHandler == null ? (class$de$audi$app$terminalmode$hmi$SmartphoneRouteGuidanceHMIHandler = TerminalModeApplication.class$("de.audi.app.terminalmode.hmi.SmartphoneRouteGuidanceHMIHandler")) : class$de$audi$app$terminalmode$hmi$SmartphoneRouteGuidanceHMIHandler));
        this.terminalModeComponents.add(this.injector.getInstance(class$de$audi$app$terminalmode$bt$dsi$IBTDSIControllerListenerUpdateProvider == null ? (class$de$audi$app$terminalmode$bt$dsi$IBTDSIControllerListenerUpdateProvider = TerminalModeApplication.class$("de.audi.app.terminalmode.bt.dsi.IBTDSIControllerListenerUpdateProvider")) : class$de$audi$app$terminalmode$bt$dsi$IBTDSIControllerListenerUpdateProvider));
        this.terminalModeComponents.add(this.injector.getInstance(class$de$audi$app$terminalmode$FactoryResetMessageHandler == null ? (class$de$audi$app$terminalmode$FactoryResetMessageHandler = TerminalModeApplication.class$("de.audi.app.terminalmode.FactoryResetMessageHandler")) : class$de$audi$app$terminalmode$FactoryResetMessageHandler));
        this.terminalModeComponents.add(this.injector.getInstance(class$de$audi$app$terminalmode$interapp$HighPriorityResourceTracker == null ? (class$de$audi$app$terminalmode$interapp$HighPriorityResourceTracker = TerminalModeApplication.class$("de.audi.app.terminalmode.interapp.HighPriorityResourceTracker")) : class$de$audi$app$terminalmode$interapp$HighPriorityResourceTracker));
        this.terminalModeComponents.add(this.injector.getInstance(class$de$audi$app$terminalmode$smartphone$MFLPhoneButtonsListener == null ? (class$de$audi$app$terminalmode$smartphone$MFLPhoneButtonsListener = TerminalModeApplication.class$("de.audi.app.terminalmode.smartphone.MFLPhoneButtonsListener")) : class$de$audi$app$terminalmode$smartphone$MFLPhoneButtonsListener));
        this.terminalModeComponents.add(this.injector.getInstance(class$de$audi$app$terminalmode$interapp$BluetoothWaker == null ? (class$de$audi$app$terminalmode$interapp$BluetoothWaker = TerminalModeApplication.class$("de.audi.app.terminalmode.interapp.BluetoothWaker")) : class$de$audi$app$terminalmode$interapp$BluetoothWaker));
        this.terminalModeComponents.add(this.injector.getInstance(class$de$audi$app$terminalmode$device$TMDeviceStorekeeper == null ? (class$de$audi$app$terminalmode$device$TMDeviceStorekeeper = TerminalModeApplication.class$("de.audi.app.terminalmode.device.TMDeviceStorekeeper")) : class$de$audi$app$terminalmode$device$TMDeviceStorekeeper));
        this.terminalModeComponents.add(this.injector.getInstance(class$de$audi$app$terminalmode$interapp$OnlinePOICallHandler == null ? (class$de$audi$app$terminalmode$interapp$OnlinePOICallHandler = TerminalModeApplication.class$("de.audi.app.terminalmode.interapp.OnlinePOICallHandler")) : class$de$audi$app$terminalmode$interapp$OnlinePOICallHandler));
        this.terminalModeComponents.add(this.injector.getInstance(class$de$audi$app$terminalmode$audio$SpeechReset == null ? (class$de$audi$app$terminalmode$audio$SpeechReset = TerminalModeApplication.class$("de.audi.app.terminalmode.audio.SpeechReset")) : class$de$audi$app$terminalmode$audio$SpeechReset));
        this.terminalModeComponents.add((Object)iTerminalModeApplicationFactory.createActionProxy(this.context));
        this.terminalModeComponents.add((Object)iTerminalModeApplicationFactory.createHmiApplication(this.context));
        this.terminalModeComponents.addAll((Collection)iTerminalModeApplicationFactory.getVariantComponents(this.context));
    }

    public void init() {
        if (!this.context.getConfiguration().isTerminalMode()) {
            this.context.getLogger().main().log(1078071040, "[%1.init] TerminalMode is not coded. Return.", (Object)"TerminalModeApplication");
            return;
        }
        this.context.getDispatcher().start();
        this.context.getCommandListManager().start();
        GIterator gIterator = this.terminalModeComponents.iterator();
        while (gIterator.hasNext()) {
            ((ITerminalModeComponent)gIterator.next()).init();
        }
        this.context.getChoiceModel(4044).setValue(this.context.getConfiguration().isTerminalMode() ? 1 : 0);
        this.context.getEventBus().startupFinished();
    }

    public void deinit() {
        GIterator gIterator = this.terminalModeComponents.iterator();
        while (gIterator.hasNext()) {
            ((ITerminalModeComponent)gIterator.next()).deinit();
        }
        this.context.getDispatcher().stop();
        this.context.getCommandListManager().destroy();
        ((ServiceManagerImpl)this.injector.getInstance(class$de$audi$app$terminalmode$osgi$ServiceManagerImpl == null ? (class$de$audi$app$terminalmode$osgi$ServiceManagerImpl = TerminalModeApplication.class$("de.audi.app.terminalmode.osgi.ServiceManagerImpl")) : class$de$audi$app$terminalmode$osgi$ServiceManagerImpl)).cleanup();
        ((LoggingPropertyFactory)this.injector.getInstance(class$de$audi$atip$utils$reactive$properties$PropertyFactory == null ? (class$de$audi$atip$utils$reactive$properties$PropertyFactory = TerminalModeApplication.class$("de.audi.atip.utils.reactive.properties.PropertyFactory")) : class$de$audi$atip$utils$reactive$properties$PropertyFactory)).dispose();
        ((ServiceBindings)this.injector.getInstance(class$de$audi$atip$utils$reactive$bindings$IServiceBindings == null ? (class$de$audi$atip$utils$reactive$bindings$IServiceBindings = TerminalModeApplication.class$("de.audi.atip.utils.reactive.bindings.IServiceBindings")) : class$de$audi$atip$utils$reactive$bindings$IServiceBindings)).dispose();
    }

    public TerminalModeContext getContextBuilder() {
        return this.contextBuilder;
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

