/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.eni;

import de.audi.app.eni.ENIActivator;
import de.audi.atip.interapp.bap.eni.BAPServiceENI;
import org.osgi.framework.ServiceReference;

class ENIActivator$2
implements Runnable {
    private final /* synthetic */ Object val$service;
    private final /* synthetic */ ServiceReference val$reference;
    private final /* synthetic */ ENIActivator this$0;

    ENIActivator$2(ENIActivator eNIActivator, Object object, ServiceReference serviceReference) {
        this.this$0 = eNIActivator;
        this.val$service = object;
        this.val$reference = serviceReference;
    }

    @Override
    public void run() {
        ENIActivator.access$302(this.this$0, (BAPServiceENI)this.val$service);
        ENIActivator.access$100(this.this$0).add(this.val$reference);
        ENIActivator.access$400(this.this$0, ENIActivator.access$300(this.this$0));
    }
}

