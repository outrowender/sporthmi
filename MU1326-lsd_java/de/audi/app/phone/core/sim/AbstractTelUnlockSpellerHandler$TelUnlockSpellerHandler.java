/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.phone.core.sim;

import de.audi.app.phone.core.ITelApplication;
import de.audi.app.phone.core.model.TelDefaultSpellerListener;
import de.audi.app.phone.core.sim.AbstractTelUnlockSpellerHandler;

class AbstractTelUnlockSpellerHandler$TelUnlockSpellerHandler
extends TelDefaultSpellerListener {
    private final int minSpellerLength;
    private final int maxSpellerLength;
    private final /* synthetic */ AbstractTelUnlockSpellerHandler this$0;

    public AbstractTelUnlockSpellerHandler$TelUnlockSpellerHandler(AbstractTelUnlockSpellerHandler abstractTelUnlockSpellerHandler, ITelApplication iTelApplication, String string, int n, int n2, int n3) {
        this.this$0 = abstractTelUnlockSpellerHandler;
        super(iTelApplication, string, n);
        this.minSpellerLength = n2;
        this.maxSpellerLength = n3;
    }

    @Override
    public void init() {
        super.init();
        this.setMinMaxLength(this.minSpellerLength, this.maxSpellerLength);
    }

    @Override
    public void textChanged(int n, String string, char c2, int n2) {
        this.log.log(1078071040, "[%1.UnlockSpellerHandler#textChanged] text=%1, latestChar=%2", (Object)AbstractTelUnlockSpellerHandler.access$000(this.this$0), (Object)string, (long)c2);
        this.setOKButtonEnabled(string);
    }

    private void setOKButtonEnabled(String string) {
        int n = this.getSpellerModel().getMinLength();
        int n2 = this.getSpellerModel().getMaxLength();
        if (string != null) {
            if (string.length() >= n && string.length() <= n2) {
                AbstractTelUnlockSpellerHandler.access$100(this.this$0).setStatus(1);
            } else {
                AbstractTelUnlockSpellerHandler.access$100(this.this$0).setStatus(0);
            }
        } else {
            AbstractTelUnlockSpellerHandler.access$100(this.this$0).setStatus(0);
        }
    }

    @Override
    public void keyTyped(int n, int n2, int n3) {
        this.this$0.codeEntered(AbstractTelUnlockSpellerHandler.access$200(this.this$0).getText(), n3);
    }
}

