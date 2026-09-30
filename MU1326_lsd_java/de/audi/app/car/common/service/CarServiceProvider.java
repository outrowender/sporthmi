/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.car.common.service;

import de.audi.atip.log.LogChannel;
import java.util.Dictionary;
import java.util.Hashtable;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;

public class CarServiceProvider {
    private final LogChannel logChannel;
    private final BundleContext bundleContext;
    private String serviceClass;
    private Object service;
    private Hashtable properties;
    private volatile ServiceRegistration serviceRegistration;

    public CarServiceProvider(String string, Object object, Hashtable hashtable, BundleContext bundleContext, LogChannel logChannel) {
        this.logChannel = logChannel;
        this.bundleContext = bundleContext;
        this.serviceClass = string;
        this.service = object;
        this.properties = hashtable;
    }

    public void startService() {
        this.logChannel.log(1000000, "[CarServiceProvider#startService] starting service '%1'", (Object)this.serviceClass);
        this.serviceRegistration = this.bundleContext.registerService(this.serviceClass, this.service, (Dictionary)this.properties);
    }

    public void stopService() {
        this.logChannel.log(1000000, "[CarServiceProvider#stopService] stopping service '%1'", (Object)this.serviceClass);
        if (this.serviceRegistration != null) {
            this.serviceRegistration.unregister();
        }
    }

    public void setServiceClazz(String string) {
        this.serviceClass = string;
    }

    public void setService(Object object) {
        this.service = object;
    }

    public void setProperties(Hashtable hashtable) {
        this.properties = hashtable;
    }
}

