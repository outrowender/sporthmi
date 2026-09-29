/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.phone.core.audio;

import de.audi.app.phone.core.audio.TelAudioDSISoundCmdListener;
import de.audi.app.phone.core.audio.TelAudioDSISoundCmdListener$1;
import de.audi.mib.jdsi.IDSIClient;
import org.dsi.ifc.audio.DSISound;
import org.dsi.ifc.base.DSIBase;

class TelAudioDSISoundCmdListener$TelAudioDSISoundClient
implements IDSIClient {
    private final /* synthetic */ TelAudioDSISoundCmdListener this$0;

    private TelAudioDSISoundCmdListener$TelAudioDSISoundClient(TelAudioDSISoundCmdListener telAudioDSISoundCmdListener) {
        this.this$0 = telAudioDSISoundCmdListener;
    }

    @Override
    public void setDSI(DSIBase dSIBase) {
        if (dSIBase instanceof DSISound) {
            TelAudioDSISoundCmdListener.access$300(this.this$0).log(1078071040, "[TelAudioHandler.TelAudioDSISoundClient#setDSI] DSISound available");
        } else {
            TelAudioDSISoundCmdListener.access$400(this.this$0).log(1078071040, "[TelAudioHandler.TelAudioDSISoundClient#setDSI] DSISound not available");
        }
    }

    @Override
    public int[] getAutoNotifications() {
        return new int[0];
    }

    /* synthetic */ TelAudioDSISoundCmdListener$TelAudioDSISoundClient(TelAudioDSISoundCmdListener telAudioDSISoundCmdListener, TelAudioDSISoundCmdListener$1 telAudioDSISoundCmdListener$1) {
        this(telAudioDSISoundCmdListener);
    }
}

