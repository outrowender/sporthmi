/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.sdsmanager.apps.navi.commands;

import de.audi.app.sdsmanager.apps.AbstractSystemCallCommand;
import de.audi.app.sdsmanager.apps.SDSHandlerService;
import de.audi.app.sdsmanager.apps.navi.NaviSDSUtils;
import de.audi.app.sdsmanager.common.SDSUtils;
import de.audi.app.sdsmanager.syscall.ISystemCallParameter;
import de.audi.atip.interapp.NaviService;
import de.audi.atip.log.LogChannel;

public class NaviPOISearchAreaSetCommand
extends AbstractSystemCallCommand {
    private final NaviService service;
    private final byte searchArea;

    public NaviPOISearchAreaSetCommand(LogChannel logChannel, String string, SDSHandlerService sDSHandlerService, ISystemCallParameter[] iSystemCallParameterArray, NaviService naviService) {
        super(logChannel, string, sDSHandlerService);
        this.service = naviService;
        this.searchArea = (byte)SDSUtils.retrieveInteger(iSystemCallParameterArray, 0);
    }

    public void execute() {
        byte by = SDSUtils.translate(this.searchArea, NaviSDSUtils.poiAreaToPOISearchArea);
        this.logger.log(10000000, "%1#execute: searchArea=%2, poiArea=%3", (Object)this.getName(), (long)this.searchArea, (long)by);
        if (by == -128) {
            this.logger.log(100000, "%1#execute: Unhandled searchArea %2!", (Object)this.getName(), (long)this.searchArea);
            this.sendResult(40001);
            return;
        }
        int n = NaviSDSUtils.getSDSResult(this.service.setPOISearchArea(by));
        this.sendResult(n);
    }
}

