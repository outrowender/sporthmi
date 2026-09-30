/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.carkombi;

import org.dsi.ifc.base.DSIBase;
import org.dsi.ifc.carkombi.BCMenueConfiguration;
import org.dsi.ifc.carkombi.BCSpeedWarningSettings;
import org.dsi.ifc.carkombi.BCStatisticsReset;
import org.dsi.ifc.carkombi.BCVehicleStateUpdateInfoAH;
import org.dsi.ifc.carkombi.DCAdditionalInstrument;
import org.dsi.ifc.carkombi.DCAdditionalInstrument2;
import org.dsi.ifc.carkombi.DCDisplayDependency;
import org.dsi.ifc.carkombi.DCDisplayPresetsListRecord;
import org.dsi.ifc.carkombi.DCDisplayViewConfiguration;
import org.dsi.ifc.carkombi.DCElementContentSelectionListRA1;
import org.dsi.ifc.carkombi.DCElementContentSelectionListRA2;
import org.dsi.ifc.carkombi.DCElementContentSelectionListUpdateInfo;
import org.dsi.ifc.carkombi.DCMainItems;
import org.dsi.ifc.carkombi.HUDCollectiveTopics;
import org.dsi.ifc.carkombi.HUDContent;
import org.dsi.ifc.carkombi.HUDSectionConfigListRecord;
import org.dsi.ifc.global.CarArrayListUpdateInfo;

public interface DSICarKombi
extends DSIBase {
    public static final String VERSION = "2.11.30";
    public static final int ATTR_SIAVIEWOPTIONS = 1;
    public static final int ATTR_SIASERVICEDATA = 2;
    public static final int ATTR_SIAOILINSPECTION = 3;
    public static final int ATTR_SIAHISTORYLISTUPDATEINFO = 103;
    public static final int ATTR_SIAHISTORYLISTTOTALNUMBEROFELEMENTS = 104;
    public static final int ATTR_SIADISTANCEOILUSER = 105;
    public static final int ATTR_SIADISTANCEAIRFILTERUSER = 106;
    public static final int ATTR_SIADISTANCEOILFILTERUSER = 107;
    public static final int ATTR_SIAINSPECTIONDISTANCEUSER = 108;
    public static final int ATTR_SIADAILYAVERAGEMILEAGE = 109;
    public static final int ATTR_BCVIEWOPTIONS = 4;
    public static final int ATTR_BCINDICATIONS = 5;
    public static final int ATTR_BCCURRENTCONSUMPTION1 = 6;
    public static final int ATTR_BCCURRENTCONSUMPTION2 = 7;
    public static final int ATTR_BCCURRENTRANGE1 = 8;
    public static final int ATTR_BCCURRENTRANGE2 = 9;
    public static final int ATTR_BCTOTALDISTANCE = 10;
    public static final int ATTR_BCSHORTTERMAVERAGECONSUMPTION1 = 11;
    public static final int ATTR_BCSHORTTERMAVERAGECONSUMPTION2 = 12;
    public static final int ATTR_BCSHORTTERMGENERAL = 13;
    public static final int ATTR_BCLONGTERMAVERAGECONSUMPTION1 = 14;
    public static final int ATTR_BCLONGTERMAVERAGECONSUMPTION2 = 15;
    public static final int ATTR_BCLONGTERMGENERAL = 16;
    public static final int ATTR_BCCYCLEAVERAGECONSUMPTION1 = 17;
    public static final int ATTR_BCCYCLEAVERAGECONSUMPTION2 = 18;
    public static final int ATTR_BCCYCLEGENERAL = 19;
    public static final int ATTR_BCVZADISPLAY = 20;
    public static final int ATTR_BCLIFETIPSDISPLAY = 21;
    public static final int ATTR_BCCONSUMERDISPLAY = 22;
    public static final int ATTR_BCTANKLEVEL1 = 23;
    public static final int ATTR_BCTANKLEVEL2 = 24;
    public static final int ATTR_BCREFUELVOLUME1 = 25;
    public static final int ATTR_BCREFUELVOLUME2 = 26;
    public static final int ATTR_BCMENUE1CONFIG = 27;
    public static final int ATTR_BCMENUE2CONFIG = 28;
    public static final int ATTR_BCMENUE3CONFIG = 29;
    public static final int ATTR_BCOILTEMPERATURE = 30;
    public static final int ATTR_BCDIGITALSPEED = 31;
    public static final int ATTR_BCSTOPWATCH = 32;
    public static final int ATTR_BCSPEEDWARNING = 33;
    public static final int ATTR_BCGEARRECOMMENDATION = 34;
    public static final int ATTR_BCREARSEATBELTWARNING = 35;
    public static final int ATTR_HUDVIEWOPTIONS = 37;
    public static final int ATTR_HUDHEIGHTADJUSTMENT = 38;
    public static final int ATTR_HUDBRIGHTNESS = 39;
    public static final int ATTR_HUDCONTENT = 40;
    public static final int ATTR_HUDPRESETS = 110;
    public static final int ATTR_HUDCOLLECTIVETOPICS = 111;
    public static final int ATTR_HUDAUTOSKINSWITCH = 112;
    public static final int ATTR_HUDSECTIONCONFIGLISTUPDATEINFO = 113;
    public static final int ATTR_HUDSECTIONCONFIGLISTTOTALNUMBEROFELEMENTS = 114;
    public static final int ATTR_BCVEHICLESTATELISTTOTALNUMBEROFELEMENTS = 41;
    public static final int ATTR_COMPASSINFO = 42;
    public static final int ATTR_BCVZAMFA = 43;
    public static final int ATTR_HUDINFO = 44;
    public static final int ATTR_BCSTATISTICSCONFIG = 45;
    public static final int ATTR_BCSTATISTICSTIMECURRENTPERIODZE = 46;
    public static final int ATTR_BCSTATISTICSTIMECURRENTPERIODRE = 47;
    public static final int ATTR_BCSTATISTICSTIMECURRENTPERIODAC2 = 48;
    public static final int ATTR_BCSTATISTICSTIMECURRENTPERIODAC1 = 49;
    public static final int ATTR_BCSTATISTICSTIMEZE = 50;
    public static final int ATTR_BCSTATISTICSTIMERE = 51;
    public static final int ATTR_BCSTATISTICSTIMEAC2 = 52;
    public static final int ATTR_BCSTATISTICSTIMEAC1 = 53;
    public static final int ATTR_BCSTATISTICSDISTANCECURRENTINTERVALZE = 54;
    public static final int ATTR_BCSTATISTICSDISTANCECURRENTINTERVALRE = 55;
    public static final int ATTR_BCSTATISTICSDISTANCECURRENTINTERVALAC2 = 56;
    public static final int ATTR_BCSTATISTICSDISTANCECURRENTINTERVALAC1 = 57;
    public static final int ATTR_BCSTATISTICSDISTANCEZE = 58;
    public static final int ATTR_BCSTATISTICSDISTANCERE = 59;
    public static final int ATTR_BCSTATISTICSDISTANCEAC2 = 60;
    public static final int ATTR_BCSTATISTICSDISTANCEAC1 = 61;
    public static final int ATTR_BCCOMFORTPOWERCONSUMPTION = 62;
    public static final int ATTR_BCCOOLANTTEMPERATURE = 63;
    public static final int ATTR_BCOILTEMPERATUREVALUE = 64;
    public static final int ATTR_BCOUTSIDETEMPERATURE = 65;
    public static final int ATTR_HUDROTATIONADJUSTMENT = 66;
    public static final int ATTR_BCSTATISTICDISTANCEEUKM = 67;
    public static final int ATTR_BCSTATISTICDISTANCEEUMLS = 68;
    public static final int ATTR_BCTOTALCURRENTRANGE = 69;
    public static final int ATTR_BCZEROEMISSIONDISTANCEST = 70;
    public static final int ATTR_BCZEROEMISSIONTIMEST = 71;
    public static final int ATTR_BCZEROEMISSIONDISTANCELT = 72;
    public static final int ATTR_BCZEROEMISSIONTIMELT = 73;
    public static final int ATTR_BCZEROEMISSIONDISTANCECY = 74;
    public static final int ATTR_BCZEROEMISSIONTIMECY = 75;
    public static final int ATTR_BCMAXVALUES = 76;
    public static final int ATTR_BCRESETTIMESTAMPST = 77;
    public static final int ATTR_BCRESETTIMESTAMPLT = 78;
    public static final int ATTR_BCRESETTIMESTAMPCY = 79;
    public static final int ATTR_HUDSYSTEMONOFF = 80;
    public static final int ATTR_HUDCOLOUR = 81;
    public static final int ATTR_DCVIEWOPTIONS = 82;
    public static final int ATTR_DCBRIGHTNESS = 83;
    public static final int ATTR_DCVOLUME = 84;
    public static final int ATTR_DCELEMENTCONTENTSELECTIONLISTTOTALNUMBEROFELEMENTS = 85;
    public static final int ATTR_DCDISPLAY1SETUP = 86;
    public static final int ATTR_DCDISPLAY2SETUP = 87;
    public static final int ATTR_DCDISPLAY3SETUP = 88;
    public static final int ATTR_DCDISPLAY1MAINSELECTION = 89;
    public static final int ATTR_DCDISPLAY2MAINSELECTION = 90;
    public static final int ATTR_DCDISPLAY3MAINSELECTION = 91;
    public static final int ATTR_DCELEMENTCONTENTSELECTIONLISTUPDATEINFO = 92;
    public static final int ATTR_DCADDITIONALINSTRUMENTSETUP = 93;
    public static final int ATTR_BCASTAMFA = 94;
    public static final int ATTR_DCADDITIONALINSTRUMENT2SETUP = 95;
    public static final int ATTR_DCDISPLAYPRESETSLISTTOTALNUMBEROFELEMENTS = 96;
    public static final int ATTR_DCDISPLAYPRESETSLISTUPDATEINFO = 97;
    public static final int ATTR_DCDISPLAYDEPENDENCYSETUP = 98;
    public static final int ATTR_DCACTIVEDISPLAYPRESET = 99;
    public static final int ATTR_DCDISPLAYVIEWCONFIGURATION = 100;
    public static final int ATTR_HUDLICENSE = 101;
    public static final int ATTR_DCLEDCONFIGURATION = 102;
    public static final int RT_RESETSIAVALUE = 1000;
    public static final int RT_REQUESTSIAHISTORYLIST = 1045;
    public static final int RT_SETSIADISTANCEOILUSER = 1046;
    public static final int RT_SETSIADISTANCEAIRFILTERUSER = 1047;
    public static final int RT_SETSIADISTANCEOILFILTERUSER = 1048;
    public static final int RT_SETSIAINSPECTIONDISTANCEUSER = 1049;
    public static final int RT_SETBCVZADISPLAY = 1001;
    public static final int RT_SETBCLIFETIPSDISPLAY = 1002;
    public static final int RT_SETBCCONSUMERDISPLAY = 1003;
    public static final int RT_SETBCMENUECONFIG = 1004;
    public static final int RT_RESETBCMENUE = 1005;
    public static final int RT_SETBCOILTEMPERATURE = 1006;
    public static final int RT_SETBCDIGITALSPEED = 1007;
    public static final int RT_SETBCSTOPWATCH = 1008;
    public static final int RT_SETBCSPEEDWARNING = 1009;
    public static final int RT_SETBCGEARRECOMMENDATION = 1010;
    public static final int RT_SETBCREARSEATBELTWARNING = 1011;
    public static final int RT_SETHUDHEIGHTADJUSTMENT = 1012;
    public static final int RT_SETHUDBRIGHTNESS = 1013;
    public static final int RT_SETHUDCONTENT = 1014;
    public static final int RT_SETHUDPRESETS = 1050;
    public static final int RT_SETHUDCOLLECTIVETOPICS = 1051;
    public static final int RT_SETHUDAUTOSKINSWITCH = 1052;
    public static final int RT_REQUESTHUDSECTIONCONFIGLIST = 1053;
    public static final int RT_SETHUDSECTIONCONFIGLIST = 1054;
    public static final int RT_SETBCSETFACTORYDEFAULT = 1015;
    public static final int RT_REQUESTVEHICLESTATELIST = 1016;
    public static final int RT_RESETBCSTATISTICS = 1017;
    public static final int RT_SETBCVZAMFA = 1018;
    public static final int RT_SETHUDROTATIONADJUSTMENT = 1019;
    public static final int RT_SETHUDCOLOUR = 1020;
    public static final int RT_SETHUDSETFACTORYDEFAULT = 1021;
    public static final int RT_SETHUDSYSTEMONOFF = 1022;
    public static final int RT_SETDCSETFACTORYDEFAULT = 1023;
    public static final int RT_SETDCBRIGHTNESS = 1024;
    public static final int RT_SETDCVOLUME = 1025;
    public static final int RT_SETDCDISPLAY1MAINSELECTION = 1026;
    public static final int RT_SETDCDISPLAY2MAINSELECTION = 1027;
    public static final int RT_SETDCDISPLAY3MAINSELECTION = 1028;
    public static final int RT_SETDCELEMENTCONTENTSELECTIONLISTRA1 = 1029;
    public static final int RT_SETDCELEMENTCONTENTSELECTIONLISTRA2 = 1044;
    public static final int RT_SETDCELEMENTCONTENTSELECTIONLISTRAF = 1030;
    public static final int RT_REQUESTDCELEMENTCONTENTSELECTIONLIST = 1031;
    public static final int RT_SETDCADDITIONALINSTRUMENTSETUP = 1032;
    public static final int RT_SETBCASTAMFA = 1033;
    public static final int RT_SETDCADDITIONALINSTRUMENT2SETUP = 1034;
    public static final int RT_SETDCDISPLAYDEPENDENCYSETUP = 1035;
    public static final int RT_SETDCACTIVEDISPLAYPRESET = 1038;
    public static final int RT_SETDCDISPLAYVIEWCONFIGURATION = 1039;
    public static final int RT_SETHUDLICENSE = 1040;
    public static final int RT_REQUESTDCDISPLAYPRESETSLIST = 1041;
    public static final int RT_SETDCDISPLAYPRESETSLIST = 1042;
    public static final int RT_SETDCLEDCONFIGURATION = 1043;
    public static final int RP_INDICATEENDOFSIARESET = 2000;
    public static final int RP_INDICATEENDOFBCMENURESET = 2001;
    public static final int RP_ACKNOWLEDGEBCSETFACTORYDEFAULT = 2002;
    public static final int RP_ACKNOWLEDGEHUDSETFACTORYDEFAULT = 2003;
    public static final int RP_ACKNOWLEDGEDCSETFACTORYDEFAULT = 2005;
    public static final int IN_RESPONSEVEHICLESTATELISTWARNINGIDDYNVALUEALTERNATIVETEXT = 3002;
    public static final int IN_RESPONSEVEHICLESTATELISTWARNINGIDDYNVALUE = 3003;
    public static final int IN_RESPONSEVEHICLESTATELISTALTERNATIVETEXT = 3004;
    public static final int IN_RESPONSEVEHICLESTATELISTDYNVALUE = 3005;
    public static final int RP_ACKNOWLEDGEBCSTATISTICSRESET = 2008;
    public static final int IN_RESPONSEVEHICLESTATEUPDATEINFO = 3000;
    public static final int IN_RESPONSEVEHICLESTATELISTPOS = 3001;
    public static final int IN_RESPONSEDCELEMENTCONTENTSELECTIONLISTRAF = 3007;
    public static final int IN_RESPONSEDCELEMENTCONTENTSELECTIONLISTRA1 = 3008;
    public static final int IN_RESPONSEDCELEMENTCONTENTSELECTIONLISTRA2 = 3010;
    public static final int IN_RESPONSEDCDISPLAYPRESETSLIST = 3009;
    public static final int IN_RESPONSESIAHISTORYLIST = 3011;
    public static final int IN_RESPONSEHUDSECTIONCONFIGLIST = 3012;
    public static final int SIADISTANCESTATUS_UNDEFINED = 0;
    public static final int SIADISTANCESTATUS_NOT_CALCULATED_YET = 1;
    public static final int SIADISTANCESTATUS_SERVICE_IN = 2;
    public static final int SIADISTANCESTATUS_SERVICE_AGO = 3;
    public static final int SIATIMESTATUS_UNDEFINED = 0;
    public static final int SIATIMESTATUS_NOT_CALCULATED = 1;
    public static final int SIATIMESTATUS_SERVICE_IN = 2;
    public static final int SIATIMESTATUS_SERVICE_AGO = 3;
    public static final int SIARESETVALUES_OIL_DISTANCE = 1;
    public static final int SIARESETVALUES_OIL_TIME = 2;
    public static final int SIARESETVALUES_INSPECTION_DISTANCE = 4;
    public static final int SIARESETVALUES_INSPECTION_TIME = 8;
    public static final int SIAHISTORYLISTRACONTENT_POS = 1;
    public static final int SIAHISTORYLISTRACONTENT_SERVICE_TYPE = 2;
    public static final int SIAHISTORYLISTRACONTENT_SERVICE_ATTRIBUTES = 4;
    public static final int SIAHISTORYLISTRACONTENT_YEAR = 8;
    public static final int SIAHISTORYLISTRACONTENT_MONTH = 16;
    public static final int SIAHISTORYLISTRACONTENT_DAY = 32;
    public static final int SIAHISTORYLISTRACONTENT_ORDER_CODE = 64;
    public static final int SIAHISTORYLISTRACONTENT_MILAGE = 128;
    public static final int SIAHISTORYLISTRACONTENT_MILAGE_UNIT = 256;
    public static final int SIAHISTORYLISTRACONTENT_DEALER_NAME = 512;
    public static final int BCENGINE_PRIMARY_ENGINE = 0;
    public static final int BCENGINE_SECONDARY_ENGINE = 1;
    public static final int BCENGINETYPE_NOT_INSTALLED = 0;
    public static final int BCENGINETYPE_PETROL = 1;
    public static final int BCENGINETYPE_GAS = 2;
    public static final int BCENGINETYPE_ELECTRIC = 3;
    public static final int BCENGINETYPE_UNKNOWN = 4;
    public static final int BCENGINETYPE_NOT_SUPPORTED = 5;
    public static final int BCENGINETYPE_PETROL_DIESEL = 6;
    public static final int BCENGINETYPE_PETROL_GASOLINE = 7;
    public static final int BCENGINETYPE_GAS_CNG = 8;
    public static final int BCENGINETYPE_GAS_LPG = 9;
    public static final int BCMENUSTATE_INVALID = 0;
    public static final int BCMENUSTATE_VALID = 1;
    public static final int BCTEMPERATURESTATE_INITIAL = 0;
    public static final int BCTEMPERATURESTATE_VALID = 1;
    public static final int BCTEMPERATURESTATE_INVALID = 2;
    public static final int BCCOUNTERSTATE_INITIAL = 0;
    public static final int BCCOUNTERSTATE_VALID = 1;
    public static final int BCCOUNTERSTATE_INVALID = 2;
    public static final int BCMENUE_ALL = 0;
    public static final int BCMENUE_ONE = 1;
    public static final int BCMENUE_TWO = 2;
    public static final int BCMENUE_THREE = 3;
    public static final int BCMENUE_MAX_VALUES = 4;
    public static final int BCMENUE_TRIP = 5;
    public static final int VEHICLESTATELISTARRAYCONTENT_NONE = 0;
    public static final int VEHICLESTATELISTARRAYCONTENT_ALL = 1;
    public static final int VEHICLESTATELISTARRAYCONTENT_ALL_FORWARD = 2;
    public static final int VEHICLESTATELISTARRAYCONTENT_ALL_BACKWARD = 3;
    public static final int VEHICLESTATELISTARRAYCONTENT_ONLY_CHANGES = 4;
    public static final int VEHICLESTATELISTARRAYCONTENT_ELEMENTS_REMOVED = 5;
    public static final int VEHICLESTATELISTARRAYCONTENT_BLOCK_INSERTED = 6;
    public static final int VEHICLESTATELISTARRAYCONTENT_BACKWARD = 7;
    public static final int VEHICLESTATELISTRECORDCONTENT_WARNINGID_DYNVALUE_ALTERNATIVETEXT = 0;
    public static final int VEHICLESTATELISTRECORDCONTENT_WARNINGID_DYNVALUE = 1;
    public static final int VEHICLESTATELISTRECORDCONTENT_ALTERNATIVETEXT = 2;
    public static final int VEHICLESTATELISTRECORDCONTENT_DYNVALUE = 3;
    public static final int VEHICLESTATELISTRECORDCONTENT_POS_ONLY = 15;
    public static final int VEHICLESTATELISTRECORDCONTENT_NONE = 16;
    public static final int BCVALUESTATE_INVALID = 0;
    public static final int BCVALUESTATE_VALID = 1;
    public static final int BCVALUESTATE_MAX = 2;
    public static final int BCVALUESTATE_NOT_CALCULATED = 3;
    public static final int BCVALUESTATE_INIT = 4;
    public static final int BCACKSTATE_SUCCESSFUL = 0;
    public static final int BCACKSTATE_NOT_SUCCESSFUL = 1;
    public static final int BCACKSTATE_ABORT_SUCCESSFUL = 2;
    public static final int BCACKSTATE_ABORT_NOT_SUCCESSFUL = 3;
    public static final int HUDINFORMATION_FAULTY = 0;
    public static final int HUDINFORMATION_PROPERLY = 1;
    public static final int HUDCOLOURDESIGN_AUTO = 0;
    public static final int HUDCOLOURDESIGN_DAY = 1;
    public static final int HUDCOLOURDESIGN_NIGHT = 2;
    public static final int HUDCOLOUR_DEFAULT = 0;
    public static final int HUDCOLOUR_ALTERNATIVE = 1;
    public static final int HUDPRESETS_NONE = 0;
    public static final int HUDPRESETS_ASSISTANCE = 1;
    public static final int HUDPRESETS_NAVIGATION = 2;
    public static final int HUDPRESETS_SPORTCHRONO = 3;
    public static final int HUDPRESETS_OFFROAD = 4;
    public static final int HUDPRESETS_PHEV = 5;
    public static final int HUDPRESETS_INDIVIDUAL = 6;
    public static final int HUDCOLLECTIVETOPICS_NO_VISUALISATION = 0;
    public static final int HUDCOLLECTIVETOPICS_VISUALISATION_HUD = 1;
    public static final int HUDCOLLECTIVETOPICS_VISUALISATION_VIRTUALCOCKPIT = 2;
    public static final int HUDCOLLECTIVETOPICS_VISUALISATION_HUD_AND_VIRTUALCOCKPIT = 3;
    public static final int HUDNAVINFO_NO_VISUALISATION = 0;
    public static final int HUDNAVINFO_ONLY_MANEUVER = 1;
    public static final int HUDNAVINFO_ALWAYS = 2;
    public static final int HUDSECTIONCONFIGLISTRACONTENT_POS = 1;
    public static final int HUDSECTIONCONFIGLISTRACONTENT_DISPLAYSECTION = 2;
    public static final int HUDSECTIONCONFIGLISTRACONTENT_DISPLAYSECTIONSETUP1 = 4;
    public static final int HUDSECTIONCONFIGLISTRACONTENT_DISPLAYSECTIONSETUP2 = 8;
    public static final int HUDSECTIONCONFIGLISTRACONTENT_DISPLAYSECTIONSETUP3 = 16;
    public static final int HUDSECTIONCONFIGLISTRACONTENT_DISPLAYSECTIONSETUP4 = 32;
    public static final int HUDSECTIONCONFIGLISTRACONTENT_DISPLAYSECTIONSELECTION1 = 64;
    public static final int HUDSECTIONCONFIGLISTRACONTENT_DISPLAYSECTIONSELECTION2 = 128;
    public static final int HUDSECTIONCONFIGLISTRACONTENT_DISPLAYSECTIONSELECTION3 = 256;
    public static final int HUDSECTIONCONFIGLISTRACONTENT_DISPLAYSECTIONSELECTION4 = 512;
    public static final int DCELEMENTCONTENTSELECTIONLISTRECORDCONTENT_RA0 = 0;
    public static final int DCELEMENTCONTENTSELECTIONLISTRECORDCONTENT_RA1 = 1;
    public static final int DCELEMENTCONTENTSELECTIONLISTRECORDCONTENT_RA2 = 2;
    public static final int DCELEMENTCONTENTSELECTIONLISTRECORDCONTENT_RAF = 15;
    public static final int DCELEMENTCONTENT_BLANKLINE = 0;
    public static final int DCELEMENTCONTENT_BOOSTPRESSURE = 1;
    public static final int DCELEMENTCONTENT_OILPRESSURE = 2;
    public static final int DCELEMENTCONTENT_OILTEMPERATURE = 3;
    public static final int DCELEMENTCONTENT_COOLANTTEMPERATURE = 4;
    public static final int DCELEMENTCONTENT_FUELRANGE = 5;
    public static final int DCELEMENTCONTENT_DESTINATIONARRIVALTIME = 6;
    public static final int DCELEMENTCONTENT_INTERMEDIATEARRIVALTIME = 7;
    public static final int DCELEMENTCONTENT_DESTINATIONTRIPTIME = 8;
    public static final int DCELEMENTCONTENT_INTERMEDIATETRIPTIME = 9;
    public static final int DCELEMENTCONTENT_COMPASS = 10;
    public static final int DCELEMENTCONTENT_GPSHEIGHT = 11;
    public static final int DCELEMENTCONTENT_TIME = 12;
    public static final int DCELEMENTCONTENT_DATE = 13;
    public static final int DCELEMENTCONTENT_HYBRIDBATTERY = 14;
    public static final int DCELEMENTCONTENT_STATIONTRACK = 15;
    public static final int DCELEMENTCONTENT_PHONEINFO = 16;
    public static final int DCELEMENTCONTENT_LATERALACCELERATION = 17;
    public static final int DCELEMENTCONTENT_ACCELERATION = 18;
    public static final int DCELEMENTCONTENT_DECELERATION = 19;
    public static final int DCELEMENTCONTENT_ELECTRICRANGE = 20;
    public static final int DCELEMENTCONTENT_BATTERYSTATEOFCHARGE = 21;
    public static final int DCELEMENTCONTENT_CHARGINGTIMELEFT = 22;
    public static final int DCELEMENTCONTENT_BATTERYTEMPERATURE = 23;
    public static final int DCELEMENTCONTENT_BATTERYLEVELRANGE = 24;
    public static final int DCELEMENTCONTENT_COOLANT = 25;
    public static final int DCELEMENTCONTENT_BOOSTLEVELVALUE = 26;
    public static final int DCELEMENTCONTENT_BATTERYCOOLANT = 27;
    public static final int DCELEMENTCONTENT_BATTERYBOOST = 28;
    public static final int DCELEMENTCONTENT_BOOSTCOOLANT = 29;
    public static final int DCELEMENTCONTENT_VEHICLEVOLTAGE = 30;
    public static final int DCELEMENTCONTENT_AVERAGECONSUMPTION = 31;
    public static final int DCELEMENTCONTENT_DISTANCE = 32;
    public static final int DCELEMENTCONTENT_DRIVINGTIME = 33;
    public static final int DCELEMENTCONTENT_CURRENTCONSUMPTION = 34;
    public static final int DCELEMENTCONTENT_ZEROEMISSION = 35;
    public static final int DCELEMENTCONTENT_DRIVINGPROFILE = 36;
    public static final int DCELEMENTCONTENT_SECONDARYSPEED = 37;
    public static final int DCELEMENTCONTENT_DIGITALSPEED = 38;
    public static final int DCELEMENTCONTENT_ENERGYFLOW = 39;
    public static final int DCELEMENTCONTENT_ACC = 40;
    public static final int DCELEMENTCONTENT_ROUTEGUIDANCE = 41;
    public static final int DCELEMENTCONTENT_TRAFFICSIGNDETECTION = 42;
    public static final int DCELEMENTCONTENT_SHIFTUPINDICATION = 43;
    public static final int DCELEMENTCONTENT_PERFORMANCE = 44;
    public static final int DCELEMENTCONTENT_PREDICTIVEEFFICIENCYASSISTANT = 45;
    public static final int DCELEMENTCONTENT_WILDCARD = 46;
    public static final int DCELEMENTCONTENT_STEERINGANGLE = 47;
    public static final int DCELEMENTCONTENT_SLOPE = 48;
    public static final int DCELEMENTCONTENT_CONSUMPTION_DATA = 49;
    public static final int DCELEMENTCONTENT_COMBUSTOR_CONSUMPTION = 50;
    public static final int DCELEMENTCONTENT_ELECTRICAL_CONSUMPTION = 51;
    public static final int DCELEMENTCONTENT_AVERAGESPEED = 52;
    public static final int DCELEMENTCONTENT_POWERMETER = 53;
    public static final int DCELEMENTCONTENT_TACHOMETER = 54;
    public static final int DCELEMENTCONTENT_POWERMETER_AND_TACHOMETER = 55;
    public static final int DCELEMENTCONTENT_HYBRID = 56;
    public static final int DCELEMENTCONTENT_ENGINE_DATA = 57;
    public static final int DCELEMENTCONTENT_SHORTTERM_DATA = 58;
    public static final int DCELEMENTCONTENT_LONGTERM_DATA = 59;
    public static final int DCELEMENTCONTENT_G_METER = 60;
    public static final int DCELEMENTCONTENT_TYRE_PRESSURE_MONITOR = 61;
    public static final int DISPLAYPRESETLISTRACONTENT_POS = 1;
    public static final int DISPLAYPRESETSLISTRACONTENT_STATE = 2;
    public static final int DISPLAYPRESETSLISTRACONTENT_DISPLAYPRESETTYPE = 4;
    public static final int DISPLAYPRESETSLISTRACONTENT_DISPLAYPRESETINSTANCE = 8;
    public static final int DISPLAYPRESETSLISTRACONTENT_DISPLAY1MAINSELECTION = 16;
    public static final int DISPLAYPRESETSLISTRACONTENT_DISPLAY1ADDITIONALINFO1 = 32;
    public static final int DISPLAYPRESETSLISTRACONTENT_DISPLAY1ADDITIONALINFO2 = 64;
    public static final int DISPLAYPRESETSLISTRACONTENT_DISPLAY2MAINSELECTION = 128;
    public static final int DISPLAYPRESETSLISTRACONTENT_DISPLAY2ADDITIONALINFO1 = 256;
    public static final int DISPLAYPRESETSLISTRACONTENT_DISPLAY2ADDITIONALINFO2 = 512;
    public static final int DISPLAYPRESETSLISTRACONTENT_DISPLAY3MAINSELECTION = 1024;
    public static final int DISPLAYPRESETSLISTRACONTENT_DISPLAY3ADDITIONALINFO1 = 2048;
    public static final int DISPLAYPRESETSLISTRACONTENT_DISPLAY3ADDITIONALINFO2 = 4096;
    public static final int DCSTATE_EMPTY = 0;
    public static final int DCSTATE_PREDEFINED = 1;
    public static final int DCSTATE_USERDEFINED = 2;
    public static final int DCDISPLAYPRESETSTYPE_UNKNOWN = 0;
    public static final int DCDISPLAYPRESETSTYPE_INDIVIDUAL = 1;
    public static final int DCDISPLAYPRESETSTYPE_CLASSIC = 2;
    public static final int DCDISPLAYPRESETSTYPE_DRIVINGPROFILE = 3;
    public static final int DCDISPLAYVIEWCONFIGURATION_UNKNOWN = 0;
    public static final int DCDISPLAYVIEWCONFIGURATION_NORMAL = 1;
    public static final int DCDISPLAYVIEWCONFIGURATION_LARGE = 2;
    public static final int DCDISPLAYVIEWCONFIGURATION_DISPLAY_VIEW1 = 3;
    public static final int DCDISPLAYVIEWCONFIGURATION_DISPLAY_VIEW2 = 4;
    public static final int DCDISPLAYVIEWCONFIGURATION_DISPLAY_VIEW3 = 5;
    public static final int DCDISPLAYVIEWCONFIGURATION_DISPLAY_VIEW4 = 6;
    public static final int DCDISPLAYVIEWCONFIGURATION_DISPLAY_VIEW5 = 7;
    public static final int DCDISPLAYVIEWCONFIGURATION_DISPLAY_VIEW6 = 8;
    public static final int DCDISPLAYVIEWCONFIGURATION_DISPLAY_VIEW7 = 9;
    public static final int DCDISPLAYVIEWCONFIGURATION_DISPLAY_VIEW8 = 10;
    public static final int DCDISPLAYVIEWCONFIGURATION_DISPLAY_VIEW9 = 11;
    public static final int DCDISPLAYVIEWCONFIGURATION_DISPLAY_VIEW10 = 12;

    public void resetSIAValue(int var1);

    public void requestSIAHistoryList(CarArrayListUpdateInfo var1);

    public void setSIADistanceOilUser(int var1, int var2);

    public void setSIADistanceAirFilterUser(int var1, int var2);

    public void setSIADistanceOilFilterUser(int var1, int var2);

    public void setSIAInspectionDistanceUser(int var1, int var2);

    public void setBCVZADisplay(boolean var1);

    public void setBCLifeTipsDisplay(boolean var1);

    public void setBCConsumerDisplay(boolean var1);

    public void setBCMenueConfig(BCMenueConfiguration var1, int var2);

    public void resetBCMenue(int var1);

    public void setBCOilTemperature(boolean var1);

    public void setBCDigitalSpeed(boolean var1);

    public void setBCStopwatch(boolean var1);

    public void setBCVzaMFA(boolean var1);

    public void setBCSpeedWarning(BCSpeedWarningSettings var1);

    public void setBCGearRecommendation(boolean var1);

    public void setBCRearSeatbeltWarning(boolean var1);

    public void requestVehicleStateList(BCVehicleStateUpdateInfoAH var1);

    public void setBcSetFactoryDefault();

    public void resetBCStatistics(BCStatisticsReset var1);

    public void setBCAstaMFA(boolean var1);

    public void setHUDHeightAdjustment(byte var1);

    public void setHUDBrightness(byte var1);

    public void setHUDContent(HUDContent var1);

    public void setHUDRotationAdjustment(int var1);

    public void setHUDColour(int var1, int var2);

    public void setHUDSetFactoryDefault();

    public void setHUDSystemOnOff(boolean var1);

    public void setHUDPresets(int var1, int var2);

    public void setHUDCollectiveTopics(HUDCollectiveTopics var1);

    public void setHUDAutoSkinSwitch(boolean var1);

    public void requestHUDSectionConfigList(CarArrayListUpdateInfo var1);

    public void setHUDSectionConfigList(CarArrayListUpdateInfo var1, HUDSectionConfigListRecord[] var2);

    public void setDCSetFactoryDefault();

    public void setDCBrightness(int var1);

    public void setDCVolume(int var1);

    public void setDCDisplay1MainSelection(DCMainItems var1);

    public void setDCDisplay2MainSelection(DCMainItems var1);

    public void setDCDisplay3MainSelection(DCMainItems var1);

    public void requestDCElementContentSelectionList(DCElementContentSelectionListUpdateInfo var1);

    public void setDCElementContentSelectionListRA1(DCElementContentSelectionListUpdateInfo var1, DCElementContentSelectionListRA1[] var2);

    public void setDCElementContentSelectionListRA2(DCElementContentSelectionListUpdateInfo var1, DCElementContentSelectionListRA2[] var2);

    public void setDCElementContentSelectionListRAF(DCElementContentSelectionListUpdateInfo var1, int[] var2);

    public void setDCAdditionalInstrumentSetup(DCAdditionalInstrument var1);

    public void setDCAdditionalInstrument2Setup(DCAdditionalInstrument2 var1);

    public void requestDCDisplayPresetsList(CarArrayListUpdateInfo var1);

    public void setDCDisplayPresetsList(CarArrayListUpdateInfo var1, DCDisplayPresetsListRecord[] var2);

    public void setDCDisplayDependencySetup(DCDisplayDependency var1);

    public void setDCActiveDisplayPreset(int var1);

    public void setDCDisplayViewConfiguration(DCDisplayViewConfiguration var1);

    public void setHUDLicense(boolean var1);

    public void setDCLEDConfiguration(boolean var1);
}

