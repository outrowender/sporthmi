/*
 * Decompiled with CFR 0.152.
 */
package de.audi.remotehmi.ui.pag;

import de.audi.remotehmi.ui.core.ActionsCore;

public interface ActionsPorsche
extends ActionsCore {
    public static final int TYPE_START_APP = 20000001;
    public static final int TYPE_REFRESH_APP_LIST = 2000002;
    public static final int TYPE_TRIGGER_APPLIST_INCACHE = 2000030;
    public static final int TYPE_SHORTCUT_SELECTED = 2000010;
    public static final int TYPE_REMOTEHMI_ENTERED = 2000020;
    public static final int TYPE_CONTROLLER_SELECTED = 2000110;
    public static final int TYPE_TABBAR_SELECTED = 2000120;
    public static final int TYPE_HEADLINE_SELECTED = 2000130;
    public static final int TYPE_BREADCRUMB_SELECTED = 2000140;
    public static final int TYPE_OPTION_SELECTED = 2000150;
    public static final int TYPE_POPUP_SELECTED = 2000160;
    public static final int TYPE_PAGE_SWIPED = 2000170;
    public static final int TYPE_PLAYLIST_SELECTED = 2000180;
    public static final int TYPE_ABOVE_GRID_SELECTED = 2000300;
    public static final int TYPE_START_APP_PHONE = 20010004;
    public static final int TYPE_HK_MEDIA = 30010004;
    public static final int TYPE_REQUEST_PREVIEW_UPDATE = 40010001;
    public static final int TYPE_REQUEST_DATA_UPDATE_FOR_HMI = 40010002;
}

