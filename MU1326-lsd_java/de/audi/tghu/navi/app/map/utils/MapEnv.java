/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.map.utils;

import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.util.Util;

public class MapEnv {
    public static boolean isRouteInfoHandlerEnabled = true;
    public static boolean useRgCalculate1stRouteAndPostponeRemaining = false;
    public static boolean waitForReadyBeforeEnterMap = true;
    public static boolean useTopLeftToCalculateBoundingBox = true;
    public static boolean restoreLastRubberbandPoint = true;
    public static boolean enableSoftAnimationForRubberband = true;
    public static int mapModeForRouteBriefing = 10;

    public static boolean useDSIMapViewerControl2ForPreviewMap() {
        return false;
    }

    public static boolean force2UsePreviewMapForTest() {
        return false;
    }

    public static boolean leaveRouteBriefingScreenAutomatically() {
        return true;
    }

    public static boolean isLoggingWindowEnabled() {
        return false;
    }

    public static boolean isDebuggingCrossHair() {
        return false;
    }

    public static boolean isDebugEnabled() {
        return false;
    }

    public static boolean isDebugSelectionOnMapEnabled() {
        return false;
    }

    public static boolean isDebugMapFlagEnabled() {
        return false;
    }

    public static boolean isDebugTooltip() {
        return false;
    }

    public static boolean isSwitchScreenDelayerDisabled() {
        return false;
    }

    public static boolean isAutoStartRGDisabled() {
        return false;
    }

    public static boolean useRgCalculate1stRouteAndPostponeRemaining() {
        return useRgCalculate1stRouteAndPostponeRemaining;
    }

    public static boolean waitForReadyBeforeEnterMap(NavigationEnv navigationEnv) {
        if (Util.isPorsche(navigationEnv.getFramework())) {
            return false;
        }
        return waitForReadyBeforeEnterMap;
    }
}

