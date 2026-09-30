/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.dsi.media;

import org.dsi.ifc.media.SearchListEntry;
import org.dsi.ifc.media.SearchListEntryExt;

public interface IMediaBrowserSearchListListener {
    public static final int LIST_REQUEST_CLIENT_CONTROLLER = 1;
    public static final int LIST_REQUEST_CLIENT_FASTSCROLL_HANDLER = 2;

    public int getClientID();

    public void responseSearchList(SearchListEntry[] var1, int var2);

    public void responseSearchListExt(SearchListEntryExt[] var1, int var2);
}

