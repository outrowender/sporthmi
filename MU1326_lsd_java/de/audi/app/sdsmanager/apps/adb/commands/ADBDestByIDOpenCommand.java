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

public class ADBDestByIDOpenCommand
extends AbstractSystemCallCommand {
    private final int entryIDSource;
    private final ADBSDSService adbService;
    private final AddressBookSDSHandler adbHandler;

    public ADBDestByIDOpenCommand(LogChannel logChannel, String string, SDSHandlerService sDSHandlerService, ISystemCallParameter[] iSystemCallParameterArray, AddressBookSDSHandler addressBookSDSHandler, ADBSDSService aDBSDSService) {
        super(logChannel, string, sDSHandlerService);
        this.entryIDSource = SDSUtils.retrieveInteger(iSystemCallParameterArray, 0);
        this.adbService = aDBSDSService;
        this.adbHandler = addressBookSDSHandler;
    }

    public void execute() {
        this.logger.log(10000000, "%1#execute: entryIDSource=%2!", (Object)this.getName(), (long)this.entryIDSource);
        long l = this.adbHandler.getADBID(this.entryIDSource);
        if (l == 0L) {
            this.logger.log(10000000, "%1#execute: Unhandled entryIDSource %2, sending ERROR!", (Object)this.getName(), (long)this.entryIDSource);
            this.sendResult(3001);
            return;
        }
        this.adbHandler.setCurrentEntryID(l);
        int n = SDSModelAccess.getADBCategoryLocationModel();
        this.logger.log(10000000, "%1#execute: adbID=%2, locationType=%3, showing navi locations!", (Object)this.getName(), l, (long)n);
        this.adbService.showAddresses(l, n != 1, n != 2);
    }

    public void responseShowAddresses(int n, int[] nArray, String string) {
        this.logger.log(10000000, "%1#responseShowAddresses: resultCode=%3, availableNavLocations=%2", (Object)this.getName(), (Object)nArray, (long)n);
        this.logger.log(10000000, "%1#responseShowAddresses: combinedName=%2, sending OK!", (Object)this.getName(), (Object)string);
        if (n != 0) {
            this.logger.log(100000, "%1#responseShowAddresses: Unhandled resultCode %2, sending ERROR!", (Object)this.getName(), (long)n);
            this.sendResult(3001);
            return;
        }
        int n2 = 0;
        int n3 = 0;
        for (int i2 = 0; i2 < nArray.length; ++i2) {
            int n4 = nArray[i2];
            if (n4 == 4 || n4 == 2 || n4 == 0) {
                ++n2;
                continue;
            }
            if (n4 != 5 && n4 != 3 && n4 != 1) continue;
            ++n3;
        }
        SDSModelAccess.setADBCategoryLocationsCountModel(n3, n2);
        this.fillModelsForDynamicPrompts(nArray);
        SDSModelAccess.setADBEntryNameModel(string);
        this.adbHandler.setNavLocations(nArray);
        this.sendResult(3000);
    }

    protected void fillModelsForDynamicPrompts(int[] nArray) {
    }
}

