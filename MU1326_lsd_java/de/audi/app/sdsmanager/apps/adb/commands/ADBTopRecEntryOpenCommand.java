/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.sdsmanager.apps.adb.commands;

import de.audi.app.sdsmanager.SDSModelAccess;
import de.audi.app.sdsmanager.apps.AbstractSystemCallCommand;
import de.audi.app.sdsmanager.apps.SDSHandlerService;
import de.audi.app.sdsmanager.apps.adb.AddressBookSDSHandler;
import de.audi.app.sdsmanager.common.SDSUtils;
import de.audi.app.sdsmanager.syscall.ISystemCallParameter;
import de.audi.atip.interapp.ADBSDSService;
import de.audi.atip.log.LogChannel;

public class ADBTopRecEntryOpenCommand
extends AbstractSystemCallCommand {
    private final int entryIDSource;
    private final ADBSDSService adbService;
    private final AddressBookSDSHandler adbHandler;

    public ADBTopRecEntryOpenCommand(LogChannel logChannel, String string, SDSHandlerService sDSHandlerService, ISystemCallParameter[] iSystemCallParameterArray, AddressBookSDSHandler addressBookSDSHandler, ADBSDSService aDBSDSService) {
        super(logChannel, string, sDSHandlerService);
        this.adbHandler = addressBookSDSHandler;
        this.entryIDSource = SDSUtils.retrieveInteger(iSystemCallParameterArray, 0);
        this.adbService = aDBSDSService;
    }

    public void execute() {
        this.logger.log(10000000, "%1#execute: entryIDSource=%2!", (Object)this.getName(), (long)this.entryIDSource);
        long l = this.adbHandler.getADBID(this.entryIDSource);
        if (l == 0L) {
            this.logger.log(100000, "%1#execute: Unhandled adbID %2!", (Object)this.getName(), l);
            this.sendResult(3001);
            return;
        }
        this.adbHandler.setCurrentEntryID(l);
        this.logger.log(10000000, "%1#execute: adbID=%2!", (Object)this.getName(), l);
        this.adbService.openEntryDetails(l);
    }

    public void responseOpenEntryDetails(int n, String string) {
        this.logger.log(10000000, "%1#responseOpenEntryDetails: combinedName=%2", (Object)this.getName(), (Object)string);
        SDSModelAccess.setADBEntryNameModel(string);
        this.sendResult(n == 0 ? 3000 : 3001);
    }
}

