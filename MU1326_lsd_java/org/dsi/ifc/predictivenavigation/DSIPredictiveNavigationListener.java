/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.predictivenavigation;

import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.predictivenavigation.LikelyDestination;

public interface DSIPredictiveNavigationListener
extends DSIListener {
    public void updateOperationMode(int var1, int var2);

    public void updateLikelyDestinations(LikelyDestination[] var1, int var2);

    public void updateMaxPredictions(int var1, int var2);

    public void clearCacheResult();
}

