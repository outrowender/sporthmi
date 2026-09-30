/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.content.media.online;

import de.audi.app.media.content.media.online.AbstractOnlinePlayerControllerJob;
import de.audi.app.media.content.media.online.IOnlinePlayerController;
import de.audi.app.media.content.media.online.OnlinePlayerSession;
import de.audi.atip.interapp.media.IMediaOnlinePlayerSession;
import de.audi.atip.log.LogChannel;

public class JobSessionClose
extends AbstractOnlinePlayerControllerJob {
    private static final String LOGCLASS = "JobSessionClose";
    private final OnlinePlayerSession session;
    private final IOnlinePlayerController controller;

    public JobSessionClose(LogChannel logChannel, IOnlinePlayerController iOnlinePlayerController, IMediaOnlinePlayerSession iMediaOnlinePlayerSession) {
        super(logChannel, "CLOSE");
        this.session = new OnlinePlayerSession(logChannel, iMediaOnlinePlayerSession);
        this.controller = iOnlinePlayerController;
    }

    public void start() {
        this.logger.log(10000000, "[%1.start]", (Object)LOGCLASS);
        if (this.controller.isActiveSession(this.session)) {
            this.logger.log(1000000, "[%1.start] The active session. Detach it.", (Object)LOGCLASS);
            this.controller.detachActiveSession();
            return;
        }
        this.logger.log(1000000, "[%1.start] Not the active session.", (Object)LOGCLASS);
        this.getExecutionContext().jobFinished();
    }

    public void onActiveSessionDetached() {
        this.logger.log(10000000, "[%1.onActiveSessionDetached]", (Object)LOGCLASS);
        this.session.onClose();
        this.getExecutionContext().jobFinished();
    }

    public String toString() {
        return this.session.getName();
    }
}

