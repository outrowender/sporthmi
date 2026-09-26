/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.phone.core.bap.telephone;

import de.audi.app.phone.core.bap.telephone.BAPPropertyTelFSGSetup;
import de.audi.app.phone.core.bap.telephone.BAPPropertyTelFSGSetup$1;
import de.audi.atip.interapp.terminalmode.DefaultTerminalModeUpdateListener;
import de.audi.atip.interapp.terminalmode.TerminalModeDevice;

class BAPPropertyTelFSGSetup$BAPTerminalModeUpdateListener
extends DefaultTerminalModeUpdateListener {
    private final /* synthetic */ BAPPropertyTelFSGSetup this$0;

    private BAPPropertyTelFSGSetup$BAPTerminalModeUpdateListener(BAPPropertyTelFSGSetup bAPPropertyTelFSGSetup) {
        this.this$0 = bAPPropertyTelFSGSetup;
    }

    @Override
    public void updateActiveDeviceState(TerminalModeDevice terminalModeDevice) {
        if (terminalModeDevice == null) {
            BAPPropertyTelFSGSetup.access$100(this.this$0).log(10000, "BAPTerminalModeUpdateListener#updateActiveDeviceState pActiveDevice is null");
            return;
        }
        boolean bl = BAPPropertyTelFSGSetup.access$200(this.this$0);
        boolean bl2 = BAPPropertyTelFSGSetup.access$300(this.this$0);
        BAPPropertyTelFSGSetup.access$202(this.this$0, terminalModeDevice.isActive() && terminalModeDevice.getConnectionMethod() == 1);
        BAPPropertyTelFSGSetup.access$302(this.this$0, terminalModeDevice.isActive() && terminalModeDevice.getConnectionMethod() == 2);
        if (bl != BAPPropertyTelFSGSetup.access$200(this.this$0)) {
            BAPPropertyTelFSGSetup.access$400(this.this$0).log(-2137614336, "[BAPTerminalModeUpdateListener#updateActiveDeviceState] changed. sending update to combi. isCarplayActive=%1", BAPPropertyTelFSGSetup.access$200(this.this$0));
            BAPPropertyTelFSGSetup.access$500(this.this$0);
        }
        if (bl2 != BAPPropertyTelFSGSetup.access$300(this.this$0)) {
            BAPPropertyTelFSGSetup.access$600(this.this$0).log(-2137614336, "[BAPTerminalModeUpdateListener#updateActiveDeviceState] changed. sending update to combi. isAndroidAutoActive=%1", BAPPropertyTelFSGSetup.access$300(this.this$0));
            BAPPropertyTelFSGSetup.access$700(this.this$0);
        }
    }

    /* synthetic */ BAPPropertyTelFSGSetup$BAPTerminalModeUpdateListener(BAPPropertyTelFSGSetup bAPPropertyTelFSGSetup, BAPPropertyTelFSGSetup$1 bAPPropertyTelFSGSetup$1) {
        this(bAPPropertyTelFSGSetup);
    }
}

