/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.jdsi;

import de.audi.atip.activator.AbstractFrameworkActivator;
import de.audi.atip.log.LogChannel;
import de.audi.tghu.jdsi.JDSIActivator$1;
import de.audi.tghu.jdsi.JDSIActivator$2;
import de.audi.tghu.jdsi.JDSIManager;
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
        this.serviceAdminTracker = new ServiceTracker(this.bundleContext, (class$org$dsi$ifc$base$ServiceAdmin == null ? (class$org$dsi$ifc$base$ServiceAdmin = JDSIActivator.class$("org.dsi.ifc.base.ServiceAdmin")) : class$org$dsi$ifc$base$ServiceAdmin).getName(), (ServiceTrackerCustomizer)new JDSIActivator$1(this));
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

    private void initDSITracker(JDSIManager jDSIManager) {
        this.dsiTracker = new ServiceTracker(this.getBundleContext(), this.getDSIFilter(), (ServiceTrackerCustomizer)new JDSIActivator$2(this, jDSIManager));
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

    @Override
    protected void startInternal(BundleContext bundleContext) {
        this.lc = this.getFramework().getLogChannel("Fw.JDSI.Admin");
        this.service = new JDSIManager(this.getFramework());
        this.initTracker();
        this.initDSITracker(this.service);
    }

    @Override
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

    static /* synthetic */ BundleContext access$000(JDSIActivator jDSIActivator) {
        return jDSIActivator.bundleContext;
    }

    static /* synthetic */ ServiceReference access$102(JDSIActivator jDSIActivator, ServiceReference serviceReference) {
        jDSIActivator.serviceAdminReference = serviceReference;
        return jDSIActivator.serviceAdminReference;
    }

    static /* synthetic */ JDSIManager access$200(JDSIActivator jDSIActivator) {
        return jDSIActivator.service;
    }

    static /* synthetic */ BundleContext access$300(JDSIActivator jDSIActivator) {
        return jDSIActivator.bundleContext;
    }

    static /* synthetic */ BundleContext access$400(JDSIActivator jDSIActivator) {
        return jDSIActivator.bundleContext;
    }

    static /* synthetic */ BundleContext access$500(JDSIActivator jDSIActivator) {
        return jDSIActivator.getBundleContext();
    }

    static /* synthetic */ String access$600(JDSIActivator jDSIActivator, ServiceReference serviceReference) {
        return jDSIActivator.getDeviceName(serviceReference);
    }

    static /* synthetic */ int access$700(JDSIActivator jDSIActivator, ServiceReference serviceReference) {
        return jDSIActivator.getDeviceInstance(serviceReference);
    }

    static /* synthetic */ BundleContext access$800(JDSIActivator jDSIActivator) {
        return jDSIActivator.getBundleContext();
    }

    static /* synthetic */ LogChannel access$900(JDSIActivator jDSIActivator) {
        return jDSIActivator.lc;
    }

    static /* synthetic */ BundleContext access$1000(JDSIActivator jDSIActivator) {
        return jDSIActivator.getBundleContext();
    }

    static /* synthetic */ BundleContext access$1100(JDSIActivator jDSIActivator) {
        return jDSIActivator.getBundleContext();
    }
}

