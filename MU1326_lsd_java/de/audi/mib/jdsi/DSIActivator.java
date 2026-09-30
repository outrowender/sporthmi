/*
 * Decompiled with CFR 0.152.
 */
package de.audi.mib.jdsi;

import de.audi.atip.base.IFrameworkAccess;
import de.audi.atip.log.LogChannel;
import de.audi.mib.jdsi.IDSIClient;
import java.util.Dictionary;
import java.util.Hashtable;
import org.dsi.ifc.base.DSIBase;
import org.dsi.ifc.base.DSIListener;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;
import org.osgi.framework.ServiceRegistration;
import org.osgi.util.tracker.ServiceTracker;
import org.osgi.util.tracker.ServiceTrackerCustomizer;

public class DSIActivator
implements BundleActivator,
ServiceTrackerCustomizer {
    public static final int[] ATTR_ALL = new int[0];
    private final IFrameworkAccess framework;
    private final LogChannel log;
    private final String clazz;
    private final String listenerClazz;
    private final Integer instance;
    private final DSIListener listener;
    private final IDSIClient client;
    private volatile BundleContext context = null;
    private volatile ServiceRegistration sRegListener = null;
    private volatile ServiceTracker tracker = null;
    static /* synthetic */ Class class$org$dsi$ifc$base$DSIListener;

    public DSIActivator(IFrameworkAccess iFrameworkAccess, String string, String string2, Integer n, DSIListener dSIListener, IDSIClient iDSIClient) {
        this.framework = iFrameworkAccess;
        this.log = iFrameworkAccess.getLogChannel("Fw.Util.DSI");
        this.clazz = string;
        this.listenerClazz = string2;
        this.instance = n;
        this.listener = dSIListener;
        this.client = iDSIClient;
    }

    public Object addingService(ServiceReference serviceReference) {
        Object object = this.context.getService(serviceReference);
        if (object instanceof DSIBase) {
            Object object2 = serviceReference.getProperty("DEVICE_INSTANCE");
            if (this.instance.equals(object2)) {
                this.log.log(1000000, "[DSIActivator] found DSI %1 instance %2!", (Object)this.clazz, (Object)this.instance);
                this.client.setDSI((DSIBase)object);
                int[] nArray = this.client.getAutoNotifications();
                if (nArray != null && this.listener != null) {
                    if (nArray == ATTR_ALL) {
                        this.log.log(10000000, "[DSIActivator] %1 set all notifications!", (Object)this.clazz);
                        ((DSIBase)object).setNotification(this.listener);
                    } else {
                        this.log.log(10000000, "[DSIActivator] %1 set notifications %2!", (Object)this.clazz, (Object)nArray);
                        ((DSIBase)object).setNotification(nArray, this.listener);
                    }
                }
            } else {
                this.log.log(100000, "[DSIActivator] wrong instance %2!", (Object)this.clazz, (Object)this.instance);
                this.context.ungetService(serviceReference);
                object = null;
            }
        } else {
            this.context.ungetService(serviceReference);
            this.log.log(100000, "[DSIActivator] not adding unwanted service!");
            object = null;
        }
        return object;
    }

    public void modifiedService(ServiceReference serviceReference, Object object) {
    }

    public void removedService(ServiceReference serviceReference, Object object) {
        this.log.log(100000, "[DSIActivator] removed DSI %1 instance %2!", (Object)this.clazz, (Object)this.instance);
        int[] nArray = this.client.getAutoNotifications();
        if (nArray != null && this.listener != null) {
            if (nArray == ATTR_ALL) {
                this.log.log(10000000, "[DSIActivator] %1 clear all notifications!", (Object)this.clazz);
                ((DSIBase)object).clearNotification(this.listener);
            } else {
                this.log.log(10000000, "[DSIActivator] %1 clear notifications %2!", (Object)this.clazz, (Object)nArray);
                ((DSIBase)object).clearNotification(nArray, this.listener);
            }
        }
        this.client.setDSI(null);
        this.context.ungetService(serviceReference);
    }

    public void start(BundleContext bundleContext) {
        this.context = bundleContext;
        Hashtable hashtable = new Hashtable(8);
        hashtable.put("DEVICE_NAME", this.listenerClazz);
        hashtable.put("DEVICE_INSTANCE", this.instance);
        if (this.listener != null) {
            this.sRegListener = bundleContext.registerService((class$org$dsi$ifc$base$DSIListener == null ? (class$org$dsi$ifc$base$DSIListener = DSIActivator.class$("org.dsi.ifc.base.DSIListener")) : class$org$dsi$ifc$base$DSIListener).getName(), (Object)this.listener, (Dictionary)hashtable);
        }
        this.tracker = new ServiceTracker(bundleContext, this.clazz, (ServiceTrackerCustomizer)this);
        this.tracker.open();
        this.framework.startDSIService(this.clazz, this.instance);
    }

    public void stop(BundleContext bundleContext) {
        this.framework.stopDSIService(this.clazz, this.instance);
        if (this.tracker != null) {
            this.tracker.close();
            this.tracker = null;
        }
        if (this.sRegListener != null) {
            this.sRegListener.unregister();
            this.sRegListener = null;
        }
    }

    static /* synthetic */ Class class$(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new NoClassDefFoundError().initCause(classNotFoundException);
        }
    }
}

