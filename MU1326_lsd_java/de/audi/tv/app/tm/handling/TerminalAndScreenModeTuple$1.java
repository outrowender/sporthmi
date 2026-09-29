/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tv.app.tm.handling;

import de.audi.atip.utils.reactive.observables.Observables$Combinator;
import de.audi.tv.app.tm.handling.TerminalAndScreenModeTuple;

final class TerminalAndScreenModeTuple$1
implements Observables$Combinator {
    TerminalAndScreenModeTuple$1() {
    }

    public TerminalAndScreenModeTuple combine(Integer n, Integer n2) {
        return new TerminalAndScreenModeTuple(n, n2);
    }

    @Override
    public /* synthetic */ Object combine(Object object, Object object2) {
        return this.combine((Integer)object, (Integer)object2);
    }
}

