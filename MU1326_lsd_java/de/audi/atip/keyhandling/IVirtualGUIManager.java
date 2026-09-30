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
    public void notifyPowerListenerOnEnterState(int var1, int var2);

    public void notifyPowerListenerOnExitState(int var1, int var2);

    public void notifyPowerTriggerAction(int var1, int var2);

    public void updateClampState(boolean var1, boolean var2, boolean var3, boolean var4);

    public void connectService(HMIApplication var1);

    public void disconnectService(HMIApplication var1);

    public void keyPressed(KeyEvent var1);

    public void keyMoved(JoystickEvent var1);

    public void keyReleased(KeyEvent var1);

    public void keyTurned(WheelButtonEvent var1);

    public IFocusManager getFocusManager();
}

