/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.map.context;

import de.audi.atip.base.IFrameworkAccess;
import de.audi.atip.hmi.modelaccess.RangeModelApp;
import de.audi.atip.log.LogChannel;
import de.audi.atip.storage.IStorageAccess;
import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.map.AbstractMap;
import de.audi.tghu.navi.app.map.constants.MapOption;
import de.audi.tghu.navi.app.map.context.SetupChangeListener;
import de.audi.tghu.navi.app.map.context.State;
import de.audi.tghu.navi.app.map.context.State$StateData;
import de.audi.tghu.navi.app.map.gui.SimpleChoiceListener;
import de.audi.tghu.navi.app.map.handler.ISetupHandler;
import de.audi.tghu.navi.app.map.settings.MapOptionValidator;
import de.audi.tghu.navi.app.map.settings.StateDataProxy;
import de.audi.tghu.navi.app.map.utils.MapUtils;
import de.audi.tghu.navi.app.util.Util;
import de.esolutions.fw.util.commons.Buffer;

public class SetupHandler
extends SimpleChoiceListener
implements ISetupHandler {
    public static final int ASIA_TRAFFICFLOW_ITEMID_ALL;
    public static final int ASIA_TRAFFICFLOW_ITEMID_HIGHWAY;
    public static final int ASIA_TRAFFICFLOW_ITEMID_ROAD;
    public static final int ASIA_TRAFFICFLOW_ITEMID_AUTO;
    public static final int ASIA_TRAFFICFLOW_ITEMID_OFF;
    private int mapKey = 0;
    protected StateDataProxy stateDataProxy;
    protected AbstractMap naviMap;
    protected NavigationEnv env;
    protected MapOptionValidator mapOptionValidator;
    protected boolean initializationPhaseFinished = false;
    private LogChannel logChannel;

    private static int convertAdditionalInfoFromModel(int n, IFrameworkAccess iFrameworkAccess) {
        switch (n) {
            case 0: 
            case 1: 
            case 4: {
                return 0;
            }
            case 2: {
                return 1;
            }
            case 3: {
                return 2;
            }
            case 5: {
                return 3;
            }
        }
        return State$StateData.getDefaultAdditionalInfos(iFrameworkAccess);
    }

    private static int convertAdditionalInfoToModel(int n, NavigationEnv navigationEnv) {
        switch (n) {
            case 0: {
                if (Util.isClusterRGI(navigationEnv.getFramework())) {
                    if (Util.isHURegionNAR()) {
                        return 1;
                    }
                    return 4;
                }
                if (Util.isHURegionNAR()) {
                    if (Util.isClusterMMI(navigationEnv.getFramework())) {
                        return 4;
                    }
                    return 1;
                }
                return 4;
            }
            case 1: {
                return 2;
            }
            case 2: {
                return 3;
            }
        }
        return 5;
    }

    public SetupHandler(NavigationEnv navigationEnv, MapOptionValidator mapOptionValidator) {
        this.env = navigationEnv;
        this.mapOptionValidator = mapOptionValidator;
        this.logChannel = navigationEnv.getLogChannel("App.Map.Main");
    }

    @Override
    public void bind(AbstractMap abstractMap) {
        this.naviMap = abstractMap;
        this.logChannel = this.naviMap.getMapLogChannel();
        this.mapKey = this.getMap().isMapKombi() || this.getMap().isMapKombiFPK() || this.getMap().isMapKombiMOST() ? 1 : 0;
        this.stateDataProxy = StateDataProxy.getInstance(this.env.getFramework(), this.mapKey, this.mapOptionValidator);
        this.naviMap.getMapDataContainer().sMapContentList.refresh();
    }

    protected LogChannel getLogger() {
        return this.logChannel;
    }

    private void saveStateMapContent(State state, int n) {
        state.setTmcSymbols(this.stateDataProxy.getSetupTMCSymbols(n), n);
        state.setShow3DLandmarks(this.stateDataProxy.getSetup3DLandmarks(n), n);
        state.setShow3DBuildings(this.stateDataProxy.getSetup3DBuildings(n), n);
        state.setFavorites(this.stateDataProxy.getSetupFavorites(n), n);
        state.setBrandedPois(this.stateDataProxy.getSetupBrandedPOIs(n), n);
        state.setSpeedAndFlowFreeflow(this.stateDataProxy.getSetupSpeedAndFlowFreeflow(n), n);
        state.setSpeedAndFlowCongestions(this.stateDataProxy.getSetupSpeedAndFlowCongestions(n), n);
        state.setPicNavIcons(this.stateDataProxy.getSetupPicNavIcons(n), n);
        state.setWeatherIcons(this.stateDataProxy.getSetupWeatherIcons(n), n);
    }

    protected SetupChangeListener getActiveContext() {
        return this.naviMap.getActiveContext();
    }

    protected boolean isActive() {
        return this.naviMap != null;
    }

    protected AbstractMap getMap() {
        return this.naviMap;
    }

    @Override
    public void setPanorama(boolean bl, boolean bl2) {
        if (!Util.isClusterMapFPK(this.env.getFramework())) {
            bl = true;
        }
        boolean bl3 = this.stateDataProxy.isSetupPanorama() != bl;
        this.getLogger().log(14808325, "SetupHandler#setPanorama(): isPanorama: %1, sSetupPanorama: %2", bl, this.stateDataProxy.isSetupPanorama());
        if (bl) {
            this.refreshModels();
        }
        if (bl3 || !bl2) {
            this.stateDataProxy.setSetupPanorama(bl);
            if (bl2) {
                this.saveState();
                this.getLogger().log(14808325, "SetupHandler#setPanorama(): Saving Panorama = %1", this.stateDataProxy.isSetupPanorama());
            }
            if (this.isActive()) {
                this.getActiveContext().onChangedPanorama(bl);
            } else {
                this.getLogger().log(-1601830656, "SetupHandler#setPanorama(): not bound to a map");
            }
        }
    }

    @Override
    public boolean isPanorama() {
        return this.stateDataProxy.isSetupPanorama();
    }

    @Override
    public void itemSelected(int n, int n2, int n3, int n4) {
        if (!this.isActive()) {
            this.getLogger().log(-1601830656, "SetupHandler#itemSelected( %1, %2 ) - not bound to a map", (long)n, (long)n2);
            return;
        }
        this.getLogger().log(-2137614336, "SetupHandler[%1]#itemSelected( %2, %3 )", (Object)this.getMap().getName(), (long)n, (long)n2);
        boolean bl = false;
        boolean bl2 = false;
        switch (n) {
            case 400786: {
                this.naviMap.getMapManager().setMapColor(n2);
                break;
            }
            case 400793: {
                this.setMapTypeAndOrientation(n2);
                n2 = this.convertMapTypeOrientationToModel(this.getMapType(), this.getOrientation());
                if (this.getMap().getOldActiveContextIndex() == 5 || this.getMap().getOldActiveContextIndex() == 33) {
                    bl2 = false;
                } else {
                    this.getMap().forceContext(-1);
                    bl2 = true;
                }
                bl = true;
                break;
            }
            case 400490: {
                if (this.getMap().getMapInterface().isGoogleTempDisabled() && n2 != 1) {
                    this.getMap().getMapInterface().setGoogleTempDisabled(false);
                }
                this.naviMap.getMapManager().setMapRepresentation(n2);
                break;
            }
            case 400802: {
                if (this.getMapRepresentation() != 3 && this.getMapType() != 0) {
                    this.setAutoZoom(n2, true);
                    n2 = this.getAutoZoom();
                    bl = true;
                    bl2 = true;
                    break;
                }
                bl2 = false;
                bl = false;
                break;
            }
            case 400781: {
                int n5 = SetupHandler.convertAdditionalInfoFromModel(n2, this.env.getFramework());
                this.setAdditionalInfos(n5, true);
                bl = true;
                break;
            }
            case 400897: {
                this.setCrossingView(n2, true);
                bl = true;
                break;
            }
            default: {
                this.getLogger().log(-1601830656, "SetupHandler#itemSelected( %1, %2 ) - not supported", (long)n, (long)n2);
            }
        }
        if (bl) {
            this.getMap().getGuiInterface().updateChoiceValue(n, n2);
            this.naviMap.getMapManager().getFunctionCounter().incCounter(25);
        }
        this.forceHiddenContextRefresh(bl2);
    }

    @Override
    public void forceHiddenContextRefresh(boolean bl) {
        if (bl && this.getMap().getActiveContextIndex() == 3) {
            this.getMap().forceHiddenContextRefresh();
        }
    }

    protected void refreshModels() {
        this.getLogger().log(14808325, "SetupHandler#refreshModels()");
        this.getMap().getGuiInterface().updateSetupModels(this.getDayNightView(), this.convertMapTypeOrientationToModel(this.getMapType(), this.getOrientation()), this.getMapRepresentation(), SetupHandler.convertAdditionalInfoToModel(this.getAdditionalInfos(), this.env), this.getCrossingView(), this.getAutoZoom());
    }

    @Override
    public void setMapTypeAndOrientation(int n) {
        this.getLogger().log(1078071040, "SetupHandler#setMapTypeAndOrientation: choiceIndex = %1", (long)n);
        if (!this.mapOptionValidator.isMapTypeAndOrientationValid(n)) {
            this.getLogger().log(10000, "SetupHandler#setMapTypeAndOrientation() - invalid parameter: %1 ", (long)n);
            n = State$StateData.getDefaultMapType();
        }
        int n2 = -1;
        int n3 = -1;
        if (n == 0 || n == 1) {
            if (this.getMapType() == 1) {
                if (n == 0) {
                    n3 = 1;
                } else if (n == 1) {
                    n3 = 0;
                }
            } else {
                n2 = 1;
                if (n == 0 && this.getOrientation() != 1) {
                    n3 = 1;
                } else if (n == 1 && this.getOrientation() != 0) {
                    n3 = 0;
                }
            }
        } else if (n == 3 || n == 4) {
            n2 = this.convertMapTypeChoiceIndex(n);
            n3 = 0;
        } else {
            n2 = this.convertMapTypeChoiceIndex(n);
            if (n == 2) {
                n3 = 1;
            }
        }
        if (n3 != -1) {
            this.setOrientation(n3, true);
        }
        if (n2 != -1) {
            this.setMapType(n2, true);
        }
    }

    private int convertMapTypeChoiceIndex(int n) {
        switch (n) {
            case 3: {
                return 0;
            }
            case 0: 
            case 1: {
                return 1;
            }
            case 2: {
                return 2;
            }
            case 4: {
                return 3;
            }
        }
        this.getLogger().log(10000, "SetupHandler#convertMapTypeChoiceIndex invalid choiceIndex: %1", (long)n);
        return -1;
    }

    private int convertMapTypeOrientationToModel(int n, int n2) {
        switch (n) {
            case 0: {
                return 3;
            }
            case 2: {
                return 2;
            }
            case 3: {
                return 4;
            }
            case 1: {
                if (n2 == 1) {
                    return 0;
                }
                return 1;
            }
        }
        this.getLogger().log(10000, "SetupHandler#convertMapTypeOrientationToModel() - invalid map type: %1", (long)n);
        return 0;
    }

    @Override
    public void saveState() {
        if (!this.initializationPhaseFinished) {
            this.getLogger().log(-1601830656, "SetupHandler#saveState() - not yet initialized - ignore!");
            return;
        }
        IStorageAccess iStorageAccess = this.env.getFramework().getStorageMgr();
        if (iStorageAccess != null) {
            this.getLogger().log(14808325, "SetupHandler#saveState() - saving state, container instance: %1", (Object)this.stateDataProxy);
            int n = this.naviMap.isMapKombi() ? 950 : 900;
            State state = new State(iStorageAccess, this.getLogger(), this.env.getFramework(), n);
            state.setPanorama(this.stateDataProxy.isSetupPanorama());
            state.setDayNightView(this.stateDataProxy.getSetupDayNightView());
            state.setOrientation(this.stateDataProxy.getSetupOrientation());
            state.setMapType(this.stateDataProxy.getSetupMapType());
            state.setAutoZoom(this.stateDataProxy.getSetupAutoZoom());
            state.setAdditionalInfos(this.stateDataProxy.getSetupAdditionalInfos());
            state.setCrossingView(this.stateDataProxy.getSetupCrossingView());
            state.setMapRepresentation(this.stateDataProxy.getMapRepresentation());
            state.setZoomLevelIndex(this.stateDataProxy.getSavedZoomListIndex());
            this.saveStateMapContent(state, 0);
            this.saveStateMapContent(state, 1);
            this.saveStateMapContent(state, 2);
            int[] nArray = this.getMap().getMapDataContainer().sMapContentList.getSystemLayers();
            int[] nArray2 = this.getMap().getMapDataContainer().sMapContentList.getSystemLayersAvailable();
            this.getLogger().log(14808325, "SetupHandler#saveState() - KML Layer: %1, available: %2", (Object)nArray, (Object)nArray2);
            state.setSystemLayers(nArray);
            state.setSystemLayersAvailable(nArray2);
            state.setGoogle3DCityModel(this.stateDataProxy.getSetupGoogle3DCityModel());
            state.setTrafficFlow(this.stateDataProxy.getSetupSpeedAndFlowRoadClass());
            state.setTrafficEventNoticeMap(this.stateDataProxy.isSetupTrafficEventNoticeMap());
            state.setUncrowedRoad(this.stateDataProxy.isSetupUncrowdedRoad());
            state.serializeAndWrite();
        }
    }

    @Override
    public void initFromStateData(State$StateData state$StateData, boolean bl) {
        try {
            this.stateDataProxy.loadByPersistence(state$StateData, this.mapKey);
            int n = this.stateDataProxy.getMapRepresentation();
            if (n == 1 && Util.isLockFeatureNavMapAdvancedMapEnabled(this.env) && this.getLockFeatureStateChoice()) {
                this.getLogger().log(-1601830656, "SetupHandler#initFromStateData() - Google Earth is not allowed while driving! -> Change to Standard");
                this.updateLockingState(true);
            } else {
                this.setMapRepresentation(n, false);
            }
            this.setOption(1, this.stateDataProxy.getSetupDayNightView(), false);
            this.setOrientation(this.stateDataProxy.getSetupOrientation(), false);
            this.setMapType(this.stateDataProxy.getSetupMapType(), false);
            this.setAutoZoom(this.stateDataProxy.getSetupAutoZoom(), false);
            this.setAdditionalInfos(this.stateDataProxy.getSetupAdditionalInfos(), false);
            this.setCrossingView(this.stateDataProxy.getSetupCrossingView(), false);
            this.setGoogle3DCityModel(this.stateDataProxy.getSetupGoogle3DCityModel(), false);
            this.setSpeedAndFlowRoadClass(this.stateDataProxy.getSetupSpeedAndFlowRoadClass(), false);
            this.setTrafficEventNoticeMap(this.stateDataProxy.isSetupTrafficEventNoticeMap(), false);
            this.setUncrowdedRoad(this.stateDataProxy.isSetupUncrowdedRoad(), false);
            for (int i2 = 0; i2 < 3; ++i2) {
                this.setTMCSymbols(this.stateDataProxy.getSetupTMCSymbols(i2), i2);
                this.set3DLandmarks(this.stateDataProxy.getSetup3DLandmarks(i2), i2);
                this.set3DBuildings(this.stateDataProxy.getSetup3DBuildings(i2), i2);
                this.setFavorites(this.stateDataProxy.getSetupFavorites(i2), false, i2);
                this.setBrandedPOIs(this.stateDataProxy.getSetupBrandedPOIs(i2), false, i2);
                this.setSpeedAndFlowFreeflow(this.stateDataProxy.getSetupSpeedAndFlowFreeflow(i2), false, i2);
                this.setSpeedAndFlowCongestions(this.stateDataProxy.getSetupSpeedAndFlowCongestions(i2), false, i2);
                this.setPicNavIcons(this.stateDataProxy.getSetupPicNavIcons(i2), false, i2);
                this.setWeatherIcons(this.stateDataProxy.getSetupWeatherIcons(i2), false, i2);
            }
            float[] fArray = this.getMap().getZoomHandler().getZoomList();
            if (fArray == null) {
                this.getLogger().log(-1601830656, "SetupHandler#initFromStateData(): zoomList not available!");
            } else {
                int n2 = this.stateDataProxy.getSavedZoomListIndex();
                if (this.getMapRepresentation() == 3) {
                    n2 = this.getMap().getZoomHandler().getZoomListIndex(6318662);
                } else if (n2 == -1) {
                    n2 = this.getMap().getZoomHandler().getZoomListIndex(51267);
                }
                this.getLogger().log(1078071040, "SetupHandler#initFromStateData(): ZoomIndex = %1", (long)n2);
                if (n2 >= fArray.length) {
                    n2 = fArray.length - 1;
                }
                this.initZoomListModel(n2);
                this.getMap().getZoomHandler().setZoom(n2);
                this.getMap().getMVResponseControl().initZoomListIndex(n2);
                this.setSavedZoomListIndex(n2, false);
            }
            this.getMap().getMapDataContainer().sMapContentList.initializeSystemLayers(this.stateDataProxy.getSystemLayers(), this.stateDataProxy.getSystemLayerAvailable(), false);
            this.refreshModels();
            this.getMap().getMapDataContainer().sMapContentList.refresh();
            this.setInitializationPhasefinished();
        }
        catch (Exception exception) {
            this.getLogger().log(10000, "SetupHandler#initFromStateData() - ERROR=%1", (Throwable)exception);
        }
        this.initClusterSettings();
        if (bl) {
            this.saveState();
            this.getLogger().log(1078071040, "SetupHandler#initFromStateData(): Stored new settings from state");
        }
    }

    @Override
    public boolean isInitializationPhasefinished() {
        return this.initializationPhaseFinished;
    }

    protected void setInitializationPhasefinished() {
        this.initializationPhaseFinished = true;
    }

    protected void initClusterSettings() {
        this.getMap().getNaviInterface().getClusterService().applySetupHandlerSettings();
    }

    private void initZoomListModel(int n) {
        RangeModelApp rangeModelApp = this.env.getRangeModel(1545340416);
        if (rangeModelApp != null) {
            rangeModelApp.setValue(n);
        }
    }

    @Override
    public void setMapRepresentation(int n, boolean bl) {
        boolean bl2;
        if (!this.mapOptionValidator.isMapRepresentationValid(n)) {
            this.getLogger().log(10000, "SetupHandler#setMapRepresentation() - invalid parameter: %1 ", (long)n);
            n = State$StateData.getDefaultMapRepresentation();
        }
        this.getLogger().log(1078071040, "SetupHandler#setMapRepresentation(): mapRepresentation: %2, persistent: %1", bl, (long)n);
        if (n == 3) {
            if (!this.naviMap.isMapMain()) {
                n = this.mapOptionValidator.isMapRepresentationValid(2) ? 2 : State$StateData.getDefaultMapRepresentation();
            } else {
                this.setMapRepresentationRangeMapHandling();
            }
        }
        boolean bl3 = bl2 = this.stateDataProxy.getMapRepresentation() != n;
        if (bl2 || !bl) {
            this.stateDataProxy.setBackupMapRepresentation(this.stateDataProxy.getMapRepresentation());
            this.stateDataProxy.setMapRepresentation(n);
            this.getLogger().log(-2137614336, "SetupHandler#setMapRepresentation(): isFPK: %1, isPanorama: %2", Util.isClusterMapFPK(this.env.getFramework()), this.isPanorama());
            this.refreshModels();
            if (this.isActive()) {
                this.getActiveContext().onChangedMapRepresentation(n, this.stateDataProxy.getBackupMapRepresentation());
            } else {
                this.getLogger().log(-1601830656, "SetupHandler#setMapRepresentation(): not bound to a map");
            }
            if (bl && bl2) {
                this.saveState();
                this.getLogger().log(1078071040, "SetupHandler#setMapRepresentation(): Saving %1", (long)this.stateDataProxy.getMapRepresentation());
            }
        }
    }

    protected void setMapRepresentationRangeMapHandling() {
        this.getActiveContext().setRangeMapDefaultZoomLevel();
    }

    @Override
    public void setSavedZoomListIndex(int n, boolean bl) {
        if (n < 0 || n >= this.getMap().getZoomHandler().getZoomList().length) {
            this.getLogger().log(10000, "SetupHandler#setSavedZoomListIndex() - invalid parameter: %1 ", (long)n);
            n = State$StateData.getDefaultZoomLevelIndex();
        }
        boolean bl2 = this.stateDataProxy.getSavedZoomListIndex() != n;
        this.stateDataProxy.setSavedZoomListIndex(n);
        if (bl && bl2) {
            this.saveState();
            this.getLogger().log(1078071040, "SetupHandler#setSavedZoomListIndex(): Saving Zoom = %2, persistent = %1", bl, (long)this.stateDataProxy.getSavedZoomListIndex());
        }
    }

    private void set3DBuildings(int n, int n2) {
        if (!this.mapOptionValidator.is3dBuildingsValid(n)) {
            this.getLogger().log(10000, "SetupHandler#set3DBuildings() - invalid parameter: %1 ", (long)n);
            n = State$StateData.getDefault3DBuildings(this.env.getFramework());
        }
        this.stateDataProxy.setSetup3DBuildings(n, n2);
    }

    private void set3DLandmarks(boolean bl, int n) {
        boolean bl2;
        if (bl && !Util.is3DLandmarksAvailable(this.env.getFramework())) {
            this.getLogger().log(10000, "SetupHandler#set3DLandmarks() - invalid parameter: %1 ", bl);
            bl = State$StateData.getDefaultShow3DLandmarks(this.env.getFramework());
        }
        boolean bl3 = bl2 = this.stateDataProxy.getSetup3DLandmarks(n) != bl;
        if (bl2) {
            this.stateDataProxy.setSetup3DLandmarks(bl, n);
        }
    }

    @Override
    public void setAdditionalInfos(int n, boolean bl) {
        boolean bl2;
        if (!this.mapOptionValidator.isAdditionalInfosValid(n)) {
            this.getLogger().log(10000, "SetupHandler#setAdditionalInfos() - invalid parameter: %1 ", (long)n);
            n = State$StateData.getDefaultAdditionalInfos(this.env.getFramework());
        }
        boolean bl3 = bl2 = this.stateDataProxy.getSetupAdditionalInfos() != n;
        if (bl2 || !bl) {
            this.stateDataProxy.setSetupAdditionalInfos(n);
            this.refreshModels();
            if (this.isActive()) {
                this.getActiveContext().onChangedAdditionalInfos(n);
            } else {
                this.getLogger().log(-1601830656, "SetupHandler#setAdditionalInfos(): not bound to a map");
            }
            if (bl) {
                this.saveState();
                this.getLogger().log(1078071040, "SetupHandler#setAdditionalInfos(): Saving RouteInfo/TurnByTurn/OverviewMap/Off/RangeMap = %1", (long)this.stateDataProxy.getSetupAdditionalInfos());
            }
        }
    }

    @Override
    public void setAutoZoom(int n, boolean bl) {
        boolean bl2;
        if (!this.mapOptionValidator.isAutoZoomValid(n)) {
            this.getLogger().log(10000, "SetupHandler#setAutoZoom() - invalid parameter: %1 ", (long)n);
            n = State$StateData.getDefaultAutoZoom();
        }
        this.getLogger().log(1078071040, "SetupHandler#setAutoZoom(): Setting Autozoom: Auto/Cross/Off = %1", (long)n);
        boolean bl3 = bl2 = this.stateDataProxy.getSetupAutoZoom() != n;
        if (bl2 || !bl) {
            this.stateDataProxy.setSetupAutoZoom(n);
            n = this.stateDataProxy.getSetupAutoZoom();
            this.refreshModels();
            if (this.isActive()) {
                this.getActiveContext().onChangedAutoZoom(n);
            } else {
                this.getLogger().log(-1601830656, "SetupHandler#setAutoZoom(): not bound to a map");
            }
            if (bl) {
                this.saveState();
                this.getLogger().log(1078071040, "SetupHandler#setAutoZoom(): Saving Autozoom: Auto/Cross/Off = %1", (long)this.stateDataProxy.getSetupAutoZoom());
            }
        }
    }

    @Override
    public boolean isManeuverZoomDependendOnAutoZoom() {
        return true;
    }

    @Override
    public void setBrandedPOIs(int n, boolean bl, int n2) {
        boolean bl2;
        if (!this.mapOptionValidator.isBrandedPOIsValid(n)) {
            this.getLogger().log(10000, "SetupHandler#setBrandedPOIs() - invalid parameter: %1 ", (long)n);
            n = State$StateData.getDefaultBrandedPois();
        }
        boolean bl3 = bl2 = this.stateDataProxy.getSetupBrandedPOIs(n2) != n;
        if (bl2 || !bl) {
            this.stateDataProxy.setSetupBrandedPOIs(n, n2);
            if (bl) {
                this.saveState();
                this.getLogger().log(1078071040, "SetupHandler#setBrandedPOIs(): Saving Branded POIs = %1", (long)this.stateDataProxy.getSetupBrandedPOIs(n2));
            }
        }
    }

    @Override
    public void setCrossingView(int n, boolean bl) {
        boolean bl2;
        if (!this.mapOptionValidator.isCrossingViewValid(n)) {
            this.getLogger().log(10000, "SetupHandler#setCrossingView() - invalid parameter: %1 ", (long)n);
            n = State$StateData.getDefaultCrossingView(this.env.getFramework());
        }
        boolean bl3 = bl2 = this.stateDataProxy.getSetupCrossingView() != n;
        if (bl2 || !bl) {
            this.stateDataProxy.setSetupCrossingView(n);
            this.refreshModels();
            if (this.isActive() && !this.isCrossingViewEnabled() && this.getMap().getRouteInfoContextHandler().isManeuverViewVisible()) {
                this.getLogger().log(-2137614336, "SetupHandler#setCrossingView() - correct visible display context!");
                this.getMap().getActiveCtx().setVisibleDisplayContextID(this.getMap().getMapDataContainer().sRequestedDisplayContextID);
            }
            if (bl) {
                this.saveState();
                this.getLogger().log(1078071040, "SetupHandler#setCrossingView(): Saving crossing view on/off = %1", (long)this.stateDataProxy.getSetupCrossingView());
            }
        }
    }

    private void setDayNightView(int n) {
        boolean bl;
        if (!this.mapOptionValidator.isSetupMapColorValid(n)) {
            this.getLogger().log(10000, "SetupHandler#setDayNightView() - invalid parameter: %1 ", (long)n);
            n = State$StateData.getDefaultDayNightView();
        }
        boolean bl2 = bl = this.stateDataProxy.getSetupDayNightView() != n;
        if (bl) {
            this.stateDataProxy.setSetupDayNightView(n);
        }
        this.refreshModels();
        if (this.isActive()) {
            this.getActiveContext().onChangedDayNightView(n);
        } else {
            this.getLogger().log(-1601830656, "SetupHandler#setDayNightView(): not bound to a map");
        }
    }

    @Override
    public void setMapType(int n, boolean bl) {
        boolean bl2;
        if (!this.mapOptionValidator.isMapTypeValid(n)) {
            this.getLogger().log(10000, "SetupHandler#setMapType() - invalid parameter: %1 ", (long)n);
            n = State$StateData.getDefaultMapType();
        }
        boolean bl3 = bl2 = this.stateDataProxy.getSetupMapType() != n;
        if (bl2 || !bl) {
            int n2 = this.stateDataProxy.getSetupMapType();
            this.stateDataProxy.setSetupMapType(n);
            if (bl) {
                this.saveState();
                this.getLogger().log(1078071040, "SetupHandler#setMapType(): Saving Dest/Pos2D/3D/Overview = %1", (long)this.stateDataProxy.getSetupMapType());
            }
            if (this.isActive()) {
                this.getActiveContext().onChangedMapType(n, n2);
            } else {
                this.getLogger().log(-1601830656, "SetupHandler#setMapType(): not bound to a map");
            }
        }
    }

    @Override
    public void setOrientation(int n, boolean bl) {
        boolean bl2;
        if (!this.mapOptionValidator.isOrientationValid(n)) {
            this.getLogger().log(10000, "SetupHandler#setOrientation() - invalid parameter: %1 ", (long)n);
            n = State$StateData.getDefaultOrientation();
        }
        boolean bl3 = bl2 = this.stateDataProxy.getSetupOrientation() != n;
        if (bl2 || !bl) {
            this.stateDataProxy.setSetupOrientation(n);
            if (this.isActive()) {
                this.getActiveContext().onChangedOrientation(n);
            } else {
                this.getLogger().log(-1601830656, "SetupHandler#setOrientation(): not bound to a map");
            }
            if (bl) {
                this.saveState();
                this.getLogger().log(1078071040, "SetupHandler#setOrientation(): Saving North/Car/Auto = %1", (long)this.stateDataProxy.getSetupOrientation());
            }
        }
    }

    @Override
    public void setPicNavIcons(boolean bl, boolean bl2, int n) {
        boolean bl3;
        if (!Util.isPictureNavPresent(this.env.getFramework()) && bl) {
            this.getLogger().log(-1601830656, "SetupHandler#setPicNavIcons() - invalid parameter: %1 ", bl);
            bl = State$StateData.getDefaultPicNavIcons(this.env.getFramework());
        }
        boolean bl4 = bl3 = this.stateDataProxy.getSetupPicNavIcons(n) != bl;
        if (bl3 || !bl2) {
            this.stateDataProxy.setSetupPicNavIcons(bl, n);
            if (bl2) {
                this.saveState();
                this.getLogger().log(1078071040, "SetupHandler#setPicNavIcons(): Saving PicNav icons = %1", this.stateDataProxy.getSetupPicNavIcons(n));
            }
        }
    }

    @Override
    public void setWeatherIcons(boolean bl, boolean bl2, int n) {
        boolean bl3;
        if (bl && !Util.isWeatherOnMapPresent(this.env.getFramework())) {
            this.getLogger().log(10000, "SetupHandler#setWeatherIcons() - invalid parameter: %1 ", bl);
            bl = State$StateData.getDefaultWeatherIcons(this.env.getFramework());
        }
        boolean bl4 = bl3 = this.stateDataProxy.getSetupWeatherIcons(n) != bl;
        if (bl3 || !bl2) {
            this.stateDataProxy.setSetupWeatherIcons(bl, n);
            if (bl2) {
                this.saveState();
                this.getLogger().log(1078071040, "SetupHandler#setWeatherIcons(): Saving weather icons = %1", this.stateDataProxy.getSetupWeatherIcons(n));
            }
        }
    }

    @Override
    public void setRange(boolean bl, boolean bl2, int n) {
        boolean bl3;
        boolean bl4 = bl3 = this.stateDataProxy.getSetupRange(n) != bl;
        if (bl3 || !bl2) {
            this.stateDataProxy.setSetupRange(bl, n);
            if (bl2) {
                this.saveState();
                this.getLogger().log(1078071040, "SetupHandler#setRange(): Saving range = %1", this.stateDataProxy.getSetupRange(n));
            }
        }
    }

    @Override
    public void setSpeedAndFlowCongestions(boolean bl, boolean bl2, int n) {
        boolean bl3;
        if (bl && !Util.isSpeedAndFlowAvailable(this.env.getFramework())) {
            this.getLogger().log(10000, "SetupHandler#setSpeedAndFlowCongestions() - invalid parameter: %1 ", bl);
            bl = State$StateData.getDefaultSpeedAndFlowCongestions(this.env.getFramework());
        }
        boolean bl4 = bl3 = this.stateDataProxy.getSetupSpeedAndFlowCongestions(n) != bl;
        if (bl3 || !bl2) {
            this.stateDataProxy.setSetupSpeedAndFlowCongestions(bl, n);
            if (bl2) {
                this.saveState();
                this.getLogger().log(1078071040, "SetupHandler#setSpeedAndFlowCongestions(): Saving Speed and Flow Congestions = %1", this.stateDataProxy.getSetupSpeedAndFlowCongestions(n));
            }
        }
    }

    @Override
    public void setSpeedAndFlowFreeflow(boolean bl, boolean bl2, int n) {
        boolean bl3;
        if (bl && !Util.isSpeedAndFlowAvailable(this.env.getFramework())) {
            this.getLogger().log(10000, "SetupHandler#setSpeedAndFlowFreeflow() - invalid parameter: %1 ", bl);
            bl = State$StateData.getDefaultSpeedAndFlowFreeflow(this.env.getFramework());
        }
        boolean bl4 = bl3 = this.stateDataProxy.getSetupSpeedAndFlowFreeflow(n) != bl;
        if (bl3 || !bl2) {
            this.stateDataProxy.setSetupSpeedAndFlowFreeflow(bl, n);
            if (bl2) {
                this.saveState();
                this.getLogger().log(1078071040, "SetupHandler#setSpeedAndFlowFreeflow(): Saving Speed and Flow Freeflow = %1", this.stateDataProxy.getSetupSpeedAndFlowFreeflow(n));
            }
        }
    }

    private void setTMCSymbols(boolean bl, int n) {
        boolean bl2;
        if (bl && !Util.isTrafficPresent(this.env.getFramework())) {
            this.getLogger().log(10000, "SetupHandler#setTMCSymbols() - invalid parameter: %1 ", bl);
            bl = State$StateData.getDefaultTmcSymbols(this.env.getFramework());
        }
        boolean bl3 = bl2 = this.stateDataProxy.getSetupTMCSymbols(n) != bl;
        if (bl2) {
            this.stateDataProxy.setSetupTMCSymbols(bl, n);
        }
    }

    @Override
    public void setTopBusiness(boolean bl, boolean bl2, int n) {
        boolean bl3;
        boolean bl4 = bl3 = this.stateDataProxy.getSetupFavorites(n) != bl;
        if (bl3 || !bl2) {
            this.stateDataProxy.setSetupFavorites(bl, n);
            if (bl2) {
                this.saveState();
                this.getLogger().log(1078071040, "SetupHandler#setTopBusiness(): Saving TOP Dest. (b) = %1", this.stateDataProxy.getSetupFavorites(n));
            }
        }
    }

    @Override
    public void setTopPrivate(boolean bl, boolean bl2, int n) {
        boolean bl3;
        boolean bl4 = bl3 = this.stateDataProxy.getSetupTopPrivate(n) != bl;
        if (bl3 || !bl2) {
            this.stateDataProxy.setSetupTopPrivate(bl, n);
            if (bl2) {
                this.saveState();
                this.getLogger().log(1078071040, "SetupHandler#setTopPrivate(): Saving TOP Dest. (p) = %1", this.stateDataProxy.getSetupTopPrivate(n));
            }
        }
    }

    @Override
    public int[] getPoiVisibility() {
        return this.naviMap.getMapContentHandler().getPoiVisibility();
    }

    @Override
    public void setPoiVisible(int[] nArray, boolean[] blArray, boolean bl) {
        this.getLogger().log(1078071040, "SetupHandler#setPoiVisible() - categoryUid.length: %1, visibility.length: %2", nArray == null ? 0L : (long)nArray.length, blArray == null ? 0L : (long)blArray.length);
        if (nArray == null) {
            nArray = new int[]{};
            blArray = new boolean[]{};
        }
        this.stateDataProxy.setSetupPoiVisibleUid(nArray);
        this.stateDataProxy.setSetupPoiVisibleStatus(blArray);
        if (this.getLogger().isDebug2()) {
            Buffer buffer = new Buffer();
            for (int i2 = 0; i2 < nArray.length; ++i2) {
                if (!blArray[i2]) continue;
                buffer.append(nArray[i2]).append(", ");
            }
            this.getLogger().log(14808325, "SetupHandler#setPoiVisible() - visible uid=[%1]", (Object)buffer.toString());
        } else {
            int n = 0;
            for (int i3 = 0; i3 < blArray.length; ++i3) {
                if (!blArray[i3]) continue;
                ++n;
            }
            this.getLogger().log(-2137614336, "SetupHandler#setPoiVisible() - count of visible uid = %1", (long)n);
        }
        this.getMap().getMVRequest().ehSetCategoryVisibility(this.getMap().getCurrentMapStyle(), this.stateDataProxy.getSetupPoiVisibleUid(), this.stateDataProxy.getSetupPoiVisibleStatus());
        if (bl) {
            if (this.isActive()) {
                this.getLogger().log(-2137614336, "SetupHandler#setPoiVisible(): Saving POI visibility (ignore - POI visibilities are persisted by Navi)");
            } else {
                this.getLogger().log(-1601830656, "SetupHandler#setPoiVisible(): not bound to a map");
            }
        }
    }

    @Override
    public void setGoogle3DCityModel(int n, boolean bl) {
        if (!this.mapOptionValidator.isGoogle3DCityModelValid(n)) {
            this.getLogger().log(10000, "SetupHandler#setGoogle3DCityModel() - invalid parameter: %1 ", (long)n);
            n = State$StateData.getDefaultGoogle3DCityModel();
        }
        boolean bl2 = this.stateDataProxy.getSetupGoogle3DCityModel() != n;
        this.stateDataProxy.setSetupGoogle3DCityModel(n);
        if (bl && bl2) {
            this.saveState();
            this.getLogger().log(1078071040, "SetupHandler#setGoogle3DCityModel(): Saving 3D Buildings = %1", (long)this.stateDataProxy.getSetupGoogle3DCityModel());
        }
    }

    public void setSpeedAndFlowRoadClass(int n, boolean bl) {
        boolean bl2;
        if (n != 0 && !Util.isSpeedAndFlowAvailable(this.env.getFramework())) {
            this.getLogger().log(10000, "SetupHandler#setSpeedAndFlowRoadClass() - invalid parameter: %1 ", (long)n);
            n = State$StateData.getDefaultTrafficFlow(this.env.getFramework());
        }
        boolean bl3 = bl2 = this.stateDataProxy.getSetupSpeedAndFlowRoadClass() != n;
        if (bl2 || !bl) {
            this.stateDataProxy.setSetupSpeedAndFlowRoadClass(n);
            if (bl) {
                this.saveState();
                this.getLogger().log(1078071040, "SetupHandler#setSpeedAndFlowRoadClass(): Saving Traffic flow and road class. (p) = %1", (long)this.stateDataProxy.getSetupSpeedAndFlowRoadClass());
            }
        }
    }

    public void setTrafficEventNoticeMap(boolean bl, boolean bl2) {
        boolean bl3;
        if (bl && !this.mapOptionValidator.isTrafficEventNoticeMapValid()) {
            this.getLogger().log(10000, "SetupHandler#setTrafficEventNoticeMap() - invalid parameter: %1 ", bl);
            bl = State$StateData.getDefaultTrafficEventNoticeMap(this.env.getFramework());
        }
        boolean bl4 = bl3 = this.stateDataProxy.isSetupTrafficEventNoticeMap() != bl;
        if (bl3 || !bl2) {
            this.stateDataProxy.setSetupTrafficEventNoticeMap(bl);
            if (bl2) {
                this.saveState();
                this.getLogger().log(1078071040, "SetupHandler#setTrafficEventNoticeMap(): Saving Traffic Event Notice map (p) = %1", this.stateDataProxy.isSetupTrafficEventNoticeMap());
            }
        }
    }

    public void setUncrowdedRoad(boolean bl, boolean bl2) {
        boolean bl3;
        if (bl && !Util.isUncrowdedRoadsCheckboxAvailable(this.env.getFramework()) || !Util.isSpeedAndFlowAvailable(this.env.getFramework())) {
            this.getLogger().log(10000, "SetupHandler#setUncrowdedRoad() - invalid parameter: %1 ", bl);
            bl = State$StateData.getDefaultUncrowdedRoad();
        }
        boolean bl4 = bl3 = this.stateDataProxy.isSetupUncrowdedRoad() != bl;
        if (bl3 || !bl2) {
            this.stateDataProxy.setSetupUncrowdedRoad(bl);
            if (bl2) {
                this.saveState();
                this.getLogger().log(1078071040, "SetupHandler#setUncrowdedRoad(): Saving UncrowdedRoad (p) = %1", this.stateDataProxy.isSetupUncrowdedRoad());
            }
        }
    }

    @Override
    public int getMapRepresentation() {
        return this.stateDataProxy.getMapRepresentation();
    }

    @Override
    public int getBackupMapRepresentation() {
        return this.stateDataProxy.getBackupMapRepresentation();
    }

    @Override
    public int getSavedZoomListIndex() {
        return this.stateDataProxy.getSavedZoomListIndex();
    }

    @Override
    public int get3DBuildings(int n) {
        return this.stateDataProxy.getSetup3DBuildings(n);
    }

    @Override
    public boolean get3DLandmarks(int n) {
        return this.stateDataProxy.getSetup3DLandmarks(n);
    }

    @Override
    public int getAdditionalInfos() {
        if (MapUtils.isRSERouteCalcMode(this.env.getFramework())) {
            return 3;
        }
        return this.stateDataProxy.getSetupAdditionalInfos();
    }

    @Override
    public int getAutoZoom() {
        return this.getAutoZoom(false);
    }

    @Override
    public int getAutoZoom(boolean bl) {
        if (this.getMap().getActiveContextIndex() == 22) {
            return 2;
        }
        if (!this.env.getFramework().isFrontMU() || this.getMap().getNaviInterface().isOffroad()) {
            return 2;
        }
        if (bl) {
            if (this.getMapRepresentation() == 3) {
                return 2;
            }
            int n = this.getMapType(bl);
            if (n == 0) {
                return 2;
            }
        }
        this.getLogger().log(14808325, "SetupHandler#getSetupAutoZoom - on/crossing/off = %1", (long)this.stateDataProxy.getSetupAutoZoom());
        return this.stateDataProxy.getSetupAutoZoom();
    }

    @Override
    public int getBrandedPOIs(int n) {
        return this.stateDataProxy.getSetupBrandedPOIs(n);
    }

    @Override
    public int getCrossingView() {
        if (MapUtils.isRSERouteCalcMode(this.env.getFramework())) {
            this.getLogger().log(-2137614336, "SetupHandler#getCrossingView() - crossing view on/off = %1, because it is RSERouteCalcMode", 1L);
            return 1;
        }
        int n = this.stateDataProxy.getSetupCrossingView();
        if (!this.mapOptionValidator.isCrossingViewValid(n)) {
            n = 1;
        }
        this.getLogger().log(14808325, "SetupHandler#getSetupCrossingView - crossing view on/off = %1", (long)n);
        return n;
    }

    @Override
    public int getDayNightView() {
        return this.stateDataProxy.getSetupDayNightView();
    }

    @Override
    public int getMapType() {
        return this.getMapType(false);
    }

    @Override
    public int getMapType(boolean bl) {
        if (MapUtils.isRSERouteCalcMode(this.env.getFramework())) {
            return 3;
        }
        if (bl && this.getMapRepresentation() == 3 && this.stateDataProxy.getSetupMapType() == 2) {
            return 1;
        }
        this.getLogger().log(14808325, "SetupHandler#getSetupMapType - destination/2D/3D/overview/detail = %1", (long)this.stateDataProxy.getSetupMapType());
        return this.stateDataProxy.getSetupMapType();
    }

    @Override
    public int getOrientation() {
        if (MapUtils.isRSERouteCalcMode(this.env.getFramework())) {
            this.getLogger().log(-2137614336, "SetupHandler#getOrientation() - force to NORTH");
            return 0;
        }
        this.getLogger().log(14808325, "SetupHandler#getSetupOrientation - north/car = %1", (long)this.stateDataProxy.getSetupOrientation());
        return this.stateDataProxy.getSetupOrientation();
    }

    @Override
    public boolean getPicNavIcons(int n) {
        return this.stateDataProxy.getSetupPicNavIcons(n);
    }

    @Override
    public boolean isWeatherIconVisible(int n) {
        return this.stateDataProxy.getSetupWeatherIcons(n);
    }

    @Override
    public boolean getRange(int n) {
        return this.stateDataProxy.getSetupRange(n);
    }

    @Override
    public boolean getSpeedAndFlowCongestions(int n) {
        return this.stateDataProxy.getSetupSpeedAndFlowCongestions(n);
    }

    @Override
    public boolean getSpeedAndFlowFreeflow(int n) {
        return this.stateDataProxy.getSetupSpeedAndFlowFreeflow(n);
    }

    public int getSpeedAndFlowRoadClass() {
        return this.stateDataProxy.getSetupSpeedAndFlowRoadClass();
    }

    @Override
    public boolean getTMCSymbols(int n) {
        return this.stateDataProxy.getSetupTMCSymbols(n);
    }

    @Override
    public boolean getTopBusiness(int n) {
        return this.stateDataProxy.getSetupFavorites(n);
    }

    @Override
    public boolean getTopPrivate(int n) {
        return this.stateDataProxy.getSetupTopPrivate(n);
    }

    @Override
    public int[] getPoiVisibleUid() {
        return this.stateDataProxy.getSetupPoiVisibleUid();
    }

    @Override
    public boolean[] getPoiVisibleStatus() {
        return this.stateDataProxy.getSetupPoiVisibleStatus();
    }

    @Override
    public boolean isRouteInfoEnabled() {
        int n = this.getAdditionalInfos();
        return n == 0 || n == 1;
    }

    @Override
    public boolean isMapInMapEnabled() {
        int n = this.getAdditionalInfos();
        return n == 2;
    }

    @Override
    public boolean isCrossingViewEnabled() {
        int n = this.getCrossingView();
        return n == 0;
    }

    @Override
    public void setFavorites(boolean bl, boolean bl2, int n) {
        boolean bl3;
        boolean bl4 = bl3 = this.stateDataProxy.getSetupFavorites(n) != bl;
        if (bl3) {
            this.stateDataProxy.setSetupFavorites(bl, n);
            if (bl2) {
                this.saveState();
                this.getLogger().log(1078071040, "SetupHandler#setFavorites(): Saving favorites (b) = %1", this.stateDataProxy.getSetupFavorites(n));
            }
        }
    }

    @Override
    public boolean isFavoriteVisible(int n) {
        return this.stateDataProxy.getSetupFavorites(n);
    }

    @Override
    public int getGoogle3DCityModel() {
        return this.stateDataProxy.getSetupGoogle3DCityModel();
    }

    public final int getTrafficFlow() {
        return this.stateDataProxy.getSetupSpeedAndFlowRoadClass();
    }

    public final boolean isTrafficEventNoticeMap() {
        return this.stateDataProxy.isSetupTrafficEventNoticeMap();
    }

    public final boolean isUncrowedRoad() {
        return this.stateDataProxy.isSetupUncrowdedRoad();
    }

    public String toString() {
        Buffer buffer = new Buffer();
        if (this.getMap() != null) {
            buffer.append("==== SetupHandler[").append(this.getMap().getName()).append("] ====\n");
        } else {
            buffer.append("==== SetupHandler[not bound] ====\n");
        }
        buffer.append(this.stateDataProxy.toString());
        return buffer.toString();
    }

    @Override
    public void resetSettings() {
        this.naviMap.getMapDataContainer().sMapContentList.resetSettings();
    }

    @Override
    public int getEtaMode() {
        return 0;
    }

    @Override
    public int getSpeedAndFlow() {
        return 0;
    }

    @Override
    public int getLayerPOI() {
        return 0;
    }

    @Override
    public int getRangeMapVisibilitySetting() {
        return 0;
    }

    @Override
    public int getIntersectionZoom() {
        return 0;
    }

    @Override
    public int getOnlineTraffic() {
        return 0;
    }

    @Override
    public void setEtaMode(int n, boolean bl) {
    }

    @Override
    public void setLayerPOI(int n, boolean bl) {
    }

    @Override
    public void setRangeMapVisibilitySetting(int n, boolean bl) {
    }

    @Override
    public void setSpeedAndFlow(int n, boolean bl) {
    }

    @Override
    public void setIntersectionZoom(int n, boolean bl) {
    }

    @Override
    public void setOnlineTraffic(int n, boolean bl) {
    }

    @Override
    public int getProperty(int n) {
        this.getLogger().log(14808325, "SetupHandler#getProperty( %1 )", (long)n);
        switch (n) {
            case 0: {
                return this.getTMCSymbols(0) ? 1 : 0;
            }
            case 4: {
                return this.isFavoriteVisible(0) ? 1 : 0;
            }
            case 1: {
                return this.isTrafficEventNoticeMap() ? 1 : 0;
            }
            case 5: {
                return this.getTrafficFlow();
            }
            case 2: {
                return this.isUncrowedRoad() ? 1 : 0;
            }
            case 6: {
                return this.isWeatherIconVisible(0) ? 1 : 0;
            }
        }
        this.getLogger().log(-1601830656, "SetupHandler#getProperty( %1 ) - unknown property", (long)n);
        return 0;
    }

    @Override
    public void setProperty(int n, int n2) {
        this.getLogger().log(-2137614336, "SetupHandler#setProperty( %1, %2 )", (long)n, (long)n2);
        switch (n) {
            case 0: {
                this.setOption(11, n2 == 1, true);
                break;
            }
            case 4: {
                this.setFavorites(n2 == 1, true, 0);
                break;
            }
            case 1: {
                this.setTrafficEventNoticeMap(n2 == 1, true);
                break;
            }
            case 5: {
                boolean bl;
                this.setSpeedAndFlowRoadClass(this.mapTrafficFlowToDSIValue(n2), true);
                boolean bl2 = bl = n2 != 4;
                if (Util.isUncrowdedRoadsCheckboxAvailable(this.env.getFramework())) {
                    bl &= this.isUncrowedRoad();
                }
                boolean bl3 = n2 != 4;
                this.setSpeedAndFlowFreeflow(bl, true, 0);
                this.setSpeedAndFlowCongestions(bl3, true, 0);
                break;
            }
            case 2: {
                this.setUncrowdedRoad(n2 == 1, true);
                boolean bl = n2 == 1 && this.getTrafficFlow() != 0;
                this.setSpeedAndFlowFreeflow(bl, true, 0);
                break;
            }
            case 6: {
                this.setWeatherIcons(n2 == 1, true, 0);
                break;
            }
            default: {
                this.getLogger().log(-1601830656, "SetupHandler#setProperty( %1 ) - unknown property", (long)n);
            }
        }
    }

    private int mapTrafficFlowToDSIValue(int n) {
        switch (n) {
            case 0: {
                return 4;
            }
            case 1: {
                return 1;
            }
            case 2: {
                return 2;
            }
            case 3: {
                return 3;
            }
            case 4: {
                return 0;
            }
        }
        return 4;
    }

    @Override
    public boolean getGeneralPoiVisibility() {
        return true;
    }

    @Override
    public void setOption(int n, int n2, boolean bl) {
        this.getLogger().log(-2137614336, "SetupHandler#setOption( %1, %3, persist=%2 )", (Object)MapOption.getName(n), (Object)Boolean.toString(bl), (long)n2);
        switch (n) {
            case 1: {
                this.setDayNightView(n2);
                break;
            }
            case 2: {
                this.set3DBuildings(n2, 0);
                break;
            }
        }
        if (bl) {
            this.saveState();
        }
    }

    @Override
    public void setOption(int n, boolean bl, boolean bl2) {
        this.getLogger().log(-2137614336, "SetupHandler#setOption( %2, %1, persist=%3 )", bl, (Object)MapOption.getName(n), (Object)Boolean.toString(bl2));
        switch (n) {
            case 11: {
                this.setTMCSymbols(bl, 0);
                break;
            }
            case 3: {
                this.set3DLandmarks(bl, 0);
                break;
            }
        }
        if (bl2) {
            this.saveState();
        }
    }

    public boolean getLockFeatureStateChoice() {
        return this.env.getFramework().getHMIService().getChoiceModel(5583).getValue() == 1;
    }

    private void updateLockingState(boolean bl) {
        this.naviMap.getMapManager().updateLockingState(bl);
        this.naviMap.getNaviInterface().setFeatureToBeLocked(bl);
        this.naviMap.getNaviInterface().getClusterService().getCombiBAPListener().updateLockingState(bl);
    }
}

