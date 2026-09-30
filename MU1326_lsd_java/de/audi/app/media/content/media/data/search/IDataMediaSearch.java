/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.content.media.data.search;

public interface IDataMediaSearch {
    public static final int[] WORDTYPELIST_NAME = new int[]{5};
    public static final int[] WORDTYPELIST_ALBUM = new int[]{15};
    public static final int[] WORDTYPELIST_ARTIST = new int[]{16};
    public static final int[] WORDTYPELIST_GENRE = new int[]{14};
    public static final int SEARCHFILTER_TYPE_DEFAULT = 1;
    public static final int SEARCHFILTER_TYPE_ADVANCE = 2;

    public void setSearchFilterType(int var1);

    public void setDefaultSearchFilter(int[] var1);
}

