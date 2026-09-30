/*
 * Decompiled with CFR 0.152.
 */
package de.audi.audio.sdis.cmd;

import de.audi.audio.AudioEnv;
import de.audi.tghu.command.Command;
import org.dsi.ifc.media.DSIMediaRouter;

public class SdisCmdStreamRegister
extends Command {
    private final DSIMediaRouter dsiMediaRouter;
    private final int clientID;
    private final String ipAddress;
    private static final String PORT = "ADD_HERE";

    public SdisCmdStreamRegister(AudioEnv audioEnv, DSIMediaRouter dSIMediaRouter, int n, String string) {
        super(audioEnv.lcSDIS, "SdisCmdStreamRegister");
        this.dsiMediaRouter = dSIMediaRouter;
        this.clientID = n;
        this.ipAddress = string;
    }

    public void execute() {
        this.logger.log(10000000, "[SdisCmdStreamRegister.execute] -> DSIMediaRouter.registerClient()");
        this.logger.log(10000000, "[SdisCmdStreamRegister.execute] -> clientID:%3 ipAddress:%1 port:%2", (Object)this.ipAddress, (Object)PORT, (long)this.clientID);
        this.dsiMediaRouter.registerClient(this.clientID, this.ipAddress, PORT);
    }

    public void responseClientStatus(int n, int n2) {
        if (n != this.clientID) {
            this.logger.log(1000000, "[SdisCmdStreamRegister.responseClientStatus] Client ID mismatch %1 vs. %2", (long)this.clientID, (long)n);
            return;
        }
        if (n2 == 1) {
            this.logger.log(10000000, "[SdisCmdStreamRegister.responseClientStatus] Success -> finish command");
            this.commandList.commandFinished();
        } else if (n2 == 2) {
            this.logger.log(100000, "[SdisCmdStreamRegister.responseClientStatus] Failed -> abort command");
            this.commandList.commandAborted("Registration failed!");
        }
    }
}

