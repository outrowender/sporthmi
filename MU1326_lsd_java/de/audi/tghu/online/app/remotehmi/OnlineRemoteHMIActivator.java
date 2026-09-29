/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.online.app.remotehmi;

import de.audi.atip.base.IFrameworkAccess;
import de.audi.atip.browser.IBrowserHandler;
import de.audi.atip.interapp.IConnectivityOnlineStateListener;
import de.audi.atip.interapp.IConnectivityRHMIStateListener;
import de.audi.atip.interapp.INaviFormattingService;
import de.audi.atip.interapp.MapService;
import de.audi.atip.interapp.NaviADBService;
import de.audi.atip.interapp.NaviService;
import de.audi.atip.interapp.OnlineHMIService;
import de.audi.atip.interapp.OnlineServiceListener;
import de.audi.atip.interapp.PortalAuthenticationService;
import de.audi.atip.interapp.SDSService;
import de.audi.atip.interapp.media.IMediaDrawerContext;
import de.audi.atip.interapp.media.IMediaOnlinePlayerService;
import de.audi.atip.interapp.media.IMediaService;
import de.audi.atip.interapp.messaging.IMessagingOnlineService;
import de.audi.atip.interapp.messaging.folderbrowsing.IFolderBrowsingService;
import de.audi.atip.interapp.navigation.previewmap.IPreviewMap;
import de.audi.atip.interapp.online.IRemoteHMIEsimLicenseListener;
import de.audi.atip.interapp.online.IRemoteHMIMediaOnlineServiceListener;
import de.audi.atip.interapp.online.OnlinePOICall;
import de.audi.atip.interapp.tts.TTSService;
import de.audi.atip.interapp.tts.TTSSessionBasedService;
import de.audi.atip.log.LogChannel;
import de.audi.atip.phone.ITelService;
import de.audi.remotehmi.IRemoteHMI;
import de.audi.tghu.online.app.AbstractOnlineActivator;
import de.audi.tghu.online.app.Online;
import de.audi.tghu.online.app.remotehmi.OnlineRemoteHMIActivator$1;
import de.audi.tghu.online.app.remotehmi.OnlineRemoteHMIActivator$10;
import de.audi.tghu.online.app.remotehmi.OnlineRemoteHMIActivator$11;
import de.audi.tghu.online.app.remotehmi.OnlineRemoteHMIActivator$12;
import de.audi.tghu.online.app.remotehmi.OnlineRemoteHMIActivator$13;
import de.audi.tghu.online.app.remotehmi.OnlineRemoteHMIActivator$14;
import de.audi.tghu.online.app.remotehmi.OnlineRemoteHMIActivator$15;
import de.audi.tghu.online.app.remotehmi.OnlineRemoteHMIActivator$16;
import de.audi.tghu.online.app.remotehmi.OnlineRemoteHMIActivator$17;
import de.audi.tghu.online.app.remotehmi.OnlineRemoteHMIActivator$18;
import de.audi.tghu.online.app.remotehmi.OnlineRemoteHMIActivator$19;
import de.audi.tghu.online.app.remotehmi.OnlineRemoteHMIActivator$2;
import de.audi.tghu.online.app.remotehmi.OnlineRemoteHMIActivator$20;
import de.audi.tghu.online.app.remotehmi.OnlineRemoteHMIActivator$21;
import de.audi.tghu.online.app.remotehmi.OnlineRemoteHMIActivator$22;
import de.audi.tghu.online.app.remotehmi.OnlineRemoteHMIActivator$23;
import de.audi.tghu.online.app.remotehmi.OnlineRemoteHMIActivator$24;
import de.audi.tghu.online.app.remotehmi.OnlineRemoteHMIActivator$3;
import de.audi.tghu.online.app.remotehmi.OnlineRemoteHMIActivator$4;
import de.audi.tghu.online.app.remotehmi.OnlineRemoteHMIActivator$5;
import de.audi.tghu.online.app.remotehmi.OnlineRemoteHMIActivator$6;
import de.audi.tghu.online.app.remotehmi.OnlineRemoteHMIActivator$7;
import de.audi.tghu.online.app.remotehmi.OnlineRemoteHMIActivator$8;
import de.audi.tghu.online.app.remotehmi.OnlineRemoteHMIActivator$9;
import de.audi.tghu.online.app.remotehmi.RemoteHMIConnectivityChangedService;
import de.audi.tghu.online.app.remotehmi.RemoteHMIConnectivityService;
import de.audi.tghu.online.app.remotehmi.RemoteHMIDataConnectionStateListener;
import de.audi.tghu.online.app.remotehmi.RemoteHMIIFolderBrowsingServiceListener;
import de.audi.tghu.online.app.remotehmi.RemoteHMIPhoneStatusService;
import de.audi.tghu.online.app.remotehmi.RemoteHMISDSStateListener;
import de.audi.tghu.online.app.remotehmi.RemoteHMIService;
import java.util.Dictionary;
import java.util.Hashtable;

public class OnlineRemoteHMIActivator {
    private final LogChannel logChannel;
    private final RemoteHMIService remoteHmiService;
    private RemoteHMIDataConnectionStateListener remoteHmiDataConnectionListener;
    private RemoteHMIConnectivityService remoteHMIConnectivityService;
    private RemoteHMIConnectivityChangedService remoteHMIConnectivityChangedService;
    private RemoteHMIPhoneStatusService remoteHMIPhoneStatusService;
    private RemoteHMISDSStateListener remoteHMISDSStateListener;
    private RemoteHMIIFolderBrowsingServiceListener remotehmiIFolderBrowsingServiceListener;
    static /* synthetic */ Class class$de$audi$remotehmi$IRemoteHMIListener;
    static /* synthetic */ Class class$de$audi$atip$i18n$I18NTarget;
    static /* synthetic */ Class class$de$audi$atip$interapp$tts$TTSListener;
    static /* synthetic */ Class class$de$audi$atip$interapp$OnlineService;
    static /* synthetic */ Class class$de$audi$atip$msg$MsgListener;
    static /* synthetic */ Class class$de$audi$atip$interapp$DataConnectionStateListener;
    static /* synthetic */ Class class$de$audi$atip$interapp$media$IMediaServiceListener;
    static /* synthetic */ Class class$de$audi$atip$interapp$IConnectivityRHMIService;
    static /* synthetic */ Class class$de$audi$atip$interapp$IOnlineConnectivityStateListener;
    static /* synthetic */ Class class$de$audi$atip$interapp$online$IPhoneStateService;
    static /* synthetic */ Class class$de$audi$atip$interapp$messaging$folderbrowsing$IFolderBrowsingServiceListener;
    static /* synthetic */ Class class$de$audi$atip$interapp$audio$VolumeOnOffPressListener;

    public OnlineRemoteHMIActivator(LogChannel logChannel, IFrameworkAccess iFrameworkAccess, RemoteHMIService remoteHMIService) {
        this.logChannel = logChannel;
        this.remoteHmiService = remoteHMIService;
        this.remoteHmiDataConnectionListener = new RemoteHMIDataConnectionStateListener(logChannel, this.remoteHmiService);
        this.remoteHMIConnectivityService = new RemoteHMIConnectivityService(logChannel, this.remoteHmiService);
        this.remoteHMIConnectivityChangedService = new RemoteHMIConnectivityChangedService(logChannel, this.remoteHmiService);
        this.remoteHMIPhoneStatusService = new RemoteHMIPhoneStatusService(logChannel, this.remoteHmiService);
        this.remoteHMISDSStateListener = new RemoteHMISDSStateListener(logChannel, this.remoteHmiService);
        this.remotehmiIFolderBrowsingServiceListener = new RemoteHMIIFolderBrowsingServiceListener(logChannel, this.remoteHmiService);
        Online.getInstance().getOnlineDiag().setRemoteHMIService(this.remoteHmiService);
        this.remoteHmiService.setConnectivityChangedService(this.remoteHMIConnectivityChangedService);
    }

    public void registerProvidedServices(AbstractOnlineActivator abstractOnlineActivator) {
        this.logChannel.log(-2137614336, "OnlineRemoteHMIActivator#registerProvidedServices - register remote HMI listener service");
        abstractOnlineActivator.registerService((class$de$audi$remotehmi$IRemoteHMIListener == null ? (class$de$audi$remotehmi$IRemoteHMIListener = OnlineRemoteHMIActivator.class$("de.audi.remotehmi.IRemoteHMIListener")) : class$de$audi$remotehmi$IRemoteHMIListener).getName(), (Object)this.remoteHmiService, (Dictionary)new Hashtable());
        this.logChannel.log(-2137614336, "OnlineRemoteHMIActivator#registerProvidedServices - register I18N service");
        Hashtable hashtable = new Hashtable();
        hashtable.put("DEVICE_NAME", (class$de$audi$atip$i18n$I18NTarget == null ? (class$de$audi$atip$i18n$I18NTarget = OnlineRemoteHMIActivator.class$("de.audi.atip.i18n.I18NTarget")) : class$de$audi$atip$i18n$I18NTarget).getName());
        hashtable.put("DEVICE_INSTANCE", new Integer(0));
        hashtable.put("LANG_COMPONENT_TYPE", "LANG_COMPONENT_HMI");
        hashtable.put("NOTIFY_BY_REGISTRATION_STRATEGY", "UPDATE_AFTER_REGISTRATION");
        abstractOnlineActivator.registerService((class$de$audi$atip$i18n$I18NTarget == null ? (class$de$audi$atip$i18n$I18NTarget = OnlineRemoteHMIActivator.class$("de.audi.atip.i18n.I18NTarget")) : class$de$audi$atip$i18n$I18NTarget).getName(), (Object)this.remoteHmiService, (Dictionary)hashtable);
        this.logChannel.log(-2137614336, "OnlineRemoteHMIActivator#registerProvidedServices - register TTS listener service");
        hashtable = new Hashtable();
        hashtable.put("DEVICE_NAME", (class$de$audi$atip$interapp$tts$TTSListener == null ? (class$de$audi$atip$interapp$tts$TTSListener = OnlineRemoteHMIActivator.class$("de.audi.atip.interapp.tts.TTSListener")) : class$de$audi$atip$interapp$tts$TTSListener).getName());
        hashtable.put("TTS_CLIENT_ID", TTSService.CLIENT_ID_REMOTE_HMI);
        abstractOnlineActivator.registerService((class$de$audi$atip$interapp$tts$TTSListener == null ? (class$de$audi$atip$interapp$tts$TTSListener = OnlineRemoteHMIActivator.class$("de.audi.atip.interapp.tts.TTSListener")) : class$de$audi$atip$interapp$tts$TTSListener).getName(), (Object)this.remoteHmiService.getTTS(), (Dictionary)hashtable);
        this.logChannel.log(-2137614336, "OnlineRemoteHMIActivator#registerProvidedServices: OnlineService");
        hashtable = new Hashtable();
        hashtable.put("ApplicationName", "AppOnline");
        hashtable.put("moduleID", new Integer(23));
        abstractOnlineActivator.registerService((class$de$audi$atip$interapp$OnlineService == null ? (class$de$audi$atip$interapp$OnlineService = OnlineRemoteHMIActivator.class$("de.audi.atip.interapp.OnlineService")) : class$de$audi$atip$interapp$OnlineService).getName(), (Object)this.remoteHmiService.getOnlineService(), (Dictionary)hashtable);
        this.logChannel.log(-2137614336, "OnlineRemoteHMIActivator#registerProvidedServices: MsgListener");
        hashtable = new Hashtable();
        hashtable.put("ApplicationName", "AppOnline");
        hashtable.put("moduleID", new Integer(23));
        abstractOnlineActivator.registerService((class$de$audi$atip$msg$MsgListener == null ? (class$de$audi$atip$msg$MsgListener = OnlineRemoteHMIActivator.class$("de.audi.atip.msg.MsgListener")) : class$de$audi$atip$msg$MsgListener).getName(), (Object)this.remoteHmiService, (Dictionary)hashtable);
        this.logChannel.log(-2137614336, "OnlineRemoteHMIActivator#registerProvidedServices: DataConnectionStateListener");
        hashtable = new Hashtable();
        hashtable.put("ApplicationName", "AppOnline");
        hashtable.put("moduleID", new Integer(23));
        abstractOnlineActivator.registerService((class$de$audi$atip$interapp$DataConnectionStateListener == null ? (class$de$audi$atip$interapp$DataConnectionStateListener = OnlineRemoteHMIActivator.class$("de.audi.atip.interapp.DataConnectionStateListener")) : class$de$audi$atip$interapp$DataConnectionStateListener).getName(), (Object)this.remoteHmiDataConnectionListener, (Dictionary)hashtable);
        this.logChannel.log(-2137614336, "OnlineRemoteHMIActivator#registerProvidedServices: IMediaServiceListener");
        hashtable = new Hashtable();
        hashtable.put("ApplicationName", "AppOnline");
        hashtable.put("moduleID", new Integer(23));
        abstractOnlineActivator.registerService((class$de$audi$atip$interapp$media$IMediaServiceListener == null ? (class$de$audi$atip$interapp$media$IMediaServiceListener = OnlineRemoteHMIActivator.class$("de.audi.atip.interapp.media.IMediaServiceListener")) : class$de$audi$atip$interapp$media$IMediaServiceListener).getName(), (Object)this.remoteHmiService.getOnlineMediaComponent(), (Dictionary)hashtable);
        this.logChannel.log(-2137614336, "OnlineRemoteHMIActivator#registerProvidedServices: IConnectivityRHMIService");
        hashtable = new Hashtable();
        hashtable.put("ApplicationName", "AppOnline");
        hashtable.put("moduleID", new Integer(23));
        abstractOnlineActivator.registerService((class$de$audi$atip$interapp$IConnectivityRHMIService == null ? (class$de$audi$atip$interapp$IConnectivityRHMIService = OnlineRemoteHMIActivator.class$("de.audi.atip.interapp.IConnectivityRHMIService")) : class$de$audi$atip$interapp$IConnectivityRHMIService).getName(), (Object)this.remoteHMIConnectivityService, (Dictionary)hashtable);
        this.logChannel.log(-2137614336, "OnlineRemoteHMIActivator#registerProvidedServices: IOnlineConnectivityStateListener");
        hashtable = new Hashtable();
        hashtable.put("ApplicationName", "AppOnline");
        hashtable.put("moduleID", new Integer(23));
        abstractOnlineActivator.registerService((class$de$audi$atip$interapp$IOnlineConnectivityStateListener == null ? (class$de$audi$atip$interapp$IOnlineConnectivityStateListener = OnlineRemoteHMIActivator.class$("de.audi.atip.interapp.IOnlineConnectivityStateListener")) : class$de$audi$atip$interapp$IOnlineConnectivityStateListener).getName(), (Object)this.remoteHMIConnectivityChangedService, (Dictionary)hashtable);
        this.logChannel.log(-2137614336, "OnlineRemoteHMIActivator#registerProvidedServices: IPhoneStateService");
        hashtable = new Hashtable();
        hashtable.put("ApplicationName", "AppOnline");
        hashtable.put("moduleID", new Integer(23));
        abstractOnlineActivator.registerService((class$de$audi$atip$interapp$online$IPhoneStateService == null ? (class$de$audi$atip$interapp$online$IPhoneStateService = OnlineRemoteHMIActivator.class$("de.audi.atip.interapp.online.IPhoneStateService")) : class$de$audi$atip$interapp$online$IPhoneStateService).getName(), (Object)this.remoteHMIPhoneStatusService, (Dictionary)hashtable);
        this.logChannel.log(-2137614336, "OnlineRemoteHMIActivator#registerProvidedServices: IFolderBrowsingServiceListener");
        hashtable = new Hashtable();
        hashtable.put("ApplicationName", "AppOnline");
        hashtable.put("moduleID", new Integer(23));
        abstractOnlineActivator.registerService((class$de$audi$atip$interapp$messaging$folderbrowsing$IFolderBrowsingServiceListener == null ? (class$de$audi$atip$interapp$messaging$folderbrowsing$IFolderBrowsingServiceListener = OnlineRemoteHMIActivator.class$("de.audi.atip.interapp.messaging.folderbrowsing.IFolderBrowsingServiceListener")) : class$de$audi$atip$interapp$messaging$folderbrowsing$IFolderBrowsingServiceListener).getName(), (Object)this.remotehmiIFolderBrowsingServiceListener, (Dictionary)hashtable);
        if (this.remoteHmiService.getVolumeListener() != null) {
            this.logChannel.log(-2137614336, "OnlineRemoteHMIActivator#registerProvidedServices: VolumeOnOffPressListener");
            hashtable = new Hashtable();
            hashtable.put("ApplicationName", "AppOnline");
            hashtable.put("moduleID", new Integer(23));
            abstractOnlineActivator.registerService((class$de$audi$atip$interapp$audio$VolumeOnOffPressListener == null ? (class$de$audi$atip$interapp$audio$VolumeOnOffPressListener = OnlineRemoteHMIActivator.class$("de.audi.atip.interapp.audio.VolumeOnOffPressListener")) : class$de$audi$atip$interapp$audio$VolumeOnOffPressListener).getName(), (Object)this.remoteHmiService.getVolumeListener(), (Dictionary)hashtable);
        }
    }

    public void setFolderBrowsingService(IFolderBrowsingService iFolderBrowsingService) {
        this.logChannel.log(-2137614336, "OnlineRemoteHMIActivator#addIFolderBrowsingService - Got registered reference of IFolderBrowsingService");
        this.remoteHmiService.execute(new OnlineRemoteHMIActivator$1(this, "activator-set-messaging-service", iFolderBrowsingService));
    }

    public RemoteHMIService getRemoteHMIService() {
        return this.remoteHmiService;
    }

    public void setOnlinePOICall(OnlinePOICall onlinePOICall) {
        this.logChannel.log(-2137614336, "OnlineRemoteHMIActivator#addOnlineOperatorCallService: called");
        this.remoteHmiService.execute(new OnlineRemoteHMIActivator$2(this, "activator-set-operatorcall-service", onlinePOICall));
    }

    public void setRemoteHmi(IRemoteHMI iRemoteHMI) {
        this.remoteHmiService.execute(new OnlineRemoteHMIActivator$3(this, "activator-add-iremotehmi", iRemoteHMI));
    }

    public void setBrowserHandler(IBrowserHandler iBrowserHandler, Integer n) {
        if (IBrowserHandler.DEVICEINSTANCE_DSIBROWSER_REMOTEHMI.equals(n)) {
            this.logChannel.log(-2137614336, "OnlineRemoteHMIActivator#addBrowserHandler - receiving browser handler");
            this.remoteHmiService.execute(new OnlineRemoteHMIActivator$4(this, "activator-add-browser-handler", iBrowserHandler));
        } else if (IBrowserHandler.DEVICEINSTANCE_DSIBROWSER_REMOTEHMI_FULLSCREEN.equals(n)) {
            this.logChannel.log(-2137614336, "OnlineRemoteHMIActivator#addBrowserHandler - receiving browser handler fullscreen; using BOS instance");
            this.remoteHmiService.execute(new OnlineRemoteHMIActivator$5(this, "activator-add-fullscreen-browser-handler", iBrowserHandler));
        }
    }

    public void setTtsService(TTSSessionBasedService tTSSessionBasedService) {
        this.remoteHmiService.execute(new OnlineRemoteHMIActivator$6(this, "activator-set-tts-service", tTSSessionBasedService));
    }

    public void setSDSOnlineServiceListener(OnlineServiceListener onlineServiceListener) {
        this.remoteHmiService.execute(new OnlineRemoteHMIActivator$7(this, "activator-set-sds-online-service-listener", onlineServiceListener));
    }

    public void setConnectivityStateListener(IConnectivityRHMIStateListener iConnectivityRHMIStateListener) {
        this.remoteHmiService.execute(new OnlineRemoteHMIActivator$8(this, "activator-set-connectivity-state-listener", iConnectivityRHMIStateListener));
    }

    public void setConnectivityOnlineStateListener(IConnectivityOnlineStateListener iConnectivityOnlineStateListener) {
        this.remoteHmiService.execute(new OnlineRemoteHMIActivator$9(this, "activator-set-online-connectivity-state-listener", iConnectivityOnlineStateListener));
    }

    public void setNaviService(NaviService naviService) {
        this.remoteHmiService.execute(new OnlineRemoteHMIActivator$10(this, "activator-set-navi-service", naviService));
    }

    public void setNaviFormattingService(INaviFormattingService iNaviFormattingService) {
        this.remoteHmiService.execute(new OnlineRemoteHMIActivator$11(this, "activator-set-navi-formatting-service", iNaviFormattingService));
    }

    public void setNaviAdbService(NaviADBService naviADBService) {
        this.remoteHmiService.execute(new OnlineRemoteHMIActivator$12(this, "activator-set-navi-adb-service", naviADBService));
    }

    public void setOnlineMediaService(IMediaOnlinePlayerService iMediaOnlinePlayerService) {
        this.remoteHmiService.execute(new OnlineRemoteHMIActivator$13(this, "activator-set-online-media-service", iMediaOnlinePlayerService));
    }

    public void setMediaService(IMediaService iMediaService) {
        this.remoteHmiService.execute(new OnlineRemoteHMIActivator$14(this, "activator-set-media-service", iMediaService));
    }

    public void setRemoteHMIMediaOnlineServiceListener(IRemoteHMIMediaOnlineServiceListener iRemoteHMIMediaOnlineServiceListener) {
        this.remoteHmiService.execute(new OnlineRemoteHMIActivator$15(this, "activator-set-media-online-service-listener", iRemoteHMIMediaOnlineServiceListener));
    }

    public void setMediaDrawerContext(IMediaDrawerContext iMediaDrawerContext) {
        this.logChannel.log(-2137614336, "OnlineRemoteHMIActivator#addDrawerContextHandler - Got registered reference of IMediaDrawerContext");
        this.remoteHmiService.execute(new OnlineRemoteHMIActivator$16(this, "activator-set-media-drawer-context", iMediaDrawerContext));
    }

    public void setRemoteHMIEsimLicenseListener(IRemoteHMIEsimLicenseListener iRemoteHMIEsimLicenseListener) {
        this.logChannel.log(-2137614336, "OnlineRemoteHMIActivator#addRemoteHMIESimLicense - Got registered reference of IRemoteHMILicenseEsim");
        this.remoteHmiService.execute(new OnlineRemoteHMIActivator$17(this, "activator-set-esim-license-listener", iRemoteHMIEsimLicenseListener));
    }

    public void setOnlineHMIService(OnlineHMIService onlineHMIService) {
        this.remoteHmiService.execute(new OnlineRemoteHMIActivator$18(this, "activator-set-online-hmi-service", onlineHMIService));
    }

    public void setPortalAuthenticationService(PortalAuthenticationService portalAuthenticationService) {
        this.remoteHmiService.execute(new OnlineRemoteHMIActivator$19(this, "activator-set-authentication-service", portalAuthenticationService));
    }

    public void setPreviewMap(IPreviewMap iPreviewMap) {
        this.remoteHmiService.execute(new OnlineRemoteHMIActivator$20(this, "activator-set-navi-preview-map", iPreviewMap));
    }

    public void setMapService(MapService mapService) {
        this.remoteHmiService.execute(new OnlineRemoteHMIActivator$21(this, "activator-set-navi-map-service", mapService));
    }

    public void setTelService(ITelService iTelService) {
        this.remoteHmiService.execute(new OnlineRemoteHMIActivator$22(this, "activator-set-navi-itel-service", iTelService));
    }

    public void setOnlineMessagingService(IMessagingOnlineService iMessagingOnlineService) {
        if (this.remoteHmiService != null) {
            this.remoteHmiService.execute(new OnlineRemoteHMIActivator$23(this, "activator-set-online-messaging-service", iMessagingOnlineService));
        }
    }

    public void setSdsService(SDSService sDSService) {
        if (this.remoteHmiService != null) {
            this.remoteHmiService.execute(new OnlineRemoteHMIActivator$24(this, "activator-set-sds-service", sDSService));
        }
    }

    static /* synthetic */ Class class$(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new NoClassDefFoundError().initCause(classNotFoundException);
        }
    }

    static /* synthetic */ RemoteHMIService access$000(OnlineRemoteHMIActivator onlineRemoteHMIActivator) {
        return onlineRemoteHMIActivator.remoteHmiService;
    }

    static /* synthetic */ RemoteHMISDSStateListener access$100(OnlineRemoteHMIActivator onlineRemoteHMIActivator) {
        return onlineRemoteHMIActivator.remoteHMISDSStateListener;
    }
}

