/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.swdl.ude;

import de.audi.atip.storage.IStorageAccess;

public class IEStorage {
    private final IStorageAccess storage;

    protected IEStorage(IStorageAccess iStorageAccess) {
        this.storage = iStorageAccess;
    }

    public boolean load(int n, int n2, boolean bl, String string) {
        return this.storage.getBoolean(n, n2, bl);
    }

    public void save(int n, int n2, boolean bl, String string) {
        this.storage.setBoolean(n, n2, bl);
    }

    public int load(int n, int n2, int n3, String string) {
        return this.storage.getInt(n, n2, n3);
    }

    public long load(int n, int n2, long l, String string) {
        return this.storage.getLong(n, n2, l);
    }

    public void save(int n, int n2, int n3, String string) {
        this.storage.setInt(n, n2, n3);
    }

    public void save(int n, int n2, long l, String string) {
        this.storage.setLong(n, n2, l);
    }

    public int[] load(int n, int n2, int[] nArray, String string) {
        return this.storage.getIntArray(n, n2, nArray);
    }

    public void save(int n, int n2, int[] nArray, String string) {
        this.storage.setIntArray(n, n2, nArray);
    }

    public byte[] load(int n, int n2, byte[] byArray, String string) {
        return this.storage.getByteArray(n, n2, byArray);
    }

    public void save(int n, int n2, byte[] byArray, String string) {
        this.storage.setByteArray(n, n2, byArray);
    }
}

