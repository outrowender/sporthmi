/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.online.evo;

import de.audi.app.online.evo.OnlineEvoActionProxyImpl;
import de.audi.atip.hmi.modelaccess.ChoiceModelApp;
import de.audi.tghu.online.app.remotehmi.AbstractRemoteHMITask;

class OnlineEvoActionProxyImpl$4
extends AbstractRemoteHMITask {
    private final /* synthetic */ OnlineEvoActionProxyImpl this$0;

    OnlineEvoActionProxyImpl$4(OnlineEvoActionProxyImpl onlineEvoActionProxyImpl, String string) {
        this.this$0 = onlineEvoActionProxyImpl;
        super(string);
    }

    @Override
    public void run() {
        OnlineEvoActionProxyImpl.access$202(this.this$0, false);
        OnlineEvoActionProxyImpl.access$100(this.this$0).replaceExitView();
        ChoiceModelApp choiceModelApp = this.this$0.modelBankAccess.getChoiceModel(1025254144);
        choiceModelApp.setValue(0);
    }
}

