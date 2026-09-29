/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.sdsmanager.apps.navi.commands;

import de.audi.app.sdsmanager.apps.AbstractSystemCallCommand;
import de.audi.app.sdsmanager.apps.SDSHandlerService;
import de.audi.app.sdsmanager.common.SDSUtils;
import de.audi.app.sdsmanager.syscall.ISystemCallParameter;
import de.audi.atip.interapp.NaviSDSPOIOnlineService;
import de.audi.atip.log.LogChannel;

public class NaviPOIOnlineShowListCommand
extends AbstractSystemCallCommand {
    private final NaviSDSPOIOnlineService poiOnlineService;
    private byte listType;
    private static byte[] listmodeIndex2ServiceListmode = new byte[]{0, 1, 2};

    public NaviPOIOnlineShowListCommand(LogChannel logChannel, String string, SDSHandlerService sDSHandlerService, NaviSDSPOIOnlineService naviSDSPOIOnlineService, ISystemCallParameter[] iSystemCallParameterArray) {
        super(logChannel, string, sDSHandlerService);
        this.poiOnlineService = naviSDSPOIOnlineService;
        this.listType = (byte)SDSUtils.retrieveInteger(iSystemCallParameterArray, 0);
    }

    @Override
    public void execute() {
        this.logger.log(-2137614336, "[%1#execute] listType=%2", (Object)this.getName(), (long)this.listType);
        if (this.listType < 0 || this.listType > listmodeIndex2ServiceListmode.length - 1) {
            this.logger.log(-1601830656, "%1#execute: listTypeIndex is out of bounds!", (Object)this.getName());
            this.processingFinished();
            return;
        }
        this.poiOnlineService.poiOnlineShowList(listmodeIndex2ServiceListmode[this.listType]);
        this.processingFinished();
    }
}

