/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.carparkingsystem;

import org.dsi.ifc.base.DSIBase;
import org.dsi.ifc.carparkingsystem.DisplayContent;
import org.dsi.ifc.carparkingsystem.PDCPLASystemState;
import org.dsi.ifc.carparkingsystem.PDCPiloPaSystemState;
import org.dsi.ifc.carparkingsystem.PDCSound;
import org.dsi.ifc.carparkingsystem.PDCSoundReproduction;
import org.dsi.ifc.carparkingsystem.VPSCameraCleaning;
import org.dsi.ifc.carparkingsystem.VPSDefaultMode;
import org.dsi.ifc.carparkingsystem.VPSDynParkingMode;
import org.dsi.ifc.carparkingsystem.VPSOPSOverlay;
import org.dsi.ifc.global.CarArrayListUpdateInfo;

public interface DSICarParkingSystem
extends DSIBase {
    public static final String VERSION = "2.11.21";
    public static final int ATTR_PARKINGSYSTEMVIEWOPTIONS = 1;
    public static final int ATTR_PDCDEFAULTPARKINGMODE = 2;
    public static final int ATTR_PDCFREQUENCEFRONT = 3;
    public static final int ATTR_PDCFREQUENCEREAR = 4;
    public static final int ATTR_PDCVOLUMEFRONT = 5;
    public static final int ATTR_PDCVOLUMEREAR = 6;
    public static final int ATTR_PDCMUTE = 7;
    public static final int ATTR_PDCSYSTEMONOFF = 8;
    public static final int ATTR_PDCTRAILERHITCHED = 9;
    public static final int ATTR_PDCDISTANCEVALUESFRONT = 10;
    public static final int ATTR_PDCDISTANCEVALUESREAR = 11;
    public static final int ATTR_PDCFREQUENCERIGHT = 27;
    public static final int ATTR_PDCFREQUENCELEFT = 28;
    public static final int ATTR_PDCVOLUMERIGHT = 29;
    public static final int ATTR_PDCVOLUMELEFT = 30;
    public static final int ATTR_PDCINFO = 31;
    public static final int ATTR_PDCFAILURE = 32;
    public static final int ATTR_PDCDISTANCEVALUESRIGHT = 33;
    public static final int ATTR_PDCDISTANCEVALUESLEFT = 34;
    public static final int ATTR_PDCSTATUSLEVELFRONT = 35;
    public static final int ATTR_PDCSTATUSLEVELREAR = 36;
    public static final int ATTR_PDCSTATUSLEVELRIGHT = 37;
    public static final int ATTR_PDCSTATUSLEVELLEFT = 38;
    public static final int ATTR_PDCCRASHWARNING = 39;
    public static final int ATTR_PDCSTEERINGINFORMATION = 40;
    public static final int ATTR_PDCOPSAUTOACTIVATION = 41;
    public static final int ATTR_PDCFLANKGUARD = 42;
    public static final int ATTR_PDCSOUNDREPRODUCTION = 43;
    public static final int ATTR_PDCSTATUSLEVELFRONTEXT = 49;
    public static final int ATTR_PDCSTATUSLEVELREAREXT = 50;
    public static final int ATTR_PDCDISTANCEVALUESFRONTEXT = 51;
    public static final int ATTR_PDCDISTANCEVALUESREAREXT = 52;
    public static final int ATTR_PDCWALLDETECTION = 53;
    public static final int ATTR_PDCPLAMESSAGE = 54;
    public static final int ATTR_PDCSOUNDFRONT = 55;
    public static final int ATTR_PDCSOUNDREAR = 56;
    public static final int ATTR_PDCSOUNDLEFT = 57;
    public static final int ATTR_PDCSOUNDRIGHT = 58;
    public static final int ATTR_PDCPLASTATUS = 59;
    public static final int ATTR_PDCPLABARGRAPH = 60;
    public static final int ATTR_PDCPLAPARKMODESELECTION = 61;
    public static final int ATTR_PDCPLASYSTEMSTATE = 62;
    public static final int ATTR_PDCOFFROADMODE = 63;
    public static final int ATTR_PDCPARKBOXVISUALISATION = 64;
    public static final int ATTR_PDCOPSVISUALISATIONPOSITION = 65;
    public static final int ATTR_PDCMANEUVERASSISTCONFIG = 71;
    public static final int ATTR_PDCMANEUVERASSIST = 72;
    public static final int ATTR_PDCMANEUVERASSISTSTATE = 73;
    public static final int ATTR_PDCMANEUVERASSISTMESSAGE = 74;
    public static final int ATTR_PDCIPAMESSAGE = 75;
    public static final int ATTR_PDCCONTINUEDRIVINGASSIST = 76;
    public static final int ATTR_PDCIPACONFIG = 77;
    public static final int ATTR_PDCPILOPASYSTEMSTATE = 78;
    public static final int ATTR_VPSFOLLOWUPTIME = 13;
    public static final int ATTR_VPSVIDEOINFO = 14;
    public static final int ATTR_VPSCOLOR = 15;
    public static final int ATTR_VPSCONTRAST = 16;
    public static final int ATTR_VPSBRIGHTNESS = 17;
    public static final int ATTR_VPSDEFAULTMODERV = 18;
    public static final int ATTR_VPSDEFAULTMODESV = 19;
    public static final int ATTR_VPSDEFAULTMODEFV = 20;
    public static final int ATTR_VPSDEFAULTMODEBV = 21;
    public static final int ATTR_VPSDEFAULTVIEW = 22;
    public static final int ATTR_VPSDYNAMICPARKINGMODE = 23;
    public static final int ATTR_VPSOPSOVERLAY = 24;
    public static final int ATTR_VPSSYSTEMONOFF = 25;
    public static final int ATTR_VPSFAILURE = 44;
    public static final int ATTR_VPSEXTCAMCONFIG = 66;
    public static final int ATTR_VPSEXTCAMMANACTIVATION = 67;
    public static final int ATTR_VPS3DBIRDVIEW = 68;
    public static final int ATTR_VPSSYSTEMSTATE = 69;
    public static final int ATTR_VPSCAMERASTATES = 70;
    public static final int ATTR_VPSCAMERACLEANING = 79;
    public static final int ATTR_VPSRIMPROTECTION = 80;
    public static final int ATTR_ARAFAILURE = 45;
    public static final int ATTR_ARAINFO = 46;
    public static final int ATTR_ARACURRENTTRAILERANGLE = 47;
    public static final int ATTR_ARATARGETTRAILERANGLE = 48;
    public static final int ATTR_PARKINGPOPUPCONTENT = 26;
    public static final int ATTR_WCSYSTEMONOFF = 89;
    public static final int ATTR_WCAUTOACTIVATION = 90;
    public static final int ATTR_WCPOPUPCONTENT = 91;
    public static final int ATTR_WCMESSAGE = 92;
    public static final int ATTR_WCPANELPOSITION = 93;
    public static final int ATTR_WCVEHICLEPANELINFO = 94;
    public static final int ATTR_WCPINPUKSTATE = 95;
    public static final int ATTR_WCPANELLISTUPDATEINFO = 96;
    public static final int ATTR_WCPANELLISTTOTALNUMBEROFELEMENTS = 97;
    public static final int ATTR_WCSCANNINGPROGRESS = 98;
    public static final int ATTR_WCSOFTWAREUPDATEPROGRESS = 99;
    public static final int ATTR_WCVIEWOPTIONS = 102;
    public static final int POPUP_NONE = 0;
    public static final int POPUP_OPS = 1;
    public static final int POPUP_VPS = 2;
    public static final int POPUP_VPSOPS = 3;
    public static final int POPUP_OPSAUTOACTIVATION = 4;
    public static final int POPUP_SETTINGS = 5;
    public static final int POPUP_GENERAL = 6;
    public static final int POPUP_OPSFLANKGUARD = 7;
    public static final int POPUP_VPSOPSFLANKGUARD = 8;
    public static final int POPUP_ARA = 9;
    public static final int POPUP_ARAOPS = 10;
    public static final int POPUP_ARAOPSFLANKGUARD = 11;
    public static final int POPUP_ARAVPS = 12;
    public static final int POPUP_ARAVPSOPS = 13;
    public static final int POPUP_ARAVPSOPSFLANKGUARD = 14;
    public static final int POPUP_OPSFLANKGUARDPLA = 15;
    public static final int POPUP_VPSOPSFLANKGUARDPLA = 16;
    public static final int POPUP_OPSOFFROAD = 17;
    public static final int POPUP_VPSOPSOFFROAD = 18;
    public static final int PDCDEFAULTPARKINGMODE_OFF = 0;
    public static final int PDCDEFAULTPARKINGMODE_OPS = 1;
    public static final int PDCDEFAULTPARKINGMODE_OPS_AUTOACTIVATION = 2;
    public static final int PDCDEFAULTPARKINGMODE_OPS_FLANKGUARD = 3;
    public static final int PDCDEFAULTPARKINGMODE_LASTUSED = 15;
    public static final int PDCTRACKDISPLAY_NONE = 0;
    public static final int PDCTRACKDISPLAY_FRONT = 1;
    public static final int PDCTRACKDISPLAY_REAR = 2;
    public static final int PDCSTATUSLEVEL_NOWARNING = 0;
    public static final int PDCSTATUSLEVEL_LOW = 1;
    public static final int PDCSTATUSLEVEL_MEDIUM = 2;
    public static final int PDCSTATUSLEVEL_HARD = 3;
    public static final int PDCSTATUSLEVEL_EXTERNAL_VALUE = 4;
    public static final int PDCSTATUSLEVEL_EXTERNAL_VALUE_PDC_NOT_INITIALIZED = 5;
    public static final int PDCSTATUSLEVEL_LOW_PDC_NOT_INITIALIZED = 6;
    public static final int PDCSTATUSLEVEL_MEDIUM_PDC_NOT_INITIALIZED = 7;
    public static final int PDCSTATUSLEVEL_HARD_PDC_NOT_INITIALIZED = 8;
    public static final int PDCSTATUSLEVEL_SPEED_OUT_OF_RANGE = 11;
    public static final int PDCSTATUSLEVEL_AFFECTED_BY_FAILURE = 12;
    public static final int PDCSTATUSLEVEL_TEMPNOTAVAILABLE = 13;
    public static final int PDCSTATUSLEVEL_NOTINITIALIZED = 14;
    public static final int PDCSTATUSLEVEL_ERROR = 15;
    public static final int PDCIPAMESSAGES_NO_MESSAGE = 0;
    public static final int IPA_PARKING_PILOT_WATCH_TRAFFIC = 1;
    public static final int IPA_PARKING_PILOT_ACTIVE_WATCH_TRAFFIC_AND_BRAKE = 2;
    public static final int IPA_PARKING_PILOT_SPEED_LIMITED = 3;
    public static final int IPA_PARKING_PILOT_CANCELED_STEERING_INTERVENTION_OF_THE_DRIVER_TAKE_OVER_THE_VEHICLE = 4;
    public static final int IPA_PARKING_PILOT_EMERGENCY_BRAKE = 5;
    public static final int IPA_PARKING_PILOT_CANCELED_EMERGENCY_BRAKE_TAKE_OVER_THE_VEHICLE = 6;
    public static final int IPA_PARKING_PILOT_CANCELED_EMERGENCY_BRAKE_INTERVENTION_OF_ESC_TAKE_OVER_THE_VEHICLE = 7;
    public static final int IPA_PARKING_PILOT_CANCELED_TIME_LIMIT_EXCEEDED_TAKE_OVER_THE_VEHICLE = 8;
    public static final int IPA_PARKING_PILOT_CANCELED_EMERGENCY_BRAKE_PARKING_NOT_POSSIBLE_TAKE_OVER_THE_VEHICLE = 9;
    public static final int IPA_PARKING_PILOT_CANCELED_TAKE_OVER_THE_VEHICLE = 10;
    public static final int IPA_PARKING_PILOT_INTERRUPTED_BRAKE = 11;
    public static final int IPA_PARKING_PILOT_TEMPORARY_NOT_AVAILABLE = 12;
    public static final int IPA_PARKING_PILOT_SYSTEM_ERROR_PLEASE_CONTACT_A_SERVICE_CENTER = 13;
    public static final int IPA_PARKING_PILOT_PARK_OUT_NOT_POSSIBLE_PARKING_SLOT_TOO_SMALL = 14;
    public static final int IPA_PARKING_PILOT_INTERVENTION_OF_ESC_CONTINUE_DRIVING = 15;
    public static final int IPA_PARKING_PILOT_TIME_LIMIT_EXCEEDED_CONTINUE_DRIVING = 16;
    public static final int IPA_PARKING_PILOT_NOT_POSSIBLE_IF_TRAILER_HITCHED = 17;
    public static final int IPA_PARKING_PILOT_CANCELED_PARKING_NOT_POSSIBLE = 18;
    public static final int IPA_PARKING_PILOT_EMERGENCY_BRAKE_CLOSE_DOOR = 19;
    public static final int IPA_PARKING_PILOT_EMERGENCY_BRAKE_APPLY_SEATBELT = 20;
    public static final int IPA_PARKING_PILOT_POSOK_PLEASE_PRESS_BUTTON_AND_RELEASE_BRAKE = 21;
    public static final int IPA_PARKING_PILOT_POSOK_PLEASE_STOP = 22;
    public static final int IPA_PARKING_PILOT_EMERGENCY_BRAKE_TO_CONTINUE_BRAKE_AND_RELEASE_EPB_BRAKE = 23;
    public static final int IPA_PARKING_PILOT_EMERGENCY_BRAKE_SIDE_MIRROR_RETRACTED = 24;
    public static final int IPA_PARKING_PILOT_NOT_POSSIBLE_IF_SIDE_MIRROR_RETRACTED = 25;
    public static final int IPA_PARKING_PILOT_CANCELED_EMERGENCY_BRAKE_GRADIENT_TOO_HIGH = 26;
    public static final int IPA_PARKING_PILOT_TEMPORARY_NOT_AVAILABLE_ESC_OFF = 27;
    public static final int IPA_PARKING_PILOT_CANCELED_EMERGENCY_BRAKE_NO_CAMERA_IMAGE = 28;
    public static final int IPA_PARKING_PILOT_BE_CAREFUL_OF_TRAFFIC = 29;
    public static final int IPA_PARKING_PILOT_EMERGENCY_BRAKE_BUTTON_NOT_HOLD = 30;
    public static final int IPA_PARKING_PILOT_CANCELED_EMERGENCY_BRAKE_GEAR_MANUALLY_SHIFTED = 31;
    public static final int IPA_PARKING_PILOT_CANCELED_BRAKING_NOT_POSSIBLE_PLEASE_TAKE_OVER_THE_VEHICLE = 32;
    public static final int IPA_PARKING_PILOT_DRIVING_OVER_THE_CURB = 33;
    public static final int IPA_PARKING_PILOT_INTERRUPTED_TO_CONTINUE_HOLD_THE_BUTTON = 34;
    public static final int IPA_PARKING_PILOT_CANCELED_TO_CONTINUE_PRESS_THE_BUTTON_AGAIN = 35;
    public static final int IPA_PARKING_PILOT_FOR_PARKING_OUT_PLEASE_SELECT_DIRECTION_USING_THE_TURN_INDICATOR = 36;
    public static final int IPA_PARKING_PILOT_INTERRUPTED_EMERGENCY_BRAKE_PLEASE_REMOVE_THE_OBSTACLE = 37;
    public static final int IPA_PARKING_PILOT_CANCELED_ACCELERATION_FROM_DRIVER_TAKE_OVER_THE_VEHICLE = 38;
    public static final int IPA_PP_PARKING_PILOT_PLEASE_START_YOUR_PARK_APPLICATION_TAKE_YOUR_KEY_AND_LEAVE_THE_VEHICLE = 39;
    public static final int IPA_PP_PARKING_PILOT_PLEASE_TAKEOVER_THE_VEHICLE_TO_CONTINUE_DRIVING = 40;
    public static final int IPA_PP_PARKING_PILOT_ERROR_TAKEOVER_KEY_NOT_FOUND = 41;
    public static final int IPA_PP_PARKING_PILOT_TIME_LIMIT_FOR_TAKEOVER_EXCEEDED = 42;
    public static final int IPA_PARKING_PILOT_ACTIVATION_NOT_POSSIBLE_ANOTHER_FAS_IS_ACTIVE = 43;
    public static final int IPA_PARKING_PILOT_PRESS_BRAKE_AND_THEN_DEADMAN_SWITCH_UNTIL_END_OF_PARKING_CYCLE = 44;
    public static final int IPA_PARKING_PILOT_OPPOSITE_SIDE_IS_BARRED = 45;
    public static final int IPA_PARKING_PILOT_PARK_IN_ACTIVE_STEERING_INTERVENTION_ACTIVE_LOOK_SAFE_TO_MOVE_RELEASE_BRAKE_TO_START_MANEUVERING = 46;
    public static final int IPA_PARKING_PILOT_USE_DIRECTION_INDICATORS_SWITCH_GEAR_AND_HOLD_DEADMAN_SWITCH_RELEASE_BRAKE_TO_START_MANEUVERING = 47;
    public static final int IPA_PARKING_PILOT_PARK_OUT_ACTIVE_STEERING_INTERVENTION_ACTIVE_LOOK_SAFE_TO_MOVE_RELEASE_BRAKE_TO_START_MANEUVERING = 48;
    public static final int IPA_PARKING_PILOT_PARK_IN_ACTIVE_LOOK_SAFE_TO_MOVE = 49;
    public static final int IPA_PARKING_PILOT_DRIVINGDIRECTION_WILL_CHANGE = 50;
    public static final int IPA_PARKING_PILOT_PARK_OUT_ACTIVE_LOOK_SAFE_TO_MOVE = 51;
    public static final int IPA_PARKING_PILOT_CANCELED_KEY_IS_STILL_IN_THE_CAR = 52;
    public static final int IPA_PARKING_PILOT_CANCELED_SLIDING_DOOR_OPEN = 53;
    public static final int IPA_PARKING_PILOT_CANCELED_SPEED_TOO_HIGH = 54;
    public static final int IPA_PARKING_PILOT_PARKING_NOT_POSSIBLE_OPPOSITE_SIDE_BARRED = 55;
    public static final int IPA_PARKING_PILOT_INTERVENTION_OF_TRACTION_CONTROL_ASR = 56;
    public static final int IPA_PARKING_PILOT_STOPPED_CANCELED = 57;
    public static final int IPA_PARKING_PILOT_PROBLEM_WITH_CAMERA_SENSOR_PLA_FUNCTION_AVAILABLE_PRESS_BRAKE_TAKE_OVER = 58;
    public static final int IPA_PARKING_PILOT_CANCELED_ESCOFF_PRESS_BRAKE_TAKE_OVER = 59;
    public static final int IPA_PARKING_PILOT_SYSTEM_ERROR_PLEASE_CONTACT_A_SERVICE_CENTER_PRESS_BRAKE_TAKE_OVER = 60;
    public static final int IPA_PARKING_PILOT_CONVERTIBLE_TOP_ACTIVE_PARK_ASSIST_STOPPED_PRESS_BRAKE_TAKE_OVER = 61;
    public static final int IPA_PARKING_PILOT_TIMEOUT_REACHED_PARK_ASSIST_CANCELED_PRESS_BRAKE_TAKE_OVER = 62;
    public static final int IPA_PARKING_PILOT_TEMP_NOT_AVAILABLE_PARK_ASSIST_CANCELED_PRESS_BRAKE_TAKE_OVER = 63;
    public static final int IPA_PARKING_PILOT_CANCELED_PRESS_BRAKE_TAKE_OVER = 64;
    public static final int IPA_PARKING_PILOT_TRUNK_OPEN_CLOSE_TRUNK_PRESS_BRAKE_TAKE_OVER = 65;
    public static final int IPA_PARKING_PILOT_SLIDING_DOOR_OPEN_CLOSE_SLIDING_DOOR_PRESS_BRAKE_TAKE_OVER = 66;
    public static final int IPA_PARKING_PILOT_MOTOR_NOT_READY_START_MOTOR_PRESS_BRAKE_TAKEOVER = 67;
    public static final int IPA_PARKING_PILOT_FRONT_LID_OPEN_CLOSE_FRONT_LID_PRESS_BRAKE_TAKE_OVER = 68;
    public static final int IPA_PARKING_PILOT_DRIVER_DOOR_OPEN_CLOSE_DRIVER_DOOR_PRESS_BRAKE_TAKE_OVER = 69;
    public static final int IPA_PARKING_PILOT_PDC_IS_DEACTIVATED_PARK_ASSIST_STOPPED_PRESS_BRAKE_TAKE_OVER = 70;
    public static final int IPA_PARKING_PILOT_STARTS_MOTOR = 71;
    public static final int IPA_PARKING_PILOT_RELEASE_PARKING_BRAKE = 72;
    public static final int IPA_PARK_ASSIST_STOPPED_SLIDING_DOOR_OPEN = 73;
    public static final int IPA_PARKING_PILOT_PRESS_BRAKE_FOR_AUTOMATIC_PARK_IN = 74;
    public static final int IPA_PARKING_PILOT_UNSUFFICIENT_STANDSTILL_PRESS_BRAKE = 75;
    public static final int IPA_PARKING_PILOT_ERROR_ON_KEY_AUTHENTICATION_DO_PARKING_MANUALLY_OR_ACTIVATE_PARK_ASSIST_AGAIN = 76;
    public static final int IPA_PARKING_PILOT_DRIVER_STILL_IN_THE_CAR_LEAVE_THE_CAR_TO_START_PP = 77;
    public static final int IPA_PARKING_PILOT_EPB_ACTIVE_PARK_ASSIST_CANCELED = 78;
    public static final int IPA_PARKING_PILOT_MAX_AMOUNT_OF_MANEUVRE_MOVES_REACHED_PARKING_NOT_POSSIBLE_TAKE_OVER = 79;
    public static final int IPA_PARKING_PILOT_CANCELED_LEAVE_RADIO_RANGE_OF_REMOTE_CONTROL_CAR_BACKED = 80;
    public static final int IPA_PARKING_PILOT_CANCELED_DISTURBANCE_OF_RADIO_CONTROL_TAKE_OVER = 81;
    public static final int IPA_PARKING_PILOT_CANCELED_INTERVENTION_ESC_PRESS_BRAKE_TAKE_OVER = 82;
    public static final int IPA_PARKING_PILOT_CANCELED_AUTOMATIV_PARK_IN_NOT_POSSIBLE_PRESS_BRAKE_TAKE_OVER = 83;
    public static final int IPA_PARKING_PILOT_OBSTACLE_DETECTED_IN_MANEUVER_AREA_PRESS_BRAKE_TAKE_OVER = 84;
    public static final int IPA_PARKING_PILOT_CANCELED_AUTOMATIC_PARK_OUT_NOT_POSSIBLE_PRESS_BRAKE_TAKE_OVER = 85;
    public static final int IPA_PARKING_PILOT_CANCELED_SLIPPING_DETECTED_PRESS_BRAKE_TAKE_OVER = 86;
    public static final int IPA_PARKING_PILOT_CANCELED_DRIVING_RESISTANCE_TOO_HIGH_PRESS_BRAKE_TAKE_OVER = 87;
    public static final int IPA_PARKING_PILOT_CANCELED_BRAKING_INTERVENTION_BY_ANOTHER_FAS_SYSTEM_PRESS_BRAKE_TAKE_OVER = 88;
    public static final int IPA_PARKING_PILOT_CANCELED_ERROR_ON_CAMERA_SENSOR_SYSTEM_PRESS_BRAKE_TAKE_OVER = 89;
    public static final int IPA_PARKING_PILOT_CANCELED_STEERING_INTERVENTION_BY_DRIVER_PRESS_BRAKE_TAKE_OVER = 90;
    public static final int IPA_PARKING_PILOT_CANCELED_GEAR_SWITCHED_MANUALLY_PRESS_BRAKE_TAKE_OVER = 91;
    public static final int IPA_PARKING_PILOT_MOTOR_NOT_READY_START_MOTOR_PRESS_BRAKE_TAKE_OVER = 92;
    public static final int IPA_PARKING_PILOT_CANCELED_PARK_BUTTON_PRESSED_PRESS_BRAKE_TAKE_OVER = 93;
    public static final int IPA_PARKING_PILOT_PDC_ACTIVATED_PRESS_BRAKE_TAKE_OVER = 94;
    public static final int IPA_PARKING_PILOT_CANCELED_DOOR_OPEN_CLOSE_DOOR_PRESS_BRAKE_TAKE_OVER = 95;
    public static final int IPA_PARKING_PILOT_DRIVING_RESISTANCE_RECOGNIZED_PARK_ASSIST_STANDBY_TO_PASS_OVER_ACTIVATE_DEAD_MAN_SWITCH_LOOK_SAFE_TO_MOVE = 96;
    public static final int IPA_PARKING_PILOT_HOLD_DEAD_MAN_SWITCH_UNTIL_PARKING_IS_FINISHED_OR_DRIVER_LEAVES_CAR_FOR_PP = 97;
    public static final int IPA_PARKING_PILOT_DRIVING_SPEED_INCREASED_AUTOMATIC_SPEEDCONTROL_ACTIVE = 98;
    public static final int IPA_PARKING_PILOT_HOLDING_SPEED = 99;
    public static final int IPA_PARKING_PILOT_OBSTACLE_DETECTED_IN_DRIVING_DIRECTION_DRIVING_DIRECTION_WILL_CHANGE_ACTIVATE_DEAD_MAN_SWITCH_TO_CONTINUE = 100;
    public static final int IPA_PARKING_PILOT_RELEASE_BRAKE_TO_MAKE_CAR_MOVING_LOOK_SAFE_TO_MOVE = 101;
    public static final int IPA_PARKING_PILOT_REDUCING_SPEED = 102;
    public static final int IPA_PARKING_PILOT_CURBLIFTING_UNSUCCESSFUL_NEXT_TRY = 103;
    public static final int IPA_PARKING_PILOT_CANCELED_OBSTACLE_CAN_NOT_BE_OVERDRIVEN_PRESS_BRAKE_TAKE_OVER = 104;
    public static final int IPA_PARKING_PILOT_PP_STILL_NOT_POSSIBLE_CLOSE_DOOR_AND_PRESS_DEADMAN_SWITCH_TO_CONTINUE_PARKING_LOOK_SAFE_TO_MOVE = 105;
    public static final int IPA_PARKING_PILOT_PP_POSSIBLE_LEAVE_CAR_TO_PROCEED_PARKING_LOOK_SAFE_TO_MOVE = 106;
    public static final int IPA_PARKING_PILOT_PLA_POSSIBLE_ONLY_STEERING_INTERVENTION_MANUALLY_CHANGE_GEAR_BRAKE_AND_ACCELERATE_ENGAGE_RGEAR = 107;
    public static final int IPA_PARKING_PILOT_NOT_AVAILABLE_RIGHT_CAMERA_POLLUTED = 108;
    public static final int IPA_PARKING_PILOT_NOT_AVAILABLE_LEFT_CAMERA_POLLUTED = 109;
    public static final int IPA_PARKING_PILOT_NOT_AVAILABLE_FRONT_CAMERA_POLLUTED = 110;
    public static final int IPA_PARKING_PILOT_NOT_AVAILABLE_REAR_CAMERA_POLLUTED = 111;
    public static final int IPA_PARKING_PILOT_PARKING_IN_FINISHED_PRESS_BRAKE_TAKE_OVER = 112;
    public static final int IPA_PARKING_PILOT_PARKING_OUT_FINISHED_TAKE_OVER_CONTINUE_DRIVING = 113;
    public static final int IPA_PP_PARKING_PILOT_PP_ACTIVE_CAR_CAN_ONLY_BE_CONTROLLED_FROM_OUTSIDE = 114;
    public static final int IPA_PP_PARKING_PILOT_AUTHORISATION_ERROR_RETRY_AUTORISATION = 115;
    public static final int IPA_PP_PARKING_PILOT_PRESS_BRAKE_PRESS_SWITCH_UNTIL_PARKING_IS_FINISHED_OR_LEAVE_CAR_FOR_PPR = 116;
    public static final int IPA_PP_PARKING_PILOT_LEAVE_CAR_FOR_PP = 117;
    public static final int IPA_PP_PARKING_PILOT_TO_START_PRESS_DEAD_MAN_SWITCH = 118;
    public static final int IPA_PP_PARKING_PILOT_PARK_IN_IS_ACTIVE_STEERING_INTERVENTION_ACTIV_LOOK_SAFE_TO_MOVE = 119;
    public static final int IPA_PP_PARKING_PILOT_PARK_OUT_IS_ACTIVE_STEERING_INTERVENTION_ACTIVE_LOOK_SAFE_TO_MOVE = 120;
    public static final int IPA_PP_PARKING_PILOT_PARK_OUT_ACTIVE_LOOK_SAFE_TO_MOVE = 121;
    public static final int IPA_PP_PARKING_PILOT_GP_IN_FRONT_SELECTED_TO_START_PRESS_SWITCH = 122;
    public static final int IPA_PP_PARKING_PILOT_GP_OUT_SELECTED_TO_START_PRESS_SWITCH = 123;
    public static final int IPA_PP_PARKING_PILOT_GP_SELECTED_LEAVE_CAR_START_PARKING_FROM_OUTSIDE_PLEASE_DO_NOT_BOX_OTHER_CARS = 124;
    public static final int IPA_PP_PARKING_PILOT_PARK_OUT_ACTIVE_DRIVING_DIRECTION_FORWARD = 125;
    public static final int IPA_PP_PARKING_PILOT_PARK_OUT_ACTIVE_DRIVING_DIRECTION_WILL_CHANGE = 126;
    public static final int IPA_PP_PARKING_PILOT_PARK_OUT_ACTIVE_DRIVING_DIRECTION_BACKWARD = 127;
    public static final int IPA_PP_PARKING_PILOT_PARK_IN_ACTIVE_DRIVING_DIRECTION_WILL_CHANGE = 128;
    public static final int IPA_PP_PARKING_PILOT_PARK_IN_DRIVING_DIRECTION_BACKWARD = 129;
    public static final int IPA_PP_PARKING_PILOT_OBSTACLE_IN_MANEUVER_AREA_PARK_OUT_MANUALLY_TAKE_OVER = 130;
    public static final int IPA_PP_PARKING_PILOT_AUTHORISATION_ERROR_FUNCTION_STOPPED_TAKE_OVER = 131;
    public static final int IPA_PP_PARKING_PILOT_DEAD_MAN_SWITCH_RELEASED_PLEASE_PRESS_SWITCH_CONTINOUSLY = 132;
    public static final int IPA_PP_PARKING_PILOT_CAR_HAS_LEFT_THE_PERMITTED_RADIO_RANGE_PLEASE_FOLLOW_THE_CAR = 133;
    public static final int IPA_PP_PARKING_PILOT_CAR_IS_LEAVING_THE_PERMITTED_RADIO_RANGE_PLEASE_FOLLOW_THE_CAR = 134;
    public static final int IPA_PP_PARKING_PILOT_PP_IS_ACTIVE_CAR_WITHIN_THE_PERMITTED_RADIO_RANGE = 135;
    public static final int IPA_PP_PARKING_PILOT_PP_IS_ACTIVE_CAR_IS_LEAVING_THE_PERMITTED_RADIO_RANGE = 136;
    public static final int IPA_PP_PARKING_PILOT_PP_CANCELED_CAR_HAS_LEFT_THE_PERMITTED_RADIO_RANGE = 137;
    public static final int IPA_PP_PARKING_PILOT_FUNCTION_COMPLETED = 138;
    public static final int IPA_PP_PARKING_PILOT_UNDO_LAST_MANEUVER_MOVEMENT = 139;
    public static final int IPA_PP_PARKING_PILOT_PP_CANCELED = 140;
    public static final int IPA_PP_PARKING_PILOT_PARKING_FINISHED_MANUALLY = 141;
    public static final int IPA_PP_PARKING_PILOT_PARK_IN_FINISHED_CAR_WILL_BE_LOCKED_EPB_ACTIVE_MOTOR_OFF = 142;
    public static final int IPA_PP_PARKING_PILOT_PARK_OUT_FINISHED_PLEASE_ENTER_CAR_TAKE_OVER = 143;
    public static final int PDCMANEUVERASSISTMESSAGES_NO_MESSAGE = 0;
    public static final int PDCMANEUVERASSISTMESSAGES_EMERGENCY_BRAKE = 1;
    public static final int PDCMANEUVERASSISTMESSAGES_SYSTEM_ERROR = 2;
    public static final int PDCMANEUVERASSISTMESSAGES_TEMP_NOT_AVAILABLE = 3;
    public static final int PDCMANEUVERASSISTMESSAGES_TEMP_OFF = 4;
    public static final int PDCMANEUVERASSISTMESSAGES_OFF = 5;
    public static final int PDCMANEUVERASSISTMESSAGES_ON = 6;
    public static final int PDCMESSAGES_NO_MESSAGE = 0;
    public static final int PDCMESSAGES_STEERINGASSIST_ACTIVE_SLOW_DOWN_AND_BRAKE = 1;
    public static final int PDCMESSAGES_PARKINGASSIST_CANCELED_STEERING_INTERVENTION_OF_DRIVER_ASSUME_STEERING = 2;
    public static final int PDCMESSAGES_PARKINGASSIST_CANCELED_SPEED_TO_HIGH = 3;
    public static final int PDCMESSAGES_PARKINGASSIST_COMPLETED_ASSUME_CONTROL = 4;
    public static final int PDCMESSAGES_PARKINGASSIST_CANCELED_ASSUME_STEERING = 5;
    public static final int PDCMESSAGES_PARKINGASSIST_SYSTEM_ERROR_ASSUME_STEERING_CONTACT_SERVICE_CENTER = 6;
    public static final int PDCMESSAGES_PARKINGASSIST_TEMPORARY_NOT_AVAILABLE_ASSUME_STEERING = 7;
    public static final int PDCMESSAGES_PARKINGASSIST_CANCELED_ESP_INTERVENTION_ASSUME_STEERING = 8;
    public static final int PDCMESSAGES_PARKINGASSIST_CANCELED_TIME_LIMIT_EXCEEDED_ASSUME_STEERING = 9;
    public static final int PDCMESSAGES_PARKINGASSIST_CANCELED_PARKING_NOT_POSSIBLE_ASSUME_STEERING = 10;
    public static final int PDCMESSAGES_PARKINGASSIST_COMPLETED = 11;
    public static final int PDCMESSAGES_PARKINGASSIST_TEMPORARY_NOT_AVAILABLE = 12;
    public static final int PDCMESSAGES_PARKINGASSIST_SYSTEM_ERROR_CONTACT_SERVICE_CENTER = 13;
    public static final int PDCMESSAGES_PARKINGASSIST_PARK_OUT_NOT_POSSIBLE_PARKING_SLOT_TO_SMALL = 14;
    public static final int PDCMESSAGES_FOR_PARKING_OUT_SELECT_DIRECTION_USING_TURN_INDICATOR = 15;
    public static final int PDCMESSAGES_START_AUTOMATIC_PARKING_OUT = 16;
    public static final int PDCMESSAGES_PARKINGASSIST_COMPLETED_ASSUME_STEERING_AND_CONTINUE_DRIVING = 17;
    public static final int PDCMESSAGES_PARKINGASSIST_SPEED_TO_HIGH = 18;
    public static final int PDCMESSAGES_PARKINGASSIST_ESP_INTERVENTION_CONTINUE_DRIVING = 19;
    public static final int PDCMESSAGES_PARKINGASSIST_TIME_LIMIT_EXCEEDED_CONTINUE_DRIVING = 20;
    public static final int PDCMESSAGES_PARKINGASSIST_NOT_POSSIBLE_IF_TRAILER_HITCHED = 21;
    public static final int PDCMESSAGES_PARKINGASSIST_STANDSTILL_TIME_NOT_LONG_ENOUGH = 22;
    public static final int PDCMESSAGES_PARKINGASSIST_CANCELED_PARKING_NOT_POSSIBLE = 23;
    public static final int PDCMESSAGES_SPEED_ICON = 24;
    public static final int PDCMESSAGES_LIMITED_SPEED_BRAKE = 25;
    public static final int PDCMESSAGES_TO_RESUME_PRESS_PARKING_BUTTON_AGAIN = 26;
    public static final int PDCMESSAGES_OPERATION_DURING_STEERINGWHEEL_INTERVENTION_IS_ACTIVE_NOT_POSSIBLE = 27;
    public static final int PDCMESSAGES_PARKING_SYSTEM_SYSTEM_ERROR_CONTACT_SERVICE_CENTER = 28;
    public static final int PDCMESSAGES_PARKING_SYSTEM_TEMPORARY_NOT_AVAILABLE_NO_SENSOR_DATA = 29;
    public static final int PDCMESSAGES_PARKING_ASSIST_TEMPORARY_NOT_AVAILABLE_ESP_OFF = 30;
    public static final int PDCMESSAGES_PARKING_ASSIST_SHIFT_TO_R_GEAR = 31;
    public static final int PDCMESSAGES_PARKING_ASSIST_SHIFT_TO_FORWARD_GEAR = 32;
    public static final int PDCMESSAGES_PARKING_ASSIST_POSOK_SHIFT_TO_R_GEAR = 33;
    public static final int PDCMESSAGES_PARKING_ASSIST_POSOK_STOP = 34;
    public static final int PDCMESSAGES_PARKING_ASSIST_POSOK_NOT_REACHED_GO_ON = 35;
    public static final int PDCMESSAGES_PARKING_ASSIST_NOT_AVAILABLE_IN_OFFROADMODE = 36;
    public static final int PDCMESSAGES_PARKING_ASSIST_CANCELED_NOT_AVAILABLE_IN_OFFROADMODE = 37;
    public static final int PDCMESSAGES_PARKING_ASSIST_CANCELED_OBSTACLE_DETECTED_ASSUME_STEERING = 38;
    public static final int PDCMESSAGES_PARKING_ASSIST_DRIVING_FORWARD_AND_BRAKE_BY_YOURSELF = 39;
    public static final int PDCMESSAGES_PARKING_ASSIST_DRIVING_BACKWARD_AND_BRAKE_BY_YOURSELF = 40;
    public static final int PDCMESSAGES_START_AUTOMATIC_PARKING_IN = 41;
    public static final int PDCPLASTATUS_IDLE = 0;
    public static final int PDCPLASTATUS_SEARCH_MODE_ACTIVE = 1;
    public static final int PDCPLASTATUS_PARK_IN_MODE_SELECTION_ACTIVE = 2;
    public static final int PDCPLASTATUS_PARK_OUT_MODE_SELECTION_ACTIVE = 3;
    public static final int PDCPLASTATUS_PARK_IN_ACTIVE = 4;
    public static final int PDCPLASTATUS_PARK_OUT_ACTIVE = 5;
    public static final int PDCPLASTATUS_PLA_STANDBY = 6;
    public static final int PDCPLASTATUS_PLA_RESUME = 7;
    public static final int PDCPLASTATUS_PP_PARK_IN_ACTIVE = 8;
    public static final int PDCPLASTATUS_PP_PARK_OUT_ACTIVE = 9;
    public static final int PDCPLASTATUS_GP_PARK_IN_SELECTION_ACTIVE = 10;
    public static final int PDCPLASTATUS_GP_PARK_IN_ACTIVE = 11;
    public static final int PDCPLASTATUS_GP_PARK_OUT_ACTIVE = 12;
    public static final int PDCPLADRIVINGDIRECTION_NO_DIRECTION = 0;
    public static final int PDCPLADRIVINGDIRECTION_PLA_POS_OK = 1;
    public static final int PDCPLADRIVINGDIRECTION_IPA_POS_OK = 2;
    public static final int PDCPLADRIVINGDIRECTION_FORWARD = 3;
    public static final int PDCPLADRIVINGDIRECTION_BACKWARD = 4;
    public static final int PDCPLADRIVINGDIRECTION_IPA_PP_POS_OK = 5;
    public static final int PDCPLADRIVINGDIRECTION_GP_POS_OK = 6;
    public static final int PDCPLAPRESELECTION_NO_PRESELECTION = 0;
    public static final int PDCPLAPRESELECTION_BACKWARD_PARKBOX_LEFT = 1;
    public static final int PDCPLAPRESELECTION_BACKWARD_PARKBOX_RIGHT = 2;
    public static final int PDCPLAPRESELECTION_FORWARD_PARKBOX_LEFT = 3;
    public static final int PDCPLAPRESELECTION_FORWARD_PARKBOX_RIGHT = 4;
    public static final int PDCPLAPRESELECTION_BACKWARD_PARALLEL_TO_ROAD_LEFT = 5;
    public static final int PDCPLAPRESELECTION_BACKWARD_PARALLEL_TO_ROAD_RIGHT = 6;
    public static final int PDCPLAPRESELECTION_FORWARD_PARKBOX_MIDDLE = 7;
    public static final int PDCPLAARROWINDICATION_NOT_DISPLAYED = 0;
    public static final int PDCPLAARROWINDICATION_DISPLAYED = 1;
    public static final int PDCPLAARROWINDICATION_INIT = 15;
    public static final int PDCPLAPARKMODES_PARK_IN_BACKWARD_PARKBOX_LEFT = 0;
    public static final int PDCPLAPARKMODES_PARK_IN_BACKWARD_PARKBOX_RIGHT = 1;
    public static final int PDCPLAPARKMODES_PARK_IN_FORWARD_PARKBOX_LEFT = 2;
    public static final int PDCPLAPARKMODES_PARK_IN_FORWARD_PARKBOX_RIGHT = 3;
    public static final int PDCPLAPARKMODES_PARK_IN_BACKWARD_PARALLEL_TO_ROAD_LEFT = 4;
    public static final int PDCPLAPARKMODES_PARK_IN_BACKWARD_PARALLEL_TO_ROAD_RIGHT = 5;
    public static final int PDCPLAPARKMODES_PARK_OUT_BACKWARD_PARKBOX_LEFT = 6;
    public static final int PDCPLAPARKMODES_PARK_OUT_BACKWARD_PARKBOX_RIGHT = 7;
    public static final int PDCPLAPARKMODES_PARK_OUT_FORWARD_PARKBOX_LEFT = 8;
    public static final int PDCPLAPARKMODES_PARK_OUT_FORWARD_PARKBOX_RIGHT = 9;
    public static final int PDCPLAPARKMODES_PARK_OUT_BACKWARD_PARALLEL_TO_ROAD_LEFT = 10;
    public static final int PDCPLAPARKMODES_PARK_OUT_BACKWARD_PARALLEL_TO_ROAD_RIGHT = 11;
    public static final int PDCPLAPARKMODES_PARK_IN_FORWARD_PARKBOX_MIDDLE = 12;
    public static final int PDCPLAPARKMODES_PARK_OUT_FORWARD_PARKBOX_STRAIGHT = 13;
    public static final int PDCPLAPARKMODES_PARK_OUT_BACKWARD_PARKBOX_STRAIGHT = 14;
    public static final int PDCPLAPARKMODES_NO_PARKMODE_SELECTED = 255;
    public static final int PDCOPSVISUALISATIONPOSITION_LEFT = 0;
    public static final int PDCOPSVISUALISATIONPOSITION_RIGHT = 1;
    public static final int VPSSCREEN_NOSCREEN = 0;
    public static final int VPSSCREEN_FULLSCREEN = 1;
    public static final int VPSSCREEN_SPLITSCREEN = 2;
    public static final int VPSSCREEN_LEGALSCREEN = 3;
    public static final int VPSSCREEN_LASTSCREEN = 15;
    public static final int VPSMODE_NOMODE = 0;
    public static final int VPSMODE_PARKBOX = 1;
    public static final int VPSMODE_PARALLELTOROAD = 2;
    public static final int VPSMODE_OFFROAD = 3;
    public static final int VPSMODE_RIGHTSIDEVIEW = 4;
    public static final int VPSMODE_LEFTSIDEVIEW = 5;
    public static final int VPSMODE_LEFTRIGHTSIDEVIEW = 6;
    public static final int VPSMODE_CROSSING = 7;
    public static final int VPSMODE_TRAILERASSIST = 8;
    public static final int VPSMODE_BIRDVIEW = 9;
    public static final int VPSMODE_ONLYSIDEVIEW = 10;
    public static final int VPSMODE_3DBIRDVIEW = 11;
    public static final int VPSMODE_TRAILERASSIST_ARA = 12;
    public static final int VPSMODE_OFFROAD_KOG = 13;
    public static final int VPSMODE_LASTMODE = 15;
    public static final int VPSDEFAULTVIEW_REARVIEW = 1;
    public static final int VPSDEFAULTVIEW_FRONTVIEW = 2;
    public static final int VPSDEFAULTVIEW_SIDEVIEW = 3;
    public static final int VPSDEFAULTVIEW_BIRDVIEW = 4;
    public static final int VPSDEFAULTVIEW_AUTO = 5;
    public static final int VPSDEFAULTVIEW_EXTCAM = 6;
    public static final int VPSDEFAULTVIEW_LASTVIEW = 15;
    public static final int VPSDEFAULTVIEW_UNKNOWN = 255;
    public static final int VPSCURRENTVIEW_NOVIEW = 0;
    public static final int VPSCURRENTVIEW_REARVIEW = 1;
    public static final int VPSCURRENTVIEW_FRONTVIEW = 2;
    public static final int VPSCURRENTVIEW_SIDEVIEW = 3;
    public static final int VPSCURRENTVIEW_BIRDVIEW = 4;
    public static final int VPSCURRENTVIEW_EXTCAM = 6;
    public static final int VPSCAMERASTATE_OK = 0;
    public static final int VPSCAMERASTATE_DEFECT = 1;
    public static final int VPSCAMERASTATE_TEMPNOTAVAILABLE = 2;
    public static final int VPSCAMERASTATE_SPEEDTOHIGH = 3;
    public static final int VPSCAMERASTATE_NOTCALIBRATED = 4;
    public static final int VPSCAMERASTATE_TRAILERHITCHED = 5;
    public static final int VPSCAMERASTATE_EXTMIRROR_FOLDED = 6;
    public static final int VPSCAMERASTATE_TRUNKOPEN = 7;
    public static final int VPSCAMERASTATE_ENGINEHOOD_OPEN = 8;
    public static final int VPSCAMERASTATE_FRONTDOOR_OPEN = 9;
    public static final int VPSCAMERASTATE_REARDOOR_OPEN = 10;
    public static final int VPSCAMERASTATE_FRONT_AND_REARDOOR_OPEN = 11;
    public static final int VPSCAMERASTATE_FRONTDOOR_OPEN_AND_EXTMIRROR_FOLDED = 12;
    public static final int VPSCAMERASTATE_REARDOOR_OPEN_AND_EXTMIRROR_FOLDED = 13;
    public static final int VPSCAMERASTATE_FRONT_AND_REARDOOR_OPEN_AND_EXTMIRROR_FOLDED = 14;
    public static final int VPSCAMERASTATE_NOTEXISTING = 255;
    public static final int VPSEXTCAMCONFIG_NONE = 0;
    public static final int VPSEXTCAMCONFIG_REARCAMERA = 1;
    public static final int VPSEXTCAMCONFIG_INTERIORCAMERA = 2;
    public static final int VPSRIMPROTECTIONTIRESTATE_NO_WARNING = 0;
    public static final int VPSRIMPROTECTIONTIRESTATE_LOW_WARNING = 1;
    public static final int VPSRIMPROTECTIONTIRESTATE_HIGH_WARNING = 2;
    public static final int VPSRIMPROTECTIONTIRESTATE_NOT_DISPLAYED = 14;
    public static final int VPSRIMPROTECTIONTIRESTATE_NOT_AVAILABLE = 15;
    public static final int ARAMESSAGES_NO_WARNING_TIP = 0;
    public static final int ARAMESSAGES_STEERING_ASSIST_IS_ACTIVE_BRAKING_BY_YOURSELF = 1;
    public static final int ARAMESSAGES_TRAILER_ASSIST_IS_TEMP_NOT_AVAILABLE = 2;
    public static final int ARAMESSAGES_TRAILER_ASSIST_IS_FINISHED = 3;
    public static final int ARAMESSAGES_STEERING_INTERVENTION_BY_DRIVER_EMERGENCY_BRAKE_IS_ACTIVE = 4;
    public static final int ARAMESSAGES_STABILITY_CONTROL_EMERGENCY_BRAKE_IS_ACTIVE = 5;
    public static final int ARAMESSAGES_MAXIMUM_ANGLE_IS_EXCEEDED_EMERGENCY_BRAKE_IS_ACTIVE = 6;
    public static final int ARAMESSAGES_SYSTEM_ERROR_EMERGENCY_BRAKE_IS_ACTIVE = 7;
    public static final int ARAMESSAGES_SYSTEM_ERROR_CONTACT_SERVICE_DEPARTMENT = 8;
    public static final int ARAMESSAGES_PRESS_BRAKE_TO_RELEASE_PARKING_BRAKE = 9;
    public static final int ARAMESSAGES_TRAILER_DETECTION_IS_NOT_FINISHED_MOVE_TRAILER_STRAIGHT_FORWARD = 10;
    public static final int ARAMESSAGES_TRAILER_DETECTION_IS_NOT_FINISHED_REDUCED_FUNCTIONALITY = 11;
    public static final int ARAMESSAGES_PARK_ASSIST_IS_NOT_FUNCTIONAL_BY_RACK_ON_TRAILER_TOW_HITCH = 12;
    public static final int ARAMESSAGES_TRAILER_ASSIST_IS_NOT_AVAILABLE_BY_RACK_ON_TRAILER_TOW_HITCH = 13;
    public static final int ARAMESSAGES_TRAILER_ASSIST_IS_ABORTED_TRAILER_IS_NOT_DETECTED_EMERGENCY_BRAKE_IS_ACTIVE = 14;
    public static final int ARAMESSAGES_TRAILER_ASSIST_IS_ABORTED_TRAILER_IS_NOT_DETECTED = 15;
    public static final int ARAMESSAGES_TRAILER_ASSIST_IS_ABORTED_TRAILER_IS_NOT_DETECTED_RESUME_STEERING = 16;
    public static final int ARAMESSAGES_STANDSTILL_TO_ACTIVATE_TRAILER_ASSIST = 17;
    public static final int ARAMESSAGES_DURING_AUTOMATIC_STEERING_THE_ACTIVITY_IS_NOT_AVAILABLE = 18;
    public static final int ARAMESSAGES_STANDSTILL_IS_NOT_LONG_ENOUGH = 19;
    public static final int ARAMESSAGES_SYSTEM_ERROR_BRAKING_BY_YOURSELF = 20;
    public static final int ARAMESSAGES_ACTIVATION_TRAILERASSIST_PRESS_PLA_BUTTON = 21;
    public static final int ARAMESSAGES_PARKING_ASSIST_TEMP_NOT_AVAILABLE_ESP_OFF = 22;
    public static final int PDCMANEUVERASSISTCONFIGMODE_NOTACTIVE = 0;
    public static final int PDCMANEUVERASSISTCONFIGMODE_ACTIVE = 1;
    public static final int PDCMANEUVERASSISTCONFIGMODE_ACTIVE_BRAKING = 1;
    public static final int PDCMANEUVERASSISTCONFIGMODE_ACTIVE_STEERING = 2;
    public static final int PDCMANEUVERASSISTCONFIGMODE_ACTIVE_BRAKING_STEERING = 3;
    public static final int PDCCONTINUEDRIVINGASSISTMODE_OFF = 0;
    public static final int PDCCONTINUEDRIVINGASSISTMODE_ON = 1;
    public static final int PDCCONTINUEDRIVINGASSISTMODE_EARLY = 2;
    public static final int PDCCONTINUEDRIVINGASSISTMODE_MEDIUM = 3;
    public static final int PDCCONTINUEDRIVINGASSISTMODE_LATE = 4;
    public static final int PDCIPACONFIG_SLOW = 0;
    public static final int PDCIPACONFIG_MEDIUM = 1;
    public static final int PDCIPACONFIG_FAST = 2;
    public static final int WCPOPUPCONTENT_NONE = 0;
    public static final int WCPOPUPCONTENT_PANELPOSITION = 1;
    public static final int WCMESSAGE_NO_MESSAGE = 0;
    public static final int WCMESSAGE_NO_CHARGING_AUTORISATION = 1;
    public static final int WCMESSAGE_INFRASTRUCTURE_INCOMPATIBLE = 2;
    public static final int WCMESSAGE_METAL_DETECTION_ON_BASE_PANEL = 3;
    public static final int WCMESSAGE_POSITIONING_SUCCESSFUL = 4;
    public static final int WCMESSAGE_ERROR_ON_VEHICLE_PANEL = 5;
    public static final int WCMESSAGE_ERROR_ON_BASE_PANEL = 6;
    public static final int WCMESSAGE_TEMP_NOT_AVAILABLE = 7;
    public static final int WCMESSAGE_WAITING_START_AGAIN = 8;
    public static final int WCMESSAGE_TEMPERATURE_ERROR = 9;
    public static final int WCMESSAGE_VEHICLE_FLOOR_MODIFIED = 10;
    public static final int WCMESSAGE_ERROR_POWER_SUPPLY = 11;
    public static final int WCMESSAGE_ERROR_POWER_SUPPLY_CONTACT_ELECTRICIAN = 12;
    public static final int WCMESSAGE_MOVE_DOWN_VEHICLE = 13;
    public static final int WCMESSAGE_MOVE_VEHICLE_PANEL_CONGRUENT_WITH_BASE_PANEL = 14;
    public static final int WCMESSAGE_VEHICLE_PANEL_NOT_CONGRUENT_WITH_BASE_PANEL = 15;
    public static final int WCMESSAGE_ZMOVER_ERROR = 16;
    public static final int WCMESSAGE_SOFTWARE_UPDATE_ACTIVE = 17;
    public static final int WCMESSAGE_RESIDUAL_CURRENT_DEVICE_ACTIVE = 18;
    public static final int WCPANELSTATE_INIT_NO_PANEL = 0;
    public static final int WCPANELSTATE_PANEL_FOUND_POS_NOT_REACHED = 1;
    public static final int WCPANELSTATE_PANEL_FOUND_POS_REACHED_ZMOVER_DOWN = 2;
    public static final int WCPANELSTATE_PANEL_FOUND_POS_REACHED_ZMOVER_MOVING = 3;
    public static final int WCPANELSTATE_PANEL_FOUND_POS_REACHED_ZMOVER_UP = 4;
    public static final int WCPANELSTATE_ERROR_ON_BASE_PANEL = 5;
    public static final int WCPANELSTATE_ERROR_ON_VEHICLE_PANEL = 6;
    public static final int WCPANELINFO_NO_INFO = 0;
    public static final int WCPANELINFO_NOT_CONNECTED = 1;
    public static final int WCPANELINFO_CONNECTED = 2;
    public static final int WCPANELINFO_WRONG_PIN = 3;
    public static final int WCPANELINFO_PANEL_NOT_COMPATIBLE = 4;
    public static final int WCPANELINFO_METALL_DETECTION = 5;
    public static final int WCPANELINFO_ERROR_VEHICLE_PANEL = 6;
    public static final int WCPANELINFO_PANEL_SYSTEM_ERROR = 7;
    public static final int WCPANELINFO_TEMP_PANEL_ERROR = 8;
    public static final int WCPANELINFO_PLAY_PROTECTION = 9;
    public static final int WCPANELINFO_TEMPERATURE_ERROR = 10;
    public static final int WCPANELINFO_UNDERSURFACE_MODIFIED = 11;
    public static final int WCPANELINFO_POWER_SUPPLY_ERROR = 12;
    public static final int WCPANELINFO_POWER_SUPPLY_ERROR_CONTACT_SERVICE = 13;
    public static final int WCPANELINFO_RESIDUAL_CURRENT_DEVICE_ACTIVE = 14;
    public static final int WCPANELINFO_UNKNOWN = 255;
    public static final int WCPINPUKSTATE_NOT_LOCKED = 0;
    public static final int WCPINPUKSTATE_LOCKED_ENTER_PINPUK = 1;
    public static final int WCPINPUKSTATE_LOCKED_ENTER_PIN = 2;
    public static final int WCPINPUKSTATE_LOCKED_ENTER_PUK = 3;
    public static final int WCPINPUKSTATE_LOCKED_WRONG_PINPUK = 4;
    public static final int WCPINPUKSTATE_LOCKED_WRONG_PIN = 5;
    public static final int WCPINPUKSTATE_LOCKED_WRONG_PUK = 6;
    public static final int WCPINPUKSTATE_UNKNOWN = 255;
    public static final int WCENTERPINPUKRESULT_SUCCESSFUL = 0;
    public static final int WCENTERPINPUKRESULT_ABORT_SUCCESSFUL = 1;
    public static final int WCENTERPINPUKRESULT_ABORT_NOT_SUCCESSFUL = 240;
    public static final int WCENTERPINPUKRESULT_NOT_SUCCESSFUL = 241;
    public static final int WCENTERPINPUKRESULT_NOT_SUCCESSFUL_WRONG_PINPUK = 242;
    public static final int WCSCANNINGRESULT_SUCCESSFUL = 0;
    public static final int WCSCANNINGRESULT_ABORT_SUCCESSFUL = 1;
    public static final int WCSCANNINGRESULT_ABORT_NOT_SUCCESSFUL = 240;
    public static final int WCSCANNINGRESULT_NOT_SUCCESSFUL = 241;
    public static final int WCSCANNINGRESULT_NOT_SUCCESSFUL_NO_PANELS_FOUND = 242;
    public static final int WCPAIRINGRESULT_SUCCESSFUL = 0;
    public static final int WCPAIRINGRESULT_ABORT_SUCCESSFUL = 1;
    public static final int WCPAIRINGRESULT_ABORT_NOT_SUCCESSFUL = 240;
    public static final int WCPAIRINGRESULT_NOT_SUCCESSFUL = 241;
    public static final int WCPAIRINGRESULT_NOT_SUCCESSFUL_WRONG_PINPUK = 242;
    public static final int WCSOFTWAREUPDATERESULT_SUCCESSFUL = 0;
    public static final int WCSOFTWAREUPDATERESULT_ABORT_SUCCESSFUL = 1;
    public static final int WCSOFTWAREUPDATERESULT_ABORT_NOT_SUCCESSFUL = 240;
    public static final int WCSOFTWAREUPDATERESULT_NOT_SUCCESSFUL = 241;
    public static final int WCSOFTWAREUPDATERESULT_NOT_SUCCESSFUL_WRONG_PUK = 242;
    public static final int WCSOFTWAREUPDATERESULT_NOT_SUCCESSFUL_ABORTED = 243;
    public static final int WCCHANGEPINRESULT_SUCCESSFUL = 0;
    public static final int WCCHANGEPINRESULT_ABORT_SUCCESSFUL = 1;
    public static final int WCCHANGEPINRESULT_ABORT_NOT_SUCCESSFUL = 240;
    public static final int WCCHANGEPINRESULT_NOT_SUCCESSFUL = 241;
    public static final int WCCHANGEPANELNAMERESULT_SUCCESSFUL = 0;
    public static final int WCCHANGEPANELNAMERESULT_ABORT_SUCCESSFUL = 1;
    public static final int WCCHANGEPANELNAMERESULT_ABORT_NOT_SUCCESSFUL = 240;
    public static final int WCCHANGEPANELNAMERESULT_NOT_SUCCESSFUL = 241;
    public static final int PANELLISTRACONTENT_POS = 1;
    public static final int PANELLISTRACONTENT_SERIALNUMBER = 2;
    public static final int PANELLISTRACONTENT_NAME = 4;
    public static final int PANELLISTRACONTENT_PIN = 8;
    public static final int PANELLISTRACONTENT_SOFTWARE = 16;
    public static final int PANELLISTRACONTENT_HARDWARE = 32;
    public static final int PANELLISTRACONTENT_STATES = 64;
    public static final int PANELLISTRACONTENT_INFO = 128;
    public static final int RT_SETHMISTATEISREADY = 1000;
    public static final int RT_SETPDCDEFAULTPARKINGMODE = 1001;
    public static final int RT_SETPDCMUTE = 1002;
    public static final int RT_SETPDCFREQUENCEFRONT = 1003;
    public static final int RT_SETPDCFREQUENCEREAR = 1004;
    public static final int RT_SETPDCVOLUMEFRONT = 1005;
    public static final int RT_SETPDCVOLUMEREAR = 1006;
    public static final int RT_SETPDCAUTOACTIVATION = 1007;
    public static final int RT_SETPDCSYSTEMONOFF = 1008;
    public static final int RT_SETPDCFREQUENCERIGHT = 1024;
    public static final int RT_SETPDCFREQUENCELEFT = 1025;
    public static final int RT_SETPDCVOLUMERIGHT = 1026;
    public static final int RT_SETPDCVOLUMELEFT = 1027;
    public static final int RT_SETPDCFLANKGUARD = 1028;
    public static final int RT_SETPDCSOUNDREPRODUCTION = 1029;
    public static final int RT_SETPDCSETFACTORYDEFAULT = 1031;
    public static final int RT_SETPDCSOUNDFRONT = 1034;
    public static final int RT_SETPDCSOUNDREAR = 1035;
    public static final int RT_SETPDCSOUNDLEFT = 1036;
    public static final int RT_SETPDCSOUNDRIGHT = 1037;
    public static final int RT_SETPDCPLAPRESELECTION = 1038;
    public static final int RT_SETPDCPLAPARKMODE = 1039;
    public static final int RT_SETPDCPLASYSTEMSTATE = 1040;
    public static final int RT_SETPDCOFFROADMODE = 1041;
    public static final int RT_SETPDCVISUALISATIONPARKBOX = 1042;
    public static final int RT_SETPDCOPSVISUALISATIONPOSITION = 1043;
    public static final int RT_SETPDCMANEUVERASSISTCONFIG = 1048;
    public static final int RT_SETPDCMANEUVERASSIST = 1049;
    public static final int RT_SETPDCCONTINUEDRIVINGASSIST = 1051;
    public static final int RT_SETPDCIPACONFIG = 1052;
    public static final int RT_SETPDCPILOPASYSTEMSTATE = 1053;
    public static final int RT_SETVPSFOLLOWUPTIME = 1010;
    public static final int RT_SETVPSCOLOR = 1011;
    public static final int RT_SETVPSCONTRAST = 1012;
    public static final int RT_SETVPSBRIGHTNESS = 1013;
    public static final int RT_SETVPSDEFAULTMODERV = 1014;
    public static final int RT_SETVPSDEFAULTMODEFV = 1015;
    public static final int RT_SETVPSDEFAULTMODESV = 1016;
    public static final int RT_SETVPSDEFAULTMODEBV = 1017;
    public static final int RT_SETVPSDEFAULTVIEW = 1018;
    public static final int RT_SETVPSOPSOVERLAY = 1019;
    public static final int RT_SETVPSDYNAMICPARKINGMODE = 1020;
    public static final int RT_SETVPSSYSTEMONOFF = 1021;
    public static final int RT_SETVPSSETFACTORYDEFAULT = 1032;
    public static final int RT_SETVPSEXTCAMCONFIG = 1044;
    public static final int RT_SETVPSEXTCAMMANACTIVATION = 1045;
    public static final int RT_SETVPS3DBIRDVIEW = 1046;
    public static final int RT_SETVPSSYSTEMSTATE = 1047;
    public static final int RT_SETVPSCAMERACLEANING = 1050;
    public static final int RT_SHOWPARKINGPOPUP = 1022;
    public static final int RT_CANCELPARKINGPOPUP = 1023;
    public static final int RT_REQUESTLIFEMONITORING = 1030;
    public static final int RT_SETARATARGETTRAILERANGLE = 1033;
    public static final int RT_SETWCSYSTEMONOFF = 1060;
    public static final int RT_SETWCAUTOACTIVATION = 1061;
    public static final int RT_SETWCSETFACTORYDEFAULT = 1062;
    public static final int RT_SHOWWCPOPUP = 1063;
    public static final int RT_CANCELWCPOPUP = 1064;
    public static final int RT_REQUESTWCPANELLIST = 1066;
    public static final int RT_ENTERWCPINPUK = 1067;
    public static final int RT_ABORTWCENTERPINPUK = 1068;
    public static final int RT_STARTWCSCANNING = 1069;
    public static final int RT_ABORTWCSCANNING = 1070;
    public static final int RT_STARTWCPAIRING = 1071;
    public static final int RT_ABORTWCPAIRING = 1072;
    public static final int RT_STARTWCSOFTWAREUPDATE = 1073;
    public static final int RT_ABORTWCSOFTWAREUPDATE = 1074;
    public static final int RT_CHANGEWCPIN = 1075;
    public static final int RT_ABORTWCCHANGEPIN = 1076;
    public static final int RT_CHANGEWCPANELNAME = 1077;
    public static final int RT_ABORTWCCHANGEPANELNAME = 1078;
    public static final int RP_ACKNOWLEDGEPARKINGPOPUP = 2001;
    public static final int RP_ACKNOWLEDGEPDCSETFACTORYDEFAULT = 2003;
    public static final int RP_ACKNOWLEDGEVPSSETFACTORYDEFAULT = 2004;
    public static final int RP_ACKNOWLEDGEWCSETFACTORYDEFAULT = 2005;
    public static final int RP_ACKNOWLEDGEWCPOPUP = 2006;
    public static final int RP_ACKNOWLEDGEWCENTERPINPUK = 2007;
    public static final int RP_ACKNOWLEDGEWCSCANNING = 2008;
    public static final int RP_ACKNOWLEDGEWCPAIRING = 2009;
    public static final int RP_ACKNOWLEDGEWCSOFTWAREUPDATE = 2010;
    public static final int RP_ACKNOWLEDGEWCCHANGEPIN = 2011;
    public static final int RP_ACKNOWLEDGEWCCHANGEPANELNAME = 2012;
    public static final int IN_REQUESTPARKINGPOPUP = 3000;
    public static final int IN_RESPONSELIFEMONITORING = 3001;
    public static final int IN_REQUESTWCPOPUP = 3003;
    public static final int IN_RESPONSEWCPANELLIST = 3004;

    public void setHMIStateIsReady(boolean var1);

    public void setPDCDefaultParkingMode(int var1);

    public void setPDCMute(boolean var1);

    public void setPDCFrequenceFront(int var1);

    public void setPDCFrequenceRear(int var1);

    public void setPDCVolumeFront(int var1);

    public void setPDCVolumeRear(int var1);

    public void setPDCAutoActivation(boolean var1);

    public void setPDCSystemOnOff(boolean var1);

    public void setPDCFrequenceRight(int var1);

    public void setPDCFrequenceLeft(int var1);

    public void setPDCVolumeRight(int var1);

    public void setPDCVolumeLeft(int var1);

    public void setPDCFlankGuard(boolean var1);

    public void setPDCSoundReproduction(PDCSoundReproduction var1);

    public void setPDCSoundFront(PDCSound var1);

    public void setPDCSoundRear(PDCSound var1);

    public void setPDCSoundLeft(PDCSound var1);

    public void setPDCSoundRight(PDCSound var1);

    public void setPDCPLAPreSelection(int var1);

    public void setPDCPLAParkMode(int var1);

    public void setPDCPLASystemState(PDCPLASystemState var1);

    public void setPDCOffroadMode(boolean var1);

    public void setPDCVisualisationParkbox(boolean var1);

    public void setPDCOPSVisualisationPosition(int var1);

    public void setVPSFollowUpTime(int var1);

    public void setVPSColor(int var1);

    public void setVPSContrast(int var1);

    public void setVPSBrightness(int var1);

    public void setVPSDefaultModeRV(VPSDefaultMode var1);

    public void setVPSDefaultModeFV(VPSDefaultMode var1);

    public void setVPSDefaultModeSV(VPSDefaultMode var1);

    public void setVPSDefaultModeBV(VPSDefaultMode var1);

    public void setVPSDefaultView(int var1);

    public void setVPSOPSOverlay(VPSOPSOverlay var1);

    public void setVPSDynamicParkingMode(VPSDynParkingMode var1);

    public void setVPSSystemOnOff(boolean var1);

    public void setVPSExtCamConfig(int var1);

    public void setVPSExtCamManActivation(boolean var1);

    public void setVPS3DBirdview(int var1, int var2);

    public void setVPSSystemState(boolean var1);

    public void showParkingPopup(DisplayContent var1);

    public void cancelParkingPopup(DisplayContent var1, int var2);

    public void requestLifeMonitoring(boolean var1);

    public void setPdcSetFactoryDefault();

    public void setVpsSetFactoryDefault();

    public void setARATargetTrailerAngle(int var1);

    public void setPDCManeuverAssistConfig(int var1);

    public void setPDCManeuverAssist(boolean var1);

    public void setPDCContinueDrivingAssist(int var1);

    public void setPDCIpaConfig(int var1);

    public void setPDCPiloPaSystemState(PDCPiloPaSystemState var1);

    public void setVPSCameraCleaning(VPSCameraCleaning var1);

    public void setWCAutoActivation(boolean var1);

    public void setWCSystemOnOff(boolean var1);

    public void setWCSetFactoryDefault();

    public void showWCPopup(int var1);

    public void cancelWCPopup(int var1, int var2);

    public void requestWCPanelList(CarArrayListUpdateInfo var1);

    public void enterWCPinPuk(String var1, String var2);

    public void abortWCEnterPinPuk();

    public void startWCScanning();

    public void abortWCScanning();

    public void startWCPairing(String var1, String var2);

    public void abortWCPairing();

    public void startWCSoftwareUpdate(String var1);

    public void abortWCSoftwareUpdate();

    public void changeWCPin(String var1, String var2);

    public void abortWCChangePin();

    public void changeWCPanelName(String var1, String var2);

    public void abortWCChangePanelName();
}

