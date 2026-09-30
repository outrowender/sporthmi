/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.predictivenav;

import org.dsi.ifc.predictivenavigation.LikelyDestination;
import org.osgi.framework.BundleContext;

public interface IPredictiveNavController {
    public static final int ACTIVATIONMODE_DEACTIVATE = 0;
    public static final int ACTIVATIONMODE_FORCE_PASSIVE_IF_NOT_DEACTIVATED = 1;
    public static final int ACTIVATIONMODE_ACTIVATE = 2;
    public static final int ACTIVATIONMODE_UPDATE_OPERATIONMODE = 3;

    public void start(BundleContext var1);

    public void stop(BundleContext var1);

    public void updateRgActive();

    public void updateRgRouteCalculationState();

    public void updateOperationMode();

    public void setActivationMode(int var1);

    public void updateLikelyDestinations(LikelyDestination[] var1);

    public void updateMaxPredictions(int var1);

    public void clearCacheResult();

    public void resetMemorySettings();

    public void resetSettings();

    public LikelyDestination[] getLikelyDestinations();

    public void focusSelenaRoutes(boolean var1);
}

