/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.bap.dsi;

import de.audi.app.bap.dsi.IDSIController;
import de.audi.app.bap.dsi.IDSIServiceStateListener;
import de.audi.atip.log.LogChannel;
import java.util.Dictionary;
import java.util.Hashtable;
import org.dsi.ifc.base.DSIBase;
import org.dsi.ifc.base.DSIListener;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;
import org.osgi.framework.ServiceRegistration;
import org.osgi.util.tracker.ServiceTracker;
import org.osgi.util.tracker.ServiceTrackerCustomizer;

public class DSIServiceTracker
implements ServiceTrackerCustomizer {
    private final BundleContext bundleContext;
    private final IDSIController dsiController;
    private final DSIListener dsiListener;
    private final Class dsiListenerClass;
    private final int[] notifications;
    private final LogChannel logChannel;
    private ServiceTracker serviceTracker;
    private volatile ServiceRegistration serviceRegistration;
    private IDSIServiceStateListener listener;
    static /* synthetic */ Class class$org$dsi$ifc$base$DSIBase;
    static /* synthetic */ Class class$org$dsi$ifc$base$DSIListener;

    public DSIServiceTracker(BundleContext bundleContext, IDSIController iDSIController, LogChannel logChannel) {
        this(bundleContext, iDSIController, null, null, null, logChannel);
    }

    public DSIServiceTracker(BundleContext bundleContext, IDSIController iDSIController, DSIListener dSIListener, Class clazz, int[] nArray, LogChannel logChannel) {
        this.bundleContext = bundleContext;
        this.dsiController = iDSIController;
        this.notifications = nArray;
        this.dsiListener = dSIListener;
        this.dsiListenerClass = clazz;
        this.logChannel = logChannel;
    }

    public void setDSIServiceStateListener(IDSIServiceStateListener iDSIServiceStateListener) {
        this.listener = iDSIServiceStateListener;
    }

    public void start() {
        if ((class$org$dsi$ifc$base$DSIBase == null ? (class$org$dsi$ifc$base$DSIBase = DSIServiceTracker.class$("org.dsi.ifc.base.DSIBase")) : class$org$dsi$ifc$base$DSIBase).isAssignableFrom(this.dsiController.getDSIClass())) {
            if (this.dsiListener != null) {
                this.registerDSIListener(this.bundleContext);
            }
            this.logChannel.log(1078071040, "[DSIServiceTracker#startTracking] tracking service: %1", (Object)this.dsiController.getDSIClass().getName());
            this.serviceTracker = new ServiceTracker(this.bundleContext, this.dsiController.getDSIClass().getName(), (ServiceTrackerCustomizer)this);
            this.serviceTracker.open();
        } else {
            this.logChannel.log(10000, "[DSIServiceTracker#startTracking] class not allowed, must be assignable from DSIBase: %1", (Object)this.dsiController.getDSIClass().getName());
        }
    }

    private void registerDSIListener(BundleContext bundleContext) {
        Hashtable hashtable = new Hashtable();
        hashtable.put("DEVICE_NAME", this.dsiListenerClass.getName());
        hashtable.put("DEVICE_INSTANCE", new Integer(0));
        hashtable.put("moduleID", new Integer(20));
        this.logChannel.log(-2137614336, "[DSIServiceTracker#registerDSIListener] Registering %1", (Object)super.getClass());
        this.serviceRegistration = bundleContext.registerService((class$org$dsi$ifc$base$DSIListener == null ? (class$org$dsi$ifc$base$DSIListener = DSIServiceTracker.class$("org.dsi.ifc.base.DSIListener")) : class$org$dsi$ifc$base$DSIListener).getName(), (Object)this.dsiListener, (Dictionary)hashtable);
    }

    public void stop() {
        if (this.dsiListener != null) {
            this.dsiController.getDSI().clearNotification(this.dsiListener);
        }
        if (this.serviceRegistration != null) {
            this.serviceRegistration.unregister();
            this.serviceRegistration = null;
        }
        this.logChannel.log(1078071040, "[DSIServiceTracker#stopTracking] tracking service: %1", (Object)this.dsiController.getDSIClass().getName());
        if (this.serviceTracker != null) {
            this.serviceTracker.close();
            this.serviceTracker = null;
        }
    }

    @Override
    public void removedService(ServiceReference serviceReference, Object object) {
        this.logChannel.log(-2137614336, "[DSIServiceTracker#removedService] service removed: %1", (Object)this.dsiController.getDSIClass().getName());
        this.dsiController.deregisterDSI();
        this.bundleContext.ungetService(serviceReference);
        if (this.listener != null) {
            this.listener.notifyDSIAvailable(this.dsiController.getDSIClass(), false);
        }
    }

    @Override
    public void modifiedService(ServiceReference serviceReference, Object object) {
    }

    @Override
    public Object addingService(ServiceReference serviceReference) {
        this.logChannel.log(-2137614336, "[DSIServiceTracker#addingService] service added: %1", (Object)this.dsiController.getDSIClass().getName());
        Object object = this.bundleContext.getService(serviceReference);
        if (this.dsiController.getDSIClass().isAssignableFrom(object.getClass())) {
            DSIBase dSIBase = (DSIBase)object;
            if (this.dsiListener != null) {
                if (this.notifications == null || this.notifications.length == 0) {
                    dSIBase.setNotification(this.dsiListener);
                } else {
                    dSIBase.setNotification(this.notifications, this.dsiListener);
                }
            }
            this.dsiController.setDSI(dSIBase);
            if (this.listener != null) {
                this.listener.notifyDSIAvailable(this.dsiController.getDSIClass(), true);
            }
        }
        return object;
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

