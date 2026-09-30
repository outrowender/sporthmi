/*
 * Decompiled with CFR 0.152.
 */
package org.osgi.framework;

import java.io.File;
import java.io.InputStream;
import java.util.Dictionary;
import org.osgi.framework.Bundle;
import org.osgi.framework.BundleException;
import org.osgi.framework.BundleListener;
import org.osgi.framework.Filter;
import org.osgi.framework.FrameworkListener;
import org.osgi.framework.InvalidSyntaxException;
import org.osgi.framework.ServiceListener;
import org.osgi.framework.ServiceReference;
import org.osgi.framework.ServiceRegistration;

public interface BundleContext {
    public String getProperty(String var1);

    public Bundle getBundle();

    public Bundle installBundle(String var1) throws BundleException;

    public Bundle installBundle(String var1, InputStream var2) throws BundleException;

    public Bundle getBundle(long var1);

    public Bundle[] getBundles();

    public void addServiceListener(ServiceListener var1, String var2) throws InvalidSyntaxException;

    public void addServiceListener(ServiceListener var1);

    public void removeServiceListener(ServiceListener var1);

    public void addBundleListener(BundleListener var1);

    public void removeBundleListener(BundleListener var1);

    public void addFrameworkListener(FrameworkListener var1);

    public void removeFrameworkListener(FrameworkListener var1);

    public ServiceRegistration registerService(String[] var1, Object var2, Dictionary var3);

    public ServiceRegistration registerService(String var1, Object var2, Dictionary var3);

    public ServiceReference[] getServiceReferences(String var1, String var2) throws InvalidSyntaxException;

    public ServiceReference getServiceReference(String var1);

    public Object getService(ServiceReference var1);

    public boolean ungetService(ServiceReference var1);

    public File getDataFile(String var1);

    public Filter createFilter(String var1) throws InvalidSyntaxException;
}

