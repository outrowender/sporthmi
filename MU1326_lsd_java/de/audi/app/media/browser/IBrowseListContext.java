/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.browser;

import de.audi.app.media.browser.IBrowseListListener;
import de.audi.app.media.dsi.media.MediaListEntry;
import de.audi.app.media.source.ISourceSlot;

public interface IBrowseListContext {
    public static final int BROWSEMODE_UNDEFINED = -1;
    public static final int BROWSEMODE_RAW = 0;
    public static final int BROWSEMODE_DATABASE = 1;
    public static final int INVALID_LIST_SIZE = -1;
    public static final MediaListEntry[] EMPTY_BROWSE_FOLDER = new MediaListEntry[0];

    public int getBrowserID();

    public ISourceSlot getSlot();

    public void changeFolder(MediaListEntry[] var1);

    public MediaListEntry[] getBrowseFolder();

    public int getListSize();

    public void requestListByIndex(int var1, int var2, int var3);

    public void requestListByEntryId(long var1, int var3, int var4, int var5);

    public void requestPickList(long[] var1, int var2);

    public void discardListRequest(int var1);

    public void discardPickListRequest(int var1);

    public void setBrowseMode(int var1);

    public int getBrowseMode();

    public void addSelection(boolean var1, int var2, long var3, int var5, boolean var6);

    public void resetSelection();

    public void addBrowseListListener(IBrowseListListener var1, boolean var2);

    public void removeAllBrowseListListener();
}

