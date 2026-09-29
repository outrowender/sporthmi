/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.map.context;

import de.audi.atip.base.IFrameworkAccess;
import de.audi.atip.log.LogChannel;
import de.audi.atip.storage.IStorageAccess;
import de.audi.tghu.navi.app.PersistentState;
import de.audi.tghu.navi.app.map.context.State$MapContentState;
import de.audi.tghu.navi.app.map.context.State$StateData;
import de.audi.tghu.navi.app.map.context.State$StateDataMapKombi;
import de.audi.tghu.navi.app.map.context.State$StateDataMapMain;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class State
extends PersistentState {
    public static final int VERSION;
    public static final int MAP_STYLES;
    public static final int MAP_STYLE_STANDARD;
    public static final int MAP_STYLE_GOOGLE;
    public static final int MAP_STYLE_TRAFFIC;
    private final State$StateData data;

    public State(IStorageAccess iStorageAccess, LogChannel logChannel, IFrameworkAccess iFrameworkAccess, int n) {
        super(iStorageAccess, 10, 1004, n, logChannel);
        switch (n) {
            case 950: {
                this.data = new State$StateDataMapKombi(iFrameworkAccess);
                break;
            }
            default: {
                this.data = new State$StateDataMapMain(iFrameworkAccess);
            }
        }
    }

    public final State$StateData getData() {
        return this.data;
    }

    @Override
    protected void initWithDefaultValues() {
        this.data.init();
        this.getLogChannel().log(-2137614336, "Context.State#initWithDefaultValue() - %1", (Object)this.data.toString());
    }

    @Override
    protected void initFromOldKeys(IStorageAccess iStorageAccess) {
        this.getLogChannel().log(-2137614336, "Context.State#initFromOldKeys()");
        this.data.initFromOldKeys(iStorageAccess);
    }

    @Override
    protected void serialize(DataOutputStream dataOutputStream) {
        int n;
        this.getLogChannel().log(14808325, "Context.State#serialize() - %1", (Object)this.data.toString());
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

    @Override
    protected void deserialize(DataInputStream dataInputStream) {
        int n;
        this.data.dayNightView = dataInputStream.readInt();
        this.data.orientation = dataInputStream.readInt();
        this.data.mapType = dataInputStream.readInt();
        this.data.autoZoom = dataInputStream.readInt();
        this.data.additionalInfos = dataInputStream.readInt();
        this.data.crossingView = dataInputStream.readInt();
        this.data.splitScreenMode = dataInputStream.readInt();
        this.data.splitScreen = dataInputStream.readInt();
        this.data.mapContentState[0] = new State$MapContentState(null);
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
            this.data.mapContentState[n] = new State$MapContentState(null);
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
        this.getLogChannel().log(-2137614336, "Context.State#deserialize() - %1", (Object)this.data.toString());
    }

    @Override
    protected void convertContainer(int n, int n2, DataInputStream dataInputStream) {
        this.getLogChannel().log(-2137614336, "Context.State#convertContainer( %1, %2 )", (long)n, (long)n2);
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
                this.data.mapContentState[0] = new State$MapContentState(null);
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
                    this.data.mapContentState[n4] = new State$MapContentState(null);
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
            this.getLogChannel().log(-2137614336, "Context.State#convertContainer() - %1", (Object)this.data.toString());
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
}

