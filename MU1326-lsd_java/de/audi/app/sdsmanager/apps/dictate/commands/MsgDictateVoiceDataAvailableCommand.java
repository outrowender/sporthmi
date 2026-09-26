/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.sdsmanager.apps.dictate.commands;

import de.audi.app.sdsmanager.SDSModelAccess;
import de.audi.app.sdsmanager.apps.AbstractSystemCallCommand;
import de.audi.app.sdsmanager.apps.SDSHandlerService;
import de.audi.app.sdsmanager.apps.dictate.MessageDictationHandler;
import de.audi.app.sdsmanager.common.ISDSPopupHelper;
import de.audi.app.sdsmanager.common.SDSUtils;
import de.audi.app.sdsmanager.dictation.dsiadapter.IDsiDictationAdapter;
import de.audi.app.sdsmanager.syscall.ISystemCall;
import de.audi.atip.log.LogChannel;
import java.util.LinkedList;

public class MsgDictateVoiceDataAvailableCommand
extends AbstractSystemCallCommand {
    private final MessageDictationHandler dictationHandler;
    private final IDsiDictationAdapter dictationAdapter;
    private ISDSPopupHelper popupHelper;
    private static final int DICT_STATUS_OK;
    private static final int DICT_STATUS_ERROR_PROXY;
    private static final int DICT_STATUS_ERROR_CONNECTION;
    private static final int DICT_STATUS_ERROR_LANGUAGE;
    private static final int DICT_STATUS_ERROR_RECOG_FAILURE;
    private static final int DICT_STATUS_ERROR_TIMEOUT;
    private static final int DICT_STATUS_ERROR_GENERIC;
    private static final int[][] result2modelValue;

    public MsgDictateVoiceDataAvailableCommand(LogChannel logChannel, String string, SDSHandlerService sDSHandlerService, MessageDictationHandler messageDictationHandler, IDsiDictationAdapter iDsiDictationAdapter, ISDSPopupHelper iSDSPopupHelper) {
        super(logChannel, string, sDSHandlerService);
        this.dictationHandler = messageDictationHandler;
        this.dictationAdapter = iDsiDictationAdapter;
        this.popupHelper = iSDSPopupHelper;
    }

    @Override
    public void execute() {
        this.logger.log(-2137614336, "%1#execute: called", (Object)this.getName());
        this.dictationHandler.setStopRequested(false);
        this.dictationAdapter.requestProcessVoiceData();
    }

    public void responseProcessVoiceData(int n, LinkedList linkedList) {
        if (this.sdsHandlerService.isOnlineRecogResultsInvalid()) {
            this.sendResult(-131858176);
            return;
        }
        this.logger.log(-2137614336, "%1#responseProcessVoiceData: result=%3, text=%2", (Object)this.getName(), (Object)linkedList, (long)n);
        int n2 = SDSUtils.translate(n, result2modelValue);
        if (n2 == 128) {
            n2 = 0;
        }
        SDSModelAccess.setDictationRecognitionStatusChoice(n2);
        this.dictationHandler.dictationStopped();
        this.logger.log(-2137614336, "%1#responseProcessVoiceData: hide processing popup!", (Object)this.getName());
        this.popupHelper.triggerHapticalPopup(77, false);
        if (n == 0) {
            this.logger.log(-2137614336, "%1#responseProcessVoiceData: dictation successful -> handle result", (Object)this.getName());
            this.dictationHandler.handleDictationResult(linkedList);
        }
        this.sendResult(-131858176);
    }

    @Override
    public byte getActionOnNewSystemCall(ISystemCall iSystemCall) {
        return iSystemCall.getId() == -785645312 ? (byte)1 : 0;
    }

    static {
        result2modelValue = new int[][]{{0, 1}, {41, 6}, {42, 2}, {43, 2}, {44, 2}, {45, 2}, {46, 2}, {47, 2}, {48, 2}, {51, 6}, {52, 3}, {53, 3}, {54, 3}, {56, 3}, {55, 3}, {61, 4}, {62, 5}};
    }
}

