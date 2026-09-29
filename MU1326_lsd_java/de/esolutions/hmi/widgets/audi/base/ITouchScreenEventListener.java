/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.base;

import de.audi.atip.hmi.event.GestureEvent;

public interface ITouchScreenEventListener {
    default public void touchScreenReleased(GestureEvent gestureEvent, int n, int n2) {
    }

    default public void touchScreenFlicked(GestureEvent gestureEvent, int n, int n2) {
    }

    default public void touchScreenPressed(GestureEvent gestureEvent, int n, int n2) {
    }

    default public void touchScreenZoom(GestureEvent gestureEvent, int n, int n2) {
    }

    default public void touchScreenMoved(GestureEvent gestureEvent, int n, int n2) {
    }

    default public void touchScreenRotate(GestureEvent gestureEvent, int n, int n2) {
    }

    default public void touchScreenPress2(GestureEvent gestureEvent, int n, int n2) {
    }
}

