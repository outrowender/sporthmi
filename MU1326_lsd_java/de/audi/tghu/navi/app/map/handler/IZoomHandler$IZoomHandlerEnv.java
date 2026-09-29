/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.map.handler;

import de.audi.atip.log.LogChannel;
import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.map.Context;
import de.audi.tghu.navi.app.map.GUIInterface;
import de.audi.tghu.navi.app.map.IContext;
import de.audi.tghu.navi.app.map.MapConfig;
import de.audi.tghu.navi.app.map.MapDataContainer;
import de.audi.tghu.navi.app.map.dsi.IMapRequest;
import de.audi.tghu.navi.app.map.dsi.MVResponseControl;
import de.audi.tghu.navi.app.map.dsi.MVResponseZoomEngine;
import de.audi.tghu.navi.app.map.handler.ISetupHandler;

public interface IZoomHandler$IZoomHandlerEnv {
    default public LogChannel getMapLogChannel() {
    }

    default public MVResponseControl getMVResponseControl() {
    }

    default public IContext getActiveContext() {
    }

    default public MapConfig getMapConfig() {
    }

    default public MVResponseZoomEngine getMVResponseZoomEngine() {
    }

    default public IMapRequest getMVRequest() {
    }

    default public GUIInterface getGuiInterface() {
    }

    default public NavigationEnv getNavigationEnv() {
    }

    default public int getActiveContextIndex() {
    }

    default public void switchToContext(int n) {
    }

    default public MapDataContainer getMapDataContainer() {
    }

    default public int getZoomEngineState() {
    }

    default public ISetupHandler getSetup() {
    }

    default public int getLastCtxShownID() {
    }

    default public String getName() {
    }

    default public boolean isMapMain() {
    }

    default public Context getActiveCtx() {
    }

    default public boolean isMapEnablingSoftTiltDesired() {
    }
}

