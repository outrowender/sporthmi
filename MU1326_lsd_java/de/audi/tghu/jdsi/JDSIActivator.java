/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.jdsi;

import de.audi.atip.activator.AbstractFrameworkActivator;
import de.audi.atip.log.LogChannel;
import de.audi.tghu.jdsi.JDSIManager;
import org.dsi.ifc.base.DSIBase;
import org.dsi.ifc.base.ServiceAdmin;
import org.osgi.framework.BundleContext;
import org.osgi.framework.Filter;
import org.osgi.framework.InvalidSyntaxException;
import org.osgi.framework.ServiceReference;
import org.osgi.util.tracker.ServiceTracker;
import org.osgi.util.tracker.ServiceTrackerCustomizer;

public final class JDSIActivator
extends AbstractFrameworkActivator {
    private JDSIManager service;
    private ServiceReference serviceAdminReference;
    private ServiceTracker serviceAdminTracker;
    private ServiceTracker dsiTracker;
    private LogChannel lc;
    static /* synthetic */ Class class$org$dsi$ifc$base$ServiceAdmin;

    public JDSIActivator() {
        super("JDSIAdmin");
    }

    public JDSIManager getService() {
        return this.service;
    }

    public void initTracker() {
        this.serviceAdminTracker = new ServiceTracker(this.bundleContext, (class$org$dsi$ifc$base$ServiceAdmin == null ? (class$org$dsi$ifc$base$ServiceAdmin = JDSIActivator.class$("org.dsi.ifc.base.ServiceAdmin")) : class$org$dsi$ifc$base$ServiceAdmin).getName(), new ServiceTrackerCustomizer(){

            public Object addingService(ServiceReference serviceReference) {
                Object object = JDSIActivator.this.bundleContext.getService(serviceReference);
                if (object instanceof ServiceAdmin) {
                    JDSIActivator.this.serviceAdminReference = serviceReference;
                    JDSIActivator.this.service.setServiceAdmin((ServiceAdmin)object);
                    return object;
                }
                JDSIActivator.this.bundleContext.ungetService(serviceReference);
                return null;
            }

            public void modifiedService(ServiceReference serviceReference, Object object) {
            }

            public void removedService(ServiceReference serviceReference, Object object) {
                JDSIActivator.this.bundleContext.ungetService(serviceReference);
                JDSIActivator.this.serviceAdminReference = null;
                JDSIActivator.this.service.setServiceAdmin(null);
            }
        });
        this.serviceAdminTracker.open();
    }

    private Filter getDSIFilter() {
        Filter filter = null;
        try {
            filter = this.getBundleContext().createFilter("(&(objectClass=org.dsi.ifc.*) (!(objectClass=*Listener)))");
        }
        catch (InvalidSyntaxException invalidSyntaxException) {
            this.lc.log(10000, "JDSIManager.getDSIFilter() invalid syntax!", (Throwable)invalidSyntaxException);
            filter = null;
        }
        return filter;
    }

    private int getDeviceInstance(ServiceReference serviceReference) {
        Object object = serviceReference.getProperty("DEVICE_INSTANCE");
        if (object != null) {
            int n = object instanceof Integer ? (Integer)object : Integer.parseInt((String)object);
            return n;
        }
        return 0;
    }

    private String getDeviceName(ServiceReference serviceReference) {
        return (String)serviceReference.getProperty("DEVICE_NAME");
    }

    private void initDSITracker(final JDSIManager jDSIManager) {
        this.dsiTracker = new ServiceTracker(this.getBundleContext(), this.getDSIFilter(), new ServiceTrackerCustomizer(){

            public Object addingService(ServiceReference serviceReference) {
                Object object = JDSIActivator.this.getBundleContext().getService(serviceReference);
                if (object instanceof DSIBase) {
                    try {
                        jDSIManager.addDSIService((DSIBase)object, JDSIActivator.this.getDeviceName(serviceReference), JDSIActivator.this.getDeviceInstance(serviceReference));
                        return object;
                    }
                    catch (Exception exception) {
                        JDSIActivator.this.getBundleContext().ungetService(serviceReference);
                        JDSIActivator.this.lc.log(10000, "Incorrect property DEVICE_INSTANCE for a DSI reference %1", (Object)serviceReference);
                        return null;
                    }
                }
                JDSIActivator.this.getBundleContext().ungetService(serviceReference);
                return null;
            }

            public void modifiedService(ServiceReference serviceReference, Object object) {
            }

            public void removedService(ServiceReference serviceReference, Object object) {
                JDSIActivator.this.getBundleContext().ungetService(serviceReference);
                jDSIManager.removedDSIService((DSIBase)object, JDSIActivator.this.getDeviceName(serviceReference), JDSIActivator.this.getDeviceInstance(serviceReference));
            }
        });
        this.dsiTracker.open();
    }

    private void cleanupDSI() {
        if (this.service != null) {
            this.service.setServiceAdmin(null);
            this.service = null;
        }
        if (this.serviceAdminReference != null) {
            this.getBundleContext().ungetService(this.serviceAdminReference);
            this.serviceAdminReference = null;
        }
        if (this.serviceAdminTracker != null) {
            this.serviceAdminTracker.close();
            this.serviceAdminTracker = null;
        }
        if (this.dsiTracker != null) {
            this.dsiTracker.close();
            this.dsiTracker = null;
        }
    }

    protected void startInternal(BundleContext bundleContext) {
        this.lc = this.getFramework().getLogChannel("Fw.JDSI.Admin");
        this.service = new JDSIManager(this.getFramework());
        this.initTracker();
        this.initDSITracker(this.service);
    }

    public void stop(BundleContext bundleContext) {
        this.cleanupDSI();
        super.stop(bundleContext);
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

