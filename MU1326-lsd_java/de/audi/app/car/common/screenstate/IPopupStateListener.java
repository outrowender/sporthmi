/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.car.common.screenstate;

public interface IPopupStateListener {
    default public void notifyPopupVisible(int n) {
    }

    default public void notifyPopupHidden(int n) {
    }

    default public void notifyPopupRemoved(int n) {
    }
}

