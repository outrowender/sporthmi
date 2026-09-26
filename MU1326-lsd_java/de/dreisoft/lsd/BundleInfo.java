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

    @Override
    public int getState() {
        return this.state;
    }

    @Override
    public void start() {
        this.state = 8;
        try {
            Class clazz = Class.forName(this.activator);
            this.bundleActivator = (BundleActivator)clazz.newInstance();
        }
        catch (ClassNotFoundException classNotFoundException) {
            this.state = 4;
            throw new BundleException(new StringBuffer().append("Bundle ").append(this.name).append(" activator not found").toString(), classNotFoundException);
        }
        catch (InstantiationException instantiationException) {
            this.state = 4;
            throw new BundleException(new StringBuffer().append("Bundle ").append(this.name).append(" activator invalid").toString(), instantiationException);
        }
        catch (IllegalAccessException illegalAccessException) {
            this.state = 4;
            throw new BundleException(new StringBuffer().append("Bundle ").append(this.name).append(" activator invalid").toString(), illegalAccessException);
        }
        catch (Exception exception) {
            this.state = 4;
            throw new BundleException(new StringBuffer().append("Bundle ").append(this.name).append(" unexpected exception loading activator").toString(), exception);
        }
        try {
            this.bundleActivator.start(this);
        }
        catch (Exception exception) {
            this.bundleActivator = null;
            this.state = 4;
            throw new BundleException(new StringBuffer().append("[bundle:").append(this.name).append("] exception starting bundle").toString(), exception);
        }
        finally {
            ServiceRegistry.getInstance().waitForDelayedChanges();
        }
        this.state = 32;
    }

    @Override
    public void stop() {
        if (this.bundleActivator == null) {
            this.state = 4;
            return;
        }
        this.state = 16;
        try {
            this.bundleActivator.stop(this);
        }
        catch (Exception exception) {
            throw new BundleException(new StringBuffer().append("[bundle ").append(this.name).append("] exception stopping bundle").toString(), exception);
        }
        finally {
            this.bundleActivator = null;
            this.state = 4;
        }
    }

    @Override
    public void update() {
        System.err.println("Bundle#update() not supported!");
    }

    @Override
    public void update(InputStream inputStream) {
        System.err.println("Bundle#update(InputStream) not supported!");
    }

    @Override
    public void uninstall() {
        System.err.println("Bundle#uninstall() not supported!");
    }

    @Override
    public Dictionary getHeaders() {
        Hashtable hashtable = new Hashtable();
        ((Dictionary)hashtable).put("Bundle-Name", this.name);
        ((Dictionary)hashtable).put("Bundle-Activator", this.activator);
        return hashtable;
    }

    @Override
    public long getBundleId() {
        return this.id;
    }

    public String getBundleName() {
        return this.name;
    }

    @Override
    public String getLocation() {
        return this.name;
    }

    @Override
    public ServiceReference[] getRegisteredServices() {
        Object[] objectArray = new ServiceReference[this.registeredServices.size()];
        this.registeredServices.toArray(objectArray);
        return objectArray;
    }

    @Override
    public synchronized ServiceReference[] getServicesInUse() {
        Object[] objectArray = new ServiceReference[this.servicesInUse.size()];
        this.servicesInUse.toArray(objectArray);
        return objectArray;
    }

    @Override
    public boolean hasPermission(Object object) {
        return true;
    }

    @Override
    public URL getResource(String string) {
        return ClassLoader.getSystemResource(string);
    }

    @Override
    public String getProperty(String string) {
        if ("AuditTrail".equals(string)) {
            return AuditTrail.getInstance().toString();
        }
        return (String)this.getHeaders().get(string);
    }

    @Override
    public Bundle getBundle() {
        return this;
    }

    @Override
    public Bundle installBundle(String string) {
        throw new UnsupportedOperationException("BundleContext#installBundle(String) not supported!");
    }

    @Override
    public Bundle installBundle(String string, InputStream inputStream) {
        throw new UnsupportedOperationException("BundleContext#installBundle(String, InputStream) not supported!");
    }

    @Override
    public Bundle getBundle(long l) {
        if (l < 0) {
            return BundleRegistry.getInstance().getBundle((int)l);
        }
        return null;
    }

    @Override
    public Bundle[] getBundles() {
        return BundleRegistry.getInstance().getBundles();
    }

    @Override
    public void addServiceListener(ServiceListener serviceListener, String string) {
        System.err.println("BundleContext#addServiceListener(ServiceListener, String) in future version");
    }

    @Override
    public void addServiceListener(ServiceListener serviceListener) {
        ServiceRegistry.getInstance().addServiceListener(serviceListener);
    }

    @Override
    public void removeServiceListener(ServiceListener serviceListener) {
        ServiceRegistry.getInstance().removeServiceListener(serviceListener);
    }

    @Override
    public void addBundleListener(BundleListener bundleListener) {
        throw new UnsupportedOperationException("BundleContext#addBundleListener(BundleListener) not supported!");
    }

    @Override
    public void removeBundleListener(BundleListener bundleListener) {
        throw new UnsupportedOperationException("BundleContext#removeBundleListener(BundleListener) not supported!");
    }

    @Override
    public void addFrameworkListener(FrameworkListener frameworkListener) {
        System.err.println("BundleContext#addFrameworkListener(FrameworkListener) not supported!");
    }

    @Override
    public void removeFrameworkListener(FrameworkListener frameworkListener) {
        throw new UnsupportedOperationException("BundleContext#removeFrameworkListener(FrameworkListener) not supported!");
    }

    @Override
    public ServiceRegistration registerService(String[] stringArray, Object object, Dictionary dictionary) {
        ServiceInfo serviceInfo = ServiceDelegator.getServiceInfo(this, stringArray, object, dictionary);
        return serviceInfo;
    }

    @Override
    public ServiceRegistration registerService(String string, Object object, Dictionary dictionary) {
        ServiceInfo serviceInfo = ServiceDelegator.getServiceInfo(this, string, object, dictionary);
        return serviceInfo;
    }

    @Override
    public ServiceReference[] getServiceReferences(String string, String string2) {
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

    @Override
    public ServiceReference getServiceReference(String string) {
        return ServiceRegistry.getInstance().getServiceInfo(string);
    }

    @Override
    public synchronized Object getService(ServiceReference serviceReference) {
        this.servicesInUse.add(serviceReference);
        return ((ServiceInfo)serviceReference).getService();
    }

    @Override
    public synchronized boolean ungetService(ServiceReference serviceReference) {
        this.servicesInUse.remove(serviceReference);
        return true;
    }

    @Override
    public File getDataFile(String string) {
        return null;
    }

    @Override
    public Filter createFilter(String string) {
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
                stringBuffer.append(new StringBuffer().append(" (Unknown ").append(this.state).append(")").toString());
            }
        }
        stringBuffer.append(" (").append(this.activator).append(')');
        int n2 = this.registeredServices.size();
        int n3 = this.servicesInUse.size();
        stringBuffer.append(new StringBuffer().append("\n     Registered Services (").append(n2).append("):").toString());
        if (n2 == 0) {
            stringBuffer.append(" NONE");
        }
        for (n = 0; n < n2; ++n) {
            stringBuffer.append("\n          -> ");
            stringBuffer.append(this.registeredServices.get(n));
        }
        stringBuffer.append(new StringBuffer().append("\n     Services in use (").append(n3).append("):").toString());
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

