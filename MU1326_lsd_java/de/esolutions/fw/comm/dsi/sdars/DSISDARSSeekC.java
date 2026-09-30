/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.sdars;

import de.esolutions.fw.comm.core.method.MethodException;

public interface DSISDARSSeekC {
    public void setSeekCommand(int var1, int var2, int var3) throws MethodException;

    public void manageSeek(int var1, int var2) throws MethodException;

    public void manageSeek2(int var1, int var2, int var3, int var4) throws MethodException;

    public void getTeamsOfLeague(int var1) throws MethodException;

    public void getLeagues() throws MethodException;

    public void reset(int var1) throws MethodException;

    public void profileChange(int var1) throws MethodException;

    public void profileCopy(int var1, int var2) throws MethodException;

    public void profileReset(int var1) throws MethodException;

    public void profileResetAll() throws MethodException;

    public void setNotification(int[] var1) throws MethodException;

    public void setNotification(int var1) throws MethodException;

    public void setNotification() throws MethodException;

    public void clearNotification(int[] var1) throws MethodException;

    public void clearNotification(int var1) throws MethodException;

    public void clearNotification() throws MethodException;

    public void yySet(String var1, String var2) throws MethodException;
}

