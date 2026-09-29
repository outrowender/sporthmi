/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.addressinput.poi.sequences;

import de.audi.atip.phone.ITelServiceListener;
import de.audi.tghu.navi.app.addressinput.poi.sequences.CallPhoneNumberSequence$2;

class CallPhoneNumberSequence$2$1
implements ITelServiceListener {
    private final /* synthetic */ CallPhoneNumberSequence$2 this$1;

    CallPhoneNumberSequence$2$1(CallPhoneNumberSequence$2 callPhoneNumberSequence$2) {
        this.this$1 = callPhoneNumberSequence$2;
    }

    @Override
    public void dialNumberResponse(int n) {
        CallPhoneNumberSequence$2.access$100(this.this$1).log(-2137614336, "CallPhoneNumberSequence#start with navLocation - result=%1", (long)n);
        if (n != 0) {
            CallPhoneNumberSequence$2.access$100(this.this$1).log(10000, "CallPhoneNumberSequence#start with navLocation - dial was not successful, result=%1", (long)n);
        }
    }
}

