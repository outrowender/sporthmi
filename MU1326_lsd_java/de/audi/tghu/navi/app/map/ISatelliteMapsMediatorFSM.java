/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.map;

import de.audi.atip.interapp.icon.RenderingInfoProvider;

public interface ISatelliteMapsMediatorFSM {
    public static final ISatelliteMapsMediatorFSM NULL_SATELLITES_MANAGAER_FSM = new NullSatellitesManagerFSM();

    public void cleanUp();

    public void updatemapStyle(int var1);

    public void setMapStyle(int var1, boolean var2);

    public boolean isSatelliteMapsActive();

    public void setLogosAccordingToSetup();

    public void setRenderingInfoProvider(RenderingInfoProvider var1);

    public static class NullSatellitesManagerFSM
    implements ISatelliteMapsMediatorFSM {
        public void cleanUp() {
        }

        public void updatemapStyle(int n) {
        }

        public void setMapStyle(int n, boolean bl) {
        }

        public boolean isSatelliteMapsActive() {
            return false;
        }

        public void setLogosAccordingToSetup() {
        }

        public void setRenderingInfoProvider(RenderingInfoProvider renderingInfoProvider) {
        }
    }
}

