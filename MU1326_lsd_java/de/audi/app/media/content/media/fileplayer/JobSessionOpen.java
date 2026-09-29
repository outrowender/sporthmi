/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.content.media.fileplayer;

import de.audi.app.media.content.media.fileplayer.AbstractFilePlayerControllerJob;
import de.audi.app.media.content.media.fileplayer.FilePlayerSession;
import de.audi.app.media.content.media.fileplayer.IFilePlayerController;
import de.audi.atip.interapp.media.IMediaFilePlayerSession;
import de.audi.atip.log.LogChannel;

public class JobSessionOpen
extends AbstractFilePlayerControllerJob {
    private static final String LOGCLASS;
    private static final int STATE_ACTIVATE_FILEPLAYER;
    private static final int STATE_WAITFOR_FILEPLAYER;
    private static final int STATE_FILEPLAYER_ACTIVE;
    private final IFilePlayerController controller;
    private final FilePlayerSession session;
    private final FilePlayerSession activeSession;
    private int state;

    public JobSessionOpen(LogChannel logChannel, IFilePlayerController iFilePlayerController, IMediaFilePlayerSession iMediaFilePlayerSession) {
        super(logChannel, "OPEN");
        this.controller = iFilePlayerController;
        this.session = new FilePlayerSession(this.logger, iMediaFilePlayerSession);
        this.activeSession = this.controller.getActiveSession();
    }

    @Override
    public void start() {
        this.setState(1);
    }

    private void setState(int n) {
        this.state = n;
        switch (n) {
            case 1: {
                this.logger.log(1078071040, "[%1.setState] STATE_ACTIVATE_FILEPLAYER", (Object)"JobSessionOpen");
                if (this.controller.activateFilePlayer()) {
                    this.setState(2);
                    return;
                }
                this.setState(3);
                break;
            }
            case 2: {
                this.logger.log(1078071040, "[%1.setState] STATE_WAITFOR_FILEPLAYER", (Object)"JobSessionOpen");
                break;
            }
            case 3: {
                this.logger.log(1078071040, "[%1.setState] STATE_FILEPLAYER_ACTIVE", (Object)"JobSessionOpen");
                if (this.controller.isActiveSession(this.session)) {
                    this.logger.log(1078071040, "[%1.setState] Session already opened.", (Object)"JobSessionOpen");
                    this.getExecutionContext().jobFinished();
                    return;
                }
                if (this.activeSession == null) {
                    this.logger.log(1078071040, "[%1.setState] No active session. Attach session.", (Object)"JobSessionOpen");
                    this.controller.attachSession(this.session);
                    this.getExecutionContext().jobFinished();
                    return;
                }
                if (this.activeSession.getPriority() >= this.session.getPriority()) {
                    this.logger.log(1078071040, "[%1.setState] Active session has higher priority.", (Object)"JobSessionOpen");
                    this.controller.addSessionToPendingList(this.session);
                    this.getExecutionContext().jobFinished();
                    return;
                }
                this.logger.log(1078071040, "[%1.setState] Session has higher priority then the active session. Detach active session.", (Object)"JobSessionOpen");
                this.controller.detachActiveSession();
                break;
            }
        }
    }

    @Override
    public void onFilePlayerActive() {
        this.logger.log(1078071040, "[%1.onFilePlayerActive]", (Object)"JobSessionOpen");
        if (this.state == 2) {
            this.setState(3);
        }
    }

    @Override
    public void onActiveSessionDetached() {
        this.logger.log(1078071040, "[%1.onActiveSessionDetached]", (Object)"JobSessionOpen");
        this.controller.addSessionToPendingList(this.activeSession);
        this.controller.attachSession(this.session);
        this.getExecutionContext().jobFinished();
    }

    @Override
    public String toString() {
        return this.session.getName();
    }
}

