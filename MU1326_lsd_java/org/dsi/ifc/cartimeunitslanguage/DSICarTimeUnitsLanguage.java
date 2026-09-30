/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.cartimeunitslanguage;

import org.dsi.ifc.base.DSIBase;
import org.dsi.ifc.cartimeunitslanguage.ClockDate;
import org.dsi.ifc.cartimeunitslanguage.ClockGPSSyncData;
import org.dsi.ifc.cartimeunitslanguage.ClockSummerTimeData;

public interface DSICarTimeUnitsLanguage
extends DSIBase {
    public static final String VERSION = "2.11.26";
    public static final int ATTR_CLOCKVIEWOPTIONS = 1;
    public static final int ATTR_CLOCKDATE = 2;
    public static final int ATTR_CLOCKTIME = 3;
    public static final int ATTR_CLOCKSOURCE = 4;
    public static final int ATTR_CLOCKDAYLIGHTSAVING = 5;
    public static final int ATTR_CLOCKDAYLIGHTSAVINGDATA = 6;
    public static final int ATTR_CLOCKTIMEZONEOFFSET = 7;
    public static final int ATTR_CLOCKTIMESOURCESAVAILABLE = 8;
    public static final int ATTR_CLOCKGPSSYNCDATA = 9;
    public static final int ATTR_UNITMASTERVIEWOPTIONS = 10;
    public static final int ATTR_MENULANGUAGE = 11;
    public static final int ATTR_TEMPERATUREUNIT = 12;
    public static final int ATTR_DISTANCEUNIT = 13;
    public static final int ATTR_SPEEDUNIT = 14;
    public static final int ATTR_PRESSUREUNIT = 15;
    public static final int ATTR_VOLUMEUNIT = 16;
    public static final int ATTR_CONSUMPTIONPETROLUNIT = 17;
    public static final int ATTR_CONSUMPTIONGASUNIT = 18;
    public static final int ATTR_CLOCKFORMAT = 19;
    public static final int ATTR_DATEFORMAT = 20;
    public static final int ATTR_UTCOFFSET = 21;
    public static final int ATTR_CONSUMPTIONELECTRICUNIT = 22;
    public static final int ATTR_SKIN = 23;
    public static final int ATTR_WEIGHTUNIT = 24;
    public static final int VOLUMEGASUNIT_LBS = 0;
    public static final int VOLUMEGASUNIT_M3 = 1;
    public static final int VOLUMEGASUNIT_YARD3 = 2;
    public static final int VOLUMEGASUNIT_KG = 3;
    public static final int DATEFORMAT_DAY_MONTH_YEAR = 0;
    public static final int DATEFORMAT_MONTH_DAY_YEAR = 1;
    public static final int DATEFORMAT_YEAR_MONTH_DAY = 2;
    public static final int CLOCKFORMAT_24H = 0;
    public static final int CLOCKFORMAT_12AMPM = 1;
    public static final int CONSUMPTIONUNITELECTRICKWHPMSUPPORT_NOTSUPPORTED = 0;
    public static final int CONSUMPTIONUNITELECTRICKWHPMSUPPORT_SUPPORTED = 1;
    public static final int CONSUMPTIONUNITMPGUSESUPPORT_NOTSUPPORTED = 0;
    public static final int CONSUMPTIONUNITMPGUSESUPPORT_SUPPORTED = 1;
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
    public static final int MENULANGUAGE_CROATIAN = 30;
    public static final int MENULANGUAGE_SERBIAN = 31;
    public static final int MENULANGUAGE_SLOVAK = 32;
    public static final int MENULANGUAGE_ROMANIAN = 33;
    public static final int MENULANGUAGE_HINDI = 34;
    public static final int MENULANGUAGE_INDONESIAN = 35;
    public static final int MENULANGUAGE_AZERBAIJANIAN = 36;
    public static final int MENULANGUAGE_BOSNIAN = 37;
    public static final int MENULANGUAGE_SLOWENIAN = 38;
    public static final int MENULANGUAGE_BULGARIAN = 39;
    public static final int MENULANGUAGE_LATVIAN = 40;
    public static final int MENULANGUAGE_ESTONIAN = 41;
    public static final int MENULANGUAGE_LITHUANIAN = 42;
    public static final int MENULANGUAGE_UKRAINIAN = 43;
    public static final int CLOCKSOURCE_NOTVALID = 0;
    public static final int CLOCKSOURCE_QUARTZ = 1;
    public static final int CLOCKSOURCE_DCF77 = 2;
    public static final int CLOCKSOURCE_GPS = 3;
    public static final int CLOCKDAYLIGHTSAVINGMODE_NONE = 0;
    public static final int CLOCKDAYLIGHTSAVINGMODE_PLUSONEHOUR = 1;
    public static final int CLOCKDAYLIGHTSAVINGMODE_MESZ = 2;
    public static final int CLOCKDAYLIGHTSAVINGMODE_USA = 3;
    public static final int CLOCKDAYLIGHTSAVINGMODE_NAVIGATION_DB = 4;
    public static final int TIME_INVALID = 0;
    public static final int TIME_SUMMERTIME = 1;
    public static final int TIME_WINTERTIME = 2;
    public static final int UTCOFFSETSTATE_INVALID = 0;
    public static final int UTCOFFSETSTATE_VALID_NOT_SYNCED_TO_UTC = 1;
    public static final int UTCOFFSETSTATE_VALID_SYNCED_TO_UTC = 2;
    public static final int SKIN_SKIN1 = 0;
    public static final int SKIN_SKIN2 = 1;
    public static final int SKIN_SKIN3 = 2;
    public static final int SKIN_UNKNOWN = 255;
    public static final int RT_SETCLOCKDATE = 1000;
    public static final int RT_SETCLOCKTIME = 1001;
    public static final int RT_SETCLOCKSOURCE = 1002;
    public static final int RT_SETCLOCKDAYLIGHTSAVING = 1003;
    public static final int RT_SETCLOCKTIMEZONEOFFSET = 1005;
    public static final int RT_SETCLOCKGPSSYNCDATA = 1006;
    public static final int RT_SETMENULANGUAGE = 1007;
    public static final int RT_SETPRESSUREUNIT = 1008;
    public static final int RT_SETVOLUMEUNIT = 1009;
    public static final int RT_SETTEMPERATUREUNIT = 1010;
    public static final int RT_SETDISTANCEUNIT = 1011;
    public static final int RT_SETSPEEDUNIT = 1012;
    public static final int RT_SETCONSUMPTIONPETROLUNIT = 1013;
    public static final int RT_SETCONSUMPTIONGASUNIT = 1014;
    public static final int RT_SETCLOCKFORMAT = 1015;
    public static final int RT_SETDATEFORMAT = 1016;
    public static final int RT_SETUMSETFACTORYDEFAULT = 1017;
    public static final int RT_SETCONSUMPTIONELECTRICUNIT = 1018;
    public static final int RT_SETSKIN = 1019;
    public static final int RT_SETCLOCKSUMMERTIMEDATA = 1020;
    public static final int RT_SETWEIGHTUNIT = 1021;
    public static final int RP_ACKNOWLEDGEUMSETFACTORYDEFAULT = 2000;

    public void setMenuLanguage(int var1);

    public void setPressureUnit(int var1);

    public void setVolumeUnit(int var1);

    public void setTemperatureUnit(int var1);

    public void setDistanceUnit(int var1);

    public void setSpeedUnit(int var1);

    public void setConsumptionPetrolUnit(int var1);

    public void setConsumptionGasUnit(int var1);

    public void setConsumptionElectricUnit(int var1);

    public void setClockFormat(int var1);

    public void setDateFormat(int var1);

    public void setClockDate(ClockDate var1);

    public void setClockTime(byte var1, byte var2, byte var3);

    public void setClockSource(int var1);

    public void setClockDayLightSaving(boolean var1);

    public void setClockTimeZoneOffset(float var1);

    public void setClockGPSSyncData(ClockGPSSyncData var1);

    public void setClockSummerTimeData(ClockSummerTimeData var1);

    public void setUmSetFactoryDefault();

    public void setSkin(int var1);

    public void setWeightUnit(int var1);
}

