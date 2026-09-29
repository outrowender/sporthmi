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
    private static final String LOGCLASS;
    private final OnlinePlayerSession session;
    private final IOnlinePlayerController controller;

    public JobSessionClose(LogChannel logChannel, IOnlinePlayerController iOnlinePlayerController, IMediaOnlinePlayerSession iMediaOnlinePlayerSession) {
        super(logChannel, "CLOSE");
        this.session = new OnlinePlayerSession(logChannel, iMediaOnlinePlayerSession);
        this.controller = iOnlinePlayerController;
    }

    @Override
    public void start() {
        this.logger.log(-2137614336, "[%1.start]", (Object)"JobSessionClose");
        if (this.controller.isActiveSession(this.session)) {
            this.logger.log(1078071040, "[%1.start] The active session. Detach it.", (Object)"JobSessionClose");
            this.controller.detachActiveSession();
            return;
        }
        this.logger.log(1078071040, "[%1.start] Not the active session.", (Object)"JobSessionClose");
        this.getExecutionContext().jobFinished();
    }

    @Override
    public void onActiveSessionDetached() {
        this.logger.log(-2137614336, "[%1.onActiveSessionDetached]", (Object)"JobSessionClose");
        this.session.onClose();
        this.getExecutionContext().jobFinished();
    }

    @Override
    public String toString() {
        return this.session.getName();
    }
}

