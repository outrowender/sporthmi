/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.terminalmode.smartphone;

import de.audi.app.terminalmode.dsi.IAppState;
import de.audi.app.terminalmode.dsi.IResource;

public interface IDSISmartphoneManagerListener {
    default public void updateDSIState(boolean bl) {
    }

    default public void updateMode(long l, IAppState[] iAppStateArray, IResource[] iResourceArray) {
    }

    default public void updateTextInputState(boolean bl) {
    }

    default public void duckAudio(int n, double d2) {
    }

    default public void duckAudioCompletely() {
    }

    default public void unduckAudio(int n) {
    }

    default public void releaseDuckAudioCompletely() {
    }

    default public void ignoreUpdateMode(long l) {
    }
}

