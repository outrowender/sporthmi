/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.swdlprogress;

import de.esolutions.fw.comm.core.method.MethodException;

public interface DSISwdlProgressC {
    public void getProgressDetails(String var1) throws MethodException;

    public void handleUserSelection(int var1, String var2, int var3) throws MethodException;

    public void handleMediumSelection(int var1, String var2, byte var3, int var4) throws MethodException;

    public void setNotification(int[] var1) throws MethodException;

    public void setNotification(int var1) throws MethodException;

    public void setNotification() throws MethodException;

    public void clearNotification(int[] var1) throws MethodException;

    public void clearNotification(int var1) throws MethodException;

    public void clearNotification() throws MethodException;

    public void yySet(String var1, String var2) throws MethodException;
}

