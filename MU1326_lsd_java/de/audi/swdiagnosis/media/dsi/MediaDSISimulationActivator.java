/*
 * Decompiled with CFR 0.152.
 */
package de.audi.swdiagnosis.media.dsi;

import de.audi.app.media.osgi.IServiceTracker;
import de.audi.app.media.osgi.ServiceManagerImpl;
import de.audi.atip.activator.AbstractActivator;
import de.audi.atip.diag.sw.SwDiagnosisManager;
import de.audi.swdiagnosis.media.dsi.MediaDSISimulation;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;
import org.osgi.util.tracker.ServiceTrackerCustomizer;

public class MediaDSISimulationActivator
extends AbstractActivator {
    private IServiceTracker diagGatewayTracker;
    private MediaDSISimulation simulation;
    static /* synthetic */ Class class$de$audi$atip$diag$sw$SwDiagnosisManager;

    public void start(BundleContext bundleContext) {
        super.start(bundleContext);
        final ServiceManagerImpl serviceManagerImpl = new ServiceManagerImpl(bundleContext, this.getFramework());
        this.diagGatewayTracker = serviceManagerImpl.createServiceTracker(class$de$audi$atip$diag$sw$SwDiagnosisManager == null ? (class$de$audi$atip$diag$sw$SwDiagnosisManager = MediaDSISimulationActivator.class$("de.audi.atip.diag.sw.SwDiagnosisManager")) : class$de$audi$atip$diag$sw$SwDiagnosisManager, new ServiceTrackerCustomizer(){

            public Object addingService(ServiceReference serviceReference) {
                SwDiagnosisManager swDiagnosisManager = (SwDiagnosisManager)serviceManagerImpl.getService(serviceReference);
                MediaDSISimulationActivator.this.simulation = new MediaDSISimulation(serviceManagerImpl);
                swDiagnosisManager.addDiagGateway(MediaDSISimulationActivator.this.simulation);
                return swDiagnosisManager;
            }

            public void removedService(ServiceReference serviceReference, Object object) {
                ((SwDiagnosisManager)object).removeDiagGateway(MediaDSISimulationActivator.this.simulation);
                serviceManagerImpl.releaseService(serviceReference);
            }

            public void modifiedService(ServiceReference serviceReference, Object object) {
            }
        });
        this.diagGatewayTracker.open();
    }

    public void stop(BundleContext bundleContext) {
        this.diagGatewayTracker.close();
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

