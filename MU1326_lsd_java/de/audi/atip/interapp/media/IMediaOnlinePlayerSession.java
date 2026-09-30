/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.interapp.media;

import de.audi.atip.interapp.media.IMediaPlayerSession;

public interface IMediaOnlinePlayerSession
extends IMediaPlayerSession {
    public static final int TYPE_ONLINE_RADIO = 0;
    public static final int TYPE_ONLINE_MEDIA = 1;
    public static final int BUFFER_STATE_UNDEFINED = 0;
    public static final int BUFFER_STATE_FILLED = 2;
    public static final int BUFFER_STATE_UNDERRUN = 1;

    public String getServiceID();

    public String getUrl();

    public void updateBufferState(int var1, int var2);

    public void trackChanged(long var1);

    public void updateCapabilities(boolean var1, boolean var2, boolean var3, boolean var4, boolean var5, boolean var6);

    public void updatePlaybackMode(boolean var1, boolean var2);

    public void updateSkipCount(boolean var1, int var2);

    public void responseDetailInfo(String var1, String var2, String var3, String var4);
}

