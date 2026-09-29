/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.online.app.remotehmi.onlinemedia;

import de.audi.remotehmi.media.IOnlineMediaSession;
import de.audi.tghu.online.app.remotehmi.onlinemedia.IPlaytimeStrategy;
import de.audi.tghu.online.app.remotehmi.onlinemedia.OnlineMediaSession;

public interface IMediaSessionListener {
    default public void updatePlayPosition(int n, int n2) {
    }

    default public void processState(IOnlineMediaSession iOnlineMediaSession) {
    }

    default public void close(OnlineMediaSession onlineMediaSession) {
    }

    default public void processGenericEvent(String string, IOnlineMediaSession iOnlineMediaSession, Object object) {
    }

    default public void processShuffleChanged(IOnlineMediaSession iOnlineMediaSession, boolean bl) {
    }

    default public void processRepeatChanged(IOnlineMediaSession iOnlineMediaSession, boolean bl) {
    }

    default public void setPlaytimeStrategy(IPlaytimeStrategy iPlaytimeStrategy) {
    }

    default public void processBufferChangedEvent(IOnlineMediaSession iOnlineMediaSession) {
    }

    default public void processSkipEvent(IOnlineMediaSession iOnlineMediaSession) {
    }

    default public void updateMetadata(String string, String string2, String string3, String string4) {
    }
}

