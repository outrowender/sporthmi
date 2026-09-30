/*
 * Decompiled with CFR 0.152.
 */
package de.audi.audio.sdis.cmd;

import de.audi.audio.AudioEnv;
import de.audi.audio.sdis.SdisStreamState;
import de.audi.tghu.command.Command;
import org.dsi.ifc.media.DSIMediaRouter;

public class SdisCmdStreamStop
extends Command {
    private final DSIMediaRouter dsiMediaRouter;
    private final int clientID;
    private SdisStreamState streamState;
    private boolean force;

    public SdisCmdStreamStop(AudioEnv audioEnv, DSIMediaRouter dSIMediaRouter, int n, SdisStreamState sdisStreamState, boolean bl) {
        super(audioEnv.lcSDIS, "SdisCmdStreamStop");
        this.dsiMediaRouter = dSIMediaRouter;
        this.clientID = n;
        this.streamState = sdisStreamState;
        this.force = bl;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void execute() {
        this.logger.log(10000000, "[SdisCmdStreamStop.execute] -> DSIMediaRouter.stopStreaming()");
        this.logger.log(10000000, "[SdisCmdStreamStop.execute] -> clientID:%1, force:%2", (Object)String.valueOf(this.clientID), (Object)String.valueOf(this.force));
        if (!this.streamState.reconfigureMediaRouterNecessary() && !this.force) {
            this.logger.log(10000000, "[SdisCmdStreamStop.execute] reconfigure: %1. Nothing to do.", this.streamState.reconfigureMediaRouterNecessary());
            this.commandList.commandFinished();
            return;
        }
        this.dsiMediaRouter.stopStreaming(this.clientID);
        this.streamState.setStreamStatus(3);
        SdisCmdStreamStop sdisCmdStreamStop = this;
        synchronized (sdisCmdStreamStop) {
            try {
                this.wait(100L);
            }
            catch (InterruptedException interruptedException) {
                this.logger.log(10000, "[SdisCmdStreamStop.execute] -> clientID:%1 interrupted exception %2", (long)this.clientID, (Throwable)interruptedException);
            }
        }
        this.commandList.commandFinished();
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void updateStreamingStatus(int n, int n2) {
        if (n != this.clientID) {
            this.logger.log(100000, "[SdisCmdStreamStop.updateStreamingStatus] ClientID mismatch %1 vs. %2", (long)this.clientID, (long)n);
            return;
        }
        this.logger.log(10000000, "[SdisCmdStreamStop.updateStreamingStatus] finish stopStreamingCommand");
        SdisCmdStreamStop sdisCmdStreamStop = this;
        synchronized (sdisCmdStreamStop) {
            this.notifyAll();
        }
    }
}

