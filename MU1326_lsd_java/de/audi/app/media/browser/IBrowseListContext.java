/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.browser;

import de.audi.app.media.browser.IBrowseListListener;
import de.audi.app.media.dsi.media.MediaListEntry;
import de.audi.app.media.source.ISourceSlot;

public interface IBrowseListContext {
    public static final int BROWSEMODE_UNDEFINED;
    public static final int BROWSEMODE_RAW;
    public static final int BROWSEMODE_DATABASE;
    public static final int INVALID_LIST_SIZE;
    public static final MediaListEntry[] EMPTY_BROWSE_FOLDER;

    default public int getBrowserID() {
    }

    default public ISourceSlot getSlot() {
    }

    default public void changeFolder(MediaListEntry[] mediaListEntryArray) {
    }

    default public MediaListEntry[] getBrowseFolder() {
    }

    default public int getListSize() {
    }

    default public void requestListByIndex(int n, int n2, int n3) {
    }

    default public void requestListByEntryId(long l, int n, int n2, int n3) {
    }

    default public void requestPickList(long[] lArray, int n) {
    }

    default public void discardListRequest(int n) {
    }

    default public void discardPickListRequest(int n) {
    }

    default public void setBrowseMode(int n) {
    }

    default public int getBrowseMode() {
    }

    default public void addSelection(boolean bl, int n, long l, int n2, boolean bl2) {
    }

    default public void resetSelection() {
    }

    default public void addBrowseListListener(IBrowseListListener iBrowseListListener, boolean bl) {
    }

    default public void removeAllBrowseListListener() {
    }

    static {
        EMPTY_BROWSE_FOLDER = new MediaListEntry[0];
    }
}

