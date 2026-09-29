/*
 * Decompiled with CFR 0.152.
 */
package de.audi.swdiagnosis.media.dsi;

import de.audi.app.media.osgi.IServiceManager;
import de.audi.atip.diag.sw.SwDiagnosisManager;
import de.audi.swdiagnosis.media.dsi.MediaDSISimulation;
import de.audi.swdiagnosis.media.dsi.MediaDSISimulationActivator;
import org.osgi.framework.ServiceReference;
import org.osgi.util.tracker.ServiceTrackerCustomizer;

class MediaDSISimulationActivator$1
implements ServiceTrackerCustomizer {
    private final /* synthetic */ IServiceManager val$serviceManager;
    private final /* synthetic */ MediaDSISimulationActivator this$0;

    MediaDSISimulationActivator$1(MediaDSISimulationActivator mediaDSISimulationActivator, IServiceManager iServiceManager) {
        this.this$0 = mediaDSISimulationActivator;
        this.val$serviceManager = iServiceManager;
    }

    @Override
    public Object addingService(ServiceReference serviceReference) {
        SwDiagnosisManager swDiagnosisManager = (SwDiagnosisManager)this.val$serviceManager.getService(serviceReference);
        MediaDSISimulationActivator.access$002(this.this$0, new MediaDSISimulation(this.val$serviceManager));
        swDiagnosisManager.addDiagGateway(MediaDSISimulationActivator.access$000(this.this$0));
        return swDiagnosisManager;
    }

    @Override
    public void removedService(ServiceReference serviceReference, Object object) {
        ((SwDiagnosisManager)object).removeDiagGateway(MediaDSISimulationActivator.access$000(this.this$0));
        this.val$serviceManager.releaseService(serviceReference);
    }

    @Override
    public void modifiedService(ServiceReference serviceReference, Object object) {
    }
}

