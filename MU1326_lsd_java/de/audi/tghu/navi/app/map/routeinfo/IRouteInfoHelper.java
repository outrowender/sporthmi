/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.map.routeinfo;

import de.audi.atip.hmi.intercommunication.MixedListConstants;
import de.audi.atip.hmi.model.IconCell;
import de.audi.atip.hmi.model.LongListCell;
import de.audi.atip.hmi.model.TextListCell;
import de.audi.atip.metrics.DateMetric;
import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.map.routeinfo.RouteInfoHandler;
import org.dsi.ifc.global.NavLocation;
import org.dsi.ifc.komoview.ManeuverElement;
import org.dsi.ifc.navigation.NavLaneGuidanceData;
import org.dsi.ifc.navigation.NavPoiInfo;
import org.dsi.ifc.navigation.TurnListElement;
import org.dsi.ifc.tmc.TmcMessage;
import org.dsi.ifc.trafficregulation.RoadClassSpeedInfo;

public interface IRouteInfoHelper {
    public IconCell createEmptyIconCell();

    public TextListCell createEmptyTextListCell();

    public LongListCell createZeroLongListCell();

    public void setTravelData(RouteInfoHandler.TravelData var1);

    public long computeDistToFinalDest(long var1, int var3, RouteInfoHandler.TravelData var4);

    public long computeRttToFinalDest(long var1, int var3, RouteInfoHandler.TravelData var4);

    public long computeWholeDistance(int[] var1);

    public int getDefaultFormat(TurnListElement var1, NavigationEnv var2);

    public int getDefaultFormat(NavPoiInfo var1);

    public int getDefaultFormat(TmcMessage var1);

    public long getDistToNextDest(Object var1);

    public int getDestinationIndex(Object var1);

    public long getRttToNextDest(Object var1);

    public boolean isTurnElement(int var1);

    public boolean isRealTurnElement(org.dsi.ifc.navigation.ManeuverElement var1);

    public String determineDisplayName(TurnListElement var1);

    public String determineExitNumber(TurnListElement var1);

    public int findSpeedUnitForCountry(String var1, RoadClassSpeedInfo[] var2);

    public String formatDistString(long var1);

    public String formatMillisecond(long var1);

    public ManeuverElement clone(org.dsi.ifc.navigation.ManeuverElement var1);

    public boolean isWithinHorizon(long var1);

    public DateMetric createDateMetrics(long var1);

    public int getElement(TurnListElement var1, int var2);

    public org.dsi.ifc.navigation.ManeuverElement getManeuverElement(TurnListElement var1, int var2);

    public String getDisplayName(TurnListElement var1);

    public String getDisplayName(NavPoiInfo var1);

    public String getDisplayName(TmcMessage var1);

    public MixedListConstants.TollGateInfo getTollGateInfo(NavLaneGuidanceData[] var1, int var2);

    public String getDestName(int var1);

    public boolean isFinalDestination(int var1);

    public IconCell createPicNavIconCell(NavLocation var1);

    public IconCell createTurnRoadIcon(int var1, String var2);
}

