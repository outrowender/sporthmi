/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.media;

import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.global.CharacterInfo;
import org.dsi.ifc.media.ListEntry;
import org.dsi.ifc.media.SearchListEntry;
import org.dsi.ifc.media.SearchListEntryExt;

public interface DSIMediaBrowserListener
extends DSIListener {
    public void updateBrowseMode(int var1, int var2);

    public void updateContentFilter(int var1, int var2);

    public void updateBrowseMedia(long var1, long var3, int var5);

    public void updateBrowseFolder(ListEntry[] var1, int var2);

    public void updateListSize(int var1, int var2, int var3);

    public void updateAlphabeticalIndex(CharacterInfo[] var1, int var2);

    public void responseList(ListEntry[] var1, int var2);

    public void responsePickList(ListEntry[] var1);

    public void selectionResult(int var1, int var2, boolean var3, long var4, long var6, long var8, long var10, long var12);

    public void responseSetSearchCriteria(int var1, boolean var2);

    public void updateSearchSize(int var1, int var2, int var3, int var4, int var5);

    public void responseSelectSearchResult(long var1, long var3, boolean var5);

    public void responseSetSearchString(String var1, boolean var2);

    public void updateSearchSpellerState(int var1, int var2);

    public void responseSearchList(SearchListEntry[] var1, int var2);

    public void responseSearchListExt(SearchListEntryExt[] var1, int var2);

    public void responseFullyQualifiedName(long var1, String var3);
}

