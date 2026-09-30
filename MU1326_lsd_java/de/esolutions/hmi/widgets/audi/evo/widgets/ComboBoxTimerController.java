/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo.widgets;

import de.esolutions.hmi.widgets.audi.base.widgets.AbstractIdleTimerController;
import de.esolutions.hmi.widgets.audi.evo.widgets.ComboBoxController;

public class ComboBoxTimerController
extends AbstractIdleTimerController {
    public ComboBoxTimerController() {
        super(menuLogCh);
        this.startTimerAutomatically = false;
        this.fireWhenOptionDrawerOpen = true;
        this.fireWhenSelectionDrawerOpen = true;
        this.deactivateOnKeyReleased = false;
        this.idleTime = 500;
    }

    protected void timerFired() {
        if (this.parent instanceof ComboBoxController) {
            logChannel.log(10000000, "ComboBoxTimerController#timerFired: Fire timer --> updateContent if needed");
            if (((ComboBoxController)this.parent).updateContent()) {
                logChannel.log(10000000, "ComboBoxTimerController#timerFired: model value did not match label value -> trigger repaint");
                this.triggerRepaint();
            }
        }
    }
}

