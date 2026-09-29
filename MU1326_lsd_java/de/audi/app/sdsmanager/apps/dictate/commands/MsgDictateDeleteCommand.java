/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.sdsmanager.apps.dictate.commands;

import de.audi.app.sdsmanager.apps.AbstractSystemCallCommand;
import de.audi.app.sdsmanager.apps.SDSHandlerService;
import de.audi.app.sdsmanager.apps.dictate.MessageDictationHandler;
import de.audi.app.sdsmanager.common.SDSUtils;
import de.audi.app.sdsmanager.syscall.ISystemCallParameter;
import de.audi.atip.log.LogChannel;

public class MsgDictateDeleteCommand
extends AbstractSystemCallCommand {
    private static final int DELETE_MODE_UNDO;
    private static final int DELETE_MODE_ALL;
    private static final int DELETE_MODE_UNDO_MAIL_SUBJECT;
    private static final int DELETE_MODE_ALL_MAIL_SUBJECTL;
    private final MessageDictationHandler dictationHandler;
    private final int deleteMode;

    public MsgDictateDeleteCommand(LogChannel logChannel, String string, SDSHandlerService sDSHandlerService, MessageDictationHandler messageDictationHandler, ISystemCallParameter[] iSystemCallParameterArray) {
        super(logChannel, string, sDSHandlerService);
        this.dictationHandler = messageDictationHandler;
        this.deleteMode = SDSUtils.retrieveInteger(iSystemCallParameterArray, 0);
    }

    @Override
    public void execute() {
        this.logger.log(-2137614336, "%1#execute: deleteMode=%2", (Object)this.getName(), (long)this.deleteMode);
        switch (this.deleteMode) {
            case 0: 
            case 2: {
                this.logger.log(-2137614336, "%1#execute: Requesting undo of last section!", (Object)this.getName());
                this.dictationHandler.undoLastInsertion();
                break;
            }
            case 1: {
                this.logger.log(-2137614336, "%1#execute: Requesting deletion of full body!", (Object)this.getName());
                this.dictationHandler.clearBody();
                break;
            }
            case 3: {
                this.logger.log(-2137614336, "%1#execute: Requesting deletion of full body!", (Object)this.getName());
                this.dictationHandler.clearSubject();
                break;
            }
            default: {
                this.logger.log(-1601830656, "%1#execute: Unhandled deletion mode -> NOP!", (Object)this.getName());
            }
        }
        this.sendResult(-131858176);
    }
}

