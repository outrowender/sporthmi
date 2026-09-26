/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app.rthyperlinking;

import de.audi.atip.hmi.modelaccess.ChoiceModelApp;
import de.audi.atip.interapp.IMessagingService;
import de.audi.atip.log.LogChannel;
import de.audi.tuner.app.TunerBasics;
import de.audi.tuner.app.rthyperlinking.RadiotextHyperlinkProcessor;
import de.audi.tuner.app.rthyperlinking.RadiotextHyperlinkProcessor$AbstractPendingHyperlinkAction;

public class MailPendingHyperlinkAction
extends RadiotextHyperlinkProcessor$AbstractPendingHyperlinkAction {
    private final IMessagingService messaging;

    public MailPendingHyperlinkAction(RadiotextHyperlinkProcessor radiotextHyperlinkProcessor, TunerBasics tunerBasics, String string, IMessagingService iMessagingService) {
        super(radiotextHyperlinkProcessor, tunerBasics, 3, string);
        this.messaging = iMessagingService;
    }

    @Override
    public boolean isExecutable(LogChannel logChannel) {
        boolean bl;
        boolean bl2 = bl = this.basics.getFramework().getSysConst(4004) == 1;
        if (!bl) {
            logChannel.log(-2137614336, "[MailPendingHyperlinkAction.isExecutable] %1, EMail not coded!", (Object)this.hyperlinkContent);
            return false;
        }
        ChoiceModelApp choiceModelApp = this.models.getChoiceModel(4091);
        ChoiceModelApp choiceModelApp2 = this.models.getChoiceModel(154);
        logChannel.log(-2137614336, "[MailPendingHyperlinkAction.isExecutable] %1, phoneReady %2, numMail %3", (Object)this.hyperlinkContent, (long)choiceModelApp.getValue(), (long)choiceModelApp2.getValue());
        return choiceModelApp.getValue() != 1 || choiceModelApp2.getValue() != 0;
    }

    @Override
    public void execute() {
        this.messaging.composeMsgPresetRecipient(1, this.hyperlinkContent);
    }
}

