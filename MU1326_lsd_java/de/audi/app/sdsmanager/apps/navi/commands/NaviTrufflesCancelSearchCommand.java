/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.sdsmanager.apps.navi.commands;

import de.audi.app.sdsmanager.apps.AbstractSystemCallCommand;
import de.audi.app.sdsmanager.apps.SDSHandlerService;
import de.audi.app.sdsmanager.apps.navi.commands.NaviTrufflesSearchDestinationCommand;
import de.audi.app.sdsmanager.common.SDSUtils;
import de.audi.atip.interapp.NaviService;
import de.audi.atip.log.LogChannel;

public class NaviTrufflesCancelSearchCommand
extends AbstractSystemCallCommand {
    private NaviService naviService;

    public NaviTrufflesCancelSearchCommand(LogChannel logChannel, String string, SDSHandlerService sDSHandlerService, NaviService naviService) {
        super(logChannel, string, sDSHandlerService);
        this.naviService = naviService;
        AbstractSystemCallCommand abstractSystemCallCommand = SDSUtils.getActiveSystemCall();
        if (abstractSystemCallCommand instanceof NaviTrufflesSearchDestinationCommand) {
            NaviTrufflesSearchDestinationCommand naviTrufflesSearchDestinationCommand = (NaviTrufflesSearchDestinationCommand)abstractSystemCallCommand;
            int n = naviTrufflesSearchDestinationCommand.getSearchResults() == 0 ? 40009 : 40000;
            naviTrufflesSearchDestinationCommand.sendResult(n);
        }
    }

    public void execute() {
        this.logger.log(10000000, "%1#execute: called!", (Object)this.getName());
        this.naviService.cancelSDSTrufflesSearch(false);
        this.processingFinished();
    }
}

