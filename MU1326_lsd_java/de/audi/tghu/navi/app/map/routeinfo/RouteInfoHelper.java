/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.map.routeinfo;

import de.audi.atip.hmi.intercommunication.MixedListConstants;
import de.audi.atip.hmi.model.HMIResourceLocator;
import de.audi.atip.hmi.model.IconCell;
import de.audi.atip.hmi.model.LongListCell;
import de.audi.atip.hmi.model.TextListCell;
import de.audi.atip.interapp.icon.ExtRenderingInfo;
import de.audi.atip.log.LogChannel;
import de.audi.atip.metrics.DateMetric;
import de.audi.atip.util.StringUtilities;
import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.PicNavNaviInterfaceImpl;
import de.audi.tghu.navi.app.map.routeinfo.IRouteInfoHelper;
import de.audi.tghu.navi.app.map.routeinfo.RouteInfoHandler;
import de.audi.tghu.navi.app.map.utils.MixedListRow;
import de.audi.tghu.navi.app.util.LocationFormatter;
import de.audi.tghu.navi.app.util.Util;
import de.audi.tghu.navi.app.util.addressformatting.AddressFormatter;
import de.audi.tghu.navi.app.util.addressformatting.LocationFormattingResponse;
import java.util.Date;
import org.dsi.ifc.global.NavLocation;
import org.dsi.ifc.global.ResourceLocator;
import org.dsi.ifc.komoview.ManeuverElement;
import org.dsi.ifc.navigation.NavLaneGuidanceData;
import org.dsi.ifc.navigation.NavPoiInfo;
import org.dsi.ifc.navigation.TurnListElement;
import org.dsi.ifc.tmc.TmcMessage;
import org.dsi.ifc.trafficregulation.RoadClassSpeedInfo;

public class RouteInfoHelper
implements MixedListConstants,
IRouteInfoHelper {
    protected NavigationEnv env;
    private LogChannel logger;
    protected MixedListRow.IRouteInfoEnv riEnv;
    protected RouteInfoHandler.TravelData travelData;
    protected final DateMetric dateMetric = new DateMetric(new Date(), 5);
    public static int MANEUVERELEMENTELEMENT_NONE = -1;

    public RouteInfoHelper(NavigationEnv navigationEnv, LogChannel logChannel, MixedListRow.IRouteInfoEnv iRouteInfoEnv) {
        this.env = navigationEnv;
        this.logger = logChannel;
        this.riEnv = iRouteInfoEnv;
    }

    protected LogChannel getLogger() {
        return this.logger;
    }

    public void setTravelData(RouteInfoHandler.TravelData travelData) {
        this.logger.log(10000000, "RouteInfoHelper#setTravelData()");
        this.travelData = travelData;
    }

    public long computeDistToFinalDest(long l, int n, RouteInfoHandler.TravelData travelData) {
        if (travelData != null && travelData.rgDestinationInfo != null && travelData.rgDestinationInfo.length > n && n >= 0) {
            return l + (long)travelData.rgDestinationInfo[n].endDistance;
        }
        this.getLogger().log(100000, "RouteInfoHelper#computeDistToFinalDest() - invalid TravelData: %1", (Object)travelData);
        return 0L;
    }

    public long computeRttToFinalDest(long l, int n, RouteInfoHandler.TravelData travelData) {
        try {
            if (travelData != null && travelData.isTravelDataValid()) {
                if (n == travelData.rgDestinationInfo.length - 1) {
                    return l;
                }
                return l + (long)(travelData.rgDestinationInfo[n + 1].remainingTravelTime / 1000);
            }
            this.getLogger().log(100000, "RouteInfoHelper#computeRttToFinalDest() - invalid Travel data - return 0 as RttToFinalDest! ");
            return 0L;
        }
        catch (Exception exception) {
            this.getLogger().log(100000, "RouteInfoHelper#computeRttToFinalDest() - invalid Travel data cause array out of bounds, destIndex: %1", (long)n);
            return 0L;
        }
    }

    public long computeWholeDistance(int[] nArray) {
        long l = 0L;
        for (int i2 = 0; i2 < nArray.length; ++i2) {
            l += (long)nArray[i2];
        }
        return l;
    }

    public int getDefaultFormat(TurnListElement turnListElement, NavigationEnv navigationEnv) {
        int n = turnListElement.getManeuver()[0].getElement();
        int n2 = -1;
        switch (turnListElement.getType()) {
            case 1: {
                if (RouteInfoHelper.isLaneGuidanceInfoElement(turnListElement, navigationEnv)) {
                    n2 = 70;
                    break;
                }
                n2 = 0;
                break;
            }
            case 3: {
                n2 = 70;
                break;
            }
            case 8: {
                n2 = 89;
                break;
            }
            case 9: {
                n2 = 90;
                break;
            }
            case 10: {
                n2 = 91;
                break;
            }
            case 11: {
                n2 = 91;
                break;
            }
            case 14: {
                n2 = 91;
                break;
            }
            case 4: {
                n2 = 92;
                break;
            }
            case 13: {
                n2 = 84;
                break;
            }
            case 2: {
                n2 = 94;
                break;
            }
            case 12: {
                n2 = 88;
                break;
            }
            case 6: {
                n2 = -1;
                break;
            }
            case 7: {
                n2 = 82;
                break;
            }
            case 0: {
                n2 = this.getManeuver(turnListElement, n);
                break;
            }
            default: {
                n2 = this.getManeuver(turnListElement, n);
            }
        }
        return n2;
    }

    private int getManeuver(TurnListElement turnListElement, int n) {
        if (turnListElement.getManeuver() == null || turnListElement.getManeuver().length == 0) {
            return -1;
        }
        if (n == 136) {
            return 8;
        }
        if (n == 3) {
            return 16;
        }
        return 0;
    }

    public int getDefaultFormat(NavPoiInfo navPoiInfo) {
        if (navPoiInfo == null) {
            return -1;
        }
        switch (navPoiInfo.type) {
            case 1: 
            case 2: {
                return 88;
            }
        }
        return 1;
    }

    public int getDefaultFormat(TmcMessage tmcMessage) {
        if (tmcMessage == null) {
            return -1;
        }
        if (Util.isPorsche(this.env.getFramework()) || Util.isBentley(this.env.getFramework())) {
            return 2;
        }
        if (Util.isHURegionAsia()) {
            return 22;
        }
        if (tmcMessage.getMessageSource() == 5) {
            return 18;
        }
        if (tmcMessage.getEventDelayOnRoute() > 0L) {
            return 21;
        }
        return 2;
    }

    public long getDistToNextDest(Object object) {
        if (object instanceof TurnListElement) {
            return ((TurnListElement)object).distance;
        }
        if (object instanceof NavPoiInfo) {
            return ((NavPoiInfo)object).distance;
        }
        if (object instanceof TmcMessage) {
            return ((TmcMessage)object).distanceToEvent;
        }
        return 0L;
    }

    public int getDestinationIndex(Object object) {
        if (object instanceof TurnListElement) {
            return ((TurnListElement)object).destinationIndex;
        }
        if (object instanceof NavPoiInfo) {
            return ((NavPoiInfo)object).destinationIndex;
        }
        if (object instanceof TmcMessage) {
            return ((TmcMessage)object).destinationIndex;
        }
        return 0;
    }

    public long getRttToNextDest(Object object) {
        if (object instanceof TurnListElement) {
            TurnListElement turnListElement = (TurnListElement)object;
            return turnListElement.etaWithTimeDelay != 0L ? turnListElement.etaWithTimeDelay : turnListElement.eta;
        }
        if (object instanceof NavPoiInfo) {
            return ((NavPoiInfo)object).remainingTime / 1000L;
        }
        if (object instanceof TmcMessage) {
            return ((TmcMessage)object).startTimeToDestination;
        }
        return 0L;
    }

    public boolean isTurnElement(int n) {
        boolean bl = false;
        switch (n) {
            case 0: 
            case 6: 
            case 7: 
            case 8: 
            case 9: 
            case 10: {
                bl = true;
                break;
            }
            default: {
                bl = false;
            }
        }
        return bl;
    }

    public boolean isRealTurnElement(org.dsi.ifc.navigation.ManeuverElement maneuverElement) {
        return maneuverElement != null && maneuverElement.getElement() < 128;
    }

    public String determineDisplayName(TurnListElement turnListElement) {
        String string = turnListElement.getTurnToStreet();
        String string2 = turnListElement.getSignPostInfo();
        if (!Util.isEmpty(string2)) {
            string = string2;
        }
        if (Util.isHURegionNAR() && turnListElement.maneuver != null) {
            for (int i2 = 0; i2 < turnListElement.maneuver.length; ++i2) {
                if (turnListElement.maneuver[i2].getElement() != 256) continue;
                string = "\u25ca " + string;
                break;
            }
        }
        return string;
    }

    public String determineExitNumber(TurnListElement turnListElement) {
        return turnListElement.getExitNumber();
    }

    public int findSpeedUnitForCountry(String string, RoadClassSpeedInfo[] roadClassSpeedInfoArray) {
        if (!Util.isEmpty(string) && roadClassSpeedInfoArray != null) {
            for (int i2 = 0; i2 < roadClassSpeedInfoArray.length; ++i2) {
                RoadClassSpeedInfo roadClassSpeedInfo = roadClassSpeedInfoArray[i2];
                if (roadClassSpeedInfo == null || !string.equals(roadClassSpeedInfo.getCountryAbbreviation())) continue;
                return roadClassSpeedInfo.getSpeedUnit();
            }
        }
        return 0;
    }

    public String formatDistString(long l) {
        if (l > 30L) {
            if (Util.isHURegionAsia()) {
                return Util.formatDistance((int)l, 5);
            }
            return StringUtilities.formatMessage("%1 %2", new String[]{this.env.getTranslatedText(16, "in"), Util.formatDistance((int)l, 5)});
        }
        return "";
    }

    public String formatMillisecond(long l) {
        if (l == 0L) {
            return "";
        }
        this.dateMetric.setDate(l);
        return this.dateMetric.format();
    }

    public ManeuverElement clone(org.dsi.ifc.navigation.ManeuverElement maneuverElement) {
        return new ManeuverElement(maneuverElement.getElement(), maneuverElement.getDirection(), maneuverElement.getAttribute());
    }

    public boolean isWithinHorizon(long l) {
        return l <= 500L;
    }

    public DateMetric createDateMetrics(long l) {
        return new DateMetric(new Date(l), 5);
    }

    public int getElement(TurnListElement turnListElement, int n) {
        if (turnListElement != null && turnListElement.maneuver != null && 0 <= n && n < turnListElement.maneuver.length) {
            return turnListElement.maneuver[n].element;
        }
        this.getLogger().log(100000000, "RouteInfoHelper#getElement() - tle.maneuver[%1].element not found", (long)n);
        return MANEUVERELEMENTELEMENT_NONE;
    }

    public org.dsi.ifc.navigation.ManeuverElement getManeuverElement(TurnListElement turnListElement, int n) {
        if (turnListElement != null && turnListElement.maneuver != null) {
            for (int i2 = 0; i2 < turnListElement.maneuver.length; ++i2) {
                if (turnListElement.maneuver[i2] == null || turnListElement.maneuver[i2].getElement() != n) continue;
                return turnListElement.maneuver[i2];
            }
        }
        return null;
    }

    public String getDisplayName(TurnListElement turnListElement) {
        int n;
        String string = turnListElement.getTurnToStreet();
        String string2 = turnListElement.getSignPostInfo();
        if (!Util.isEmpty(string2)) {
            string = string2;
        }
        if ((n = this.getElement(turnListElement, 0)) == 3 || n == 4 || n == 5) {
            string = this.riEnv.getDestName(turnListElement.destinationIndex);
        }
        return string;
    }

    public String getDisplayName(NavPoiInfo navPoiInfo) {
        String string = "";
        if (navPoiInfo != null && navPoiInfo.poiLocations != null && navPoiInfo.poiLocations.length > 0) {
            string = LocationFormatter.formatPOIName(navPoiInfo.getPoiLocations()[0]);
            this.getLogger().log(100000000, "RouteInfoHelper#getDisplayName(NavPoiInfo) - %1", (Object)string);
        } else {
            this.getLogger().log(100000000, "RouteInfoHelper#getDisplayName(NavPoiInfo) - empty");
        }
        return string;
    }

    public String getDisplayName(TmcMessage tmcMessage) {
        String string = "";
        if (tmcMessage != null && tmcMessage.eventText != null && tmcMessage.eventText.length > 0) {
            string = tmcMessage.eventText[0];
            this.getLogger().log(100000000, "RouteInfoHelper#getDisplayName(TmcMessage) - %1", (Object)string);
        } else {
            this.getLogger().log(100000, "RouteInfoHelper#getDisplayName(TmcMessage) - empty");
        }
        return string;
    }

    public static String getFormattedCityDistrict(NavLocation navLocation, NavigationEnv navigationEnv) {
        String string = "";
        if (navLocation != null) {
            LocationFormattingResponse locationFormattingResponse = AddressFormatter.formatTwoLines(navLocation, navigationEnv);
            int n = navigationEnv.getFramework().getLanguageMgr().getCurrentLanguage("LANG_COMPONENT_HMI").getLanguageIndex();
            string = n == 14 || n == 23 || n == 24 || n == 12 || n == 16 ? Util.concat2StringsWithComma(locationFormattingResponse.getSecondLineAsText(), locationFormattingResponse.getFirstLineAsText()) : Util.concat2StringsWithComma(locationFormattingResponse.getFirstLineAsText(), locationFormattingResponse.getSecondLineAsText());
        }
        return string;
    }

    public static String getFormattedCityDistrict2(NavLocation navLocation, NavigationEnv navigationEnv) {
        String string = "";
        if (navLocation != null) {
            LocationFormattingResponse locationFormattingResponse = AddressFormatter.formatTwoLines(navLocation, navigationEnv);
            int n = navigationEnv.getFramework().getLanguageMgr().getCurrentLanguage("LANG_COMPONENT_HMI").getLanguageIndex();
            string = n == 14 || n == 23 || n == 24 || n == 12 || n == 16 ? locationFormattingResponse.getSecondLineAsText() : locationFormattingResponse.getSecondLineAsText();
        }
        return string;
    }

    public MixedListConstants.TollGateInfo getTollGateInfo(NavLaneGuidanceData[] navLaneGuidanceDataArray, int n) {
        if (navLaneGuidanceDataArray == null || navLaneGuidanceDataArray.length == 0) {
            return null;
        }
        int n2 = navLaneGuidanceDataArray.length > n ? n : navLaneGuidanceDataArray.length;
        MixedListConstants.TollgateType_enum[] tollgateType_enumArray = new MixedListConstants.TollgateType_enum[n2];
        for (int i2 = 0; i2 < n2; ++i2) {
            short s = navLaneGuidanceDataArray[i2].laneType;
            switch (s) {
                case 1: {
                    tollgateType_enumArray[i2] = MixedListConstants.TollgateType_enum.ETC_DEDICATED;
                    break;
                }
                case 2: {
                    tollgateType_enumArray[i2] = MixedListConstants.TollgateType_enum.ETC_AND_GENERAL_COMBINED;
                    break;
                }
                case 3: {
                    tollgateType_enumArray[i2] = MixedListConstants.TollgateType_enum.ETC_GENERAL_ONLY;
                    break;
                }
                case 4: {
                    tollgateType_enumArray[i2] = MixedListConstants.TollgateType_enum.ETC_LANE_OMIT;
                    break;
                }
                default: {
                    this.getLogger().log(100000, "RouteInfoHelper#getTollGateInfo() - %1 : unknown ETC type or type currently not handled!", (long)s);
                    tollgateType_enumArray[i2] = MixedListConstants.TollgateType_enum.ETC_UNKNOWN;
                }
            }
            if (navLaneGuidanceDataArray.length <= n || i2 != n - 1) continue;
            tollgateType_enumArray[i2] = MixedListConstants.TollgateType_enum.ETC_LANE_OMIT;
            break;
        }
        MixedListConstants.TollGateInfo tollGateInfo = new MixedListConstants.TollGateInfo();
        tollGateInfo.setTollGateTypes(tollgateType_enumArray);
        return tollGateInfo;
    }

    public static boolean isLaneGuidanceInfoElement(TurnListElement turnListElement, NavigationEnv navigationEnv) {
        if (turnListElement == null) {
            return false;
        }
        if (Util.isClusterMMI(navigationEnv.getFramework())) {
            return false;
        }
        if (turnListElement.getType() == 4) {
            return false;
        }
        return turnListElement.getLaneGuidance() != null && turnListElement.getLaneGuidance().length != 0;
    }

    public String getDestName(int n) {
        String string = "---";
        int n2 = -1;
        if (this.travelData != null && this.travelData.rgDestinationInfo != null && this.travelData.rgDestinationInfo.length > 0) {
            n2 = this.travelData.rgDestinationInfo.length - 1;
        }
        if (n2 >= 0 && n >= 0 && n <= n2) {
            string = n == this.travelData.rgDestinationInfo.length - 1 ? this.env.getTranslatedText(14, "Destination") : this.env.getTranslatedText(21, "Stopover");
        }
        this.getLogger().log(10000000, "RouteInfoHelper#getDestName( %2 ) - finalDestinationIndex=%3, name=%1", (Object)string, (long)n, (long)n2);
        return string;
    }

    public boolean isFinalDestination(int n) {
        return n >= 0 && this.travelData != null && this.travelData.rgDestinationInfo != null && this.travelData.rgDestinationInfo.length > 0 && n == this.travelData.rgDestinationInfo.length - 1;
    }

    public IconCell createPicNavIconCell(NavLocation navLocation) {
        ResourceLocator resourceLocator;
        int n = -1;
        String string = HMIResourceLocator.UNDEFINED_URI;
        if (navLocation != null && PicNavNaviInterfaceImpl.isPicNavLocationStatic(navLocation) && (resourceLocator = PicNavNaviInterfaceImpl.getPictureFromPicNavLocationStatic(navLocation)) != null) {
            n = resourceLocator.getId();
            string = resourceLocator.getUrl();
            if (n != -1 || string != HMIResourceLocator.UNDEFINED_URI) {
                return new IconCell(new HMIResourceLocator(n, string));
            }
        }
        return null;
    }

    public IconCell createTurnRoadIcon(int n, String string) {
        ExtRenderingInfo extRenderingInfo = null;
        if (!Util.isEmpty(string)) {
            extRenderingInfo = this.riEnv.getIconHandler().resolveStreetIconResourceID(n, string.length());
        } else {
            this.getLogger().log(100000000, "MixedListRow#updateTurnDefault(): Street icon text not available");
        }
        if (extRenderingInfo != null && extRenderingInfo.isValid()) {
            if (this.getLogger().isDebug2()) {
                this.getLogger().log(100000000, "MixedListRow#updateTurnDefault(): Street icon is available, Resource Id is: (%1), and StreetIconText is (%2)", (Object)String.valueOf(extRenderingInfo.getResourceId()), (Object)string);
            }
            return new IconCell(new HMIResourceLocator(extRenderingInfo.getResourceId()), string, extRenderingInfo.getFontReference(), extRenderingInfo.getFontSize(), extRenderingInfo.getFontColor(), extRenderingInfo.getDeltaX(), extRenderingInfo.getDeltaY());
        }
        this.getLogger().log(100000000, "MixedListRow#updateTurnDefault(): Street icon not available");
        return this.createEmptyIconCell();
    }

    public IconCell createEmptyIconCell() {
        return new IconCell(new HMIResourceLocator(-1));
    }

    public TextListCell createEmptyTextListCell() {
        return new TextListCell("");
    }

    public LongListCell createZeroLongListCell() {
        return new LongListCell(0L);
    }
}

