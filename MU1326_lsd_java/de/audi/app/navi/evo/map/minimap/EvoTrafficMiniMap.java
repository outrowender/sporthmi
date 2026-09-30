/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.navi.evo.map.minimap;

import de.audi.app.navi.evo.map.minimap.EvoTrafficMiniMapView;
import de.audi.atip.base.IFrameworkAccess;
import de.audi.atip.log.LogChannel;
import de.audi.atip.storage.IStorageAccess;
import de.audi.tghu.navi.app.PersistentState;
import de.audi.tghu.navi.app.audio.INaviAudioHandler;
import de.audi.tghu.navi.app.map.handler.ICruiseModeHandler;
import de.audi.tghu.navi.app.map.minimap.AbstractTrafficMiniMap;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class EvoTrafficMiniMap
extends AbstractTrafficMiniMap {
    public EvoTrafficMiniMap(LogChannel logChannel, IFrameworkAccess iFrameworkAccess, ICruiseModeHandler iCruiseModeHandler, INaviAudioHandler iNaviAudioHandler) {
        super(logChannel, iFrameworkAccess, iCruiseModeHandler);
        this.view = new EvoTrafficMiniMapView(this, iFrameworkAccess, iNaviAudioHandler, logChannel);
    }

    public EvoTrafficMiniMapView getView() {
        return (EvoTrafficMiniMapView)this.view;
    }

    public void persistSettings() {
        IStorageAccess iStorageAccess = this.framework.getStorageMgr();
        if (iStorageAccess != null) {
            this.logChannel.log(10000000, "EvoTrafficMiniMap#persistSettings isActive = %1", this.isActive());
            TrafficMiniMapState trafficMiniMapState = new TrafficMiniMapState(iStorageAccess, this.logChannel);
            trafficMiniMapState.setActive(this.isActive());
            trafficMiniMapState.serializeAndWrite();
        }
    }

    public void loadState() {
        IStorageAccess iStorageAccess = this.framework.getStorageMgr();
        if (iStorageAccess != null) {
            TrafficMiniMapState trafficMiniMapState = new TrafficMiniMapState(iStorageAccess, this.logChannel);
            trafficMiniMapState.readAndDeserialize();
            this.logChannel.log(10000000, "EvoTrafficMiniMap#loadState isActive = %1", trafficMiniMapState.isActive());
            this.setActive(trafficMiniMapState.isActive());
        }
    }

    public void resetSettings() {
        this.setActive(false);
    }

    public void cleanup() {
        super.cleanup();
        ((EvoTrafficMiniMapView)this.view).cleanup();
    }

    public static class TrafficMiniMapState
    extends PersistentState {
        public static final int VERSION = 1;
        public static final int KEY = 1041;
        private boolean active;

        public TrafficMiniMapState(IStorageAccess iStorageAccess, LogChannel logChannel) {
            super(iStorageAccess, 1, 1004, 1041, logChannel);
        }

        protected void initWithDefaultValues() {
            this.active = false;
        }

        protected void initFromOldKeys(IStorageAccess iStorageAccess) {
            this.active = iStorageAccess.getBoolean(1004, 1041, false);
        }

        protected void convertContainer(int n, int n2, DataInputStream dataInputStream) throws IOException {
            this.initWithDefaultValues();
            try {
                if (n > 0) {
                    this.deserialize(dataInputStream);
                }
            }
            catch (IOException iOException) {
                this.getLogChannel().log(10000, "TrafficMiniMapState#convertContainer - error on converting the persistent state format", (Throwable)iOException);
            }
        }

        protected void serialize(DataOutputStream dataOutputStream) throws IOException {
            dataOutputStream.writeBoolean(this.active);
        }

        protected void deserialize(DataInputStream dataInputStream) throws IOException {
            this.active = dataInputStream.readBoolean();
        }

        public boolean isActive() {
            return this.active;
        }

        public void setActive(boolean bl) {
            this.active = bl;
        }
    }
}

