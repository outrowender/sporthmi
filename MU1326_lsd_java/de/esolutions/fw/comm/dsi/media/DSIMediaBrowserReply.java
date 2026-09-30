/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.media;

import de.esolutions.fw.comm.core.method.MethodException;
import org.dsi.ifc.global.CharacterInfo;
import org.dsi.ifc.media.ListEntry;
import org.dsi.ifc.media.SearchListEntry;
import org.dsi.ifc.media.SearchListEntryExt;

public interface DSIMediaBrowserReply {
    public static final String IPL_COMM_UUID = "4bd972e8-016b-5b8e-8843-5e9da71bd889";
    public static final String IPL_COMM_INTERFACE_KEY = "eb2373f8-8839-59fb-ab05-f2b59647a61b";
    public static final String IPL_COMM_INTERFACE_VERSION = "2.11.52";
    public static final String IPL_COMM_MODULE_VERSION = "2.11.52";

    public void updateBrowseMode(int var1, int var2) throws MethodException;

    public void updateContentFilter(int var1, int var2) throws MethodException;

    public void updateBrowseMedia(long var1, long var3, int var5) throws MethodException;

    public void updateBrowseFolder(ListEntry[] var1, int var2) throws MethodException;

    public void updateListSize(int var1, int var2, int var3) throws MethodException;

    public void updateAlphabeticalIndex(CharacterInfo[] var1, int var2) throws MethodException;

    public void responseList(ListEntry[] var1, int var2) throws MethodException;

    public void responsePickList(ListEntry[] var1) throws MethodException;

    public void selectionResult(int var1, int var2, boolean var3, long var4, long var6, long var8, long var10, long var12) throws MethodException;

    public void responseSetSearchCriteria(int var1, boolean var2) throws MethodException;

    public void updateSearchSize(int var1, int var2, int var3, int var4, int var5) throws MethodException;

    public void responseSelectSearchResult(long var1, long var3, boolean var5) throws MethodException;

    public void responseSetSearchString(String var1, boolean var2) throws MethodException;

    public void updateSearchSpellerState(int var1, int var2) throws MethodException;

    public void responseSearchList(SearchListEntry[] var1, int var2) throws MethodException;

    public void responseSearchListExt(SearchListEntryExt[] var1, int var2) throws MethodException;

    public void responseFullyQualifiedName(long var1, String var3) throws MethodException;

    public void asyncException(int var1, String var2, int var3) throws MethodException;

    public void yyIndication(String var1, String var2) throws MethodException;
}

