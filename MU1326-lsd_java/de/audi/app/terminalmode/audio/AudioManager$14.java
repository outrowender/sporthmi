/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.terminalmode.audio;

import de.audi.app.terminalmode.audio.AudioManager;
import de.audi.atip.log.LogChannel;
import de.audi.tghu.command.Command;

class AudioManager$14
extends Command {
    private final /* synthetic */ AudioManager this$0;

    AudioManager$14(AudioManager audioManager, LogChannel logChannel, String string) {
        this.this$0 = audioManager;
        super(logChannel, string);
    }

    @Override
    public void execute() {
        this.getCommandList().commandFinished();
    }
}

