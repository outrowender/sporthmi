/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.androidauto;

import de.esolutions.fw.comm.core.method.MethodException;
import org.dsi.ifc.androidauto.AppState;
import org.dsi.ifc.androidauto.Resource;
import org.dsi.ifc.androidauto.ServiceConfiguration;
import org.dsi.ifc.androidauto.TouchEvent;

public interface DSIAndroidAutoC {
    public void startService(ServiceConfiguration var1) throws MethodException;

    public void postButtonEvent(int var1, int var2) throws MethodException;

    public void postTouchEvent(int var1, TouchEvent[] var2, int var3, int var4) throws MethodException;

    public void postRotaryEvent(int var1) throws MethodException;

    public void setMode(Resource[] var1, AppState[] var2) throws MethodException;

    public void responseModeChange(Resource[] var1, AppState[] var2) throws MethodException;

    public void requestNightMode(boolean var1) throws MethodException;

    public void setNotification(int[] var1) throws MethodException;

    public void setNotification(int var1) throws MethodException;

    public void setNotification() throws MethodException;

    public void clearNotification(int[] var1) throws MethodException;

    public void clearNotification(int var1) throws MethodException;

    public void clearNotification() throws MethodException;

    public void yySet(String var1, String var2) throws MethodException;
}

