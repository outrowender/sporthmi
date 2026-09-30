/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.hmisync.headunit;

public interface ASIHMISyncHeadUnit {
    public static final String IPL_COMM_UUID = "036f2d17-c35a-4f85-8d0c-e89fd5461382";
    public static final String IPL_COMM_INTERFACE_KEY = "c3516fb7-905b-55cc-97e2-b7c3dc5be53b";
    public static final String IPL_COMM_INTERFACE_VERSION = "1.2.00";
    public static final String IPL_COMM_MODULE_VERSION = "1.2.00";

    public static interface Consts {
        public static final int MENULANGUAGE_GERMAN = 0;
        public static final int MENULANGUAGE_ENGLISH_UK = 1;
        public static final int MENULANGUAGE_ENGLISH_US = 2;
        public static final int MENULANGUAGE_FRENCH = 3;
        public static final int MENULANGUAGE_ITALIAN = 4;
        public static final int MENULANGUAGE_SPANISH = 5;
        public static final int MENULANGUAGE_PORTUGUESE = 6;
        public static final int MENULANGUAGE_POLISH = 7;
        public static final int MENULANGUAGE_CZECH = 8;
        public static final int MENULANGUAGE_HUNGARIAN = 9;
        public static final int MENULANGUAGE_DANISH = 10;
        public static final int MENULANGUAGE_SWEDISH = 11;
        public static final int MENULANGUAGE_FINNISH = 12;
        public static final int MENULANGUAGE_DUTCH = 13;
        public static final int MENULANGUAGE_CHINESE_TRADITIONAL = 14;
        public static final int MENULANGUAGE_JAPANESE = 15;
        public static final int MENULANGUAGE_RUSSIAN = 16;
        public static final int MENULANGUAGE_GREEK = 17;
        public static final int MENULANGUAGE_KOREAN = 18;
        public static final int MENULANGUAGE_FRENCH_CANADIAN = 19;
        public static final int MENULANGUAGE_SPANISH_US = 20;
        public static final int MENULANGUAGE_PORTUGUESE_US = 21;
        public static final int MENULANGUAGE_TURKISH = 22;
        public static final int MENULANGUAGE_CHINESE_MANDARIN = 23;
        public static final int MENULANGUAGE_CHINESE_CANTONESE = 24;
        public static final int MENULANGUAGE_ARABIC = 25;
        public static final int MENULANGUAGE_PORTUGUESE_BRAZIL = 26;
        public static final int MENULANGUAGE_MALAYSIAN = 27;
        public static final int MENULANGUAGE_THAI = 28;
        public static final int MENULANGUAGE_NORWEGIAN = 29;
        public static final int TEMPERATUREUNIT_CELSIUS = 0;
        public static final int TEMPERATUREUNIT_FAHRENHEIT = 1;
        public static final int SPEEDUNIT_KMPH = 0;
        public static final int SPEEDUNIT_MPH = 1;
        public static final int DISTANCEUNIT_KM = 0;
        public static final int DISTANCEUNIT_MI = 1;
        public static final int PRESSUREUNIT_BAR = 0;
        public static final int PRESSUREUNIT_PSI = 1;
        public static final int PRESSUREUNIT_KPA = 2;
        public static final int VOLUMEUNIT_LITER = 1;
        public static final int VOLUMEUNIT_GALLON_UK = 2;
        public static final int VOLUMEUNIT_GALLON_US = 3;
        public static final int REGION_EU = 0;
        public static final int REGION_NAR = 1;
        public static final int REGION_CN = 2;
        public static final int REGION_JP = 3;
        public static final int REGION_KR = 4;
        public static final int REGION_TW = 5;
        public static final int REGION_ROW = 6;
        public static final int DRIVERSIDE_LEFT_HAND_DRIVE = 0;
        public static final int DRIVERSIDE_RIGHT_HAND_DRIVE = 1;
    }

    public static class ReplyIDs {
        public static final short resetLanguage = 3;
        public static final short updateASIVersion = 7;
        public static final short updateRequestIDs = 18;
        public static final short updateReplyIDs = 17;
        public static final short updateClockTime = 9;
        public static final short updateClockDate = 8;
        public static final short updateLanguage1 = 11;
        public static final short updateLanguage2 = 12;
        public static final short updateTemperatureUnit = 15;
        public static final short updateSpeedUnit = 14;
        public static final short updateDistanceUnit = 10;
        public static final short updatePressureUnit = 13;
        public static final short updateCarConfiguration = 16;
        public static final short updateRegion = 19;
        public static final short updateExtCarConfiguration = 20;
        public static final short updateSplashScreenCoding = 21;

        public static short[] getIDs() {
            return new short[]{3, 7, 18, 17, 9, 8, 11, 12, 15, 14, 10, 13, 16, 19, 20, 21};
        }
    }

    public static class RequestIDs {
        public static final short setNotification_4 = 4;
        public static final short setNotification_6 = 6;
        public static final short setNotification_5 = 5;
        public static final short clearNotification_0 = 0;
        public static final short clearNotification_2 = 2;
        public static final short clearNotification_1 = 1;

        public static short[] getIDs() {
            return new short[]{4, 6, 5, 0, 2, 1};
        }
    }

    public static interface AttributesIDs {
        public static final long ASIVersion = 7L;
        public static final long RequestIDs = 18L;
        public static final long ReplyIDs = 17L;
        public static final long ClockTime = 9L;
        public static final long ClockDate = 8L;
        public static final long Language1 = 11L;
        public static final long Language2 = 12L;
        public static final long TemperatureUnit = 15L;
        public static final long SpeedUnit = 14L;
        public static final long DistanceUnit = 10L;
        public static final long PressureUnit = 13L;
        public static final long CarConfiguration = 16L;
        public static final long Region = 19L;
        public static final long ExtCarConfiguration = 20L;
        public static final long SplashScreenCoding = 21L;
    }
}

