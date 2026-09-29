/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tv.app.tm.handling;

import de.audi.atip.utils.generics.Consumer;
import de.audi.tv.app.tm.handling.TerminalAndScreenModeHandler;
import de.audi.tv.app.tm.handling.TerminalAndScreenModeTuple;

class TerminalAndScreenModeHandler$2
implements Consumer {
    private final /* synthetic */ TerminalAndScreenModeHandler this$0;

    TerminalAndScreenModeHandler$2(TerminalAndScreenModeHandler terminalAndScreenModeHandler) {
        this.this$0 = terminalAndScreenModeHandler;
    }

    public void accept(TerminalAndScreenModeTuple terminalAndScreenModeTuple) {
        TerminalAndScreenModeHandler.access$200(this.this$0, terminalAndScreenModeTuple);
    }

    @Override
    public /* synthetic */ void accept(Object object) {
        this.accept((TerminalAndScreenModeTuple)object);
    }
}

