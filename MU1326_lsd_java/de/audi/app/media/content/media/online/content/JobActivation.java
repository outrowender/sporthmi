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
    private static final String LOGCLASS = "JobActivation";
    private static final int STATE_WAIT_FOR_CAPABILITIES = 1;
    private static final int STATE_RECEIVE_CAPABILITIES = 2;
    private static final int STATE_ACTIVATION_FINISHED = 3;
    private int state;

    public JobActivation(LogChannel logChannel, IOnlinePlayer iOnlinePlayer) {
        super(logChannel, "ACTIVATION", iOnlinePlayer);
    }

    public void start() {
        this.logger.log(100000000, "[%1.start]", (Object)LOGCLASS);
        this.setState(1);
    }

    private void setState(int n) {
        this.state = n;
        switch (this.state) {
            case 1: {
                this.logger.log(1000000, "[%1.setState] STATE_WAIT_FOR_CAPABILITIES", (Object)LOGCLASS);
                break;
            }
            case 2: {
                this.logger.log(1000000, "[%1.setState] STATE_RECEIVE_CAPABILITIES", (Object)LOGCLASS);
                this.setState(3);
                break;
            }
            case 3: {
                this.logger.log(1000000, "[%1.setState] STATE_ACTIVATION_FINISHED", (Object)LOGCLASS);
                this.getExecutionContext().jobFinished();
                break;
            }
        }
    }

    public void onCapabilitiesChanged(Capabilities capabilities) {
        super.onCapabilitiesChanged(capabilities);
        this.logger.log(100000000, "[%1.onCapabilitiesChanged]", (Object)LOGCLASS);
        if (this.state == 1) {
            this.setState(2);
        }
    }
}

