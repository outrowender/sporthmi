/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.carlife;

import de.esolutions.fw.comm.core.method.MethodException;
import org.dsi.ifc.carlife.AppState;
import org.dsi.ifc.carlife.Resource;
import org.dsi.ifc.carlife.ServiceConfiguration;
import org.dsi.ifc.carlife.TouchEvent;

public interface DSICarlifeC {
    public void startService(ServiceConfiguration var1) throws MethodException;

    public void postButtonEvent(int var1, int var2) throws MethodException;

    public void postTouchEvent(int var1, TouchEvent[] var2, int var3) throws MethodException;

    public void postRotaryEvent(int var1) throws MethodException;

    public void postCharacterEvent(int var1, String[] var2) throws MethodException;

    public void setMode(Resource[] var1, AppState[] var2) throws MethodException;

    public void requestNightMode(boolean var1) throws MethodException;

    public void responseModeChange(Resource[] var1, AppState[] var2) throws MethodException;

    public void setNotification(int[] var1) throws MethodException;

    public void setNotification(int var1) throws MethodException;

    public void setNotification() throws MethodException;

    public void clearNotification(int[] var1) throws MethodException;

    public void clearNotification(int var1) throws MethodException;

    public void clearNotification() throws MethodException;

    public void yySet(String var1, String var2) throws MethodException;
}

