/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.dsi.media;

import de.audi.app.media.dsi.IDSIController;
import de.audi.app.media.dsi.media.IMediaBrowserListListener;
import de.audi.app.media.dsi.media.IMediaBrowserListener;
import de.audi.app.media.dsi.media.IMediaBrowserSearchListListener;
import de.audi.app.media.dsi.media.IMediaBrowserSearchListener;
import de.audi.app.media.dsi.media.IMediaBrowserStateListener;
import de.audi.app.media.dsi.media.MediaListEntry;
import de.audi.app.media.source.MediaSourceSlot;

public interface IMediaDSIBrowserController
extends IDSIController {
    public static final int BROWSERID_MAIN = 0;
    public static final int BROWSERID_SELECTION = 1;
    public static final int BROWSERID_GENERIC1 = 2;
    public static final int BROWSERID_GENERIC2 = 3;
    public static final int BROWSERID_SDIS1 = 4;
    public static final int BROWSERID_SDIS2 = 5;
    public static final int BROWSERID_GENERIC3 = 6;
    public static final int BROWSERID_RECORDER = 7;

    public void setBrowserStateListener(IMediaBrowserStateListener var1);

    public void setBrowserListener(IMediaBrowserListener var1);

    public void addBrowserListListener(IMediaBrowserListListener var1);

    public void removeAllBrowserListListener();

    public void setBrowserSearchListener(IMediaBrowserSearchListener var1);

    public void addBrowserSearchListListener(IMediaBrowserSearchListListener var1);

    public void removeBrowserSearchListListener(IMediaBrowserSearchListListener var1);

    public void activate(MediaSourceSlot var1);

    public void deactivate();

    public void setBrowseMode(int var1);

    public void setContentFilter(int var1);

    public void changeFolder(MediaListEntry[] var1);

    public void requestList(long var1, int var3, int var4, int var5, int var6);

    public void requestPickList(long[] var1, int var2);

    public void discardListRequest(int var1);

    public void discardPickListRequest(int var1);

    public void enableRecurseSubdirectories(boolean var1);

    public void addSelection(boolean var1, int var2, long var3, int var5, boolean var6);

    public void resetSelection();

    public void activateSearchSpeller();

    public void deactivateSearchSpeller();

    public void setSearchCriteria(int var1);

    public void setSearchString(String var1);

    public void resetSearchString();

    public void selectSearchResult(long var1);

    public void requestSearchList(long var1, int var3, int var4, int var5);

    public void requestSearchListExt(long var1, int var3, int var4, int var5);

    public void discardSearchListRequests(int var1);

    public void discardSearchListExtRequests(int var1);
}

