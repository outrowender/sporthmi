/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.phone.core.audio;

import de.audi.app.phone.core.audio.TelAudiDSISoundDefaultHandler;
import de.audi.app.phone.core.audio.TelMicrophoneGainLevelHandler;
import de.audi.app.phone.core.audio.TelMicrophoneGainLevelHandler$1;
import de.audi.app.phone.core.audio.TelMicrophoneGainLevelHandler$TelMicrophoneGainLevelDSISoundListener$1;

class TelMicrophoneGainLevelHandler$TelMicrophoneGainLevelDSISoundListener
extends TelAudiDSISoundDefaultHandler {
    private final /* synthetic */ TelMicrophoneGainLevelHandler this$0;

    private TelMicrophoneGainLevelHandler$TelMicrophoneGainLevelDSISoundListener(TelMicrophoneGainLevelHandler telMicrophoneGainLevelHandler) {
        this.this$0 = telMicrophoneGainLevelHandler;
    }

    @Override
    public void updateMicGainLevel(int n, int n2) {
        TelMicrophoneGainLevelHandler.access$800(this.this$0).enqueueEvent(new TelMicrophoneGainLevelHandler$TelMicrophoneGainLevelDSISoundListener$1(this, "TelAudiDSISoundDefaultHandler#updateMicGainLevel", n2, n));
    }

    /* synthetic */ TelMicrophoneGainLevelHandler$TelMicrophoneGainLevelDSISoundListener(TelMicrophoneGainLevelHandler telMicrophoneGainLevelHandler, TelMicrophoneGainLevelHandler$1 telMicrophoneGainLevelHandler$1) {
        this(telMicrophoneGainLevelHandler);
    }

    static /* synthetic */ TelMicrophoneGainLevelHandler access$300(TelMicrophoneGainLevelHandler$TelMicrophoneGainLevelDSISoundListener telMicrophoneGainLevelHandler$TelMicrophoneGainLevelDSISoundListener) {
        return telMicrophoneGainLevelHandler$TelMicrophoneGainLevelDSISoundListener.this$0;
    }
}

