/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.setup;

import de.audi.tghu.navi.app.setup.IRouteCriteria;

public interface IRouteCriteriaManager {
    default public void persistState() {
    }

    default public IRouteCriteria getRouteCriteria() {
    }

    default public void setRouteCriteria(IRouteCriteria iRouteCriteria) {
    }

    default public void resetSettings() {
    }
}

