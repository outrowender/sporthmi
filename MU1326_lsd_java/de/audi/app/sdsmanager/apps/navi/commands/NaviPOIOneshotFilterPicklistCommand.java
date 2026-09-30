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
import de.audi.app.sdsmanager.syscall.ISystemCallParameter;
import de.audi.atip.log.LogChannel;

public class NaviPOIOneshotFilterPicklistCommand
extends AbstractSystemCallCommand {
    private static final byte[][] oneshotListModeToSlotNumber = new byte[][]{{0, 0}, {1, 1}, {28, 1}};
    private final NaviSDSHandlerImpl sdsHandler;
    private final byte listMode;

    public NaviPOIOneshotFilterPicklistCommand(LogChannel logChannel, String string, SDSHandlerService sDSHandlerService, NaviSDSHandlerImpl naviSDSHandlerImpl, ISystemCallParameter[] iSystemCallParameterArray) {
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
        if (this.listMode == 0 && !this.sdsHandler.initializeEntryPicklist()) {
            this.sendResult(3001);
            return;
        }
        byte by = SDSUtils.translate(this.listMode, oneshotListModeToSlotNumber);
        this.logger.log(10000000, "%1#execute: slotNumber=%2!", (Object)this.getName(), (long)by);
        if (by == -128) {
            this.logger.log(100000, "%1#execute: Unexpected slotNumber %2, sending ERROR!", (Object)this.getName(), (long)by);
            this.sendResult(3001);
            return;
        }
        this.filterSlotData(by);
        this.sendResult(3000);
    }

    private void filterSlotData(byte by) {
        this.logger.log(10000000, "%1#filterSlotData: slotNumber=%2", (Object)this.getName(), (long)by);
        boolean bl = this.listMode != 28;
        byte by2 = this.sdsHandler.getNextPicklistSizeType(by, bl);
        this.logger.log(10000000, "%1#filterSlotData: nextPicklistSizeType=%2", (Object)this.getName(), (long)by2);
        SDSModelAccess.setNBestListSlotXModel(by2, by);
        this.sdsHandler.storeUniqueOneshotData(by2, by, this.listMode, 0, 1);
    }
}

