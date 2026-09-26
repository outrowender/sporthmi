/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.combi.bap.app.audio.functionsync;

import de.audi.app.combi.bap.app.audio.CombiModuleAudio;
import de.audi.app.combi.bap.app.audio.functionsync.FunctionSynchronizationHandlerAudio;
import de.audi.app.combi.bap.functionsync.AbstractFunctionSyncEpilogueAction;
import de.audi.atip.log.LogChannel;
import de.vw.mib.bap.generated.audiosd.serializer.InfoStates_Status;

final class EpilogueActionUpdateInfoStates
extends AbstractFunctionSyncEpilogueAction {
    public EpilogueActionUpdateInfoStates(CombiModuleAudio combiModuleAudio, LogChannel logChannel) {
        super(combiModuleAudio, logChannel);
    }

    @Override
    protected void execute() {
        FunctionSynchronizationHandlerAudio functionSynchronizationHandlerAudio = (FunctionSynchronizationHandlerAudio)this.module.getFunctionSynchronizationHandler();
        InfoStates_Status infoStates_Status = functionSynchronizationHandlerAudio.getInfoStatesPending();
        if (infoStates_Status != null) {
            this.logChannel.log(-2137614336, "[EpilogueActionUpdateInfoStates#execute] send pending InfoStates: %1", (Object)infoStates_Status);
            ((CombiModuleAudio)this.module).statusREQInfoStates(functionSynchronizationHandlerAudio.getInfoStatesPending());
            functionSynchronizationHandlerAudio.setInfoStatesPending(null);
        } else {
            this.logChannel.log(-2137614336, "[EpilogueActionUpdateInfoStates#execute] InfoStates status request not pending");
        }
    }
}

