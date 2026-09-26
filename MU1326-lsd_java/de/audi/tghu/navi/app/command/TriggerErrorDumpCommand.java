/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.command;

import de.audi.tghu.navi.app.command.NavCommand;

public class TriggerErrorDumpCommand
extends NavCommand {
    @Override
    public void execute() {
        Long l;
        long l2 = this.env.getFramework().getKombiTime();
        long l3 = l2 - (l = (Long)this.getCommandList().get("STARTING_TIME_KEY"));
        if (l3 > 0) {
            this.logger.log(10000, "TriggerErrorDumpCommand#CommandList was running for too long: %1", l3);
            this.env.getFramework().getErrorMgr().handleError(null, new StringBuffer().append("CommandList was running for too long: ").append(l3).toString(), 1, 0, 0);
        }
        this.getCommandList().commandFinished();
    }
}

