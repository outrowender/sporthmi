/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.online.app.remotehmi.onlinemedia;

import de.audi.remotehmi.media.IOnlineMediaSession;

public interface IPlaytimeStrategy {
    default public void updatePlayPosition(int n, int n2) {
    }

    default public void updateBufferPosition(IOnlineMediaSession iOnlineMediaSession) {
    }
}

