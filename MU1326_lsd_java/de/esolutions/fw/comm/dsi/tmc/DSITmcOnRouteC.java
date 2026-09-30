/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.tmc;

import de.esolutions.fw.comm.core.method.MethodException;

public interface DSITmcOnRouteC {
    public void getTmcMessage(int var1) throws MethodException;

    public void setTmcWarningMode(int var1) throws MethodException;

    public void blockTMCMessages(long[] var1, boolean var2) throws MethodException;

    public void unblockTMCMessages(long[] var1) throws MethodException;

    public void unblockAllTMCMessages() throws MethodException;

    public void setNotification(int[] var1) throws MethodException;

    public void setNotification(int var1) throws MethodException;

    public void setNotification() throws MethodException;

    public void clearNotification(int[] var1) throws MethodException;

    public void clearNotification(int var1) throws MethodException;

    public void clearNotification() throws MethodException;

    public void yySet(String var1, String var2) throws MethodException;
}

