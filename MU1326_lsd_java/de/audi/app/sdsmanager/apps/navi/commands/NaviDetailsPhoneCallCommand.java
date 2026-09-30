/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.sdsmanager.apps.navi.commands;

import de.audi.app.sdsmanager.SDSManagerBaseActivator;
import de.audi.app.sdsmanager.apps.AbstractSystemCallCommand;
import de.audi.app.sdsmanager.apps.SDSHandlerService;
import de.audi.atip.hmi.HMIService;
import de.audi.atip.interapp.NaviService;
import de.audi.atip.log.LogChannel;

public class NaviDetailsPhoneCallCommand
extends AbstractSystemCallCommand {
    private final NaviService service;
    private HMIService hmiService;

    public NaviDetailsPhoneCallCommand(LogChannel logChannel, String string, SDSHandlerService sDSHandlerService, HMIService hMIService, NaviService naviService) {
        super(logChannel, string, sDSHandlerService);
        this.service = naviService;
        this.hmiService = hMIService;
    }

    public void execute() {
        this.logger.log(10000000, "[%1#execute] called", (Object)this.getName());
        this.service.dialDetailsNumber();
        this.sdsHandlerService.switchEntertainment(false);
        this.sdsHandlerService.setSDSNumberDialingActive(true);
    }

    public void responseDialDetailsNumber(byte by) {
        this.logger.log(10000000, "[%1#responseDialDetailsNumber] result=%2", (Object)this.getName(), (long)by);
        if (by != 0) {
            this.sendResult(40001);
            return;
        }
        int n = SDSManagerBaseActivator.getMapping().getEventID(1016);
        if (n != -1) {
            this.hmiService.fireSMEvent(0, n);
        }
        this.sendResult(40000);
    }
}

