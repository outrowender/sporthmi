/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.adb;

import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.adb.NaviADBOnlineUtils$1;
import de.audi.tghu.navi.app.call.CommandListCallManager;
import de.audi.tghu.navi.app.dsi.DSINavigationManager;
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
    public static synchronized NavLocation resolveGeoCoords(NavigationEnv navigationEnv, DSINavigationManager dSINavigationManager, int n, int n2, CommandListCallManager commandListCallManager) {
        NavLocation navLocation = Util.getLocationFromGeoPos(n, n2);
        NavLocation navLocation2 = null;
        if (navLocation != null) {
            Object object = resolveGeoCoordsMutex;
            synchronized (object) {
                navigationEnv.getContainer().setTransformedLocation(null);
                NaviADBOnlineUtils$1 naviADBOnlineUtils$1 = new NaviADBOnlineUtils$1(navigationEnv.getCommandLogChannel(), "ResolveGeoCoordsCall", navLocation, dSINavigationManager, navigationEnv);
                commandListCallManager.executeCall(naviADBOnlineUtils$1, "NaviADBOnlineUtils.resolveGeoCoords", false);
                try {
                    resolveGeoCoordsMutex.wait(0);
                }
                catch (InterruptedException interruptedException) {
                    Thread.interrupted();
                }
                navLocation2 = navigationEnv.getContainer().getTransformedLocation();
            }
        }
        return navLocation2;
    }

    static /* synthetic */ Object access$000() {
        return resolveGeoCoordsMutex;
    }
}

