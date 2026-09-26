/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.sdsmanager.apps.navi.commands;

import de.audi.app.sdsmanager.apps.AbstractSystemCallCommand;
import de.audi.app.sdsmanager.apps.SDSHandlerService;
import de.audi.atip.interapp.NaviService;
import de.audi.atip.log.LogChannel;

public class NaviMapCodeNavigableCommand
extends AbstractSystemCallCommand {
    private final NaviService naviService;

    public NaviMapCodeNavigableCommand(LogChannel logChannel, String string, SDSHandlerService sDSHandlerService, NaviService naviService) {
        super(logChannel, string, sDSHandlerService);
        this.naviService = naviService;
    }

    @Override
    public void execute() {
        this.sendResult(this.naviService.isCurrentMapCodeNavigable() ? 1083965440 : 1184628736);
    }
}

