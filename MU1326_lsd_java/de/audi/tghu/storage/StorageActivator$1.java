/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  de.mib.swdiagnosis.StorageManagerDiag
 */
package de.audi.tghu.storage;

import de.audi.atip.diag.sw.AbstractSwDiagnosis;
import de.audi.atip.diag.sw.SwDiagnosisManager;
import de.audi.tghu.storage.StorageAccess;
import de.audi.tghu.storage.StorageActivator;
import de.mib.swdiagnosis.StorageManagerDiag;
import org.dsi.ifc.persistence.DSIPersistence;
import org.osgi.framework.ServiceReference;
import org.osgi.util.tracker.ServiceTrackerCustomizer;

class StorageActivator$1
implements ServiceTrackerCustomizer {
    private final /* synthetic */ StorageActivator this$0;

    StorageActivator$1(StorageActivator storageActivator) {
        this.this$0 = storageActivator;
    }

    @Override
    public Object addingService(ServiceReference serviceReference) {
        Object object = StorageActivator.access$000(this.this$0).getService(serviceReference);
        if (object instanceof DSIPersistence) {
            DSIPersistence dSIPersistence = (DSIPersistence)object;
            if (dSIPersistence != null) {
                StorageActivator.access$100(this.this$0).setProvider(dSIPersistence);
                if (StorageActivator.access$200(this.this$0) == null) {
                    StorageActivator.access$202(this.this$0, new StorageAccess(StorageActivator.access$100(this.this$0), StorageActivator.access$300(this.this$0)));
                }
                StorageActivator.access$400(this.this$0).getStartupManager().persistenceIsAvailable();
            }
        } else if (object instanceof SwDiagnosisManager) {
            ((SwDiagnosisManager)object).addDiagGateway((AbstractSwDiagnosis)new StorageManagerDiag(StorageActivator.access$400(this.this$0)));
        } else {
            StorageActivator.access$500(this.this$0).log(10000, "track unwanted service=%1", object);
            StorageActivator.access$600(this.this$0).ungetService(serviceReference);
            return null;
        }
        return object;
    }

    @Override
    public void modifiedService(ServiceReference serviceReference, Object object) {
    }

    @Override
    public void removedService(ServiceReference serviceReference, Object object) {
        StorageActivator.access$500(this.this$0).log(1078071040, "Removing Service=%1", object);
        StorageActivator.access$700(this.this$0).ungetService(serviceReference);
        if (object instanceof DSIPersistence) {
            StorageActivator.access$800(this.this$0).startDSIService((StorageActivator.class$org$dsi$ifc$persistence$DSIPersistence == null ? (StorageActivator.class$org$dsi$ifc$persistence$DSIPersistence = StorageActivator.class$("org.dsi.ifc.persistence.DSIPersistence")) : StorageActivator.class$org$dsi$ifc$persistence$DSIPersistence).getName(), 0);
        }
    }
}

