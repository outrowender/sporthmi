/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.combi.bap.app.audio.sds;

import de.audi.app.combi.bap.AbstractCombiConnector;
import de.audi.app.combi.bap.app.audio.CombiModuleAudio;
import de.audi.atip.interapp.combi.bap.audio.CombiBAPServiceSDS;
import de.vw.mib.bap.generated.audiosd.serializer.SDS_State_Status;

public class AppConnectorSDS
extends AbstractCombiConnector
implements CombiBAPServiceSDS {
    public AppConnectorSDS(CombiModuleAudio combiModuleAudio) {
        super(combiModuleAudio);
    }

    @Override
    public void updateSDSState(int n) {
        this.logChannel.log(1078071040, "[AppConnectorSDS#updateSDSState] called (state=%1)", (long)n);
        SDS_State_Status sDS_State_Status = new SDS_State_Status();
        sDS_State_Status.state = n;
        this.moduleFsg.getBAPFunctionPropertyFSG(41).sendStatusIfChanged(sDS_State_Status);
    }
}

