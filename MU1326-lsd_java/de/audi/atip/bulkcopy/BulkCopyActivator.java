/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  de.mib.swdiagnosis.BulkCopyDiag
 */
package de.audi.atip.bulkcopy;

import de.audi.atip.activator.AbstractActivator;
import de.audi.atip.bulkcopy.BulkCopyException;
import de.audi.atip.bulkcopy.BulkCopyManagerImpl;
import de.audi.atip.bulkcopy.IBulkCopyClient;
import de.audi.atip.bulkcopy.IBulkCopyManager;
import de.audi.atip.diag.sw.AbstractSwDiagnosis;
import de.audi.atip.diag.sw.SwDiagnosisManager;
import de.audi.atip.log.LogChannel;
import de.mib.swdiagnosis.BulkCopyDiag;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;
import org.osgi.util.tracker.ServiceTracker;
import org.osgi.util.tracker.ServiceTrackerCustomizer;

public class BulkCopyActivator
extends AbstractActivator
implements ServiceTrackerCustomizer {
    private BulkCopyManagerImpl m_manager = null;
    private LogChannel m_log = null;
    ServiceTracker m_tracker;
    BulkCopyDiag m_diag = null;
    static /* synthetic */ Class class$de$audi$atip$bulkcopy$IBulkCopyManager;
    static /* synthetic */ Class class$de$esolutions$fw$util$commons$error$DumpInfoProvider;
    static /* synthetic */ Class class$de$audi$atip$bulkcopy$IBulkCopyClient;
    static /* synthetic */ Class class$de$audi$atip$diag$sw$SwDiagnosisManager;

    @Override
    public void start(BundleContext bundleContext) {
        super.start(bundleContext);
        this.m_log = this.framework.getLogChannel("Fw.BulkCopy");
        this.m_log.log(1078071040, "BulkCopyActivator.start()");
        this.m_manager = new BulkCopyManagerImpl(this.framework, this.m_log, new int[]{1, 2});
        this.registerServices(this.m_manager);
        this.initTracker();
    }

    public BulkCopyManagerImpl getService() {
        return this.m_manager;
    }

    @Override
    public void stop(BundleContext bundleContext) {
        if (null != this.m_tracker) {
            this.m_tracker.close();
        }
        super.stop(bundleContext);
    }

    @Override
    public Object addingService(ServiceReference serviceReference) {
        this.m_log.log(1078071040, "BulkCopyActivator.addingService(..)");
        Object object = this.getBundleContext().getService(serviceReference);
        if (object instanceof IBulkCopyClient) {
            this.m_log.log(-2137614336, "register bulkcopyclient");
            try {
                this.m_manager.registerClient((IBulkCopyClient)object);
            }
            catch (BulkCopyException bulkCopyException) {
                this.getBundleContext().ungetService(serviceReference);
                this.m_log.log(10000, "register of bulkcopyclient %1 failed!", object, (Throwable)bulkCopyException);
                return null;
            }
        } else if (object instanceof SwDiagnosisManager) {
            this.m_log.log(-2137614336, "register me to diagnosis manager");
            this.m_diag = new BulkCopyDiag((IBulkCopyManager)this.m_manager);
            ((SwDiagnosisManager)object).addDiagGateway((AbstractSwDiagnosis)this.m_diag);
        } else {
            this.getBundleContext().ungetService(serviceReference);
            this.m_log.log(-1601830656, "adding unwanted service!");
            return null;
        }
        this.m_log.log(-2137614336, "added service = %1", object);
        return object;
    }

    @Override
    public void modifiedService(ServiceReference serviceReference, Object object) {
    }

    @Override
    public void removedService(ServiceReference serviceReference, Object object) {
        this.m_log.log(1078071040, "BulkCopyActivator.removedService(..)");
        if (object instanceof IBulkCopyClient) {
            this.m_log.log(-2137614336, "unregister bulkcopyclient");
            this.m_manager.unregisterClient((IBulkCopyClient)object);
        } else if (object instanceof SwDiagnosisManager) {
            this.m_log.log(-2137614336, "unregister me from diagnosis manager");
            if (null != this.m_diag) {
                ((SwDiagnosisManager)object).removeDiagGateway((AbstractSwDiagnosis)this.m_diag);
                this.m_diag = null;
            }
        }
        this.m_log.log(-2137614336, "removed service = %1", object);
        this.getBundleContext().ungetService(serviceReference);
    }

    private void registerServices(BulkCopyManagerImpl bulkCopyManagerImpl) {
        this.m_log.log(1078071040, "BulkCopyActivator.registerServices(..)");
        this.registerService(new String[]{(class$de$audi$atip$bulkcopy$IBulkCopyManager == null ? (class$de$audi$atip$bulkcopy$IBulkCopyManager = BulkCopyActivator.class$("de.audi.atip.bulkcopy.IBulkCopyManager")) : class$de$audi$atip$bulkcopy$IBulkCopyManager).getName(), (class$de$esolutions$fw$util$commons$error$DumpInfoProvider == null ? (class$de$esolutions$fw$util$commons$error$DumpInfoProvider = BulkCopyActivator.class$("de.esolutions.fw.util.commons.error.DumpInfoProvider")) : class$de$esolutions$fw$util$commons$error$DumpInfoProvider).getName()}, (Object)bulkCopyManagerImpl, null);
    }

    private void initTracker() {
        this.m_log.log(1078071040, "BulkCopyActivator.initTracker()");
        String[] stringArray = new String[]{(class$de$audi$atip$bulkcopy$IBulkCopyClient == null ? (class$de$audi$atip$bulkcopy$IBulkCopyClient = BulkCopyActivator.class$("de.audi.atip.bulkcopy.IBulkCopyClient")) : class$de$audi$atip$bulkcopy$IBulkCopyClient).getName(), (class$de$audi$atip$diag$sw$SwDiagnosisManager == null ? (class$de$audi$atip$diag$sw$SwDiagnosisManager = BulkCopyActivator.class$("de.audi.atip.diag.sw.SwDiagnosisManager")) : class$de$audi$atip$diag$sw$SwDiagnosisManager).getName()};
        this.m_tracker = new ServiceTracker(this.getBundleContext(), stringArray, (ServiceTrackerCustomizer)this);
        this.m_tracker.open();
    }

    static /* synthetic */ Class class$(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new NoClassDefFoundError().initCause(classNotFoundException);
        }
    }
}

