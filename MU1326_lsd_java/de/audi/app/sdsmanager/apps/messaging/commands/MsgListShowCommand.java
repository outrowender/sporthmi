/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.sdsmanager.apps.messaging.commands;

import de.audi.app.sdsmanager.apps.AbstractSystemCallCommand;
import de.audi.app.sdsmanager.apps.SDSHandlerService;
import de.audi.app.sdsmanager.common.ISDSPopupHelper;
import de.audi.atip.log.LogChannel;

public class MsgListShowCommand
extends AbstractSystemCallCommand {
    private ISDSPopupHelper popupHelper;

    public MsgListShowCommand(LogChannel logChannel, String string, SDSHandlerService sDSHandlerService, ISDSPopupHelper iSDSPopupHelper) {
        super(logChannel, string, sDSHandlerService);
        this.popupHelper = iSDSPopupHelper;
    }

    public void execute() {
        this.logger.log(10000000, "%1#execute: called", (Object)this.getName());
        this.popupHelper.triggerHapticalPopup(75, true);
        this.sendResult(75000);
    }
}

