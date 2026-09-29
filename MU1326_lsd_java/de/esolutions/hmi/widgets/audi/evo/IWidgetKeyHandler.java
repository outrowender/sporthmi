/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo;

import de.audi.atip.hmi.event.JoystickEvent;
import de.audi.atip.hmi.event.KeyEvent;
import de.audi.atip.hmi.event.WheelButtonEvent;
import de.esolutions.hmi.widgets.audi.base.widgets.AbstractWidgetController;

public interface IWidgetKeyHandler {
    default public void keyPressed(AbstractWidgetController abstractWidgetController, KeyEvent keyEvent) {
    }

    default public void keyReleased(AbstractWidgetController abstractWidgetController, KeyEvent keyEvent) {
    }

    default public void keyTurned(AbstractWidgetController abstractWidgetController, WheelButtonEvent wheelButtonEvent) {
    }

    default public void keyMoved(AbstractWidgetController abstractWidgetController, JoystickEvent joystickEvent) {
    }
}

