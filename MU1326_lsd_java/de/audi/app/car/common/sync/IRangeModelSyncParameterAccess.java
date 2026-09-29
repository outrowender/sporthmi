/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.car.common.sync;

import de.audi.app.car.common.sync.IRangeModelSyncListener;

public interface IRangeModelSyncParameterAccess {
    default public int getAttributeID() {
    }

    default public int getCurrentValue() {
    }

    default public int getRangeModelID() {
    }

    default public int getLastSentValue() {
    }

    default public void resetRangeModelParameter(IRangeModelSyncListener iRangeModelSyncListener) {
    }
}

