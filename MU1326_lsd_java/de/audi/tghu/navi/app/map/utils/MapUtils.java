/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.map.utils;

import de.audi.atip.base.IFrameworkAccess;
import de.audi.atip.hmi.intercommunication.MixedListConstants$LaneGuidance;
import de.audi.atip.hmi.intercommunication.MixedListConstants$TollGateInfo;
import de.audi.atip.hmi.model.BaseListRow;
import de.audi.atip.hmi.model.IconCell;
import de.audi.atip.hmi.model.ListCell;
import de.audi.atip.hmi.model.MetricsListCell;
import de.audi.atip.hmi.model.ObjectListCell;
import de.audi.atip.log.LogChannel;
import de.audi.atip.metrics.DateMetric;
import de.audi.atip.util.StringUtilities;
import de.audi.tghu.navi.app.Navigation;
import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.map.AbstractMap;
import de.audi.tghu.navi.app.map.dsi.IMapRequest;
import de.audi.tghu.navi.app.map.handler.MapUserFlag;
import de.audi.tghu.navi.app.poi.online.OnlinePOIResultList;
import de.audi.tghu.navi.app.util.Util;
import de.esolutions.fw.util.commons.Buffer;
import java.util.Date;
import org.dsi.ifc.global.NavLocationWgs84;
import org.dsi.ifc.global.NavSegmentID;
import org.dsi.ifc.map.MapFlag;
import org.dsi.ifc.map.PosInfo;
import org.dsi.ifc.map.Rect;
import org.dsi.ifc.navigation.CalculatedRouteListElement;
import org.dsi.ifc.navigation.RouteDestination;
import org.dsi.ifc.navigation.RouteOptions;
import org.dsi.ifc.navigation.TurnListElement;
import org.dsi.ifc.online.PoiOnlineSearchValuelistElement;
import org.dsi.ifc.organizer.AddressData;

public class MapUtils {
    public static final int MAP_ADDITIONAL_INFOS_OFF;
    public static final int MAP_ADDITIONAL_INFOS_OVERVIEW;
    public static final int MAP_ADDITIONAL_INFOS_ROUTEINFO;
    public static final String UNRELIABLE_ETA;

    public static int searchUserFlag(PosInfo posInfo, MapUserFlag[] mapUserFlagArray, NavigationEnv navigationEnv) {
        if (posInfo == null || mapUserFlagArray == null) {
            navigationEnv.getMapMainLogChannel().log(-2137614336, "MapUtils#searchUserFlag(): info or userFlags is null!");
            return -1;
        }
        long l = posInfo.getObjectId();
        for (int i2 = 0; i2 < mapUserFlagArray.length; ++i2) {
            if (l != mapUserFlagArray[i2].mMapFlag.handle) continue;
            return i2;
        }
        return -1;
    }

    public static int searchUserFlag(PosInfo posInfo, MapFlag[] mapFlagArray, NavigationEnv navigationEnv) {
        if (posInfo == null || mapFlagArray == null) {
            navigationEnv.getMapMainLogChannel().log(-2137614336, "MapUtils#searchUserFlag(): info or userFlags is null!");
            return -1;
        }
        long l = posInfo.getObjectId();
        for (int i2 = 0; i2 < mapFlagArray.length; ++i2) {
            if (l != mapFlagArray[i2].handle) continue;
            return i2;
        }
        return -1;
    }

    public static AddressData extractAddressDataOfEntryType(AddressData[] addressDataArray, int n) {
        if (addressDataArray == null || addressDataArray.length == 0) {
            return null;
        }
        for (int i2 = 0; i2 < addressDataArray.length; ++i2) {
            AddressData addressData = addressDataArray[i2];
            if (addressData == null || !addressData.isTopDestination() || addressData.getAddressType() != n) continue;
            return addressData;
        }
        return null;
    }

    public static AddressData extractAddressDataOfHomeDest(AddressData[] addressDataArray) {
        if (addressDataArray == null || addressDataArray.length == 0) {
            return null;
        }
        for (int i2 = 0; i2 < addressDataArray.length; ++i2) {
            AddressData addressData = addressDataArray[i2];
            if (addressData == null || addressData.getAddressType() != 2) continue;
            return addressData;
        }
        return null;
    }

    public static boolean isOnlinePOIUserFlag(MapUserFlag mapUserFlag) {
        if (mapUserFlag == null || mapUserFlag.mMapFlag == null) {
            return false;
        }
        return MapUtils.isOnlinePOIStyletype(mapUserFlag.mMapFlag.getStyleIndex()) && mapUserFlag.mFlagType == 0;
    }

    public static boolean isRemoteHMIUserFlag(MapUserFlag mapUserFlag) {
        if (mapUserFlag == null || mapUserFlag.mMapFlag == null) {
            return false;
        }
        return MapUtils.isOnlinePOIStyletype(mapUserFlag.mMapFlag.getStyleIndex()) && mapUserFlag.mFlagType == 1;
    }

    public static boolean isPicNavFlag(MapUserFlag mapUserFlag) {
        if (mapUserFlag == null || mapUserFlag.mMapFlag == null) {
            return false;
        }
        return mapUserFlag.mMapFlag.getStyleIndex() == 35;
    }

    public static boolean isOnlinePOIStyletype(int n) {
        switch (n) {
            case 2: 
            case 3: 
            case 4: 
            case 5: 
            case 6: 
            case 7: 
            case 8: 
            case 9: 
            case 10: 
            case 11: 
            case 12: 
            case 13: 
            case 14: 
            case 15: 
            case 16: 
            case 17: 
            case 18: 
            case 19: 
            case 20: 
            case 21: 
            case 22: {
                return true;
            }
        }
        return false;
    }

    public static int contextToHMIServiceID(int n, int n2, int n3, NavigationEnv navigationEnv) {
        int n4;
        switch (n) {
            case 0: {
                n4 = n2 == 0 ? 10 : 16;
                break;
            }
            case 1: {
                n4 = n2 == 0 ? 11 : 17;
                break;
            }
            case 2: {
                n4 = n2 == 0 ? 12 : 18;
                break;
            }
            case 3: {
                n4 = n2 == 0 ? 13 : 19;
                break;
            }
            case 4: {
                n4 = n2 == 0 ? 14 : 20;
                break;
            }
            case 5: {
                n4 = n2 == 0 ? 15 : 21;
                break;
            }
            case 6: {
                n4 = n2 == 0 ? 29 : 30;
                break;
            }
            case 8: {
                n4 = n2 == 3 ? 72 : 76;
                break;
            }
            case 9: {
                n4 = 73;
                break;
            }
            case 11: {
                n4 = 55;
                break;
            }
            case 10: {
                n4 = n2 == 3 ? 74 : 77;
                break;
            }
            case 12: {
                n4 = n2 == 3 ? 53 : 54;
                break;
            }
            default: {
                navigationEnv.getMapMainLogChannel().log(-1601830656, "MapUtils#contextToHMIServiceID() - invalid context: %1, rendererID: %2, terminalID: %3", (long)n, (long)n2, (long)n3);
                n4 = n3 == 1 ? (n2 == 3 ? 72 : 76) : (n2 == 0 ? 10 : 16);
            }
        }
        return n4;
    }

    public static int hmiServiceIDToContext(int n, int n2, NavigationEnv navigationEnv) {
        int n3;
        switch (n) {
            case 10: 
            case 16: {
                n3 = 0;
                break;
            }
            case 11: 
            case 17: {
                n3 = 1;
                break;
            }
            case 12: 
            case 18: {
                n3 = 2;
                break;
            }
            case 13: 
            case 19: {
                n3 = 3;
                break;
            }
            case 14: 
            case 20: {
                n3 = 4;
                break;
            }
            case 15: 
            case 21: {
                n3 = 5;
                break;
            }
            case 29: 
            case 30: {
                n3 = 6;
                break;
            }
            case 73: {
                n3 = 9;
                break;
            }
            case 72: 
            case 76: {
                n3 = 8;
                break;
            }
            default: {
                navigationEnv.getMapMainLogChannel().log(-1601830656, "MapUtils#hmiServiceIDToContext() - invalid hmiServiceID: %1, terminalID: %2", (long)n, (long)n2);
                n3 = n2 == 1 ? 8 : 0;
            }
        }
        return n3;
    }

    public static String contextToString(int n) {
        String string;
        switch (n) {
            case 0: {
                string = "DISPLAY_CONTEXT_MAP";
                break;
            }
            case 1: {
                string = "DISPLAY_CONTEXT_MAP_INTERSECTION";
                break;
            }
            case 2: {
                string = "DISPLAY_CONTEXT_MAP_INTERSECTION_3D";
                break;
            }
            case 3: {
                string = "DISPLAY_CONTEXT_MAP_JUNCTION";
                break;
            }
            case 4: {
                string = "DISPLAY_CONTEXT_MAP_RGS";
                break;
            }
            case 5: {
                string = "DISPLAY_CONTEXT_MAP_LANDMARK";
                break;
            }
            case 6: {
                string = "DISPLAY_CONTEXT_MAP_IN_MAP";
                break;
            }
            case 9: {
                string = "DISPLAY_CONTEXT_KOMBI_KDK";
                break;
            }
            case 8: {
                string = "DISPLAY_CONTEXT_KOMBI_MAP";
                break;
            }
            default: {
                string = new StringBuffer().append("UNKNOWN_").append(n).toString();
            }
        }
        return string;
    }

    public static boolean isEqual(MapFlag mapFlag, MapFlag mapFlag2) {
        return mapFlag.getGeoX() == mapFlag2.getGeoX() && mapFlag.getGeoY() == mapFlag2.getGeoY() && mapFlag.getStyleIndex() == mapFlag2.getStyleIndex();
    }

    public static boolean isRSERouteCalcMode(IFrameworkAccess iFrameworkAccess) {
        return !iFrameworkAccess.isFrontMU() && Navigation.isRouteCalcMode();
    }

    public static boolean isUserInteractiveMap(int n) {
        switch (n) {
            case 5: 
            case 12: 
            case 13: 
            case 15: 
            case 17: 
            case 18: 
            case 26: 
            case 27: 
            case 28: 
            case 37: 
            case 39: {
                return true;
            }
        }
        return false;
    }

    public static boolean isCtxCrosshairMap(int n) {
        switch (n) {
            case 12: 
            case 13: 
            case 15: 
            case 17: 
            case 28: 
            case 37: 
            case 39: {
                return true;
            }
        }
        return false;
    }

    public static boolean isCtxPositionMap(int n) {
        return n == 6 || n == 7 || n == 8;
    }

    public static boolean isCtxAllowedInSmallStage(int n) {
        switch (n) {
            case 12: 
            case 13: {
                return false;
            }
        }
        return true;
    }

    public static boolean isCRLElementCalculated(CalculatedRouteListElement calculatedRouteListElement) {
        switch (calculatedRouteListElement.getCalculationState()) {
            case 2: 
            case 3: 
            case 5: {
                return true;
            }
        }
        return false;
    }

    public static int adjust(int n, int n2, int n3) {
        return Math.min(Math.max(n, 0), n3);
    }

    public static int convertMapTypeIndex(int n, int n2, NavigationEnv navigationEnv) {
        int n3;
        switch (n) {
            case 0: {
                n3 = 3;
                break;
            }
            case 1: {
                if (n2 == 1) {
                    n3 = 0;
                    break;
                }
                if (n2 == 0) {
                    n3 = 1;
                    break;
                }
                navigationEnv.getMapMainLogChannel().log(-2137614336, "MapUtils#convertMapTypeIndex unknown orientation: %1", (long)n2);
                n3 = -1;
                break;
            }
            case 2: {
                n3 = 2;
                break;
            }
            case 3: {
                n3 = 4;
                break;
            }
            default: {
                navigationEnv.getMapMainLogChannel().log(-2137614336, "MapUtils#convertMapTypeIndex unknown map type: %1", (long)n);
                n3 = -1;
            }
        }
        return n3;
    }

    public static String getPrettyStringOfRouteInfo(BaseListRow baseListRow) {
        Buffer buffer = new Buffer();
        switch (baseListRow.getInteger(0)) {
            case 0: {
                buffer.append("[TRUN] ").append("{").append(baseListRow.getInteger(20)).append("} ").append(baseListRow.getText(19)).append(" ").append(baseListRow.getText(18));
                break;
            }
            case 1: {
                buffer.append("[POI] ").append(baseListRow.getText(12)).append(" ").append(baseListRow.getText(13)).append(" ").append(baseListRow.getText(11));
                break;
            }
            default: {
                buffer.append("[").append(baseListRow.getInteger(0)).append("] ");
                buffer.append(baseListRow.toString());
            }
        }
        return buffer.toString();
    }

    public static String toPrettyString(RouteDestination[] routeDestinationArray) {
        Buffer buffer = new Buffer("");
        if (routeDestinationArray != null) {
            for (int i2 = 0; i2 < routeDestinationArray.length; ++i2) {
                buffer.append("RD[").append(i2).append("]={");
                RouteOptions[] routeOptionsArray = routeDestinationArray[i2].getRouteOptions();
                if (routeOptionsArray != null) {
                    for (int i3 = 0; i3 < routeOptionsArray.length; ++i3) {
                        if (routeOptionsArray[i3] == null) continue;
                        buffer.append("RO[").append(i3).append("] ");
                    }
                }
                buffer.append("} ");
            }
        } else {
            buffer.append("<NULL>");
        }
        return buffer.toString();
    }

    public static String toPrettyString(CalculatedRouteListElement calculatedRouteListElement) {
        if (calculatedRouteListElement == null) {
            return "<NULL>";
        }
        Buffer buffer = new Buffer();
        buffer.append(calculatedRouteListElement.getSegmentIDList());
        buffer.append(" [").append(calculatedRouteListElement.getCalculationPercentage()).append("%]");
        buffer.append(" State=").append(calculatedRouteListElement.getCalculationState());
        return buffer.toString();
    }

    public static boolean isRectEqual(Rect rect, Rect rect2) {
        if (rect == null && rect2 != null) {
            return false;
        }
        if (rect != null && rect2 == null) {
            return false;
        }
        if (rect != null && rect2 != null) {
            if (rect.getDiffX() != rect2.getDiffX()) {
                return false;
            }
            if (rect.getDiffY() != rect2.getDiffY()) {
                return false;
            }
            if (rect.getKordX() != rect2.getKordX()) {
                return false;
            }
            if (rect.getKordY() != rect2.getKordY()) {
                return false;
            }
        }
        return true;
    }

    public static String getDiff(CalculatedRouteListElement calculatedRouteListElement, CalculatedRouteListElement calculatedRouteListElement2, boolean bl) {
        Buffer buffer = new Buffer();
        if (calculatedRouteListElement.distance != calculatedRouteListElement2.distance && !bl) {
            buffer.append(" distance:").append(calculatedRouteListElement.distance).append("->").append(calculatedRouteListElement2.distance);
        }
        if (calculatedRouteListElement.eta != calculatedRouteListElement2.eta && !bl) {
            buffer.append(" eta:").append(calculatedRouteListElement.eta).append("->").append(calculatedRouteListElement2.eta);
        }
        if (calculatedRouteListElement.etaWithSpeedAndFlow != calculatedRouteListElement2.etaWithSpeedAndFlow && !bl) {
            buffer.append(" etaWithSpeedAndFlow:").append(calculatedRouteListElement.etaWithSpeedAndFlow).append("->").append(calculatedRouteListElement2.etaWithSpeedAndFlow);
        }
        if (calculatedRouteListElement.ecologicalFactor != calculatedRouteListElement2.ecologicalFactor) {
            buffer.append(" ecologicalFactor:").append(calculatedRouteListElement.ecologicalFactor).append("->").append(calculatedRouteListElement2.ecologicalFactor);
        }
        if (calculatedRouteListElement.motorwayLength != calculatedRouteListElement2.motorwayLength) {
            buffer.append(" motorwayLength:").append(calculatedRouteListElement.motorwayLength).append("->").append(calculatedRouteListElement2.motorwayLength);
        }
        if (calculatedRouteListElement.tollLength != calculatedRouteListElement2.tollLength) {
            buffer.append(" tollLength:").append(calculatedRouteListElement.tollLength).append("->").append(calculatedRouteListElement2.tollLength);
        }
        if (calculatedRouteListElement.tollCostAmount != calculatedRouteListElement2.tollCostAmount) {
            buffer.append(" tollCostAmount:").append(calculatedRouteListElement.tollCostAmount).append("->").append(calculatedRouteListElement2.tollCostAmount);
        }
        if (calculatedRouteListElement.tollCostCurrency != calculatedRouteListElement2.tollCostCurrency) {
            buffer.append(" tollCostCurrency:").append(calculatedRouteListElement.tollCostCurrency).append("->").append(calculatedRouteListElement2.tollCostCurrency);
        }
        if (calculatedRouteListElement.hasTunnel != calculatedRouteListElement2.hasTunnel) {
            buffer.append(" hasTunnel:").append(calculatedRouteListElement.hasTunnel).append("->").append(calculatedRouteListElement2.hasTunnel);
        }
        if (calculatedRouteListElement.hasFerry != calculatedRouteListElement2.hasFerry) {
            buffer.append(" hasFerry:").append(calculatedRouteListElement.hasFerry).append("->").append(calculatedRouteListElement2.hasFerry);
        }
        if (calculatedRouteListElement.isTimeRestricted != calculatedRouteListElement2.isTimeRestricted) {
            buffer.append(" isTimeRestricted:").append(calculatedRouteListElement.isTimeRestricted).append("->").append(calculatedRouteListElement2.isTimeRestricted);
        }
        if (calculatedRouteListElement.hasCarTrain != calculatedRouteListElement2.hasCarTrain) {
            buffer.append(" hasCarTrain:").append(calculatedRouteListElement.hasCarTrain).append("->").append(calculatedRouteListElement2.hasCarTrain);
        }
        if (calculatedRouteListElement.isSeasonalRestricted != calculatedRouteListElement2.isSeasonalRestricted) {
            buffer.append(" isSeasonalRestricted:").append(calculatedRouteListElement.isSeasonalRestricted).append("->").append(calculatedRouteListElement2.isSeasonalRestricted);
        }
        if (calculatedRouteListElement.needsVignette != calculatedRouteListElement2.needsVignette) {
            buffer.append(" needsVignette:").append(calculatedRouteListElement.needsVignette).append("->").append(calculatedRouteListElement2.needsVignette);
        }
        if (!calculatedRouteListElement.segmentIDList.toString().equals(calculatedRouteListElement2.segmentIDList.toString())) {
            buffer.append(" segmentIDList:").append(calculatedRouteListElement.segmentIDList).append("->").append(calculatedRouteListElement2.segmentIDList);
        }
        if (calculatedRouteListElement.calculationState != calculatedRouteListElement2.calculationState) {
            buffer.append(" calculationState:").append(calculatedRouteListElement.calculationState).append("->").append(calculatedRouteListElement2.calculationState);
        }
        if (calculatedRouteListElement.calculationPercentage != calculatedRouteListElement2.calculationPercentage) {
            buffer.append(" calculationPercentage:").append(calculatedRouteListElement.calculationPercentage).append("->").append(calculatedRouteListElement2.calculationPercentage);
        }
        if (calculatedRouteListElement.numberOfTmcMessages != calculatedRouteListElement2.numberOfTmcMessages) {
            buffer.append(" numberOfTmcMessages:").append(calculatedRouteListElement.numberOfTmcMessages).append("->").append(calculatedRouteListElement2.numberOfTmcMessages);
        }
        if (calculatedRouteListElement.etaWithSpeedAndFlowStatus != calculatedRouteListElement2.etaWithSpeedAndFlowStatus) {
            buffer.append(" etaWithSpeedAndFlowStatus:").append(calculatedRouteListElement.etaWithSpeedAndFlowStatus).append("->").append(calculatedRouteListElement2.etaWithSpeedAndFlowStatus);
        }
        return buffer.toString();
    }

    public static String toString(short[] sArray) {
        if (sArray == null) {
            return "null";
        }
        if (sArray.length == 0) {
            return "";
        }
        Buffer buffer = new Buffer();
        for (int i2 = 0; i2 < sArray.length; ++i2) {
            buffer.append(sArray[i2]).append(", ");
        }
        return buffer.substring(0, buffer.length() - 2);
    }

    public static String toString(float[] fArray) {
        if (fArray == null) {
            return "null";
        }
        if (fArray.length == 0) {
            return "";
        }
        Buffer buffer = new Buffer();
        for (int i2 = 0; i2 < fArray.length; ++i2) {
            buffer.append(fArray[i2]).append(", ");
        }
        return buffer.substring(0, buffer.length() - 2);
    }

    public static String toString(int[] nArray) {
        if (nArray == null) {
            return "null";
        }
        if (nArray.length == 0) {
            return "";
        }
        Buffer buffer = new Buffer();
        for (int i2 = 0; i2 < nArray.length; ++i2) {
            buffer.append(nArray[i2]).append(", ");
        }
        return buffer.substring(0, buffer.length() - 2);
    }

    public static String toString(boolean[] blArray) {
        if (blArray == null) {
            return "null";
        }
        if (blArray.length == 0) {
            return "";
        }
        Buffer buffer = new Buffer();
        for (int i2 = 0; i2 < blArray.length; ++i2) {
            buffer.append(blArray[i2]).append(", ");
        }
        return buffer.substring(0, buffer.length() - 2);
    }

    public static String toString(long[] lArray) {
        if (lArray == null) {
            return "null";
        }
        if (lArray.length == 0) {
            return "";
        }
        Buffer buffer = new Buffer();
        for (int i2 = 0; i2 < lArray.length; ++i2) {
            buffer.append(lArray[i2]).append(", ");
        }
        return buffer.substring(0, buffer.length() - 2);
    }

    public static String toString(Object[] objectArray) {
        if (objectArray == null) {
            return "null";
        }
        if (objectArray.length == 0) {
            return "";
        }
        Buffer buffer = new Buffer();
        for (int i2 = 0; i2 < objectArray.length; ++i2) {
            buffer.append(objectArray[i2]).append(", ");
        }
        return buffer.substring(0, buffer.length() - 2);
    }

    public static int findIndex(OnlinePOIResultList onlinePOIResultList, MapFlag mapFlag) {
        if (onlinePOIResultList != null && onlinePOIResultList.length() > 0) {
            for (int i2 = 0; i2 < onlinePOIResultList.length(); ++i2) {
                PoiOnlineSearchValuelistElement poiOnlineSearchValuelistElement = onlinePOIResultList.getPOIElementAt(i2);
                if (poiOnlineSearchValuelistElement.longitude != mapFlag.geoX || poiOnlineSearchValuelistElement.latitude != mapFlag.geoY) continue;
                return i2;
            }
        }
        return -1;
    }

    public static boolean isEqual(NavSegmentID navSegmentID, NavSegmentID navSegmentID2) {
        if (navSegmentID == null || navSegmentID.getElements() == null || navSegmentID2 == null || navSegmentID2.getElements() == null) {
            return false;
        }
        if (navSegmentID.getElements().length != navSegmentID2.getElements().length) {
            return false;
        }
        for (int i2 = 0; i2 < navSegmentID.getElements().length; ++i2) {
            if (navSegmentID.getElements()[i2] == navSegmentID2.getElements()[i2]) continue;
            return false;
        }
        return true;
    }

    public static boolean isPreviewMapContext(int n) {
        switch (n) {
            case 24: 
            case 30: {
                return true;
            }
        }
        return false;
    }

    public static boolean isHiddenContext(int n) {
        switch (n) {
            case 3: {
                return true;
            }
        }
        return false;
    }

    public static LogChannel getMapCommandLogChannel(NavigationEnv navigationEnv, int n) {
        switch (n) {
            case 0: {
                return navigationEnv.getLogChannel("App.Map.CMD0");
            }
            case 1: {
                return navigationEnv.getLogChannel("App.Map.CMD1");
            }
            case 2: {
                return navigationEnv.getLogChannel("App.Map.CMD2");
            }
            case 3: {
                return navigationEnv.getLogChannel("App.Map.CMD3");
            }
            case 4: {
                return navigationEnv.getLogChannel("App.Map.CMD4");
            }
        }
        return navigationEnv.getLogChannel("App.Map.Main");
    }

    public static LogChannel getMapLogChannel(NavigationEnv navigationEnv, int n) {
        switch (n) {
            case 0: {
                return navigationEnv.getLogChannel("App.Map.MapMain");
            }
            case 1: {
                return navigationEnv.getLogChannel("App.Map.MapGE");
            }
            case 2: {
                return navigationEnv.getLogChannel("App.Map.MapMinor");
            }
            case 3: {
                return navigationEnv.getLogChannel("App.Map.MapKombi");
            }
            case 4: {
                return navigationEnv.getLogChannel("App.Map.MapGE2");
            }
        }
        navigationEnv.getLogChannel("App.Navi.Main").log(10000, "MapUtils#getMapLogChannel() - Unknown map id: %1", (long)n);
        return navigationEnv.getLogChannel("App.Navi.Main");
    }

    public static LogChannel getMapGUILogChannel(NavigationEnv navigationEnv, int n) {
        switch (n) {
            case 0: {
                return navigationEnv.getLogChannel("App.Map.GUI.Main");
            }
            case 1: {
                return navigationEnv.getLogChannel("App.Map.GUI.GE");
            }
            case 2: {
                return navigationEnv.getLogChannel("App.Map.GUI.Minor");
            }
            case 3: {
                return navigationEnv.getLogChannel("App.Map.GUI.Kombi");
            }
            case 4: {
                return navigationEnv.getLogChannel("App.Map.GUI.GE2");
            }
        }
        navigationEnv.getLogChannel("App.Navi.Main").log(10000, "MapUtils#getMapGUILogChannel() - Unknown map id: %1", (long)n);
        return navigationEnv.getLogChannel("App.Navi.Main");
    }

    public static LogChannel getMapDSILogChannel(NavigationEnv navigationEnv, int n) {
        switch (n) {
            case 0: {
                return navigationEnv.getLogChannel("App.Map.DSI0");
            }
            case 1: {
                return navigationEnv.getLogChannel("App.Map.DSI1");
            }
            case 2: {
                return navigationEnv.getLogChannel("App.Map.DSI2");
            }
            case 3: {
                return navigationEnv.getLogChannel("App.Map.DSI3");
            }
            case 4: {
                return navigationEnv.getLogChannel("App.Map.DSI4");
            }
        }
        navigationEnv.getLogChannel("App.Navi.Main").log(10000, "MapUtils#getMapDSILogChannel() - Unknown map id: %1", (long)n);
        return navigationEnv.getLogChannel("App.Navi.Main");
    }

    public static LogChannel getMapDSICtrlLogChannel(NavigationEnv navigationEnv, int n) {
        switch (n) {
            case 0: {
                return navigationEnv.getLogChannel("App.Map.DSIControl0");
            }
            case 1: {
                return navigationEnv.getLogChannel("App.Map.DSIControl1");
            }
            case 2: {
                return navigationEnv.getLogChannel("App.Map.DSIControl2");
            }
            case 3: {
                return navigationEnv.getLogChannel("App.Map.DSIControl3");
            }
            case 4: {
                return navigationEnv.getLogChannel("App.Map.DSIControl4");
            }
        }
        navigationEnv.getLogChannel("App.Navi.Main").log(10000, "MapUtils#getMapDSICtrlLogChannel() - Unknown map id: %1", (long)n);
        return navigationEnv.getLogChannel("App.Navi.Main");
    }

    public static int getStyleIndexForFavorite() {
        return 113;
    }

    public static String getFingerprint(CalculatedRouteListElement calculatedRouteListElement) {
        Buffer buffer = new Buffer("");
        if (calculatedRouteListElement != null) {
            buffer.append(calculatedRouteListElement.segmentIDList).append("{").append(calculatedRouteListElement.calculationState).append("} ");
        }
        return buffer.toString();
    }

    public static String formatTime(long l) {
        DateMetric dateMetric = new DateMetric(new Date(l), 5);
        return dateMetric.format();
    }

    public static boolean isRangeMapStatusOk(int n) {
        switch (n) {
            case 1: 
            case 4: 
            case 5: 
            case 6: {
                return true;
            }
        }
        return false;
    }

    public static boolean almostEquals(NavLocationWgs84 navLocationWgs84, NavLocationWgs84 navLocationWgs842) {
        if (navLocationWgs84 != null && navLocationWgs842 != null) {
            return Math.abs(navLocationWgs84.longitude - navLocationWgs842.longitude) + Math.abs(navLocationWgs84.latitude - navLocationWgs842.latitude) < 5;
        }
        return false;
    }

    public static boolean isRouteInfoComplete(int n, boolean bl, boolean bl2) {
        return (!bl || !bl2) && n != 1;
    }

    public static boolean isAllowedFromOptionsDrawer(int n) {
        switch (n) {
            case 5: 
            case 13: 
            case 15: 
            case 18: 
            case 20: 
            case 28: 
            case 34: 
            case 37: {
                return true;
            }
        }
        return false;
    }

    public static TurnListElement[] filterRgTurnListForAsia(TurnListElement[] turnListElementArray) {
        if (turnListElementArray == null || turnListElementArray.length == 0) {
            return turnListElementArray;
        }
        int n = 0;
        for (int i2 = 0; i2 < turnListElementArray.length; ++i2) {
            if (turnListElementArray[i2] != null && turnListElementArray[i2].getType() == 4) continue;
            ++n;
        }
        TurnListElement[] turnListElementArray2 = new TurnListElement[n];
        int n2 = 0;
        for (int i3 = 0; i3 < turnListElementArray.length; ++i3) {
            if (turnListElementArray[i3] != null && turnListElementArray[i3].getType() == 4) continue;
            turnListElementArray2[n2++] = turnListElementArray[i3];
        }
        return turnListElementArray2;
    }

    public static boolean appendIfNotEmpty(Buffer buffer, String string, String string2) {
        if (string2 != null && string2.trim().length() > 0) {
            buffer.append(string).append(string2);
            return true;
        }
        buffer.append(string).append("null");
        return false;
    }

    public static String toShortString(BaseListRow baseListRow) {
        if (baseListRow == null || baseListRow.getCells() == null) {
            return "null";
        }
        ListCell[] listCellArray = baseListRow.getCells();
        Buffer buffer = new Buffer("BaseListRow: ");
        for (int i2 = 0; i2 < listCellArray.length; ++i2) {
            Object object;
            ListCell listCell = listCellArray[i2];
            if (listCell == null) continue;
            if (listCell instanceof IconCell) {
                if (((IconCell)listCellArray[i2]).getResourceLocator().getResourceID() == -1) continue;
                buffer.append(" [").append(i2).append(']');
                buffer.append("Icon");
                continue;
            }
            if (listCell instanceof ObjectListCell) {
                object = ((ObjectListCell)listCell).value;
                if (object instanceof MixedListConstants$TollGateInfo) {
                    if (((MixedListConstants$TollGateInfo)object).getTollGateTypes() == null) continue;
                    buffer.append(" [").append(i2).append(']');
                    buffer.append("TollGateInfo");
                    continue;
                }
                if (!(object instanceof MixedListConstants$LaneGuidance) || ((MixedListConstants$LaneGuidance)object).getDirectionArrow() == null) continue;
                buffer.append(" [").append(i2).append(']');
                buffer.append(object);
                continue;
            }
            if (listCell instanceof MetricsListCell) {
                object = (MetricsListCell)listCell;
                buffer.append(" [").append(i2).append(']');
                buffer.append(((MetricsListCell)object).getMetrics());
                continue;
            }
            object = listCell.toString();
            if (StringUtilities.isNullOrEmpty((CharSequence)object)) continue;
            buffer.append(" [").append(i2).append(']');
            buffer.append(listCell.toString());
        }
        return buffer.toString();
    }

    public static String getDefaultTraslatedText(int n) {
        switch (n) {
            case 13: {
                return "Off road";
            }
            case 10: {
                return "Ferry";
            }
            case 4: {
                return "Calculating...";
            }
            case 6: {
                return "Border crossing";
            }
            case 0: {
                return "Allowed";
            }
            case 3: {
                return "velocities";
            }
            case 1: {
                return "in km/h";
            }
            case 53: {
                return "Tempolimits";
            }
            case 2: {
                return "in mph";
            }
            case 9: {
                return "EXIT";
            }
        }
        return "";
    }

    public static void setMapOrientationTemporaryToNorth(AbstractMap abstractMap) {
        IMapRequest iMapRequest = abstractMap.getMVRequest();
        if (abstractMap.getMapRepresentation() == 0 && !Util.isHURegionAsia()) {
            iMapRequest.setOrientation(0);
            iMapRequest.setRotation((short)0);
        } else {
            iMapRequest.setOrientation(2);
        }
    }

    public static boolean isMapMovementBehaviorAllowedInCtxRoutesSelection(NavigationEnv navigationEnv) {
        return Util.isPorsche(navigationEnv.getFramework()) && !Util.isBentley(navigationEnv.getFramework());
    }

    public static boolean isMapRepresentationEbStandard(AbstractMap abstractMap) {
        return abstractMap.getMapRepresentation() == 0 && !Util.isHURegionAsia();
    }
}

