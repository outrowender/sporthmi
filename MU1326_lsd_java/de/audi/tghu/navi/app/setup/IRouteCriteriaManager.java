/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.setup;

import de.audi.tghu.navi.app.setup.IRouteCriteria;

public interface IRouteCriteriaManager {
    public void persistState();

    public IRouteCriteria getRouteCriteria();

    public void setRouteCriteria(IRouteCriteria var1);

    public void resetSettings();
}

