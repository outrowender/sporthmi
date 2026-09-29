/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.terminalmode.statemachine.commands;

import de.audi.app.terminalmode.statemachine.commands.RequestAudioConnection;
import de.audi.atip.log.LogChannel;
import de.audi.tghu.command.Command;

class RequestAudioConnection$1
extends Command {
    private final /* synthetic */ RequestAudioConnection this$0;

    RequestAudioConnection$1(RequestAudioConnection requestAudioConnection, LogChannel logChannel) {
        this.this$0 = requestAudioConnection;
        super(logChannel);
    }

    @Override
    public void execute() {
        this.getCommandList().commandFinished();
    }

    @Override
    public String getName() {
        return "RequestAudioConnection.canceled -> Continue CommandList";
    }
}

