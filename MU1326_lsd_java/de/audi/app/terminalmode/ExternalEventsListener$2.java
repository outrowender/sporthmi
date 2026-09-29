/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.terminalmode;

import de.audi.app.terminalmode.ExternalEventsListener;
import de.audi.atip.utils.generics.Consumer;

class ExternalEventsListener$2
implements Consumer {
    private final /* synthetic */ ExternalEventsListener this$0;

    ExternalEventsListener$2(ExternalEventsListener externalEventsListener) {
        this.this$0 = externalEventsListener;
    }

    public void accept(Integer n) {
        switch (n) {
            case 1001: {
                ExternalEventsListener.access$000(this.this$0).log(1078071040, "<<- [%1.actionProxyCallPerformed] AP_METHOD_HMI_ACTIVATED", (Object)"ExternalEventsListener");
                if (ExternalEventsListener.access$400(this.this$0)) {
                    ExternalEventsListener.access$500(this.this$0);
                }
                ExternalEventsListener.access$602(this.this$0, true);
                break;
            }
            case 1002: {
                ExternalEventsListener.access$000(this.this$0).log(1078071040, "<<- [%1.actionProxyCallPerformed] AP_METHOD_HMI_DEACTIVATED", (Object)"ExternalEventsListener");
                ExternalEventsListener.access$700(this.this$0);
                ExternalEventsListener.access$602(this.this$0, false);
                break;
            }
        }
    }

    @Override
    public /* synthetic */ void accept(Object object) {
        this.accept((Integer)object);
    }
}

