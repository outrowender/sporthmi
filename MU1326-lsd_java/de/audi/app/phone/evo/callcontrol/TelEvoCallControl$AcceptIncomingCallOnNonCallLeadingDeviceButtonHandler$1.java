/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.phone.evo.callcontrol;

import de.audi.app.phone.core.dsi.TelDefaultDSIResponseListener;
import de.audi.app.phone.evo.callcontrol.TelEvoCallControl$AcceptIncomingCallOnNonCallLeadingDeviceButtonHandler;

class TelEvoCallControl$AcceptIncomingCallOnNonCallLeadingDeviceButtonHandler$1
extends TelDefaultDSIResponseListener {
    private final /* synthetic */ TelEvoCallControl$AcceptIncomingCallOnNonCallLeadingDeviceButtonHandler this$1;

    TelEvoCallControl$AcceptIncomingCallOnNonCallLeadingDeviceButtonHandler$1(TelEvoCallControl$AcceptIncomingCallOnNonCallLeadingDeviceButtonHandler telEvoCallControl$AcceptIncomingCallOnNonCallLeadingDeviceButtonHandler) {
        this.this$1 = telEvoCallControl$AcceptIncomingCallOnNonCallLeadingDeviceButtonHandler;
    }

    @Override
    public void responseHangupCall(int n, int n2) {
        if (n == 0) {
            TelEvoCallControl$AcceptIncomingCallOnNonCallLeadingDeviceButtonHandler.access$100(this.this$1).acceptOnNCLDOngoing(true);
        }
    }

    @Override
    public void responseAcceptCall(int n, int n2) {
        TelEvoCallControl$AcceptIncomingCallOnNonCallLeadingDeviceButtonHandler.access$100(this.this$1).acceptOnNCLDOngoing(false);
    }
}

