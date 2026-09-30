/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.navigation;

import de.esolutions.fw.comm.core.method.MethodException;

public interface DSICombinedRouteListC {
    public void requestCombinedRouteListWindow(int var1, int var2, long[] var3, long var4) throws MethodException;

    public void requestTrafficInformation(long var1) throws MethodException;

    public void requestPOIInformation(long var1) throws MethodException;

    public void getBoundingRectangleOfCombinedRouteListElements(long[] var1) throws MethodException;

    public void requestPriceInfo(long var1) throws MethodException;

    public void setNotification(int[] var1) throws MethodException;

    public void setNotification(int var1) throws MethodException;

    public void setNotification() throws MethodException;

    public void clearNotification(int[] var1) throws MethodException;

    public void clearNotification(int var1) throws MethodException;

    public void clearNotification() throws MethodException;

    public void yySet(String var1, String var2) throws MethodException;
}

