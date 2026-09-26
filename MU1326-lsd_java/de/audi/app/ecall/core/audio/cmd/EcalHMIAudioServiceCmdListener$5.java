/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.ecall.core.audio.cmd;

import de.audi.app.ecall.core.audio.cmd.EcalHMIAudioServiceCmdListener;
import de.audi.app.ecall.core.audio.cmd.IEcallAudioCmdListener;
import de.audi.tghu.command.CommandResponse;
import org.dsi.ifc.base.DSIListener;

class EcalHMIAudioServiceCmdListener$5
extends CommandResponse {
    private final /* synthetic */ int val$connection;
    private final /* synthetic */ int val$hmiTerminal;
    private final /* synthetic */ int val$errorCode;
    private final /* synthetic */ EcalHMIAudioServiceCmdListener this$0;

    EcalHMIAudioServiceCmdListener$5(EcalHMIAudioServiceCmdListener ecalHMIAudioServiceCmdListener, int n, int n2, int n3) {
        this.this$0 = ecalHMIAudioServiceCmdListener;
        this.val$connection = n;
        this.val$hmiTerminal = n2;
        this.val$errorCode = n3;
    }

    @Override
    public void call(DSIListener dSIListener) {
        IEcallAudioCmdListener iEcallAudioCmdListener = (IEcallAudioCmdListener)dSIListener;
        iEcallAudioCmdListener.errorConnection(this.val$connection, this.val$hmiTerminal, this.val$errorCode);
    }
}

