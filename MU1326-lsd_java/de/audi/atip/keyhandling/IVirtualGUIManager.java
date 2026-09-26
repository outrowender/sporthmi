/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.keyhandling;

import de.audi.atip.hmi.HMIApplication;
import de.audi.atip.hmi.IFocusManager;
import de.audi.atip.hmi.event.JoystickEvent;
import de.audi.atip.hmi.event.KeyEvent;
import de.audi.atip.hmi.event.WheelButtonEvent;

public interface IVirtualGUIManager {
    default public void notifyPowerListenerOnEnterState(int n, int n2) {
    }

    default public void notifyPowerListenerOnExitState(int n, int n2) {
    }

    default public void notifyPowerTriggerAction(int n, int n2) {
    }

    default public void updateClampState(boolean bl, boolean bl2, boolean bl3, boolean bl4) {
    }

    default public void connectService(HMIApplication hMIApplication) {
    }

    default public void disconnectService(HMIApplication hMIApplication) {
    }

    default public void keyPressed(KeyEvent keyEvent) {
    }

    default public void keyMoved(JoystickEvent joystickEvent) {
    }

    default public void keyReleased(KeyEvent keyEvent) {
    }

    default public void keyTurned(WheelButtonEvent wheelButtonEvent) {
    }

    default public IFocusManager getFocusManager() {
    }
}

