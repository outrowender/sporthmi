/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.sdsmanager.apps.system.commands;

import de.audi.app.sdsmanager.apps.AbstractSystemCallCommand;
import de.audi.app.sdsmanager.apps.SDSHandlerService;
import de.audi.app.sdsmanager.common.ISDSPopupHelper;
import de.audi.atip.log.LogChannel;

public class SystemWaitStateCommand
extends AbstractSystemCallCommand {
    private final ISDSPopupHelper sdsPopupHelper;

    public SystemWaitStateCommand(LogChannel logChannel, String string, SDSHandlerService sDSHandlerService, ISDSPopupHelper iSDSPopupHelper) {
        super(logChannel, string, sDSHandlerService);
        this.sdsPopupHelper = iSDSPopupHelper;
    }

    @Override
    public void execute() {
        this.logger.log(-2137614336, "%1#execute: called", (Object)this.getName());
        this.sdsPopupHelper.triggerSpeechPopup(3, true);
        this.processingFinished();
    }
}

