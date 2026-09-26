/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.phone.core.sim;

import de.audi.app.phone.core.ITelApplication;
import de.audi.app.phone.core.sim.AbstractTelUnlockPresentationHandler;
import de.audi.app.phone.core.sim.AbstractTelUnlockSpellerHandler;

class AbstractTelUnlockPresentationHandler$PukEntryHandler
extends AbstractTelUnlockSpellerHandler {
    private final /* synthetic */ AbstractTelUnlockPresentationHandler this$0;

    AbstractTelUnlockPresentationHandler$PukEntryHandler(AbstractTelUnlockPresentationHandler abstractTelUnlockPresentationHandler, ITelApplication iTelApplication, int n, int n2) {
        this.this$0 = abstractTelUnlockPresentationHandler;
        super(iTelApplication, "PukEntryHandler", n, n2, 8, 8);
    }

    @Override
    protected void codeEntered(String string, int n) {
        this.log.log(1078071040, "[%1.PukEntryHandler#codeEntered] code=%2", (Object)AbstractTelUnlockPresentationHandler.access$000(this.this$0), (Object)string);
        AbstractTelUnlockPresentationHandler.access$102(this.this$0, string);
        AbstractTelUnlockPresentationHandler.access$200(this.this$0).clearSpeller();
        this.fireEvent(n);
        this.clearSpeller();
    }
}

