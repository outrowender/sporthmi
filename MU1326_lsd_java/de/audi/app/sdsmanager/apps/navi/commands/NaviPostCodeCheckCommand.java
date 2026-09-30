/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.sdsmanager.apps.navi.commands;

import de.audi.app.sdsmanager.SDSModelAccess;
import de.audi.app.sdsmanager.apps.AbstractSystemCallCommand;
import de.audi.app.sdsmanager.apps.SDSHandlerService;
import de.audi.atip.interapp.NaviService;
import de.audi.atip.log.LogChannel;

public class NaviPostCodeCheckCommand
extends AbstractSystemCallCommand {
    private final NaviService service;

    public NaviPostCodeCheckCommand(LogChannel logChannel, String string, SDSHandlerService sDSHandlerService, NaviService naviService) {
        super(logChannel, string, sDSHandlerService);
        this.service = naviService;
    }

    public void execute() {
        this.logger.log(10000000, "[%1#execute] Requesting postcode format!", (Object)this.getName());
        this.service.requestPostCodeFormat();
    }

    public void sdsPostCodeCheckResult(byte by, boolean bl) {
        this.logger.log(10000000, "[%1#sdsPostCodeCheckResult] result=%3, isNumeric=%2", (Object)this.getName(), (Object)bl, (long)by);
        if (by != 0) {
            this.sendResult(3001);
        }
        if (bl) {
            SDSModelAccess.setNaviPostcodeChoice(0);
        } else {
            SDSModelAccess.setNaviPostcodeChoice(1);
        }
        this.sendResult(3000);
    }
}

