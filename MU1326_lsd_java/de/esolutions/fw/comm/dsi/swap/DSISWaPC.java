/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.swap;

import de.esolutions.fw.comm.core.method.MethodException;

public interface DSISWaPC {
    public void encryptFile(String var1, String var2, byte[] var3) throws MethodException;

    public void checkSignature(String var1, short[] var2, int var3, long var4) throws MethodException;

    public void getPublicKey() throws MethodException;

    public void checkSingleFsc(int var1) throws MethodException;

    public void decryptFile(String var1, String var2, byte[] var3) throws MethodException;

    public void getFscDetails(int var1, int var2, int var3) throws MethodException;

    public void triggerSoftwareEnabling() throws MethodException;

    public void importFSCs(int var1) throws MethodException;

    public void exportCCD(int var1) throws MethodException;

    public void getHistory() throws MethodException;

    public void setNotification(int[] var1) throws MethodException;

    public void setNotification(int var1) throws MethodException;

    public void setNotification() throws MethodException;

    public void clearNotification(int[] var1) throws MethodException;

    public void clearNotification(int var1) throws MethodException;

    public void clearNotification() throws MethodException;

    public void yySet(String var1, String var2) throws MethodException;
}

