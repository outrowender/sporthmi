/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.car.sdis;

import de.audi.app.car.sdis.CarMainASIProvider;
import de.audi.app.car.sdis.SDISCarManager;
import de.audi.app.car.sdis.mainunit.InterAppSDISDistributor;
import de.audi.app.car.sdis.swdiag.SDISCarDiag;
import de.audi.atip.activator.AbstractActivator;
import de.audi.atip.diag.sw.SwDiagnosisManager;
import de.audi.atip.log.LogChannel;
import de.audi.atip.log.NullLogChannel;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;
import org.osgi.util.tracker.ServiceTracker;
import org.osgi.util.tracker.ServiceTrackerCustomizer;

public class CarSDISActivator
extends AbstractActivator
implements ServiceTrackerCustomizer {
    private LogChannel log = NullLogChannel.getInstance();
    private SDISCarDiag sdisCarDiag;
    private InterAppSDISDistributor updater;
    private SDISCarManager carDataManager;
    private ServiceTracker tracker;
    private CarMainASIProvider carMainProvider;
    static /* synthetic */ Class class$de$audi$app$car$common$sdis$interapp$ISDISCarInfoDistributor;
    static /* synthetic */ Class class$de$audi$atip$diag$sw$SwDiagnosisManager;

    @Override
    public void start(BundleContext bundleContext) {
        super.start(bundleContext);
        this.log = this.getFramework().getLogChannel("App.CarSDIS.Main");
        if (!this.getFramework().isSDISEnabled()) {
            this.log.log(1078071040, "SDIS is not enabled, do not start bundle.");
            return;
        }
        this.carMainProvider = new CarMainASIProvider(this.log);
        this.carDataManager = new SDISCarManager(this.log, bundleContext, this.getFramework(), this.carMainProvider);
        this.carDataManager.init();
        this.tracker = new ServiceTracker(bundleContext, new String[]{(class$de$audi$app$car$common$sdis$interapp$ISDISCarInfoDistributor == null ? (class$de$audi$app$car$common$sdis$interapp$ISDISCarInfoDistributor = CarSDISActivator.class$("de.audi.app.car.common.sdis.interapp.ISDISCarInfoDistributor")) : class$de$audi$app$car$common$sdis$interapp$ISDISCarInfoDistributor).getName(), (class$de$audi$atip$diag$sw$SwDiagnosisManager == null ? (class$de$audi$atip$diag$sw$SwDiagnosisManager = CarSDISActivator.class$("de.audi.atip.diag.sw.SwDiagnosisManager")) : class$de$audi$atip$diag$sw$SwDiagnosisManager).getName()}, (ServiceTrackerCustomizer)this);
        this.tracker.open();
        this.updater = new InterAppSDISDistributor(this.log, this.carDataManager);
        this.registerService((class$de$audi$app$car$common$sdis$interapp$ISDISCarInfoDistributor == null ? (class$de$audi$app$car$common$sdis$interapp$ISDISCarInfoDistributor = CarSDISActivator.class$("de.audi.app.car.common.sdis.interapp.ISDISCarInfoDistributor")) : class$de$audi$app$car$common$sdis$interapp$ISDISCarInfoDistributor).getName(), (Object)this.updater, null);
        this.carMainProvider.registerServices(this);
        this.log.log(1078071040, "AppCarSDIS bundle started");
    }

    @Override
    public void stop(BundleContext bundleContext) {
        if (this.tracker != null) {
            this.tracker.close();
            this.tracker = null;
        }
        super.stop(bundleContext);
        this.carDataManager.deinit();
        this.carMainProvider = null;
        this.log.log(1078071040, "AppCarSDIS bundle stopped");
    }

    @Override
    public Object addingService(ServiceReference serviceReference) {
        Object object = this.bundleContext.getService(serviceReference);
        if (object != null) {
            this.log.log(1078071040, "CarSDISActivator#addingService( %1 )", object);
            if (object instanceof InterAppSDISDistributor) {
                this.updater = (InterAppSDISDistributor)object;
                this.updater.serviceAvailable(this.updater);
                if (this.sdisCarDiag == null) {
                    this.sdisCarDiag = new SDISCarDiag(this.framework);
                    this.sdisCarDiag.init(this.updater);
                    this.sdisCarDiag.setCarManager(this.carDataManager);
                }
            } else if (object instanceof SwDiagnosisManager) {
                if (this.sdisCarDiag == null) {
                    this.sdisCarDiag = new SDISCarDiag(this.framework);
                    this.sdisCarDiag.init(this.updater);
                    this.sdisCarDiag.setCarManager(this.carDataManager);
                }
                this.log.log(1078071040, "CarSDISActivator#addingService( %1 )", object);
                ((SwDiagnosisManager)object).addDiagGateway(this.sdisCarDiag);
            } else {
                this.bundleContext.ungetService(serviceReference);
                return null;
            }
        }
        return object;
    }

    @Override
    public void modifiedService(ServiceReference serviceReference, Object object) {
    }

    @Override
    public void removedService(ServiceReference serviceReference, Object object) {
        if (object instanceof InterAppSDISDistributor) {
            this.updater.deinit();
            this.updater = null;
        } else if (object instanceof SwDiagnosisManager) {
            ((SwDiagnosisManager)object).removeDiagGateway(this.sdisCarDiag);
            this.sdisCarDiag = null;
        }
        this.bundleContext.ungetService(serviceReference);
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

