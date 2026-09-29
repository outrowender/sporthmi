/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.msg;

import de.audi.atip.msg.MsgListener;
import de.audi.tghu.msg.MessageDistributorActivator;
import org.osgi.framework.ServiceReference;
import org.osgi.util.tracker.ServiceTrackerCustomizer;

class MessageDistributorActivator$1
implements ServiceTrackerCustomizer {
    private final /* synthetic */ MessageDistributorActivator this$0;

    MessageDistributorActivator$1(MessageDistributorActivator messageDistributorActivator) {
        this.this$0 = messageDistributorActivator;
    }

    @Override
    public Object addingService(ServiceReference serviceReference) {
        Object object = MessageDistributorActivator.access$000(this.this$0).getBundleCxt().getService(serviceReference);
        if (object instanceof MsgListener) {
            MessageDistributorActivator.access$100(this.this$0).addListener((MsgListener)object);
            return object;
        }
        MessageDistributorActivator.access$200(this.this$0).getBundleCxt().ungetService(serviceReference);
        return null;
    }

    @Override
    public void modifiedService(ServiceReference serviceReference, Object object) {
    }

    @Override
    public void removedService(ServiceReference serviceReference, Object object) {
        if (object instanceof MsgListener) {
            MessageDistributorActivator.access$100(this.this$0).removeListener((MsgListener)object);
        }
    }
}

