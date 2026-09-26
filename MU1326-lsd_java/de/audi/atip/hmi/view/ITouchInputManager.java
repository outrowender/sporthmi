/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.hmi.view;

import de.audi.atip.hmi.view.HMIView;

public interface ITouchInputManager {
    default public void setDesiredRecognizerMode(HMIView hMIView, int n) {
    }

    default public void deregister(HMIView hMIView) {
    }

    default public void presetPopupActive(boolean bl) {
    }

    default public boolean isPresetPopupActive() {
    }

    default public void clear() {
    }

    default public void updateRecognizerMode(boolean bl) {
    }
}

