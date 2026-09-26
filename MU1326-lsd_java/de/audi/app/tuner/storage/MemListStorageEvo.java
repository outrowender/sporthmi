/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.tuner.storage;

import de.audi.atip.log.LogChannel;
import de.audi.atip.storage.IStorageAccess;
import de.audi.tuner.app.Utilities;
import de.audi.tuner.app.memory.AbstractMemoryRow;
import de.audi.tuner.app.storage.AbstractMemListStorage;
import de.audi.tuner.ifc.AbstractListRowFactory;
import de.audi.tuner.ifc.ILogoDatabase;

public class MemListStorageEvo
extends AbstractMemListStorage {
    public MemListStorageEvo(IStorageAccess iStorageAccess, LogChannel logChannel, AbstractListRowFactory abstractListRowFactory) {
        super(iStorageAccess, logChannel, abstractListRowFactory);
    }

    @Override
    protected AbstractMemoryRow[] getDefaultList() {
        return new AbstractMemoryRow[0];
    }

    @Override
    public AbstractMemoryRow[] readList(int n, ILogoDatabase iLogoDatabase) {
        int n2 = this.getKey(n);
        this.setLogoDb(iLogoDatabase);
        return this.doRead(n2);
    }

    @Override
    public void writeList(int n, AbstractMemoryRow[] abstractMemoryRowArray) {
        int n2 = this.getKey(n);
        this.doWrite(abstractMemoryRowArray, n2);
    }

    private int getKey(int n) {
        if (Utilities.isNARBuild() && n == 12) {
            return 338;
        }
        return n == 13 ? 320 : 339;
    }
}

