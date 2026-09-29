/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.earlyfunc.core.parking;

public interface IParkingPopupHandler {
    default public void registerPopup(int n) {
    }

    default public void unregisterPopup(int n) {
    }

    default public void showPopup(int n) {
    }

    default public void removeCurrentPopup(int n) {
    }

    default public boolean isPopupActive() {
    }
}

