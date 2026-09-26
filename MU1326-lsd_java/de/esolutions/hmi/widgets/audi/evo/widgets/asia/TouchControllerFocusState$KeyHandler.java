/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo.widgets.asia;

import de.audi.atip.hmi.event.JoystickEvent;
import de.audi.atip.hmi.event.KeyEvent;
import de.audi.atip.hmi.event.WheelButtonEvent;
import de.esolutions.hmi.widgets.audi.evo.widgets.asia.TouchControllerAsia;

public interface TouchControllerFocusState$KeyHandler {
    default public void handleKeyPress(TouchControllerAsia touchControllerAsia, KeyEvent keyEvent) {
    }

    default public void handleKeyMove(TouchControllerAsia touchControllerAsia, JoystickEvent joystickEvent) {
    }

    default public void handleKeyTurn(TouchControllerAsia touchControllerAsia, WheelButtonEvent wheelButtonEvent) {
    }
}

