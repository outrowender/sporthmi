/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.sdsmanager.apps.phone.commands;

import de.audi.app.sdsmanager.SDSModelAccess;
import de.audi.app.sdsmanager.apps.AbstractSystemCallCommand;
import de.audi.app.sdsmanager.apps.SDSHandlerService;
import de.audi.app.sdsmanager.apps.adb.AddressBookSDSHandler;
import de.audi.app.sdsmanager.common.SDSUtils;
import de.audi.atip.log.LogChannel;
import de.audi.atip.phone.ITelServiceSDS;
import de.audi.atip.phone.TelServiceCallStackEntry;

public class PhoneRedialNumberCommand
extends AbstractSystemCallCommand {
    protected final ITelServiceSDS phoneService;
    private final AddressBookSDSHandler adbHandler;
    private static final int VALUE_PHONE_NUMBER;
    private static final int VALUE_CONTACT;

    public PhoneRedialNumberCommand(LogChannel logChannel, String string, SDSHandlerService sDSHandlerService, ITelServiceSDS iTelServiceSDS, AddressBookSDSHandler addressBookSDSHandler) {
        super(logChannel, string, sDSHandlerService);
        this.phoneService = iTelServiceSDS;
        this.adbHandler = addressBookSDSHandler;
    }

    @Override
    public void execute() {
        TelServiceCallStackEntry telServiceCallStackEntry = this.phoneService.getLastDialedNumber();
        if (telServiceCallStackEntry == null) {
            this.logger.log(-1601830656, "%1#execute: No csEntry given!", (Object)this.getName());
            this.sendResult(30002);
            return;
        }
        long l = telServiceCallStackEntry.getAdbEntryID();
        this.logger.log(-2137614336, "%1#execute: adbEntryID=%2!", (Object)this.getName(), l);
        if (l > 0L) {
            this.logger.log(-2137614336, "%1#execute: Valid adbEntryID available, storing it and sending OK!", (Object)this.getName());
            this.setExtraPromptingLabesHook(telServiceCallStackEntry);
            this.adbHandler.setSelectedEntryID(l);
            SDSModelAccess.setPhoneRedialContentChoice(1);
            this.sendResult(30008);
            return;
        }
        String string = telServiceCallStackEntry.getNumber();
        this.logger.log(-2137614336, "%1#execute: csNumber=%2!", (Object)this.getName(), (Object)string);
        if (SDSUtils.isEmpty(string)) {
            this.logger.log(-1601830656, "%1#execute: No csNumber found!", (Object)this.getName());
            this.sendResult(30002);
            return;
        }
        SDSModelAccess.setPhoneRedialContentChoice(0);
        this.sendResult(30010);
    }

    protected void setExtraPromptingLabesHook(TelServiceCallStackEntry telServiceCallStackEntry) {
    }
}

