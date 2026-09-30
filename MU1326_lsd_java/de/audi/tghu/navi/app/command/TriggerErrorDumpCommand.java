/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.command;

import de.audi.tghu.navi.app.command.NavCommand;

public class TriggerErrorDumpCommand
extends NavCommand {
    public void execute() {
        Long l;
        long l2 = this.env.getFramework().getKombiTime();
        long l3 = l2 - (l = (Long)this.getCommandList().get("STARTING_TIME_KEY"));
        if (l3 > 60000L) {
            this.logger.log(10000, "TriggerErrorDumpCommand#CommandList was running for too long: %1", l3);
            this.env.getFramework().getErrorMgr().handleError(null, "CommandList was running for too long: " + l3, 1, 0, 0);
        }
        this.getCommandList().commandFinished();
    }
}

