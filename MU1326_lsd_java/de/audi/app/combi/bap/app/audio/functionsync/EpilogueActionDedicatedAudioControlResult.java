/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.combi.bap.app.audio.functionsync;

import de.audi.app.bap.fw.AbstractBAPModuleFSG;
import de.audi.app.bap.fw.functiontypes.BAPFunctionMethodFSG;
import de.audi.app.combi.bap.app.audio.CombiModuleAudio;
import de.audi.app.combi.bap.functionsync.AbstractFunctionSyncEpilogueAction;
import de.audi.atip.log.LogChannel;
import de.vw.mib.bap.generated.audiosd.serializer.DedicatedAudioControl_Result;

final class EpilogueActionDedicatedAudioControlResult
extends AbstractFunctionSyncEpilogueAction {
    public EpilogueActionDedicatedAudioControlResult(AbstractBAPModuleFSG abstractBAPModuleFSG, LogChannel logChannel) {
        super(abstractBAPModuleFSG, logChannel);
    }

    protected void execute() {
        BAPFunctionMethodFSG bAPFunctionMethodFSG = this.module.getBAPFunctionMethodFSG(24);
        if (bAPFunctionMethodFSG.isResultWaiting()) {
            this.logChannel.log(10000000, "[EpilogueActionDedicatedAudioControlResult#execute] DedicatedAudioControl result waiting -> send now");
            DedicatedAudioControl_Result dedicatedAudioControl_Result = (DedicatedAudioControl_Result)this.module.createResultSerializer(24);
            dedicatedAudioControl_Result.dedicatedAudioControlResult = bAPFunctionMethodFSG.getWaitingResult();
            bAPFunctionMethodFSG.resultREQ(dedicatedAudioControl_Result);
            ((CombiModuleAudio)this.module).getDedicatedAudioControlHandler().processingFinished();
        } else {
            this.logChannel.log(10000000, "[EpilogueActionDedicatedAudioControlResult#execute] DedicatedAudioControl result not waiting");
        }
    }
}

