/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.interapp.def;

import de.audi.atip.interapp.NavAsiaToneConnector;
import de.audi.atip.interapp.def.NullService;
import de.audi.atip.log.LogChannel;

public class NullNavAsiaToneConnector
extends NullService
implements NavAsiaToneConnector {
    public NullNavAsiaToneConnector(LogChannel logChannel, int n) {
        super(logChannel, n, "NavAsiaToneConnector");
    }

    public void navAsiaAnnouncementVolumeEntered(int n) {
        this.log("navAsiaAnnouncementVolumeEntered");
    }

    public void navAsiaAnnouncementVolumeLeft(int n) {
        this.log("navAsiaAnnouncementVolumeLeft");
    }
}

