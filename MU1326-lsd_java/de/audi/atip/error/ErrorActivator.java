/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  de.mib.swdiagnosis.ErrorManagerDiag
 */
package de.audi.atip.error;

import de.audi.atip.activator.AbstractFrameworkActivator;
import de.audi.atip.diag.sw.AbstractSwDiagnosis;
import de.audi.atip.diag.sw.SwDiagnosisManager;
import de.audi.atip.error.ErrorDumpTcpTrigger;
import de.audi.atip.error.ErrorManager;
import de.audi.atip.log.SPISink;
import de.esolutions.fw.util.commons.error.DumpInfoProvider;
import de.mib.swdiagnosis.ErrorManagerDiag;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;
import org.osgi.util.tracker.ServiceTracker;
import org.osgi.util.tracker.ServiceTrackerCustomizer;

public class ErrorActivator
extends AbstractFrameworkActivator
implements ServiceTrackerCustomizer {
    private ErrorManager errorManager;
    private ServiceTracker dumpInfoProviderTracker;
    private ErrorDumpTcpTrigger dumpTrigger = null;
    static /* synthetic */ Class class$de$esolutions$fw$util$commons$error$DumpInfoProvider;
    static /* synthetic */ Class class$de$audi$atip$diag$sw$SwDiagnosisManager;
    static /* synthetic */ Class class$de$audi$atip$log$LogSink;

    public ErrorActivator() {
        super("FwError");
    }

    public ErrorManager getService() {
        return this.errorManager;
    }

    @Override
    protected void startInternal(BundleContext bundleContext) {
        this.errorManager = new ErrorManager(this.framework);
        this.initTracker();
        this.dumpTrigger = new ErrorDumpTcpTrigger(this.framework);
        this.dumpTrigger.start();
    }

    @Override
    public void stop(BundleContext bundleContext) {
        if (this.dumpTrigger != null) {
            this.dumpTrigger.stop();
            this.dumpTrigger = null;
        }
        if (this.dumpInfoProviderTracker != null) {
            this.dumpInfoProviderTracker.close();
            this.dumpInfoProviderTracker = null;
        }
        this.errorManager = null;
        super.stop(bundleContext);
    }

    private void initTracker() {
        this.dumpInfoProviderTracker = new ServiceTracker(this.getBundleContext(), new String[]{(class$de$esolutions$fw$util$commons$error$DumpInfoProvider == null ? (class$de$esolutions$fw$util$commons$error$DumpInfoProvider = ErrorActivator.class$("de.esolutions.fw.util.commons.error.DumpInfoProvider")) : class$de$esolutions$fw$util$commons$error$DumpInfoProvider).getName(), (class$de$audi$atip$diag$sw$SwDiagnosisManager == null ? (class$de$audi$atip$diag$sw$SwDiagnosisManager = ErrorActivator.class$("de.audi.atip.diag.sw.SwDiagnosisManager")) : class$de$audi$atip$diag$sw$SwDiagnosisManager).getName(), (class$de$audi$atip$log$LogSink == null ? (class$de$audi$atip$log$LogSink = ErrorActivator.class$("de.audi.atip.log.LogSink")) : class$de$audi$atip$log$LogSink).getName()}, (ServiceTrackerCustomizer)this);
        this.dumpInfoProviderTracker.open();
    }

    @Override
    public Object addingService(ServiceReference serviceReference) {
        Object object = this.getBundleContext().getService(serviceReference);
        if (object instanceof DumpInfoProvider) {
            this.errorManager.registerDumpInfoProvider((DumpInfoProvider)object);
        } else if (object instanceof SwDiagnosisManager) {
            ((SwDiagnosisManager)object).addDiagGateway((AbstractSwDiagnosis)new ErrorManagerDiag(this.framework));
        } else if (object instanceof SPISink) {
            this.errorManager.setSPISink((SPISink)object);
        } else {
            this.getBundleContext().ungetService(serviceReference);
            object = null;
        }
        return object;
    }

    @Override
    public void modifiedService(ServiceReference serviceReference, Object object) {
    }

    @Override
    public void removedService(ServiceReference serviceReference, Object object) {
        if (object instanceof DumpInfoProvider) {
            this.errorManager.unregisterDumpInfoProvider((DumpInfoProvider)object);
        } else if (object instanceof SPISink) {
            this.errorManager.setSPISink(null);
        }
        if (serviceReference != null) {
            this.getBundleContext().ungetService(serviceReference);
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
}

