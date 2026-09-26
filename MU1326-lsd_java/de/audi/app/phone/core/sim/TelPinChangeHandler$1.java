/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.phone.core.sim;

import de.audi.app.phone.core.dsi.TelDefaultDSIResponseListener;
import de.audi.app.phone.core.sim.TelPinChangeHandler;

class TelPinChangeHandler$1
extends TelDefaultDSIResponseListener {
    private final /* synthetic */ TelPinChangeHandler this$0;

    TelPinChangeHandler$1(TelPinChangeHandler telPinChangeHandler) {
        this.this$0 = telPinChangeHandler;
    }

    @Override
    public void responseChangeSIMCode(int n, int n2, int n3) {
        TelPinChangeHandler.access$000(this.this$0).log(-2137614336, "TelPinChangeHandler#responseChangeSIMCode result = %1", (long)n2);
        if (n2 == 0) {
            TelPinChangeHandler.access$100(this.this$0).log(-2137614336, "TelPinChangeHandler#responseChangeSIMCode: PIN was changed, swhowing confirmation to confirmation ");
            this.this$0.setChangePINStateModel(1, 1);
            TelPinChangeHandler.access$200(this.this$0).log(-2137614336, "TelPinChangeHandler#responseChangeSIMCode: ICorePhoneModelBank.CHANGE_PIN_STATE_CHOICE(t,v) <-- (STATUS_VALID, VALUE_AVAILABLE");
            return;
        }
        TelPinChangeHandler.access$300(this.this$0).log(-1601830656, "TelPinChangeHandler#responseChangeSIMCode: Error  occurred, PIN NOT changed, showing Error Indication", (long)n2);
        this.this$0.setChangePINStateModel(2, -1);
        TelPinChangeHandler.access$400(this.this$0).log(-2137614336, "TelPinChangeHandler#responseChangeSIMCode: ICorePhoneModelBank.CHANGE_PIN_STATE_CHOICE(t,v) <-- (STATUS_ERROR, VALUE_UNAVAILABLE");
        TelPinChangeHandler.access$500(this.this$0, 731251712).setStatus(1);
        TelPinChangeHandler.access$600(this.this$0, 731251712).clear();
        TelPinChangeHandler.access$700(this.this$0);
    }
}

