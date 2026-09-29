/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.content.media.fileplayer.content;

import de.audi.app.media.content.media.fileplayer.content.AbstractFilePlayerJob;
import de.audi.app.media.content.media.fileplayer.content.IFilePlayer;
import de.audi.atip.log.LogChannel;

public class JobActivation
extends AbstractFilePlayerJob {
    private static final String LOGCLASS;
    private static final int STATE_WAIT_FOR_CAPABILITIES;
    private static final int STATE_RECEIVE_CAPABILITIES;
    private static final int STATE_WAIT_FOR_PLAYMODES;
    private static final int STATE_RECEIVE_PLAYMODES;
    private static final int STATE_ACTIVATION_FINISHED;
    private int state;

    public JobActivation(LogChannel logChannel, IFilePlayer iFilePlayer) {
        super(logChannel, "ACTIVATION", iFilePlayer);
    }

    @Override
    public void start() {
        this.logger.log(14808325, "[%1.start]", (Object)"JobActivation");
        this.setState(2);
    }

    private void setState(int n) {
        this.state = n;
        switch (this.state) {
            case 2: {
                this.logger.log(1078071040, "[%1.setState] STATE_WAIT_FOR_CAPABILITIES", (Object)"JobActivation");
                break;
            }
            case 3: {
                this.logger.log(1078071040, "[%1.setState] STATE_RECEIVE_CAPABILITIES", (Object)"JobActivation");
                if (this.getPlayer().getState().getActiveSlot().getCapabilities().isPlaymodes()) {
                    this.setState(4);
                    return;
                }
                this.setState(6);
                break;
            }
            case 4: {
                this.logger.log(1078071040, "[%1.setState] STATE_WAIT_FOR_PLAYMODES", (Object)"JobActivation");
                break;
            }
            case 5: {
                this.logger.log(1078071040, "[%1.setState] STATE_RECEIVE_PLAYMODES", (Object)"JobActivation");
                this.setState(6);
                break;
            }
            case 6: {
                this.logger.log(1078071040, "[%1.setState] STATE_ACTIVATION_FINISHED", (Object)"JobActivation");
                this.getExecutionContext().jobFinished();
                break;
            }
        }
    }

    @Override
    public void onCapabilitiesChanged() {
        this.logger.log(14808325, "[%1.onCapabilitiesChanged]", (Object)"JobActivation");
        if (this.state == 2) {
            this.setState(3);
        }
    }

    @Override
    public void onPlaybackModeListChanged() {
        this.logger.log(14808325, "[%1.onPlaybackModeListChanged]", (Object)"JobActivation");
        if (this.state == 4) {
            this.setState(5);
        }
    }
}

