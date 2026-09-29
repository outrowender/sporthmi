/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.online.evo;

import de.audi.app.online.evo.SwitchToOnlineComponent;
import de.audi.atip.hmi.modelaccess.ChoiceModelApp;
import de.audi.atip.log.LogChannel;
import de.audi.tghu.online.app.remotehmi.AbstractCommandHandler;
import de.audi.tghu.online.app.remotehmi.RemoteHMIService;

class SwitchToOnlineComponent$1
extends AbstractCommandHandler {
    private final /* synthetic */ LogChannel val$logChannel;
    private final /* synthetic */ RemoteHMIService val$remoteHmiService;
    private final /* synthetic */ SwitchToOnlineComponent this$0;

    SwitchToOnlineComponent$1(SwitchToOnlineComponent switchToOnlineComponent, String string, LogChannel logChannel, RemoteHMIService remoteHMIService) {
        this.this$0 = switchToOnlineComponent;
        this.val$logChannel = logChannel;
        this.val$remoteHmiService = remoteHMIService;
        super(string);
    }

    @Override
    public void indicateCommand(int n, Object object) {
        if (object != null && object instanceof Integer) {
            int n2 = (Integer)object;
            this.val$logChannel.log(1078071040, "SwitchToOnlineComponent#indicateCommand(): switching to service type %1", (long)n2);
            ChoiceModelApp choiceModelApp = this.val$remoteHmiService.getModelBankAccess().getChoiceModel(4586);
            choiceModelApp.setValue(n2);
            ChoiceModelApp choiceModelApp2 = this.val$remoteHmiService.getModelBankAccess().getChoiceModel(4622);
            choiceModelApp2.setValue(~choiceModelApp2.getValue());
            return;
        }
        this.val$logChannel.log(-1601830656, "SwitchToOnlineComponent#indicateCommand(): encountered unexpected payload object.");
    }
}

