/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.map.handler;

import de.audi.atip.hmi.model.ChoiceListener;
import de.audi.tghu.navi.app.map.AbstractMap;
import de.audi.tghu.navi.app.map.context.State$StateData;

public interface ISetupHandler
extends ChoiceListener {
    public static final float DEFAULT_ZOOM_LEVEL;

    default public void saveState() {
    }

    default public void initFromStateData(State$StateData state$StateData, boolean bl) {
    }

    default public boolean isInitializationPhasefinished() {
    }

    default public void setOption(int n, int n2, boolean bl) {
    }

    default public void setOption(int n, boolean bl, boolean bl2) {
    }

    default public void setMapTypeAndOrientation(int n) {
    }

    default public void setPanorama(boolean bl, boolean bl2) {
    }

    default public void setOrientation(int n, boolean bl) {
    }

    default public void setMapType(int n, boolean bl) {
    }

    default public void setAutoZoom(int n, boolean bl) {
    }

    default public void setAdditionalInfos(int n, boolean bl) {
    }

    default public void setCrossingView(int n, boolean bl) {
    }

    default public void setTopBusiness(boolean bl, boolean bl2, int n) {
    }

    default public void setTopPrivate(boolean bl, boolean bl2, int n) {
    }

    default public void setBrandedPOIs(int n, boolean bl, int n2) {
    }

    default public void setSpeedAndFlowFreeflow(boolean bl, boolean bl2, int n) {
    }

    default public void setSpeedAndFlowCongestions(boolean bl, boolean bl2, int n) {
    }

    default public void setPicNavIcons(boolean bl, boolean bl2, int n) {
    }

    default public void setWeatherIcons(boolean bl, boolean bl2, int n) {
    }

    default public void setRange(boolean bl, boolean bl2, int n) {
    }

    default public void setSavedZoomListIndex(int n, boolean bl) {
    }

    default public void setMapRepresentation(int n, boolean bl) {
    }

    default public void setPoiVisible(int[] nArray, boolean[] blArray, boolean bl) {
    }

    default public void setFavorites(boolean bl, boolean bl2, int n) {
    }

    default public void setGoogle3DCityModel(int n, boolean bl) {
    }

    default public int getDayNightView() {
    }

    default public int getOrientation() {
    }

    default public int getMapType(boolean bl) {
    }

    default public int getMapType() {
    }

    default public int getAutoZoom() {
    }

    default public int getAutoZoom(boolean bl) {
    }

    default public int getAdditionalInfos() {
    }

    default public int getCrossingView() {
    }

    default public boolean getTMCSymbols(int n) {
    }

    default public boolean get3DLandmarks(int n) {
    }

    default public int get3DBuildings(int n) {
    }

    default public boolean getTopBusiness(int n) {
    }

    default public boolean getTopPrivate(int n) {
    }

    default public int getBrandedPOIs(int n) {
    }

    default public boolean getSpeedAndFlowFreeflow(int n) {
    }

    default public boolean getSpeedAndFlowCongestions(int n) {
    }

    default public boolean getPicNavIcons(int n) {
    }

    default public boolean isWeatherIconVisible(int n) {
    }

    default public boolean getRange(int n) {
    }

    default public int getSavedZoomListIndex() {
    }

    default public int getMapRepresentation() {
    }

    default public int getBackupMapRepresentation() {
    }

    default public int[] getPoiVisibleUid() {
    }

    default public boolean[] getPoiVisibleStatus() {
    }

    default public boolean isCrossingViewEnabled() {
    }

    default public boolean isMapInMapEnabled() {
    }

    default public boolean isRouteInfoEnabled() {
    }

    default public boolean isPanorama() {
    }

    default public boolean isFavoriteVisible(int n) {
    }

    default public int getGoogle3DCityModel() {
    }

    default public void forceHiddenContextRefresh(boolean bl) {
    }

    default public int[] getPoiVisibility() {
    }

    default public void resetSettings() {
    }

    default public void bind(AbstractMap abstractMap) {
    }

    default public int getProperty(int n) {
    }

    default public void setProperty(int n, int n2) {
    }

    default public boolean isManeuverZoomDependendOnAutoZoom() {
    }

    default public int getEtaMode() {
    }

    default public int getSpeedAndFlow() {
    }

    default public int getLayerPOI() {
    }

    default public int getRangeMapVisibilitySetting() {
    }

    default public int getIntersectionZoom() {
    }

    default public int getOnlineTraffic() {
    }

    default public boolean getGeneralPoiVisibility() {
    }

    default public void setEtaMode(int n, boolean bl) {
    }

    default public void setLayerPOI(int n, boolean bl) {
    }

    default public void setRangeMapVisibilitySetting(int n, boolean bl) {
    }

    default public void setSpeedAndFlow(int n, boolean bl) {
    }

    default public void setIntersectionZoom(int n, boolean bl) {
    }

    default public void setOnlineTraffic(int n, boolean bl) {
    }
}

