/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.car.common.sync;

import de.audi.app.car.common.sync.IRangeModelSyncParameterAccess;

public interface IRangeModelSyncListener {
    public void setDSIParameter(IRangeModelSyncParameterAccess var1);

    public void updateRangeModelByTurningRotary(IRangeModelSyncParameterAccess var1);

    public void updateRangeModelByDSINotitification(IRangeModelSyncParameterAccess var1);
}

