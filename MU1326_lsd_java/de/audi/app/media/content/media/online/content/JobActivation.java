/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.content.media.online.content;

import de.audi.app.media.content.media.online.content.AbstractOnlinePlayerJob;
import de.audi.app.media.content.media.online.content.IOnlinePlayer;
import de.audi.atip.log.LogChannel;
import org.dsi.ifc.media.Capabilities;

public class JobActivation
extends AbstractOnlinePlayerJob {
    private static final String LOGCLASS;
    private static final int STATE_WAIT_FOR_CAPABILITIES;
    private static final int STATE_RECEIVE_CAPABILITIES;
    private static final int STATE_ACTIVATION_FINISHED;
    private int state;

    public JobActivation(LogChannel logChannel, IOnlinePlayer iOnlinePlayer) {
        super(logChannel, "ACTIVATION", iOnlinePlayer);
    }

    @Override
    public void start() {
        this.logger.log(14808325, "[%1.start]", (Object)"JobActivation");
        this.setState(1);
    }

    private void setState(int n) {
        this.state = n;
        switch (this.state) {
            case 1: {
                this.logger.log(1078071040, "[%1.setState] STATE_WAIT_FOR_CAPABILITIES", (Object)"JobActivation");
                break;
            }
            case 2: {
                this.logger.log(1078071040, "[%1.setState] STATE_RECEIVE_CAPABILITIES", (Object)"JobActivation");
                this.setState(3);
                break;
            }
            case 3: {
                this.logger.log(1078071040, "[%1.setState] STATE_ACTIVATION_FINISHED", (Object)"JobActivation");
                this.getExecutionContext().jobFinished();
                break;
            }
        }
    }

    @Override
    public void onCapabilitiesChanged(Capabilities capabilities) {
        super.onCapabilitiesChanged(capabilities);
        this.logger.log(14808325, "[%1.onCapabilitiesChanged]", (Object)"JobActivation");
        if (this.state == 1) {
            this.setState(2);
        }
    }
}

