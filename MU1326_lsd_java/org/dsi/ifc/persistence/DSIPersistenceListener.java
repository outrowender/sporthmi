/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.persistence;

import org.dsi.ifc.base.DSIListener;

public interface DSIPersistenceListener
extends DSIListener {
    public void updateActiveSQLDatabaseMedium(int var1, int var2);

    public void writeInt(int var1, long var2, int var4);

    public void readInt(int var1, long var2, int var4, int var5);

    public void writeBuffer(int var1, long var2, int var4);

    public void readBuffer(int var1, long var2, byte[] var4, int var5);

    public void writeString(int var1, long var2, int var4);

    public void readString(int var1, long var2, String var4, int var5);

    public void writeArray(int var1, long var2, int var4);

    public void readArray(int var1, long var2, int[] var4, int var5);

    public void writeStringArray(int var1, long var2, int var4);

    public void readStringArray(int var1, long var2, String[] var4, int var5);

    public void getVisibleSystemLanguages(String var1);

    public void flushSQLDatabase(int var1);

    public void beginTransaction(int var1, int var2);

    public void endTransaction(int var1, int var2);

    public void valueChangedInt(int var1, long var2, int var4, int var5);

    public void valueChangedString(int var1, long var2, String var4, int var5);

    public void valueChangedArray(int var1, long var2, int[] var4, int var5);

    public void valueChangedStringArray(int var1, long var2, String[] var4, int var5);

    public void valueChangedBuffer(int var1, long var2, byte[] var4, int var5);

    public void unsubscribe(int var1, int[] var2, long[] var3, int[] var4);
}

