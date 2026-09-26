/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.interapp.media;

import de.audi.atip.interapp.media.IMediaPlayerSession;

public interface IMediaOnlinePlayerSession
extends IMediaPlayerSession {
    public static final int TYPE_ONLINE_RADIO;
    public static final int TYPE_ONLINE_MEDIA;
    public static final int BUFFER_STATE_UNDEFINED;
    public static final int BUFFER_STATE_FILLED;
    public static final int BUFFER_STATE_UNDERRUN;

    default public String getServiceID() {
    }

    default public String getUrl() {
    }

    default public void updateBufferState(int n, int n2) {
    }

    default public void trackChanged(long l) {
    }

    default public void updateCapabilities(boolean bl, boolean bl2, boolean bl3, boolean bl4, boolean bl5, boolean bl6) {
    }

    default public void updatePlaybackMode(boolean bl, boolean bl2) {
    }

    default public void updateSkipCount(boolean bl, int n) {
    }

    default public void responseDetailInfo(String string, String string2, String string3, String string4) {
    }
}

