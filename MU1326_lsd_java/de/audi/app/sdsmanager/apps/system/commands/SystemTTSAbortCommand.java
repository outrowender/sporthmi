/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.sdsmanager.apps.system.commands;

import de.audi.app.sdsmanager.AppSDSManager;
import de.audi.app.sdsmanager.apps.AbstractSystemCallCommand;
import de.audi.app.sdsmanager.apps.SDSHandlerService;
import de.audi.app.sdsmanager.apps.system.ISystemVBIHandler;
import de.audi.app.sdsmanager.apps.system.SystemSDSHandler;
import de.audi.atip.log.LogChannel;

public class SystemTTSAbortCommand
extends AbstractSystemCallCommand {
    private final AppSDSManager appSDSManager;
    private final SystemSDSHandler systemHandler;
    private final ISystemVBIHandler systemVBIHandler;

    public SystemTTSAbortCommand(LogChannel logChannel, String string, AppSDSManager appSDSManager, SDSHandlerService sDSHandlerService, SystemSDSHandler systemSDSHandler, ISystemVBIHandler iSystemVBIHandler) {
        super(logChannel, string, sDSHandlerService);
        this.appSDSManager = appSDSManager;
        this.systemHandler = systemSDSHandler;
        this.systemVBIHandler = iSystemVBIHandler;
    }

    public void execute() {
        this.logger.log(10000000, "%1#execute: called", (Object)this.getName());
        if (this.systemVBIHandler.isRegularPromptAtSessionEndActive()) {
            return;
        }
        if (this.systemHandler.abortCurrentPrompt((byte)0, false, -1)) {
            this.logger.log(10000000, "%1#execute: TTS (already) aborting => Wait for aborting of prompt!", (Object)this.getName());
            return;
        }
        this.logger.log(10000000, "%1#execute: TTS idle and not aborted => Sending OK!", (Object)this.getName());
        this.sendResult(3000);
    }

    public void currentTTSPromptEnded() {
        this.logger.log(10000000, "%1#currentTTSPromptEnded: Current TTS prompt ended => sending OK!", (Object)this.getName());
        this.sendResult(3000);
    }

    public boolean isSDSEndSequenceCommand() {
        return this.appSDSManager.isSDSAborting();
    }
}

