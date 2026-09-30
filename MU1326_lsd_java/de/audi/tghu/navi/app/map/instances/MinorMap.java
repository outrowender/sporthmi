/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.map.instances;

import de.audi.atip.hmi.modelaccess.ChoiceModelApp;
import de.audi.atip.log.LogChannel;
import de.audi.tghu.navi.app.IconHandler;
import de.audi.tghu.navi.app.LocationSerializer;
import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.map.AbstractMap;
import de.audi.tghu.navi.app.map.INaviInterface;
import de.audi.tghu.navi.app.map.MapConfig;
import de.audi.tghu.navi.app.map.MapInterface;
import de.audi.tghu.navi.app.map.MapManager;
import de.audi.tghu.navi.app.map.context.CtxMapInMapShown;
import de.audi.tghu.navi.app.map.gui.GUIMinor;
import de.audi.tghu.navi.app.map.handler.IRouteInfo;
import de.audi.tghu.navi.app.map.handler.selection.MapSelectionHandlerFactory;
import de.audi.tghu.navi.app.map.utils.MapContentListEmpty;
import de.audi.tghu.navi.app.map.utils.MapEnv;
import de.audi.tghu.navi.app.util.Util;

public class MinorMap
extends AbstractMap {
    private static final String NAME = "MinorMap";
    private boolean bMinorMapInitiated = false;
    private int iLastMapMode = 0;

    public MinorMap(NavigationEnv navigationEnv, MapManager mapManager, MapConfig mapConfig, IconHandler iconHandler, MapInterface mapInterface, INaviInterface iNaviInterface, LocationSerializer locationSerializer, MapSelectionHandlerFactory mapSelectionHandlerFactory) {
        super(navigationEnv, mapManager, mapConfig, iconHandler, mapInterface, iNaviInterface, locationSerializer, mapSelectionHandlerFactory);
        this.setGUIInterface(new GUIMinor(navigationEnv, this));
        this.getGuiInterface().showPreviewMap(false);
        if (this.mapDataContainer.sMapContentList == null) {
            this.mapDataContainer.sMapContentList = new MapContentListEmpty(this.sMapLogChannel);
        }
    }

    protected void cleanup() {
        super.cleanup();
    }

    public String getName() {
        return NAME;
    }

    public String toString() {
        return NAME;
    }

    public IRouteInfo getRouteInfo() {
        return this.mapMgr.getMapMain().getRouteInfo();
    }

    private boolean isMapDSIReady() {
        return this.getMainRequestCtl().isReady();
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void initDSI() {
        Object object = this.getMutexSwitchToContext();
        synchronized (object) {
            if (this.isMapDSIReady()) {
                if (!this.bMinorMapInitiated) {
                    this.sMapLogChannel.log(1000000, "%1#init() - Map DSI is ready. Starting initialization...", (Object)this);
                    this.bMinorMapInitiated = true;
                    this.switchToContext(24);
                }
            } else if (this.bMinorMapInitiated) {
                this.sMapLogChannel.log(100000, "%1#init() - Map DSIs is failed! %1 is not operable any more!", (Object)this);
                this.bMinorMapInitiated = false;
            }
        }
    }

    protected LogChannel getLogger() {
        return this.getMapLogChannel();
    }

    public void hide() {
        this.getLogger().log(10000000, "MinorMap#hide()");
        this.switchToContext(31);
    }

    public void showMapInMap(int n) {
        if (MapEnv.force2UsePreviewMapForTest()) {
            this.getLogger().log(1000000, "%1#showMapInMap() - force to show PreviewMap for test", (Object)this);
            this.showPreviewMap();
            return;
        }
        this.getMapLogChannel().log(10000000, "%1#showMapInMap()", (Object)this.getName());
        this.iLastMapMode = n;
        CtxMapInMapShown ctxMapInMapShown = (CtxMapInMapShown)this.getCtx(29);
        ctxMapInMapShown.setMapMode(n);
        this.switchToContext(29);
    }

    public void showPreviewMap() {
        if (!Util.isPreviewMapPresent(this.env.getFramework())) {
            this.getLogger().log(100000000, "%1#showPreviewMap() - Preview map not available!", (Object)this);
            return;
        }
        this.switchToContext(30);
    }

    public void forceHiddenContextRefresh() {
        this.getLogger().log(10000000, "MinorMap#forceContextRefresh() - unexpected call");
    }

    public boolean isStdMapInitiated() {
        return this.bMinorMapInitiated;
    }

    protected ChoiceModelApp getActiveRendererChoice() {
        return null;
    }

    public void switchToHiddenContext() {
        this.switchToContext(31);
    }
}

