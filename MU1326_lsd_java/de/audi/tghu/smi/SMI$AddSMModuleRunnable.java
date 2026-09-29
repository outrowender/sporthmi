/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.smi;

import de.audi.atip.statemachine.SMModule;
import de.audi.tghu.smi.SMI;

public class SMI$AddSMModuleRunnable
implements Runnable {
    final SMModule stateMachineModule;
    private final /* synthetic */ SMI this$0;

    public SMI$AddSMModuleRunnable(SMI sMI, SMModule sMModule) {
        this.this$0 = sMI;
        this.stateMachineModule = sMModule;
    }

    @Override
    public final void run() {
        if (!this.this$0.addSMM(this.stateMachineModule)) {
            SMI.access$000((SMI)this.this$0).smi.log(10000, "[AddSMModuleRunnable#run] Failed to add state machine module! (moduleID=%1)", (long)this.stateMachineModule.getModuleID());
        }
    }

    public final String toString() {
        return new StringBuffer().append("AddSMModuleRunnable( ").append(this.stateMachineModule.getModuleID()).append(" )").toString();
    }
}

