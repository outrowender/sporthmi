/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo.widgets;

import de.audi.atip.log.LogChannel;
import de.esolutions.hmi.widgets.audi.base.widgets.AbstractIdleTimerController;
import de.esolutions.hmi.widgets.audi.evo.widgets.EntertainmentDrawerOpenCloseController;

class EntertainmentDrawerOpenCloseController$BlacklistingTimer
extends AbstractIdleTimerController {
    private final /* synthetic */ EntertainmentDrawerOpenCloseController this$0;

    public EntertainmentDrawerOpenCloseController$BlacklistingTimer(EntertainmentDrawerOpenCloseController entertainmentDrawerOpenCloseController, LogChannel logChannel) {
        this.this$0 = entertainmentDrawerOpenCloseController;
        super(logChannel);
        this.startTimerAutomatically = false;
        this.fireWhenOptionDrawerOpen = true;
        this.fireWhenSelectionDrawerOpen = true;
        this.deactivateOnKeyReleased = false;
        this.idleTime = 300;
    }

    @Override
    protected void timerFired() {
        EntertainmentDrawerOpenCloseController.access$000(this.this$0).setDelayForDeblacklistingActive(false);
        EntertainmentDrawerOpenCloseController.access$000(this.this$0).processAnimation(200, 32959, 1);
    }
}

