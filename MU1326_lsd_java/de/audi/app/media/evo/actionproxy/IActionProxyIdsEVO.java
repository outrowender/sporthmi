/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.evo.actionproxy;

import de.audi.app.media.actionproxy.IActionProxyIDsCore;

public interface IActionProxyIdsEVO
extends IActionProxyIDsCore {
    public static final int AP_METHOD_CHANGE_TO_ROOT_FOLDER = 8;
    public static final int AP_METHOD_CHANGE_TO_PARENT_FOLDER = 9;
    public static final int AP_METHOD_PLAYER_MORELIKETHIS_ERROR_LEAVED = 21;
    public static final String AP_PARAM_BROWSER_START_BROWSING_TYPE = "BROWSETYPE";
    public static final int AP_CONST_BROWSERTYPE_STRUCTURE = 1;
    public static final int AP_CONST_BROWSERTYPE_TITLE = 2;
    public static final int AP_CONST_BROWSERTYPE_ALBUM = 3;
    public static final int AP_CONST_BROWSERTYPE_ARTIST = 4;
    public static final int AP_CONST_BROWSERTYPE_GENRE = 5;
    public static final int AP_CONST_BROWSERTYPE_PLAYLISTS = 6;
    public static final int AP_CONST_BROWSERTYPE_VIDEOS = 7;
    public static final int AP_CONST_BROWSERTYPE_PODCASTS = 8;
    public static final int AP_CONST_BROWSERTYPE_AUDIOBOOKS = 9;
    public static final int AP_CONST_BROWSERTYPE_COMPOSERS = 10;
    public static final int AP_CONST_BROWSERTYPE_FAVORITS = 11;
    public static final int AP_CONST_BROWSERTYPE_RADIO = 12;
    public static final int AP_METHOD_BROWSER_START_BROWSING = 23;
    public static final int AP_METHOD_PLAYER_NEW_SEARCH = 25;
    public static final int AP_METHOD_BROWSER_TRUFFLE_DISABLE = 26;
    public static final int AP_METHOD_BROWSER_RESTORE_SELECTION_PATH = 27;
    public static final int AP_MERGE_CURSORS = 28;
    public static final int AP_METHOD_BROWSER_TRUFFLE_DISABLE_ANIM_WAIT = 29;
    public static final int AP_METHOD_PLAYER_SEEKTOTIME_ENTER = 30;
    public static final int AP_METHOD_PLAYER_SEEKTOTIME_LEFT = 31;
    public static final String AP_PARAM_DATA_SET_SELECTED_LIST_LISTTYPE = "LISTTYPE";
    public static final int AP_CONST_DATA_LISTTYPE_PLAYVIEW = 0;
    public static final int AP_CONST_DATA_LISTTYPE_BROWSERLIST = 1;
    public static final int AP_CONST_DATA_LISTTYPE_FAVORITEN = 2;
    public static final int AP_METHOD_DATA_SET_SELECTED_LIST = 32;
    public static final int AP_METHOD_TOGGLE_SOURCE_ENTERED = 33;
    public static final int AP_METHOD_TOGGLE_SOURCE = 34;
    public static final int AP_METHOD_BROWSER_FAVORITES_RESTORE_SELECTION_PATH = 35;
    public static final int AP_METHOD_LOADING_FINISHED = 36;
    public static final int AP_METHOD_SCREEN_FADED_OUT = 37;
    public static final String AP_PARAM_SET_BROWSER_ACTIVE_STATE = "BROWSER_STATE";
    public static final int AP_METHOD_SET_BROWSER_ACTIVE = 38;
    public static final int AP_METHOD_START_SEARCH_BROWSER = 39;
    public static final int AP_METHOD_SET_OPTION_OPEN_IN_NEXT_SCREEN = 40;
}

