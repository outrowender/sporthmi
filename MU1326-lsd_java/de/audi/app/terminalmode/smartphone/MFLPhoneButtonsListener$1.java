/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.terminalmode.smartphone;

import de.audi.app.terminalmode.smartphone.MFLPhoneButtonsListener;
import de.audi.atip.hmi.model.DefaultButtonListener;

class MFLPhoneButtonsListener$1
extends DefaultButtonListener {
    private final /* synthetic */ MFLPhoneButtonsListener this$0;

    MFLPhoneButtonsListener$1(MFLPhoneButtonsListener mFLPhoneButtonsListener) {
        this.this$0 = mFLPhoneButtonsListener;
    }

    @Override
    public void keyPressed(int n, int n2, int n3) {
        MFLPhoneButtonsListener.access$000(this.this$0).log(-2137614336, "<<- [%1.keyPressed] HOOK", (Object)"MFLPhoneButtonsListener");
        if (MFLPhoneButtonsListener.access$100(this.this$0).hasBothPhoneMFLKeys()) {
            MFLPhoneButtonsListener.access$200(this.this$0).hook(false);
        } else {
            MFLPhoneButtonsListener.access$200(this.this$0).flash(false);
        }
    }

    @Override
    public void keyReleased(int n, int n2, int n3) {
        MFLPhoneButtonsListener.access$000(this.this$0).log(-2137614336, "<<- [%1.keyReleased] HOOK", (Object)"MFLPhoneButtonsListener");
        if (MFLPhoneButtonsListener.access$100(this.this$0).hasBothPhoneMFLKeys()) {
            MFLPhoneButtonsListener.access$200(this.this$0).hook(true);
        } else {
            MFLPhoneButtonsListener.access$200(this.this$0).flash(true);
        }
    }
}

