/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.phone.core.interapp;

import de.audi.app.phone.core.dsi.ITelDSIResponseListener;
import de.audi.app.phone.core.dsi.TelDefaultDSIResponseListener;
import de.audi.app.phone.core.interapp.AbstractPhoneServiceImpl;
import de.audi.app.phone.core.interapp.AbstractPhoneServiceImpl$1;
import de.audi.app.phone.core.interapp.TelServiceListenerWrapper;
import org.dsi.ifc.telephoneng.SuppServiceResponseStruct;

class AbstractPhoneServiceImpl$1$1
extends TelDefaultDSIResponseListener {
    private final /* synthetic */ AbstractPhoneServiceImpl$1 this$1;

    AbstractPhoneServiceImpl$1$1(AbstractPhoneServiceImpl$1 abstractPhoneServiceImpl$1) {
        this.this$1 = abstractPhoneServiceImpl$1;
    }

    @Override
    public void responseDialNumber(int n, int n2, SuppServiceResponseStruct suppServiceResponseStruct, int n3) {
        ITelDSIResponseListener iTelDSIResponseListener;
        ITelDSIResponseListener iTelDSIResponseListener2 = iTelDSIResponseListener = AbstractPhoneServiceImpl$1.access$200(this.this$1) != null ? new TelServiceListenerWrapper(AbstractPhoneServiceImpl$1.access$200(this.this$1)) : AbstractPhoneServiceImpl.access$400(AbstractPhoneServiceImpl$1.access$300(this.this$1)).getDefaultListener();
        if (iTelDSIResponseListener != null) {
            iTelDSIResponseListener.responseDialNumber(n, n2, suppServiceResponseStruct, n3);
        }
        if (n == 0) {
            if (AbstractPhoneServiceImpl$1.access$500(this.this$1)) {
                AbstractPhoneServiceImpl.access$600(AbstractPhoneServiceImpl$1.access$300(this.this$1)).log(1078071040, "[AbstractPhoneServiceImpl.dialNumber] RESULT_OK - switching to phone!");
                AbstractPhoneServiceImpl.access$700(AbstractPhoneServiceImpl$1.access$300(this.this$1));
            } else {
                AbstractPhoneServiceImpl.access$800(AbstractPhoneServiceImpl$1.access$300(this.this$1)).log(1078071040, "[AbstractPhoneServiceImpl#dialNumber] RESULT_OK - jumpToPhone false.");
            }
        } else {
            AbstractPhoneServiceImpl.access$900(AbstractPhoneServiceImpl$1.access$300(this.this$1)).log(1078071040, "[AbstractPhoneServiceImpl#dialNumber] result=%1", (long)n);
        }
    }
}

