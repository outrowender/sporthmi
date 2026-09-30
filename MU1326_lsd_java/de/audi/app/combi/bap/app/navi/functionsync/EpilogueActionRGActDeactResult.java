/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.combi.bap.app.navi.functionsync;

import de.audi.app.bap.fw.AbstractBAPModuleFSG;
import de.audi.app.bap.fw.functiontypes.BAPFunctionMethodFSG;
import de.audi.app.combi.bap.app.navi.CombiModuleNavi;
import de.audi.app.combi.bap.functionsync.AbstractFunctionSyncEpilogueAction;
import de.audi.atip.log.LogChannel;

public class EpilogueActionRGActDeactResult
extends AbstractFunctionSyncEpilogueAction {
    public EpilogueActionRGActDeactResult(AbstractBAPModuleFSG abstractBAPModuleFSG, LogChannel logChannel) {
        super(abstractBAPModuleFSG, logChannel);
    }

    protected void execute() {
        BAPFunctionMethodFSG bAPFunctionMethodFSG = this.module.getBAPFunctionMethodFSG(34);
        if (bAPFunctionMethodFSG.isResultWaiting()) {
            this.logChannel.log(10000000, "[EpilogueActionRGActDeactResult#execute] RGActDeactResult result waiting -> try to send now");
            ((CombiModuleNavi)this.module).rgActDeactSyncFinished();
        } else {
            this.logChannel.log(10000000, "[EpilogueActionRGActDeactResult#execute] RGActDeactResult result not waiting");
        }
    }
}

