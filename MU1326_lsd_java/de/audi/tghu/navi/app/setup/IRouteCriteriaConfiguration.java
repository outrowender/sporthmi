/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.setup;

import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.setup.IRouteCriteria;

public interface IRouteCriteriaConfiguration {
    default public void initRouteCriteria(IRouteCriteria iRouteCriteria) {
    }

    default public void checkForRegionConsistency(IRouteCriteria iRouteCriteria) {
    }

    default public void checkForEncodedTrailer(IRouteCriteria iRouteCriteria, NavigationEnv navigationEnv) {
    }
}

