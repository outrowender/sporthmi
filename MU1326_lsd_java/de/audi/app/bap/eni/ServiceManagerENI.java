/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.bap.eni;

import de.audi.app.bap.eni.AppConnectorENI;
import de.audi.app.bap.fw.AbstractBAPModule;
import de.audi.app.bap.fw.AbstractBAPModuleServiceManager;
import de.audi.atip.activator.AbstractActivator;
import de.audi.atip.interapp.bap.BAPServiceListener;
import de.audi.atip.interapp.bap.eni.BAPServiceENIListener;
import de.audi.atip.log.LogChannel;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;
import org.osgi.util.tracker.ServiceTracker;
import org.osgi.util.tracker.ServiceTrackerCustomizer;

public class ServiceManagerENI
extends AbstractBAPModuleServiceManager {
    private LogChannel logChannel;
    static /* synthetic */ Class class$de$audi$atip$interapp$bap$eni$BAPServiceENI;
    static /* synthetic */ Class class$de$audi$atip$interapp$bap$eni$BAPServiceENIListener;
    static /* synthetic */ Class class$de$audi$atip$diag$sw$SwDiagnosisManager;

    public ServiceManagerENI(AbstractBAPModule abstractBAPModule, BundleContext bundleContext) {
        super(abstractBAPModule, bundleContext);
        this.logChannel = abstractBAPModule.getLogChannel();
    }

    public Object addingService(ServiceReference serviceReference) {
        Object object = this.bundleContext.getService(serviceReference);
        if (object instanceof BAPServiceENIListener) {
            this.logChannel.log(1000000, "[ServiceManagerENI#addingService] BAPServiceENIListener found");
            ((AppConnectorENI)this.module.getAppConnectors().get("AppBapENI")).setAppServiceListener((BAPServiceListener)object);
            this.module.getInitializationManager().notifyAppServiceChanged(true);
            return object;
        }
        this.bundleContext.ungetService(serviceReference);
        return super.addingService(serviceReference);
    }

    public void removedService(ServiceReference serviceReference, Object object) {
        if (object instanceof BAPServiceENIListener) {
            this.logChannel.log(10000000, "[ServiceManagerENI#removedService] BAPServiceENIListener removed");
            ((AppConnectorENI)this.module.getAppConnectors().get("AppBapENI")).setAppServiceListener(null);
            this.bundleContext.ungetService(serviceReference);
        } else {
            super.removedService(serviceReference, object);
        }
    }

    public void registerServices(AbstractActivator abstractActivator) {
        this.logChannel.log(1000000, "[ServiceManagerENI#registerServices] activator: %1", (Object)abstractActivator);
        abstractActivator.registerService((class$de$audi$atip$interapp$bap$eni$BAPServiceENI == null ? (class$de$audi$atip$interapp$bap$eni$BAPServiceENI = ServiceManagerENI.class$("de.audi.atip.interapp.bap.eni.BAPServiceENI")) : class$de$audi$atip$interapp$bap$eni$BAPServiceENI).getName(), this.module.getAppConnectors().get("AppBapENI"), null);
    }

    public void trackServices() {
        this.logChannel.log(1000000, "[ServiceManagerENI#trackServices]");
        String[] stringArray = new String[]{(class$de$audi$atip$interapp$bap$eni$BAPServiceENIListener == null ? (class$de$audi$atip$interapp$bap$eni$BAPServiceENIListener = ServiceManagerENI.class$("de.audi.atip.interapp.bap.eni.BAPServiceENIListener")) : class$de$audi$atip$interapp$bap$eni$BAPServiceENIListener).getName(), (class$de$audi$atip$diag$sw$SwDiagnosisManager == null ? (class$de$audi$atip$diag$sw$SwDiagnosisManager = ServiceManagerENI.class$("de.audi.atip.diag.sw.SwDiagnosisManager")) : class$de$audi$atip$diag$sw$SwDiagnosisManager).getName()};
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

