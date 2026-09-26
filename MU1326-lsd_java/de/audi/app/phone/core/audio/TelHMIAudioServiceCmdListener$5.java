/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.phone.core.audio;

import de.audi.app.phone.core.audio.ITelAudioCmdListener;
import de.audi.app.phone.core.audio.TelHMIAudioServiceCmdListener;
import de.audi.tghu.command.CommandResponse;
import org.dsi.ifc.base.DSIListener;

class TelHMIAudioServiceCmdListener$5
extends CommandResponse {
    private final /* synthetic */ int val$connection;
    private final /* synthetic */ int val$hmiTerminal;
    private final /* synthetic */ int val$errorCode;
    private final /* synthetic */ TelHMIAudioServiceCmdListener this$0;

    TelHMIAudioServiceCmdListener$5(TelHMIAudioServiceCmdListener telHMIAudioServiceCmdListener, int n, int n2, int n3) {
        this.this$0 = telHMIAudioServiceCmdListener;
        this.val$connection = n;
        this.val$hmiTerminal = n2;
        this.val$errorCode = n3;
    }

    @Override
    public void call(DSIListener dSIListener) {
        ITelAudioCmdListener iTelAudioCmdListener = TelHMIAudioServiceCmdListener.access$000(this.this$0);
        try {
            iTelAudioCmdListener = (ITelAudioCmdListener)dSIListener;
        }
        catch (ClassCastException classCastException) {
            TelHMIAudioServiceCmdListener.access$500(this.this$0).log(10000, "[TelHMIAudioServiceCmdListener#errorConnection] %1", (Throwable)classCastException);
        }
        iTelAudioCmdListener.errorConnection(this.val$connection, this.val$hmiTerminal, this.val$errorCode);
    }
}

