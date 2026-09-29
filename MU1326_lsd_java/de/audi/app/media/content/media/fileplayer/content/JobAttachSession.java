/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.content.media.fileplayer.content;

import de.audi.app.media.content.media.fileplayer.content.AbstractFilePlayerJob;
import de.audi.app.media.content.media.fileplayer.content.FilePlayerAdapterImpl;
import de.audi.app.media.content.media.fileplayer.content.FilePlayerContent$SessionPlayer;
import de.audi.app.media.content.media.fileplayer.content.IFilePlayer;
import de.audi.atip.interapp.media.IMediaFilePlayerSession;
import de.audi.atip.log.LogChannel;

public class JobAttachSession
extends AbstractFilePlayerJob {
    private static final String LOGCLASS;
    private final FilePlayerContent$SessionPlayer sessionPlayer;
    private final IMediaFilePlayerSession session;
    private final FilePlayerAdapterImpl adapter;

    public JobAttachSession(LogChannel logChannel, IFilePlayer iFilePlayer, FilePlayerContent$SessionPlayer filePlayerContent$SessionPlayer, FilePlayerAdapterImpl filePlayerAdapterImpl) {
        super(logChannel, "ATTACH", iFilePlayer);
        this.sessionPlayer = filePlayerContent$SessionPlayer;
        this.session = this.sessionPlayer.getSession();
        this.adapter = filePlayerAdapterImpl;
    }

    @Override
    public void start() {
        if (this.getPlayer().getState().getAudioState().getConnection() != this.session.getAudioConnection()) {
            this.logger.log(1078071040, "[%1.start] Request new audio connection.", (Object)"JobAttachSession");
            this.getPlayer().getAudioManager().requestAudio(this.session.getAudioConnection(), false);
            this.getPlayer().getAudioManager().resumeAudio(false);
            this.getPlayer().getAudioManager().requestVolumelock("File player attach session");
            return;
        }
        this.logger.log(1078071040, "[%1.start] Audio connection available.", (Object)"JobAttachSession");
        this.finishJob();
    }

    private void finishJob() {
        this.getPlayer().getState().setActiveSession(this.sessionPlayer.getSession());
        this.adapter.updateActiveSessionType(this.sessionPlayer.getSession().getType());
        this.session.updateVideoContext(this.getPlayer().getState().getPlayerID() == 1 ? 25 : 26);
        this.sessionPlayer.getSession().onActive(this.sessionPlayer);
        this.getExecutionContext().jobFinished();
    }

    @Override
    public void onAudioStateChanged() {
        this.logger.log(14808325, "[%1.onAudioStateChanged]", (Object)"JobAttachSession");
        if (this.getPlayer().getState().getAudioState().getConnection() != this.session.getAudioConnection()) {
            this.logger.log(1078071040, "[%1.onAudioStateChanged] Not the audio connection for the session.", (Object)"JobAttachSession");
            return;
        }
        if (this.getPlayer().getState().getAudioState().getState() != 0) {
            this.finishJob();
        }
    }
}

