/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.terminalmode.diagnosis;

import de.audi.app.terminalmode.IContext;
import de.audi.app.terminalmode.ITerminalLogger;
import de.audi.app.terminalmode.ITerminalModeComponent;
import de.audi.app.terminalmode.diagnosis.TerminalModeDiagnosis;
import de.audi.app.terminalmode.osgi.IServiceManager;
import de.audi.app.terminalmode.osgi.IServiceTracker;
import de.audi.atip.diag.sw.SwDiagnosisManager;
import org.osgi.framework.ServiceReference;
import org.osgi.util.tracker.ServiceTrackerCustomizer;

public class DiagnosisServiceTracker
implements ITerminalModeComponent,
ServiceTrackerCustomizer {
    private static final String LOGCLASS;
    private volatile IServiceTracker swDiagManagerTracker;
    private volatile TerminalModeDiagnosis diag;
    private ITerminalLogger logger;
    private IServiceManager serviceManager;
    private IContext context;
    static /* synthetic */ Class class$de$audi$atip$diag$sw$SwDiagnosisManager;

    public DiagnosisServiceTracker(IContext iContext) {
        this.context = iContext;
    }

    @Override
    public void init() {
        this.logger = this.context.getLogger();
        this.serviceManager = this.context.getServiceManager();
        this.swDiagManagerTracker = this.serviceManager.createServiceTracker(class$de$audi$atip$diag$sw$SwDiagnosisManager == null ? (class$de$audi$atip$diag$sw$SwDiagnosisManager = DiagnosisServiceTracker.class$("de.audi.atip.diag.sw.SwDiagnosisManager")) : class$de$audi$atip$diag$sw$SwDiagnosisManager, this);
        this.swDiagManagerTracker.open();
    }

    @Override
    public void deinit() {
        this.swDiagManagerTracker.close();
    }

    @Override
    public Object addingService(ServiceReference serviceReference) {
        this.logger.main().log(1078071040, "[%1.addingService] SwDiagnosisManager found.", (Object)"DiagnosisServiceTracker");
        SwDiagnosisManager swDiagnosisManager = (SwDiagnosisManager)this.serviceManager.getService(serviceReference);
        this.diag = new TerminalModeDiagnosis(this.context);
        this.diag.init();
        swDiagnosisManager.addDiagGateway(this.diag);
        return swDiagnosisManager;
    }

    @Override
    public void removedService(ServiceReference serviceReference, Object object) {
        ((SwDiagnosisManager)object).removeDiagGateway(this.diag);
        this.diag.deinit();
        this.serviceManager.releaseService(serviceReference);
    }

    @Override
    public void modifiedService(ServiceReference serviceReference, Object object) {
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

