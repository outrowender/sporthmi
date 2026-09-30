/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.routeguidance;

import org.dsi.ifc.navigation.Route;

public interface IRouteGuidanceStateModelAccess {
    public void updateRgActive(boolean var1, Route var2);

    public void updateActiveDestinations(int var1);

    public void setPredictiveRgRunning(boolean var1);
}

