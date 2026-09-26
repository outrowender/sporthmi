/*
 * Decompiled with CFR 0.152.
 */
package de.audi.swdiagnosis.media.dsi;

import de.audi.app.media.osgi.IServiceTracker;
import de.audi.app.media.osgi.ServiceManagerImpl;
import de.audi.atip.activator.AbstractActivator;
import de.audi.swdiagnosis.media.dsi.MediaDSISimulation;
import de.audi.swdiagnosis.media.dsi.MediaDSISimulationActivator$1;
import org.osgi.framework.BundleContext;

public class MediaDSISimulationActivator
extends AbstractActivator {
    private IServiceTracker diagGatewayTracker;
    private MediaDSISimulation simulation;
    static /* synthetic */ Class class$de$audi$atip$diag$sw$SwDiagnosisManager;

    @Override
    public void start(BundleContext bundleContext) {
        super.start(bundleContext);
        ServiceManagerImpl serviceManagerImpl = new ServiceManagerImpl(bundleContext, this.getFramework());
        this.diagGatewayTracker = serviceManagerImpl.createServiceTracker(class$de$audi$atip$diag$sw$SwDiagnosisManager == null ? (class$de$audi$atip$diag$sw$SwDiagnosisManager = MediaDSISimulationActivator.class$("de.audi.atip.diag.sw.SwDiagnosisManager")) : class$de$audi$atip$diag$sw$SwDiagnosisManager, new MediaDSISimulationActivator$1(this, serviceManagerImpl));
        this.diagGatewayTracker.open();
    }

    @Override
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

    static /* synthetic */ MediaDSISimulation access$002(MediaDSISimulationActivator mediaDSISimulationActivator, MediaDSISimulation mediaDSISimulation) {
        mediaDSISimulationActivator.simulation = mediaDSISimulation;
        return mediaDSISimulationActivator.simulation;
    }

    static /* synthetic */ MediaDSISimulation access$000(MediaDSISimulationActivator mediaDSISimulationActivator) {
        return mediaDSISimulationActivator.simulation;
    }
}

