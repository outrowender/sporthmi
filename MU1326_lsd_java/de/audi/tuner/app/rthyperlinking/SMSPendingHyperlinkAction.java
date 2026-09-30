/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app.rthyperlinking;

import de.audi.atip.hmi.modelaccess.ChoiceModelApp;
import de.audi.atip.interapp.IMessagingService;
import de.audi.atip.log.LogChannel;
import de.audi.tuner.app.TunerBasics;
import de.audi.tuner.app.rthyperlinking.RadiotextHyperlinkProcessor;

public class SMSPendingHyperlinkAction
extends RadiotextHyperlinkProcessor.AbstractPendingHyperlinkAction {
    private final IMessagingService messaging;

    public SMSPendingHyperlinkAction(RadiotextHyperlinkProcessor radiotextHyperlinkProcessor, TunerBasics tunerBasics, String string, IMessagingService iMessagingService) {
        super(radiotextHyperlinkProcessor, tunerBasics, 2, string);
        this.messaging = iMessagingService;
    }

    public boolean isExecutable(LogChannel logChannel) {
        boolean bl;
        boolean bl2 = bl = this.basics.getFramework().getSysConst(472) == 1;
        if (!bl) {
            logChannel.log(10000000, "[SMSPendingHyperlinkAction.isExecutable] %1, Messaging not coded!", (Object)this.hyperlinkContent);
            return false;
        }
        ChoiceModelApp choiceModelApp = this.models.getChoiceModel(4091);
        ChoiceModelApp choiceModelApp2 = this.models.getChoiceModel(155);
        logChannel.log(10000000, "[SMSPendingHyperlinkAction.isExecutable] %1, phoneReady %2, numSms %3", (Object)this.hyperlinkContent, (long)choiceModelApp.getValue(), (long)choiceModelApp2.getValue());
        return choiceModelApp.getValue() != 1 || choiceModelApp2.getValue() != 0;
    }

    public void execute() {
        this.messaging.composeMsgPresetRecipient(0, this.hyperlinkContent);
    }
}

