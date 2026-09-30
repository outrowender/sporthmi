/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.hmi.evo;

import de.audi.atip.hmi.event.GestureEvent;
import de.audi.atip.hmi.event.KeyEvent;
import de.audi.atip.hmi.event.TouchEvent;

public interface IEventListenerEvo {
    public void processKeyEvent(KeyEvent var1);

    public void processTouchPadEvent(TouchEvent var1);

    public void processGestureEvent(GestureEvent var1);
}

