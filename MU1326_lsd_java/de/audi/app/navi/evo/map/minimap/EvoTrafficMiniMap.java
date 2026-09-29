/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.navi.evo.map.minimap;

import de.audi.app.navi.evo.map.minimap.EvoTrafficMiniMap$TrafficMiniMapState;
import de.audi.app.navi.evo.map.minimap.EvoTrafficMiniMapView;
import de.audi.atip.base.IFrameworkAccess;
import de.audi.atip.log.LogChannel;
import de.audi.atip.storage.IStorageAccess;
import de.audi.tghu.navi.app.audio.INaviAudioHandler;
import de.audi.tghu.navi.app.map.handler.ICruiseModeHandler;
import de.audi.tghu.navi.app.map.minimap.AbstractTrafficMiniMap;

public class EvoTrafficMiniMap
extends AbstractTrafficMiniMap {
    public EvoTrafficMiniMap(LogChannel logChannel, IFrameworkAccess iFrameworkAccess, ICruiseModeHandler iCruiseModeHandler, INaviAudioHandler iNaviAudioHandler) {
        super(logChannel, iFrameworkAccess, iCruiseModeHandler);
        this.view = new EvoTrafficMiniMapView(this, iFrameworkAccess, iNaviAudioHandler, logChannel);
    }

    public EvoTrafficMiniMapView getView() {
        return (EvoTrafficMiniMapView)this.view;
    }

    @Override
    public void persistSettings() {
        IStorageAccess iStorageAccess = this.framework.getStorageMgr();
        if (iStorageAccess != null) {
            this.logChannel.log(-2137614336, "EvoTrafficMiniMap#persistSettings isActive = %1", this.isActive());
            EvoTrafficMiniMap$TrafficMiniMapState evoTrafficMiniMap$TrafficMiniMapState = new EvoTrafficMiniMap$TrafficMiniMapState(iStorageAccess, this.logChannel);
            evoTrafficMiniMap$TrafficMiniMapState.setActive(this.isActive());
            evoTrafficMiniMap$TrafficMiniMapState.serializeAndWrite();
        }
    }

    @Override
    public void loadState() {
        IStorageAccess iStorageAccess = this.framework.getStorageMgr();
        if (iStorageAccess != null) {
            EvoTrafficMiniMap$TrafficMiniMapState evoTrafficMiniMap$TrafficMiniMapState = new EvoTrafficMiniMap$TrafficMiniMapState(iStorageAccess, this.logChannel);
            evoTrafficMiniMap$TrafficMiniMapState.readAndDeserialize();
            this.logChannel.log(-2137614336, "EvoTrafficMiniMap#loadState isActive = %1", evoTrafficMiniMap$TrafficMiniMapState.isActive());
            this.setActive(evoTrafficMiniMap$TrafficMiniMapState.isActive());
        }
    }

    @Override
    public void resetSettings() {
        this.setActive(false);
    }

    @Override
    public void cleanup() {
        super.cleanup();
        ((EvoTrafficMiniMapView)this.view).cleanup();
    }
}

