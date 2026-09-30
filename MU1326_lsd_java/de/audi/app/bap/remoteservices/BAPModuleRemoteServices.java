/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.bap.remoteservices;

import de.audi.app.bap.AbstractBAPApplication;
import de.audi.app.bap.fw.AbstractBAPModule;
import de.audi.app.bap.fw.AbstractBAPModuleASG;
import de.audi.app.bap.fw.AbstractBAPModuleInitializationManagerASG;
import de.audi.app.bap.fw.IBAPFunctionFactoryASG;
import de.audi.app.bap.fw.request.IDataTypeMapping;
import de.audi.app.bap.generated.remoteservices.DataTypeMappingRemoteServices;
import de.audi.app.bap.generated.remoteservices.ErrorCodesRemoteServices;
import de.audi.app.bap.generated.remoteservices.FunctionIDsRemoteServices;
import de.audi.app.bap.generated.remoteservices.FunctionRegistrationRemoteServices;
import de.audi.app.bap.remoteservices.AppConnectorRemoteServices;
import de.audi.app.bap.remoteservices.BAPDiagnosisConnectorRemoteServices;
import de.audi.app.bap.remoteservices.BAPIndicationHandlerRemoteServices;
import de.audi.app.bap.remoteservices.DataRemoteServices;
import de.audi.app.bap.remoteservices.FunctionListRemoteServices;
import de.audi.app.bap.remoteservices.InitializationManagerRemoteServices;
import de.audi.app.bap.remoteservices.ServiceManagerRemoteServices;
import de.audi.app.bap.utils.IErrorCodes;
import de.audi.app.bap.utils.IFunctionIDs;
import de.audi.app.bap.utils.NullObjectFactory;
import de.audi.atip.interapp.bap.remoteservices.BAPServiceRemoteServicesListener;
import org.osgi.framework.BundleContext;

public class BAPModuleRemoteServices
extends AbstractBAPModuleASG {
    private final DataRemoteServices dataRemoteServices;
    private static final int[] ERROR_MAPPING = BAPModuleRemoteServices.errorMapping();
    static /* synthetic */ Class class$de$audi$atip$interapp$bap$remoteservices$BAPServiceRemoteServicesListener;

    public BAPModuleRemoteServices(AbstractBAPApplication abstractBAPApplication) {
        super(78, abstractBAPApplication);
        this.addAppConnector("AppBapRemoteServices", new AppConnectorRemoteServices(this, this.functionRegistration));
        this.dataRemoteServices = new DataRemoteServices(this.logChannel);
    }

    public BAPModuleRemoteServices(AbstractBAPApplication abstractBAPApplication, IBAPFunctionFactoryASG iBAPFunctionFactoryASG) {
        super(78, abstractBAPApplication, iBAPFunctionFactoryASG);
        this.addAppConnector("AppBapRemoteServices", new AppConnectorRemoteServices(this, this.functionRegistration));
        this.dataRemoteServices = new DataRemoteServices(this.logChannel);
    }

    public void updateInitState(AbstractBAPModule abstractBAPModule, int n) {
        this.logChannel.log(10000000, "[BAPModuleRemoteServices#updateInitState] initState: %1", (long)n);
        this.communicationState.updateInitState(n);
    }

    protected void onCommunicationUp() {
        this.logChannel.log(10000000, "[BAPModuleRemoteServices#onCommunicationUp]");
        ((AbstractBAPModuleInitializationManagerASG)this.initializationManager).sendSetGetProperties();
        this.getAppServiceListenerRemoteServices().onCommunicationUp();
    }

    protected void initModuleComponents() {
        this.logChannel.log(10000000, "[BAPModuleRemoteServices#initModuleComponents]");
        this.indicationHandler = new BAPIndicationHandlerRemoteServices(this);
        this.functionRegistration = new FunctionRegistrationRemoteServices(this);
        this.functionListAsg = new FunctionListRemoteServices();
        this.functionListAsg.init(this);
        this.initializationManager = new InitializationManagerRemoteServices(this, this.bapApplication.getDSIBAPController(), this.bapApplication.getPowerState());
    }

    protected void initServiceManager(BundleContext bundleContext) {
        this.serviceManager = new ServiceManagerRemoteServices(this, bundleContext);
    }

    protected String getLSGDescription() {
        return "0x4E (RemoteServices)";
    }

    protected IFunctionIDs getFunctionIDs() {
        return new FunctionIDsRemoteServices();
    }

    protected IErrorCodes getErrorIDs() {
        return new ErrorCodesRemoteServices();
    }

    public int[] getErrorMapping() {
        this.logChannel.log(10000, "[BAPModuleRemoteServices#getErrorMapping]");
        return ERROR_MAPPING;
    }

    protected IDataTypeMapping getDataTypeMapping() {
        return new DataTypeMappingRemoteServices();
    }

    protected void initDiagnosisConnector() {
        this.diagnosisConnectorAsg = new BAPDiagnosisConnectorRemoteServices(this.bapApplication, this);
    }

    public void setAppServiceListenerRemoteServices(BAPServiceRemoteServicesListener bAPServiceRemoteServicesListener) {
        this.logChannel.log(10000000, "[BAPModuleRemoteServices#setAppServiceListenerRemoteServices] called");
        this.appConnectorRemoteServices().setAppServiceListener(bAPServiceRemoteServicesListener);
        if (bAPServiceRemoteServicesListener == null) {
            this.logChannel.log(10000000, "[BAPModuleRemoteServices#setAppServiceListenerRemoteServices] serviceListener is null!");
            return;
        }
        if (this.communicationState.isUp()) {
            this.logChannel.log(10000000, "[BAPModuleRemoteServices#setAppServiceListenerRemoteServices] notify onCommunicationUp()");
            this.getAppServiceListenerRemoteServices().onCommunicationUp();
        }
    }

    public BAPServiceRemoteServicesListener getAppServiceListenerRemoteServices() {
        BAPServiceRemoteServicesListener bAPServiceRemoteServicesListener = (BAPServiceRemoteServicesListener)this.appConnectorRemoteServices().getAppServiceListener();
        if (bAPServiceRemoteServicesListener == null) {
            this.logChannel.log(10000000, "[BAPModuleRemoteServices#getAppServiceListenerRemoteServices] No app listener set. Returning a NullListener.");
            bAPServiceRemoteServicesListener = (BAPServiceRemoteServicesListener)NullObjectFactory.makeNullObjectFor(class$de$audi$atip$interapp$bap$remoteservices$BAPServiceRemoteServicesListener == null ? (class$de$audi$atip$interapp$bap$remoteservices$BAPServiceRemoteServicesListener = BAPModuleRemoteServices.class$("de.audi.atip.interapp.bap.remoteservices.BAPServiceRemoteServicesListener")) : class$de$audi$atip$interapp$bap$remoteservices$BAPServiceRemoteServicesListener);
        }
        return bAPServiceRemoteServicesListener;
    }

    public DataRemoteServices getDataRemoteServices() {
        return this.dataRemoteServices;
    }

    public void destroy() {
        this.dataRemoteServices.clear();
        super.destroy();
    }

    private AppConnectorRemoteServices appConnectorRemoteServices() {
        return (AppConnectorRemoteServices)this.getAppConnectors().get("AppBapRemoteServices");
    }

    private static int[] errorMapping() {
        int[] nArray = new int[]{65, 65, 65, 80, 65, 65, 66, 65, 34, 67};
        return nArray;
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

