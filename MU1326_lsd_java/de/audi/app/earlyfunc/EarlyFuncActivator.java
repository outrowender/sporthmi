/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  de.mib.swdiagnosis.earlyfunc.evo.EarlyFuncEvoDiagnosis
 */
package de.audi.app.earlyfunc;

import de.audi.app.car.common.app.CarVMOptions;
import de.audi.app.car.common.app.ICarApplication;
import de.audi.app.earlyfunc.evo.app.EarlyFuncEvoApplication;
import de.audi.atip.activator.AbstractActivator;
import de.audi.atip.diag.sw.AbstractSwDiagnosis;
import de.audi.atip.diag.sw.SwDiagnosisManager;
import de.mib.swdiagnosis.earlyfunc.evo.EarlyFuncEvoDiagnosis;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;
import org.osgi.util.tracker.ServiceTracker;
import org.osgi.util.tracker.ServiceTrackerCustomizer;

public class EarlyFuncActivator
extends AbstractActivator
implements ServiceTrackerCustomizer {
    private static final String LOG_CHANNEL_NAME = "App.EarlyFunc.Activator";
    private ICarApplication earlyFuncApplication;
    private ServiceTracker serviceTracker;
    private EarlyFuncEvoDiagnosis diagGWEarlyFunc;
    static /* synthetic */ Class class$de$audi$atip$base$IFrameworkAccess;
    static /* synthetic */ Class class$org$osgi$framework$BundleContext;
    static /* synthetic */ Class class$de$audi$atip$diag$sw$SwDiagnosisManager;

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void start(BundleContext bundleContext) {
        super.start(bundleContext);
        if (CarVMOptions.carFuncAdapSimulated()) {
            this.getFramework().getLogChannel(LOG_CHANNEL_NAME).log(1000000, "[CarActivator] FuncAdapSimulated-VM-Flag is set, activating Simulation.");
            try {
                Class clazz = Class.forName("de.mib.swdiagnosis.earlyfunc.evo.SimulatedEarlyFuncApplication");
                Constructor constructor = clazz.getConstructor(new Class[]{class$de$audi$atip$base$IFrameworkAccess == null ? (class$de$audi$atip$base$IFrameworkAccess = EarlyFuncActivator.class$("de.audi.atip.base.IFrameworkAccess")) : class$de$audi$atip$base$IFrameworkAccess, class$org$osgi$framework$BundleContext == null ? (class$org$osgi$framework$BundleContext = EarlyFuncActivator.class$("org.osgi.framework.BundleContext")) : class$org$osgi$framework$BundleContext});
                this.earlyFuncApplication = (ICarApplication)constructor.newInstance(new Object[]{this.getFramework(), bundleContext});
                this.getFramework().getLogChannel(LOG_CHANNEL_NAME).log(1000000, "[EarlyFuncActivator] Simulation of Car Features activated");
            }
            catch (ClassNotFoundException classNotFoundException) {
                this.getFramework().getLogChannel(LOG_CHANNEL_NAME).log(1000000, "[EarlyFuncActivator] FuncAdapSimulated-VM-Flag is set, but cannot find Simulated Application. Using Standard.", (Throwable)classNotFoundException);
            }
            catch (SecurityException securityException) {
                this.getFramework().getLogChannel(LOG_CHANNEL_NAME).log(1000000, "[EarlyFuncActivator] FuncAdapSimulated-VM-Flag is set, but cannot get Constructor because of security Concerns", (Throwable)securityException);
            }
            catch (NoSuchMethodException noSuchMethodException) {
                this.getFramework().getLogChannel(LOG_CHANNEL_NAME).log(1000000, "[EarlyFuncActivator] FuncAdapSimulated-VM-Flag is set, but cannot get Constructor because there is no constructor with matching signature", (Throwable)noSuchMethodException);
            }
            catch (IllegalArgumentException illegalArgumentException) {
                this.getFramework().getLogChannel(LOG_CHANNEL_NAME).log(1000000, "[EarlyFuncActivator] FuncAdapSimulated-VM-Flag is set, but cannot cannot call constructor with this type of argument", (Throwable)illegalArgumentException);
            }
            catch (InstantiationException instantiationException) {
                this.getFramework().getLogChannel(LOG_CHANNEL_NAME).log(1000000, "[EarlyFuncActivator] FuncAdapSimulated-VM-Flag is set, but cannot instantiate Simulated Application. Using Standard.", (Throwable)instantiationException);
            }
            catch (IllegalAccessException illegalAccessException) {
                this.getFramework().getLogChannel(LOG_CHANNEL_NAME).log(1000000, "[EarlyFuncActivator] FuncAdapSimulated-VM-Flag is set, but cannot access Simulated Application. Using Standard.", (Throwable)illegalAccessException);
            }
            catch (InvocationTargetException invocationTargetException) {
                this.getFramework().getLogChannel(LOG_CHANNEL_NAME).log(1000000, "[EarlyFuncActivator] FuncAdapSimulated-VM-Flag is set, but Constructor does not like to be called.", (Throwable)invocationTargetException);
            }
            finally {
                if (this.earlyFuncApplication == null) {
                    this.earlyFuncApplication = new EarlyFuncEvoApplication(this.getFramework(), bundleContext);
                }
            }
        } else {
            this.earlyFuncApplication = new EarlyFuncEvoApplication(this.getFramework(), bundleContext);
        }
        this.earlyFuncApplication.init();
        this.initTracker();
    }

    public void stop(BundleContext bundleContext) {
        super.stop(bundleContext);
        this.earlyFuncApplication.deinit();
        this.deinitTracker();
    }

    private void initTracker() {
        this.serviceTracker = new ServiceTracker(this.bundleContext, (class$de$audi$atip$diag$sw$SwDiagnosisManager == null ? (class$de$audi$atip$diag$sw$SwDiagnosisManager = EarlyFuncActivator.class$("de.audi.atip.diag.sw.SwDiagnosisManager")) : class$de$audi$atip$diag$sw$SwDiagnosisManager).getName(), (ServiceTrackerCustomizer)this);
        this.serviceTracker.open();
    }

    private void deinitTracker() {
        this.serviceTracker = this.closeTracker(this.serviceTracker);
    }

    public Object addingService(ServiceReference serviceReference) {
        Object object = this.bundleContext.getService(serviceReference);
        if (object instanceof SwDiagnosisManager) {
            this.diagGWEarlyFunc = new EarlyFuncEvoDiagnosis(this.earlyFuncApplication);
            ((SwDiagnosisManager)object).addDiagGateway((AbstractSwDiagnosis)this.diagGWEarlyFunc);
        }
        return object;
    }

    public void modifiedService(ServiceReference serviceReference, Object object) {
    }

    public void removedService(ServiceReference serviceReference, Object object) {
        if (object instanceof SwDiagnosisManager) {
            this.diagGWEarlyFunc = null;
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

