/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.eni;

import de.audi.app.eni.ENIActivator;
import de.audi.atip.interapp.bap.remoteservices.BAPServiceRemoteServices;
import org.osgi.framework.ServiceReference;

class ENIActivator$3
implements Runnable {
    private final /* synthetic */ Object val$service;
    private final /* synthetic */ ServiceReference val$reference;
    private final /* synthetic */ ENIActivator this$0;

    ENIActivator$3(ENIActivator eNIActivator, Object object, ServiceReference serviceReference) {
        this.this$0 = eNIActivator;
        this.val$service = object;
        this.val$reference = serviceReference;
    }

    @Override
    public void run() {
        ENIActivator.access$502(this.this$0, (BAPServiceRemoteServices)this.val$service);
        ENIActivator.access$100(this.this$0).add(this.val$reference);
        ENIActivator.access$200(this.this$0).setBAPServiceRemoteServices(ENIActivator.access$500(this.this$0));
    }
}

