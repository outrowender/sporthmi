/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tv.app.tm.handling;

import de.audi.atip.utils.reactive.observables.Observables$Combinator3;
import de.audi.tv.app.tm.handling.DisplayManagerHandler;

class DisplayManagerHandler$2
implements Observables$Combinator3 {
    private final /* synthetic */ DisplayManagerHandler this$0;

    DisplayManagerHandler$2(DisplayManagerHandler displayManagerHandler) {
        this.this$0 = displayManagerHandler;
    }

    public Boolean combine(Boolean bl, Boolean bl2, Boolean bl3) {
        return new Boolean(bl == false && bl2 == false && bl3 != false);
    }

    @Override
    public /* synthetic */ Object combine(Object object, Object object2, Object object3) {
        return this.combine((Boolean)object, (Boolean)object2, (Boolean)object3);
    }
}

