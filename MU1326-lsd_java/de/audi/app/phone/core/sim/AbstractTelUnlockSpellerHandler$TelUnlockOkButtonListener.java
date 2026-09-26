/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.phone.core.sim;

import de.audi.app.phone.core.ITelApplication;
import de.audi.app.phone.core.model.TelDefaultButtonListener;
import de.audi.app.phone.core.sim.AbstractTelUnlockSpellerHandler;

class AbstractTelUnlockSpellerHandler$TelUnlockOkButtonListener
extends TelDefaultButtonListener {
    private final /* synthetic */ AbstractTelUnlockSpellerHandler this$0;

    public AbstractTelUnlockSpellerHandler$TelUnlockOkButtonListener(AbstractTelUnlockSpellerHandler abstractTelUnlockSpellerHandler, ITelApplication iTelApplication, String string, int n) {
        this.this$0 = abstractTelUnlockSpellerHandler;
        super(iTelApplication, string, n);
    }

    @Override
    public void init() {
        super.init();
        this.getButtonModel().setStatus(0);
    }

    @Override
    public void keyTyped(int n, int n2, int n3) {
        this.this$0.codeEntered(AbstractTelUnlockSpellerHandler.access$200(this.this$0).getText(), n3);
    }
}

