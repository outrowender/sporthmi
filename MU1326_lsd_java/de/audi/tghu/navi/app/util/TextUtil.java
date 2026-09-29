/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.util;

import de.audi.tghu.navi.app.NavigationEnv;
import de.esolutions.fw.util.commons.Buffer;

public class TextUtil {
    private static final String DEFAULT_CENTER_NAME;
    private static final String DEFAULT_OFFROAD_NAME;
    private static final String DEFAULT_IN_ALL_CITIES;
    private static final String DEFAULT_STREET_BASENAME_MARKER;
    private static final String DEFAULT_PETROL_STATION_24H_MARKER;
    private static String CENTER_NAME;
    private static String OFFROAD_NAME;
    private static String IN_ALL_CITIES;
    private static String STREET_BASENAME_MARKER;
    private static String PETROL_STATION_24H_MARKER;

    public static String getCenterName() {
        return CENTER_NAME;
    }

    public static String getOffRoadName() {
        return OFFROAD_NAME;
    }

    public static String getInAllCities() {
        return IN_ALL_CITIES;
    }

    public static String appendInAllCities(String string) {
        return new Buffer(string).append(" (").append(TextUtil.getInAllCities()).append(")").toString();
    }

    public static String getStreetBasenameMarker() {
        return STREET_BASENAME_MARKER;
    }

    public static String getPoi24hMarker() {
        return PETROL_STATION_24H_MARKER;
    }

    public static void updateTranslations(NavigationEnv navigationEnv) {
        CENTER_NAME = navigationEnv.getTranslatedText(5, "ZENTRUM");
        OFFROAD_NAME = navigationEnv.getTranslatedText(13, "off road");
        IN_ALL_CITIES = navigationEnv.getTranslatedText(11, "In allen St\u00e4dten");
        STREET_BASENAME_MARKER = "(All)";
        PETROL_STATION_24H_MARKER = "(24h)";
    }

    static {
        CENTER_NAME = "";
        OFFROAD_NAME = "---";
        IN_ALL_CITIES = "";
        STREET_BASENAME_MARKER = "";
        PETROL_STATION_24H_MARKER = "";
    }
}

