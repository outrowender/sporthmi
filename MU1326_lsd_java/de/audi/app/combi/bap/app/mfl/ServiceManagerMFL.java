/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.combi.bap.app.mfl;

import de.audi.app.bap.fw.AbstractBAPModuleServiceManager;
import de.audi.app.combi.bap.app.mfl.AppConnectorMFL;
import de.audi.app.combi.bap.app.mfl.CombiModuleMFL;
import de.audi.app.combi.bap.fw.AbstractCombiModule;
import de.audi.atip.activator.AbstractActivator;
import de.audi.atip.interapp.combi.bap.PartialPopupBAPServiceListener;
import de.audi.atip.interapp.combi.bap.mfl.CombiBAPServiceMFLListener;
import de.audi.atip.log.LogChannel;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;
import org.osgi.util.tracker.ServiceTracker;
import org.osgi.util.tracker.ServiceTrackerCustomizer;

public class ServiceManagerMFL
extends AbstractBAPModuleServiceManager {
    private final LogChannel logChannel;
    static /* synthetic */ Class class$de$audi$atip$interapp$combi$bap$mfl$CombiBAPServiceMFLListener;
    static /* synthetic */ Class class$de$audi$atip$interapp$combi$bap$PartialPopupBAPServiceListener;
    static /* synthetic */ Class class$de$audi$atip$interapp$combi$bap$mfl$CombiBAPServiceMFL;
    static /* synthetic */ Class class$de$audi$atip$msg$MsgListener;
    static /* synthetic */ Class class$de$audi$atip$interapp$combi$bap$PartialPopupBAPService;
    static /* synthetic */ Class class$de$audi$atip$diag$sw$SwDiagnosisManager;

    public ServiceManagerMFL(AbstractCombiModule abstractCombiModule, BundleContext bundleContext) {
        super(abstractCombiModule, bundleContext);
        this.logChannel = abstractCombiModule.getLogChannel();
    }

    public Object addingService(ServiceReference serviceReference) {
        Object object = this.bundleContext.getService(serviceReference);
        if (object instanceof CombiBAPServiceMFLListener) {
            this.logChannel.log(10000000, "[ServiceManagerMFL#addingService] %1 found", (Object)(class$de$audi$atip$interapp$combi$bap$mfl$CombiBAPServiceMFLListener == null ? (class$de$audi$atip$interapp$combi$bap$mfl$CombiBAPServiceMFLListener = ServiceManagerMFL.class$("de.audi.atip.interapp.combi.bap.mfl.CombiBAPServiceMFLListener")) : class$de$audi$atip$interapp$combi$bap$mfl$CombiBAPServiceMFLListener).getName());
            ((AppConnectorMFL)this.module.getAppConnectors().get("Car")).setAppServiceListener((CombiBAPServiceMFLListener)object);
            return object;
        }
        if (object instanceof PartialPopupBAPServiceListener) {
            this.logChannel.log(10000000, "[ServiceManagerMFL#addingService] %1 found", (Object)(class$de$audi$atip$interapp$combi$bap$PartialPopupBAPServiceListener == null ? (class$de$audi$atip$interapp$combi$bap$PartialPopupBAPServiceListener = ServiceManagerMFL.class$("de.audi.atip.interapp.combi.bap.PartialPopupBAPServiceListener")) : class$de$audi$atip$interapp$combi$bap$PartialPopupBAPServiceListener).getName());
            ((CombiModuleMFL)this.module).getPartialPopupHandler().setPartialPopupBAPServiceListener((PartialPopupBAPServiceListener)object);
            this.module.getInitializationManager().notifyAppServiceChanged(true);
            return object;
        }
        this.bundleContext.ungetService(serviceReference);
        return super.addingService(serviceReference);
    }

    public void removedService(ServiceReference serviceReference, Object object) {
        if (object instanceof CombiBAPServiceMFLListener) {
            this.logChannel.log(10000000, "[ServiceManagerMFL#removedService] CombiBAPServiceMFLListener removed");
            ((AppConnectorMFL)this.module.getAppConnectors().get("Car")).setAppServiceListener(null);
            this.bundleContext.ungetService(serviceReference);
        } else {
            this.logChannel.log(100000, "[ServiceManagerMFL#removedService] removing unknown service: %1", (Object)serviceReference);
            super.removedService(serviceReference, object);
        }
    }

    public void registerServices(AbstractActivator abstractActivator) {
        this.logChannel.log(10000000, "[ServiceManagerMFL#registerServices] Registering appConnectorMFL as CombiBAPServiceMFL");
        abstractActivator.registerService((class$de$audi$atip$interapp$combi$bap$mfl$CombiBAPServiceMFL == null ? (class$de$audi$atip$interapp$combi$bap$mfl$CombiBAPServiceMFL = ServiceManagerMFL.class$("de.audi.atip.interapp.combi.bap.mfl.CombiBAPServiceMFL")) : class$de$audi$atip$interapp$combi$bap$mfl$CombiBAPServiceMFL).getName(), this.module.getAppConnectors().get("Car"), null);
        this.logChannel.log(10000000, "[ServiceManagerMFL#registerServices] Registering MFLKeyHandler as MessageListener");
        abstractActivator.registerService((class$de$audi$atip$msg$MsgListener == null ? (class$de$audi$atip$msg$MsgListener = ServiceManagerMFL.class$("de.audi.atip.msg.MsgListener")) : class$de$audi$atip$msg$MsgListener).getName(), (Object)((CombiModuleMFL)this.module).getMFLKeyHandler(), null);
        this.logChannel.log(10000000, "[ServiceManagerMFL#registerServices] Registering InitializationManagerMFL as MessageListener");
        abstractActivator.registerService((class$de$audi$atip$msg$MsgListener == null ? (class$de$audi$atip$msg$MsgListener = ServiceManagerMFL.class$("de.audi.atip.msg.MsgListener")) : class$de$audi$atip$msg$MsgListener).getName(), (Object)this.module.getInitializationManager(), null);
        this.logChannel.log(10000000, "[ServiceManagerMFL#registerServices] Registering PartialPopupHandler as PartialPopupBAPService");
        abstractActivator.registerService((class$de$audi$atip$interapp$combi$bap$PartialPopupBAPService == null ? (class$de$audi$atip$interapp$combi$bap$PartialPopupBAPService = ServiceManagerMFL.class$("de.audi.atip.interapp.combi.bap.PartialPopupBAPService")) : class$de$audi$atip$interapp$combi$bap$PartialPopupBAPService).getName(), (Object)((CombiModuleMFL)this.module).getPartialPopupHandler(), null);
    }

    public void trackServices() {
        String[] stringArray = new String[]{(class$de$audi$atip$interapp$combi$bap$mfl$CombiBAPServiceMFLListener == null ? (class$de$audi$atip$interapp$combi$bap$mfl$CombiBAPServiceMFLListener = ServiceManagerMFL.class$("de.audi.atip.interapp.combi.bap.mfl.CombiBAPServiceMFLListener")) : class$de$audi$atip$interapp$combi$bap$mfl$CombiBAPServiceMFLListener).getName(), (class$de$audi$atip$interapp$combi$bap$PartialPopupBAPServiceListener == null ? (class$de$audi$atip$interapp$combi$bap$PartialPopupBAPServiceListener = ServiceManagerMFL.class$("de.audi.atip.interapp.combi.bap.PartialPopupBAPServiceListener")) : class$de$audi$atip$interapp$combi$bap$PartialPopupBAPServiceListener).getName(), (class$de$audi$atip$diag$sw$SwDiagnosisManager == null ? (class$de$audi$atip$diag$sw$SwDiagnosisManager = ServiceManagerMFL.class$("de.audi.atip.diag.sw.SwDiagnosisManager")) : class$de$audi$atip$diag$sw$SwDiagnosisManager).getName()};
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

