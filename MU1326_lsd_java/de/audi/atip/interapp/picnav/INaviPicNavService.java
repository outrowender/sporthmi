/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.interapp.picnav;

import org.dsi.ifc.global.NavLocation;
import org.dsi.ifc.global.ResourceLocator;

public interface INaviPicNavService {
    public boolean isPicNavAvailable();

    public void deleteAllImplicitPicNavLocations();

    public void deleteImplicitPicNavLocation(NavLocation var1);

    public void showPicNavMapDestination(NavLocation var1, ResourceLocator var2);

    public NavLocation getDetailedLocation();

    public void resetToFactorySettings();

    public void resolvedLocationResult(NavLocation var1);

    public void mapUnfrozen();
}

