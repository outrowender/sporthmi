/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.phone.core.sim;

import de.audi.app.phone.core.ITelApplication;
import de.audi.app.phone.core.sim.AbstractTelUnlockPresentationHandler;
import de.audi.app.phone.core.sim.AbstractTelUnlockSpellerHandler;

class AbstractTelUnlockPresentationHandler$PinEntryHandler
extends AbstractTelUnlockSpellerHandler {
    private final /* synthetic */ AbstractTelUnlockPresentationHandler this$0;

    AbstractTelUnlockPresentationHandler$PinEntryHandler(AbstractTelUnlockPresentationHandler abstractTelUnlockPresentationHandler, ITelApplication iTelApplication, int n, int n2) {
        this.this$0 = abstractTelUnlockPresentationHandler;
        super(iTelApplication, "PinEntryHandler", n, n2, 4, 8);
    }

    @Override
    protected void codeEntered(String string, int n) {
        this.log.log(1078071040, "[%1.PinEntryHandler#codeEntered] code=%2", (Object)AbstractTelUnlockPresentationHandler.access$000(this.this$0), (Object)string);
        this.fireEvent(n);
        this.this$0.unlockSIMwithPIN(string, n);
    }
}

