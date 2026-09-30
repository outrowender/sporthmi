/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.evo.content.data;

import de.audi.app.media.content.media.IPlayer;
import de.audi.app.media.dsi.media.MediaListEntry;
import de.audi.app.media.evo.content.data.DataBrowserListLocator;
import de.audi.app.media.evo.content.data.IDataBrowserListChangeListener;

public interface IDataBrowserList {
    public static final int LISTTYPE_UNDEFINED = 0;
    public static final int LISTTYPE_PHYSICAL = 1;
    public static final int LISTTYPE_TITELS = 2;
    public static final int LISTTYPE_ALBUMS = 3;
    public static final int LISTTYPE_ARTISTS = 4;
    public static final int LISTTYPE_GENRES = 5;
    public static final int LISTTYPE_PLAYLISTS = 6;
    public static final int LISTTYPE_VIDEOS = 7;
    public static final int LISTTYPE_COMPOSERS = 8;
    public static final int LISTTYPE_AUDIOBOOKS = 9;
    public static final int LISTTYPE_PODCASTS = 10;
    public static final int LAYOUT_1L_TITLE = 0;
    public static final int LAYOUT_1L_FILENAME = 1;
    public static final int LAYOUT_2L_TITLE_ARTIST = 2;
    public static final int LAYOUT_2L_TITLE_ALBUM_ARTIST = 3;
    public static final int PATHTYPE_LIST = 0;
    public static final int PATHTYPE_SEARCH = 1;
    public static final int PATHTYPE_BROWSER_SEARCH = 2;

    public void addBrowseListChangeListener(IDataBrowserListChangeListener var1);

    public void removeBrowseListChangeListener(IDataBrowserListChangeListener var1);

    public boolean selectBrowseListPath(DataBrowserListLocator var1);

    public void selectEntry(MediaListEntry var1);

    public boolean changeToParentFolder();

    public boolean isReady();

    public IPlayer getPlayer();
}

