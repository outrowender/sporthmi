/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.sdsmanager.apps.phone.commands;

import de.audi.app.sdsmanager.apps.AbstractSystemCallCommand;
import de.audi.app.sdsmanager.apps.SDSHandlerService;
import de.audi.app.sdsmanager.apps.phone.PhoneSDSHandler;
import de.audi.app.sdsmanager.apps.phone.PhoneSDSHandlerImpl;
import de.audi.app.sdsmanager.apps.phone.PhoneSequenceHandler;
import de.audi.app.sdsmanager.common.SDSUtils;
import de.audi.app.sdsmanager.syscall.ISystemCallParameter;
import de.audi.atip.log.LogChannel;

public class PhoneNumberDeleteCommand
extends AbstractSystemCallCommand {
    private static final int DELETE_ALL = 0;
    private static final int DELETE_SEQUENCE = 1;
    private final PhoneSequenceHandler sequenceHandler;
    private final PhoneSDSHandler phoneSDSHandler;
    private final int numberType;
    private final int deleteMode;

    public PhoneNumberDeleteCommand(LogChannel logChannel, String string, SDSHandlerService sDSHandlerService, PhoneSequenceHandler phoneSequenceHandler, PhoneSDSHandler phoneSDSHandler, ISystemCallParameter[] iSystemCallParameterArray) {
        super(logChannel, string, sDSHandlerService);
        this.sequenceHandler = phoneSequenceHandler;
        this.phoneSDSHandler = phoneSDSHandler;
        this.deleteMode = SDSUtils.retrieveInteger(iSystemCallParameterArray, 0);
        this.numberType = SDSUtils.retrieveInteger(iSystemCallParameterArray, 1);
    }

    public void execute() {
        this.logger.log(10000000, "%1#execute: deleteMode=%2, numberType=%3", (Object)this.getName(), (long)this.deleteMode, (long)this.numberType);
        if (this.numberType != 0 && this.numberType != 2 && this.numberType != 1) {
            this.logger.log(100000, "%1#execute: invalid number type!", (Object)this.getName());
            this.sendResult(30001);
            return;
        }
        int n = this.deleteSpellerContent();
        this.sendResult(n);
    }

    private int deleteSpellerContent() {
        byte by = (byte)this.numberType;
        this.logger.log(10000000, "%1#deleteSpellerContent: deleteMode=%2, type=%3", (Object)this.getName(), (long)this.deleteMode, (long)by);
        switch (this.deleteMode) {
            case 0: {
                this.logger.log(10000000, "%1#deleteSpellerContent: Initializing phone speller!", (Object)this.getName());
                this.phoneSDSHandler.setPhoneSpeller(by, "", true);
                return 30000;
            }
            case 1: {
                if (this.sequenceHandler.hasSequenceElements(by)) {
                    String string = this.sequenceHandler.removeLastFromSequence(by);
                    this.logger.log(10000000, "%1#deleteSpellerContent: Removed sequence element %2, %3Sequence=%4!", (Object)this.getName(), (Object)string, (Object)PhoneSDSHandlerImpl.getSpellerType(by), (Object)this.sequenceHandler.getSequence(by));
                    boolean bl = by != 1;
                    String string2 = this.sequenceHandler.sequenceToString(by, bl ? " " : "");
                    this.logger.log(10000000, "%1#deleteSpellerContent: addDelimiter=%2, setting speller to %3!", (Object)this.getName(), (Object)bl, (Object)string2);
                    this.phoneSDSHandler.setPhoneSpeller(by, string2, false);
                } else {
                    this.logger.log(10000000, "%1#deleteSpellerContent: Nothing to remove!", (Object)this.getName());
                }
                return 30000;
            }
        }
        this.logger.log(100000, "%1#deleteSpellerContent: Unhandled deleteMode %2!", (Object)this.getName(), (long)this.deleteMode);
        return 30001;
    }
}

