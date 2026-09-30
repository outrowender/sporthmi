/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.sdsmanager.apps.navi.commands;

import de.audi.app.sdsmanager.SDSModelAccess;
import de.audi.app.sdsmanager.apps.AbstractSystemCallCommand;
import de.audi.app.sdsmanager.apps.SDSHandlerService;
import de.audi.app.sdsmanager.apps.navi.ISDSNaviPOIValueSettingCommand;
import de.audi.app.sdsmanager.apps.navi.NaviSDSUtils;
import de.audi.atip.interapp.NaviService;
import de.audi.atip.log.LogChannel;

public class NaviSelectTpegPOIResultCommand
extends AbstractSystemCallCommand
implements ISDSNaviPOIValueSettingCommand {
    private final NaviService naviService;

    public NaviSelectTpegPOIResultCommand(LogChannel logChannel, String string, SDSHandlerService sDSHandlerService, NaviService naviService) {
        super(logChannel, string, sDSHandlerService);
        this.naviService = naviService;
    }

    public void execute() {
        this.logger.log(10000000, "%1#execute: called.", (Object)this.getName());
        int n = SDSModelAccess.getEnumerationNumberStatus();
        this.naviService.selectTpegPOIResultByIndex(n);
    }

    public void responseSelectPOIByListIndex(byte by) {
        this.logger.log(10000000, "%1#responseSelectPOIByListIndex: result=%2", (Object)this.getName(), (long)by);
        this.sendResult(NaviSDSUtils.getSDSResult(by));
    }

    public void responseSelectPOIByUID(byte by, NaviService.POISDSListEntry[] pOISDSListEntryArray) {
        this.responseSelectPOIByListIndex(by);
    }
}

