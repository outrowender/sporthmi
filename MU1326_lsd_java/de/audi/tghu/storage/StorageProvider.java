/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.storage;

import de.audi.atip.storage.ProviderFailedException;
import de.audi.atip.storage.ValueMissingException;

interface StorageProvider {
    public void start();

    public void stop();

    public void flush();

    public boolean getBoolean(int var1, int var2);

    public byte[] getByteArray(int var1, int var2) throws ValueMissingException, ProviderFailedException;

    public int[] getIntArray(int var1, int var2) throws ValueMissingException, ProviderFailedException;

    public int getInt(int var1, int var2);

    public long getLong(int var1, int var2) throws UnsupportedOperationException;

    public String getString(int var1, int var2) throws UnsupportedOperationException;

    public void setBoolean(int var1, int var2, boolean var3) throws UnsupportedOperationException;

    public void setInt(int var1, int var2, int var3) throws UnsupportedOperationException;

    public void setLong(int var1, int var2, long var3) throws UnsupportedOperationException;

    public void setString(int var1, int var2, String var3) throws UnsupportedOperationException;

    public void setIntArray(int var1, int var2, int[] var3) throws ProviderFailedException;

    public void setByteArray(int var1, int var2, byte[] var3) throws ProviderFailedException;

    public void blockFlush();

    public void unblockFlush();
}

