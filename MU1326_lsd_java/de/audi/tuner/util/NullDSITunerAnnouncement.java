/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.util;

import de.audi.atip.log.LogChannel;
import de.audi.tuner.util.NullDSIService;
import org.dsi.ifc.radio.DSITunerAnnouncement;

public class NullDSITunerAnnouncement
extends NullDSIService
implements DSITunerAnnouncement {
    public NullDSITunerAnnouncement(LogChannel logChannel) {
        super(logChannel, "DSITunerAnnouncement");
    }

    public NullDSITunerAnnouncement(LogChannel logChannel, int n) {
        super(logChannel, n, "DSITunerAnnouncement");
    }

    @Override
    public void setFilter(int n) {
        this.log();
    }

    @Override
    public void abort(int n) {
        this.log();
    }
}

