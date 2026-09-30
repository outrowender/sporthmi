/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.interapp.bap.ecall.data;

public final class FunctionalState {
    private final boolean audioFunctional;
    private final boolean audioUplinkFunctional;
    private final boolean audioDownlinkFunctional;

    public static Builder builder() {
        return new Builder();
    }

    private FunctionalState(boolean bl, boolean bl2, boolean bl3) {
        this.audioFunctional = bl;
        this.audioUplinkFunctional = bl2;
        this.audioDownlinkFunctional = bl3;
    }

    public boolean isAudioFunctional() {
        return this.audioFunctional;
    }

    public boolean isAudioUplinkFunctional() {
        return this.audioUplinkFunctional;
    }

    public boolean isAudioDownlinkFunctional() {
        return this.audioDownlinkFunctional;
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null) {
            return false;
        }
        if (this.getClass() != object.getClass()) {
            return false;
        }
        FunctionalState functionalState = (FunctionalState)object;
        if (this.audioDownlinkFunctional != functionalState.audioDownlinkFunctional) {
            return false;
        }
        if (this.audioFunctional != functionalState.audioFunctional) {
            return false;
        }
        return this.audioUplinkFunctional == functionalState.audioUplinkFunctional;
    }

    public int hashCode() {
        int n = 1;
        n = 31 * n + (this.audioDownlinkFunctional ? 1231 : 1237);
        n = 31 * n + (this.audioFunctional ? 1231 : 1237);
        n = 31 * n + (this.audioUplinkFunctional ? 1231 : 1237);
        return n;
    }

    public String toString() {
        return new StringBuffer().append("FunctionalState [audioFullyFunctional=").append(this.audioFunctional).append(", audioUplinkFunctional=").append(this.audioUplinkFunctional).append(", audioDownlinkFullyFunctional=").append(this.audioDownlinkFunctional).append("]").toString();
    }

    public static final class Builder {
        private boolean audioFunctional;
        private boolean audioUplinkFunctional;
        private boolean audioDownlinkFunctional;

        public Builder setAudioFunctional(boolean bl) {
            this.audioFunctional = bl;
            return this;
        }

        public Builder setAudioUplinkFunctional(boolean bl) {
            this.audioUplinkFunctional = bl;
            return this;
        }

        public Builder setAudioDownlinkFunctional(boolean bl) {
            this.audioDownlinkFunctional = bl;
            return this;
        }

        public FunctionalState build() {
            return new FunctionalState(this.audioFunctional, this.audioUplinkFunctional, this.audioDownlinkFunctional);
        }
    }
}

