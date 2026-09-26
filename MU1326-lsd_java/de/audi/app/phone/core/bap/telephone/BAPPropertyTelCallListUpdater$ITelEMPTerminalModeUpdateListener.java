/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.phone.core.bap.telephone;

import de.audi.app.phone.core.bap.telephone.BAPPropertyTelCallListUpdater;
import de.audi.app.phone.core.bap.telephone.BAPPropertyTelCallListUpdater$1;
import de.audi.atip.interapp.terminalmode.DefaultTerminalModeUpdateListener;
import de.audi.atip.interapp.terminalmode.TerminalModeDevice;

class BAPPropertyTelCallListUpdater$ITelEMPTerminalModeUpdateListener
extends DefaultTerminalModeUpdateListener {
    private final /* synthetic */ BAPPropertyTelCallListUpdater this$0;

    private BAPPropertyTelCallListUpdater$ITelEMPTerminalModeUpdateListener(BAPPropertyTelCallListUpdater bAPPropertyTelCallListUpdater) {
        this.this$0 = bAPPropertyTelCallListUpdater;
    }

    @Override
    public void updateActiveDeviceState(TerminalModeDevice terminalModeDevice) {
        if (terminalModeDevice == null) {
            BAPPropertyTelCallListUpdater.access$300(this.this$0).log(10000, "ITelEMPTerminalModeUpdateListener#updateActiveDeviceState activeDevice is null");
            return;
        }
        BAPPropertyTelCallListUpdater.access$402(this.this$0, terminalModeDevice.getConnectionMethod() == 2);
        BAPPropertyTelCallListUpdater.access$500(this.this$0).log(1078071040, "[TelEPMHandler.ITelEMPTerminalModeUpdateListener#updateActiveDeviceState] pActiveDeviceAndroidAuto=%1", BAPPropertyTelCallListUpdater.access$400(this.this$0));
    }

    @Override
    public void updateTMVideoFocus(boolean bl) {
        BAPPropertyTelCallListUpdater.access$600(this.this$0).log(1078071040, "[TelEPMHandler.ITelEMPTerminalModeUpdateListener#updateTMVideoFocus] pVideoFocus=%1", bl);
        BAPPropertyTelCallListUpdater.access$702(this.this$0, bl);
        if (BAPPropertyTelCallListUpdater.access$800(this.this$0) && BAPPropertyTelCallListUpdater.access$400(this.this$0) && !BAPPropertyTelCallListUpdater.access$700(this.this$0)) {
            BAPPropertyTelCallListUpdater.access$900(this.this$0);
        }
    }

    /* synthetic */ BAPPropertyTelCallListUpdater$ITelEMPTerminalModeUpdateListener(BAPPropertyTelCallListUpdater bAPPropertyTelCallListUpdater, BAPPropertyTelCallListUpdater$1 bAPPropertyTelCallListUpdater$1) {
        this(bAPPropertyTelCallListUpdater);
    }
}

