/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.online.evo;

import de.audi.app.online.evo.RemoteHMIServiceEvo;
import de.audi.atip.log.LogChannel;
import de.audi.tghu.online.app.remotehmi.AbstractCommandHandler;

class RemoteHMIServiceEvo$2
extends AbstractCommandHandler {
    private final /* synthetic */ LogChannel val$logChannel;
    private final /* synthetic */ RemoteHMIServiceEvo this$0;

    RemoteHMIServiceEvo$2(RemoteHMIServiceEvo remoteHMIServiceEvo, String string, LogChannel logChannel) {
        this.this$0 = remoteHMIServiceEvo;
        this.val$logChannel = logChannel;
        super(string);
    }

    @Override
    public void indicateCommand(int n, Object object) {
        boolean bl;
        if (object instanceof Boolean && (bl = ((Boolean)object).booleanValue())) {
            this.val$logChannel.log(1078071040, "RemoteHMIServiceEvo#indicateCommand: state STATE_CONNECTIVITY_CHANGED");
            this.this$0.getModelBankAccess().getChoiceModel(907813632).setValue(0);
        }
    }
}

