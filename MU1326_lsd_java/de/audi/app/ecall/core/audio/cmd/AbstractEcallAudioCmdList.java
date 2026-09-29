/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.ecall.core.audio.cmd;

import de.audi.atip.audio.HMIAudioService;
import de.audi.atip.log.LogChannel;
import de.audi.tghu.command.CommandList;
import de.audi.tghu.command.CommandListManager;

abstract class AbstractEcallAudioCmdList
extends CommandList {
    protected final HMIAudioService audioService;
    protected final LogChannel log;

    AbstractEcallAudioCmdList(CommandListManager commandListManager, HMIAudioService hMIAudioService, LogChannel logChannel) {
        super(commandListManager);
        this.audioService = hMIAudioService;
        this.log = logChannel;
    }
}

