/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.map.context;

import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.map.context.SetupHandler;
import de.audi.tghu.navi.app.map.context.State;
import de.audi.tghu.navi.app.map.handler.ISetupHandler;
import de.audi.tghu.navi.app.map.instances.MapKombiMOST;
import de.audi.tghu.navi.app.map.settings.MapOptionValidator;

public class VirtualSetupHandler
extends SetupHandler {
    private ISetupHandler owner;

    public VirtualSetupHandler(NavigationEnv navigationEnv, ISetupHandler iSetupHandler, MapOptionValidator mapOptionValidator) {
        super(navigationEnv, mapOptionValidator);
        this.bind(iSetupHandler);
    }

    public final void bind(ISetupHandler iSetupHandler) {
        this.owner = iSetupHandler;
    }

    private void warn(String string) {
        if (!(this.getMap() instanceof MapKombiMOST)) {
            this.getLogger().log(100000, "VirtualSetupHandler#%1() - unexpected call", (Object)string);
        }
    }

    public int getDayNightView() {
        return this.owner.getDayNightView();
    }

    public boolean getTopBusiness(int n) {
        return this.owner.getTopBusiness(n);
    }

    public boolean getTopPrivate(int n) {
        return this.owner.getTopPrivate(n);
    }

    public int getMapRepresentation() {
        this.warn("getMapRepresentation");
        return this.owner.getMapRepresentation();
    }

    public int getSavedZoomListIndex() {
        this.warn("getSavedZoomListIndex");
        return this.owner.getSavedZoomListIndex();
    }

    public int get3DBuildings(int n) {
        this.warn("get3DBuildings");
        return this.owner.get3DBuildings(n);
    }

    public boolean get3DLandmarks(int n) {
        this.warn("get3DLandmarks");
        return this.owner.get3DLandmarks(n);
    }

    public int getAdditionalInfos() {
        this.warn("getAdditionalInfos");
        return this.owner.getAdditionalInfos();
    }

    public int getAutoZoom() {
        this.warn("getAutoZoom");
        return this.owner.getAutoZoom();
    }

    public int getBrandedPOIs(int n) {
        this.warn("getBrandedPOIs");
        return this.owner.getBrandedPOIs(n);
    }

    public int getCrossingView() {
        this.warn("getCrossingView");
        return this.owner.getCrossingView();
    }

    public int getMapType() {
        this.warn("getMapType");
        return this.owner.getMapType();
    }

    public int getOrientation() {
        this.warn("getOrientation");
        return this.owner.getOrientation();
    }

    public boolean getPicNavIcons(int n) {
        this.warn("getPicNavIcons");
        return this.owner.getPicNavIcons(n);
    }

    public boolean isWeatherIconVisible(int n) {
        this.warn("getWeatherIcons");
        return this.owner.isWeatherIconVisible(n);
    }

    public boolean getSpeedAndFlowCongestions(int n) {
        this.warn("getSpeedAndFlowCongestions");
        return this.owner.getSpeedAndFlowCongestions(n);
    }

    public boolean getSpeedAndFlowFreeflow(int n) {
        this.warn("getSpeedAndFlowFreeflow");
        return this.owner.getSpeedAndFlowFreeflow(n);
    }

    public boolean getTMCSymbols(int n) {
        this.warn("getTMCSymbols");
        return this.owner.getTMCSymbols(n);
    }

    public int[] getPoiVisibleUid() {
        this.warn("getPoiVisibleUid");
        return this.owner.getPoiVisibleUid();
    }

    public boolean[] getPoiVisibleStatus() {
        this.warn("getPoiVisibleStatus");
        return this.owner.getPoiVisibleStatus();
    }

    public boolean isRouteInfoEnabled() {
        this.warn("isRouteInfoEnabled");
        return this.owner.isRouteInfoEnabled();
    }

    public boolean isMapInMapEnabled() {
        this.warn("isMapInMapEnabled");
        return this.owner.isMapInMapEnabled();
    }

    public boolean isCrossingViewEnabled() {
        this.warn("isCrossingViewEnabled");
        return this.owner.isCrossingViewEnabled();
    }

    public int getGoogle3DCityModel() {
        this.warn("getGoogle3DCityModel");
        return this.owner.getGoogle3DCityModel();
    }

    public void saveState() {
        this.warn("saveState");
    }

    public void initFromStateData(State.StateData stateData, boolean bl) {
        this.warn("initFromStateData");
    }

    public void setMapRepresentation(int n, boolean bl) {
        this.warn("setMapRepresentation");
    }

    public void setSavedZoomListIndex(int n, boolean bl) {
        this.warn("setSavedZoomListIndex");
    }

    public void set3DBuildings(int n, boolean bl, int n2) {
        this.warn("set3DBuildings");
    }

    public void set3DLandmarks(boolean bl, boolean bl2, int n) {
        this.warn("set3DLandmarks");
    }

    public void setAdditionalInfos(int n, boolean bl) {
        this.warn("setAdditionalInfos");
    }

    public void setAutoZoom(int n, boolean bl) {
        this.warn("setAutoZoom");
    }

    public void setBrandedPOIs(int n, boolean bl, int n2) {
        this.warn("setBrandedPOIs");
    }

    public void setCrossingView(int n, boolean bl) {
        this.warn("setCrossingView");
    }

    public void setDayNightView(int n, boolean bl) {
    }

    public void setMapType(int n, boolean bl) {
        this.warn("setMapType");
    }

    public void setOrientation(int n, boolean bl) {
        this.warn("setOrientation");
    }

    public void setPicNavIcons(boolean bl, boolean bl2, int n) {
        this.warn("setPicNavIcons");
    }

    public void setWeatherIcons(boolean bl, boolean bl2, int n) {
        this.warn("setWeatherIcons");
    }

    public void setSpeedAndFlowCongestions(boolean bl, boolean bl2, int n) {
        this.warn("setSpeedAndFlowCongestions");
    }

    public void setSpeedAndFlowFreeflow(boolean bl, boolean bl2, int n) {
        this.warn("setSpeedAndFlowFreeflow");
    }

    public void setSplitScreen(int n, boolean bl) {
        this.warn("setSplitScreen");
    }

    public void setSplitScreenMode(int n, boolean bl) {
        this.warn("setSplitScreenMode");
    }

    public void setTMCSymbols(boolean bl, boolean bl2, int n) {
        this.warn("setTMCSymbols");
    }

    public void setTopBusiness(boolean bl, boolean bl2, int n) {
        this.warn("setTopBusiness");
    }

    public void setTopPrivate(boolean bl, boolean bl2, int n) {
        this.warn("setTopPrivate");
    }

    public void setPoiVisible(int[] nArray, boolean[] blArray, boolean bl) {
        this.warn("setPoiVisible");
    }

    public void setGoogle3DCityModel(int n, boolean bl) {
        this.warn("setGoogle3DCityModel");
    }
}

