/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.interapp.def;

import de.audi.atip.interapp.combi.bap.audio.CombiBAPServiceTone;
import de.audi.atip.interapp.def.NullService;
import de.audi.atip.log.LogChannel;

public class NullCombiBAPServiceTone
extends NullService
implements CombiBAPServiceTone {
    private volatile boolean muted;
    private volatile boolean mutedDueToActivePhoneCall;

    public NullCombiBAPServiceTone(LogChannel logChannel) {
        super(logChannel, "CombiBAPServiceTone");
    }

    public boolean isMuted() {
        return this.muted;
    }

    public boolean isMutedDueToActivePhoneCall() {
        return this.mutedDueToActivePhoneCall;
    }

    public void updateMuteState(boolean bl, boolean bl2) {
        this.muted = bl;
        this.mutedDueToActivePhoneCall = bl2;
        this.log("updateMuteState save snapshot");
    }

    public void updateVolumeProperties(byte by, boolean bl, boolean bl2, boolean bl3, boolean bl4, boolean bl5, boolean bl6, boolean bl7, boolean bl8) {
        this.log();
    }

    public void updateVolume(int n, int n2, int n3, boolean bl, boolean bl2) {
        this.log();
    }
}

