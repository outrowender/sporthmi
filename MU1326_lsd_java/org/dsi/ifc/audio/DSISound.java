/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.audio;

import org.dsi.ifc.base.DSIBase;

public interface DSISound
extends DSIBase {
    public static final String VERSION = "2.11.45";
    public static final int RT_GETVOLUME = 1000;
    public static final int RT_SETVOLUME = 1001;
    public static final int RT_DECREASEVOLUME = 1002;
    public static final int RT_INCREASEVOLUME = 1003;
    public static final int RT_GETBALANCE = 1004;
    public static final int RT_SETBALANCE = 1005;
    public static final int RT_DECREASEBALANCE = 1006;
    public static final int RT_INCREASEBALANCE = 1007;
    public static final int RT_GETBASS = 1008;
    public static final int RT_SETBASS = 1009;
    public static final int RT_DECREASEBASS = 1010;
    public static final int RT_INCREASEBASS = 1011;
    public static final int RT_GETTREBLE = 1012;
    public static final int RT_SETTREBLE = 1013;
    public static final int RT_DECREASETREBLE = 1014;
    public static final int RT_INCREASETREBLE = 1015;
    public static final int RT_GETFADER = 1016;
    public static final int RT_SETFADER = 1017;
    public static final int RT_DECREASEFADER = 1018;
    public static final int RT_INCREASEFADER = 1019;
    public static final int RT_GETSUBWOOFER = 1020;
    public static final int RT_SETSUBWOOFER = 1021;
    public static final int RT_GETINPUTGAINOFFSET = 1022;
    public static final int RT_SETINPUTGAINOFFSET = 1023;
    public static final int RT_GETINPUTGAINOFFSETRANGE = 1024;
    public static final int RT_GETLOWERINGENTERTAINMENT = 1025;
    public static final int RT_SETLOWERINGENTERTAINMENT = 1026;
    public static final int RT_GETMENUVOLENTRANGE = 1027;
    public static final int RT_GETMENUVOLUMERANGE = 1028;
    public static final int RT_GETSURROUNDLEVEL = 1031;
    public static final int RT_SETSURROUNDLEVEL = 1032;
    public static final int RT_SETSURROUNDONOFF = 1037;
    public static final int RT_REVERTTOFACTORYSETTINGS = 1038;
    public static final int RT_CREATEEXPORTFILE = 1039;
    public static final int RT_IMPORTFILE = 1040;
    public static final int RT_GETMIDDLE = 1041;
    public static final int RT_SETMIDDLE = 1042;
    public static final int RT_DECREASEMIDDLE = 1043;
    public static final int RT_INCREASEMIDDLE = 1044;
    public static final int RT_SETMICGAINLEVEL = 1045;
    public static final int RT_DECREASEMICGAINLEVEL = 1046;
    public static final int RT_INCREASEMICGAINLEVEL = 1047;
    public static final int RT_SETEQUALIZER = 1048;
    public static final int RT_INCREASEEQUALIZER = 1049;
    public static final int RT_DECREASEEQUALIZER = 1050;
    public static final int RT_GETEQUALIZER = 1051;
    public static final int RT_SETONVOLUMELIMIT = 1052;
    public static final int RT_INCREASEONVOLUMELIMIT = 1053;
    public static final int RT_DECREASEONVOLUMELIMIT = 1054;
    public static final int RT_DECREASEINPUTGAINOFFSET = 1056;
    public static final int RT_INCREASEINPUTGAINOFFSET = 1057;
    public static final int RT_DECREASESUBWOOFER = 1058;
    public static final int RT_INCREASESUBWOOFER = 1059;
    public static final int RT_DECREASESURROUNDLEVEL = 1060;
    public static final int RT_INCREASESURROUNDLEVEL = 1061;
    public static final int RT_DECREASELOWERINGENTERTAINMENT = 1064;
    public static final int RT_INCREASELOWERINGENTERTAINMENT = 1065;
    public static final int RT_GETNOISECOMPENSATION = 1066;
    public static final int RT_SETNOISECOMPENSATION = 1067;
    public static final int RT_INCREASENOISECOMPENSATION = 1068;
    public static final int RT_DECREASENOISECOMPENSATION = 1069;
    public static final int RT_GETPRESETPOSITION = 1074;
    public static final int RT_SETPRESETPOSITION = 1075;
    public static final int RT_GETPRESETEQ = 1076;
    public static final int RT_SETPRESETEQ = 1077;
    public static final int RT_SETSUBWOOFERACTIVITY = 1078;
    public static final int RT_GET3DMODE = 1079;
    public static final int RT_SET3DMODE = 1080;
    public static final int RT_SETWIDEBANDSPEECH = 1081;
    public static final int RT_SETDURATION = 1082;
    public static final int RT_GETVOLUMERANGE = 1083;
    public static final int RT_GETSOUNDSHAPEACTIVE = 1084;
    public static final int RT_SETSOUNDSHAPEACTIVE = 1085;
    public static final int RT_GETSOUNDSHAPE = 1086;
    public static final int RT_SETSOUNDSHAPE = 1087;
    public static final int RT_PROFILECHANGE = 1088;
    public static final int RT_PROFILECOPY = 1089;
    public static final int RT_PROFILERESET = 1090;
    public static final int RT_PROFILERESETALL = 1091;
    public static final int ATTR_BALANCE = 2;
    public static final int ATTR_BALANCERANGE = 3;
    public static final int ATTR_BASS = 4;
    public static final int ATTR_BASSRANGE = 5;
    public static final int ATTR_FADER = 9;
    public static final int ATTR_FADERRANGE = 10;
    public static final int ATTR_INPUTGAINOFFSET = 12;
    public static final int ATTR_LOWERINGENTERTAINMENT = 13;
    public static final int ATTR_MUTEPINSTATE = 14;
    public static final int ATTR_SUBWOOFER = 17;
    public static final int ATTR_SUBWOOFERRANGE = 18;
    public static final int ATTR_SURRLEVELRANGE = 19;
    public static final int ATTR_SURROUNDLEVEL = 20;
    public static final int ATTR_TREBLE = 21;
    public static final int ATTR_TREBLERANGE = 22;
    public static final int ATTR_VOLUME = 24;
    public static final int ATTR_VOLUMERANGE = 26;
    public static final int ATTR_MIDDLE = 27;
    public static final int ATTR_MIDDLERANGE = 28;
    public static final int ATTR_EQUALIZERRANGE = 31;
    public static final int ATTR_EQUALIZER = 32;
    public static final int ATTR_ONVOLUMELIMIT = 33;
    public static final int ATTR_ONVOLUMELIMITRANGE = 34;
    public static final int ATTR_ACTIVEAMPLIFIERCAPABILITIES = 35;
    public static final int ATTR_MUTETHEFTPROTECTION = 36;
    public static final int ATTR_MICGAINLEVEL = 37;
    public static final int ATTR_VOLUMEFOCUS = 38;
    public static final int ATTR_NOISECOMPENSATION = 39;
    public static final int ATTR_PRESETPOSITION = 42;
    public static final int ATTR_PRESETEQ = 43;
    public static final int ATTR_PRESETPOSITIONLIST = 44;
    public static final int ATTR_PRESETEQLIST = 45;
    public static final int ATTR_NOISECOMPENSATIONRANGE = 47;
    public static final int ATTR_SUBWOOFERACTIVITY = 48;
    public static final int ATTR_SURROUNDONOFF = 49;
    public static final int ATTR_THREEDMODE = 50;
    public static final int ATTR_THREEDMODERANGE = 51;
    public static final int ATTR_SOUNDSHAPEACTIVE = 52;
    public static final int ATTR_SOUNDSHAPE = 53;
    public static final int ATTR_SOUNDSHAPERANGE = 54;
    public static final int ATTR_ICCAVAILABLE = 55;
    public static final int ATTR_PROFILESTATE = 56;
    public static final int RP_INPUTGAINOFFSETRANGE = 2000;
    public static final int RP_MENUVOLENTRANGE = 2001;
    public static final int RP_MENUVOLUMERANGE = 2002;
    public static final int RP_CREATEEXPORTFILERESULT = 2004;
    public static final int RP_IMPORTFILERESPONSE = 2005;
    public static final int RP_RESPONSEWIDEBANDSPEECH = 2006;
    public static final int RP_VOLUMERANGE = 2007;
    public static final int RP_PROFILECHANGED = 2008;
    public static final int RP_PROFILECOPIED = 2009;
    public static final int RP_PROFILERESET = 2010;
    public static final int RP_PROFILERESETALL = 2011;

    public void getVolume(int var1, int var2);

    public void setVolume(int var1, int var2, short var3);

    public void decreaseVolume(int var1, int var2, short var3);

    public void increaseVolume(int var1, int var2, short var3);

    public void getBalance(int var1, int var2);

    public void setBalance(int var1, int var2, short var3);

    public void decreaseBalance(int var1, int var2, short var3);

    public void increaseBalance(int var1, int var2, short var3);

    public void getBass(int var1, int var2);

    public void setBass(int var1, int var2, short var3);

    public void decreaseBass(int var1, int var2, short var3);

    public void increaseBass(int var1, int var2, short var3);

    public void getTreble(int var1, int var2);

    public void setTreble(int var1, int var2, short var3);

    public void decreaseTreble(int var1, int var2, short var3);

    public void increaseTreble(int var1, int var2, short var3);

    public void getFader(int var1, int var2);

    public void setFader(int var1, int var2, short var3);

    public void decreaseFader(int var1, int var2, short var3);

    public void increaseFader(int var1, int var2, short var3);

    public void getSubwoofer(int var1, int var2);

    public void setSubwoofer(int var1, int var2, short var3);

    public void getInputGainOffset(int var1, int var2);

    public void setInputGainOffset(int var1, int var2, short var3);

    public void getInputGainOffsetRange(int var1, int var2);

    public void getLoweringEntertainment(int var1, int var2, int var3);

    public void setLoweringEntertainment(int var1, int var2, int var3, short var4);

    public void getMenuVolEntRange(int var1);

    public void getMenuVolumeRange(int var1, int var2);

    public void getVolumeRange(int var1, int var2);

    public void getSurroundLevel(int var1, int var2);

    public void setSurroundLevel(int var1, int var2, short var3);

    public void setSurroundOnOff(int var1, int var2, boolean var3);

    public void revertToFactorySettings(int var1, int var2);

    public void createExportFile(String var1, int var2);

    public void importFile(String var1, int var2);

    public void getMiddle(int var1, int var2);

    public void setMiddle(int var1, int var2, short var3);

    public void decreaseMiddle(int var1, int var2, short var3);

    public void increaseMiddle(int var1, int var2, short var3);

    public void setEqualizer(int var1, int var2, int var3, int var4);

    public void increaseEqualizer(int var1, int var2, int var3, short var4);

    public void decreaseEqualizer(int var1, int var2, int var3, short var4);

    public void getEqualizer(int var1, int var2);

    public void setOnVolumeLimit(int var1);

    public void increaseOnVolumeLimit(short var1);

    public void decreaseOnVolumeLimit(short var1);

    public void decreaseSubwoofer(int var1, int var2, short var3);

    public void increaseSubwoofer(int var1, int var2, short var3);

    public void decreaseInputGainOffset(int var1, int var2, short var3);

    public void increaseInputGainOffset(int var1, int var2, short var3);

    public void decreaseLoweringEntertainment(int var1, int var2, int var3, short var4);

    public void increaseLoweringEntertainment(int var1, int var2, int var3, short var4);

    public void decreaseSurroundLevel(int var1, int var2, short var3);

    public void increaseSurroundLevel(int var1, int var2, short var3);

    public void setMicGainLevel(int var1);

    public void decreaseMicGainLevel(short var1);

    public void increaseMicGainLevel(short var1);

    public void getNoiseCompensation(int var1, int var2);

    public void setNoiseCompensation(int var1, int var2, short var3);

    public void increaseNoiseCompensation(int var1, int var2, short var3);

    public void decreaseNoiseCompensation(int var1, int var2, short var3);

    public void getPresetEQ(int var1, int var2);

    public void setPresetEQ(int var1, int var2, int var3);

    public void getPresetPosition(int var1, int var2);

    public void setPresetPosition(int var1, int var2, int var3);

    public void get3DMode(int var1, int var2);

    public void set3DMode(int var1, int var2, int var3);

    public void setSubwooferActivity(int var1, int var2, boolean var3);

    public void setWidebandSpeech(int var1, boolean var2);

    public void setDuration(int var1, int var2);

    public void getSoundShapeActive();

    public void setSoundShapeActive(boolean var1);

    public void getSoundShape();

    public void setSoundShape(short var1, short var2, short var3);

    public void profileChange(int var1);

    public void profileCopy(int var1, int var2);

    public void profileReset(int var1);

    public void profileResetAll();
}

