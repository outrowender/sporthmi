/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.sdsmanager.apps.navi.commands;

import de.audi.app.sdsmanager.apps.AbstractSystemCallCommand;
import de.audi.app.sdsmanager.apps.SDSHandlerService;
import de.audi.app.sdsmanager.apps.navi.NaviSDSUtils;
import de.audi.app.sdsmanager.common.SDSUtils;
import de.audi.app.sdsmanager.syscall.ISystemCallParameter;
import de.audi.atip.interapp.NaviSDSPOIOnlineService;
import de.audi.atip.log.LogChannel;

public class NaviPOIOnlineSearchAreaSetCommand
extends AbstractSystemCallCommand {
    private final NaviSDSPOIOnlineService poiOnlineService;
    private final byte searchArea;

    public NaviPOIOnlineSearchAreaSetCommand(LogChannel logChannel, String string, SDSHandlerService sDSHandlerService, ISystemCallParameter[] iSystemCallParameterArray, NaviSDSPOIOnlineService naviSDSPOIOnlineService) {
        super(logChannel, string, sDSHandlerService);
        this.searchArea = (byte)SDSUtils.retrieveInteger(iSystemCallParameterArray, 0);
        this.poiOnlineService = naviSDSPOIOnlineService;
    }

    public void execute() {
        byte by = SDSUtils.translate(this.searchArea, NaviSDSUtils.poiAreaToPOIOnlineSearchArea);
        this.logger.log(10000000, "%1#execute: searchArea=%2, poiArea=%3!", (Object)this.getName(), (long)this.searchArea, (long)by);
        if (by == -128) {
            this.logger.log(100000, "%1#execute: Unhandled searchArea %2!", (Object)this.getName(), (long)this.searchArea);
            this.sendResult(40001);
            return;
        }
        this.poiOnlineService.poiOnlineSetSearchArea(by);
    }

    public void poiOnlineSetSearchAreaResult(byte by) {
        this.logger.log(10000000, "[%1.poiOnlineSetSearchAreaResult] replyCode=%2", (Object)this.getName(), (long)by);
        this.sendResult(NaviSDSUtils.handlePOIOnlineReplyCodeSDS(this.logger, by, "poiOnlineSetSearchAreaResult"));
    }
}

