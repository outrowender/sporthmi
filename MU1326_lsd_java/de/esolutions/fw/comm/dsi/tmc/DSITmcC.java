/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.tmc;

import de.esolutions.fw.comm.core.method.MethodException;

public interface DSITmcC {
    public void requestTmcWindow(int var1, int var2, int var3, int[] var4, int var5) throws MethodException;

    public void setMessageFilter(int var1, int var2) throws MethodException;

    public void getMessageIdsForListElement(long var1) throws MethodException;

    public void getBoundingRectangleForTrafficMessages(long[] var1) throws MethodException;

    public void enableAreaWarnings(boolean var1) throws MethodException;

    public void enableTrafficFlowStatistics(boolean var1) throws MethodException;

    public void setNotification(int[] var1) throws MethodException;

    public void setNotification(int var1) throws MethodException;

    public void setNotification() throws MethodException;

    public void clearNotification(int[] var1) throws MethodException;

    public void clearNotification(int var1) throws MethodException;

    public void clearNotification() throws MethodException;

    public void yySet(String var1, String var2) throws MethodException;
}

