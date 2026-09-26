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
    @Override
    public ISourceSlot getSlot() {
        return null;
    }

    @Override
    public int getBrowserID() {
        return -1;
    }

    @Override
    public void changeFolder(MediaListEntry[] mediaListEntryArray) {
    }

    @Override
    public void requestListByIndex(int n, int n2, int n3) {
    }

    @Override
    public void requestListByEntryId(long l, int n, int n2, int n3) {
    }

    @Override
    public void requestPickList(long[] lArray, int n) {
    }

    @Override
    public void discardListRequest(int n) {
    }

    @Override
    public void discardPickListRequest(int n) {
    }

    @Override
    public void setBrowseMode(int n) {
    }

    @Override
    public void addSelection(boolean bl, int n, long l, int n2, boolean bl2) {
    }

    @Override
    public void resetSelection() {
    }

    @Override
    public void addBrowseListListener(IBrowseListListener iBrowseListListener, boolean bl) {
    }

    @Override
    public void removeAllBrowseListListener() {
    }

    @Override
    public MediaListEntry[] getBrowseFolder() {
        return EMPTY_BROWSE_FOLDER;
    }

    @Override
    public int getBrowseMode() {
        return -1;
    }

    @Override
    public int getListSize() {
        return -1;
    }
}

