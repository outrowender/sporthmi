/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.browser;

import de.audi.app.media.browser.IBrowseListContext;
import de.audi.app.media.browser.IBrowseListListener;
import de.audi.app.media.dsi.media.MediaListEntry;
import de.audi.app.media.source.ISourceSlot;

public class NullBrowseListContextImpl
implements IBrowseListContext {
    public ISourceSlot getSlot() {
        return null;
    }

    public int getBrowserID() {
        return -1;
    }

    public void changeFolder(MediaListEntry[] mediaListEntryArray) {
    }

    public void requestListByIndex(int n, int n2, int n3) {
    }

    public void requestListByEntryId(long l, int n, int n2, int n3) {
    }

    public void requestPickList(long[] lArray, int n) {
    }

    public void discardListRequest(int n) {
    }

    public void discardPickListRequest(int n) {
    }

    public void setBrowseMode(int n) {
    }

    public void addSelection(boolean bl, int n, long l, int n2, boolean bl2) {
    }

    public void resetSelection() {
    }

    public void addBrowseListListener(IBrowseListListener iBrowseListListener, boolean bl) {
    }

    public void removeAllBrowseListListener() {
    }

    public MediaListEntry[] getBrowseFolder() {
        return EMPTY_BROWSE_FOLDER;
    }

    public int getBrowseMode() {
        return -1;
    }

    public int getListSize() {
        return -1;
    }
}

