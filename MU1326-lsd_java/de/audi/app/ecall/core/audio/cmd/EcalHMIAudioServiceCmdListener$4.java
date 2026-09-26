/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.ecall.core.audio.cmd;

import de.audi.app.ecall.core.audio.cmd.EcalHMIAudioServiceCmdListener;
import de.audi.app.ecall.core.audio.cmd.IEcallAudioCmdListener;
import de.audi.tghu.command.CommandResponse;
import org.dsi.ifc.base.DSIListener;

class EcalHMIAudioServiceCmdListener$4
extends CommandResponse {
    private final /* synthetic */ int val$connection;
    private final /* synthetic */ int val$hmiTerminal;
    private final /* synthetic */ EcalHMIAudioServiceCmdListener this$0;

    EcalHMIAudioServiceCmdListener$4(EcalHMIAudioServiceCmdListener ecalHMIAudioServiceCmdListener, int n, int n2) {
        this.this$0 = ecalHMIAudioServiceCmdListener;
        this.val$connection = n;
        this.val$hmiTerminal = n2;
    }

    @Override
    public void call(DSIListener dSIListener) {
        IEcallAudioCmdListener iEcallAudioCmdListener = (IEcallAudioCmdListener)dSIListener;
        iEcallAudioCmdListener.startConnection(this.val$connection, this.val$hmiTerminal);
    }
}

