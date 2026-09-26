/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.map.instances;

import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.map.MapConfig;
import de.audi.tghu.navi.app.map.MapConsts;
import de.audi.tghu.navi.app.util.Util;

public class MapConfigFactory
implements MapConsts {
    public static MapConfig createMapConfig(int n, NavigationEnv navigationEnv) {
        MapConfig mapConfig = new MapConfig();
        switch (n) {
            case 0: {
                mapConfig.setGoogleEarth(Util.isGoogleEarthPresent(navigationEnv.getFramework()));
                mapConfig.setZoomEngine(true);
                mapConfig.setManeuverView(true);
                mapConfig.setRouteInfo(true);
                mapConfig.setTooltip(true);
                mapConfig.setSupportedContextObjs(new int[]{0, 1, 2, 33, 34, 29, 30, 31, 3, 5, 6, 7, 8, 10, 11, 12, 13, 15, 17, 18, 20, 22, 26, 28, 36, 37, 38, 39});
                mapConfig.setMapInstanceId(0);
                mapConfig.setMapInstanceIdGoogle(1);
                mapConfig.setTerminalID(0);
                mapConfig.setDSIGoogleLogChannel(navigationEnv.getLogChannel("App.Map.DSI1"), navigationEnv.getLogChannel("App.Map.DSIControl1"));
                break;
            }
            case 1: {
                mapConfig.setGoogleEarth(false);
                mapConfig.setSupportedContextObjs(new int[]{0, 24, 29, 30, 31});
                mapConfig.setMapInstanceId(2);
                break;
            }
            case 2: {
                mapConfig.setGoogleEarth(Util.isGoogleEarthPresent(navigationEnv.getFramework()));
                mapConfig.setZoomEngine(true);
                mapConfig.setSupportedContextObjs(new int[]{0, 32, 2, 33, 3, 5, 6, 7, 8, 10, 11, 12, 13, 15, 17, 18, 22, 26, 27, 28});
                mapConfig.setMapInstanceId(3);
                mapConfig.setMapInstanceIdGoogle(4);
                mapConfig.setTerminalID(1);
                mapConfig.setDSIGoogleLogChannel(navigationEnv.getLogChannel("App.Map.DSI4"), navigationEnv.getLogChannel("App.Map.DSIControl4"));
                break;
            }
            case 3: {
                mapConfig.setGoogleEarth(Util.isGoogleEarthPresent(navigationEnv.getFramework()));
                mapConfig.setZoomEngine(true);
                mapConfig.setSupportedContextObjs(new int[]{0, 32, 2, 33, 3, 5, 6, 7, 8, 10, 11, 12, 13, 15, 17, 18, 22, 26, 27, 28});
                mapConfig.setMapInstanceId(3);
                mapConfig.setMapInstanceIdGoogle(4);
                mapConfig.setTerminalID(1);
                mapConfig.setDSIGoogleLogChannel(navigationEnv.getLogChannel("App.Map.DSI4"), navigationEnv.getLogChannel("App.Map.DSIControl4"));
                break;
            }
            default: {
                mapConfig = null;
            }
        }
        return mapConfig;
    }
}

