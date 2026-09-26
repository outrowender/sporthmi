/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.phone.core.dsi;

import de.audi.app.phone.core.dsi.TelResultHandlerWrapper;
import de.audi.app.phone.core.event.AbstractTelDSIResponseEvent;
import org.dsi.ifc.telephoneng.CFResponseData;

class TelResultHandlerWrapper$4
extends AbstractTelDSIResponseEvent {
    private final /* synthetic */ int val$result;
    private final /* synthetic */ int val$terminalID;
    private final /* synthetic */ CFResponseData[] val$telCFResponseData;
    private final /* synthetic */ TelResultHandlerWrapper this$0;

    TelResultHandlerWrapper$4(TelResultHandlerWrapper telResultHandlerWrapper, int n, int n2, int n3, CFResponseData[] cFResponseDataArray) {
        this.this$0 = telResultHandlerWrapper;
        this.val$result = n2;
        this.val$terminalID = n3;
        this.val$telCFResponseData = cFResponseDataArray;
        super(n);
    }

    @Override
    public void run() {
        TelResultHandlerWrapper.access$000(this.this$0, this.val$result, this.val$terminalID);
        TelResultHandlerWrapper.access$100(this.this$0).responseCallForward(this.val$telCFResponseData, this.val$result, this.val$terminalID);
        for (int i2 = 0; i2 < TelResultHandlerWrapper.access$200(this.this$0).length; ++i2) {
            TelResultHandlerWrapper.access$200(this.this$0)[i2].responseCallForward(this.val$telCFResponseData, this.val$result, this.val$terminalID);
        }
    }
}

