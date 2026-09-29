/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.sdsmanager.apps.navi.commands;

import de.audi.app.sdsmanager.apps.AbstractSystemCallCommand;
import de.audi.app.sdsmanager.apps.SDSHandlerService;
import de.audi.app.sdsmanager.apps.navi.NaviSDSUtils;
import de.audi.atip.interapp.NaviService;
import de.audi.atip.log.LogChannel;

public class NaviPhoneNumberGetCommand
extends AbstractSystemCallCommand {
    private final NaviService naviService;

    public NaviPhoneNumberGetCommand(LogChannel logChannel, String string, SDSHandlerService sDSHandlerService, NaviService naviService) {
        super(logChannel, string, sDSHandlerService);
        this.naviService = naviService;
    }

    @Override
    public void execute() {
        this.logger.log(-2137614336, "[%1#execute] ", (Object)this.getName());
        NaviSDSUtils.updateNaviPhoneNumberModels(this.naviService);
        this.sendResult(1083965440);
    }
}

