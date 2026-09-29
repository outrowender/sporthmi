/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.sdsmanager.apps.dictate.commands;

import de.audi.app.sdsmanager.SDSModelAccess;
import de.audi.app.sdsmanager.apps.AbstractSystemCallCommand;
import de.audi.app.sdsmanager.apps.SDSHandlerService;
import de.audi.app.sdsmanager.apps.dictate.MessageDictationHandler;
import de.audi.app.sdsmanager.apps.dictate.commands.MessageDictateSDSUtils;
import de.audi.app.sdsmanager.common.SDSUtils;
import de.audi.app.sdsmanager.syscall.ISystemCallParameter;
import de.audi.atip.interapp.IMessagingDictationService;
import de.audi.atip.log.LogChannel;

public class MsgDictatePrepareCommand
extends AbstractSystemCallCommand {
    private final IMessagingDictationService messagingService;
    private final int messageType;
    private MessageDictationHandler messageDictationHandler;

    public MsgDictatePrepareCommand(LogChannel logChannel, String string, SDSHandlerService sDSHandlerService, MessageDictationHandler messageDictationHandler, IMessagingDictationService iMessagingDictationService, ISystemCallParameter[] iSystemCallParameterArray) {
        super(logChannel, string, sDSHandlerService);
        this.messageDictationHandler = messageDictationHandler;
        this.messagingService = iMessagingDictationService;
        this.messageType = SDSUtils.retrieveInteger(iSystemCallParameterArray, 0);
    }

    @Override
    public void execute() {
        this.logger.log(-2137614336, "%1#execute: messageType=%2", (Object)this.getName(), (long)this.messageType);
        SDSModelAccess.setMsgDictateModel(this.messageType);
        SDSModelAccess.setDictationPromptLabel("");
        int[] nArray = SDSUtils.translateMulti(this.messageType, MessageDictateSDSUtils.MESSAGE_PARAMETER_2_TYPE_AND_COMPOSITION_MODE);
        int n = nArray[0];
        int n2 = nArray[1];
        if (n == 128 || n2 == 128) {
            this.logger.log(-1601830656, "%1#setCorrectPicklistTitle: Unsupported messageType %2!", (Object)this.getName(), (long)this.messageType);
            this.sendResult(-115080960);
            return;
        }
        this.logger.log(-2137614336, "%1#execute: compositionMode=%2, msgType=%3!", (Object)this.getName(), (long)n2, (long)n);
        this.messagingService.requestBeginDialog(n2, n, false);
    }

    public void responseBeginDialog(int n) {
        this.logger.log(-2137614336, "%1#responseBeginDialog: result=%2", (Object)this.getName(), (long)n);
        this.messageDictationHandler.evaluateCompositionState();
        this.sendResult(n == 0 ? -131858176 : -115080960);
    }
}

