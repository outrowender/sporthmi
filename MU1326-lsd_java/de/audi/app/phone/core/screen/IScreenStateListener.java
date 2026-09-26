/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.phone.core.screen;

public interface IScreenStateListener {
    default public void screenVisible(int n) {
    }

    default public void screenHidden(int n) {
    }

    default public void notifyScreenConnected(int n) {
    }

    default public void notifyScreenFadedOut(int n) {
    }
}

