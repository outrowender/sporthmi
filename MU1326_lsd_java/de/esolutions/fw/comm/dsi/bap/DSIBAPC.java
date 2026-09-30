/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.bap;

import de.esolutions.fw.comm.core.method.MethodException;

public interface DSIBAPC {
    public void getBAPState(int var1) throws MethodException;

    public void setHMIState(int var1, int var2) throws MethodException;

    public void request(int var1, int var2, int var3, int var4, int var5) throws MethodException;

    public void requestVoid(int var1, int var2, int var3) throws MethodException;

    public void requestByteSequence(int var1, int var2, int var3, byte[] var4) throws MethodException;

    public void requestError(int var1, int var2, int var3) throws MethodException;

    public void setNotification(int[] var1) throws MethodException;

    public void setNotification(int var1) throws MethodException;

    public void setNotification() throws MethodException;

    public void clearNotification(int[] var1) throws MethodException;

    public void clearNotification(int var1) throws MethodException;

    public void clearNotification() throws MethodException;

    public void yySet(String var1, String var2) throws MethodException;
}

