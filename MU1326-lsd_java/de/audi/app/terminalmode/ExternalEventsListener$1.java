/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.terminalmode;

import de.audi.app.terminalmode.ExternalEventsListener;
import de.audi.app.terminalmode.commands.PhoneStateUpdate;
import de.audi.atip.interapp.phone.ITelState;
import de.audi.atip.interapp.phone.ITelStateListener;

class ExternalEventsListener$1
implements ITelStateListener {
    private final /* synthetic */ ExternalEventsListener this$0;

    ExternalEventsListener$1(ExternalEventsListener externalEventsListener) {
        this.this$0 = externalEventsListener;
    }

    @Override
    public void updateTelState(int n, ITelState iTelState) {
        ExternalEventsListener.access$000(this.this$0).log(1078071040, "<- [%1.updateTelState]", (Object)"ExternalEventsListener");
        ExternalEventsListener.access$100(this.this$0).getCommandListHelper().create().addSingle(new PhoneStateUpdate(ExternalEventsListener.access$100(this.this$0), iTelState.getCallActive(), ExternalEventsListener.access$200(this.this$0))).execute("ExternalEventsListener.updateTelState");
        ExternalEventsListener.access$300(this.this$0).getPropertyMUHFPPhonecallActive().accept(new Boolean(iTelState.getCallActive()));
    }
}

