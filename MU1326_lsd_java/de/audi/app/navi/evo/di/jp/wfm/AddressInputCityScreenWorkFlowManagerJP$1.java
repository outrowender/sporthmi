/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.navi.evo.di.jp.wfm;

import de.audi.app.navi.evo.di.AddressInputUtilEvo;
import de.audi.app.navi.evo.di.jp.wfm.AddressInputCityScreenWorkFlowManagerJP;
import de.audi.tghu.navi.app.command.NavCommand;
import de.audi.tghu.navi.app.di.AddressInputUtil;

class AddressInputCityScreenWorkFlowManagerJP$1
extends NavCommand {
    private final /* synthetic */ AddressInputCityScreenWorkFlowManagerJP this$0;

    AddressInputCityScreenWorkFlowManagerJP$1(AddressInputCityScreenWorkFlowManagerJP addressInputCityScreenWorkFlowManagerJP, String string) {
        this.this$0 = addressInputCityScreenWorkFlowManagerJP;
        super(string);
    }

    @Override
    public void execute() {
        if (this.env.getChoiceModel(-1641806336).getValue() == 0) {
            this.this$0.logChannel.log(-2137614336, "%1#createJPCityScreenListElementSelectedWorkFlow -- ward screen is unavailable.", (Object)this.CLASS_NAME);
            this.this$0.spellerStack.pop();
            if (this.this$0.spellerStack.getActiveSC().getContextID() == 34) {
                this.this$0.spellerStack.pop();
            }
            if (AddressInputUtilEvo.isRemoteHMIPOIContext(this.env)) {
                AddressInputUtil.setNewSearchAreaContextChoiceStatus(this.env, 1);
            }
        } else {
            this.this$0.logChannel.log(-2137614336, "%1#createJPCityScreenListElementSelectedWorkFlow -- enter ward screen.", (Object)this.CLASS_NAME);
        }
        this.getCommandList().commandFinished();
    }
}

