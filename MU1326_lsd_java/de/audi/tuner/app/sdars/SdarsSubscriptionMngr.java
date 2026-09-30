/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app.sdars;

import de.audi.tuner.app.TunerBasics;
import de.audi.tuner.app.TunerModels;
import de.audi.tuner.app.sdars.dsi.SDARSDsiUpInfo;
import de.esolutions.fw.util.commons.Buffer;
import org.dsi.ifc.sdars.ServiceStatus3;
import org.dsi.ifc.sdars.SubscriptionStatus;

public class SdarsSubscriptionMngr {
    final SDARSDsiUpInfo dsiUpListener = new DsiUpListener();
    private final TunerModels models;

    public SdarsSubscriptionMngr(TunerBasics tunerBasics) {
        this.models = tunerBasics.getModels();
    }

    private class DsiUpListener
    extends SDARSDsiUpInfo {
        private DsiUpListener() {
        }

        public void updateSubscriptionStatus(SubscriptionStatus subscriptionStatus) {
            SdarsSubscriptionMngr.this.models.getChoiceModel(100671).setValue(subscriptionStatus.subscription);
            if (subscriptionStatus.subscription == 2 || subscriptionStatus.subscription == 1 || subscriptionStatus.subscription == 0 || subscriptionStatus.suspendYear <= 1970) {
                SdarsSubscriptionMngr.this.models.getChoiceModel(100641).setValue(0);
            } else {
                SdarsSubscriptionMngr.this.models.getChoiceModel(100641).setValue(1);
                int n = SdarsSubscriptionMngr.this.models.getChoiceModel(1100211).getValue();
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
                SdarsSubscriptionMngr.this.models.getLabelModel(100642).setText(buffer.toString());
                SdarsSubscriptionMngr.this.models.getLabelModel(100640).setText(String.valueOf(subscriptionStatus.reasonCode));
                SdarsSubscriptionMngr.this.models.getLabelModel(100643).setText(subscriptionStatus.reasonText);
            }
        }

        public void updateServiceStatus3(ServiceStatus3 serviceStatus3) {
            SdarsSubscriptionMngr.this.models.getChoiceModel(100882).setValue(serviceStatus3.dataSubscription);
        }
    }
}

