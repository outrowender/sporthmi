/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.guidance;

import de.audi.tghu.navi.app.navobserver.INavObserverRegistry;
import org.dsi.ifc.global.NavLocation;

public class CcpCountry {
    private static NavLocation oldCarLocation = null;

    public static void updateIfChanged(NavLocation navLocation, INavObserverRegistry iNavObserverRegistry) {
        if (navLocation != null && iNavObserverRegistry != null) {
            if (oldCarLocation != null && oldCarLocation.getCountryAbbreviation() != null && navLocation.getCountryAbbreviation() != null && !oldCarLocation.getCountryAbbreviation().equals(navLocation.getCountryAbbreviation())) {
                iNavObserverRegistry.ccpCountryUpdated(navLocation);
            }
            oldCarLocation = navLocation;
        }
    }
}

