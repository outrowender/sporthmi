/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.content;

public interface IDataBrowserLastSelectionHandler {
    public static final int CATEGORY_UNDEFINED = 0;
    public static final int CATEGORY_PHYSICAL = 1;
    public static final int CATEGORY_TITLES = 2;
    public static final int CATEGORY_ALBUMS = 3;
    public static final int CATEGORY_ARTISTS = 4;
    public static final int CATEGORY_GENRES = 5;
    public static final int CATEGORY_PLAYLISTS = 6;
    public static final int CATEGORY_VIDEOS = 7;
    public static final int CATEGORY_PODCASTS = 8;
    public static final int CATEGORY_AUDIOBOOKS = 9;
    public static final int CATEGORY_COMPOSERS = 10;
    public static final int CATEGORY_FAVORITES = 11;
    public static final int CATEGORY_RADIO = 12;
    public static final int CATEGORY_MAX_VALUE = 12;

    public void setLastCategorySelection(int var1);

    public void setSelectedCategory(int var1);

    public int getLastCategorySelection();
}

