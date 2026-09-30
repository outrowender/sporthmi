/*
 * Decompiled with CFR 0.152.
 */
package de.audi.audio.sdis.cmd;

import de.audi.audio.AudioEnv;
import de.audi.tghu.command.Command;
import org.dsi.ifc.media.DSIMediaRouter;

public class SdisCmdStreamUnregister
extends Command {
    private final DSIMediaRouter dsiMediaRouter;
    private final int clientID;

    public SdisCmdStreamUnregister(AudioEnv audioEnv, DSIMediaRouter dSIMediaRouter, int n) {
        super(audioEnv.lcSDIS, "SdisCmdStreamUnregister");
        this.dsiMediaRouter = dSIMediaRouter;
        this.clientID = n;
    }

    public void execute() {
        this.logger.log(10000000, "[SdisCmdStreamUnregister.execute] -> DSIMediaRouter.unregisterClient()");
        this.logger.log(10000000, "[SdisCmdStreamUnregister.execute] -> clientID:%1", (long)this.clientID);
        this.dsiMediaRouter.unregisterClient(this.clientID);
        this.commandList.commandFinished();
    }
}

