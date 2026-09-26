/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.phone.core.suppservices;

import de.audi.app.phone.core.dsi.TelDefaultDSIResponseListener;
import de.audi.app.phone.core.suppservices.AbstractTelCallForwardingHandler;
import de.esolutions.fw.util.commons.Converter;
import org.dsi.ifc.telephoneng.CFResponseData;

class AbstractTelCallForwardingHandler$1
extends TelDefaultDSIResponseListener {
    private final /* synthetic */ AbstractTelCallForwardingHandler this$0;

    AbstractTelCallForwardingHandler$1(AbstractTelCallForwardingHandler abstractTelCallForwardingHandler) {
        this.this$0 = abstractTelCallForwardingHandler;
    }

    @Override
    public void responseCallForward(CFResponseData[] cFResponseDataArray, int n, int n2) {
        AbstractTelCallForwardingHandler.access$000(this.this$0).log(1078071040, "TelCallForwardingHandler#responseCallForward, telCFData=%1, result=%2", (Object)Converter.array2String(cFResponseDataArray), (long)n);
        if (n != 0) {
            AbstractTelCallForwardingHandler.access$100(this.this$0).log(10000, "TelCallForwardingHandler#responseCallForward handling error");
            AbstractTelCallForwardingHandler.access$200(this.this$0);
            return;
        }
        if (cFResponseDataArray == null || cFResponseDataArray.length == 0 || cFResponseDataArray[0] == null) {
            AbstractTelCallForwardingHandler.access$300(this.this$0).log(-1601830656, "TelCallForwardingHandler#responseCallForward: Missing or invalid CF response data given! ");
            return;
        }
        AbstractTelCallForwardingHandler.access$500(this.this$0).log(-2137614336, "TelCallForwardingHandler#responseCallForward:  requested type =%1!", (long)AbstractTelCallForwardingHandler.access$400(this.this$0));
        CFResponseData cFResponseData = cFResponseDataArray[0];
        int n3 = cFResponseData.getTelCFStatus();
        String string = cFResponseData.getTelCFNumber();
        AbstractTelCallForwardingHandler.access$602(this.this$0, n3);
        AbstractTelCallForwardingHandler.access$702(this.this$0, string);
        AbstractTelCallForwardingHandler.access$800(this.this$0);
        AbstractTelCallForwardingHandler.access$900(this.this$0, cFResponseDataArray);
    }
}

