/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.terminalmode.interapp;

import de.audi.app.terminalmode.interapp.HighPriorityResourceTracker;
import de.audi.atip.utils.reactive.observables.Observables$Combinator3;
import de.esolutions.fw.util.commons.Buffer;

class HighPriorityResourceTracker$4
implements Observables$Combinator3 {
    private final /* synthetic */ HighPriorityResourceTracker this$0;

    HighPriorityResourceTracker$4(HighPriorityResourceTracker highPriorityResourceTracker) {
        this.this$0 = highPriorityResourceTracker;
    }

    public Boolean combine(Boolean bl, Boolean bl2, Boolean bl3) {
        boolean bl4;
        boolean bl5 = bl4 = bl != false || bl2 != false || bl3 != false;
        String string = !bl4 ? "not blocked" : new Buffer().append(bl != false ? "eCallActive" : "").append(bl2 != false ? "clampSOff" : "").append(bl3 != false ? "rvcActive" : "").toString();
        HighPriorityResourceTracker.access$100(this.this$0).log(1078071040, "[HighPriorityResourceTracker.combine] %1 ", (Object)string);
        return new Boolean(bl4);
    }

    @Override
    public /* synthetic */ Object combine(Object object, Object object2, Object object3) {
        return this.combine((Boolean)object, (Boolean)object2, (Boolean)object3);
    }
}

