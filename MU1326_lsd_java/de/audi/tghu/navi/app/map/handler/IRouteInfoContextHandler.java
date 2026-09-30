/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.map.handler;

import de.audi.tghu.navi.app.map.instances.MinorMap;

public interface IRouteInfoContextHandler {
    public void setMinorMap(MinorMap var1);

    public void cleanup();

    public void handleCurrentRouteInfoContext();

    public boolean isManeuverViewVisible();

    public boolean isRouteInfoAllowedToFadeIn();

    public void signalManeuverViewActive();

    public void signalMapHidden();

    public void signalMapInMapInoperable();

    public void signalRouteInfoHidden();

    public void updateDisplayContext(int var1);

    public void updateDistanceToNextManeuver(String var1);

    public void updateManoeuvreViewsAvailable(short[] var1);

    public void updateMapInMapViewVisibleAndUnfrozen(boolean var1, boolean var2);

    public boolean isManeuverViewAvailable();

    public boolean isManeuverViewRequested();

    public void updateDistanceToNextManeuver(int var1, int var2);

    public void fillModelsAccordingToLayerVisibility();

    public boolean isOffroadModeActive();

    public void signalCompassHidden();
}

