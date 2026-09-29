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
    private static final String NAME;
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

    @Override
    protected void cleanup() {
        super.cleanup();
    }

    @Override
    public String getName() {
        return "MinorMap";
    }

    public String toString() {
        return "MinorMap";
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
    @Override
    public void initDSI() {
        Object object = this.getMutexSwitchToContext();
        synchronized (object) {
            if (this.isMapDSIReady()) {
                if (!this.bMinorMapInitiated) {
                    this.sMapLogChannel.log(1078071040, "%1#init() - Map DSI is ready. Starting initialization...", (Object)this);
                    this.bMinorMapInitiated = true;
                    this.switchToContext(24);
                }
            } else if (this.bMinorMapInitiated) {
                this.sMapLogChannel.log(-1601830656, "%1#init() - Map DSIs is failed! %1 is not operable any more!", (Object)this);
                this.bMinorMapInitiated = false;
            }
        }
    }

    protected LogChannel getLogger() {
        return this.getMapLogChannel();
    }

    @Override
    public void hide() {
        this.getLogger().log(-2137614336, "MinorMap#hide()");
        this.switchToContext(31);
    }

    public void showMapInMap(int n) {
        if (MapEnv.force2UsePreviewMapForTest()) {
            this.getLogger().log(1078071040, "%1#showMapInMap() - force to show PreviewMap for test", (Object)this);
            this.showPreviewMap();
            return;
        }
        this.getMapLogChannel().log(-2137614336, "%1#showMapInMap()", (Object)this.getName());
        this.iLastMapMode = n;
        CtxMapInMapShown ctxMapInMapShown = (CtxMapInMapShown)this.getCtx(29);
        ctxMapInMapShown.setMapMode(n);
        this.switchToContext(29);
    }

    @Override
    public void showPreviewMap() {
        if (!Util.isPreviewMapPresent(this.env.getFramework())) {
            this.getLogger().log(14808325, "%1#showPreviewMap() - Preview map not available!", (Object)this);
            return;
        }
        this.switchToContext(30);
    }

    @Override
    public void forceHiddenContextRefresh() {
        this.getLogger().log(-2137614336, "MinorMap#forceContextRefresh() - unexpected call");
    }

    @Override
    public boolean isStdMapInitiated() {
        return this.bMinorMapInitiated;
    }

    @Override
    protected ChoiceModelApp getActiveRendererChoice() {
        return null;
    }

    @Override
    public void switchToHiddenContext() {
        this.switchToContext(31);
    }
}

