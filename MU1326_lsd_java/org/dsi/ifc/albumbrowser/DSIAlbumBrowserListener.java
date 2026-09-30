/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.albumbrowser;

import org.dsi.ifc.albumbrowser.AlbumEntryInfo;
import org.dsi.ifc.base.DSIListener;

public interface DSIAlbumBrowserListener
extends DSIListener {
    public void updateBrowserState(int var1, int var2);

    public void updateFocusedEntry(AlbumEntryInfo var1, int var2);

    public void updateListPosition(long var1, int var3);

    public void updateNumEntries(long var1, int var3);

    public void updateScrollMode(int var1, int var2);

    public void selectAlbum(long var1);

    public void albumIdxForFID(long var1, long var3);
}

