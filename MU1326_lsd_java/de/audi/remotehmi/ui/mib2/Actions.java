/*
 * Decompiled with CFR 0.152.
 */
package de.audi.remotehmi.ui.mib2;

import de.audi.remotehmi.ui.ql.ActionsQL;

public interface Actions
extends ActionsQL {
    public static final int TYPE_LEFT_DRAWER = 10000001;
    public static final int TYPE_RIGHT_DRAWER = 10000002;
    public static final int TYPE_START_MINI_APP_DESTINATION = 10000003;
    public static final int TYPE_START_APP_MEDIA = 10000004;
    public static final int TYPE_UPDATE_CONTEXT = 10000005;
    public static final int TYPE_START_MINI_APP_OPERATOR = 0x989686;
    public static final int TYPE_MOVE_CONTEXT_TO_BACKGROUND = 10000007;
    public static final int TYPE_START_MINI_APP_MAP = 0x989688;
    public static final int TYPE_TRIGGER_APPLIST_DOWNLOAD = 0x989689;
    public static final int TYPE_FORCE_APPLIST_REFRESH = 10000013;
    public static final int TYPE_RESUME_INTERPRETER = 100000010;
    public static final int TYPE_CHANGE_MAP_VIEW_STATE = 100000011;
    public static final int TYPE_REMOVE_UNUSED_INTERPRETER = 100000012;
    public static final int TYPE_REMOVE_UNUSED_INTERPRETER_WITHOUT_SENDING_COMMAND = 100000013;
    public static final int TYPE_SPELLER_INPUT = 1000900;
    public static final int TYPE_SPELLER_KEY_TYPED = 1000901;
    public static final int TYPE_SPELLER_REQUEST = 1000902;
    public static final int TYPE_UPDATE_I18N = 0x9899F8;
    public static final int TYPE_UPDATE_CAR_CODING = 0x9899F9;
    public static final int TYPE_START_APP_TOP_WIZARD = 10001000;
    public static final int TYPE_DIAG = 10002000;
    public static final int TYPE_REMOTEHMI_ENTERED = 10003000;
    public static final int TYPE_INFINITE_LIST_REQUEST = 10004000;
    public static final int TYPE_ACTIVATED_MOBILE_MACADDRESS = 10005000;
    public static final int TYPE_DEACTIVATED_MOBILE_MACADDRESS = 10006000;
    public static final int TYPE_ONLINE_MEDIA_SESSION_UPDATE = 10007001;
    public static final int TYPE_ONLINE_MEDIA_BUFFER_UPDATE = 10007002;
    public static final int TYPE_ONLINE_MEDIA_METADATA_CHANGED = 10007003;
    public static final int TYPE_ONLINE_MEDIA_LEFT_DRAWER = 10007004;
    public static final int TYPE_ONLINE_MEDIA_COVER_ART_DOWNLOAD = 10007005;
    public static final int TYPE_POPUP_ITEM_SELECTED = 10008001;
    public static final int TYPE_AUTHENTICATION_RESULT = 10008811;
    public static final int TYPE_PHONE_STATUS = 10008900;
    public static final int TYPE_OSRAPPLICATIONS = 10008910;
    public static final int TYPE_REQUEST_IMAGE = 10008911;
    public static final int TYPE_INDICATE_GREY_SERVICES_AVAILABLE = 10008912;
    public static final int TYPE_NAVI_ROUTEGUIDANCE_FINISHED = 10008913;
    public static final int TYPE_NAVI_ROUTEGUIDANCE_ABORTED = 10008914;
    public static final int TYPE_INDICATE_GREY_SERVICE_MAIN_USER_AVAILABLE = 10008915;
    public static final int TYPE_OFFLINEMODE_ACTIVE = 100089415;
    public static final int TYPE_UPDATE_ESIM_USAGE = 100089416;
    public static final int TYPE_START_PRESET = 100089417;
    public static final int TYPE_START_DATAPLAN_SERVICE = 100089418;
    public static final int TYPE_START_BUNDLED_CONNECTIVITY_JOB_DIAGNOSIS_UI = 100089419;
    public static final int TYPE_UPDATE_ESIM_IMSI = 100089420;
    public static final int TYPE_SLAY_INTERPRETER = 100089421;
    public static final int TYPE_INDICATE_PRIVACY_MODE = 10008916;
    public static final int TYPE_INDICATE_FLEET_MODE = 10008917;
    public static final int STATE_UPDATE_NAVLOCATION_NAME_RESPONSE = 1100009009;
}

