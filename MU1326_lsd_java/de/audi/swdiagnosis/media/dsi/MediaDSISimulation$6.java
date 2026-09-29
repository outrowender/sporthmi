/*
 * Decompiled with CFR 0.152.
 */
package de.audi.swdiagnosis.media.dsi;

import de.audi.swdiagnosis.media.dsi.MediaDSISimulation;
import org.dsi.ifc.media.DSIMediaOnlineListener;
import org.osgi.framework.ServiceReference;
import org.osgi.util.tracker.ServiceTrackerCustomizer;

class MediaDSISimulation$6
implements ServiceTrackerCustomizer {
    private final /* synthetic */ int val$instanceID;
    private final /* synthetic */ MediaDSISimulation this$0;

    MediaDSISimulation$6(MediaDSISimulation mediaDSISimulation, int n) {
        this.this$0 = mediaDSISimulation;
        this.val$instanceID = n;
    }

    @Override
    public void removedService(ServiceReference serviceReference, Object object) {
    }

    @Override
    public void modifiedService(ServiceReference serviceReference, Object object) {
    }

    @Override
    public Object addingService(ServiceReference serviceReference) {
        Integer n = (Integer)serviceReference.getProperty("DEVICE_INSTANCE");
        if (n == null) {
            return null;
        }
        if (n != this.val$instanceID) {
            return null;
        }
        String string = (String)serviceReference.getProperty("DEVICE_NAME");
        if (string == null) {
            return null;
        }
        if (!(MediaDSISimulation.class$org$dsi$ifc$media$DSIMediaOnlineListener == null ? (MediaDSISimulation.class$org$dsi$ifc$media$DSIMediaOnlineListener = MediaDSISimulation.class$("org.dsi.ifc.media.DSIMediaOnlineListener")) : MediaDSISimulation.class$org$dsi$ifc$media$DSIMediaOnlineListener).getName().equals(string)) {
            return null;
        }
        Object object = MediaDSISimulation.access$000(this.this$0).getService(serviceReference);
        if (object instanceof DSIMediaOnlineListener) {
            MediaDSISimulation.access$502(this.this$0, (DSIMediaOnlineListener)object);
            return object;
        }
        return null;
    }
}

