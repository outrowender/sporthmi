/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.phone.core.audio;

import de.audi.app.phone.core.audio.TelMicrophoneGainLevelHandler;
import de.audi.app.phone.core.audio.TelMicrophoneGainLevelHandler$1;
import de.audi.mib.jdsi.IDSIClient;
import org.dsi.ifc.audio.DSISound;
import org.dsi.ifc.base.DSIBase;

class TelMicrophoneGainLevelHandler$TelMicrophoneGainLevelDSISoundClient
implements IDSIClient {
    private final /* synthetic */ TelMicrophoneGainLevelHandler this$0;

    private TelMicrophoneGainLevelHandler$TelMicrophoneGainLevelDSISoundClient(TelMicrophoneGainLevelHandler telMicrophoneGainLevelHandler) {
        this.this$0 = telMicrophoneGainLevelHandler;
    }

    @Override
    public void setDSI(DSIBase dSIBase) {
        if (dSIBase instanceof DSISound) {
            TelMicrophoneGainLevelHandler.access$900(this.this$0).log(1078071040, "[TelMicrophoneGainLevelHandler.TelMicrophoneGainLevelDSISoundListener#setDSI] DSISound available");
            TelMicrophoneGainLevelHandler.access$1002(this.this$0, (DSISound)dSIBase);
        } else {
            TelMicrophoneGainLevelHandler.access$1100(this.this$0).log(1078071040, "[TelMicrophoneGainLevelHandler.TelMicrophoneGainLevelDSISoundListener#setDSI] DSISound not available");
            TelMicrophoneGainLevelHandler.access$1002(this.this$0, null);
        }
    }

    @Override
    public int[] getAutoNotifications() {
        return new int[]{37};
    }

    /* synthetic */ TelMicrophoneGainLevelHandler$TelMicrophoneGainLevelDSISoundClient(TelMicrophoneGainLevelHandler telMicrophoneGainLevelHandler, TelMicrophoneGainLevelHandler$1 telMicrophoneGainLevelHandler$1) {
        this(telMicrophoneGainLevelHandler);
    }
}

