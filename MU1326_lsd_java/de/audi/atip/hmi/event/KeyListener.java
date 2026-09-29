/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.hmi.event;

import de.audi.atip.hmi.event.JoystickEvent;
import de.audi.atip.hmi.event.KeyEvent;
import de.audi.atip.hmi.event.WheelButtonEvent;

public interface KeyListener {
    default public void keyPressed(KeyEvent keyEvent) {
    }

    default public void keyReleased(KeyEvent keyEvent) {
    }

    default public void keyTurned(WheelButtonEvent wheelButtonEvent) {
    }

    default public void keyMoved(JoystickEvent joystickEvent) {
    }
}

