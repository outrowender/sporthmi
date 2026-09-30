/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.sdsmanager.apps.phone.commands;

import de.audi.app.sdsmanager.apps.AbstractSystemCallCommand;
import de.audi.app.sdsmanager.apps.SDSHandlerService;
import de.audi.app.sdsmanager.apps.phone.PhoneSDSHandler;
import de.audi.app.sdsmanager.apps.phone.PhoneSDSHandlerImpl;
import de.audi.app.sdsmanager.apps.phone.PhoneSequenceElement;
import de.audi.app.sdsmanager.apps.phone.PhoneSequenceHandler;
import de.audi.app.sdsmanager.common.SDSUtils;
import de.audi.app.sdsmanager.nbest.IPicklistSlot;
import de.audi.app.sdsmanager.nbest.NBestStorageAccess;
import de.audi.app.sdsmanager.syscall.ISystemCallParameter;
import de.audi.atip.log.LogChannel;
import de.audi.atip.phone.ITelServiceSDS;

public class PhoneNumberAddCommand
extends AbstractSystemCallCommand {
    private final NBestStorageAccess nbest;
    private final ITelServiceSDS phoneService;
    private final PhoneSDSHandler phoneSDSHandler;
    private final int numberType;
    private final PhoneSequenceHandler sequenceHandler;

    public PhoneNumberAddCommand(LogChannel logChannel, String string, SDSHandlerService sDSHandlerService, ITelServiceSDS iTelServiceSDS, NBestStorageAccess nBestStorageAccess, PhoneSequenceHandler phoneSequenceHandler, PhoneSDSHandler phoneSDSHandler, ISystemCallParameter[] iSystemCallParameterArray) {
        super(logChannel, string, sDSHandlerService);
        this.phoneService = iTelServiceSDS;
        this.phoneSDSHandler = phoneSDSHandler;
        this.sequenceHandler = phoneSequenceHandler;
        this.numberType = SDSUtils.retrieveInteger(iSystemCallParameterArray, 0);
        this.nbest = nBestStorageAccess;
    }

    public void execute() {
        String string;
        IPicklistSlot iPicklistSlot = this.nbest.getMatchingPicklist((byte)0).getSlot(0, 0);
        String string2 = string = iPicklistSlot != null ? SDSUtils.remove(iPicklistSlot.getText(), ' ') : "";
        if (SDSUtils.isEmpty(string)) {
            this.logger.log(100000, "%1#execute: No number found in prompt label!", (Object)this.getName());
            this.sendResult(30001);
            return;
        }
        if (this.numberType != 0 && this.numberType != 2 && this.numberType != 1) {
            this.logger.log(100000, "%1#execute: invalid number type!", (Object)this.getName());
            this.sendResult(30001);
            return;
        }
        this.logger.log(10000000, "%1#execute: numberType=%2!", (Object)this.getName(), (long)this.numberType);
        int n = this.addSpellerContent(string);
        this.sendResult(n);
    }

    private int addSpellerContent(String string) {
        byte by = (byte)this.numberType;
        this.logger.log(10000000, "%1#addSpellerContent: content=%2, type=%3", (Object)this.getName(), (Object)string, (long)by);
        String string2 = SDSUtils.remove(this.getSpellerContent(), ' ');
        this.logger.log(10000000, "%1#addSpellerContent: oldContent=%2", (Object)this.getName(), (Object)string2);
        int n = string2.length() + string.length();
        int n2 = this.getSpellerMaxLength();
        if (n2 < n) {
            this.logger.log(100000, "%1#addSpellerContent: maxLen %2 < %3 => result too long!", (Object)this.getName(), (long)n2, (long)n);
            return 30004;
        }
        this.sequenceHandler.addToSequence(new PhoneSequenceElement(string, false), by);
        this.logger.log(10000000, "%1#addSpellerContent: Added content %2, %3Sequence=%4!", (Object)this.getName(), (Object)string, (Object)PhoneSDSHandlerImpl.getSpellerType(by), (Object)this.sequenceHandler.getSequence(by));
        boolean bl = by != 1;
        String string3 = string2 + (bl && !"".equals(string2) ? " " : "") + string;
        this.logger.log(10000000, "%1#addSpellerContent: addDelimiter=%2, setting speller to %3!", (Object)this.getName(), (Object)bl, (Object)string3);
        this.phoneSDSHandler.setPhoneSpeller(by, string3, false);
        return 30000;
    }

    private String getSpellerContent() {
        this.logger.log(10000000, "%1#getSpellerContent: numberType=%2", (Object)this.getName(), (long)this.numberType);
        switch (this.numberType) {
            case 0: {
                return this.phoneService.getNumberSpellerContent();
            }
            case 1: {
                return this.phoneService.getPINSpellerContent();
            }
            case 2: {
                return this.phoneService.getMailboxSpellerContent();
            }
        }
        this.logger.log(100000, "%1#getSpellerContent: Unhandled numberType %2!", (Object)this.getName(), (long)this.numberType);
        return "";
    }

    private int getSpellerMaxLength() {
        this.logger.log(10000000, "%1#getSpellerMaxLength: numberTypeID=%1", (Object)this.getName(), (long)this.numberType);
        switch (this.numberType) {
            case 0: 
            case 2: {
                return 40;
            }
            case 1: {
                return 8;
            }
        }
        this.logger.log(100000, "%1#getSpellerMaxLength: Unhandled numberTypeID %2!", (Object)this.getName(), (long)this.numberType);
        return 0;
    }
}

