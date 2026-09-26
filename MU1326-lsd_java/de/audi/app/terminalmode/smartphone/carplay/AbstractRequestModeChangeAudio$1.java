/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.terminalmode.smartphone.carplay;

import de.audi.app.terminalmode.smartphone.carplay.AbstractRequestModeChangeAudio;
import de.audi.atip.log.LogChannel;
import de.audi.tghu.command.Command;

class AbstractRequestModeChangeAudio$1
extends Command {
    private final /* synthetic */ AbstractRequestModeChangeAudio this$0;

    AbstractRequestModeChangeAudio$1(AbstractRequestModeChangeAudio abstractRequestModeChangeAudio, LogChannel logChannel) {
        this.this$0 = abstractRequestModeChangeAudio;
        super(logChannel);
    }

    @Override
    public void execute() {
        AbstractRequestModeChangeAudio.access$000(this.this$0).updateState(this.this$0.newState);
        this.getCommandList().commandFinished();
    }

    @Override
    public String getName() {
        return "RequestModeChangeAudio.canceled -> Continue CommandList";
    }
}

