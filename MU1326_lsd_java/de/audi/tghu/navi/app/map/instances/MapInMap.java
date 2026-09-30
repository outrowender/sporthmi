/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.map.instances;

import de.audi.atip.hmi.modelaccess.ChoiceModelApp;
import de.audi.tghu.navi.app.IconHandler;
import de.audi.tghu.navi.app.LocationSerializer;
import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.map.INaviInterface;
import de.audi.tghu.navi.app.map.MapConfig;
import de.audi.tghu.navi.app.map.MapInterface;
import de.audi.tghu.navi.app.map.MapManager;
import de.audi.tghu.navi.app.map.context.CtxMapInMapShown;
import de.audi.tghu.navi.app.map.gui.GUIMapInMap;
import de.audi.tghu.navi.app.map.handler.selection.MapSelectionHandlerFactory;
import de.audi.tghu.navi.app.map.instances.MapAdditional;

public class MapInMap
extends MapAdditional {
    private static final String NAME = "MapInMap";
    private boolean bMapInMapInitiated;
    private int lastRequestedMapInMapMode = -1;
    private boolean lastRequestedMapInMapMobilityHorizonVisibility = false;

    public MapInMap(NavigationEnv navigationEnv, MapManager mapManager, MapConfig mapConfig, IconHandler iconHandler, MapInterface mapInterface, INaviInterface iNaviInterface, LocationSerializer locationSerializer, MapSelectionHandlerFactory mapSelectionHandlerFactory) {
        super(navigationEnv, mapManager, mapConfig, iconHandler, mapInterface, iNaviInterface, locationSerializer, mapSelectionHandlerFactory);
        this.setGUIInterface(new GUIMapInMap(navigationEnv, this));
    }

    public String getName() {
        return NAME;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void initDSI() {
        Object object = this.getMutexSwitchToContext();
        synchronized (object) {
            if (this.isMapInMapDSIReceived()) {
                if (!this.bMapInMapInitiated) {
                    this.sMapLogChannel.log(1000000, "%1#init() - all MapInMap DSIs received. Starting initialization...", (Object)this.getName());
                    this.bMapInMapInitiated = true;
                    this.switchToContext(24);
                }
            } else if (this.bMapInMapInitiated) {
                this.sMapLogChannel.log(100000, "%1#init() - MapInMap DSIs failed! MapInMap is not operable any more!", (Object)this.getName());
                this.bMapInMapInitiated = false;
            }
        }
    }

    private boolean isMapInMapDSIReceived() {
        return this.getMainRequestCtl().isReady();
    }

    public void show() {
        this.show(0, false);
    }

    public void show(int n, boolean bl) {
        this.getMapLogChannel().log(10000000, "%1#showMapInMap()", (Object)this.getName());
        CtxMapInMapShown ctxMapInMapShown = (CtxMapInMapShown)this.getCtx(29);
        ctxMapInMapShown.setMapMode(n);
        this.switchToContext(29);
    }

    public void forceHiddenContextRefresh() {
    }

    public void setMapInMapModeAndMobilityHorizonVisibility(int n, boolean bl) {
        if (this.lastRequestedMapInMapMobilityHorizonVisibility != bl) {
            this.lastRequestedMapInMapMobilityHorizonVisibility = bl;
            this.getMVRequest().setMobilityHorizonVisibility(this.lastRequestedMapInMapMobilityHorizonVisibility);
        }
        if (this.lastRequestedMapInMapMode != n) {
            this.lastRequestedMapInMapMode = n;
            this.getMVRequest().setMode(this.lastRequestedMapInMapMode);
        }
    }

    public void switchDayNight() {
    }

    public boolean isStdMapInitiated() {
        return this.bMapInMapInitiated;
    }

    public void hide() {
        this.getMapLogChannel().log(10000000, "%1#hideMapInMap()", (Object)this.getName());
        this.switchToContext(31);
    }

    protected ChoiceModelApp getActiveRendererChoice() {
        return null;
    }
}

