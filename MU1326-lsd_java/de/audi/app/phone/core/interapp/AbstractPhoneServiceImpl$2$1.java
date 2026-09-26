/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.phone.core.interapp;

import de.audi.app.phone.core.dsi.ITelDSIResponseListener;
import de.audi.app.phone.core.dsi.TelDefaultDSIResponseListener;
import de.audi.app.phone.core.interapp.AbstractPhoneServiceImpl;
import de.audi.app.phone.core.interapp.AbstractPhoneServiceImpl$2;
import de.audi.app.phone.core.interapp.TelServiceListenerWrapper;
import org.dsi.ifc.telephoneng.SuppServiceResponseStruct;

class AbstractPhoneServiceImpl$2$1
extends TelDefaultDSIResponseListener {
    private final /* synthetic */ AbstractPhoneServiceImpl$2 this$1;

    AbstractPhoneServiceImpl$2$1(AbstractPhoneServiceImpl$2 abstractPhoneServiceImpl$2) {
        this.this$1 = abstractPhoneServiceImpl$2;
    }

    @Override
    public void responseDialNumber(int n, int n2, SuppServiceResponseStruct suppServiceResponseStruct, int n3) {
        ITelDSIResponseListener iTelDSIResponseListener;
        ITelDSIResponseListener iTelDSIResponseListener2 = iTelDSIResponseListener = AbstractPhoneServiceImpl$2.access$1300(this.this$1) != null ? new TelServiceListenerWrapper(AbstractPhoneServiceImpl$2.access$1300(this.this$1)) : AbstractPhoneServiceImpl.access$1500(AbstractPhoneServiceImpl$2.access$1400(this.this$1)).getDefaultListener();
        if (iTelDSIResponseListener != null) {
            iTelDSIResponseListener.responseDialNumber(n, n2, suppServiceResponseStruct, n3);
        }
        if (n == 0) {
            if (AbstractPhoneServiceImpl$2.access$1600(this.this$1)) {
                AbstractPhoneServiceImpl.access$1700(AbstractPhoneServiceImpl$2.access$1400(this.this$1)).log(1078071040, "[AbstractPhoneServiceImpl.dialNumberFromADBEntry] RESULT_OK - switching to phone!");
                AbstractPhoneServiceImpl.access$700(AbstractPhoneServiceImpl$2.access$1400(this.this$1));
            } else {
                AbstractPhoneServiceImpl.access$1800(AbstractPhoneServiceImpl$2.access$1400(this.this$1)).log(1078071040, "[AbstractPhoneServiceImpl#dialNumberFromADBEntry] RESULT_OK - jumpToPhone false.");
            }
        } else {
            AbstractPhoneServiceImpl.access$1900(AbstractPhoneServiceImpl$2.access$1400(this.this$1)).log(1078071040, "[AbstractPhoneServiceImpl#dialNumberFromADBEntry] result=%1", (long)n);
        }
    }
}

