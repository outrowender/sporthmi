/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.messaging.core.readout;

import de.audi.app.messaging.core.readout.MultipleMessageReadoutService;
import de.audi.app.messaging.core.swdiagnosis.IDiagPlugIn;

final class MultipleMessageReadoutService$DiagPlugIn
implements IDiagPlugIn {
    private final /* synthetic */ MultipleMessageReadoutService this$0;

    MultipleMessageReadoutService$DiagPlugIn(MultipleMessageReadoutService multipleMessageReadoutService) {
        this.this$0 = multipleMessageReadoutService;
    }

    public void cmdMultipleMessageBeginDialog(boolean bl, int n) {
        this.this$0.requestBeginDialog(bl, n);
    }

    public void cmdMultipleMessageRequestNextMessage() {
        this.this$0.requestNextMessage();
    }

    public void cmdMultipleMessageEndDialog() {
        this.this$0.requestNextMessage();
    }
}

