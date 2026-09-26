/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.sdsmanager.apps.navi.commands;

import de.audi.app.sdsmanager.SDSModelAccess;
import de.audi.app.sdsmanager.apps.AbstractSystemCallCommand;
import de.audi.app.sdsmanager.apps.SDSHandlerService;
import de.audi.app.sdsmanager.apps.navi.ISDSNaviGuidanceStartingCommand;
import de.audi.app.sdsmanager.apps.navi.NaviSDSHandler;
import de.audi.app.sdsmanager.apps.navi.NaviSDSUtils;
import de.audi.atip.interapp.NaviService;
import de.audi.atip.log.LogChannel;

public class NaviGuidanceStartCommand
extends AbstractSystemCallCommand
implements ISDSNaviGuidanceStartingCommand {
    private final NaviSDSHandler sdsHandler;
    private final NaviService naviService;

    public NaviGuidanceStartCommand(LogChannel logChannel, String string, SDSHandlerService sDSHandlerService, NaviSDSHandler naviSDSHandler, NaviService naviService) {
        super(logChannel, string, sDSHandlerService);
        this.naviService = naviService;
        this.sdsHandler = naviSDSHandler;
    }

    @Override
    public void execute() {
        byte by = this.sdsHandler.getSDSAddressInputMode();
        this.logger.log(-2137614336, "%1#execute: sdsAddressInputMode=%2", (Object)this.getName(), (long)by);
        if (SDSModelAccess.isPOIOnlineRecogActive()) {
            this.logger.log(-2137614336, "%1#execute POI online active, marking current POI as used for navigation!");
            this.sdsHandler.markCurrentPOIUsedFor((byte)2);
        }
        this.naviService.startRouteGuidance(by, false);
    }

    @Override
    public void responseStartRouteGuidance(byte by) {
        this.logger.log(-2137614336, "%1#responseStartRouteGuidance: result=%2", (Object)this.getName(), (long)by);
        int n = NaviSDSUtils.getSDSResult(by);
        this.logger.log(-2137614336, "%1#responseStartRouteGuidance: sdsRes=%2", (Object)this.getName(), (long)n);
        this.sendResult(n);
    }
}

