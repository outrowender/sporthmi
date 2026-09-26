/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo.widgets;

import de.esolutions.hmi.widgets.audi.evo.widgets.NowPlayingMenuController;
import de.esolutions.hmi.widgets.audi.evo.widgets.menu.AbstractMenuIdleTimerController;

public class NowPlayingMenuTimerController
extends AbstractMenuIdleTimerController {
    private boolean isFireEventTemporarilyDisabled = false;

    public NowPlayingMenuTimerController() {
        super(menuLogCh);
        this.startTimerAutomatically = true;
        this.fireWhenOptionDrawerOpen = false;
        this.fireWhenSelectionDrawerOpen = false;
        this.fireWhenSdsActive = false;
        this.fireWhenScrollAnimationRunning = false;
        this.fireWhenMoveModeActive = false;
        this.idleTime = 10000;
    }

    @Override
    protected void timerFired() {
        if (this.isFireEventTemporarilyDisabled) {
            return;
        }
        NowPlayingMenuController nowPlayingMenuController = this.getNowPlayingMenu();
        if (nowPlayingMenuController != null) {
            nowPlayingMenuController.activateNowPlayingOnFocus(false);
        }
    }

    @Override
    public void setEnabled(boolean bl) {
        super.setEnabled(bl);
        if (!this.isEnabled()) {
            this.deactivateNowPlaying();
        }
    }

    public void setTemporaryDisabled(boolean bl) {
        if (this.isFireEventTemporarilyDisabled && !bl) {
            this.restartTimer();
        }
        this.isFireEventTemporarilyDisabled = bl;
    }

    public boolean isTemporaryDisabled() {
        return this.isFireEventTemporarilyDisabled;
    }

    private void deactivateNowPlaying() {
        NowPlayingMenuController nowPlayingMenuController = this.getNowPlayingMenu();
        if (nowPlayingMenuController != null && nowPlayingMenuController.isNowPlayingActive()) {
            nowPlayingMenuController.deactivateNowPlaying(false);
        }
    }

    private NowPlayingMenuController getNowPlayingMenu() {
        if (this.parent instanceof NowPlayingMenuController) {
            return (NowPlayingMenuController)this.parent;
        }
        menuLogCh.log(10000, "NowPlayingMenuTimerController#getNowPlayingMenu: parent is not a NowPlayingMenu: %1", (Object)this.parent);
        return null;
    }
}

