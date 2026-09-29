/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.eni;

import de.audi.app.eni.ENIActivator;
import de.audi.atip.interapp.eni.ENIServiceOnlineListener;
import org.osgi.framework.ServiceReference;

class ENIActivator$5
implements Runnable {
    private final /* synthetic */ Object val$service;
    private final /* synthetic */ ServiceReference val$reference;
    private final /* synthetic */ ENIActivator this$0;

    ENIActivator$5(ENIActivator eNIActivator, Object object, ServiceReference serviceReference) {
        this.this$0 = eNIActivator;
        this.val$service = object;
        this.val$reference = serviceReference;
    }

    @Override
    public void run() {
        ENIActivator.access$702(this.this$0, (ENIServiceOnlineListener)this.val$service);
        ENIActivator.access$200(this.this$0).setEniServiceOnlineListener(ENIActivator.access$700(this.this$0));
        ENIActivator.access$100(this.this$0).add(this.val$reference);
    }
}

