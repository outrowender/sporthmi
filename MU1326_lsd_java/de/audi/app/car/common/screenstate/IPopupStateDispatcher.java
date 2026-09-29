/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.car.common.screenstate;

import de.audi.app.car.common.screenstate.IPartialPopupStateListener;
import de.audi.app.car.common.screenstate.IPopupStateListener;
import de.audi.app.car.common.screenstate.IScreenStateListener;

public interface IPopupStateDispatcher {
    default public void init() {
    }

    default public void deinit() {
    }

    default public void addPopupStateListener(int n, IPopupStateListener iPopupStateListener) {
    }

    default public void removePopupStateListener(int n, IPopupStateListener iPopupStateListener) {
    }

    default public void addScreenStateListener(int n, IScreenStateListener iScreenStateListener) {
    }

    default public void removeScreenStateListener(int n, IScreenStateListener iScreenStateListener) {
    }

    default public void addPartialPopupStateListener(int n, IPartialPopupStateListener iPartialPopupStateListener) {
    }

    default public void removePartialPopupStateListener(int n, IPartialPopupStateListener iPartialPopupStateListener) {
    }

    default public void notifyPopupVisible(int n, int n2) {
    }

    default public void notifyPopupHidden(int n, int n2) {
    }

    default public void notifyPopupRemoved(int n, int n2) {
    }

    default public void notifyScreenVisible(int n, int n2) {
    }

    default public void notifyScreenHidden(int n, int n2) {
    }

    default public void notifyScreenFadedOut(int n, int n2) {
    }

    default public void notifyScreenConnected(int n, int n2) {
    }
}

