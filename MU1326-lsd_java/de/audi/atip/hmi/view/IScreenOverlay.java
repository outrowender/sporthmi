/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.hmi.view;

public interface IScreenOverlay {
    default public void show() {
    }

    default public void hide() {
    }

    default public void hideNow() {
    }

    default public boolean isShown() {
    }

    default public boolean isVisible() {
    }

    default public boolean isAnimating() {
    }

    default public void startFadeoutTimer() {
    }

    default public void stopFadeoutTimer() {
    }
}

