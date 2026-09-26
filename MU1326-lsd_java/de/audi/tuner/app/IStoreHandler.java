/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app;

import de.audi.tuner.ifc.AbstractRadioListRow;

public interface IStoreHandler {
    default public boolean isStoreModeActive() {
    }

    default public void store(AbstractRadioListRow abstractRadioListRow) {
    }
}

