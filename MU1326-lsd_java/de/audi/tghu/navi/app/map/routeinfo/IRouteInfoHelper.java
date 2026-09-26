/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.map.routeinfo;

import de.audi.atip.hmi.intercommunication.MixedListConstants$TollGateInfo;
import de.audi.atip.hmi.model.IconCell;
import de.audi.atip.hmi.model.LongListCell;
import de.audi.atip.hmi.model.TextListCell;
import de.audi.atip.metrics.DateMetric;
import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.map.routeinfo.RouteInfoHandler$TravelData;
import org.dsi.ifc.global.NavLocation;
import org.dsi.ifc.komoview.ManeuverElement;
import org.dsi.ifc.navigation.NavLaneGuidanceData;
import org.dsi.ifc.navigation.NavPoiInfo;
import org.dsi.ifc.navigation.TurnListElement;
import org.dsi.ifc.tmc.TmcMessage;
import org.dsi.ifc.trafficregulation.RoadClassSpeedInfo;

public interface IRouteInfoHelper {
    default public IconCell createEmptyIconCell() {
    }

    default public TextListCell createEmptyTextListCell() {
    }

    default public LongListCell createZeroLongListCell() {
    }

    default public void setTravelData(RouteInfoHandler$TravelData routeInfoHandler$TravelData) {
    }

    default public long computeDistToFinalDest(long l, int n, RouteInfoHandler$TravelData routeInfoHandler$TravelData) {
    }

    default public long computeRttToFinalDest(long l, int n, RouteInfoHandler$TravelData routeInfoHandler$TravelData) {
    }

    default public long computeWholeDistance(int[] nArray) {
    }

    default public int getDefaultFormat(TurnListElement turnListElement, NavigationEnv navigationEnv) {
    }

    default public int getDefaultFormat(NavPoiInfo navPoiInfo) {
    }

    default public int getDefaultFormat(TmcMessage tmcMessage) {
    }

    default public long getDistToNextDest(Object object) {
    }

    default public int getDestinationIndex(Object object) {
    }

    default public long getRttToNextDest(Object object) {
    }

    default public boolean isTurnElement(int n) {
    }

    default public boolean isRealTurnElement(org.dsi.ifc.navigation.ManeuverElement maneuverElement) {
    }

    default public String determineDisplayName(TurnListElement turnListElement) {
    }

    default public String determineExitNumber(TurnListElement turnListElement) {
    }

    default public int findSpeedUnitForCountry(String string, RoadClassSpeedInfo[] roadClassSpeedInfoArray) {
    }

    default public String formatDistString(long l) {
    }

    default public String formatMillisecond(long l) {
    }

    default public ManeuverElement clone(org.dsi.ifc.navigation.ManeuverElement maneuverElement) {
    }

    default public boolean isWithinHorizon(long l) {
    }

    default public DateMetric createDateMetrics(long l) {
    }

    default public int getElement(TurnListElement turnListElement, int n) {
    }

    default public org.dsi.ifc.navigation.ManeuverElement getManeuverElement(TurnListElement turnListElement, int n) {
    }

    default public String getDisplayName(TurnListElement turnListElement) {
    }

    default public String getDisplayName(NavPoiInfo navPoiInfo) {
    }

    default public String getDisplayName(TmcMessage tmcMessage) {
    }

    default public MixedListConstants$TollGateInfo getTollGateInfo(NavLaneGuidanceData[] navLaneGuidanceDataArray, int n) {
    }

    default public String getDestName(int n) {
    }

    default public boolean isFinalDestination(int n) {
    }

    default public IconCell createPicNavIconCell(NavLocation navLocation) {
    }

    default public IconCell createTurnRoadIcon(int n, String string) {
    }
}

