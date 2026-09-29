/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.phone.evo.callcontrol;

import de.audi.app.phone.core.ITelApplication;
import de.audi.app.phone.core.model.TelDefaultButtonListener;
import de.audi.app.phone.evo.callcontrol.TelEvoCallControl;

class TelEvoCallControl$RejectIncomingCallOnNonCallLeadingDeviceButtonHandler
extends TelDefaultButtonListener {
    private final /* synthetic */ TelEvoCallControl this$0;

    public TelEvoCallControl$RejectIncomingCallOnNonCallLeadingDeviceButtonHandler(TelEvoCallControl telEvoCallControl, ITelApplication iTelApplication) {
        this.this$0 = telEvoCallControl;
        super(iTelApplication, -359201792);
    }

    @Override
    public void keyTyped(int n, int n2, int n3) {
        this.log.log(1078071040, "[TelEvoCallControl.RejectIncomingCallOnNonCallLeadingDeviceButtonHandler#keyTyped]");
        TelEvoCallControl.access$200(this.this$0).closeEntertainmentDrawer();
        this.getApplication().getTelephoneDSIAccess().rejectIncomingCallOnNonCallLeadingDevice(n3);
    }
}

