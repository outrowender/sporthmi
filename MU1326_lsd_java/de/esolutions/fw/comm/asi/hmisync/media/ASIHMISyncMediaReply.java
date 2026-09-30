/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.hmisync.media;

import de.esolutions.fw.comm.asi.hmisync.media.MediaActiveSourceState;
import de.esolutions.fw.comm.asi.hmisync.media.MediaEntry;
import de.esolutions.fw.comm.asi.hmisync.media.MediaPlayTime;
import de.esolutions.fw.comm.asi.hmisync.media.MediaPlaylistState;
import de.esolutions.fw.comm.asi.hmisync.media.MediaSourceSlot;
import de.esolutions.fw.comm.core.method.MethodException;

public interface ASIHMISyncMediaReply {
    public static final String IPL_COMM_UUID = "d4078ff5-09f8-41d6-bc52-9680f105aea0";
    public static final String IPL_COMM_INTERFACE_KEY = "bfc935bd-08a4-581a-85b9-c997454d068b";
    public static final String IPL_COMM_INTERFACE_VERSION = "4.8.2";
    public static final String IPL_COMM_MODULE_VERSION = "1.0.00";

    public void indicationCmdBlocked(int var1) throws MethodException;

    public void responsePlayList(boolean var1, int var2, MediaEntry[] var3) throws MethodException;

    public void responseSetPlaySelection(boolean var1) throws MethodException;

    public void responsePlayMoreFrom(long var1, int var3, int var4) throws MethodException;

    public void updateASIVersion(String var1, boolean var2) throws MethodException;

    public void updateRequestIDs(short[] var1, boolean var2) throws MethodException;

    public void updateReplyIDs(short[] var1, boolean var2) throws MethodException;

    public void updateSourceList(MediaSourceSlot[] var1, boolean var2) throws MethodException;

    public void updateActiveSlotState(MediaActiveSourceState var1, boolean var2) throws MethodException;

    public void updatePlaybackState(int var1, boolean var2) throws MethodException;

    public void updateListState(MediaPlaylistState var1, boolean var2) throws MethodException;

    public void updatePlayerCapabilities(int var1, boolean var2) throws MethodException;

    public void updateMix(boolean var1, boolean var2) throws MethodException;

    public void updateRepeatTitle(boolean var1, boolean var2) throws MethodException;

    public void updateRepeatState(int var1, boolean var2) throws MethodException;

    public void updateShuffleState(int var1, boolean var2) throws MethodException;

    public void updatePlayingTrack(MediaEntry var1, boolean var2) throws MethodException;

    public void updatePlayPosition(MediaPlayTime var1, boolean var2) throws MethodException;

    public void updatePlaybackFolder(MediaEntry[] var1, boolean var2) throws MethodException;

    public void updatePlaybackPossible(int var1, boolean var2) throws MethodException;
}

