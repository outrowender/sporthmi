/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.base;

import de.audi.atip.hmi.event.GestureEvent;

public interface ITouchScreenEventListener {
    public void touchScreenReleased(GestureEvent var1, int var2, int var3);

    public void touchScreenFlicked(GestureEvent var1, int var2, int var3);

    public void touchScreenPressed(GestureEvent var1, int var2, int var3);

    public void touchScreenZoom(GestureEvent var1, int var2, int var3);

    public void touchScreenMoved(GestureEvent var1, int var2, int var3);

    public void touchScreenRotate(GestureEvent var1, int var2, int var3);

    public void touchScreenPress2(GestureEvent var1, int var2, int var3);
}

