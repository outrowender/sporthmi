/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.combi.bap.app.audio.functionsync;

import de.audi.app.bap.fw.AbstractBAPModuleFSG;
import de.audi.app.bap.fw.functiontypes.BAPFunctionMethodFSG;
import de.audi.app.combi.bap.functionsync.AbstractFunctionSyncEpilogueAction;
import de.audi.atip.log.LogChannel;
import de.vw.mib.bap.generated.audiosd.serializer.SwitchSource_Result;

final class EpilogueActionSwitchSourceResult
extends AbstractFunctionSyncEpilogueAction {
    public EpilogueActionSwitchSourceResult(AbstractBAPModuleFSG abstractBAPModuleFSG, LogChannel logChannel) {
        super(abstractBAPModuleFSG, logChannel);
    }

    @Override
    public void execute() {
        BAPFunctionMethodFSG bAPFunctionMethodFSG = this.module.getBAPFunctionMethodFSG(34);
        if (bAPFunctionMethodFSG.isResultWaiting()) {
            this.logChannel.log(-2137614336, "[EpilogueActionSwitchSourceResult#execute] SwitchSource result waiting -> send now");
            SwitchSource_Result switchSource_Result = (SwitchSource_Result)this.module.createResultSerializer(34);
            switchSource_Result.switchSourceResult = bAPFunctionMethodFSG.getWaitingResult();
            bAPFunctionMethodFSG.resultREQ(switchSource_Result);
        } else {
            this.logChannel.log(-2137614336, "[EpilogueActionSwitchSourceResult#execute] SwitchSource result not waiting");
        }
    }
}

