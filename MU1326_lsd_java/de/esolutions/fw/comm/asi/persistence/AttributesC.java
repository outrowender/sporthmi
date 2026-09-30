/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.persistence;

import de.esolutions.fw.comm.core.method.MethodException;

public interface AttributesC {
    public void subscribe(long[] var1, long[] var2) throws MethodException;

    public void unsubscribe(long[] var1, long[] var2) throws MethodException;

    public void unsubscribeAll() throws MethodException;

    public void putInts(long[] var1, long[] var2, int[] var3) throws MethodException;

    public void putStrings(long[] var1, long[] var2, String[] var3) throws MethodException;

    public void putBlobs(long[] var1, long[] var2, short[][] var3) throws MethodException;
}

