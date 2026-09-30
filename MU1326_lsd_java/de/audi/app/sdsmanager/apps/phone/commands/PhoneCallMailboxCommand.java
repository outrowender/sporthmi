/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.sdsmanager.apps.phone.commands;

import de.audi.app.sdsmanager.apps.SDSHandlerService;
import de.audi.app.sdsmanager.apps.phone.PhoneSDSHandlerImpl;
import de.audi.app.sdsmanager.apps.phone.commands.AbstractPhoneCallCommand;
import de.audi.app.sdsmanager.common.SDSUtils;
import de.audi.atip.hmi.HMIService;
import de.audi.atip.log.LogChannel;
import de.audi.atip.phone.ITelServiceSDS;

public class PhoneCallMailboxCommand
extends AbstractPhoneCallCommand {
    public PhoneCallMailboxCommand(LogChannel logChannel, String string, SDSHandlerService sDSHandlerService, ITelServiceSDS iTelServiceSDS, HMIService hMIService, PhoneSDSHandlerImpl phoneSDSHandlerImpl) {
        super(logChannel, string, sDSHandlerService, iTelServiceSDS, hMIService, phoneSDSHandlerImpl);
    }

    public void execute() {
        String string = this.phoneService.getMailboxNumber();
        if (SDSUtils.isEmpty(string)) {
            this.logger.log(10000000, "%1#execute: No mailbox number available!", (Object)this.getName());
            this.sendResult(30002);
            return;
        }
        super.dial(string);
    }
}

