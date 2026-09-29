/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.ecall.core.audio.cmd;

import de.audi.app.ecall.core.audio.cmd.EcalHMIAudioServiceCmdListener;
import de.audi.app.ecall.core.audio.cmd.IEcallAudioCmdListener;
import de.audi.tghu.command.CommandResponse;
import org.dsi.ifc.base.DSIListener;

class EcalHMIAudioServiceCmdListener$1
extends CommandResponse {
    private final /* synthetic */ boolean val$available;
    private final /* synthetic */ EcalHMIAudioServiceCmdListener this$0;

    EcalHMIAudioServiceCmdListener$1(EcalHMIAudioServiceCmdListener ecalHMIAudioServiceCmdListener, boolean bl) {
        this.this$0 = ecalHMIAudioServiceCmdListener;
        this.val$available = bl;
    }

    @Override
    public void call(DSIListener dSIListener) {
        IEcallAudioCmdListener iEcallAudioCmdListener = (IEcallAudioCmdListener)dSIListener;
        iEcallAudioCmdListener.updateAMAvailable(this.val$available);
    }
}

