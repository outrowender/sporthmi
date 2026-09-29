/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.sdsmanager.apps.phone.commands;

import de.audi.app.sdsmanager.SDSModelAccess;
import de.audi.app.sdsmanager.apps.AbstractSystemCallCommand;
import de.audi.app.sdsmanager.apps.SDSHandlerService;
import de.audi.app.sdsmanager.apps.phone.PhoneSequenceElement;
import de.audi.app.sdsmanager.apps.phone.PhoneSequenceHandler;
import de.audi.app.sdsmanager.common.SDSUtils;
import de.audi.app.sdsmanager.syscall.ISystemCallParameter;
import de.audi.atip.log.LogChannel;
import java.util.ArrayList;
import java.util.List;

public class PhoneNumberGetCommand
extends AbstractSystemCallCommand {
    private final int numberTypeID;
    private final PhoneSequenceHandler sequenceHandler;

    public PhoneNumberGetCommand(LogChannel logChannel, String string, SDSHandlerService sDSHandlerService, PhoneSequenceHandler phoneSequenceHandler, ISystemCallParameter[] iSystemCallParameterArray) {
        super(logChannel, string, sDSHandlerService);
        this.sequenceHandler = phoneSequenceHandler;
        this.numberTypeID = SDSUtils.retrieveInteger(iSystemCallParameterArray, 0);
    }

    @Override
    public void execute() {
        this.logger.log(-2137614336, "%1#execute: numberTypeID=%2!", (Object)this.getName(), (long)this.numberTypeID);
        List list = new ArrayList(3);
        switch (this.numberTypeID) {
            case 0: 
            case 1: 
            case 2: {
                list = this.sequenceHandler.getSequence((byte)this.numberTypeID);
                break;
            }
            default: {
                this.logger.log(-1601830656, "%1#execute: Unhandled numberTypeID %2!", (Object)this.getName(), (long)this.numberTypeID);
                this.sendResult(30001);
                return;
            }
        }
        String string = PhoneSequenceHandler.sequencetoString(list);
        this.logger.log(-2137614336, "%1#execute: numberList=%2, number=%3!", (Object)this.getName(), (Object)list, (Object)string);
        int n = list.size();
        String string2 = n < 1 ? "" : ((PhoneSequenceElement)list.get(n - 1)).getNumber();
        this.logger.log(-2137614336, "%1#execute: size=%3, lastNumber=%2!", (Object)this.getName(), (Object)string2, (long)n);
        SDSModelAccess.setPhoneCompleteNumberModel(string);
        SDSModelAccess.setPhoneLastSequenceModel(string2);
        this.sendResult(30000);
    }
}

