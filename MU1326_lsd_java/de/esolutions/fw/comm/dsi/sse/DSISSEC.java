/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.sse;

import de.esolutions.fw.comm.core.method.MethodException;

public interface DSISSEC {
    public void requestSetMode(int var1) throws MethodException;

    public void requestSetMicGainLevel(int var1) throws MethodException;

    public void requestSetMicMuteState(int var1) throws MethodException;

    public void setNotification(int[] var1) throws MethodException;

    public void setNotification(int var1) throws MethodException;

    public void setNotification() throws MethodException;

    public void clearNotification(int[] var1) throws MethodException;

    public void clearNotification(int var1) throws MethodException;

    public void clearNotification() throws MethodException;

    public void yySet(String var1, String var2) throws MethodException;
}

