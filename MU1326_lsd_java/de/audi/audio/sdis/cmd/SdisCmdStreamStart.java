/*
 * Decompiled with CFR 0.152.
 */
package de.audi.audio.sdis.cmd;

import de.audi.audio.AudioEnv;
import de.audi.audio.sdis.SdisStreamState;
import de.audi.tghu.command.Command;
import org.dsi.ifc.media.DSIMediaRouter;

public class SdisCmdStreamStart
extends Command {
    private final DSIMediaRouter dsiMediaRouter;
    private final int clientID;
    private SdisStreamState streamState;

    public SdisCmdStreamStart(AudioEnv audioEnv, DSIMediaRouter dSIMediaRouter, int n, SdisStreamState sdisStreamState) {
        super(audioEnv.lcSDIS, "SdisCmdStreamStart");
        this.dsiMediaRouter = dSIMediaRouter;
        this.clientID = n;
        this.streamState = sdisStreamState;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void execute() {
        this.logger.log(-2137614336, "[SdisCmdStreamStart.execute] -> DSIMediaRouter.startStreaming()");
        this.logger.log(-2137614336, "[SdisCmdStreamStart.execute] -> clientID:%1", (long)this.clientID);
        if (!this.streamState.reconfigureMediaRouterNecessary() && !this.streamState.isCurrentStreamStatusNotStarted()) {
            this.logger.log(-2137614336, "[SdisCmdStreamStart.execute] reconfigure: %1 streamer started: %2. Nothing to do.", this.streamState.reconfigureMediaRouterNecessary(), this.streamState.isCurrentStreamStatusNotStarted());
            this.commandList.commandFinished();
            return;
        }
        this.dsiMediaRouter.startStreaming(this.clientID);
        this.streamState.setStreamStatus(1);
        SdisCmdStreamStart sdisCmdStreamStart = this;
        synchronized (sdisCmdStreamStart) {
            try {
                super.wait(0);
            }
            catch (InterruptedException interruptedException) {
                this.logger.log(10000, "[SdisCmdStreamStart.execute] -> clientID:%1 interrupted exception %2", (long)this.clientID, (Throwable)interruptedException);
            }
        }
        this.commandList.commandFinished();
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void updateStreamingStatus(int n, int n2) {
        if (n != this.clientID) {
            this.logger.log(-1601830656, "[SdisCmdStreamStart.updateStreamingStatus] ClientID mismatch %1 vs. %2", (long)this.clientID, (long)n);
            return;
        }
        this.streamState.setStreamStatus(this.streamState.getHMIStreamStatus(n2));
        SdisCmdStreamStart sdisCmdStreamStart = this;
        synchronized (sdisCmdStreamStart) {
            super.notifyAll();
        }
    }
}

