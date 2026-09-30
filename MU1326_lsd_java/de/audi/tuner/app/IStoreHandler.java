/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app;

import de.audi.tuner.ifc.AbstractRadioListRow;

public interface IStoreHandler {
    public boolean isStoreModeActive();

    public void store(AbstractRadioListRow var1);
}

