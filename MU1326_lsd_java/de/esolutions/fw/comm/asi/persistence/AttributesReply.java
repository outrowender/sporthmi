/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.persistence;

import de.esolutions.fw.comm.core.method.MethodException;

public interface AttributesReply {
    public static final String IPL_COMM_UUID = "f423654f-fed2-59d3-be18-59e9a9b2d05f";
    public static final String IPL_COMM_INTERFACE_KEY = "e5e426dc-4f2a-56e5-9b1b-8beaf406be7a";
    public static final String IPL_COMM_INTERFACE_VERSION = "0.0.3";
    public static final String IPL_COMM_MODULE_VERSION = "0.0.3";

    public void unsubscribeResults(long[] var1, long[] var2, int[] var3) throws MethodException;

    public void stringValues(long[] var1, long[] var2, String[] var3, int[] var4) throws MethodException;

    public void intValues(long[] var1, long[] var2, int[] var3, int[] var4) throws MethodException;

    public void blobValues(long[] var1, long[] var2, short[][] var3, int[] var4) throws MethodException;

    public void putResults(long[] var1, long[] var2, int[] var3) throws MethodException;
}

