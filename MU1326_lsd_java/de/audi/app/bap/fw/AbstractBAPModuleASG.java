/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  de.mib.swdiagnosis.bap.AbstractBAPDiagnosisConnectorASG
 */
package de.audi.app.bap.fw;

import de.audi.app.bap.AbstractBAPApplication;
import de.audi.app.bap.fw.AbstractBAPModule;
import de.audi.app.bap.fw.AbstractFunctionList;
import de.audi.app.bap.fw.AbstractFunctionListASG;
import de.audi.app.bap.fw.BAPFunctionFactoryASG;
import de.audi.app.bap.fw.CommunicationState;
import de.audi.app.bap.fw.CommunicationUpListener;
import de.audi.app.bap.fw.IBAPFunctionFactory;
import de.audi.app.bap.fw.IBAPFunctionFactoryASG;
import de.audi.app.bap.fw.IFunctionRegistrationASG;
import de.audi.app.bap.fw.IInitStateListener;
import de.audi.app.bap.fw.functiontypes.BAPFunctionArrayASG;
import de.audi.app.bap.fw.functiontypes.BAPFunctionGetAll;
import de.audi.app.bap.fw.functiontypes.BAPFunctionMethodASG;
import de.audi.app.bap.fw.functiontypes.BAPFunctionPropertyASG;
import de.audi.app.bap.fw.functiontypes.IBAPFunction;
import de.audi.app.bap.fw.functiontypes.RetryConfig;
import de.audi.app.bap.fw.indication.IBAPIndicationHandlerASG;
import de.audi.app.bap.fw.indication.IBAPIndicationListener;
import de.audi.atip.diag.sw.AbstractSwDiagnosis;
import de.mib.swdiagnosis.bap.AbstractBAPDiagnosisConnectorASG;
import de.vw.mib.bap.requests.AbortResultMethod;
import de.vw.mib.bap.requests.AckProperty;
import de.vw.mib.bap.requests.GetArray;
import de.vw.mib.bap.requests.SetGetArray;
import de.vw.mib.bap.requests.SetGetProperty;
import de.vw.mib.bap.requests.StartResultMethod;

public abstract class AbstractBAPModuleASG
extends AbstractBAPModule
implements IInitStateListener {
    protected IBAPIndicationHandlerASG indicationHandler;
    protected IFunctionRegistrationASG functionRegistration;
    protected AbstractBAPDiagnosisConnectorASG diagnosisConnectorAsg;
    protected final CommunicationState communicationState = new CommunicationState(new CommunicationUpListener(){

        public void communicationUp() {
            AbstractBAPModuleASG.this.onCommunicationUp();
        }
    });
    protected AbstractFunctionListASG functionListAsg;

    protected abstract void onCommunicationUp();

    public AbstractBAPModuleASG(int n, AbstractBAPApplication abstractBAPApplication) {
        super(n, abstractBAPApplication);
    }

    public AbstractBAPModuleASG(int n, AbstractBAPApplication abstractBAPApplication, IBAPFunctionFactoryASG iBAPFunctionFactoryASG) {
        super(n, abstractBAPApplication, iBAPFunctionFactoryASG);
    }

    public IBAPIndicationListener getIndicationListener() {
        return this.indicationHandler;
    }

    public IBAPIndicationHandlerASG getIndicationHandler() {
        return this.indicationHandler;
    }

    public IFunctionRegistrationASG getFunctionRegistration() {
        return this.functionRegistration;
    }

    protected IBAPFunctionFactory createBAPFunctionFactory() {
        return new BAPFunctionFactoryASG();
    }

    public BAPFunctionGetAll createBAPFunctionGetAll(int n) {
        return ((IBAPFunctionFactoryASG)this.getBapFunctionFactory()).createBAPFunctionGetAll(this, n);
    }

    public BAPFunctionArrayASG createBAPFunctionArrayASG(int n) {
        return ((IBAPFunctionFactoryASG)this.getBapFunctionFactory()).createBAPFunctionArrayASG(this, n);
    }

    public BAPFunctionArrayASG createBAPFunctionArrayASG(int n, RetryConfig retryConfig) {
        return ((IBAPFunctionFactoryASG)this.getBapFunctionFactory()).createBAPFunctionArrayASG(this, n, retryConfig);
    }

    public BAPFunctionMethodASG createBAPFunctionMethodASG(int n) {
        return ((IBAPFunctionFactoryASG)this.getBapFunctionFactory()).createBAPFunctionMethodASG(this, n);
    }

    public BAPFunctionPropertyASG createBAPFunctionPropertyASG(int n) {
        return ((IBAPFunctionFactoryASG)this.getBapFunctionFactory()).createBAPFunctionPropertyASG(this, n);
    }

    public GetArray createGetArraySerializer(int n) {
        return this.functionRegistration.createGetArrayForArrayASG(n);
    }

    public SetGetArray createSetGetArraySerializer(int n) {
        return this.functionRegistration.createSetGetArrayForArrayASG(n);
    }

    public SetGetArray createSetArraySerializer(int n) {
        return this.functionRegistration.createSetArrayForArrayASG(n);
    }

    public StartResultMethod createStartResulSerializer(int n) {
        return this.functionRegistration.createStartResulForMethodASG(n);
    }

    public AbortResultMethod createAbortResulSerializer(int n) {
        return this.functionRegistration.createAbortResulForMethodASG(n);
    }

    public SetGetProperty createSetGetSerializer(int n) {
        return this.functionRegistration.createSetGetForPropertyASG(n);
    }

    public AckProperty createAckSerializer(int n) {
        return this.functionRegistration.createAckForPropertyASG(n);
    }

    public IBAPFunction getBAPFunction(int n) {
        return this.functionRegistration.getBAPFunction(n);
    }

    public BAPFunctionGetAll getBAPFunctionGetAll() {
        return (BAPFunctionGetAll)this.functionRegistration.getBAPFunction(this.getFunctionList().getGetAllFctID());
    }

    public BAPFunctionMethodASG getBAPFunctionMethodASG(int n) {
        return this.functionRegistration.getBAPFunctionMethodASG(n);
    }

    public BAPFunctionPropertyASG getBAPFunctionPropertyASG(int n) {
        return this.functionRegistration.getBAPFunctionPropertyASG(n);
    }

    public BAPFunctionArrayASG getBAPFunctionArrayASG(int n) {
        return this.functionRegistration.getBAPFunctionArrayASG(n);
    }

    public void resetBAPFunctions() {
        this.functionRegistration.resetBAPFunctions();
    }

    public void destroy() {
        super.destroy();
        if (this.diagnosisConnectorAsg != null) {
            this.diagnosisConnectorAsg.destroy();
            this.diagnosisConnectorAsg = null;
        }
        this.indicationHandler = null;
        this.functionRegistration = null;
    }

    protected AbstractSwDiagnosis getDiagnosisGateway(boolean bl) {
        if (this.diagnosisConnectorAsg == null && bl) {
            this.initDiagnosisConnector();
        }
        return this.diagnosisConnectorAsg;
    }

    public final void setFsgOperationState(int n) {
        this.logChannel.log(10000000, "[AbstractBAPModuleASG#setFsgOperationState] fsgState=%1", (long)n);
        this.communicationState.updateFsgOperationnState(n);
    }

    protected final void setInitState(int n) {
        this.logChannel.log(10000000, "[AbstractBAPModuleASG#setInitState] initState=%1", (long)n);
        this.communicationState.updateInitState(n);
    }

    public AbstractFunctionList getFunctionList() {
        return this.functionListAsg;
    }

    public boolean isUpdateBeforeInit(int n) {
        return n == this.functionListAsg.getFctListBAPFctID() || n == this.functionListAsg.getOperationStateBAPFctID();
    }
}

