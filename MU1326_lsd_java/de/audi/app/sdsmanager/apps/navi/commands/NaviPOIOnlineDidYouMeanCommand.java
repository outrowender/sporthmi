/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.sdsmanager.apps.navi.commands;

import de.audi.app.sdsmanager.apps.AbstractSystemCallCommand;
import de.audi.app.sdsmanager.apps.SDSHandlerService;
import de.audi.app.sdsmanager.apps.navi.NaviSDSUtils;
import de.audi.atip.interapp.NaviSDSPOIOnlineService;
import de.audi.atip.log.LogChannel;

public class NaviPOIOnlineDidYouMeanCommand
extends AbstractSystemCallCommand {
    private final NaviSDSPOIOnlineService poiOnlineService;

    public NaviPOIOnlineDidYouMeanCommand(LogChannel logChannel, String string, SDSHandlerService sDSHandlerService, NaviSDSPOIOnlineService naviSDSPOIOnlineService) {
        super(logChannel, string, sDSHandlerService);
        this.poiOnlineService = naviSDSPOIOnlineService;
    }

    public void execute() {
        this.logger.log(10000000, "%1#execute: called", (Object)this.getName());
        this.poiOnlineService.poiOnlineSearchDidYouMean();
    }

    public void poiOnlineSearchDidYouMeanResult(byte by) {
        this.logger.log(10000000, "%1#poiOnlineSearchDidYouMeanResult: replyCode=%2", (Object)this.getName(), (long)by);
        this.sendResult(NaviSDSUtils.handlePOIOnlineReplyCode(this.logger, by, "poiOnlineSearchDidYouMeanResult"));
    }
}

