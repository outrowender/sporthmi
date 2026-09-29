/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.content.media.fileplayer;

import de.audi.app.media.content.media.fileplayer.FilePlayerSession;

public interface IFilePlayerController {
    default public boolean activateFilePlayer() {
    }

    default public FilePlayerSession getActiveSession() {
    }

    default public boolean isActiveSession(FilePlayerSession filePlayerSession) {
    }

    default public void attachSession(FilePlayerSession filePlayerSession) {
    }

    default public void detachActiveSession() {
    }

    default public void restoreLastAudioContext() {
    }

    default public void releaseAudio() {
    }

    default public void addSessionToPendingList(FilePlayerSession filePlayerSession) {
    }

    default public boolean removeSessionFromPendingList(FilePlayerSession filePlayerSession) {
    }

    default public FilePlayerSession removeHighPrioSessionFromPendingList() {
    }
}

