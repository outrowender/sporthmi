/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.phone.evo.audio;

import de.audi.app.phone.core.ITelApplication;
import de.audi.app.phone.core.model.TelDefaultButtonListener;
import de.audi.app.phone.evo.audio.TelEvoAudioTransferPopupHandler;

class TelEvoAudioTransferPopupHandler$KeepAudioOnMEButtonListener
extends TelDefaultButtonListener {
    private final /* synthetic */ TelEvoAudioTransferPopupHandler this$0;

    public TelEvoAudioTransferPopupHandler$KeepAudioOnMEButtonListener(TelEvoAudioTransferPopupHandler telEvoAudioTransferPopupHandler, ITelApplication iTelApplication) {
        this.this$0 = telEvoAudioTransferPopupHandler;
        super(iTelApplication, -174652416);
    }

    @Override
    public void keyTyped(int n, int n2, int n3) {
        this.log.log(1078071040, "[TelEvoAudioTransferPopupHandler.KeepAudioOnMEButtonListener#keyTyped]");
        TelEvoAudioTransferPopupHandler.access$000(this.this$0);
    }
}

