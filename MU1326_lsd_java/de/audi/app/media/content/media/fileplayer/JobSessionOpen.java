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
    private static final String LOGCLASS = "JobSessionOpen";
    private static final int STATE_ACTIVATE_FILEPLAYER = 1;
    private static final int STATE_WAITFOR_FILEPLAYER = 2;
    private static final int STATE_FILEPLAYER_ACTIVE = 3;
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

    public void start() {
        this.setState(1);
    }

    private void setState(int n) {
        this.state = n;
        switch (n) {
            case 1: {
                this.logger.log(1000000, "[%1.setState] STATE_ACTIVATE_FILEPLAYER", (Object)LOGCLASS);
                if (this.controller.activateFilePlayer()) {
                    this.setState(2);
                    return;
                }
                this.setState(3);
                break;
            }
            case 2: {
                this.logger.log(1000000, "[%1.setState] STATE_WAITFOR_FILEPLAYER", (Object)LOGCLASS);
                break;
            }
            case 3: {
                this.logger.log(1000000, "[%1.setState] STATE_FILEPLAYER_ACTIVE", (Object)LOGCLASS);
                if (this.controller.isActiveSession(this.session)) {
                    this.logger.log(1000000, "[%1.setState] Session already opened.", (Object)LOGCLASS);
                    this.getExecutionContext().jobFinished();
                    return;
                }
                if (this.activeSession == null) {
                    this.logger.log(1000000, "[%1.setState] No active session. Attach session.", (Object)LOGCLASS);
                    this.controller.attachSession(this.session);
                    this.getExecutionContext().jobFinished();
                    return;
                }
                if (this.activeSession.getPriority() >= this.session.getPriority()) {
                    this.logger.log(1000000, "[%1.setState] Active session has higher priority.", (Object)LOGCLASS);
                    this.controller.addSessionToPendingList(this.session);
                    this.getExecutionContext().jobFinished();
                    return;
                }
                this.logger.log(1000000, "[%1.setState] Session has higher priority then the active session. Detach active session.", (Object)LOGCLASS);
                this.controller.detachActiveSession();
                break;
            }
        }
    }

    public void onFilePlayerActive() {
        this.logger.log(1000000, "[%1.onFilePlayerActive]", (Object)LOGCLASS);
        if (this.state == 2) {
            this.setState(3);
        }
    }

    public void onActiveSessionDetached() {
        this.logger.log(1000000, "[%1.onActiveSessionDetached]", (Object)LOGCLASS);
        this.controller.addSessionToPendingList(this.activeSession);
        this.controller.attachSession(this.session);
        this.getExecutionContext().jobFinished();
    }

    public String toString() {
        return this.session.getName();
    }
}

