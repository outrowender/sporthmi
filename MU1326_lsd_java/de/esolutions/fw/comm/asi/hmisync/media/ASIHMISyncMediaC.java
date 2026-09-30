/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.hmisync.media;

import de.esolutions.fw.comm.asi.hmisync.media.MediaBrowserSelectionData;
import de.esolutions.fw.comm.asi.hmisync.media.MediaSourceSlot;
import de.esolutions.fw.comm.core.method.MethodException;

public interface ASIHMISyncMediaC {
    public void activate(MediaSourceSlot var1, MediaBrowserSelectionData var2) throws MethodException;

    public void resume() throws MethodException;

    public void pause() throws MethodException;

    public void skip(byte var1) throws MethodException;

    public void seek(boolean var1) throws MethodException;

    public void stopSeek() throws MethodException;

    public void mix(boolean var1) throws MethodException;

    public void repeatTitle(boolean var1) throws MethodException;

    public void toggleRepeatState() throws MethodException;

    public void toggleShuffleState() throws MethodException;

    public void setEntry(long var1) throws MethodException;

    public void setTimePosition(int var1) throws MethodException;

    public void touchEvent(int var1, int var2, int var3, int var4, int var5) throws MethodException;

    public void executeDvdVideoCommand(int var1) throws MethodException;

    public void requestPlayList(int var1, long var2, int var4) throws MethodException;

    public void setPlaySelection(MediaBrowserSelectionData var1) throws MethodException;

    public void playMoreFrom(long var1, int var3) throws MethodException;

    public void setNotification() throws MethodException;

    public void setNotification(long var1) throws MethodException;

    public void setNotification(long[] var1) throws MethodException;

    public void clearNotification() throws MethodException;

    public void clearNotification(long var1) throws MethodException;

    public void clearNotification(long[] var1) throws MethodException;
}

