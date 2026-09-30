/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.connectivity.core.common;

import de.audi.atip.log.LogChannel;
import de.audi.atip.phone.ITelServiceConnectivity;
import de.audi.atip.phone.ITelServiceConnectivityListener;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;
import org.osgi.util.tracker.ServiceTracker;
import org.osgi.util.tracker.ServiceTrackerCustomizer;

public class PhoneProxy
implements ServiceTrackerCustomizer,
ITelServiceConnectivityListener {
    private final BundleContext bundleContext;
    private final LogChannel log;
    private ServiceTracker serviceTracker;
    private ITelServiceConnectivity phone;
    private ITelServiceConnectivityListener caller;
    private boolean operationInProgress;
    static /* synthetic */ Class class$de$audi$atip$phone$ITelServiceConnectivity;

    public PhoneProxy(BundleContext bundleContext, LogChannel logChannel) {
        this.bundleContext = bundleContext;
        this.log = logChannel;
    }

    public boolean isIdle() {
        return !this.operationInProgress;
    }

    void setNadMode(ITelServiceConnectivityListener iTelServiceConnectivityListener, boolean bl) {
        this.caller = iTelServiceConnectivityListener;
        this.setNadMode(bl);
    }

    private void setNadMode(boolean bl) {
        if (this.phone != null) {
            this.operationInProgress = true;
            this.phone.setNadMode(bl ? 1 : 2, this);
        } else {
            this.log.log(100000, "PhoneProxy#setNadMode(): Phone not available!");
        }
    }

    void activateNadModule(ITelServiceConnectivityListener iTelServiceConnectivityListener) {
        this.caller = iTelServiceConnectivityListener;
        this.activateNadModule();
    }

    private void activateNadModule() {
        if (this.phone != null) {
            this.operationInProgress = true;
            this.phone.changePhoneModulePowerState(true, this);
        } else {
            this.log.log(100000, "PhoneProxy#activateNadModule(): Phone not available!");
        }
    }

    void togglePhones(ITelServiceConnectivityListener iTelServiceConnectivityListener) {
        this.caller = iTelServiceConnectivityListener;
        this.togglePhones();
    }

    private void togglePhones() {
        if (this.phone != null) {
            this.operationInProgress = true;
            this.phone.togglePhones(this);
        } else {
            this.log.log(100000, "PhoneProxy#togglePhones(): Phone not available!");
        }
    }

    void setNadRole(ITelServiceConnectivityListener iTelServiceConnectivityListener, int n) {
        this.caller = iTelServiceConnectivityListener;
        this.setNadRole(n);
    }

    private void setNadRole(int n) {
        if (this.phone != null) {
            this.operationInProgress = true;
            this.phone.setNadRole(n, this);
        } else {
            this.log.log(100000, "PhoneProxy#setNadRole(): Phone not available!");
        }
    }

    public void responseSetNadMode(int n) {
        this.setIdle();
        this.caller.responseSetNadMode(n);
    }

    public void responseChangePhoneModulePowerState(int n) {
        this.setIdle();
        this.caller.responseChangePhoneModulePowerState(n);
    }

    public void responseTogglePhones(int n) {
        this.setIdle();
        this.caller.responseTogglePhones(n);
    }

    public void responseSetNadRole(int n) {
        this.setIdle();
        this.caller.responseSetNadRole(n);
    }

    private void setIdle() {
        this.operationInProgress = false;
    }

    public Object addingService(ServiceReference serviceReference) {
        Object object = this.bundleContext.getService(serviceReference);
        if (object instanceof ITelServiceConnectivity) {
            this.phone = (ITelServiceConnectivity)object;
            return object;
        }
        return null;
    }

    public void removedService(ServiceReference serviceReference, Object object) {
        if (object instanceof ITelServiceConnectivity) {
            this.phone = null;
            this.bundleContext.ungetService(serviceReference);
        }
    }

    public void modifiedService(ServiceReference serviceReference, Object object) {
        if (object instanceof ITelServiceConnectivity) {
            this.phone = (ITelServiceConnectivity)object;
        }
    }

    public void init() {
        this.serviceTracker = new ServiceTracker(this.bundleContext, new String[]{(class$de$audi$atip$phone$ITelServiceConnectivity == null ? (class$de$audi$atip$phone$ITelServiceConnectivity = PhoneProxy.class$("de.audi.atip.phone.ITelServiceConnectivity")) : class$de$audi$atip$phone$ITelServiceConnectivity).getName()}, (ServiceTrackerCustomizer)this);
        this.serviceTracker.open();
    }

    public void deinit() {
        this.phone = null;
        this.serviceTracker.close();
        this.serviceTracker = null;
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

