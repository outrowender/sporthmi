/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  de.mib.swdiagnosis.car.evo.CarEvoDiagnosis
 *  de.mib.swdiagnosis.car.evo.CarEvoDiagnosisFAS
 */
package de.audi.app.car;

import de.audi.app.car.common.app.CarVMOptions;
import de.audi.app.car.common.app.ICarApplication;
import de.audi.app.car.evo.app.CarEvoApplication;
import de.audi.atip.activator.AbstractActivator;
import de.audi.atip.diag.sw.AbstractSwDiagnosis;
import de.audi.atip.diag.sw.SwDiagnosisManager;
import de.mib.swdiagnosis.car.evo.CarEvoDiagnosis;
import de.mib.swdiagnosis.car.evo.CarEvoDiagnosisFAS;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;
import org.osgi.util.tracker.ServiceTracker;
import org.osgi.util.tracker.ServiceTrackerCustomizer;

public class CarActivator
extends AbstractActivator
implements ServiceTrackerCustomizer {
    private static final String LOG_CHANNEL_NAME;
    private ICarApplication carApplication;
    private ServiceTracker serviceTracker;
    private CarEvoDiagnosis diagGWCar;
    private CarEvoDiagnosisFAS diagGWCarFAS;
    static /* synthetic */ Class class$de$audi$atip$base$IFrameworkAccess;
    static /* synthetic */ Class class$org$osgi$framework$BundleContext;
    static /* synthetic */ Class class$de$audi$atip$diag$sw$SwDiagnosisManager;

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void start(BundleContext bundleContext) {
        super.start(bundleContext);
        if (CarVMOptions.carFuncAdapSimulated()) {
            this.getFramework().getLogChannel("App.Car.Activator").log(1078071040, "[CarActivator] FuncAdapSimulated-VM-Flag is set, activating Simulation.");
            try {
                Class clazz = Class.forName("de.mib.swdiagnosis.car.evo.SimulatedCarEvoApplication");
                Constructor constructor = clazz.getConstructor(new Class[]{class$de$audi$atip$base$IFrameworkAccess == null ? (class$de$audi$atip$base$IFrameworkAccess = CarActivator.class$("de.audi.atip.base.IFrameworkAccess")) : class$de$audi$atip$base$IFrameworkAccess, class$org$osgi$framework$BundleContext == null ? (class$org$osgi$framework$BundleContext = CarActivator.class$("org.osgi.framework.BundleContext")) : class$org$osgi$framework$BundleContext});
                this.carApplication = (ICarApplication)constructor.newInstance(new Object[]{this.getFramework(), bundleContext});
                this.getFramework().getLogChannel("App.Car.Activator").log(1078071040, "[CarActivator] Simulation of Car Features activated");
            }
            catch (ClassNotFoundException classNotFoundException) {
                this.getFramework().getLogChannel("App.Car.Activator").log(1078071040, "[CarActivator] FuncAdapSimulated-VM-Flag is set, but cannot find Simulated Application. Using Standard.", (Throwable)classNotFoundException);
            }
            catch (SecurityException securityException) {
                this.getFramework().getLogChannel("App.Car.Activator").log(1078071040, "[CarActivator] FuncAdapSimulated-VM-Flag is set, but cannot get Constructor because of security Concerns", (Throwable)securityException);
            }
            catch (NoSuchMethodException noSuchMethodException) {
                this.getFramework().getLogChannel("App.Car.Activator").log(1078071040, "[CarActivator] FuncAdapSimulated-VM-Flag is set, but cannot get Constructor because there is no constructor with matching signature", (Throwable)noSuchMethodException);
            }
            catch (IllegalArgumentException illegalArgumentException) {
                this.getFramework().getLogChannel("App.Car.Activator").log(1078071040, "[CarActivator] FuncAdapSimulated-VM-Flag is set, but cannot cannot call constructor with this type of argument", (Throwable)illegalArgumentException);
            }
            catch (InstantiationException instantiationException) {
                this.getFramework().getLogChannel("App.Car.Activator").log(1078071040, "[CarActivator] FuncAdapSimulated-VM-Flag is set, but cannot instantiate Simulated Application. Using Standard.", (Throwable)instantiationException);
            }
            catch (IllegalAccessException illegalAccessException) {
                this.getFramework().getLogChannel("App.Car.Activator").log(1078071040, "[CarActivator] FuncAdapSimulated-VM-Flag is set, but cannot access Simulated Application. Using Standard.", (Throwable)illegalAccessException);
            }
            catch (InvocationTargetException invocationTargetException) {
                this.getFramework().getLogChannel("App.Car.Activator").log(1078071040, "[CarActivator] FuncAdapSimulated-VM-Flag is set, but Constructor does not like to be called.", (Throwable)invocationTargetException);
            }
            finally {
                if (this.carApplication == null) {
                    this.carApplication = new CarEvoApplication(this.getFramework(), bundleContext);
                }
            }
        } else {
            this.carApplication = new CarEvoApplication(this.getFramework(), bundleContext);
        }
        this.carApplication.init();
        this.initTracker();
    }

    @Override
    public void stop(BundleContext bundleContext) {
        super.stop(bundleContext);
        this.carApplication.deinit();
        this.deinitTracker();
    }

    private void initTracker() {
        this.serviceTracker = new ServiceTracker(this.bundleContext, (class$de$audi$atip$diag$sw$SwDiagnosisManager == null ? (class$de$audi$atip$diag$sw$SwDiagnosisManager = CarActivator.class$("de.audi.atip.diag.sw.SwDiagnosisManager")) : class$de$audi$atip$diag$sw$SwDiagnosisManager).getName(), (ServiceTrackerCustomizer)this);
        this.serviceTracker.open();
    }

    private void deinitTracker() {
        this.serviceTracker = this.closeTracker(this.serviceTracker);
    }

    @Override
    public Object addingService(ServiceReference serviceReference) {
        Object object = this.bundleContext.getService(serviceReference);
        if (object instanceof SwDiagnosisManager) {
            this.diagGWCar = new CarEvoDiagnosis(this.carApplication);
            this.diagGWCarFAS = new CarEvoDiagnosisFAS(this.carApplication);
            ((SwDiagnosisManager)object).addDiagGateway((AbstractSwDiagnosis)this.diagGWCar);
            ((SwDiagnosisManager)object).addDiagGateway((AbstractSwDiagnosis)this.diagGWCarFAS);
        }
        return object;
    }

    @Override
    public void modifiedService(ServiceReference serviceReference, Object object) {
    }

    @Override
    public void removedService(ServiceReference serviceReference, Object object) {
        if (object instanceof SwDiagnosisManager) {
            this.diagGWCar = null;
            this.diagGWCarFAS = null;
            this.getBundleContext().ungetService(serviceReference);
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

