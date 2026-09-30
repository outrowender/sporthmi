/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.fec;

import de.esolutions.fw.comm.core.method.MethodException;

public interface FecAppMMXC {
    public void registerForFec(int var1) throws MethodException;

    public void checkPkgSignature(String var1, short[] var2, short[] var3) throws MethodException;
}

