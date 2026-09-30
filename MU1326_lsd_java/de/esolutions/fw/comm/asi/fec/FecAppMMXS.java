/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.fec;

import de.esolutions.fw.comm.asi.fec.FecAppMMXReply;
import de.esolutions.fw.comm.core.method.MethodException;

public interface FecAppMMXS {
    public void registerForFec(int var1, FecAppMMXReply var2) throws MethodException;

    public void checkPkgSignature(String var1, short[] var2, short[] var3, FecAppMMXReply var4) throws MethodException;
}

