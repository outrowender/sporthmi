/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.phone.core.screen;

import de.audi.app.phone.core.screen.IPartialPopupStateListener;
import de.audi.app.phone.core.screen.IPopupStateListener;
import de.audi.app.phone.core.screen.IScreenStateListener;

public interface IPopupScreenStateDispatcher {
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

