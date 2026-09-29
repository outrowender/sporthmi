/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.phone.core.audio;

import de.audi.app.phone.core.audio.ITelAudioCmdListener;
import de.audi.app.phone.core.audio.TelAudioWavePlayerCmdListener;
import de.audi.tghu.command.CommandResponse;
import org.dsi.ifc.base.DSIListener;

class TelAudioWavePlayerCmdListener$1
extends CommandResponse {
    private final /* synthetic */ int val$status;
    private final /* synthetic */ TelAudioWavePlayerCmdListener this$0;

    TelAudioWavePlayerCmdListener$1(TelAudioWavePlayerCmdListener telAudioWavePlayerCmdListener, int n) {
        this.this$0 = telAudioWavePlayerCmdListener;
        this.val$status = n;
    }

    @Override
    public void call(DSIListener dSIListener) {
        ITelAudioCmdListener iTelAudioCmdListener = TelAudioWavePlayerCmdListener.access$000(this.this$0);
        try {
            iTelAudioCmdListener = (ITelAudioCmdListener)dSIListener;
        }
        catch (ClassCastException classCastException) {
            TelAudioWavePlayerCmdListener.access$100(this.this$0).log(10000, "[TelAudioWavePlayerCmdListener#state] %1", (Throwable)classCastException);
        }
        iTelAudioCmdListener.state(this.val$status);
    }
}

