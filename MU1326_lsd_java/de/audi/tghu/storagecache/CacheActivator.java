/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.storagecache;

import de.audi.atip.activator.AbstractFrameworkActivator;
import de.audi.atip.base.FwServices;
import de.audi.atip.interapp.online.IOnlineService;
import de.audi.atip.log.LogChannel;
import de.audi.atip.storagecache.CacheEventListener;
import de.audi.tghu.storagecache.CacheHandlerImpl;
import java.util.ArrayList;
import java.util.Dictionary;
import java.util.Hashtable;
import org.dsi.ifc.carvehiclestates.DSICarVehicleStates;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;
import org.osgi.framework.ServiceRegistration;
import org.osgi.util.tracker.ServiceTracker;
import org.osgi.util.tracker.ServiceTrackerCustomizer;

public class CacheActivator
extends AbstractFrameworkActivator
implements ServiceTrackerCustomizer {
    private ServiceTracker tracker;
    private CacheHandlerImpl cacheHandler;
    private LogChannel log;
    private ServiceRegistration sRegCVState;
    private BundleContext context;
    private ArrayList sRegOTCWStates = new ArrayList();
    static /* synthetic */ Class class$org$dsi$ifc$carvehiclestates$DSICarVehicleStatesListener;
    static /* synthetic */ Class class$org$dsi$ifc$base$DSIListener;
    static /* synthetic */ Class class$de$audi$atip$interapp$online$IOnlineService;
    static /* synthetic */ Class class$org$dsi$ifc$carvehiclestates$DSICarVehicleStates;
    static /* synthetic */ Class class$de$audi$atip$storagecache$CacheEventListener;
    static /* synthetic */ Class class$de$audi$atip$msg$MsgListener;

    public CacheActivator(FwServices fwServices) {
        super("FwCache");
    }

    public CacheHandlerImpl getService() {
        return this.cacheHandler;
    }

    @Override
    protected void startInternal(BundleContext bundleContext) {
        this.log = this.framework.getLogChannel("Fw.Cache.Activator");
        this.cacheHandler = new CacheHandlerImpl(this.framework);
        Hashtable hashtable = new Hashtable();
        ((Dictionary)hashtable).put("DEVICE_NAME", (class$org$dsi$ifc$carvehiclestates$DSICarVehicleStatesListener == null ? (class$org$dsi$ifc$carvehiclestates$DSICarVehicleStatesListener = CacheActivator.class$("org.dsi.ifc.carvehiclestates.DSICarVehicleStatesListener")) : class$org$dsi$ifc$carvehiclestates$DSICarVehicleStatesListener).getName());
        ((Dictionary)hashtable).put("DEVICE_INSTANCE", new Integer(0));
        this.sRegCVState = bundleContext.registerService((class$org$dsi$ifc$base$DSIListener == null ? (class$org$dsi$ifc$base$DSIListener = CacheActivator.class$("org.dsi.ifc.base.DSIListener")) : class$org$dsi$ifc$base$DSIListener).getName(), (Object)this.cacheHandler.getWorker("service_dsi_presetlayout"), (Dictionary)hashtable);
        this.context = bundleContext;
        String[] stringArray = new String[]{(class$de$audi$atip$interapp$online$IOnlineService == null ? (class$de$audi$atip$interapp$online$IOnlineService = CacheActivator.class$("de.audi.atip.interapp.online.IOnlineService")) : class$de$audi$atip$interapp$online$IOnlineService).getName(), (class$org$dsi$ifc$carvehiclestates$DSICarVehicleStates == null ? (class$org$dsi$ifc$carvehiclestates$DSICarVehicleStates = CacheActivator.class$("org.dsi.ifc.carvehiclestates.DSICarVehicleStates")) : class$org$dsi$ifc$carvehiclestates$DSICarVehicleStates).getName(), (class$de$audi$atip$storagecache$CacheEventListener == null ? (class$de$audi$atip$storagecache$CacheEventListener = CacheActivator.class$("de.audi.atip.storagecache.CacheEventListener")) : class$de$audi$atip$storagecache$CacheEventListener).getName()};
        this.tracker = new ServiceTracker(bundleContext, stringArray, (ServiceTrackerCustomizer)this);
        this.tracker.open();
        this.framework.startDSIService((class$org$dsi$ifc$carvehiclestates$DSICarVehicleStates == null ? (class$org$dsi$ifc$carvehiclestates$DSICarVehicleStates = CacheActivator.class$("org.dsi.ifc.carvehiclestates.DSICarVehicleStates")) : class$org$dsi$ifc$carvehiclestates$DSICarVehicleStates).getName(), 0);
    }

    @Override
    public void stop(BundleContext bundleContext) {
        if (this.sRegCVState != null) {
            this.sRegCVState.unregister();
            this.sRegCVState = null;
        }
        if (this.sRegOTCWStates != null) {
            for (int i2 = 0; i2 < this.sRegOTCWStates.size(); ++i2) {
                Object object = this.sRegOTCWStates.get(i2);
                if (!(object instanceof ServiceRegistration)) continue;
                ServiceRegistration serviceRegistration = (ServiceRegistration)object;
                serviceRegistration.unregister();
            }
            this.sRegOTCWStates.clear();
        }
        if (this.tracker != null) {
            this.tracker.close();
            this.tracker = null;
        }
        this.log = null;
        super.stop(bundleContext);
    }

    @Override
    public Object addingService(ServiceReference serviceReference) {
        Object object = this.bundleContext.getService(serviceReference);
        if (object instanceof IOnlineService) {
            String string = (String)serviceReference.getProperty("ONLINE_APP_ID");
            this.log.log(1078071040, "Setting Service=%1 ServiceID = %2", object, (Object)string);
            if (!this.cacheHandler.registerService(object, string)) {
                this.bundleContext.ungetService(serviceReference);
                return null;
            }
            this.registerOTCWMsgListener(this.context, string);
        } else if (object instanceof DSICarVehicleStates) {
            this.log.log(1078071040, "Setting DSI Service=%1 ServiceID = %2", object, (Object)"service_dsi_presetlayout");
            if (!this.cacheHandler.registerService(object, "service_dsi_presetlayout")) {
                this.bundleContext.ungetService(serviceReference);
                return null;
            }
        } else if (object instanceof CacheEventListener) {
            this.log.log(1078071040, "Adding Service=%1", object);
            this.cacheHandler.addListener((CacheEventListener)object);
        } else {
            this.log.log(10000, "track unwanted service=%1", object);
            this.getBundleContext().ungetService(serviceReference);
            return null;
        }
        return object;
    }

    @Override
    public void modifiedService(ServiceReference serviceReference, Object object) {
    }

    @Override
    public void removedService(ServiceReference serviceReference, Object object) {
        if (object instanceof CacheEventListener) {
            this.log.log(1078071040, "Removing Service=%1", object);
            this.cacheHandler.removeListener((CacheEventListener)object);
        }
        this.bundleContext.ungetService(serviceReference);
    }

    protected void registerOTCWMsgListener(BundleContext bundleContext, String string) {
        if (string == null) {
            this.log.log(-1601830656, "CacheActivator#registerOTCWMsgListener(): serviceId is null.");
        }
        if (bundleContext == null) {
            this.log.log(-1601830656, "CacheActivator#registerOTCWMsgListener(): Context is null. %1 not registered as message listener.", (Object)string);
        }
        Hashtable hashtable = new Hashtable();
        hashtable.put("ApplicationName", "AppOnline");
        hashtable.put("moduleID", new Integer(23));
        this.sRegOTCWStates.add(bundleContext.registerService((class$de$audi$atip$msg$MsgListener == null ? (class$de$audi$atip$msg$MsgListener = CacheActivator.class$("de.audi.atip.msg.MsgListener")) : class$de$audi$atip$msg$MsgListener).getName(), (Object)this.cacheHandler.getWorker(string), (Dictionary)hashtable));
        this.log.log(1078071040, "CacheActivator#registerOTCWMsgListener(): Register %1 as message listener.", (Object)string);
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

