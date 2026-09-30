/*
 * Decompiled with CFR 0.152.
 */
package de.dreisoft.lsd;

import de.dreisoft.lsd.AuditTrail;
import de.dreisoft.lsd.BundleRegistry;
import de.dreisoft.lsd.ServiceDelegator;
import de.dreisoft.lsd.ServiceFilter;
import de.dreisoft.lsd.ServiceInfo;
import de.dreisoft.lsd.ServiceRegistry;
import java.io.File;
import java.io.InputStream;
import java.net.URL;
import java.util.Dictionary;
import java.util.Hashtable;
import java.util.LinkedList;
import java.util.List;
import org.osgi.framework.Bundle;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.BundleException;
import org.osgi.framework.BundleListener;
import org.osgi.framework.Filter;
import org.osgi.framework.FrameworkListener;
import org.osgi.framework.InvalidSyntaxException;
import org.osgi.framework.ServiceListener;
import org.osgi.framework.ServiceReference;
import org.osgi.framework.ServiceRegistration;

public class BundleInfo
implements Bundle,
BundleContext {
    private final List registeredServices = new LinkedList();
    private final List servicesInUse = new LinkedList();
    private final String activator;
    private final String name;
    private final int id;
    private BundleActivator bundleActivator;
    private int state = 4;

    public BundleInfo(int n, String string, String string2) {
        this.id = n;
        this.name = string;
        this.activator = string2;
    }

    public void addService(ServiceInfo serviceInfo) {
        this.registeredServices.add(serviceInfo);
    }

    public void removeService(ServiceInfo serviceInfo) {
        this.registeredServices.remove(serviceInfo);
    }

    public int getState() {
        return this.state;
    }

    public void start() throws BundleException {
        this.state = 8;
        try {
            Class clazz = Class.forName(this.activator);
            this.bundleActivator = (BundleActivator)clazz.newInstance();
        }
        catch (ClassNotFoundException classNotFoundException) {
            this.state = 4;
            throw new BundleException("Bundle " + this.name + " activator not found", classNotFoundException);
        }
        catch (InstantiationException instantiationException) {
            this.state = 4;
            throw new BundleException("Bundle " + this.name + " activator invalid", instantiationException);
        }
        catch (IllegalAccessException illegalAccessException) {
            this.state = 4;
            throw new BundleException("Bundle " + this.name + " activator invalid", illegalAccessException);
        }
        catch (Exception exception) {
            this.state = 4;
            throw new BundleException("Bundle " + this.name + " unexpected exception loading activator", exception);
        }
        try {
            this.bundleActivator.start(this);
        }
        catch (Exception exception) {
            this.bundleActivator = null;
            this.state = 4;
            throw new BundleException("[bundle:" + this.name + "] exception starting bundle", exception);
        }
        finally {
            ServiceRegistry.getInstance().waitForDelayedChanges();
        }
        this.state = 32;
    }

    public void stop() throws BundleException {
        if (this.bundleActivator == null) {
            this.state = 4;
            return;
        }
        this.state = 16;
        try {
            this.bundleActivator.stop(this);
        }
        catch (Exception exception) {
            throw new BundleException("[bundle " + this.name + "] exception stopping bundle", exception);
        }
        finally {
            this.bundleActivator = null;
            this.state = 4;
        }
    }

    public void update() throws BundleException {
        System.err.println("Bundle#update() not supported!");
    }

    public void update(InputStream inputStream) throws BundleException {
        System.err.println("Bundle#update(InputStream) not supported!");
    }

    public void uninstall() throws BundleException {
        System.err.println("Bundle#uninstall() not supported!");
    }

    public Dictionary getHeaders() {
        Hashtable hashtable = new Hashtable();
        ((Dictionary)hashtable).put("Bundle-Name", this.name);
        ((Dictionary)hashtable).put("Bundle-Activator", this.activator);
        return hashtable;
    }

    public long getBundleId() {
        return this.id;
    }

    public String getBundleName() {
        return this.name;
    }

    public String getLocation() {
        return this.name;
    }

    public ServiceReference[] getRegisteredServices() {
        Object[] objectArray = new ServiceReference[this.registeredServices.size()];
        this.registeredServices.toArray(objectArray);
        return objectArray;
    }

    public synchronized ServiceReference[] getServicesInUse() {
        Object[] objectArray = new ServiceReference[this.servicesInUse.size()];
        this.servicesInUse.toArray(objectArray);
        return objectArray;
    }

    public boolean hasPermission(Object object) {
        return true;
    }

    public URL getResource(String string) {
        return ClassLoader.getSystemResource(string);
    }

    public String getProperty(String string) {
        if ("AuditTrail".equals(string)) {
            return AuditTrail.getInstance().toString();
        }
        return (String)this.getHeaders().get(string);
    }

    public Bundle getBundle() {
        return this;
    }

    public Bundle installBundle(String string) throws BundleException {
        throw new UnsupportedOperationException("BundleContext#installBundle(String) not supported!");
    }

    public Bundle installBundle(String string, InputStream inputStream) throws BundleException {
        throw new UnsupportedOperationException("BundleContext#installBundle(String, InputStream) not supported!");
    }

    public Bundle getBundle(long l) {
        if (l < Integer.MAX_VALUE) {
            return BundleRegistry.getInstance().getBundle((int)l);
        }
        return null;
    }

    public Bundle[] getBundles() {
        return BundleRegistry.getInstance().getBundles();
    }

    public void addServiceListener(ServiceListener serviceListener, String string) throws InvalidSyntaxException {
        System.err.println("BundleContext#addServiceListener(ServiceListener, String) in future version");
    }

    public void addServiceListener(ServiceListener serviceListener) {
        ServiceRegistry.getInstance().addServiceListener(serviceListener);
    }

    public void removeServiceListener(ServiceListener serviceListener) {
        ServiceRegistry.getInstance().removeServiceListener(serviceListener);
    }

    public void addBundleListener(BundleListener bundleListener) {
        throw new UnsupportedOperationException("BundleContext#addBundleListener(BundleListener) not supported!");
    }

    public void removeBundleListener(BundleListener bundleListener) {
        throw new UnsupportedOperationException("BundleContext#removeBundleListener(BundleListener) not supported!");
    }

    public void addFrameworkListener(FrameworkListener frameworkListener) {
        System.err.println("BundleContext#addFrameworkListener(FrameworkListener) not supported!");
    }

    public void removeFrameworkListener(FrameworkListener frameworkListener) {
        throw new UnsupportedOperationException("BundleContext#removeFrameworkListener(FrameworkListener) not supported!");
    }

    public ServiceRegistration registerService(String[] stringArray, Object object, Dictionary dictionary) {
        ServiceInfo serviceInfo = ServiceDelegator.getServiceInfo(this, stringArray, object, dictionary);
        return serviceInfo;
    }

    public ServiceRegistration registerService(String string, Object object, Dictionary dictionary) {
        ServiceInfo serviceInfo = ServiceDelegator.getServiceInfo(this, string, object, dictionary);
        return serviceInfo;
    }

    public ServiceReference[] getServiceReferences(String string, String string2) throws InvalidSyntaxException {
        List list;
        Object[] objectArray;
        if (string == null) {
            string = "*";
        }
        if (string2 != null) {
            objectArray = new ServiceFilter(string2);
            list = ServiceRegistry.getInstance().getServiceInfos(string);
            for (int i2 = list.size() - 1; i2 >= 0; --i2) {
                if (objectArray.match((ServiceInfo)list.get(i2))) continue;
                list.remove(i2);
            }
        } else {
            list = ServiceRegistry.getInstance().getServiceInfos(string);
        }
        objectArray = new ServiceInfo[list.size()];
        if (!list.isEmpty()) {
            objectArray = (ServiceInfo[])list.toArray(objectArray);
        }
        return objectArray;
    }

    public ServiceReference getServiceReference(String string) {
        return ServiceRegistry.getInstance().getServiceInfo(string);
    }

    public synchronized Object getService(ServiceReference serviceReference) {
        this.servicesInUse.add(serviceReference);
        return ((ServiceInfo)serviceReference).getService();
    }

    public synchronized boolean ungetService(ServiceReference serviceReference) {
        this.servicesInUse.remove(serviceReference);
        return true;
    }

    public File getDataFile(String string) {
        return null;
    }

    public Filter createFilter(String string) throws InvalidSyntaxException {
        return new ServiceFilter(string);
    }

    public String toString() {
        int n;
        StringBuffer stringBuffer = new StringBuffer(500);
        stringBuffer.append(this.name);
        switch (this.state) {
            case 32: {
                stringBuffer.append(" (ACTIVE)");
                break;
            }
            case 2: {
                stringBuffer.append(" (INSTALLED)");
                break;
            }
            case 4: {
                stringBuffer.append(" (RESOLVED)");
                break;
            }
            case 8: {
                stringBuffer.append(" (STARTING)");
                break;
            }
            case 16: {
                stringBuffer.append(" (STOPPING)");
                break;
            }
            case 1: {
                stringBuffer.append(" (UNINSTALLED)");
                break;
            }
            default: {
                stringBuffer.append(" (Unknown " + this.state + ")");
            }
        }
        stringBuffer.append(" (").append(this.activator).append(')');
        int n2 = this.registeredServices.size();
        int n3 = this.servicesInUse.size();
        stringBuffer.append("\n     Registered Services (" + n2 + "):");
        if (n2 == 0) {
            stringBuffer.append(" NONE");
        }
        for (n = 0; n < n2; ++n) {
            stringBuffer.append("\n          -> ");
            stringBuffer.append(this.registeredServices.get(n));
        }
        stringBuffer.append("\n     Services in use (" + n3 + "):");
        if (n3 == 0) {
            stringBuffer.append(" NONE");
        }
        for (n = 0; n < n3; ++n) {
            stringBuffer.append("\n          -> ");
            stringBuffer.append(this.servicesInUse.get(n));
        }
        stringBuffer.append('\n');
        return stringBuffer.toString();
    }

    public boolean equals(Object object) {
        if (object == null) {
            return false;
        }
        if (object instanceof BundleInfo) {
            return ((BundleInfo)object).getBundleName().equals(this.name);
        }
        return false;
    }
}

