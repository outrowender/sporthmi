/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.hmi.event;

import de.audi.atip.hmi.event.TouchEvent;

public interface TouchPadEventListener {
    public void touchPadPressed(TouchEvent var1);

    public void touchPadReleased(TouchEvent var1);

    public void touchPadPositionMoved(TouchEvent var1);

    public void touchPadCharactersRecognized(TouchEvent var1);

    public void touchPadPalmRecognized(TouchEvent var1);

    public void touchPadApproached(TouchEvent var1);

    public void touchPadAbandoned(TouchEvent var1);
}

