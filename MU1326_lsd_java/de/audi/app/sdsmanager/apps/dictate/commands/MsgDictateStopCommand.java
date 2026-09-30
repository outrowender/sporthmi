/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.sdsmanager.apps.dictate.commands;

import de.audi.app.sdsmanager.apps.AbstractSystemCallCommand;
import de.audi.app.sdsmanager.apps.SDSHandlerService;
import de.audi.app.sdsmanager.apps.dictate.MessageDictationHandler;
import de.audi.app.sdsmanager.common.ISDSPopupHelper;
import de.audi.app.sdsmanager.dictation.dsiadapter.IDsiDictationAdapter;
import de.audi.atip.log.LogChannel;

public class MsgDictateStopCommand
extends AbstractSystemCallCommand {
    private final IDsiDictationAdapter dictationAdapter;
    private final MessageDictationHandler dictationHandler;
    private ISDSPopupHelper sdsPopupHelper;

    public MsgDictateStopCommand(LogChannel logChannel, String string, SDSHandlerService sDSHandlerService, MessageDictationHandler messageDictationHandler, IDsiDictationAdapter iDsiDictationAdapter, ISDSPopupHelper iSDSPopupHelper) {
        super(logChannel, string, sDSHandlerService);
        this.dictationHandler = messageDictationHandler;
        this.dictationAdapter = iDsiDictationAdapter;
        this.sdsPopupHelper = iSDSPopupHelper;
    }

    public void execute() {
        this.logger.log(10000000, "%1#execute: called", (Object)this.getName());
        this.dictationHandler.setStopRequested(true);
        this.sdsPopupHelper.triggerHapticalPopup(77, false);
        this.sdsPopupHelper.triggerHapticalPopup(76, false);
        this.dictationHandler.dictationStopped();
        this.dictationAdapter.requestStopDictation();
    }

    public void responseStopDictation(int n) {
        this.logger.log(10000000, "%1#responseStopDictation: result=%2", (Object)this.getName(), (long)n);
        this.dictationHandler.setStopRequested(false);
        this.sendResult(n == 0 ? 75000 : 75001);
    }
}

