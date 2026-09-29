/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.content.media;

import org.dsi.ifc.media.Capabilities;

public interface IPlayerListener {
    default public void playerStartupComplete() {
    }

    default public void repeatScopeChanged(int n, boolean bl) {
    }

    default public void repeatModeChanged(int n) {
    }

    default public void playbackStateChanged(int n) {
    }

    default public void capabilitiesChanged(Capabilities capabilities) {
    }

    default public void commandBlocked() {
    }

    default public void currentPMLevelChanged(int n) {
    }
}

