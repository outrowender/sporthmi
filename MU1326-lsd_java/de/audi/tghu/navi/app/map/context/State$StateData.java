/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.map.context;

import de.audi.atip.base.IFrameworkAccess;
import de.audi.atip.storage.IStorageAccess;
import de.audi.tghu.navi.app.map.context.State$MapContentState;
import de.audi.tghu.navi.app.util.Util;
import de.esolutions.fw.util.commons.Buffer;

public abstract class State$StateData {
    IFrameworkAccess framework;
    boolean panorama;
    int dayNightView;
    int orientation;
    int mapType;
    int autoZoom;
    int additionalInfos;
    int crossingView;
    int splitScreenMode;
    int splitScreen;
    State$MapContentState[] mapContentState;
    int mapRepresentation;
    int zoomLevelIndex;
    int[] systemLayers;
    int google3DCityModel;
    int trafficFlow;
    boolean trafficEventNoticeMap;
    boolean uncrowdedRoad;
    boolean trafficMiniMap;
    int[] systemLayersAvailable;
    public static final int INVALID_ZOOM_LEVEL_INDEX;
    public static final int DEFAULT_SYSTEM_LAYER_ID;
    public static final int[] DEFAULT_SYSTEM_LAYERS;
    public static final int[] DEFAULT_SYSTEM_LAYERS_AVAILABLE;

    public String toString() {
        int n;
        Buffer buffer = new Buffer();
        buffer.append("dayNightView=").append(this.dayNightView).append(", ");
        buffer.append("orientation=").append(this.orientation).append(", ");
        buffer.append("mapType=").append(this.mapType).append(", ");
        buffer.append("mapRepresentation=").append(this.mapRepresentation).append(", ");
        buffer.append("additionalInfos=").append(this.additionalInfos).append(", ");
        buffer.append("crossingView=").append(this.crossingView).append(", ");
        buffer.append("autoZoom=").append(this.autoZoom).append(", ");
        buffer.append("panorama=").append(this.panorama).append(", ");
        buffer.append("google3DCityModel=").append(this.google3DCityModel).append(", ");
        int n2 = this.systemLayers == null ? 0 : this.systemLayers.length;
        buffer.append("systemLayersLength=").append(n2).append(", ");
        int n3 = this.systemLayersAvailable == null ? 0 : this.systemLayersAvailable.length;
        buffer.append("systemLayersAvailableLength=").append(n3).append(", ");
        buffer.append("trafficFlow=").append(this.trafficFlow).append(", ");
        buffer.append("trafficEventNoticeMap=").append(this.trafficEventNoticeMap).append(", ");
        buffer.append("uncrowdedRoad=").append(this.uncrowdedRoad).append(", ");
        buffer.append("trafficMiniMap=").append(this.trafficMiniMap).append(", ");
        buffer.append("FreeFlow=[");
        for (n = 0; n < 3; ++n) {
            buffer.append(this.mapContentState[n].speedAndFlowFreeflow).append(", ");
        }
        buffer.append("], ");
        buffer.append("Congestions=[");
        for (n = 0; n < 3; ++n) {
            buffer.append(this.mapContentState[n].speedAndFlowCongestions).append(", ");
        }
        buffer.append("], ");
        buffer.append("TMC=[");
        for (n = 0; n < 3; ++n) {
            buffer.append(this.mapContentState[n].tmcSymbols).append(", ");
        }
        buffer.append("], ");
        buffer.append("3DLandmarks=[");
        for (n = 0; n < 3; ++n) {
            buffer.append(this.mapContentState[n].show3DLandmarks).append(", ");
        }
        buffer.append("], ");
        buffer.append("3DBuildings=[");
        for (n = 0; n < 3; ++n) {
            buffer.append(this.mapContentState[n].show3DBuildings).append(", ");
        }
        buffer.append("], ");
        buffer.append("brandedPois=[");
        for (n = 0; n < 3; ++n) {
            buffer.append(this.mapContentState[n].brandedPois).append(", ");
        }
        buffer.append("], ");
        buffer.append("PicNav=[");
        for (n = 0; n < 3; ++n) {
            buffer.append(this.mapContentState[n].picNavIcons).append(", ");
        }
        buffer.append("], ");
        buffer.append("Weather=[");
        for (n = 0; n < 3; ++n) {
            buffer.append(this.mapContentState[n].weatherIcons).append(", ");
        }
        buffer.append("], ");
        buffer.append("Range=[");
        for (n = 0; n < 3; ++n) {
            buffer.append(this.mapContentState[n].range).append(", ");
        }
        buffer.append("], ");
        return buffer.toString();
    }

    public final int getDayNightView() {
        return this.dayNightView;
    }

    public final int getOrientation() {
        return this.orientation;
    }

    public final int getMapType() {
        return this.mapType;
    }

    public final int getAutoZoom() {
        return this.autoZoom;
    }

    public final int getAdditionalInfos() {
        return this.additionalInfos;
    }

    public final int getCrossingView() {
        return this.crossingView;
    }

    public final boolean isPanorama() {
        return this.panorama;
    }

    public final int getSplitScreenMode() {
        return this.splitScreenMode;
    }

    public final int getSplitScreen() {
        return this.splitScreen;
    }

    public final int getMapRepresentation() {
        return this.mapRepresentation;
    }

    public final int getZoomLevelIndex() {
        return this.zoomLevelIndex;
    }

    public final int[] getSystemLayers() {
        return this.systemLayers;
    }

    public final int[] getSystemLayersAvailable() {
        return this.systemLayersAvailable;
    }

    public final boolean isTmcSymbols(int n) {
        return this.mapContentState[n].tmcSymbols;
    }

    public final boolean isShow3DLandmarks(int n) {
        return this.mapContentState[n].show3DLandmarks;
    }

    public final int getShow3DBuildings(int n) {
        return this.mapContentState[n].show3DBuildings;
    }

    public final boolean isFavorites(int n) {
        return this.mapContentState[n].favorites;
    }

    public final boolean isTopPrivate(int n) {
        return this.mapContentState[n].topPrivate;
    }

    public final boolean isRange(int n) {
        return this.mapContentState[n].range;
    }

    public final int getBrandedPois(int n) {
        return this.mapContentState[n].brandedPois;
    }

    public final boolean isSpeedAndFlowFreeflow(int n) {
        return this.mapContentState[n].speedAndFlowFreeflow;
    }

    public final boolean isSpeedAndFlowCongestions(int n) {
        return this.mapContentState[n].speedAndFlowCongestions;
    }

    public final boolean isPicNavIcons(int n) {
        return this.mapContentState[n].picNavIcons;
    }

    public final boolean isWeatherIcons(int n) {
        return this.mapContentState[n].weatherIcons;
    }

    public final int getGoogle3DCityModel() {
        return this.google3DCityModel;
    }

    public final int getTrafficFlow() {
        return this.trafficFlow;
    }

    public final boolean isTrafficEventNoticeMap() {
        return this.trafficEventNoticeMap;
    }

    public final boolean isTrafficMiniMapEnabled() {
        return this.trafficMiniMap;
    }

    public final boolean isUncrowedRoad() {
        return this.uncrowdedRoad;
    }

    public State$StateData(IFrameworkAccess iFrameworkAccess) {
        this.framework = iFrameworkAccess;
        this.mapContentState = new State$MapContentState[3];
        for (int i2 = 0; i2 < this.mapContentState.length; ++i2) {
            this.mapContentState[i2] = new State$MapContentState(null);
        }
        this.init();
    }

    abstract void init() {
    }

    final void initCommon() {
        this.dayNightView = State$StateData.getDefaultDayNightView();
        this.orientation = State$StateData.getDefaultOrientation();
        this.mapType = State$StateData.getDefaultMapType();
        this.autoZoom = State$StateData.getDefaultAutoZoom();
        this.additionalInfos = State$StateData.getDefaultAdditionalInfos(this.framework);
        this.crossingView = State$StateData.getDefaultCrossingView(this.framework);
        this.splitScreenMode = State$StateData.getDefaultSplitScreenMode();
        this.splitScreen = State$StateData.getDefaultSplitScreen();
        for (int i2 = 0; i2 < this.mapContentState.length; ++i2) {
            this.mapContentState[i2] = new State$MapContentState(null);
            this.mapContentState[i2].tmcSymbols = State$StateData.getDefaultTmcSymbols(this.framework);
            this.mapContentState[i2].show3DLandmarks = State$StateData.getDefaultShow3DLandmarks(this.framework);
            this.mapContentState[i2].show3DBuildings = State$StateData.getDefault3DBuildings(this.framework);
            this.mapContentState[i2].favorites = State$StateData.getDefaultFavorites();
            this.mapContentState[i2].topPrivate = State$StateData.getDefaultTopPrivate();
            this.mapContentState[i2].range = State$StateData.getDefaultRange();
            this.mapContentState[i2].brandedPois = State$StateData.getDefaultBrandedPois();
            this.mapContentState[i2].speedAndFlowFreeflow = State$StateData.getDefaultSpeedAndFlowFreeflow(this.framework);
            this.mapContentState[i2].speedAndFlowCongestions = State$StateData.getDefaultSpeedAndFlowCongestions(this.framework);
            this.mapContentState[i2].picNavIcons = State$StateData.getDefaultPicNavIcons(this.framework);
            this.mapContentState[i2].weatherIcons = State$StateData.getDefaultWeatherIcons(this.framework);
        }
        this.mapRepresentation = State$StateData.getDefaultMapRepresentation();
        this.zoomLevelIndex = State$StateData.getDefaultZoomLevelIndex();
        this.systemLayers = State$StateData.getDefaultSystemLayers();
        this.systemLayersAvailable = State$StateData.getDefaultSystemLayersAvailable();
        this.google3DCityModel = State$StateData.getDefaultGoogle3DCityModel();
        this.trafficFlow = State$StateData.getDefaultTrafficFlow(this.framework);
        this.trafficEventNoticeMap = State$StateData.getDefaultTrafficEventNoticeMap(this.framework);
        this.uncrowdedRoad = State$StateData.getDefaultUncrowdedRoad();
        this.trafficMiniMap = State$StateData.getDefaultTrafficMiniMap();
    }

    abstract void initFromOldKeys(IStorageAccess iStorageAccess) {
    }

    final void initFromOldKeysCommon(IStorageAccess iStorageAccess) {
        this.dayNightView = iStorageAccess.getInt(1004, 200, 2);
        this.orientation = iStorageAccess.getInt(1004, 240, 1);
        this.mapType = iStorageAccess.getInt(1004, 220, 2);
        this.autoZoom = iStorageAccess.getInt(1004, 210, 2);
        this.additionalInfos = iStorageAccess.getInt(1004, 250, State$StateData.getDefaultAdditionalInfos(this.framework));
        this.crossingView = iStorageAccess.getInt(1004, 440, State$StateData.getDefaultCrossingView(this.framework));
        this.splitScreenMode = iStorageAccess.getInt(1004, 250, 0);
        this.splitScreen = iStorageAccess.getInt(1004, 420, 0);
        for (int i2 = 0; i2 < this.mapContentState.length; ++i2) {
            this.mapContentState[i2] = new State$MapContentState(null);
            this.mapContentState[i2].tmcSymbols = iStorageAccess.getBoolean(1004, 260, true);
            this.mapContentState[i2].show3DLandmarks = iStorageAccess.getBoolean(1004, 270, true);
            this.mapContentState[i2].show3DBuildings = iStorageAccess.getInt(1004, 330, State$StateData.getDefault3DBuildings(this.framework));
            this.mapContentState[i2].favorites = iStorageAccess.getBoolean(1004, 280, State$StateData.getDefaultFavorites());
            this.mapContentState[i2].topPrivate = iStorageAccess.getBoolean(1004, 320, State$StateData.getDefaultTopPrivate());
            this.mapContentState[i2].brandedPois = iStorageAccess.getInt(1004, 430, 0);
            this.mapContentState[i2].speedAndFlowFreeflow = iStorageAccess.getBoolean(1004, 450, true);
            this.mapContentState[i2].speedAndFlowCongestions = iStorageAccess.getBoolean(1004, 460, true);
            this.mapContentState[i2].picNavIcons = iStorageAccess.getBoolean(1004, 470, true);
            this.mapContentState[i2].weatherIcons = true;
            this.mapContentState[i2].range = State$StateData.getDefaultRange();
        }
        this.mapRepresentation = iStorageAccess.getInt(1004, 380, 0);
        this.zoomLevelIndex = iStorageAccess.getInt(1004, 600, -1);
        this.systemLayers = iStorageAccess.getIntArray(1004, 410, DEFAULT_SYSTEM_LAYERS);
        this.systemLayersAvailable = State$StateData.getDefaultSystemLayersAvailable();
        this.google3DCityModel = State$StateData.getDefaultGoogle3DCityModel();
        this.trafficFlow = State$StateData.getDefaultTrafficFlow(this.framework);
        this.trafficEventNoticeMap = State$StateData.getDefaultTrafficEventNoticeMap(this.framework);
        this.uncrowdedRoad = State$StateData.getDefaultUncrowdedRoad();
        this.trafficMiniMap = State$StateData.getDefaultTrafficMiniMap();
    }

    public static int getDefaultAdditionalInfos(IFrameworkAccess iFrameworkAccess) {
        if (Util.isHURegionAsia()) {
            return 0;
        }
        return State$StateData.isClusterMMI(iFrameworkAccess) ? 3 : 0;
    }

    public static boolean isClusterMMI(IFrameworkAccess iFrameworkAccess) {
        return iFrameworkAccess.getScreenRes() == 4;
    }

    public static boolean isClusterRGI(IFrameworkAccess iFrameworkAccess) {
        return !State$StateData.isClusterMMI(iFrameworkAccess) && iFrameworkAccess.getSysConst(541) == 0;
    }

    public static int getDefault3DBuildings(IFrameworkAccess iFrameworkAccess) {
        return Util.isCityModelModeAvailable(iFrameworkAccess) ? 2 : 0;
    }

    public static int getDefaultDayNightView() {
        return 2;
    }

    public static int getDefaultOrientation() {
        return 1;
    }

    public static int getDefaultMapType() {
        return 2;
    }

    public static int getDefaultAutoZoom() {
        if (Util.isHURegionAsia()) {
            return 1;
        }
        return 2;
    }

    public static int getDefaultSplitScreenMode() {
        return 0;
    }

    public static int getDefaultSplitScreen() {
        return 0;
    }

    public static boolean getDefaultFavorites() {
        return true;
    }

    public static boolean getDefaultTopPrivate() {
        return true;
    }

    public static boolean getDefaultRange() {
        return false;
    }

    public static boolean getDefaultTmcSymbols(IFrameworkAccess iFrameworkAccess) {
        return Util.isTrafficPresent(iFrameworkAccess);
    }

    public static boolean getDefaultShow3DLandmarks(IFrameworkAccess iFrameworkAccess) {
        return Util.is3DLandmarksAvailable(iFrameworkAccess);
    }

    public static int getDefaultBrandedPois() {
        return 0;
    }

    public static boolean getDefaultSpeedAndFlowFreeflow(IFrameworkAccess iFrameworkAccess) {
        return Util.isUncrowdedRoadsCheckboxAvailable(iFrameworkAccess) ? State$StateData.getDefaultUncrowdedRoad() : Util.isSpeedAndFlowAvailable(iFrameworkAccess);
    }

    public static boolean getDefaultSpeedAndFlowCongestions(IFrameworkAccess iFrameworkAccess) {
        return Util.isSpeedAndFlowAvailable(iFrameworkAccess);
    }

    public static boolean getDefaultPicNavIcons(IFrameworkAccess iFrameworkAccess) {
        return Util.isPictureNavPresent(iFrameworkAccess);
    }

    public static boolean getDefaultWeatherIcons(IFrameworkAccess iFrameworkAccess) {
        return Util.isWeatherOnMapPresent(iFrameworkAccess);
    }

    public static int getDefaultMapRepresentation() {
        return 0;
    }

    public static int getDefaultZoomLevelIndex() {
        return -1;
    }

    public static int[] getDefaultSystemLayers() {
        return DEFAULT_SYSTEM_LAYERS;
    }

    public static int[] getDefaultSystemLayersAvailable() {
        return DEFAULT_SYSTEM_LAYERS_AVAILABLE;
    }

    public static int getDefaultCrossingView(IFrameworkAccess iFrameworkAccess) {
        return State$StateData.isClusterRGI(iFrameworkAccess) ? 0 : 1;
    }

    public static int getDefaultGoogle3DCityModel() {
        return Util.isGoogle3dCityModelAvailable() ? 2 : 0;
    }

    public static int getDefaultTrafficFlow(IFrameworkAccess iFrameworkAccess) {
        return Util.isSpeedAndFlowAvailable(iFrameworkAccess) ? 4 : 0;
    }

    public static boolean getDefaultTrafficEventNoticeMap(IFrameworkAccess iFrameworkAccess) {
        return Util.isTrafficEventNoticeMapAvailable(iFrameworkAccess);
    }

    public static boolean getDefaultUncrowdedRoad() {
        return false;
    }

    public static boolean getDefaultTrafficMiniMap() {
        return false;
    }

    static {
        DEFAULT_SYSTEM_LAYERS = new int[]{-1, -1};
        DEFAULT_SYSTEM_LAYERS_AVAILABLE = new int[0];
    }
}

