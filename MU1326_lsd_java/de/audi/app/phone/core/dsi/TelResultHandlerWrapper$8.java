/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.phone.core.dsi;

import de.audi.app.phone.core.dsi.TelResultHandlerWrapper;
import de.audi.app.phone.core.event.AbstractTelDSIResponseEvent;
import org.dsi.ifc.telephoneng.SuppServiceResponseStruct;

class TelResultHandlerWrapper$8
extends AbstractTelDSIResponseEvent {
    private final /* synthetic */ int val$dialNumberType;
    private final /* synthetic */ int val$result;
    private final /* synthetic */ int val$terminalID;
    private final /* synthetic */ SuppServiceResponseStruct val$telSuppServResult;
    private final /* synthetic */ TelResultHandlerWrapper this$0;

    TelResultHandlerWrapper$8(TelResultHandlerWrapper telResultHandlerWrapper, int n, int n2, int n3, int n4, SuppServiceResponseStruct suppServiceResponseStruct) {
        this.this$0 = telResultHandlerWrapper;
        this.val$dialNumberType = n2;
        this.val$result = n3;
        this.val$terminalID = n4;
        this.val$telSuppServResult = suppServiceResponseStruct;
        super(n);
    }

    @Override
    public void run() {
        if (this.val$dialNumberType == 0) {
            TelResultHandlerWrapper.access$000(this.this$0, this.val$result, this.val$terminalID);
        }
        TelResultHandlerWrapper.access$100(this.this$0).responseDialNumber(this.val$result, this.val$dialNumberType, this.val$telSuppServResult, this.val$terminalID);
        for (int i2 = 0; i2 < TelResultHandlerWrapper.access$200(this.this$0).length; ++i2) {
            TelResultHandlerWrapper.access$200(this.this$0)[i2].responseDialNumber(this.val$result, this.val$dialNumberType, this.val$telSuppServResult, this.val$terminalID);
        }
    }
}

