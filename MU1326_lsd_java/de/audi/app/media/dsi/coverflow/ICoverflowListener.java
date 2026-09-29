/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.dsi.coverflow;

import de.audi.app.media.dsi.coverflow.MediaAlbumInfo;

public interface ICoverflowListener {
    public static final byte STATE_BROWSER_UNKNOWN;
    public static final byte STATE_BROWSER_INITIALIZED;
    public static final byte STATE_BROWSER_ACTIVE;
    public static final byte STATE_BROWSER_SCROLLING;
    public static final byte STATE_BROWSER_SELECTING;
    public static final byte STATE_BROWSER_PREVIEW;
    public static final byte STATE_BROWSER_ANIMATION_OPEN;
    public static final byte STATE_BROWSER_ANIMATION_CLOSE;
    public static final byte STATE_BROWSER_ANIMATION_ENTRY;
    public static final byte STATE_BROWSER_ANIMATION_PREVIEW_OPEN;
    public static final byte STATE_BROWSER_ANIMATION_PREVIEW_CLOSE;
    public static final byte STATE_BROWSER_ANIMATION_PREVIEW_SCROLLING;
    public static final byte STATE_BROWSER_SINGLE;
    public static final byte SCROLLMODE_NORMAL;
    public static final byte SCROLLMODE_FAST;

    default public void responseSelectedAlbum(long l) {
    }

    default public void responseAlbumIdxForFid(long l, long l2) {
    }

    default public void updateBrowserState(int n) {
    }

    default public void updateFocusedEntry(MediaAlbumInfo mediaAlbumInfo) {
    }

    default public void updateNumEntries(long l) {
    }

    default public void updateScrollMode(int n) {
    }

    default public void updateListPosition(long l) {
    }

    default public void asyncException(int n, String string, int n2) {
    }
}

