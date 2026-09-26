/*
 * Decompiled with CFR 0.152.
 */
package de.audi.remotehmi.ui.pag;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public interface GeneralConst {
    public static final String POPUP_ELEMENT;
    public static final String OPTION_ELEMENT;
    public static final String OPTION_ENTRY;
    public static final String OPTION_UPDATE_ELEMENT;
    public static final String CONTROLLER_LABEL_BUTTON;
    public static final String CONTROLLER_BUTTON;
    public static final String CONTROLLER_TOGGLE_BUTTON;
    public static final List CONTROLLER_ELEMENTS;
    public static final String BUTTON_CONTROLLER_ELEMENT;
    public static final String MEDIA_CONTROLLER_ELEMENT;
    public static final List CONTROLLER_TYPES;
    public static final String CONTROLLER_SWITCH_TOGGLE_IMAGES;
    public static final String SHORTCUT_ELEMENT;
    public static final String FORMATTED_TEXT_ELEMENT;
    public static final String LABEL_IMAGE_ELEMENT;
    public static final String PREVIEW_MAP_ELEMENT;
    public static final String BREADCRUMB_ELEMENT;
    public static final String BREADCRUMB_BUTTON;
    public static final String TABBAR_ELEMENT;
    public static final String TABBAR_BUTTON;
    public static final String HEADLINE_ELEMENT;
    public static final String HEADLINE_BUTTON;
    public static final String HEADLINE_PLAY;
    public static final String HEADLINE_REFRESH;
    public static final List HEADLINE_ELEMENTS;
    public static final int HEADLINE_BUTTON_INDEX;
    public static final int HEADLINE_PLAY_INDEX;
    public static final int HEADLINE_REFRESH_INDEX;
    public static final int DOWNLOAD_APPLIST_ERROR_CACHED;
    public static final int DOWNLOAD_APPLIST_ERROR_NOT_CACHED;
    public static final int DOWNLOAD_APPLIST_RUNNING_FALSE;
    public static final int DOWNLOAD_APPLIST_RUNNING_TRUE;
    public static final String VIEW_MEDIA_DATA;
    public static final String VIEW_MEDIA_TITLE;
    public static final String VIEW_MEDIA_ALBUM;
    public static final String VIEW_MEDIA_INTERPRET;
    public static final String VIEW_MEDIA_ALBUMCOVER;
    public static final String VIEW_MEDIA_PLAYLIST_ADD;
    public static final String VIEW_MEDIA_PLAYLIST;
    public static final String VIEW_MEDIA_PLAYLIST_ENTRY;
    public static final List VIEW_MEDIA_DATA_VALUES;
    public static final String BACK_BUTTON;
    public static final String BACK_BUTTON_VISIBILITY;
    public static final String LOGIN_BUTTON;
    public static final String LOGIN_BUTTON_VISIBILITY;
    public static final int BUTTON_VALUE_INVALID;
    public static final int BUTTON_VALUE_TRUE;
    public static final int BUTTON_VALUE_FALSE;

    static {
        CONTROLLER_ELEMENTS = Collections.unmodifiableList(Arrays.asList(new String[]{"controllerButton".toLowerCase(), "labelControllerButton".toLowerCase(), "toggleButton".toLowerCase()}));
        CONTROLLER_TYPES = Collections.unmodifiableList(Arrays.asList(new String[]{"buttonController".toLowerCase(), "mediaController".toLowerCase()}));
        HEADLINE_ELEMENTS = Collections.unmodifiableList(Arrays.asList(new String[]{"headlineButton".toLowerCase(), "headlinePlay".toLowerCase(), "refreshButton".toLowerCase()}));
        VIEW_MEDIA_DATA_VALUES = Collections.unmodifiableList(Arrays.asList(new String[]{"title".toLowerCase(), "album".toLowerCase(), "interpret".toLowerCase(), "albumCover".toLowerCase(), "playList".toLowerCase()}));
    }
}

