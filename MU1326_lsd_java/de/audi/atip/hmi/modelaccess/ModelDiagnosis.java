/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.hmi.modelaccess;

import de.audi.atip.hmi.model.AbstractModel;

public interface ModelDiagnosis {
    public AbstractModel getActiveModel();

    public AbstractModel getInactiveModel();

    public boolean isTransactionRunning();
}

