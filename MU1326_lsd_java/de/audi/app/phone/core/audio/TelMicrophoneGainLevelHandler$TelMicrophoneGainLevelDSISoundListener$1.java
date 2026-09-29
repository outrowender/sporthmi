/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.phone.core.audio;

import de.audi.app.phone.core.audio.TelMicrophoneGainLevelHandler;
import de.audi.app.phone.core.audio.TelMicrophoneGainLevelHandler$TelMicrophoneGainLevelDSISoundListener;
import de.audi.app.phone.core.event.AbstractTelDSIUpdateEvent;

class TelMicrophoneGainLevelHandler$TelMicrophoneGainLevelDSISoundListener$1
extends AbstractTelDSIUpdateEvent {
    private final /* synthetic */ int val$validFlag;
    private final /* synthetic */ int val$micGainLevel;
    private final /* synthetic */ TelMicrophoneGainLevelHandler$TelMicrophoneGainLevelDSISoundListener this$1;

    TelMicrophoneGainLevelHandler$TelMicrophoneGainLevelDSISoundListener$1(TelMicrophoneGainLevelHandler$TelMicrophoneGainLevelDSISoundListener telMicrophoneGainLevelHandler$TelMicrophoneGainLevelDSISoundListener, String string, int n, int n2) {
        this.this$1 = telMicrophoneGainLevelHandler$TelMicrophoneGainLevelDSISoundListener;
        this.val$validFlag = n;
        this.val$micGainLevel = n2;
        super(string);
    }

    @Override
    public void run() {
        if (this.val$validFlag == 1) {
            TelMicrophoneGainLevelHandler.access$400(TelMicrophoneGainLevelHandler$TelMicrophoneGainLevelDSISoundListener.access$300(this.this$1)).log(1078071040, "[TelMicrophoneGainLevelHandler.TelMicrophoneGainLevelDSISoundListener#updateMicGainLevel] micGainLevel=%1", (long)this.val$micGainLevel);
            if (TelMicrophoneGainLevelHandler.access$500(TelMicrophoneGainLevelHandler$TelMicrophoneGainLevelDSISoundListener.access$300(this.this$1)) != null && TelMicrophoneGainLevelHandler.access$500(TelMicrophoneGainLevelHandler$TelMicrophoneGainLevelDSISoundListener.access$300(this.this$1)).isPhoneReady()) {
                TelMicrophoneGainLevelHandler.access$600(TelMicrophoneGainLevelHandler$TelMicrophoneGainLevelDSISoundListener.access$300(this.this$1), this.val$micGainLevel);
            }
        } else {
            TelMicrophoneGainLevelHandler.access$700(TelMicrophoneGainLevelHandler$TelMicrophoneGainLevelDSISoundListener.access$300(this.this$1)).log(1078071040, "[TelMicrophoneGainLevelHandler.TelMicrophoneGainLevelDSISoundListener#updateMicGainLevel] invalid update --> NOP!");
        }
    }
}

