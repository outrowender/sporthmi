/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.content.media.online;

import de.audi.app.media.content.IContentManager;
import de.audi.app.media.content.media.online.AbstractOnlinePlayerControllerJob;
import de.audi.app.media.content.media.online.IOnlinePlayerController;
import de.audi.app.media.content.media.online.OnlinePlayerSession;
import de.audi.app.media.source.ISourceController;
import de.audi.app.media.source.ISourceSlot;
import de.audi.atip.log.LogChannel;

public class JobSessionOpen
extends AbstractOnlinePlayerControllerJob {
    private static final String LOGCLASS;
    private static final int STATE_GET_ACTIVE_SOURCE_STATE;
    private static final int STATE_WAITFOR_ONLINEPLAYER;
    private static final int STATE_ONLINEPLAYER_ACTIVE;
    private static final int STATE_WAITFOR_ONLINECONTENT;
    private final IOnlinePlayerController controller;
    private final ISourceController sourceController;
    private final IContentManager contentManager;
    private final OnlinePlayerSession session;
    private int state;

    public JobSessionOpen(LogChannel logChannel, IOnlinePlayerController iOnlinePlayerController, ISourceController iSourceController, IContentManager iContentManager, OnlinePlayerSession onlinePlayerSession) {
        super(logChannel, "OPEN");
        this.controller = iOnlinePlayerController;
        this.contentManager = iContentManager;
        this.sourceController = iSourceController;
        this.session = onlinePlayerSession;
    }

    @Override
    public void start() {
        if (null != this.sourceController.getSource(13)) {
            this.setState(0);
        } else {
            this.logger.log(-1601830656, "[%1.start] Online source is not available!");
            this.getExecutionContext().jobFinished();
        }
    }

    private void setState(int n) {
        this.state = n;
        switch (n) {
            case 0: {
                this.logger.log(1078071040, "[%1.setState] STATE_GET_ACTIVE_SOURCE_STATE", (Object)"JobSessionOpen");
                ISourceSlot iSourceSlot = this.sourceController.getSelectedSlot();
                if (iSourceSlot.getSource().getType() == 13) {
                    this.logger.log(1078071040, "[%1.setState] Online source already active.", (Object)"JobSessionOpen");
                    if (iSourceSlot.getMountPoint().equals(this.session.getServiceID())) {
                        this.logger.log(1078071040, "[%1.setState] Slot for session already active.", (Object)"JobSessionOpen");
                        if (this.contentManager.getActiveContent() != null && this.contentManager.getActiveContent().getContentType() == 8) {
                            this.logger.log(1078071040, "[%1.setState] Content already active.", (Object)"JobSessionOpen");
                            this.setState(3);
                            return;
                        }
                        this.setState(4);
                        return;
                    }
                    this.logger.log(1078071040, "[%1.setState] Online Source is not the active source -> ignore openSession.", (Object)"JobSessionOpen");
                    this.getExecutionContext().jobFinished();
                    return;
                }
                this.logger.log(-1601830656, "[%1.setState] Slot for service '%2' not found.", (Object)"JobSessionOpen", (Object)this.session.getServiceID());
                this.getExecutionContext().jobFinished();
                return;
            }
            case 4: {
                this.logger.log(1078071040, "[%1.setState] STATE_WAITFOR_ONLINECONTENT", (Object)"JobSessionOpen");
                break;
            }
            case 2: {
                this.logger.log(1078071040, "[%1.setState] STATE_WAITFOR_ONLINEPLAYER", (Object)"JobSessionOpen");
                break;
            }
            case 3: {
                this.logger.log(1078071040, "[%1.setState] STATE_ONLINEPLAYER_ACTIVE", (Object)"JobSessionOpen");
                if (this.controller.isActiveSession(this.session) && this.controller.getActiveSession().getState() != 6) {
                    this.logger.log(1078071040, "[%1.setState] Session already opened.", (Object)"JobSessionOpen");
                    this.getExecutionContext().jobFinished();
                    return;
                }
                if (this.controller.getActiveSession() == null || this.controller.getActiveSession().getState() == 6) {
                    this.logger.log(1078071040, "[%1.setState] Attach session.", (Object)"JobSessionOpen");
                    this.controller.attachSession(this.session);
                    this.getExecutionContext().jobFinished();
                    return;
                }
                this.logger.log(-1601830656, "[%1.setState] +++ WRONG STATE +++", (Object)"JobSessionOpen");
                this.getExecutionContext().jobFinished();
                break;
            }
        }
    }

    @Override
    public void onOnlineContentActivated() {
        this.logger.log(14808325, "[%1.onOnlineContentActivated]", (Object)"JobSessionOpen");
        if (this.state == 4) {
            this.setState(3);
        }
    }

    @Override
    public void onActiveSessionDetached() {
        this.logger.log(14808325, "[%1.onActiveSessionDetached]", (Object)"JobSessionOpen");
        this.controller.addSessionToPendingList(this.controller.getActiveSession());
        this.controller.attachSession(this.session);
        this.getExecutionContext().jobFinished();
    }

    @Override
    public void onOnlineSourceDeactivated() {
        this.logger.log(14808325, "[%1.onOnlineSourceDeactivated]", (Object)"JobSessionOpen");
        this.getExecutionContext().jobFinished();
    }

    @Override
    public String toString() {
        return this.session.getName();
    }
}

