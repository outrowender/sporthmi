/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tv.app.tm.handling;

import de.audi.atip.utils.reactive.observables.Observables$Combinator;
import de.audi.tv.app.tm.handling.DisplayManagerHandler;
import de.audi.tv.app.tm.handling.TerminalAndScreenModeTuple;

class DisplayManagerHandler$1
implements Observables$Combinator {
    private final /* synthetic */ DisplayManagerHandler this$0;

    DisplayManagerHandler$1(DisplayManagerHandler displayManagerHandler) {
        this.this$0 = displayManagerHandler;
    }

    public Integer combine(Boolean bl, TerminalAndScreenModeTuple terminalAndScreenModeTuple) {
        return new Integer(terminalAndScreenModeTuple.terminalMode == 0 ? 26 : 31);
    }

    @Override
    public /* synthetic */ Object combine(Object object, Object object2) {
        return this.combine((Boolean)object, (TerminalAndScreenModeTuple)object2);
    }
}

