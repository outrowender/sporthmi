/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.onlinefunctions.bap;

import de.audi.app.bap.AbstractBAPApplication;
import de.audi.app.bap.fw.AbstractBAPModuleFSG;
import de.audi.app.bap.fw.AbstractFunctionListFSG;
import de.audi.app.bap.fw.IBAPFunctionFactoryFSG;
import de.audi.app.bap.fw.request.IDataTypeMapping;
import de.audi.app.bap.generated.onlinefunctions.DataTypeMappingOnlineFunctions;
import de.audi.app.bap.generated.onlinefunctions.ErrorCodesOnlineFunctions;
import de.audi.app.bap.generated.onlinefunctions.FunctionIDsOnlineFunctions;
import de.audi.app.bap.generated.onlinefunctions.FunctionRegistrationOnlineFunctions;
import de.audi.app.bap.utils.IErrorCodes;
import de.audi.app.bap.utils.IFunctionIDs;
import de.audi.app.onlinefunctions.bap.BAPIndicationHandlerOnlineFunctions;
import de.audi.app.onlinefunctions.bap.InitializationManagerOnlineFunctions;
import de.audi.app.onlinefunctions.bap.OnlineFunctionsServiceManager;
import org.osgi.framework.BundleContext;

public class OnlineFunctionsModule
extends AbstractBAPModuleFSG {
    public OnlineFunctionsModule(AbstractBAPApplication abstractBAPApplication, AbstractFunctionListFSG abstractFunctionListFSG) {
        this(abstractBAPApplication, abstractFunctionListFSG, null);
    }

    public OnlineFunctionsModule(AbstractBAPApplication abstractBAPApplication, AbstractFunctionListFSG abstractFunctionListFSG, IBAPFunctionFactoryFSG iBAPFunctionFactoryFSG) {
        super(42, abstractBAPApplication, iBAPFunctionFactoryFSG);
        this.functionListFsg = abstractFunctionListFSG;
        this.functionListFsg.init(this);
    }

    protected String getLSGDescription() {
        return "0x2a (OnlineFunctions)";
    }

    protected boolean isRelevantForUpdateProperties(int n) {
        return n != this.getFunctionList().getFctListBAPFctID() && n != this.getFunctionList().getBAPConfigBAPFctID();
    }

    protected void initModuleComponents() {
        this.logChannel.log(10000000, "[OnlineFunctionsModule#initModuleComponents]");
        this.indicationHandler = new BAPIndicationHandlerOnlineFunctions(this);
        this.functionRegistration = new FunctionRegistrationOnlineFunctions(this);
        this.initializationManager = new InitializationManagerOnlineFunctions(this, this.getBAPFunctionPropertyFSG(15), this.bapApplication.getDSIBAPController(), this.bapApplication.getPowerState());
    }

    protected void initServiceManager(BundleContext bundleContext) {
        this.serviceManager = new OnlineFunctionsServiceManager(this, bundleContext);
    }

    protected IFunctionIDs getFunctionIDs() {
        return new FunctionIDsOnlineFunctions();
    }

    protected IErrorCodes getErrorIDs() {
        return new ErrorCodesOnlineFunctions();
    }

    public int[] getErrorMapping() {
        return new int[1];
    }

    protected IDataTypeMapping getDataTypeMapping() {
        return new DataTypeMappingOnlineFunctions();
    }

    protected void initDiagnosisConnector() {
    }
}

