/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.setup;

import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.setup.IRouteCriteria;

public interface IRouteCriteriaConfiguration {
    public void initRouteCriteria(IRouteCriteria var1);

    public void checkForRegionConsistency(IRouteCriteria var1);

    public void checkForEncodedTrailer(IRouteCriteria var1, NavigationEnv var2);
}

