/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo.widgets.menu;

import de.audi.atip.log.LogChannel;
import de.esolutions.hmi.widgets.audi.base.widgets.AbstractIdleTimerController;

public class SelectionMenuIdleTimerController
extends AbstractIdleTimerController {
    private static final int t_close_selection_menu;

    public SelectionMenuIdleTimerController(LogChannel logChannel) {
        super(logChannel);
        this.idleTime = 4000;
        this.startTimerAutomatically = false;
        this.fireWhenOptionDrawerOpen = false;
        this.fireWhenSelectionDrawerOpen = true;
    }

    @Override
    protected void timerFired() {
        this.terminal.getDrawerFocusManager().requestDrawerState(16);
    }
}

