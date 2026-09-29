/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.map.routeinfo;

import de.audi.atip.log.LogChannel;
import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.map.routeinfo.RouteInfoHelper;
import de.audi.tghu.navi.app.map.utils.MixedListRow$IRouteInfoEnv;
import de.audi.tghu.navi.app.util.Util;
import org.dsi.ifc.navigation.ManeuverElement;
import org.dsi.ifc.navigation.NavPoiInfo;
import org.dsi.ifc.navigation.TurnListElement;

public class RouteInfoHelperNAR
extends RouteInfoHelper {
    public RouteInfoHelperNAR(NavigationEnv navigationEnv, LogChannel logChannel, MixedListRow$IRouteInfoEnv mixedListRow$IRouteInfoEnv) {
        super(navigationEnv, logChannel, mixedListRow$IRouteInfoEnv);
    }

    @Override
    public String getDisplayName(TurnListElement turnListElement) {
        String string = super.getDisplayName(turnListElement);
        ManeuverElement maneuverElement = this.getManeuverElement(turnListElement, 256);
        if (maneuverElement != null) {
            string = new StringBuffer().append("\u25ca ").append(string).toString();
        }
        return string;
    }

    @Override
    public String getDisplayName(NavPoiInfo navPoiInfo) {
        String string = "";
        if (navPoiInfo != null) {
            string = navPoiInfo.getSignpostInfo();
            this.getLogger().log(14808325, "RouteInfoHelperNAR#getDisplayName(NavPoiInfo): SignpostInfo = %1", (Object)string);
            if (Util.isEmpty(string)) {
                string = this.env.getTranslatedText(9, "EXIT");
            }
        }
        return string;
    }
}

