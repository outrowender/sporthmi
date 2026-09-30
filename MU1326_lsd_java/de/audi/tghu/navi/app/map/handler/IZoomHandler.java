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
import de.audi.tghu.navi.app.util.Util;
import org.dsi.ifc.map.Rect;

public interface IZoomHandler {
    public static final float ZOOMLEVEL_30M = 30.0f;
    public static final float ZOOMLEVEL_100M = 100.0f;
    public static final float ZOOMLEVEL_200M = 200.0f;
    public static final float ZOOMLEVEL_400M = 400.0f;
    public static final float ZOOMLEVEL_1KM = 1000.0f;
    public static final float ZOOMLEVEL_2KM = 2000.0f;
    public static final float ZOOMLEVEL_3KM = 3000.0f;
    public static final float ZOOMLEVEL_4KM = 4000.0f;
    public static final float ZOOMLEVEL_6KM = 6000.0f;
    public static final float ZOOMLEVEL_10KM = 10000.0f;
    public static final float ZOOMLEVEL_15KM = 15000.0f;
    public static final float ZOOMLEVEL_30KM = 30000.0f;
    public static final float ZOOMLEVEL_100KM = 100000.0f;
    public static final float ZOOMLEVEL_2500KM = 2500000.0f;
    public static final float PREVIEWMAP_DEFAULT_ZOOMLEVEL = Util.getPreviewMapDefaultZoomLevel();
    public static final float PREVIEWMAP_CITY_ZOOMLEVEL = 30000.0f;
    public static final float PREVIEWMAP_TMC_ZOOMLEVEL = 3000.0f;
    public static final float PREVIEWMAP_TMC_NAR_ZOOMLEVEL = 400.0f;
    public static final float RANGE_MAP_DEFAULT_ZOOMLEVEL = 15000.0f;

    public float getRecommendedZoom();

    public float[] getZoomList();

    public int getZoomListIndex(float var1);

    public float getZoom();

    public boolean isMaxZoomLevel(int var1);

    public void incrementGesture(int var1);

    public void startPinchZoom();

    public void stopPinchZoom();

    public void incrementWithDelay(int var1);

    public void setZoom(int var1);

    public void setZoomLevel(float var1);

    public void setZoomArea(Rect var1);

    public void setZoomAreaWithGridMask(Rect var1, Rect var2);

    public void startOverviewMapSwitchBackTimer(boolean var1);

    public void stopOverviewMapSwitchBackTimer();

    public void setUserRequestedZoomIndex(int var1);

    public void autoZoomEnable(boolean var1);

    public void manoeuvreZoomEnable(boolean var1);

    public void sdsIncrement(int var1);

    public boolean matchZoomLevelToZoomListIndex(float var1, int var2);

    public float getZoomLevel(int var1);

    public void doubleClick();

    public void pinchZoom(float var1);

    public long getSetZoomLevelTime();

    public long getUpdateZoomListIndexTime();

    public void pinchZoom(float var1, int var2, int var3);

    public float getCurrentlyRequestedZoomLevel();

    public static interface IZoomHandlerEnv {
        public LogChannel getMapLogChannel();

        public MVResponseControl getMVResponseControl();

        public IContext getActiveContext();

        public MapConfig getMapConfig();

        public MVResponseZoomEngine getMVResponseZoomEngine();

        public IMapRequest getMVRequest();

        public GUIInterface getGuiInterface();

        public NavigationEnv getNavigationEnv();

        public int getActiveContextIndex();

        public void switchToContext(int var1);

        public MapDataContainer getMapDataContainer();

        public int getZoomEngineState();

        public ISetupHandler getSetup();

        public int getLastCtxShownID();

        public String getName();

        public boolean isMapMain();

        public Context getActiveCtx();

        public boolean isMapEnablingSoftTiltDesired();
    }
}

