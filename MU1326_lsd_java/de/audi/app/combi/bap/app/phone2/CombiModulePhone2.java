/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  de.mib.swdiagnosis.combi.CombiDiagnosisConnectorPhone2
 */
package de.audi.app.combi.bap.app.phone2;

import de.audi.app.bap.fw.IBAPFunctionFactoryFSG;
import de.audi.app.bap.fw.request.IDataTypeMapping;
import de.audi.app.bap.generated.phone2.DataTypeMappingPhone2;
import de.audi.app.bap.generated.phone2.ErrorCodesPhone2;
import de.audi.app.bap.generated.phone2.FunctionIDsPhone2;
import de.audi.app.bap.generated.phone2.FunctionRegistrationPhone2;
import de.audi.app.bap.utils.IErrorCodes;
import de.audi.app.bap.utils.IFunctionIDs;
import de.audi.app.combi.bap.AbstractCombiBAPApplication;
import de.audi.app.combi.bap.app.phone2.AbstractFunctionListPhone2;
import de.audi.app.combi.bap.app.phone2.AppConnectorPhone2;
import de.audi.app.combi.bap.app.phone2.BAPIndicationHandlerPhone2;
import de.audi.app.combi.bap.app.phone2.InitializationManagerPhone2;
import de.audi.app.combi.bap.app.phone2.ServiceManagerPhone2;
import de.audi.app.combi.bap.fw.AbstractCombiModule;
import de.audi.atip.interapp.combi.bap.phone.CombiBAPServicePhone2;
import de.audi.atip.interapp.combi.bap.phone.CombiBAPServicePhone2Listener;
import de.mib.swdiagnosis.combi.CombiDiagnosisConnectorPhone2;
import org.osgi.framework.BundleContext;

public class CombiModulePhone2
extends AbstractCombiModule {
    private static final int[] ERROR_MAPPING = new int[10];
    private AppConnectorPhone2 appConnectorPhone;

    public CombiModulePhone2(AbstractCombiBAPApplication abstractCombiBAPApplication, AbstractFunctionListPhone2 abstractFunctionListPhone2) {
        this(abstractCombiBAPApplication, abstractFunctionListPhone2, null);
    }

    public CombiModulePhone2(AbstractCombiBAPApplication abstractCombiBAPApplication, AbstractFunctionListPhone2 abstractFunctionListPhone2, IBAPFunctionFactoryFSG iBAPFunctionFactoryFSG) {
        super(41, abstractCombiBAPApplication);
        this.functionListFsg = abstractFunctionListPhone2;
        this.functionListFsg.init(this);
        this.appConnectorPhone = new AppConnectorPhone2(this);
        this.addAppConnector("Phone", this.appConnectorPhone);
    }

    protected void initModuleComponents() {
        this.logChannel.log(10000000, "[CombiModulePhone2#initModuleComponents]");
        this.indicationHandler = new BAPIndicationHandlerPhone2(this);
        this.functionRegistration = new FunctionRegistrationPhone2(this);
        this.initializationManager = new InitializationManagerPhone2(this, this.getBAPFunctionPropertyFSG(15), this.bapApplication.getDSIBAPController(), this.bapApplication.getPowerState());
    }

    protected void initServiceManager(BundleContext bundleContext) {
        this.serviceManager = new ServiceManagerPhone2(this, bundleContext);
    }

    protected void initDiagnosisConnector() {
        this.diagnosisConnectorFsg = new CombiDiagnosisConnectorPhone2((AbstractCombiBAPApplication)this.bapApplication, this);
    }

    public String getLSGDescription() {
        return "0x29 (PHONE2)";
    }

    public IFunctionIDs getFunctionIDs() {
        return new FunctionIDsPhone2();
    }

    public IErrorCodes getErrorIDs() {
        return new ErrorCodesPhone2();
    }

    public int[] getErrorMapping() {
        return ERROR_MAPPING;
    }

    public IDataTypeMapping getDataTypeMapping() {
        return new DataTypeMappingPhone2();
    }

    public CombiBAPServicePhone2 getPhone2Service() {
        return this.appConnectorPhone;
    }

    public CombiBAPServicePhone2Listener getPhone2ServiceListener() {
        return (CombiBAPServicePhone2Listener)this.appConnectorPhone.getAppServiceListener();
    }

    static {
        CombiModulePhone2.ERROR_MAPPING[0] = 65;
        CombiModulePhone2.ERROR_MAPPING[1] = 65;
        CombiModulePhone2.ERROR_MAPPING[2] = 65;
        CombiModulePhone2.ERROR_MAPPING[3] = 80;
        CombiModulePhone2.ERROR_MAPPING[4] = 65;
        CombiModulePhone2.ERROR_MAPPING[5] = 65;
        CombiModulePhone2.ERROR_MAPPING[6] = 66;
        CombiModulePhone2.ERROR_MAPPING[7] = 65;
        CombiModulePhone2.ERROR_MAPPING[8] = 34;
        CombiModulePhone2.ERROR_MAPPING[9] = 67;
    }
}

