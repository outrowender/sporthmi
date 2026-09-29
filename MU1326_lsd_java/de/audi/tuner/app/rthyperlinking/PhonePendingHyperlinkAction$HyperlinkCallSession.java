/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app.rthyperlinking;

import de.audi.atip.interapp.phone.ITelCallControl;
import de.audi.atip.interapp.phone.ITelCallInformation;
import de.audi.atip.interapp.phone.ITelCallSession;
import de.audi.tuner.app.rthyperlinking.PhonePendingHyperlinkAction;
import de.audi.tuner.app.rthyperlinking.PhonePendingHyperlinkAction$1;

class PhonePendingHyperlinkAction$HyperlinkCallSession
implements ITelCallSession {
    private final /* synthetic */ PhonePendingHyperlinkAction this$0;

    private PhonePendingHyperlinkAction$HyperlinkCallSession(PhonePendingHyperlinkAction phonePendingHyperlinkAction) {
        this.this$0 = phonePendingHyperlinkAction;
    }

    @Override
    public int getCallType() {
        return 0;
    }

    @Override
    public String getTelephoneNumber() {
        return this.this$0.getTrimedPhoneNumber();
    }

    @Override
    public void onActive(ITelCallControl iTelCallControl) {
    }

    @Override
    public void onClose() {
    }

    @Override
    public void updateCallInformation(ITelCallInformation iTelCallInformation, int n) {
    }

    /* synthetic */ PhonePendingHyperlinkAction$HyperlinkCallSession(PhonePendingHyperlinkAction phonePendingHyperlinkAction, PhonePendingHyperlinkAction$1 phonePendingHyperlinkAction$1) {
        this(phonePendingHyperlinkAction);
    }
}

