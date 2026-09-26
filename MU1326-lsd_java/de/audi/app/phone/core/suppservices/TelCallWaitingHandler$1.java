/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.phone.core.suppservices;

import de.audi.app.phone.core.dsi.TelDefaultDSIResponseListener;
import de.audi.app.phone.core.suppservices.TelCallWaitingHandler;

class TelCallWaitingHandler$1
extends TelDefaultDSIResponseListener {
    private final /* synthetic */ TelCallWaitingHandler this$0;

    TelCallWaitingHandler$1(TelCallWaitingHandler telCallWaitingHandler) {
        this.this$0 = telCallWaitingHandler;
    }

    @Override
    public void responseCallWaiting(int n, int n2, int n3, int n4) {
        TelCallWaitingHandler.access$002(this.this$0, n2);
        TelCallWaitingHandler.access$100(this.this$0).log(-2137614336, "[TelTelCallWaitingHandler#responseCallWaiting] telCWMode=%1, telCWStatus=%2, result=%3", (long)n, (long)n2, (long)n3);
        TelCallWaitingHandler.access$300(this.this$0).log(-2137614336, "[TelTelCallWaitingHandler#responseCallWaiting] most recent request type=%1", (long)TelCallWaitingHandler.access$200(this.this$0));
        if (n3 != 0) {
            TelCallWaitingHandler.access$400(this.this$0);
        } else {
            switch (TelCallWaitingHandler.access$200(this.this$0)) {
                case 1: {
                    TelCallWaitingHandler.access$500(this.this$0);
                    break;
                }
                case 0: {
                    TelCallWaitingHandler.access$600(this.this$0);
                    break;
                }
                case 2: {
                    TelCallWaitingHandler.access$700(this.this$0);
                    break;
                }
                default: {
                    TelCallWaitingHandler.access$800(this.this$0).log(10000, "TelCallWaitingHandler#setCallWaitingModels: Unhandled mode %1! ", (long)n);
                }
            }
        }
    }
}

