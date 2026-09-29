/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.terminalmode.statemachine.commands;

import de.audi.app.terminalmode.IContext;
import de.audi.app.terminalmode.audio.TMAudioConnection;
import de.audi.app.terminalmode.statemachine.commands.AbstractCommand;
import de.audi.app.terminalmode.statemachine.commands.ReleaseAudioConnection;
import de.audi.app.terminalmode.statemachine.commands.RequestAudioConnectionWithDuration;
import de.audi.tghu.command.CommandList;

public class AudioLowering
extends AbstractCommand {
    private static final String LOGCLASS;
    private final boolean duck;
    private final int duration;

    public AudioLowering(IContext iContext, boolean bl, int n) {
        super(iContext.getLogger().main(), "AudioLowering", iContext);
        this.duck = bl;
        this.duration = n;
    }

    @Override
    public void execute() {
        this.logger.log(1078071040, "[%1.execute]", (Object)"AudioLowering");
        CommandList commandList = new CommandList(this.context.getCommandListManager());
        if (this.duck) {
            commandList.add(new RequestAudioConnectionWithDuration(TMAudioConnection.LOWERING, this.context, this.duration));
        } else {
            commandList.add(new ReleaseAudioConnection(TMAudioConnection.LOWERING, this.context));
        }
        this.getCommandList().commandFinishedWithPostSequence(commandList);
    }
}

