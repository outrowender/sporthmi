/*
 * Decompiled with CFR 0.152.
 */
package de.audi.remotehmi.ui.pag;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public interface GeneralConst {
    public static final String POPUP_ELEMENT = "popup";
    public static final String OPTION_ELEMENT = "option";
    public static final String OPTION_ENTRY = "optionElement";
    public static final String OPTION_UPDATE_ELEMENT = "updateOptionElement";
    public static final String CONTROLLER_LABEL_BUTTON = "labelControllerButton";
    public static final String CONTROLLER_BUTTON = "controllerButton";
    public static final String CONTROLLER_TOGGLE_BUTTON = "toggleButton";
    public static final List CONTROLLER_ELEMENTS = Collections.unmodifiableList(Arrays.asList(new String[]{"controllerButton".toLowerCase(), "labelControllerButton".toLowerCase(), "toggleButton".toLowerCase()}));
    public static final String BUTTON_CONTROLLER_ELEMENT = "buttonController";
    public static final String MEDIA_CONTROLLER_ELEMENT = "mediaController";
    public static final List CONTROLLER_TYPES = Collections.unmodifiableList(Arrays.asList(new String[]{"buttonController".toLowerCase(), "mediaController".toLowerCase()}));
    public static final String CONTROLLER_SWITCH_TOGGLE_IMAGES = "switchToggleImages";
    public static final String SHORTCUT_ELEMENT = "shortcut";
    public static final String FORMATTED_TEXT_ELEMENT = "formattedText";
    public static final String LABEL_IMAGE_ELEMENT = "labelImage";
    public static final String PREVIEW_MAP_ELEMENT = "previewMap";
    public static final String BREADCRUMB_ELEMENT = "breadcrumb";
    public static final String BREADCRUMB_BUTTON = "breadcrumbButton";
    public static final String TABBAR_ELEMENT = "tabbar";
    public static final String TABBAR_BUTTON = "tabbarButton";
    public static final String HEADLINE_ELEMENT = "headline";
    public static final String HEADLINE_BUTTON = "headlineButton";
    public static final String HEADLINE_PLAY = "headlinePlay";
    public static final String HEADLINE_REFRESH = "refreshButton";
    public static final List HEADLINE_ELEMENTS = Collections.unmodifiableList(Arrays.asList(new String[]{"headlineButton".toLowerCase(), "headlinePlay".toLowerCase(), "refreshButton".toLowerCase()}));
    public static final int HEADLINE_BUTTON_INDEX = 0;
    public static final int HEADLINE_PLAY_INDEX = 1;
    public static final int HEADLINE_REFRESH_INDEX = 2;
    public static final int DOWNLOAD_APPLIST_ERROR_CACHED = 0;
    public static final int DOWNLOAD_APPLIST_ERROR_NOT_CACHED = 1;
    public static final int DOWNLOAD_APPLIST_RUNNING_FALSE = 2;
    public static final int DOWNLOAD_APPLIST_RUNNING_TRUE = 3;
    public static final String VIEW_MEDIA_DATA = "mediaData";
    public static final String VIEW_MEDIA_TITLE = "title";
    public static final String VIEW_MEDIA_ALBUM = "album";
    public static final String VIEW_MEDIA_INTERPRET = "interpret";
    public static final String VIEW_MEDIA_ALBUMCOVER = "albumCover";
    public static final String VIEW_MEDIA_PLAYLIST_ADD = "additionalInfo";
    public static final String VIEW_MEDIA_PLAYLIST = "playList";
    public static final String VIEW_MEDIA_PLAYLIST_ENTRY = "entry";
    public static final List VIEW_MEDIA_DATA_VALUES = Collections.unmodifiableList(Arrays.asList(new String[]{"title".toLowerCase(), "album".toLowerCase(), "interpret".toLowerCase(), "albumCover".toLowerCase(), "playList".toLowerCase()}));
    public static final String BACK_BUTTON = "backButton";
    public static final String BACK_BUTTON_VISIBILITY = "visibility";
    public static final String LOGIN_BUTTON = "loginButton";
    public static final String LOGIN_BUTTON_VISIBILITY = "visibility";
    public static final int BUTTON_VALUE_INVALID = 0;
    public static final int BUTTON_VALUE_TRUE = 1;
    public static final int BUTTON_VALUE_FALSE = -1;
}

