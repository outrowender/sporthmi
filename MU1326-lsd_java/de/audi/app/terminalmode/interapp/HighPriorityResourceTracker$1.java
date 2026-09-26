/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.terminalmode.interapp;

import de.audi.app.terminalmode.diagnosis.IDiagnosisCommandProvider;
import de.audi.app.terminalmode.interapp.HighPriorityResourceTracker;
import de.audi.app.terminalmode.interapp.HighPriorityResourceTracker$DiagECallState;

class HighPriorityResourceTracker$1
implements IDiagnosisCommandProvider {
    private final /* synthetic */ HighPriorityResourceTracker this$0;

    HighPriorityResourceTracker$1(HighPriorityResourceTracker highPriorityResourceTracker) {
        this.this$0 = highPriorityResourceTracker;
    }

    @Override
    public String[] getDiagKeys() {
        return new String[]{"HighPriorityResourceTracker enable RVC", "HighPriorityResourceTracker disable RVC", "HighPriorityResourceTracker enable eCall", "HighPriorityResourceTracker disable eCall"};
    }

    @Override
    public void executeDiagCommand(String string, String[] stringArray) {
        if ("HighPriorityResourceTracker enable RVC".equals(string)) {
            this.this$0.processMsg(108);
        } else if ("HighPriorityResourceTracker disable RVC".equals(string)) {
            this.this$0.processMsg(107);
        } else if ("HighPriorityResourceTracker enable eCall".equals(string)) {
            this.this$0.updateEcallState(0, new HighPriorityResourceTracker$DiagECallState(this.this$0, true));
        } else if ("HighPriorityResourceTracker disable eCall".equals(string)) {
            this.this$0.updateEcallState(0, new HighPriorityResourceTracker$DiagECallState(this.this$0, false));
        }
    }
}

