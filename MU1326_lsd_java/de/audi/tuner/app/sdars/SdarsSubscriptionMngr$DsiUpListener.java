/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app.sdars;

import de.audi.tuner.app.sdars.SdarsSubscriptionMngr;
import de.audi.tuner.app.sdars.SdarsSubscriptionMngr$1;
import de.audi.tuner.app.sdars.dsi.SDARSDsiUpInfo;
import de.esolutions.fw.util.commons.Buffer;
import org.dsi.ifc.sdars.ServiceStatus3;
import org.dsi.ifc.sdars.SubscriptionStatus;

class SdarsSubscriptionMngr$DsiUpListener
extends SDARSDsiUpInfo {
    private final /* synthetic */ SdarsSubscriptionMngr this$0;

    private SdarsSubscriptionMngr$DsiUpListener(SdarsSubscriptionMngr sdarsSubscriptionMngr) {
        this.this$0 = sdarsSubscriptionMngr;
    }

    @Override
    public void updateSubscriptionStatus(SubscriptionStatus subscriptionStatus) {
        SdarsSubscriptionMngr.access$100(this.this$0).getChoiceModel(1065943296).setValue(subscriptionStatus.subscription);
        if (subscriptionStatus.subscription == 2 || subscriptionStatus.subscription == 1 || subscriptionStatus.subscription == 0 || subscriptionStatus.suspendYear <= 1970) {
            SdarsSubscriptionMngr.access$100(this.this$0).getChoiceModel(562626816).setValue(0);
        } else {
            SdarsSubscriptionMngr.access$100(this.this$0).getChoiceModel(562626816).setValue(1);
            int n = SdarsSubscriptionMngr.access$100(this.this$0).getChoiceModel(-1278668800).getValue();
            Buffer buffer = new Buffer(20);
            if (n == 0) {
                buffer.append(subscriptionStatus.suspendDay).append('.');
                buffer.append(subscriptionStatus.suspendMonth).append('.');
                buffer.append(subscriptionStatus.suspendYear);
            } else if (n == 1) {
                buffer.append(subscriptionStatus.suspendMonth).append('/');
                buffer.append(subscriptionStatus.suspendDay).append('/');
                buffer.append(subscriptionStatus.suspendYear);
            } else {
                buffer.append(subscriptionStatus.suspendYear).append('-');
                buffer.append(subscriptionStatus.suspendMonth).append('-');
                buffer.append(subscriptionStatus.suspendDay);
            }
            SdarsSubscriptionMngr.access$100(this.this$0).getLabelModel(579404032).setText(buffer.toString());
            SdarsSubscriptionMngr.access$100(this.this$0).getLabelModel(545849600).setText(String.valueOf(subscriptionStatus.reasonCode));
            SdarsSubscriptionMngr.access$100(this.this$0).getLabelModel(596181248).setText(subscriptionStatus.reasonText);
        }
    }

    @Override
    public void updateServiceStatus3(ServiceStatus3 serviceStatus3) {
        SdarsSubscriptionMngr.access$100(this.this$0).getChoiceModel(311034112).setValue(serviceStatus3.dataSubscription);
    }

    /* synthetic */ SdarsSubscriptionMngr$DsiUpListener(SdarsSubscriptionMngr sdarsSubscriptionMngr, SdarsSubscriptionMngr$1 sdarsSubscriptionMngr$1) {
        this(sdarsSubscriptionMngr);
    }
}

