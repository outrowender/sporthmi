/*
 * Decompiled with CFR 0.152.
 */
package de.audi.swdiagnosis.media.dsi;

import de.audi.swdiagnosis.media.dsi.MediaDSISimulation;
import org.dsi.ifc.albumbrowser.DSIAlbumBrowserListener;
import org.osgi.framework.ServiceReference;
import org.osgi.util.tracker.ServiceTrackerCustomizer;

class MediaDSISimulation$4
implements ServiceTrackerCustomizer {
    private final /* synthetic */ MediaDSISimulation this$0;

    MediaDSISimulation$4(MediaDSISimulation mediaDSISimulation) {
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
        Object object = MediaDSISimulation.access$000(this.this$0).getService(serviceReference);
        if (object instanceof DSIAlbumBrowserListener) {
            MediaDSISimulation.access$402(this.this$0, (DSIAlbumBrowserListener)object);
            return MediaDSISimulation.access$400(this.this$0);
        }
        return null;
    }
}

