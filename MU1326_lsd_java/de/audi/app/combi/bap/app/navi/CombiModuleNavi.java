/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  de.mib.swdiagnosis.combi.CombiDiagnosisConnectorNavi
 */
package de.audi.app.combi.bap.app.navi;

import de.audi.app.bap.AbstractBAPApplication;
import de.audi.app.bap.fw.IBAPFunctionFactoryFSG;
import de.audi.app.bap.fw.IFunctionRegistrationFSG;
import de.audi.app.bap.fw.functiontypes.BAPFunctionPropertyFSG;
import de.audi.app.bap.fw.request.IDataTypeMapping;
import de.audi.app.bap.generated.navi.DataTypeMappingNavi;
import de.audi.app.bap.generated.navi.ErrorCodesNavi;
import de.audi.app.bap.generated.navi.FunctionIDsNavi;
import de.audi.app.bap.generated.navi.FunctionRegistrationNavi;
import de.audi.app.bap.utils.IErrorCodes;
import de.audi.app.bap.utils.IFunctionIDs;
import de.audi.app.combi.bap.AbstractCombiBAPApplication;
import de.audi.app.combi.bap.app.navi.AbstractFunctionListNavi;
import de.audi.app.combi.bap.app.navi.AppConnectorNavi;
import de.audi.app.combi.bap.app.navi.BAPIndicationHandlerNavi;
import de.audi.app.combi.bap.app.navi.BAPMethodRGActDeactWaitingForProperties;
import de.audi.app.combi.bap.app.navi.InitializationManagerNavi;
import de.audi.app.combi.bap.app.navi.ServiceManagerNavi;
import de.audi.app.combi.bap.app.navi.TMCInfoHandler;
import de.audi.app.combi.bap.app.navi.functionsync.FunctionSynchronizationHandlerNavi;
import de.audi.app.combi.bap.app.navi.list.ListManagerNavi;
import de.audi.app.combi.bap.fw.AbstractCombiModule;
import de.audi.atip.interapp.ExternalKeyListener;
import de.audi.atip.interapp.combi.bap.navi.CombiBAPServiceNavi;
import de.audi.atip.interapp.combi.bap.navi.CombiBAPServiceNaviListener;
import de.mib.swdiagnosis.combi.CombiDiagnosisConnectorNavi;
import de.vw.mib.bap.generated.navsd.serializer.RG_ActDeact_StartResult;
import java.util.Collections;
import java.util.List;
import org.osgi.framework.BundleContext;

public class CombiModuleNavi
extends AbstractCombiModule {
    private static final int[] ERROR_MAPPING = new int[10];
    private AppConnectorNavi appConnectorNavi;
    private final TMCInfoHandler tmcInfoHandler;
    private ExternalKeyListener externKeyListener;
    private final BAPMethodRGActDeactWaitingForProperties propertiesToWaitForRGActDeact = new BAPMethodRGActDeactWaitingForProperties(this, this.getBAPFunctionMethodFSG(34));

    public CombiModuleNavi(AbstractCombiBAPApplication abstractCombiBAPApplication, AbstractFunctionListNavi abstractFunctionListNavi) {
        this(abstractCombiBAPApplication, abstractFunctionListNavi, null);
    }

    public CombiModuleNavi(AbstractCombiBAPApplication abstractCombiBAPApplication, AbstractFunctionListNavi abstractFunctionListNavi, IBAPFunctionFactoryFSG iBAPFunctionFactoryFSG) {
        super(50, (AbstractBAPApplication)abstractCombiBAPApplication, iBAPFunctionFactoryFSG);
        this.functionListFsg = abstractFunctionListNavi;
        this.functionListFsg.init(this);
        this.appConnectorNavi = new AppConnectorNavi(this);
        this.addAppConnector("Navi", this.appConnectorNavi);
        this.tmcInfoHandler = new TMCInfoHandler(this.getBAPFunctionPropertyFSG(25), this.logChannel);
        this.listManager = new ListManagerNavi(this, abstractCombiBAPApplication.isMOSTListSupported());
    }

    public ExternalKeyListener getExternalKeyListener() {
        return this.externKeyListener;
    }

    public void setExternalKeyListener(ExternalKeyListener externalKeyListener) {
        this.externKeyListener = externalKeyListener;
    }

    public void rgActDeactStartResultReceived(RG_ActDeact_StartResult rG_ActDeact_StartResult) {
        this.propertiesToWaitForRGActDeact.rgActDeactStartResultReceived(rG_ActDeact_StartResult);
    }

    public void rgActDeactResultReceived(int n) {
        this.propertiesToWaitForRGActDeact.rgActDeactResultReceived(n);
    }

    public void rgActDeactSyncFinished() {
        this.propertiesToWaitForRGActDeact.rgActDeactSyncFinished();
    }

    protected void initModuleComponents() {
        this.logChannel.log(10000000, "[CombiModuleNavi#initModuleComponents]");
        this.indicationHandler = new BAPIndicationHandlerNavi(this);
        this.functionRegistration = CombiModuleNavi.customInitialize(new FunctionRegistrationNavi(this));
        this.initializationManager = new InitializationManagerNavi(this, this.getBAPFunctionPropertyFSG(15), this.bapApplication.getDSIBAPController(), this.bapApplication.getPowerState());
        this.functionSyncHandler = new FunctionSynchronizationHandlerNavi(this);
    }

    private static IFunctionRegistrationFSG customInitialize(FunctionRegistrationNavi functionRegistrationNavi) {
        int n;
        BAPFunctionPropertyFSG bAPFunctionPropertyFSG = functionRegistrationNavi.getBAPFunctionPropertyFSG(38);
        BAPFunctionPropertyFSG bAPFunctionPropertyFSG2 = functionRegistrationNavi.getBAPFunctionPropertyFSG(39);
        List list = functionRegistrationNavi.getAllProperties();
        int n2 = list.indexOf(bAPFunctionPropertyFSG);
        if (n2 < (n = list.indexOf(bAPFunctionPropertyFSG2))) {
            Collections.swap(list, n2, n);
        }
        return functionRegistrationNavi;
    }

    protected void initServiceManager(BundleContext bundleContext) {
        this.serviceManager = new ServiceManagerNavi(this, bundleContext);
    }

    protected void initDiagnosisConnector() {
        this.diagnosisConnectorFsg = new CombiDiagnosisConnectorNavi((AbstractCombiBAPApplication)this.bapApplication, this);
    }

    public String getLSGDescription() {
        return "0x32 (NAVI)";
    }

    public IFunctionIDs getFunctionIDs() {
        return new FunctionIDsNavi();
    }

    public IErrorCodes getErrorIDs() {
        return new ErrorCodesNavi();
    }

    public int[] getErrorMapping() {
        return ERROR_MAPPING;
    }

    public IDataTypeMapping getDataTypeMapping() {
        return new DataTypeMappingNavi();
    }

    public TMCInfoHandler getTMCInfoHandler() {
        return this.tmcInfoHandler;
    }

    public CombiBAPServiceNavi getNaviService() {
        return this.appConnectorNavi;
    }

    public CombiBAPServiceNaviListener getNaviServiceListener() {
        return (CombiBAPServiceNaviListener)this.appConnectorNavi.getAppServiceListener();
    }

    static {
        CombiModuleNavi.ERROR_MAPPING[0] = 65;
        CombiModuleNavi.ERROR_MAPPING[1] = 65;
        CombiModuleNavi.ERROR_MAPPING[2] = 65;
        CombiModuleNavi.ERROR_MAPPING[3] = 80;
        CombiModuleNavi.ERROR_MAPPING[4] = 65;
        CombiModuleNavi.ERROR_MAPPING[5] = 65;
        CombiModuleNavi.ERROR_MAPPING[6] = 66;
        CombiModuleNavi.ERROR_MAPPING[7] = 65;
        CombiModuleNavi.ERROR_MAPPING[8] = 34;
        CombiModuleNavi.ERROR_MAPPING[9] = 67;
    }
}

