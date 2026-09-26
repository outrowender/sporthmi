/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.messaging.core.application;

import de.audi.app.messaging.core.application.AbstractMsgApplication;
import de.audi.app.messaging.core.osgi.AbstractMessagingTrackerCustomizer;
import de.audi.atip.interapp.ADBHMIAppService;
import de.audi.atip.interapp.SDSService;
import de.audi.atip.log.LogChannel;
import de.audi.atip.phone.ITelService;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;

class AbstractMsgApplication$1
extends AbstractMessagingTrackerCustomizer {
    private final /* synthetic */ AbstractMsgApplication this$0;

    AbstractMsgApplication$1(AbstractMsgApplication abstractMsgApplication, LogChannel logChannel, BundleContext bundleContext) {
        this.this$0 = abstractMsgApplication;
        super(logChannel, bundleContext);
    }

    @Override
    public void addService(ServiceReference serviceReference, Object object) {
        if (object instanceof ADBHMIAppService) {
            AbstractMsgApplication.access$000(this.this$0, (ADBHMIAppService)object);
        } else if (object instanceof ITelService) {
            AbstractMsgApplication.access$100(this.this$0, (ITelService)object);
        } else {
            AbstractMsgApplication.access$200(this.this$0, (SDSService)object);
        }
    }

    @Override
    public void removeService(ServiceReference serviceReference, Object object) {
        if (object instanceof ADBHMIAppService) {
            AbstractMsgApplication.access$000(this.this$0, null);
        } else if (object instanceof ITelService) {
            AbstractMsgApplication.access$100(this.this$0, null);
        } else {
            AbstractMsgApplication.access$200(this.this$0, null);
        }
    }
}

