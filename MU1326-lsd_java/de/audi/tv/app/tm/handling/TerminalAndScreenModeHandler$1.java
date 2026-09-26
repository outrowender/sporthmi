/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tv.app.tm.handling;

import de.audi.atip.utils.generics.Consumer;
import de.audi.tv.app.base.TVEnv;
import de.audi.tv.app.tm.handling.TerminalAndScreenModeHandler;
import de.audi.tv.app.tm.handling.TerminalAndScreenModeTuple;

class TerminalAndScreenModeHandler$1
implements Consumer {
    private final /* synthetic */ TVEnv val$env;
    private final /* synthetic */ TerminalAndScreenModeHandler this$0;

    TerminalAndScreenModeHandler$1(TerminalAndScreenModeHandler terminalAndScreenModeHandler, TVEnv tVEnv) {
        this.this$0 = terminalAndScreenModeHandler;
        this.val$env = tVEnv;
    }

    public void accept(TerminalAndScreenModeTuple terminalAndScreenModeTuple) {
        this.val$env.getChoiceModel(-592697600).setValue(terminalAndScreenModeTuple.terminalMode);
        TerminalAndScreenModeHandler.access$100(this.this$0, terminalAndScreenModeTuple);
    }

    @Override
    public /* synthetic */ void accept(Object object) {
        this.accept((TerminalAndScreenModeTuple)object);
    }
}

