/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.phone.core.audio;

import de.audi.app.phone.core.audio.ITelAudioCmdListener;
import de.audi.app.phone.core.audio.TelHMIAudioServiceCmdListener;
import de.audi.tghu.command.CommandResponse;
import org.dsi.ifc.base.DSIListener;

class TelHMIAudioServiceCmdListener$1
extends CommandResponse {
    private final /* synthetic */ boolean val$available;
    private final /* synthetic */ TelHMIAudioServiceCmdListener this$0;

    TelHMIAudioServiceCmdListener$1(TelHMIAudioServiceCmdListener telHMIAudioServiceCmdListener, boolean bl) {
        this.this$0 = telHMIAudioServiceCmdListener;
        this.val$available = bl;
    }

    @Override
    public void call(DSIListener dSIListener) {
        ITelAudioCmdListener iTelAudioCmdListener = TelHMIAudioServiceCmdListener.access$000(this.this$0);
        try {
            iTelAudioCmdListener = (ITelAudioCmdListener)dSIListener;
        }
        catch (ClassCastException classCastException) {
            TelHMIAudioServiceCmdListener.access$100(this.this$0).log(10000, "[TelHMIAudioServiceCmdListener#updateAMAvailable] %1", (Throwable)classCastException);
        }
        iTelAudioCmdListener.updateAMAvailable(this.val$available);
    }
}

