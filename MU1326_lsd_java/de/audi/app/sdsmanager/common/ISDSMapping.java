/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.sdsmanager.common;

import de.audi.atip.log.LogChannel;

public interface ISDSMapping {
    public static final byte COMMAND_MODE_DUMMY;
    public static final byte COMMAND_MODE_BIG_NAVI;
    public static final byte COMMAND_MODE_BIG_TUNER;
    public static final byte COMMAND_MODE_BIG_MEDIA;
    public static final byte COMMAND_MODE_BIG_PHONE;
    public static final byte COMMAND_MODE_BIG_MENU;
    public static final byte COMMAND_MODE_BIG_MAP;
    public static final byte COMMAND_MODE_BIG_ONLINE;
    public static final byte COMMAND_MODE_BIG_CAR;
    public static final byte COMMAND_MODE_BIG_SMS;
    public static final byte COMMAND_MODE_BIG_OFFICE;
    public static final byte COMMAND_MODE_BIG_ONLINE_PTT;
    public static final byte LIST_MODE_HELP_MEDIA;
    public static final byte LIST_MODE_HELP_MEDIA_TITLE_SELECT;
    public static final byte LIST_MODE_HELP_MEDIA_JUKEBOX_SD_USB;
    public static final byte LIST_MODE_HELP_MEDIA_IPOD;
    public static final byte LIST_MODE_HELP_MEDIA_DEVICE_CHANGE;
    public static final byte LIST_MODE_HELP_TUNER;
    public static final byte LIST_MODE_HELP_TUNER_STATION;
    public static final byte LIST_MODE_HELP_TUNER_DAB;
    public static final byte LIST_MODE_HELP_TUNER_SIRIUS;
    public static final byte LIST_MODE_HELP_NAVI;
    public static final byte LIST_MODE_HELP_NAVI_ENTER_DESTINATION;
    public static final byte LIST_MODE_HELP_NAVI_POI;
    public static final byte LIST_MODE_HELP_NAVI_ROUTE_INFORMATION;
    public static final byte LIST_MODE_HELP_PHONE;
    public static final byte LIST_MODE_HELP_PHONE_ADDRESSBOOK;
    public static final byte LIST_MODE_HELP_PHONE_DIAL_NUMBER;
    public static final byte LIST_MODE_HELP_CAR;
    public static final byte LIST_MODE_HELP_PHONE_NUMBER_SPELLER;
    public static final byte LIST_MODE_HELP_PHONE_PIN_SPELLER;
    public static final byte LIST_MODE_HELP_PHONE_SMS;
    public static final byte LIST_MODE_HELP_SDS_SPEECH;
    public static final byte LIST_MODE_HELP_MAP;
    public static final byte LIST_MODE_HELP_REMOTE_HMI;
    public static final byte LIST_MODE_HELP_TOPIC_HELP_REMOTE_HMI_SUBTOPIC;
    public static final int SCREEN_MAPPING_NONE;
    public static final int SCREEN_MAPPING_LOGICAL_POPUP;
    public static final int SCREEN_MAPPING_MAP_SHOW_DETAILS;
    public static final int SCREEN_MAPPING_PHONE_INTELLI_CALL;
    public static final int SCREEN_MAPPING_PHONE_FAVORITES;
    public static final int SCREEN_MAPPING_RHMI_BROWSER;
    public static final int SCREEN_MAPPING_RHMI_LIST;
    public static final int SCREEN_MAPPING_TEL_SDS_CONTACT;
    public static final int SCREEN_MAPPING_DEST_ADDRESS_FORM_MAIN;
    public static final int SCREEN_MAPPING_RHMI_TEXT_DISPLAY;
    public static final int SCREEN_MAPPING_RHMI_TEXT_DISPLAY_OPTIONS;
    public static final int SCREEN_MAPPING_RHMI_LIST_OPTIONS;
    public static final int SCREEN_MAPPING_RHMI_WAITING;
    public static final int SCREEN_MAPPING_SDS_COM_FURTHER_COMMANDS_MAIN;
    public static final int SCREEN_MAPPING_SDS_HELP_CAR;
    public static final int SCREEN_MAPPING_SDS_HELP_MEDIA;
    public static final int SCREEN_MAPPING_SDS_HELP_MEDIA_TOPIC_DEVICE_CHANGE;
    public static final int SCREEN_MAPPING_SDS_HELP_MEDIA_TOPIC_JUKEBOX_SD_USB;
    public static final int SCREEN_MAPPING_SDS_HELP_MEDIA_TOPIC_TITLE_SELECT;
    public static final int SCREEN_MAPPING_SDS_HELP_MEDIA_TOPIC_IPOD;
    public static final int SCREEN_MAPPING_SDS_HELP_CONTEXT_OFFICE;
    public static final int SCREEN_MAPPING_SDS_HELP_NAV;
    public static final int SCREEN_MAPPING_SDS_HELP_NAV_TOPIC_MAP;
    public static final int SCREEN_MAPPING_SDS_HELP_NAV_TOPIC_ROUTE_INFORMATION;
    public static final int SCREEN_MAPPING_SDS_HELP_NAV_TOPIC_ENTER_DESTINATION;
    public static final int SCREEN_MAPPING_SDS_HELP_NAV_TOPIC_SPECIAL_DESTINATION;
    public static final int SCREEN_MAPPING_SDS_HELP_ONLINE_GENERIC;
    public static final int SCREEN_MAPPING_SDS_HELP_ONLINE_TOPIC_XY_GENERIC_STATE;
    public static final int SCREEN_MAPPING_SDS_HELP_PHONE;
    public static final int SCREEN_MAPPING_SDS_HELP_PHONE_TOPIC_DIAL_NUMBER;
    public static final int SCREEN_MAPPING_SDS_HELP_PHONE_TOPIC_SMS;
    public static final int SCREEN_MAPPING_SDS_HELP_PHONE_TOPIC_ADB;
    public static final int SCREEN_MAPPING_SDS_HELP_PHONE_TOPIC_NUMBER_SPELLER;
    public static final int SCREEN_MAPPING_SDS_HELP_PHONE_TOPIC_PIN_SPELLER;
    public static final int SCREEN_MAPPING_SDS_HELP_TUNER;
    public static final int SCREEN_MAPPING_SDS_HELP_TUNER_TOPIC_STATION;
    public static final int SCREEN_MAPPING_SDS_HELP_TUNER_TOPIC_DAB;
    public static final int SCREEN_MAPPING_SDS_HELP_TUNER_TOPIC_SIRIUS;
    public static final int SCREEN_MAPPING_SDS_HELP_MENUS;
    public static final int SCREEN_MAPPING_MAP_SHOW_DETAILS_GENERIC_SDS_MAIN;
    public static final int SCREEN_MAPPING_SDS_NAV_PICKLIST_AI1;
    public static final int SCREEN_MAPPING_DEST_ONLINE_SEARCH_SCREEN;
    public static final int SCREEN_MAPPING_OFFICE_OPT_SMS_NEW_EDIT;
    public static final int SCREEN_MAPPING_OFFICE_OPT_MAIL_NEW_EDIT;
    public static final int SCREEN_MAPPING_SDS_COM_FURTHER_COMMANDS_TUNER;
    public static final int SCREEN_MAPPING_SDS_COM_FURTHER_COMMANDS_NAVI_ASIA_CNTW;
    public static final int SCREEN_MAPPING_SDS_COM_FURTHER_COMMANDS_NAVI_ASIA_KR;
    public static final int SCREEN_MAPPING_SDS_COM_FURTHER_COMMANDS_NAVI_ASIA_JP;
    public static final int SCREEN_MAPPING_SDS_COM_FURTHER_COMMANDS_NAVI;
    public static final int SCREEN_MAPPING_SDS_COM_FURTHER_COMMANDS_NAVI_POI_ONLINE;
    public static final int SCREEN_MAPPING_SDS_COM_FURTHER_COMMANDS_ADB;
    public static final int SCREEN_MAPPING_SDS_COM_FURTHER_COMMANDS_MEDIA;
    public static final int SCREEN_MAPPING_SDS_COM_FURTHER_COMMANDS_PHONE;
    public static final int SCREEN_MAPPING_SDS_COM_FURTHER_COMMANDS_MESSAGING;
    public static final int SCREEN_MAPPING_SDS_COM_FURTHER_COMMANDS_RHMI;
    public static final int SCREEN_MAPPING_KOMBI_ACTIVE_POPUP;
    public static final int POPUP_MAPPING_NONE;
    public static final int POPUP_MAPPING_DIALOG;
    public static final int POPUP_MAPPING_PAUSE;
    public static final int POPUP_MAPPING_VOLUME;
    public static final int POPUP_MAPPING_WAIT_STATE;
    public static final int POPUP_MAPPING_LOGICAL;
    public static final int POPUP_MAPPING_FURTHER_COMMANDS_ADB;
    public static final int POPUP_MAPPING_FURTHER_COMMANDS_MEDIA;
    public static final int POPUP_MAPPING_FURTHER_COMMANDS_MESSAGING;
    public static final int POPUP_MAPPING_FURTHER_COMMANDS_NAVI_ASIA_CNTW;
    public static final int POPUP_MAPPING_FURTHER_COMMANDS_NAVI;
    public static final int POPUP_MAPPING_FURTHER_COMMANDS_NAVI_POI_ONLINE;
    public static final int POPUP_MAPPING_FURTHER_COMMANDS_PHONE;
    public static final int POPUP_MAPPING_FURTHER_COMMANDS_RHMI;
    public static final int POPUP_MAPPING_FURTHER_COMMANDS_TUNER;
    public static final int POPUP_MAPPING_FURTHER_COMMANDS_NAVI_ASIA_JP;
    public static final int POPUP_MAPPING_FURTHER_COMMANDS_NAVI_ASIA_KR;
    public static final int POPUP_MAPPING_FURTHER_COMMANDS_MAIN;
    public static final int POPUP_MAPPING_COMMAND_DISAMBIGUATION_LIST;
    public static final int POPUP_MAPPING_BIG_COMMAND_MENU;
    public static final int POPUP_MAPPING_BIG_COMMAND_MEDIA;
    public static final int POPUP_MAPPING_BIG_COMMAND_PHONE;
    public static final int POPUP_MAPPING_BIG_COMMAND_TUNER;
    public static final int POPUP_MAPPING_BIG_COMMAND_MAP;
    public static final int POPUP_MAPPING_BIG_COMMAND_NAV;
    public static final int POPUP_MAPPING_BIG_COMMAND_ONLINE;
    public static final int POPUP_MAPPING_BIG_COMMAND_SMS;
    public static final int POPUP_MAPPING_BIG_COMMAND_OFFCE;
    public static final int POPUP_MAPPING_BIG_COMMAND_ONLINE_PTT;
    public static final int POPUP_MAPPING_BIG_COMMAND_CAR;
    public static final int POPUP_MAPPING_FAVORITE_DISAMBIGUATION_LIST;
    public static final int POPUP_MAPPING_EXTERNAL_SDS;
    public static final int POPUP_MAPPING_TELINCOMINGCALLPOPUP;
    public static final int POPUP_MAPPING_HELP_MEDIA;
    public static final int POPUP_MAPPING_HELP_MEDIA_DEVICE_CHANGE;
    public static final int POPUP_MAPPING_HELP_MEDIA_TITLE_SELECT;
    public static final int POPUP_MAPPING_HELP_MEDIA_JUKEBOX_SD;
    public static final int POPUP_MAPPING_HELP_MEDIA_IPOD;
    public static final int POPUP_MAPPING_HELP_TUNER;
    public static final int POPUP_MAPPING_HELP_TUNER_STATION;
    public static final int POPUP_MAPPING_HELP_TUNER_DAB;
    public static final int POPUP_MAPPING_HELP_TUNER_SIRIUS;
    public static final int POPUP_MAPPING_HELP_NAVI;
    public static final int POPUP_MAPPING_HELP_NAVI_ENTER_DESTINATION;
    public static final int POPUP_MAPPING_HELP_NAVI_POI;
    public static final int POPUP_MAPPING_HELP_NAVI_ROUTE_INFORMATION;
    public static final int POPUP_MAPPING_HELP_PHONE;
    public static final int POPUP_MAPPING_HELP_PHONE_ADB;
    public static final int POPUP_MAPPING_HELP_PHONE_DIAL_NUMBER;
    public static final int POPUP_MAPPING_HELP_PHONE_NUMBER_SPELLER;
    public static final int POPUP_MAPPING_HELP_PHONE_PIN_SPELLER;
    public static final int POPUP_MAPPING_HELP_PHONE_SMS;
    public static final int POPUP_MAPPING_HELP_SDS_SPEECH;
    public static final int POPUP_MAPPING_HELP_MAP;
    public static final int POPUP_MAPPING_HELP_CAR;
    public static final int POPUP_MAPPING_HELP_REMOTE_HMI;
    public static final int POPUP_MAPPING_HELP_REMOTE_HMI_SUBTOPIC;
    public static final int POPUP_MAPPING_CONNECTIONONLINEYESNO;
    public static final int POPUP_MAPPING_ADR_SDS;
    public static final int POPUP_MAPPING_ADRSDSNAVPOPUP;
    public static final int POPUP_MAPPING_ADRSDSPOPUPCONTACT;
    public static final int POPUP_MAPPING_TELSDSCONTACT;
    public static final int POPUP_MAPPING_TELSDSNUM;
    public static final int POPUP_MAPPING_MSG_ACCOUNT;
    public static final int POPUP_MAPPING_OFFICE_OPT_SMS_DICTATION_RUNNING;
    public static final int POPUP_MAPPING_OFFICE_OPT_SMS_DICTATION_PROCESSING;
    public static final int POPUP_MAPPING_MAILSDSPOPUPCONTACT;
    public static final int POPUP_MAPPING_NAVSDSPOPUP;
    public static final int POPUP_MAPPING_NAVSDSPOIPICKLIST;
    public static final int POPUP_MAPPING_NAV_SDS_PICKLIST_AI1;
    public static final int POPUP_MAPPING_NAV_SDS_POI_RESULTS_PICKLIST;
    public static final int POPUP_MAPPING_NAV_SDS_MY_AUDI_DETAIL_SCREEN;
    public static final int POPUP_MAPPING_NAV_SDS_GENERIC_MAP_DETAILS;
    public static final int POPUP_MAPPING_NAV_SDS_SEARCH_AREA_COUNTRY_CITY;
    public static final int POPUP_MAPPING_NAV_PP_ONE_DEST;
    public static final int POPUP_MAPPING_NAV_PP_TWO_DEST;
    public static final int POPUP_MAPPING_NAV_PP_DEMOMODUS;
    public static final int POPUP_MAPPING_NAV_SDS_SEARCH_AREA_CITY_CNTW;
    public static final int POPUP_MAPPING_NAV_SDS_SEARCH_AREA_PREFECTURE_CITY_JP;
    public static final int POPUP_MAPPING_NAV_SDS_SEARCH_AREA_PROVINCE_CITY_KR;
    public static final int POPUP_MAPPING_TUNERSDSPOPUP;
    public static final int POPUP_MAPPING_TUNERGENRESDSPOPUP;
    public static final int POPUP_MAPPING_MEDIASDSPOPUP;
    public static final int POPUP_MAPPING_PHONESDSPOPUP;
    public static final int POPUP_MAPPING_SDSDEBUGPOPUP;
    public static final int POPUP_MAPPING_TELEPROMPTER_BIG;
    public static final int POPUP_MAPPING_TELEPROMPTER_SMALL;
    public static final int POPUP_MAPPING_SEARCH_PROMPT;
    public static final int POPUP_MAPPING_CALL_LIST;
    public static final int POPUP_MAPPING_SYSTEMNBESTLIST;
    public static final int POPUP_MAPPING_PORSCHE_HELP_CATEGORIES;
    public static final int POPUP_MAPPING_PORSCHE_HELP_DETAILS;
    public static final int POPUP_MAPPING_REFINEMENT_LIST;
    public static final int POPUP_MAPPING_MEDIASDSPARTIALPOPUP;
    public static final int POPUP_MAPPING_ICON_LIST;
    public static final int POPUP_MAPPING_SDS_STATUS;
    public static final int POPUP_MAPPING_POI_OFFLINE_RESULTS;
    public static final int POPUP_MAPPING_ONLINE_RESULTS;
    public static final int POPUP_MAPPING_SDSICONLISTDETAILS;
    public static final int POPUP_MAPPING_SDSICONLISTDETAILS_SUI;
    public static final int POPUP_MAPPING_ADB_CONTACT_LIST;
    public static final int POPUP_MAPPING_REFINEMENT_PHONE_CATEGORIES;
    public static final int POPUP_MAPPING_PHONE_REFINEMENT_NUMBERS;
    public static final int POPUP_MAPPING_NAVI_LAST_AND_FAVORITES;
    public static final int POPUP_MAPPING_ONLINE_SEARCH_PROMPT;
    public static final int POPUP_MAPPING_TUNER_STATION_ICONS_LIST;
    public static final int POPUP_MAPPING_LAST_DESTINATIONS;
    public static final int POPUP_MAPPING_STORED_DESTINATIONS;
    public static final int POPUP_MAPPING_TELEPROMPTER_SMALL_GREY;
    public static final int POPUP_MAPPING_SEARCH_PROMPT_SMALL;
    public static final int POPUP_MAPPING_TUNER_FAVORITES;
    public static final int POPUP_MAPPING_SEARCH_PROMPT_TRUFFLE;
    public static final int POPUP_MAPPING_REFINEMENT_LIST_TRUFFLE;
    public static final int POPUP_MAPPING_REFINEMENT_NUMBERS_MSG_EMAIL_ACCOUNTS;
    public static final int POPUP_MAPPING_ONLINE_SEARCH_PROMPT_SMALL;
    public static final int POPUP_MAPPING_ONLINE_DISCLAIMER;
    public static final int POPUP_MAPPING_ONLINE_LICENSE_N_A;
    public static final int POPUP_MAPPING_ONLINE_LICENSE_EXPIRED;
    public static final int POPUP_MAPPING_ONLINE_LICENSE_CURRENTLY_N_A;
    public static final int POPUP_MAPPING_PHONE_CONTACT_DETAILS;
    public static final int EVENT_MAPPING_NONE;
    public static final int EVENT_MAPPING_SYS_INIT_COMPLETE;
    public static final int EVENT_MAPPING_PTT;
    public static final int EVENT_MAPPING_PAUSE;
    public static final int EVENT_MAPPING_POSTTRAINING;
    public static final int EVENT_MAPPING_VOLUME;
    public static final int EVENT_MAPPING_DIALOG_STARTING;
    public static final int EVENT_MAPPING_SELECT;
    public static final int EVENT_MAPPING_ABORT;
    public static final int EVENT_MAPPING_SILENT_ABORT;
    public static final int EVENT_MAPPING_PAUSE_RELEASE;
    public static final int EVENT_MAPPING_POSTTRAINING_ABORT;
    public static final int EVENT_MAPPING_SD_REMOVED_OR_ERROR;
    public static final int EVENT_MAPPING_FOLDER_UP;
    public static final int EVENT_MAPPING_PHONE_STATE_CHANGED;
    public static final int EVENT_MAPPING_MSG_WORD_SELECTED;
    public static final int EVENT_MAPPING_MSG_START_TOUCHPAD;
    public static final int EVENT_MAPPING_CORRECTION;
    public static final int EVENT_MAPPING_TP_AUDIO;
    public static final int EVENT_MAPPING_WAIT_RELEASE;
    public static final int EVENT_MAPPING_WAIT_CORRECTION;
    public static final int EVENT_MAPPING_NAVI_ALL_IN_ONESHOT_WAIT;
    public static final int EVENT_MAPPING_JUMP_TO_PHONE_STATE;
    public static final int EVENT_MAPPING_SMS_DICTATE;
    public static final int EVENT_MAPPING_MAIL_DICTATE;
    public static final int EVENT_MAPPING_NAVI_POI_ONLINE;
    public static final int EVENT_MAPPING_ONLINE_REMOTE_HMI_HELP;
    public static final int EVENT_MAPPING_TTS_FINISH;
    public static final int EVENT_MAPPING_RECOG_FAILURE;
    public static final int EVENT_MAPPING_TIMEOUT;
    public static final int EVENT_MAPPING_SIGNAL_TO_NOISE_RATIO_TOO_LOW;
    public static final int EVENT_MAPPING_SPEECHREC_FINISHED_ONLINE_STREAMING;
    public static final int EVENT_MAPPING_ONLINE_RECOG_STARTED;
    public static final int EVENT_MAPPING_TTS_FINISH_COMBINED;
    public static final int EVENT_MAPPING_TTS_INTERRUPTED;
    public static final int EVENT_MAPPING_TTS_FAILED_IGNORE;
    public static final int EVENT_MAPPING_OK;
    public static final int EVENT_MAPPING_ERROR;
    public static final int EVENT_MAPPING_PAUSE_OK;
    public static final int EVENT_MAPPING_PAUSE_ERROR;
    public static final int EVENT_MAPPING_INVALID;
    public static final int EVENT_MAPPING_AMBIGUOUS;
    public static final int EVENT_MAPPING_DISABLED;
    public static final int EVENT_MAPPING_EMPTY;
    public static final int EVENT_MAPPING_BUSY;
    public static final int EVENT_MAPPING_NOT_EMPTY;
    public static final int EVENT_MAPPING_WAIT_OK;
    public static final int EVENT_MAPPING_WAIT_ERROR;
    public static final int EVENT_MAPPING_HELP;
    public static final int EVENT_MAPPING_GLOBAL_GRAPHGROUP_RECOGNIZED;
    public static final int EVENT_MAPPING_NO_GRAPHGROUP_RECOGNIZED;
    public static final int EVENT_MAPPING_PRIVATE;
    public static final int EVENT_MAPPING_WORK;
    public static final int EVENT_MAPPING_ADB_TYPE_TEL_NUMBER;
    public static final int EVENT_MAPPING_ADB_TYPE_ADDRESS;
    public static final int EVENT_MAPPING_ADB_TYPE_MAIL;
    public static final int EVENT_MAPPING_ADB_ERROR;
    public static final int EVENT_MAPPING_ADB_OK;
    public static final int EVENT_MAPPING_WBS_NONE;
    public static final int EVENT_MAPPING_WBS_FM;
    public static final int EVENT_MAPPING_WBS_AM;
    public static final int EVENT_MAPPING_WBS_DAB;
    public static final int EVENT_MAPPING_WBS_SDARS;
    public static final int EVENT_MAPPING_TUNER_ERROR;
    public static final int EVENT_MAPPING_TUNER_INVALID;
    public static final int EVENT_MAPPING_TUNER_DISABLED;
    public static final int EVENT_MAPPING_TUNER_OK;
    public static final int EVENT_MAPPING_TUNER_UNIQUE;
    public static final int EVENT_MAPPING_TUNER_NOT_PLAYABLE;
    public static final int EVENT_MAPPING_TUNER_GREYED_OUT;
    public static final int EVENT_MAPPING_TUNER_AMBIGUOUS;
    public static final int EVENT_MAPPING_TV_OK;
    public static final int EVENT_MAPPING_TV_ERROR;
    public static final int EVENT_MAPPING_TV_DISABLED;
    public static final int EVENT_MAPPING_WBS_TV;
    public static final int EVENT_MAPPING_MEDIA_OK;
    public static final int EVENT_MAPPING_MEDIA_ERROR;
    public static final int EVENT_MAPPING_MEDIA_BUSY;
    public static final int EVENT_MAPPING_MEDIA_EMPTY;
    public static final int EVENT_MAPPING_MEDIA_DISABLED;
    public static final int EVENT_MAPPING_MEDIA_INVALID;
    public static final int EVENT_MAPPING_MEDIA_NOT_PLAYABLE;
    public static final int EVENT_MAPPING_MEDIA_NOT_READABLE;
    public static final int EVENT_MAPPING_MEDIA_ALREADY_TOP_LEVEL;
    public static final int EVENT_MAPPING_MEDIA_OK_IDENT;
    public static final int EVENT_MAPPING_MEDIA_AMBIGUOUS;
    public static final int EVENT_MAPPING_MEDIA_JUST_FIRST_LEVEL;
    public static final int EVENT_MAPPING_MEDIA_JUST_SECOND_LEVEL;
    public static final int EVENT_MAPPING_MEDIA_JUST_THIRD_LEVEL;
    public static final int EVENT_MAPPING_MEDIA_TWO_LEVELS;
    public static final int EVENT_MAPPING_MSG_OK;
    public static final int EVENT_MAPPING_MSG_ERROR;
    public static final int EVENT_MAPPING_MSG_NEXT_STEP_NONE;
    public static final int EVENT_MAPPING_MSG_NEXT_STEP_ACCOUNT;
    public static final int EVENT_MAPPING_MSG_NEXT_STEP_LIST;
    public static final int EVENT_MAPPING_MSG_NEXT_STEP_DETAIL;
    public static final int EVENT_MAPPING_MSG_INVALID;
    public static final int EVENT_MAPPING_MSG_EDIT_FINISHED;
    public static final int EVENT_MAPPING_MSG_ERROR_NO_MESSAGES;
    public static final int EVENT_MAPPING_PHONE_OK;
    public static final int EVENT_MAPPING_PHONE_ERROR;
    public static final int EVENT_MAPPING_PHONE_INVALID;
    public static final int EVENT_MAPPING_PHONE_AMBIGUOUS;
    public static final int EVENT_MAPPING_PHONE_TOO_LONG;
    public static final int EVENT_MAPPING_PHONE_FUNCTION_NOT_SUPPORTED_BY_PHONE;
    public static final int EVENT_MAPPING_PHONE_FUNCTION_NOT_SUPPORTED_BY_NET;
    public static final int EVENT_MAPPING_PHONE_NO_NET;
    public static final int EVENT_MAPPING_PHONE_ADB_CONTACT;
    public static final int EVENT_MAPPING_PHONE_UNKNOWN_NUMBER;
    public static final int EVENT_MAPPING_PHONE_NUMBER;
    public static final int EVENT_MAPPING_PHONE_MAILBOX;
    public static final int EVENT_MAPPING_MSG_START_CORRECTION;
    public static final int EVENT_MAPPING_MSG_DELETE;
    public static final int EVENT_MAPPING_MSG_ERROR_PROXY;
    public static final int EVENT_MAPPING_MSG_ERROR_CONNECTION;
    public static final int EVENT_MAPPING_MSG_LANG_NOT_SUPPORTED;
    public static final int EVENT_MAPPING_MSG_RECOGNITION_FAILURE;
    public static final int EVENT_MAPPING_NAVI_OK;
    public static final int EVENT_MAPPING_NAVI_ERROR;
    public static final int EVENT_MAPPING_JUST_FIRST_AND_SECOND_LEVEL;
    public static final int EVENT_MAPPING_JUST_FIRST_LEVEL;
    public static final int EVENT_MAPPING_CORRECTION_ENTER_POI;
    public static final int EVENT_MAPPING_NAVI_CUSTOMER_UPDATE;
    public static final int EVENT_MAPPING_NAVI_INVALID;
    public static final int EVENT_MAPPING_NAVI_HOMEADDRESS;
    public static final int EVENT_MAPPING_JUST_POI;
    public static final int EVENT_MAPPING_NAVI_EMPTY;
    public static final int EVENT_MAPPING_NAVI_AMBIGUOUS;
    public static final int EVENT_MAPPING_NAVI_OK_HOUSENUMBER;
    public static final int EVENT_MAPPING_NAVI_OK_INTERSECTION;
    public static final int EVENT_MAPPING_ONESHOT_UP_TO_LEVEL_0;
    public static final int EVENT_MAPPING_ONESHOT_UP_TO_LEVEL_1;
    public static final int EVENT_MAPPING_ONESHOT_UP_TO_LEVEL_2;
    public static final int EVENT_MAPPING_ONESHOT_UP_TO_LEVEL_3;
    public static final int EVENT_MAPPING_ONESHOT_UP_TO_LEVEL_4;
    public static final int EVENT_MAPPING_NAVI_BUSY;
    public static final int EVENT_MAPPING_NAVI_WARD;
    public static final int EVENT_MAPPING_NAVI_NO_WARD;
    public static final int EVENT_MAPPING_NAVI_TIMEOUT;
    public static final int EVENT_MAPPING_NAVI_OLD_DATA_FOUND;
    public static final int EVENT_MAPPING_CONNECTION_FALSE;
    public static final int EVENT_MAPPING_CONNECTION_TRUE;
    public static final int EVENT_MAPPING_SWITCH_TELEPROMPTER;
    public static final int EVENT_MAPPING_FIRST_LINE_SET;
    public static final int EVENT_MAPPING_LIST_JUMP;
    public static final int GRAMMAR_MAPPING_NONE;
    public static final int GRAMMAR_MAPPING_SDS_INPUT_ROWNUMBERS1_6;
    public static final int GRAMMAR_MAPPING_SDS_INPUT_SDCARDNUMBERS;
    public static final int GRAMMAR_MAPPING_SDS_INPUT_ROWNUMBERS1_7;
    public static final int GRAMMAR_MAPPING_MEDIA_ONESHOT_ALBUMS;
    public static final int GRAMMAR_MAPPING_MEDIA_ONESHOT_TITLES;
    public static final int GRAMMAR_MAPPING_MEDIA_ONESHOT_ARTISTS;
    public static final int GRAMMAR_MAPPING_NAVI_LAST_DESTINATIONS;
    public static final int GRAMMAR_MAPPING_NAVI_FAVORITES;
    public static final int GRAMMAR_MAPPING_MY_AUDI_CONTACTS;
    public static final int GRAMMAR_MAPPING_PHONE_CALLSTACKS;
    public static final int GRAMMAR_MAPPING_PHONE_FAVORITES;
    public static final int GRAMMAR_MAPPING_ADB_MAIL_ADDRESSES;
    public static final int GRAMMAR_MAPPING_ONLINE_REMOTEHMI;
    public static final int GRAMMAR_MAPPING_ONLINE_REMOTEHMI_GLOBAL;
    public static final int GRAMMAR_MAPPING_ONLINE_REMOTEHMI_HELP;
    public static final int GRAMMAR_MAPPING_TUNER_DAB_ENSEMBLES;
    public static final int GRAMMAR_MAPPING_TUNER_STATIONS;
    public static final int GRAMMAR_MAPPING_TUNER_GENRES;
    public static final int GRAMMAR_MAPPING_MEDIA_DYNAMIC_DEVICES;
    public static final int GRAMMAR_MAPPING_TUNER_CHANNEL_NUMBER;
    public static final int GRAMMAR_MAPPING_NAVI_KR_SIMPLE_MAP;
    public static final int SLOT_MAPPING_NONE;
    public static final int SLOT_MAPPING_MEDIA_TITLES;
    public static final int SLOT_MAPPING_MEDIA_ARTISTS;
    public static final int SLOT_MAPPING_MEDIA_ALBUMS;
    public static final int SLOT_MAPPING_ADB_CONTACTS;
    public static final int SUI_MAPPING_TYPE_NONE;
    public static final int SUI_MAPPING_TYPE_ADDRESS;
    public static final int SUI_MAPPING_TYPE_CONTACT;
    public static final int SUI_MAPPING_TYPE_POI;
    public static final int SUI_MAPPING_TYPE_POI_CITY;
    public static final int TRUFFLE_MAPPING_TYPE_NONE;
    public static final int TRUFFLE_MAPPING_TYPE_INITIAL;
    public static final int EVENT_MAPPING_MSG_DDS_ENTER;
    public static final int EVENT_MAPPING_MSG_TOUCHPAD_ENTER;
    public static final int MODEL_MAPPING_NONE;
    public static final int MODEL_MAPPING_PHONE_NUMBER_SPELLER;
    public static final int MODEL_MAPPING_NAV_DEST_EDIT_STREET_AFTER_CITY_MATCHSPELLER;
    public static final int MODEL_MAPPING_HOUSENUMBER_MATCHSPELLER;
    public static final int MODEL_MAPPING_NAV_DEST_LAST_DEST_BASE_LIST;
    public static final int MODEL_MAPPING_NAV_DEST_FAVORITES_BASE_LIST;
    public static final int MODEL_MAPPING_ADR_ORGANIZER_SEARCH_RESULT_TILED_LIST;
    public static final int MODEL_MAPPING_ADR_TRUFFLE_BASE_LIST;
    public static final int MODEL_MAPPING_ADR_ENTRY_DETAILS_TEL_NUMBER_BASE_LIST;
    public static final int MODEL_MAPPING_ADR_ENTRY_DETAILS_ADDRESS_BASE_LIST;
    public static final int MODEL_MAPPING_ADR_ENTRY_DETAILS_EMAIL_BASE_LIST;
    public static final int MODEL_MAPPING_SDS_MEDIA_PICKLIST_IS_PLAY_MUSIC_CHOICE;
    public static final int MODEL_MAPPING_SDS_MEDIA_PICKLIST_AMI_BUTTON;
    public static final int MODEL_MAPPING_SDS_MEDIA_PICKLIST_AUX_BUTTON;
    public static final int MODEL_MAPPING_SDS_MEDIA_PICKLIST_JUKEBOX_BUTTON;
    public static final int MODEL_MAPPING_SDS_MEDIA_PICKLIST_PLAY_MUSIC_SELECTED_TYPE_CHOICE;
    public static final int MODEL_MAPPING_SDS_REMOTE_HMI_ONLINE_PROMPT_AVAILABLE_CHOICE;
    public static final int MODEL_MAPPING_NAV_INTELLIDEST_SEARCH_BASE_LIST;
    public static final int MODEL_MAPPING_NAV_FAVOURITES_CONTEXT_CHOICE;
    public static final int MODEL_MAPPING_SDS_MEDIA_GRAMMAR_COMPILING_CHOICE;
    public static final int MODEL_MAPPING_SDS_VOICE_BARGE_IN_PROMPT_SELECT_CHOICE;
    public static final int MODEL_MAPPING_TEMPLATE_LIST_BASE_LIST;
    public static final int MODEL_MAPPING_SDS_INTERSECTION_SET_CHOICE;
    public static final int MODEL_MAPPING_SDS_PROMPT_TYPE_UNCHANGING_CHOICE;
    public static final int MODEL_MAPPING_SDS_NAVI_ONLINE_POI_SYNC_NEEDED;
    public static final int MODEL_MAPPING_SDS_AUDI_CONNECT_SCREEN_SYNC;

    default public int getModelMappingID(int n) {
    }

    default public int getModelID(int n) {
    }

    default public int getPopupID(int n) {
    }

    default public int getPopupMappingID(int n) {
    }

    default public int getEventID(int n) {
    }

    default public int[] getBigCommandPopups() {
    }

    default public int[] getFurtherCommandPopups() {
    }

    default public int[] getDisambiguationPopups() {
    }

    default public int getCommandScreenPopupMapping(int n, LogChannel logChannel) {
    }

    default public int getHelpScreenPopupMapping(int n, LogChannel logChannel) {
    }

    default public int[] getHMISlotGrammarArray() {
    }

    default public int[] getSlotOrder(int n) {
    }

    default public int getEventIdForRule(int n) {
    }

    default public int getHMISlotGrammar(int n) {
    }

    default public int getHMISlotGrammarMapping(int n) {
    }

    default public int getSlotTypeMapping(int n) {
    }

    default public int getSUITypeForRule(int n) {
    }

    default public int[] getSUIGrammars(int n) {
    }

    default public int[] getTruffleGrammars(int n) {
    }

    default public boolean isSUIGrammar(int n) {
    }

    default public boolean isOneshotGrammar(int n) {
    }

    default public boolean isNaviTrufflesInitialEvent(int n) {
    }

    default public int[] getSDSPopups() {
    }

    default public int getRemoteHMILineNumberForEvent(int n) {
    }

    default public boolean isSDSPopup(int n) {
    }

    default public int getScreenID(int n) {
    }

    default public int getScreenMapping(int n) {
    }

    default public boolean isBigCommandDisplay(int n) {
    }

    default public boolean isFurtherCommandDisplay(int n) {
    }

    default public int getProgressIconTimeout() {
    }

    default public int getSdsEvent(int n) {
    }

    default public boolean isOnlineRecogFinishedSMEvent(int n) {
    }
}

