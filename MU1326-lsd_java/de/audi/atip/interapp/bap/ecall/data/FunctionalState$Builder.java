/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.interapp.bap.ecall.data;

import de.audi.atip.interapp.bap.ecall.data.FunctionalState;

public final class FunctionalState$Builder {
    private boolean audioFunctional;
    private boolean audioUplinkFunctional;
    private boolean audioDownlinkFunctional;

    public FunctionalState$Builder setAudioFunctional(boolean bl) {
        this.audioFunctional = bl;
        return this;
    }

    public FunctionalState$Builder setAudioUplinkFunctional(boolean bl) {
        this.audioUplinkFunctional = bl;
        return this;
    }

    public FunctionalState$Builder setAudioDownlinkFunctional(boolean bl) {
        this.audioDownlinkFunctional = bl;
        return this;
    }

    public FunctionalState build() {
        return new FunctionalState(this.audioFunctional, this.audioUplinkFunctional, this.audioDownlinkFunctional);
    }
}

