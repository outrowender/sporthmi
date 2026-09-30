/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.map.handler;

import de.audi.atip.hmi.model.ChoiceListener;
import de.audi.tghu.navi.app.map.AbstractMap;
import de.audi.tghu.navi.app.map.context.State;

public interface ISetupHandler
extends ChoiceListener {
    public static final float DEFAULT_ZOOM_LEVEL = 400.0f;

    public void saveState();

    public void initFromStateData(State.StateData var1, boolean var2);

    public boolean isInitializationPhasefinished();

    public void setOption(int var1, int var2, boolean var3);

    public void setOption(int var1, boolean var2, boolean var3);

    public void setMapTypeAndOrientation(int var1);

    public void setPanorama(boolean var1, boolean var2);

    public void setOrientation(int var1, boolean var2);

    public void setMapType(int var1, boolean var2);

    public void setAutoZoom(int var1, boolean var2);

    public void setAdditionalInfos(int var1, boolean var2);

    public void setCrossingView(int var1, boolean var2);

    public void setTopBusiness(boolean var1, boolean var2, int var3);

    public void setTopPrivate(boolean var1, boolean var2, int var3);

    public void setBrandedPOIs(int var1, boolean var2, int var3);

    public void setSpeedAndFlowFreeflow(boolean var1, boolean var2, int var3);

    public void setSpeedAndFlowCongestions(boolean var1, boolean var2, int var3);

    public void setPicNavIcons(boolean var1, boolean var2, int var3);

    public void setWeatherIcons(boolean var1, boolean var2, int var3);

    public void setRange(boolean var1, boolean var2, int var3);

    public void setSavedZoomListIndex(int var1, boolean var2);

    public void setMapRepresentation(int var1, boolean var2);

    public void setPoiVisible(int[] var1, boolean[] var2, boolean var3);

    public void setFavorites(boolean var1, boolean var2, int var3);

    public void setGoogle3DCityModel(int var1, boolean var2);

    public int getDayNightView();

    public int getOrientation();

    public int getMapType(boolean var1);

    public int getMapType();

    public int getAutoZoom();

    public int getAutoZoom(boolean var1);

    public int getAdditionalInfos();

    public int getCrossingView();

    public boolean getTMCSymbols(int var1);

    public boolean get3DLandmarks(int var1);

    public int get3DBuildings(int var1);

    public boolean getTopBusiness(int var1);

    public boolean getTopPrivate(int var1);

    public int getBrandedPOIs(int var1);

    public boolean getSpeedAndFlowFreeflow(int var1);

    public boolean getSpeedAndFlowCongestions(int var1);

    public boolean getPicNavIcons(int var1);

    public boolean isWeatherIconVisible(int var1);

    public boolean getRange(int var1);

    public int getSavedZoomListIndex();

    public int getMapRepresentation();

    public int getBackupMapRepresentation();

    public int[] getPoiVisibleUid();

    public boolean[] getPoiVisibleStatus();

    public boolean isCrossingViewEnabled();

    public boolean isMapInMapEnabled();

    public boolean isRouteInfoEnabled();

    public boolean isPanorama();

    public boolean isFavoriteVisible(int var1);

    public int getGoogle3DCityModel();

    public void forceHiddenContextRefresh(boolean var1);

    public int[] getPoiVisibility();

    public void resetSettings();

    public void bind(AbstractMap var1);

    public int getProperty(int var1);

    public void setProperty(int var1, int var2);

    public boolean isManeuverZoomDependendOnAutoZoom();

    public int getEtaMode();

    public int getSpeedAndFlow();

    public int getLayerPOI();

    public int getRangeMapVisibilitySetting();

    public int getIntersectionZoom();

    public int getOnlineTraffic();

    public boolean getGeneralPoiVisibility();

    public void setEtaMode(int var1, boolean var2);

    public void setLayerPOI(int var1, boolean var2);

    public void setRangeMapVisibilitySetting(int var1, boolean var2);

    public void setSpeedAndFlow(int var1, boolean var2);

    public void setIntersectionZoom(int var1, boolean var2);

    public void setOnlineTraffic(int var1, boolean var2);

    public static interface Property {
        public static final int ASIA_MAP_CONTENT_TRAFFIC_EVENT_ICONS = 0;
        public static final int ASIA_MAP_CONTENT_TRAFFIC_EVENT_NOTICE = 1;
        public static final int ASIA_MAP_CONTENT_UNCROWDED_ROAD = 2;
        public static final int ASIA_MAP_CONTENT_FAVORITES = 4;
        public static final int ASIA_MAP_CONTENT_TRAFFIC_FLOW = 5;
        public static final int ASIA_MAP_CONTENT_WEATHER_ICONS = 6;
    }
}

