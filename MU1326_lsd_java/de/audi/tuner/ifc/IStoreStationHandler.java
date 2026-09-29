/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.ifc;

import de.audi.tuner.app.TunerObjectContainer;

public interface IStoreStationHandler {
    public static final int TOGGLE_OP_REMOVED;
    public static final int TOGGLE_OP_ADDED;
    public static final int TOGGLE_OP_ERROR;

    default public boolean prepareStore(int n, TunerObjectContainer tunerObjectContainer) {
    }

    default public int toggleStore(TunerObjectContainer tunerObjectContainer) {
    }

    default public boolean isStored(TunerObjectContainer tunerObjectContainer) {
    }
}

