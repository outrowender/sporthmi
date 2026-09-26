/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.hierarchiclist.rml;

import de.audi.atip.hmi.model.IconCell;
import de.audi.atip.hmi.model.ListRow;
import de.audi.tghu.navi.app.IconHandler;
import de.audi.tghu.navi.app.util.IconUtil;
import org.dsi.ifc.navigation.CombinedRouteListElement;
import org.dsi.ifc.navigation.ManeuverElement;
import org.dsi.ifc.navigation.NavRouteListDataIcon;

public class RMLUtil {
    public static boolean isDestination(CombinedRouteListElement combinedRouteListElement) {
        return RMLUtil.isOfType(combinedRouteListElement, 5);
    }

    public static boolean isPOI(CombinedRouteListElement combinedRouteListElement) {
        return RMLUtil.isOfType(combinedRouteListElement, 4);
    }

    public static boolean isTMC(CombinedRouteListElement combinedRouteListElement) {
        return RMLUtil.isOfType(combinedRouteListElement, 3);
    }

    public static boolean isManeuver(CombinedRouteListElement combinedRouteListElement) {
        return RMLUtil.isOfType(combinedRouteListElement, 2);
    }

    public static boolean isRoadSegment(CombinedRouteListElement combinedRouteListElement) {
        return RMLUtil.isOfType(combinedRouteListElement, 0) || RMLUtil.isOfType(combinedRouteListElement, 7) || RMLUtil.isOfType(combinedRouteListElement, 9);
    }

    public static boolean isCountryChange(CombinedRouteListElement combinedRouteListElement) {
        return RMLUtil.isOfType(combinedRouteListElement, 10);
    }

    public static boolean isRoadPoint(CombinedRouteListElement combinedRouteListElement) {
        return RMLUtil.isOfType(combinedRouteListElement, 6);
    }

    public static boolean isOffroad(CombinedRouteListElement combinedRouteListElement) {
        return RMLUtil.isOfType(combinedRouteListElement, 14) || RMLUtil.isOfType(combinedRouteListElement, 13);
    }

    public static synchronized boolean isOfType(CombinedRouteListElement combinedRouteListElement, int n) {
        int[] nArray = combinedRouteListElement.getType();
        if (nArray != null) {
            for (int i2 = 0; i2 < nArray.length; ++i2) {
                if (nArray[i2] != n) continue;
                return true;
            }
        }
        return false;
    }

    public static synchronized boolean isOfManeuverType(CombinedRouteListElement combinedRouteListElement, int n) {
        ManeuverElement[] maneuverElementArray = combinedRouteListElement.getManeuver();
        if (maneuverElementArray != null) {
            for (int i2 = 0; i2 < maneuverElementArray.length; ++i2) {
                if (maneuverElementArray[i2].getElement() != n) continue;
                return true;
            }
        }
        return false;
    }

    public static synchronized int getIconTypeIndex(CombinedRouteListElement combinedRouteListElement, int n, int n2) {
        NavRouteListDataIcon[] navRouteListDataIconArray = combinedRouteListElement.getIcons();
        if (navRouteListDataIconArray != null) {
            for (int i2 = n2; i2 < navRouteListDataIconArray.length; ++i2) {
                if (navRouteListDataIconArray[i2].getType() != n) continue;
                return i2;
            }
        }
        return -1;
    }

    public static synchronized void setPOIIconImages(IconHandler iconHandler, CombinedRouteListElement combinedRouteListElement, ListRow listRow, int n, int n2) {
        int n3 = RMLUtil.getIconTypeIndex(combinedRouteListElement, 1, 0);
        for (int i2 = 0; n3 >= 0 && i2 < n2; ++i2) {
            NavRouteListDataIcon navRouteListDataIcon = combinedRouteListElement.getIcons()[n3];
            IconUtil.setPOIIconImage(iconHandler, navRouteListDataIcon.getCriteria1(), navRouteListDataIcon.getCriteria2(), (IconCell)listRow.getCell(n + i2));
            n3 = RMLUtil.getIconTypeIndex(combinedRouteListElement, 1, n3 + 1);
        }
    }
}

