/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.predictivenav;

import de.audi.tghu.navi.app.predictivenav.IPredictiveNavController;
import org.dsi.ifc.predictivenavigation.LikelyDestination;
import org.osgi.framework.BundleContext;

public class NullPredictiveNavController
implements IPredictiveNavController {
    @Override
    public void start(BundleContext bundleContext) {
    }

    @Override
    public void stop(BundleContext bundleContext) {
    }

    @Override
    public void updateRgActive() {
    }

    @Override
    public void updateRgRouteCalculationState() {
    }

    @Override
    public void updateOperationMode() {
    }

    @Override
    public void setActivationMode(int n) {
    }

    @Override
    public void updateLikelyDestinations(LikelyDestination[] likelyDestinationArray) {
    }

    @Override
    public void updateMaxPredictions(int n) {
    }

    @Override
    public void clearCacheResult() {
    }

    @Override
    public void resetMemorySettings() {
    }

    @Override
    public void resetSettings() {
    }

    @Override
    public LikelyDestination[] getLikelyDestinations() {
        return null;
    }

    @Override
    public void focusSelenaRoutes(boolean bl) {
    }
}

