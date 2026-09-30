/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.sdsmanager.apps.navi.commands;

import de.audi.app.sdsmanager.SDSModelAccess;
import de.audi.app.sdsmanager.apps.AbstractSystemCallCommand;
import de.audi.app.sdsmanager.apps.SDSHandlerService;
import de.audi.app.sdsmanager.apps.navi.NaviSDSHandlerImpl;
import de.audi.app.sdsmanager.apps.navi.NaviSDSUtils;
import de.audi.app.sdsmanager.common.SDSUtils;
import de.audi.app.sdsmanager.oneshot.NaviOneshotHandler;
import de.audi.app.sdsmanager.syscall.ISystemCallParameter;
import de.audi.atip.log.LogChannel;

public class NaviOneshotFilterPicklistCommand
extends AbstractSystemCallCommand {
    private final NaviSDSHandlerImpl sdsHandler;
    private final byte listMode;

    public NaviOneshotFilterPicklistCommand(LogChannel logChannel, String string, SDSHandlerService sDSHandlerService, NaviSDSHandlerImpl naviSDSHandlerImpl, ISystemCallParameter[] iSystemCallParameterArray) {
        super(logChannel, string, sDSHandlerService);
        this.sdsHandler = naviSDSHandlerImpl;
        this.listMode = (byte)SDSUtils.retrieveInteger(iSystemCallParameterArray, 0);
    }

    public void execute() {
        this.logger.log(10000000, "%1#execute: listMode=%2", (Object)this.getName(), (long)this.listMode);
        SDSModelAccess.setVDEOneshotPLType(this.listMode);
        if (!NaviSDSUtils.isOneshotPickListMode(this.listMode)) {
            this.logger.log(100000, "%1#execute: Unhandled listMode %2, sending ERROR!", (Object)this.getName(), (long)this.listMode);
            this.sendResult(3001);
            return;
        }
        this.sdsHandler.setPickListMode(this.listMode);
        NaviOneshotHandler naviOneshotHandler = this.sdsHandler.getOneshotHandler();
        byte by = naviOneshotHandler.filterPicklist(this.listMode);
        if (by == -1) {
            this.logger.log(100000, "%1#execute: Filtered picklist length error %2, sending ERROR!", (Object)this.getName(), (long)by);
            this.sendResult(3001);
        } else {
            this.sendResult(3000);
        }
    }
}

