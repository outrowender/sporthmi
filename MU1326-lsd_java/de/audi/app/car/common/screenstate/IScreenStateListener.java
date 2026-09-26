/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.car.common.screenstate;

public interface IScreenStateListener {
    default public void notifyScreenVisible(int n) {
    }

    default public void notifyScreenHidden(int n) {
    }

    default public void notifyScreenConnected(int n) {
    }

    default public void notifyScreenFadedOut(int n) {
    }
}

