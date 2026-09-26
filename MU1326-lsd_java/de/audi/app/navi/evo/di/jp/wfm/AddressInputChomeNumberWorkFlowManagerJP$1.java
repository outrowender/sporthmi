/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.navi.evo.di.jp.wfm;

import de.audi.app.navi.evo.di.AddressInputUtilEvo;
import de.audi.app.navi.evo.di.jp.wfm.AddressInputChomeNumberWorkFlowManagerJP;
import de.audi.tghu.navi.app.command.NavCommand;
import de.audi.tghu.navi.app.di.AddressInputUtil;

class AddressInputChomeNumberWorkFlowManagerJP$1
extends NavCommand {
    private final /* synthetic */ AddressInputChomeNumberWorkFlowManagerJP this$0;

    AddressInputChomeNumberWorkFlowManagerJP$1(AddressInputChomeNumberWorkFlowManagerJP addressInputChomeNumberWorkFlowManagerJP) {
        this.this$0 = addressInputChomeNumberWorkFlowManagerJP;
    }

    @Override
    public void execute() {
        if (AddressInputChomeNumberWorkFlowManagerJP.access$000(this.this$0).getValue() == 0) {
            if (AddressInputUtilEvo.isOnlineOrNormalPOIContext(this.env)) {
                AddressInputUtil.setNewSearchAreaContextChoiceStatus(this.env, 1);
            }
            this.this$0.spellerStack.pop();
        }
        this.getCommandList().commandFinished();
    }
}

