/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.sdsmanager.apps.adb.commands;

import de.audi.app.sdsmanager.SDSModelAccess;
import de.audi.app.sdsmanager.apps.AbstractSystemCallCommand;
import de.audi.app.sdsmanager.apps.SDSHandlerService;
import de.audi.app.sdsmanager.apps.adb.AddressBookSDSHandler;
import de.audi.app.sdsmanager.apps.dictate.MessageDictationHandler;
import de.audi.app.sdsmanager.common.SDSUtils;
import de.audi.app.sdsmanager.syscall.ISystemCallParameter;
import de.audi.atip.interapp.ADBSDSService;
import de.audi.atip.log.LogChannel;

public class ADBMailByIDOpenCommand
extends AbstractSystemCallCommand {
    private final int entryIDSource;
    private final ADBSDSService adbService;
    private final AddressBookSDSHandler adbHandler;
    private final MessageDictationHandler messageHandler;

    public ADBMailByIDOpenCommand(LogChannel logChannel, String string, SDSHandlerService sDSHandlerService, ISystemCallParameter[] iSystemCallParameterArray, AddressBookSDSHandler addressBookSDSHandler, ADBSDSService aDBSDSService, MessageDictationHandler messageDictationHandler) {
        super(logChannel, string, sDSHandlerService);
        this.adbHandler = addressBookSDSHandler;
        this.entryIDSource = SDSUtils.retrieveInteger(iSystemCallParameterArray, 0);
        this.adbService = aDBSDSService;
        this.messageHandler = messageDictationHandler;
    }

    public void execute() {
        this.logger.log(10000000, "%1#execute: entryIDSource=%2!", (Object)this.getName(), (long)this.entryIDSource);
        long l = this.adbHandler.getADBID(this.entryIDSource);
        if (l == 0L) {
            this.logger.log(100000, "%1#execute: No adbID found, returning ERROR!", (Object)this.getName());
            this.sendResult(3001);
            return;
        }
        this.adbHandler.setCurrentEntryID(l);
        this.logger.log(10000000, "%1#execute: adbID=%2!", (Object)this.getName(), l);
        this.adbService.fillEmailList(l);
    }

    public void responseFillEmailList(int n, String string, int n2) {
        this.logger.log(10000000, "%1#responseFillEmailList: resultCode=%3, combinedName=%2!", (Object)this.getName(), (Object)string, (long)n);
        if (n != 0) {
            this.logger.log(100000, "%1#responseFillMailAddressList: Unhandled resultCode %2, sending ERROR!", (Object)this.getName(), (long)n);
            this.sendResult(70005);
            return;
        }
        String[] stringArray = new String[n2];
        for (int i2 = 0; i2 < n2; ++i2) {
            ADBSDSService.EmailAddressDetails emailAddressDetails = this.adbService.getEmailAddressDetails(4276, i2);
            stringArray[i2] = emailAddressDetails == null ? "" : emailAddressDetails.email;
            this.messageHandler.updateEmailList(stringArray);
        }
        SDSModelAccess.setADBEntryNameModel(string);
        this.sendResult(70006);
    }
}

