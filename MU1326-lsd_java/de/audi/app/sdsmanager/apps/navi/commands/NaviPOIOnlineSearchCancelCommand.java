/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.sdsmanager.apps.navi.commands;

import de.audi.app.sdsmanager.apps.AbstractSystemCallCommand;
import de.audi.app.sdsmanager.apps.SDSHandlerService;
import de.audi.app.sdsmanager.apps.navi.NaviSDSUtils;
import de.audi.atip.interapp.NaviSDSPOIOnlineService;
import de.audi.atip.log.LogChannel;

public class NaviPOIOnlineSearchCancelCommand
extends AbstractSystemCallCommand {
    private final NaviSDSPOIOnlineService poiOnlineService;

    public NaviPOIOnlineSearchCancelCommand(LogChannel logChannel, String string, SDSHandlerService sDSHandlerService, NaviSDSPOIOnlineService naviSDSPOIOnlineService) {
        super(logChannel, string, sDSHandlerService);
        this.poiOnlineService = naviSDSPOIOnlineService;
    }

    @Override
    public void execute() {
        this.logger.log(-2137614336, "%1#execute: called", (Object)this.getName());
        this.sendResult(NaviSDSUtils.handlePOIOnlineReplyCode(this.logger, this.poiOnlineService.poiOnlineSearchCancel(), this.getName()));
    }
}

