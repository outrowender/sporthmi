/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.routeguidance;

import org.dsi.ifc.navigation.Route;

public interface IRouteGuidanceStateModelAccess {
    default public void updateRgActive(boolean bl, Route route) {
    }

    default public void updateActiveDestinations(int n) {
    }

    default public void setPredictiveRgRunning(boolean bl) {
    }
}

