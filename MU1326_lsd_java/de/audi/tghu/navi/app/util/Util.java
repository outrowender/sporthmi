/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.util;

import de.audi.atip.base.IFrameworkAccess;
import de.audi.atip.hmi.model.IntegerListCell;
import de.audi.atip.hmi.modelaccess.HMIModelApp;
import de.audi.atip.hmi.modelaccess.LabelModelApp;
import de.audi.atip.hmi.modelaccess.ListModelApp;
import de.audi.atip.hmi.modelaccess.RangeModelApp;
import de.audi.atip.i18n.I18NTarget;
import de.audi.atip.interapp.NavigationUtilities;
import de.audi.atip.interapp.locationaccessor.IMyLocationAccessor;
import de.audi.atip.interapp.maptmc.MapTmcMessage;
import de.audi.atip.log.LogChannel;
import de.audi.atip.metrics.DateMetric;
import de.audi.atip.metrics.Distance;
import de.audi.atip.metrics.Temperature;
import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.util.IMyLocationAccessorFactory;
import de.audi.tghu.navi.app.util.LocationFormatter;
import de.audi.tghu.navi.app.util.MMIInternalData;
import de.audi.tghu.navi.app.util.PCLocationAccessorFactory;
import de.esolutions.fw.util.commons.Buffer;
import java.text.DecimalFormat;
import java.util.Date;
import org.dsi.ifc.global.NavLocation;
import org.dsi.ifc.global.NavLocationWgs84;
import org.dsi.ifc.global.NavRectangle;
import org.dsi.ifc.navigation.CalculatedRouteListElement;
import org.dsi.ifc.navigation.LIValueList;
import org.dsi.ifc.navigation.LIValueListElement;
import org.dsi.ifc.navigation.PosPosition;
import org.dsi.ifc.search.SearchResult;
import org.dsi.ifc.search.Token;
import org.dsi.ifc.tmc.TmcMessage;

public class Util {
    public static final int DIRECTION_STRAIGHT = 0;
    public static final int DIRECTION_STRAIGHT_RIGHT = 1;
    public static final int DIRECTION_RIGHT = 2;
    public static final int DIRECTION_BEHIND_RIGHT = 3;
    public static final int DIRECTION_BEHIND = 4;
    public static final int DIRECTION_BEHIND_LEFT = 5;
    public static final int DIRECTION_LEFT = 6;
    public static final int DIRECTION_STRAIGHT_LEFT = 7;
    public static final float NNE = 337.5f;
    public static final float ENE = 292.5f;
    public static final float ESE = 247.5f;
    public static final float SSE = 202.5f;
    public static final float SSW = 157.5f;
    public static final float WSW = 112.5f;
    public static final float WNW = 67.5f;
    public static final float NNW = 22.5f;
    public static final double EARTHEQUATORRADIUS = 6371000.8;
    public static final int MEDIUM_UNKNWON = -1;
    public static final int MEDIUM_HDD = 0;
    public static final int MEDIUM_SD_1 = 1;
    public static final int MEDIUM_SD_2 = 2;
    public static final int MEDIUM_INTERNAL_DRIVE = 3;
    public static final String INVALID_ETA = "--:--";
    public static final String INVALID_RTT = "---";
    public static final String INVALID_DISTANCE_KM_PREFIX = "--";
    public static final String INVALID_DISTANCE_MILES_PREFIX = "--";
    public static final String INVALID_DISTANCE_NULL_AT_KOMBI_WITHOUT_TEXT_FOR_UNIT = "";
    public static final String INVALID_DISTANCE_FALLBACK_NO_TEXTTOOL_KM = "-- km";
    public static final String INVALID_DISTANCE_FALLBACK_NO_TEXTTOOL_MILES = "-- mi";
    public static final String ROUTEINFO_APPENDSTRING_HOVLANE = "\u25ca ";
    public static final String AFTER_TRADITIONAL = "\u5f8c";
    public static final String CAUSE = "\u5f15\u8d77";
    public static final String CAR_JAM = "\u8eca\u8f1b\u64c1\u5835";
    public static final String AFTER_SIMPLIFIED = "\u540e";
    public static final String IN_FRONT_JAPANESE = "\u5148";
    public static final String TRAFFIC_JAM = "\u4ea4\u901a\u62e5\u5835";
    public static final String DUE_TO_JAPANESE = "\u306e\u70ba";
    public static final String LENGHT_JAPANESE = "\u9577\u3055";
    public static final String CONGESTION_JAPANESE = "\u6e0b\u6ede";
    public static final String IN_FRONT_KOREAN = "\uc804\ubc29";
    public static final String DUE_TO_KOREAN = "\ub85c";
    public static final String CAUSE_KOREAN = "\uc778\ud55c";
    public static final String LENGTH_KOREAN = "\ub3d9\uc548";
    public static final String CONGESTION_KOREAN = "\uc815\uccb4";
    public static final String COMING_KOREAN = "\uc73c";
    private static final Distance distance = new Distance(0.0f, 1);
    private static final Distance height = new Distance(0.0f, 1);
    private static final DateMetric dateMetric = new DateMetric(new Date(), 2);
    private static final MMIInternalData tmpInternalData = new MMIInternalData();
    public static int region;
    private static IMyLocationAccessorFactory locationAccessorFactory;
    public static final int ASCII_FOR_DOT = 46;

    public static boolean isEmpty(String string) {
        return string == null || string.length() == 0 || Util.hasStringOnlyWhitespaces(string);
    }

    public static String getFirstNotEmpty(String string, String string2) {
        if (!Util.isEmpty(string)) {
            return string;
        }
        if (!Util.isEmpty(string2)) {
            return string2;
        }
        return INVALID_DISTANCE_NULL_AT_KOMBI_WITHOUT_TEXT_FOR_UNIT;
    }

    private static boolean hasStringOnlyWhitespaces(String string) {
        for (int i2 = 0; i2 < string.length(); ++i2) {
            if (Character.isWhitespace(string.charAt(i2))) continue;
            return false;
        }
        return true;
    }

    public static String deleteWhiteSpaces(String string) {
        return Util.deleteCharacter(string, ' ');
    }

    public static String deleteDash(String string) {
        return Util.deleteCharacter(string, '-');
    }

    private static String deleteCharacter(String string, char c2) {
        StringBuffer stringBuffer = new StringBuffer(string);
        for (int i2 = 0; i2 < stringBuffer.length(); ++i2) {
            if (stringBuffer.charAt(i2) != c2) continue;
            stringBuffer.deleteCharAt(i2);
            --i2;
        }
        return stringBuffer.toString();
    }

    public static int stringLength(String string) {
        return string == null ? 0 : string.length();
    }

    public static boolean hasCharacter(String string, int n) {
        int n2 = -1;
        if (!Util.isEmpty(string)) {
            n2 = string.indexOf(n);
        }
        return n2 != -1;
    }

    public static boolean hasValue(int[] nArray, int n) {
        boolean bl = false;
        if (nArray != null) {
            for (int i2 = 0; !bl && i2 < nArray.length; ++i2) {
                bl = nArray[i2] == n;
            }
        }
        return bl;
    }

    public static void setModelStatus(HMIModelApp hMIModelApp, int n) {
        int n2 = hMIModelApp.getStatus();
        if (n2 != n) {
            hMIModelApp.setStatus(n);
        }
    }

    public static void beginTransaction(HMIModelApp hMIModelApp) {
        if (!hMIModelApp.isTransactionRunning()) {
            hMIModelApp.beginTransaction();
        }
    }

    public static void endTransaction(HMIModelApp hMIModelApp) {
        if (hMIModelApp.isTransactionRunning()) {
            hMIModelApp.endTransaction();
        }
    }

    public static synchronized String formatDistance(int n, int n2) {
        return Util.formatDistance(n, n2, 0);
    }

    public static String formatJapaneseYen(long l, int n) {
        DecimalFormat decimalFormat = new DecimalFormat("#,###");
        if (n == 13) {
            return "\u00a5" + decimalFormat.format(l);
        }
        if (n == 12) {
            return decimalFormat.format(l) + "\u5186";
        }
        return null;
    }

    public static synchronized String formatDistance(int n, int n2, int n3, String string) {
        if (n >= 0) {
            distance.setValue((float)n / 1000.0f);
            return distance.format(Distance.getSystemUnit(), n2, n3);
        }
        return string;
    }

    public static synchronized String formatDistance(int n, int n2, int n3) {
        if (n >= 0) {
            distance.setValue((float)n / 1000.0f);
            return distance.format(Distance.getSystemUnit(), n2, n3);
        }
        return Util.getInvalidDistance();
    }

    public static synchronized float getFormattedDistance() {
        return distance.getFormattedDistance();
    }

    public static synchronized int getFormattedUnit() {
        return distance.getFormattedUnit();
    }

    public static synchronized int getFormattedHeight() {
        return height.getFormattedHeight();
    }

    public static synchronized int getFormattedHeightUnit() {
        return height.getFormattedUnit();
    }

    public static String getInvalidDistance() {
        String string;
        int n = Distance.getSystemUnit();
        string = n == 2 || n == 3 ? ((string = Distance.getText(1)) == null || string.length() == 0 ? INVALID_DISTANCE_FALLBACK_NO_TEXTTOOL_MILES : "--" + string) : ((string = Distance.getText(0)) == null || string.length() == 0 ? INVALID_DISTANCE_FALLBACK_NO_TEXTTOOL_KM : "--" + string);
        return string;
    }

    public static synchronized String formatDate(long l) {
        if (l >= 0L) {
            dateMetric.setDate(l);
            return dateMetric.format();
        }
        return INVALID_DISTANCE_NULL_AT_KOMBI_WITHOUT_TEXT_FOR_UNIT;
    }

    public static synchronized String formatTime(long l, int n, NavigationEnv navigationEnv) {
        if (l >= 0L) {
            DateMetric dateMetric = new DateMetric(new Date(), 1);
            dateMetric.setDate(l);
            return dateMetric.format(0, n);
        }
        return INVALID_DISTANCE_NULL_AT_KOMBI_WITHOUT_TEXT_FOR_UNIT;
    }

    public static synchronized String formatTrafficOffsetDuration(long l, int n, NavigationEnv navigationEnv) {
        if (l >= 0L) {
            DateMetric dateMetric = new DateMetric(new Date(), 7);
            dateMetric.setDate(l);
            return dateMetric.format(7, n);
        }
        return INVALID_DISTANCE_NULL_AT_KOMBI_WITHOUT_TEXT_FOR_UNIT;
    }

    public static synchronized String formatDuration(long l, int n, NavigationEnv navigationEnv) {
        if (l >= 0L) {
            DateMetric dateMetric = new DateMetric(new Date(), 3);
            dateMetric.setDate(l);
            return dateMetric.format(1, n);
        }
        return INVALID_DISTANCE_NULL_AT_KOMBI_WITHOUT_TEXT_FOR_UNIT;
    }

    public static synchronized String formatHeight(int n) {
        height.setValue((float)n / 1000.0f);
        return height.formatByMode(2);
    }

    public static final int convertRotatingDirection(int n, int n2) {
        int n3 = 0;
        float f2 = (360 + n - n2) % 360;
        if (337.5f <= f2 || f2 < 22.5f) {
            n3 = 0;
        } else if (22.5f <= f2 && f2 < 67.5f) {
            n3 = 7;
        } else if (67.5f <= f2 && f2 < 112.5f) {
            n3 = 6;
        } else if (112.5f <= f2 && f2 < 157.5f) {
            n3 = 5;
        } else if (157.5f <= f2 && f2 < 202.5f) {
            n3 = 4;
        } else if (202.5f <= f2 && f2 < 247.5f) {
            n3 = 3;
        } else if (247.5f <= f2 && f2 < 292.5f) {
            n3 = 2;
        } else if (292.5f <= f2 && f2 < 337.5f) {
            n3 = 1;
        }
        return n3;
    }

    public static final String directionToArrow(int n) {
        switch (n) {
            case 0: {
                return "\u21d1";
            }
            case 1: {
                return "\u21d7";
            }
            case 2: {
                return "\u21d2";
            }
            case 3: {
                return "\u21d8";
            }
            case 4: {
                return "\u21d3";
            }
            case 5: {
                return "\u21d9";
            }
            case 6: {
                return "\u21d0";
            }
            case 7: {
                return "\u21d6";
            }
        }
        return String.valueOf(n);
    }

    public static final boolean isGoogleEarthPresent(IFrameworkAccess iFrameworkAccess) {
        return iFrameworkAccess.getSysConst(479) == 1;
    }

    public static final boolean isGoogleMapRestricted(IFrameworkAccess iFrameworkAccess) {
        return iFrameworkAccess.getSysConst(4436) == 1;
    }

    public static final boolean isGoogleMapRestrictedPoiOnly(IFrameworkAccess iFrameworkAccess) {
        return iFrameworkAccess.getSysConst(4436) == 2;
    }

    public static final boolean isPoiWarningPresent() {
        return true;
    }

    public static final boolean isPictureNavPresent(IFrameworkAccess iFrameworkAccess) {
        return iFrameworkAccess.getSysConst(489) == 1;
    }

    public static final boolean isRangeMapDisplayPresent(IFrameworkAccess iFrameworkAccess) {
        return iFrameworkAccess.getSysConst(3834) == 1;
    }

    public static final boolean isRangeMapModeBEV(IFrameworkAccess iFrameworkAccess) {
        return iFrameworkAccess.getSysConst(468) == 7;
    }

    public static final boolean isRangeMapModePHEV(IFrameworkAccess iFrameworkAccess) {
        return iFrameworkAccess.getSysConst(468) == 9;
    }

    public static final boolean isPreviewMapPresent(IFrameworkAccess iFrameworkAccess) {
        return iFrameworkAccess.getSysConst(556) == 1;
    }

    public static final boolean isWeatherOnMapPresent(IFrameworkAccess iFrameworkAccess) {
        return iFrameworkAccess.getSysConst(4462) == 1;
    }

    public static final boolean isTrailerModeAvailable(IFrameworkAccess iFrameworkAccess) {
        return iFrameworkAccess.getSysConst(4456) == 1;
    }

    public static final boolean isCityModelModeAvailable(IFrameworkAccess iFrameworkAccess) {
        return !Util.isEvoScale(iFrameworkAccess);
    }

    public static final boolean is3DLandmarksAvailable(IFrameworkAccess iFrameworkAccess) {
        return !Util.isEvoScale(iFrameworkAccess);
    }

    public static final boolean isEvoScale(IFrameworkAccess iFrameworkAccess) {
        return iFrameworkAccess.getSysConst(522) == 1 && iFrameworkAccess.getSysConst(4581) == 0 && iFrameworkAccess.getSysConst(523) == 1 && iFrameworkAccess.getSysConst(4168) == 1;
    }

    public static final boolean isGoogle3dCityModelAvailable() {
        return false;
    }

    public static final boolean isSpeedAndFlowAvailable(IFrameworkAccess iFrameworkAccess) {
        return Util.isHURegionAsia() && Util.isTrafficPresent(iFrameworkAccess) || Util.isOnlineTrafficPresent(iFrameworkAccess);
    }

    public static final boolean isTrafficEventNoticeMapAvailable(IFrameworkAccess iFrameworkAccess) {
        return iFrameworkAccess.getSysConst(4499) == 1;
    }

    public static final boolean isEtronActivated() {
        return false;
    }

    public static final boolean isPartialMapUpdateAvailable() {
        return Util.isHURegionAsia();
    }

    public static final boolean isHURegionEU() {
        return region == 0;
    }

    public static final boolean isHURegionAsia() {
        return region == 2 || region == 3 || region == 4 || region == 5;
    }

    public static final boolean isHURegionCN() {
        return region == 2;
    }

    public static final boolean isHURegionJP() {
        return region == 3;
    }

    public static final boolean isHURegionKR() {
        return region == 4;
    }

    public static final boolean isHURegionTW() {
        return region == 5;
    }

    public static final boolean isHURegionNAR() {
        return region == 1;
    }

    public static final boolean isHURegionRdW() {
        return region == 6;
    }

    public static final boolean isClusterMapFPK(IFrameworkAccess iFrameworkAccess) {
        return !Util.isClusterMMI(iFrameworkAccess) && iFrameworkAccess.getSysConst(541) == 2;
    }

    public static final boolean isClusterMapMOST(IFrameworkAccess iFrameworkAccess) {
        return !Util.isClusterMMI(iFrameworkAccess) && iFrameworkAccess.getSysConst(541) == 1;
    }

    public static final boolean isClusterRGI(IFrameworkAccess iFrameworkAccess) {
        return !Util.isClusterMMI(iFrameworkAccess) && iFrameworkAccess.getSysConst(541) == 0;
    }

    public static final boolean isMapInMapAvailable(IFrameworkAccess iFrameworkAccess) {
        return iFrameworkAccess.getSysConst(4389) == 1;
    }

    public static final boolean isClusterKDKOnly(IFrameworkAccess iFrameworkAccess) {
        return iFrameworkAccess.getSysConst(4388) == 1 && iFrameworkAccess.getSysConst(4383) == 0;
    }

    public static final boolean isClusterMapAvailable(IFrameworkAccess iFrameworkAccess) {
        return iFrameworkAccess.getSysConst(4383) == 1 && !Util.isClusterRGI(iFrameworkAccess);
    }

    public static final boolean isClusterKDKAvailable(IFrameworkAccess iFrameworkAccess) {
        return iFrameworkAccess.getSysConst(4388) == 1 && !Util.isClusterRGI(iFrameworkAccess);
    }

    public static boolean isClusterMMI(IFrameworkAccess iFrameworkAccess) {
        return iFrameworkAccess.getScreenRes() == 4 && !Util.isPorscheGen2(iFrameworkAccess);
    }

    public static boolean isClusterMapMOSTAlwaysOn() {
        return Boolean.getBoolean("clusterMapMostAlwaysOn");
    }

    public static boolean isClusterMapAlwaysOn() {
        return Boolean.getBoolean("clusterMapAlwaysOn");
    }

    public static final boolean isPhoneCallActive(NavigationEnv navigationEnv) {
        return navigationEnv.getChoiceModel(182).getValue() == 1;
    }

    public static final boolean isTrafficMapAvailable(IFrameworkAccess iFrameworkAccess) {
        return iFrameworkAccess.getSysConst(4485) == 1;
    }

    public static final boolean isOnlineTrafficPresent(IFrameworkAccess iFrameworkAccess) {
        return iFrameworkAccess.getSysConst(488) == 1;
    }

    public static final boolean isVzoLgiDownloadPresent(IFrameworkAccess iFrameworkAccess) {
        return iFrameworkAccess.getSysConst(4589) == 1 || iFrameworkAccess.getSysConst(4592) == 1;
    }

    public static final boolean isVzoLgiTrackerPresent(IFrameworkAccess iFrameworkAccess) {
        return iFrameworkAccess.getSysConst(4590) == 1 || iFrameworkAccess.getSysConst(4591) == 1;
    }

    public static final boolean isTrafficPresent(IFrameworkAccess iFrameworkAccess) {
        return iFrameworkAccess.getSysConst(4011) == 1;
    }

    public static int parseInteger(String string) {
        try {
            return Integer.parseInt(string);
        }
        catch (NumberFormatException numberFormatException) {
            return 0;
        }
    }

    public static int computeAbsoluteDirection(int n, int n2, int n3, int n4) {
        int n5;
        if (n != 0 || n2 != 0) {
            double d2 = NavigationUtilities.wgs84ToDegree(n);
            double d3 = NavigationUtilities.wgs84ToDegree(n2);
            double d4 = NavigationUtilities.wgs84ToDegree(n3);
            double d5 = NavigationUtilities.wgs84ToDegree(n4);
            double d6 = Math.toRadians(d2);
            double d7 = Math.toRadians(d3);
            double d8 = Math.toRadians(d4);
            double d9 = Math.toRadians(d5);
            double d10 = (d8 - d6) * Math.cos((d7 + d9) / 2.0);
            double d11 = d9 - d7;
            double d12 = Math.toDegrees(Math.atan2(d11, d10));
            d12 -= 90.0;
            d12 = (d12 + 360.0) % 360.0;
            n5 = (int)d12;
        } else {
            n5 = 0;
        }
        return n5;
    }

    public static int computeAbsoluteDirection(PosPosition posPosition, int n, int n2) {
        if (posPosition == null) {
            return 0;
        }
        return Util.computeAbsoluteDirection(posPosition.longitude, posPosition.latitude, n, n2);
    }

    public static int degreeStringToWgs84(String string) {
        try {
            double d2 = Double.parseDouble(string);
            return NavigationUtilities.degreeToWgs84(d2);
        }
        catch (NumberFormatException numberFormatException) {
            return 0;
        }
    }

    public static int computeAirDistance(int n, int n2, int n3, int n4) {
        double d2 = Math.toRadians(NavigationUtilities.wgs84ToDegree(n));
        double d3 = Math.toRadians(NavigationUtilities.wgs84ToDegree(n2));
        double d4 = Math.toRadians(NavigationUtilities.wgs84ToDegree(n3));
        double d5 = Math.toRadians(NavigationUtilities.wgs84ToDegree(n4));
        int n5 = (int)(Math.acos(Math.sin(d3) * Math.sin(d5) + Math.cos(d3) * Math.cos(d5) * Math.cos(d2 - d4)) * 6371000.8);
        return n5;
    }

    public static double[] getDistanceCoordinatesFromLocation(NavLocation navLocation, double d2) {
        double d3;
        double[] dArray = new double[4];
        int n = navLocation.getLatitude();
        int n2 = navLocation.getLongitude();
        double d4 = Math.toRadians(NavigationUtilities.wgs84ToDegree(n));
        double d5 = Math.toRadians(NavigationUtilities.wgs84ToDegree(n2));
        double d6 = d2 / 6371000.8;
        double d7 = 6371000.8 * Math.cos(d6);
        double d8 = d2 / d7;
        double d9 = Math.toDegrees(d5 - d8);
        double d10 = Math.toDegrees(d4 + d6);
        double d11 = Math.toDegrees(d5 + d8);
        dArray[0] = d3 = Math.toDegrees(d4 - d6);
        dArray[1] = d10;
        dArray[2] = d9;
        dArray[3] = d11;
        return dArray;
    }

    private static void setKeyValueOnLocation(NavLocation navLocation, String string, String string2) {
        if (navLocation != null) {
            tmpInternalData.init(navLocation);
            tmpInternalData.setValue(string, string2);
            tmpInternalData.setInLocation(navLocation);
        }
    }

    private static void removeKeyValueFromLocation(NavLocation navLocation, String string) {
        if (navLocation != null && !Util.isEmpty(string)) {
            tmpInternalData.init(navLocation);
            tmpInternalData.removeKeyValuePair(string);
            tmpInternalData.setInLocation(navLocation);
        }
    }

    private static String getKeyValueOnLocation(NavLocation navLocation, String string) {
        if (navLocation != null) {
            tmpInternalData.init(navLocation);
            return tmpInternalData.getValue(string);
        }
        return null;
    }

    private static void toggleFlagOnLocation(NavLocation navLocation, String string, boolean bl) {
        if (navLocation != null) {
            tmpInternalData.init(navLocation);
            if (bl) {
                tmpInternalData.setValue(string, "Y");
            } else {
                tmpInternalData.removeKeyValuePair(string);
            }
            tmpInternalData.setInLocation(navLocation);
        }
    }

    public static void setDescriptionOnLocation(NavLocation navLocation, String string) {
        Util.setKeyValueOnLocation(navLocation, "Title", string);
    }

    public static void setOnlinePoiIdOnLocation(NavLocation navLocation, String string) {
        Util.setKeyValueOnLocation(navLocation, "OnlienPoiID", string);
    }

    public static void setPhoneNumberOnLocation(NavLocation navLocation, String string) {
        Util.setKeyValueOnLocation(navLocation, "Phone", string);
    }

    public static void setOnlinePOINameOnLocation(NavLocation navLocation, String string) {
        Util.setKeyValueOnLocation(navLocation, "OnlineName", string);
    }

    public static String getAdditionalNameFromNavLocation(NavLocation navLocation) {
        String string = LocationFormatter.formatLocationTitle(navLocation);
        if (!Util.isEmpty(string)) {
            return string;
        }
        string = Util.getKeyValueOnLocation(navLocation, "OnlineName");
        if (!Util.isEmpty(string)) {
            return string;
        }
        string = LocationFormatter.formatPOIName(navLocation);
        if (!Util.isEmpty(string)) {
            return string;
        }
        return null;
    }

    public static void setURLOnLocation(NavLocation navLocation, String string) {
        Util.setKeyValueOnLocation(navLocation, "URL", string);
    }

    public static void setGeoPosFlagOnLocation(NavLocation navLocation, boolean bl) {
        Util.toggleFlagOnLocation(navLocation, "GeoPos", bl);
    }

    public static void setPetrolStationValue(NavLocation navLocation, String string) {
        Util.setKeyValueOnLocation(navLocation, "Petrol", string);
    }

    public static String getPetrolStationValue(NavLocation navLocation) {
        return tmpInternalData.getValue(navLocation, "Petrol");
    }

    public static boolean isPetrolStation(NavLocation navLocation) {
        return tmpInternalData.isKeyAvailable(navLocation, "Petrol");
    }

    public static boolean isNormalPoi(NavLocation navLocation) {
        IMyLocationAccessor iMyLocationAccessor = Util.getLocationAccessor(navLocation);
        return iMyLocationAccessor.getType() == 1 && !Util.isEmpty(iMyLocationAccessor.getPoiName());
    }

    public static boolean isOnlinePOI(NavLocation navLocation) {
        return tmpInternalData.isKeyAvailable(navLocation, "OnlineName");
    }

    public static boolean isGeoPosFlag(NavLocation navLocation) {
        return tmpInternalData.isKeyAvailable(navLocation, "GeoPos");
    }

    public static int getCurrentMetricsSystem(boolean bl) {
        int n;
        switch (Distance.getSystemUnit()) {
            case 1: {
                n = bl ? 2 : 2;
                break;
            }
            case 2: {
                if (Distance.getHURegion() == 1) {
                    n = bl ? 4 : 4;
                    break;
                }
                n = bl ? 3 : 3;
                break;
            }
            default: {
                n = bl ? 1 : 1;
            }
        }
        return n;
    }

    public static int getCurrentTemperatureScale() {
        int n;
        switch (Temperature.getSystemUnit()) {
            case 1: {
                n = 1;
                break;
            }
            case 2: {
                n = 2;
                break;
            }
            default: {
                n = 0;
            }
        }
        return n;
    }

    public static String stripNumber(String string) {
        int n;
        if (string != null && (n = string.length() - 1) > 0 && string.charAt(n--) == ')' && n > 0 && Character.isDigit(string.charAt(n--))) {
            while (n > 0 && Character.isDigit(string.charAt(n))) {
                --n;
            }
            if (n > 0 && string.charAt(n--) == '(' && string.charAt(n) == ' ') {
                return string.substring(0, n);
            }
        }
        return string;
    }

    public static String formatStringArray(String[] stringArray) {
        Buffer buffer = new Buffer();
        Util.appendObjectArray(buffer, stringArray);
        return buffer.toString();
    }

    public static void appendObjectArray(Buffer buffer, Object[] objectArray) {
        if (buffer != null) {
            if (objectArray != null && objectArray.length > 0) {
                int n = objectArray.length;
                buffer.append('[');
                for (int i2 = 0; i2 < n - 1; ++i2) {
                    buffer.append(objectArray[i2]).append(", ");
                }
                buffer.append(objectArray[n - 1]).append(']');
            } else {
                buffer.append("[]");
            }
        }
    }

    public static int mountPathToMediumID(String string) {
        int n = string == null ? -1 : (string.startsWith("/mnt/nav/db") ? 0 : (string.startsWith("/fs/sd0") ? 1 : (string.startsWith("/mnt/sdcard1") ? 1 : (string.startsWith("/fs/sd1") ? 2 : (string.startsWith("/mnt/sdcard2") ? 2 : (string.startsWith("/fs/cd") ? 3 : -1))))));
        return n;
    }

    public static String getFallBackLanguage() {
        String string = Util.isHURegionNAR() ? I18NTarget.LANGUAGES[9].getLanguageCode() : I18NTarget.LANGUAGES[0].getLanguageCode();
        return string;
    }

    public static int getScreenWidth(NavigationEnv navigationEnv) {
        int n;
        try {
            ListModelApp listModelApp = navigationEnv.getListModel(176);
            n = ((IntegerListCell)listModelApp.getCell(0, 0)).getValue();
        }
        catch (Exception exception) {
            navigationEnv.getLogChannel().log(100000, "Util#getScreenWidth() - failed to resolve screen width.", (Throwable)exception);
            n = 0;
        }
        return n;
    }

    public static int getScreenHeight(NavigationEnv navigationEnv) {
        int n;
        try {
            ListModelApp listModelApp = navigationEnv.getListModel(176);
            n = ((IntegerListCell)listModelApp.getCell(0, 1)).getValue();
        }
        catch (Exception exception) {
            navigationEnv.getLogChannel().log(100000, "Util#getScreenHeight() - failed to resolve screen height.", (Throwable)exception);
            n = 0;
        }
        return n;
    }

    public static String getRevision(NavigationEnv navigationEnv) {
        String string = navigationEnv.getLabelModel(151).getText();
        string = string == null ? INVALID_DISTANCE_NULL_AT_KOMBI_WITHOUT_TEXT_FOR_UNIT : string;
        return string;
    }

    public static String getVIN(NavigationEnv navigationEnv) {
        LabelModelApp labelModelApp = navigationEnv.getLabelModel(49);
        String string = null;
        if (labelModelApp != null) {
            string = labelModelApp.getText();
        }
        string = string == null ? INVALID_DISTANCE_NULL_AT_KOMBI_WITHOUT_TEXT_FOR_UNIT : string;
        return string;
    }

    public static NavLocation getDynamicVicinityLocation() {
        NavLocation navLocation = Util.getLocationFromGeoPos(0, 0);
        return navLocation;
    }

    public static NavLocation setMyscreenIndicatorOnLocation(NavLocation navLocation, int n) {
        if (navLocation != null) {
            Util.setKeyValueOnLocation(navLocation, "Myscreen", Integer.toString(n));
        }
        return navLocation;
    }

    public static NavLocation removeMyscreenIndicatorFromLocation(NavLocation navLocation) {
        if (navLocation != null) {
            Util.removeKeyValueFromLocation(navLocation, "Myscreen");
        }
        return navLocation;
    }

    public static String getLocationOnMyscreen(NavLocation navLocation) {
        if (navLocation != null) {
            tmpInternalData.init(navLocation);
            String string = tmpInternalData.getValue("Myscreen");
            if (string != null) {
                return string;
            }
        }
        return INVALID_DISTANCE_NULL_AT_KOMBI_WITHOUT_TEXT_FOR_UNIT;
    }

    public static NavLocation setFavoriteNameOnLocation(NavLocation navLocation, String string) {
        if (!Util.isEmpty(string)) {
            Util.setKeyValueOnLocation(navLocation, "FAVORITE_NAME", string);
            Util.setKeyValueOnLocation(navLocation, "Title", string);
        } else {
            Util.removeKeyValueFromLocation(navLocation, "FAVORITE_NAME");
            Util.removeKeyValueFromLocation(navLocation, "Title");
        }
        return navLocation;
    }

    public static String getFavoriteNameFromLocation(NavLocation navLocation) {
        if (navLocation != null) {
            tmpInternalData.init(navLocation);
            String string = tmpInternalData.getValue("FAVORITE_NAME");
            if (string != null) {
                return string;
            }
        }
        return INVALID_DISTANCE_NULL_AT_KOMBI_WITHOUT_TEXT_FOR_UNIT;
    }

    public static NavLocation setAreaInfoOnLocation(NavLocation navLocation, String string) {
        if (!Util.isEmpty(string)) {
            Util.setKeyValueOnLocation(navLocation, "Area", string);
        } else {
            Util.removeKeyValueFromLocation(navLocation, "Area");
        }
        return navLocation;
    }

    public static String getAreaInfoFromLocation(NavLocation navLocation) {
        if (navLocation != null) {
            tmpInternalData.init(navLocation);
            String string = tmpInternalData.getValue("Area");
            if (string != null) {
                return string;
            }
        }
        return INVALID_DISTANCE_NULL_AT_KOMBI_WITHOUT_TEXT_FOR_UNIT;
    }

    public static NavLocation getFallbackLocation() {
        NavLocation navLocation = Util.getLocationFromGeoPos(136106718, 582115815);
        return navLocation;
    }

    public static IMyLocationAccessor getLocationAccessor(NavLocation navLocation) {
        return Util.getLocationAccessorFactory().fromLocation(navLocation);
    }

    public static synchronized IMyLocationAccessorFactory getLocationAccessorFactory() {
        if (locationAccessorFactory == null) {
            return new PCLocationAccessorFactory(null);
        }
        return locationAccessorFactory;
    }

    public static synchronized void setLocationAccessorFactory(IMyLocationAccessorFactory iMyLocationAccessorFactory) {
        locationAccessorFactory = iMyLocationAccessorFactory;
    }

    public static NavLocation getLocationFromGeoPos(int n, int n2) {
        IMyLocationAccessorFactory iMyLocationAccessorFactory = Util.getLocationAccessorFactory();
        IMyLocationAccessor iMyLocationAccessor = iMyLocationAccessorFactory.createLocationAccessorFromGeoPos(n2, n);
        return iMyLocationAccessorFactory.toLocation(iMyLocationAccessor);
    }

    public static boolean isAdditionalFlagSet(NavLocation navLocation, int n) {
        if (navLocation != null) {
            IMyLocationAccessor iMyLocationAccessor = Util.getLocationAccessor(navLocation);
            int n2 = iMyLocationAccessor.getAdditionalFlags();
            if (n2 == -1) {
                n2 = Integer.MIN_VALUE;
            }
            return (n2 & n) != 0;
        }
        return false;
    }

    public static int mapTrailOptions(boolean bl, boolean bl2) {
        if (bl && bl2) {
            return 3;
        }
        if (!bl && bl2) {
            return 2;
        }
        if (bl && !bl2) {
            return 4;
        }
        if (!bl && !bl2) {
            return 1;
        }
        return 0;
    }

    public static NavLocation cloneLocation(NavLocation navLocation) {
        IMyLocationAccessorFactory iMyLocationAccessorFactory = Util.getLocationAccessorFactory();
        IMyLocationAccessor iMyLocationAccessor = iMyLocationAccessorFactory.fromLocation(navLocation);
        IMyLocationAccessor iMyLocationAccessor2 = iMyLocationAccessorFactory.cloneLocationAccessor(iMyLocationAccessor);
        return iMyLocationAccessorFactory.toLocation(iMyLocationAccessor2);
    }

    public static int castLongToInt(long l) {
        int n = (int)l;
        return n;
    }

    public static boolean isListValid(LIValueList lIValueList) {
        return lIValueList != null && lIValueList.getList() != null;
    }

    public static int getLIValueListElement(LogChannel logChannel, LIValueList lIValueList, int n) {
        if (lIValueList == null) {
            logChannel.log(100000, "Util#getLIValueListElement() - valueList is null");
            return -1;
        }
        LIValueListElement[] lIValueListElementArray = lIValueList.getList();
        if (lIValueListElementArray == null) {
            logChannel.log(100000, "Util#getLIValueListElement() - valueListElements is null");
            return -1;
        }
        for (int i2 = 0; i2 < lIValueListElementArray.length; ++i2) {
            if (!lIValueListElementArray[i2].isHasListIndex() || lIValueListElementArray[i2].getListIndex() != n) continue;
            return i2;
        }
        return -1;
    }

    public static String[] decodeConcatenatedString(String string, int n) {
        String[] stringArray = null;
        if (!Util.isEmpty(string)) {
            boolean bl;
            boolean bl2 = bl = string.charAt(0) == '@';
            if (bl) {
                stringArray = new String[n];
                int n2 = 1;
                int n3 = string.indexOf(124, n2);
                for (int i2 = 0; i2 < n && n3 >= 0; ++i2) {
                    String string2;
                    stringArray[i2] = string2 = string.substring(n2, n3);
                    n2 = n3 + 1;
                    n3 = string.indexOf(124, n2);
                }
            } else {
                stringArray = new String[]{string};
            }
        }
        return stringArray;
    }

    public static byte[] getUpdatedArray(byte[] byArray, byte[] byArray2) {
        int n = byArray != null ? byArray.length : 0;
        int n2 = byArray2 != null ? byArray2.length : 0;
        byte[] byArray3 = new byte[Math.max(n, n2)];
        if (n > 0) {
            System.arraycopy((Object)byArray, 0, (Object)byArray3, 0, n);
        }
        if (n2 > n) {
            System.arraycopy((Object)byArray2, n, (Object)byArray3, n, n2 - n);
        }
        return byArray3;
    }

    public static int[] getUpdatedArray(int[] nArray, int[] nArray2) {
        int n = nArray != null ? nArray.length : 0;
        int n2 = nArray2 != null ? nArray2.length : 0;
        int[] nArray3 = new int[Math.max(n, n2)];
        if (n > 0) {
            System.arraycopy((Object)nArray, 0, (Object)nArray3, 0, n);
        }
        if (n2 > n) {
            System.arraycopy((Object)nArray2, n, (Object)nArray3, n, n2 - n);
        }
        return nArray3;
    }

    public static String getCountryAbbreviation(NavLocation navLocation) {
        if (navLocation == null) {
            return INVALID_DISTANCE_NULL_AT_KOMBI_WITHOUT_TEXT_FOR_UNIT;
        }
        String string = navLocation.getCountryAbbreviation();
        return string == null ? INVALID_DISTANCE_NULL_AT_KOMBI_WITHOUT_TEXT_FOR_UNIT : string;
    }

    public static String getStateAbbreviation(NavLocation navLocation) {
        if (navLocation == null) {
            return INVALID_DISTANCE_NULL_AT_KOMBI_WITHOUT_TEXT_FOR_UNIT;
        }
        IMyLocationAccessor iMyLocationAccessor = Util.getLocationAccessor(navLocation);
        String string = iMyLocationAccessor.getStateAbbreviation();
        return string == null ? INVALID_DISTANCE_NULL_AT_KOMBI_WITHOUT_TEXT_FOR_UNIT : string;
    }

    public static String getCurrentCallStack() {
        StackTraceElement[] stackTraceElementArray = new Exception().getStackTrace();
        Buffer buffer = new Buffer();
        for (int i2 = 1; i2 < stackTraceElementArray.length; ++i2) {
            buffer.append(stackTraceElementArray[i2].getClassName()).append("#").append(stackTraceElementArray[i2].getMethodName()).append(" Line ").append(stackTraceElementArray[i2].getLineNumber()).append("\n");
        }
        return buffer.toString();
    }

    public static void logStartupEvent(IFrameworkAccess iFrameworkAccess, String string) {
        iFrameworkAccess.getStartupMgr().logStartupEvent(string);
    }

    public static void logStartupEvent(IFrameworkAccess iFrameworkAccess, Buffer buffer) {
        iFrameworkAccess.getStartupMgr().logStartupEvent(buffer.toString());
    }

    static void handleDSIException(Exception exception, String string, NavigationEnv navigationEnv) {
        navigationEnv.getLogChannel().log(10000, "Util#handleDSIException( %1 ) ", (Object)string, (Throwable)exception);
    }

    public static void handleDSIException(Exception exception, NavigationEnv navigationEnv) {
        Util.handleDSIException(exception, exception.getMessage(), navigationEnv);
    }

    public static final boolean isPreferredGasStationsPresent(IFrameworkAccess iFrameworkAccess) {
        return iFrameworkAccess.getSysConst(3866) == 1;
    }

    public static final boolean isPredictiveNav(IFrameworkAccess iFrameworkAccess) {
        return iFrameworkAccess.getSysConst(4410) == 1;
    }

    public static final boolean isKOMOFollowMode(IFrameworkAccess iFrameworkAccess) {
        return Util.isClusterMapFPK(iFrameworkAccess) || Util.isClusterMMI(iFrameworkAccess);
    }

    public static String concat2StringsWithComma(String string, String string2) {
        Buffer buffer = new Buffer();
        buffer.append(string);
        if (buffer.length() > 0 && !Util.isEmpty(string2)) {
            buffer.append(", ");
        }
        buffer.append(string2);
        return buffer.toString();
    }

    public static boolean isNavRectangleValid(NavRectangle navRectangle) {
        if (navRectangle == null) {
            return false;
        }
        return navRectangle.xLeft != 0 || navRectangle.xRight != 0 || navRectangle.yBottom != 0 || navRectangle.yUp != 0;
    }

    public static boolean isStreetBasename(LIValueListElement lIValueListElement) {
        return (lIValueListElement.getAdditionalFlags() & 0x10) == 16;
    }

    public static boolean isPorsche(IFrameworkAccess iFrameworkAccess) {
        return iFrameworkAccess.isPorsche();
    }

    public static boolean isPorscheHigh(IFrameworkAccess iFrameworkAccess) {
        return iFrameworkAccess.isPorscheHigh();
    }

    public static boolean isPorscheGen2(IFrameworkAccess iFrameworkAccess) {
        return iFrameworkAccess.isPGen2();
    }

    public static boolean isBentley(IFrameworkAccess iFrameworkAccess) {
        return iFrameworkAccess.isBentley();
    }

    public static String getClassNameFromPackageName(Class clazz) {
        String string = clazz.getName();
        int n = string.lastIndexOf(46);
        return string.substring(n + 1, string.length());
    }

    public static NavLocationWgs84 navLocationToWgs84(NavLocation navLocation) {
        if (navLocation == null) {
            return null;
        }
        return new NavLocationWgs84(navLocation.longitude, navLocation.latitude);
    }

    public static NavLocationWgs84[] navLocationsToWgs84(NavLocation[] navLocationArray) {
        if (navLocationArray == null) {
            return null;
        }
        NavLocationWgs84[] navLocationWgs84Array = new NavLocationWgs84[navLocationArray.length];
        for (int i2 = 0; i2 < navLocationArray.length; ++i2) {
            NavLocation navLocation = navLocationArray[i2];
            navLocationWgs84Array[i2] = Util.navLocationToWgs84(navLocation);
        }
        return navLocationWgs84Array;
    }

    public static NavLocation wgs84ToNavLocation(NavLocationWgs84 navLocationWgs84) {
        if (navLocationWgs84 == null) {
            return null;
        }
        return Util.getLocationFromGeoPos(navLocationWgs84.getLongitude(), navLocationWgs84.getLatitude());
    }

    public static NavLocation[] wgs84sToNavLocations(NavLocationWgs84[] navLocationWgs84Array) {
        if (navLocationWgs84Array == null) {
            return null;
        }
        NavLocation[] navLocationArray = new NavLocation[navLocationWgs84Array.length];
        for (int i2 = 0; i2 < navLocationWgs84Array.length; ++i2) {
            NavLocationWgs84 navLocationWgs84 = navLocationWgs84Array[i2];
            navLocationArray[i2] = Util.wgs84ToNavLocation(navLocationWgs84);
        }
        return navLocationArray;
    }

    public static NavLocationWgs84 mapTmcMessageToWgs84(MapTmcMessage mapTmcMessage) {
        if (mapTmcMessage == null) {
            return null;
        }
        return new NavLocationWgs84(mapTmcMessage.getGeoPosLongitude(), mapTmcMessage.getGeoPosLatitude());
    }

    public static NavLocationWgs84[] mapTmcMessagesToWgs84(MapTmcMessage[] mapTmcMessageArray) {
        if (mapTmcMessageArray == null) {
            return null;
        }
        NavLocationWgs84[] navLocationWgs84Array = new NavLocationWgs84[mapTmcMessageArray.length];
        for (int i2 = 0; i2 < mapTmcMessageArray.length; ++i2) {
            MapTmcMessage mapTmcMessage = mapTmcMessageArray[i2];
            navLocationWgs84Array[i2] = Util.mapTmcMessageToWgs84(mapTmcMessage);
        }
        return navLocationWgs84Array;
    }

    public static boolean equals(NavLocationWgs84 navLocationWgs84, NavLocationWgs84 navLocationWgs842) {
        if (navLocationWgs84 == null && navLocationWgs842 == null) {
            return true;
        }
        if (navLocationWgs84 != null && navLocationWgs842 != null) {
            return navLocationWgs84.longitude == navLocationWgs842.longitude && navLocationWgs84.latitude == navLocationWgs842.latitude;
        }
        return false;
    }

    public static final boolean isMekkaCompassAvailable(IFrameworkAccess iFrameworkAccess) {
        return iFrameworkAccess.getSysConst(4396) == 1;
    }

    public static boolean isSetRouteInfoDSIAvailable(IFrameworkAccess iFrameworkAccess) {
        return !Util.isHURegionAsia() || Util.isPorsche(iFrameworkAccess);
    }

    public static final boolean isScrollByCrossHairsEnabled(IFrameworkAccess iFrameworkAccess) {
        return iFrameworkAccess.getSysConst(4404) == 1;
    }

    public static final boolean isHMIScrollHairsEnabled(IFrameworkAccess iFrameworkAccess) {
        return iFrameworkAccess.getSysConst(4422) == 1;
    }

    public static final boolean isIntellidestPickHelpAvailable(IFrameworkAccess iFrameworkAccess) {
        return iFrameworkAccess.getSysConst(4405) == 1;
    }

    public static final void removeUrlFromMmiInternalData(NavLocation navLocation) {
        IMyLocationAccessor iMyLocationAccessor = Util.getLocationAccessor(navLocation);
        if (!Util.isEmpty(iMyLocationAccessor.getMmiInternalData())) {
            MMIInternalData mMIInternalData = new MMIInternalData();
            mMIInternalData.init(iMyLocationAccessor.getMmiInternalData());
            mMIInternalData.removeKeyValuePair("URL");
            mMIInternalData.setInLocation(navLocation);
        }
    }

    public static final boolean isSemidynamicRgAvailable(IFrameworkAccess iFrameworkAccess) {
        return iFrameworkAccess.getSysConst(4417) == 1;
    }

    public static final boolean isLockConceptEnabled(IFrameworkAccess iFrameworkAccess) {
        return iFrameworkAccess.getSysConst(4368) == 1;
    }

    public static final boolean isLockFeatureNavMapOptionDrawerEnabled(NavigationEnv navigationEnv) {
        return navigationEnv.getChoiceModel(5590).getValue() == 1;
    }

    public static final boolean isLockFeatureNavDestOptionDrawerEnabled(NavigationEnv navigationEnv) {
        return navigationEnv.getChoiceModel(5593).getValue() == 1;
    }

    public static final boolean isLockFeatureNavMapAdvancedMapEnabled(NavigationEnv navigationEnv) {
        return navigationEnv.getChoiceModel(5598).getValue() == 1;
    }

    public static final boolean isLockFeatureNavMapviewScrollEnabled(NavigationEnv navigationEnv) {
        return navigationEnv.getChoiceModel(5613).getValue() == 1;
    }

    public static final boolean isRubberbandAvailable(NavigationEnv navigationEnv) {
        return navigationEnv.getFramework().getSysConst(4416) == 1 && !Util.isLockFeatureNavMapviewScrollEnabled(navigationEnv);
    }

    public static boolean isNavDBOnSDCard(IFrameworkAccess iFrameworkAccess) {
        return iFrameworkAccess.getSysConst(4420) == 1;
    }

    public static boolean alternativeRoutesWithStopOverAreDisabled(IFrameworkAccess iFrameworkAccess) {
        return iFrameworkAccess.getSysConst(4434) == 0;
    }

    public static final boolean isUncrowdedRoadsCheckboxAvailable(IFrameworkAccess iFrameworkAccess) {
        return iFrameworkAccess.getSysConst(4441) == 1;
    }

    public static final boolean isOnlineTrafficAlwaysActive(IFrameworkAccess iFrameworkAccess) {
        return iFrameworkAccess.getSysConst(4588) == 1;
    }

    public static float getPreviewMapDefaultZoomLevel() {
        if (Util.isHURegionAsia()) {
            return 200.0f;
        }
        return 400.0f;
    }

    public static final boolean isTrafficMiniMapAvailable(IFrameworkAccess iFrameworkAccess) {
        return iFrameworkAccess.getSysConst(4450) == 1;
    }

    public static boolean isGeoPosType(NavLocation navLocation) {
        if (navLocation != null) {
            IMyLocationAccessor iMyLocationAccessor = Util.getLocationAccessor(navLocation);
            return iMyLocationAccessor.getType() == 2;
        }
        return false;
    }

    public static boolean isOnlyOneOrNoBitSet(int n) {
        return (n & n - 1) == 0;
    }

    public static boolean checkIfCountryAbbreviationIsEqual(NavLocation navLocation, NavLocation navLocation2) {
        String string = LocationFormatter.formatCountryCode(navLocation);
        if (Util.isEmpty(string)) {
            return false;
        }
        return string.equals(LocationFormatter.formatCountryCode(navLocation2));
    }

    public static String appendHouseNumberForFPK(String string, String string2, IFrameworkAccess iFrameworkAccess) {
        if (!(!Util.isClusterMapFPK(iFrameworkAccess) || Util.isPorsche(iFrameworkAccess) || Util.isHURegionAsia() || Util.isEmpty(string) || Util.isEmpty(string2))) {
            Buffer buffer = new Buffer(string.length() + 1 + string2.length());
            if (Util.isHURegionNAR()) {
                buffer.append(string2);
                buffer.append(' ');
                buffer.append(string);
            } else {
                buffer.append(string);
                buffer.append(' ');
                buffer.append(string2);
            }
            string = buffer.toString();
        }
        return string;
    }

    public static boolean useDSIUpdateBapManeuverInformation() {
        return true;
    }

    public static String getMotorwayEntryExit(LogChannel logChannel, CalculatedRouteListElement calculatedRouteListElement, int n, String string) {
        int[] nArray = calculatedRouteListElement.additionalRouteDataKeys;
        String[] stringArray = calculatedRouteListElement.additionalRouteDataValues;
        if (nArray == null || stringArray == null || nArray.length == 0 || stringArray.length == 0 || nArray.length != stringArray.length) {
            logChannel.log(100000, "Util#getMotorwayEntryExit(), failed to get a valid value for key: (%1), additionalRouteDataKeys : (%2), additionalRouteDataValues: (%3) ", (Object)Integer.toString(n), (Object)nArray, (Object)stringArray);
            return string;
        }
        int n2 = nArray.length;
        for (int i2 = 0; i2 < n2; ++i2) {
            if (nArray[i2] != n) continue;
            return stringArray[i2];
        }
        logChannel.log(100000, "Util#getMotorwayEntryExit(), additionalRouteDataValues: (%1), there is no key: (%2)", (Object)stringArray, (long)n);
        return string;
    }

    public static Token extractTokenFromSearchresult(SearchResult searchResult, int n) {
        Token[] tokenArray;
        if (searchResult != null && (tokenArray = searchResult.getTokens()) != null && tokenArray.length > 0) {
            for (int i2 = 0; i2 < tokenArray.length; ++i2) {
                if (tokenArray[i2].getWordType() != n) continue;
                return tokenArray[i2];
            }
        }
        return new Token();
    }

    public static int getIncrementedValueForRangeModel(RangeModelApp rangeModelApp, int n) {
        int n2 = rangeModelApp.getValue() - rangeModelApp.getMinimum() + n;
        n2 %= rangeModelApp.getMaximum() - rangeModelApp.getMinimum() + 1;
        return n2 += rangeModelApp.getMinimum();
    }

    public static int getRouteInfoConfigMode(IFrameworkAccess iFrameworkAccess) {
        return iFrameworkAccess.getSysConst(4575);
    }

    public static NavRectangle extendNavRectangleToCenterOnPoint(NavRectangle navRectangle, NavLocationWgs84 navLocationWgs84) {
        int n = navRectangle.getXLeft();
        int n2 = navRectangle.getYBottom();
        int n3 = navRectangle.getXRight();
        int n4 = navRectangle.getYUp();
        long l = 2L * (long)navLocationWgs84.getLatitude() - (long)n2 - (long)n4;
        long l2 = 2L * (long)navLocationWgs84.getLongitude() - (long)n - (long)n3;
        if (l >= 0L) {
            n4 = (int)((long)n4 + l);
        } else {
            n2 = (int)((long)n2 + l);
        }
        if (l2 >= 0L) {
            n3 = (int)((long)n3 + l2);
        } else {
            n = (int)((long)n + l2);
        }
        return new NavRectangle(n, n3, n2, n4, false);
    }

    public static boolean isCategoryGasStation(int n) {
        return 120 == n || n == 69030;
    }

    public static boolean isCategoryParking(int n) {
        return 119 == n || n == 41;
    }

    public static boolean isCategoryCharging(int n) {
        return n == 69032;
    }

    public static final boolean isOffroadNavigationEnabled() {
        return false;
    }

    public static boolean isNavLocationPoiOnboard(NavLocation navLocation) {
        IMyLocationAccessor iMyLocationAccessor;
        return navLocation != null && navLocation.isPositionValid() && (iMyLocationAccessor = Util.getLocationAccessor(navLocation)) != null && iMyLocationAccessor.getType() == 1 && !Util.isEmpty(iMyLocationAccessor.getPoiCategory());
    }

    public static boolean isNavLocationPoiTpeg(NavLocation navLocation) {
        IMyLocationAccessor iMyLocationAccessor;
        return navLocation != null && navLocation.isPositionValid() && (iMyLocationAccessor = Util.getLocationAccessor(navLocation)) != null && iMyLocationAccessor.getType() == 4;
    }

    public static int getVariantSpecificRHMIContext() {
        if (Util.isHURegionEU() || Util.isHURegionRdW()) {
            return 75;
        }
        if (Util.isHURegionNAR()) {
            return 102;
        }
        if (Util.isHURegionCN() || Util.isHURegionTW()) {
            return 81;
        }
        if (Util.isHURegionJP()) {
            return 82;
        }
        return -1;
    }

    public static int getVariantSpecificOnlineContext() {
        if (Util.isHURegionEU() || Util.isHURegionRdW()) {
            return 49;
        }
        if (Util.isHURegionNAR()) {
            return 60;
        }
        if (Util.isHURegionCN() || Util.isHURegionTW()) {
            return 84;
        }
        if (Util.isHURegionJP()) {
            return 91;
        }
        return -1;
    }

    public static boolean isPoiSelectionTreeAvailable(IFrameworkAccess iFrameworkAccess) {
        return iFrameworkAccess.getSysConst(5581) == 1;
    }

    public static boolean isGooglePoisAvailable(IFrameworkAccess iFrameworkAccess) {
        return iFrameworkAccess.getSysConst(5616) == 1;
    }

    public static int determineSubIndexForTMCEvent(TmcMessage tmcMessage, boolean bl) {
        int n = bl ? Util.getSubindexForEventIcon(tmcMessage) : 0;
        return n;
    }

    private static int getSubindexForEventIcon(TmcMessage tmcMessage) {
        int n = Util.isMessageOnRoute(tmcMessage) ? 0 : (Util.isMessageBypassed(tmcMessage) ? 2 : 1);
        return n;
    }

    private static boolean isMessageOnRoute(TmcMessage tmcMessage) {
        int n;
        boolean bl = false;
        if (tmcMessage != null && (n = tmcMessage.getRouteRelevance()) == 0) {
            bl = true;
        }
        return bl;
    }

    private static boolean isMessageBypassed(TmcMessage tmcMessage) {
        int n;
        boolean bl = false;
        if (tmcMessage != null && ((n = tmcMessage.getRouteRelevance()) == 2 || n == 3)) {
            bl = true;
        }
        return bl;
    }
}

