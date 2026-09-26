/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.evo.content.data;

import de.audi.app.media.content.media.IPlayer;
import de.audi.app.media.dsi.media.MediaListEntry;
import de.audi.app.media.evo.content.data.DataBrowserListLocator;
import de.audi.app.media.evo.content.data.IDataBrowserListChangeListener;

public interface IDataBrowserList {
    public static final int LISTTYPE_UNDEFINED;
    public static final int LISTTYPE_PHYSICAL;
    public static final int LISTTYPE_TITELS;
    public static final int LISTTYPE_ALBUMS;
    public static final int LISTTYPE_ARTISTS;
    public static final int LISTTYPE_GENRES;
    public static final int LISTTYPE_PLAYLISTS;
    public static final int LISTTYPE_VIDEOS;
    public static final int LISTTYPE_COMPOSERS;
    public static final int LISTTYPE_AUDIOBOOKS;
    public static final int LISTTYPE_PODCASTS;
    public static final int LAYOUT_1L_TITLE;
    public static final int LAYOUT_1L_FILENAME;
    public static final int LAYOUT_2L_TITLE_ARTIST;
    public static final int LAYOUT_2L_TITLE_ALBUM_ARTIST;
    public static final int PATHTYPE_LIST;
    public static final int PATHTYPE_SEARCH;
    public static final int PATHTYPE_BROWSER_SEARCH;

    default public void addBrowseListChangeListener(IDataBrowserListChangeListener iDataBrowserListChangeListener) {
    }

    default public void removeBrowseListChangeListener(IDataBrowserListChangeListener iDataBrowserListChangeListener) {
    }

    default public boolean selectBrowseListPath(DataBrowserListLocator dataBrowserListLocator) {
    }

    default public void selectEntry(MediaListEntry mediaListEntry) {
    }

    default public boolean changeToParentFolder() {
    }

    default public boolean isReady() {
    }

    default public IPlayer getPlayer() {
    }
}

