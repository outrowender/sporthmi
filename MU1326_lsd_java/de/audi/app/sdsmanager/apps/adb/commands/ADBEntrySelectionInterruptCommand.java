/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.sdsmanager.apps.adb.commands;

import de.audi.app.sdsmanager.SDSModelAccess;
import de.audi.app.sdsmanager.apps.AbstractSystemCallCommand;
import de.audi.app.sdsmanager.apps.SDSHandlerService;
import de.audi.app.sdsmanager.apps.adb.AddressBookSDSHandler;
import de.audi.app.sdsmanager.common.SDSUtils;
import de.audi.app.sdsmanager.nbest.NBestStorageAccess;
import de.audi.app.sdsmanager.syscall.ISystemCallParameter;
import de.audi.atip.log.LogChannel;

public class ADBEntrySelectionInterruptCommand
extends AbstractSystemCallCommand {
    private final boolean adbSelectionInterrupt;
    private final NBestStorageAccess nBestStorage;
    private final AddressBookSDSHandler adbHandler;

    public ADBEntrySelectionInterruptCommand(LogChannel logChannel, String string, SDSHandlerService sDSHandlerService, ISystemCallParameter[] iSystemCallParameterArray, AddressBookSDSHandler addressBookSDSHandler, NBestStorageAccess nBestStorageAccess) {
        super(logChannel, string, sDSHandlerService);
        this.adbSelectionInterrupt = SDSUtils.retrieveBoolean(iSystemCallParameterArray, 0);
        this.adbHandler = addressBookSDSHandler;
        this.nBestStorage = nBestStorageAccess;
    }

    public void execute() {
        this.logger.log(10000000, "%1#execute: adbSelectionInterrupt=%1", (Object)this.getName(), (Object)this.adbSelectionInterrupt);
        SDSModelAccess.setADBSelectionInterrupt(this.adbSelectionInterrupt ? 1 : 0);
        if (this.adbSelectionInterrupt) {
            long l = this.nBestStorage.getSlotObjID(0, 0);
            this.logger.log(10000000, "%1#execute: adbEntrySelectionInterruptID=%1!", (Object)this.getName(), this.adbHandler.getADBEntrySelectionInterruptID());
            this.adbHandler.setADBEntrySelectionInterruptID(l);
        }
    }
}

