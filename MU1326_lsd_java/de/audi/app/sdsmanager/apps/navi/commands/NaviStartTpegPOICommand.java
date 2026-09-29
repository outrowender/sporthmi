/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.sdsmanager.apps.navi.commands;

import de.audi.app.sdsmanager.apps.AbstractSystemCallCommand;
import de.audi.app.sdsmanager.apps.SDSHandlerService;
import de.audi.app.sdsmanager.apps.navi.ISDSNaviInputStartingCommand;
import de.audi.app.sdsmanager.apps.navi.NaviSDSUtils;
import de.audi.atip.interapp.NaviService;
import de.audi.atip.log.LogChannel;

public class NaviStartTpegPOICommand
extends AbstractSystemCallCommand
implements ISDSNaviInputStartingCommand {
    private final NaviService naviService;

    public NaviStartTpegPOICommand(LogChannel logChannel, String string, SDSHandlerService sDSHandlerService, NaviService naviService) {
        super(logChannel, string, sDSHandlerService);
        this.naviService = naviService;
    }

    @Override
    public void execute() {
        this.logger.log(-2137614336, "%1#execute: called.", (Object)this.getName());
        this.naviService.startTpegPOI();
    }

    @Override
    public void responseStartDestinationInput(byte by) {
        this.logger.log(-2137614336, "%1#responseStartDestinationInput: result=%2", (Object)this.getName(), (long)by);
        this.sendResult(NaviSDSUtils.getSDSResult(by));
    }
}

