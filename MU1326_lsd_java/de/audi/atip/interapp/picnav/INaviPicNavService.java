/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.interapp.picnav;

import org.dsi.ifc.global.NavLocation;
import org.dsi.ifc.global.ResourceLocator;

public interface INaviPicNavService {
    default public boolean isPicNavAvailable() {
    }

    default public void deleteAllImplicitPicNavLocations() {
    }

    default public void deleteImplicitPicNavLocation(NavLocation navLocation) {
    }

    default public void showPicNavMapDestination(NavLocation navLocation, ResourceLocator resourceLocator) {
    }

    default public NavLocation getDetailedLocation() {
    }

    default public void resetToFactorySettings() {
    }

    default public void resolvedLocationResult(NavLocation navLocation) {
    }

    default public void mapUnfrozen() {
    }
}

