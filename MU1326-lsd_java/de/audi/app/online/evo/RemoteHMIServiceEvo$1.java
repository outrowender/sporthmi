/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.online.evo;

import de.audi.app.online.evo.RemoteHMIServiceEvo;
import de.audi.atip.hmi.modelaccess.ChoiceModelApp;
import de.audi.atip.log.LogChannel;
import de.audi.tghu.online.app.remotehmi.AbstractCommandHandler;

class RemoteHMIServiceEvo$1
extends AbstractCommandHandler {
    private final /* synthetic */ LogChannel val$logChannel;
    private final /* synthetic */ RemoteHMIServiceEvo this$0;

    RemoteHMIServiceEvo$1(RemoteHMIServiceEvo remoteHMIServiceEvo, String string, LogChannel logChannel) {
        this.this$0 = remoteHMIServiceEvo;
        this.val$logChannel = logChannel;
        super(string);
    }

    @Override
    public void indicateCommand(int n, Object object) {
        if (RemoteHMIServiceEvo.access$200(this.this$0) && RemoteHMIServiceEvo.access$300(this.this$0) == 1) {
            this.val$logChannel.log(1078071040, "RemoteHMIServiceEvo#indicateCommand: state STATE_PREDEVELOPMENT_GOTO_AUDI_CONNECT skipped (already in Audi Connect)");
            return;
        }
        ChoiceModelApp choiceModelApp = this.this$0.getModelBankAccess().getChoiceModel(452);
        choiceModelApp.setValue(~choiceModelApp.getValue());
        this.val$logChannel.log(1078071040, "RemoteHMIServiceEvo#indicateCommand: state STATE_PREDEVELOPMENT_GOTO_AUDI_CONNECT triggered");
    }
}

