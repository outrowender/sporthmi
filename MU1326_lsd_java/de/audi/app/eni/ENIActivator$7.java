/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.eni;

import de.audi.app.eni.ENIActivator;
import de.audi.atip.interapp.eni.ENIMobileKeyStatusDisplayListener;
import org.osgi.framework.ServiceReference;

class ENIActivator$7
implements Runnable {
    private final /* synthetic */ Object val$service;
    private final /* synthetic */ ServiceReference val$reference;
    private final /* synthetic */ ENIActivator this$0;

    ENIActivator$7(ENIActivator eNIActivator, Object object, ServiceReference serviceReference) {
        this.this$0 = eNIActivator;
        this.val$service = object;
        this.val$reference = serviceReference;
    }

    @Override
    public void run() {
        ENIActivator.access$902(this.this$0, (ENIMobileKeyStatusDisplayListener)this.val$service);
        ENIActivator.access$200(this.this$0).registerMobileKeyStatusDisplayListener(ENIActivator.access$900(this.this$0));
        ENIActivator.access$100(this.this$0).add(this.val$reference);
    }
}

