/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.combi.bap.app.phone;

import de.audi.app.bap.fw.AbstractBAPModuleServiceManager;
import de.audi.app.combi.bap.app.phone.AppConnectorAddressBook;
import de.audi.app.combi.bap.app.phone.AppConnectorMessaging;
import de.audi.app.combi.bap.app.phone.AppConnectorPhone;
import de.audi.app.combi.bap.fw.AbstractCombiModule;
import de.audi.atip.activator.AbstractActivator;
import de.audi.atip.interapp.combi.bap.phone.CombiBAPServiceAddressBookListener;
import de.audi.atip.interapp.combi.bap.phone.CombiBAPServiceMessagingListener;
import de.audi.atip.interapp.combi.bap.phone.CombiBAPServicePhoneListener;
import de.audi.atip.log.LogChannel;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;
import org.osgi.util.tracker.ServiceTracker;
import org.osgi.util.tracker.ServiceTrackerCustomizer;

public class ServiceManagerPhone
extends AbstractBAPModuleServiceManager {
    private final LogChannel logChannel;
    static /* synthetic */ Class class$de$audi$atip$interapp$combi$bap$phone$CombiBAPServicePhone;
    static /* synthetic */ Class class$de$audi$atip$interapp$combi$bap$phone$CombiBAPServiceAddressBook;
    static /* synthetic */ Class class$de$audi$atip$interapp$combi$bap$phone$CombiBAPServiceMessaging;
    static /* synthetic */ Class class$de$audi$atip$interapp$combi$bap$phone$CombiBAPServiceConnectivity;
    static /* synthetic */ Class class$de$audi$atip$msg$MsgListener;
    static /* synthetic */ Class class$de$audi$atip$interapp$combi$bap$phone$CombiBAPServicePhoneListener;
    static /* synthetic */ Class class$de$audi$atip$interapp$combi$bap$phone$CombiBAPServiceAddressBookListener;
    static /* synthetic */ Class class$de$audi$atip$diag$sw$SwDiagnosisManager;

    public ServiceManagerPhone(AbstractCombiModule abstractCombiModule, BundleContext bundleContext) {
        super(abstractCombiModule, bundleContext);
        this.logChannel = abstractCombiModule.getLogChannel();
    }

    public Object addingService(ServiceReference serviceReference) {
        Object object = this.bundleContext.getService(serviceReference);
        if (object instanceof CombiBAPServicePhoneListener) {
            this.logChannel.log(10000000, "[ServiceManagerPhone#addingService] CombiBAPServicePhoneListener found");
            ((AppConnectorPhone)this.module.getAppConnectors().get("Phone")).setAppServiceListener((CombiBAPServicePhoneListener)object);
            return object;
        }
        if (object instanceof CombiBAPServiceAddressBookListener) {
            this.logChannel.log(10000000, "[ServiceManagerPhone#addingService] CombiBAPServiceAddressBookListener found");
            ((AppConnectorAddressBook)this.module.getAppConnectors().get("AddressBook")).setAppServiceListener((CombiBAPServiceAddressBookListener)object);
            return object;
        }
        if (object instanceof CombiBAPServiceMessagingListener) {
            this.logChannel.log(10000000, "[ServiceManagerPhone#addingService] CombiBAPServiceMessagingListener found");
            ((AppConnectorMessaging)this.module.getAppConnectors().get("Messaging")).setAppServiceListener((CombiBAPServiceMessagingListener)object);
            return object;
        }
        this.bundleContext.ungetService(serviceReference);
        return super.addingService(serviceReference);
    }

    public void removedService(ServiceReference serviceReference, Object object) {
        if (object instanceof CombiBAPServicePhoneListener) {
            this.logChannel.log(10000000, "[ServiceManagerPhone#removedService] CombiBAPServicePhoneListener removed");
            ((AppConnectorPhone)this.module.getAppConnectors().get("Phone")).setAppServiceListener(null);
            this.bundleContext.ungetService(serviceReference);
        } else if (object instanceof CombiBAPServiceAddressBookListener) {
            this.logChannel.log(10000000, "[ServiceManagerPhone#removedService] CombiBAPServiceAddressBookListener removed");
            ((AppConnectorAddressBook)this.module.getAppConnectors().get("AddressBook")).setAppServiceListener(null);
            this.bundleContext.ungetService(serviceReference);
        } else if (object instanceof CombiBAPServiceMessagingListener) {
            this.logChannel.log(10000000, "[ServiceManagerPhone#removedService] CombiBAPServiceMessagingListener removed");
            ((AppConnectorMessaging)this.module.getAppConnectors().get("Messaging")).setAppServiceListener(null);
            this.bundleContext.ungetService(serviceReference);
        } else {
            super.removedService(serviceReference, object);
        }
    }

    public void registerServices(AbstractActivator abstractActivator) {
        this.logChannel.log(10000000, "[ServiceManagerPhone#registerServices] Registering AppConnectorPhone as CombiBAPServicePhone");
        abstractActivator.registerService((class$de$audi$atip$interapp$combi$bap$phone$CombiBAPServicePhone == null ? (class$de$audi$atip$interapp$combi$bap$phone$CombiBAPServicePhone = ServiceManagerPhone.class$("de.audi.atip.interapp.combi.bap.phone.CombiBAPServicePhone")) : class$de$audi$atip$interapp$combi$bap$phone$CombiBAPServicePhone).getName(), this.module.getAppConnectors().get("Phone"), null);
        this.logChannel.log(10000000, "[ServiceManagerPhone#registerServices] Registering AppConnectorAddressBook as CombiBAPServiceAddressBook");
        abstractActivator.registerService((class$de$audi$atip$interapp$combi$bap$phone$CombiBAPServiceAddressBook == null ? (class$de$audi$atip$interapp$combi$bap$phone$CombiBAPServiceAddressBook = ServiceManagerPhone.class$("de.audi.atip.interapp.combi.bap.phone.CombiBAPServiceAddressBook")) : class$de$audi$atip$interapp$combi$bap$phone$CombiBAPServiceAddressBook).getName(), this.module.getAppConnectors().get("AddressBook"), null);
        this.logChannel.log(10000000, "[ServiceManagerPhone#registerServices] Registering AppConnectorMessaging as CombiBAPServiceMessaging");
        abstractActivator.registerService((class$de$audi$atip$interapp$combi$bap$phone$CombiBAPServiceMessaging == null ? (class$de$audi$atip$interapp$combi$bap$phone$CombiBAPServiceMessaging = ServiceManagerPhone.class$("de.audi.atip.interapp.combi.bap.phone.CombiBAPServiceMessaging")) : class$de$audi$atip$interapp$combi$bap$phone$CombiBAPServiceMessaging).getName(), this.module.getAppConnectors().get("Messaging"), null);
        this.logChannel.log(10000000, "[ServiceManagerPhone#registerServices] Registering AppConnectorConnectivity as CombiBAPServiceConnectivity");
        abstractActivator.registerService((class$de$audi$atip$interapp$combi$bap$phone$CombiBAPServiceConnectivity == null ? (class$de$audi$atip$interapp$combi$bap$phone$CombiBAPServiceConnectivity = ServiceManagerPhone.class$("de.audi.atip.interapp.combi.bap.phone.CombiBAPServiceConnectivity")) : class$de$audi$atip$interapp$combi$bap$phone$CombiBAPServiceConnectivity).getName(), this.module.getAppConnectors().get("Connectivity"), null);
        this.logChannel.log(10000000, "[ServiceManagerPhone#registerServices] Registering InitializationManagerPhone as MessageListener");
        abstractActivator.registerService((class$de$audi$atip$msg$MsgListener == null ? (class$de$audi$atip$msg$MsgListener = ServiceManagerPhone.class$("de.audi.atip.msg.MsgListener")) : class$de$audi$atip$msg$MsgListener).getName(), (Object)this.module.getInitializationManager(), null);
    }

    public void trackServices() {
        String[] stringArray = new String[]{(class$de$audi$atip$interapp$combi$bap$phone$CombiBAPServicePhoneListener == null ? (class$de$audi$atip$interapp$combi$bap$phone$CombiBAPServicePhoneListener = ServiceManagerPhone.class$("de.audi.atip.interapp.combi.bap.phone.CombiBAPServicePhoneListener")) : class$de$audi$atip$interapp$combi$bap$phone$CombiBAPServicePhoneListener).getName(), (class$de$audi$atip$interapp$combi$bap$phone$CombiBAPServiceAddressBookListener == null ? (class$de$audi$atip$interapp$combi$bap$phone$CombiBAPServiceAddressBookListener = ServiceManagerPhone.class$("de.audi.atip.interapp.combi.bap.phone.CombiBAPServiceAddressBookListener")) : class$de$audi$atip$interapp$combi$bap$phone$CombiBAPServiceAddressBookListener).getName(), (class$de$audi$atip$diag$sw$SwDiagnosisManager == null ? (class$de$audi$atip$diag$sw$SwDiagnosisManager = ServiceManagerPhone.class$("de.audi.atip.diag.sw.SwDiagnosisManager")) : class$de$audi$atip$diag$sw$SwDiagnosisManager).getName()};
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

