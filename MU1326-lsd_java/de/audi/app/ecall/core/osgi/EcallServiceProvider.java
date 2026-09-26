/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.ecall.core.osgi;

import de.audi.atip.log.LogChannel;
import de.esolutions.fw.util.commons.Buffer;
import java.util.Dictionary;
import java.util.Hashtable;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;

public class EcallServiceProvider {
    private final LogChannel logChannel;
    private final BundleContext bundleContext;
    private String serviceClass;
    private Object service;
    private Hashtable properties;
    private volatile ServiceRegistration serviceRegistration;

    public EcallServiceProvider(String string, Object object, Hashtable hashtable, BundleContext bundleContext, LogChannel logChannel) {
        this.logChannel = logChannel;
        this.bundleContext = bundleContext;
        this.serviceClass = string;
        this.service = object;
        this.properties = hashtable;
    }

    public void startService() {
        this.logChannel.log(1078071040, "[EcallServiceProvider#startService] %1", (Object)this);
        this.serviceRegistration = this.bundleContext.registerService(this.serviceClass, this.service, (Dictionary)this.properties);
    }

    public void stopService() {
        this.logChannel.log(1078071040, "[EcallServiceProvider#stopService] %1", (Object)this);
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

    public String toString() {
        Buffer buffer = new Buffer();
        buffer.append("serviceClazz=");
        buffer.append(this.serviceClass);
        buffer.append(", service=");
        buffer.append(this.service);
        buffer.append(", properties=");
        buffer.append(this.properties);
        return buffer.toString();
    }
}

