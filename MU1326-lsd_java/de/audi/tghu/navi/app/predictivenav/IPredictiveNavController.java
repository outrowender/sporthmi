/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.predictivenav;

import org.dsi.ifc.predictivenavigation.LikelyDestination;
import org.osgi.framework.BundleContext;

public interface IPredictiveNavController {
    public static final int ACTIVATIONMODE_DEACTIVATE;
    public static final int ACTIVATIONMODE_FORCE_PASSIVE_IF_NOT_DEACTIVATED;
    public static final int ACTIVATIONMODE_ACTIVATE;
    public static final int ACTIVATIONMODE_UPDATE_OPERATIONMODE;

    default public void start(BundleContext bundleContext) {
    }

    default public void stop(BundleContext bundleContext) {
    }

    default public void updateRgActive() {
    }

    default public void updateRgRouteCalculationState() {
    }

    default public void updateOperationMode() {
    }

    default public void setActivationMode(int n) {
    }

    default public void updateLikelyDestinations(LikelyDestination[] likelyDestinationArray) {
    }

    default public void updateMaxPredictions(int n) {
    }

    default public void clearCacheResult() {
    }

    default public void resetMemorySettings() {
    }

    default public void resetSettings() {
    }

    default public LikelyDestination[] getLikelyDestinations() {
    }

    default public void focusSelenaRoutes(boolean bl) {
    }
}

