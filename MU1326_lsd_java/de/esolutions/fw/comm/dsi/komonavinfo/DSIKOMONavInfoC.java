/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.komonavinfo;

import de.esolutions.fw.comm.core.method.MethodException;

public interface DSIKOMONavInfoC {
    public void setDistanceToNextManeuver(long var1, int var3, boolean var4) throws MethodException;

    public void setETA(int var1, short var2, short var3, short var4, boolean var5, boolean var6) throws MethodException;

    public void setCurrentStreet(String var1) throws MethodException;

    public void setTurnToStreet(String var1, String var2) throws MethodException;

    public void setCityName(String var1) throws MethodException;

    public void setDistanceToDestination(long var1, int var3, boolean var4) throws MethodException;

    public void setSemiDynRoute(boolean var1) throws MethodException;

    public void setTrafficOffset(int var1, short var2, short var3, short var4, boolean var5) throws MethodException;

    public void setRTT(short var1, short var2, boolean var3) throws MethodException;

    public void setRgSelect(int var1) throws MethodException;

    public void setCapabilities(boolean[] var1) throws MethodException;

    public void setMapScale(int var1, int var2, boolean[] var3, int var4, int var5, int var6) throws MethodException;

    public void setMapScaleResult(int var1, int var2, boolean[] var3, int var4, int var5, boolean[] var6, boolean var7) throws MethodException;

    public void setNotification(int[] var1) throws MethodException;

    public void setNotification(int var1) throws MethodException;

    public void setNotification() throws MethodException;

    public void clearNotification(int[] var1) throws MethodException;

    public void clearNotification(int var1) throws MethodException;

    public void clearNotification() throws MethodException;

    public void yySet(String var1, String var2) throws MethodException;
}

