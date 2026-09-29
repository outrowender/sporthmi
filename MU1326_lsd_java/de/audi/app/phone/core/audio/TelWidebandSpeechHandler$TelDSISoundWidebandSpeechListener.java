/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.phone.core.audio;

import de.audi.app.phone.core.audio.TelDefaultDSISoundListener;
import de.audi.app.phone.core.audio.TelWidebandSpeechHandler;
import de.audi.app.phone.core.audio.TelWidebandSpeechHandler$1;

class TelWidebandSpeechHandler$TelDSISoundWidebandSpeechListener
extends TelDefaultDSISoundListener {
    private final /* synthetic */ TelWidebandSpeechHandler this$0;

    private TelWidebandSpeechHandler$TelDSISoundWidebandSpeechListener(TelWidebandSpeechHandler telWidebandSpeechHandler) {
        this.this$0 = telWidebandSpeechHandler;
    }

    @Override
    public void responseWidebandSpeech(int n, boolean bl) {
        TelWidebandSpeechHandler.access$100(this.this$0).log(1078071040, "[TelWidebandSpeechHandler.TelDSISoundWidebandSpeechListener#responseWidebandSpeech] widebandSpeech=%1", bl);
        if (TelWidebandSpeechHandler.access$200(this.this$0)) {
            TelWidebandSpeechHandler.access$302(this.this$0, bl ? 2 : 1);
        } else {
            TelWidebandSpeechHandler.access$400(this.this$0).log(-1601830656, "[TelWidebandSpeechHandler.TelDSISoundWidebandSpeechListener#responseWidebandSpeech] AMAvailable=FALSE, reset WBS setting to UNKNOWN");
            TelWidebandSpeechHandler.access$302(this.this$0, 0);
        }
    }

    /* synthetic */ TelWidebandSpeechHandler$TelDSISoundWidebandSpeechListener(TelWidebandSpeechHandler telWidebandSpeechHandler, TelWidebandSpeechHandler$1 telWidebandSpeechHandler$1) {
        this(telWidebandSpeechHandler);
    }
}

