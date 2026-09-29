/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.phone.core.audio;

import de.audi.app.phone.core.audio.TelAudioMobileSpeechRecognitionListener;
import de.audi.atip.timer.Timer;
import de.audi.atip.timer.TimerListener;

class TelAudioMobileSpeechRecognitionListener$2
implements TimerListener {
    private final /* synthetic */ TelAudioMobileSpeechRecognitionListener this$0;

    TelAudioMobileSpeechRecognitionListener$2(TelAudioMobileSpeechRecognitionListener telAudioMobileSpeechRecognitionListener) {
        this.this$0 = telAudioMobileSpeechRecognitionListener;
    }

    @Override
    public void fireTimer(Timer timer) {
        TelAudioMobileSpeechRecognitionListener.access$100(this.this$0).log(1078071040, "TelAudioMobileSpeechRecognitionListener.TelAudioMobileSpeechRecognitionListener(...).new TimerListener() {...}#fireTimer(): mobileSpeechRecognition is not active - releasing audio connections.");
        this.this$0.setExternSDSActive(false);
    }

    @Override
    public void cancelTimer(Timer timer) {
        TelAudioMobileSpeechRecognitionListener.access$200(this.this$0).log(1078071040, "TelAudioMobileSpeechRecognitionListener.TelAudioMobileSpeechRecognitionListener(...).new TimerListener() {...}#cancelTimer(): ");
    }
}

