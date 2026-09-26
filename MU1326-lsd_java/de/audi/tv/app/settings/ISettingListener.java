/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tv.app.settings;

public interface ISettingListener {
    default public void updateVisualAudio(boolean bl) {
    }

    default public void updateEWS(boolean bl) {
    }

    default public void passwordChanged() {
    }

    default public void passwordNeedsToBeEnteredAgain() {
    }

    default public void updateStationListSorting(int n) {
    }
}

