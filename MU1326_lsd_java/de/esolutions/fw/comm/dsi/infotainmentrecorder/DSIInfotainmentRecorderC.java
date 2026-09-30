/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.infotainmentrecorder;

import de.esolutions.fw.comm.core.method.MethodException;

public interface DSIInfotainmentRecorderC {
    public void logPanelName(String var1) throws MethodException;

    public void logKeyEvent(int var1, int var2, int var3) throws MethodException;

    public void backupTrigger(int var1) throws MethodException;

    public void enableTrigger(boolean var1, int var2) throws MethodException;

    public void logInit() throws MethodException;

    public void setNotification(int[] var1) throws MethodException;

    public void setNotification(int var1) throws MethodException;

    public void setNotification() throws MethodException;

    public void clearNotification(int[] var1) throws MethodException;

    public void clearNotification(int var1) throws MethodException;

    public void clearNotification() throws MethodException;

    public void yySet(String var1, String var2) throws MethodException;
}

