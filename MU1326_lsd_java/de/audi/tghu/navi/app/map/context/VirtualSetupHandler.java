/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.map.context;

import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.map.context.SetupHandler;
import de.audi.tghu.navi.app.map.context.State$StateData;
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
            this.getLogger().log(-1601830656, "VirtualSetupHandler#%1() - unexpected call", (Object)string);
        }
    }

    @Override
    public int getDayNightView() {
        return this.owner.getDayNightView();
    }

    @Override
    public boolean getTopBusiness(int n) {
        return this.owner.getTopBusiness(n);
    }

    @Override
    public boolean getTopPrivate(int n) {
        return this.owner.getTopPrivate(n);
    }

    @Override
    public int getMapRepresentation() {
        this.warn("getMapRepresentation");
        return this.owner.getMapRepresentation();
    }

    @Override
    public int getSavedZoomListIndex() {
        this.warn("getSavedZoomListIndex");
        return this.owner.getSavedZoomListIndex();
    }

    @Override
    public int get3DBuildings(int n) {
        this.warn("get3DBuildings");
        return this.owner.get3DBuildings(n);
    }

    @Override
    public boolean get3DLandmarks(int n) {
        this.warn("get3DLandmarks");
        return this.owner.get3DLandmarks(n);
    }

    @Override
    public int getAdditionalInfos() {
        this.warn("getAdditionalInfos");
        return this.owner.getAdditionalInfos();
    }

    @Override
    public int getAutoZoom() {
        this.warn("getAutoZoom");
        return this.owner.getAutoZoom();
    }

    @Override
    public int getBrandedPOIs(int n) {
        this.warn("getBrandedPOIs");
        return this.owner.getBrandedPOIs(n);
    }

    @Override
    public int getCrossingView() {
        this.warn("getCrossingView");
        return this.owner.getCrossingView();
    }

    @Override
    public int getMapType() {
        this.warn("getMapType");
        return this.owner.getMapType();
    }

    @Override
    public int getOrientation() {
        this.warn("getOrientation");
        return this.owner.getOrientation();
    }

    @Override
    public boolean getPicNavIcons(int n) {
        this.warn("getPicNavIcons");
        return this.owner.getPicNavIcons(n);
    }

    @Override
    public boolean isWeatherIconVisible(int n) {
        this.warn("getWeatherIcons");
        return this.owner.isWeatherIconVisible(n);
    }

    @Override
    public boolean getSpeedAndFlowCongestions(int n) {
        this.warn("getSpeedAndFlowCongestions");
        return this.owner.getSpeedAndFlowCongestions(n);
    }

    @Override
    public boolean getSpeedAndFlowFreeflow(int n) {
        this.warn("getSpeedAndFlowFreeflow");
        return this.owner.getSpeedAndFlowFreeflow(n);
    }

    @Override
    public boolean getTMCSymbols(int n) {
        this.warn("getTMCSymbols");
        return this.owner.getTMCSymbols(n);
    }

    @Override
    public int[] getPoiVisibleUid() {
        this.warn("getPoiVisibleUid");
        return this.owner.getPoiVisibleUid();
    }

    @Override
    public boolean[] getPoiVisibleStatus() {
        this.warn("getPoiVisibleStatus");
        return this.owner.getPoiVisibleStatus();
    }

    @Override
    public boolean isRouteInfoEnabled() {
        this.warn("isRouteInfoEnabled");
        return this.owner.isRouteInfoEnabled();
    }

    @Override
    public boolean isMapInMapEnabled() {
        this.warn("isMapInMapEnabled");
        return this.owner.isMapInMapEnabled();
    }

    @Override
    public boolean isCrossingViewEnabled() {
        this.warn("isCrossingViewEnabled");
        return this.owner.isCrossingViewEnabled();
    }

    @Override
    public int getGoogle3DCityModel() {
        this.warn("getGoogle3DCityModel");
        return this.owner.getGoogle3DCityModel();
    }

    @Override
    public void saveState() {
        this.warn("saveState");
    }

    @Override
    public void initFromStateData(State$StateData state$StateData, boolean bl) {
        this.warn("initFromStateData");
    }

    @Override
    public void setMapRepresentation(int n, boolean bl) {
        this.warn("setMapRepresentation");
    }

    @Override
    public void setSavedZoomListIndex(int n, boolean bl) {
        this.warn("setSavedZoomListIndex");
    }

    public void set3DBuildings(int n, boolean bl, int n2) {
        this.warn("set3DBuildings");
    }

    public void set3DLandmarks(boolean bl, boolean bl2, int n) {
        this.warn("set3DLandmarks");
    }

    @Override
    public void setAdditionalInfos(int n, boolean bl) {
        this.warn("setAdditionalInfos");
    }

    @Override
    public void setAutoZoom(int n, boolean bl) {
        this.warn("setAutoZoom");
    }

    @Override
    public void setBrandedPOIs(int n, boolean bl, int n2) {
        this.warn("setBrandedPOIs");
    }

    @Override
    public void setCrossingView(int n, boolean bl) {
        this.warn("setCrossingView");
    }

    public void setDayNightView(int n, boolean bl) {
    }

    @Override
    public void setMapType(int n, boolean bl) {
        this.warn("setMapType");
    }

    @Override
    public void setOrientation(int n, boolean bl) {
        this.warn("setOrientation");
    }

    @Override
    public void setPicNavIcons(boolean bl, boolean bl2, int n) {
        this.warn("setPicNavIcons");
    }

    @Override
    public void setWeatherIcons(boolean bl, boolean bl2, int n) {
        this.warn("setWeatherIcons");
    }

    @Override
    public void setSpeedAndFlowCongestions(boolean bl, boolean bl2, int n) {
        this.warn("setSpeedAndFlowCongestions");
    }

    @Override
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

    @Override
    public void setTopBusiness(boolean bl, boolean bl2, int n) {
        this.warn("setTopBusiness");
    }

    @Override
    public void setTopPrivate(boolean bl, boolean bl2, int n) {
        this.warn("setTopPrivate");
    }

    @Override
    public void setPoiVisible(int[] nArray, boolean[] blArray, boolean bl) {
        this.warn("setPoiVisible");
    }

    @Override
    public void setGoogle3DCityModel(int n, boolean bl) {
        this.warn("setGoogle3DCityModel");
    }
}

