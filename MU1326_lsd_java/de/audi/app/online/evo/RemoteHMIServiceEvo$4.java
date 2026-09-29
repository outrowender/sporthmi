/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.online.evo;

import de.audi.app.online.evo.RemoteHMIServiceEvo;
import de.audi.atip.hmi.modelaccess.ChoiceModelApp;
import de.audi.atip.hmi.modelaccess.LabelModelApp;
import de.audi.atip.log.LogChannel;
import de.audi.tghu.online.app.remotehmi.AbstractCommandHandler;

class RemoteHMIServiceEvo$4
extends AbstractCommandHandler {
    private final /* synthetic */ LogChannel val$logChannel;
    private final /* synthetic */ RemoteHMIServiceEvo this$0;

    RemoteHMIServiceEvo$4(RemoteHMIServiceEvo remoteHMIServiceEvo, String string, LogChannel logChannel) {
        this.this$0 = remoteHMIServiceEvo;
        this.val$logChannel = logChannel;
        super(string);
    }

    @Override
    public void indicateCommand(int n, Object object) {
        this.val$logChannel.log(1078071040, "RemoteHMIServiceEvo#ctor (ICommandHandler): mobile device was personalized via service discovery.");
        if (object instanceof String) {
            String string = (String)object;
            this.val$logChannel.log(1078071040, "RemoteHMIServiceEvo#ctor (ICommandHandler): connected device %1, showing popzp", (Object)string);
            LabelModelApp labelModelApp = this.this$0.getModelBankAccess().getLabelModel(1931223808);
            labelModelApp.setText(string);
            ChoiceModelApp choiceModelApp = this.this$0.getModelBankAccess().getChoiceModel(1948001024);
            choiceModelApp.setValue(~choiceModelApp.getValue());
        }
    }
}

