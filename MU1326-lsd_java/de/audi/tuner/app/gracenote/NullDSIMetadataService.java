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
        super(logChannel, 14808325, "DSIMetadataService");
    }

    @Override
    public void setNotification(int[] nArray, DSIListener dSIListener) {
        this.log();
    }

    @Override
    public void setNotification(int n, DSIListener dSIListener) {
        this.log();
    }

    @Override
    public void setNotification(DSIListener dSIListener) {
        this.log();
    }

    @Override
    public void clearNotification(int[] nArray, DSIListener dSIListener) {
        this.log();
    }

    @Override
    public void clearNotification(int n, DSIListener dSIListener) {
        this.log();
    }

    @Override
    public void clearNotification(DSIListener dSIListener) {
        this.log();
    }

    @Override
    public void requestCoverArt(int n, CoverartInfo coverartInfo) {
        this.log();
    }

    @Override
    public void disableOnlineLookup() {
        this.log();
    }

    @Override
    public void enableOnlineLookup() {
        this.log();
    }
}

