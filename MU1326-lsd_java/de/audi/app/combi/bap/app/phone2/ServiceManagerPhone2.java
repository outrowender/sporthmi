/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.combi.bap.app.phone2;

import de.audi.app.bap.fw.AbstractBAPModuleServiceManager;
import de.audi.app.combi.bap.app.phone2.AppConnectorPhone2;
import de.audi.app.combi.bap.fw.AbstractCombiModule;
import de.audi.atip.activator.AbstractActivator;
import de.audi.atip.interapp.combi.bap.phone.CombiBAPServicePhone2Listener;
import de.audi.atip.log.LogChannel;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;
import org.osgi.util.tracker.ServiceTracker;
import org.osgi.util.tracker.ServiceTrackerCustomizer;

public class ServiceManagerPhone2
extends AbstractBAPModuleServiceManager {
    private final LogChannel logChannel;
    static /* synthetic */ Class class$de$audi$atip$interapp$combi$bap$phone$CombiBAPServicePhone2;
    static /* synthetic */ Class class$de$audi$atip$msg$MsgListener;
    static /* synthetic */ Class class$de$audi$atip$interapp$combi$bap$phone$CombiBAPServicePhone2Listener;
    static /* synthetic */ Class class$de$audi$atip$diag$sw$SwDiagnosisManager;

    public ServiceManagerPhone2(AbstractCombiModule abstractCombiModule, BundleContext bundleContext) {
        super(abstractCombiModule, bundleContext);
        this.logChannel = abstractCombiModule.getLogChannel();
    }

    @Override
    public Object addingService(ServiceReference serviceReference) {
        Object object = this.bundleContext.getService(serviceReference);
        if (object instanceof CombiBAPServicePhone2Listener) {
            this.logChannel.log(-2137614336, "[ServiceManagerPhone2#addingService] CombiBAPServicePhoneListener found");
            ((AppConnectorPhone2)this.module.getAppConnectors().get("Phone")).setAppServiceListener((CombiBAPServicePhone2Listener)object);
            return object;
        }
        this.bundleContext.ungetService(serviceReference);
        return super.addingService(serviceReference);
    }

    @Override
    public void removedService(ServiceReference serviceReference, Object object) {
        if (object instanceof CombiBAPServicePhone2Listener) {
            this.logChannel.log(-2137614336, "[ServiceManagerPhone2#removedService] CombiBAPServicePhoneListener removed");
            ((AppConnectorPhone2)this.module.getAppConnectors().get("Phone")).setAppServiceListener(null);
            this.bundleContext.ungetService(serviceReference);
        } else {
            super.removedService(serviceReference, object);
        }
    }

    @Override
    public void registerServices(AbstractActivator abstractActivator) {
        this.logChannel.log(-2137614336, "[ServiceManagerPhone2#registerServices] Registering AppConnectorPhone as CombiBAPServicePhone");
        abstractActivator.registerService((class$de$audi$atip$interapp$combi$bap$phone$CombiBAPServicePhone2 == null ? (class$de$audi$atip$interapp$combi$bap$phone$CombiBAPServicePhone2 = ServiceManagerPhone2.class$("de.audi.atip.interapp.combi.bap.phone.CombiBAPServicePhone2")) : class$de$audi$atip$interapp$combi$bap$phone$CombiBAPServicePhone2).getName(), this.module.getAppConnectors().get("Phone"), null);
        this.logChannel.log(-2137614336, "[ServiceManagerPhone2#registerServices] Registering InitializationManagerPhone2 as MessageListener");
        abstractActivator.registerService((class$de$audi$atip$msg$MsgListener == null ? (class$de$audi$atip$msg$MsgListener = ServiceManagerPhone2.class$("de.audi.atip.msg.MsgListener")) : class$de$audi$atip$msg$MsgListener).getName(), (Object)this.module.getInitializationManager(), null);
    }

    @Override
    public void trackServices() {
        String[] stringArray = new String[]{(class$de$audi$atip$interapp$combi$bap$phone$CombiBAPServicePhone2Listener == null ? (class$de$audi$atip$interapp$combi$bap$phone$CombiBAPServicePhone2Listener = ServiceManagerPhone2.class$("de.audi.atip.interapp.combi.bap.phone.CombiBAPServicePhone2Listener")) : class$de$audi$atip$interapp$combi$bap$phone$CombiBAPServicePhone2Listener).getName(), (class$de$audi$atip$diag$sw$SwDiagnosisManager == null ? (class$de$audi$atip$diag$sw$SwDiagnosisManager = ServiceManagerPhone2.class$("de.audi.atip.diag.sw.SwDiagnosisManager")) : class$de$audi$atip$diag$sw$SwDiagnosisManager).getName()};
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

