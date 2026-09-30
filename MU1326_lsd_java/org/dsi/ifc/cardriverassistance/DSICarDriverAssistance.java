/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.cardriverassistance;

import org.dsi.ifc.base.DSIBase;
import org.dsi.ifc.cardriverassistance.ACCDistanceWarning;
import org.dsi.ifc.cardriverassistance.AWVEmergencyBrake;
import org.dsi.ifc.cardriverassistance.NVObjectDetection;
import org.dsi.ifc.cardriverassistance.TSDRoadSignFilter;
import org.dsi.ifc.global.CarBCSpeed;

public interface DSICarDriverAssistance
extends DSIBase {
    public static final String VERSION = "2.11.22";
    public static final int ATTR_SWAVIEWOPTIONS = 1;
    public static final int ATTR_SWAGONGSTATE = 2;
    public static final int ATTR_SWAGONGVOLUME = 3;
    public static final int ATTR_SWASYSTEM = 4;
    public static final int ATTR_SWAWARNINGTIME = 5;
    public static final int ATTR_SWABRIGHTNESS = 6;
    public static final int ATTR_SWAFREQUENCY = 7;
    public static final int ATTR_SWARCTASENSORDATA = 54;
    public static final int ATTR_SWARCTA = 55;
    public static final int ATTR_SWAEXITASSIST = 56;
    public static final int ATTR_NVVIEWOPTIONS = 8;
    public static final int ATTR_NVACTIVATION = 9;
    public static final int ATTR_NVCONTRAST = 10;
    public static final int ATTR_NVBRIGHTNESS = 11;
    public static final int ATTR_NVOBJECTDETECTION = 12;
    public static final int ATTR_NVCOLORPA = 13;
    public static final int ATTR_NVDESIGNPA = 14;
    public static final int ATTR_NVDISPLAY = 15;
    public static final int ATTR_NVZOOMPANNING = 16;
    public static final int ATTR_NVSOUND = 17;
    public static final int ATTR_NVSYMBOL = 18;
    public static final int ATTR_NVSYSTEM = 74;
    public static final int ATTR_NVWARNINGTIMEGAP = 75;
    public static final int ATTR_LDWHCAVIEWOPTIONS = 19;
    public static final int ATTR_LDWWARNINGTIME = 20;
    public static final int ATTR_LDWSTEERINGWHEELVIBRATION = 21;
    public static final int ATTR_HCATOLERANCELEVEL = 22;
    public static final int ATTR_HCAINTERVENTIONSTYLE = 23;
    public static final int ATTR_LDWHCASYSTEMONOFF = 57;
    public static final int ATTR_LDWHCAWARNINGSOUND = 82;
    public static final int ATTR_ACCVIEWOPTIONS = 24;
    public static final int ATTR_ACCGONGSTATE = 25;
    public static final int ATTR_ACCGONGVOLUME = 26;
    public static final int ATTR_ACCDRIVINGPROGRAM = 27;
    public static final int ATTR_ACCTIMEGAP = 28;
    public static final int ATTR_ACCDEFAULTMODE = 29;
    public static final int ATTR_ACCCURVEASSIST = 47;
    public static final int ATTR_ACCSPEEDLIMITADOPTION = 48;
    public static final int ATTR_ACCSPEEDLIMITOFFSET = 49;
    public static final int ATTR_ACCTRAFFICJAMASSIST = 50;
    public static final int ATTR_ACCDISTANCEWARNING = 51;
    public static final int ATTR_PACCSENSIBILITY = 66;
    public static final int ATTR_PACCMAXSPEED = 67;
    public static final int ATTR_PACCMEANVELOCITY = 68;
    public static final int ATTR_PACCMEANCONSUMPTION = 69;
    public static final int ATTR_PACCCOASTINGPERCENTAGE = 70;
    public static final int ATTR_PACCDRIVINGPROGRAM = 71;
    public static final int ATTR_PACCSYSTEMSTATE = 72;
    public static final int ATTR_AWVVIEWOPTIONS = 30;
    public static final int ATTR_AWVSYSTEM = 31;
    public static final int ATTR_AWVWARNING = 32;
    public static final int ATTR_AWVGONG = 33;
    public static final int ATTR_AWVGONGVOLUME = 34;
    public static final int ATTR_AWVBRAKEJERK = 41;
    public static final int ATTR_AWVEMERGENCYBRAKE = 42;
    public static final int ATTR_AWVDISTANCEWARNING = 46;
    public static final int ATTR_AWVWARNINGTIMEGAP = 63;
    public static final int ATTR_TSDVIEWOPTIONS = 35;
    public static final int ATTR_TSDSYSTEMONOFF = 36;
    public static final int ATTR_TSDTRAILERDETECTION = 37;
    public static final int ATTR_TSDSIGN1 = 38;
    public static final int ATTR_TSDSIGN2 = 39;
    public static final int ATTR_TSDSIGN3 = 40;
    public static final int ATTR_TSDSIGN4 = 77;
    public static final int ATTR_TSDSIGN5 = 78;
    public static final int ATTR_TSDROADSIGNFILTER = 43;
    public static final int ATTR_TSDSPEEDWARNINGTHRESHOLD = 52;
    public static final int ATTR_TSDTRAILERSPEEDLIMIT = 53;
    public static final int ATTR_TSDSYSTEMMESSAGES = 64;
    public static final int ATTR_TSDSPEEDWARNINGACOUSTICS = 76;
    public static final int ATTR_MKEVIEWOPTIONS = 44;
    public static final int ATTR_MKESYSTEMONOFF = 45;
    public static final int ATTR_PAVIEWOPTIONS = 58;
    public static final int ATTR_PASYSTEMONOFF = 59;
    public static final int ATTR_PACONFIGINFORMATION = 60;
    public static final int ATTR_PACONFIGWARNING = 61;
    public static final int ATTR_PAWARNINGTIMEGAP = 73;
    public static final int ATTR_CURVEASSISTSYSTEMONOFF = 62;
    public static final int ATTR_FTAVIEWOPTIONS = 79;
    public static final int ATTR_FTASYSTEMONOFF = 80;
    public static final int ATTR_FTASENSORDATA = 81;
    public static final int ACCDRIVINGPROGRAM_COMFORT = 0;
    public static final int ACCDRIVINGPROGRAM_STANDARD = 1;
    public static final int ACCDRIVINGPROGRAM_DYNAMIC = 2;
    public static final int ACCDRIVINGPROGRAM_ECO = 3;
    public static final int ACCDEFAULTMODE_PRESELECTION = 0;
    public static final int ACCDEFAULTMODE_LASTVALUE = 1;
    public static final int ACCSPEEDLIMITOFFSET_OFF = 0;
    public static final int ACCSPEEDLIMITOFFSET_SMALL = 1;
    public static final int ACCSPEEDLIMITOFFSET_MEDIUM = 2;
    public static final int ACCSPEEDLIMITOFFSET_LARGE = 3;
    public static final int PACCSYSTEMSTATE_OFF = 0;
    public static final int PACCSYSTEMSTATE_INIT = 1;
    public static final int PACCSYSTEMSTATE_STANDBY = 2;
    public static final int PACCSYSTEMSTATE_ACTIVEREGULATING = 3;
    public static final int PACCSYSTEMSTATE_PASSIVE = 4;
    public static final int PACCSYSTEMSTATE_ERRORMAP = 5;
    public static final int PACCSYSTEMSTATE_ERRORSYSTEM = 6;
    public static final int PACCSYSTEMSTATE_ERRORIRREVERSIBLE = 7;
    public static final int AWVSYSTEMMODE_LRR = 1;
    public static final int AWVSYSTEMMODE_SRR = 2;
    public static final int AWVSYSTEMMODE_FCW = 3;
    public static final int LDWSTEERINGWHEELVIBRATION_LOW = 0;
    public static final int LDWSTEERINGWHEELVIBRATION_MEDIUMADAPTIVE = 1;
    public static final int LDWSTEERINGWHEELVIBRATION_STRONG = 2;
    public static final int LDWWARNINGTIME_EARLY = 0;
    public static final int LDWWARNINGTIME_MEDIUMADAPTIVE = 1;
    public static final int LDWWARNINGTIME_LATE = 2;
    public static final int HCAINTERVENTIONSTYLE_TORQUE = 0;
    public static final int HCAINTERVENTIONSTYLE_TORQUEVIBRATION = 1;
    public static final int HCAINTERVENTIONSTYLE_VIBRATION = 2;
    public static final int HCATOLERANCELEVEL_EARLY = 0;
    public static final int HCATOLERANCELEVEL_MEDIUMADAPTIVE = 1;
    public static final int HCATOLERANCELEVEL_LATE = 2;
    public static final int LDWHCAWARNINGSOUND_VERYSILENT = 0;
    public static final int LDWHCAWARNINGSOUND_SILENT = 1;
    public static final int LDWHCAWARNINGSOUND_MEDIUM = 2;
    public static final int LDWHCAWARNINGSOUND_LOUD = 3;
    public static final int LDWHCAWARNINGSOUND_VERYLOUD = 4;
    public static final int SWABRIGHTNESS_VERY_DARK = 0;
    public static final int SWABRIGHTNESS_DARK = 1;
    public static final int SWABRIGHTNESS_MEDIUM = 2;
    public static final int SWABRIGHTNESS_BRIGHT = 3;
    public static final int SWABRIGHTNESS_VERY_BRIGHT = 4;
    public static final int SWAWARNINGTIME_EARLY = 0;
    public static final int SWAWARNINGTIME_MEDIUM = 1;
    public static final int SWAWARNINGTIME_LATE = 2;
    public static final int SWAFREQUENCY_EU = 0;
    public static final int SWAFREQUENCY_GB = 1;
    public static final int SWASYSTEM_SWA = 0;
    public static final int SWASYSTEM_BSD = 1;
    public static final int SWAGONGVOLUME_QUIET = 0;
    public static final int SWAGONGVOLUME_NORMAL = 1;
    public static final int SWAGONGVOLUME_LOUD = 2;
    public static final int SWARCTASTATUSLEVEL_NOTACTIVE = 0;
    public static final int SWARCTASTATUSLEVEL_NOOBSTACLE = 1;
    public static final int SWARCTASTATUSLEVEL_CRITICALOBSTACLE = 2;
    public static final int SWARCTASTATUSLEVEL_HIGHCRITICALOBSTACLE = 3;
    public static final int SWARCTASTATUSLEVEL_DEFECT = 15;
    public static final int SWARCTADISTANCE_NOOBSTACLE = 0;
    public static final int SWARCTADISTANCE_GREAT = 1;
    public static final int SWARCTADISTANCE_MEDIUM = 2;
    public static final int SWARCTADISTANCE_SMALL = 3;
    public static final int SWARCTADISTANCE_UNKNOWN = 15;
    public static final int FTASTATUSLEVEL_NOTACTIVE = 0;
    public static final int FTASTATUSLEVEL_NOOBSTACLE = 1;
    public static final int FTASTATUSLEVEL_CRITICALOBSTACLE = 2;
    public static final int FTASTATUSLEVEL_HIGHCRITICALOBSTACLE = 3;
    public static final int FTASTATUSLEVEL_DEFECT = 15;
    public static final int NIGHTVISIONSOUND_OFF = 0;
    public static final int NIGHTVISIONSOUND_LOW = 1;
    public static final int NIGHTVISIONSOUND_MEDIUM = 2;
    public static final int NIGHTVISIONSOUND_LOUD = 3;
    public static final int NVCOLORPA_COLOR0 = 0;
    public static final int NVCOLORPA_COLOR1 = 1;
    public static final int NVCOLORPA_COLOR2 = 2;
    public static final int NVCOLORPA_COLOR3 = 3;
    public static final int NVCOLORPA_COLOR4 = 4;
    public static final int NVDESIGNPA_DESIGN0 = 0;
    public static final int NVDESIGNPA_DESIGN1 = 1;
    public static final int NVDESIGNPA_DESIGN2 = 2;
    public static final int NVDESIGNPA_DESIGN3 = 3;
    public static final int NVDESIGNPA_DESIGN4 = 4;
    public static final int NVDISPLAY_INSTRUMENTCLUSTER = 0;
    public static final int NVDISPLAY_HEADUPDISPLAY = 1;
    public static final int NVDISPLAY_MMI = 2;
    public static final int NVZOOMPANNING_ZOOMPANNINGOFF = 0;
    public static final int NVZOOMPANNING_ZOOMON = 1;
    public static final int NVZOOMPANNING_ZOOMPANNINGON = 2;
    public static final int NVWARNINGTIMEGAP_OFF = 0;
    public static final int NVWARNINGTIMEGAP_LATE = 1;
    public static final int NVWARNINGTIMEGAP_MEDIUM = 2;
    public static final int NVWARNINGTIMEGAP_EARLY = 3;
    public static final int TSDTRAILERSTATE_TRAILER_NOT_DETECTED = 0;
    public static final int TSDTRAILERSTATE_TRAILER_DETECTED = 1;
    public static final int TSDTYPE_NONE = 0;
    public static final int TSDTYPE_VZA = 1;
    public static final int TSDTYPE_VZE = 2;
    public static final int TSDSIGN_NOSIGN = 0;
    public static final int TSDSIGN_SPEEDLIMITEU = 1;
    public static final int TSDSIGN_CANCELSPEEDLIMITEU = 2;
    public static final int TSDSIGN_SPEEDLIMITVAREU = 3;
    public static final int TSDSIGN_CANCELSPEEDLIMITVAREU = 4;
    public static final int TSDSIGN_NOPASSINGALLVEHICLESEU = 5;
    public static final int TSDSIGN_CANCELNOPASSINGALLVEHICLESEU = 6;
    public static final int TSDSIGN_NOPASSINGMORE35TEU = 7;
    public static final int TSDSIGN_CANCELNOPASSINGMORE35TEU = 8;
    public static final int TSDSIGN_NOPASSINGALLVEHICLESVAREU = 9;
    public static final int TSDSIGN_CANCELNOPASSINGALLVEHICLESVAREU = 10;
    public static final int TSDSIGN_NOPASSINGMORE35TVAREU = 11;
    public static final int TSDSIGN_CANCELNOPASSINGMORE35TVAREU = 12;
    public static final int TSDSIGN_CANCELALLLIMITSEU = 13;
    public static final int TSDSIGN_CANCELALLLIMITSVAREU = 14;
    public static final int TSDSIGN_RECOMMENDEDSPEED = 15;
    public static final int TSDSIGN_SPEEDLIMITNARUSA = 49;
    public static final int TSDSIGN_SPEEDLIMITVARNARUSA = 50;
    public static final int TSDSIGN_CANCELSPEEDLIMITNARUSA = 51;
    public static final int TSDSIGN_CANCELSPEEDLIMITVARNARUSA = 52;
    public static final int TSDSIGN_NOPASSINGALLVEHICLESNARUSA = 53;
    public static final int TSDSIGN_NOPASSINGALLVEHICLESVARNARUSA = 54;
    public static final int TSDSIGN_CANCELNOPASSINGALLVEHICLENARUSA = 55;
    public static final int TSDSIGN_CANCELNOPASSINGALLVEHICLEVARNARUSA = 56;
    public static final int TSDSIGN_CANCELALLLIMITSNARUSA = 57;
    public static final int TSDSIGN_CANCELALLLIMITSVARNARUSA = 58;
    public static final int TSDSIGN_SPEEDLIMITNARCANADA = 65;
    public static final int TSDSIGN_SPEEDLIMITVARNARCANADA = 66;
    public static final int TSDSIGN_CANCELSPEEDLIMITNARCANADA = 67;
    public static final int TSDSIGN_CANCELSPEEDLIMITVARNARCANADA = 68;
    public static final int TSDSIGN_NOPASSINGALLVEHICLESNARCANADA = 69;
    public static final int TSDSIGN_NOPASSINGALLVEHICLESVARNARCANADA = 70;
    public static final int TSDSIGN_CANCELNOPASSINGALLVEHICLENARCANADA = 71;
    public static final int TSDSIGN_CANCELNOPASSINGALLVEHICLEVARNARCANADA = 72;
    public static final int TSDSIGN_CANCELALLLIMITSNARCANADA = 73;
    public static final int TSDSIGN_CANCELALLLIMITSVARNARCANADA = 74;
    public static final int TSDSIGN_SPEEDLIMITCHINA = 81;
    public static final int TSDSIGN_SPEEDLIMITVARCHINA = 82;
    public static final int TSDSIGN_CANCELSPEEDLIMITCHINA = 83;
    public static final int TSDSIGN_CANCELSPEEDLIMITVARCHINA = 84;
    public static final int TSDSIGN_NOPASSINGALLVEHICLESCHINA = 85;
    public static final int TSDSIGN_NOPASSINGALLVEHICLESVARCHINA = 86;
    public static final int TSDSIGN_CANCELNOPASSINGALLVEHICLECHINA = 87;
    public static final int TSDSIGN_CANCELNOPASSINGALLVEHICLEVARCHINA = 88;
    public static final int TSDSIGN_CANCELALLLIMITSCHINA = 89;
    public static final int TSDSIGN_CANCELALLLIMITSVARCHINA = 90;
    public static final int TSDSIGN_SPEEDLIMITJAPAN = 97;
    public static final int TSDSIGN_SPEEDLIMITVARJAPAN = 98;
    public static final int TSDSIGN_CANCELSPEEDLIMITJAPAN = 99;
    public static final int TSDSIGN_CANCELSPEEDLIMITVARJAPAN = 100;
    public static final int TSDSIGN_NOPASSINGALLVEHICLESJAPAN = 101;
    public static final int TSDSIGN_NOPASSINGALLVEHICLESVARJAPAN = 102;
    public static final int TSDSIGN_CANCELNOPASSINGALLVEHICLEJAPAN = 103;
    public static final int TSDSIGN_CANCELNOPASSINGALLVEHICLEVARJAPAN = 104;
    public static final int TSDSIGN_CANCELALLLIMITSJAPAN = 105;
    public static final int TSDSIGN_CANCELALLLIMITSVARJAPAN = 106;
    public static final int TSDSIGN_SPEEDLIMITSOUTHKOREA = 113;
    public static final int TSDSIGN_SPEEDLIMITVARSOUTHKOREA = 114;
    public static final int TSDSIGN_CANCELSPEEDLIMITSOUTHKOREA = 115;
    public static final int TSDSIGN_CANCELSPEEDLIMITVARSOUTHKOREA = 116;
    public static final int TSDSIGN_NOPASSINGALLVEHICLESSOUTHKOREA = 117;
    public static final int TSDSIGN_NOPASSINGALLVEHICLESVARSOUTHKOREA = 118;
    public static final int TSDSIGN_CANCELNOPASSINGALLVEHICLESOUTHKOREA = 119;
    public static final int TSDSIGN_CANCELNOPASSINGALLVEHICLEVARSOUTHKOREA = 120;
    public static final int TSDSIGN_CANCELALLLIMITSSOUTHKOREA = 121;
    public static final int TSDSIGN_CANCELALLLIMITSVARSOUTHKOREA = 122;
    public static final int TSDSIGN_SPEEDLIMITAUSTRALIA = 129;
    public static final int TSDSIGN_SPEEDLIMITVARAUSTRALIA = 130;
    public static final int TSDSIGN_CANCELSPEEDLIMITAUSTRALIA = 131;
    public static final int TSDSIGN_CANCELSPEEDLIMITVARAUSTRALIA = 132;
    public static final int TSDSIGN_NOPASSINGALLVEHICLESAUSTRALIA = 133;
    public static final int TSDSIGN_NOPASSINGALLVEHICLESVARAUSTRALIA = 134;
    public static final int TSDSIGN_CANCELNOPASSINGALLVEHICLEAUSTRALIA = 135;
    public static final int TSDSIGN_CANCELNOPASSINGALLVEHICLEVARAUSTRALIA = 136;
    public static final int TSDSIGN_CANCELALLLIMITSAUSTRALIA = 137;
    public static final int TSDSIGN_CANCELALLLIMITSVARAUSTRALIA = 138;
    public static final int TSDSIGN_DANGER_GENERALDANGEREU = 144;
    public static final int TSDSIGN_DANGER_UNMARKEDINTERSECTIONAHEADEU = 145;
    public static final int TSDSIGN_DANGER_PRIORITYATNEXTINTERSECTIONEU = 146;
    public static final int TSDSIGN_DANGER_CURVELEFTEU = 147;
    public static final int TSDSIGN_DANGER_CURVERIGHTEU = 148;
    public static final int TSDSIGN_DANGER_DOUBLECURVELEFTEU = 149;
    public static final int TSDSIGN_DANGER_DOUBLECURVERIGHTEU = 150;
    public static final int TSDSIGN_DANGER_SLIPPERYROADEU = 151;
    public static final int TSDSIGN_DANGER_ROADNARROWSBOTHSIDES = 152;
    public static final int TSDSIGN_DANGER_ROADNARROWSRIGHT = 153;
    public static final int TSDSIGN_DANGER_ROADNARROWSLEFT = 154;
    public static final int TSDSIGN_DANGER_ROADWORKEU = 155;
    public static final int TSDSIGN_DANGER_CONGESTIONHAZARDEU = 156;
    public static final int TSDSIGN_DANGER_PEDESTRIANSEU = 159;
    public static final int TSDSIGN_DANGER_WATCHFORCHILDRENEU = 160;
    public static final int TSDSIGN_DANGER_BYCICLESEU = 161;
    public static final int TSDSIGN_DANGER_WILDANIMALCROSSINGEU = 162;
    public static final int TSDADDSIGN_NOSIGN = 0;
    public static final int TSDADDSIGN_EMPTYADDSIGNEU = 1;
    public static final int TSDADDSIGN_WETEU = 2;
    public static final int TSDADDSIGN_RAINEU = 3;
    public static final int TSDADDSIGN_TEMPCONDEU = 4;
    public static final int TSDADDSIGN_ONLYPASSENGERCAREU = 5;
    public static final int TSDADDSIGN_VEHICLEWITHTRAILEREU = 6;
    public static final int TSDADDSIGN_VEHILCESTURNRIGHT = 7;
    public static final int TSDADDSIGN_VEHILCESTURNLEFT = 8;
    public static final int TSDADDSIGN_OVERTAKINGTRACTORALLOWED = 9;
    public static final int TSDADDSIGN_VARIABLESIGNEU = 10;
    public static final int TSDADDSIGN_FOGEU = 11;
    public static final int TSDADDSIGN_SCHOOLNAR = 12;
    public static final int TSDADDSIGN_NIGHTNAR = 13;
    public static final int TSDADDSIGN_WORKNAR = 14;
    public static final int SYSTEMSTATE_SYSTEM_OFF = 0;
    public static final int SYSTEMSTATE_SYSTEM_ON = 1;
    public static final int WARNINGTIMEGAP_OFF = 0;
    public static final int WARNINGTIMEGAP_LATE = 1;
    public static final int WARNINGTIMEGAP_MEDIUM = 2;
    public static final int WARNINGTIMEGAP_EARLY = 3;
    public static final int RT_SETLDWWARNINGTIME = 1001;
    public static final int RT_SETLDWSTEERINGWHEELVIBRATION = 1002;
    public static final int RT_SETHCAINTERVENTIONSTYLE = 1003;
    public static final int RT_SETHCATOLERANCELEVEL = 1004;
    public static final int RT_SETLDWHCASETFACTORYDEFAULT = 1035;
    public static final int RT_SETLDWHCASYSTEMONOFF = 1048;
    public static final int RT_SETLDWHCAWARNINGSOUND = 1067;
    public static final int RT_SETSWASYSTEM = 1005;
    public static final int RT_SETSWABRIGHTNESS = 1006;
    public static final int RT_SETSWAWARNINGTIME = 1007;
    public static final int RT_SETSWAFREQUENCY = 1008;
    public static final int RT_SETSWAGONGSTATE = 1009;
    public static final int RT_SETSWAGONGVOLUME = 1010;
    public static final int RT_SETSWARCTA = 1046;
    public static final int RT_SETSWAEXITASSIST = 1047;
    public static final int RT_SETACCGONGVOLUME = 1011;
    public static final int RT_SETACCDRIVINGPROGRAM = 1012;
    public static final int RT_SETACCGONGSTATE = 1013;
    public static final int RT_SETACCDEFAULTMODE = 1014;
    public static final int RT_SETACCTIMEGAP = 1015;
    public static final int RT_SETACCCURVEASSIST = 1038;
    public static final int RT_SETACCSPEEDLIMITADOPTION = 1039;
    public static final int RT_SETACCTRAFFICJAMASSIST = 1040;
    public static final int RT_SETACCSPEEDLIMITOFFSET = 1041;
    public static final int RT_SETACCDISTANCEWARNING = 1042;
    public static final int RT_SETACCSETFACTORYDEFAULT = 1043;
    public static final int RT_SETPACCSENSIBILITY = 1059;
    public static final int RT_SETPACCMAXSPEED = 1060;
    public static final int RT_SETPACCDRIVINGPROGRAM = 1061;
    public static final int RT_SETAWVSYSTEM = 1016;
    public static final int RT_SETAWVWARNING = 1017;
    public static final int RT_SETAWVGONG = 1018;
    public static final int RT_SETAWVGONGVOLUME = 1019;
    public static final int RT_SETAWVBRAKEJERK = 1032;
    public static final int RT_SETAWVEMERGENCYBRAKE = 1033;
    public static final int RT_SETAWVDISTANCEWARNING = 1037;
    public static final int RT_SETAWVWARNINGTIMEGAP = 1056;
    public static final int RT_SETAWVSETFACTORYDEFAULT = 1058;
    public static final int RT_SETNVSOUND = 1020;
    public static final int RT_SETNVCONTRAST = 1021;
    public static final int RT_SETNVACTIVATION = 1022;
    public static final int RT_SETNVBRIGHTNESS = 1023;
    public static final int RT_SETNVOBJECTDETECTION = 1024;
    public static final int RT_SETNVCOLORPA = 1025;
    public static final int RT_SETNVDESIGNPA = 1026;
    public static final int RT_SETNVDISPLAY = 1027;
    public static final int RT_SETNVZOOMPANNING = 1028;
    public static final int RT_SETNVSYMBOL = 1029;
    public static final int RT_SETNVSETFACTORYDEFAULT = 1062;
    public static final int RT_SETNVSYSTEM = 1063;
    public static final int RT_SETNVWARNINGTIMEGAP = 1064;
    public static final int RT_SETTSDSYSTEMONOFF = 1030;
    public static final int RT_SETTSDROADSIGNFILTER = 1031;
    public static final int RT_SETTSDSETFACTORYDEFAULT = 1036;
    public static final int RT_SETTSDSPEEDWARNINGTHRESHOLD = 1044;
    public static final int RT_SETTSDTRAILERSPEEDLIMIT = 1045;
    public static final int RT_SETTSDSPEEDWARNINGACOUSTICS = 1065;
    public static final int RT_SETMKESYSTEMONOFF = 1034;
    public static final int RT_SETMKESETFACTORYDEFAULT = 1049;
    public static final int RT_SETPASYSTEMONOFF = 1050;
    public static final int RT_SETPASETFACTORYDEFAULT = 1051;
    public static final int RT_SETPACONFIGINFORMATION = 1052;
    public static final int RT_SETPACONFIGWARNING = 1053;
    public static final int RT_SETPAWARNINGTIMEGAP = 1057;
    public static final int RT_SETCURVEASSISTSYSTEMONOFF = 1054;
    public static final int RT_SETCURVEASSISTSETFACTORYDEFAULT = 1055;
    public static final int RT_SETFTASYSTEMONOFF = 1066;
    public static final int RP_ACKNOWLEDGELDWHCASETFACTORYDEFAULT = 2000;
    public static final int RP_ACKNOWLEDGETSDSETFACTORYDEFAULT = 2001;
    public static final int RP_ACKNOWLEDGEACCSETFACTORYDEFAULT = 2002;
    public static final int RP_ACKNOWLEDGEMKESETFACTORYDEFAULT = 2003;
    public static final int RP_ACKNOWLEDGEPASETFACTORYDEFAULT = 2004;
    public static final int RP_ACKNOWLEDGECURVEASSISTSETFACTORYDEFAULT = 2005;
    public static final int RP_ACKNOWLEDGEAWVSETFACTORYDEFAULT = 2006;
    public static final int RP_ACKNOWLEDGENVSETFACTORYDEFAULT = 2007;

    public void setACCGongState(boolean var1);

    public void setACCGongVolume(int var1);

    public void setACCDrivingProgram(int var1);

    public void setACCTimeGap(int var1);

    public void setACCDefaultMode(int var1);

    public void setACCCurveAssist(boolean var1);

    public void setACCSpeedLimitAdoption(boolean var1);

    public void setACCTrafficJamAssist(boolean var1);

    public void setACCSpeedLimitOffset(int var1);

    public void setACCDistanceWarning(ACCDistanceWarning var1);

    public void setACCSetFactoryDefault();

    public void setPACCSensibility(boolean var1);

    public void setPACCMaxSpeed(int var1, int var2);

    public void setPACCDrivingProgram(int var1);

    public void setAWVSystem(int var1);

    public void setAWVWarning(boolean var1);

    public void setAWVGong(boolean var1);

    public void setAWVGongVolume(int var1);

    public void setAWVBrakeJerk(boolean var1);

    public void setAWVEmergencyBrake(AWVEmergencyBrake var1);

    public void setAWVDistanceWarning(boolean var1);

    public void setAWVWarningTimegap(int var1);

    public void setAWVSetFactoryDefault();

    public void setSWABrightness(int var1);

    public void setSWAWarningTime(int var1);

    public void setSWAFrequency(int var1);

    public void setSWASystem(int var1);

    public void setSWAGongState(boolean var1);

    public void setSWAGongVolume(int var1);

    public void setSWARCTA(boolean var1);

    public void setSWAExitAssist(boolean var1);

    public void setNVActivation(boolean var1);

    public void setNVContrast(int var1);

    public void setNVBrightness(int var1);

    public void setNVObjectDetection(NVObjectDetection var1);

    public void setNVColorPA(int var1);

    public void setNVDesignPA(int var1);

    public void setNVDisplay(int var1);

    public void setNVZoomPanning(int var1);

    public void setNVSound(int var1);

    public void setNVSymbol(boolean var1);

    public void setNVSetFactoryDefault();

    public void setNVWarningTimegap(int var1);

    public void setNVSystem(boolean var1);

    public void setLDWWarningTime(int var1);

    public void setLDWSteeringWheelVibration(int var1);

    public void setHCAInterventionStyle(int var1);

    public void setHCAToleranceLevel(int var1);

    public void setLdwhcaSetFactoryDefault();

    public void setLDWHCASystemOnOff(boolean var1);

    public void setLDWHCAWarningSound(boolean var1, int var2);

    public void setTSDSystemOnOff(boolean var1);

    public void setTSDRoadSignFilter(TSDRoadSignFilter var1);

    public void setTsdSetFactoryDefault();

    public void setTSDSpeedWarningThreshold(boolean var1, CarBCSpeed var2);

    public void setTSDTrailerSpeedLimit(CarBCSpeed var1);

    public void setTSDSpeedWarningAcoustics(boolean var1);

    public void setMKESystemOnOff(boolean var1);

    public void setMKESetFactoryDefault();

    public void setPASystemOnOff(boolean var1);

    public void setPASetFactoryDefault();

    public void setPAConfigInformation(boolean var1);

    public void setPAConfigWarning(boolean var1);

    public void setPAWarningTimegap(int var1);

    public void setCurveAssistSystemOnOff(boolean var1);

    public void setCurveAssistSetFactoryDefault();

    public void setFTASystemOnOff(boolean var1);
}

