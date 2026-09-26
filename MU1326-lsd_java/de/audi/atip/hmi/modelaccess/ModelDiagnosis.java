/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.hmi.modelaccess;

import de.audi.atip.hmi.model.AbstractModel;

public interface ModelDiagnosis {
    default public AbstractModel getActiveModel() {
    }

    default public AbstractModel getInactiveModel() {
    }

    default public boolean isTransactionRunning() {
    }
}

