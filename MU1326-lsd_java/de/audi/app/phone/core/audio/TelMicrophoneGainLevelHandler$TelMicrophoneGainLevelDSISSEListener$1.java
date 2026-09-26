/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.phone.core.audio;

import de.audi.app.phone.core.audio.TelMicrophoneGainLevelHandler;
import de.audi.app.phone.core.audio.TelMicrophoneGainLevelHandler$TelMicrophoneGainLevelDSISSEListener;
import de.audi.app.phone.core.event.AbstractTelDSIUpdateEvent;

class TelMicrophoneGainLevelHandler$TelMicrophoneGainLevelDSISSEListener$1
extends AbstractTelDSIUpdateEvent {
    private final /* synthetic */ int val$validFlag;
    private final /* synthetic */ int val$micGainLevel;
    private final /* synthetic */ TelMicrophoneGainLevelHandler$TelMicrophoneGainLevelDSISSEListener this$1;

    TelMicrophoneGainLevelHandler$TelMicrophoneGainLevelDSISSEListener$1(TelMicrophoneGainLevelHandler$TelMicrophoneGainLevelDSISSEListener telMicrophoneGainLevelHandler$TelMicrophoneGainLevelDSISSEListener, String string, int n, int n2) {
        this.this$1 = telMicrophoneGainLevelHandler$TelMicrophoneGainLevelDSISSEListener;
        this.val$validFlag = n;
        this.val$micGainLevel = n2;
        super(string);
    }

    @Override
    public void run() {
        if (this.val$validFlag == 1) {
            TelMicrophoneGainLevelHandler.access$1400(TelMicrophoneGainLevelHandler$TelMicrophoneGainLevelDSISSEListener.access$1300(this.this$1)).log(1078071040, "[TelMicrophoneGainLevelHandler.TelMicrophoneGainLevelDSISSEListener#updateMicGainLevel] micGainLevel=%1", (long)this.val$micGainLevel);
            if (TelMicrophoneGainLevelHandler.access$500(TelMicrophoneGainLevelHandler$TelMicrophoneGainLevelDSISSEListener.access$1300(this.this$1)) != null && TelMicrophoneGainLevelHandler.access$500(TelMicrophoneGainLevelHandler$TelMicrophoneGainLevelDSISSEListener.access$1300(this.this$1)).isPhoneReady()) {
                TelMicrophoneGainLevelHandler.access$600(TelMicrophoneGainLevelHandler$TelMicrophoneGainLevelDSISSEListener.access$1300(this.this$1), this.val$micGainLevel);
            }
        } else {
            TelMicrophoneGainLevelHandler.access$1500(TelMicrophoneGainLevelHandler$TelMicrophoneGainLevelDSISSEListener.access$1300(this.this$1)).log(1078071040, "[TelMicrophoneGainLevelHandler.TelMicrophoneGainLevelDSISSEListener#updateMicGainLevel] invalid update --> NOP!");
        }
    }
}

