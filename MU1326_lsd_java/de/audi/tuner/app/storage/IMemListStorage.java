/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app.storage;

import de.audi.tuner.app.memory.AbstractMemoryRow;
import de.audi.tuner.ifc.ILogoDatabase;

public interface IMemListStorage {
    default public AbstractMemoryRow[] readList(int n, ILogoDatabase iLogoDatabase) {
    }

    default public void writeList(int n, AbstractMemoryRow[] abstractMemoryRowArray) {
    }

    default public void setPreferredImgType(int n) {
    }
}

