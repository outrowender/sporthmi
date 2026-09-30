/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.carlight;

import org.dsi.ifc.base.DSIBase;
import org.dsi.ifc.carlight.IntLightBrightness;
import org.dsi.ifc.carlight.IntLightRGBColorListUpdateInfo;
import org.dsi.ifc.carlight.IntLightRGBValues;
import org.dsi.ifc.carlight.MotorwayBlinkingSettings;
import org.dsi.ifc.carlight.TimeState;

public interface DSICarLight
extends DSIBase {
    public static final String VERSION = "2.11.20";
    public static final int ATTR_INTLIGHTVIEWOPTIONS = 1;
    public static final int ATTR_INTLIGHTCOLOUR = 7;
    public static final int ATTR_INTLIGHTSTATE = 8;
    public static final int ATTR_INTLIGHTENVIRONMENT = 9;
    public static final int ATTR_INTLIGHTSPEED = 10;
    public static final int ATTR_INTLIGHTTEMPERATURE = 11;
    public static final int ATTR_INTLIGHTBRIGHTNESS = 27;
    public static final int ATTR_INTLIGHTILLUMINATIONSET1 = 29;
    public static final int ATTR_INTLIGHTILLUMINATIONSET2 = 30;
    public static final int ATTR_INTLIGHTILLUMINATIONSET3 = 31;
    public static final int ATTR_INTLIGHTILLUMINATIONSET4 = 32;
    public static final int ATTR_INTLIGHTILLUMINATIONSET5 = 33;
    public static final int ATTR_INTLIGHTILLUMINATIONSET6 = 34;
    public static final int ATTR_INTLIGHTILLUMINATIONSET7 = 35;
    public static final int ATTR_INTLIGHTILLUMINATIONSET8 = 36;
    public static final int ATTR_INTLIGHTILLUMINATIONPROFILE1 = 37;
    public static final int ATTR_INTLIGHTILLUMINATIONPROFILE2 = 38;
    public static final int ATTR_INTLIGHTILLUMINATIONPROFILE3 = 39;
    public static final int ATTR_INTLIGHTILLUMINATIONPROFILE4 = 40;
    public static final int ATTR_INTLIGHTILLUMINATIONPROFILE5 = 41;
    public static final int ATTR_INTLIGHTILLUMINATIONPROFILE6 = 42;
    public static final int ATTR_INTLIGHTILLUMINATIONPROFILE7 = 43;
    public static final int ATTR_INTLIGHTILLUMINATIONPROFILE8 = 44;
    public static final int ATTR_INTLIGHTACTIVEPROFILE = 45;
    public static final int ATTR_INTLIGHTAMBIENTLIGHTCOLOR = 46;
    public static final int ATTR_INTLIGHTCONTOURLIGHTCOLOR = 47;
    public static final int ATTR_INTLIGHTFOLLOWUPTIME = 48;
    public static final int ATTR_INTLIGHTRGBCOLORLISTUPDATEINFO = 49;
    public static final int ATTR_INTLIGHTRGBCOLORLISTTOTALNUMBEROFELEMENTS = 50;
    public static final int ATTR_INTLIGHTDOORCONTACT = 52;
    public static final int ATTR_EXTLIGHTVIEWOPTIONS = 12;
    public static final int ATTR_EXTLIGHTCOMINGHOME = 13;
    public static final int ATTR_EXTLIGHTLEAVINGHOME = 14;
    public static final int ATTR_EXTLIGHTSWITCHONSENSITIVITY = 15;
    public static final int ATTR_EXTLIGHTDAYLIGHT = 16;
    public static final int ATTR_EXTLIGHTTOURIST = 17;
    public static final int ATTR_EXTLIGHTADAPTIVE = 18;
    public static final int ATTR_EXTLIGHTHEADLIGHTSYSTEM = 19;
    public static final int ATTR_EXTLIGHTGLIDINGSYSTEM = 20;
    public static final int ATTR_EXTLIGHTMOTORWAYBLINKING = 21;
    public static final int ATTR_EXTLIGHTMASKEDHIGHBEAM = 22;
    public static final int ATTR_EXTLIGHTLAMPERRORDETECTION = 23;
    public static final int ATTR_EXTLIGHTLAMPERRORDETECTIONTRAILER = 24;
    public static final int ATTR_EXTLIGHTSENSORERRORDETECTION = 25;
    public static final int ATTR_EXTLIGHTLASERLIGHT = 51;
    public static final int ATTR_EXTLIGHTAUTOMATICLIGHT = 28;
    public static final int ATTR_EXTLIGHTSIGNATURELIGHT = 53;
    public static final int ATTR_EXTLIGHTHEADLIGHTRANGE = 54;
    public static final int SETUPILLUMINATIONSET_NOT_EXISTING = 255;
    public static final int SETUPILLUMINATIONSET_ROOF_FRONT = 1;
    public static final int SETUPILLUMINATIONSET_ROOF_REAR = 2;
    public static final int SETUPILLUMINATIONSET_FOOTWELL_FRONT = 3;
    public static final int SETUPILLUMINATIONSET_FOOTWELL_REAR = 4;
    public static final int SETUPILLUMINATIONSET_FOOTWELL_FRONTREAR = 5;
    public static final int SETUPILLUMINATIONSET_COCKPIT = 6;
    public static final int SETUPILLUMINATIONSET_DOORS_FRONTREAR = 7;
    public static final int SETUPILLUMINATIONSET_DOORS_FOOTWELLFRONT = 8;
    public static final int SETUPILLUMINATIONSET_NOT_DOORS_FOOTWELLREAR = 9;
    public static final int SETUPILLUMINATIONSET_ALLSETSSYNC = 10;
    public static final int SETUPILLUMINATIONSET_STANDARDSET = 11;
    public static final int SETUPILLUMINATIONSET_SUNROOF = 12;
    public static final int SETUPILLUMINATIONSET_CONTOUR = 13;
    public static final int SETUPILLUMINATIONSET_ROOFFRONTREAR = 14;
    public static final int SETUPILLUMINATIONSET_CENTERCONSOLE = 15;
    public static final int SETUPILLUMINATIONSET_REAR = 16;
    public static final int SETUPILLUMINATIONSET_SURFACE = 17;
    public static final int SETUPILLUMINATIONSET_LINE = 18;
    public static final int COLOUR_WARMWHITE = 0;
    public static final int COLOUR_COLDWHITE = 1;
    public static final int COLOUR_REDWHITE = 2;
    public static final int COLOUR_ORANGE = 3;
    public static final int COLOUR_BLUE = 4;
    public static final int COLOUR_CYAN = 5;
    public static final int LIGHTSTATE_OFF = 0;
    public static final int LIGHTSTATE_NORMAL = 1;
    public static final int LIGHTSTATE_AUTO = 2;
    public static final int LIGHTSTATE_PRIVACY = 3;
    public static final int SETUPILLUMINATIONPROFILE_NOT_EXISTING = 255;
    public static final int SETUPILLUMINATIONPROFILE_PROFILE1 = 1;
    public static final int SETUPILLUMINATIONPROFILE_PROFILE2 = 2;
    public static final int SETUPILLUMINATIONPROFILE_PROFILE3 = 3;
    public static final int SETUPILLUMINATIONPROFILE_PROFILE4 = 4;
    public static final int SETUPILLUMINATIONPROFILE_PROFILE5 = 5;
    public static final int SETUPILLUMINATIONPROFILE_PROFILE6 = 6;
    public static final int SETUPILLUMINATIONPROFILE_PROFILE7 = 7;
    public static final int SETUPILLUMINATIONPROFILE_PROFILE8 = 8;
    public static final int INTLIGHTARRAYCONTENT_INIT = 0;
    public static final int INTLIGHTARRAYCONTENT_ALL = 1;
    public static final int INTLIGHTARRAYCONTENT_ALL_FORWARD = 2;
    public static final int INTLIGHTARRAYCONTENT_ALL_BACKWARD = 3;
    public static final int INTLIGHTARRAYCONTENT_ONLY_CHANGES = 4;
    public static final int INTLIGHTARRAYCONTENT_ELEMENTS_REMOVED = 5;
    public static final int INTLIGHTARRAYCONTENT_BLOCK_INSERTED = 6;
    public static final int INTLIGHTRECORDCONTENT_RA0 = 0;
    public static final int INTLIGHTRECORDCONTENT_RAF = 15;
    public static final int SWITCHONSENSITIVITY_SENSITIVE = 0;
    public static final int SWITCHONSENSITIVITY_NORMAL = 1;
    public static final int SWITCHONSENSITIVITY_INSENSITIVE = 2;
    public static final int MOTORWAYBLINKINGTIMES_2TIMES = 0;
    public static final int MOTORWAYBLINKINGTIMES_3TIMES = 1;
    public static final int MOTORWAYBLINKINGTIMES_4TIMES = 2;
    public static final int MOTORWAYBLINKINGTIMES_5TIMES = 3;
    public static final int LAMPSTATE_OK = 0;
    public static final int LAMPSTATE_DEFECT = 1;
    public static final int SENSORSTATE_OK = 0;
    public static final int SENSORSTATE_BLOCKED = 1;
    public static final int SENSORSTATE_DEFECT = 2;
    public static final int EXTLIGHTLAMPS_UNKNOWN = 0;
    public static final int EXTLIGHTLAMPS_BLINKER_FRONT_LEFT = 1;
    public static final int EXTLIGHTLAMPS_PARKLIGHT_FRONT_LEFT = 2;
    public static final int EXTLIGHTLAMPS_HEADLIGHT_FRONT_LEFT = 3;
    public static final int EXTLIGHTLAMPS_HIGH_HEADLIGHT_FRONT_LEFT = 4;
    public static final int EXTLIGHTLAMPS_FOGLIGHT_FRONT_LEFT = 5;
    public static final int EXTLIGHTLAMPS_ADDON_HIGH_HEADLIGHT_FRONT_LEFT = 6;
    public static final int EXTLIGHTLAMPS_SIDE_BLINKER_LEFT = 7;
    public static final int EXTLIGHTLAMPS_TURN_OFF_LIGHT_LEFT = 8;
    public static final int EXTLIGHTLAMPS_BLINKER_FRONT_RIGHT = 9;
    public static final int EXTLIGHTLAMPS_PARKLIGHT_FRONT_RIGHT = 10;
    public static final int EXTLIGHTLAMPS_HEADLIGHT_FRONT_RIGHT = 11;
    public static final int EXTLIGHTLAMPS_HIGH_HEADLIGHT_FRONT_RIGHT = 12;
    public static final int EXTLIGHTLAMPS_FOGLIGHT_FRONT_RIGHT = 13;
    public static final int EXTLIGHTLAMPS_ADDON_HIGH_HEADLIGHT_FRONT_RIGHT = 14;
    public static final int EXTLIGHTLAMPS_SIDE_BLINKER_RIGHT = 15;
    public static final int EXTLIGHTLAMPS_TURN_OFF_LIGHT_RIGHT = 16;
    public static final int EXTLIGHTLAMPS_BLINKER_REAR_LEFT = 17;
    public static final int EXTLIGHTLAMPS_PARKLIGHT_REAR_LEFT = 18;
    public static final int EXTLIGHTLAMPS_BRAKELIGHT_REAR_LEFT = 19;
    public static final int EXTLIGHTLAMPS_BACKUP_LIGHT_REAR_LEFT = 20;
    public static final int EXTLIGHTLAMPS_FOGLIGHT_REAR_LEFT = 21;
    public static final int EXTLIGHTLAMPS_3RD_BRAKELIGHT = 22;
    public static final int EXTLIGHTLAMPS_NUMBERBLADELIGHT = 23;
    public static final int EXTLIGHTLAMPS_BLINKER_REAR_RIGHT = 24;
    public static final int EXTLIGHTLAMPS_PARKLIGHT_REAR_RIGHT = 25;
    public static final int EXTLIGHTLAMPS_BRAKELIGHT_REAR_RIGHT = 26;
    public static final int EXTLIGHTLAMPS_BACKUP_LIGHT_REAR_RIGHT = 27;
    public static final int EXTLIGHTLAMPS_FOGLIGHT_REAR_RIGHT = 28;
    public static final int EXTLIGHTLAMPS_REVERSELIGHT_REAR = 29;
    public static final int EXTLIGHTLAMPS_DAYTIME_RUNNINGLIGHT_FRONT_LEFT = 30;
    public static final int EXTLIGHTLAMPS_DAYTIME_RUNNINGLIGHT_FRONT_RIGHT = 31;
    public static final int EXTLIGHTLAMPS_BLINKER_MIRROR_LEFT = 32;
    public static final int EXTLIGHTLAMPS_BLINKER_MIRROR_RIGHT = 33;
    public static final int EXTLIGHTLAMPS_SIDEMARKER_FRONT_LEFT = 34;
    public static final int EXTLIGHTLAMPS_SIDEMARKER_FRONT_RIGHT = 35;
    public static final int EXTLIGHTLAMPS_DAYTIME_RUNNING_LIGHT = 36;
    public static final int EXTLIGHTLAMPS_FLA_INTERIOR_MIRROR_DEFECTIVE = 37;
    public static final int EXTLIGHTLAMPS_FLA_SENSOR_BLOCKED = 38;
    public static final int EXTLIGHTLAMPSTRAILER_UNKNOWN = 0;
    public static final int EXTLIGHTLAMPSTRAILER_BLINKER_LEFT = 1;
    public static final int EXTLIGHTLAMPSTRAILER_REARLIGHT_LEFT = 2;
    public static final int EXTLIGHTLAMPSTRAILER_BRAKELIGHT = 3;
    public static final int EXTLIGHTLAMPSTRAILER_FOGLIGHT = 4;
    public static final int EXTLIGHTLAMPSTRAILER_BLINKER_RIGHT = 5;
    public static final int EXTLIGHTLAMPSTRAILER_REARLIGHT_RIGHT = 6;
    public static final int EXTLIGHTLAMPSTRAILER_BACKUP_LIGHT = 7;
    public static final int SENSORS_UNKNOWN = 0;
    public static final int SENSORS_FLA = 1;
    public static final int RT_SETEXTLIGHTCOMINGHOME = 1000;
    public static final int RT_SETEXTLIGHTLEAVINGHOME = 1001;
    public static final int RT_SETEXTLIGHTSWITCHONSENSITIVITY = 1002;
    public static final int RT_SETEXTLIGHTDAYLIGHT = 1003;
    public static final int RT_SETEXTLIGHTHEADLIGHTSYSTEM = 1004;
    public static final int RT_SETEXTLIGHTGLIDINGLIGHTSYSTEM = 1005;
    public static final int RT_SETEXTLIGHTADAPTIVE = 1006;
    public static final int RT_SETEXTLIGHTTOURIST = 1007;
    public static final int RT_SETEXTLIGHTMOTORWAYBLINKING = 1008;
    public static final int RT_SETEXTLIGHTMASKEDHIGHBEAM = 1009;
    public static final int RT_SETEXTLIGHTAUTOMATICLIGHT = 1021;
    public static final int RT_SETEXTLIGHTLASERLIGHT = 1031;
    public static final int RT_SETEXTLIGHTSIGNATURELIGHT = 1033;
    public static final int RT_SETEXTLIGHTHEADLIGHTRANGE = 1034;
    public static final int RT_SETEXTLIGHTSETFACTORYDEFAULT = 1022;
    public static final int RT_SETINTLIGHTCOLOUR = 1015;
    public static final int RT_SETINTLIGHTSTATE = 1016;
    public static final int RT_SETINTLIGHTENVIRONMENT = 1017;
    public static final int RT_SETINTLIGHTSPEED = 1018;
    public static final int RT_SETINTLIGHTTEMPERATURE = 1019;
    public static final int RT_SETINTLIGHTBRIGHTNESS = 1020;
    public static final int RT_SETINTLIGHTSETFACTORYDEFAULT = 1023;
    public static final int RT_SETINTLIGHTILLUMINATIONSET = 1024;
    public static final int RT_SETINTLIGHTILLUMINATIONPROFILE = 1025;
    public static final int RT_SETINTLIGHTACTIVEPROFILE = 1026;
    public static final int RT_SETINTLIGHTAMBIENTLIGHTCOLOR = 1027;
    public static final int RT_SETINTLIGHTCONTOURLIGHTCOLOR = 1028;
    public static final int RT_SETINTLIGHTFOLLOWUPTIME = 1029;
    public static final int RT_REQUESTINTLIGHTRGBCOLORLIST = 1030;
    public static final int RT_SETINTLIGHTDOORCONTACT = 1032;
    public static final int RP_ACKNOWLEDGEINTLIGHTSETFACTORYDEFAULT = 2000;
    public static final int RP_RESPONSEINTLIGHTRGBCOLORLISTRA0 = 2002;
    public static final int RP_RESPONSEINTLIGHTRGBCOLORLISTRAF = 2003;
    public static final int RP_ACKNOWLEDGEEXTLIGHTSETFACTORYDEFAULT = 2001;

    public void setExtLightComingHome(TimeState var1);

    public void setExtLightLeavingHome(TimeState var1);

    public void setExtLightSwitchOnSensitivity(int var1);

    public void setExtLightDayLight(boolean var1);

    public void setExtLightHeadLightSystem(boolean var1);

    public void setExtLightGlidingLightSystem(boolean var1);

    public void setExtLightAdaptive(boolean var1);

    public void setExtLightTourist(boolean var1);

    public void setExtLightMotorwayBlinking(MotorwayBlinkingSettings var1);

    public void setExtLightMaskedHighBeam(boolean var1);

    public void setExtLightAutomaticLight(boolean var1, boolean var2);

    public void setExtLightSetFactoryDefault();

    public void setExtLightLaserLight(boolean var1);

    public void setExtLightSignatureLight(boolean var1);

    public void setExtLightHeadlightRange(int var1);

    public void setIntLightIlluminationSet(int var1, int var2);

    public void setIntLightColour(int var1);

    public void setIntLightState(int var1);

    public void setIntLightEnvironment(boolean var1);

    public void setIntLightSpeed(boolean var1);

    public void setIntLightTemperature(boolean var1);

    public void setIntLightBrightness(IntLightBrightness var1);

    public void setIntLightSetFactoryDefault();

    public void setIntLightIlluminationProfile(int var1, int var2);

    public void setIntLightActiveProfile(int var1);

    public void setIntLightAmbientLightColor(IntLightRGBValues var1);

    public void setIntLightContourLightColor(IntLightRGBValues var1);

    public void setIntLightFollowUpTime(int var1);

    public void setIntLightDoorContact(boolean var1);

    public void requestIntLightRGBColorList(IntLightRGBColorListUpdateInfo var1);
}

