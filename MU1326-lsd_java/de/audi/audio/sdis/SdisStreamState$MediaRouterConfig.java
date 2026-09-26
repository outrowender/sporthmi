/*
 * Decompiled with CFR 0.152.
 */
package de.audi.audio.sdis;

import de.audi.audio.sdis.SdisStreamState;

class SdisStreamState$MediaRouterConfig {
    private int audioSource;
    private int videoSource;
    private int sink;
    private final /* synthetic */ SdisStreamState this$0;

    SdisStreamState$MediaRouterConfig(SdisStreamState sdisStreamState, int n, int n2, int n3) {
        this.this$0 = sdisStreamState;
        this.audioSource = n;
        this.videoSource = n2;
        this.sink = n3;
    }

    public int hashCode() {
        int n = 1;
        n = 31 * n + this.getOuterType().hashCode();
        n = 31 * n + this.audioSource;
        n = 31 * n + this.sink;
        n = 31 * n + this.videoSource;
        return n;
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
        SdisStreamState$MediaRouterConfig sdisStreamState$MediaRouterConfig = (SdisStreamState$MediaRouterConfig)object;
        if (!this.getOuterType().equals(sdisStreamState$MediaRouterConfig.getOuterType())) {
            return false;
        }
        if (this.audioSource != sdisStreamState$MediaRouterConfig.audioSource) {
            return false;
        }
        if (this.sink != sdisStreamState$MediaRouterConfig.sink) {
            return false;
        }
        return this.videoSource == sdisStreamState$MediaRouterConfig.videoSource;
    }

    private SdisStreamState getOuterType() {
        return this.this$0;
    }
}

