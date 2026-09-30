/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.caraircondition;

import org.dsi.ifc.base.DSIBase;
import org.dsi.ifc.caraircondition.AirconAirDistribution;
import org.dsi.ifc.caraircondition.AirconAirVolume;
import org.dsi.ifc.caraircondition.AirconBCMeasuresConfiguration;
import org.dsi.ifc.caraircondition.AirconBlowerCompensation;
import org.dsi.ifc.caraircondition.AirconContent;
import org.dsi.ifc.caraircondition.AirconFreshAirConfiguration;
import org.dsi.ifc.caraircondition.AirconNozzleListRecord;
import org.dsi.ifc.caraircondition.AirconPureAirSetup;
import org.dsi.ifc.caraircondition.AirconSteeringWheelHeater;
import org.dsi.ifc.caraircondition.AirconSynchronisation;
import org.dsi.ifc.caraircondition.AirconTemp;
import org.dsi.ifc.global.CarArrayListUpdateInfo;

public interface DSICarAirCondition
extends DSIBase {
    public static final String VERSION = "2.11.15";
    public static final int STYLE_WEAK = 0;
    public static final int STYLE_MEDIUM = 1;
    public static final int STYLE_STRONG = 2;
    public static final int AIRVOLUMEAUTO_OFF = 0;
    public static final int AIRVOLUMEAUTO_AUTO = 1;
    public static final int AIRVOLUMEAUTO_AUTOLOW = 2;
    public static final int AIRVOLUMEAUTO_AUTOHIGH = 3;
    public static final int SYNCHRONISATION_NOTACTIVE = 0;
    public static final int SYNCHRONISATION_ZL1R = 1;
    public static final int SYNCHRONISATION_ZR1R = 2;
    public static final int SYNCHRONISATION_ZL2R = 3;
    public static final int SYNCHRONISATION_ZR2R = 4;
    public static final int SYNCHRONISATION_ZL3R = 5;
    public static final int SYNCHRONISATION_ZR3R = 6;
    public static final int AIRCONCONTENT_NONE = 0;
    public static final int AIRCONCONTENT_AIRDISTRIBUTION = 1;
    public static final int AIRCONCONTENT_TEMPERATURE = 2;
    public static final int AIRCONCONTENT_SEATHEATER = 3;
    public static final int AIRCONCONTENT_SEATVENTILATION = 4;
    public static final int AIRCONCONTENT_AIRVOLUME = 5;
    public static final int AIRCONCONTENT_EXHAUSTION = 6;
    public static final int AIRCONCONTENT_SETUP = 7;
    public static final int AIRCONCONTENT_DEFROST = 8;
    public static final int AIRCONCONTENT_AUTO = 9;
    public static final int AIRCONCONTENT_CIRCULATION = 10;
    public static final int AIRCONCONTENT_AC = 11;
    public static final int AIRCONCONTENT_MIDDLEEXHAUSTION = 12;
    public static final int AIRCONCONTENT_SYNCHRONISATION = 13;
    public static final int AIRCONCONTENT_REARWINDOWHEATER = 14;
    public static final int AIRCONCONTENT_REARCONTROL = 15;
    public static final int AIRCONCONTENT_RESIDUAL = 16;
    public static final int AIRCONCONTENT_HEATER = 17;
    public static final int AIRCONCONTENT_STYLE = 18;
    public static final int AIRCONCONTENT_FRONTWINDOWHEATER = 19;
    public static final int AIRCONCONTENT_FOOTWELLTEMP = 20;
    public static final int AIRCONCONTENT_STEERINGWHEELHEATER = 21;
    public static final int STEERINGWHEELHEATINGSTEP_STEP1 = 1;
    public static final int STEERINGWHEELHEATINGSTEP_STEP2 = 2;
    public static final int STEERINGWHEELHEATINGSTEP_STEP3 = 3;
    public static final int STYLESTATE_UNKNOWN = 0;
    public static final int STYLESTATE_COOLING = 1;
    public static final int STYLESTATE_VENTING = 2;
    public static final int STYLESTATE_HEATING = 3;
    public static final int STYLESTATE_PASSIVE_COOLING = 4;
    public static final int STYLESTATE_PASSIVE_VENTING = 5;
    public static final int STYLESTATE_PASSIVE_HEATING = 6;
    public static final int NOZZLEHORIZONTALPOSITION_LEFT = 1;
    public static final int NOZZLEHORIZONTALPOSITION_LEFTCENTRE = 2;
    public static final int NOZZLEHORIZONTALPOSITION_RIGHTCENTRE = 3;
    public static final int NOZZLEHORIZONTALPOSITION_RIGHT = 4;
    public static final int NOZZLEVERTICALPOSITION_UP = 1;
    public static final int NOZZLEVERTICALPOSITION_CENTRE = 2;
    public static final int NOZZLEVERTICALPOSITION_BOTTOM = 3;
    public static final int NOZZLEINTERVAL_OFF = 0;
    public static final int NOZZLEINTERVAL_SLOW = 1;
    public static final int NOZZLEINTERVAL_MEDIUM = 2;
    public static final int NOZZLEINTERVAL_FAST = 3;
    public static final int NOZZLELISTRACONTENT_POS = 1;
    public static final int NOZZLELISTRACONTENT_HORIZONTALPOSITION = 2;
    public static final int NOZZLELISTRACONTENT_VERTICALPOSITION = 4;
    public static final int NOZZLELISTRACONTENT_CAPABILITIES = 8;
    public static final int NOZZLELISTRACONTENT_HORIZONTAL = 16;
    public static final int NOZZLELISTRACONTENT_VERTICAL = 32;
    public static final int NOZZLELISTRACONTENT_AIRFLOW = 64;
    public static final int NOZZLELISTRACONTENT_STYLE = 128;
    public static final int NOZZLELISTRACONTENT_INTERVALHORIZONTAL = 256;
    public static final int NOZZLELISTRACONTENT_INTERVALVERTICAL = 512;
    public static final int NOZZLECONTROL_CLOSE = 1;
    public static final int NOZZLECONTROL_OPEN = 2;
    public static final int PUREAIRSTATE_STEP0 = 0;
    public static final int PUREAIRSTATE_STEP1 = 1;
    public static final int PUREAIRSTATE_STEP2 = 2;
    public static final int PUREAIRSTATE_STEP3 = 3;
    public static final int PUREAIRSTATE_STEP4 = 4;
    public static final int PUREAIRSTATE_STEP5 = 5;
    public static final int PUREAIRSTATE_STEP6 = 6;
    public static final int PUREAIRSTATE_STEP7 = 7;
    public static final int PUREAIRSTATE_STEP8 = 8;
    public static final int PUREAIRSTATE_STEP9 = 9;
    public static final int PUREAIRSTATE_STEP10 = 10;
    public static final int PUREAIRSTATE_NOTSUPPORTED = 255;
    public static final int FRESHAIRCARTRIDGEWARNING_NONE = 0;
    public static final int FRESHAIRCARTRIDGEWARNING_LEVEL1 = 1;
    public static final int FRESHAIRCARTRIDGEWARNING_LEVEL2 = 2;
    public static final int FRESHAIRCARTRIDGEWARNING_LEVEL3 = 3;
    public static final int FRESHAIRCONFIGSETUP_OFF = 0;
    public static final int FRESHAIRCONFIGSETUP_AUTO = 1;
    public static final int FRESHAIRCONFIGSETUP_AUTOONLINEIQS = 2;
    public static final int FRESHAIRCARTRIDGESELECTION_NONE = 0;
    public static final int FRESHAIRCARTRIDGESELECTION_CARTRIDGE1 = 1;
    public static final int FRESHAIRCARTRIDGESELECTION_CARTRIDGE2 = 2;
    public static final int SEATCLIMATESTATE_OFF = 0;
    public static final int SEATCLIMATESTATE_ON = 1;
    public static final int SEATCLIMATESTATE_AUTO = 2;
    public static final int IONISATORSETUP_OFF = 0;
    public static final int IONISATORSETUP_AUTO = 1;
    public static final int IONISATORSETUP_AUTOONLINEIQS = 2;
    public static final int ZONES_ZONE1 = 1;
    public static final int ZONES_ZONE2 = 2;
    public static final int ZONES_ZONE3 = 4;
    public static final int ZONES_ZONE4 = 8;
    public static final int ZONES_ZONE5 = 16;
    public static final int ZONES_ZONE6 = 32;
    public static final int ROWS_ROW1 = 1;
    public static final int ROWS_ROW2 = 2;
    public static final int ROWS_ROW3 = 4;
    public static final int ATTR_AIRCONVIEWOPTIONSMASTER = 92;
    public static final int ATTR_AIRCONCONTENT = 2;
    public static final int ATTR_AIRCONAIRCIRCULATIONMAN = 3;
    public static final int ATTR_AIRCONAIRCIRCULATIONAUTO = 4;
    public static final int ATTR_AIRCONAIRCIRCULATIONSENSITIVITY = 5;
    public static final int ATTR_AIRCONAIRCIRCULATIONMIDDLEEXHAUSTION = 6;
    public static final int ATTR_AIRCONREARWINDOWHEATER = 7;
    public static final int ATTR_AIRCONINDIRECTVENTILATION = 8;
    public static final int ATTR_AIRCONPOPUPTIME = 9;
    public static final int ATTR_AIRCONHEATER = 10;
    public static final int ATTR_AIRCONREARAUXHEATER = 11;
    public static final int ATTR_AIRCONFRONTWINDOWHEATER = 12;
    public static final int ATTR_AIRCONDEFROST = 13;
    public static final int ATTR_AIRCONMAXDEFROST = 81;
    public static final int ATTR_AIRCONSOLAR = 14;
    public static final int ATTR_AIRCONAC = 15;
    public static final int ATTR_AIRCONMAXAC = 82;
    public static final int ATTR_AIRCONECOAC = 83;
    public static final int ATTR_AIRCONREARCONTROL = 16;
    public static final int ATTR_AIRCONREARCONTROLFONDPLUS = 91;
    public static final int ATTR_AIRCONSTEERINGWHEELHEATER = 17;
    public static final int ATTR_AIRCONFRONTWINDOWHEATERAUTO = 19;
    public static final int ATTR_AIRCONBLOWERCOMPENSATION = 20;
    public static final int ATTR_AIRCONSYNCHRONISATION = 21;
    public static final int ATTR_AIRCONSUPPRESSVISUALISATION = 22;
    public static final int ATTR_AIRCONSYSTEMONOFFROW1 = 152;
    public static final int ATTR_AIRCONSYSTEMONOFFROW2 = 153;
    public static final int ATTR_AIRCONSYSTEMONOFFROW3 = 154;
    public static final int ATTR_AIRCONRESIDUALHEAT = 62;
    public static final int ATTR_AIRCONSIDEWINDOWDEFROST = 102;
    public static final int ATTR_AIRCONPUREAIR = 103;
    public static final int ATTR_AIRCONFRESHAIRSTATE = 104;
    public static final int ATTR_AIRCONFRESHAIRCONFIG = 105;
    public static final int ATTR_AIRCONAIRQUALITY = 106;
    public static final int ATTR_AIRCONVIEWOPTIONSROW1 = 93;
    public static final int ATTR_AIRCONNOZZLELISTUPDATEINFOROW1 = 96;
    public static final int ATTR_AIRCONNOZZLELISTTOTALNUMBEROFELEMENTSROW1 = 99;
    public static final int ATTR_AIRCONNOZZLESTATUSROW1 = 107;
    public static final int ATTR_AIRCONTEMPZONE1 = 24;
    public static final int ATTR_AIRCONAIRVOLUMEZONE1 = 25;
    public static final int ATTR_AIRCONAIRDISTRIBUTIONZONE1 = 26;
    public static final int ATTR_AIRCONFOOTWELLTEMPZONE1 = 27;
    public static final int ATTR_AIRCONSEATHEATERZONE1 = 167;
    public static final int ATTR_AIRCONSEATVENTILATIONZONE1 = 168;
    public static final int ATTR_AIRCONCLIMATESTYLEZONE1 = 110;
    public static final int ATTR_AIRCONCLIMATESTATEZONE1 = 111;
    public static final int ATTR_AIRCONSEATNECKHEATERZONE1 = 122;
    public static final int ATTR_AIRCONSEATSURFACEHEATERZONE1 = 128;
    public static final int ATTR_AIRCONINDIVIDUALCLIMATISATIONZONE1 = 134;
    public static final int ATTR_AIRCONIONISATORZONE1 = 140;
    public static final int ATTR_AIRCONSEATVENTILATIONDISTRIBUTIONZONE1 = 69;
    public static final int ATTR_AIRCONSEATHEATERDISTRIBUTIONZONE1 = 63;
    public static final int ATTR_AIRCONBODYCLOSEMEASURESZONE1 = 146;
    public static final int ATTR_AIRCONTEMPSTEPZONE1 = 75;
    public static final int ATTR_AIRCONTEMPZONE2 = 30;
    public static final int ATTR_AIRCONAIRVOLUMEZONE2 = 31;
    public static final int ATTR_AIRCONAIRDISTRIBUTIONZONE2 = 32;
    public static final int ATTR_AIRCONFOOTWELLTEMPZONE2 = 33;
    public static final int ATTR_AIRCONSEATHEATERZONE2 = 169;
    public static final int ATTR_AIRCONSEATVENTILATIONZONE2 = 170;
    public static final int ATTR_AIRCONCLIMATESTYLEZONE2 = 112;
    public static final int ATTR_AIRCONCLIMATESTATEZONE2 = 113;
    public static final int ATTR_AIRCONSEATNECKHEATERZONE2 = 123;
    public static final int ATTR_AIRCONSEATSURFACEHEATERZONE2 = 129;
    public static final int ATTR_AIRCONINDIVIDUALCLIMATISATIONZONE2 = 135;
    public static final int ATTR_AIRCONIONISATORZONE2 = 141;
    public static final int ATTR_AIRCONBODYCLOSEMEASURESZONE2 = 147;
    public static final int ATTR_AIRCONSEATHEATERDISTRIBUTIONZONE2 = 64;
    public static final int ATTR_AIRCONSEATVENTILATIONDISTRIBUTIONZONE2 = 70;
    public static final int ATTR_AIRCONTEMPSTEPZONE2 = 76;
    public static final int ATTR_AIRCONVIEWOPTIONSROW2 = 94;
    public static final int ATTR_AIRCONNOZZLELISTUPDATEINFOROW2 = 97;
    public static final int ATTR_AIRCONNOZZLELISTTOTALNUMBEROFELEMENTSROW2 = 100;
    public static final int ATTR_AIRCONNOZZLESTATUSROW2 = 108;
    public static final int ATTR_AIRCONTEMPZONE3 = 36;
    public static final int ATTR_AIRCONAIRVOLUMEZONE3 = 37;
    public static final int ATTR_AIRCONAIRDISTRIBUTIONZONE3 = 38;
    public static final int ATTR_AIRCONFOOTWELLTEMPZONE3 = 39;
    public static final int ATTR_AIRCONSEATHEATERZONE3 = 171;
    public static final int ATTR_AIRCONSEATVENTILATIONZONE3 = 172;
    public static final int ATTR_AIRCONCLIMATESTYLEZONE3 = 114;
    public static final int ATTR_AIRCONCLIMATESTATEZONE3 = 115;
    public static final int ATTR_AIRCONSEATNECKHEATERZONE3 = 124;
    public static final int ATTR_AIRCONSEATSURFACEHEATERZONE3 = 130;
    public static final int ATTR_AIRCONINDIVIDUALCLIMATISATIONZONE3 = 136;
    public static final int ATTR_AIRCONIONISATORZONE3 = 142;
    public static final int ATTR_AIRCONBODYCLOSEMEASURESZONE3 = 148;
    public static final int ATTR_AIRCONSEATHEATERDISTRIBUTIONZONE3 = 65;
    public static final int ATTR_AIRCONSEATVENTILATIONDISTRIBUTIONZONE3 = 71;
    public static final int ATTR_AIRCONTEMPSTEPZONE3 = 77;
    public static final int ATTR_AIRCONTEMPZONE4 = 42;
    public static final int ATTR_AIRCONAIRVOLUMEZONE4 = 43;
    public static final int ATTR_AIRCONAIRDISTRIBUTIONZONE4 = 44;
    public static final int ATTR_AIRCONFOOTWELLTEMPZONE4 = 45;
    public static final int ATTR_AIRCONSEATHEATERZONE4 = 173;
    public static final int ATTR_AIRCONSEATVENTILATIONZONE4 = 174;
    public static final int ATTR_AIRCONCLIMATESTYLEZONE4 = 116;
    public static final int ATTR_AIRCONCLIMATESTATEZONE4 = 117;
    public static final int ATTR_AIRCONSEATNECKHEATERZONE4 = 125;
    public static final int ATTR_AIRCONSEATSURFACEHEATERZONE4 = 131;
    public static final int ATTR_AIRCONINDIVIDUALCLIMATISATIONZONE4 = 137;
    public static final int ATTR_AIRCONIONISATORZONE4 = 143;
    public static final int ATTR_AIRCONBODYCLOSEMEASURESZONE4 = 149;
    public static final int ATTR_AIRCONSEATHEATERDISTRIBUTIONZONE4 = 66;
    public static final int ATTR_AIRCONSEATVENTILATIONDISTRIBUTIONZONE4 = 72;
    public static final int ATTR_AIRCONTEMPSTEPZONE4 = 78;
    public static final int ATTR_AIRCONVIEWOPTIONSROW3 = 95;
    public static final int ATTR_AIRCONNOZZLELISTUPDATEINFOROW3 = 98;
    public static final int ATTR_AIRCONNOZZLELISTTOTALNUMBEROFELEMENTSROW3 = 101;
    public static final int ATTR_AIRCONNOZZLESTATUSROW3 = 109;
    public static final int ATTR_AIRCONTEMPZONE5 = 48;
    public static final int ATTR_AIRCONAIRVOLUMEZONE5 = 49;
    public static final int ATTR_AIRCONAIRDISTRIBUTIONZONE5 = 50;
    public static final int ATTR_AIRCONFOOTWELLTEMPZONE5 = 51;
    public static final int ATTR_AIRCONSEATHEATERZONE5 = 175;
    public static final int ATTR_AIRCONSEATVENTILATIONZONE5 = 176;
    public static final int ATTR_AIRCONCLIMATESTYLEZONE5 = 118;
    public static final int ATTR_AIRCONCLIMATESTATEZONE5 = 119;
    public static final int ATTR_AIRCONSEATNECKHEATERZONE5 = 126;
    public static final int ATTR_AIRCONSEATSURFACEHEATERZONE5 = 132;
    public static final int ATTR_AIRCONINDIVIDUALCLIMATISATIONZONE5 = 138;
    public static final int ATTR_AIRCONIONISATORZONE5 = 144;
    public static final int ATTR_AIRCONBODYCLOSEMEASURESZONE5 = 150;
    public static final int ATTR_AIRCONSEATHEATERDISTRIBUTIONZONE5 = 67;
    public static final int ATTR_AIRCONSEATVENTILATIONDISTRIBUTIONZONE5 = 73;
    public static final int ATTR_AIRCONTEMPSTEPZONE5 = 79;
    public static final int ATTR_AIRCONTEMPZONE6 = 54;
    public static final int ATTR_AIRCONAIRVOLUMEZONE6 = 55;
    public static final int ATTR_AIRCONAIRDISTRIBUTIONZONE6 = 56;
    public static final int ATTR_AIRCONFOOTWELLTEMPZONE6 = 57;
    public static final int ATTR_AIRCONSEATHEATERZONE6 = 177;
    public static final int ATTR_AIRCONSEATVENTILATIONZONE6 = 178;
    public static final int ATTR_AIRCONCLIMATESTYLEZONE6 = 120;
    public static final int ATTR_AIRCONCLIMATESTATEZONE6 = 121;
    public static final int ATTR_AIRCONSEATNECKHEATERZONE6 = 127;
    public static final int ATTR_AIRCONSEATSURFACEHEATERZONE6 = 133;
    public static final int ATTR_AIRCONINDIVIDUALCLIMATISATIONZONE6 = 139;
    public static final int ATTR_AIRCONIONISATORZONE6 = 145;
    public static final int ATTR_AIRCONBODYCLOSEMEASURESZONE6 = 151;
    public static final int ATTR_AIRCONSEATHEATERDISTRIBUTIONZONE6 = 68;
    public static final int ATTR_AIRCONSEATVENTILATIONDISTRIBUTIONZONE6 = 74;
    public static final int ATTR_AIRCONTEMPSTEPZONE6 = 80;
    public static final int RT_SHOWAIRCONPOPUP = 1000;
    public static final int RT_CANCELAIRCONPOPUP = 1001;
    public static final int RT_SETAIRCONAIRCIRCULATIONMAN = 1002;
    public static final int RT_SETAIRCONAIRCIRCULATIONAUTO = 1003;
    public static final int RT_SETAIRCONMIDDLEEXHAUSTION = 1004;
    public static final int RT_SETAIRCONREARWINDOWHEATER = 1005;
    public static final int RT_SETAIRCONINDIRECTVENTILATION = 1006;
    public static final int RT_SETAIRCONPOPUPTIME = 1007;
    public static final int RT_SETAIRCONHEATER = 1008;
    public static final int RT_SETAIRCONREARAUXHEATER = 1009;
    public static final int RT_SETAIRCONFRONTWINDOWHEATER = 1010;
    public static final int RT_SETAIRCONDEFROST = 1011;
    public static final int RT_SETAIRCONMAXDEFROST = 1042;
    public static final int RT_SETAIRCONSOLAR = 1012;
    public static final int RT_SETAIRCONAC = 1013;
    public static final int RT_SETAIRCONMAXAC = 1041;
    public static final int RT_SETAIRCONECOAC = 1043;
    public static final int RT_SETAIRCONREARCONTROL = 1014;
    public static final int RT_SETAIRCONREARCONTROLFONDPLUS = 1046;
    public static final int RT_SETAIRCONSTEERINGWHEELHEATER = 1015;
    public static final int RT_SETAIRCONFRONTWINDOWHEATERAUTO = 1017;
    public static final int RT_SETAIRCONBLOWERCOMPENSATION = 1018;
    public static final int RT_SETAIRCONSYNCHRONISATION = 1019;
    public static final int RT_SETAIRCONSUPPRESSVISUALISATION = 1020;
    public static final int RT_SETAIRCONSYSTEMONOFFROW = 1063;
    public static final int RT_SETAIRCONRESIDUALHEAT = 1033;
    public static final int RT_SETAIRCONCONTENT = 1022;
    public static final int RT_SETAIRCONAIRCIRCULATIONSENSITIVITY = 1023;
    public static final int RT_SETAIRCONHMIISREADY = 1030;
    public static final int RT_SETAIRCONTEMPZONE = 1024;
    public static final int RT_SETAIRCONAIRVOLUME = 1025;
    public static final int RT_SETAIRCONAIRDISTRIBUTION = 1026;
    public static final int RT_SETAIRCONFOOTWELLTEMP = 1027;
    public static final int RT_SETAIRCONSEATHEATER = 1067;
    public static final int RT_SETAIRCONSEATVENTILATION = 1068;
    public static final int RT_SETAIRCONSEATHEATERDISTRIBUTION = 1038;
    public static final int RT_SETAIRCONSEATVENTILATIONDISTRIBUTION = 1039;
    public static final int RT_SETAIRCONTEMPSTEP = 1040;
    public static final int RT_SETAIRCONIONISATOR = 1069;
    public static final int RT_SETAIRCONCLIMATESTYLE = 1058;
    public static final int RT_SETAIRCONSETFACTORYDEFAULTMASTER = 1047;
    public static final int RT_SETAIRCONSETFACTORYDEFAULTROW = 1048;
    public static final int RT_SETAIRCONNOZZLECONTROLROW1 = 1049;
    public static final int RT_SETAIRCONNOZZLECONTROLROW2 = 1050;
    public static final int RT_SETAIRCONNOZZLECONTROLROW3 = 1051;
    public static final int RT_REQUESTAIRCONNOZZLELISTROW = 1052;
    public static final int RT_SETAIRCONNOZZLELISTROW = 1053;
    public static final int RT_SETAIRCONSIDEWINDOWDEFROST = 1054;
    public static final int RT_SETAIRCONPUREAIR = 1055;
    public static final int RT_SETAIRCONFRESHAIRCONFIG = 1056;
    public static final int RT_SETAIRCONAIRQUALITY = 1057;
    public static final int RT_SETAIRCONSEATNECKHEATER = 1059;
    public static final int RT_SETAIRCONSEATSURFACEHEATER = 1060;
    public static final int RT_SETAIRCONINDIVIDUALCLIMATISATION = 1061;
    public static final int RT_SETAIRCONBODYCLOSEMEASURES = 1062;
    public static final int RP_ACKNOWLEDGEAIRCONSETFACTORYDEFAULTMASTER = 2003;
    public static final int RP_ACKNOWLEDGEAIRCONSETFACTORYDEFAULTROW = 2004;
    public static final int RP_ACKNOWLEDGEAIRCONNOZZLECONTROLROW1 = 2005;
    public static final int RP_ACKNOWLEDGEAIRCONNOZZLECONTROLROW2 = 2006;
    public static final int RP_ACKNOWLEDGEAIRCONNOZZLECONTROLROW3 = 2007;
    public static final int IN_REQUESTAIRCONPOPUP = 3000;
    public static final int IN_ACKNOWLEGDEAIRCONPOPUP = 3001;
    public static final int IN_RESPONSEAIRCONNOZZLELISTROW1 = 3002;
    public static final int IN_RESPONSEAIRCONNOZZLELISTROW2 = 3003;
    public static final int IN_RESPONSEAIRCONNOZZLELISTROW3 = 3004;

    public void setAirconAirCirculationMan(boolean var1);

    public void setAirconAirCirculationAuto(boolean var1);

    public void setAirconMiddleExhaustion(int var1);

    public void setAirconRearWindowHeater(boolean var1);

    public void setAirconIndirectVentilation(boolean var1);

    public void setAirconPopupTime(int var1);

    public void setAirconHeater(boolean var1);

    public void setAirconRearAuxHeater(boolean var1);

    public void setAirconFrontWindowHeater(boolean var1);

    public void setAirconDefrost(boolean var1);

    public void setAirconMaxDefrost(boolean var1);

    public void setAirconSolar(boolean var1);

    public void setAirconAC(boolean var1);

    public void setAirconMaxAC(boolean var1);

    public void setAirconEcoAC(boolean var1);

    public void setAirconRearControl(boolean var1);

    public void setAirconRearControlFondPlus(boolean var1);

    public void setAirconSteeringWheelHeater(AirconSteeringWheelHeater var1);

    public void setAirconFrontWindowHeaterAuto(boolean var1);

    public void setAirconBlowerCompensation(AirconBlowerCompensation var1);

    public void setAirconSynchronisation(AirconSynchronisation var1);

    public void setAirconSuppressVisualisation(boolean var1);

    public void setAirconSystemOnOffRow(int var1, boolean var2);

    public void setAirconAirCirculationSensitivity(int var1);

    public void setAirconResidualHeat(boolean var1);

    public void showAirconPopup(AirconContent var1);

    public void cancelAirconPopup(AirconContent var1, int var2);

    public void setAirconContent(AirconContent var1);

    public void setAirconTempZone(int var1, AirconTemp var2);

    public void setAirconAirVolume(int var1, AirconAirVolume var2);

    public void setAirconAirDistribution(int var1, AirconAirDistribution var2);

    public void setAirconFootwellTemp(int var1, int var2);

    public void setAirconSeatHeater(int var1, int var2, int var3);

    public void setAirconSeatVentilation(int var1, int var2, int var3);

    public void setAirconHMIIsReady(boolean var1);

    public void setAirconSeatHeaterDistribution(int var1, int var2);

    public void setAirconSeatVentilationDistribution(int var1, int var2);

    public void setAirconTempStep(int var1, int var2);

    public void setAirconClimateStyle(int var1, int var2);

    public void setAirconSetFactoryDefaultMaster();

    public void setAirconSetFactoryDefaultRow(int var1);

    public void setAirconNozzleControlRow1(int var1);

    public void setAirconNozzleControlRow2(int var1);

    public void setAirconNozzleControlRow3(int var1);

    public void requestAirconNozzleListRow(int var1, CarArrayListUpdateInfo var2);

    public void setAirconNozzleListRow(int var1, CarArrayListUpdateInfo var2, AirconNozzleListRecord[] var3);

    public void setAirconSideWindowDefrost(boolean var1);

    public void setAirconPureAir(AirconPureAirSetup var1);

    public void setAirconFreshAirConfig(AirconFreshAirConfiguration var1);

    public void setAirconAirQuality(int var1, int var2);

    public void setAirconSeatNeckHeater(int var1, boolean var2, int var3);

    public void setAirconSeatSurfaceHeater(int var1, boolean var2, boolean var3, int var4);

    public void setAirconIndividualClimatisation(int var1, boolean var2);

    public void setAirconIonisator(int var1, int var2);

    public void setAirconBodyCloseMeasures(int var1, boolean var2, AirconBCMeasuresConfiguration var3);
}

