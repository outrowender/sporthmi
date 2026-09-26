/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.map;

import de.audi.atip.interapp.icon.RenderingInfoProvider;
import de.audi.tghu.navi.app.map.ISatelliteMapsMediatorFSM$NullSatellitesManagerFSM;

public interface ISatelliteMapsMediatorFSM {
    public static final ISatelliteMapsMediatorFSM NULL_SATELLITES_MANAGAER_FSM = new ISatelliteMapsMediatorFSM$NullSatellitesManagerFSM();

    default public void cleanUp() {
    }

    default public void updatemapStyle(int n) {
    }

    default public void setMapStyle(int n, boolean bl) {
    }

    default public boolean isSatelliteMapsActive() {
    }

    default public void setLogosAccordingToSetup() {
    }

    default public void setRenderingInfoProvider(RenderingInfoProvider renderingInfoProvider) {
    }
}

