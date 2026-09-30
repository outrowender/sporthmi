/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.carplay;

import de.esolutions.fw.comm.core.method.MethodException;
import org.dsi.ifc.carplay.AppState;
import org.dsi.ifc.carplay.AppStateRequest;
import org.dsi.ifc.carplay.Resource;
import org.dsi.ifc.carplay.ResourceRequest;
import org.dsi.ifc.carplay.ServiceConfiguration;
import org.dsi.ifc.carplay.TouchEvent;

public interface DSICarplayC {
    public void startService(ServiceConfiguration var1) throws MethodException;

    public void postButtonEvent(int var1, int var2) throws MethodException;

    public void postTouchEvent(int var1, int var2, TouchEvent[] var3) throws MethodException;

    public void postRotaryEvent(int var1) throws MethodException;

    public void postCharacterEvent(int var1, String[] var2) throws MethodException;

    public void requestModeChange(ResourceRequest[] var1, AppStateRequest[] var2, String var3) throws MethodException;

    public void responseUpdateMode(Resource[] var1, AppState[] var2) throws MethodException;

    public void responseBTDeactivation() throws MethodException;

    public void requestUI(int var1) throws MethodException;

    public void requestNightMode(boolean var1) throws MethodException;

    public void requestSIRIAction(int var1) throws MethodException;

    public void responseUpdateMainAudioType(int var1) throws MethodException;

    public void requestUI2(String var1) throws MethodException;

    public void setNotification(int[] var1) throws MethodException;

    public void setNotification(int var1) throws MethodException;

    public void setNotification() throws MethodException;

    public void clearNotification(int[] var1) throws MethodException;

    public void clearNotification(int var1) throws MethodException;

    public void clearNotification() throws MethodException;

    public void yySet(String var1, String var2) throws MethodException;
}

