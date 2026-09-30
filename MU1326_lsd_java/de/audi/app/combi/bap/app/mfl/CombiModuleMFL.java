/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  de.mib.swdiagnosis.combi.CombiDiagnosisConnectorMFL
 */
package de.audi.app.combi.bap.app.mfl;

import de.audi.app.bap.AbstractBAPApplication;
import de.audi.app.bap.fw.IBAPFunctionFactoryFSG;
import de.audi.app.bap.fw.request.IDataTypeMapping;
import de.audi.app.bap.generated.mfl.DataTypeMappingMFL;
import de.audi.app.bap.generated.mfl.ErrorCodesMFL;
import de.audi.app.bap.generated.mfl.FunctionIDsMFL;
import de.audi.app.bap.generated.mfl.FunctionRegistrationMFL;
import de.audi.app.bap.utils.IErrorCodes;
import de.audi.app.bap.utils.IFunctionIDs;
import de.audi.app.combi.bap.AbstractCombiBAPApplication;
import de.audi.app.combi.bap.app.mfl.AbstractFunctionListMFL;
import de.audi.app.combi.bap.app.mfl.AppConnectorMFL;
import de.audi.app.combi.bap.app.mfl.BAPIndicationHandlerMFL;
import de.audi.app.combi.bap.app.mfl.InitializationManagerMFL;
import de.audi.app.combi.bap.app.mfl.MFLKeyHandler;
import de.audi.app.combi.bap.app.mfl.PartialPopupHandler;
import de.audi.app.combi.bap.app.mfl.ServiceManagerMFL;
import de.audi.app.combi.bap.fw.AbstractCombiModule;
import de.audi.atip.interapp.combi.bap.mfl.CombiBAPServiceMFL;
import de.audi.atip.interapp.combi.bap.mfl.CombiBAPServiceMFLListener;
import de.mib.swdiagnosis.combi.CombiDiagnosisConnectorMFL;
import org.osgi.framework.BundleContext;

public class CombiModuleMFL
extends AbstractCombiModule {
    private static final int[] ERROR_MAPPING = new int[10];
    private AppConnectorMFL appConnectorMFL;
    private final MFLKeyHandler mflKeyHandler;
    private final PartialPopupHandler partialPopupHandler;

    public CombiModuleMFL(AbstractCombiBAPApplication abstractCombiBAPApplication, AbstractFunctionListMFL abstractFunctionListMFL) {
        this(abstractCombiBAPApplication, abstractFunctionListMFL, null);
    }

    public CombiModuleMFL(AbstractCombiBAPApplication abstractCombiBAPApplication, AbstractFunctionListMFL abstractFunctionListMFL, IBAPFunctionFactoryFSG iBAPFunctionFactoryFSG) {
        super(52, (AbstractBAPApplication)abstractCombiBAPApplication, iBAPFunctionFactoryFSG);
        this.functionListFsg = abstractFunctionListMFL;
        this.functionListFsg.init(this);
        this.appConnectorMFL = new AppConnectorMFL(this);
        this.addAppConnector("Car", this.appConnectorMFL);
        this.mflKeyHandler = new MFLKeyHandler(this);
        this.partialPopupHandler = new PartialPopupHandler(this);
    }

    protected void initModuleComponents() {
        this.logChannel.log(10000000, "[CombiModuleMFL#initModuleComponents]");
        this.indicationHandler = new BAPIndicationHandlerMFL(this);
        this.functionRegistration = new FunctionRegistrationMFL(this);
        this.initializationManager = new InitializationManagerMFL(this, this.getBAPFunctionPropertyFSG(15), this.bapApplication.getDSIBAPController(), this.bapApplication.getPowerState());
    }

    protected void initServiceManager(BundleContext bundleContext) {
        this.serviceManager = new ServiceManagerMFL(this, bundleContext);
    }

    protected void initDiagnosisConnector() {
        this.diagnosisConnectorFsg = new CombiDiagnosisConnectorMFL((AbstractCombiBAPApplication)this.bapApplication, this);
    }

    public String getLSGDescription() {
        return "0x34 (MFL)";
    }

    public IFunctionIDs getFunctionIDs() {
        return new FunctionIDsMFL();
    }

    public IErrorCodes getErrorIDs() {
        return new ErrorCodesMFL();
    }

    public int[] getErrorMapping() {
        return ERROR_MAPPING;
    }

    public IDataTypeMapping getDataTypeMapping() {
        return new DataTypeMappingMFL();
    }

    public MFLKeyHandler getMFLKeyHandler() {
        return this.mflKeyHandler;
    }

    public CombiBAPServiceMFL getMFLService() {
        return this.appConnectorMFL;
    }

    public CombiBAPServiceMFLListener getMFLServiceListener() {
        return (CombiBAPServiceMFLListener)this.appConnectorMFL.getAppServiceListener();
    }

    public PartialPopupHandler getPartialPopupHandler() {
        return this.partialPopupHandler;
    }

    static {
        CombiModuleMFL.ERROR_MAPPING[0] = 65;
        CombiModuleMFL.ERROR_MAPPING[1] = 65;
        CombiModuleMFL.ERROR_MAPPING[2] = 65;
        CombiModuleMFL.ERROR_MAPPING[3] = 66;
        CombiModuleMFL.ERROR_MAPPING[4] = 65;
        CombiModuleMFL.ERROR_MAPPING[5] = 65;
        CombiModuleMFL.ERROR_MAPPING[6] = 66;
        CombiModuleMFL.ERROR_MAPPING[7] = 65;
        CombiModuleMFL.ERROR_MAPPING[8] = 34;
        CombiModuleMFL.ERROR_MAPPING[9] = 67;
    }
}

