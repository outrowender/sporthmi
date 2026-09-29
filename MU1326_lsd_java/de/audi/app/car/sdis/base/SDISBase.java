/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.car.sdis.base;

import de.audi.app.car.common.app.CarVMOptions;
import de.audi.app.car.sdis.CarMainASIProvider;
import de.audi.app.car.sdis.base.IDSIObserver;
import de.audi.app.car.sdis.base.ISDISFramework;
import de.audi.app.car.sdis.base.ViewOptionMapper;
import de.audi.app.car.sdis.dsi2asi.GenericDsiAsiHandler;
import de.audi.app.car.sdis.swdiag.CarMenuOperationFlagSimulation;
import de.audi.atip.base.IFrameworkAccess;
import de.audi.atip.log.LogChannel;
import de.audi.atip.sysapp.carcoding.CarFuncAdap;
import java.util.Dictionary;
import java.util.HashMap;
import java.util.Hashtable;
import org.dsi.ifc.base.DSIBase;
import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.caraircondition.DSICarAirCondition;
import org.dsi.ifc.carcomfort.DSICarComfort;
import org.dsi.ifc.cardrivingcharacteristics.DSICarDrivingCharacteristics;
import org.dsi.ifc.carkombi.DSICarKombi;
import org.dsi.ifc.carvehiclestates.DSICarVehicleStates;
import org.dsi.ifc.global.CarViewOption;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;
import org.osgi.framework.ServiceRegistration;
import org.osgi.util.tracker.ServiceTracker;
import org.osgi.util.tracker.ServiceTrackerCustomizer;

public class SDISBase
implements DSIListener,
ISDISFramework,
ServiceTrackerCustomizer {
    private volatile ServiceRegistration serviceReg;
    private ServiceTracker serviceTracker;
    private final IFrameworkAccess framework;
    private final BundleContext context;
    private final LogChannel logger;
    private final ViewOptionMapper viewOptionMapper;
    private final HashMap serviceTrackerMap;
    private HashMap dsiMap;
    private HashMap dsiObserver;
    private CarFuncAdap codingAdapter;
    private CarFuncAdap simulatedCodingAdapter;
    private GenericDsiAsiHandler asiMainHandler;
    private CarMainASIProvider asiProvider;
    static /* synthetic */ Class class$org$dsi$ifc$carvehiclestates$DSICarVehicleStates;
    static /* synthetic */ Class class$org$dsi$ifc$cardrivingcharacteristics$DSICarDrivingCharacteristics;
    static /* synthetic */ Class class$org$dsi$ifc$carcomfort$DSICarComfort;
    static /* synthetic */ Class class$org$dsi$ifc$carkombi$DSICarKombi;
    static /* synthetic */ Class class$org$dsi$ifc$caraircondition$DSICarAirCondition;

    public SDISBase(String string, BundleContext bundleContext, IFrameworkAccess iFrameworkAccess, CarMainASIProvider carMainASIProvider, CarFuncAdap carFuncAdap) {
        this.framework = iFrameworkAccess;
        this.context = bundleContext;
        this.logger = this.framework.getLogChannel(string);
        this.asiProvider = carMainASIProvider;
        this.serviceTrackerMap = new HashMap();
        this.dsiMap = new HashMap();
        this.dsiObserver = new HashMap();
        this.viewOptionMapper = new ViewOptionMapper(this.logger, carFuncAdap);
        this.codingAdapter = carFuncAdap;
        this.asiMainHandler = new GenericDsiAsiHandler(this);
    }

    private void registerServiceImpl(String string, Object object) {
        Hashtable hashtable = new Hashtable();
        hashtable.put("DEVICE_NAME", string);
        hashtable.put("DEVICE_INSTANCE", new Integer(0));
        this.context.registerService(string, object, (Dictionary)hashtable);
        this.logger.log(1078071040, "[SDISBase#registerServiceImpl] class: %1 service: %2", (Object)string, object);
    }

    private void registerDSIImpl(String string, String string2) {
        Hashtable hashtable = new Hashtable();
        hashtable.put("DEVICE_NAME", string2);
        hashtable.put("DEVICE_INSTANCE", new Integer(0));
        this.context.registerService(string2, (Object)this, (Dictionary)hashtable);
        this.logger.log(1078071040, "[SDISBase#registerDSI] class: %1 service: %2", (Object)string2, (Object)this);
        this.serviceTracker = new ServiceTracker(this.context, string, (ServiceTrackerCustomizer)this);
        this.serviceTracker.open();
        this.serviceTrackerMap.put(string, this.serviceTracker);
        this.framework.getStartupMgr().logStartupEvent(new StringBuffer().append("starting DSI ").append(string).toString());
        this.framework.startDSIService(string, 0);
        this.logger.log(1078071040, "[SDISBase#registerDSI] starting DSI %1", (Object)string);
    }

    private void deRegisterServiceImpl(String string) {
    }

    private void deRegisterDSIImpl(String string) {
        Object object;
        DSIBase dSIBase;
        if (this.dsiMap.containsKey(string) && (dSIBase = (DSIBase)this.dsiMap.get(string)) != null) {
            dSIBase.clearNotification(this);
            this.dsiMap.remove(string);
        }
        if (this.serviceTrackerMap.containsKey(string) && (object = (ServiceRegistration)this.serviceTrackerMap.get(string)) != null) {
            object.unregister();
            object = null;
            this.serviceTrackerMap.remove(string);
        }
        if (this.serviceTrackerMap.containsKey(string) && (object = (ServiceTracker)this.serviceTrackerMap.get(string)) != null) {
            ((ServiceTracker)object).close();
            object = null;
            this.serviceTrackerMap.remove(string);
        }
        dSIBase = null;
    }

    @Override
    public Object addingService(ServiceReference serviceReference) {
        BundleContext bundleContext = this.context;
        this.logger.log(-2137614336, "addingService, bundleContext: %1", (Object)bundleContext);
        Object object = bundleContext.getService(serviceReference);
        Object object2 = serviceReference.getProperty("DEVICE_NAME");
        Object object3 = serviceReference.getProperty("DEVICE_INSTANCE");
        this.logger.log(-2137614336, "addingService( deviceName: %1, deviceInstance %2)", object2, object3);
        if (object != null) {
            if (object instanceof DSICarVehicleStates) {
                this.logger.log(1078071040, "[addingService] service is instance of DSICarVehicleStates");
                this.handleDSIService(object, (class$org$dsi$ifc$carvehiclestates$DSICarVehicleStates == null ? (class$org$dsi$ifc$carvehiclestates$DSICarVehicleStates = SDISBase.class$("org.dsi.ifc.carvehiclestates.DSICarVehicleStates")) : class$org$dsi$ifc$carvehiclestates$DSICarVehicleStates).getName());
            } else if (object instanceof DSICarDrivingCharacteristics) {
                this.logger.log(1078071040, "[addingService] service is instance of DSICarDrivingCharacteristics");
                this.handleDSIService(object, (class$org$dsi$ifc$cardrivingcharacteristics$DSICarDrivingCharacteristics == null ? (class$org$dsi$ifc$cardrivingcharacteristics$DSICarDrivingCharacteristics = SDISBase.class$("org.dsi.ifc.cardrivingcharacteristics.DSICarDrivingCharacteristics")) : class$org$dsi$ifc$cardrivingcharacteristics$DSICarDrivingCharacteristics).getName());
            } else if (object instanceof DSICarComfort) {
                this.logger.log(1078071040, "[addingService] service is instance of DSICarComfort");
                this.handleDSIService(object, (class$org$dsi$ifc$carcomfort$DSICarComfort == null ? (class$org$dsi$ifc$carcomfort$DSICarComfort = SDISBase.class$("org.dsi.ifc.carcomfort.DSICarComfort")) : class$org$dsi$ifc$carcomfort$DSICarComfort).getName());
            } else if (object instanceof DSICarKombi) {
                this.logger.log(1078071040, "[addingService] service is instance of DSICarKombi");
                this.handleDSIService(object, (class$org$dsi$ifc$carkombi$DSICarKombi == null ? (class$org$dsi$ifc$carkombi$DSICarKombi = SDISBase.class$("org.dsi.ifc.carkombi.DSICarKombi")) : class$org$dsi$ifc$carkombi$DSICarKombi).getName());
            } else if (object instanceof DSICarAirCondition) {
                this.logger.log(1078071040, "[addingService] service is instance of DSICarAirCondition");
                this.handleDSIService(object, (class$org$dsi$ifc$caraircondition$DSICarAirCondition == null ? (class$org$dsi$ifc$caraircondition$DSICarAirCondition = SDISBase.class$("org.dsi.ifc.caraircondition.DSICarAirCondition")) : class$org$dsi$ifc$caraircondition$DSICarAirCondition).getName());
            }
        }
        return object;
    }

    private void handleDSIService(Object object, Object object2) {
        DSIBase dSIBase = (DSIBase)object;
        if (!this.dsiMap.containsKey(object2)) {
            this.dsiMap.put(object2, dSIBase);
            if (this.dsiObserver.containsKey(object2)) {
                IDSIObserver iDSIObserver = (IDSIObserver)this.dsiObserver.get(object2);
                this.logger.log(1078071040, "[handleDSIService] found observer.");
                iDSIObserver.setDSI(dSIBase);
            }
        } else {
            this.logger.log(1078071040, "[handleDSIService] is in dsiMap %1", this.dsiMap.get(object2));
        }
    }

    @Override
    public void modifiedService(ServiceReference serviceReference, Object object) {
    }

    @Override
    public void removedService(ServiceReference serviceReference, Object object) {
        Object object2 = this.context.getService(serviceReference);
        Object object3 = serviceReference.getProperty("DEVICE_NAME");
        Object object4 = serviceReference.getProperty("DEVICE_INSTANCE");
        this.logger.log(-2137614336, "removedService( deviceName: %1, deviceInstance %2)", object3, object4);
        if (object2 instanceof DSIBase) {
            this.logger.log(-2137614336, "removedService dsi %1", object2);
            this.dsiMap.remove(object3);
            this.context.ungetService(serviceReference);
        }
    }

    @Override
    public IFrameworkAccess getHMIFramework() {
        return this.framework;
    }

    @Override
    public LogChannel getLogChannel(String string) {
        return this.framework.getLogChannel(string);
    }

    @Override
    public void registerService(String string, Object object) {
        this.registerServiceImpl(string, object);
    }

    @Override
    public void deRegisterDSI(String string) {
        this.deRegisterDSIImpl(string);
    }

    @Override
    public void registerDSI(String string, String string2, IDSIObserver iDSIObserver) {
        this.dsiObserver.put(string, iDSIObserver);
        this.registerDSIImpl(string, string2);
    }

    @Override
    public void deRegisterService(String string) {
        this.deRegisterServiceImpl(string);
    }

    @Override
    public BundleContext getBundleContext() {
        return this.context;
    }

    @Override
    public CarMainASIProvider getASIDataUpdater() {
        return this.asiProvider;
    }

    @Override
    public int updateVisibility(CarViewOption carViewOption, short s) {
        if (s == 128 || this.codingAdapter.isMenuDisplayActivated(s)) {
            return this.viewOptionMapper.getVisibilityState(carViewOption);
        }
        return 0;
    }

    @Override
    public int getVisibilityMainState(CarViewOption[] carViewOptionArray) {
        return this.viewOptionMapper.getVisibilityState(carViewOptionArray);
    }

    @Override
    public void asyncException(int n, String string, int n2) {
    }

    public DSIBase getDSI(String string) {
        return (DSIBase)this.dsiMap.get(string);
    }

    @Override
    public CarFuncAdap getCarAdaption() {
        if (CarVMOptions.carFuncAdapSimulated()) {
            if (this.simulatedCodingAdapter == null) {
                this.simulatedCodingAdapter = new CarMenuOperationFlagSimulation(5);
                return this.simulatedCodingAdapter;
            }
            return this.simulatedCodingAdapter;
        }
        return this.codingAdapter;
    }

    @Override
    public GenericDsiAsiHandler getDsiAsiHandler() {
        return this.asiMainHandler;
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

