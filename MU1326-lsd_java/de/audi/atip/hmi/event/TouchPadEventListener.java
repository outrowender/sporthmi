/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.hmi.event;

import de.audi.atip.hmi.event.TouchEvent;

public interface TouchPadEventListener {
    default public void touchPadPressed(TouchEvent touchEvent) {
    }

    default public void touchPadReleased(TouchEvent touchEvent) {
    }

    default public void touchPadPositionMoved(TouchEvent touchEvent) {
    }

    default public void touchPadCharactersRecognized(TouchEvent touchEvent) {
    }

    default public void touchPadPalmRecognized(TouchEvent touchEvent) {
    }

    default public void touchPadApproached(TouchEvent touchEvent) {
    }

    default public void touchPadAbandoned(TouchEvent touchEvent) {
    }
}

