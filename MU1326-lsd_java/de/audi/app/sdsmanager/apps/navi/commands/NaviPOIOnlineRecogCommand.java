/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.sdsmanager.apps.navi.commands;

import de.audi.app.sdsmanager.SDSModelAccess;
import de.audi.app.sdsmanager.apps.AbstractSystemCallCommand;
import de.audi.app.sdsmanager.apps.SDSHandlerService;
import de.audi.app.sdsmanager.common.SDSUtils;
import de.audi.app.sdsmanager.syscall.ISystemCallParameter;
import de.audi.atip.log.LogChannel;

public class NaviPOIOnlineRecogCommand
extends AbstractSystemCallCommand {
    private final boolean isOnlineRecog;

    public NaviPOIOnlineRecogCommand(LogChannel logChannel, String string, SDSHandlerService sDSHandlerService, ISystemCallParameter[] iSystemCallParameterArray) {
        super(logChannel, string, sDSHandlerService);
        this.isOnlineRecog = SDSUtils.retrieveBoolean(iSystemCallParameterArray, 0);
    }

    @Override
    public void execute() {
        this.logger.log(-2137614336, "%1#execute: isOnlineRecog=%2", (Object)this.getName(), (Object)this.isOnlineRecog);
        SDSModelAccess.setPOIOnlineRecogModel(this.isOnlineRecog);
        this.processingFinished();
    }
}

