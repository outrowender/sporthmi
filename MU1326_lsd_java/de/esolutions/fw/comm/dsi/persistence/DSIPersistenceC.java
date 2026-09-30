/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.persistence;

import de.esolutions.fw.comm.core.method.MethodException;

public interface DSIPersistenceC {
    public void writeInt(int var1, long var2, int var4) throws MethodException;

    public void readInt(int var1, long var2) throws MethodException;

    public void readIntTimeout(int var1, long var2, int var4) throws MethodException;

    public void writeBuffer(int var1, long var2, byte[] var4) throws MethodException;

    public void readBuffer(int var1, long var2) throws MethodException;

    public void readBufferTimeout(int var1, long var2, int var4) throws MethodException;

    public void writeString(int var1, long var2, String var4) throws MethodException;

    public void readString(int var1, long var2) throws MethodException;

    public void readStringTimeout(int var1, long var2, int var4) throws MethodException;

    public void writeArray(int var1, long var2, int[] var4) throws MethodException;

    public void readArray(int var1, long var2) throws MethodException;

    public void readArrayTimeout(int var1, long var2, int var4) throws MethodException;

    public void writeStringArray(int var1, long var2, String[] var4) throws MethodException;

    public void readStringArray(int var1, long var2) throws MethodException;

    public void readStringArrayTimeout(int var1, long var2, int var4) throws MethodException;

    public void enterEngineeringSession(int var1) throws MethodException;

    public void exitEngineeringSession(int var1) throws MethodException;

    public void getVisibleSystemLanguages() throws MethodException;

    public void flushSQLDatabase() throws MethodException;

    public void setSQLDatabaseMedium(int var1) throws MethodException;

    public void beginTransaction(int var1) throws MethodException;

    public void endTransaction(int var1, boolean var2) throws MethodException;

    public void subscribe(int var1, int[] var2, long[] var3, int var4) throws MethodException;

    public void unsubscribe(int var1, int[] var2, long[] var3) throws MethodException;

    public void unsubscribeAll(int var1) throws MethodException;

    public void setNotification(int[] var1) throws MethodException;

    public void setNotification(int var1) throws MethodException;

    public void setNotification() throws MethodException;

    public void clearNotification(int[] var1) throws MethodException;

    public void clearNotification(int var1) throws MethodException;

    public void clearNotification() throws MethodException;

    public void yySet(String var1, String var2) throws MethodException;
}

