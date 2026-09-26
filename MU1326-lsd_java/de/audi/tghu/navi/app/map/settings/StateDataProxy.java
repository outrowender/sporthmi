/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.map.settings;

import de.audi.atip.base.IFrameworkAccess;
import de.audi.atip.log.LogChannel;
import de.audi.tghu.navi.app.map.context.State$StateData;
import de.audi.tghu.navi.app.map.settings.MapOptionValidator;
import de.audi.tghu.navi.app.util.Util;

public class StateDataProxy {
    protected final String CLASS_NAME = Util.getClassNameFromPackageName(super.getClass());
    public static final int MAP_MAIN;
    public static final int MAP_Kombi;
    public static final int MAP_MAX;
    protected static StateDataProxy[] instance;
    protected final LogChannel logger;
    protected IFrameworkAccess framework = null;
    protected MapOptionValidator mapOptionValidator;
    protected State$StateData[] stateData = new State$StateData[2];
    private boolean[] loadedFromPersistence = new boolean[2];
    protected boolean setupPanorama = true;
    protected int setupDayNightView = State$StateData.getDefaultDayNightView();
    protected int setupOrientation = State$StateData.getDefaultOrientation();
    protected int setupMapType = State$StateData.getDefaultMapType();
    protected int setupMapAutoZoom = State$StateData.getDefaultAutoZoom();
    protected int setupAdditionalInfos;
    protected int setupCrossingView;
    protected int setupGoogle3DCityModel = State$StateData.getDefaultGoogle3DCityModel();
    protected boolean[] setupTMCSymbols = new boolean[3];
    protected boolean[] setupMap3DLandmarks = new boolean[3];
    protected int[] setup3DBuildings = new int[3];
    protected boolean[] setupFavorties = new boolean[3];
    protected boolean[] setupTopPrivate = new boolean[3];
    protected int[] setupBrandedPOIs = new int[3];
    protected boolean[] setupSpeedAndFlowFreeflow = new boolean[3];
    protected boolean[] setupSpeedAndFlowCongestions = new boolean[3];
    protected boolean[] setupPicNavIcons = new boolean[3];
    protected boolean[] setupWeatherIcons = new boolean[3];
    protected boolean[] setupRange = new boolean[3];
    protected int[] setupPoiVisibleUid = null;
    protected boolean[] setupPoiVisibleStatus = null;
    protected int savedZoomListIndex = State$StateData.getDefaultZoomLevelIndex();
    protected int mapRepresentation = State$StateData.getDefaultMapRepresentation();
    protected int backupMapRepresentation = 0;
    protected int setupSpeedAndFlowRoadClass = 4;
    protected boolean setupTrafficEventNoticeMap;
    protected boolean setupUncrowdedRoad = State$StateData.getDefaultUncrowdedRoad();
    protected int[] systemLayers;
    protected int[] systemLayerAvailable;

    public synchronized void loadByPersistence(State$StateData state$StateData, int n) {
        this.stateData[n] = state$StateData;
        this.loadedFromPersistence[n] = true;
        this.setMapRepresentation(state$StateData.getMapRepresentation());
        this.setSetupPanorama(state$StateData.isPanorama());
        this.setSetupDayNightView(state$StateData.getDayNightView());
        this.setSetupOrientation(state$StateData.getOrientation());
        this.setSetupMapType(state$StateData.getMapType());
        this.setSetupAutoZoom(state$StateData.getAutoZoom());
        this.setSetupAdditionalInfos(state$StateData.getAdditionalInfos());
        this.setSetupCrossingView(state$StateData.getCrossingView());
        this.setSetupGoogle3DCityModel(state$StateData.getGoogle3DCityModel());
        this.setSetupSpeedAndFlowRoadClass(state$StateData.getTrafficFlow());
        this.setSetupTrafficEventNoticeMap(state$StateData.isTrafficEventNoticeMap());
        this.setSetupUncrowdedRoad(state$StateData.isUncrowedRoad());
        for (int i2 = 0; i2 < 3; ++i2) {
            this.setSetupTMCSymbols(state$StateData.isTmcSymbols(i2), i2);
            this.setSetup3DLandmarks(state$StateData.isShow3DLandmarks(i2), i2);
            this.setSetup3DBuildings(state$StateData.getShow3DBuildings(i2), i2);
            this.setSetupFavorites(state$StateData.isFavorites(i2), i2);
            this.setSetupTopPrivate(state$StateData.isTopPrivate(i2), i2);
            this.setSetupBrandedPOIs(state$StateData.getBrandedPois(i2), i2);
            this.setSetupSpeedAndFlowFreeflow(state$StateData.isSpeedAndFlowFreeflow(i2), i2);
            this.setSetupSpeedAndFlowCongestions(state$StateData.isSpeedAndFlowCongestions(i2), i2);
            this.setSetupPicNavIcons(state$StateData.isPicNavIcons(i2), i2);
            this.setSetupWeatherIcons(state$StateData.isWeatherIcons(i2), i2);
            this.setSetupRange(state$StateData.isRange(i2), i2);
        }
        this.setSavedZoomListIndex(state$StateData.getZoomLevelIndex());
        this.setSystemLayers(state$StateData.getSystemLayers());
        this.setSystemLayerAvailable(state$StateData.getSystemLayersAvailable());
    }

    private StateDataProxy(IFrameworkAccess iFrameworkAccess, int n, MapOptionValidator mapOptionValidator) {
        this.framework = iFrameworkAccess;
        this.logger = iFrameworkAccess.getLogChannel(n == 0 ? "App.Map.MapMain" : "App.Map.MapKombi");
        this.mapOptionValidator = mapOptionValidator;
        this.logger.log(-2137614336, "%1 is initialized with key (%2)", (Object)this.CLASS_NAME, (long)n);
        this.setupAdditionalInfos = 3;
        this.setupCrossingView = 1;
        this.setupTrafficEventNoticeMap = State$StateData.getDefaultTrafficEventNoticeMap(iFrameworkAccess);
        int n2 = 2;
        for (int i2 = 0; i2 < 3; ++i2) {
            this.setupTMCSymbols[i2] = true;
            this.setupMap3DLandmarks[i2] = true;
            this.setup3DBuildings[i2] = n2;
            this.setupFavorties[i2] = true;
            this.setupTopPrivate[i2] = true;
            this.setupBrandedPOIs[i2] = 0;
            this.setupSpeedAndFlowFreeflow[i2] = false;
            this.setupSpeedAndFlowCongestions[i2] = false;
            this.setupPicNavIcons[i2] = true;
            this.setupWeatherIcons[i2] = true;
            this.setupRange[i2] = true;
        }
    }

    public static synchronized StateDataProxy getInstance(IFrameworkAccess iFrameworkAccess, int n, MapOptionValidator mapOptionValidator) {
        if (instance[n] == null) {
            StateDataProxy.instance[n] = new StateDataProxy(iFrameworkAccess, n, mapOptionValidator);
        }
        return instance[n];
    }

    protected int getSysConst(int n) {
        return this.framework.getSysConst(n);
    }

    protected State$StateData getStateData(int n) {
        return this.stateData[n];
    }

    protected boolean getLoadedFromPersistence(int n) {
        return this.loadedFromPersistence[n];
    }

    public boolean isSetupPanorama() {
        return this.setupPanorama;
    }

    public int getSetupDayNightView() {
        return this.setupDayNightView;
    }

    public int getSetupOrientation() {
        return this.setupOrientation;
    }

    public int getSetupMapType() {
        return this.setupMapType;
    }

    public int getSetupAutoZoom() {
        return this.setupMapAutoZoom;
    }

    public int getSetupAdditionalInfos() {
        return this.setupAdditionalInfos;
    }

    public int getSetupCrossingView() {
        return this.setupCrossingView;
    }

    public int getSetupGoogle3DCityModel() {
        return this.setupGoogle3DCityModel;
    }

    public boolean getSetupTMCSymbols(int n) {
        return this.setupTMCSymbols[n];
    }

    public boolean getSetup3DLandmarks(int n) {
        return this.setupMap3DLandmarks[n];
    }

    public int getSetup3DBuildings(int n) {
        return this.setup3DBuildings[n];
    }

    public boolean getSetupFavorites(int n) {
        return this.setupFavorties[n];
    }

    public boolean getSetupTopPrivate(int n) {
        return this.setupTopPrivate[n];
    }

    public int getSetupBrandedPOIs(int n) {
        return this.setupBrandedPOIs[n];
    }

    public boolean getSetupSpeedAndFlowFreeflow(int n) {
        return this.setupSpeedAndFlowFreeflow[n];
    }

    public boolean getSetupSpeedAndFlowCongestions(int n) {
        return this.setupSpeedAndFlowCongestions[n];
    }

    public boolean getSetupPicNavIcons(int n) {
        return this.setupPicNavIcons[n];
    }

    public boolean getSetupWeatherIcons(int n) {
        return this.setupWeatherIcons[n];
    }

    public boolean getSetupRange(int n) {
        return this.setupRange[n];
    }

    public int[] getSetupPoiVisibleUid() {
        return this.setupPoiVisibleUid;
    }

    public boolean[] getSetupPoiVisibleStatus() {
        return this.setupPoiVisibleStatus;
    }

    public int getSavedZoomListIndex() {
        return this.savedZoomListIndex;
    }

    public int getMapRepresentation() {
        return this.mapRepresentation;
    }

    public int getBackupMapRepresentation() {
        return this.backupMapRepresentation;
    }

    public int getSetupSpeedAndFlowRoadClass() {
        return this.setupSpeedAndFlowRoadClass;
    }

    public boolean isSetupTrafficEventNoticeMap() {
        return this.setupTrafficEventNoticeMap;
    }

    public boolean isSetupUncrowdedRoad() {
        return this.setupUncrowdedRoad;
    }

    public int[] getSystemLayers() {
        return this.systemLayers;
    }

    public int[] getSystemLayerAvailable() {
        return this.systemLayerAvailable;
    }

    public void setSetupPanorama(boolean bl) {
        this.setupPanorama = bl;
    }

    public void setSetupDayNightView(int n) {
        this.setupDayNightView = n;
    }

    public void setSetupOrientation(int n) {
        this.setupOrientation = this.mapOptionValidator.isOrientationValid(n) ? n : State$StateData.getDefaultOrientation();
    }

    public void setSetupMapType(int n) {
        this.setupMapType = this.mapOptionValidator.isMapTypeValid(n) ? n : State$StateData.getDefaultMapType();
    }

    public void setSetupAutoZoom(int n) {
        this.setupMapAutoZoom = this.mapOptionValidator.isAutoZoomValid(n) ? n : State$StateData.getDefaultAutoZoom();
    }

    public void setSetupAdditionalInfos(int n) {
        this.setupAdditionalInfos = this.mapOptionValidator.isAdditionalInfosValid(n) ? n : State$StateData.getDefaultAdditionalInfos(this.framework);
    }

    public void setSetupCrossingView(int n) {
        this.setupCrossingView = n;
    }

    public void setSetupGoogle3DCityModel(int n) {
        this.setupGoogle3DCityModel = n;
    }

    public void setSetupTMCSymbols(boolean bl, int n) {
        this.setupTMCSymbols[n] = bl;
    }

    public void setSetup3DLandmarks(boolean bl, int n) {
        this.setupMap3DLandmarks[n] = bl;
    }

    public void setSetup3DBuildings(int n, int n2) {
        this.setup3DBuildings[n2] = n;
    }

    public void setSetupFavorites(boolean bl, int n) {
        this.setupFavorties[n] = bl;
    }

    public void setSetupTopPrivate(boolean bl, int n) {
        this.setupTopPrivate[n] = bl;
    }

    public void setSetupBrandedPOIs(int n, int n2) {
        this.setupBrandedPOIs[n2] = n;
    }

    public void setSetupSpeedAndFlowFreeflow(boolean bl, int n) {
        this.setupSpeedAndFlowFreeflow[n] = bl;
    }

    public void setSetupSpeedAndFlowCongestions(boolean bl, int n) {
        this.setupSpeedAndFlowCongestions[n] = bl;
    }

    public void setSetupPicNavIcons(boolean bl, int n) {
        this.setupPicNavIcons[n] = bl;
    }

    public void setSetupWeatherIcons(boolean bl, int n) {
        this.setupWeatherIcons[n] = bl;
    }

    public void setSetupRange(boolean bl, int n) {
        this.setupRange[n] = bl;
    }

    public void setSetupPoiVisibleUid(int[] nArray) {
        this.setupPoiVisibleUid = nArray;
    }

    public void setSetupPoiVisibleStatus(boolean[] blArray) {
        this.setupPoiVisibleStatus = blArray;
    }

    public void setSavedZoomListIndex(int n) {
        this.savedZoomListIndex = n;
    }

    public void setMapRepresentation(int n) {
        this.mapRepresentation = this.mapOptionValidator.isMapRepresentationValid(n) ? n : State$StateData.getDefaultMapRepresentation();
    }

    public void setBackupMapRepresentation(int n) {
        this.backupMapRepresentation = n;
    }

    public void setSetupSpeedAndFlowRoadClass(int n) {
        this.setupSpeedAndFlowRoadClass = n;
    }

    public void setSetupTrafficEventNoticeMap(boolean bl) {
        this.setupTrafficEventNoticeMap = bl;
    }

    public void setSetupUncrowdedRoad(boolean bl) {
        this.setupUncrowdedRoad = this.mapOptionValidator.isUncrowdedRoadValid() ? bl : State$StateData.getDefaultUncrowdedRoad();
    }

    public void setSystemLayers(int[] nArray) {
        this.systemLayers = nArray;
    }

    public void setSystemLayerAvailable(int[] nArray) {
        this.systemLayerAvailable = nArray;
    }

    static {
        instance = new StateDataProxy[2];
    }
}

