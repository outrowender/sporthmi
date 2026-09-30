/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.sdsmanager.apps.navi.commands;

import de.audi.app.sdsmanager.apps.AbstractSystemCallCommand;
import de.audi.app.sdsmanager.apps.SDSHandlerService;
import de.audi.atip.interapp.NaviService;
import de.audi.atip.log.LogChannel;

public class NaviTriggerTpegPOIReturnCommand
extends AbstractSystemCallCommand {
    private final NaviService naviService;

    public NaviTriggerTpegPOIReturnCommand(LogChannel logChannel, String string, SDSHandlerService sDSHandlerService, NaviService naviService) {
        super(logChannel, string, sDSHandlerService);
        this.naviService = naviService;
    }

    public void execute() {
        this.logger.log(10000000, "%1#execute: called.", (Object)this.getName());
        this.naviService.triggerTpegPoiReturn();
        this.processingFinished();
    }
}

