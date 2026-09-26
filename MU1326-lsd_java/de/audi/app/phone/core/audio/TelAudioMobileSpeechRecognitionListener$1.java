/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.phone.core.audio;

import de.audi.app.phone.core.audio.TelAudioMobileSpeechRecognitionListener;
import de.audi.mib.jdsi.IDSIClient;
import org.dsi.ifc.base.DSIBase;
import org.dsi.ifc.telephone.DSIMobileSpeechRecognition;

class TelAudioMobileSpeechRecognitionListener$1
implements IDSIClient {
    private final /* synthetic */ TelAudioMobileSpeechRecognitionListener this$0;

    TelAudioMobileSpeechRecognitionListener$1(TelAudioMobileSpeechRecognitionListener telAudioMobileSpeechRecognitionListener) {
        this.this$0 = telAudioMobileSpeechRecognitionListener;
    }

    @Override
    public void setDSI(DSIBase dSIBase) {
        if (dSIBase instanceof DSIMobileSpeechRecognition) {
            TelAudioMobileSpeechRecognitionListener.access$002(this.this$0, (DSIMobileSpeechRecognition)dSIBase);
        } else {
            TelAudioMobileSpeechRecognitionListener.access$002(this.this$0, null);
        }
    }

    @Override
    public int[] getAutoNotifications() {
        return new int[]{2, 1, 3};
    }
}

