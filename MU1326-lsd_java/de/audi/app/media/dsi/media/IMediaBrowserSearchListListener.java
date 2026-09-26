/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.dsi.media;

import org.dsi.ifc.media.SearchListEntry;
import org.dsi.ifc.media.SearchListEntryExt;

public interface IMediaBrowserSearchListListener {
    public static final int LIST_REQUEST_CLIENT_CONTROLLER;
    public static final int LIST_REQUEST_CLIENT_FASTSCROLL_HANDLER;

    default public int getClientID() {
    }

    default public void responseSearchList(SearchListEntry[] searchListEntryArray, int n) {
    }

    default public void responseSearchListExt(SearchListEntryExt[] searchListEntryExtArray, int n) {
    }
}

