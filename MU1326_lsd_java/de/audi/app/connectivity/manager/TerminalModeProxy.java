/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.connectivity.manager;

import de.audi.app.connectivity.manager.ConnectivityManager;
import de.audi.atip.interapp.terminalmode.DefaultTerminalModeUpdateListener;
import de.audi.atip.interapp.terminalmode.ITerminalModeUpdateService;
import de.audi.atip.interapp.terminalmode.TerminalModeDevice;
import de.audi.atip.log.LogChannel;
import de.esolutions.fw.util.commons.StringUtils;
import java.util.Dictionary;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;
import org.osgi.framework.ServiceRegistration;
import org.osgi.util.tracker.ServiceTracker;
import org.osgi.util.tracker.ServiceTrackerCustomizer;

class TerminalModeProxy
extends DefaultTerminalModeUpdateListener
implements ServiceTrackerCustomizer {
    private final BundleContext bundleContext;
    private final LogChannel log;
    private final ConnectivityManager coma;
    private TerminalModeDevice carplayActiveDevice;
    private ServiceTracker serviceTracker;
    private ITerminalModeUpdateService service;
    private ServiceRegistration registration;
    private Map smartphones = new HashMap();
    static /* synthetic */ Class class$de$audi$atip$interapp$terminalmode$ITerminalModeUpdateService;
    static /* synthetic */ Class class$de$audi$atip$interapp$terminalmode$ITerminalModeUpdateListener;

    TerminalModeProxy(BundleContext bundleContext, LogChannel logChannel, ConnectivityManager connectivityManager) {
        this.coma = connectivityManager;
        this.bundleContext = bundleContext;
        this.log = logChannel;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    void activateSmartphone(String string) {
        if (this.service != null) {
            Map map = this.smartphones;
            synchronized (map) {
                TerminalModeDevice terminalModeDevice = (TerminalModeDevice)this.smartphones.get(string);
                this.service.activateDevice(terminalModeDevice);
            }
        } else {
            this.log.log(100000, "TerminalModeProxy#activateSmartphone(): no ITerminalModeUpdateService available");
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    void deactivateSmartphone(String string) {
        if (this.service != null) {
            Map map = this.smartphones;
            synchronized (map) {
                TerminalModeDevice terminalModeDevice = (TerminalModeDevice)this.smartphones.get(string);
                this.service.deactivateDevice(terminalModeDevice);
            }
        } else {
            this.log.log(100000, "TerminalModeProxy#deactivateSmartphone(): no ITerminalModeUpdateService available");
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    void deleteSmartphone(String string) {
        if (this.service != null) {
            Map map = this.smartphones;
            synchronized (map) {
                TerminalModeDevice terminalModeDevice = (TerminalModeDevice)this.smartphones.get(string);
                this.service.deleteDeviceFromPersistence(terminalModeDevice);
                if (this.carplayActiveDevice != null && this.carplayActiveDevice.getDeviceUniqueId().equals(string)) {
                    this.carplayActiveDevice = null;
                }
            }
        } else {
            this.log.log(100000, "TerminalModeProxy#deleteSmartphone(): no ITerminalModeUpdateService available");
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void updateDeviceList(TerminalModeDevice[] terminalModeDeviceArray) {
        this.log.log(1000000, "TerminalModeProxy#updateDeviceList(): pDeviceList=%1", (Object)StringUtils.toString(terminalModeDeviceArray));
        if (terminalModeDeviceArray != null) {
            Map map = this.smartphones;
            synchronized (map) {
                this.smartphones.clear();
                for (int i2 = 0; i2 < terminalModeDeviceArray.length; ++i2) {
                    TerminalModeDevice terminalModeDevice = terminalModeDeviceArray[i2];
                    String string = terminalModeDevice != null ? terminalModeDevice.getDeviceUniqueId() : "";
                    this.smartphones.put(string, terminalModeDevice);
                    if (terminalModeDevice == null || !terminalModeDevice.isActive()) continue;
                    this.carplayActiveDevice = terminalModeDevice;
                }
                this.coma.updateSmartphones(terminalModeDeviceArray);
            }
        } else {
            this.log.log(10000, "TerminalModeProxy#updateDeviceList(): pDeviceList is NULL");
        }
    }

    public Object addingService(ServiceReference serviceReference) {
        Object object = this.bundleContext.getService(serviceReference);
        if (object instanceof ITerminalModeUpdateService) {
            this.service = (ITerminalModeUpdateService)object;
            return object;
        }
        return null;
    }

    public void removedService(ServiceReference serviceReference, Object object) {
        if (object instanceof ITerminalModeUpdateService) {
            this.service = null;
            this.bundleContext.ungetService(serviceReference);
        }
    }

    public void modifiedService(ServiceReference serviceReference, Object object) {
        if (object instanceof ITerminalModeUpdateService) {
            this.service = (ITerminalModeUpdateService)object;
        }
    }

    void init() {
        this.serviceTracker = new ServiceTracker(this.bundleContext, new String[]{(class$de$audi$atip$interapp$terminalmode$ITerminalModeUpdateService == null ? (class$de$audi$atip$interapp$terminalmode$ITerminalModeUpdateService = TerminalModeProxy.class$("de.audi.atip.interapp.terminalmode.ITerminalModeUpdateService")) : class$de$audi$atip$interapp$terminalmode$ITerminalModeUpdateService).getName()}, (ServiceTrackerCustomizer)this);
        this.serviceTracker.open();
        this.registration = this.bundleContext.registerService((class$de$audi$atip$interapp$terminalmode$ITerminalModeUpdateListener == null ? (class$de$audi$atip$interapp$terminalmode$ITerminalModeUpdateListener = TerminalModeProxy.class$("de.audi.atip.interapp.terminalmode.ITerminalModeUpdateListener")) : class$de$audi$atip$interapp$terminalmode$ITerminalModeUpdateListener).getName(), (Object)this, (Dictionary)new Hashtable(0));
    }

    void deinit() {
        this.registration.unregister();
        this.registration = null;
        this.service = null;
        this.serviceTracker.close();
        this.serviceTracker = null;
    }

    public TerminalModeDevice getCarplayActiveDevice() {
        return this.carplayActiveDevice;
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

