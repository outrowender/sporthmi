/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.interapp.def;

import de.audi.atip.interapp.MapService;
import de.audi.atip.interapp.def.NullService;
import de.audi.atip.log.LogChannel;

public class NullMapService
extends NullService
implements MapService {
    public NullMapService(LogChannel logChannel) {
        super(logChannel, "MapService");
    }

    public boolean isOrientationChangeAllowed() {
        super.log();
        return false;
    }

    public int setMapType(int n) {
        super.log();
        return 0;
    }

    public void setMapColor(int n) {
        super.log();
    }

    public void setMapOrientation(int n) {
        super.log();
    }

    public void setAdditionalInfos(int n) {
        super.log();
    }

    public void setCrossingView(int n) {
        super.log();
    }

    public void setAutoZoom(int n) {
        super.log();
    }

    public void setIncrementalZoom(int n) {
        super.log();
    }

    public void setMapRepresentation(int n) {
        super.log();
    }

    public void setZoomLevel(float f2) {
        super.log();
    }

    public boolean sdsSetMapRepresentation(int n) {
        super.log();
        return false;
    }

    public void swapMaps() {
        super.log();
    }

    public void setTrafficSettings(boolean bl, boolean bl2, boolean bl3, int n) {
        super.log();
    }
}

