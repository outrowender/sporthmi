/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.sdsmanager.apps.navi.commands;

import de.audi.app.sdsmanager.SDSModelAccess;
import de.audi.app.sdsmanager.apps.AbstractSystemCallCommand;
import de.audi.app.sdsmanager.apps.SDSHandlerService;
import de.audi.app.sdsmanager.apps.navi.NaviSDSUtils;
import de.audi.atip.hmi.model.list.BaseListModelApp;
import de.audi.atip.interapp.NaviService;
import de.audi.atip.log.LogChannel;

public class NaviMapCodeResolveCommand
extends AbstractSystemCallCommand {
    private final NaviService naviService;

    public NaviMapCodeResolveCommand(LogChannel logChannel, String string, SDSHandlerService sDSHandlerService, NaviService naviService) {
        super(logChannel, string, sDSHandlerService);
        this.naviService = naviService;
    }

    @Override
    public void execute() {
        this.logger.log(-2137614336, "[%1#execute]", (Object)this.getName());
        this.naviService.disambiguateMapCode();
    }

    public void mapCodeResolveResult(byte by) {
        this.logger.log(-2137614336, "[%1#resultMapCodeResolve] result=%2", (Object)this.getName(), (long)by);
        BaseListModelApp baseListModelApp = SDSModelAccess.getSDSNaviPicklistBaseList();
        if (baseListModelApp.getLength() == 2) {
            int n = baseListModelApp.getRow(0).getInteger(4);
            if (n != 6) {
                SDSModelAccess.setNaviMapCodeDestTypeModel(n);
            } else {
                n = baseListModelApp.getRow(1).getInteger(4);
                SDSModelAccess.setNaviMapCodeDestTypeModel(n);
            }
        }
        this.sendResult(NaviSDSUtils.getSDSResult(by));
    }
}

