/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.map.routecalc;

import de.audi.atip.timer.Timer;
import de.audi.tghu.navi.app.map.routecalc.RcciEvent;
import org.dsi.ifc.global.NavLocation;
import org.dsi.ifc.global.NavLocationWgs84;
import org.dsi.ifc.global.NavSegmentID;
import org.dsi.ifc.map.AvailableRoute;
import org.dsi.ifc.navigation.CalculatedRouteListElement;
import org.dsi.ifc.navigation.RgRouteCostChangeInformation;
import org.dsi.ifc.navigation.Route;

class RouteCalcDataContainer {
    boolean[] sAvailableRoutesValid = new boolean[5];
    AvailableRoute[][] sAvailableRoutes = new AvailableRoute[5][];
    public volatile boolean sRGInfoForNextDestReceived = false;
    boolean sCalculatedRoutesValid = false;
    CalculatedRouteListElement[] mCalculatedRouteListElement = new CalculatedRouteListElement[0];
    String mOldCrleFingerprint = null;
    int iRgRouteCalculationState = 0;
    boolean rgStartRubberbandManipulationResultOK = false;
    int[] sMatchingRoutesFound = new int[5];
    int[] sCountOfMatching = new int[5];
    int iRouteIndex = 0;
    Route currentRoute = null;
    RgRouteCostChangeInformation rgRCCI = null;
    CalculatedRouteListElement origialRoute = null;
    CalculatedRouteListElement betterRoute = null;
    NavSegmentID currentNavSegmentID = null;
    int iBetterRouteState = 1;
    Timer startRGTimer = null;
    boolean disableTimer = false;
    Timer shortBetterRouteAvailableInfoTimer;
    boolean isRGActive = false;
    boolean isBetterRouteIgnored = false;
    protected boolean isPopupDueToBlockingIgnored = false;
    protected boolean isPopupDefinitiveBetterIgnored = false;
    NavLocation sDestination = null;
    long sSavingTimeOfBetterRoute = -1L;
    boolean sWaitForAvailableRoute = true;
    boolean calcFurtherAltRoute = false;
    RcciEvent rcciEvent = null;
    boolean wasOnceVisible = false;
    NavLocationWgs84 rbbPoint = null;
    int rbbState = 0;
    boolean isBaseRouteReconstructable = false;
    boolean newRouteVanished = false;

    RouteCalcDataContainer() {
    }
}

