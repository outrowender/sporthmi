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
import de.audi.atip.log.LogChannel;

public class ADBCategorySetCommand
extends AbstractSystemCallCommand {
    private final int locationCategory;
    private final int phoneCategory;
    private final AddressBookSDSHandler adbHandler;

    public ADBCategorySetCommand(LogChannel logChannel, String string, SDSHandlerService sDSHandlerService, ISystemCallParameter[] iSystemCallParameterArray, AddressBookSDSHandler addressBookSDSHandler) {
        super(logChannel, string, sDSHandlerService);
        this.phoneCategory = SDSUtils.retrieveInteger(iSystemCallParameterArray, 0);
        this.locationCategory = SDSUtils.retrieveInteger(iSystemCallParameterArray, 1);
        this.adbHandler = addressBookSDSHandler;
    }

    public void execute() {
        this.logger.log(10000000, "%1#execute: locationCategory=%2, phoneCategory=%3!", (Object)this.getName(), (long)this.locationCategory, (long)this.phoneCategory);
        SDSModelAccess.setADBCategoryLocationModel(this.locationCategory);
        SDSModelAccess.setADBCategoryPhoneModel(this.phoneCategory);
        int n = this.getAdbPhoneType();
        this.logger.log(10000000, "%1#execute: phoneNumberTypes=%2!", (Object)this.getName(), (long)n);
        this.adbHandler.setPhoneNumberTypes(n);
        this.sendResult(3000);
    }

    private int getAdbPhoneType() {
        int n = 0;
        if (this.locationCategory == 1) {
            this.logger.log(100000, "%1#getAdbPhoneType: Location category is private!", (Object)this.getName());
            n |= 4;
        } else if (this.locationCategory == 2) {
            this.logger.log(100000, "%1#getAdbPhoneType: Location category is mobile!", (Object)this.getName());
            n |= 2;
        } else {
            this.logger.log(100000, "%1#getAdbPhoneType: No location category specified!", (Object)this.getName());
        }
        if (this.phoneCategory == 1) {
            this.logger.log(100000, "%1#getAdbPhoneType: Phone category is fix!", (Object)this.getName());
            n |= 8;
        } else if (this.phoneCategory == 2) {
            this.logger.log(100000, "%1#getAdbPhoneType: Phone category is mobile!", (Object)this.getName());
            n |= 0x40;
        } else {
            this.logger.log(10000000, "%1#getAdbPhoneType: No phone category specified!", (Object)this.getName());
        }
        return n;
    }
}

