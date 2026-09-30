/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.androidauto2;

import de.esolutions.fw.comm.core.method.MethodException;
import org.dsi.ifc.androidauto2.ServiceConfiguration;
import org.dsi.ifc.androidauto2.TouchEvent;

public interface DSIAndroidAuto2C {
    public void videoFocusNotification(int var1, boolean var2) throws MethodException;

    public void audioFocusNotification(int var1, boolean var2) throws MethodException;

    public void microphoneNotification(int var1, boolean var2) throws MethodException;

    public void navFocusNotification(int var1, boolean var2) throws MethodException;

    public void startService(ServiceConfiguration var1) throws MethodException;

    public void postButtonEvent(int var1, int var2) throws MethodException;

    public void postTouchEvent(int var1, TouchEvent[] var2, int var3, int var4) throws MethodException;

    public void postRotaryEvent(int var1) throws MethodException;

    public void setNightMode(boolean var1) throws MethodException;

    public void bluetoothPairingResponse(boolean var1) throws MethodException;

    public void bluetoothAuthenticationData(String var1) throws MethodException;

    public void setNotification(int[] var1) throws MethodException;

    public void setNotification(int var1) throws MethodException;

    public void setNotification() throws MethodException;

    public void clearNotification(int[] var1) throws MethodException;

    public void clearNotification(int var1) throws MethodException;

    public void clearNotification() throws MethodException;

    public void yySet(String var1, String var2) throws MethodException;
}

