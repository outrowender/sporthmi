/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.persistence;

import de.esolutions.fw.comm.core.method.MethodException;
import de.esolutions.fw.comm.persistence.PartitionHandle;

public interface IPersistenceAReply {
    public static final String IPL_COMM_UUID = "f4ac6df9-a35a-4f1c-a334-9c2890a41c09";
    public static final String IPL_COMM_INTERFACE_KEY = "21034d62-3469-5d3a-b904-de8a9709a4ed";
    public static final String IPL_COMM_INTERFACE_VERSION = "1.3.0";
    public static final String IPL_COMM_MODULE_VERSION = "1.3.0";

    public void openResult(long var1, String var3, PartitionHandle var4, int var5) throws MethodException;

    public void openResult(String var1, String var2, PartitionHandle var3, int var4) throws MethodException;

    public void closeResult(PartitionHandle var1, int var2) throws MethodException;

    public void versionResult(long var1, String var3, int var4) throws MethodException;

    public void versionResult(String var1, String var2, int var3) throws MethodException;

    public void purgeResult(long var1, int var3) throws MethodException;

    public void purgeResult(String var1, int var2) throws MethodException;

    public void beginTransactionResult(PartitionHandle var1, int var2) throws MethodException;

    public void endTransactionResult(PartitionHandle var1, int var2) throws MethodException;

    public void flushResult(PartitionHandle var1, int var2) throws MethodException;

    public void existsResult(PartitionHandle var1, long var2, int var4) throws MethodException;

    public void removeResult(PartitionHandle var1, long var2, int var4) throws MethodException;

    public void getIntResult(PartitionHandle var1, long var2, long var4, int var6) throws MethodException;

    public void getIntsResult(PartitionHandle var1, long[] var2, long[] var3, int[] var4) throws MethodException;

    public void getStringResult(PartitionHandle var1, long var2, String var4, int var5) throws MethodException;

    public void getStringsResult(PartitionHandle var1, long[] var2, String[] var3, int[] var4) throws MethodException;

    public void getBlobResult(PartitionHandle var1, long var2, short[] var4, int var5) throws MethodException;

    public void getBlobsResult(PartitionHandle var1, long[] var2, short[][] var3, int[] var4) throws MethodException;

    public void setResult(PartitionHandle var1, long var2, int var4) throws MethodException;

    public void unsubscribeResult(PartitionHandle var1, long[] var2, int[] var3) throws MethodException;

    public void stringValues(PartitionHandle var1, long[] var2, String[] var3, int[] var4) throws MethodException;

    public void intValues(PartitionHandle var1, long[] var2, long[] var3, int[] var4) throws MethodException;

    public void blobValues(PartitionHandle var1, long[] var2, short[][] var3, int[] var4) throws MethodException;

    public void convertResult(long var1, String var3, String var4, PartitionHandle var5, int var6) throws MethodException;

    public void convertResult(String var1, String var2, String var3, PartitionHandle var4, int var5) throws MethodException;
}

