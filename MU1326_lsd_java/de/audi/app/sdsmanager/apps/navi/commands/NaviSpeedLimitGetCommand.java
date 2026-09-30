/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.sdsmanager.apps.navi.commands;

import de.audi.app.sdsmanager.SDSModelAccess;
import de.audi.app.sdsmanager.apps.AbstractSystemCallCommand;
import de.audi.app.sdsmanager.apps.SDSHandlerService;
import de.audi.atip.interapp.NaviService;
import de.audi.atip.log.LogChannel;

public class NaviSpeedLimitGetCommand
extends AbstractSystemCallCommand {
    private final NaviService naviService;

    public NaviSpeedLimitGetCommand(LogChannel logChannel, String string, SDSHandlerService sDSHandlerService, NaviService naviService) {
        super(logChannel, string, sDSHandlerService);
        this.naviService = naviService;
    }

    public void execute() {
        this.logger.log(10000000, "%1#execute: called", (Object)this.getName());
        this.naviService.requestCurrentSpeedLimit();
    }

    public void responseCurrentSpeedLimit(byte by, int n, byte by2) {
        this.logger.log(10000000, "%1#responseCurrentSpeedLimit: result=%2", (Object)this.getName(), (long)by);
        this.logger.log(10000000, "%1#responseCurrentSpeedLimit: speedLimit=%2, speedUnit=%3", (Object)this.getName(), (long)n, (long)by2);
        SDSModelAccess.setSpeedLimitValue(n);
        SDSModelAccess.setSpeedLimitUnit(by2);
        this.sendResult(3000);
    }
}

