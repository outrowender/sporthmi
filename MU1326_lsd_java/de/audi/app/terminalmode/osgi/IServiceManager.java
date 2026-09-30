/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.terminalmode.osgi;

import de.audi.app.terminalmode.osgi.IServiceTracker;
import java.util.Dictionary;
import java.util.Hashtable;
import org.dsi.ifc.base.DSIListener;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;
import org.osgi.framework.ServiceRegistration;
import org.osgi.util.tracker.ServiceTrackerCustomizer;

public interface IServiceManager {
    public static final Hashtable EMPTY_PARAMETERS = new Hashtable(0);

    public IServiceTracker createServiceTracker(Class var1, ServiceTrackerCustomizer var2);

    public ServiceReference[] getServiceReferences(Class var1);

    public ServiceRegistration registerService(Class var1, Object var2, Dictionary var3);

    public void unregisterService(ServiceRegistration var1);

    public ServiceRegistration registerDSIListener(int var1, String var2, DSIListener var3);

    public Object getService(ServiceReference var1);

    public void releaseService(ServiceReference var1);

    public boolean startDSIService(String var1, int var2);

    public BundleContext getBundleContext();
}

