/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.fec;

import de.esolutions.fw.comm.core.method.MethodException;

public interface FecManagerC {
    public void checkDataSignature(String var1, short[] var2, short[] var3) throws MethodException;

    public void fecDetails(long var1, long var3) throws MethodException;

    public void importFecs(int var1) throws MethodException;

    public void exportCCD(int var1) throws MethodException;

    public void getHistory() throws MethodException;

    public void encryptFile(String var1, String var2, byte[] var3) throws MethodException;

    public void decryptFile(String var1, String var2, byte[] var3) throws MethodException;
}

