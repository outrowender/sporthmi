/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  de.mib.swdiagnosis.onlinefunctions.OnlineFunctionsDiagnosisConnector
 */
package de.audi.app.onlinefunctions.bap;

import de.audi.app.bap.AbstractBAPActivator;
import de.audi.app.bap.AbstractBAPApplication;
import de.audi.app.bap.fw.AbstractBAPModule;
import de.audi.app.bap.fw.AbstractBAPModuleFSG;
import de.audi.app.onlinefunctions.bap.FunctionListOnlineFunctions;
import de.audi.app.onlinefunctions.bap.LoggerOnlineFunctionsBAP;
import de.audi.app.onlinefunctions.bap.OnlineFunctionsBAPApplication;
import de.audi.app.onlinefunctions.bap.OnlineFunctionsModule;
import de.audi.atip.base.IFrameworkAccess;
import de.audi.atip.diag.sw.AbstractSwDiagnosis;
import de.mib.swdiagnosis.onlinefunctions.OnlineFunctionsDiagnosisConnector;
import org.osgi.framework.BundleContext;
import org.osgi.util.tracker.ServiceTracker;
import org.osgi.util.tracker.ServiceTrackerCustomizer;

public final class OnlineFunctionsBAPActivator
extends AbstractBAPActivator {
    private OnlineFunctionsModule onlineFunctionsModule;
    private ServiceTracker trackerDSIOTLI;
    static /* synthetic */ Class class$org$dsi$ifc$online$DSIOnlineTrafficLightInfo;

    public void start(BundleContext bundleContext) {
        super.start(bundleContext);
        OnlineFunctionsBAPApplication onlineFunctionsBAPApplication = (OnlineFunctionsBAPApplication)this.bapApplication;
        this.trackerDSIOTLI = new ServiceTracker(bundleContext, (class$org$dsi$ifc$online$DSIOnlineTrafficLightInfo == null ? (class$org$dsi$ifc$online$DSIOnlineTrafficLightInfo = OnlineFunctionsBAPActivator.class$("org.dsi.ifc.online.DSIOnlineTrafficLightInfo")) : class$org$dsi$ifc$online$DSIOnlineTrafficLightInfo).getName(), (ServiceTrackerCustomizer)onlineFunctionsBAPApplication);
        this.trackerDSIOTLI.open();
        this.logChannel.log(10000000, "[OnlineFunctionsBAPActivator#start] %1 has been started.", (Object)this.getApplicationName());
    }

    public void stop(BundleContext bundleContext) {
        this.logChannel.log(10000000, "[OnlineFunctionsBAPActivator#stop] called");
        this.trackerDSIOTLI.close();
        super.stop(bundleContext);
    }

    protected String getApplicationName() {
        return "AppOnlineFunctionsBAP";
    }

    protected AbstractBAPApplication createApplication(IFrameworkAccess iFrameworkAccess) {
        return new OnlineFunctionsBAPApplication(iFrameworkAccess, new LoggerOnlineFunctionsBAP(iFrameworkAccess));
    }

    protected AbstractBAPModule[] createModules(AbstractBAPApplication abstractBAPApplication) {
        this.logChannel.log(10000000, "[OnlineFunctionsBAPActivator#createModules] application: %1", (Object)abstractBAPApplication.getName());
        this.onlineFunctionsModule = new OnlineFunctionsModule(abstractBAPApplication, new FunctionListOnlineFunctions());
        return new AbstractBAPModule[]{this.onlineFunctionsModule};
    }

    protected AbstractSwDiagnosis createDiagnosis(AbstractBAPApplication abstractBAPApplication) {
        this.logChannel.log(10000000, "[OnlineFunctionsBAPActivator#createDiagnosis] application: %1", (Object)abstractBAPApplication);
        return new OnlineFunctionsDiagnosisConnector(abstractBAPApplication, (AbstractBAPModuleFSG)this.onlineFunctionsModule);
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

