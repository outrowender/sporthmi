/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.phone.core.audio;

import de.audi.app.phone.core.audio.ITelAudioCmdListener;
import de.audi.app.phone.core.audio.TelHMIAudioServiceCmdListener;
import de.audi.tghu.command.CommandResponse;
import org.dsi.ifc.base.DSIListener;

class TelHMIAudioServiceCmdListener$6
extends CommandResponse {
    private final /* synthetic */ int val$connection;
    private final /* synthetic */ int val$hmiTerminal;
    private final /* synthetic */ TelHMIAudioServiceCmdListener this$0;

    TelHMIAudioServiceCmdListener$6(TelHMIAudioServiceCmdListener telHMIAudioServiceCmdListener, int n, int n2) {
        this.this$0 = telHMIAudioServiceCmdListener;
        this.val$connection = n;
        this.val$hmiTerminal = n2;
    }

    @Override
    public void call(DSIListener dSIListener) {
        ITelAudioCmdListener iTelAudioCmdListener = TelHMIAudioServiceCmdListener.access$000(this.this$0);
        try {
            iTelAudioCmdListener = (ITelAudioCmdListener)dSIListener;
        }
        catch (ClassCastException classCastException) {
            TelHMIAudioServiceCmdListener.access$600(this.this$0).log(10000, "[TelHMIAudioServiceCmdListener#fadedIn] %1", (Throwable)classCastException);
        }
        iTelAudioCmdListener.fadedIn(this.val$connection, this.val$hmiTerminal);
    }
}

