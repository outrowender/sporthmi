/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.hmi.event;

import de.audi.atip.hmi.event.JoystickEvent;
import de.audi.atip.hmi.event.KeyEvent;
import de.audi.atip.hmi.event.WheelButtonEvent;

public interface KeyListener {
    public void keyPressed(KeyEvent var1);

    public void keyReleased(KeyEvent var1);

    public void keyTurned(WheelButtonEvent var1);

    public void keyMoved(JoystickEvent var1);
}

