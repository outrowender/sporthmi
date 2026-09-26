/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.storage;

interface StorageProvider {
    default public void start() {
    }

    default public void stop() {
    }

    default public void flush() {
    }

    default public boolean getBoolean(int n, int n2) {
    }

    default public byte[] getByteArray(int n, int n2) {
    }

    default public int[] getIntArray(int n, int n2) {
    }

    default public int getInt(int n, int n2) {
    }

    default public long getLong(int n, int n2) {
    }

    default public String getString(int n, int n2) {
    }

    default public void setBoolean(int n, int n2, boolean bl) {
    }

    default public void setInt(int n, int n2, int n3) {
    }

    default public void setLong(int n, int n2, long l) {
    }

    default public void setString(int n, int n2, String string) {
    }

    default public void setIntArray(int n, int n2, int[] nArray) {
    }

    default public void setByteArray(int n, int n2, byte[] byArray) {
    }

    default public void blockFlush() {
    }

    default public void unblockFlush() {
    }
}

