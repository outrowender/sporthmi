/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.albumbrowser;

import de.esolutions.fw.comm.core.method.MethodException;
import org.dsi.ifc.albumbrowser.AlbumEntryInfo;

public interface DSIAlbumBrowserReply {
    public static final String IPL_COMM_UUID = "11bb0e6e-82d5-5623-848e-eeb35a1a5bb1";
    public static final String IPL_COMM_INTERFACE_KEY = "7b023b24-ce3d-579c-b971-3ace26adedfb";
    public static final String IPL_COMM_INTERFACE_VERSION = "2.11.6";
    public static final String IPL_COMM_MODULE_VERSION = "2.11.6";

    public void updateBrowserState(int var1, int var2) throws MethodException;

    public void updateFocusedEntry(AlbumEntryInfo var1, int var2) throws MethodException;

    public void updateListPosition(long var1, int var3) throws MethodException;

    public void updateNumEntries(long var1, int var3) throws MethodException;

    public void updateScrollMode(int var1, int var2) throws MethodException;

    public void selectAlbum(long var1) throws MethodException;

    public void albumIdxForFID(long var1, long var3) throws MethodException;

    public void asyncException(int var1, String var2, int var3) throws MethodException;

    public void yyIndication(String var1, String var2) throws MethodException;
}

