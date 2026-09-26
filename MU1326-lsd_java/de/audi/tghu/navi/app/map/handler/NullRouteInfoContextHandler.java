/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.map.handler;

import de.audi.tghu.navi.app.map.handler.IRouteInfoContextHandler;
import de.audi.tghu.navi.app.map.instances.MinorMap;

public class NullRouteInfoContextHandler
implements IRouteInfoContextHandler {
    @Override
    public void setMinorMap(MinorMap minorMap) {
    }

    @Override
    public void cleanup() {
    }

    @Override
    public void handleCurrentRouteInfoContext() {
    }

    @Override
    public boolean isManeuverViewVisible() {
        return false;
    }

    @Override
    public boolean isRouteInfoAllowedToFadeIn() {
        return false;
    }

    @Override
    public void signalManeuverViewActive() {
    }

    @Override
    public void signalMapHidden() {
    }

    @Override
    public void signalMapInMapInoperable() {
    }

    @Override
    public void signalRouteInfoHidden() {
    }

    @Override
    public void updateDisplayContext(int n) {
    }

    @Override
    public void updateDistanceToNextManeuver(String string) {
    }

    @Override
    public void updateManoeuvreViewsAvailable(short[] sArray) {
    }

    @Override
    public void updateMapInMapViewVisibleAndUnfrozen(boolean bl, boolean bl2) {
    }

    @Override
    public boolean isManeuverViewAvailable() {
        return false;
    }

    @Override
    public boolean isManeuverViewRequested() {
        return false;
    }

    @Override
    public void updateDistanceToNextManeuver(int n, int n2) {
    }

    @Override
    public void fillModelsAccordingToLayerVisibility() {
    }

    @Override
    public boolean isOffroadModeActive() {
        return false;
    }

    @Override
    public void signalCompassHidden() {
    }
}

