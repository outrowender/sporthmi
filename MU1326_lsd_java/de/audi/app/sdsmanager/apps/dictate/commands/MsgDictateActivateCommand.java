/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.sdsmanager.apps.dictate.commands;

import de.audi.app.sdsmanager.apps.AbstractSystemCallCommand;
import de.audi.app.sdsmanager.apps.SDSHandlerService;
import de.audi.app.sdsmanager.apps.dictate.MessageDictationHandler;
import de.audi.app.sdsmanager.dictation.dsiadapter.IDsiDictationAdapter;
import de.audi.atip.log.LogChannel;

public class MsgDictateActivateCommand
extends AbstractSystemCallCommand {
    private final IDsiDictationAdapter dictationAdapter;
    private MessageDictationHandler dictationHandler;

    public MsgDictateActivateCommand(LogChannel logChannel, String string, SDSHandlerService sDSHandlerService, IDsiDictationAdapter iDsiDictationAdapter, MessageDictationHandler messageDictationHandler) {
        super(logChannel, string, sDSHandlerService);
        this.dictationAdapter = iDsiDictationAdapter;
        this.dictationHandler = messageDictationHandler;
    }

    public void execute() {
        this.logger.log(10000000, "%1#execute: called", (Object)this.getName());
        if (this.dictationHandler == null) {
            this.logger.log(10000000, "%1#execute: dictation handler is null, send error!", (Object)this.getName());
            this.sendResult(75001);
            return;
        }
        this.logger.log(10000000, "%1#execute: dictation handler ok.", (Object)this.getName());
        if (this.dictationHandler.getActivationState() == 1) {
            this.logger.log(10000000, "%1#execute: state already in activation -> sending ok", (Object)this.getName());
            this.sendResult(75000);
            return;
        }
        if (this.dictationAdapter == null) {
            this.logger.log(10000000, "%1#execute: dictation adapter is null, send error!", (Object)this.getName());
            this.sendResult(75001);
            return;
        }
        this.logger.log(10000000, "%1#execute: dictation adapter ok.", (Object)this.getName());
        this.dictationAdapter.requestActivateDictation();
    }

    public void responseActivateDictation(int n) {
        this.logger.log(10000000, "%1#responseActivateDictation: result=%2", (Object)this.getName(), (long)n);
        this.sendResult(n == 0 ? 75000 : 75001);
    }

    public void responseStartDictation(int n) {
        this.logger.log(10000000, "%1#responseStartDictation: result=%2", (Object)this.getName(), (long)n);
        this.sendResult(n == 0 ? 75000 : 75001);
    }
}

