/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.predictivenav;

import org.dsi.ifc.predictivenavigation.LikelyDestination;

public interface IPredictiveNavModelAccess {
    public static final int PREDICTIVE_NAVIGATION_RESULTS_INVISIBLE = 0;
    public static final int PREDICTIVE_NAVIGATION_RESULTS_VISIBLE = 1;
    public static final int PREDICTIVE_NAVIGATION_STATUSBAR_INVISIBLE = 0;
    public static final int PREDICTIVE_NAVIGATION_STATUSBAR_VISIBLE = 1;

    public void updateSelection(LikelyDestination[] var1);

    public void clearLikelyDestinations();

    public int getPredictiveRouteListLength();

    public void updateOperationModeModels(boolean var1);
}

