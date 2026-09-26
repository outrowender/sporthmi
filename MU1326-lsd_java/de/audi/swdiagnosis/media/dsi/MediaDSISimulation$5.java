/*
 * Decompiled with CFR 0.152.
 */
package de.audi.swdiagnosis.media.dsi;

import de.audi.atip.interapp.IEjectHandler;
import de.audi.swdiagnosis.media.dsi.MediaDSISimulation;
import org.osgi.framework.ServiceReference;
import org.osgi.util.tracker.ServiceTrackerCustomizer;

class MediaDSISimulation$5
implements ServiceTrackerCustomizer {
    private final /* synthetic */ MediaDSISimulation this$0;

    MediaDSISimulation$5(MediaDSISimulation mediaDSISimulation) {
        this.this$0 = mediaDSISimulation;
    }

    @Override
    public void removedService(ServiceReference serviceReference, Object object) {
    }

    @Override
    public void modifiedService(ServiceReference serviceReference, Object object) {
    }

    @Override
    public Object addingService(ServiceReference serviceReference) {
        IEjectHandler iEjectHandler = (IEjectHandler)MediaDSISimulation.access$000(this.this$0).getService(serviceReference);
        iEjectHandler.ejectCD();
        MediaDSISimulation.access$000(this.this$0).releaseService(serviceReference);
        return null;
    }
}

