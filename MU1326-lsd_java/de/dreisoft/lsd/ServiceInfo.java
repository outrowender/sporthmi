/*
 * Decompiled with CFR 0.152.
 */
package de.dreisoft.lsd;

import de.dreisoft.lsd.BundleInfo;
import de.dreisoft.lsd.ServiceRegistry;
import java.util.Dictionary;
import java.util.Enumeration;
import java.util.Hashtable;
import org.osgi.framework.Bundle;
import org.osgi.framework.ServiceReference;
import org.osgi.framework.ServiceRegistration;

public class ServiceInfo
implements ServiceReference,
ServiceRegistration {
    private static ServiceRegistry svcRegistry;
    private static long highestSvcID;
    private BundleInfo bdlInfo;
    private long svcID;
    private String[] svcInterfaces;
    private Dictionary svcProperties;
    private Object svcObject;
    private boolean registered = false;

    static void setServiceRegistry(ServiceRegistry serviceRegistry) {
        svcRegistry = serviceRegistry;
    }

    public ServiceInfo(BundleInfo bundleInfo, String string, Object object, Dictionary dictionary) {
        this(bundleInfo, new String[]{string}, object, dictionary);
    }

    public ServiceInfo(BundleInfo bundleInfo, String[] stringArray, Object object, Dictionary dictionary) {
        this.bdlInfo = bundleInfo;
        this.svcID = ++highestSvcID;
        this.svcInterfaces = stringArray;
        this.svcProperties = dictionary;
        if (this.svcProperties == null) {
            this.svcProperties = new Hashtable();
        }
        this.svcObject = object;
        this.svcProperties.put("service.id", new Long(this.svcID));
        this.svcProperties.put("objectClass", this.svcInterfaces);
        if (this.bdlInfo != null) {
            this.bdlInfo.addService(this);
        }
        svcRegistry.registerService(this);
        this.registered = true;
    }

    public long getServiceID() {
        return this.svcID;
    }

    public Object getService() {
        return this.svcObject;
    }

    public String[] getServiceInterfaces() {
        return this.svcInterfaces;
    }

    public Dictionary getProperties() {
        return this.svcProperties;
    }

    @Override
    public String[] getPropertyKeys() {
        String[] stringArray = new String[this.svcProperties.size()];
        Enumeration enumeration = this.svcProperties.keys();
        int n = 0;
        while (enumeration.hasMoreElements()) {
            stringArray[n] = (String)enumeration.nextElement();
            ++n;
        }
        return stringArray;
    }

    @Override
    public Object getProperty(String string) {
        return this.svcProperties.get(string);
    }

    @Override
    public Bundle getBundle() {
        return this.bdlInfo;
    }

    @Override
    public Bundle[] getUsingBundles() {
        throw new UnsupportedOperationException("ServiceReference.getUsingBundles is not supported");
    }

    @Override
    public ServiceReference getReference() {
        return this;
    }

    @Override
    public void setProperties(Dictionary dictionary) {
        throw new UnsupportedOperationException("ServiceRegistration.setProperties is not supported");
    }

    @Override
    public void unregister() {
        if (!this.registered) {
            throw new IllegalStateException("service already unregistered");
        }
        if (this.bdlInfo != null) {
            this.bdlInfo.removeService(this);
        }
        svcRegistry.unregisterService(this);
        this.registered = false;
        this.svcObject = null;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(500);
        stringBuffer.append('[').append(this.svcID).append("] ");
        if (this.svcObject != null) {
            stringBuffer.append(this.svcObject.getClass().getName());
        }
        stringBuffer.append("( ");
        for (int i2 = 0; i2 < this.svcInterfaces.length; ++i2) {
            if (i2 > 0) {
                stringBuffer.append(", ");
            }
            stringBuffer.append("Interface=");
            stringBuffer.append(this.svcInterfaces[i2]);
        }
        Enumeration enumeration = this.svcProperties.keys();
        while (enumeration.hasMoreElements()) {
            String string = (String)enumeration.nextElement();
            if (string.equals("objectClass")) continue;
            stringBuffer.append(" | ");
            stringBuffer.append(string).append('=').append(this.svcProperties.get(string));
        }
        stringBuffer.append(" )");
        return stringBuffer.toString();
    }

    public int hashCode() {
        return super.hashCode();
    }

    static {
        highestSvcID = -1L;
    }
}

