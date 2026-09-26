/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.storage;

import de.audi.atip.activator.AbstractFrameworkActivator;
import de.audi.atip.base.FwServices;
import de.audi.atip.base.IFrameworkAccess;
import de.audi.atip.log.LogChannel;
import de.audi.tghu.storage.DSIStorageProvider;
import de.audi.tghu.storage.StorageAccess;
import de.audi.tghu.storage.StorageActivator$1;
import de.audi.tghu.storage.StorageStatistic;
import java.util.Dictionary;
import java.util.Hashtable;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;
import org.osgi.util.tracker.ServiceTracker;
import org.osgi.util.tracker.ServiceTrackerCustomizer;

public final class StorageActivator
extends AbstractFrameworkActivator {
    private volatile StorageAccess storageManager;
    private DSIStorageProvider dsiStorageProv;
    private StorageStatistic statistic;
    private ServiceRegistration dsiPersistenceListenerSvcReg;
    private ServiceRegistration statisticSvcReg;
    private ServiceTracker dsiPersistenceTracker;
    private LogChannel stor;
    private final FwServices fwServices;
    static /* synthetic */ Class class$de$esolutions$fw$util$commons$error$DumpInfoProvider;
    static /* synthetic */ Class class$org$dsi$ifc$persistence$DSIPersistenceListener;
    static /* synthetic */ Class class$org$dsi$ifc$base$DSIListener;
    static /* synthetic */ Class class$org$dsi$ifc$persistence$DSIPersistence;
    static /* synthetic */ Class class$de$audi$atip$diag$sw$SwDiagnosisManager;

    public StorageAccess getService() {
        return this.storageManager;
    }

    public StorageActivator(FwServices fwServices) {
        super("FwStorage");
        this.fwServices = fwServices;
    }

    @Override
    protected void startInternal(BundleContext bundleContext) {
        this.stor = this.framework.getLogChannel("Fw.Storage.Activator");
        this.statistic = new StorageStatistic(this.framework);
        this.statisticSvcReg = bundleContext.registerService((class$de$esolutions$fw$util$commons$error$DumpInfoProvider == null ? (class$de$esolutions$fw$util$commons$error$DumpInfoProvider = StorageActivator.class$("de.esolutions.fw.util.commons.error.DumpInfoProvider")) : class$de$esolutions$fw$util$commons$error$DumpInfoProvider).getName(), (Object)this.statistic, null);
        this.dsiStorageProv = new DSIStorageProvider(this.framework, this.statistic);
        Hashtable hashtable = new Hashtable();
        hashtable.put("DEVICE_NAME", (class$org$dsi$ifc$persistence$DSIPersistenceListener == null ? (class$org$dsi$ifc$persistence$DSIPersistenceListener = StorageActivator.class$("org.dsi.ifc.persistence.DSIPersistenceListener")) : class$org$dsi$ifc$persistence$DSIPersistenceListener).getName());
        hashtable.put("DEVICE_INSTANCE", new Integer(0));
        this.dsiPersistenceListenerSvcReg = bundleContext.registerService((class$org$dsi$ifc$base$DSIListener == null ? (class$org$dsi$ifc$base$DSIListener = StorageActivator.class$("org.dsi.ifc.base.DSIListener")) : class$org$dsi$ifc$base$DSIListener).getName(), (Object)this.dsiStorageProv, (Dictionary)hashtable);
        this.dsiPersistenceTracker = new ServiceTracker(bundleContext, new String[]{(class$org$dsi$ifc$persistence$DSIPersistence == null ? (class$org$dsi$ifc$persistence$DSIPersistence = StorageActivator.class$("org.dsi.ifc.persistence.DSIPersistence")) : class$org$dsi$ifc$persistence$DSIPersistence).getName(), (class$de$audi$atip$diag$sw$SwDiagnosisManager == null ? (class$de$audi$atip$diag$sw$SwDiagnosisManager = StorageActivator.class$("de.audi.atip.diag.sw.SwDiagnosisManager")) : class$de$audi$atip$diag$sw$SwDiagnosisManager).getName()}, (ServiceTrackerCustomizer)new StorageActivator$1(this));
        this.dsiPersistenceTracker.open();
    }

    @Override
    public void stop(BundleContext bundleContext) {
        if (this.dsiPersistenceListenerSvcReg != null) {
            this.dsiPersistenceListenerSvcReg.unregister();
            this.dsiPersistenceListenerSvcReg = null;
        }
        if (this.statisticSvcReg != null) {
            this.statisticSvcReg.unregister();
            this.statisticSvcReg = null;
        }
        this.dsiPersistenceTracker.close();
        this.dsiPersistenceTracker = null;
        if (this.dsiStorageProv != null) {
            this.dsiStorageProv.stop();
            this.dsiStorageProv = null;
        }
        this.storageManager = null;
        this.stor = null;
        super.stop(bundleContext);
    }

    public void flush() {
        if (this.dsiStorageProv != null) {
            this.dsiStorageProv.flush();
        }
    }

    static /* synthetic */ Class class$(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new NoClassDefFoundError().initCause(classNotFoundException);
        }
    }

    static /* synthetic */ BundleContext access$000(StorageActivator storageActivator) {
        return storageActivator.getBundleContext();
    }

    static /* synthetic */ DSIStorageProvider access$100(StorageActivator storageActivator) {
        return storageActivator.dsiStorageProv;
    }

    static /* synthetic */ StorageAccess access$200(StorageActivator storageActivator) {
        return storageActivator.storageManager;
    }

    static /* synthetic */ StorageAccess access$202(StorageActivator storageActivator, StorageAccess storageAccess) {
        storageActivator.storageManager = storageAccess;
        return storageActivator.storageManager;
    }

    static /* synthetic */ StorageStatistic access$300(StorageActivator storageActivator) {
        return storageActivator.statistic;
    }

    static /* synthetic */ FwServices access$400(StorageActivator storageActivator) {
        return storageActivator.fwServices;
    }

    static /* synthetic */ LogChannel access$500(StorageActivator storageActivator) {
        return storageActivator.stor;
    }

    static /* synthetic */ BundleContext access$600(StorageActivator storageActivator) {
        return storageActivator.getBundleContext();
    }

    static /* synthetic */ BundleContext access$700(StorageActivator storageActivator) {
        return storageActivator.getBundleContext();
    }

    static /* synthetic */ IFrameworkAccess access$800(StorageActivator storageActivator) {
        return storageActivator.framework;
    }
}

