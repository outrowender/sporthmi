/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.bap.ecall;

import de.audi.app.bap.AbstractBAPApplication;
import de.audi.app.bap.ecall.AppConnectorEcall;
import de.audi.app.bap.ecall.BAPDiagnosisConnectorEcall;
import de.audi.app.bap.ecall.BAPIndicationHandlerEcall;
import de.audi.app.bap.ecall.DataEcall;
import de.audi.app.bap.ecall.FunctionListEcall;
import de.audi.app.bap.ecall.InitializationManagerEcall;
import de.audi.app.bap.ecall.ServiceManagerEcall;
import de.audi.app.bap.fw.AbstractBAPModule;
import de.audi.app.bap.fw.AbstractBAPModuleASG;
import de.audi.app.bap.fw.AbstractBAPModuleInitializationManagerASG;
import de.audi.app.bap.fw.IBAPFunctionFactoryASG;
import de.audi.app.bap.fw.functiontypes.BAPFunctionPropertyASG;
import de.audi.app.bap.fw.request.IDataTypeMapping;
import de.audi.app.bap.generated.ecall.DataTypeMappingEcall;
import de.audi.app.bap.generated.ecall.ErrorCodesEcall;
import de.audi.app.bap.generated.ecall.FunctionIDsEcall;
import de.audi.app.bap.generated.ecall.FunctionRegistrationEcall;
import de.audi.app.bap.utils.IErrorCodes;
import de.audi.app.bap.utils.IFunctionIDs;
import de.audi.app.bap.utils.NullObjectFactory;
import de.audi.atip.interapp.bap.ecall.BAPServiceEcall;
import de.audi.atip.interapp.bap.ecall.BAPServiceEcallListener;
import de.vw.mib.bap.generated.ecall.serializer.AudioState_SetGet;
import org.osgi.framework.BundleContext;

public final class BAPModuleEcall
extends AbstractBAPModuleASG {
    private final DataEcall dataEcall;
    private static final int[] ERROR_MAPPING = BAPModuleEcall.errorMapping();
    static /* synthetic */ Class class$de$audi$atip$interapp$bap$ecall$BAPServiceEcall;
    static /* synthetic */ Class class$de$audi$atip$interapp$bap$ecall$BAPServiceEcallListener;

    public BAPModuleEcall(AbstractBAPApplication abstractBAPApplication) {
        super(51, abstractBAPApplication);
        this.addAppConnector("AppBapEcall", new AppConnectorEcall(this, this.functionRegistration));
        this.dataEcall = new DataEcall(this.logChannel);
    }

    public BAPModuleEcall(AbstractBAPApplication abstractBAPApplication, IBAPFunctionFactoryASG iBAPFunctionFactoryASG) {
        super(51, abstractBAPApplication, iBAPFunctionFactoryASG);
        this.addAppConnector("AppBapEcall", new AppConnectorEcall(this, this.functionRegistration));
        this.dataEcall = new DataEcall(this.logChannel);
    }

    protected void initModuleComponents() {
        this.logChannel.log(10000000, "[BAPModuleEcall#initModuleComponents]");
        this.indicationHandler = new BAPIndicationHandlerEcall(this);
        this.functionRegistration = new FunctionRegistrationEcall(this);
        this.functionListAsg = new FunctionListEcall();
        this.functionListAsg.init(this);
        this.initializationManager = new InitializationManagerEcall(this, this.bapApplication.getDSIBAPController(), this.bapApplication.getPowerState());
    }

    protected void initServiceManager(BundleContext bundleContext) {
        this.serviceManager = new ServiceManagerEcall(this, bundleContext);
    }

    protected void setInitialValues() {
        AudioState_SetGet audioState_SetGet = (AudioState_SetGet)this.createSetGetSerializer(16);
        audioState_SetGet.currentAudioSource = this.getDataEcall().getCurrentAudioSource();
        BAPFunctionPropertyASG bAPFunctionPropertyASG = this.getBAPFunctionPropertyASG(16);
        if (bAPFunctionPropertyASG != null) {
            bAPFunctionPropertyASG.setSetGetSerializer(audioState_SetGet);
        } else {
            this.logChannel.log(100000, "[BAPModuleEcall#setInitialValues] bapFunctionPropertyASG is NULL");
        }
    }

    protected String getLSGDescription() {
        return "0x33 (ECALL)";
    }

    protected IFunctionIDs getFunctionIDs() {
        return new FunctionIDsEcall();
    }

    protected IErrorCodes getErrorIDs() {
        return new ErrorCodesEcall();
    }

    public int[] getErrorMapping() {
        this.logChannel.log(10000, "[BAPModuleEcall#getErrorMapping]");
        return ERROR_MAPPING;
    }

    protected IDataTypeMapping getDataTypeMapping() {
        return new DataTypeMappingEcall();
    }

    protected void initDiagnosisConnector() {
        this.diagnosisConnectorAsg = new BAPDiagnosisConnectorEcall(this.bapApplication, this);
    }

    public BAPServiceEcall getAppServiceEcall() {
        BAPServiceEcall bAPServiceEcall = this.appConnectorEcall();
        if (bAPServiceEcall == null) {
            this.logChannel.log(10000, "[BAPModuleEcall#getAppServiceEcall] appConnectorEcall() returned null");
            bAPServiceEcall = (BAPServiceEcall)NullObjectFactory.makeNullObjectFor(class$de$audi$atip$interapp$bap$ecall$BAPServiceEcall == null ? (class$de$audi$atip$interapp$bap$ecall$BAPServiceEcall = BAPModuleEcall.class$("de.audi.atip.interapp.bap.ecall.BAPServiceEcall")) : class$de$audi$atip$interapp$bap$ecall$BAPServiceEcall);
        }
        return bAPServiceEcall;
    }

    public void setAppServiceListenerEcall(BAPServiceEcallListener bAPServiceEcallListener) {
        this.logChannel.log(10000000, "[BAPModuleEcall#setAppServiceListenerEcall] called");
        this.appConnectorEcall().setAppServiceListener(bAPServiceEcallListener);
        if (bAPServiceEcallListener == null) {
            this.logChannel.log(10000000, "[BAPModuleEcall#setAppServiceListenerEcall] serviceListener is null!");
            return;
        }
        if (this.communicationState.isUp()) {
            this.logChannel.log(10000000, "[BAPModuleEcall#setAppServiceListenerEcall] notify onCommunicationUp()");
            this.getAppServiceListenerEcall().onCommunicationUp();
        }
    }

    protected void onCommunicationUp() {
        this.logChannel.log(10000000, "[BAPModuleEcall#onCommunicationUp]");
        ((AbstractBAPModuleInitializationManagerASG)this.initializationManager).sendSetGetProperties();
        this.getAppServiceListenerEcall().onCommunicationUp();
    }

    public BAPServiceEcallListener getAppServiceListenerEcall() {
        BAPServiceEcallListener bAPServiceEcallListener = (BAPServiceEcallListener)this.appConnectorEcall().getAppServiceListener();
        if (bAPServiceEcallListener == null) {
            this.logChannel.log(10000000, "[BAPModuleEcall#getAppServiceListenerEcall] No app listener set. Returning a NullListener.");
            bAPServiceEcallListener = (BAPServiceEcallListener)NullObjectFactory.makeNullObjectFor(class$de$audi$atip$interapp$bap$ecall$BAPServiceEcallListener == null ? (class$de$audi$atip$interapp$bap$ecall$BAPServiceEcallListener = BAPModuleEcall.class$("de.audi.atip.interapp.bap.ecall.BAPServiceEcallListener")) : class$de$audi$atip$interapp$bap$ecall$BAPServiceEcallListener);
        }
        return bAPServiceEcallListener;
    }

    public DataEcall getDataEcall() {
        return this.dataEcall;
    }

    public void destroy() {
        this.dataEcall.clear();
        super.destroy();
    }

    private AppConnectorEcall appConnectorEcall() {
        return (AppConnectorEcall)this.getAppConnectors().get("AppBapEcall");
    }

    private static int[] errorMapping() {
        int[] nArray = new int[]{65, 65, 65, 80, 65, 65, 66, 65, 34, 67};
        return nArray;
    }

    public void updateInitState(AbstractBAPModule abstractBAPModule, int n) {
        this.logChannel.log(10000000, "[BAPModuleEcall#updateInitState] initState: %1", (long)n);
        this.communicationState.updateInitState(n);
    }

    public boolean isErrorHandled(int n) {
        boolean bl = false;
        switch (n) {
            case 148: 
            case 149: 
            case 150: {
                this.logChannel.log(1000000, "BAPModuleEcall#isErrorHandled [%1] = true", (long)n);
                bl = true;
                break;
            }
            default: {
                this.logChannel.log(10000000, "BAPModuleEcall#isErrorHandled [%1], = false", (long)n);
            }
        }
        return bl;
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

