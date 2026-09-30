/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.bap.remoteservices;

import de.audi.app.bap.fw.AbstractBAPModule;
import de.audi.app.bap.fw.AbstractBAPModuleServiceManager;
import de.audi.app.bap.remoteservices.AppConnectorRemoteServices;
import de.audi.atip.activator.AbstractActivator;
import de.audi.atip.interapp.bap.BAPServiceListener;
import de.audi.atip.interapp.bap.remoteservices.BAPServiceRemoteServicesListener;
import de.audi.atip.log.LogChannel;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;
import org.osgi.util.tracker.ServiceTracker;
import org.osgi.util.tracker.ServiceTrackerCustomizer;

public class ServiceManagerRemoteServices
extends AbstractBAPModuleServiceManager {
    private LogChannel logChannel;
    static /* synthetic */ Class class$de$audi$atip$interapp$bap$remoteservices$BAPServiceRemoteServices;
    static /* synthetic */ Class class$de$audi$atip$interapp$bap$remoteservices$BAPServiceRemoteServicesListener;
    static /* synthetic */ Class class$de$audi$atip$diag$sw$SwDiagnosisManager;

    public ServiceManagerRemoteServices(AbstractBAPModule abstractBAPModule, BundleContext bundleContext) {
        super(abstractBAPModule, bundleContext);
        this.logChannel = abstractBAPModule.getLogChannel();
    }

    public Object addingService(ServiceReference serviceReference) {
        Object object = this.bundleContext.getService(serviceReference);
        if (object instanceof BAPServiceRemoteServicesListener) {
            this.logChannel.log(1000000, "[ServiceManagerRemoteServices#addingService] BAPServiceRemoteServicesListener found");
            ((AppConnectorRemoteServices)this.module.getAppConnectors().get("AppBapRemoteServices")).setAppServiceListener((BAPServiceListener)object);
            this.module.getInitializationManager().notifyAppServiceChanged(true);
            return object;
        }
        this.bundleContext.ungetService(serviceReference);
        return super.addingService(serviceReference);
    }

    public void removedService(ServiceReference serviceReference, Object object) {
        if (object instanceof BAPServiceRemoteServicesListener) {
            this.logChannel.log(10000000, "[ServiceManagerRemoteServices#removedService] BAPServiceRemoteServicesListener removed");
            ((AppConnectorRemoteServices)this.module.getAppConnectors().get("AppBapRemoteServices")).setAppServiceListener(null);
            this.bundleContext.ungetService(serviceReference);
        } else {
            super.removedService(serviceReference, object);
        }
    }

    public void registerServices(AbstractActivator abstractActivator) {
        this.logChannel.log(1000000, "[ServiceManagerRemoteServices#registerServices] activator: %1", (Object)abstractActivator);
        abstractActivator.registerService((class$de$audi$atip$interapp$bap$remoteservices$BAPServiceRemoteServices == null ? (class$de$audi$atip$interapp$bap$remoteservices$BAPServiceRemoteServices = ServiceManagerRemoteServices.class$("de.audi.atip.interapp.bap.remoteservices.BAPServiceRemoteServices")) : class$de$audi$atip$interapp$bap$remoteservices$BAPServiceRemoteServices).getName(), this.module.getAppConnectors().get("AppBapRemoteServices"), null);
    }

    public void trackServices() {
        this.logChannel.log(1000000, "[ServiceManagerRemoteServices#trackServices]");
        String[] stringArray = new String[]{(class$de$audi$atip$interapp$bap$remoteservices$BAPServiceRemoteServicesListener == null ? (class$de$audi$atip$interapp$bap$remoteservices$BAPServiceRemoteServicesListener = ServiceManagerRemoteServices.class$("de.audi.atip.interapp.bap.remoteservices.BAPServiceRemoteServicesListener")) : class$de$audi$atip$interapp$bap$remoteservices$BAPServiceRemoteServicesListener).getName(), (class$de$audi$atip$diag$sw$SwDiagnosisManager == null ? (class$de$audi$atip$diag$sw$SwDiagnosisManager = ServiceManagerRemoteServices.class$("de.audi.atip.diag.sw.SwDiagnosisManager")) : class$de$audi$atip$diag$sw$SwDiagnosisManager).getName()};
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

