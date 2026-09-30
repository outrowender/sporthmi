/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.combi.bap.app.audio.functionsync;

import de.audi.app.bap.fw.AbstractBAPModuleFSG;
import de.audi.app.bap.fw.functiontypes.BAPFunctionMethodFSG;
import de.audi.app.combi.bap.app.audio.CombiModuleAudio;
import de.audi.app.combi.bap.functionsync.AbstractFunctionSyncEpilogueAction;
import de.audi.atip.log.LogChannel;
import de.vw.mib.bap.generated.audiosd.serializer.SwitchRadioMedia_Result;

final class EpilogueActionSwitchRadioMediaResult
extends AbstractFunctionSyncEpilogueAction {
    public EpilogueActionSwitchRadioMediaResult(AbstractBAPModuleFSG abstractBAPModuleFSG, LogChannel logChannel) {
        super(abstractBAPModuleFSG, logChannel);
    }

    public void execute() {
        BAPFunctionMethodFSG bAPFunctionMethodFSG = this.module.getBAPFunctionMethodFSG(45);
        if (bAPFunctionMethodFSG.isMethodProcessing()) {
            this.logChannel.log(10000000, "[EpilogueActionSwitchRadioMediaResult#execute] SwitchRadioMedia result pending -> send now");
            BAPFunctionMethodFSG bAPFunctionMethodFSG2 = this.module.getBAPFunctionMethodFSG(45);
            SwitchRadioMedia_Result switchRadioMedia_Result = (SwitchRadioMedia_Result)((CombiModuleAudio)this.module).createResultSerializer(45);
            switchRadioMedia_Result.switchRadioMediaResult = 0;
            bAPFunctionMethodFSG2.resultREQ(switchRadioMedia_Result);
        } else {
            this.logChannel.log(10000000, "[EpilogueActionSwitchRadioMediaResult#execute] SwitchRadioMedia result not pending");
        }
    }
}

