/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.ecall.core.audio.cmd;

import de.audi.app.ecall.core.audio.cmd.EcallAudioDSISoundCmdListener;
import de.audi.app.ecall.core.audio.cmd.IEcallAudioCmdListener;
import de.audi.tghu.command.CommandResponse;
import org.dsi.ifc.base.DSIListener;

class EcallAudioDSISoundCmdListener$2
extends CommandResponse {
    private final /* synthetic */ boolean val$mutePinState;
    private final /* synthetic */ int val$validFlag;
    private final /* synthetic */ EcallAudioDSISoundCmdListener this$0;

    EcallAudioDSISoundCmdListener$2(EcallAudioDSISoundCmdListener ecallAudioDSISoundCmdListener, boolean bl, int n) {
        this.this$0 = ecallAudioDSISoundCmdListener;
        this.val$mutePinState = bl;
        this.val$validFlag = n;
    }

    @Override
    public void call(DSIListener dSIListener) {
        IEcallAudioCmdListener iEcallAudioCmdListener = EcallAudioDSISoundCmdListener.access$100(this.this$0);
        try {
            iEcallAudioCmdListener = (IEcallAudioCmdListener)dSIListener;
        }
        catch (ClassCastException classCastException) {
            EcallAudioDSISoundCmdListener.access$200(this.this$0).log(10000, "[EcallAudioDSISoundCmdListener#updateMutePinState] %1", (Throwable)classCastException);
        }
        iEcallAudioCmdListener.updateMutePinState(this.val$mutePinState, this.val$validFlag);
    }
}

