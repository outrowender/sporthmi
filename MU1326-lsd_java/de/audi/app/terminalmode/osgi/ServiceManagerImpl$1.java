/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.terminalmode.osgi;

import de.audi.app.terminalmode.osgi.ServiceManagerImpl;
import java.util.Dictionary;
import org.osgi.framework.ServiceReference;
import org.osgi.framework.ServiceRegistration;

class ServiceManagerImpl$1
implements ServiceRegistration {
    private final /* synthetic */ ServiceRegistration val$serviceRegistration;
    private final /* synthetic */ ServiceManagerImpl this$0;

    ServiceManagerImpl$1(ServiceManagerImpl serviceManagerImpl, ServiceRegistration serviceRegistration) {
        this.this$0 = serviceManagerImpl;
        this.val$serviceRegistration = serviceRegistration;
    }

    @Override
    public void unregister() {
        ServiceManagerImpl.access$000(this.this$0).remove(this.val$serviceRegistration);
        this.val$serviceRegistration.unregister();
    }

    @Override
    public void setProperties(Dictionary dictionary) {
        this.val$serviceRegistration.setProperties(dictionary);
    }

    @Override
    public ServiceReference getReference() {
        return this.val$serviceRegistration.getReference();
    }
}

