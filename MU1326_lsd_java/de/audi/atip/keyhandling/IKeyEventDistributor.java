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
    default public void setSDSService(SDSService sDSService) {
    }

    default public void keyPressed(KeyEvent keyEvent) {
    }

    default public void keyReleased(KeyEvent keyEvent) {
    }

    default public void keyTurned(WheelButtonEvent wheelButtonEvent) {
    }

    default public void keyMoved(JoystickEvent joystickEvent) {
    }

    default public void touchPadPositionMoved(TouchEvent touchEvent) {
    }

    default public void touchPadPressed(TouchEvent touchEvent) {
    }

    default public void touchPadReleased(TouchEvent touchEvent) {
    }

    default public void touchPadCharactersRecognized(TouchEvent touchEvent) {
    }

    default public void touchPadAbandoned(TouchEvent touchEvent) {
    }

    default public void touchPadPalmRecognized(TouchEvent touchEvent) {
    }

    default public void touchPadApproached(TouchEvent touchEvent) {
    }

    default public void triggerGestureEvent(GestureEvent gestureEvent) {
    }

    default public void triggerProximityEvent(ProximityEvent proximityEvent) {
    }

    default public void setHardkeyListeners(IVirtualGUIManager iVirtualGUIManager) {
    }
}

