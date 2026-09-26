/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.phone.core.audio;

import de.audi.app.phone.core.audio.ITelAudioCmdListener;
import de.audi.app.phone.core.audio.TelAudioWavePlayerCmdListener;
import de.audi.tghu.command.CommandResponse;
import org.dsi.ifc.base.DSIListener;

class TelAudioWavePlayerCmdListener$2
extends CommandResponse {
    private final /* synthetic */ int val$playTone;
    private final /* synthetic */ TelAudioWavePlayerCmdListener this$0;

    TelAudioWavePlayerCmdListener$2(TelAudioWavePlayerCmdListener telAudioWavePlayerCmdListener, int n) {
        this.this$0 = telAudioWavePlayerCmdListener;
        this.val$playTone = n;
    }

    @Override
    public void call(DSIListener dSIListener) {
        ITelAudioCmdListener iTelAudioCmdListener = TelAudioWavePlayerCmdListener.access$000(this.this$0);
        try {
            iTelAudioCmdListener = (ITelAudioCmdListener)dSIListener;
        }
        catch (ClassCastException classCastException) {
            TelAudioWavePlayerCmdListener.access$200(this.this$0).log(10000, "[TelAudioWavePlayerCmdListener#playToneInfo] %1", (Throwable)classCastException);
        }
        iTelAudioCmdListener.playToneInfo(this.val$playTone);
    }
}

