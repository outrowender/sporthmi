/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.hmi.evo;

import de.audi.atip.hmi.event.GestureEvent;
import de.audi.atip.hmi.event.KeyEvent;
import de.audi.atip.hmi.event.TouchEvent;

public interface IEventListenerEvo {
    default public void processKeyEvent(KeyEvent keyEvent) {
    }

    default public void processTouchPadEvent(TouchEvent touchEvent) {
    }

    default public void processGestureEvent(GestureEvent gestureEvent) {
    }
}

