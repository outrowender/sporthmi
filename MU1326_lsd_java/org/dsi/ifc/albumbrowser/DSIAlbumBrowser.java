/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.albumbrowser;

import org.dsi.ifc.base.DSIBase;

public interface DSIAlbumBrowser
extends DSIBase {
    public static final String VERSION = "2.11.6";
    public static final int ATTR_BROWSERSTATE = 1;
    public static final int ATTR_FOCUSEDENTRY = 2;
    public static final int ATTR_NUMENTRIES = 3;
    public static final int ATTR_SCROLLMODE = 4;
    public static final int ATTR_LISTPOSITION = 5;
    public static final int RT_INITIALIZEBROWSER = 1000;
    public static final int RT_DEINITIALIZEBROWSER = 1001;
    public static final int RT_STARTACTIVE = 1002;
    public static final int RT_STOP = 1003;
    public static final int RT_SETSCROLLMODE = 1004;
    public static final int RT_SCROLLTICKS = 1005;
    public static final int RT_SELECTALBUM = 1006;
    public static final int RT_MOVEFOCUS = 1007;
    public static final int RT_ALBUMIDXFORFID = 1008;
    public static final int RT_STARTPREVIEW = 1009;
    public static final int RT_STARTSINGLE = 1010;
    public static final int RP_SELECTALBUM = 2000;
    public static final int RP_ALBUMIDXFORFID = 2001;
    public static final int BROWSERSTATE_STATE_UNKNOWN = 0;
    public static final int BROWSERSTATE_STATE_INITIALIZED = 1;
    public static final int BROWSERSTATE_STATE_ACTIVE = 2;
    public static final int BROWSERSTATE_STATE_SCROLLING = 3;
    public static final int BROWSERSTATE_STATE_SELECTING = 4;
    public static final int BROWSERSTATE_STATE_ANIMATION_ENTRY = 5;
    public static final int BROWSERSTATE_STATE_PREVIEW = 6;
    public static final int BROWSERSTATE_STATE_ANIMATION_OPEN = 7;
    public static final int BROWSERSTATE_STATE_ANIMATION_CLOSE = 8;
    public static final int BROWSERSTATE_STATE_ANIMATION_PREV_OPEN = 9;
    public static final int BROWSERSTATE_STATE_ANIMATION_PREVSCROLLING = 10;
    public static final int BROWSERSTATE_STATE_SINGLE = 11;
    public static final int BROWSERSTATE_STATE_ANIMATION_PREV_CLOSE = 12;
    public static final int SCROLLMODE_SCROLLMODE_NORMAL = 0;
    public static final int SCROLLMODE_SCROLLMODE_FAST = 1;
    public static final int ANIMATIONMODE_ANIMATIONMODE_STILL = 0;
    public static final int ANIMATIONMODE_ANIMATIONMODE_ANIMATE = 1;
    public static final int ALBUMFLAGS_ENTRYFLAG_UNKNOWN_ALBUM = 1;
    public static final int ALBUMFLAGS_ENTRYFLAG_UNKNOWN_ARTIST = 2;

    public void initializeBrowser(long var1, long var3, int var5);

    public void deinitializeBrowser();

    public void startSingle();

    public void startPreview();

    public void startActive();

    public void stop();

    public void setScrollMode(int var1);

    public void scrollTicks(long var1);

    public void selectAlbum(long var1);

    public void moveFocus(long var1, int var3);

    public void albumIdxForFID(long var1);
}

