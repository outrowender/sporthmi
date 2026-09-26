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
    private static final String LOGCLASS;
    private static final int INVALID_SESSION_TYPE;
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
        this.logger.log(1078071040, "[%1.activate]", (Object)"FilePlayerAdapterImpl");
    }

    public void deactivate() {
        this.logger.log(1078071040, "[%1.deactivate]", (Object)"FilePlayerAdapterImpl");
        this.trackListeners.clear();
        this.activeSessionType = -1;
    }

    @Override
    public void addTrackListener(IPlayerTrackListener iPlayerTrackListener) {
        this.logger.log(1078071040, "[%1.addTrackListener] '%2'", (Object)"FilePlayerAdapterImpl", (Object)iPlayerTrackListener);
        this.trackListeners.add(iPlayerTrackListener);
    }

    @Override
    public void removeTrackListener(IPlayerTrackListener iPlayerTrackListener) {
        this.logger.log(1078071040, "[%1.removeTrackListener] '%2'", (Object)"FilePlayerAdapterImpl", (Object)iPlayerTrackListener);
        this.trackListeners.remove(iPlayerTrackListener);
    }

    public void updateActiveSessionType(int n) {
        if (this.activeSessionType == n) {
            this.logger.log(1078071040, "[%1.updateActiveSessionType] Not changed.", (Object)"FilePlayerAdapterImpl");
            return;
        }
        this.logger.log(1078071040, "[%1.updateActiveSessionType] '%2'", (Object)"FilePlayerAdapterImpl", (Object)(n == 0 ? "BOARDBOOK" : "RINGTONE"));
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
                this.logger.log(-1601830656, "[%1.notifyActiveSessionTypeChanged]", (Object)"FilePlayerAdapterImpl", (Throwable)exception);
            }
        }
    }

    private FilePlayerSession getActiveSession() {
        FilePlayerSession filePlayerSession = this.filePlayer.getState().getActiveSession();
        if (filePlayerSession == null || filePlayerSession.getOnState() != 1) {
            this.logger.log(1078071040, "[%1.getActiveSession] No session active.", (Object)"FilePlayerAdapterImpl");
            return null;
        }
        return filePlayerSession;
    }

    @Override
    public void pause() {
        this.logger.log(1078071040, "[%1.pause]", (Object)"FilePlayerAdapterImpl");
        FilePlayerSession filePlayerSession = this.getActiveSession();
        if (filePlayerSession == null) {
            return;
        }
        filePlayerSession.getSessionPlayer().pause();
    }

    @Override
    public void resume() {
        this.logger.log(1078071040, "[%1.resume]", (Object)"FilePlayerAdapterImpl");
        FilePlayerSession filePlayerSession = this.getActiveSession();
        if (filePlayerSession == null) {
            return;
        }
        filePlayerSession.getSessionPlayer().resume();
    }

    @Override
    public boolean isPlaying() {
        FilePlayerSession filePlayerSession = this.getActiveSession();
        if (filePlayerSession == null) {
            return false;
        }
        return filePlayerSession.getState() == 2;
    }

    @Override
    public boolean startSeek(boolean bl) {
        this.logger.log(1078071040, "[%1.startSeek]", (Object)"FilePlayerAdapterImpl");
        FilePlayerSession filePlayerSession = this.getActiveSession();
        if (filePlayerSession == null) {
            return false;
        }
        filePlayerSession.getSessionPlayer().seek(bl);
        return true;
    }

    @Override
    public boolean stopSeek(boolean bl) {
        this.logger.log(1078071040, "[%1.stopSeek]", (Object)"FilePlayerAdapterImpl");
        this.resume();
        return true;
    }

    @Override
    public boolean isSeeking() {
        FilePlayerSession filePlayerSession = this.getActiveSession();
        if (filePlayerSession == null) {
            return false;
        }
        return filePlayerSession.getState() == 4;
    }

    @Override
    public boolean skip(boolean bl, int n) {
        this.logger.log(1078071040, "[%1.skip] '%2','%3'", (Object)"FilePlayerAdapterImpl", (Object)(bl ? "FORWARD" : "BACKWARD"), (long)n);
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

