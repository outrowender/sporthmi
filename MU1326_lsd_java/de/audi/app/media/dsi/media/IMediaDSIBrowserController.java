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
    public static final int BROWSERID_MAIN;
    public static final int BROWSERID_SELECTION;
    public static final int BROWSERID_GENERIC1;
    public static final int BROWSERID_GENERIC2;
    public static final int BROWSERID_SDIS1;
    public static final int BROWSERID_SDIS2;
    public static final int BROWSERID_GENERIC3;
    public static final int BROWSERID_RECORDER;

    default public void setBrowserStateListener(IMediaBrowserStateListener iMediaBrowserStateListener) {
    }

    default public void setBrowserListener(IMediaBrowserListener iMediaBrowserListener) {
    }

    default public void addBrowserListListener(IMediaBrowserListListener iMediaBrowserListListener) {
    }

    default public void removeAllBrowserListListener() {
    }

    default public void setBrowserSearchListener(IMediaBrowserSearchListener iMediaBrowserSearchListener) {
    }

    default public void addBrowserSearchListListener(IMediaBrowserSearchListListener iMediaBrowserSearchListListener) {
    }

    default public void removeBrowserSearchListListener(IMediaBrowserSearchListListener iMediaBrowserSearchListListener) {
    }

    default public void activate(MediaSourceSlot mediaSourceSlot) {
    }

    default public void deactivate() {
    }

    default public void setBrowseMode(int n) {
    }

    default public void setContentFilter(int n) {
    }

    default public void changeFolder(MediaListEntry[] mediaListEntryArray) {
    }

    default public void requestList(long l, int n, int n2, int n3, int n4) {
    }

    default public void requestPickList(long[] lArray, int n) {
    }

    default public void discardListRequest(int n) {
    }

    default public void discardPickListRequest(int n) {
    }

    default public void enableRecurseSubdirectories(boolean bl) {
    }

    default public void addSelection(boolean bl, int n, long l, int n2, boolean bl2) {
    }

    default public void resetSelection() {
    }

    default public void activateSearchSpeller() {
    }

    default public void deactivateSearchSpeller() {
    }

    default public void setSearchCriteria(int n) {
    }

    default public void setSearchString(String string) {
    }

    default public void resetSearchString() {
    }

    default public void selectSearchResult(long l) {
    }

    default public void requestSearchList(long l, int n, int n2, int n3) {
    }

    default public void requestSearchListExt(long l, int n, int n2, int n3) {
    }

    default public void discardSearchListRequests(int n) {
    }

    default public void discardSearchListExtRequests(int n) {
    }
}

