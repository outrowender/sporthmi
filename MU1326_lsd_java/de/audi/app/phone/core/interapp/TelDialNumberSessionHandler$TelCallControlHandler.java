/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.phone.core.interapp;

import de.audi.app.phone.core.interapp.TelDialNumberSessionHandler;
import de.audi.atip.interapp.phone.ITelCallControl;

class TelDialNumberSessionHandler$TelCallControlHandler
implements ITelCallControl {
    private final short telCallId;
    private final /* synthetic */ TelDialNumberSessionHandler this$0;

    public TelDialNumberSessionHandler$TelCallControlHandler(TelDialNumberSessionHandler telDialNumberSessionHandler, short s) {
        this.this$0 = telDialNumberSessionHandler;
        this.telCallId = s;
    }

    @Override
    public void hangupCall() {
        TelDialNumberSessionHandler.access$000(this.this$0).log(1078071040, "[TelDialNumberSessionHandler.TelCallControlHandler#hangupCall] hanging up callID=%1", (long)this.telCallId);
        TelDialNumberSessionHandler.access$100(this.this$0).getTelephoneDSIAccess().hangupCall(this.telCallId, 0);
    }

    @Override
    public void muteMicrophone(boolean bl) {
        TelDialNumberSessionHandler.access$200(this.this$0).log(1078071040, "[TelDialNumberSessionHandler.TelCallControlHandler#muteMicrophone] mute=%1", bl);
        int n = bl ? 0 : 1;
        TelDialNumberSessionHandler.access$300(this.this$0).getTelephoneDSIAccess().requestSetMICMuteState(n, 0);
    }
}

