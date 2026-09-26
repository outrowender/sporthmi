/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.storage;

import de.audi.atip.storage.IStorageStatistic;

public interface IStorageAccess {
    default public void setBoolean(int n, int n2, boolean bl) {
    }

    default public void setByteArray(int n, int n2, byte[] byArray) {
    }

    default public void setInt(int n, int n2, int n3) {
    }

    default public void setLong(int n, int n2, long l) {
    }

    default public void setString(int n, int n2, String string) {
    }

    default public void setIntArray(int n, int n2, int[] nArray) {
    }

    default public boolean getBoolean(int n, int n2, boolean bl) {
    }

    default public int getInt(int n, int n2, int n3) {
    }

    default public long getLong(int n, int n2, long l) {
    }

    default public String getString(int n, int n2, String string) {
    }

    default public byte[] getByteArray(int n, int n2, byte[] byArray) {
    }

    default public int[] getIntArray(int n, int n2, int[] nArray) {
    }

    default public IStorageStatistic getStorageStatistic() {
    }

    default public void enterSetupScreen() {
    }

    default public void exitSetupScreen() {
    }

    default public void startReset2FactorySettings() {
    }

    default public void endReset2FactorySettings() {
    }
}

