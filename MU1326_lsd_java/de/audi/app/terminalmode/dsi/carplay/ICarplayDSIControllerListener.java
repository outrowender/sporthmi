/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.terminalmode.dsi.carplay;

import de.audi.app.terminalmode.dsi.IAppState;
import de.audi.app.terminalmode.dsi.IResource;

public interface ICarplayDSIControllerListener {
    default public void updateMode(IAppState[] iAppStateArray, IResource[] iResourceArray) {
    }

    default public void updateTextInputState(boolean bl) {
    }

    default public void duckAudio(int n, double d2) {
    }

    default public void unduckAudio(int n) {
    }

    default public void updateMainAudioType(int n) {
    }

    default public void oemAppSelected() {
    }
}

