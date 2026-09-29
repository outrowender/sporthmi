/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.content.media.online;

import de.audi.app.media.content.media.online.OnlinePlayerSession;

public interface IOnlinePlayerController {
    default public OnlinePlayerSession getActiveSession() {
    }

    default public boolean isActiveSession(OnlinePlayerSession onlinePlayerSession) {
    }

    default public void addSessionToPendingList(OnlinePlayerSession onlinePlayerSession) {
    }

    default public void attachSession(OnlinePlayerSession onlinePlayerSession) {
    }

    default public void detachActiveSession() {
    }
}

