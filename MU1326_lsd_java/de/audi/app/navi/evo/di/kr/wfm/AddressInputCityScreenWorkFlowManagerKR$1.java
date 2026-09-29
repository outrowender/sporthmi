/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.navi.evo.di.kr.wfm;

import de.audi.app.navi.evo.di.kr.wfm.AddressInputCityScreenWorkFlowManagerKR;
import de.audi.tghu.navi.app.command.NavCommand;

class AddressInputCityScreenWorkFlowManagerKR$1
extends NavCommand {
    private final /* synthetic */ AddressInputCityScreenWorkFlowManagerKR this$0;

    AddressInputCityScreenWorkFlowManagerKR$1(AddressInputCityScreenWorkFlowManagerKR addressInputCityScreenWorkFlowManagerKR, String string) {
        this.this$0 = addressInputCityScreenWorkFlowManagerKR;
        super(string);
    }

    @Override
    public void execute() {
        if (this.env.getChoiceModel(-1641806336).getValue() == 0) {
            this.this$0.logChannel.log(-2137614336, "%1#createKRCityScreenListElementSelectedWorkFlow -- ward screen is unavailable.", (Object)this.CLASS_NAME);
            this.this$0.spellerStack.pop();
        } else {
            this.this$0.logChannel.log(-2137614336, "%1#createKRCityScreenListElementSelectedWorkFlow -- enter ward screen.", (Object)this.CLASS_NAME);
        }
        this.getCommandList().commandFinished();
    }
}

