/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.addressinput.poi.sequences;

import de.audi.atip.phone.ITelServiceListener;
import de.audi.tghu.navi.app.addressinput.poi.sequences.CallPhoneNumberSequence$1;

class CallPhoneNumberSequence$1$1
implements ITelServiceListener {
    private final /* synthetic */ CallPhoneNumberSequence$1 this$1;

    CallPhoneNumberSequence$1$1(CallPhoneNumberSequence$1 callPhoneNumberSequence$1) {
        this.this$1 = callPhoneNumberSequence$1;
    }

    @Override
    public void dialNumberResponse(int n) {
        CallPhoneNumberSequence$1.access$000(this.this$1).log(-2137614336, "CallPhoneNumberSequence#start with liValueListElement - result=%1", (long)n);
        if (n != 0) {
            CallPhoneNumberSequence$1.access$000(this.this$1).log(10000, "CallPhoneNumberSequence#start with liValueListElement - dial was not successful, result=%1", (long)n);
        }
    }
}

