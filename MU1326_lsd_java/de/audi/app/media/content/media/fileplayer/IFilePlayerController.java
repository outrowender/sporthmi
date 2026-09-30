/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.content.media.fileplayer;

import de.audi.app.media.content.media.fileplayer.FilePlayerSession;

public interface IFilePlayerController {
    public boolean activateFilePlayer();

    public FilePlayerSession getActiveSession();

    public boolean isActiveSession(FilePlayerSession var1);

    public void attachSession(FilePlayerSession var1);

    public void detachActiveSession();

    public void restoreLastAudioContext();

    public void releaseAudio();

    public void addSessionToPendingList(FilePlayerSession var1);

    public boolean removeSessionFromPendingList(FilePlayerSession var1);

    public FilePlayerSession removeHighPrioSessionFromPendingList();
}

