/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.content.media.fileplayer.content;

import de.audi.app.media.content.media.IPlayerTrackListener;
import de.audi.app.media.content.media.MediaDetailInfo;
import de.audi.app.media.content.media.NullPlayer;
import de.audi.app.media.content.media.PlayingTrack;
import de.audi.app.media.content.media.fileplayer.FilePlayerSession;
import de.audi.app.media.content.media.fileplayer.content.IFilePlayer;
import de.audi.app.media.util.CopyOnWriteArrayList;
import de.audi.atip.log.LogChannel;
import java.util.Iterator;
import org.dsi.ifc.media.EntryInfo;

public class FilePlayerAdapterImpl
extends NullPlayer {
    private static final String LOGCLASS = "FilePlayerAdapterImpl";
    private static final int INVALID_SESSION_TYPE = -1;
    private final IFilePlayer filePlayer;
    private final LogChannel logger;
    private final CopyOnWriteArrayList trackListeners;
    private int activeSessionType = -1;

    public FilePlayerAdapterImpl(LogChannel logChannel, IFilePlayer iFilePlayer) {
        this.filePlayer = iFilePlayer;
        this.logger = logChannel;
        this.trackListeners = new CopyOnWriteArrayList();
    }

    public void activate() {
        this.logger.log(1000000, "[%1.activate]", (Object)LOGCLASS);
    }

    public void deactivate() {
        this.logger.log(1000000, "[%1.deactivate]", (Object)LOGCLASS);
        this.trackListeners.clear();
        this.activeSessionType = -1;
    }

    public void addTrackListener(IPlayerTrackListener iPlayerTrackListener) {
        this.logger.log(1000000, "[%1.addTrackListener] '%2'", (Object)LOGCLASS, (Object)iPlayerTrackListener);
        this.trackListeners.add(iPlayerTrackListener);
    }

    public void removeTrackListener(IPlayerTrackListener iPlayerTrackListener) {
        this.logger.log(1000000, "[%1.removeTrackListener] '%2'", (Object)LOGCLASS, (Object)iPlayerTrackListener);
        this.trackListeners.remove(iPlayerTrackListener);
    }

    public void updateActiveSessionType(int n) {
        if (this.activeSessionType == n) {
            this.logger.log(1000000, "[%1.updateActiveSessionType] Not changed.", (Object)LOGCLASS);
            return;
        }
        this.logger.log(1000000, "[%1.updateActiveSessionType] '%2'", (Object)LOGCLASS, (Object)(n == 0 ? "BOARDBOOK" : "RINGTONE"));
        this.activeSessionType = n;
        this.notifyActiveSessionTypeChanged();
    }

    private void notifyActiveSessionTypeChanged() {
        EntryInfo entryInfo = new EntryInfo();
        entryInfo.contentType = this.activeSessionType == 0 ? 2 : 1;
        MediaDetailInfo mediaDetailInfo = new MediaDetailInfo(entryInfo, new PlayingTrack(entryInfo.entryID, PlayingTrack.EMPTY_PLAYBACK_FOLDER));
        Iterator iterator = this.trackListeners.iterator();
        while (iterator.hasNext()) {
            try {
                ((IPlayerTrackListener)iterator.next()).detailInfoChanged(mediaDetailInfo);
            }
            catch (Exception exception) {
                this.logger.log(100000, "[%1.notifyActiveSessionTypeChanged]", (Object)LOGCLASS, (Throwable)exception);
            }
        }
    }

    private FilePlayerSession getActiveSession() {
        FilePlayerSession filePlayerSession = this.filePlayer.getState().getActiveSession();
        if (filePlayerSession == null || filePlayerSession.getOnState() != 1) {
            this.logger.log(1000000, "[%1.getActiveSession] No session active.", (Object)LOGCLASS);
            return null;
        }
        return filePlayerSession;
    }

    public void pause() {
        this.logger.log(1000000, "[%1.pause]", (Object)LOGCLASS);
        FilePlayerSession filePlayerSession = this.getActiveSession();
        if (filePlayerSession == null) {
            return;
        }
        filePlayerSession.getSessionPlayer().pause();
    }

    public void resume() {
        this.logger.log(1000000, "[%1.resume]", (Object)LOGCLASS);
        FilePlayerSession filePlayerSession = this.getActiveSession();
        if (filePlayerSession == null) {
            return;
        }
        filePlayerSession.getSessionPlayer().resume();
    }

    public boolean isPlaying() {
        FilePlayerSession filePlayerSession = this.getActiveSession();
        if (filePlayerSession == null) {
            return false;
        }
        return filePlayerSession.getState() == 2;
    }

    public boolean startSeek(boolean bl) {
        this.logger.log(1000000, "[%1.startSeek]", (Object)LOGCLASS);
        FilePlayerSession filePlayerSession = this.getActiveSession();
        if (filePlayerSession == null) {
            return false;
        }
        filePlayerSession.getSessionPlayer().seek(bl);
        return true;
    }

    public boolean stopSeek(boolean bl) {
        this.logger.log(1000000, "[%1.stopSeek]", (Object)LOGCLASS);
        this.resume();
        return true;
    }

    public boolean isSeeking() {
        FilePlayerSession filePlayerSession = this.getActiveSession();
        if (filePlayerSession == null) {
            return false;
        }
        return filePlayerSession.getState() == 4;
    }

    public boolean skip(boolean bl, int n) {
        this.logger.log(1000000, "[%1.skip] '%2','%3'", (Object)LOGCLASS, (Object)(bl ? "FORWARD" : "BACKWARD"), (long)n);
        FilePlayerSession filePlayerSession = this.getActiveSession();
        if (filePlayerSession == null) {
            return false;
        }
        if (n == 0) {
            return false;
        }
        filePlayerSession.getSessionPlayer().skip(bl ? n : n * -1);
        return true;
    }
}

