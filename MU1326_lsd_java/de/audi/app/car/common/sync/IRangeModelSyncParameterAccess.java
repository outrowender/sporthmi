/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.car.common.sync;

import de.audi.app.car.common.sync.IRangeModelSyncListener;

public interface IRangeModelSyncParameterAccess {
    public int getAttributeID();

    public int getCurrentValue();

    public int getRangeModelID();

    public int getLastSentValue();

    public void resetRangeModelParameter(IRangeModelSyncListener var1);
}

