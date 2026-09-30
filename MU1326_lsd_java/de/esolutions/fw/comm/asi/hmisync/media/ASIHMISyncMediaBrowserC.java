/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.hmisync.media;

import de.esolutions.fw.comm.asi.hmisync.media.MediaEntry;
import de.esolutions.fw.comm.asi.hmisync.media.MediaSourceSlot;
import de.esolutions.fw.comm.core.method.MethodException;

public interface ASIHMISyncMediaBrowserC {
    public void activate(MediaSourceSlot var1) throws MethodException;

    public void deactivate() throws MethodException;

    public void setBrowseMode(int var1) throws MethodException;

    public void changeFolder(MediaEntry[] var1) throws MethodException;

    public void addSelection(int var1, MediaEntry var2) throws MethodException;

    public void requestList(int var1, long var2, int var4, int var5) throws MethodException;

    public void setNotification() throws MethodException;

    public void setNotification(long var1) throws MethodException;

    public void setNotification(long[] var1) throws MethodException;

    public void clearNotification() throws MethodException;

    public void clearNotification(long var1) throws MethodException;

    public void clearNotification(long[] var1) throws MethodException;
}

