/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.persistence;

import de.esolutions.fw.comm.core.method.MethodException;

public interface DSIPersistenceReply {
    public static final String IPL_COMM_UUID = "41cba447-eba6-5c69-b37a-27fd8427a88a";
    public static final String IPL_COMM_INTERFACE_KEY = "b20e710c-fdb9-55ad-a946-afba7a636c2a";
    public static final String IPL_COMM_INTERFACE_VERSION = "2.11.6";
    public static final String IPL_COMM_MODULE_VERSION = "2.11.6";

    public void updateActiveSQLDatabaseMedium(int var1, int var2) throws MethodException;

    public void writeInt(int var1, long var2, int var4) throws MethodException;

    public void readInt(int var1, long var2, int var4, int var5) throws MethodException;

    public void writeBuffer(int var1, long var2, int var4) throws MethodException;

    public void readBuffer(int var1, long var2, byte[] var4, int var5) throws MethodException;

    public void writeString(int var1, long var2, int var4) throws MethodException;

    public void readString(int var1, long var2, String var4, int var5) throws MethodException;

    public void writeArray(int var1, long var2, int var4) throws MethodException;

    public void readArray(int var1, long var2, int[] var4, int var5) throws MethodException;

    public void writeStringArray(int var1, long var2, int var4) throws MethodException;

    public void readStringArray(int var1, long var2, String[] var4, int var5) throws MethodException;

    public void getVisibleSystemLanguages(String var1) throws MethodException;

    public void flushSQLDatabase(int var1) throws MethodException;

    public void beginTransaction(int var1, int var2) throws MethodException;

    public void endTransaction(int var1, int var2) throws MethodException;

    public void valueChangedInt(int var1, long var2, int var4, int var5) throws MethodException;

    public void valueChangedString(int var1, long var2, String var4, int var5) throws MethodException;

    public void valueChangedArray(int var1, long var2, int[] var4, int var5) throws MethodException;

    public void valueChangedStringArray(int var1, long var2, String[] var4, int var5) throws MethodException;

    public void valueChangedBuffer(int var1, long var2, byte[] var4, int var5) throws MethodException;

    public void unsubscribe(int var1, int[] var2, long[] var3, int[] var4) throws MethodException;

    public void asyncException(int var1, String var2, int var3) throws MethodException;

    public void yyIndication(String var1, String var2) throws MethodException;
}

