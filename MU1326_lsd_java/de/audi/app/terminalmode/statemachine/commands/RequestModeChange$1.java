/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.terminalmode.statemachine.commands;

import de.audi.app.terminalmode.smartphone.IDSISmartphoneManager$RequestModeChangeCallback;
import de.audi.app.terminalmode.statemachine.commands.RequestModeChange;

class RequestModeChange$1
implements IDSISmartphoneManager$RequestModeChangeCallback {
    private final /* synthetic */ RequestModeChange this$0;

    RequestModeChange$1(RequestModeChange requestModeChange) {
        this.this$0 = requestModeChange;
    }

    @Override
    public void modeChanged() {
        RequestModeChange.access$100(this.this$0).updateState(RequestModeChange.access$000(this.this$0));
        this.this$0.getCommandList().commandFinished();
    }
}

