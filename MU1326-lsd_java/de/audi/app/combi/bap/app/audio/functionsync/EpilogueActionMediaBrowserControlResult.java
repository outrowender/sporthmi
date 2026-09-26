/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.combi.bap.app.audio.functionsync;

import de.audi.app.bap.fw.AbstractBAPModuleFSG;
import de.audi.app.bap.fw.functiontypes.BAPFunctionMethodFSG;
import de.audi.app.combi.bap.functionsync.AbstractFunctionSyncEpilogueAction;
import de.audi.atip.log.LogChannel;
import de.vw.mib.bap.generated.audiosd.serializer.MediaBrowserControl_Result;

final class EpilogueActionMediaBrowserControlResult
extends AbstractFunctionSyncEpilogueAction {
    public EpilogueActionMediaBrowserControlResult(AbstractBAPModuleFSG abstractBAPModuleFSG, LogChannel logChannel) {
        super(abstractBAPModuleFSG, logChannel);
    }

    @Override
    public void execute() {
        BAPFunctionMethodFSG bAPFunctionMethodFSG = this.module.getBAPFunctionMethodFSG(38);
        if (bAPFunctionMethodFSG.isResultWaiting()) {
            this.logChannel.log(-2137614336, "[EpilogueActionMediaBrowserControlResult#execute] MediaBrowserControl result waiting -> send now");
            MediaBrowserControl_Result mediaBrowserControl_Result = (MediaBrowserControl_Result)this.module.createResultSerializer(38);
            mediaBrowserControl_Result.browserControlResult = bAPFunctionMethodFSG.getWaitingResult();
            bAPFunctionMethodFSG.resultREQ(mediaBrowserControl_Result);
        } else {
            this.logChannel.log(-2137614336, "[EpilogueActionMediaBrowserControlResult#execute] MediaBrowserControl result not waiting");
        }
    }
}

