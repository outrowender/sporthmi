/*
 * Decompiled with CFR 0.152.
 */
package de.audi.swdiagnosis.media.dsi;

import de.audi.swdiagnosis.media.dsi.MediaDSISimulation;
import org.dsi.ifc.media.DSIMediaBaseListener;
import org.osgi.framework.ServiceReference;
import org.osgi.util.tracker.ServiceTrackerCustomizer;

class MediaDSISimulation$1
implements ServiceTrackerCustomizer {
    private final /* synthetic */ MediaDSISimulation this$0;

    MediaDSISimulation$1(MediaDSISimulation mediaDSISimulation) {
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
        String string = (String)serviceReference.getProperty("DEVICE_NAME");
        if (string == null) {
            return null;
        }
        if (!(MediaDSISimulation.class$org$dsi$ifc$media$DSIMediaBaseListener == null ? (MediaDSISimulation.class$org$dsi$ifc$media$DSIMediaBaseListener = MediaDSISimulation.class$("org.dsi.ifc.media.DSIMediaBaseListener")) : MediaDSISimulation.class$org$dsi$ifc$media$DSIMediaBaseListener).getName().equals(string)) {
            return null;
        }
        Object object = MediaDSISimulation.access$000(this.this$0).getService(serviceReference);
        if (object instanceof DSIMediaBaseListener) {
            MediaDSISimulation.access$102(this.this$0, (DSIMediaBaseListener)object);
            return MediaDSISimulation.access$100(this.this$0);
        }
        return null;
    }
}

