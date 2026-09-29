/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.bap;

import de.audi.app.bap.AbstractBAPActivator$1;
import de.audi.app.bap.AbstractBAPApplication;
import de.audi.app.bap.dsi.DSIServiceTracker;
import de.audi.app.bap.fw.AbstractBAPModule;
import de.audi.atip.activator.AbstractActivator;
import de.audi.atip.base.IFrameworkAccess;
import de.audi.atip.diag.sw.AbstractSwDiagnosis;
import de.audi.atip.log.LogChannel;
import org.osgi.framework.BundleContext;
import org.osgi.util.tracker.ServiceTracker;
import org.osgi.util.tracker.ServiceTrackerCustomizer;

public abstract class AbstractBAPActivator
extends AbstractActivator {
    protected LogChannel logChannel;
    protected AbstractBAPApplication bapApplication;
    private DSIServiceTracker dsiBAPServiceTracker;
    private ServiceTracker swDiagnosisServiceTracker;
    private AbstractSwDiagnosis diagnosis;
    static /* synthetic */ Class class$org$dsi$ifc$bap$DSIBAPListener;
    static /* synthetic */ Class class$org$dsi$ifc$bap$DSIBAP;
    static /* synthetic */ Class class$de$audi$atip$diag$sw$SwDiagnosisManager;

    @Override
    public void start(BundleContext bundleContext) {
        super.start(bundleContext);
        this.init();
        this.bapApplication = this.createApplication(this.framework);
        this.logChannel = this.bapApplication.getLogger().getMainLog();
        AbstractBAPModule[] abstractBAPModuleArray = this.createModules(this.bapApplication);
        for (int i2 = 0; i2 < abstractBAPModuleArray.length; ++i2) {
            this.bapApplication.registerModule(abstractBAPModuleArray[i2]);
        }
        this.bapApplication.activate(this);
        this.startDSIBAP();
        this.startSwDiagnosis();
        this.logChannel.log(-2137614336, "[AbstractBAPActivator#start] %1 has been started.", (Object)this.getApplicationName());
    }

    protected void init() {
    }

    private void startDSIBAP() {
        this.dsiBAPServiceTracker = new DSIServiceTracker(this.bundleContext, this.bapApplication.getDSIBAPController(), this.bapApplication.getDSIBAPListener(), class$org$dsi$ifc$bap$DSIBAPListener == null ? (class$org$dsi$ifc$bap$DSIBAPListener = AbstractBAPActivator.class$("org.dsi.ifc.bap.DSIBAPListener")) : class$org$dsi$ifc$bap$DSIBAPListener, null, this.logChannel);
        this.dsiBAPServiceTracker.setDSIServiceStateListener(this.bapApplication);
        this.dsiBAPServiceTracker.start();
        this.framework.startDSIService((class$org$dsi$ifc$bap$DSIBAP == null ? (class$org$dsi$ifc$bap$DSIBAP = AbstractBAPActivator.class$("org.dsi.ifc.bap.DSIBAP")) : class$org$dsi$ifc$bap$DSIBAP).getName(), 0);
    }

    private void startSwDiagnosis() {
        this.swDiagnosisServiceTracker = new ServiceTracker(this.bundleContext, (class$de$audi$atip$diag$sw$SwDiagnosisManager == null ? (class$de$audi$atip$diag$sw$SwDiagnosisManager = AbstractBAPActivator.class$("de.audi.atip.diag.sw.SwDiagnosisManager")) : class$de$audi$atip$diag$sw$SwDiagnosisManager).getName(), (ServiceTrackerCustomizer)new AbstractBAPActivator$1(this));
        this.swDiagnosisServiceTracker.open();
    }

    @Override
    public void stop(BundleContext bundleContext) {
        this.logChannel.log(-2137614336, "[AbstractBAPActivator#stop] %1 has been stopped. Shutting down...", (Object)this.getApplicationName());
        this.dsiBAPServiceTracker.stop();
        this.swDiagnosisServiceTracker = this.closeTracker(this.swDiagnosisServiceTracker);
        this.bapApplication.deactivate();
        this.bapApplication = null;
        super.stop(bundleContext);
    }

    protected abstract String getApplicationName() {
    }

    protected abstract AbstractBAPApplication createApplication(IFrameworkAccess iFrameworkAccess) {
    }

    protected abstract AbstractBAPModule[] createModules(AbstractBAPApplication abstractBAPApplication) {
    }

    protected abstract AbstractSwDiagnosis createDiagnosis(AbstractBAPApplication abstractBAPApplication) {
    }

    static /* synthetic */ Class class$(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new NoClassDefFoundError().initCause(classNotFoundException);
        }
    }

    static /* synthetic */ AbstractSwDiagnosis access$000(AbstractBAPActivator abstractBAPActivator) {
        return abstractBAPActivator.diagnosis;
    }

    static /* synthetic */ BundleContext access$100(AbstractBAPActivator abstractBAPActivator) {
        return abstractBAPActivator.bundleContext;
    }

    static /* synthetic */ BundleContext access$200(AbstractBAPActivator abstractBAPActivator) {
        return abstractBAPActivator.bundleContext;
    }

    static /* synthetic */ AbstractSwDiagnosis access$002(AbstractBAPActivator abstractBAPActivator, AbstractSwDiagnosis abstractSwDiagnosis) {
        abstractBAPActivator.diagnosis = abstractSwDiagnosis;
        return abstractBAPActivator.diagnosis;
    }
}

