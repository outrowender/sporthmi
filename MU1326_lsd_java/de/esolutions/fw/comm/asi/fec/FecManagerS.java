/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.fec;

import de.esolutions.fw.comm.asi.fec.FecManagerReply;
import de.esolutions.fw.comm.core.method.MethodException;

public interface FecManagerS {
    public void checkDataSignature(String var1, short[] var2, short[] var3, FecManagerReply var4) throws MethodException;

    public void fecDetails(long var1, long var3, FecManagerReply var5) throws MethodException;

    public void importFecs(int var1, FecManagerReply var2) throws MethodException;

    public void exportCCD(int var1, FecManagerReply var2) throws MethodException;

    public void getHistory(FecManagerReply var1) throws MethodException;

    public void encryptFile(String var1, String var2, byte[] var3, FecManagerReply var4) throws MethodException;

    public void decryptFile(String var1, String var2, byte[] var3, FecManagerReply var4) throws MethodException;
}

