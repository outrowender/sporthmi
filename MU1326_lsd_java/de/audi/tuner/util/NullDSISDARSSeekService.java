/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.util;

import de.audi.atip.log.LogChannel;
import de.audi.tuner.util.NullDSIService;
import org.dsi.ifc.sdars.DSISDARSSeek;

public class NullDSISDARSSeekService
extends NullDSIService
implements DSISDARSSeek {
    public NullDSISDARSSeekService(LogChannel logChannel) {
        super(logChannel, "DSISDARSSeek");
    }

    public void setSeekCommand(int n, int n2, int n3) {
        this.log();
    }

    public void manageSeek(int n, int n2) {
        this.log();
    }

    public void reset(int n) {
        this.log();
    }

    public void manageSeek2(int n, int n2, int n3, int n4) {
        this.log();
    }

    public void getTeamsOfLeague(int n) {
        this.log();
    }

    public void getLeagues() {
        this.log();
    }

    public void profileChange(int n) {
        this.log();
    }

    public void profileCopy(int n, int n2) {
        this.log();
    }

    public void profileReset(int n) {
        this.log();
    }

    public void profileResetAll() {
        this.log();
    }
}

