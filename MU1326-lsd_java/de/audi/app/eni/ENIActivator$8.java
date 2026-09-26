/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.eni;

import de.audi.app.eni.ENIActivator;
import org.osgi.framework.ServiceReference;

class ENIActivator$8
implements Runnable {
    private final /* synthetic */ Object val$service;
    private final /* synthetic */ ServiceReference val$reference;
    private final /* synthetic */ ENIActivator this$0;

    ENIActivator$8(ENIActivator eNIActivator, Object object, ServiceReference serviceReference) {
        this.this$0 = eNIActivator;
        this.val$service = object;
        this.val$reference = serviceReference;
    }

    @Override
    public void run() {
        if (ENIActivator.access$300(this.this$0).equals(this.val$service)) {
            ENIActivator.access$302(this.this$0, null);
            ENIActivator.access$100(this.this$0).remove(this.val$reference);
            this.this$0.getLogMain().log(1078071040, "ENIActivator#removedService: removed %1", this.val$service);
        } else if (ENIActivator.access$600(this.this$0).equals(this.val$service)) {
            ENIActivator.access$602(this.this$0, null);
            ENIActivator.access$100(this.this$0).remove(this.val$reference);
            this.this$0.getLogMain().log(1078071040, "ENIActivator#removedService: removed %1", this.val$service);
        } else if (ENIActivator.access$700(this.this$0).equals(this.val$service)) {
            ENIActivator.access$702(this.this$0, null);
            ENIActivator.access$100(this.this$0).remove(this.val$reference);
            this.this$0.getLogMain().log(1078071040, "ENIActivator#removedService: removed %1", this.val$service);
        } else {
            this.this$0.getLogMain().log(-1601830656, "ENIActivator#removingService: unknown service: %1", this.val$service);
            return;
        }
    }
}

