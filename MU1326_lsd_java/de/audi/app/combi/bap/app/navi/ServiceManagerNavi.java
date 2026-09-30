/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.combi.bap.app.navi;

import de.audi.app.bap.fw.AbstractBAPModuleServiceManager;
import de.audi.app.combi.bap.app.navi.AppConnectorNavi;
import de.audi.app.combi.bap.app.navi.CombiModuleNavi;
import de.audi.app.combi.bap.fw.AbstractCombiModule;
import de.audi.atip.activator.AbstractActivator;
import de.audi.atip.interapp.ExternalKeyListener;
import de.audi.atip.interapp.combi.bap.navi.CombiBAPServiceNaviListener;
import de.audi.atip.log.LogChannel;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;
import org.osgi.util.tracker.ServiceTracker;
import org.osgi.util.tracker.ServiceTrackerCustomizer;

public class ServiceManagerNavi
extends AbstractBAPModuleServiceManager {
    private final LogChannel logChannel;
    static /* synthetic */ Class class$de$audi$atip$interapp$combi$bap$navi$CombiBAPServiceNavi;
    static /* synthetic */ Class class$de$audi$atip$msg$MsgListener;
    static /* synthetic */ Class class$de$audi$atip$interapp$combi$bap$navi$CombiBAPServiceNaviListener;
    static /* synthetic */ Class class$de$audi$atip$diag$sw$SwDiagnosisManager;

    public ServiceManagerNavi(AbstractCombiModule abstractCombiModule, BundleContext bundleContext) {
        super(abstractCombiModule, bundleContext);
        this.logChannel = abstractCombiModule.getLogChannel();
    }

    public Object addingService(ServiceReference serviceReference) {
        Object object = this.bundleContext.getService(serviceReference);
        if (object instanceof CombiBAPServiceNaviListener) {
            this.logChannel.log(10000000, "[ServiceManagerNavi#addingService] CombiBAPServiceNaviListener found");
            ((AppConnectorNavi)this.module.getAppConnectors().get("Navi")).setAppServiceListener((CombiBAPServiceNaviListener)object);
            return object;
        }
        if (object instanceof ExternalKeyListener) {
            this.logChannel.log(10000000, "[ServiceManagerNavi#addingService] ExternalKeyListener found");
            ((CombiModuleNavi)this.module).setExternalKeyListener((ExternalKeyListener)object);
            return object;
        }
        this.bundleContext.ungetService(serviceReference);
        return super.addingService(serviceReference);
    }

    public void removedService(ServiceReference serviceReference, Object object) {
        if (object instanceof CombiBAPServiceNaviListener) {
            this.logChannel.log(10000000, "[ServiceManagerNavi#removedService] CombiBAPServiceNaviListener removed");
            ((AppConnectorNavi)this.module.getAppConnectors().get("Navi")).setAppServiceListener(null);
            this.bundleContext.ungetService(serviceReference);
        } else {
            super.removedService(serviceReference, object);
        }
    }

    public void registerServices(AbstractActivator abstractActivator) {
        this.logChannel.log(10000000, "[ServiceManagerNavi#registerServices] Registering AppConnectorNavi as CombiBAPServiceNavi");
        abstractActivator.registerService((class$de$audi$atip$interapp$combi$bap$navi$CombiBAPServiceNavi == null ? (class$de$audi$atip$interapp$combi$bap$navi$CombiBAPServiceNavi = ServiceManagerNavi.class$("de.audi.atip.interapp.combi.bap.navi.CombiBAPServiceNavi")) : class$de$audi$atip$interapp$combi$bap$navi$CombiBAPServiceNavi).getName(), this.module.getAppConnectors().get("Navi"), null);
        this.logChannel.log(10000000, "[ServiceManagerNavi#registerServices] Registering InitializationManagerNavi as MessageListener");
        abstractActivator.registerService((class$de$audi$atip$msg$MsgListener == null ? (class$de$audi$atip$msg$MsgListener = ServiceManagerNavi.class$("de.audi.atip.msg.MsgListener")) : class$de$audi$atip$msg$MsgListener).getName(), (Object)this.module.getInitializationManager(), null);
    }

    public void trackServices() {
        String[] stringArray = new String[]{(class$de$audi$atip$interapp$combi$bap$navi$CombiBAPServiceNaviListener == null ? (class$de$audi$atip$interapp$combi$bap$navi$CombiBAPServiceNaviListener = ServiceManagerNavi.class$("de.audi.atip.interapp.combi.bap.navi.CombiBAPServiceNaviListener")) : class$de$audi$atip$interapp$combi$bap$navi$CombiBAPServiceNaviListener).getName(), (class$de$audi$atip$diag$sw$SwDiagnosisManager == null ? (class$de$audi$atip$diag$sw$SwDiagnosisManager = ServiceManagerNavi.class$("de.audi.atip.diag.sw.SwDiagnosisManager")) : class$de$audi$atip$diag$sw$SwDiagnosisManager).getName()};
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

