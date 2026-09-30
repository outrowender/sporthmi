/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.storage;

import de.audi.atip.storage.IStorageAccess;
import de.audi.atip.storage.IStorageStatistic;
import de.audi.atip.storage.NoSuchDataException;
import de.audi.atip.storage.ProviderFailedException;
import de.audi.tghu.storage.FlushValuesDict;
import de.audi.tghu.storage.StorageProvider;
import de.audi.tghu.storage.StorageStatistic;
import de.esolutions.fw.util.commons.Converter;

public final class StorageAccess
implements IStorageAccess {
    private final StorageProvider storageProvider;
    private final StorageStatistic statistic;
    private boolean dirtyFlag;

    protected StorageAccess(StorageProvider storageProvider, StorageStatistic storageStatistic) {
        this.storageProvider = storageProvider;
        this.statistic = storageStatistic;
        storageProvider.start();
    }

    public IStorageStatistic getStorageStatistic() {
        return this.statistic;
    }

    public boolean getBoolean(int n, int n2, boolean bl) {
        boolean bl2 = bl;
        try {
            this.statistic.readStart(n, n2);
            bl2 = this.storageProvider.getBoolean(n, n2);
            if (this.statistic.isEnabled()) {
                this.statistic.readOK(n, n2, String.valueOf(bl2));
            }
        }
        catch (NoSuchDataException noSuchDataException) {
            this.statistic.readError(noSuchDataException, String.valueOf(bl2));
        }
        return bl2;
    }

    public int getInt(int n, int n2, int n3) {
        int n4 = n3;
        try {
            this.statistic.readStart(n, n2);
            n4 = this.storageProvider.getInt(n, n2);
            if (this.statistic.isEnabled()) {
                this.statistic.readOK(n, n2, Integer.toString(n4));
            }
        }
        catch (NoSuchDataException noSuchDataException) {
            this.statistic.readError(noSuchDataException, Integer.toString(n4));
        }
        return n4;
    }

    public long getLong(int n, int n2, long l) {
        long l2 = l;
        try {
            this.statistic.readStart(n, n2);
            l2 = this.storageProvider.getLong(n, n2);
            if (this.statistic.isEnabled()) {
                this.statistic.readOK(n, n2, Long.toString(l2));
            }
        }
        catch (NoSuchDataException noSuchDataException) {
            this.statistic.readError(noSuchDataException, Long.toString(l2));
        }
        return l2;
    }

    public String getString(int n, int n2, String string) {
        String string2 = string;
        try {
            this.statistic.readStart(n, n2);
            string2 = this.storageProvider.getString(n, n2);
            if (this.statistic.isEnabled()) {
                this.statistic.readOK(n, n2, string2);
            }
        }
        catch (NoSuchDataException noSuchDataException) {
            this.statistic.readError(noSuchDataException, string2);
        }
        if (string2 == null) {
            string2 = string;
        }
        return string2;
    }

    public byte[] getByteArray(int n, int n2, byte[] byArray) {
        byte[] byArray2 = byArray;
        try {
            this.statistic.readStart(n, n2);
            byArray2 = this.storageProvider.getByteArray(n, n2);
            if (this.statistic.isEnabled()) {
                this.statistic.readOK(n, n2, Converter.array2String(byArray2));
            }
        }
        catch (NoSuchDataException noSuchDataException) {
            this.statistic.readError(noSuchDataException, Converter.array2String(byArray2));
        }
        if (byArray2 == null) {
            byArray2 = byArray;
        }
        return byArray2;
    }

    public int[] getIntArray(int n, int n2, int[] nArray) {
        int[] nArray2 = nArray;
        try {
            this.statistic.readStart(n, n2);
            nArray2 = this.storageProvider.getIntArray(n, n2);
            if (this.statistic.isEnabled()) {
                this.statistic.readOK(n, n2, Converter.array2String(nArray2));
            }
        }
        catch (NoSuchDataException noSuchDataException) {
            this.statistic.readError(noSuchDataException, Converter.array2String(nArray2));
        }
        if (nArray2 == null) {
            nArray2 = nArray;
        }
        return nArray2;
    }

    public void setBoolean(int n, int n2, boolean bl) {
        this.setDirtyFlag(n, n2);
        try {
            if (this.statistic.isEnabled()) {
                this.statistic.writeStart(n, n2, String.valueOf(bl));
            }
            this.storageProvider.setBoolean(n, n2, bl);
        }
        catch (ProviderFailedException providerFailedException) {
            this.statistic.writeError(providerFailedException);
        }
    }

    public void setInt(int n, int n2, int n3) {
        this.setDirtyFlag(n, n2);
        try {
            if (this.statistic.isEnabled()) {
                this.statistic.writeStart(n, n2, Integer.toString(n3));
            }
            this.storageProvider.setInt(n, n2, n3);
        }
        catch (ProviderFailedException providerFailedException) {
            this.statistic.writeError(providerFailedException);
        }
    }

    public void setLong(int n, int n2, long l) {
        this.setDirtyFlag(n, n2);
        try {
            if (this.statistic.isEnabled()) {
                this.statistic.writeStart(n, n2, Long.toString(l));
            }
            this.storageProvider.setLong(n, n2, l);
        }
        catch (ProviderFailedException providerFailedException) {
            this.statistic.writeError(providerFailedException);
        }
    }

    public void setString(int n, int n2, String string) {
        this.setDirtyFlag(n, n2);
        try {
            if (this.statistic.isEnabled()) {
                this.statistic.writeStart(n, n2, string);
            }
            this.storageProvider.setString(n, n2, string);
        }
        catch (ProviderFailedException providerFailedException) {
            this.statistic.writeError(providerFailedException);
        }
    }

    public void setByteArray(int n, int n2, byte[] byArray) {
        this.setDirtyFlag(n, n2);
        try {
            if (this.statistic.isEnabled()) {
                this.statistic.writeStart(n, n2, Converter.array2String(byArray));
            }
            this.storageProvider.setByteArray(n, n2, byArray);
        }
        catch (ProviderFailedException providerFailedException) {
            this.statistic.writeError(providerFailedException);
        }
    }

    public void setIntArray(int n, int n2, int[] nArray) {
        this.setDirtyFlag(n, n2);
        try {
            if (this.statistic.isEnabled()) {
                this.statistic.writeStart(n, n2, Converter.array2String(nArray));
            }
            this.storageProvider.setIntArray(n, n2, nArray);
        }
        catch (ProviderFailedException providerFailedException) {
            this.statistic.writeError(providerFailedException);
        }
    }

    public void enterSetupScreen() {
        this.clearDirtyFlag();
    }

    public void exitSetupScreen() {
        if (this.isDirtyFlagSet()) {
            this.storageProvider.flush();
            this.clearDirtyFlag();
        }
    }

    public void startReset2FactorySettings() {
        this.storageProvider.blockFlush();
    }

    public void endReset2FactorySettings() {
        this.storageProvider.unblockFlush();
    }

    private synchronized boolean isDirtyFlagSet() {
        return this.dirtyFlag;
    }

    private synchronized void setDirtyFlag(int n, int n2) {
        if (FlushValuesDict.isSetupScreenFlushRequired(n, n2)) {
            this.dirtyFlag = true;
        }
    }

    private synchronized void clearDirtyFlag() {
        this.dirtyFlag = false;
    }
}

