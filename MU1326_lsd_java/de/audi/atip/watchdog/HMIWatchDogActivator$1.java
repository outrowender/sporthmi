/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.watchdog;

import de.audi.atip.watchdog.HMIWatchDogActivator;
import org.dsi.ifc.system.DSIHMIWatchDog;
import org.osgi.framework.ServiceReference;
import org.osgi.util.tracker.ServiceTrackerCustomizer;

class HMIWatchDogActivator$1
implements ServiceTrackerCustomizer {
    private final /* synthetic */ HMIWatchDogActivator this$0;

    HMIWatchDogActivator$1(HMIWatchDogActivator hMIWatchDogActivator) {
        this.this$0 = hMIWatchDogActivator;
    }

    @Override
    public Object addingService(ServiceReference serviceReference) {
        try {
            String string = (String)serviceReference.getProperty("DEVICE_NAME");
            Object object = serviceReference.getProperty("DEVICE_INSTANCE");
            int n = 0;
            if (object instanceof Integer) {
                n = (Integer)object;
            }
            HMIWatchDogActivator.access$000(this.this$0).log(-2137614336, "HMIWatchDogActivator.addingService( %1, %2 )", (Object)string, (long)n);
            Object object2 = HMIWatchDogActivator.access$100(this.this$0).getService(serviceReference);
            if (HMIWatchDogActivator.access$200().equals(string) && n == 0) {
                HMIWatchDogActivator.access$000(this.this$0).log(1078071040, "DSIHMIWatchDog is available!", (Object)string, (long)n);
                HMIWatchDogActivator.access$300(this.this$0).setDSI((DSIHMIWatchDog)object2);
            }
            return object2;
        }
        catch (Exception exception) {
            HMIWatchDogActivator.access$000(this.this$0).log(-1601830656, "DomainActivator.addingService failed", (Throwable)exception);
            return null;
        }
    }

    @Override
    public void modifiedService(ServiceReference serviceReference, Object object) {
    }

    @Override
    public void removedService(ServiceReference serviceReference, Object object) {
        HMIWatchDogActivator.access$000(this.this$0).log(-2137614336, "HMIWatchDogActivator.removedService( %1 )", (Object)serviceReference);
        HMIWatchDogActivator.access$400(this.this$0).ungetService(serviceReference);
        HMIWatchDogActivator.access$300(this.this$0).setDSI(null);
    }
}

