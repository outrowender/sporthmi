/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tv.app.tm.handling;

import de.audi.atip.utils.reactive.observables.Observables$Combinator;

final class DisplayContextHandler$2
implements Observables$Combinator {
    DisplayContextHandler$2() {
    }

    public Integer combine(Boolean bl, Integer n) {
        int n2 = 0;
        if (bl.booleanValue()) {
            n2 = n == 26 ? 1 : 23;
        }
        return new Integer(n2);
    }

    @Override
    public /* synthetic */ Object combine(Object object, Object object2) {
        return this.combine((Boolean)object, (Integer)object2);
    }
}

