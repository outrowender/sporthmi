/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.command.poi.online;

import de.audi.atip.i18n.Language;
import de.audi.atip.log.LogChannel;
import de.audi.tghu.navi.app.command.poi.online.AbstractOnlineSearchCommand;

public class OnlineSearchSetLanguageCommand
extends AbstractOnlineSearchCommand {
    private final Language language;

    public OnlineSearchSetLanguageCommand(LogChannel logChannel, Language language) {
        super(logChannel);
        this.language = language;
    }

    public void execute() {
        this.logger.log(1000000, "SetLanguageCommand#execute: calling DSI with language %1", (Object)this.language);
        this.dsiOnlineSearch.setLanguage(this.language.getHmiCode());
        this.getCommandList().commandFinished();
    }
}

