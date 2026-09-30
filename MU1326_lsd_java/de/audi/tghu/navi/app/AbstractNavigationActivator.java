/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app;

import de.audi.atip.activator.AbstractActivator;
import de.audi.atip.audio.HMIAudioService;
import de.audi.atip.base.IFrameworkAccess;
import de.audi.atip.browser.IBrowserHandler;
import de.audi.atip.diag.sw.AbstractSwDiagnosis;
import de.audi.atip.diag.sw.SwDiagnosisManager;
import de.audi.atip.interapp.ADBHMIAppService;
import de.audi.atip.interapp.ADBRemoteHMIService;
import de.audi.atip.interapp.IConnectivityNaviStateListener;
import de.audi.atip.interapp.MapServiceListener;
import de.audi.atip.interapp.NaviCruiseModeServiceListener;
import de.audi.atip.interapp.NaviSDSPOIOnlineServiceListener;
import de.audi.atip.interapp.PhoneService;
import de.audi.atip.interapp.audio.IAnnouncementStateListener;
import de.audi.atip.interapp.audio.IAnnouncementStateService;
import de.audi.atip.interapp.car.AudiEnergyAssistService;
import de.audi.atip.interapp.combi.bap.navi.CombiBAPServiceNavi;
import de.audi.atip.interapp.combi.ddp2.CombiService;
import de.audi.atip.interapp.icon.RenderingInfoProvider;
import de.audi.atip.interapp.navcar.CarNavListener;
import de.audi.atip.interapp.navcar.ILGIServiceListener;
import de.audi.atip.interapp.navtmc.TMCService;
import de.audi.atip.interapp.navuota.UotaNavListener;
import de.audi.atip.interapp.online.IOnlineDestinationService;
import de.audi.atip.interapp.online.IOnlineService;
import de.audi.atip.interapp.online.IOperatorCallNaviService;
import de.audi.atip.interapp.online.OnlineServiceProvider;
import de.audi.atip.interapp.picnav.INaviPicNavService;
import de.audi.atip.interapp.picturestore.PictureStoreProvider;
import de.audi.atip.log.LogChannel;
import de.audi.atip.mmicombi.IViewSizeManager;
import de.audi.atip.rse.AbstractRSEConnection;
import de.audi.atip.variant.IGUIVariantProvider;
import de.audi.tghu.navi.app.Navigation;
import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.NavigationInfoProvider;
import de.audi.tghu.navi.app.adb.NaviADBHandler;
import de.audi.tghu.navi.app.asia.warning.AsiaWarningsStateSetupListener;
import de.audi.tghu.navi.app.audio.INaviAudioHandler;
import de.audi.tghu.navi.app.car.DSIGeneralVehicleStatesController;
import de.audi.tghu.navi.app.car.kombi.DSICarKombiController;
import de.audi.tghu.navi.app.dsi.DSINavigationManager;
import de.audi.tghu.navi.app.map.handler.GoogleMapLicenseHandler;
import de.audi.tghu.navi.app.map.handler.LGIInterAppServiceHandler;
import de.audi.tghu.navi.app.sdis.INaviTabletServiceListener;
import de.audi.tghu.navi.app.util.Util;
import de.audi.tghu.waveplayer.WavePlayer;
import java.util.ArrayList;
import java.util.Dictionary;
import java.util.Hashtable;
import org.dsi.ifc.base.IAdapterManager;
import org.dsi.ifc.komogfxstreamsink.DSIKOMOGfxStreamSink;
import org.dsi.ifc.komonavinfo.DSIKOMONavInfo;
import org.dsi.ifc.komoview.DSIKOMOView;
import org.dsi.ifc.map.DSIMapViewerControl;
import org.dsi.ifc.map.DSIMapViewerGoogleCtrl;
import org.dsi.ifc.map.DSIMapViewerManeuverView;
import org.dsi.ifc.map.DSIMapViewerZoomEngine;
import org.dsi.ifc.mobilityhorizon.DSIMobilityHorizon;
import org.dsi.ifc.navigation.DSIBlocking;
import org.dsi.ifc.navigation.DSICombinedRouteList;
import org.dsi.ifc.navigation.DSINavigation;
import org.dsi.ifc.online.DSIPoiOnlineSearch;
import org.dsi.ifc.organizer.DSIAdbEdit;
import org.dsi.ifc.organizer.DSIAdbList;
import org.dsi.ifc.organizer.DSIAdbSetup;
import org.dsi.ifc.organizer.DSIAdbUserProfile;
import org.dsi.ifc.tmc.DSITmcOnRoute;
import org.dsi.ifc.trafficregulation.DSITrafficRegulation;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;
import org.osgi.framework.ServiceRegistration;
import org.osgi.util.tracker.ServiceTracker;
import org.osgi.util.tracker.ServiceTrackerCustomizer;

public abstract class AbstractNavigationActivator
extends AbstractActivator
implements BundleActivator,
ServiceTrackerCustomizer,
IGUIVariantProvider {
    private boolean delayedServicesStarted = false;
    protected LogChannel logChannel;
    private ServiceTracker serviceTracker;
    protected Navigation navigation;
    protected DSICarKombiController dsiCarKombiController;
    protected DSIGeneralVehicleStatesController dsiGeneralVehicleStatesController;
    protected SwDiagnosisManager swDiagnosisManager;
    public static final Integer DEV_INST_DSINAV_MAIN = new Integer(0);
    public static final Integer DEVICEINSTANCE_DSINAVIGATION_REMOTE = new Integer(1);
    public static final Integer DEVICEINSTANCE_DSIMAPCTRL_DEFAULT = new Integer(0);
    public static final Integer DEVICEINSTANCE_DSIMAPCTRL_GOOGLE = new Integer(1);
    public static final Integer DEVICEINSTANCE_DSIMAPCTRL_MAP_IN_MAP = new Integer(2);
    public static final Integer DEVICEINSTANCE_DSIMAPCTRL_KOMBI = new Integer(3);
    public static final Integer DEVICEINSTANCE_DSIMAPCTRL_GOOGLE2 = new Integer(4);
    ServiceRegistration sregI18NTarget;
    private ServiceReference serviceReferenceDSINavigationMain;
    private ServiceReference serviceReferenceDSINavigationRemote;
    private ServiceReference[] serviceReferenceDSIMapControl = new ServiceReference[5];
    private ServiceReference[] serviceReferenceBrowserHandler = new ServiceReference[8];
    private volatile boolean isServiceDeregistrationAllowed = true;
    static /* synthetic */ Class class$org$dsi$ifc$base$DSIListener;
    static /* synthetic */ Class class$org$dsi$ifc$navigation$DSINavigationListener;
    static /* synthetic */ Class class$org$dsi$ifc$navigation$DSIBlockingListener;
    static /* synthetic */ Class class$org$dsi$ifc$navigation$DSICombinedRouteListListener;
    static /* synthetic */ Class class$org$dsi$ifc$map$DSIMapViewerControlListener;
    static /* synthetic */ Class class$org$dsi$ifc$map$DSIMapViewerGoogleCtrlListener;
    static /* synthetic */ Class class$org$dsi$ifc$map$DSIMapViewerZoomEngineListener;
    static /* synthetic */ Class class$org$dsi$ifc$map$DSIMapViewerManeuverViewListener;
    static /* synthetic */ Class class$org$dsi$ifc$tmc$DSITmcOnRouteListener;
    static /* synthetic */ Class class$org$dsi$ifc$organizer$DSIAdbEditListener;
    static /* synthetic */ Class class$org$dsi$ifc$organizer$DSIAdbListListener;
    static /* synthetic */ Class class$org$dsi$ifc$organizer$DSIAdbUserProfileListener;
    static /* synthetic */ Class class$org$dsi$ifc$organizer$DSIAdbSetupListener;
    static /* synthetic */ Class class$org$dsi$ifc$online$DSIPoiOnlineSearchListener;
    static /* synthetic */ Class class$org$dsi$ifc$komoview$DSIKOMOViewListener;
    static /* synthetic */ Class class$org$dsi$ifc$komonavinfo$DSIKOMONavInfoListener;
    static /* synthetic */ Class class$org$dsi$ifc$komogfxstreamsink$DSIKOMOGfxStreamSinkListener;
    static /* synthetic */ Class class$org$dsi$ifc$trafficregulation$DSITrafficRegulationListener;
    static /* synthetic */ Class class$org$dsi$ifc$mobilityhorizon$DSIMobilityHorizonListener;
    static /* synthetic */ Class class$de$audi$atip$i18n$I18NTarget;
    static /* synthetic */ Class class$de$audi$atip$hmi$HMIApplication;
    static /* synthetic */ Class class$de$audi$atip$power$PowerEventListener;
    static /* synthetic */ Class class$de$audi$atip$interapp$MapService;
    static /* synthetic */ Class class$de$audi$atip$interapp$maptmc$MapTmcService;
    static /* synthetic */ Class class$de$audi$atip$interapp$navigation$previewmap$IPreviewMap;
    static /* synthetic */ Class class$de$audi$atip$interapp$NaviService;
    static /* synthetic */ Class class$de$audi$atip$interapp$NaviADBService;
    static /* synthetic */ Class class$de$audi$atip$msg$MsgListener;
    static /* synthetic */ Class class$de$esolutions$fw$util$commons$error$DumpInfoProvider;
    static /* synthetic */ Class class$de$audi$atip$interapp$combi$bap$navi$CombiBAPServiceNaviListener;
    static /* synthetic */ Class class$de$audi$atip$audio$HMIAudioServiceListener;
    static /* synthetic */ Class class$de$audi$atip$interapp$picnav$IPicNavNaviService;
    static /* synthetic */ Class class$de$audi$tghu$navi$app$sdis$INaviTabletService;
    static /* synthetic */ Class class$de$audi$atip$interapp$INaviConnectivityStateListener;
    static /* synthetic */ Class class$de$audi$atip$preset$IAppPresetDefinitionHandler;
    static /* synthetic */ Class class$de$audi$atip$preset$IAppPresetExecutionHandler;
    static /* synthetic */ Class class$de$audi$atip$interapp$terminalmode$ITerminalModeUpdateListener;
    static /* synthetic */ Class class$de$audi$atip$interapp$audio$IAnnouncementStateService;
    static /* synthetic */ Class class$de$audi$atip$interapp$INaviFormattingService;
    static /* synthetic */ Class class$org$dsi$ifc$iconhandling$DSIIconExtractor;
    static /* synthetic */ Class class$org$dsi$ifc$navigation$DSINavigation;
    static /* synthetic */ Class class$org$dsi$ifc$navigation$DSIBlocking;
    static /* synthetic */ Class class$org$dsi$ifc$navigation$DSICombinedRouteList;
    static /* synthetic */ Class class$org$dsi$ifc$trafficregulation$DSITrafficRegulation;
    static /* synthetic */ Class class$org$dsi$ifc$map$DSIMapViewerControl;
    static /* synthetic */ Class class$org$dsi$ifc$map$DSIMapViewerZoomEngine;
    static /* synthetic */ Class class$org$dsi$ifc$map$DSIMapViewerManeuverView;
    static /* synthetic */ Class class$org$dsi$ifc$komoview$DSIKOMOView;
    static /* synthetic */ Class class$org$dsi$ifc$komonavinfo$DSIKOMONavInfo;
    static /* synthetic */ Class class$org$dsi$ifc$komogfxstreamsink$DSIKOMOGfxStreamSink;
    static /* synthetic */ Class class$org$dsi$ifc$mobilityhorizon$DSIMobilityHorizon;
    static /* synthetic */ Class class$org$dsi$ifc$generalvehiclestates$DSIGeneralVehicleStates;
    static /* synthetic */ Class class$org$dsi$ifc$tmc$DSITmcOnRoute;
    static /* synthetic */ Class class$de$audi$atip$interapp$online$OnlineServiceProvider;
    static /* synthetic */ Class class$org$dsi$ifc$organizer$DSIAdbEdit;
    static /* synthetic */ Class class$org$dsi$ifc$organizer$DSIAdbList;
    static /* synthetic */ Class class$org$dsi$ifc$organizer$DSIAdbUserProfile;
    static /* synthetic */ Class class$org$dsi$ifc$organizer$DSIAdbSetup;
    static /* synthetic */ Class class$de$audi$atip$interapp$ADBHMIAppService;
    static /* synthetic */ Class class$de$audi$atip$interapp$PhoneService;
    static /* synthetic */ Class class$de$audi$atip$audio$HMIAudioService;
    static /* synthetic */ Class class$de$audi$atip$interapp$navtmc$TMCService;
    static /* synthetic */ Class class$de$audi$atip$interapp$icon$RenderingInfoProvider;
    static /* synthetic */ Class class$de$audi$atip$interapp$combi$ddp2$CombiService;
    static /* synthetic */ Class class$de$audi$atip$interapp$combi$bap$navi$CombiBAPServiceNavi;
    static /* synthetic */ Class class$de$audi$atip$diag$sw$SwDiagnosisManager;
    static /* synthetic */ Class class$org$dsi$ifc$base$IAdapterManager;
    static /* synthetic */ Class class$de$audi$atip$interapp$navcar$CarNavListener;
    static /* synthetic */ Class class$de$audi$atip$interapp$navuota$UotaNavListener;
    static /* synthetic */ Class class$de$audi$tghu$navi$app$sdis$INaviTabletServiceListener;
    static /* synthetic */ Class class$de$audi$atip$interapp$online$IOnlineDestinationService;
    static /* synthetic */ Class class$de$audi$atip$interapp$ADBRemoteHMIService;
    static /* synthetic */ Class class$de$audi$atip$interapp$NaviCruiseModeServiceListener;
    static /* synthetic */ Class class$de$audi$atip$mmicombi$IViewSizeManager;
    static /* synthetic */ Class class$org$dsi$ifc$map$DSIMapViewerGoogleCtrl;
    static /* synthetic */ Class class$de$audi$atip$browser$IBrowserHandler;
    static /* synthetic */ Class class$org$dsi$ifc$online$DSIPoiOnlineSearch;
    static /* synthetic */ Class class$de$audi$atip$rse$AbstractRSEConnection;
    static /* synthetic */ Class class$de$audi$atip$interapp$NaviSDSPOIOnlineServiceListener;
    static /* synthetic */ Class class$de$audi$atip$interapp$picnav$INaviPicNavService;
    static /* synthetic */ Class class$de$audi$atip$interapp$online$IOnlineService;
    static /* synthetic */ Class class$org$dsi$ifc$carkombi$DSICarKombi;
    static /* synthetic */ Class class$de$audi$tghu$waveplayer$WavePlayer;
    static /* synthetic */ Class class$de$audi$atip$interapp$IConnectivityNaviStateListener;
    static /* synthetic */ Class class$de$audi$atip$interapp$MapServiceListener;
    static /* synthetic */ Class class$de$audi$atip$interapp$car$AudiEnergyAssistService;
    static /* synthetic */ Class class$de$audi$atip$interapp$online$IOperatorCallNaviService;
    static /* synthetic */ Class class$de$audi$atip$interapp$audio$IAnnouncementStateListener;
    static /* synthetic */ Class class$de$audi$atip$interapp$navcar$ILGIServiceListener;
    static /* synthetic */ Class class$de$audi$atip$interapp$picturestore$PictureStoreProvider;
    static /* synthetic */ Class class$de$audi$atip$interapp$NaviMyAudiImport;

    protected void registerDSIListeners(Navigation navigation, NavigationEnv navigationEnv) {
        String string = (class$org$dsi$ifc$base$DSIListener == null ? (class$org$dsi$ifc$base$DSIListener = AbstractNavigationActivator.class$("org.dsi.ifc.base.DSIListener")) : class$org$dsi$ifc$base$DSIListener).getName();
        DSINavigationManager dSINavigationManager = navigation.getDsiNavigationManager();
        this.registerDSIListener(string, dSINavigationManager.getDispatcher(0), (class$org$dsi$ifc$navigation$DSINavigationListener == null ? (class$org$dsi$ifc$navigation$DSINavigationListener = AbstractNavigationActivator.class$("org.dsi.ifc.navigation.DSINavigationListener")) : class$org$dsi$ifc$navigation$DSINavigationListener).getName(), 0);
        this.registerDSIListener(string, dSINavigationManager.getDispatcher(0), (class$org$dsi$ifc$navigation$DSIBlockingListener == null ? (class$org$dsi$ifc$navigation$DSIBlockingListener = AbstractNavigationActivator.class$("org.dsi.ifc.navigation.DSIBlockingListener")) : class$org$dsi$ifc$navigation$DSIBlockingListener).getName(), 0);
        this.registerDSIListener(string, dSINavigationManager.getDispatcher(0), (class$org$dsi$ifc$navigation$DSICombinedRouteListListener == null ? (class$org$dsi$ifc$navigation$DSICombinedRouteListListener = AbstractNavigationActivator.class$("org.dsi.ifc.navigation.DSICombinedRouteListListener")) : class$org$dsi$ifc$navigation$DSICombinedRouteListListener).getName(), 0);
        if (!this.framework.isFrontMU()) {
            this.registerDSIListener(string, dSINavigationManager.getDispatcher(1), (class$org$dsi$ifc$navigation$DSINavigationListener == null ? (class$org$dsi$ifc$navigation$DSINavigationListener = AbstractNavigationActivator.class$("org.dsi.ifc.navigation.DSINavigationListener")) : class$org$dsi$ifc$navigation$DSINavigationListener).getName(), 1);
            this.registerDSIListener(string, dSINavigationManager.getDispatcher(1), (class$org$dsi$ifc$navigation$DSIBlockingListener == null ? (class$org$dsi$ifc$navigation$DSIBlockingListener = AbstractNavigationActivator.class$("org.dsi.ifc.navigation.DSIBlockingListener")) : class$org$dsi$ifc$navigation$DSIBlockingListener).getName(), 1);
            this.registerDSIListener(string, dSINavigationManager.getDispatcher(1), (class$org$dsi$ifc$navigation$DSICombinedRouteListListener == null ? (class$org$dsi$ifc$navigation$DSICombinedRouteListListener = AbstractNavigationActivator.class$("org.dsi.ifc.navigation.DSICombinedRouteListListener")) : class$org$dsi$ifc$navigation$DSICombinedRouteListListener).getName(), 1);
        }
        this.registerDSIListener(string, navigation.getMapInterface().getDSIMapControlListener(DEVICEINSTANCE_DSIMAPCTRL_DEFAULT), (class$org$dsi$ifc$map$DSIMapViewerControlListener == null ? (class$org$dsi$ifc$map$DSIMapViewerControlListener = AbstractNavigationActivator.class$("org.dsi.ifc.map.DSIMapViewerControlListener")) : class$org$dsi$ifc$map$DSIMapViewerControlListener).getName(), DEVICEINSTANCE_DSIMAPCTRL_DEFAULT);
        if (Util.isClusterMapAvailable(navigationEnv.getFramework())) {
            this.registerDSIListener(string, navigation.getMapInterface().getDSIMapControlListener(DEVICEINSTANCE_DSIMAPCTRL_KOMBI), (class$org$dsi$ifc$map$DSIMapViewerControlListener == null ? (class$org$dsi$ifc$map$DSIMapViewerControlListener = AbstractNavigationActivator.class$("org.dsi.ifc.map.DSIMapViewerControlListener")) : class$org$dsi$ifc$map$DSIMapViewerControlListener).getName(), DEVICEINSTANCE_DSIMAPCTRL_KOMBI);
            if (Util.isGoogleEarthPresent(navigationEnv.getFramework())) {
                this.registerDSIListener(string, navigation.getMapInterface().getDSIMapControlListener(DEVICEINSTANCE_DSIMAPCTRL_GOOGLE2), (class$org$dsi$ifc$map$DSIMapViewerControlListener == null ? (class$org$dsi$ifc$map$DSIMapViewerControlListener = AbstractNavigationActivator.class$("org.dsi.ifc.map.DSIMapViewerControlListener")) : class$org$dsi$ifc$map$DSIMapViewerControlListener).getName(), DEVICEINSTANCE_DSIMAPCTRL_GOOGLE2);
                this.registerDSIListener(string, navigation.getMapInterface().getDSIMapGoogleCtrlListener(1), (class$org$dsi$ifc$map$DSIMapViewerGoogleCtrlListener == null ? (class$org$dsi$ifc$map$DSIMapViewerGoogleCtrlListener = AbstractNavigationActivator.class$("org.dsi.ifc.map.DSIMapViewerGoogleCtrlListener")) : class$org$dsi$ifc$map$DSIMapViewerGoogleCtrlListener).getName(), 1);
            }
            this.registerDSIListener(string, navigation.getMapInterface().getDSIMapZoomEngineListener(1), (class$org$dsi$ifc$map$DSIMapViewerZoomEngineListener == null ? (class$org$dsi$ifc$map$DSIMapViewerZoomEngineListener = AbstractNavigationActivator.class$("org.dsi.ifc.map.DSIMapViewerZoomEngineListener")) : class$org$dsi$ifc$map$DSIMapViewerZoomEngineListener).getName(), 1);
        }
        if (Util.isGoogleEarthPresent(navigationEnv.getFramework())) {
            this.registerDSIListener(string, navigation.getMapInterface().getDSIMapControlListener(DEVICEINSTANCE_DSIMAPCTRL_GOOGLE), (class$org$dsi$ifc$map$DSIMapViewerControlListener == null ? (class$org$dsi$ifc$map$DSIMapViewerControlListener = AbstractNavigationActivator.class$("org.dsi.ifc.map.DSIMapViewerControlListener")) : class$org$dsi$ifc$map$DSIMapViewerControlListener).getName(), DEVICEINSTANCE_DSIMAPCTRL_GOOGLE);
            this.registerDSIListener(string, navigation.getMapInterface().getDSIMapGoogleCtrlListener(0), (class$org$dsi$ifc$map$DSIMapViewerGoogleCtrlListener == null ? (class$org$dsi$ifc$map$DSIMapViewerGoogleCtrlListener = AbstractNavigationActivator.class$("org.dsi.ifc.map.DSIMapViewerGoogleCtrlListener")) : class$org$dsi$ifc$map$DSIMapViewerGoogleCtrlListener).getName(), 0);
        }
        if (Util.isMapInMapAvailable(navigationEnv.getFramework())) {
            this.registerDSIListener(string, navigation.getMapInterface().getDSIMapControlListener(DEVICEINSTANCE_DSIMAPCTRL_MAP_IN_MAP), (class$org$dsi$ifc$map$DSIMapViewerControlListener == null ? (class$org$dsi$ifc$map$DSIMapViewerControlListener = AbstractNavigationActivator.class$("org.dsi.ifc.map.DSIMapViewerControlListener")) : class$org$dsi$ifc$map$DSIMapViewerControlListener).getName(), DEVICEINSTANCE_DSIMAPCTRL_MAP_IN_MAP);
        }
        this.registerDSIListener(string, navigation.getMapInterface().getDSIMapZoomEngineListener(0), (class$org$dsi$ifc$map$DSIMapViewerZoomEngineListener == null ? (class$org$dsi$ifc$map$DSIMapViewerZoomEngineListener = AbstractNavigationActivator.class$("org.dsi.ifc.map.DSIMapViewerZoomEngineListener")) : class$org$dsi$ifc$map$DSIMapViewerZoomEngineListener).getName(), 0);
        this.registerDSIListener(string, navigation.getMapInterface().getDSIMapManeuverViewListener(), (class$org$dsi$ifc$map$DSIMapViewerManeuverViewListener == null ? (class$org$dsi$ifc$map$DSIMapViewerManeuverViewListener = AbstractNavigationActivator.class$("org.dsi.ifc.map.DSIMapViewerManeuverViewListener")) : class$org$dsi$ifc$map$DSIMapViewerManeuverViewListener).getName(), 0);
        this.registerDSIListener(string, navigation.getTmcOnRouteService(), (class$org$dsi$ifc$tmc$DSITmcOnRouteListener == null ? (class$org$dsi$ifc$tmc$DSITmcOnRouteListener = AbstractNavigationActivator.class$("org.dsi.ifc.tmc.DSITmcOnRouteListener")) : class$org$dsi$ifc$tmc$DSITmcOnRouteListener).getName(), 0);
        if (this.framework.isFrontMU()) {
            this.registerDSIListener(string, navigation.getNaviADBHandler().getADBDSIListener(), (class$org$dsi$ifc$organizer$DSIAdbEditListener == null ? (class$org$dsi$ifc$organizer$DSIAdbEditListener = AbstractNavigationActivator.class$("org.dsi.ifc.organizer.DSIAdbEditListener")) : class$org$dsi$ifc$organizer$DSIAdbEditListener).getName(), 2);
            this.registerDSIListener(string, navigation.getNaviADBHandler().getADBDSIListener(), (class$org$dsi$ifc$organizer$DSIAdbListListener == null ? (class$org$dsi$ifc$organizer$DSIAdbListListener = AbstractNavigationActivator.class$("org.dsi.ifc.organizer.DSIAdbListListener")) : class$org$dsi$ifc$organizer$DSIAdbListListener).getName(), 2);
            this.registerDSIListener(string, navigation.getNaviADBHandler().getADBDSIListener(), (class$org$dsi$ifc$organizer$DSIAdbUserProfileListener == null ? (class$org$dsi$ifc$organizer$DSIAdbUserProfileListener = AbstractNavigationActivator.class$("org.dsi.ifc.organizer.DSIAdbUserProfileListener")) : class$org$dsi$ifc$organizer$DSIAdbUserProfileListener).getName(), 2);
            this.registerDSIListener(string, navigation.getNaviADBHandler().getADBDSIListener(), (class$org$dsi$ifc$organizer$DSIAdbSetupListener == null ? (class$org$dsi$ifc$organizer$DSIAdbSetupListener = AbstractNavigationActivator.class$("org.dsi.ifc.organizer.DSIAdbSetupListener")) : class$org$dsi$ifc$organizer$DSIAdbSetupListener).getName(), 2);
        }
        if (this.framework.isFrontMU()) {
            this.registerDSIListener(string, navigation.getDSIOnlineSearchListener(), (class$org$dsi$ifc$online$DSIPoiOnlineSearchListener == null ? (class$org$dsi$ifc$online$DSIPoiOnlineSearchListener = AbstractNavigationActivator.class$("org.dsi.ifc.online.DSIPoiOnlineSearchListener")) : class$org$dsi$ifc$online$DSIPoiOnlineSearchListener).getName(), 0);
        }
        if (Util.isClusterKDKAvailable(navigationEnv.getFramework())) {
            this.registerDSIListener(string, navigation.getClusterService().getKomoService(), (class$org$dsi$ifc$komoview$DSIKOMOViewListener == null ? (class$org$dsi$ifc$komoview$DSIKOMOViewListener = AbstractNavigationActivator.class$("org.dsi.ifc.komoview.DSIKOMOViewListener")) : class$org$dsi$ifc$komoview$DSIKOMOViewListener).getName(), 0);
            if (Util.isClusterMapMOST(navigationEnv.getFramework())) {
                this.registerDSIListener(string, navigation.getClusterService().getKomoService(), (class$org$dsi$ifc$komonavinfo$DSIKOMONavInfoListener == null ? (class$org$dsi$ifc$komonavinfo$DSIKOMONavInfoListener = AbstractNavigationActivator.class$("org.dsi.ifc.komonavinfo.DSIKOMONavInfoListener")) : class$org$dsi$ifc$komonavinfo$DSIKOMONavInfoListener).getName(), 0);
                this.registerDSIListener(string, navigation.getClusterService().getKomoService(), (class$org$dsi$ifc$komogfxstreamsink$DSIKOMOGfxStreamSinkListener == null ? (class$org$dsi$ifc$komogfxstreamsink$DSIKOMOGfxStreamSinkListener = AbstractNavigationActivator.class$("org.dsi.ifc.komogfxstreamsink.DSIKOMOGfxStreamSinkListener")) : class$org$dsi$ifc$komogfxstreamsink$DSIKOMOGfxStreamSinkListener).getName(), 0);
            }
        }
        if (this.framework.isFrontMU()) {
            this.registerDSIListener(string, navigation.getTrafficRegulationService(), (class$org$dsi$ifc$trafficregulation$DSITrafficRegulationListener == null ? (class$org$dsi$ifc$trafficregulation$DSITrafficRegulationListener = AbstractNavigationActivator.class$("org.dsi.ifc.trafficregulation.DSITrafficRegulationListener")) : class$org$dsi$ifc$trafficregulation$DSITrafficRegulationListener).getName(), 0);
        }
        if (Util.isRangeMapDisplayPresent(navigationEnv.getFramework())) {
            this.registerDSIListener(string, navigation.getMapInterface().getMobilityHorizonHandler(), (class$org$dsi$ifc$mobilityhorizon$DSIMobilityHorizonListener == null ? (class$org$dsi$ifc$mobilityhorizon$DSIMobilityHorizonListener = AbstractNavigationActivator.class$("org.dsi.ifc.mobilityhorizon.DSIMobilityHorizonListener")) : class$org$dsi$ifc$mobilityhorizon$DSIMobilityHorizonListener).getName(), 0);
        }
    }

    private void registerI18NTarget(Navigation navigation) {
        Hashtable hashtable = new Hashtable();
        hashtable.put("LANG_COMPONENT_TYPE", "LANG_COMPONENT_NAVI");
        hashtable.put("NOTIFY_BY_REGISTRATION_STRATEGY", "UPDATE_AFTER_REGISTRATION");
        this.sregI18NTarget = this.bundleContext.registerService((class$de$audi$atip$i18n$I18NTarget == null ? (class$de$audi$atip$i18n$I18NTarget = AbstractNavigationActivator.class$("de.audi.atip.i18n.I18NTarget")) : class$de$audi$atip$i18n$I18NTarget).getName(), (Object)navigation, (Dictionary)hashtable);
    }

    private void unregisterI18NTarget() {
        if (this.sregI18NTarget != null) {
            this.sregI18NTarget.unregister();
            this.sregI18NTarget = null;
        }
    }

    protected void registerProvidedServices(Navigation navigation, NavigationEnv navigationEnv) {
        this.logChannel.log(10000000, "AbstractNavigationActivator#registerProvidedServices - register navigation service");
        String[] stringArray = new String[]{(class$de$audi$atip$hmi$HMIApplication == null ? (class$de$audi$atip$hmi$HMIApplication = AbstractNavigationActivator.class$("de.audi.atip.hmi.HMIApplication")) : class$de$audi$atip$hmi$HMIApplication).getName(), (class$de$audi$atip$power$PowerEventListener == null ? (class$de$audi$atip$power$PowerEventListener = AbstractNavigationActivator.class$("de.audi.atip.power.PowerEventListener")) : class$de$audi$atip$power$PowerEventListener).getName()};
        Hashtable hashtable = new Hashtable();
        hashtable.put("ApplicationName", "AppNavi");
        hashtable.put("moduleID", new Integer(navigation.getId()));
        this.registerService(stringArray, (Object)navigation, (Dictionary)hashtable);
        hashtable = new Hashtable();
        hashtable.put("DEVICE_NAME", (class$de$audi$atip$interapp$MapService == null ? (class$de$audi$atip$interapp$MapService = AbstractNavigationActivator.class$("de.audi.atip.interapp.MapService")) : class$de$audi$atip$interapp$MapService).getName());
        this.registerService((class$de$audi$atip$interapp$MapService == null ? (class$de$audi$atip$interapp$MapService = AbstractNavigationActivator.class$("de.audi.atip.interapp.MapService")) : class$de$audi$atip$interapp$MapService).getName(), (Object)navigation.getMapInterface(), (Dictionary)hashtable);
        hashtable = new Hashtable();
        hashtable.put("DEVICE_NAME", (class$de$audi$atip$interapp$maptmc$MapTmcService == null ? (class$de$audi$atip$interapp$maptmc$MapTmcService = AbstractNavigationActivator.class$("de.audi.atip.interapp.maptmc.MapTmcService")) : class$de$audi$atip$interapp$maptmc$MapTmcService).getName());
        this.registerService((class$de$audi$atip$interapp$maptmc$MapTmcService == null ? (class$de$audi$atip$interapp$maptmc$MapTmcService = AbstractNavigationActivator.class$("de.audi.atip.interapp.maptmc.MapTmcService")) : class$de$audi$atip$interapp$maptmc$MapTmcService).getName(), (Object)navigation.getMapInterface().getTMCMap(), (Dictionary)hashtable);
        hashtable = new Hashtable();
        hashtable.put("DEVICE_NAME", (class$de$audi$atip$interapp$navigation$previewmap$IPreviewMap == null ? (class$de$audi$atip$interapp$navigation$previewmap$IPreviewMap = AbstractNavigationActivator.class$("de.audi.atip.interapp.navigation.previewmap.IPreviewMap")) : class$de$audi$atip$interapp$navigation$previewmap$IPreviewMap).getName());
        this.registerService((class$de$audi$atip$interapp$navigation$previewmap$IPreviewMap == null ? (class$de$audi$atip$interapp$navigation$previewmap$IPreviewMap = AbstractNavigationActivator.class$("de.audi.atip.interapp.navigation.previewmap.IPreviewMap")) : class$de$audi$atip$interapp$navigation$previewmap$IPreviewMap).getName(), (Object)navigation.getMapInterface().getPreviewMap(), (Dictionary)hashtable);
        hashtable = new Hashtable();
        hashtable.put("ApplicationName", "AppNavi");
        this.registerService((class$de$audi$atip$interapp$NaviService == null ? (class$de$audi$atip$interapp$NaviService = AbstractNavigationActivator.class$("de.audi.atip.interapp.NaviService")) : class$de$audi$atip$interapp$NaviService).getName(), (Object)navigation.getInterAppService(), (Dictionary)hashtable);
        String[] stringArray2 = new String[]{(class$de$audi$atip$interapp$NaviADBService == null ? (class$de$audi$atip$interapp$NaviADBService = AbstractNavigationActivator.class$("de.audi.atip.interapp.NaviADBService")) : class$de$audi$atip$interapp$NaviADBService).getName()};
        this.registerService(stringArray2, (Object)navigation.getAdbInterAppService(), null);
        this.registerService((class$de$audi$atip$msg$MsgListener == null ? (class$de$audi$atip$msg$MsgListener = AbstractNavigationActivator.class$("de.audi.atip.msg.MsgListener")) : class$de$audi$atip$msg$MsgListener).getName(), (Object)navigation.getManagementServices(), null);
        this.registerService((class$de$esolutions$fw$util$commons$error$DumpInfoProvider == null ? (class$de$esolutions$fw$util$commons$error$DumpInfoProvider = AbstractNavigationActivator.class$("de.esolutions.fw.util.commons.error.DumpInfoProvider")) : class$de$esolutions$fw$util$commons$error$DumpInfoProvider).getName(), (Object)new NavigationInfoProvider(navigation.getOperationManager(), navigation.getCommandListCallManager()), null);
        this.registerService((class$de$audi$atip$interapp$combi$bap$navi$CombiBAPServiceNaviListener == null ? (class$de$audi$atip$interapp$combi$bap$navi$CombiBAPServiceNaviListener = AbstractNavigationActivator.class$("de.audi.atip.interapp.combi.bap.navi.CombiBAPServiceNaviListener")) : class$de$audi$atip$interapp$combi$bap$navi$CombiBAPServiceNaviListener).getName(), (Object)navigation.getClusterService().getCombiBAPListener(), null);
        Hashtable hashtable2 = new Hashtable();
        hashtable2.put("AUDIO_CLIENT_ID", HMIAudioService.CLIENT_NAVI);
        this.registerService((class$de$audi$atip$audio$HMIAudioServiceListener == null ? (class$de$audi$atip$audio$HMIAudioServiceListener = AbstractNavigationActivator.class$("de.audi.atip.audio.HMIAudioServiceListener")) : class$de$audi$atip$audio$HMIAudioServiceListener).getName(), (Object)navigation.getAudioStateMachine(), (Dictionary)hashtable2);
        this.registerService((class$de$audi$atip$interapp$picnav$IPicNavNaviService == null ? (class$de$audi$atip$interapp$picnav$IPicNavNaviService = AbstractNavigationActivator.class$("de.audi.atip.interapp.picnav.IPicNavNaviService")) : class$de$audi$atip$interapp$picnav$IPicNavNaviService).getName(), (Object)navigation.getPicNavInterfaceHandler().getPicNavNaviService(), null);
        this.registerService((class$de$audi$tghu$navi$app$sdis$INaviTabletService == null ? (class$de$audi$tghu$navi$app$sdis$INaviTabletService = AbstractNavigationActivator.class$("de.audi.tghu.navi.app.sdis.INaviTabletService")) : class$de$audi$tghu$navi$app$sdis$INaviTabletService).getName(), (Object)navigation.getNaviTabletService(), null);
        if (Util.isGoogleEarthPresent(navigationEnv.getFramework())) {
            this.registerService((class$de$audi$atip$interapp$INaviConnectivityStateListener == null ? (class$de$audi$atip$interapp$INaviConnectivityStateListener = AbstractNavigationActivator.class$("de.audi.atip.interapp.INaviConnectivityStateListener")) : class$de$audi$atip$interapp$INaviConnectivityStateListener).getName(), (Object)navigation.getMapInterface(), null);
        }
        this.registerService((class$de$audi$atip$preset$IAppPresetDefinitionHandler == null ? (class$de$audi$atip$preset$IAppPresetDefinitionHandler = AbstractNavigationActivator.class$("de.audi.atip.preset.IAppPresetDefinitionHandler")) : class$de$audi$atip$preset$IAppPresetDefinitionHandler).getName(), (Object)this.navigation.getPresetHandler(), null);
        this.registerService((class$de$audi$atip$preset$IAppPresetExecutionHandler == null ? (class$de$audi$atip$preset$IAppPresetExecutionHandler = AbstractNavigationActivator.class$("de.audi.atip.preset.IAppPresetExecutionHandler")) : class$de$audi$atip$preset$IAppPresetExecutionHandler).getName(), (Object)this.navigation.getPresetHandler(), null);
        this.registerService((class$de$audi$atip$interapp$terminalmode$ITerminalModeUpdateListener == null ? (class$de$audi$atip$interapp$terminalmode$ITerminalModeUpdateListener = AbstractNavigationActivator.class$("de.audi.atip.interapp.terminalmode.ITerminalModeUpdateListener")) : class$de$audi$atip$interapp$terminalmode$ITerminalModeUpdateListener).getName(), (Object)navigation.getGALHandler(), null);
        hashtable = new Hashtable();
        hashtable.put("ANN_STATE_CLIENT_ID", IAnnouncementStateService.NAVI);
        this.registerService((class$de$audi$atip$interapp$audio$IAnnouncementStateService == null ? (class$de$audi$atip$interapp$audio$IAnnouncementStateService = AbstractNavigationActivator.class$("de.audi.atip.interapp.audio.IAnnouncementStateService")) : class$de$audi$atip$interapp$audio$IAnnouncementStateService).getName(), (Object)navigation.getAnnouncementStateService(), (Dictionary)hashtable);
        this.registerService((class$de$audi$atip$interapp$INaviFormattingService == null ? (class$de$audi$atip$interapp$INaviFormattingService = AbstractNavigationActivator.class$("de.audi.atip.interapp.INaviFormattingService")) : class$de$audi$atip$interapp$INaviFormattingService).getName(), (Object)this.navigation.getNaviFormattingService(), null);
    }

    protected void startRequiredDSIServices(NavigationEnv navigationEnv) {
        this.framework.startDSIService((class$org$dsi$ifc$iconhandling$DSIIconExtractor == null ? (class$org$dsi$ifc$iconhandling$DSIIconExtractor = AbstractNavigationActivator.class$("org.dsi.ifc.iconhandling.DSIIconExtractor")) : class$org$dsi$ifc$iconhandling$DSIIconExtractor).getName(), 0);
        this.framework.startDSIService((class$org$dsi$ifc$navigation$DSINavigation == null ? (class$org$dsi$ifc$navigation$DSINavigation = AbstractNavigationActivator.class$("org.dsi.ifc.navigation.DSINavigation")) : class$org$dsi$ifc$navigation$DSINavigation).getName(), DEV_INST_DSINAV_MAIN);
        this.framework.startDSIService((class$org$dsi$ifc$navigation$DSIBlocking == null ? (class$org$dsi$ifc$navigation$DSIBlocking = AbstractNavigationActivator.class$("org.dsi.ifc.navigation.DSIBlocking")) : class$org$dsi$ifc$navigation$DSIBlocking).getName(), DEV_INST_DSINAV_MAIN);
        this.framework.startDSIService((class$org$dsi$ifc$navigation$DSICombinedRouteList == null ? (class$org$dsi$ifc$navigation$DSICombinedRouteList = AbstractNavigationActivator.class$("org.dsi.ifc.navigation.DSICombinedRouteList")) : class$org$dsi$ifc$navigation$DSICombinedRouteList).getName(), DEV_INST_DSINAV_MAIN);
        this.framework.startDSIService((class$org$dsi$ifc$trafficregulation$DSITrafficRegulation == null ? (class$org$dsi$ifc$trafficregulation$DSITrafficRegulation = AbstractNavigationActivator.class$("org.dsi.ifc.trafficregulation.DSITrafficRegulation")) : class$org$dsi$ifc$trafficregulation$DSITrafficRegulation).getName(), 0);
        if (!this.framework.isFrontMU()) {
            this.framework.startDSIService((class$org$dsi$ifc$navigation$DSINavigation == null ? (class$org$dsi$ifc$navigation$DSINavigation = AbstractNavigationActivator.class$("org.dsi.ifc.navigation.DSINavigation")) : class$org$dsi$ifc$navigation$DSINavigation).getName(), DEVICEINSTANCE_DSINAVIGATION_REMOTE);
            this.framework.startDSIService((class$org$dsi$ifc$navigation$DSIBlocking == null ? (class$org$dsi$ifc$navigation$DSIBlocking = AbstractNavigationActivator.class$("org.dsi.ifc.navigation.DSIBlocking")) : class$org$dsi$ifc$navigation$DSIBlocking).getName(), DEVICEINSTANCE_DSINAVIGATION_REMOTE);
            this.framework.startDSIService((class$org$dsi$ifc$navigation$DSICombinedRouteList == null ? (class$org$dsi$ifc$navigation$DSICombinedRouteList = AbstractNavigationActivator.class$("org.dsi.ifc.navigation.DSICombinedRouteList")) : class$org$dsi$ifc$navigation$DSICombinedRouteList).getName(), DEVICEINSTANCE_DSINAVIGATION_REMOTE);
        }
        this.framework.startDSIService((class$org$dsi$ifc$map$DSIMapViewerControl == null ? (class$org$dsi$ifc$map$DSIMapViewerControl = AbstractNavigationActivator.class$("org.dsi.ifc.map.DSIMapViewerControl")) : class$org$dsi$ifc$map$DSIMapViewerControl).getName(), DEVICEINSTANCE_DSIMAPCTRL_DEFAULT);
        this.framework.startDSIService((class$org$dsi$ifc$map$DSIMapViewerZoomEngine == null ? (class$org$dsi$ifc$map$DSIMapViewerZoomEngine = AbstractNavigationActivator.class$("org.dsi.ifc.map.DSIMapViewerZoomEngine")) : class$org$dsi$ifc$map$DSIMapViewerZoomEngine).getName(), 0);
        this.framework.startDSIService((class$org$dsi$ifc$map$DSIMapViewerManeuverView == null ? (class$org$dsi$ifc$map$DSIMapViewerManeuverView = AbstractNavigationActivator.class$("org.dsi.ifc.map.DSIMapViewerManeuverView")) : class$org$dsi$ifc$map$DSIMapViewerManeuverView).getName(), 0);
        if (Util.isClusterMapAvailable(navigationEnv.getFramework())) {
            this.framework.startDSIService((class$org$dsi$ifc$map$DSIMapViewerControl == null ? (class$org$dsi$ifc$map$DSIMapViewerControl = AbstractNavigationActivator.class$("org.dsi.ifc.map.DSIMapViewerControl")) : class$org$dsi$ifc$map$DSIMapViewerControl).getName(), DEVICEINSTANCE_DSIMAPCTRL_KOMBI);
            this.framework.startDSIService((class$org$dsi$ifc$map$DSIMapViewerZoomEngine == null ? (class$org$dsi$ifc$map$DSIMapViewerZoomEngine = AbstractNavigationActivator.class$("org.dsi.ifc.map.DSIMapViewerZoomEngine")) : class$org$dsi$ifc$map$DSIMapViewerZoomEngine).getName(), 1);
        } else if (Util.isMapInMapAvailable(navigationEnv.getFramework())) {
            this.framework.startDSIService((class$org$dsi$ifc$map$DSIMapViewerControl == null ? (class$org$dsi$ifc$map$DSIMapViewerControl = AbstractNavigationActivator.class$("org.dsi.ifc.map.DSIMapViewerControl")) : class$org$dsi$ifc$map$DSIMapViewerControl).getName(), DEVICEINSTANCE_DSIMAPCTRL_MAP_IN_MAP);
        }
        if (Util.isClusterKDKAvailable(navigationEnv.getFramework())) {
            this.framework.startDSIService((class$org$dsi$ifc$komoview$DSIKOMOView == null ? (class$org$dsi$ifc$komoview$DSIKOMOView = AbstractNavigationActivator.class$("org.dsi.ifc.komoview.DSIKOMOView")) : class$org$dsi$ifc$komoview$DSIKOMOView).getName(), 0);
            if (Util.isClusterMapMOST(navigationEnv.getFramework())) {
                this.framework.startDSIService((class$org$dsi$ifc$komonavinfo$DSIKOMONavInfo == null ? (class$org$dsi$ifc$komonavinfo$DSIKOMONavInfo = AbstractNavigationActivator.class$("org.dsi.ifc.komonavinfo.DSIKOMONavInfo")) : class$org$dsi$ifc$komonavinfo$DSIKOMONavInfo).getName(), 0);
                this.framework.startDSIService((class$org$dsi$ifc$komogfxstreamsink$DSIKOMOGfxStreamSink == null ? (class$org$dsi$ifc$komogfxstreamsink$DSIKOMOGfxStreamSink = AbstractNavigationActivator.class$("org.dsi.ifc.komogfxstreamsink.DSIKOMOGfxStreamSink")) : class$org$dsi$ifc$komogfxstreamsink$DSIKOMOGfxStreamSink).getName(), 0);
            }
        }
        if (Util.isRangeMapDisplayPresent(navigationEnv.getFramework())) {
            this.framework.startDSIService((class$org$dsi$ifc$mobilityhorizon$DSIMobilityHorizon == null ? (class$org$dsi$ifc$mobilityhorizon$DSIMobilityHorizon = AbstractNavigationActivator.class$("org.dsi.ifc.mobilityhorizon.DSIMobilityHorizon")) : class$org$dsi$ifc$mobilityhorizon$DSIMobilityHorizon).getName(), 0);
        }
    }

    public void startDelayedDSIServices(LogChannel logChannel, IFrameworkAccess iFrameworkAccess) {
        logChannel.log(10000000, "AbstractNavigationActivator#startDelayedDSIServices() - starting DSI services (already started: %1)", this.delayedServicesStarted);
        if (!this.delayedServicesStarted) {
            iFrameworkAccess.startDSIService((class$org$dsi$ifc$generalvehiclestates$DSIGeneralVehicleStates == null ? (class$org$dsi$ifc$generalvehiclestates$DSIGeneralVehicleStates = AbstractNavigationActivator.class$("org.dsi.ifc.generalvehiclestates.DSIGeneralVehicleStates")) : class$org$dsi$ifc$generalvehiclestates$DSIGeneralVehicleStates).getName(), 0);
            iFrameworkAccess.startDSIService((class$org$dsi$ifc$trafficregulation$DSITrafficRegulation == null ? (class$org$dsi$ifc$trafficregulation$DSITrafficRegulation = AbstractNavigationActivator.class$("org.dsi.ifc.trafficregulation.DSITrafficRegulation")) : class$org$dsi$ifc$trafficregulation$DSITrafficRegulation).getName(), 0);
            iFrameworkAccess.startDSIService((class$org$dsi$ifc$tmc$DSITmcOnRoute == null ? (class$org$dsi$ifc$tmc$DSITmcOnRoute = AbstractNavigationActivator.class$("org.dsi.ifc.tmc.DSITmcOnRoute")) : class$org$dsi$ifc$tmc$DSITmcOnRoute).getName(), 0);
            this.navigation.startDelayedDSIServices(this.bundleContext);
            this.delayedServicesStarted = true;
        }
    }

    protected void startTrackers(NavigationEnv navigationEnv) {
        this.logChannel.log(10000000, "AbstractNavigationActivator#startTrackers - starting trackers");
        ArrayList arrayList = new ArrayList(51);
        arrayList.add((class$de$audi$atip$interapp$online$OnlineServiceProvider == null ? (class$de$audi$atip$interapp$online$OnlineServiceProvider = AbstractNavigationActivator.class$("de.audi.atip.interapp.online.OnlineServiceProvider")) : class$de$audi$atip$interapp$online$OnlineServiceProvider).getName());
        arrayList.add((class$org$dsi$ifc$navigation$DSINavigation == null ? (class$org$dsi$ifc$navigation$DSINavigation = AbstractNavigationActivator.class$("org.dsi.ifc.navigation.DSINavigation")) : class$org$dsi$ifc$navigation$DSINavigation).getName());
        arrayList.add((class$org$dsi$ifc$navigation$DSIBlocking == null ? (class$org$dsi$ifc$navigation$DSIBlocking = AbstractNavigationActivator.class$("org.dsi.ifc.navigation.DSIBlocking")) : class$org$dsi$ifc$navigation$DSIBlocking).getName());
        arrayList.add((class$org$dsi$ifc$navigation$DSICombinedRouteList == null ? (class$org$dsi$ifc$navigation$DSICombinedRouteList = AbstractNavigationActivator.class$("org.dsi.ifc.navigation.DSICombinedRouteList")) : class$org$dsi$ifc$navigation$DSICombinedRouteList).getName());
        arrayList.add((class$org$dsi$ifc$map$DSIMapViewerControl == null ? (class$org$dsi$ifc$map$DSIMapViewerControl = AbstractNavigationActivator.class$("org.dsi.ifc.map.DSIMapViewerControl")) : class$org$dsi$ifc$map$DSIMapViewerControl).getName());
        arrayList.add((class$org$dsi$ifc$map$DSIMapViewerZoomEngine == null ? (class$org$dsi$ifc$map$DSIMapViewerZoomEngine = AbstractNavigationActivator.class$("org.dsi.ifc.map.DSIMapViewerZoomEngine")) : class$org$dsi$ifc$map$DSIMapViewerZoomEngine).getName());
        arrayList.add((class$org$dsi$ifc$map$DSIMapViewerManeuverView == null ? (class$org$dsi$ifc$map$DSIMapViewerManeuverView = AbstractNavigationActivator.class$("org.dsi.ifc.map.DSIMapViewerManeuverView")) : class$org$dsi$ifc$map$DSIMapViewerManeuverView).getName());
        arrayList.add((class$org$dsi$ifc$generalvehiclestates$DSIGeneralVehicleStates == null ? (class$org$dsi$ifc$generalvehiclestates$DSIGeneralVehicleStates = AbstractNavigationActivator.class$("org.dsi.ifc.generalvehiclestates.DSIGeneralVehicleStates")) : class$org$dsi$ifc$generalvehiclestates$DSIGeneralVehicleStates).getName());
        arrayList.add((class$org$dsi$ifc$tmc$DSITmcOnRoute == null ? (class$org$dsi$ifc$tmc$DSITmcOnRoute = AbstractNavigationActivator.class$("org.dsi.ifc.tmc.DSITmcOnRoute")) : class$org$dsi$ifc$tmc$DSITmcOnRoute).getName());
        arrayList.add((class$org$dsi$ifc$organizer$DSIAdbEdit == null ? (class$org$dsi$ifc$organizer$DSIAdbEdit = AbstractNavigationActivator.class$("org.dsi.ifc.organizer.DSIAdbEdit")) : class$org$dsi$ifc$organizer$DSIAdbEdit).getName());
        arrayList.add((class$org$dsi$ifc$organizer$DSIAdbList == null ? (class$org$dsi$ifc$organizer$DSIAdbList = AbstractNavigationActivator.class$("org.dsi.ifc.organizer.DSIAdbList")) : class$org$dsi$ifc$organizer$DSIAdbList).getName());
        arrayList.add((class$org$dsi$ifc$organizer$DSIAdbUserProfile == null ? (class$org$dsi$ifc$organizer$DSIAdbUserProfile = AbstractNavigationActivator.class$("org.dsi.ifc.organizer.DSIAdbUserProfile")) : class$org$dsi$ifc$organizer$DSIAdbUserProfile).getName());
        arrayList.add((class$org$dsi$ifc$organizer$DSIAdbSetup == null ? (class$org$dsi$ifc$organizer$DSIAdbSetup = AbstractNavigationActivator.class$("org.dsi.ifc.organizer.DSIAdbSetup")) : class$org$dsi$ifc$organizer$DSIAdbSetup).getName());
        arrayList.add((class$org$dsi$ifc$trafficregulation$DSITrafficRegulation == null ? (class$org$dsi$ifc$trafficregulation$DSITrafficRegulation = AbstractNavigationActivator.class$("org.dsi.ifc.trafficregulation.DSITrafficRegulation")) : class$org$dsi$ifc$trafficregulation$DSITrafficRegulation).getName());
        arrayList.add((class$de$audi$atip$interapp$ADBHMIAppService == null ? (class$de$audi$atip$interapp$ADBHMIAppService = AbstractNavigationActivator.class$("de.audi.atip.interapp.ADBHMIAppService")) : class$de$audi$atip$interapp$ADBHMIAppService).getName());
        arrayList.add((class$de$audi$atip$interapp$PhoneService == null ? (class$de$audi$atip$interapp$PhoneService = AbstractNavigationActivator.class$("de.audi.atip.interapp.PhoneService")) : class$de$audi$atip$interapp$PhoneService).getName());
        arrayList.add((class$de$audi$atip$audio$HMIAudioService == null ? (class$de$audi$atip$audio$HMIAudioService = AbstractNavigationActivator.class$("de.audi.atip.audio.HMIAudioService")) : class$de$audi$atip$audio$HMIAudioService).getName());
        arrayList.add((class$de$audi$atip$interapp$navtmc$TMCService == null ? (class$de$audi$atip$interapp$navtmc$TMCService = AbstractNavigationActivator.class$("de.audi.atip.interapp.navtmc.TMCService")) : class$de$audi$atip$interapp$navtmc$TMCService).getName());
        arrayList.add((class$de$audi$atip$interapp$icon$RenderingInfoProvider == null ? (class$de$audi$atip$interapp$icon$RenderingInfoProvider = AbstractNavigationActivator.class$("de.audi.atip.interapp.icon.RenderingInfoProvider")) : class$de$audi$atip$interapp$icon$RenderingInfoProvider).getName());
        arrayList.add((class$de$audi$atip$interapp$combi$ddp2$CombiService == null ? (class$de$audi$atip$interapp$combi$ddp2$CombiService = AbstractNavigationActivator.class$("de.audi.atip.interapp.combi.ddp2.CombiService")) : class$de$audi$atip$interapp$combi$ddp2$CombiService).getName());
        arrayList.add((class$de$audi$atip$interapp$combi$bap$navi$CombiBAPServiceNavi == null ? (class$de$audi$atip$interapp$combi$bap$navi$CombiBAPServiceNavi = AbstractNavigationActivator.class$("de.audi.atip.interapp.combi.bap.navi.CombiBAPServiceNavi")) : class$de$audi$atip$interapp$combi$bap$navi$CombiBAPServiceNavi).getName());
        arrayList.add((class$de$audi$atip$diag$sw$SwDiagnosisManager == null ? (class$de$audi$atip$diag$sw$SwDiagnosisManager = AbstractNavigationActivator.class$("de.audi.atip.diag.sw.SwDiagnosisManager")) : class$de$audi$atip$diag$sw$SwDiagnosisManager).getName());
        arrayList.add((class$org$dsi$ifc$base$IAdapterManager == null ? (class$org$dsi$ifc$base$IAdapterManager = AbstractNavigationActivator.class$("org.dsi.ifc.base.IAdapterManager")) : class$org$dsi$ifc$base$IAdapterManager).getName());
        arrayList.add((class$de$audi$atip$interapp$navcar$CarNavListener == null ? (class$de$audi$atip$interapp$navcar$CarNavListener = AbstractNavigationActivator.class$("de.audi.atip.interapp.navcar.CarNavListener")) : class$de$audi$atip$interapp$navcar$CarNavListener).getName());
        arrayList.add((class$de$audi$atip$interapp$navuota$UotaNavListener == null ? (class$de$audi$atip$interapp$navuota$UotaNavListener = AbstractNavigationActivator.class$("de.audi.atip.interapp.navuota.UotaNavListener")) : class$de$audi$atip$interapp$navuota$UotaNavListener).getName());
        arrayList.add((class$de$audi$tghu$navi$app$sdis$INaviTabletServiceListener == null ? (class$de$audi$tghu$navi$app$sdis$INaviTabletServiceListener = AbstractNavigationActivator.class$("de.audi.tghu.navi.app.sdis.INaviTabletServiceListener")) : class$de$audi$tghu$navi$app$sdis$INaviTabletServiceListener).getName());
        arrayList.add((class$de$audi$atip$interapp$online$IOnlineDestinationService == null ? (class$de$audi$atip$interapp$online$IOnlineDestinationService = AbstractNavigationActivator.class$("de.audi.atip.interapp.online.IOnlineDestinationService")) : class$de$audi$atip$interapp$online$IOnlineDestinationService).getName());
        arrayList.add((class$de$audi$atip$interapp$ADBRemoteHMIService == null ? (class$de$audi$atip$interapp$ADBRemoteHMIService = AbstractNavigationActivator.class$("de.audi.atip.interapp.ADBRemoteHMIService")) : class$de$audi$atip$interapp$ADBRemoteHMIService).getName());
        arrayList.add((class$de$audi$atip$interapp$NaviCruiseModeServiceListener == null ? (class$de$audi$atip$interapp$NaviCruiseModeServiceListener = AbstractNavigationActivator.class$("de.audi.atip.interapp.NaviCruiseModeServiceListener")) : class$de$audi$atip$interapp$NaviCruiseModeServiceListener).getName());
        if (Util.isClusterKDKAvailable(navigationEnv.getFramework())) {
            arrayList.add((class$org$dsi$ifc$komoview$DSIKOMOView == null ? (class$org$dsi$ifc$komoview$DSIKOMOView = AbstractNavigationActivator.class$("org.dsi.ifc.komoview.DSIKOMOView")) : class$org$dsi$ifc$komoview$DSIKOMOView).getName());
            if (Util.isClusterMapMOST(navigationEnv.getFramework())) {
                arrayList.add((class$org$dsi$ifc$komonavinfo$DSIKOMONavInfo == null ? (class$org$dsi$ifc$komonavinfo$DSIKOMONavInfo = AbstractNavigationActivator.class$("org.dsi.ifc.komonavinfo.DSIKOMONavInfo")) : class$org$dsi$ifc$komonavinfo$DSIKOMONavInfo).getName());
                arrayList.add((class$org$dsi$ifc$komogfxstreamsink$DSIKOMOGfxStreamSink == null ? (class$org$dsi$ifc$komogfxstreamsink$DSIKOMOGfxStreamSink = AbstractNavigationActivator.class$("org.dsi.ifc.komogfxstreamsink.DSIKOMOGfxStreamSink")) : class$org$dsi$ifc$komogfxstreamsink$DSIKOMOGfxStreamSink).getName());
            }
        }
        if (Util.isClusterMMI(navigationEnv.getFramework())) {
            arrayList.add((class$de$audi$atip$mmicombi$IViewSizeManager == null ? (class$de$audi$atip$mmicombi$IViewSizeManager = AbstractNavigationActivator.class$("de.audi.atip.mmicombi.IViewSizeManager")) : class$de$audi$atip$mmicombi$IViewSizeManager).getName());
        }
        if (Util.isGoogleEarthPresent(navigationEnv.getFramework())) {
            arrayList.add((class$org$dsi$ifc$map$DSIMapViewerGoogleCtrl == null ? (class$org$dsi$ifc$map$DSIMapViewerGoogleCtrl = AbstractNavigationActivator.class$("org.dsi.ifc.map.DSIMapViewerGoogleCtrl")) : class$org$dsi$ifc$map$DSIMapViewerGoogleCtrl).getName());
        }
        arrayList.add((class$de$audi$atip$browser$IBrowserHandler == null ? (class$de$audi$atip$browser$IBrowserHandler = AbstractNavigationActivator.class$("de.audi.atip.browser.IBrowserHandler")) : class$de$audi$atip$browser$IBrowserHandler).getName());
        arrayList.add((class$org$dsi$ifc$online$DSIPoiOnlineSearch == null ? (class$org$dsi$ifc$online$DSIPoiOnlineSearch = AbstractNavigationActivator.class$("org.dsi.ifc.online.DSIPoiOnlineSearch")) : class$org$dsi$ifc$online$DSIPoiOnlineSearch).getName());
        arrayList.add((class$de$audi$atip$rse$AbstractRSEConnection == null ? (class$de$audi$atip$rse$AbstractRSEConnection = AbstractNavigationActivator.class$("de.audi.atip.rse.AbstractRSEConnection")) : class$de$audi$atip$rse$AbstractRSEConnection).getName());
        arrayList.add((class$de$audi$atip$interapp$NaviSDSPOIOnlineServiceListener == null ? (class$de$audi$atip$interapp$NaviSDSPOIOnlineServiceListener = AbstractNavigationActivator.class$("de.audi.atip.interapp.NaviSDSPOIOnlineServiceListener")) : class$de$audi$atip$interapp$NaviSDSPOIOnlineServiceListener).getName());
        if (Util.isPictureNavPresent(navigationEnv.getFramework())) {
            arrayList.add((class$de$audi$atip$interapp$picnav$INaviPicNavService == null ? (class$de$audi$atip$interapp$picnav$INaviPicNavService = AbstractNavigationActivator.class$("de.audi.atip.interapp.picnav.INaviPicNavService")) : class$de$audi$atip$interapp$picnav$INaviPicNavService).getName());
        }
        if (!this.getIViewSizeManagerClassName().equals("")) {
            arrayList.add(this.getIViewSizeManagerClassName());
        }
        arrayList.add((class$de$audi$atip$interapp$online$IOnlineService == null ? (class$de$audi$atip$interapp$online$IOnlineService = AbstractNavigationActivator.class$("de.audi.atip.interapp.online.IOnlineService")) : class$de$audi$atip$interapp$online$IOnlineService).getName());
        arrayList.add((class$org$dsi$ifc$carkombi$DSICarKombi == null ? (class$org$dsi$ifc$carkombi$DSICarKombi = AbstractNavigationActivator.class$("org.dsi.ifc.carkombi.DSICarKombi")) : class$org$dsi$ifc$carkombi$DSICarKombi).getName());
        if (Util.isPoiWarningPresent()) {
            arrayList.add((class$de$audi$tghu$waveplayer$WavePlayer == null ? (class$de$audi$tghu$waveplayer$WavePlayer = AbstractNavigationActivator.class$("de.audi.tghu.waveplayer.WavePlayer")) : class$de$audi$tghu$waveplayer$WavePlayer).getName());
        }
        if (this.isRequiredConnectivityNaviStateListener(navigationEnv)) {
            arrayList.add((class$de$audi$atip$interapp$IConnectivityNaviStateListener == null ? (class$de$audi$atip$interapp$IConnectivityNaviStateListener = AbstractNavigationActivator.class$("de.audi.atip.interapp.IConnectivityNaviStateListener")) : class$de$audi$atip$interapp$IConnectivityNaviStateListener).getName());
        }
        arrayList.add((class$de$audi$atip$interapp$MapServiceListener == null ? (class$de$audi$atip$interapp$MapServiceListener = AbstractNavigationActivator.class$("de.audi.atip.interapp.MapServiceListener")) : class$de$audi$atip$interapp$MapServiceListener).getName());
        arrayList.add((class$de$audi$atip$interapp$car$AudiEnergyAssistService == null ? (class$de$audi$atip$interapp$car$AudiEnergyAssistService = AbstractNavigationActivator.class$("de.audi.atip.interapp.car.AudiEnergyAssistService")) : class$de$audi$atip$interapp$car$AudiEnergyAssistService).getName());
        if (Util.isRangeMapDisplayPresent(navigationEnv.getFramework())) {
            arrayList.add((class$org$dsi$ifc$mobilityhorizon$DSIMobilityHorizon == null ? (class$org$dsi$ifc$mobilityhorizon$DSIMobilityHorizon = AbstractNavigationActivator.class$("org.dsi.ifc.mobilityhorizon.DSIMobilityHorizon")) : class$org$dsi$ifc$mobilityhorizon$DSIMobilityHorizon).getName());
        }
        if (Util.isHURegionCN() || Util.isHURegionJP()) {
            arrayList.add((class$de$audi$atip$interapp$online$IOperatorCallNaviService == null ? (class$de$audi$atip$interapp$online$IOperatorCallNaviService = AbstractNavigationActivator.class$("de.audi.atip.interapp.online.IOperatorCallNaviService")) : class$de$audi$atip$interapp$online$IOperatorCallNaviService).getName());
        }
        arrayList.add((class$de$audi$atip$interapp$audio$IAnnouncementStateListener == null ? (class$de$audi$atip$interapp$audio$IAnnouncementStateListener = AbstractNavigationActivator.class$("de.audi.atip.interapp.audio.IAnnouncementStateListener")) : class$de$audi$atip$interapp$audio$IAnnouncementStateListener).getName());
        arrayList.add((class$de$audi$atip$interapp$navcar$ILGIServiceListener == null ? (class$de$audi$atip$interapp$navcar$ILGIServiceListener = AbstractNavigationActivator.class$("de.audi.atip.interapp.navcar.ILGIServiceListener")) : class$de$audi$atip$interapp$navcar$ILGIServiceListener).getName());
        this.serviceTracker = new ServiceTracker(this.bundleContext, (String[])arrayList.toArray(new String[arrayList.size()]), (ServiceTrackerCustomizer)this);
        this.serviceTracker.open();
    }

    protected boolean isRequiredConnectivityNaviStateListener(NavigationEnv navigationEnv) {
        return Util.isGoogleEarthPresent(navigationEnv.getFramework());
    }

    public String getIViewSizeManagerClassName() {
        return "";
    }

    public void start(BundleContext bundleContext) {
        this.isServiceDeregistrationAllowed = true;
        super.start(bundleContext);
        Util.region = this.framework.getSysConst(442);
        NavigationEnv navigationEnv = this.createNavigationEnvironment(this.getFramework());
        this.logChannel = navigationEnv.getLogChannel();
        this.logChannel.log(10000000, "AbstractNavigationActivator#start");
        this.dsiCarKombiController = new DSICarKombiController(this.framework, this.logChannel, 0);
        this.dsiGeneralVehicleStatesController = new DSIGeneralVehicleStatesController(this.framework, this.logChannel, 0);
        this.navigation = this.createNavigation(navigationEnv);
        this.navigation.kombiEventsProviderAdded(this.dsiCarKombiController.getDsiCarKombiEventsProvider());
        this.navigation.init(this, navigationEnv);
        this.navigation.start(bundleContext);
        this.navigation.vehicleStatesEventsProviderAdded(this.dsiGeneralVehicleStatesController.getDsiCarKombiEventsProvider());
        this.dsiCarKombiController.start(bundleContext);
        this.dsiGeneralVehicleStatesController.start(bundleContext);
        this.registerProvidedServices(this.navigation, navigationEnv);
        this.registerDSIListeners(this.navigation, navigationEnv);
        this.startRequiredDSIServices(navigationEnv);
        this.startTrackers(navigationEnv);
        this.navigation.getOperationManager().taskCompleted(0);
        this.navigation.getOperationManager().checkInitialization(true);
    }

    protected Navigation createNavigation(NavigationEnv navigationEnv) {
        Navigation.createInstance(navigationEnv);
        return Navigation.getInstance();
    }

    protected NavigationEnv createNavigationEnvironment(IFrameworkAccess iFrameworkAccess) {
        return new NavigationEnv(iFrameworkAccess, this.getTextConstantsMapper(), this.getSMEventConstantsMapper());
    }

    public void stop(BundleContext bundleContext) {
        this.logChannel.log(10000000, "AbstractNavigationActivator#stop");
        this.isServiceDeregistrationAllowed = false;
        this.deinitDSIServices();
        this.serviceTracker = this.closeTracker(this.serviceTracker);
        this.unregisterI18NTarget();
        if (this.dsiCarKombiController != null) {
            this.dsiCarKombiController.stop(bundleContext);
            this.dsiCarKombiController = null;
        }
        if (this.dsiGeneralVehicleStatesController != null) {
            this.dsiGeneralVehicleStatesController.stop(bundleContext);
            this.dsiGeneralVehicleStatesController = null;
        }
        this.navigation.stop(bundleContext);
        this.framework.getNavProgressMonitor().stop();
        this.framework.getNavProgressMonitor().start();
        this.navigation.cleanup1();
        this.delayedServicesStarted = false;
        Util.setLocationAccessorFactory(null);
        super.stop(bundleContext);
    }

    private void deinitDSIServices() {
        try {
            this.doRemoveAllBrowserHandlerInstances();
            this.doRemoveDSIMapControlInstances();
            this.removeDSIOnline();
            this.removeViewSizeManager();
            this.removeOnlineServiceProvider();
            this.removePhoneService();
            this.doremoveDSIAdbSetup();
            this.doremoveDSIAdbuserprofile();
            this.doremoveDSIAdbEdit();
            this.doRemoveDSIAdbList();
            this.removeADBHMIAppService();
            this.removeAdbRemoteHMIService();
            this.removeAudiEnergyAssistService();
            this.removeAudioService();
            this.removeAllCarNavListeners();
            this.removeCombiBAPServiceNavi();
            this.doRemoveDSIBlockingMain();
            this.doRemoveDSIBlockingRemote();
            this.doRemoveDSICombinedRouteListMain();
            this.doRemoveDSICombinedRouteListRemote();
            this.removeDSIKOMOGfxStreamSink();
            this.removeDSIKOMONavInfo();
            this.doremoveDSIMapGoogleControl(0);
            this.doremoveDSIMapGoogleControl(1);
            this.removeDSIMapManeuverView();
            this.removeDSIMapZoomEngine(new Integer(0));
            this.removeDSIMapZoomEngine(new Integer(1));
            this.removeDSIMobilityHorizon();
            this.doremoveDSINavigationMain();
            this.doremoveDSINavigationRemote();
            this.removeDSITmcOnRoute();
            this.removeDSITrafficRegulation();
            this.removeIAdapterManager();
            this.doremoveIOnlineServiceGE();
            this.doremoveIOnlineServiceOnlineTraffic();
            this.doremoveIOnlineServiceWeather();
            this.removeMapServiceListener();
            this.removeNaviPicNavService();
            this.removeRenderingInfoProvider();
            this.removeRSEConnection();
            this.removeTabletService();
            this.removeTMCService();
            this.removeUotaNavListenerService();
            this.removeWavePlayer();
            this.removeOperatorCallService();
            this.removeTrafficMiniMap();
            this.removeNaviCruiseModeServiceListener();
            this.removeAllLGIServiceListeners();
            this.removeSWDiagnosisManager();
            this.logChannel.log(10000000, "AbstractNavigationActivator#deinitDSIServices - OSGi Services deinitialized");
        }
        catch (Exception exception) {
            this.logChannel.log(10000, "AbstractNavigationActivator#deinitDSIServices - Problem during OSGi Service deinit %1", (Throwable)exception);
        }
    }

    private void removeTrafficMiniMap() {
        this.navigation.getTrafficMiniMap().stopDSI(this.getBundleContext());
    }

    public Object addingService(ServiceReference serviceReference) {
        Object object = this.bundleContext.getService(serviceReference);
        String string = null;
        try {
            string = (String)serviceReference.getProperty("ApplicationName");
        }
        catch (NullPointerException nullPointerException) {
            this.logChannel.log(10000, "addingService: Empty reference! ");
            return null;
        }
        if (string != null && string.equals("AddressBookInterHMIAppService")) {
            return this.addADBHMIAppService((ADBHMIAppService)object);
        }
        if (string != null && string.equals("AppPhone")) {
            this.logChannel.log(10000000, "addingService: AppPhone service added! ");
            this.navigation.getPhoneGateway().setPhoneService((PhoneService)object);
            return object;
        }
        Object object2 = serviceReference.getProperty("DEVICE_NAME");
        Object object3 = serviceReference.getProperty("DEVICE_INSTANCE");
        this.logChannel.log(10000000, "AbstractNavigationActivator#addingService() - deviceName: %1, deviceInstance: %2", object2, object3);
        if (object2 != null) {
            NaviADBHandler naviADBHandler = this.navigation.getNaviADBHandler();
            if (object2.equals((class$org$dsi$ifc$navigation$DSINavigation == null ? (class$org$dsi$ifc$navigation$DSINavigation = AbstractNavigationActivator.class$("org.dsi.ifc.navigation.DSINavigation")) : class$org$dsi$ifc$navigation$DSINavigation).getName())) {
                return this.addDSINavigation(serviceReference, (DSINavigation)object, object3, this.navigation);
            }
            if (object2.equals((class$de$audi$atip$interapp$ADBRemoteHMIService == null ? (class$de$audi$atip$interapp$ADBRemoteHMIService = AbstractNavigationActivator.class$("de.audi.atip.interapp.ADBRemoteHMIService")) : class$de$audi$atip$interapp$ADBRemoteHMIService).getName())) {
                return this.addAdbRemoteHMIService((ADBRemoteHMIService)object);
            }
            if (object2.equals((class$org$dsi$ifc$navigation$DSIBlocking == null ? (class$org$dsi$ifc$navigation$DSIBlocking = AbstractNavigationActivator.class$("org.dsi.ifc.navigation.DSIBlocking")) : class$org$dsi$ifc$navigation$DSIBlocking).getName())) {
                return this.addDSIBlocking((DSIBlocking)object, object3);
            }
            if (object2.equals((class$org$dsi$ifc$navigation$DSICombinedRouteList == null ? (class$org$dsi$ifc$navigation$DSICombinedRouteList = AbstractNavigationActivator.class$("org.dsi.ifc.navigation.DSICombinedRouteList")) : class$org$dsi$ifc$navigation$DSICombinedRouteList).getName())) {
                return this.addDSICombinedRouteList((DSICombinedRouteList)object, object3);
            }
            if (object2.equals((class$org$dsi$ifc$map$DSIMapViewerControl == null ? (class$org$dsi$ifc$map$DSIMapViewerControl = AbstractNavigationActivator.class$("org.dsi.ifc.map.DSIMapViewerControl")) : class$org$dsi$ifc$map$DSIMapViewerControl).getName())) {
                return this.addDSIMapControl(serviceReference, (DSIMapViewerControl)object, object3);
            }
            if (object2.equals((class$org$dsi$ifc$map$DSIMapViewerZoomEngine == null ? (class$org$dsi$ifc$map$DSIMapViewerZoomEngine = AbstractNavigationActivator.class$("org.dsi.ifc.map.DSIMapViewerZoomEngine")) : class$org$dsi$ifc$map$DSIMapViewerZoomEngine).getName())) {
                return this.addDSIMapZoomEngine((DSIMapViewerZoomEngine)object, object3);
            }
            if (object2.equals((class$org$dsi$ifc$map$DSIMapViewerManeuverView == null ? (class$org$dsi$ifc$map$DSIMapViewerManeuverView = AbstractNavigationActivator.class$("org.dsi.ifc.map.DSIMapViewerManeuverView")) : class$org$dsi$ifc$map$DSIMapViewerManeuverView).getName())) {
                return this.addDSIMapManeuverView((DSIMapViewerManeuverView)object);
            }
            if (object2.equals((class$org$dsi$ifc$map$DSIMapViewerGoogleCtrl == null ? (class$org$dsi$ifc$map$DSIMapViewerGoogleCtrl = AbstractNavigationActivator.class$("org.dsi.ifc.map.DSIMapViewerGoogleCtrl")) : class$org$dsi$ifc$map$DSIMapViewerGoogleCtrl).getName())) {
                return this.addDSIMapGoogleCtrl(serviceReference, (DSIMapViewerGoogleCtrl)object, object3);
            }
            if (object2.equals((class$org$dsi$ifc$organizer$DSIAdbEdit == null ? (class$org$dsi$ifc$organizer$DSIAdbEdit = AbstractNavigationActivator.class$("org.dsi.ifc.organizer.DSIAdbEdit")) : class$org$dsi$ifc$organizer$DSIAdbEdit).getName())) {
                return this.addDSIAdbEdit(serviceReference, object, object3, naviADBHandler);
            }
            if (object2.equals((class$org$dsi$ifc$organizer$DSIAdbList == null ? (class$org$dsi$ifc$organizer$DSIAdbList = AbstractNavigationActivator.class$("org.dsi.ifc.organizer.DSIAdbList")) : class$org$dsi$ifc$organizer$DSIAdbList).getName())) {
                return this.addDSIAdbList(serviceReference, object, object3, naviADBHandler);
            }
            if (object2.equals((class$org$dsi$ifc$organizer$DSIAdbUserProfile == null ? (class$org$dsi$ifc$organizer$DSIAdbUserProfile = AbstractNavigationActivator.class$("org.dsi.ifc.organizer.DSIAdbUserProfile")) : class$org$dsi$ifc$organizer$DSIAdbUserProfile).getName())) {
                return this.addDSIAdbuserProfile(serviceReference, object, object3, naviADBHandler);
            }
            if (object2.equals((class$org$dsi$ifc$organizer$DSIAdbSetup == null ? (class$org$dsi$ifc$organizer$DSIAdbSetup = AbstractNavigationActivator.class$("org.dsi.ifc.organizer.DSIAdbSetup")) : class$org$dsi$ifc$organizer$DSIAdbSetup).getName())) {
                return this.addDSIAdbSetup(serviceReference, object, object3, naviADBHandler);
            }
            if (object2.equals((class$org$dsi$ifc$tmc$DSITmcOnRoute == null ? (class$org$dsi$ifc$tmc$DSITmcOnRoute = AbstractNavigationActivator.class$("org.dsi.ifc.tmc.DSITmcOnRoute")) : class$org$dsi$ifc$tmc$DSITmcOnRoute).getName())) {
                return this.addDSITmcOnRoute((DSITmcOnRoute)object);
            }
            if (object2.equals((class$de$audi$atip$interapp$navtmc$TMCService == null ? (class$de$audi$atip$interapp$navtmc$TMCService = AbstractNavigationActivator.class$("de.audi.atip.interapp.navtmc.TMCService")) : class$de$audi$atip$interapp$navtmc$TMCService).getName())) {
                return this.addTMCService((TMCService)object);
            }
            if (object2.equals((class$de$audi$atip$interapp$icon$RenderingInfoProvider == null ? (class$de$audi$atip$interapp$icon$RenderingInfoProvider = AbstractNavigationActivator.class$("de.audi.atip.interapp.icon.RenderingInfoProvider")) : class$de$audi$atip$interapp$icon$RenderingInfoProvider).getName())) {
                return this.addRenderingInfoProvider((RenderingInfoProvider)object);
            }
            if (object2.equals((class$de$audi$atip$browser$IBrowserHandler == null ? (class$de$audi$atip$browser$IBrowserHandler = AbstractNavigationActivator.class$("de.audi.atip.browser.IBrowserHandler")) : class$de$audi$atip$browser$IBrowserHandler).getName())) {
                return this.addBrowserHandler(serviceReference, (IBrowserHandler)object, object3);
            }
            if (object2.equals((class$org$dsi$ifc$online$DSIPoiOnlineSearch == null ? (class$org$dsi$ifc$online$DSIPoiOnlineSearch = AbstractNavigationActivator.class$("org.dsi.ifc.online.DSIPoiOnlineSearch")) : class$org$dsi$ifc$online$DSIPoiOnlineSearch).getName())) {
                return this.addDSIPoiOnlineSearch((DSIPoiOnlineSearch)object);
            }
            if (object2.equals((class$org$dsi$ifc$komonavinfo$DSIKOMONavInfo == null ? (class$org$dsi$ifc$komonavinfo$DSIKOMONavInfo = AbstractNavigationActivator.class$("org.dsi.ifc.komonavinfo.DSIKOMONavInfo")) : class$org$dsi$ifc$komonavinfo$DSIKOMONavInfo).getName())) {
                return this.addDSIKOMONavInfo((DSIKOMONavInfo)object);
            }
            if (object2.equals((class$org$dsi$ifc$komoview$DSIKOMOView == null ? (class$org$dsi$ifc$komoview$DSIKOMOView = AbstractNavigationActivator.class$("org.dsi.ifc.komoview.DSIKOMOView")) : class$org$dsi$ifc$komoview$DSIKOMOView).getName())) {
                return this.addDSIKOMOView((DSIKOMOView)object);
            }
            if (object2.equals((class$org$dsi$ifc$komogfxstreamsink$DSIKOMOGfxStreamSink == null ? (class$org$dsi$ifc$komogfxstreamsink$DSIKOMOGfxStreamSink = AbstractNavigationActivator.class$("org.dsi.ifc.komogfxstreamsink.DSIKOMOGfxStreamSink")) : class$org$dsi$ifc$komogfxstreamsink$DSIKOMOGfxStreamSink).getName())) {
                return this.addDSIKOMOGfxStreamSink((DSIKOMOGfxStreamSink)object);
            }
            if (object2.equals((class$org$dsi$ifc$trafficregulation$DSITrafficRegulation == null ? (class$org$dsi$ifc$trafficregulation$DSITrafficRegulation = AbstractNavigationActivator.class$("org.dsi.ifc.trafficregulation.DSITrafficRegulation")) : class$org$dsi$ifc$trafficregulation$DSITrafficRegulation).getName())) {
                return this.addDSITrafficRegulation((DSITrafficRegulation)object);
            }
            if (object2.equals((class$de$audi$atip$interapp$navcar$CarNavListener == null ? (class$de$audi$atip$interapp$navcar$CarNavListener = AbstractNavigationActivator.class$("de.audi.atip.interapp.navcar.CarNavListener")) : class$de$audi$atip$interapp$navcar$CarNavListener).getName())) {
                return this.addCarNavListenerService((CarNavListener)object);
            }
            if (object2.equals((class$de$audi$atip$interapp$navuota$UotaNavListener == null ? (class$de$audi$atip$interapp$navuota$UotaNavListener = AbstractNavigationActivator.class$("de.audi.atip.interapp.navuota.UotaNavListener")) : class$de$audi$atip$interapp$navuota$UotaNavListener).getName())) {
                return this.addUotaNavListenerService((UotaNavListener)object);
            }
            if (object2.equals((class$de$audi$atip$interapp$online$OnlineServiceProvider == null ? (class$de$audi$atip$interapp$online$OnlineServiceProvider = AbstractNavigationActivator.class$("de.audi.atip.interapp.online.OnlineServiceProvider")) : class$de$audi$atip$interapp$online$OnlineServiceProvider).getName())) {
                return this.addOnlineServiceProvider((OnlineServiceProvider)object);
            }
            if (object2.equals((class$de$audi$atip$interapp$IConnectivityNaviStateListener == null ? (class$de$audi$atip$interapp$IConnectivityNaviStateListener = AbstractNavigationActivator.class$("de.audi.atip.interapp.IConnectivityNaviStateListener")) : class$de$audi$atip$interapp$IConnectivityNaviStateListener).getName())) {
                return this.addConnectivityNaviStateListener((IConnectivityNaviStateListener)object);
            }
            if (object2.equals((class$de$audi$atip$interapp$MapServiceListener == null ? (class$de$audi$atip$interapp$MapServiceListener = AbstractNavigationActivator.class$("de.audi.atip.interapp.MapServiceListener")) : class$de$audi$atip$interapp$MapServiceListener).getName())) {
                return this.addMapServiceListener((MapServiceListener)object);
            }
            if (object2.equals((class$org$dsi$ifc$mobilityhorizon$DSIMobilityHorizon == null ? (class$org$dsi$ifc$mobilityhorizon$DSIMobilityHorizon = AbstractNavigationActivator.class$("org.dsi.ifc.mobilityhorizon.DSIMobilityHorizon")) : class$org$dsi$ifc$mobilityhorizon$DSIMobilityHorizon).getName())) {
                return this.addDSIMobilityHorizon((DSIMobilityHorizon)object);
            }
            if (object2.equals((class$de$audi$atip$interapp$navcar$ILGIServiceListener == null ? (class$de$audi$atip$interapp$navcar$ILGIServiceListener = AbstractNavigationActivator.class$("de.audi.atip.interapp.navcar.ILGIServiceListener")) : class$de$audi$atip$interapp$navcar$ILGIServiceListener).getName())) {
                return this.addLGIServiceListener((ILGIServiceListener)object);
            }
            if (object2.equals((class$de$audi$atip$interapp$picturestore$PictureStoreProvider == null ? (class$de$audi$atip$interapp$picturestore$PictureStoreProvider = AbstractNavigationActivator.class$("de.audi.atip.interapp.picturestore.PictureStoreProvider")) : class$de$audi$atip$interapp$picturestore$PictureStoreProvider).getName())) {
                return this.addPictureStoreProvider(serviceReference, (PictureStoreProvider)object);
            }
        } else {
            if (object instanceof ADBRemoteHMIService) {
                return this.addAdbRemoteHMIService((ADBRemoteHMIService)object);
            }
            if (object instanceof IViewSizeManager) {
                return this.addViewSizeManager((IViewSizeManager)object);
            }
            if (object instanceof OnlineServiceProvider) {
                return this.addOnlineServiceProvider((OnlineServiceProvider)object);
            }
            if (object instanceof CombiService) {
                return this.addCombiService((CombiService)object);
            }
            if (object instanceof AbstractRSEConnection) {
                return this.addRSEConnection((AbstractRSEConnection)object);
            }
            if (object instanceof CombiBAPServiceNavi) {
                return this.addCombiBAPServiceNavi((CombiBAPServiceNavi)object);
            }
            if (object instanceof NaviSDSPOIOnlineServiceListener) {
                return this.addNaviSDSPOIOnlineServiceListener((NaviSDSPOIOnlineServiceListener)object);
            }
            if (object instanceof SwDiagnosisManager) {
                return this.addSWDiagnosisManager(object);
            }
            if (object instanceof IAdapterManager) {
                return this.addIAdapterManager((IAdapterManager)object);
            }
            if (object instanceof HMIAudioService) {
                return this.addAudioService(serviceReference, (HMIAudioService)object);
            }
            if (object instanceof WavePlayer) {
                return this.addWavePlayer((WavePlayer)object);
            }
            if (object instanceof INaviPicNavService) {
                return this.addNaviPicNavService((INaviPicNavService)object);
            }
            if (object instanceof IOnlineService) {
                return this.addIOnlineService(serviceReference, (IOnlineService)object);
            }
            if (object instanceof INaviTabletServiceListener) {
                return this.addTabletService((INaviTabletServiceListener)object);
            }
            if (object instanceof IOnlineDestinationService) {
                return this.addIOnlineDestinationService((IOnlineDestinationService)object);
            }
            if (object instanceof IConnectivityNaviStateListener) {
                return this.addConnectivityNaviStateListener((IConnectivityNaviStateListener)object);
            }
            if (object instanceof MapServiceListener) {
                return this.addMapServiceListener((MapServiceListener)object);
            }
            if (object instanceof AudiEnergyAssistService) {
                return this.addAudiEnergyAssistService((AudiEnergyAssistService)object);
            }
            if (object instanceof IOperatorCallNaviService) {
                return this.addOperatorCallService((IOperatorCallNaviService)object);
            }
            if (object instanceof IAnnouncementStateListener) {
                return this.addIAnnouncementStateListener((IAnnouncementStateListener)object);
            }
            if (object instanceof NaviCruiseModeServiceListener) {
                return this.addNaviCruiseModeServiceListener((NaviCruiseModeServiceListener)object);
            }
            if (object instanceof ILGIServiceListener) {
                return this.addLGIServiceListener((ILGIServiceListener)object);
            }
        }
        this.logChannel.log(100000, "AbstractNavigationActivator#addingService() - unknown service: %1, deviceName: %2 ", (Object)serviceReference, object2);
        this.bundleContext.ungetService(serviceReference);
        return null;
    }

    private Object addSWDiagnosisManager(Object object) {
        this.swDiagnosisManager = (SwDiagnosisManager)object;
        this.swDiagnosisManager.addDiagGateway((AbstractSwDiagnosis)this.navigation.getNavigationDiag());
        this.swDiagnosisManager.addDiagGateway((AbstractSwDiagnosis)this.navigation.getMixedListDiag());
        return this.swDiagnosisManager;
    }

    private void removeSWDiagnosisManager() {
        if (this.swDiagnosisManager == null) {
            return;
        }
        this.swDiagnosisManager.removeDiagGateway((AbstractSwDiagnosis)this.navigation.getNavigationDiag());
        this.swDiagnosisManager.removeDiagGateway((AbstractSwDiagnosis)this.navigation.getMixedListDiag());
        this.swDiagnosisManager = null;
    }

    private Object addDSIAdbSetup(ServiceReference serviceReference, Object object, Object object2, NaviADBHandler naviADBHandler) {
        if ((Integer)object2 == 2 && naviADBHandler != null && naviADBHandler.getADBDSIAccess() != null) {
            naviADBHandler.getADBDSIAccess().setDSIAdbSetup((DSIAdbSetup)object, naviADBHandler.getADBDSIListener());
            return object;
        }
        this.bundleContext.ungetService(serviceReference);
        return null;
    }

    private Object addDSIAdbuserProfile(ServiceReference serviceReference, Object object, Object object2, NaviADBHandler naviADBHandler) {
        if ((Integer)object2 == 2 && naviADBHandler != null && naviADBHandler.getADBDSIAccess() != null) {
            naviADBHandler.getADBDSIAccess().setDSIAdbUserProfile((DSIAdbUserProfile)object, naviADBHandler.getADBDSIListener());
            return object;
        }
        this.bundleContext.ungetService(serviceReference);
        return null;
    }

    private Object addDSIAdbList(ServiceReference serviceReference, Object object, Object object2, NaviADBHandler naviADBHandler) {
        if ((Integer)object2 == 2 && naviADBHandler != null && naviADBHandler.getADBDSIAccess() != null) {
            naviADBHandler.getADBDSIAccess().setDSIAdbList((DSIAdbList)object, naviADBHandler.getADBDSIListener());
            return object;
        }
        this.bundleContext.ungetService(serviceReference);
        return null;
    }

    private Object addDSIAdbEdit(ServiceReference serviceReference, Object object, Object object2, NaviADBHandler naviADBHandler) {
        if ((Integer)object2 == 2 && naviADBHandler != null && naviADBHandler.getADBDSIAccess() != null) {
            naviADBHandler.getADBDSIAccess().setDSIAdbEdit((DSIAdbEdit)object, naviADBHandler.getADBDSIListener());
            return object;
        }
        this.bundleContext.ungetService(serviceReference);
        return null;
    }

    private ADBHMIAppService addADBHMIAppService(ADBHMIAppService aDBHMIAppService) {
        this.navigation.getIntelliDestAccess().setADBHMIAppService(aDBHMIAppService);
        this.navigation.setADBHMIAppService(aDBHMIAppService);
        return aDBHMIAppService;
    }

    private void removeADBHMIAppService() {
        this.navigation.getIntelliDestAccess().setADBHMIAppService(null);
        this.navigation.setADBHMIAppService(null);
    }

    private Object addViewSizeManager(IViewSizeManager iViewSizeManager) {
        IViewSizeManager iViewSizeManager2 = iViewSizeManager;
        this.navigation.setViewSizeManager(iViewSizeManager2);
        return iViewSizeManager;
    }

    private void removeViewSizeManager() {
        this.navigation.setViewSizeManager(null);
    }

    private Object addAudiEnergyAssistService(AudiEnergyAssistService audiEnergyAssistService) {
        this.navigation.getAeaService().setAudiEnergyAssistService(audiEnergyAssistService);
        return audiEnergyAssistService;
    }

    private Object addIAnnouncementStateListener(IAnnouncementStateListener iAnnouncementStateListener) {
        this.navigation.getSpeechManager().addAnnouncementStateListener(iAnnouncementStateListener);
        return iAnnouncementStateListener;
    }

    private void removeIAnnouncementStateListener(IAnnouncementStateListener iAnnouncementStateListener) {
        this.navigation.getSpeechManager().removeAnnouncementStateListener(iAnnouncementStateListener);
    }

    private void removeAudiEnergyAssistService() {
        this.navigation.getAeaService().setAudiEnergyAssistService(null);
    }

    public void modifiedService(ServiceReference serviceReference, Object object) {
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void removedService(ServiceReference serviceReference, Object object) {
        this.logChannel.log(10000000, "AbstractNavigationActivator#removedService(): reference = %1, object = %2", (Object)serviceReference, object);
        if (this.bundleContext == null || serviceReference == null) {
            this.logChannel.log(10000, "removedService: bundleContext %1 isShuttingDown %3 serviceReference %2 ! ", (Object)this.bundleContext, (Object)serviceReference);
            return;
        }
        try {
            if (!this.isServiceDeregistrationAllowed) {
                this.logChannel.log(10000000, "removedService: isServiceDeregistrationAllowed %1 ! ", this.isServiceDeregistrationAllowed);
                return;
            }
            String string = null;
            try {
                string = (String)serviceReference.getProperty("ApplicationName");
            }
            catch (NullPointerException nullPointerException) {
                this.logChannel.log(10000, "removedService: Empty reference! ");
                this.bundleContext.ungetService(serviceReference);
                return;
            }
            if ("AddressBookInterHMIAppService".equals(string)) {
                this.removeADBHMIAppService();
                return;
            }
            if ("AppPhone".equals(string)) {
                this.removePhoneService();
                return;
            }
            Object object2 = serviceReference.getProperty("DEVICE_NAME");
            Object object3 = serviceReference.getProperty("DEVICE_INSTANCE");
            this.logChannel.log(10000000, "AbstractNavigationActivator#removedService(): device name = %1, instance = %2", object2, object3);
            if (object2 != null) {
                if (object2.equals((class$org$dsi$ifc$navigation$DSINavigation == null ? (class$org$dsi$ifc$navigation$DSINavigation = AbstractNavigationActivator.class$("org.dsi.ifc.navigation.DSINavigation")) : class$org$dsi$ifc$navigation$DSINavigation).getName())) {
                    this.removeDSINavigation((DSINavigation)object, object3);
                } else if (object2.equals((class$de$audi$atip$interapp$ADBRemoteHMIService == null ? (class$de$audi$atip$interapp$ADBRemoteHMIService = AbstractNavigationActivator.class$("de.audi.atip.interapp.ADBRemoteHMIService")) : class$de$audi$atip$interapp$ADBRemoteHMIService).getName())) {
                    this.removeAdbRemoteHMIService();
                } else if (object2.equals((class$org$dsi$ifc$navigation$DSIBlocking == null ? (class$org$dsi$ifc$navigation$DSIBlocking = AbstractNavigationActivator.class$("org.dsi.ifc.navigation.DSIBlocking")) : class$org$dsi$ifc$navigation$DSIBlocking).getName())) {
                    this.removeDSIBlocking((DSIBlocking)object, object3);
                } else if (object2.equals((class$org$dsi$ifc$navigation$DSICombinedRouteList == null ? (class$org$dsi$ifc$navigation$DSICombinedRouteList = AbstractNavigationActivator.class$("org.dsi.ifc.navigation.DSICombinedRouteList")) : class$org$dsi$ifc$navigation$DSICombinedRouteList).getName())) {
                    this.removeDSICombinedRouteList((DSICombinedRouteList)object, object3);
                } else if (object2.equals((class$org$dsi$ifc$map$DSIMapViewerControl == null ? (class$org$dsi$ifc$map$DSIMapViewerControl = AbstractNavigationActivator.class$("org.dsi.ifc.map.DSIMapViewerControl")) : class$org$dsi$ifc$map$DSIMapViewerControl).getName())) {
                    this.removeDSIMapControl((DSIMapViewerControl)object, object3);
                } else if (object2.equals((class$org$dsi$ifc$map$DSIMapViewerZoomEngine == null ? (class$org$dsi$ifc$map$DSIMapViewerZoomEngine = AbstractNavigationActivator.class$("org.dsi.ifc.map.DSIMapViewerZoomEngine")) : class$org$dsi$ifc$map$DSIMapViewerZoomEngine).getName())) {
                    this.removeDSIMapZoomEngine(object3);
                } else if (object2.equals((class$org$dsi$ifc$map$DSIMapViewerManeuverView == null ? (class$org$dsi$ifc$map$DSIMapViewerManeuverView = AbstractNavigationActivator.class$("org.dsi.ifc.map.DSIMapViewerManeuverView")) : class$org$dsi$ifc$map$DSIMapViewerManeuverView).getName())) {
                    this.removeDSIMapManeuverView();
                } else if (object2.equals((class$org$dsi$ifc$map$DSIMapViewerGoogleCtrl == null ? (class$org$dsi$ifc$map$DSIMapViewerGoogleCtrl = AbstractNavigationActivator.class$("org.dsi.ifc.map.DSIMapViewerGoogleCtrl")) : class$org$dsi$ifc$map$DSIMapViewerGoogleCtrl).getName())) {
                    this.removeDSIMapGoogleCtrl((DSIMapViewerGoogleCtrl)object, object3);
                } else if (object2.equals((class$de$audi$atip$interapp$icon$RenderingInfoProvider == null ? (class$de$audi$atip$interapp$icon$RenderingInfoProvider = AbstractNavigationActivator.class$("de.audi.atip.interapp.icon.RenderingInfoProvider")) : class$de$audi$atip$interapp$icon$RenderingInfoProvider).getName())) {
                    this.removeRenderingInfoProvider();
                } else if (object2.equals((class$org$dsi$ifc$tmc$DSITmcOnRoute == null ? (class$org$dsi$ifc$tmc$DSITmcOnRoute = AbstractNavigationActivator.class$("org.dsi.ifc.tmc.DSITmcOnRoute")) : class$org$dsi$ifc$tmc$DSITmcOnRoute).getName())) {
                    this.removeDSITmcOnRoute();
                } else if (object2.equals((class$de$audi$atip$browser$IBrowserHandler == null ? (class$de$audi$atip$browser$IBrowserHandler = AbstractNavigationActivator.class$("de.audi.atip.browser.IBrowserHandler")) : class$de$audi$atip$browser$IBrowserHandler).getName())) {
                    this.removeBrowserHandler((IBrowserHandler)object, object3);
                } else if (object2.equals((class$org$dsi$ifc$online$DSIPoiOnlineSearch == null ? (class$org$dsi$ifc$online$DSIPoiOnlineSearch = AbstractNavigationActivator.class$("org.dsi.ifc.online.DSIPoiOnlineSearch")) : class$org$dsi$ifc$online$DSIPoiOnlineSearch).getName())) {
                    this.removeDSIOnline();
                } else if (object2.equals((class$org$dsi$ifc$komonavinfo$DSIKOMONavInfo == null ? (class$org$dsi$ifc$komonavinfo$DSIKOMONavInfo = AbstractNavigationActivator.class$("org.dsi.ifc.komonavinfo.DSIKOMONavInfo")) : class$org$dsi$ifc$komonavinfo$DSIKOMONavInfo).getName())) {
                    this.removeDSIKOMONavInfo();
                } else if (object2.equals((class$org$dsi$ifc$komoview$DSIKOMOView == null ? (class$org$dsi$ifc$komoview$DSIKOMOView = AbstractNavigationActivator.class$("org.dsi.ifc.komoview.DSIKOMOView")) : class$org$dsi$ifc$komoview$DSIKOMOView).getName())) {
                    this.removeDSIKOMOView((DSIKOMOView)object);
                } else if (object2.equals((class$org$dsi$ifc$komogfxstreamsink$DSIKOMOGfxStreamSink == null ? (class$org$dsi$ifc$komogfxstreamsink$DSIKOMOGfxStreamSink = AbstractNavigationActivator.class$("org.dsi.ifc.komogfxstreamsink.DSIKOMOGfxStreamSink")) : class$org$dsi$ifc$komogfxstreamsink$DSIKOMOGfxStreamSink).getName())) {
                    this.removeDSIKOMOGfxStreamSink();
                } else if (object2.equals((class$org$dsi$ifc$trafficregulation$DSITrafficRegulation == null ? (class$org$dsi$ifc$trafficregulation$DSITrafficRegulation = AbstractNavigationActivator.class$("org.dsi.ifc.trafficregulation.DSITrafficRegulation")) : class$org$dsi$ifc$trafficregulation$DSITrafficRegulation).getName())) {
                    this.removeDSITrafficRegulation();
                } else if (object2.equals((class$org$dsi$ifc$organizer$DSIAdbEdit == null ? (class$org$dsi$ifc$organizer$DSIAdbEdit = AbstractNavigationActivator.class$("org.dsi.ifc.organizer.DSIAdbEdit")) : class$org$dsi$ifc$organizer$DSIAdbEdit).getName())) {
                    this.removeDSIAdbEdit(object3);
                } else if (object2.equals((class$org$dsi$ifc$organizer$DSIAdbList == null ? (class$org$dsi$ifc$organizer$DSIAdbList = AbstractNavigationActivator.class$("org.dsi.ifc.organizer.DSIAdbList")) : class$org$dsi$ifc$organizer$DSIAdbList).getName())) {
                    this.removeDSIAdbList(object3);
                } else if (object2.equals((class$org$dsi$ifc$organizer$DSIAdbUserProfile == null ? (class$org$dsi$ifc$organizer$DSIAdbUserProfile = AbstractNavigationActivator.class$("org.dsi.ifc.organizer.DSIAdbUserProfile")) : class$org$dsi$ifc$organizer$DSIAdbUserProfile).getName())) {
                    this.removeDSIAdbUserProfile(object3);
                } else if (object2.equals((class$org$dsi$ifc$organizer$DSIAdbSetup == null ? (class$org$dsi$ifc$organizer$DSIAdbSetup = AbstractNavigationActivator.class$("org.dsi.ifc.organizer.DSIAdbSetup")) : class$org$dsi$ifc$organizer$DSIAdbSetup).getName())) {
                    this.removeDSIAdbSetup(object3);
                } else if (object2.equals((class$de$audi$atip$interapp$online$OnlineServiceProvider == null ? (class$de$audi$atip$interapp$online$OnlineServiceProvider = AbstractNavigationActivator.class$("de.audi.atip.interapp.online.OnlineServiceProvider")) : class$de$audi$atip$interapp$online$OnlineServiceProvider).getName())) {
                    this.removeOnlineServiceProvider();
                } else if (object2.equals((class$de$audi$atip$interapp$IConnectivityNaviStateListener == null ? (class$de$audi$atip$interapp$IConnectivityNaviStateListener = AbstractNavigationActivator.class$("de.audi.atip.interapp.IConnectivityNaviStateListener")) : class$de$audi$atip$interapp$IConnectivityNaviStateListener).getName())) {
                    this.removeConnectivityNaviStateListener();
                } else if (object2.equals((class$de$audi$atip$interapp$MapServiceListener == null ? (class$de$audi$atip$interapp$MapServiceListener = AbstractNavigationActivator.class$("de.audi.atip.interapp.MapServiceListener")) : class$de$audi$atip$interapp$MapServiceListener).getName())) {
                    this.removeMapServiceListener();
                } else if (object2.equals((class$de$audi$atip$interapp$navtmc$TMCService == null ? (class$de$audi$atip$interapp$navtmc$TMCService = AbstractNavigationActivator.class$("de.audi.atip.interapp.navtmc.TMCService")) : class$de$audi$atip$interapp$navtmc$TMCService).getName())) {
                    this.removeTMCService();
                } else if (object2.equals((class$de$audi$atip$interapp$navcar$CarNavListener == null ? (class$de$audi$atip$interapp$navcar$CarNavListener = AbstractNavigationActivator.class$("de.audi.atip.interapp.navcar.CarNavListener")) : class$de$audi$atip$interapp$navcar$CarNavListener).getName())) {
                    this.removeCarNavListenerService((CarNavListener)object);
                } else if (object2.equals((class$de$audi$atip$interapp$navuota$UotaNavListener == null ? (class$de$audi$atip$interapp$navuota$UotaNavListener = AbstractNavigationActivator.class$("de.audi.atip.interapp.navuota.UotaNavListener")) : class$de$audi$atip$interapp$navuota$UotaNavListener).getName())) {
                    this.removeUotaNavListenerService();
                } else if (object2.equals((class$org$dsi$ifc$mobilityhorizon$DSIMobilityHorizon == null ? (class$org$dsi$ifc$mobilityhorizon$DSIMobilityHorizon = AbstractNavigationActivator.class$("org.dsi.ifc.mobilityhorizon.DSIMobilityHorizon")) : class$org$dsi$ifc$mobilityhorizon$DSIMobilityHorizon).getName())) {
                    this.removeDSIMobilityHorizon();
                } else if (object2.equals((class$de$audi$atip$interapp$navcar$ILGIServiceListener == null ? (class$de$audi$atip$interapp$navcar$ILGIServiceListener = AbstractNavigationActivator.class$("de.audi.atip.interapp.navcar.ILGIServiceListener")) : class$de$audi$atip$interapp$navcar$ILGIServiceListener).getName())) {
                    this.removeLGIServiceListener((ILGIServiceListener)object);
                } else if (object2.equals((class$de$audi$atip$interapp$picturestore$PictureStoreProvider == null ? (class$de$audi$atip$interapp$picturestore$PictureStoreProvider = AbstractNavigationActivator.class$("de.audi.atip.interapp.picturestore.PictureStoreProvider")) : class$de$audi$atip$interapp$picturestore$PictureStoreProvider).getName())) {
                    this.removePictureStoreProvider(serviceReference, (PictureStoreProvider)object);
                } else {
                    this.logChannel.log(100000, "AbstractNavigationActivator#removedService unknown device name: reference = %1, object = %2", (Object)serviceReference, object);
                }
            } else if (object instanceof OnlineServiceProvider) {
                this.removeOnlineServiceProvider();
            } else if (object instanceof ADBRemoteHMIService) {
                this.removeAdbRemoteHMIService();
            } else if (object instanceof CombiService) {
                this.removeCombiService();
            } else if (object instanceof AbstractRSEConnection) {
                this.removeRSEConnection();
            } else if (object instanceof CombiBAPServiceNavi) {
                this.removeCombiBAPServiceNavi();
            } else if (object instanceof NaviSDSPOIOnlineServiceListener) {
                this.removeNaviSDSPOIOnlineServiceListener((NaviSDSPOIOnlineServiceListener)object);
            } else if (object instanceof SwDiagnosisManager) {
                this.removeSWDiagnosisManager();
            } else if (object instanceof IAdapterManager) {
                this.removeIAdapterManager();
            } else if (object instanceof HMIAudioService) {
                this.removeAudioService();
            } else if (object instanceof WavePlayer) {
                this.removeWavePlayer();
            } else if (object instanceof INaviPicNavService) {
                this.removeNaviPicNavService();
            } else if (object instanceof IOnlineService) {
                this.removeIOnlineService(serviceReference);
            } else if (object instanceof INaviTabletServiceListener) {
                this.removeTabletService();
            } else if (object instanceof IOnlineDestinationService) {
                this.removeIOnlineDestinationService();
            } else if (object instanceof IViewSizeManager) {
                this.removeViewSizeManager();
            } else if (object instanceof IConnectivityNaviStateListener) {
                this.removeConnectivityNaviStateListener();
            } else if (object instanceof MapServiceListener) {
                this.removeMapServiceListener();
            } else if (object instanceof AudiEnergyAssistService) {
                this.removeAudiEnergyAssistService();
            } else if (object instanceof IOperatorCallNaviService) {
                this.removeOperatorCallService();
            } else if (object instanceof IAnnouncementStateListener) {
                this.removeIAnnouncementStateListener((IAnnouncementStateListener)object);
            } else if (object instanceof NaviCruiseModeServiceListener) {
                this.removeNaviCruiseModeServiceListener();
            } else if (object instanceof ILGIServiceListener) {
                this.removeLGIServiceListener((ILGIServiceListener)object);
            } else {
                this.logChannel.log(100000, "AbstractNavigationActivator#removedService unknown service: reference = %1, object = %2", (Object)serviceReference, object);
            }
        }
        finally {
            this.bundleContext.ungetService(serviceReference);
        }
    }

    private DSINavigation addDSINavigation(ServiceReference serviceReference, DSINavigation dSINavigation, Object object, Navigation navigation) {
        if (DEV_INST_DSINAV_MAIN.equals(object)) {
            this.serviceReferenceDSINavigationMain = serviceReference;
            navigation.getNavigationStartup().setDSINavigation(dSINavigation, 0);
        } else if (DEVICEINSTANCE_DSINAVIGATION_REMOTE.equals(object)) {
            this.serviceReferenceDSINavigationRemote = serviceReference;
            navigation.getNavigationStartup().setDSINavigation(dSINavigation, 1);
        }
        if (this.serviceReferenceDSINavigationMain != null || this.serviceReferenceDSINavigationRemote != null) {
            this.registerI18NTarget(navigation);
        }
        return dSINavigation;
    }

    private void removeDSINavigation(DSINavigation dSINavigation, Object object) {
        if (DEV_INST_DSINAV_MAIN.equals(object)) {
            this.doremoveDSINavigationMain();
        } else if (DEVICEINSTANCE_DSINAVIGATION_REMOTE.equals(object)) {
            this.doremoveDSINavigationRemote();
        }
        if (this.serviceReferenceDSINavigationMain == null && this.serviceReferenceDSINavigationRemote == null) {
            this.unregisterI18NTarget();
        }
    }

    private void removeDSIAdbSetup(Object object) {
        if ((Integer)object == 2) {
            this.doremoveDSIAdbSetup();
        }
    }

    private void doremoveDSIAdbSetup() {
        NaviADBHandler naviADBHandler = this.navigation.getNaviADBHandler();
        if (naviADBHandler != null && naviADBHandler.getADBDSIAccess() != null) {
            naviADBHandler.getADBDSIAccess().clearDSIAdbSetup(naviADBHandler.getADBDSIListener());
        }
    }

    private void removeDSIAdbUserProfile(Object object) {
        if ((Integer)object == 2) {
            this.doremoveDSIAdbuserprofile();
        }
    }

    private void doremoveDSIAdbuserprofile() {
        NaviADBHandler naviADBHandler = this.navigation.getNaviADBHandler();
        if (naviADBHandler != null && naviADBHandler.getADBDSIAccess() != null) {
            naviADBHandler.getADBDSIAccess().clearDSIAdbUserProfile(naviADBHandler.getADBDSIListener());
        }
    }

    private void removeDSIAdbList(Object object) {
        if ((Integer)object == 2) {
            this.doRemoveDSIAdbList();
        }
    }

    private void doRemoveDSIAdbList() {
        NaviADBHandler naviADBHandler = this.navigation.getNaviADBHandler();
        if (naviADBHandler != null && naviADBHandler.getADBDSIAccess() != null) {
            naviADBHandler.getADBDSIAccess().clearDSIAdbList(naviADBHandler.getADBDSIListener());
        }
    }

    private void removeDSIAdbEdit(Object object) {
        if ((Integer)object == 2) {
            this.doremoveDSIAdbEdit();
        }
    }

    private void doremoveDSIAdbEdit() {
        NaviADBHandler naviADBHandler = this.navigation.getNaviADBHandler();
        if (naviADBHandler != null && naviADBHandler.getADBDSIAccess() != null) {
            naviADBHandler.getADBDSIAccess().clearDSIAdbEdit(naviADBHandler.getADBDSIListener());
        }
    }

    private void removePhoneService() {
        this.navigation.getPhoneGateway().setPhoneService(null);
    }

    private void doremoveDSINavigationRemote() {
        this.navigation.getNavigationStartup().clearNotificationsAll(1);
        this.serviceReferenceDSINavigationRemote = null;
        this.navigation.getNavigationStartup().setDSINavigation(null, 1);
    }

    private void doremoveDSINavigationMain() {
        this.navigation.getNavigationStartup().clearNotificationsAll(0);
        this.serviceReferenceDSINavigationMain = null;
        this.navigation.getNavigationStartup().setDSINavigation(null, 0);
    }

    private DSIBlocking addDSIBlocking(DSIBlocking dSIBlocking, Object object) {
        if (DEV_INST_DSINAV_MAIN.equals(object)) {
            this.navigation.getNavigationStartup().setDSIBlocking(dSIBlocking, 0);
        } else if (DEVICEINSTANCE_DSINAVIGATION_REMOTE.equals(object)) {
            this.navigation.getNavigationStartup().setDSIBlocking(dSIBlocking, 1);
        }
        return dSIBlocking;
    }

    private void removeDSIBlocking(DSIBlocking dSIBlocking, Object object) {
        if (DEV_INST_DSINAV_MAIN.equals(object)) {
            this.doRemoveDSIBlockingMain();
        } else if (DEVICEINSTANCE_DSINAVIGATION_REMOTE.equals(object)) {
            this.doRemoveDSIBlockingRemote();
        }
    }

    private void doRemoveDSIBlockingRemote() {
        this.navigation.getNavigationStartup().setDSIBlocking(null, 1);
    }

    private void doRemoveDSIBlockingMain() {
        this.navigation.getNavigationStartup().setDSIBlocking(null, 0);
    }

    private DSICombinedRouteList addDSICombinedRouteList(DSICombinedRouteList dSICombinedRouteList, Object object) {
        if (DEV_INST_DSINAV_MAIN.equals(object)) {
            this.navigation.getNavigationStartup().setDSICombinedRouteList(dSICombinedRouteList, 0);
        } else if (DEVICEINSTANCE_DSINAVIGATION_REMOTE.equals(object)) {
            this.navigation.getNavigationStartup().setDSICombinedRouteList(dSICombinedRouteList, 1);
        }
        return dSICombinedRouteList;
    }

    private void removeDSICombinedRouteList(DSICombinedRouteList dSICombinedRouteList, Object object) {
        if (DEV_INST_DSINAV_MAIN.equals(object)) {
            this.doRemoveDSICombinedRouteListMain();
        } else if (DEVICEINSTANCE_DSINAVIGATION_REMOTE.equals(object)) {
            this.doRemoveDSICombinedRouteListRemote();
        }
    }

    private void doRemoveDSICombinedRouteListRemote() {
        this.navigation.getNavigationStartup().setDSICombinedRouteList(null, 1);
    }

    private void doRemoveDSICombinedRouteListMain() {
        this.navigation.getNavigationStartup().setDSICombinedRouteList(null, 0);
    }

    private Object addBrowserHandler(ServiceReference serviceReference, IBrowserHandler iBrowserHandler, Object object) {
        int n = -1;
        if (IBrowserHandler.DEVICEINSTANCE_DSIBROWSER_POI.equals(object)) {
            n = 2;
        } else if (IBrowserHandler.DEVICEINSTANCE_DSIBROWSER_BOS.equals(object)) {
            n = 3;
        } else if (IBrowserHandler.DEVICEINSTANCE_DSIBROWSER_GE.equals(object)) {
            n = 4;
        } else if (IBrowserHandler.DEVICEINSTANCE_DSIBROWSER_BOARDBOOK.equals(object)) {
            n = 7;
        } else if (IBrowserHandler.DEVICEINSTANCE_DSIBROWSER_DAB.equals(object)) {
            n = 1;
        } else {
            this.logChannel.log(10000000, "AbstractNavigationActivator#addBrowserHandler() - unknown service:%1", (Object)serviceReference);
        }
        if (n != -1) {
            this.serviceReferenceBrowserHandler[n] = serviceReference;
            this.navigation.getNavigationBrowser().setBrowserHandler(iBrowserHandler, n);
            return iBrowserHandler;
        }
        this.bundleContext.ungetService(serviceReference);
        return null;
    }

    private void removeBrowserHandler(IBrowserHandler iBrowserHandler, Object object) {
        int n = -1;
        if (IBrowserHandler.DEVICEINSTANCE_DSIBROWSER_POI.equals(object)) {
            n = 2;
        } else if (IBrowserHandler.DEVICEINSTANCE_DSIBROWSER_BOS.equals(object)) {
            n = 3;
        } else if (IBrowserHandler.DEVICEINSTANCE_DSIBROWSER_GE.equals(object)) {
            n = 4;
        } else if (IBrowserHandler.DEVICEINSTANCE_DSIBROWSER_BOARDBOOK.equals(object)) {
            n = 7;
        } else if (IBrowserHandler.DEVICEINSTANCE_DSIBROWSER_DAB.equals(object)) {
            n = 1;
        }
        if (n != -1) {
            this.doRemoveBrowserHandlerInstance(n);
        }
    }

    private void doRemoveBrowserHandlerInstance(int n) {
        this.navigation.getNavigationBrowser().setBrowserHandler(null, n);
        this.serviceReferenceBrowserHandler[n] = null;
    }

    private void doRemoveAllBrowserHandlerInstances() {
        this.doRemoveBrowserHandlerInstance(2);
        this.doRemoveBrowserHandlerInstance(3);
        this.doRemoveBrowserHandlerInstance(4);
        this.doRemoveBrowserHandlerInstance(7);
        this.doRemoveBrowserHandlerInstance(1);
    }

    private Object addAudioService(ServiceReference serviceReference, HMIAudioService hMIAudioService) {
        if (!HMIAudioService.CLIENT_NAVI.equals(serviceReference.getProperty("AUDIO_CLIENT_ID"))) {
            this.bundleContext.ungetService(serviceReference);
            return null;
        }
        this.navigation.getAudioStateMachine().setAudioManagement(hMIAudioService);
        return hMIAudioService;
    }

    private void removeAudioService() {
        this.navigation.getAudioStateMachine().setAudioManagement(null);
    }

    private Object addWavePlayer(WavePlayer wavePlayer) {
        INaviAudioHandler iNaviAudioHandler = this.navigation.getNaviAudioHandler();
        if (iNaviAudioHandler != null) {
            this.navigation.getNaviAudioHandler().setWavePlayer(wavePlayer);
        }
        return wavePlayer;
    }

    private void removeWavePlayer() {
        INaviAudioHandler iNaviAudioHandler = this.navigation.getNaviAudioHandler();
        if (iNaviAudioHandler != null) {
            this.navigation.getNaviAudioHandler().setWavePlayer(null);
        }
    }

    private Object addTMCService(TMCService tMCService) {
        this.navigation.getTmcGateway().setService(tMCService);
        if (this.navigation.getRouteCriteriaManager() != null && this.navigation.getEnv() != null && this.navigation.getOperationManager() != null) {
            this.navigation.getTmcGateway().propagateNaviState(this.navigation.getRouteCriteriaManager().getRouteCriteria(), this.navigation.getEnv(), this.navigation.getOperationManager().isFullyOperable());
        }
        return tMCService;
    }

    private void removeTMCService() {
        this.navigation.getTmcGateway().setService(null);
    }

    private Object addRenderingInfoProvider(RenderingInfoProvider renderingInfoProvider) {
        this.navigation.getDsiNavigationManager().getDispatcher(0).updateRenderingInfoProvider(renderingInfoProvider);
        return renderingInfoProvider;
    }

    private void removeRenderingInfoProvider() {
        this.navigation.getDsiNavigationManager().getDispatcher(0).updateRenderingInfoProvider(null);
    }

    private Object addNaviCruiseModeServiceListener(NaviCruiseModeServiceListener naviCruiseModeServiceListener) {
        this.navigation.getMapManager().getCruiseModeHandler().setNaviCruiseModeNotificationService(naviCruiseModeServiceListener);
        return naviCruiseModeServiceListener;
    }

    private void removeNaviCruiseModeServiceListener() {
        this.navigation.getMapManager().getCruiseModeHandler().setNaviCruiseModeNotificationService(null);
    }

    private Object addLGIServiceListener(ILGIServiceListener iLGIServiceListener) {
        this.navigation.getLGIInterAppServiceHandler().addListener(iLGIServiceListener);
        return iLGIServiceListener;
    }

    private void removeLGIServiceListener(ILGIServiceListener iLGIServiceListener) {
        this.navigation.getLGIInterAppServiceHandler().removeListener(iLGIServiceListener);
    }

    private void removeAllLGIServiceListeners() {
        LGIInterAppServiceHandler lGIInterAppServiceHandler = this.navigation.getLGIInterAppServiceHandler();
        if (lGIInterAppServiceHandler != null) {
            lGIInterAppServiceHandler.cleanUp();
        }
    }

    private Object addDSIPoiOnlineSearch(DSIPoiOnlineSearch dSIPoiOnlineSearch) {
        this.navigation.setDSIOnline(dSIPoiOnlineSearch);
        return dSIPoiOnlineSearch;
    }

    private void removeDSIOnline() {
        this.navigation.setDSIOnline(null);
    }

    private Object addDSIKOMONavInfo(DSIKOMONavInfo dSIKOMONavInfo) {
        this.navigation.getClusterService().getKomoService().setDSIKOMONavInfo(dSIKOMONavInfo);
        return dSIKOMONavInfo;
    }

    private void removeDSIKOMONavInfo() {
        this.navigation.getClusterService().getKomoService().setDSIKOMONavInfo(null);
    }

    private Object addDSIKOMOView(DSIKOMOView dSIKOMOView) {
        this.navigation.getClusterService().getKomoService().setDSIKOMOView(dSIKOMOView);
        return dSIKOMOView;
    }

    private void removeDSIKOMOView(DSIKOMOView dSIKOMOView) {
        this.navigation.getClusterService().getKomoService().setDSIKOMOView(null);
    }

    private Object addDSIKOMOGfxStreamSink(DSIKOMOGfxStreamSink dSIKOMOGfxStreamSink) {
        this.navigation.getClusterService().getKomoService().setDSIKOMOGfxStreamSink(dSIKOMOGfxStreamSink);
        return dSIKOMOGfxStreamSink;
    }

    private void removeDSIKOMOGfxStreamSink() {
        this.navigation.getClusterService().getKomoService().setDSIKOMOGfxStreamSink(null);
    }

    private Object addDSITrafficRegulation(DSITrafficRegulation dSITrafficRegulation) {
        this.navigation.getTrafficRegulationService().setDSITrafficRegulation(dSITrafficRegulation);
        if (Util.isHURegionAsia()) {
            AsiaWarningsStateSetupListener asiaWarningsStateSetupListener = this.navigation.getAsiaWarningsStateSetupListener();
            if (null == asiaWarningsStateSetupListener) {
                this.logChannel.log(100000, "AbstractNavigationActivator#addDSITrafficRegulation - navigation.getAsiaWarningsStateSetupListener() is null");
            } else {
                asiaWarningsStateSetupListener.makeInitialDSICalls(dSITrafficRegulation);
            }
        }
        return dSITrafficRegulation;
    }

    private void removeDSITrafficRegulation() {
        this.navigation.getTrafficRegulationService().setDSITrafficRegulation(null);
    }

    private Object addCombiService(CombiService combiService) {
        this.navigation.getClusterService().setCombiService(combiService);
        return combiService;
    }

    private void removeCombiService() {
        this.navigation.getClusterService().getClusterViewMode().setCombiService(null);
    }

    private Object addRSEConnection(AbstractRSEConnection abstractRSEConnection) {
        this.navigation.getRSEManager().setRSEConnection(abstractRSEConnection);
        return abstractRSEConnection;
    }

    private void removeRSEConnection() {
        this.navigation.getRSEManager().setRSEConnection(null);
    }

    private Object addCombiBAPServiceNavi(CombiBAPServiceNavi combiBAPServiceNavi) {
        this.navigation.getClusterService().setCombiBAPService(combiBAPServiceNavi);
        return combiBAPServiceNavi;
    }

    private void removeCombiBAPServiceNavi() {
        this.navigation.getClusterService().setCombiBAPService(null);
    }

    private Object addNaviSDSPOIOnlineServiceListener(NaviSDSPOIOnlineServiceListener naviSDSPOIOnlineServiceListener) {
        this.navigation.getOnlineSearchController().getSDS().setNaviSDSPOIOnlineServiceListener(naviSDSPOIOnlineServiceListener);
        return naviSDSPOIOnlineServiceListener;
    }

    private Object addIOnlineService(ServiceReference serviceReference, IOnlineService iOnlineService) {
        if ("service_dsi_onlinetraffic".equals(serviceReference.getProperty("ONLINE_APP_ID")) && Util.isOnlineTrafficPresent(this.navigation.getEnv().getFramework())) {
            this.navigation.getOnlineTrafficHandler().setService(iOnlineService);
            return iOnlineService;
        }
        if (GoogleMapLicenseHandler.SERVICE_ID_SATELLITE_MAPS.equals(serviceReference.getProperty("ONLINE_APP_ID")) && Util.isGoogleEarthPresent(this.navigation.getEnv().getFramework())) {
            this.navigation.getMapInterface().setGELicenseService(iOnlineService);
            return iOnlineService;
        }
        if ("weatherinmaponlineservice".equals(serviceReference.getProperty("ONLINE_APP_ID")) && Util.isWeatherOnMapPresent(this.navigation.getEnv().getFramework())) {
            this.navigation.getMapInterface().setWeatherLicenseService(iOnlineService);
            return iOnlineService;
        }
        if ("ncfstracker".equals(serviceReference.getProperty("ONLINE_APP_ID")) && Util.isVzoLgiTrackerPresent(this.navigation.getEnv().getFramework())) {
            this.navigation.getOnlineTrafficHandler().setTrafficOnlineService("ncfstracker", iOnlineService);
            return iOnlineService;
        }
        if ("ncfsdownload".equals(serviceReference.getProperty("ONLINE_APP_ID")) && Util.isVzoLgiDownloadPresent(this.navigation.getEnv().getFramework())) {
            this.navigation.getOnlineTrafficHandler().setTrafficOnlineService("ncfsdownload", iOnlineService);
            return iOnlineService;
        }
        this.bundleContext.ungetService(serviceReference);
        return null;
    }

    private void removeIOnlineService(ServiceReference serviceReference) {
        if ("service_dsi_onlinetraffic".equals(serviceReference.getProperty("ONLINE_APP_ID"))) {
            this.doremoveIOnlineServiceOnlineTraffic();
        } else if (GoogleMapLicenseHandler.SERVICE_ID_SATELLITE_MAPS.equals(serviceReference.getProperty("ONLINE_APP_ID"))) {
            this.doremoveIOnlineServiceGE();
        } else if ("weatherinmaponlineservice".equals(serviceReference.getProperty("ONLINE_APP_ID"))) {
            this.doremoveIOnlineServiceWeather();
        } else if ("ncfstracker".equals(serviceReference.getProperty("ONLINE_APP_ID"))) {
            this.doremoveIOnlineServiceVzoLgiTracker();
        } else if ("ncfsdownload".equals(serviceReference.getProperty("ONLINE_APP_ID"))) {
            this.doremoveIOnlineServiceVzoLgiDownload();
        }
    }

    private void doremoveIOnlineServiceWeather() {
        this.navigation.getMapInterface().setWeatherLicenseService(null);
    }

    private void doremoveIOnlineServiceGE() {
        this.navigation.getMapInterface().setGELicenseService(null);
    }

    private void doremoveIOnlineServiceOnlineTraffic() {
        this.navigation.getOnlineTrafficHandler().setService(null);
    }

    private void doremoveIOnlineServiceVzoLgiTracker() {
        this.navigation.getOnlineTrafficHandler().setTrafficOnlineService("ncfstracker", null);
    }

    private void doremoveIOnlineServiceVzoLgiDownload() {
        this.navigation.getOnlineTrafficHandler().setTrafficOnlineService("ncfsdownload", null);
    }

    private Object addIAdapterManager(IAdapterManager iAdapterManager) {
        this.navigation.getNaviLocationAccessor().registerAdapterManager(iAdapterManager);
        return iAdapterManager;
    }

    private void removeIAdapterManager() {
        this.navigation.getNaviLocationAccessor().registerAdapterManager(null);
    }

    private Object addNaviPicNavService(INaviPicNavService iNaviPicNavService) {
        this.navigation.getPicNavInterfaceHandler().setNaviPicNavService(iNaviPicNavService);
        return iNaviPicNavService;
    }

    private void removeNaviPicNavService() {
        this.navigation.getPicNavInterfaceHandler().setNaviPicNavService(null);
    }

    private Object addCarNavListenerService(CarNavListener carNavListener) {
        this.navigation.getCarNavInterface().addListener(carNavListener);
        return carNavListener;
    }

    private void removeCarNavListenerService(CarNavListener carNavListener) {
        this.navigation.getCarNavInterface().removeListener(carNavListener);
    }

    private void removeAllCarNavListeners() {
        this.navigation.getCarNavInterface().removeAllCarNavListeners();
    }

    private Object addUotaNavListenerService(UotaNavListener uotaNavListener) {
        this.navigation.getUotaNavListenerImpl().setListener(uotaNavListener);
        return uotaNavListener;
    }

    private void removeUotaNavListenerService() {
        this.navigation.getUotaNavListenerImpl().setListener(null);
    }

    private DSIMapViewerControl addDSIMapControl(ServiceReference serviceReference, DSIMapViewerControl dSIMapViewerControl, Object object) {
        int n = -1;
        if (DEVICEINSTANCE_DSIMAPCTRL_DEFAULT.equals(object)) {
            n = DEVICEINSTANCE_DSIMAPCTRL_DEFAULT;
        } else if (DEVICEINSTANCE_DSIMAPCTRL_GOOGLE.equals(object)) {
            n = DEVICEINSTANCE_DSIMAPCTRL_GOOGLE;
        } else if (DEVICEINSTANCE_DSIMAPCTRL_MAP_IN_MAP.equals(object)) {
            n = DEVICEINSTANCE_DSIMAPCTRL_MAP_IN_MAP;
        } else if (DEVICEINSTANCE_DSIMAPCTRL_KOMBI.equals(object)) {
            n = DEVICEINSTANCE_DSIMAPCTRL_KOMBI;
        } else if (DEVICEINSTANCE_DSIMAPCTRL_GOOGLE2.equals(object)) {
            n = DEVICEINSTANCE_DSIMAPCTRL_GOOGLE2;
        }
        if (n != -1) {
            this.logChannel.log(10000000, "AbstractNavigationActivator#addDSIMapControl - register map control DSI listener service, instanceID: %1", (long)n);
            this.serviceReferenceDSIMapControl[n] = serviceReference;
            this.navigation.getMapInterface().setDSIMapControl(dSIMapViewerControl, n);
            return dSIMapViewerControl;
        }
        this.bundleContext.ungetService(serviceReference);
        return null;
    }

    private DSIMapViewerZoomEngine addDSIMapZoomEngine(DSIMapViewerZoomEngine dSIMapViewerZoomEngine, Object object) {
        if ((Integer)object != -1) {
            this.navigation.getMapInterface().setDSIMapZoomEngine(dSIMapViewerZoomEngine, (Integer)object);
            return dSIMapViewerZoomEngine;
        }
        return null;
    }

    private DSIMapViewerManeuverView addDSIMapManeuverView(DSIMapViewerManeuverView dSIMapViewerManeuverView) {
        this.navigation.getMapInterface().setDSIMapManeuverView(dSIMapViewerManeuverView);
        return dSIMapViewerManeuverView;
    }

    private DSIMapViewerGoogleCtrl addDSIMapGoogleCtrl(ServiceReference serviceReference, DSIMapViewerGoogleCtrl dSIMapViewerGoogleCtrl, Object object) {
        if (object.equals(new Integer(0))) {
            this.navigation.getMapInterface().setDSIMapGoogleCtrl(dSIMapViewerGoogleCtrl, 0);
        } else if (object.equals(new Integer(1))) {
            this.navigation.getMapInterface().setDSIMapGoogleCtrl(dSIMapViewerGoogleCtrl, 1);
        } else {
            this.bundleContext.ungetService(serviceReference);
            return null;
        }
        return dSIMapViewerGoogleCtrl;
    }

    private void removeDSIMapControl(DSIMapViewerControl dSIMapViewerControl, Object object) {
        int n = -1;
        if (DEVICEINSTANCE_DSIMAPCTRL_DEFAULT.equals(object)) {
            n = DEVICEINSTANCE_DSIMAPCTRL_DEFAULT;
        } else if (DEVICEINSTANCE_DSIMAPCTRL_GOOGLE.equals(object)) {
            n = DEVICEINSTANCE_DSIMAPCTRL_GOOGLE;
        } else if (DEVICEINSTANCE_DSIMAPCTRL_MAP_IN_MAP.equals(object)) {
            n = DEVICEINSTANCE_DSIMAPCTRL_MAP_IN_MAP;
        } else if (DEVICEINSTANCE_DSIMAPCTRL_GOOGLE2.equals(object)) {
            n = DEVICEINSTANCE_DSIMAPCTRL_GOOGLE2;
        }
        if (n != -1) {
            this.cleanDSIMapControlForInstance(n);
        }
    }

    private void cleanDSIMapControlForInstance(int n) {
        this.navigation.getMapInterface().clearNotificationsMapCtrl(n);
        this.navigation.getMapInterface().setDSIMapControl(null, n);
        this.serviceReferenceDSIMapControl[n] = null;
    }

    private void doRemoveDSIMapControlInstances() {
        this.cleanDSIMapControlForInstance(DEVICEINSTANCE_DSIMAPCTRL_DEFAULT);
        this.cleanDSIMapControlForInstance(DEVICEINSTANCE_DSIMAPCTRL_GOOGLE);
        this.cleanDSIMapControlForInstance(DEVICEINSTANCE_DSIMAPCTRL_MAP_IN_MAP);
        this.cleanDSIMapControlForInstance(DEVICEINSTANCE_DSIMAPCTRL_GOOGLE2);
    }

    private void removeDSIMapZoomEngine(Object object) {
        this.navigation.getMapInterface().setDSIMapZoomEngine(null, (Integer)object);
    }

    private void removeDSIMapManeuverView() {
        this.navigation.getMapInterface().setDSIMapManeuverView(null);
    }

    private void removeDSIMapGoogleCtrl(DSIMapViewerGoogleCtrl dSIMapViewerGoogleCtrl, Object object) {
        if (object instanceof Integer) {
            int n = (Integer)object;
            if (n == 0) {
                this.doremoveDSIMapGoogleControl(n);
            } else if (n == 1) {
                this.doremoveDSIMapGoogleControl(n);
            }
        }
    }

    private void doremoveDSIMapGoogleControl(int n) {
        this.navigation.getMapInterface().clearNotificationsGoogleCtrl(n);
        this.navigation.getMapInterface().setDSIMapGoogleCtrl(null, n);
    }

    private DSITmcOnRoute addDSITmcOnRoute(DSITmcOnRoute dSITmcOnRoute) {
        this.navigation.getTmcOnRouteService().setDSI(dSITmcOnRoute);
        return dSITmcOnRoute;
    }

    private void removeDSITmcOnRoute() {
        this.navigation.getTmcOnRouteService().setDSI(null);
    }

    private Object addTabletService(INaviTabletServiceListener iNaviTabletServiceListener) {
        this.navigation.getNaviTabletService().registerListener(iNaviTabletServiceListener);
        return iNaviTabletServiceListener;
    }

    private void removeTabletService() {
        if (this.navigation.getNaviTabletService() != null) {
            this.navigation.getNaviTabletService().registerListener(null);
        }
    }

    protected void registerFrameworkService(Class clazz, Object object, Dictionary dictionary) {
        String string = clazz.getName();
        this.registerService(string, object, dictionary);
    }

    private Object addOnlineServiceProvider(OnlineServiceProvider onlineServiceProvider) {
        this.navigation.setOnlineServiceProvider(onlineServiceProvider);
        return onlineServiceProvider;
    }

    private void removeNaviSDSPOIOnlineServiceListener(NaviSDSPOIOnlineServiceListener naviSDSPOIOnlineServiceListener) {
        this.navigation.getOnlineSearchController().getSDS().setNaviSDSPOIOnlineServiceListener(null);
    }

    private void removeOnlineServiceProvider() {
        this.navigation.setOnlineServiceProvider(null);
    }

    private Object addOperatorCallService(IOperatorCallNaviService iOperatorCallNaviService) {
        this.navigation.setOperatorCallServiceProvider(iOperatorCallNaviService);
        return iOperatorCallNaviService;
    }

    private void removeOperatorCallService() {
        this.navigation.setOperatorCallServiceProvider(null);
    }

    private Object addIOnlineDestinationService(IOnlineDestinationService iOnlineDestinationService) {
        this.navigation.setOnlineDestinationService(iOnlineDestinationService);
        return iOnlineDestinationService;
    }

    private void removeIOnlineDestinationService() {
        this.navigation.setOnlineDestinationService(null);
    }

    private Object addAdbRemoteHMIService(ADBRemoteHMIService aDBRemoteHMIService) {
        this.navigation.setAdbRemoteHMIService(aDBRemoteHMIService);
        this.navigation.setAdbRhmiModelListener(this.navigation.getAdbRemoteHMIService(), this.navigation.getLocationSerializer(), this.navigation.getAdbInterAppService());
        return aDBRemoteHMIService;
    }

    private void removeAdbRemoteHMIService() {
        this.navigation.setAdbRemoteHMIService(null);
    }

    private Object addConnectivityNaviStateListener(IConnectivityNaviStateListener iConnectivityNaviStateListener) {
        this.navigation.getMapInterface().setConnectivityNaviStateListener(iConnectivityNaviStateListener);
        return iConnectivityNaviStateListener;
    }

    private void removeConnectivityNaviStateListener() {
        this.navigation.getMapInterface().setConnectivityNaviStateListener(null);
    }

    private Object addMapServiceListener(MapServiceListener mapServiceListener) {
        this.navigation.getMapInterface().setMapServiceListener(mapServiceListener);
        return mapServiceListener;
    }

    private void removeMapServiceListener() {
        this.navigation.getMapInterface().setMapServiceListener(null);
    }

    private Object addDSIMobilityHorizon(DSIMobilityHorizon dSIMobilityHorizon) {
        this.navigation.getMapInterface().getMobilityHorizonHandler().setDSIMobilityHorizon(dSIMobilityHorizon);
        return dSIMobilityHorizon;
    }

    private void removeDSIMobilityHorizon() {
        this.navigation.getMapInterface().getMobilityHorizonHandler().setDSIMobilityHorizon(null);
    }

    protected void registerMyAudiService() {
        Hashtable hashtable = new Hashtable();
        hashtable.put("DEVICE_NAME", (class$de$audi$atip$interapp$NaviMyAudiImport == null ? (class$de$audi$atip$interapp$NaviMyAudiImport = AbstractNavigationActivator.class$("de.audi.atip.interapp.NaviMyAudiImport")) : class$de$audi$atip$interapp$NaviMyAudiImport).getName());
        this.registerService((class$de$audi$atip$interapp$NaviMyAudiImport == null ? (class$de$audi$atip$interapp$NaviMyAudiImport = AbstractNavigationActivator.class$("de.audi.atip.interapp.NaviMyAudiImport")) : class$de$audi$atip$interapp$NaviMyAudiImport).getName(), (Object)this.navigation.getMyAudiImporter(), (Dictionary)hashtable);
    }

    private Object addPictureStoreProvider(ServiceReference serviceReference, PictureStoreProvider pictureStoreProvider) {
        return pictureStoreProvider;
    }

    private void removePictureStoreProvider(ServiceReference serviceReference, PictureStoreProvider pictureStoreProvider) {
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

