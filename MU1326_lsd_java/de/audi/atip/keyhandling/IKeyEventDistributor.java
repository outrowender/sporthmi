/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.keyhandling;

import de.audi.atip.hmi.event.GestureEvent;
import de.audi.atip.hmi.event.JoystickEvent;
import de.audi.atip.hmi.event.KeyEvent;
import de.audi.atip.hmi.event.ProximityEvent;
import de.audi.atip.hmi.event.TouchEvent;
import de.audi.atip.hmi.event.WheelButtonEvent;
import de.audi.atip.interapp.SDSService;
import de.audi.atip.keyhandling.IVirtualGUIManager;

public interface IKeyEventDistributor {
    public void setSDSService(SDSService var1);

    public void keyPressed(KeyEvent var1);

    public void keyReleased(KeyEvent var1);

    public void keyTurned(WheelButtonEvent var1);

    public void keyMoved(JoystickEvent var1);

    public void touchPadPositionMoved(TouchEvent var1);

    public void touchPadPressed(TouchEvent var1);

    public void touchPadReleased(TouchEvent var1);

    public void touchPadCharactersRecognized(TouchEvent var1);

    public void touchPadAbandoned(TouchEvent var1);

    public void touchPadPalmRecognized(TouchEvent var1);

    public void touchPadApproached(TouchEvent var1);

    public void triggerGestureEvent(GestureEvent var1);

    public void triggerProximityEvent(ProximityEvent var1);

    public void setHardkeyListeners(IVirtualGUIManager var1);
}

