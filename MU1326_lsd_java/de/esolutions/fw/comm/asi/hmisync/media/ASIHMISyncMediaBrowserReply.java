/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.hmisync.media;

import de.esolutions.fw.comm.asi.hmisync.media.MediaEntry;
import de.esolutions.fw.comm.asi.hmisync.media.MediaSourceSlot;
import de.esolutions.fw.comm.core.method.MethodException;

public interface ASIHMISyncMediaBrowserReply {
    public static final String IPL_COMM_UUID = "d77696f4-48c5-4b8c-9855-fe17f312507c";
    public static final String IPL_COMM_INTERFACE_KEY = "45baad1f-9553-5ee9-b624-8c7cb4344305";
    public static final String IPL_COMM_INTERFACE_VERSION = "2.2.00";
    public static final String IPL_COMM_MODULE_VERSION = "1.0.00";

    public void responseChangeFolder(boolean var1) throws MethodException;

    public void responseAddSelection(boolean var1) throws MethodException;

    public void responseList(boolean var1, int var2, MediaEntry[] var3) throws MethodException;

    public void updateASIVersion(String var1, boolean var2) throws MethodException;

    public void updateRequestIDs(short[] var1, boolean var2) throws MethodException;

    public void updateReplyIDs(short[] var1, boolean var2) throws MethodException;

    public void updateActiveSlot(MediaSourceSlot var1, boolean var2) throws MethodException;

    public void updateBrowseMode(int var1, boolean var2) throws MethodException;

    public void updateDatabaseMode(boolean var1, boolean var2) throws MethodException;

    public void updateRawMode(boolean var1, boolean var2) throws MethodException;

    public void updateBrowseFolder(MediaEntry[] var1, boolean var2) throws MethodException;

    public void updateListSize(int var1, boolean var2) throws MethodException;
}

