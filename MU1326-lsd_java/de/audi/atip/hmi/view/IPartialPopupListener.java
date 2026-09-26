/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.hmi.view;

public interface IPartialPopupListener {
    default public void partialPopupVisible(int n, int n2) {
    }

    default public void partialPopupHidden(int n, int n2) {
    }

    default public void partialPopupRemoved(int n, int n2) {
    }

    default public int[] getPPIDsForCallbacks() {
    }

    default public void partialPopupListenerRegistered(int n, int n2, boolean bl) {
    }

    default public void informAboutPPCoordinates(int n, int n2, int n3, int n4, int n5, int n6) {
    }
}

