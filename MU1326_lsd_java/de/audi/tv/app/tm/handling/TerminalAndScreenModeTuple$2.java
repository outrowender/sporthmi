/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tv.app.tm.handling;

import de.audi.atip.utils.generics.Function;
import de.audi.tv.app.tm.handling.TerminalAndScreenModeTuple;

final class TerminalAndScreenModeTuple$2
implements Function {
    TerminalAndScreenModeTuple$2() {
    }

    public Integer apply(TerminalAndScreenModeTuple terminalAndScreenModeTuple) {
        return new Integer(terminalAndScreenModeTuple.terminalMode);
    }

    @Override
    public /* synthetic */ Object apply(Object object) {
        return this.apply((TerminalAndScreenModeTuple)object);
    }
}

