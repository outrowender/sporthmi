/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.predictivenav;

import de.audi.tghu.navi.app.predictivenav.IPredictiveNavController;
import org.dsi.ifc.predictivenavigation.LikelyDestination;
import org.osgi.framework.BundleContext;

public class NullPredictiveNavController
implements IPredictiveNavController {
    public void start(BundleContext bundleContext) {
    }

    public void stop(BundleContext bundleContext) {
    }

    public void updateRgActive() {
    }

    public void updateRgRouteCalculationState() {
    }

    public void updateOperationMode() {
    }

    public void setActivationMode(int n) {
    }

    public void updateLikelyDestinations(LikelyDestination[] likelyDestinationArray) {
    }

    public void updateMaxPredictions(int n) {
    }

    public void clearCacheResult() {
    }

    public void resetMemorySettings() {
    }

    public void resetSettings() {
    }

    public LikelyDestination[] getLikelyDestinations() {
        return null;
    }

    public void focusSelenaRoutes(boolean bl) {
    }
}

