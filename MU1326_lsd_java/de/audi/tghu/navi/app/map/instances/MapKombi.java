/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.map.instances;

import de.audi.atip.hmi.modelaccess.ChoiceModelApp;
import de.audi.tghu.navi.app.IconHandler;
import de.audi.tghu.navi.app.LocationSerializer;
import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.map.AbstractMap;
import de.audi.tghu.navi.app.map.IContext;
import de.audi.tghu.navi.app.map.INaviInterface;
import de.audi.tghu.navi.app.map.MapConfig;
import de.audi.tghu.navi.app.map.MapInterface;
import de.audi.tghu.navi.app.map.MapManager;
import de.audi.tghu.navi.app.map.constants.SwitchContextEnum;
import de.audi.tghu.navi.app.map.handler.IRouteInfoContextHandler;
import de.audi.tghu.navi.app.map.handler.NullRouteInfoContextHandler;
import de.audi.tghu.navi.app.map.handler.selection.MapSelectionHandlerFactory;
import de.audi.tghu.navi.app.map.impl.MapContentSyncHandler;
import de.audi.tghu.navi.app.util.Util;
import de.esolutions.fw.util.commons.Buffer;

public abstract class MapKombi
extends AbstractMap {
    private boolean bMapKombiInitiated = false;
    private boolean bGEInitiated = false;
    private IRouteInfoContextHandler routeInfoContextHandler = new NullRouteInfoContextHandler();

    MapKombi(NavigationEnv navigationEnv, MapManager mapManager, MapConfig mapConfig, IconHandler iconHandler, MapInterface mapInterface, INaviInterface iNaviInterface, LocationSerializer locationSerializer, MapSelectionHandlerFactory mapSelectionHandlerFactory) {
        super(navigationEnv, mapManager, mapConfig, iconHandler, mapInterface, iNaviInterface, locationSerializer, mapSelectionHandlerFactory);
        if (this.mapDataContainer.sMapContentList == null) {
            this.mapDataContainer.sMapContentList = new MapContentSyncHandler(navigationEnv, iconHandler, this, this.getViews().createMapContentViewCluster(), this.getViews().createAsiaMapContentViewCluster());
            iNaviInterface.getPOICategoryManager().registerObserver(this.mapDataContainer.sMapContentList);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void initDSI() {
        this.getMapLogChannel().log(10000000, "MapKombi#initDSI() - hasGE = %1, GE DSI ready = %2", this.mapConfig.hasGoogleEarth(), this.allGEDSIsReceived());
        Object object = this.getMutexSwitchToContext();
        synchronized (object) {
            if (this.allKombiMapDSIsReceived()) {
                if (!this.bMapKombiInitiated) {
                    this.sMapLogChannel.log(1000000, "MapKombi#initDSI() - all MapKombi DSIs received. Starting initialization...");
                    this.bMapKombiInitiated = true;
                    this.switchToContext(32);
                }
            } else if (this.bMapKombiInitiated) {
                this.sMapLogChannel.log(100000, "MapKombi#initDSI() - MapKombi DSIs failed! MapKombi is not operable any more!");
                this.bMapKombiInitiated = false;
                this.switchToContext(0);
                this.getMainRequestCtl().setOperable(false);
                this.mapNotInitialized();
            }
            if (this.mapConfig.hasGoogleEarth()) {
                boolean bl = this.allGEDSIsReceived();
                if (bl) {
                    if (!this.bGEInitiated) {
                        this.sMapLogChannel.log(1000000, "MapKombi#init() - all GE DSIs received. Starting initialization...");
                        Util.logStartupEvent(this.env.getFramework(), "[Startup] Map#initDSI() - all GE DSIs received. Starting initialization...");
                        Util.logStartupEvent(this.env.getFramework(), new Buffer().append("MapKombi#initDSI() - Google Earth map enabled in setup: ").append(this.getMapRepresentation() == 1));
                        this.bGEInitiated = true;
                    }
                } else if (this.bGEInitiated) {
                    this.sMapLogChannel.log(100000, "MapKombi#init() - GE DSIs failed! GE is not operable any more!");
                    this.bGEInitiated = false;
                    this.getMVRequest().getMVRequestGoogleCtrl().setOperable(false);
                }
            }
        }
    }

    public void mapInitialized() {
        super.mapInitialized();
        this.naviInterface.updateKombiMapReady(true);
    }

    public void mapNotInitialized() {
        super.mapNotInitialized();
        this.naviInterface.updateKombiMapReady(false);
    }

    protected boolean isSwitchContextAllowed() {
        IContext iContext = this.getActiveContext();
        int n = this.getSetup().getAutoZoom(true);
        this.getMapLogChannel().log(10000000, "MapKombi#isSwitchContextAllowed() - %1", (Object)iContext);
        this.getMapLogChannel().log(10000000, "MapKombi#isSwitchContextAllowed() - %1", this.getMapConfig().hasZoomEngine());
        this.getMapLogChannel().log(10000000, "MapKombi#isSwitchContextAllowed() - %1", iContext.getManoeuvreZoomDisabledWithReturn());
        this.getMapLogChannel().log(10000000, "MapKombi#isSwitchContextAllowed() - %1", (Object)this.getSetup());
        this.getMapLogChannel().log(10000000, "MapKombi#isSwitchContextAllowed() - %1", (long)n);
        int n2 = 0;
        if (this.getMapConfig().hasZoomEngine()) {
            n2 = this.getZoomEngineState();
        }
        return !iContext.getManoeuvreZoomDisabledWithReturn() && n2 == 3 && (n == 1 || n == 0);
    }

    protected boolean isStdMapInitiated() {
        return this.bMapKombiInitiated;
    }

    protected boolean isGEInitiated() {
        return this.bGEInitiated;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void forceHiddenContextRefresh() {
        this.sMapLogChannel.log(1000000, "MapKombi#forceContextRefresh()");
        Object object = this.getMutexSwitchToContext();
        synchronized (object) {
            this.forceSwitchToAShownContext();
            this.forceSwitchToContext(3, SwitchContextEnum.ContextRefresh);
        }
    }

    protected boolean allKombiMapDSIsReceived() {
        return this.getMVRequest().getMVRequestStd().isReady() && this.getMVRequest().getMVRequestZoomEngine().isReady();
    }

    protected ChoiceModelApp getActiveRendererChoice() {
        return this.env.getChoiceModel(401374);
    }

    public IRouteInfoContextHandler getRouteInfoContextHandler() {
        return this.routeInfoContextHandler;
    }
}

