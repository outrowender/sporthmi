/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.command.poi.online;

import de.audi.atip.log.LogChannel;
import de.audi.tghu.navi.app.command.poi.online.AbstractOnlineSearchCommand;

public class OnlineSDSSearchVoiceSearchActiveCommand
extends AbstractOnlineSearchCommand {
    public OnlineSDSSearchVoiceSearchActiveCommand(LogChannel logChannel) {
        super(logChannel);
    }

    public void execute() {
        this.logger.log(1000000, "OnlineSDSSearchVoiceSearchActiveCommand#execute: Called.");
        this.dsiOnlineSearch.poiVoiceSearchActive();
        this.getCommandList().commandFinished();
    }
}

