/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.map.handler;

import de.audi.tghu.navi.app.map.instances.MinorMap;

public interface IRouteInfoContextHandler {
    default public void setMinorMap(MinorMap minorMap) {
    }

    default public void cleanup() {
    }

    default public void handleCurrentRouteInfoContext() {
    }

    default public boolean isManeuverViewVisible() {
    }

    default public boolean isRouteInfoAllowedToFadeIn() {
    }

    default public void signalManeuverViewActive() {
    }

    default public void signalMapHidden() {
    }

    default public void signalMapInMapInoperable() {
    }

    default public void signalRouteInfoHidden() {
    }

    default public void updateDisplayContext(int n) {
    }

    default public void updateDistanceToNextManeuver(String string) {
    }

    default public void updateManoeuvreViewsAvailable(short[] sArray) {
    }

    default public void updateMapInMapViewVisibleAndUnfrozen(boolean bl, boolean bl2) {
    }

    default public boolean isManeuverViewAvailable() {
    }

    default public boolean isManeuverViewRequested() {
    }

    default public void updateDistanceToNextManeuver(int n, int n2) {
    }

    default public void fillModelsAccordingToLayerVisibility() {
    }

    default public boolean isOffroadModeActive() {
    }

    default public void signalCompassHidden() {
    }
}

