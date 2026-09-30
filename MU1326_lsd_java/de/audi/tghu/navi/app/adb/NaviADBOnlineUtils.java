/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.adb;

import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.call.CommandListCallManager;
import de.audi.tghu.navi.app.call.NavSimpleCall;
import de.audi.tghu.navi.app.dsi.DSINavigationManager;
import de.audi.tghu.navi.app.util.LocationFormatter;
import de.audi.tghu.navi.app.util.Util;
import org.dsi.ifc.global.NavLocation;
import org.dsi.ifc.organizer.AdbEntry;

public class NaviADBOnlineUtils {
    private static Object resolveGeoCoordsMutex = new Object();

    public static void tryBestMatchJumpToNDF(AdbEntry adbEntry, short s) {
    }

    public static void jumpToNDF(byte[] byArray) {
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static synchronized NavLocation resolveGeoCoords(final NavigationEnv navigationEnv, final DSINavigationManager dSINavigationManager, int n, int n2, CommandListCallManager commandListCallManager) {
        final NavLocation navLocation = Util.getLocationFromGeoPos(n, n2);
        NavLocation navLocation2 = null;
        if (navLocation != null) {
            Object object = resolveGeoCoordsMutex;
            synchronized (object) {
                navigationEnv.getContainer().setTransformedLocation(null);
                NavSimpleCall navSimpleCall = new NavSimpleCall(navigationEnv.getCommandLogChannel(), "ResolveGeoCoordsCall"){

                    public void execute() {
                        this.logger.log(10000000, "NaviADBOnlineUtils#execute( ResolveGeoCoordsCall ) - calling liGetLocationDescriptionTransform( %1 ) ", (Object)LocationFormatter.formatLocationShort(navLocation));
                        dSINavigationManager.getDSINavigation(0).liGetLocationDescriptionTransform(navLocation);
                    }

                    /*
                     * WARNING - Removed try catching itself - possible behaviour change.
                     */
                    public void liGetLocationDescriptionTransformResult(NavLocation navLocation2) {
                        Object object;
                        this.logger.log(10000000, "NaviADBOnlineUtils#liGetLocationDescriptionTransformResult() ");
                        Object object2 = object = resolveGeoCoordsMutex;
                        synchronized (object2) {
                            navigationEnv.getContainer().setTransformedLocation(navLocation2);
                            object.notifyAll();
                        }
                        this.callFinished();
                    }
                };
                commandListCallManager.executeCall(navSimpleCall, "NaviADBOnlineUtils.resolveGeoCoords", false);
                try {
                    resolveGeoCoordsMutex.wait(5000L);
                }
                catch (InterruptedException interruptedException) {
                    Thread.interrupted();
                }
                navLocation2 = navigationEnv.getContainer().getTransformedLocation();
            }
        }
        return navLocation2;
    }
}

