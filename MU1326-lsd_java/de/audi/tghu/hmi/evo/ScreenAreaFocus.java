/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.hmi.evo;

import de.audi.atip.hmi.event.GestureEventListener;
import de.audi.atip.hmi.event.KeyListener;
import de.audi.atip.hmi.event.TouchPadEventListener;

public interface ScreenAreaFocus
extends KeyListener,
TouchPadEventListener,
GestureEventListener {
    default public boolean hasIdleTimer() {
    }

    default public void restartIdleTimer() {
    }

    default public void cancelIdleTimer() {
    }

    default public void focusChanged(int n, int n2, int n3) {
    }
}

