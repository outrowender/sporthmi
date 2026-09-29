/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.navi.evo.di.cn.listeners;

import de.audi.app.navi.evo.di.cn.listeners.AddressInputCityScreenListenerCN;
import de.audi.tghu.navi.app.command.NavCommand;

class AddressInputCityScreenListenerCN$1
extends NavCommand {
    private final /* synthetic */ AddressInputCityScreenListenerCN this$0;

    AddressInputCityScreenListenerCN$1(AddressInputCityScreenListenerCN addressInputCityScreenListenerCN, String string) {
        this.this$0 = addressInputCityScreenListenerCN;
        super(string);
    }

    @Override
    public void execute() {
        AddressInputCityScreenListenerCN.access$000(this.this$0).getPoiService().startPoiWithSearchContext(4, this.dsiResponseContainer.getLiCurrentLD(), true);
        this.getCommandList().commandFinished();
    }
}

