/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo.high;

import de.audi.atip.interapp.audio.drawer.AudioDrawerContextListener;
import de.esolutions.hmi.widgets.audi.evo.high.DrawerManagerEvoHigh;
import org.osgi.framework.ServiceReference;
import org.osgi.util.tracker.ServiceTrackerCustomizer;

class DrawerManagerEvoHigh$3
implements ServiceTrackerCustomizer {
    private final /* synthetic */ DrawerManagerEvoHigh this$0;

    DrawerManagerEvoHigh$3(DrawerManagerEvoHigh drawerManagerEvoHigh) {
        this.this$0 = drawerManagerEvoHigh;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public Object addingService(ServiceReference serviceReference) {
        AudioDrawerContextListener audioDrawerContextListener = (AudioDrawerContextListener)DrawerManagerEvoHigh.access$100(this.this$0).getService(serviceReference);
        if (audioDrawerContextListener != null) {
            Object object = DrawerManagerEvoHigh.access$000(this.this$0);
            synchronized (object) {
                if (DrawerManagerEvoHigh.access$500(this.this$0) != null && !DrawerManagerEvoHigh.access$500(this.this$0).contains(audioDrawerContextListener)) {
                    DrawerManagerEvoHigh.access$500(this.this$0).add(audioDrawerContextListener);
                    audioDrawerContextListener.updateActiveContext(DrawerManagerEvoHigh.access$600(this.this$0), DrawerManagerEvoHigh.access$700(this.this$0));
                }
            }
        }
        return audioDrawerContextListener;
    }

    @Override
    public void modifiedService(ServiceReference serviceReference, Object object) {
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void removedService(ServiceReference serviceReference, Object object) {
        if (object instanceof AudioDrawerContextListener) {
            AudioDrawerContextListener audioDrawerContextListener = (AudioDrawerContextListener)object;
            Object object2 = DrawerManagerEvoHigh.access$000(this.this$0);
            synchronized (object2) {
                if (DrawerManagerEvoHigh.access$500(this.this$0) != null && DrawerManagerEvoHigh.access$500(this.this$0).contains(audioDrawerContextListener)) {
                    DrawerManagerEvoHigh.access$500(this.this$0).remove(audioDrawerContextListener);
                }
            }
        }
    }
}

