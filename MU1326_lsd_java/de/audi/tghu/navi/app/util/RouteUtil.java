/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.util;

import de.audi.atip.hmi.model.HMIResourceLocator;
import de.audi.atip.hmi.model.IconCell;
import de.audi.atip.hmi.model.IntegerListCell;
import de.audi.atip.hmi.model.ListCell;
import de.audi.atip.hmi.model.TextListCell;
import de.audi.atip.hmi.modelaccess.ListModelApp;
import de.audi.atip.log.LogChannel;
import de.audi.tghu.navi.app.IconHandler;
import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.util.LocationFormatter;
import de.audi.tghu.navi.app.util.Title;
import de.audi.tghu.navi.app.util.Util;
import de.esolutions.fw.util.commons.Buffer;
import org.dsi.ifc.global.NavLocation;
import org.dsi.ifc.global.NavSegmentID;
import org.dsi.ifc.navigation.Route;
import org.dsi.ifc.navigation.RouteDestination;
import org.dsi.ifc.navigation.RouteOptions;
import org.dsi.ifc.navigation.util.RouteHelper;

public class RouteUtil {
    public static String formatRoute(Route route, String string) {
        Buffer buffer = new Buffer(512);
        buffer.append("Route: ").append(string).append('\n');
        if (route != null) {
            buffer.append("index: ").append(RouteUtil.getIndexOfCurrentDestination(route)).append(", length: ").append(RouteUtil.getRouteLength(route)).append(", routeID: ").append(RouteUtil.getRouteID(route)).append(", name: ").append(RouteUtil.getRoutename(route)).append('\n');
            RouteDestination[] routeDestinationArray = route.getRoutelist();
            if (routeDestinationArray != null && routeDestinationArray.length > 0) {
                for (int i2 = 0; i2 < routeDestinationArray.length; ++i2) {
                    buffer.append("Destination #").append(i2).append(':').append('\n');
                    buffer.append(LocationFormatter.formatLocation(routeDestinationArray[i2].getRouteLocation(), "\t"));
                    if (routeDestinationArray[i2].getDestinationType() == 2) {
                        buffer.append(" *soft* ");
                    }
                    buffer.append("---").append('\n');
                }
            } else {
                buffer.append("empty").append('\n');
            }
        } else {
            buffer.append("empty").append('\n');
        }
        return buffer.toString();
    }

    public static String formatRouteShort(Route route) {
        Buffer buffer = new Buffer(512);
        if (route != null) {
            buffer.append("index: ").append(RouteUtil.getIndexOfCurrentDestination(route)).append(", length: ").append(RouteUtil.getRouteLength(route)).append(", routeID: ").append(RouteUtil.getRouteID(route)).append(", name: ").append(RouteUtil.getRoutename(route)).append('\n');
            RouteDestination[] routeDestinationArray = route.getRoutelist();
            if (routeDestinationArray != null && routeDestinationArray.length > 0) {
                for (int i2 = 0; i2 < routeDestinationArray.length; ++i2) {
                    buffer.append('\t').append("Destination #").append(i2).append(": ");
                    buffer.append(LocationFormatter.formatLocationShort(routeDestinationArray[i2].getRouteLocation()));
                    if (routeDestinationArray[i2].getDestinationType() == 2) {
                        buffer.append(" *soft*");
                    }
                    buffer.append(" (type=").append(routeDestinationArray[i2].getDestinationType()).append(")");
                    buffer.append('\n');
                }
            } else {
                buffer.append("empty").append('\n');
            }
        } else {
            buffer.append("null").append('\n');
        }
        return buffer.toString();
    }

    public static Route cloneRoute(Route route, RouteOptions[] routeOptionsArray) {
        if (route == null) {
            return null;
        }
        int n = RouteUtil.getRouteID(route);
        String string = route.getRoutename();
        int n2 = RouteUtil.getRouteLength(route);
        int n3 = RouteUtil.getIndexOfCurrentDestination(route);
        RouteDestination[] routeDestinationArray = new RouteDestination[n2];
        try {
            for (int i2 = 0; i2 < n2; ++i2) {
                RouteDestination routeDestination = RouteHelper.getDestinationAtPosition(route, i2);
                RouteOptions[] routeOptionsArray2 = routeDestination.getRouteOptions();
                NavLocation navLocation = routeDestination.getRouteLocation();
                RouteOptions[] routeOptionsArray3 = routeOptionsArray == null ? RouteUtil.cloneRouteOptions(routeOptionsArray2) : routeOptionsArray;
                int n4 = routeDestination.getDestinationType();
                routeDestinationArray[i2] = new RouteDestination(navLocation, routeOptionsArray3, n4);
            }
        }
        catch (ArrayIndexOutOfBoundsException arrayIndexOutOfBoundsException) {
            return null;
        }
        Route route2 = new Route(n3, n, routeDestinationArray, string);
        return route2;
    }

    private static RouteOptions[] cloneRouteOptions(RouteOptions[] routeOptionsArray) {
        RouteOptions[] routeOptionsArray2 = null;
        if (routeOptionsArray != null) {
            routeOptionsArray2 = new RouteOptions[routeOptionsArray.length];
            for (int i2 = 0; i2 < routeOptionsArray.length; ++i2) {
                routeOptionsArray2[i2] = new RouteOptions(routeOptionsArray[i2].routeType, routeOptionsArray[i2].weighting, routeOptionsArray[i2].hybridMode, routeOptionsArray[i2].dynamic, routeOptionsArray[i2].dynamicSpeedFlow, routeOptionsArray[i2].dynamicTrafficPattern, routeOptionsArray[i2].dynamicTrafficPatternOnline, routeOptionsArray[i2].dynamicTrafficPatternRecorded, routeOptionsArray[i2].motorways, routeOptionsArray[i2].ferries, routeOptionsArray[i2].tollroads, routeOptionsArray[i2].tollroadsCostPenalty, routeOptionsArray[i2].tunnels, routeOptionsArray[i2].leftRightTurn, routeOptionsArray[i2].slopes, routeOptionsArray[i2].slopesMaxFactor, routeOptionsArray[i2].vignette, routeOptionsArray[i2].vignetteCountryList, routeOptionsArray[i2].cityMaut, routeOptionsArray[i2].cityMautList, routeOptionsArray[i2].cartrain, routeOptionsArray[i2].timeDomain, routeOptionsArray[i2].seasonalTimeDomain, routeOptionsArray[i2].unpaved, routeOptionsArray[i2].residentialAreaHandling, routeOptionsArray[i2].trailer, routeOptionsArray[i2].hovCarPoolsLane, routeOptionsArray[i2].border, routeOptionsArray[i2].ipd, routeOptionsArray[i2].trail, routeOptionsArray[i2].waypointMode, routeOptionsArray[i2].economicTurns, routeOptionsArray[i2].styleId);
            }
        }
        return routeOptionsArray2;
    }

    public static int getRouteID(Route route) {
        if (route == null) {
            return 0;
        }
        return Util.castLongToInt(route.getRouteID());
    }

    public static String getRoutename(Route route) {
        if (route == null) {
            return "";
        }
        return route.getRoutename();
    }

    public static int getRouteLength(Route route) {
        if (route == null) {
            return 0;
        }
        if (route.getRoutelist() == null) {
            return 0;
        }
        return route.getRoutelist().length;
    }

    public static int getIndexOfCurrentDestination(Route route) {
        if (route == null) {
            return 0;
        }
        return Util.castLongToInt(route.getIndexOfCurrentDestination());
    }

    public static void setIndexOfCurrentDestination(Route route, int n, LogChannel logChannel) {
        if (route == null) {
            logChannel.log(-1601830656, "RouteUtil#setIndexOfCurrentDestination() - failed to set index: %1, route is null", (long)n);
        } else {
            try {
                route.setIndexOfCurrentDestination(n);
            }
            catch (ArrayIndexOutOfBoundsException arrayIndexOutOfBoundsException) {
                logChannel.log(-1601830656, "RouteUtil#setIndexOfCurrentDestination() - failed to set index: %2, index out of bounds: %1", (Object)arrayIndexOutOfBoundsException.getMessage(), (long)n);
            }
        }
    }

    public static boolean isRouteNavigable(Route route) {
        int n = RouteUtil.getRouteLength(route);
        boolean bl = n > 0;
        try {
            for (int i2 = 0; i2 < n; ++i2) {
                NavLocation navLocation = RouteHelper.getDestinationAtPosition(route, i2).getRouteLocation();
                if (navLocation != null && navLocation.isPositionValid()) continue;
                return false;
            }
        }
        catch (ArrayIndexOutOfBoundsException arrayIndexOutOfBoundsException) {
            return false;
        }
        return bl;
    }

    public static NavLocation getFirstDestination(Route route) {
        NavLocation navLocation = null;
        int n = RouteUtil.getRouteLength(route);
        if (n > 0) {
            navLocation = route.getRoutelist()[0].getRouteLocation();
        }
        return navLocation;
    }

    public static NavLocation getFinalDestination(Route route) {
        NavLocation navLocation = null;
        int n = RouteUtil.getRouteLength(route);
        if (n > 0) {
            try {
                navLocation = RouteHelper.getDestinationAtPosition(route, n - 1).getRouteLocation();
            }
            catch (ArrayIndexOutOfBoundsException arrayIndexOutOfBoundsException) {
                return null;
            }
        }
        return navLocation;
    }

    public static NavLocation getCurrentDestination(Route route) {
        int n = RouteUtil.getIndexOfCurrentDestination(route);
        int n2 = RouteUtil.getRouteLength(route);
        NavLocation navLocation = null;
        if (0 <= n && n < n2) {
            try {
                navLocation = RouteHelper.getDestinationAtPosition(route, n).getRouteLocation();
            }
            catch (ArrayIndexOutOfBoundsException arrayIndexOutOfBoundsException) {
                return null;
            }
        }
        return navLocation;
    }

    public static int getCurrentDestinationType(Route route, LogChannel logChannel) {
        int n;
        int n2 = RouteUtil.getIndexOfCurrentDestination(route);
        int n3 = RouteUtil.getRouteLength(route);
        RouteDestination routeDestination = null;
        if (0 <= n2 && n2 < n3) {
            try {
                routeDestination = RouteHelper.getDestinationAtPosition(route, n2);
            }
            catch (ArrayIndexOutOfBoundsException arrayIndexOutOfBoundsException) {
                logChannel.log(-1601830656, "RouteUtil#getCurrentDestinationType() - failed to get destination, index out of bounds: %1", (Throwable)arrayIndexOutOfBoundsException);
            }
        }
        if (routeDestination == null) {
            int n4 = RouteUtil.getRouteID(route);
            switch (n4) {
                case 0: {
                    n = 0;
                    break;
                }
                case 1: {
                    n = 128;
                    break;
                }
                case 2: {
                    n = 1;
                    break;
                }
                default: {
                    n = 0;
                    break;
                }
            }
        } else {
            n = routeDestination.getDestinationType();
        }
        return n;
    }

    public static int computeCurrentDestinationFlag(Route route) {
        int n = RouteUtil.getRouteLength(route);
        int n2 = RouteUtil.getIndexOfCurrentDestination(route);
        int n3 = n2 >= n - 1 ? 0 : n2 + 1;
        return n3;
    }

    public static void fillRouteListModel(NavigationEnv navigationEnv, IconHandler iconHandler, Route route, ListModelApp listModelApp, boolean bl, boolean bl2, int n) {
        if (route == null) {
            navigationEnv.getLogChannel().log(10000, "RouteUtil#fillRouteListModel() - failed to fill route list model! route is null! ");
            return;
        }
        if (route.getRoutelist() == null) {
            navigationEnv.getLogChannel().log(10000, "RouteUtil#fillRouteListModel() - failed to fill route list model! routeList is null! ");
            return;
        }
        if (listModelApp == null) {
            navigationEnv.getLogChannel().log(10000, "RouteUtil#fillRouteListModel() - failed to fill route list model! bufferedRouteDestinationsListModel is null! ");
            return;
        }
        RouteDestination[] routeDestinationArray = route.getRoutelist();
        int n2 = 0;
        int n3 = routeDestinationArray.length;
        int n4 = RouteUtil.getIndexOfCurrentDestination(route);
        int n5 = n4 = n4 >= 0 ? n4 : 0;
        if (!bl) {
            n2 = n4;
        }
        if (!bl2) {
            n3 = n4;
        }
        listModelApp.beginTransaction();
        listModelApp.setMaxRows(routeDestinationArray.length);
        listModelApp.clear();
        for (int i2 = n2; i2 < n3; ++i2) {
            boolean bl3 = i2 < routeDestinationArray.length - 1;
            Title title = new Title(routeDestinationArray[i2].getRouteLocation(), true, navigationEnv);
            IntegerListCell integerListCell = new IntegerListCell(bl3 ? 1 : 0);
            TextListCell textListCell = new TextListCell(Integer.toString(i2 + 1));
            TextListCell textListCell2 = new TextListCell(title.getDefaultTitle());
            IntegerListCell integerListCell2 = null;
            IconCell iconCell = null;
            int n6 = iconHandler.resolvePOIIconResourceID(title.getIconIndex(), title.getSubIndex());
            if (n6 != -1) {
                iconCell = new IconCell(new HMIResourceLocator(n6));
            } else {
                navigationEnv.getLogChannel().log(-2137614336, "RouteUtil#fillRouteListModel() - failed to resolve icon for %1", (Object)title);
            }
            integerListCell2 = iconCell != null ? IntegerListCell.create(bl3 ? 3 : 2) : IntegerListCell.create(bl3 ? 1 : 0);
            ListCell[] listCellArray = new ListCell[]{integerListCell, textListCell, textListCell2, integerListCell2, iconCell};
            listModelApp.addRow(listCellArray);
        }
        listModelApp.setSelected(n);
        listModelApp.endTransaction();
    }

    public static Route deletePassedDestinationsFromRoute(Route route, LogChannel logChannel) {
        Route route2 = null;
        if (route != null && RouteUtil.getRouteLength(route) > 0) {
            route2 = RouteUtil.cloneRoute(route, null);
            for (int i2 = RouteUtil.getIndexOfCurrentDestination(route2); i2 > 0 && RouteUtil.getRouteLength(route2) > 0; --i2) {
                RouteHelper.deleteDestinationAtPosition(route2, 0);
            }
            RouteUtil.setIndexOfCurrentDestination(route2, 0, logChannel);
        }
        return route2;
    }

    public static Route deleteAllViaPoint(Route route, LogChannel logChannel) {
        Route route2 = null;
        int n = 0;
        if (route != null) {
            for (int i2 = 0; i2 < route.routelist.length; ++i2) {
                n += route.routelist[i2].destinationType == 1 ? 1 : 0;
            }
        }
        RouteDestination[] routeDestinationArray = new RouteDestination[n];
        if (route != null && RouteUtil.getRouteLength(route) > 0) {
            int n2;
            route2 = RouteUtil.cloneRoute(route, null);
            int n3 = n2 = RouteUtil.getIndexOfCurrentDestination(route2);
            int n4 = 0;
            for (int i3 = 0; i3 < route.routelist.length && n4 < n; ++i3) {
                if (route.routelist[i3].destinationType == 1) {
                    routeDestinationArray[n4] = route.routelist[i3];
                    ++n4;
                    continue;
                }
                if (i3 >= n2) continue;
                --n3;
            }
            route2.routelist = routeDestinationArray;
            RouteUtil.setIndexOfCurrentDestination(route2, n3, logChannel);
        }
        return route2;
    }

    public static Route createTrail(String string, NavLocation navLocation) {
        return RouteUtil.createTrail(string, null, navLocation);
    }

    public static Route createTrail(String string, NavSegmentID navSegmentID) {
        return RouteUtil.createTrail(string, navSegmentID, null);
    }

    private static Route createTrail(String string, NavSegmentID navSegmentID, NavLocation navLocation) {
        String string2 = string;
        if (Util.isEmpty(string2) && navSegmentID != null) {
            string2 = navSegmentID.toString();
        }
        if (navLocation != null || navSegmentID != null) {
            // empty if block
        }
        if (navLocation != null) {
            RouteDestination[] routeDestinationArray = new RouteDestination[]{new RouteDestination(navLocation, new RouteOptions[]{new RouteOptions()}, 1)};
            Route route = new Route(0L, 0, routeDestinationArray, string2);
            return route;
        }
        return null;
    }

    public static int getNumberOfDestinations(Route route, int n) {
        int n2 = 0;
        if (route == null || route.getRoutelist() == null) {
            return n2;
        }
        RouteDestination[] routeDestinationArray = route.getRoutelist();
        for (int i2 = 0; i2 < route.getRoutelist().length; ++i2) {
            if (routeDestinationArray[i2].getDestinationType() != n) continue;
            ++n2;
        }
        return n2;
    }

    public static int getNumberOfRemainingDestinations(Route route, int n) {
        int n2 = 0;
        if (route == null || route.getRoutelist() == null) {
            return n2;
        }
        RouteDestination[] routeDestinationArray = route.getRoutelist();
        for (int i2 = (int)route.getIndexOfCurrentDestination(); i2 < route.getRoutelist().length; ++i2) {
            if (routeDestinationArray[i2].getDestinationType() != n) continue;
            ++n2;
        }
        return n2;
    }

    public static RouteOptions[] getOptionsOfFinalDestination(Route route) {
        RouteOptions[] routeOptionsArray = new RouteOptions[]{};
        int n = RouteUtil.getRouteLength(route);
        if (n > 0) {
            try {
                routeOptionsArray = RouteHelper.getDestinationAtPosition(route, n - 1).getRouteOptions();
            }
            catch (ArrayIndexOutOfBoundsException arrayIndexOutOfBoundsException) {
                return new RouteOptions[0];
            }
        }
        return routeOptionsArray;
    }

    public static Route validateRoute(NavigationEnv navigationEnv, Route route) {
        if (RouteUtil.getRouteLength(route) == 0) {
            return route;
        }
        RouteDestination[] routeDestinationArray = route.getRoutelist();
        for (int i2 = 0; i2 < routeDestinationArray.length; ++i2) {
            if (routeDestinationArray[i2] != null && routeDestinationArray[i2].routeLocation != null) continue;
            navigationEnv.getLogChannel().log(10000, "RouteUtil#validateRoute() - received invalid route object %1", (Object)RouteUtil.formatRouteShort(route));
            return null;
        }
        return route;
    }

    public static int checkRouteforOnlinePOI(Route route) {
        RouteDestination[] routeDestinationArray;
        if (route != null && (routeDestinationArray = route.getRoutelist()) != null) {
            for (int i2 = 0; i2 < routeDestinationArray.length; ++i2) {
                if (routeDestinationArray[i2] == null || !Util.isOnlinePOI(routeDestinationArray[i2].routeLocation)) continue;
                return 0;
            }
        }
        return 1;
    }
}

