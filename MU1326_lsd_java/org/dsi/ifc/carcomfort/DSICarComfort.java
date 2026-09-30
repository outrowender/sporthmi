/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.carcomfort;

import org.dsi.ifc.base.DSIBase;
import org.dsi.ifc.carcomfort.DoorLockingComfortOpenSettings;
import org.dsi.ifc.carcomfort.DoorLockingRearBlind;
import org.dsi.ifc.carcomfort.DoorLockingTheftWarningSettings;
import org.dsi.ifc.carcomfort.DoorLockingUserListRA1;
import org.dsi.ifc.carcomfort.DoorLockingUserListUpdateInfo;
import org.dsi.ifc.carcomfort.DoorLockingUserProfileOnOff;
import org.dsi.ifc.carcomfort.RGSBeltPretensionData;
import org.dsi.ifc.carcomfort.RGSLocalHazardInformation;
import org.dsi.ifc.carcomfort.UGDOButtonListRA0;
import org.dsi.ifc.carcomfort.UGDOButtonListRA1;
import org.dsi.ifc.carcomfort.UGDOButtonListRA2;
import org.dsi.ifc.carcomfort.UGDOButtonListRA3;
import org.dsi.ifc.carcomfort.UGDOButtonListRA4;
import org.dsi.ifc.carcomfort.UGDOButtonListRA5;
import org.dsi.ifc.carcomfort.UGDOButtonListUpdateInfo;
import org.dsi.ifc.carcomfort.UGDOContent;
import org.dsi.ifc.carcomfort.UGDODestinationReached;
import org.dsi.ifc.carcomfort.UGDOLearningData;
import org.dsi.ifc.carcomfort.UGDOOpenDoor;
import org.dsi.ifc.carcomfort.UGDOSoftkeys;
import org.dsi.ifc.carcomfort.UGDOSynchronisation;

public interface DSICarComfort
extends DSIBase {
    public static final String VERSION = "2.11.32";
    public static final int ATTR_RGSVIEWOPTIONS = 1;
    public static final int ATTR_RGSBELTPRETENSIONDATAFRONT = 2;
    public static final int ATTR_RGSBELTPRETENSIONDATAREAR = 3;
    public static final int ATTR_RGSPRECRASHSYSTEM = 4;
    public static final int ATTR_RGSPRESENSESYSTEM = 53;
    public static final int ATTR_RGSPRESENSEWARNING = 54;
    public static final int ATTR_RGSLOCALHAZARDDETECTION = 55;
    public static final int ATTR_DOORLOCKINGVIEWOPTIONS = 5;
    public static final int ATTR_DOORLOCKINGMESSAGE = 6;
    public static final int ATTR_DOORLOCKINGLOCKSTATUS = 7;
    public static final int ATTR_DOORLOCKINGWINDOWSTATUS = 8;
    public static final int ATTR_DOORLOCKINGCOMFORTOPENSETTINGS = 9;
    public static final int ATTR_DOORLOCKINGCLBOOTOPEN = 10;
    public static final int ATTR_DOORLOCKINGBOOTOPEN = 11;
    public static final int ATTR_DOORLOCKINGTHEFTWARNINGSETTINGS = 12;
    public static final int ATTR_DOORLOCKINGUNLOCKINGMODE = 13;
    public static final int ATTR_DOORLOCKINGAUTOLOCK = 14;
    public static final int ATTR_DOORLOCKINGAUTOUNLOCK = 15;
    public static final int ATTR_DOORLOCKINGCLBOOTLOCK = 16;
    public static final int ATTR_DOORLOCKINGMIRRORPROTECTION = 17;
    public static final int ATTR_DOORLOCKINGCONFIRMATION = 18;
    public static final int ATTR_DOORLOCKINGRAINCLOSING = 19;
    public static final int ATTR_DOORLOCKINGREARBLIND = 20;
    public static final int ATTR_DOORLOCKINGBOOTCLOSE = 56;
    public static final int ATTR_DOORLOCKINGUSERLISTUPDATEINFO = 57;
    public static final int ATTR_DOORLOCKINGUSERLISTTOTALNUMBEROFELEMENTS = 58;
    public static final int ATTR_DOORLOCKINGACTIVEUSER = 59;
    public static final int ATTR_DOORLOCKINGUSERPROFILEONOFF = 60;
    public static final int ATTR_DOORLOCKINGWINDOWAUTOCLOSE = 65;
    public static final int ATTR_DOORLOCKINGBLINDSCONTROL = 66;
    public static final int ATTR_DOORLOCKINGBLINDSCONTROLEXTENDED = 79;
    public static final int ATTR_DOORLOCKINGLEFTSIDEBLINDCONTROL = 80;
    public static final int ATTR_DOORLOCKINGRIGHTSIDEBLINDCONTROL = 81;
    public static final int ATTR_DOORLOCKINGUSERPROFILECONTROLPROCESSING = 82;
    public static final int ATTR_DOORLOCKINGPROMPTCONTENT = 83;
    public static final int ATTR_DOORLOCKINGTURNINDREPEAT = 84;
    public static final int ATTR_DOORLOCKINGKEYLESS = 85;
    public static final int ATTR_WIPERVIEWOPTIONS = 21;
    public static final int ATTR_WIPERSERVICEPOSITION = 22;
    public static final int ATTR_WIPERRAINSENSORONOFF = 23;
    public static final int ATTR_WIPERRAINSENSORCONFIG = 24;
    public static final int ATTR_WIPERREARWIPING = 25;
    public static final int ATTR_WIPERTEARSWIPING = 26;
    public static final int ATTR_WIPERWINTERPOSITION = 27;
    public static final int ATTR_EASYENTRYSTEERINGCOLUMN = 28;
    public static final int ATTR_UGDOVIEWOPTIONS = 29;
    public static final int ATTR_UGDOLEARNINGDATA = 30;
    public static final int ATTR_UGDOCONTENT = 31;
    public static final int ATTR_UGDOVERSIONDATA = 32;
    public static final int ATTR_UGDOBUTTONLISTUPDATEINFO = 49;
    public static final int ATTR_UGDOBUTTONLISTTOTALNUMBEROFELEMENTS = 50;
    public static final int ATTR_UGDODESTINATIONREACHED = 51;
    public static final int ATTR_UGDOOPENDOOR = 52;
    public static final int ATTR_RDKVIEWOPTIONS = 33;
    public static final int ATTR_RDKSYSTEMONOFF = 34;
    public static final int ATTR_RDKTIRESETUPTIRELIST = 35;
    public static final int ATTR_RDKTIRESETUPSELECTEDTIRE = 36;
    public static final int ATTR_RDKTIREDISPLAY = 37;
    public static final int ATTR_RDKSPEEDLIMIT = 38;
    public static final int ATTR_RDKDIFFERENTIALPRESSURE = 63;
    public static final int ATTR_RDKRESIDUALBATTERYLIFETIME = 64;
    public static final int ATTR_RDKPRESSURELEVEL = 62;
    public static final int ATTR_MIRRORVIEWOPTIONS = 39;
    public static final int ATTR_MIRRORLOWERING = 40;
    public static final int ATTR_MIRRORSYNCADJUST = 41;
    public static final int ATTR_MIRRORFOLDING = 42;
    public static final int ATTR_MIRRORDIMMING = 43;
    public static final int ATTR_MIRRORHEATING = 44;
    public static final int ATTR_BRAKEVIEWOPTIONS = 45;
    public static final int ATTR_BRAKEELECTRICALPARKING = 46;
    public static final int ATTR_BRAKEAUTOHOLD = 47;
    public static final int ATTR_BRAKEESCMODE = 48;
    public static final int ATTR_BRAKEHDCMODE = 61;
    public static final int ATTR_MASCOTVIEWOPTIONS = 86;
    public static final int ATTR_MASCOTCONTROL = 87;
    public static final int ATTR_MASCOTMODE = 88;
    public static final int RT_SETRGSBELTPRETENSIONERDATAFRONT = 1000;
    public static final int RT_SETRGSBELTPRETENSIONERDATAREAR = 1001;
    public static final int RT_SETRGSPRECRASHSYSTEM = 1002;
    public static final int RT_SETDOORLOCKINGCOMFORTOPENSETTINGS = 1003;
    public static final int RT_SETDOORLOCKINGTHEFTWARNINGSETTINGS = 1004;
    public static final int RT_SETDOORLOCKINGCLBOOTOPEN = 1005;
    public static final int RT_SETDOORLOCKINGBOOTOPEN = 1006;
    public static final int RT_SETDOORLOCKINGUNLOCKINGMODE = 1007;
    public static final int RT_SETDOORLOCKINGAUTOLOCK = 1008;
    public static final int RT_SETDOORLOCKINGAUTOUNLOCK = 1009;
    public static final int RT_SETDOORLOCKINGCLBOOTLOCK = 1010;
    public static final int RT_SETDOORLOCKINGMIRRORPROTECTION = 1011;
    public static final int RT_SETDOORLOCKINGCONFIRMATION = 1012;
    public static final int RT_SETDOORLOCKINGRAINCLOSING = 1013;
    public static final int RT_SETDOORLOCKINGREARBLIND = 1014;
    public static final int RT_SETWIPERSERVICEPOSITION = 1015;
    public static final int RT_SETWIPERRAINSENSORONOFF = 1016;
    public static final int RT_SETWIPERRAINSENSORCONFIG = 1017;
    public static final int RT_SETWIPERREARWIPING = 1018;
    public static final int RT_SETWIPERTEARSWIPING = 1019;
    public static final int RT_SETWIPERWINTERPOSITION = 1020;
    public static final int RT_SETEASYENTRYSTEERINGCOLUMN = 1021;
    public static final int RT_SETUGDOLEARNINGDATA = 1022;
    public static final int RT_SHOWUGDOPOPUP = 1023;
    public static final int RT_CANCELUGDOPOPUP = 1024;
    public static final int RT_DELETEUGDOBUTTON = 1025;
    public static final int RT_SETRDKSYSTEMONOFF = 1026;
    public static final int RT_SETRDKTIRESETUPSELECTEDTIRE = 1027;
    public static final int RT_SETRDKSPEEDLIMIT = 1028;
    public static final int RT_SETRDKTIRECHANGED = 1029;
    public static final int RT_SETRDKPRESSURECHANGED = 1030;
    public static final int RT_SETRDKPRESSURELEVEL = 1078;
    public static final int RT_SETRDKSETFACTORYDEFAULT = 1081;
    public static final int RT_SETMIRRORLOWERING = 1031;
    public static final int RT_SETMIRRORSYNCADJUST = 1032;
    public static final int RT_SETMIRRORFOLDING = 1033;
    public static final int RT_SETMIRRORDIMMING = 1034;
    public static final int RT_SETMIRRORHEATING = 1035;
    public static final int RT_SETBRAKEELECTRICALPARKING = 1036;
    public static final int RT_SETBRAKEAUTOHOLD = 1037;
    public static final int RT_SETBRAKEESCMODE = 1038;
    public static final int RT_SETBRAKEHDCMODE = 1075;
    public static final int RT_SETWIPERSETFACTORYDEFAULT = 1039;
    public static final int RT_SETMIRRORSETFACTORYDEFAULT = 1040;
    public static final int RT_SETDOORLOCKINGSETFACTORYDEFAULT = 1041;
    public static final int RT_SETUGDOSETFACTORYDEFAULT = 1042;
    public static final int RT_SETRGSSETFACTORYDEFAULT = 1043;
    public static final int RT_REQUESTRDKLIFEMONITORING = 1044;
    public static final int RT_SETUGDOOPENDOOR = 1045;
    public static final int RT_SETUGDOSYNCHRONISATION = 1046;
    public static final int RT_RESPONSEUGDOSYNCHRONISATION = 1047;
    public static final int RT_STARTUGDOLEARNING = 1048;
    public static final int RT_ABORTUGDOLEARNING = 1049;
    public static final int RT_REQUESTUGDOBUTTONLIST = 1050;
    public static final int RT_SETUGDOBUTTONLISTRA0 = 1051;
    public static final int RT_SETUGDOBUTTONLISTRA1 = 1052;
    public static final int RT_SETUGDOBUTTONLISTRA2 = 1053;
    public static final int RT_SETUGDOBUTTONLISTRA3 = 1054;
    public static final int RT_SETUGDOBUTTONLISTRA4 = 1055;
    public static final int RT_SETUGDOBUTTONLISTRA5 = 1080;
    public static final int RT_SETUGDOBUTTONLISTRAF = 1056;
    public static final int RT_SETRGSPRESENSESYSTEM = 1057;
    public static final int RT_SETRGSPRESENSEWARNING = 1058;
    public static final int RT_SETUGDODESTINATIONREACHED = 1059;
    public static final int RT_SETHMIISREADY = 1060;
    public static final int RT_SETRGSLOCALHAZARDINFORMATION = 1061;
    public static final int RT_STARTDOORLOCKINGREMOTELOCKUNLOCK = 1062;
    public static final int RT_SENDDOORLOCKINGREMOTELOCKUNLOCKSIGNATURE = 1063;
    public static final int RT_STARTDOORLOCKINGREMOTEBLINKING = 1064;
    public static final int RT_STARTDOORLOCKINGREMOTEHORN = 1065;
    public static final int RT_ABORTDOORLOCKINGREMOTELOCKUNLOCK = 1067;
    public static final int RT_SETDOORLOCKINGBOOTCLOSE = 1068;
    public static final int RT_REQUESTDOORLOCKINGUSERLIST = 1069;
    public static final int RT_SETDOORLOCKINGUSERLISTRA1 = 1070;
    public static final int RT_SETDOORLOCKINGUSERLISTRAF = 1071;
    public static final int RT_STARTDOORLOCKINGUSERPROFILECONTROL = 1072;
    public static final int RT_SETDOORLOCKINGACTIVEUSER = 1073;
    public static final int RT_SETDOORLOCKINGUSERPROFILEONOFF = 1074;
    public static final int RT_ABORTDOORLOCKINGUSERPROFILECONTROL = 1076;
    public static final int RT_SETDOORLOCKINGWINDOWAUTOCLOSE = 1077;
    public static final int RT_SETDOORLOCKINGBLINDSCONTROL = 1079;
    public static final int RT_SETDOORLOCKINGBLINDSCONTROLEXTENDED = 1100;
    public static final int RT_SETDOORLOCKINGLEFTSIDEBLINDCONTROL = 1101;
    public static final int RT_SETDOORLOCKINGRIGHTSIDEBLINDCONTROL = 1102;
    public static final int RT_SHOWDOORLOCKINGPROMPT = 1103;
    public static final int RT_CANCELDOORLOCKINGPROMPT = 1104;
    public static final int RT_SETDOORLOCKINGTURNINDREPEAT = 1105;
    public static final int RT_SETDOORLOCKINGKEYLESS = 1106;
    public static final int RT_SETMASCOTCONTROL = 1107;
    public static final int RT_SETMASCOTMODE = 1108;
    public static final int RT_SETMASCOTSETFACTORYDEFAULT = 1109;
    public static final int RP_ACKNOWLEDGEUGDODELETEBUTTON = 2001;
    public static final int RP_RESPONSERDKTIRECHANGED = 2002;
    public static final int RP_RESPONSERDKPRESSURECHANGED = 2003;
    public static final int RP_ACKNOWLEDGEWIPERSETFACTORYDEFAULT = 2004;
    public static final int RP_ACKNOWLEDGEMIRRORSETFACTORYDEFAULT = 2005;
    public static final int RP_ACKNOWLEDGEDOORLOCKINGSETFACTORYDEFAULT = 2006;
    public static final int RP_ACKNOWLEDGEUGDOSETFACTORYDEFAULT = 2007;
    public static final int RP_ACKNOWLEDGERGSSETFACTORYDEFAULT = 2008;
    public static final int RP_RESPONSERDKLIFEMONITORING = 2009;
    public static final int RP_ACKNOWLEDGEDOORLOCKINGREMOTELOCKUNLOCK = 2019;
    public static final int RP_ACKNOWLEDGEDOORLOCKINGREMOTEBLINKING = 2020;
    public static final int RP_ACKNOWLEDGEDOORLOCKINGREMOTEHORN = 2021;
    public static final int RP_RECEIVEDDOORLOCKINGREMOTELOCKUNLOCKSIGNATUREVERIFICATION = 2022;
    public static final int RP_RECEIVEDDOORLOCKINGREMOTELOCKUNLOCKAUTHENTIFICATION = 2023;
    public static final int RP_ACKNOWLEDGEDOORLOCKINGUSERPROFILECONTROL = 2026;
    public static final int RP_ACKNOWLEDGERDKSETFACTORYDEFAULT = 2027;
    public static final int RP_ACKNOWLEDGEMASCOTSETFACTORYDEFAULT = 2028;
    public static final int IN_REQUESTUGDOPOPUP = 3000;
    public static final int IN_RESPONSEUGDOBUTTONLISTRA0 = 3001;
    public static final int IN_RESPONSEUGDOBUTTONLISTRA1 = 3002;
    public static final int IN_RESPONSEUGDOBUTTONLISTRA2 = 3003;
    public static final int IN_RESPONSEUGDOBUTTONLISTRA3 = 3004;
    public static final int IN_RESPONSEUGDOBUTTONLISTRA4 = 3005;
    public static final int IN_RESPONSEUGDOBUTTONLISTRA5 = 3013;
    public static final int IN_RESPONSEUGDOBUTTONLISTRAF = 3006;
    public static final int IN_REQUESTUGDOSYNCHRONISATION = 3007;
    public static final int IN_ACKNOWLEDGEUGDOSYNCHRONISATION = 3008;
    public static final int IN_ACKNOWLEDGEUGDOLEARNING = 3009;
    public static final int IN_ACKNOWLEDGEUGDOPOPUP = 3010;
    public static final int IN_RESPONSEDOORLOCKINGUSERLISTRA1 = 3011;
    public static final int IN_RESPONSEDOORLOCKINGUSERLISTRAF = 3012;
    public static final int IN_ACKNOWLEDGERDKPRESSURECHANGED = 3014;
    public static final int IN_REQUESTDOORLOCKINGPROMPT = 3015;
    public static final int IN_ACKNOWLEDGEDOORLOCKINGPROMPT = 3016;
    public static final int DRIVERSIDE_LEFT = 0;
    public static final int DRIVERSIDE_RIGHT = 1;
    public static final int DOORSTATUS_CLOSED = 0;
    public static final int DOORSTATUS_OPEN = 1;
    public static final int LOCKSTATUS_LOCKED = 0;
    public static final int LOCKSTATUS_UNLOCKED = 1;
    public static final int WINDOWSTATUS_CLOSED = 0;
    public static final int WINDOWSTATUS_OPEN = 1;
    public static final int WINDOWSTATUS_UNKNOWN = 2;
    public static final int SUNROOFSTATUS_CLOSED = 0;
    public static final int SUNROOFSTATUS_OPEN_SLIDEPOSITION = 1;
    public static final int SUNROOFSTATUS_OPEN_FOLDPOSITION = 2;
    public static final int SUNROOFSTATUS_UNKNOWN = 3;
    public static final int AUTOLOCKOPTIONS_OFF = 0;
    public static final int AUTOLOCKOPTIONS_TRUNK = 1;
    public static final int AUTOLOCKOPTIONS_ALL = 2;
    public static final int UNLOCKINGMODE_OFF = 0;
    public static final int UNLOCKINGMODE_SEPARATEDOOR = 1;
    public static final int UNLOCKINGMODE_SIDE = 2;
    public static final int UNLOCKINGMODE_ALLDOORS = 3;
    public static final int UNLOCKINGMODE_INDIVIDUAL = 4;
    public static final int RAINSENSORCONFIG_SENSITIVE = 0;
    public static final int RAINSENSORCONFIG_NORMAL = 1;
    public static final int RAINSENSORCONFIG_INSENSITIVE = 2;
    public static final int AUTHENTICATIONSTATE_INIT = 0;
    public static final int AUTHENTICATIONSTATE_OK = 1;
    public static final int AUTHENTICATIONSTATE_FAILURE1 = 2;
    public static final int AUTHENTICATIONSTATE_FAILURE2 = 3;
    public static final int AUTHENTICATIONSTATE_FAILURE3 = 4;
    public static final int AUTHENTICATIONSTATE_FAILURE4 = 5;
    public static final int AUTHENTICATIONSTATE_FAILURE5 = 6;
    public static final int AUTHENTICATIONSTATE_FAILURE7 = 8;
    public static final int AUTHENTICATIONSTATE_FAILURE8 = 9;
    public static final int AUTHENTICATIONSTATE_FAILURE9 = 10;
    public static final int UGDOBUTTONS_BUTTON1 = 1;
    public static final int UGDOBUTTONS_BUTTON2 = 2;
    public static final int UGDOBUTTONS_BUTTON3 = 4;
    public static final int UGDOASGREQUEST_NO_REQUEST = 0;
    public static final int UGDOASGREQUEST_START = 1;
    public static final int UGDOASGREQUEST_ABORT = 2;
    public static final int UGDOASGREQUEST_MOVE_YES = 3;
    public static final int UGDOASGREQUEST_MOVE_NO = 4;
    public static final int UGDOASGREQUEST_START_SYNC = 5;
    public static final int UGDOFSGRESPONSE_IDLE = 0;
    public static final int UGDOFSGRESPONSE_CHECK = 1;
    public static final int UGDOFSGRESPONSE_RESET = 2;
    public static final int UGDOFSGRESPONSE_MOVE = 3;
    public static final int UGDOFSGRESPONSE_REPEAT_RESET = 4;
    public static final int UGDOFSGRESPONSE_SUCCESSFUL = 5;
    public static final int UGDOFSGRESPONSE_ERROR = 6;
    public static final int UGDOFSGRESPONSE_WRONG_BUTTON = 7;
    public static final int UGDOFSGRESPONSE_PRESS_BUTTON = 8;
    public static final int UGDOCODESYSTEM_NOT_AVAILABLE = 0;
    public static final int UGDOCODESYSTEM_UNKNOWN = 1;
    public static final int UGDOCODESYSTEM_FIXED = 2;
    public static final int UGDOCODESYSTEM_ROLLING = 3;
    public static final int UGDOCONTENT_IDLE = 0;
    public static final int UGDOCONTENT_BUTTONPRESSED = 1;
    public static final int UGDOCONTENT_LEARNNEWDOOR = 2;
    public static final int UGDOCONTENT_RELEARNDOOR = 3;
    public static final int UGDOCONTENT_SYNCHRONISE = 4;
    public static final int UGDOCONTENT_SAVEGPSPOSITION = 5;
    public static final int UGDOCONTENT_NOFREESTORAGESPACE = 6;
    public static final int UGDOCONTENT_SAVEGPSPOSITIONNOTPOSSIBLE = 7;
    public static final int UGDOCONTENT_STATEIDLE = 8;
    public static final int UGDOCONTENT_STATEEDUCATE = 9;
    public static final int UGDOCONTENT_STATEDELETE = 10;
    public static final int UGDODOORSTATE_IDLE = 0;
    public static final int UGDODOORSTATE_MOVE = 1;
    public static final int UGDODOORSTATE_OPENING = 2;
    public static final int UGDODOORSTATE_CLOSING = 3;
    public static final int UGDODOORSTATE_MOVEMENTSTOPPED = 4;
    public static final int UGDODOORSTATE_NOCOMMUNICATION = 5;
    public static final int UGDODOORSTATE_COMMUNICATIONERROR = 6;
    public static final int UGDODOORSTATE_ABORTMOVING = 15;
    public static final int UGDOSYNCSTATE_PRESSBUTTON = 0;
    public static final int UGDOSYNCSTATE_RESETRECEIVER = 1;
    public static final int UGDOSYNCSTATE_REPEATRESETRECEIVER = 2;
    public static final int UGDOSYNCSTATE_WRONGBUTTON = 3;
    public static final int UGDOSYNCSTATE_SUCCESSFUL = 4;
    public static final int UGDOSYNCSTATE_SYNCFAILED = 5;
    public static final int UGDOSYNCSTATE_CHECKMOVEMENT = 6;
    public static final int UGDOSYNCSTATE_SYNCABORTED = 7;
    public static final int UGDOSYNCSTATE_INIT = 255;
    public static final int UGDOMOVEMENTSTATE_WAITINGFORUSER = 0;
    public static final int UGDOMOVEMENTSTATE_NODOORMOVEMENT = 1;
    public static final int UGDOMOVEMENTSTATE_DOORMOVEMENT = 2;
    public static final int UGDOMOVEMENTSTATE_INIT = 15;
    public static final int UGDOLEARNINGRESULT_UNKNOWN = 0;
    public static final int UGDOLEARNINGRESULT_FIXEDCODESYSTEM_SUCCESSFUL = 1;
    public static final int UGDOLEARNINGRESULT_ROLLINGCODESYSTEM_SUCCESSFUL = 2;
    public static final int UGDOLEARNINGRESULT_ABORT_SUCCESSFUL = 3;
    public static final int UGDOLEARNINGRESULT_TIMEOUT_NOTSUCCESSFUL = 240;
    public static final int UGDOLEARNINGRESULT_SPEEDTOHIGH_NOTSUCCESSFUL = 241;
    public static final int UGDOLEARNINGRESULT_NOFREESTORAGE_NOTSUCCESSFUL = 242;
    public static final int UGDOLEARNINGRESULT_HARDKEYNOTAVAILABLE_NOTSUCCESSFUL = 243;
    public static final int UGDOLEARNINGRESULT_ABORT_NOTSUCCESSFUL = 244;
    public static final int UGDOLEARNEDSTATE_IDLE = 0;
    public static final int UGDOLEARNEDSTATE_LEARNEDWITHPOS = 1;
    public static final int UGDOLEARNEDSTATE_LEARNEDWITHOUTPOS = 2;
    public static final int UGDOLEARNEDSTATE_LEARNEDWITHLATERSAVEDPOS = 3;
    public static final int UGDOLEARNEDSTATE_LEARNEDWITHOUTSYNCDOOR = 4;
    public static final int UGDOLEARNEDSTATE_FIXKITMODE = 5;
    public static final int UGDOLEARNEDSTATE_DEFAULTMODE = 6;
    public static final int UGDOARRAYCONTENT_NONE = 0;
    public static final int UGDOARRAYCONTENT_ALL = 1;
    public static final int UGDOARRAYCONTENT_ALL_FORWARD = 2;
    public static final int UGDOARRAYCONTENT_ALL_BACKWARD = 3;
    public static final int UGDOARRAYCONTENT_ONLY_CHANGES = 4;
    public static final int UGDOARRAYCONTENT_ELEMENTS_REMOVED = 5;
    public static final int UGDOARRAYCONTENT_BLOCK_INSERTED = 6;
    public static final int UGDOARRAYCONTENT_BACKWARD = 7;
    public static final int UGDORECORDCONTENT_RA0 = 0;
    public static final int UGDORECORDCONTENT_RA1 = 1;
    public static final int UGDORECORDCONTENT_RA2 = 2;
    public static final int UGDORECORDCONTENT_RA3 = 3;
    public static final int UGDORECORDCONTENT_RA4 = 4;
    public static final int UGDORECORDCONTENT_RA5 = 5;
    public static final int UGDORECORDCONTENT_RA6 = 6;
    public static final int UGDORECORDCONTENT_RA7 = 7;
    public static final int UGDORECORDCONTENT_RA8 = 8;
    public static final int UGDORECORDCONTENT_RA9 = 9;
    public static final int UGDORECORDCONTENT_RAA = 10;
    public static final int UGDORECORDCONTENT_RAB = 11;
    public static final int UGDORECORDCONTENT_RAC = 12;
    public static final int UGDORECORDCONTENT_RAD = 13;
    public static final int UGDORECORDCONTENT_RAE = 14;
    public static final int UGDORECORDCONTENT_RAF = 15;
    public static final int WHEELTYPE_WINTER = 0;
    public static final int WHEELTYPE_SUMMER = 1;
    public static final int WHEELTYPE_ALLSEASON = 2;
    public static final int WHEELTYPE_CUSTOMTIRE = 3;
    public static final int WHEELTYPE_UNKNOWN = 255;
    public static final int RDKSPEEDLIMITSTATE_NORMAL = 0;
    public static final int RDKSPEEDLIMITSTATE_NO_VALUE = 1;
    public static final int RDKSPEEDLIMITSTATE_NOT_AVAILABLE = 2;
    public static final int RDKWHEELSTATE_OK = 0;
    public static final int RDKWHEELSTATE_NOT_DISPLAYED = 1;
    public static final int RDKWHEELSTATE_LOW_WARNING = 2;
    public static final int RDKWHEELSTATE_HARD_WARNING = 3;
    public static final int RDKWHEELSTATE_BREAKDOWN = 4;
    public static final int RDKWHEELSTATE_UNKNOWN = 5;
    public static final int RDKWHEELSTATE_WHEELCHANGED = 6;
    public static final int RDKWHEELSTATE_PARTLOADOBSERVED = 7;
    public static final int RDKWHEELSTATE_FULLLOADOBSERVED = 8;
    public static final int RDKWHEELSTATE_FASTFORPRESSURE = 9;
    public static final int RDKWHEELSTATE_FASTFORWHEEL = 10;
    public static final int RDKWHEELSTATE_CHANGE_SWITCH_PRESS_LONGER = 11;
    public static final int RDKWHEELSTATE_SWITCH_PRESS_LONGER = 12;
    public static final int RDKWHEELSTATE_CHANGE_PRESS_LONGER = 13;
    public static final int RDKWHEELSTATE_NOT_OK = 14;
    public static final int RDKWHEELSTATE_LEARNING_ABOVE_SPEEDLEVEL = 15;
    public static final int RDKWHEELSTATE_LEARNING_STATE = 16;
    public static final int RDKWHEELSTATE_RACETRACK_MODE = 17;
    public static final int RDKWHEELSTATE_LEARNING_REQUIRED = 18;
    public static final int RDKWHEELSTATE_LEARNING_MODE = 19;
    public static final int RDKWHEELSTATE_CUSTOM_MODE = 20;
    public static final int RDKWHEELSTATE_OVER_TEMPERATURE = 21;
    public static final int RDKWHEELSTATE_OVER_PRESSURE = 22;
    public static final int RDKWHEELSTATE_PRESSURE_STORED = 23;
    public static final int RDKWHEELSTATE_BATTERY_LOW = 24;
    public static final int RDKSYSTEM_LOW = 0;
    public static final int RDKSYSTEM_HIGH = 1;
    public static final int RDKSYSTEM_HIGH_PLUS = 2;
    public static final int RDKSYSTEM_UNKNOWN = 255;
    public static final int RDKSYSTEMTYPE_INDIRECT = 0;
    public static final int RDKSYSTEMTYPE_DIRECT = 1;
    public static final int RDKSYSTEMTYPE_UNKNOWN = 255;
    public static final int RDKSPEEDLIMIT_UNKNOWN = 0;
    public static final int RDKSPEEDLIMIT_LIMIT1 = 1;
    public static final int RDKSPEEDLIMIT_LIMIT2 = 2;
    public static final int RDKSPEEDLIMIT_LIMIT3 = 3;
    public static final int RDKPROGRESS_IDLE = 0;
    public static final int RDKPROGRESS_RUNNING = 1;
    public static final int RDKPROGRESS_SUCCESSFUL = 2;
    public static final int RDKPROGRESS_ERROR = 3;
    public static final int RDKBATTERYLIFETIMEUNIT_MONTH = 0;
    public static final int RDKBATTERYLIFETIMEUNIT_PERCENT = 1;
    public static final int RDKPRESSURELEVEL_UNKNOWN = 0;
    public static final int RDKPRESSURELEVEL_PRESSURE1 = 1;
    public static final int RDKPRESSURELEVEL_PRESSURE2 = 2;
    public static final int RDKPRESSURELEVEL_PRESSURE3 = 3;
    public static final int BRAKEESCMODE_OFF = 0;
    public static final int BRAKEESCMODE_SPORT = 1;
    public static final int BRAKEESCMODE_TCSOFF = 2;
    public static final int BRAKEESCMODE_FULL = 3;
    public static final int BRAKEESCMODE_OFFROAD = 4;
    public static final int BRAKEAUTOHOLD_OFF = 0;
    public static final int BRAKEAUTOHOLD_ON = 1;
    public static final int BRAKEAUTOHOLD_LASTMODE = 2;
    public static final int LOCALHAZARDEVENTTRANSACTION_SET = 0;
    public static final int LOCALHAZARDEVENTTRANSACTION_CANCELLED = 1;
    public static final int LOCALHAZARDEVENTQUALITY_NOQUALITY = 0;
    public static final int LOCALHAZARDEVENTQUALITY_QUALITY1 = 1;
    public static final int LOCALHAZARDEVENTQUALITY_QUALITY2 = 2;
    public static final int LOCALHAZARDEVENTQUALITY_QUALITY3 = 3;
    public static final int LOCALHAZARDEVENTQUALITY_QUALITY4 = 4;
    public static final int LOCALHAZARDEVENTQUALITY_QUALITY5 = 5;
    public static final int LOCALHAZARDEVENTQUALITY_QUALITY6 = 6;
    public static final int LOCALHAZARDEVENTQUALITY_QUALITY7 = 7;
    public static final int LOCALHAZARDEVENTTYPE_NOTYPE = 0;
    public static final int LOCALHAZARDEVENTTYPE_ACCIDENT = 1;
    public static final int LOCALHAZARDEVENTTYPE_REDUCEDVISIBILITY = 2;
    public static final int LOCALHAZARDEVENTTYPE_BREAKDOWN = 3;
    public static final int LOCALHAZARDEVENTTYPE_TRACTIONLOSS = 4;
    public static final int RGSPRESENSEWARNING_OFF = 0;
    public static final int RGSPRESENSEWARNING_EARLY = 1;
    public static final int RGSPRESENSEWARNING_MEDIUM = 2;
    public static final int RGSPRESENSEWARNING_LATE = 3;
    public static final int USERLISTTYPE_STRING = 0;
    public static final int USERLISTTYPE_USER1 = 1;
    public static final int USERLISTTYPE_USER2 = 2;
    public static final int USERLISTTYPE_USER3 = 3;
    public static final int USERLISTTYPE_USER4 = 4;
    public static final int USERLISTTYPE_USER5 = 5;
    public static final int USERLISTTYPE_USER6 = 6;
    public static final int USERLISTTYPE_USER7 = 7;
    public static final int USERLISTTYPE_GUEST = 16;
    public static final int USERLISTARRAYCONTENT_NONE = 0;
    public static final int USERLISTARRAYCONTENT_ALL = 1;
    public static final int USERLISTARRAYCONTENT_ALL_FORWARD = 2;
    public static final int USERLISTARRAYCONTENT_ALL_BACKWARD = 3;
    public static final int USERLISTARRAYCONTENT_ONLY_CHANGES = 4;
    public static final int USERLISTARRAYCONTENT_ELEMENTS_REMOVED = 5;
    public static final int USERLISTARRAYCONTENT_BLOCK_INSERTED = 6;
    public static final int USERLISTARRAYCONTENT_BACKWARD = 7;
    public static final int USERLISTRECORDCONTENT_RA1 = 1;
    public static final int USERLISTRECORDCONTENT_RAF = 15;
    public static final int USERPROFILECONTROL_SETDEFAULT_ALL = 1;
    public static final int USERPROFILECONTROL_SETDEFAULT_ACTIVE = 2;
    public static final int USERPROFILECONTROL_COPYACTIVETOTARGET = 3;
    public static final int USERPROFILECONTROL_SETACTIVETOTARGET = 4;
    public static final int USERPROFILECONTROL_ASSIGNKEYTOTARGET = 5;
    public static final int USERPROFILECONTROL_CONTROL_NOT_AVAILABLE = 255;
    public static final int BLINDSCONTROL_BOOTBLINDDOWN = 0;
    public static final int BLINDSCONTROL_BOOTBLINDUP = 1;
    public static final int BLINDSCONTROL_ALLDOWN = 2;
    public static final int BLINDSCONTROL_ALLUP = 3;
    public static final int BLINDSCONTROLMOTIONSTATE_IDLEORFINISHED = 0;
    public static final int BLINDSCONTROLMOTIONSTATE_MOVINGDOWN = 1;
    public static final int BLINDSCONTROLMOTIONSTATE_MOVINGUP = 2;
    public static final int SIDEBLINDSCONTROLSTATE_DOWN = 0;
    public static final int SIDEBLINDSCONTROLSTATE_UP = 1;
    public static final int SIDEBLINDSCONTROLSTATE_MOVINGDOWN = 2;
    public static final int SIDEBLINDSCONTROLSTATE_MOVINGUP = 3;
    public static final int DOORLOCKINGPROMPTCONTENT_NONE = 0;
    public static final int DOORLOCKINGPROMPTCONTENT_SHOW_ATNE = 1;
    public static final int MASCOTCONTROLPOSITION_DOWN = 0;
    public static final int MASCOTCONTROLPOSITION_UP = 1;
    public static final int MASCOTCONTROLPOSITION_MOVINGDOWN = 2;
    public static final int MASCOTCONTROLPOSITION_MOVINGUP = 3;
    public static final int MASCOTCONTROLPOSITION_UNKNOWN = 4;
    public static final int MASCOTMODE_MANUAL = 0;
    public static final int MASCOTMODE_AUTOMATICONIGNITION = 1;
    public static final int MASCOTMODE_AUTOMATICONLOCK = 2;

    public void setRGSBeltPretensionerDataFront(RGSBeltPretensionData var1);

    public void setRGSBeltPretensionerDataRear(RGSBeltPretensionData var1);

    public void setRGSPreCrashSystem(boolean var1);

    public void setRgsSetFactoryDefault();

    public void setRGSPreSenseSystem(boolean var1);

    public void setRGSPreSenseWarning(int var1);

    public void setRGSLocalHazardInformation(RGSLocalHazardInformation var1);

    public void setDoorLockingComfortOpenSettings(DoorLockingComfortOpenSettings var1);

    public void setDoorLockingTheftWarningSettings(DoorLockingTheftWarningSettings var1);

    public void setDoorLockingClBootOpen(boolean var1);

    public void setDoorLockingBootOpen(boolean var1);

    public void setDoorLockingBootClose(boolean var1);

    public void startDoorLockingRemoteLockUnlock(String var1);

    public void abortDoorLockingRemoteLockUnlock();

    public void sendDoorLockingRemoteLockUnlockSignature(String var1);

    public void startDoorLockingRemoteBlinking(int var1);

    public void startDoorLockingRemoteHorn(int var1);

    public void setDoorLockingUnlockingMode(int var1);

    public void setDoorLockingAutoLock(int var1);

    public void setDoorLockingAutoUnlock(boolean var1);

    public void setDoorLockingClBootLock(boolean var1);

    public void setDoorLockingMirrorProtection(boolean var1);

    public void setDoorLockingConfirmation(boolean var1);

    public void setDoorLockingRainClosing(boolean var1);

    public void setDoorLockingRearBlind(DoorLockingRearBlind var1);

    public void setDoorLockingSetFactoryDefault();

    public void requestDoorLockingUserList(DoorLockingUserListUpdateInfo var1);

    public void setDoorLockingUserListRA1(DoorLockingUserListUpdateInfo var1, DoorLockingUserListRA1[] var2);

    public void setDoorLockingUserListRAF(DoorLockingUserListUpdateInfo var1, int[] var2);

    public void setDoorLockingActiveUser(int var1);

    public void setDoorLockingUserProfileOnOff(DoorLockingUserProfileOnOff var1);

    public void startDoorLockingUserProfileControl(int var1, int var2);

    public void abortDoorLockingUserProfileControl();

    public void setDoorLockingWindowAutoClose(boolean var1);

    public void setDoorlockingBlindsControl(int var1);

    public void setDoorlockingBlindsControlExtended(int var1);

    public void setDoorLockingLeftSideBlindControl(int var1);

    public void setDoorLockingRightSideBlindControl(int var1);

    public void setDoorLockingTurnIndRepeat(boolean var1);

    public void setDoorLockingKeyless(boolean var1);

    public void setWiperServicePosition(boolean var1);

    public void setWiperRainSensorOnOff(boolean var1);

    public void setWiperRainSensorConfig(int var1);

    public void setWiperRearWiping(boolean var1);

    public void setWiperTearsWiping(boolean var1);

    public void setWiperWinterPosition(boolean var1);

    public void setEasyEntrySteeringColumn(boolean var1);

    public void setWiperSetFactoryDefault();

    public void setUGDOLearningData(UGDOLearningData var1);

    public void showUGDOPopup(UGDOContent var1);

    public void cancelUGDOPopup(UGDOContent var1);

    public void deleteUGDOButton(UGDOSoftkeys var1);

    public void setUGDOSetFactoryDefault();

    public void setUGDODestinationReached(UGDODestinationReached var1);

    public void setUGDOOpenDoor(UGDOOpenDoor var1);

    public void setUGDOSynchronisation(UGDOSynchronisation var1);

    public void responseUGDOSynchronisation(UGDOSynchronisation var1);

    public void startUGDOLearning(int var1, int var2);

    public void abortUGDOLearning();

    public void requestUGDOButtonList(UGDOButtonListUpdateInfo var1);

    public void setUGDOButtonListRA0(UGDOButtonListUpdateInfo var1, UGDOButtonListRA0[] var2);

    public void setUGDOButtonListRA1(UGDOButtonListUpdateInfo var1, UGDOButtonListRA1[] var2);

    public void setUGDOButtonListRA2(UGDOButtonListUpdateInfo var1, UGDOButtonListRA2[] var2);

    public void setUGDOButtonListRA3(UGDOButtonListUpdateInfo var1, UGDOButtonListRA3[] var2);

    public void setUGDOButtonListRA4(UGDOButtonListUpdateInfo var1, UGDOButtonListRA4[] var2);

    public void setUGDOButtonListRA5(UGDOButtonListUpdateInfo var1, UGDOButtonListRA5[] var2);

    public void setUGDOButtonListRAF(UGDOButtonListUpdateInfo var1, int[] var2);

    public void setRDKSystemOnOff(boolean var1);

    public void setRDKTireSetupSelectedTire(int var1);

    public void setRDKSpeedLimit(int var1);

    public void setRDKTireChanged();

    public void setRDKPressureChanged();

    public void requestRDKLifeMonitoring();

    public void setRDKPressureLevel(byte var1);

    public void setRDKSetFactoryDefault();

    public void setMirrorLowering(boolean var1);

    public void setMirrorSyncAdjust(boolean var1);

    public void setMirrorFolding(boolean var1);

    public void setMirrorDimming(boolean var1);

    public void setMirrorHeating(boolean var1);

    public void setMirrorSetFactoryDefault();

    public void setBrakeElectricalParking(boolean var1);

    public void setBrakeAutoHold(int var1);

    public void setBrakeEscMode(int var1);

    public void setBrakeHdcMode(boolean var1);

    public void setHMIIsReady(boolean var1);

    public void showDoorLockingPrompt(int var1);

    public void cancelDoorLockingPrompt(int var1);

    public void setMascotSetFactoryDefault();

    public void setMascotControl(int var1);

    public void setMascotMode(int var1);
}

