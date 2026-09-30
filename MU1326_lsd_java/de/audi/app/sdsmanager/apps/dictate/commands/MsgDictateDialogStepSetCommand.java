/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.sdsmanager.apps.dictate.commands;

import de.audi.app.sdsmanager.apps.AbstractSystemCallCommand;
import de.audi.app.sdsmanager.apps.SDSHandlerService;
import de.audi.app.sdsmanager.apps.dictate.MessageDictationHandler;
import de.audi.app.sdsmanager.common.SDSUtils;
import de.audi.app.sdsmanager.syscall.ISystemCallParameter;
import de.audi.atip.interapp.IMessagingDictationService;
import de.audi.atip.log.LogChannel;

public class MsgDictateDialogStepSetCommand
extends AbstractSystemCallCommand {
    protected static final int DIALOG_STEP_BODY_START = 2;
    protected static final int DIALOG_STEP_BODY_EXTEND = 5;
    protected static final int DIALOG_STEP_SUBJECT_START = 1;
    protected static final int DIALOG_STEP_SUBJECT_EXTEND = 4;
    private int[] dialogStepArray = new int[]{0, 1, 2, 3, 1, 2};
    private final IMessagingDictationService dictationService;
    private final MessageDictationHandler messageDictationHandler;
    private final int dialogStepIndex;

    protected int getDialogStepIndex() {
        return this.dialogStepIndex;
    }

    public MsgDictateDialogStepSetCommand(LogChannel logChannel, String string, SDSHandlerService sDSHandlerService, MessageDictationHandler messageDictationHandler, IMessagingDictationService iMessagingDictationService, ISystemCallParameter[] iSystemCallParameterArray) {
        super(logChannel, string, sDSHandlerService);
        this.dictationService = iMessagingDictationService;
        this.messageDictationHandler = messageDictationHandler;
        this.dialogStepIndex = SDSUtils.retrieveInteger(iSystemCallParameterArray, 0);
    }

    public void execute() {
        this.logger.log(10000000, "%1#execute: dialogStepIndex=%2", (Object)this.getName(), (long)this.dialogStepIndex);
        if (this.dialogStepIndex < 0 || this.dialogStepIndex > this.dialogStepArray.length - 1) {
            this.logger.log(100000, "%1#execute: dialogStepIndex is out of bounds!", (Object)this.getName());
            this.sendResult(75001);
            return;
        }
        int n = this.dialogStepArray[this.dialogStepIndex];
        this.dictationService.requestDialogStep(n);
    }

    public void responseNextDialogStep(int n) {
        if (n == 0) {
            switch (this.dialogStepIndex) {
                case 2: {
                    this.messageDictationHandler.positionBodyCursor(0);
                    break;
                }
                case 1: {
                    this.messageDictationHandler.positionSubjectCursor(0);
                    break;
                }
                case 5: {
                    break;
                }
                case 4: {
                    break;
                }
            }
            this.sendResult(75000);
        } else {
            this.sendResult(75001);
        }
    }
}

