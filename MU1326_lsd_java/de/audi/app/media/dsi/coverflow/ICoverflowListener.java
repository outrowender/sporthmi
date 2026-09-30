/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.dsi.coverflow;

import de.audi.app.media.dsi.coverflow.MediaAlbumInfo;

public interface ICoverflowListener {
    public static final byte STATE_BROWSER_UNKNOWN = 0;
    public static final byte STATE_BROWSER_INITIALIZED = 1;
    public static final byte STATE_BROWSER_ACTIVE = 2;
    public static final byte STATE_BROWSER_SCROLLING = 3;
    public static final byte STATE_BROWSER_SELECTING = 4;
    public static final byte STATE_BROWSER_PREVIEW = 5;
    public static final byte STATE_BROWSER_ANIMATION_OPEN = 6;
    public static final byte STATE_BROWSER_ANIMATION_CLOSE = 7;
    public static final byte STATE_BROWSER_ANIMATION_ENTRY = 8;
    public static final byte STATE_BROWSER_ANIMATION_PREVIEW_OPEN = 9;
    public static final byte STATE_BROWSER_ANIMATION_PREVIEW_CLOSE = 10;
    public static final byte STATE_BROWSER_ANIMATION_PREVIEW_SCROLLING = 11;
    public static final byte STATE_BROWSER_SINGLE = 12;
    public static final byte SCROLLMODE_NORMAL = 0;
    public static final byte SCROLLMODE_FAST = 1;

    public void responseSelectedAlbum(long var1);

    public void responseAlbumIdxForFid(long var1, long var3);

    public void updateBrowserState(int var1);

    public void updateFocusedEntry(MediaAlbumInfo var1);

    public void updateNumEntries(long var1);

    public void updateScrollMode(int var1);

    public void updateListPosition(long var1);

    public void asyncException(int var1, String var2, int var3);
}

