/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.bap.ecall;

import de.audi.app.bap.ecall.AppConnectorEcall;
import de.audi.app.bap.fw.AbstractBAPModule;
import de.audi.app.bap.fw.AbstractBAPModuleServiceManager;
import de.audi.atip.activator.AbstractActivator;
import de.audi.atip.interapp.bap.BAPServiceListener;
import de.audi.atip.interapp.bap.ecall.BAPServiceEcallListener;
import de.audi.atip.log.LogChannel;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;
import org.osgi.util.tracker.ServiceTracker;
import org.osgi.util.tracker.ServiceTrackerCustomizer;

public class ServiceManagerEcall
extends AbstractBAPModuleServiceManager {
    private LogChannel logChannel;
    static /* synthetic */ Class class$de$audi$atip$interapp$bap$ecall$BAPServiceEcall;
    static /* synthetic */ Class class$de$audi$atip$interapp$bap$ecall$BAPServiceEcallListener;
    static /* synthetic */ Class class$de$audi$atip$diag$sw$SwDiagnosisManager;

    public ServiceManagerEcall(AbstractBAPModule abstractBAPModule, BundleContext bundleContext) {
        super(abstractBAPModule, bundleContext);
        this.logChannel = abstractBAPModule.getLogChannel();
    }

    @Override
    public Object addingService(ServiceReference serviceReference) {
        Object object = this.bundleContext.getService(serviceReference);
        if (object instanceof BAPServiceEcallListener) {
            this.logChannel.log(1078071040, "[ServiceManagerEcall#addingService] BAPServiceEcallListener found");
            ((AppConnectorEcall)this.module.getAppConnectors().get("AppBapEcall")).setAppServiceListener((BAPServiceListener)object);
            this.module.getInitializationManager().notifyAppServiceChanged(true);
            return object;
        }
        this.bundleContext.ungetService(serviceReference);
        return super.addingService(serviceReference);
    }

    @Override
    public void removedService(ServiceReference serviceReference, Object object) {
        if (object instanceof BAPServiceEcallListener) {
            this.logChannel.log(-2137614336, "[ServiceManagerEcall#removedService] BAPServiceEcallListener removed");
            ((AppConnectorEcall)this.module.getAppConnectors().get("AppBapEcall")).setAppServiceListener(null);
            this.bundleContext.ungetService(serviceReference);
        } else {
            super.removedService(serviceReference, object);
        }
    }

    @Override
    public void registerServices(AbstractActivator abstractActivator) {
        this.logChannel.log(1078071040, "[ServiceManagerEcall#registerServices] activator: %1", (Object)abstractActivator);
        abstractActivator.registerService((class$de$audi$atip$interapp$bap$ecall$BAPServiceEcall == null ? (class$de$audi$atip$interapp$bap$ecall$BAPServiceEcall = ServiceManagerEcall.class$("de.audi.atip.interapp.bap.ecall.BAPServiceEcall")) : class$de$audi$atip$interapp$bap$ecall$BAPServiceEcall).getName(), this.module.getAppConnectors().get("AppBapEcall"), null);
    }

    @Override
    public void trackServices() {
        this.logChannel.log(1078071040, "[ServiceManagerEcall#trackServices]");
        String[] stringArray = new String[]{(class$de$audi$atip$interapp$bap$ecall$BAPServiceEcallListener == null ? (class$de$audi$atip$interapp$bap$ecall$BAPServiceEcallListener = ServiceManagerEcall.class$("de.audi.atip.interapp.bap.ecall.BAPServiceEcallListener")) : class$de$audi$atip$interapp$bap$ecall$BAPServiceEcallListener).getName(), (class$de$audi$atip$diag$sw$SwDiagnosisManager == null ? (class$de$audi$atip$diag$sw$SwDiagnosisManager = ServiceManagerEcall.class$("de.audi.atip.diag.sw.SwDiagnosisManager")) : class$de$audi$atip$diag$sw$SwDiagnosisManager).getName()};
        this.serviceTracker = new ServiceTracker(this.bundleContext, stringArray, (ServiceTrackerCustomizer)this);
        this.serviceTracker.open();
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

