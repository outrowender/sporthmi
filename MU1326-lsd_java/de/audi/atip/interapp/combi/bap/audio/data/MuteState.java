/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.interapp.combi.bap.audio.data;

import de.audi.atip.interapp.combi.bap.audio.data.MuteState$Builder;

public final class MuteState {
    private final boolean dabMutingLowSignal;
    private final boolean sdarsMutingLowSignal;
    private final boolean ibocNotInSync;
    private final boolean ibocMutingLowSignal;

    public static MuteState$Builder builder() {
        return new MuteState$Builder();
    }

    private MuteState(boolean bl, boolean bl2, boolean bl3, boolean bl4) {
        this.dabMutingLowSignal = bl;
        this.sdarsMutingLowSignal = bl2;
        this.ibocNotInSync = bl3;
        this.ibocMutingLowSignal = bl4;
    }

    public boolean isDabMutingLowSignal() {
        return this.dabMutingLowSignal;
    }

    public boolean isSdarsMutingLowSignal() {
        return this.sdarsMutingLowSignal;
    }

    public boolean isIbocNotInSync() {
        return this.ibocNotInSync;
    }

    public boolean isIbocMutingLowSignal() {
        return this.ibocMutingLowSignal;
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null) {
            return false;
        }
        if (super.getClass() != object.getClass()) {
            return false;
        }
        MuteState muteState = (MuteState)object;
        if (this.dabMutingLowSignal != muteState.dabMutingLowSignal) {
            return false;
        }
        if (this.ibocMutingLowSignal != muteState.ibocMutingLowSignal) {
            return false;
        }
        if (this.ibocNotInSync != muteState.ibocNotInSync) {
            return false;
        }
        return this.sdarsMutingLowSignal == muteState.sdarsMutingLowSignal;
    }

    public int hashCode() {
        int n = 1;
        n = 31 * n + (this.dabMutingLowSignal ? 1231 : 1237);
        n = 31 * n + (this.ibocMutingLowSignal ? 1231 : 1237);
        n = 31 * n + (this.ibocNotInSync ? 1231 : 1237);
        n = 31 * n + (this.sdarsMutingLowSignal ? 1231 : 1237);
        return n;
    }

    public String toString() {
        return new StringBuffer().append("MuteState [dabMutingLowSignal=").append(this.dabMutingLowSignal).append(", sdarsMutingLowSignal=").append(this.sdarsMutingLowSignal).append(", ibocNotInSync=").append(this.ibocNotInSync).append(", ibocMutingLowSignal=").append(this.ibocMutingLowSignal).append("]").toString();
    }
}

