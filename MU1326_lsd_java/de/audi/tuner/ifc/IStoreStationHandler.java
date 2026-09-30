/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.ifc;

import de.audi.tuner.app.TunerObjectContainer;

public interface IStoreStationHandler {
    public static final int TOGGLE_OP_REMOVED = 0;
    public static final int TOGGLE_OP_ADDED = 1;
    public static final int TOGGLE_OP_ERROR = -1;

    public boolean prepareStore(int var1, TunerObjectContainer var2);

    public int toggleStore(TunerObjectContainer var1);

    public boolean isStored(TunerObjectContainer var1);
}

