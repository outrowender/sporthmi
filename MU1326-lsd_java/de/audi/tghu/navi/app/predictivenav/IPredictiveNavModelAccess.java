/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.predictivenav;

import org.dsi.ifc.predictivenavigation.LikelyDestination;

public interface IPredictiveNavModelAccess {
    public static final int PREDICTIVE_NAVIGATION_RESULTS_INVISIBLE;
    public static final int PREDICTIVE_NAVIGATION_RESULTS_VISIBLE;
    public static final int PREDICTIVE_NAVIGATION_STATUSBAR_INVISIBLE;
    public static final int PREDICTIVE_NAVIGATION_STATUSBAR_VISIBLE;

    default public void updateSelection(LikelyDestination[] likelyDestinationArray) {
    }

    default public void clearLikelyDestinations() {
    }

    default public int getPredictiveRouteListLength() {
    }

    default public void updateOperationModeModels(boolean bl) {
    }
}

