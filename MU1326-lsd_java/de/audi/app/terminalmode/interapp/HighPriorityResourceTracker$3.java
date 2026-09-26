/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.terminalmode.interapp;

import de.audi.app.terminalmode.interapp.HighPriorityResourceTracker;
import de.audi.app.terminalmode.statemachine.Resource;
import de.audi.atip.utils.generics.Consumer;

class HighPriorityResourceTracker$3
implements Consumer {
    private final /* synthetic */ HighPriorityResourceTracker this$0;

    HighPriorityResourceTracker$3(HighPriorityResourceTracker highPriorityResourceTracker) {
        this.this$0 = highPriorityResourceTracker;
    }

    public void accept(Boolean bl) {
        if (bl.booleanValue()) {
            HighPriorityResourceTracker.access$400(this.this$0, Resource.SCREEN);
        } else {
            HighPriorityResourceTracker.access$500(this.this$0, Resource.SCREEN);
        }
    }

    @Override
    public /* synthetic */ void accept(Object object) {
        this.accept((Boolean)object);
    }
}

