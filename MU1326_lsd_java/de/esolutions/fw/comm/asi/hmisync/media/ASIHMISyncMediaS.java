/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.hmisync.media;

import de.esolutions.fw.comm.asi.hmisync.media.ASIHMISyncMediaReply;
import de.esolutions.fw.comm.asi.hmisync.media.MediaBrowserSelectionData;
import de.esolutions.fw.comm.asi.hmisync.media.MediaSourceSlot;
import de.esolutions.fw.comm.core.method.MethodException;

public interface ASIHMISyncMediaS {
    public void activate(MediaSourceSlot var1, MediaBrowserSelectionData var2, ASIHMISyncMediaReply var3) throws MethodException;

    public void resume(ASIHMISyncMediaReply var1) throws MethodException;

    public void pause(ASIHMISyncMediaReply var1) throws MethodException;

    public void skip(byte var1, ASIHMISyncMediaReply var2) throws MethodException;

    public void seek(boolean var1, ASIHMISyncMediaReply var2) throws MethodException;

    public void stopSeek(ASIHMISyncMediaReply var1) throws MethodException;

    public void mix(boolean var1, ASIHMISyncMediaReply var2) throws MethodException;

    public void repeatTitle(boolean var1, ASIHMISyncMediaReply var2) throws MethodException;

    public void toggleRepeatState(ASIHMISyncMediaReply var1) throws MethodException;

    public void toggleShuffleState(ASIHMISyncMediaReply var1) throws MethodException;

    public void setEntry(long var1, ASIHMISyncMediaReply var3) throws MethodException;

    public void setTimePosition(int var1, ASIHMISyncMediaReply var2) throws MethodException;

    public void touchEvent(int var1, int var2, int var3, int var4, int var5, ASIHMISyncMediaReply var6) throws MethodException;

    public void executeDvdVideoCommand(int var1, ASIHMISyncMediaReply var2) throws MethodException;

    public void requestPlayList(int var1, long var2, int var4, ASIHMISyncMediaReply var5) throws MethodException;

    public void setPlaySelection(MediaBrowserSelectionData var1, ASIHMISyncMediaReply var2) throws MethodException;

    public void playMoreFrom(long var1, int var3, ASIHMISyncMediaReply var4) throws MethodException;

    public void setNotification(ASIHMISyncMediaReply var1) throws MethodException;

    public void setNotification(long var1, ASIHMISyncMediaReply var3) throws MethodException;

    public void setNotification(long[] var1, ASIHMISyncMediaReply var2) throws MethodException;

    public void clearNotification(ASIHMISyncMediaReply var1) throws MethodException;

    public void clearNotification(long var1, ASIHMISyncMediaReply var3) throws MethodException;

    public void clearNotification(long[] var1, ASIHMISyncMediaReply var2) throws MethodException;
}

