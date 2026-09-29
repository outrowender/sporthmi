/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo.widgets.menu;

public class MenuKeyEventHandler$ScrollAccelerationData {
    public static final int DEFAULT_SPEED;
    long lastSpeedUpdateTime = -1L;
    int speed = 1;
    int currentGestureDistance = 0;
    boolean currentGestureAccelerated = false;
    boolean down;

    public MenuKeyEventHandler$ScrollAccelerationData(boolean bl) {
        this.down = bl;
    }
}

