/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.terminalmode.statemachine.commands;

import de.audi.app.terminalmode.statemachine.commands.RequestModeChange;
import de.audi.atip.log.LogChannel;
import de.audi.tghu.command.Command;

class RequestModeChange$2
extends Command {
    private final /* synthetic */ RequestModeChange this$0;

    RequestModeChange$2(RequestModeChange requestModeChange, LogChannel logChannel) {
        this.this$0 = requestModeChange;
        super(logChannel);
    }

    @Override
    public void execute() {
        RequestModeChange.access$100(this.this$0).updateState(RequestModeChange.access$000(this.this$0));
        this.getCommandList().commandFinished();
    }

    @Override
    public String getName() {
        return "RequestModeChange.canceled -> Continue CommandList";
    }
}

