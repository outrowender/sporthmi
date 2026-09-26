/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  de.mib.swdiagnosis.combi.CombiDiagnosisConnectorPhone
 */
package de.audi.app.combi.bap.app.phone;

import de.audi.app.bap.AbstractBAPApplication;
import de.audi.app.bap.fw.IBAPFunctionFactoryFSG;
import de.audi.app.bap.fw.IFunctionRegistrationFSG;
import de.audi.app.bap.fw.functiontypes.BAPFunctionPropertyFSG;
import de.audi.app.bap.fw.request.IDataTypeMapping;
import de.audi.app.bap.generated.phone.DataTypeMappingPhone;
import de.audi.app.bap.generated.phone.ErrorCodesPhone;
import de.audi.app.bap.generated.phone.FunctionIDsPhone;
import de.audi.app.bap.generated.phone.FunctionRegistrationPhone;
import de.audi.app.bap.utils.IErrorCodes;
import de.audi.app.bap.utils.IFunctionIDs;
import de.audi.app.combi.bap.AbstractCombiBAPApplication;
import de.audi.app.combi.bap.app.phone.AbstractFunctionListPhone;
import de.audi.app.combi.bap.app.phone.AppConnectorAddressBook;
import de.audi.app.combi.bap.app.phone.AppConnectorConnectivity;
import de.audi.app.combi.bap.app.phone.AppConnectorMessaging;
import de.audi.app.combi.bap.app.phone.AppConnectorPhone;
import de.audi.app.combi.bap.app.phone.BAPIndicationHandlerPhone;
import de.audi.app.combi.bap.app.phone.InitializationManagerPhone;
import de.audi.app.combi.bap.app.phone.ServiceManagerPhone;
import de.audi.app.combi.bap.app.phone.list.ListManagerPhone;
import de.audi.app.combi.bap.app.phone2.CombiModulePhone2;
import de.audi.app.combi.bap.fw.AbstractCombiModule;
import de.audi.atip.interapp.combi.bap.phone.CombiBAPServiceAddressBook;
import de.audi.atip.interapp.combi.bap.phone.CombiBAPServiceAddressBookListener;
import de.audi.atip.interapp.combi.bap.phone.CombiBAPServiceConnectivity;
import de.audi.atip.interapp.combi.bap.phone.CombiBAPServiceMessaging;
import de.audi.atip.interapp.combi.bap.phone.CombiBAPServiceMessagingListener;
import de.audi.atip.interapp.combi.bap.phone.CombiBAPServicePhone;
import de.audi.atip.interapp.combi.bap.phone.CombiBAPServicePhoneListener;
import de.mib.swdiagnosis.combi.CombiDiagnosisConnectorPhone;
import de.vw.mib.bap.generated.telephone.serializer.CallDurationSync_Status;
import org.osgi.framework.BundleContext;

public class CombiModulePhone
extends AbstractCombiModule {
    private static final int[] ERROR_MAPPING = new int[10];
    private AppConnectorPhone appConnectorPhone;
    private AppConnectorAddressBook appConnectorAddressBook;
    private AppConnectorMessaging appConnectorMessaging;
    private AppConnectorConnectivity appConnectorConnectivity;

    public CombiModulePhone(AbstractCombiBAPApplication abstractCombiBAPApplication, AbstractFunctionListPhone abstractFunctionListPhone) {
        this(abstractCombiBAPApplication, abstractFunctionListPhone, null);
    }

    public CombiModulePhone(AbstractCombiBAPApplication abstractCombiBAPApplication, AbstractFunctionListPhone abstractFunctionListPhone, IBAPFunctionFactoryFSG iBAPFunctionFactoryFSG) {
        super(40, (AbstractBAPApplication)abstractCombiBAPApplication, iBAPFunctionFactoryFSG);
        this.functionListFsg = abstractFunctionListPhone;
        this.functionListFsg.init(this);
        this.appConnectorPhone = new AppConnectorPhone(this);
        this.addAppConnector("Phone", this.appConnectorPhone);
        this.appConnectorAddressBook = new AppConnectorAddressBook(this);
        this.addAppConnector("AddressBook", this.appConnectorAddressBook);
        this.appConnectorMessaging = new AppConnectorMessaging(this);
        this.addAppConnector("Messaging", this.appConnectorMessaging);
        this.appConnectorConnectivity = new AppConnectorConnectivity(this);
        this.addAppConnector("Connectivity", this.appConnectorConnectivity);
        this.listManager = new ListManagerPhone(this, abstractCombiBAPApplication.isMOSTListSupported());
    }

    @Override
    protected void initModuleComponents() {
        this.logChannel.log(-2137614336, "[CombiModulePhone#initModuleComponents]");
        this.indicationHandler = new BAPIndicationHandlerPhone(this);
        this.functionRegistration = CombiModulePhone.customInitialize(new FunctionRegistrationPhone(this));
        this.initializationManager = new InitializationManagerPhone(this, this.getBAPFunctionPropertyFSG(15), this.getBAPFunctionPropertyFSG(22), this.bapApplication.getDSIBAPController(), this.bapApplication.getPowerState());
    }

    private static IFunctionRegistrationFSG customInitialize(FunctionRegistrationPhone functionRegistrationPhone) {
        CallDurationSync_Status callDurationSync_Status = new CallDurationSync_Status();
        callDurationSync_Status.timeStampCall0 = -65536;
        callDurationSync_Status.timeStampCall1 = -65536;
        callDurationSync_Status.timeStampCall2 = -65536;
        callDurationSync_Status.timeStampCall3 = -65536;
        callDurationSync_Status.timeStampCall4 = -65536;
        callDurationSync_Status.timeStampCall5 = -65536;
        callDurationSync_Status.timeStampCall6 = -65536;
        BAPFunctionPropertyFSG bAPFunctionPropertyFSG = functionRegistrationPhone.getBAPFunctionPropertyFSG(24);
        bAPFunctionPropertyFSG.setInitialStatus(callDurationSync_Status);
        return functionRegistrationPhone;
    }

    @Override
    protected void initServiceManager(BundleContext bundleContext) {
        this.serviceManager = new ServiceManagerPhone(this, bundleContext);
    }

    @Override
    protected void initDiagnosisConnector() {
        this.diagnosisConnectorFsg = new CombiDiagnosisConnectorPhone((AbstractCombiBAPApplication)this.bapApplication, this);
    }

    @Override
    public String getLSGDescription() {
        return "0x28 (PHONE)";
    }

    @Override
    public IFunctionIDs getFunctionIDs() {
        return new FunctionIDsPhone();
    }

    @Override
    public IErrorCodes getErrorIDs() {
        return new ErrorCodesPhone();
    }

    @Override
    public int[] getErrorMapping() {
        return ERROR_MAPPING;
    }

    @Override
    public IDataTypeMapping getDataTypeMapping() {
        return new DataTypeMappingPhone();
    }

    public CombiBAPServicePhone getPhoneService() {
        return this.appConnectorPhone;
    }

    public CombiBAPServicePhoneListener getPhoneServiceListener() {
        return (CombiBAPServicePhoneListener)this.appConnectorPhone.getAppServiceListener();
    }

    public CombiBAPServiceAddressBook getAddressbookService() {
        return this.appConnectorAddressBook;
    }

    public CombiBAPServiceAddressBookListener getAddressbookServiceListener() {
        return (CombiBAPServiceAddressBookListener)this.appConnectorAddressBook.getAppServiceListener();
    }

    public CombiBAPServiceMessaging getMessagingService() {
        return this.appConnectorMessaging;
    }

    public CombiBAPServiceMessagingListener getMessagingServiceListener() {
        return (CombiBAPServiceMessagingListener)this.appConnectorMessaging.getAppServiceListener();
    }

    public CombiBAPServiceConnectivity getConnectivityService() {
        return this.appConnectorConnectivity;
    }

    public CombiModulePhone2 getPhone2Module() {
        return (CombiModulePhone2)this.bapApplication.getModule(41);
    }

    static {
        CombiModulePhone.ERROR_MAPPING[0] = 65;
        CombiModulePhone.ERROR_MAPPING[1] = 65;
        CombiModulePhone.ERROR_MAPPING[2] = 65;
        CombiModulePhone.ERROR_MAPPING[3] = 80;
        CombiModulePhone.ERROR_MAPPING[4] = 65;
        CombiModulePhone.ERROR_MAPPING[5] = 65;
        CombiModulePhone.ERROR_MAPPING[6] = 66;
        CombiModulePhone.ERROR_MAPPING[7] = 65;
        CombiModulePhone.ERROR_MAPPING[8] = 34;
        CombiModulePhone.ERROR_MAPPING[9] = 67;
    }
}

