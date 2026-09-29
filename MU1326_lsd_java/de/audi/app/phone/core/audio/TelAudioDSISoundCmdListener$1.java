/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.phone.core.audio;

import de.audi.app.phone.core.audio.ITelAudioCmdListener;
import de.audi.app.phone.core.audio.TelAudioDSISoundCmdListener;
import de.audi.tghu.command.CommandResponse;
import org.dsi.ifc.base.DSIListener;

class TelAudioDSISoundCmdListener$1
extends CommandResponse {
    private final /* synthetic */ int val$terminal;
    private final /* synthetic */ boolean val$onoff;
    private final /* synthetic */ TelAudioDSISoundCmdListener this$0;

    TelAudioDSISoundCmdListener$1(TelAudioDSISoundCmdListener telAudioDSISoundCmdListener, int n, boolean bl) {
        this.this$0 = telAudioDSISoundCmdListener;
        this.val$terminal = n;
        this.val$onoff = bl;
    }

    @Override
    public void call(DSIListener dSIListener) {
        ITelAudioCmdListener iTelAudioCmdListener = TelAudioDSISoundCmdListener.access$100(this.this$0);
        try {
            iTelAudioCmdListener = (ITelAudioCmdListener)dSIListener;
        }
        catch (ClassCastException classCastException) {
            TelAudioDSISoundCmdListener.access$200(this.this$0).log(10000, "[TelAudioDSISoundCmdListener#responseWidebandSpeech] %1", (Throwable)classCastException);
        }
        iTelAudioCmdListener.responseWidebandSpeech(this.val$terminal, this.val$onoff);
    }
}

