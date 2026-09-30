/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app;

import de.audi.atip.base.IFrameworkAccess;
import de.audi.atip.hmi.modelaccess.RangeModel2DApp;
import de.audi.atip.log.LogChannel;
import de.audi.atip.variant.AbstractModelEnvironment;
import de.audi.atip.variant.IIDMapper;
import de.audi.tghu.navi.app.INavigationInputModeManager;
import de.audi.tghu.navi.app.NavigationInputModeManager;
import de.audi.tghu.navi.app.addressinput.poi.searcharea.PoiSearchArea;
import de.audi.tghu.navi.app.command.DSIResponseContainer;
import de.audi.tghu.navi.app.util.Util;
import java.util.HashMap;
import java.util.Map;

public class NavigationEnv
extends AbstractModelEnvironment {
    private final LogChannel mainLogChannel;
    private final LogChannel dsiLogChannel;
    private final LogChannel sdsLogChannel;
    private final LogChannel audioLogChannel;
    private final LogChannel guidanceLogChannel;
    private final LogChannel clusterLogChannel;
    private final LogChannel clusterKOMOLogChannel;
    private final LogChannel trLogChannel;
    private final LogChannel rmlLogChannel;
    private final LogChannel browserLogChannel;
    private final LogChannel browserDSILogChannel;
    private final LogChannel rseLogChannel;
    private final LogChannel commandListLogChannel;
    private final LogChannel commandLogChannel;
    private final LogChannel onlineLogChannel;
    private final LogChannel msgLogChannel;
    private final LogChannel sdisLogChannel;
    private final LogChannel searchLogChannel;
    private final LogChannel iconRendererLogChannel;
    private final LogChannel predictiveNavigationLogChannel;
    private final LogChannel exlapLogChannel;
    private final LogChannel mapMainLogChannel;
    private final LogChannel mapGUILogChannel;
    private final LogChannel mapDSILogChannel;
    private final LogChannel mapControl0LogChannel;
    private final LogChannel mapControl1LogChannel;
    private final LogChannel mapControl2LogChannel;
    private final LogChannel mapGuidanceLogChannel;
    private final LogChannel addressInputLogChannel;
    private final LogChannel demoModeLogChannel;
    private final LogChannel poiApproachWarningLogChannel;
    private final LogChannel geoCoordInputLogChannel;
    private final LogChannel naviAudioLogChannel;
    private final LogChannel mapSettingsLogChannel;
    private final DSIResponseContainer container;
    private final DSIResponseContainer remoteContainer;
    private final LogChannel poiLogChannel;
    private Map services;
    static /* synthetic */ Class class$de$audi$tghu$navi$app$addressinput$poi$searcharea$PoiSearchArea;

    public NavigationEnv(IFrameworkAccess iFrameworkAccess, IIDMapper iIDMapper, IIDMapper iIDMapper2) {
        super(iFrameworkAccess, iIDMapper, iIDMapper2);
        this.mainLogChannel = iFrameworkAccess.getLogChannel("App.Navi.Main");
        this.dsiLogChannel = iFrameworkAccess.getLogChannel("App.Navi.DSI");
        this.sdsLogChannel = iFrameworkAccess.getLogChannel("App.Navi.SDS");
        this.audioLogChannel = iFrameworkAccess.getLogChannel("App.Navi.Audio");
        this.guidanceLogChannel = iFrameworkAccess.getLogChannel("App.Navi.Guidance");
        this.clusterLogChannel = iFrameworkAccess.getLogChannel("App.Navi.Cluster");
        this.clusterKOMOLogChannel = iFrameworkAccess.getLogChannel("App.Navi.Cluster.KOMO");
        this.trLogChannel = iFrameworkAccess.getLogChannel("App.Navi.TR");
        this.rmlLogChannel = iFrameworkAccess.getLogChannel("App.Navi.RML");
        this.browserLogChannel = iFrameworkAccess.getLogChannel("App.Navi.Browser");
        this.browserDSILogChannel = iFrameworkAccess.getLogChannel("App.Navi.Browser.DSI");
        this.rseLogChannel = iFrameworkAccess.getLogChannel("App.Navi.RSE");
        this.commandListLogChannel = iFrameworkAccess.getLogChannel("App.Navi.Commandlist");
        this.commandLogChannel = iFrameworkAccess.getLogChannel("App.Navi.Command");
        this.onlineLogChannel = iFrameworkAccess.getLogChannel("App.Navi.Online");
        this.msgLogChannel = iFrameworkAccess.getLogChannel("App.Navi.Messages");
        this.sdisLogChannel = iFrameworkAccess.getLogChannel("App.Navi.SDIS");
        this.mapMainLogChannel = iFrameworkAccess.getLogChannel("App.Map.Main");
        this.mapGUILogChannel = iFrameworkAccess.getLogChannel("App.Map.GUI.Default");
        this.mapDSILogChannel = iFrameworkAccess.getLogChannel("App.Map.DSI");
        this.mapControl0LogChannel = iFrameworkAccess.getLogChannel("App.Map.DSIControl0");
        this.mapControl1LogChannel = iFrameworkAccess.getLogChannel("App.Map.DSIControl1");
        this.mapControl2LogChannel = iFrameworkAccess.getLogChannel("App.Map.DSIControl2");
        this.mapGuidanceLogChannel = iFrameworkAccess.getLogChannel("App.Map.Guidance");
        this.addressInputLogChannel = iFrameworkAccess.getLogChannel("App.Navi.AdressInput");
        this.poiLogChannel = iFrameworkAccess.getLogChannel("App.Navi.POI");
        this.demoModeLogChannel = iFrameworkAccess.getLogChannel("App.Navi.DemoMode");
        this.poiApproachWarningLogChannel = iFrameworkAccess.getLogChannel("App.Navi.PoiApproachWarning");
        this.geoCoordInputLogChannel = iFrameworkAccess.getLogChannel("App.Navi.GeoCoordInputLogChannel");
        this.naviAudioLogChannel = iFrameworkAccess.getLogChannel("App.Navi.NaviAudioLogChannel");
        this.searchLogChannel = iFrameworkAccess.getLogChannel("App.Navi.Search");
        this.mapSettingsLogChannel = iFrameworkAccess.getLogChannel("App.Map.MapSettings");
        this.iconRendererLogChannel = iFrameworkAccess.getLogChannel("Fw.IconRenderer");
        this.predictiveNavigationLogChannel = iFrameworkAccess.getLogChannel("App.Navi.PredictiveNavigation");
        this.exlapLogChannel = iFrameworkAccess.getLogChannel("App.Navi.Exlap");
        this.container = new DSIResponseContainer();
        this.remoteContainer = iFrameworkAccess.isFrontMU() ? null : new DSIResponseContainer();
    }

    public final DSIResponseContainer getContainer() {
        return this.container;
    }

    public final DSIResponseContainer getRemoteContainer() {
        return this.remoteContainer;
    }

    public LogChannel getLogChannel() {
        return this.mainLogChannel;
    }

    public LogChannel getSDSLogChannel() {
        return this.sdsLogChannel;
    }

    public LogChannel getAudioLogChannel() {
        return this.audioLogChannel;
    }

    public LogChannel getGuidanceLogChannel() {
        return this.guidanceLogChannel;
    }

    public LogChannel getClusterLogChannel() {
        return this.clusterLogChannel;
    }

    public LogChannel getClusterKOMOLogChannel() {
        return this.clusterKOMOLogChannel;
    }

    public LogChannel getTRLogChannel() {
        return this.trLogChannel;
    }

    public LogChannel getRMLLogChannel() {
        return this.rmlLogChannel;
    }

    public LogChannel getDSILogChannel() {
        return this.dsiLogChannel;
    }

    public LogChannel getBrowserLogChannel() {
        return this.browserLogChannel;
    }

    public LogChannel getDSIBrowserLogChannel() {
        return this.browserDSILogChannel;
    }

    public LogChannel getRSELogChannel() {
        return this.rseLogChannel;
    }

    public LogChannel getCommandListLogChannel() {
        return this.commandListLogChannel;
    }

    public LogChannel getCommandLogChannel() {
        return this.commandLogChannel;
    }

    public LogChannel getOnlineLogChannel() {
        return this.onlineLogChannel;
    }

    public LogChannel getMsgLogChannel() {
        return this.msgLogChannel;
    }

    public LogChannel getSdisLogChannel() {
        return this.sdisLogChannel;
    }

    public LogChannel getPredictiveNavigationLogChannel() {
        return this.predictiveNavigationLogChannel;
    }

    public LogChannel getExlapLogChannel() {
        return this.exlapLogChannel;
    }

    public LogChannel getMapMainLogChannel() {
        return this.mapMainLogChannel;
    }

    public LogChannel getMapGUILogChannel() {
        return this.mapGUILogChannel;
    }

    public LogChannel getMapDSILogChannel() {
        return this.mapDSILogChannel;
    }

    public LogChannel getMapControl0LogChannel() {
        return this.mapControl0LogChannel;
    }

    public LogChannel getMapControl1LogChannel() {
        return this.mapControl1LogChannel;
    }

    public LogChannel getMapControl2LogChannel() {
        return this.mapControl2LogChannel;
    }

    public LogChannel getMapGuidanceLogChannel() {
        return this.mapGuidanceLogChannel;
    }

    public LogChannel getAddressInputLogChannel() {
        return this.addressInputLogChannel;
    }

    public LogChannel getDemoModeLogChannel() {
        return this.demoModeLogChannel;
    }

    public LogChannel getPoiApproachWarningLogChannel() {
        return this.poiApproachWarningLogChannel;
    }

    public LogChannel getPOILogChannel() {
        return this.poiLogChannel;
    }

    public LogChannel getGeoCoordInputLogChannel() {
        return this.geoCoordInputLogChannel;
    }

    public LogChannel getNaviAudioLogChannel() {
        return this.naviAudioLogChannel;
    }

    public LogChannel getSearchLogChannel() {
        return this.searchLogChannel;
    }

    public LogChannel getMapSettingsLogChannel() {
        return this.mapSettingsLogChannel;
    }

    public LogChannel getIconRendererLogChannel() {
        return this.iconRendererLogChannel;
    }

    public RangeModel2DApp getRangeModel2D(int n, int n2) {
        return (RangeModel2DApp)this.getHMIService().getModelApp(n, n2);
    }

    public RangeModel2DApp getRangeModel2D(int n) {
        return (RangeModel2DApp)this.getHMIService().getModelApp(n);
    }

    public INavigationInputModeManager getInputModeManager() {
        return NavigationInputModeManager.InputModeManagerHolder.INSTANCE;
    }

    public PoiSearchArea getPoiSearchArea() {
        Object object = this.getService(class$de$audi$tghu$navi$app$addressinput$poi$searcharea$PoiSearchArea == null ? (class$de$audi$tghu$navi$app$addressinput$poi$searcharea$PoiSearchArea = NavigationEnv.class$("de.audi.tghu.navi.app.addressinput.poi.searcharea.PoiSearchArea")) : class$de$audi$tghu$navi$app$addressinput$poi$searcharea$PoiSearchArea);
        if (object instanceof PoiSearchArea) {
            return (PoiSearchArea)object;
        }
        throw new RuntimeException("POI Search Area is null!");
    }

    public void addService(Object object, Object object2) {
        this.getServices().put(object, object2);
    }

    public Object getService(Object object) {
        Object object2 = this.getServices().get(object);
        if (object2 == null) {
            this.getLogChannel().log(10000000, "%1#getService() - nothing registered for %2", (Object)Util.getClassNameFromPackageName(this.getClass()), object);
        }
        return object2;
    }

    public boolean hasService(Object object) {
        return this.getServices().containsKey(object);
    }

    private Map getServices() {
        if (this.services == null) {
            this.services = new HashMap();
        }
        return this.services;
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

