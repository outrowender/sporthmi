/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  de.mib.swdiagnosis.online.EvoOnlineDiag
 *  de.mib.swdiagnosis.online.OnlineDiag
 */
package de.audi.app.online;

import de.audi.app.online.AbstractOnlineEvoActivator;
import de.audi.app.online.evo.DistributedServiceComponentEvo;
import de.audi.app.online.evo.OnlineActionProxyStd;
import de.audi.app.online.evo.OnlineBaseActionProxy;
import de.audi.app.online.evo.OnlineEvoActionProxyImpl;
import de.audi.app.online.evo.OnlineSMEventConstantsImplEvo;
import de.audi.app.online.evo.OnlineTextConstantsImplEvo;
import de.audi.app.online.evo.RemoteHMIServiceEvo;
import de.audi.app.online.evo.operatorcall.OperatorCallMainEvo;
import de.audi.app.online.evo.presets.OnlinePresetHandler;
import de.audi.app.online.evo.trafficlight.TrafficLightOnlineHandler;
import de.audi.app.online.onlinedest.OnlineDestinationButtonListener;
import de.audi.app.online.onlinedest.OnlineDestinationControllerEvo;
import de.audi.atip.hmi.HMIService;
import de.audi.atip.interapp.online.OnlinePOICall;
import de.audi.atip.log.LogChannel;
import de.audi.atip.statemachine.ap.OnlineActionProxy;
import de.audi.atip.variant.IIDMapper;
import de.audi.tghu.online.app.AbstractOnlineActivator;
import de.audi.tghu.online.app.Online;
import de.audi.tghu.online.app.operatorcall.AbstractOperatorCallMain;
import de.audi.tghu.online.app.remotehmi.RemoteHMIService;
import de.audi.tghu.online.app.standard.AbstractStandardController;
import de.audi.tghu.online.app.standard.GreyServiceHighController;
import de.audi.tghu.online.app.standard.IDistributedServiceCallListener;
import de.audi.tghu.online.app.standard.IStandardController;
import de.audi.tghu.online.app.standard.OnlineEvoStandardController;
import de.mib.swdiagnosis.online.EvoOnlineDiag;
import de.mib.swdiagnosis.online.OnlineDiag;
import java.util.Dictionary;
import org.osgi.framework.BundleContext;

public class OnlineActivator
extends AbstractOnlineEvoActivator {
    private TrafficLightOnlineHandler trafficLightHandler;
    private RemoteHMIServiceEvo remoteHMIServiceEvo = null;
    static /* synthetic */ Class class$de$audi$atip$preset$IAppPresetDefinitionHandler;
    static /* synthetic */ Class class$de$audi$atip$preset$IAppPresetExecutionHandler;
    static /* synthetic */ Class class$org$dsi$ifc$online$DSIOnlineServiceRegistration;
    static /* synthetic */ Class class$org$dsi$ifc$online$DSIDestinationImport;
    static /* synthetic */ Class class$de$audi$atip$interapp$online$OnlineServiceProvider;

    @Override
    public void start(BundleContext bundleContext) {
        super.start(bundleContext);
        this.logChannel.log(1078071040, "OnlineActivator#start() - starting AppOnline Bundle. RemoteHMI: %1", this.useRemoteHmi);
        this.initOnlineDestinationController();
        this.initOSRApplication();
        if (this.useRemoteHmi) {
            Object object;
            this.initRemoteHmi();
            this.createOperatorCall();
            try {
                object = this.getRemoteHmiActivator();
                if (object != null) {
                    this.getRemoteHmiActivator().registerProvidedServices(this);
                } else {
                    this.logChannel.log(10000, "OnlineActivator#start: remoteHmiActivator is null!");
                }
            }
            catch (Exception exception) {
                this.logChannel.log(10000, "OnlineActivator#start: exception with registering RemoteHMI provided services, exception %1", (Object)exception.getMessage());
            }
            this.registerRemoteHMIAppsHandlerOtherContextService(this.logChannel);
            object = this.getRemoteHmiService();
            if (object != null) {
                OnlinePresetHandler onlinePresetHandler = new OnlinePresetHandler((RemoteHMIService)object);
                this.registerService((class$de$audi$atip$preset$IAppPresetDefinitionHandler == null ? (class$de$audi$atip$preset$IAppPresetDefinitionHandler = OnlineActivator.class$("de.audi.atip.preset.IAppPresetDefinitionHandler")) : class$de$audi$atip$preset$IAppPresetDefinitionHandler).getName(), (Object)onlinePresetHandler, null);
                this.registerService((class$de$audi$atip$preset$IAppPresetExecutionHandler == null ? (class$de$audi$atip$preset$IAppPresetExecutionHandler = OnlineActivator.class$("de.audi.atip.preset.IAppPresetExecutionHandler")) : class$de$audi$atip$preset$IAppPresetExecutionHandler).getName(), (Object)onlinePresetHandler, null);
                ((RemoteHMIServiceEvo)object).setOnlinePresetHandler(onlinePresetHandler);
            } else {
                this.logChannel.log(10000, "OnlineActivator#start: RemoteHMIService is null!");
            }
        }
        this.framework.startDSIService((class$org$dsi$ifc$online$DSIOnlineServiceRegistration == null ? (class$org$dsi$ifc$online$DSIOnlineServiceRegistration = OnlineActivator.class$("org.dsi.ifc.online.DSIOnlineServiceRegistration")) : class$org$dsi$ifc$online$DSIOnlineServiceRegistration).getName(), 0);
        this.framework.startDSIService((class$org$dsi$ifc$online$DSIDestinationImport == null ? (class$org$dsi$ifc$online$DSIDestinationImport = OnlineActivator.class$("org.dsi.ifc.online.DSIDestinationImport")) : class$org$dsi$ifc$online$DSIDestinationImport).getName(), 0);
        this.trafficLightHandler = new TrafficLightOnlineHandler(this.framework.getHMIService(), this.logChannel, bundleContext);
        this.trafficLightHandler.setRemoteHmiService(this.getRemoteHmiService());
        new OnlineDestinationButtonListener(this.framework.getHMIService(), this.logChannel);
        this.finalizeStart();
    }

    private void initOnlineDestinationController() {
        OnlineDestinationControllerEvo onlineDestinationControllerEvo = new OnlineDestinationControllerEvo(this.logChannel, this.framework);
        onlineDestinationControllerEvo.init();
        this.setOnlineDestinationController(onlineDestinationControllerEvo);
    }

    @Override
    protected final void registerServicesVariant() {
        this.registerOnlineRegistrationService();
        this.registerDSIdestImportListener();
        this.registerDSIoperatorCallListener();
        this.registerOnlineDestinationService();
        this.registerOnlineDestSdsService();
        this.registerOperatorCallSdsService();
        this.registerOperatorCallNaviService();
        this.registerOperatorCallLanguageService();
        this.registerTerminalModeUpdateListener();
    }

    private void createOperatorCall() {
        if (this.isOperatorCallCoded()) {
            Object object;
            Online.getInstance().getOperatorCallLogChannel().log(1078071040, "OnlineActivator#createOperatorCall: called");
            RemoteHMIService remoteHMIService = this.getRemoteHmiService();
            if (remoteHMIService != null) {
                object = remoteHMIService.getOnlineOperatorCallService();
                this.setOnlinePoiCall((OnlinePOICall)object);
                if (object == null) {
                    Online.getInstance().getOperatorCallLogChannel().log(-1601830656, "OnlineActivator#createOperatorCall: onlinePOICall is null!");
                }
            } else {
                Online.getInstance().getOperatorCallLogChannel().log(10000, "OnlineActivator#createOperatorCall: remoteHMIService is null!");
            }
            object = new OperatorCallMainEvo(this.framework, this.getOnlineEnvironment(), this.getJokerKeyHandler(), this.bundleContext, this.isPoiCallCoded(), this.isConciergeCallCoded(), this.getOnlinePOICall(), remoteHMIService);
            this.finalizeOperatorCallControllerCreation((AbstractOperatorCallMain)object);
        }
    }

    @Override
    protected final RemoteHMIService createRemoteHMIService() {
        this.remoteHMIServiceEvo = new RemoteHMIServiceEvo(Online.getInstance().getRemoteHMILogChannel(), Online.getInstance().getRemoteHMIInterpreterLogChannel(), this.framework, this.getModelBank());
        IStandardController iStandardController = this.getStandardController();
        if (iStandardController instanceof IDistributedServiceCallListener) {
            ((DistributedServiceComponentEvo)this.remoteHMIServiceEvo.getDistributedServiceComponent()).addListener((IDistributedServiceCallListener)((Object)iStandardController));
        }
        return this.remoteHMIServiceEvo;
    }

    private void registerRemoteHMIAppsHandlerOtherContextService(LogChannel logChannel) {
        this.registerService((class$de$audi$atip$interapp$online$OnlineServiceProvider == null ? (class$de$audi$atip$interapp$online$OnlineServiceProvider = OnlineActivator.class$("de.audi.atip.interapp.online.OnlineServiceProvider")) : class$de$audi$atip$interapp$online$OnlineServiceProvider).getName(), (Object)this.remoteHMIServiceEvo.getOnlineServiceProvider(), (Dictionary)OnlineActivator.createServiceProperties());
    }

    @Override
    public final int getDrawerCategory() {
        int n = this.framework.getHMIService().getChoiceModel(270344960).getValue();
        if (n == 1) {
            return 1551043203;
        }
        return 1093657350;
    }

    @Override
    protected final IIDMapper createTextConstants() {
        return new OnlineTextConstantsImplEvo();
    }

    @Override
    protected final IIDMapper createSmEventConstantsMapper() {
        return new OnlineSMEventConstantsImplEvo(this.logChannel);
    }

    @Override
    protected final OnlineActionProxy createOnlineActionProxy() {
        OnlineBaseActionProxy onlineBaseActionProxy = null;
        if (this.useRemoteHmi) {
            onlineBaseActionProxy = new OnlineEvoActionProxyImpl(this.logChannel, this.getRemoteHmiService(), this.getOnlineDestinationHandler(), this.getOperatorCallHandler(), this.trafficLightHandler, this.getStandardController());
        } else if (this.useEni && !this.useRemoteHmi) {
            onlineBaseActionProxy = new OnlineActionProxyStd(this.logChannel, this.framework.getHMIService());
        }
        return onlineBaseActionProxy;
    }

    @Override
    protected final OnlineDiag createOnlineDiag() {
        EvoOnlineDiag evoOnlineDiag = new EvoOnlineDiag(this.framework, (AbstractOnlineActivator)this);
        evoOnlineDiag.setGreyServiceController(this.getStandardController());
        return evoOnlineDiag;
    }

    @Override
    protected final IStandardController createStandardController(HMIService hMIService) {
        AbstractStandardController abstractStandardController = null;
        if (!this.useRemoteHmi) {
            this.logChannel.log(1078071040, "OnlineActivator#start starting Online in Standard mode");
            abstractStandardController = new OnlineEvoStandardController(this.logChannel, hMIService, this.getShutdownPopupId(), this.getTextConstantsConverter(), this.getFramework());
        } else {
            this.logChannel.log(1078071040, "OnlineActivator#start starting Online in High mode");
            abstractStandardController = new GreyServiceHighController(this.logChannel, hMIService, this.getShutdownPopupId(), this.getTextConstantsConverter(), this.getFramework());
        }
        return abstractStandardController;
    }

    @Override
    protected final void initOSRApplicationVariant() {
        this.getOnlineServiceRegistrationSubsystem().getAuthenticationController().setPopupIds(-1340595456, -1357372672);
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

