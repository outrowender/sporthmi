/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.ecall.core.audio.cmd;

import de.audi.app.ecall.core.audio.cmd.EcallAudioDSISoundCmdListener;
import de.audi.app.ecall.core.audio.cmd.EcallAudioDSISoundCmdListener$1;
import de.audi.mib.jdsi.IDSIClient;
import org.dsi.ifc.audio.DSISound;
import org.dsi.ifc.base.DSIBase;

class EcallAudioDSISoundCmdListener$EcallAudioDSISoundClient
implements IDSIClient {
    private final /* synthetic */ EcallAudioDSISoundCmdListener this$0;

    private EcallAudioDSISoundCmdListener$EcallAudioDSISoundClient(EcallAudioDSISoundCmdListener ecallAudioDSISoundCmdListener) {
        this.this$0 = ecallAudioDSISoundCmdListener;
    }

    @Override
    public void setDSI(DSIBase dSIBase) {
        if (dSIBase instanceof DSISound) {
            EcallAudioDSISoundCmdListener.access$300(this.this$0).log(1078071040, "[EcallAudioDSISoundCmdListener.EcallAudioDSISoundClient#setDSI] DSISound available");
        } else {
            EcallAudioDSISoundCmdListener.access$400(this.this$0).log(1078071040, "[EcallAudioDSISoundCmdListener.EcallAudioDSISoundClient#setDSI] DSISound not available");
        }
    }

    @Override
    public int[] getAutoNotifications() {
        return new int[]{14, 24};
    }

    /* synthetic */ EcallAudioDSISoundCmdListener$EcallAudioDSISoundClient(EcallAudioDSISoundCmdListener ecallAudioDSISoundCmdListener, EcallAudioDSISoundCmdListener$1 ecallAudioDSISoundCmdListener$1) {
        this(ecallAudioDSISoundCmdListener);
    }
}

