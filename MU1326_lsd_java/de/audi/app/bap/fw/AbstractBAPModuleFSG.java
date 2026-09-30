/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  de.mib.swdiagnosis.bap.AbstractBAPDiagnosisConnectorFSG
 */
package de.audi.app.bap.fw;

import de.audi.app.bap.AbstractBAPApplication;
import de.audi.app.bap.fw.AbstractBAPModule;
import de.audi.app.bap.fw.AbstractFunctionList;
import de.audi.app.bap.fw.AbstractFunctionListFSG;
import de.audi.app.bap.fw.BAPFunctionFactoryFSG;
import de.audi.app.bap.fw.IBAPFunctionFactory;
import de.audi.app.bap.fw.IBAPFunctionFactoryFSG;
import de.audi.app.bap.fw.IFunctionRegistrationFSG;
import de.audi.app.bap.fw.functionsync.IFunctionSynchronizationHandler;
import de.audi.app.bap.fw.functiontypes.BAPFunctionArrayFSG;
import de.audi.app.bap.fw.functiontypes.BAPFunctionGetAll;
import de.audi.app.bap.fw.functiontypes.BAPFunctionMethodFSG;
import de.audi.app.bap.fw.functiontypes.BAPFunctionPropertyFSG;
import de.audi.app.bap.fw.functiontypes.IBAPFunction;
import de.audi.app.bap.fw.indication.IBAPIndicationHandlerFSG;
import de.audi.app.bap.fw.indication.IBAPIndicationListener;
import de.audi.atip.diag.sw.AbstractSwDiagnosis;
import de.mib.swdiagnosis.bap.AbstractBAPDiagnosisConnectorFSG;
import de.vw.mib.bap.requests.ChangedArray;
import de.vw.mib.bap.requests.ResultMethod;
import de.vw.mib.bap.requests.StatusAckProperty;
import de.vw.mib.bap.requests.StatusArray;
import de.vw.mib.bap.requests.StatusProperty;

public abstract class AbstractBAPModuleFSG
extends AbstractBAPModule {
    protected IBAPIndicationHandlerFSG indicationHandler;
    protected IFunctionRegistrationFSG functionRegistration;
    protected IFunctionSynchronizationHandler functionSyncHandler;
    protected AbstractBAPDiagnosisConnectorFSG diagnosisConnectorFsg;
    protected AbstractFunctionListFSG functionListFsg;

    public AbstractBAPModuleFSG(int n, AbstractBAPApplication abstractBAPApplication) {
        super(n, abstractBAPApplication);
    }

    public AbstractBAPModuleFSG(int n, AbstractBAPApplication abstractBAPApplication, IBAPFunctionFactoryFSG iBAPFunctionFactoryFSG) {
        super(n, abstractBAPApplication, iBAPFunctionFactoryFSG);
    }

    public IBAPIndicationListener getIndicationListener() {
        return this.indicationHandler;
    }

    public IBAPIndicationHandlerFSG getIndicationHandler() {
        return this.indicationHandler;
    }

    public IFunctionRegistrationFSG getFunctionRegistration() {
        return this.functionRegistration;
    }

    protected abstract boolean isRelevantForUpdateProperties(int var1);

    protected IBAPFunctionFactory createBAPFunctionFactory() {
        return new BAPFunctionFactoryFSG();
    }

    public BAPFunctionArrayFSG createBAPFunctionArrayFSG(int n) {
        return ((IBAPFunctionFactoryFSG)this.getBapFunctionFactory()).createBAPFunctionArrayFSG(this, n);
    }

    public BAPFunctionMethodFSG createBAPFunctionMethodFSG(int n) {
        return ((IBAPFunctionFactoryFSG)this.getBapFunctionFactory()).createBAPFunctionMethodFSG(this, n);
    }

    public BAPFunctionPropertyFSG createBAPFunctionPropertyFSG(int n) {
        return ((IBAPFunctionFactoryFSG)this.getBapFunctionFactory()).createBAPFunctionPropertyFSG(this, n);
    }

    public StatusArray createStatusArraySerializer(int n) {
        return this.functionRegistration.createStatusArrayForArrayFSG(n);
    }

    public ChangedArray createChangedArraySerializer(int n) {
        return this.functionRegistration.createChangedArrayForArrayFSG(n);
    }

    public ResultMethod createResultSerializer(int n) {
        return this.functionRegistration.createResultForMethodFSG(n);
    }

    public StatusProperty createStatusSerializer(int n) {
        return this.functionRegistration.createStatusForPropertyFSG(n);
    }

    public StatusAckProperty createStatusAckSerializer(int n) {
        return this.functionRegistration.createStatusAckForPropertyFSG(n);
    }

    public IBAPFunction getBAPFunction(int n) {
        return this.functionRegistration.getBAPFunction(n);
    }

    public BAPFunctionGetAll getBAPFunctionGetAll() {
        return (BAPFunctionGetAll)this.functionRegistration.getBAPFunction(this.getFunctionList().getGetAllFctID());
    }

    public BAPFunctionMethodFSG getBAPFunctionMethodFSG(int n) {
        return this.functionRegistration.getBAPFunctionMethodFSG(n);
    }

    public BAPFunctionPropertyFSG getBAPFunctionPropertyFSG(int n) {
        return this.functionRegistration.getBAPFunctionPropertyFSG(n);
    }

    public BAPFunctionArrayFSG getBAPFunctionArrayFSG(int n) {
        return this.functionRegistration.getBAPFunctionArrayFSG(n);
    }

    public IFunctionSynchronizationHandler getFunctionSynchronizationHandler() {
        return this.functionSyncHandler;
    }

    public void resetBAPFunctions() {
        this.functionRegistration.resetBAPFunctions();
    }

    public void destroy() {
        super.destroy();
        if (this.diagnosisConnectorFsg != null) {
            this.diagnosisConnectorFsg.destroy();
            this.diagnosisConnectorFsg = null;
        }
        this.functionSyncHandler = null;
        this.indicationHandler = null;
        this.functionRegistration = null;
    }

    protected AbstractSwDiagnosis getDiagnosisGateway(boolean bl) {
        if (this.diagnosisConnectorFsg == null && bl) {
            this.initDiagnosisConnector();
        }
        return this.diagnosisConnectorFsg;
    }

    public AbstractFunctionList getFunctionList() {
        return this.functionListFsg;
    }

    public boolean isUpdateBeforeInit(int n) {
        return n == this.functionListFsg.getFctListBAPFctID() || n == this.functionListFsg.getOperationStateBAPFctID();
    }
}

