/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.interapp.combi.bap.audio.data;

import de.audi.atip.interapp.combi.bap.audio.data.MuteState;

public final class MuteState$Builder {
    private boolean dabMutingLowSignal;
    private boolean sdarsMutingLowSignal;
    private boolean ibocNotInSync;
    private boolean ibocMutingLowSignal;

    public MuteState$Builder setDabMutingLowSignal(boolean bl) {
        this.dabMutingLowSignal = bl;
        return this;
    }

    public MuteState$Builder setSdarsMutingLowSignal(boolean bl) {
        this.sdarsMutingLowSignal = bl;
        return this;
    }

    public MuteState$Builder setIbocNotInSync(boolean bl) {
        this.ibocNotInSync = bl;
        return this;
    }

    public MuteState$Builder setIbocMutingLowSignal(boolean bl) {
        this.ibocMutingLowSignal = bl;
        return this;
    }

    public MuteState build() {
        return new MuteState(this.dabMutingLowSignal, this.sdarsMutingLowSignal, this.ibocNotInSync, this.ibocMutingLowSignal);
    }
}

