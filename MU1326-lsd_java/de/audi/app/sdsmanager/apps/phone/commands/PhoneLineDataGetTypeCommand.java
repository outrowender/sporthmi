/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.sdsmanager.apps.phone.commands;

import de.audi.app.sdsmanager.SDSModelAccess;
import de.audi.app.sdsmanager.apps.AbstractSystemCallCommand;
import de.audi.app.sdsmanager.apps.IJoystickBlock;
import de.audi.app.sdsmanager.apps.SDSHandlerService;
import de.audi.app.sdsmanager.apps.adb.AddressBookSDSHandler;
import de.audi.app.sdsmanager.apps.phone.PhoneSDSHandler;
import de.audi.app.sdsmanager.common.SDSUtils;
import de.audi.app.sdsmanager.nbest.NBestStorageAccess;
import de.audi.app.sdsmanager.syscall.ISystemCallParameter;
import de.audi.atip.log.LogChannel;

public class PhoneLineDataGetTypeCommand
extends AbstractSystemCallCommand
implements IJoystickBlock {
    private final PhoneSDSHandler phoneHandler;
    private final NBestStorageAccess nBest;
    private final byte listMode;
    private final AddressBookSDSHandler adbHandler;

    public PhoneLineDataGetTypeCommand(LogChannel logChannel, String string, SDSHandlerService sDSHandlerService, PhoneSDSHandler phoneSDSHandler, NBestStorageAccess nBestStorageAccess, AddressBookSDSHandler addressBookSDSHandler, ISystemCallParameter[] iSystemCallParameterArray) {
        super(logChannel, string, sDSHandlerService);
        this.phoneHandler = phoneSDSHandler;
        this.nBest = nBestStorageAccess;
        this.adbHandler = addressBookSDSHandler;
        this.listMode = (byte)SDSUtils.retrieveInteger(iSystemCallParameterArray, 0);
    }

    @Override
    public void execute() {
        this.logger.log(-2137614336, "%1#execute: listMode=%2", (Object)this.getName(), (long)this.listMode);
        int n = this.getSelectedIndex();
        if (n == -1) {
            this.logger.log(-2137614336, "%1#execute: index=-1, mailbox selected!", (Object)this.getName());
            this.sendResult(30011);
            return;
        }
        this.sdsHandlerService.setSelectedRow(n);
        if (this.listMode == 3) {
            this.sendResult(30008);
            return;
        }
        int n2 = this.determineEntryTypeOfCallstackEntry(n);
        this.logger.log(-2137614336, "%1#execute: index=%2, response=%3!", (Object)this.getName(), (long)n, (long)n2);
        this.sendResult(n2);
    }

    private int getSelectedIndex() {
        int n = this.sdsHandlerService.getSelectedRow();
        this.logger.log(-2137614336, "%1#getSelectedIndex: enumStatus=%2, enumValue=%3", (Object)this.getName(), (long)SDSModelAccess.getEnumerationNumberStatus(), (long)SDSModelAccess.getEnumerationNumberValue());
        this.logger.log(-2137614336, "%1#getSelectedIndex: row=%2", (Object)this.getName(), (long)n);
        switch (this.listMode) {
            case 0: 
            case 2: 
            case 3: {
                if (n != -1) {
                    this.logger.log(-2137614336, "%1#getSelectedIndex: Line selection via DDS/item selected!", (Object)this.getName());
                    return n;
                }
                int n2 = SDSModelAccess.getEnumerationNumberStatus();
                this.logger.log(-2137614336, "%1#getSelectedIndex: index = %2", (Object)this.getName(), (long)n2);
                return n2;
            }
            case 1: {
                long l = SDSUtils.getSelectedObjectId(this.nBest, this.logger, 0);
                this.logger.log(-2137614336, "%1#getSelectedIndex: Line selection via command, objID=%2!", (Object)this.getName(), l);
                int n3 = this.phoneHandler.getCallStackIndexByADBId(l);
                this.logger.log(-2137614336, "%1#getSelectedIndex: callStackIndex=%2!", (Object)this.getName(), (long)n3);
                return n3;
            }
        }
        this.logger.log(-1601830656, "%1#getSelectedIndex: Unhandled listMode %2!", (Object)this.getName(), (long)this.listMode);
        return -1;
    }

    private int determineEntryTypeOfCallstackEntry(int n) {
        String string = this.phoneHandler.getCallStackName(n);
        String string2 = this.phoneHandler.getCallStackNumber(n);
        long l = this.phoneHandler.getCallStackAdbId(n);
        short s = this.phoneHandler.getCallStackPhoneType(n);
        SDSModelAccess.setADBEntryNameModel(string);
        this.setPhoneCategoryAndLocation(s);
        if (SDSUtils.isEmpty(string2)) {
            this.logger.log(-2137614336, "%1#execute -> unknown number", (Object)this.getName());
            return 30009;
        }
        if (!SDSUtils.isEmpty(string) && l > 0L) {
            this.logger.log(-2137614336, "%1#execute -> adb entry = %2", (Object)this.getName(), (Object)string);
            this.adbHandler.setSelectedEntryID(l);
            return 30008;
        }
        this.logger.log(-2137614336, "%1#execute -> phone number", (Object)this.getName());
        return 30010;
    }

    protected void setPhoneCategoryAndLocation(short s) {
    }
}

