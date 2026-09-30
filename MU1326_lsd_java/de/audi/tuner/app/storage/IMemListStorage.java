/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app.storage;

import de.audi.tuner.app.memory.AbstractMemoryRow;
import de.audi.tuner.ifc.ILogoDatabase;

public interface IMemListStorage {
    public AbstractMemoryRow[] readList(int var1, ILogoDatabase var2);

    public void writeList(int var1, AbstractMemoryRow[] var2);

    public void setPreferredImgType(int var1);
}

