/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.map.routeinfo;

import de.audi.atip.log.LogChannel;
import de.audi.atip.util.StringUtilities;
import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.map.routeinfo.RouteInfoHelper;
import de.audi.tghu.navi.app.map.utils.MixedListRow;
import de.audi.tghu.navi.app.util.Util;
import org.dsi.ifc.navigation.NavPoiInfo;
import org.dsi.ifc.navigation.TurnListElement;
import org.dsi.ifc.tmc.TmcMessage;

public class RouteInfoHelperAsia
extends RouteInfoHelper {
    public RouteInfoHelperAsia(NavigationEnv navigationEnv, LogChannel logChannel, MixedListRow.IRouteInfoEnv iRouteInfoEnv) {
        super(navigationEnv, logChannel, iRouteInfoEnv);
    }

    public String getDisplayName(TurnListElement turnListElement) {
        String string = null;
        int n = turnListElement.getType();
        int n2 = this.getDefaultFormat(turnListElement, this.env);
        if (n != 7) {
            switch (n2) {
                case 89: {
                    string = this.env.getTranslatedText(13, "Off road");
                    break;
                }
                case 88: {
                    string = Util.isEmpty(turnListElement.signPostInfo) ? "---" : turnListElement.signPostInfo;
                    break;
                }
                case 80: 
                case 90: 
                case 91: 
                case 92: {
                    string = Util.isEmpty(turnListElement.turnToStreet) ? "---" : turnListElement.turnToStreet;
                    break;
                }
                case 84: {
                    string = this.env.getTranslatedText(10, "Ferry");
                    if (!StringUtilities.isNullOrEmpty(string)) break;
                    string = turnListElement.turnToStreet;
                    break;
                }
            }
        }
        if (string == null) {
            string = super.getDisplayName(turnListElement);
        }
        return string;
    }

    public String getDisplayName(NavPoiInfo navPoiInfo) {
        return null;
    }

    public String getDisplayName(TmcMessage tmcMessage) {
        String string = "";
        string = tmcMessage.affectedRoadLength > 0L ? StringUtilities.formatMessage("%1 %2", new String[]{Util.formatDistance((int)tmcMessage.affectedRoadLength, 5), tmcMessage.getEventText()[0]}) : super.getDisplayName(tmcMessage);
        return string;
    }
}

