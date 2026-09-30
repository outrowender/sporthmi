/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app.gracenote;

import de.audi.atip.interapp.def.NullService;
import de.audi.atip.log.LogChannel;
import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.media.CoverartInfo;
import org.dsi.ifc.media.DSIMetadataService;

class NullDSIMetadataService
extends NullService
implements DSIMetadataService {
    protected NullDSIMetadataService(LogChannel logChannel) {
        super(logChannel, 100000000, "DSIMetadataService");
    }

    public void setNotification(int[] nArray, DSIListener dSIListener) {
        this.log();
    }

    public void setNotification(int n, DSIListener dSIListener) {
        this.log();
    }

    public void setNotification(DSIListener dSIListener) {
        this.log();
    }

    public void clearNotification(int[] nArray, DSIListener dSIListener) {
        this.log();
    }

    public void clearNotification(int n, DSIListener dSIListener) {
        this.log();
    }

    public void clearNotification(DSIListener dSIListener) {
        this.log();
    }

    public void requestCoverArt(int n, CoverartInfo coverartInfo) {
        this.log();
    }

    public void disableOnlineLookup() {
        this.log();
    }

    public void enableOnlineLookup() {
        this.log();
    }
}

