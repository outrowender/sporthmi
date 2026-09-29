/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.car.common.sync;

import de.audi.app.car.common.sync.IRangeModelSyncParameterAccess;

public interface IRangeModelSyncListener {
    default public void setDSIParameter(IRangeModelSyncParameterAccess iRangeModelSyncParameterAccess) {
    }

    default public void updateRangeModelByTurningRotary(IRangeModelSyncParameterAccess iRangeModelSyncParameterAccess) {
    }

    default public void updateRangeModelByDSINotitification(IRangeModelSyncParameterAccess iRangeModelSyncParameterAccess) {
    }
}

