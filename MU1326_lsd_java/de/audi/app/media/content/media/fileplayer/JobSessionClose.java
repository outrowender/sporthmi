/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.content.media.fileplayer;

import de.audi.app.media.content.media.fileplayer.AbstractFilePlayerControllerJob;
import de.audi.app.media.content.media.fileplayer.FilePlayerSession;
import de.audi.app.media.content.media.fileplayer.IFilePlayerController;
import de.audi.atip.interapp.media.IMediaFilePlayerSession;
import de.audi.atip.log.LogChannel;

public class JobSessionClose
extends AbstractFilePlayerControllerJob {
    private static final String LOGCLASS;
    private final FilePlayerSession session;
    private final IFilePlayerController controller;

    public JobSessionClose(LogChannel logChannel, IFilePlayerController iFilePlayerController, IMediaFilePlayerSession iMediaFilePlayerSession) {
        super(logChannel, "CLOSE");
        this.session = new FilePlayerSession(logChannel, iMediaFilePlayerSession);
        this.controller = iFilePlayerController;
    }

    @Override
    public void start() {
        if (this.controller.isActiveSession(this.session)) {
            this.logger.log(1078071040, "[%1.start] The active session. Detach it.", (Object)"JobSessionClose");
            this.controller.detachActiveSession();
            return;
        }
        this.logger.log(1078071040, "[%1.start] Not the active session.", (Object)"JobSessionClose");
        if (this.controller.removeSessionFromPendingList(this.session)) {
            this.logger.log(1078071040, "[%1.start] Session removed from pending list.", (Object)"JobSessionClose");
            this.session.onClose();
            this.getExecutionContext().jobFinished();
            return;
        }
        this.logger.log(1078071040, "[%1.start] Session already closed.", (Object)"JobSessionClose");
        this.getExecutionContext().jobFinished();
    }

    @Override
    public void onActiveSessionDetached() {
        this.logger.log(1078071040, "[%1.onActiveSessionDetached]", (Object)"JobSessionClose");
        this.session.onClose();
        FilePlayerSession filePlayerSession = this.controller.removeHighPrioSessionFromPendingList();
        this.controller.releaseAudio();
        if (filePlayerSession == null) {
            this.logger.log(1078071040, "[%1.onActiveSessionDetached] No next session available. Restore last source.", (Object)"JobSessionClose");
            this.controller.restoreLastAudioContext();
            this.getExecutionContext().jobFinished();
            return;
        }
        this.controller.attachSession(filePlayerSession);
        this.getExecutionContext().jobFinished();
    }

    @Override
    public String toString() {
        return this.session.getName();
    }
}

