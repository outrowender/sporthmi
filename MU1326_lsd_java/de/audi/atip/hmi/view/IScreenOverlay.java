/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.hmi.view;

public interface IScreenOverlay {
    public void show();

    public void hide();

    public void hideNow();

    public boolean isShown();

    public boolean isVisible();

    public boolean isAnimating();

    public void startFadeoutTimer();

    public void stopFadeoutTimer();
}

