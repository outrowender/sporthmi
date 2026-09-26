/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.command.poi.online;

import de.audi.atip.log.LogChannel;
import de.audi.tghu.navi.app.command.poi.online.AbstractOnlineSearchCommand;
import de.audi.tghu.navi.app.poi.online.IOnlineSearchForm;
import de.audi.tghu.navi.app.poi.online.OnlineSearchContext;

public class OnlineSearchErrorCommand
extends AbstractOnlineSearchCommand {
    public OnlineSearchErrorCommand(LogChannel logChannel, IOnlineSearchForm iOnlineSearchForm, OnlineSearchContext onlineSearchContext) {
        super(logChannel, iOnlineSearchForm, onlineSearchContext);
    }

    @Override
    public void execute() {
        this.logger.log(-1601830656, "OnlineSearchErrorCommand#execute: A timeout occurred");
        this.form.indicateError(this.statusToErrorCode(51), Integer.toString(51));
    }
}

