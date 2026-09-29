/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.smi;

import de.audi.atip.statemachine.SMModule;
import de.audi.tghu.smi.SMI;

public class SMI$RemoveSMModuleRunnable
implements Runnable {
    final SMModule stateMachineModule;
    boolean done = false;
    private final /* synthetic */ SMI this$0;

    public SMI$RemoveSMModuleRunnable(SMI sMI, SMModule sMModule) {
        this.this$0 = sMI;
        this.stateMachineModule = sMModule;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public final void run() {
        this.this$0.removeSMM(this.stateMachineModule);
        SMI$RemoveSMModuleRunnable sMI$RemoveSMModuleRunnable = this;
        synchronized (sMI$RemoveSMModuleRunnable) {
            this.done = true;
            super.notifyAll();
        }
    }

    public final String toString() {
        return new StringBuffer().append("RemoveSMModuleRunnable( ").append(this.stateMachineModule.getModuleID()).append(" )").toString();
    }
}

