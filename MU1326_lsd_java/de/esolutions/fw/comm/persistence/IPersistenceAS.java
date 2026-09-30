/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.persistence;

import de.esolutions.fw.comm.core.method.MethodException;
import de.esolutions.fw.comm.persistence.IPersistenceAReply;
import de.esolutions.fw.comm.persistence.PartitionHandle;

public interface IPersistenceAS {
    public void open(long var1, String var3, IPersistenceAReply var4) throws MethodException;

    public void open(String var1, String var2, IPersistenceAReply var3) throws MethodException;

    public void close(PartitionHandle var1, IPersistenceAReply var2) throws MethodException;

    public void version(long var1, IPersistenceAReply var3) throws MethodException;

    public void version(String var1, IPersistenceAReply var2) throws MethodException;

    public void purge(long var1, IPersistenceAReply var3) throws MethodException;

    public void purge(String var1, IPersistenceAReply var2) throws MethodException;

    public void beginTransaction(PartitionHandle var1, IPersistenceAReply var2) throws MethodException;

    public void endTransaction(PartitionHandle var1, boolean var2, IPersistenceAReply var3) throws MethodException;

    public void endTransaction(PartitionHandle var1, IPersistenceAReply var2) throws MethodException;

    public void flush(PartitionHandle var1, IPersistenceAReply var2) throws MethodException;

    public void exists(PartitionHandle var1, long var2, IPersistenceAReply var4) throws MethodException;

    public void remove(PartitionHandle var1, long var2, IPersistenceAReply var4) throws MethodException;

    public void setInt(PartitionHandle var1, long var2, long var4, IPersistenceAReply var6) throws MethodException;

    public void getInt(PartitionHandle var1, long var2, int var4, IPersistenceAReply var5) throws MethodException;

    public void getInt(PartitionHandle var1, long var2, IPersistenceAReply var4) throws MethodException;

    public void getInts(PartitionHandle var1, long[] var2, int var3, IPersistenceAReply var4) throws MethodException;

    public void getInts(PartitionHandle var1, long[] var2, IPersistenceAReply var3) throws MethodException;

    public void setString(PartitionHandle var1, long var2, String var4, IPersistenceAReply var5) throws MethodException;

    public void getString(PartitionHandle var1, long var2, int var4, IPersistenceAReply var5) throws MethodException;

    public void getString(PartitionHandle var1, long var2, IPersistenceAReply var4) throws MethodException;

    public void getStrings(PartitionHandle var1, long[] var2, int var3, IPersistenceAReply var4) throws MethodException;

    public void getStrings(PartitionHandle var1, long[] var2, IPersistenceAReply var3) throws MethodException;

    public void setBlob(PartitionHandle var1, long var2, short[] var4, IPersistenceAReply var5) throws MethodException;

    public void getBlob(PartitionHandle var1, long var2, int var4, IPersistenceAReply var5) throws MethodException;

    public void getBlob(PartitionHandle var1, long var2, IPersistenceAReply var4) throws MethodException;

    public void getBlobs(PartitionHandle var1, long[] var2, int var3, IPersistenceAReply var4) throws MethodException;

    public void getBlobs(PartitionHandle var1, long[] var2, IPersistenceAReply var3) throws MethodException;

    public void subscribe(PartitionHandle var1, long[] var2, int var3, IPersistenceAReply var4) throws MethodException;

    public void subscribe(PartitionHandle var1, long[] var2, IPersistenceAReply var3) throws MethodException;

    public void unsubscribe(PartitionHandle var1, long[] var2, IPersistenceAReply var3) throws MethodException;

    public void unsubscribeAll(PartitionHandle var1, IPersistenceAReply var2) throws MethodException;

    public void convert(long var1, String var3, String var4, IPersistenceAReply var5) throws MethodException;

    public void convert(String var1, String var2, String var3, IPersistenceAReply var4) throws MethodException;
}

