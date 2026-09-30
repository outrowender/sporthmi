/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.map.context;

import de.audi.atip.base.IFrameworkAccess;
import de.audi.atip.log.LogChannel;
import de.audi.atip.storage.IStorageAccess;
import de.audi.tghu.navi.app.PersistentState;
import de.audi.tghu.navi.app.util.Util;
import de.esolutions.fw.util.commons.Buffer;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class State
extends PersistentState {
    public static final int VERSION = 10;
    public static final int MAP_STYLES = 3;
    public static final int MAP_STYLE_STANDARD = 0;
    public static final int MAP_STYLE_GOOGLE = 1;
    public static final int MAP_STYLE_TRAFFIC = 2;
    private final StateData data;

    public State(IStorageAccess iStorageAccess, LogChannel logChannel, IFrameworkAccess iFrameworkAccess, int n) {
        super(iStorageAccess, 10, 1004, n, logChannel);
        switch (n) {
            case 950: {
                this.data = new StateDataMapKombi(iFrameworkAccess);
                break;
            }
            default: {
                this.data = new StateDataMapMain(iFrameworkAccess);
            }
        }
    }

    public final StateData getData() {
        return this.data;
    }

    protected void initWithDefaultValues() {
        this.data.init();
        this.getLogChannel().log(10000000, "Context.State#initWithDefaultValue() - %1", (Object)this.data.toString());
    }

    protected void initFromOldKeys(IStorageAccess iStorageAccess) {
        this.getLogChannel().log(10000000, "Context.State#initFromOldKeys()");
        this.data.initFromOldKeys(iStorageAccess);
    }

    protected void serialize(DataOutputStream dataOutputStream) throws IOException {
        int n;
        this.getLogChannel().log(100000000, "Context.State#serialize() - %1", (Object)this.data.toString());
        dataOutputStream.writeInt(this.data.dayNightView);
        dataOutputStream.writeInt(this.data.orientation);
        dataOutputStream.writeInt(this.data.mapType);
        dataOutputStream.writeInt(this.data.autoZoom);
        dataOutputStream.writeInt(this.data.additionalInfos);
        dataOutputStream.writeInt(this.data.crossingView);
        dataOutputStream.writeInt(this.data.splitScreenMode);
        dataOutputStream.writeInt(this.data.splitScreen);
        dataOutputStream.writeBoolean(this.data.mapContentState[0].tmcSymbols);
        dataOutputStream.writeBoolean(this.data.mapContentState[0].show3DLandmarks);
        dataOutputStream.writeInt(this.data.mapContentState[0].show3DBuildings);
        dataOutputStream.writeBoolean(this.data.mapContentState[0].favorites);
        dataOutputStream.writeBoolean(this.data.mapContentState[0].topPrivate);
        dataOutputStream.writeInt(this.data.mapContentState[0].brandedPois);
        dataOutputStream.writeBoolean(this.data.mapContentState[0].speedAndFlowFreeflow);
        dataOutputStream.writeBoolean(this.data.mapContentState[0].speedAndFlowCongestions);
        dataOutputStream.writeBoolean(this.data.mapContentState[0].picNavIcons);
        dataOutputStream.writeInt(this.data.mapRepresentation);
        dataOutputStream.writeInt(this.data.zoomLevelIndex);
        this.serializeIntArray(this.data.systemLayers, dataOutputStream);
        dataOutputStream.writeInt(this.data.mapContentState.length);
        for (n = 1; n < this.data.mapContentState.length; ++n) {
            dataOutputStream.writeBoolean(this.data.mapContentState[n].tmcSymbols);
            dataOutputStream.writeBoolean(this.data.mapContentState[n].show3DLandmarks);
            dataOutputStream.writeInt(this.data.mapContentState[n].show3DBuildings);
            dataOutputStream.writeBoolean(this.data.mapContentState[n].favorites);
            dataOutputStream.writeBoolean(this.data.mapContentState[n].topPrivate);
            dataOutputStream.writeInt(this.data.mapContentState[n].brandedPois);
            dataOutputStream.writeBoolean(this.data.mapContentState[n].speedAndFlowFreeflow);
            dataOutputStream.writeBoolean(this.data.mapContentState[n].speedAndFlowCongestions);
            dataOutputStream.writeBoolean(this.data.mapContentState[n].picNavIcons);
        }
        dataOutputStream.writeBoolean(this.data.panorama);
        for (n = 0; n < this.data.mapContentState.length; ++n) {
            dataOutputStream.writeBoolean(this.data.mapContentState[n].weatherIcons);
        }
        for (n = 0; n < this.data.mapContentState.length; ++n) {
            dataOutputStream.writeBoolean(this.data.mapContentState[n].range);
        }
        dataOutputStream.writeInt(this.data.google3DCityModel);
        this.serializeIntArray(this.data.systemLayersAvailable, dataOutputStream);
        dataOutputStream.writeInt(this.data.trafficFlow);
        dataOutputStream.writeBoolean(this.data.trafficEventNoticeMap);
        dataOutputStream.writeBoolean(this.data.uncrowdedRoad);
        dataOutputStream.writeBoolean(this.data.trafficMiniMap);
    }

    protected void deserialize(DataInputStream dataInputStream) throws IOException {
        int n;
        this.data.dayNightView = dataInputStream.readInt();
        this.data.orientation = dataInputStream.readInt();
        this.data.mapType = dataInputStream.readInt();
        this.data.autoZoom = dataInputStream.readInt();
        this.data.additionalInfos = dataInputStream.readInt();
        this.data.crossingView = dataInputStream.readInt();
        this.data.splitScreenMode = dataInputStream.readInt();
        this.data.splitScreen = dataInputStream.readInt();
        this.data.mapContentState[0] = new MapContentState();
        this.data.mapContentState[0].tmcSymbols = dataInputStream.readBoolean();
        this.data.mapContentState[0].show3DLandmarks = dataInputStream.readBoolean();
        this.data.mapContentState[0].show3DBuildings = dataInputStream.readInt();
        this.data.mapContentState[0].favorites = dataInputStream.readBoolean();
        this.data.mapContentState[0].topPrivate = dataInputStream.readBoolean();
        this.data.mapContentState[0].brandedPois = dataInputStream.readInt();
        this.data.mapContentState[0].speedAndFlowFreeflow = dataInputStream.readBoolean();
        this.data.mapContentState[0].speedAndFlowCongestions = dataInputStream.readBoolean();
        this.data.mapContentState[0].picNavIcons = dataInputStream.readBoolean();
        this.data.mapRepresentation = dataInputStream.readInt();
        this.data.zoomLevelIndex = dataInputStream.readInt();
        this.data.systemLayers = this.deserializeIntArray(dataInputStream);
        int n2 = dataInputStream.readInt();
        for (n = 1; n < n2; ++n) {
            if (n >= this.data.mapContentState.length) continue;
            this.data.mapContentState[n] = new MapContentState();
            this.data.mapContentState[n].tmcSymbols = dataInputStream.readBoolean();
            this.data.mapContentState[n].show3DLandmarks = dataInputStream.readBoolean();
            this.data.mapContentState[n].show3DBuildings = dataInputStream.readInt();
            this.data.mapContentState[n].favorites = dataInputStream.readBoolean();
            this.data.mapContentState[n].topPrivate = dataInputStream.readBoolean();
            this.data.mapContentState[n].brandedPois = dataInputStream.readInt();
            this.data.mapContentState[n].speedAndFlowFreeflow = dataInputStream.readBoolean();
            this.data.mapContentState[n].speedAndFlowCongestions = dataInputStream.readBoolean();
            this.data.mapContentState[n].picNavIcons = dataInputStream.readBoolean();
        }
        this.data.panorama = dataInputStream.readBoolean();
        for (n = 0; n < n2; ++n) {
            if (n >= this.data.mapContentState.length) continue;
            this.data.mapContentState[n].weatherIcons = dataInputStream.readBoolean();
        }
        for (n = 0; n < n2; ++n) {
            if (n >= this.data.mapContentState.length) continue;
            this.data.mapContentState[n].range = dataInputStream.readBoolean();
        }
        this.data.google3DCityModel = dataInputStream.readInt();
        this.data.systemLayersAvailable = this.deserializeIntArray(dataInputStream);
        this.data.trafficFlow = dataInputStream.readInt();
        this.data.trafficEventNoticeMap = dataInputStream.readBoolean();
        this.data.uncrowdedRoad = dataInputStream.readBoolean();
        this.data.trafficMiniMap = dataInputStream.readBoolean();
        this.getLogChannel().log(10000000, "Context.State#deserialize() - %1", (Object)this.data.toString());
    }

    protected void convertContainer(int n, int n2, DataInputStream dataInputStream) {
        this.getLogChannel().log(10000000, "Context.State#convertContainer( %1, %2 )", (long)n, (long)n2);
        this.initWithDefaultValues();
        int n3 = 0;
        try {
            int n4;
            if (n > 0) {
                this.data.dayNightView = dataInputStream.readInt();
                this.data.orientation = dataInputStream.readInt();
                this.data.mapType = dataInputStream.readInt();
                this.data.autoZoom = dataInputStream.readInt();
                this.data.additionalInfos = dataInputStream.readInt();
                this.data.crossingView = dataInputStream.readInt();
                this.data.splitScreenMode = dataInputStream.readInt();
                this.data.splitScreen = dataInputStream.readInt();
                this.data.mapContentState[0] = new MapContentState();
                this.data.mapContentState[0].tmcSymbols = dataInputStream.readBoolean();
                this.data.mapContentState[0].show3DLandmarks = dataInputStream.readBoolean();
                this.data.mapContentState[0].show3DBuildings = dataInputStream.readInt();
                this.data.mapContentState[0].favorites = dataInputStream.readBoolean();
                this.data.mapContentState[0].topPrivate = dataInputStream.readBoolean();
                this.data.mapContentState[0].brandedPois = dataInputStream.readInt();
                this.data.mapContentState[0].speedAndFlowFreeflow = dataInputStream.readBoolean();
                this.data.mapContentState[0].speedAndFlowCongestions = dataInputStream.readBoolean();
                this.data.mapContentState[0].picNavIcons = dataInputStream.readBoolean();
                this.data.mapRepresentation = dataInputStream.readInt();
                this.data.zoomLevelIndex = dataInputStream.readInt();
                this.data.systemLayers = this.deserializeIntArray(dataInputStream);
            }
            if (n > 1) {
                n3 = dataInputStream.readInt();
                for (n4 = 1; n4 < n3; ++n4) {
                    if (n4 >= this.data.mapContentState.length) continue;
                    this.data.mapContentState[n4] = new MapContentState();
                    this.data.mapContentState[n4].tmcSymbols = dataInputStream.readBoolean();
                    this.data.mapContentState[n4].show3DLandmarks = dataInputStream.readBoolean();
                    this.data.mapContentState[n4].show3DBuildings = dataInputStream.readInt();
                    this.data.mapContentState[n4].favorites = dataInputStream.readBoolean();
                    this.data.mapContentState[n4].topPrivate = dataInputStream.readBoolean();
                    this.data.mapContentState[n4].brandedPois = dataInputStream.readInt();
                    this.data.mapContentState[n4].speedAndFlowFreeflow = dataInputStream.readBoolean();
                    this.data.mapContentState[n4].speedAndFlowCongestions = dataInputStream.readBoolean();
                    this.data.mapContentState[n4].picNavIcons = dataInputStream.readBoolean();
                }
            }
            if (n > 3) {
                this.data.panorama = dataInputStream.readBoolean();
            }
            if (n > 4) {
                for (n4 = 0; n4 < n3; ++n4) {
                    if (n4 >= this.data.mapContentState.length) continue;
                    this.data.mapContentState[n4].weatherIcons = dataInputStream.readBoolean();
                }
            }
            if (n > 5) {
                for (n4 = 0; n4 < n3; ++n4) {
                    if (n4 >= this.data.mapContentState.length) continue;
                    this.data.mapContentState[n4].range = dataInputStream.readBoolean();
                }
            }
            if (n > 6) {
                this.data.google3DCityModel = dataInputStream.readInt();
            }
            if (n > 7) {
                this.data.systemLayersAvailable = this.deserializeIntArray(dataInputStream);
            }
            if (n > 8) {
                this.data.trafficFlow = dataInputStream.readInt();
                this.data.trafficEventNoticeMap = dataInputStream.readBoolean();
                this.data.uncrowdedRoad = dataInputStream.readBoolean();
            }
            if (n > 9) {
                this.data.trafficMiniMap = dataInputStream.readBoolean();
            }
            this.getLogChannel().log(10000000, "Context.State#convertContainer() - %1", (Object)this.data.toString());
        }
        catch (IOException iOException) {
            this.getLogChannel().log(10000, "Context.State#convertContainer - error on converting the persistent state format", (Throwable)iOException);
        }
    }

    public void setDayNightView(int n) {
        this.data.dayNightView = n;
    }

    public void setOrientation(int n) {
        this.data.orientation = n;
    }

    public void setMapType(int n) {
        this.data.mapType = n;
    }

    public void setAutoZoom(int n) {
        this.data.autoZoom = n;
    }

    public void setAdditionalInfos(int n) {
        this.data.additionalInfos = n;
    }

    public void setCrossingView(int n) {
        this.data.crossingView = n;
    }

    public void setPanorama(boolean bl) {
        this.data.panorama = bl;
    }

    public void setSplitScreenMode(int n) {
        this.data.splitScreenMode = n;
    }

    public void setSplitScreen(int n) {
        this.data.splitScreen = n;
    }

    public void setTmcSymbols(boolean bl, int n) {
        this.data.mapContentState[n].tmcSymbols = bl;
    }

    public void setShow3DLandmarks(boolean bl, int n) {
        this.data.mapContentState[n].show3DLandmarks = bl;
    }

    public void setShow3DBuildings(int n, int n2) {
        this.data.mapContentState[n2].show3DBuildings = n;
    }

    public void setFavorites(boolean bl, int n) {
        this.data.mapContentState[n].favorites = bl;
    }

    public void setTopPrivate(boolean bl, int n) {
        this.data.mapContentState[n].topPrivate = bl;
    }

    public void setRange(boolean bl, int n) {
        this.data.mapContentState[n].range = bl;
    }

    public void setBrandedPois(int n, int n2) {
        this.data.mapContentState[n2].brandedPois = n;
    }

    public void setSpeedAndFlowFreeflow(boolean bl, int n) {
        this.data.mapContentState[n].speedAndFlowFreeflow = bl;
    }

    public void setSpeedAndFlowCongestions(boolean bl, int n) {
        this.data.mapContentState[n].speedAndFlowCongestions = bl;
    }

    public void setPicNavIcons(boolean bl, int n) {
        this.data.mapContentState[n].picNavIcons = bl;
    }

    public void setWeatherIcons(boolean bl, int n) {
        this.data.mapContentState[n].weatherIcons = bl;
    }

    public void setMapRepresentation(int n) {
        this.data.mapRepresentation = n;
    }

    public void setZoomLevelIndex(int n) {
        this.data.zoomLevelIndex = n;
    }

    public void setSystemLayers(int[] nArray) {
        this.data.systemLayers = nArray;
    }

    public void setSystemLayersAvailable(int[] nArray) {
        this.data.systemLayersAvailable = nArray;
    }

    public void setGoogle3DCityModel(int n) {
        this.data.google3DCityModel = n;
    }

    public void setTrafficFlow(int n) {
        this.data.trafficFlow = n;
    }

    public void setTrafficEventNoticeMap(boolean bl) {
        this.data.trafficEventNoticeMap = bl;
    }

    public void setTrafficMiniMap(boolean bl) {
        this.data.trafficMiniMap = bl;
    }

    public void setUncrowedRoad(boolean bl) {
        this.data.uncrowdedRoad = bl;
    }

    public static abstract class StateData {
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
        MapContentState[] mapContentState;
        int mapRepresentation;
        int zoomLevelIndex;
        int[] systemLayers;
        int google3DCityModel;
        int trafficFlow;
        boolean trafficEventNoticeMap;
        boolean uncrowdedRoad;
        boolean trafficMiniMap;
        int[] systemLayersAvailable;
        public static final int INVALID_ZOOM_LEVEL_INDEX = -1;
        public static final int DEFAULT_SYSTEM_LAYER_ID = -1;
        public static final int[] DEFAULT_SYSTEM_LAYERS = new int[]{-1, -1};
        public static final int[] DEFAULT_SYSTEM_LAYERS_AVAILABLE = new int[0];

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

        public StateData(IFrameworkAccess iFrameworkAccess) {
            this.framework = iFrameworkAccess;
            this.mapContentState = new MapContentState[3];
            for (int i2 = 0; i2 < this.mapContentState.length; ++i2) {
                this.mapContentState[i2] = new MapContentState();
            }
            this.init();
        }

        abstract void init();

        final void initCommon() {
            this.dayNightView = StateData.getDefaultDayNightView();
            this.orientation = StateData.getDefaultOrientation();
            this.mapType = StateData.getDefaultMapType();
            this.autoZoom = StateData.getDefaultAutoZoom();
            this.additionalInfos = StateData.getDefaultAdditionalInfos(this.framework);
            this.crossingView = StateData.getDefaultCrossingView(this.framework);
            this.splitScreenMode = StateData.getDefaultSplitScreenMode();
            this.splitScreen = StateData.getDefaultSplitScreen();
            for (int i2 = 0; i2 < this.mapContentState.length; ++i2) {
                this.mapContentState[i2] = new MapContentState();
                this.mapContentState[i2].tmcSymbols = StateData.getDefaultTmcSymbols(this.framework);
                this.mapContentState[i2].show3DLandmarks = StateData.getDefaultShow3DLandmarks(this.framework);
                this.mapContentState[i2].show3DBuildings = StateData.getDefault3DBuildings(this.framework);
                this.mapContentState[i2].favorites = StateData.getDefaultFavorites();
                this.mapContentState[i2].topPrivate = StateData.getDefaultTopPrivate();
                this.mapContentState[i2].range = StateData.getDefaultRange();
                this.mapContentState[i2].brandedPois = StateData.getDefaultBrandedPois();
                this.mapContentState[i2].speedAndFlowFreeflow = StateData.getDefaultSpeedAndFlowFreeflow(this.framework);
                this.mapContentState[i2].speedAndFlowCongestions = StateData.getDefaultSpeedAndFlowCongestions(this.framework);
                this.mapContentState[i2].picNavIcons = StateData.getDefaultPicNavIcons(this.framework);
                this.mapContentState[i2].weatherIcons = StateData.getDefaultWeatherIcons(this.framework);
            }
            this.mapRepresentation = StateData.getDefaultMapRepresentation();
            this.zoomLevelIndex = StateData.getDefaultZoomLevelIndex();
            this.systemLayers = StateData.getDefaultSystemLayers();
            this.systemLayersAvailable = StateData.getDefaultSystemLayersAvailable();
            this.google3DCityModel = StateData.getDefaultGoogle3DCityModel();
            this.trafficFlow = StateData.getDefaultTrafficFlow(this.framework);
            this.trafficEventNoticeMap = StateData.getDefaultTrafficEventNoticeMap(this.framework);
            this.uncrowdedRoad = StateData.getDefaultUncrowdedRoad();
            this.trafficMiniMap = StateData.getDefaultTrafficMiniMap();
        }

        abstract void initFromOldKeys(IStorageAccess var1);

        final void initFromOldKeysCommon(IStorageAccess iStorageAccess) {
            this.dayNightView = iStorageAccess.getInt(1004, 200, 2);
            this.orientation = iStorageAccess.getInt(1004, 240, 1);
            this.mapType = iStorageAccess.getInt(1004, 220, 2);
            this.autoZoom = iStorageAccess.getInt(1004, 210, 2);
            this.additionalInfos = iStorageAccess.getInt(1004, 250, StateData.getDefaultAdditionalInfos(this.framework));
            this.crossingView = iStorageAccess.getInt(1004, 440, StateData.getDefaultCrossingView(this.framework));
            this.splitScreenMode = iStorageAccess.getInt(1004, 250, 0);
            this.splitScreen = iStorageAccess.getInt(1004, 420, 0);
            for (int i2 = 0; i2 < this.mapContentState.length; ++i2) {
                this.mapContentState[i2] = new MapContentState();
                this.mapContentState[i2].tmcSymbols = iStorageAccess.getBoolean(1004, 260, true);
                this.mapContentState[i2].show3DLandmarks = iStorageAccess.getBoolean(1004, 270, true);
                this.mapContentState[i2].show3DBuildings = iStorageAccess.getInt(1004, 330, StateData.getDefault3DBuildings(this.framework));
                this.mapContentState[i2].favorites = iStorageAccess.getBoolean(1004, 280, StateData.getDefaultFavorites());
                this.mapContentState[i2].topPrivate = iStorageAccess.getBoolean(1004, 320, StateData.getDefaultTopPrivate());
                this.mapContentState[i2].brandedPois = iStorageAccess.getInt(1004, 430, 0);
                this.mapContentState[i2].speedAndFlowFreeflow = iStorageAccess.getBoolean(1004, 450, true);
                this.mapContentState[i2].speedAndFlowCongestions = iStorageAccess.getBoolean(1004, 460, true);
                this.mapContentState[i2].picNavIcons = iStorageAccess.getBoolean(1004, 470, true);
                this.mapContentState[i2].weatherIcons = true;
                this.mapContentState[i2].range = StateData.getDefaultRange();
            }
            this.mapRepresentation = iStorageAccess.getInt(1004, 380, 0);
            this.zoomLevelIndex = iStorageAccess.getInt(1004, 600, -1);
            this.systemLayers = iStorageAccess.getIntArray(1004, 410, DEFAULT_SYSTEM_LAYERS);
            this.systemLayersAvailable = StateData.getDefaultSystemLayersAvailable();
            this.google3DCityModel = StateData.getDefaultGoogle3DCityModel();
            this.trafficFlow = StateData.getDefaultTrafficFlow(this.framework);
            this.trafficEventNoticeMap = StateData.getDefaultTrafficEventNoticeMap(this.framework);
            this.uncrowdedRoad = StateData.getDefaultUncrowdedRoad();
            this.trafficMiniMap = StateData.getDefaultTrafficMiniMap();
        }

        public static int getDefaultAdditionalInfos(IFrameworkAccess iFrameworkAccess) {
            if (Util.isHURegionAsia()) {
                return 0;
            }
            return StateData.isClusterMMI(iFrameworkAccess) ? 3 : 0;
        }

        public static boolean isClusterMMI(IFrameworkAccess iFrameworkAccess) {
            return iFrameworkAccess.getScreenRes() == 4;
        }

        public static boolean isClusterRGI(IFrameworkAccess iFrameworkAccess) {
            return !StateData.isClusterMMI(iFrameworkAccess) && iFrameworkAccess.getSysConst(541) == 0;
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
            return Util.isUncrowdedRoadsCheckboxAvailable(iFrameworkAccess) ? StateData.getDefaultUncrowdedRoad() : Util.isSpeedAndFlowAvailable(iFrameworkAccess);
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
            return StateData.isClusterRGI(iFrameworkAccess) ? 0 : 1;
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
    }

    private static class MapContentState {
        public boolean tmcSymbols;
        public boolean show3DLandmarks;
        public int show3DBuildings;
        public boolean favorites;
        public boolean topPrivate;
        public boolean range;
        public int brandedPois;
        public boolean speedAndFlowFreeflow;
        public boolean speedAndFlowCongestions;
        public boolean picNavIcons;
        public boolean weatherIcons;

        private MapContentState() {
        }
    }

    public static class StateDataMapMain
    extends StateData {
        public StateDataMapMain(IFrameworkAccess iFrameworkAccess) {
            super(iFrameworkAccess);
        }

        final void init() {
            this.panorama = true;
            this.initCommon();
        }

        final void initFromOldKeys(IStorageAccess iStorageAccess) {
            this.panorama = true;
            this.initFromOldKeysCommon(iStorageAccess);
        }
    }

    public static class StateDataMapKombi
    extends StateData {
        public StateDataMapKombi(IFrameworkAccess iFrameworkAccess) {
            super(iFrameworkAccess);
        }

        final void init() {
            this.panorama = false;
            this.initCommon();
        }

        final void initFromOldKeys(IStorageAccess iStorageAccess) {
            this.panorama = false;
            this.initFromOldKeysCommon(iStorageAccess);
        }
    }
}

