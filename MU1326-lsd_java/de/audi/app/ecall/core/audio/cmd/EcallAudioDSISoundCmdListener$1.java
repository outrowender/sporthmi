/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  de.mib.swdiagnosis.ecall.IEcallDiagnosisComponent
 */
package de.audi.app.ecall.core.audio.cmd;

import de.audi.app.ecall.core.audio.cmd.EcallAudioDSISoundCmdListener;
import de.mib.swdiagnosis.ecall.IEcallDiagnosisComponent;

class EcallAudioDSISoundCmdListener$1
implements IEcallDiagnosisComponent {
    private final /* synthetic */ EcallAudioDSISoundCmdListener this$0;

    EcallAudioDSISoundCmdListener$1(EcallAudioDSISoundCmdListener ecallAudioDSISoundCmdListener) {
        this.this$0 = ecallAudioDSISoundCmdListener;
    }

    public void cmdUpdateMutePinState(boolean bl) {
        this.this$0.updateMutePinState(bl, 1);
    }
}

