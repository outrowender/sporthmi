/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.content.media.fileplayer.content;

import de.audi.app.media.content.media.fileplayer.content.AbstractFilePlayerJob;
import de.audi.app.media.content.media.fileplayer.content.IFilePlayer;
import de.audi.atip.log.LogChannel;

public class JobActivation
extends AbstractFilePlayerJob {
    private static final String LOGCLASS = "JobActivation";
    private static final int STATE_WAIT_FOR_CAPABILITIES = 2;
    private static final int STATE_RECEIVE_CAPABILITIES = 3;
    private static final int STATE_WAIT_FOR_PLAYMODES = 4;
    private static final int STATE_RECEIVE_PLAYMODES = 5;
    private static final int STATE_ACTIVATION_FINISHED = 6;
    private int state;

    public JobActivation(LogChannel logChannel, IFilePlayer iFilePlayer) {
        super(logChannel, "ACTIVATION", iFilePlayer);
    }

    public void start() {
        this.logger.log(100000000, "[%1.start]", (Object)LOGCLASS);
        this.setState(2);
    }

    private void setState(int n) {
        this.state = n;
        switch (this.state) {
            case 2: {
                this.logger.log(1000000, "[%1.setState] STATE_WAIT_FOR_CAPABILITIES", (Object)LOGCLASS);
                break;
            }
            case 3: {
                this.logger.log(1000000, "[%1.setState] STATE_RECEIVE_CAPABILITIES", (Object)LOGCLASS);
                if (this.getPlayer().getState().getActiveSlot().getCapabilities().isPlaymodes()) {
                    this.setState(4);
                    return;
                }
                this.setState(6);
                break;
            }
            case 4: {
                this.logger.log(1000000, "[%1.setState] STATE_WAIT_FOR_PLAYMODES", (Object)LOGCLASS);
                break;
            }
            case 5: {
                this.logger.log(1000000, "[%1.setState] STATE_RECEIVE_PLAYMODES", (Object)LOGCLASS);
                this.setState(6);
                break;
            }
            case 6: {
                this.logger.log(1000000, "[%1.setState] STATE_ACTIVATION_FINISHED", (Object)LOGCLASS);
                this.getExecutionContext().jobFinished();
                break;
            }
        }
    }

    public void onCapabilitiesChanged() {
        this.logger.log(100000000, "[%1.onCapabilitiesChanged]", (Object)LOGCLASS);
        if (this.state == 2) {
            this.setState(3);
        }
    }

    public void onPlaybackModeListChanged() {
        this.logger.log(100000000, "[%1.onPlaybackModeListChanged]", (Object)LOGCLASS);
        if (this.state == 4) {
            this.setState(5);
        }
    }
}

