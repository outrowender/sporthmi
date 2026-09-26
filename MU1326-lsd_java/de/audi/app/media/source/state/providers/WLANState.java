/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.source.state.providers;

public class WLANState {
    private final boolean enabled;

    public WLANState(boolean bl) {
        this.enabled = bl;
    }

    public boolean isEnabled() {
        return this.enabled;
    }

    public boolean equals(Object object) {
        try {
            WLANState wLANState = (WLANState)object;
            return this.isEnabled() == wLANState.isEnabled();
        }
        catch (Exception exception) {
            return false;
        }
    }

    public int hashCode() {
        return super.hashCode();
    }

    public String toString() {
        return this.enabled ? "ON" : "OFF";
    }
}

