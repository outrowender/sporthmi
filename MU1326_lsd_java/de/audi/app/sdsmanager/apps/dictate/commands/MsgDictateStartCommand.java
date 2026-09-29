/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.sdsmanager.apps.dictate.commands;

import de.audi.app.sdsmanager.apps.AbstractSystemCallCommand;
import de.audi.app.sdsmanager.apps.SDSHandlerService;
import de.audi.app.sdsmanager.apps.dictate.MessageDictationHandler;
import de.audi.app.sdsmanager.common.ISDSPopupHelper;
import de.audi.app.sdsmanager.common.SDSUtils;
import de.audi.app.sdsmanager.dictation.dsiadapter.IDsiDictationAdapter;
import de.audi.app.sdsmanager.syscall.ISystemCallParameter;
import de.audi.atip.log.LogChannel;

public class MsgDictateStartCommand
extends AbstractSystemCallCommand {
    private final MessageDictationHandler dictationHandler;
    private final int textType;
    private final IDsiDictationAdapter dictationAdapter;
    private final ISDSPopupHelper popupHelper;

    public MsgDictateStartCommand(LogChannel logChannel, String string, SDSHandlerService sDSHandlerService, ISystemCallParameter[] iSystemCallParameterArray, MessageDictationHandler messageDictationHandler, IDsiDictationAdapter iDsiDictationAdapter, ISDSPopupHelper iSDSPopupHelper) {
        super(logChannel, string, sDSHandlerService);
        this.dictationHandler = messageDictationHandler;
        this.dictationAdapter = iDsiDictationAdapter;
        this.popupHelper = iSDSPopupHelper;
        this.textType = SDSUtils.retrieveInteger(iSystemCallParameterArray, 0);
    }

    @Override
    public void execute() {
        this.logger.log(-2137614336, "%1#execute: textType=%2", (Object)this.getName(), (long)this.textType);
        this.dictationHandler.setStopRequested(false);
        this.dictationHandler.setDictationStep(this.textType);
        this.dictationAdapter.requestStartDictation(this.dictationHandler.getCurrentRecipient());
    }

    public void responseStartDictation(int n) {
        this.logger.log(-2137614336, "%1#responseStartDictation: result=%2", (Object)this.getName(), (long)n);
        if (n == 0) {
            if (this.textType == 2 || this.textType == 5) {
                this.popupHelper.triggerHapticalPopup(77, true);
                this.popupHelper.removeFurtherCommandDisplay();
            } else {
                this.dictationHandler.dictationStarted();
            }
            this.sendResult(-131858176);
        } else {
            this.sendResult(-115080960);
        }
    }
}

