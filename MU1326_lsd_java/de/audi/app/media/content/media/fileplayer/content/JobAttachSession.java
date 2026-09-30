/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.content.media.fileplayer.content;

import de.audi.app.media.content.media.fileplayer.content.AbstractFilePlayerJob;
import de.audi.app.media.content.media.fileplayer.content.FilePlayerAdapterImpl;
import de.audi.app.media.content.media.fileplayer.content.FilePlayerContent;
import de.audi.app.media.content.media.fileplayer.content.IFilePlayer;
import de.audi.atip.interapp.media.IMediaFilePlayerSession;
import de.audi.atip.log.LogChannel;

public class JobAttachSession
extends AbstractFilePlayerJob {
    private static final String LOGCLASS = "JobAttachSession";
    private final FilePlayerContent.SessionPlayer sessionPlayer;
    private final IMediaFilePlayerSession session;
    private final FilePlayerAdapterImpl adapter;

    public JobAttachSession(LogChannel logChannel, IFilePlayer iFilePlayer, FilePlayerContent.SessionPlayer sessionPlayer, FilePlayerAdapterImpl filePlayerAdapterImpl) {
        super(logChannel, "ATTACH", iFilePlayer);
        this.sessionPlayer = sessionPlayer;
        this.session = this.sessionPlayer.getSession();
        this.adapter = filePlayerAdapterImpl;
    }

    public void start() {
        if (this.getPlayer().getState().getAudioState().getConnection() != this.session.getAudioConnection()) {
            this.logger.log(1000000, "[%1.start] Request new audio connection.", (Object)LOGCLASS);
            this.getPlayer().getAudioManager().requestAudio(this.session.getAudioConnection(), false);
            this.getPlayer().getAudioManager().resumeAudio(false);
            this.getPlayer().getAudioManager().requestVolumelock("File player attach session");
            return;
        }
        this.logger.log(1000000, "[%1.start] Audio connection available.", (Object)LOGCLASS);
        this.finishJob();
    }

    private void finishJob() {
        this.getPlayer().getState().setActiveSession(this.sessionPlayer.getSession());
        this.adapter.updateActiveSessionType(this.sessionPlayer.getSession().getType());
        this.session.updateVideoContext(this.getPlayer().getState().getPlayerID() == 1 ? 25 : 26);
        this.sessionPlayer.getSession().onActive(this.sessionPlayer);
        this.getExecutionContext().jobFinished();
    }

    public void onAudioStateChanged() {
        this.logger.log(100000000, "[%1.onAudioStateChanged]", (Object)LOGCLASS);
        if (this.getPlayer().getState().getAudioState().getConnection() != this.session.getAudioConnection()) {
            this.logger.log(1000000, "[%1.onAudioStateChanged] Not the audio connection for the session.", (Object)LOGCLASS);
            return;
        }
        if (this.getPlayer().getState().getAudioState().getState() != 0) {
            this.finishJob();
        }
    }
}

