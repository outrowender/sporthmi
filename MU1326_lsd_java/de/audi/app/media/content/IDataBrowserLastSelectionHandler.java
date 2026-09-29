/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.content;

public interface IDataBrowserLastSelectionHandler {
    public static final int CATEGORY_UNDEFINED;
    public static final int CATEGORY_PHYSICAL;
    public static final int CATEGORY_TITLES;
    public static final int CATEGORY_ALBUMS;
    public static final int CATEGORY_ARTISTS;
    public static final int CATEGORY_GENRES;
    public static final int CATEGORY_PLAYLISTS;
    public static final int CATEGORY_VIDEOS;
    public static final int CATEGORY_PODCASTS;
    public static final int CATEGORY_AUDIOBOOKS;
    public static final int CATEGORY_COMPOSERS;
    public static final int CATEGORY_FAVORITES;
    public static final int CATEGORY_RADIO;
    public static final int CATEGORY_MAX_VALUE;

    default public void setLastCategorySelection(int n) {
    }

    default public void setSelectedCategory(int n) {
    }

    default public int getLastCategorySelection() {
    }
}

