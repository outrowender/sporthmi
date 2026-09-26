/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.phone.evo.callcontrol;

import de.audi.app.phone.core.ITelApplication;
import de.audi.app.phone.core.model.TelDefaultButtonListener;
import de.audi.app.phone.evo.callcontrol.TelEvoCallControl;
import de.audi.app.phone.evo.callcontrol.TelEvoCallControl$AcceptIncomingCallOnNonCallLeadingDeviceButtonHandler$1;

class TelEvoCallControl$AcceptIncomingCallOnNonCallLeadingDeviceButtonHandler
extends TelDefaultButtonListener {
    private final /* synthetic */ TelEvoCallControl this$0;

    public TelEvoCallControl$AcceptIncomingCallOnNonCallLeadingDeviceButtonHandler(TelEvoCallControl telEvoCallControl, ITelApplication iTelApplication) {
        this.this$0 = telEvoCallControl;
        super(iTelApplication, -392756224);
    }

    @Override
    public void keyTyped(int n, int n2, int n3) {
        this.log.log(1078071040, "[TelEvoCallControl.AcceptIncomingCallOnNonCallLeadingDeviceButtonHandler#keyTyped]");
        TelEvoCallControl.access$000(this.this$0);
        this.getApplication().getTelephoneDSIAccess().acceptIncomingCallOnNonCallLeadingDevice(n3, true, new TelEvoCallControl$AcceptIncomingCallOnNonCallLeadingDeviceButtonHandler$1(this));
    }

    static /* synthetic */ TelEvoCallControl access$100(TelEvoCallControl$AcceptIncomingCallOnNonCallLeadingDeviceButtonHandler telEvoCallControl$AcceptIncomingCallOnNonCallLeadingDeviceButtonHandler) {
        return telEvoCallControl$AcceptIncomingCallOnNonCallLeadingDeviceButtonHandler.this$0;
    }
}

