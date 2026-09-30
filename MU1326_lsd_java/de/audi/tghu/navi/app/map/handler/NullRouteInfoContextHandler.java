/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.map.handler;

import de.audi.tghu.navi.app.map.handler.IRouteInfoContextHandler;
import de.audi.tghu.navi.app.map.instances.MinorMap;

public class NullRouteInfoContextHandler
implements IRouteInfoContextHandler {
    public void setMinorMap(MinorMap minorMap) {
    }

    public void cleanup() {
    }

    public void handleCurrentRouteInfoContext() {
    }

    public boolean isManeuverViewVisible() {
        return false;
    }

    public boolean isRouteInfoAllowedToFadeIn() {
        return false;
    }

    public void signalManeuverViewActive() {
    }

    public void signalMapHidden() {
    }

    public void signalMapInMapInoperable() {
    }

    public void signalRouteInfoHidden() {
    }

    public void updateDisplayContext(int n) {
    }

    public void updateDistanceToNextManeuver(String string) {
    }

    public void updateManoeuvreViewsAvailable(short[] sArray) {
    }

    public void updateMapInMapViewVisibleAndUnfrozen(boolean bl, boolean bl2) {
    }

    public boolean isManeuverViewAvailable() {
        return false;
    }

    public boolean isManeuverViewRequested() {
        return false;
    }

    public void updateDistanceToNextManeuver(int n, int n2) {
    }

    public void fillModelsAccordingToLayerVisibility() {
    }

    public boolean isOffroadModeActive() {
        return false;
    }

    public void signalCompassHidden() {
    }
}

