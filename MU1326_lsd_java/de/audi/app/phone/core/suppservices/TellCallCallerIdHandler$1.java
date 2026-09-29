/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.phone.core.suppservices;

import de.audi.app.phone.core.dsi.TelDefaultDSIResponseListener;
import de.audi.app.phone.core.suppservices.TellCallCallerIdHandler;

class TellCallCallerIdHandler$1
extends TelDefaultDSIResponseListener {
    private final /* synthetic */ TellCallCallerIdHandler this$0;

    TellCallCallerIdHandler$1(TellCallCallerIdHandler tellCallCallerIdHandler) {
        this.this$0 = tellCallCallerIdHandler;
    }

    @Override
    public void responseCLIR(int n, int n2, int n3, int n4) {
        TellCallCallerIdHandler.access$100(this.this$0).log(-2137614336, "[TellCallCallerIdHandler#responseCLIR] requested CLIR access mode=%1 ", (long)TellCallCallerIdHandler.access$000(this.this$0));
        if (n3 != 0 || n != TellCallCallerIdHandler.access$000(this.this$0) && TellCallCallerIdHandler.access$000(this.this$0) != 3) {
            TellCallCallerIdHandler.access$200(this.this$0).log(-2137614336, "[TellCallCallerIdHandler#responseCLIR] Unhandled telCLIRState %1 ", (long)n);
            TellCallCallerIdHandler.access$300(this.this$0);
            return;
        }
        TellCallCallerIdHandler.access$400(this.this$0, n, n2);
    }
}

