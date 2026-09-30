/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.sdsmanager.apps.adb.commands;

import de.audi.app.sdsmanager.apps.AbstractSystemCallCommand;
import de.audi.app.sdsmanager.apps.SDSHandlerService;
import de.audi.app.sdsmanager.apps.adb.IAddressBookPicklistHandler;
import de.audi.app.sdsmanager.common.SDSUtils;
import de.audi.app.sdsmanager.syscall.ISystemCallParameter;
import de.audi.atip.log.LogChannel;

public class ADBListHideCommand
extends AbstractSystemCallCommand {
    private final IAddressBookPicklistHandler pickListHandler;
    private final int listMode;

    public ADBListHideCommand(LogChannel logChannel, String string, SDSHandlerService sDSHandlerService, ISystemCallParameter[] iSystemCallParameterArray, IAddressBookPicklistHandler iAddressBookPicklistHandler) {
        super(logChannel, string, sDSHandlerService);
        this.listMode = SDSUtils.retrieveInteger(iSystemCallParameterArray, 0);
        this.pickListHandler = iAddressBookPicklistHandler;
    }

    public void execute() {
        this.logger.log(10000000, "%1#execute: listMode=%2!", (Object)this.getName(), (long)this.listMode);
        switch (this.listMode) {
            case 0: {
                this.pickListHandler.removeADBPopup();
                break;
            }
            case 1: {
                this.pickListHandler.removeADBNaviPopup();
                break;
            }
            case 3: {
                this.pickListHandler.removeADBContactPopup();
                break;
            }
            case 6: {
                this.pickListHandler.removeMailPoup();
                break;
            }
            case 2: 
            case 5: {
                this.pickListHandler.removeTelContactPopup();
                break;
            }
            default: {
                this.logger.log(100000, "%1#execute: Unhandled listMode %2!", (Object)this.getName(), (long)this.listMode);
            }
        }
        this.processingFinished();
    }
}

