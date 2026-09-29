/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.messaging.core.swdiagnosis;

import de.audi.app.messaging.core.osgi.AbstractMessagingTrackerCustomizer;
import de.audi.app.messaging.core.swdiagnosis.MessagingSwDiagnosis;
import de.audi.atip.diag.sw.SwDiagnosisManager;
import de.audi.atip.log.LogChannel;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;

class MessagingSwDiagnosis$1
extends AbstractMessagingTrackerCustomizer {
    private final /* synthetic */ MessagingSwDiagnosis this$0;

    MessagingSwDiagnosis$1(MessagingSwDiagnosis messagingSwDiagnosis, LogChannel logChannel, BundleContext bundleContext) {
        this.this$0 = messagingSwDiagnosis;
        super(logChannel, bundleContext);
    }

    @Override
    public void addService(ServiceReference serviceReference, Object object) {
        this.this$0.addSwDiagnosisManager((SwDiagnosisManager)object);
    }

    @Override
    public void removeService(ServiceReference serviceReference, Object object) {
        this.this$0.removeSwDiagnosisManager((SwDiagnosisManager)object);
    }
}

