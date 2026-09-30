/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.bap.eni;

import de.audi.app.bap.AbstractBAPApplication;
import de.audi.app.bap.eni.AppConnectorENI;
import de.audi.app.bap.eni.BAPArrayDataENI;
import de.audi.app.bap.eni.BAPDiagnosisConnectorENI;
import de.audi.app.bap.eni.BAPIndicationHandlerENI;
import de.audi.app.bap.eni.FunctionListENI;
import de.audi.app.bap.eni.InitializationManagerENI;
import de.audi.app.bap.eni.ServiceManagerENI;
import de.audi.app.bap.fw.AbstractBAPModule;
import de.audi.app.bap.fw.AbstractBAPModuleASG;
import de.audi.app.bap.fw.AbstractBAPModuleInitializationManagerASG;
import de.audi.app.bap.fw.IBAPFunctionFactoryASG;
import de.audi.app.bap.fw.functiontypes.BAPFunctionPropertyASG;
import de.audi.app.bap.fw.request.IDataTypeMapping;
import de.audi.app.bap.generated.eni.DataTypeMappingENI;
import de.audi.app.bap.generated.eni.ErrorCodesENI;
import de.audi.app.bap.generated.eni.FunctionIDsENI;
import de.audi.app.bap.generated.eni.FunctionRegistrationENI;
import de.audi.app.bap.utils.IErrorCodes;
import de.audi.app.bap.utils.IFunctionIDs;
import de.audi.app.bap.utils.NullObjectFactory;
import de.audi.atip.interapp.bap.eni.BAPServiceENI;
import de.audi.atip.interapp.bap.eni.BAPServiceENIListener;
import de.vw.mib.bap.generated.eni.serializer.DestinationList_ASGcapacity_SetGet;
import org.osgi.framework.BundleContext;

public final class BAPModuleENI
extends AbstractBAPModuleASG {
    private static final int INITIAL_DESTINATION_LIST_ASG_CAPACITY = 1;
    private final BAPArrayDataENI bapArrayDataEni;
    private static final int[] ERROR_MAPPING = BAPModuleENI.errorMapping();
    static /* synthetic */ Class class$de$audi$atip$interapp$bap$eni$BAPServiceENI;
    static /* synthetic */ Class class$de$audi$atip$interapp$bap$eni$BAPServiceENIListener;

    public BAPModuleENI(AbstractBAPApplication abstractBAPApplication) {
        super(55, abstractBAPApplication);
        this.addAppConnector("AppBapENI", new AppConnectorENI(this, this.functionRegistration));
        this.bapArrayDataEni = new BAPArrayDataENI(this.logChannel);
    }

    public BAPModuleENI(AbstractBAPApplication abstractBAPApplication, IBAPFunctionFactoryASG iBAPFunctionFactoryASG) {
        super(55, abstractBAPApplication, iBAPFunctionFactoryASG);
        this.addAppConnector("AppBapENI", new AppConnectorENI(this, this.functionRegistration));
        this.bapArrayDataEni = new BAPArrayDataENI(this.logChannel);
    }

    protected void initModuleComponents() {
        this.logChannel.log(10000000, "[BAPModuleENI#initModuleComponents]");
        this.indicationHandler = new BAPIndicationHandlerENI(this);
        this.functionRegistration = new FunctionRegistrationENI(this);
        this.functionListAsg = new FunctionListENI();
        this.functionListAsg.init(this);
        this.initializationManager = new InitializationManagerENI(this, this.bapApplication.getDSIBAPController(), this.bapApplication.getPowerState());
    }

    protected void initServiceManager(BundleContext bundleContext) {
        this.serviceManager = new ServiceManagerENI(this, bundleContext);
    }

    protected void setInitialValues() {
        DestinationList_ASGcapacity_SetGet destinationList_ASGcapacity_SetGet = (DestinationList_ASGcapacity_SetGet)this.createSetGetSerializer(17);
        destinationList_ASGcapacity_SetGet.asgcapacity = 1;
        BAPFunctionPropertyASG bAPFunctionPropertyASG = this.getBAPFunctionPropertyASG(17);
        if (bAPFunctionPropertyASG != null) {
            bAPFunctionPropertyASG.setSetGetSerializer(destinationList_ASGcapacity_SetGet);
        } else {
            this.logChannel.log(100000, "[BAPModuleENI#setInitialValues] bapFunctionPropertyASG is NULL");
        }
    }

    protected String getLSGDescription() {
        return "0x37 (ENI)";
    }

    protected IFunctionIDs getFunctionIDs() {
        return new FunctionIDsENI();
    }

    protected IErrorCodes getErrorIDs() {
        return new ErrorCodesENI();
    }

    public int[] getErrorMapping() {
        this.logChannel.log(10000, "[BAPModuleENI#getErrorMapping]");
        return ERROR_MAPPING;
    }

    protected IDataTypeMapping getDataTypeMapping() {
        return new DataTypeMappingENI();
    }

    protected void initDiagnosisConnector() {
        this.diagnosisConnectorAsg = new BAPDiagnosisConnectorENI(this.bapApplication, this);
    }

    public BAPServiceENI getAppServiceENI() {
        BAPServiceENI bAPServiceENI = this.appConnectorENI();
        if (bAPServiceENI == null) {
            this.logChannel.log(10000, "[BAPModuleENI#getAppServiceENI] appConnectorENI() returned null");
            bAPServiceENI = (BAPServiceENI)NullObjectFactory.makeNullObjectFor(class$de$audi$atip$interapp$bap$eni$BAPServiceENI == null ? (class$de$audi$atip$interapp$bap$eni$BAPServiceENI = BAPModuleENI.class$("de.audi.atip.interapp.bap.eni.BAPServiceENI")) : class$de$audi$atip$interapp$bap$eni$BAPServiceENI);
        }
        return bAPServiceENI;
    }

    public void setAppServiceListenerENI(BAPServiceENIListener bAPServiceENIListener) {
        this.logChannel.log(10000000, "[BAPModuleENI#setAppServiceListenerENI] called");
        this.appConnectorENI().setAppServiceListener(bAPServiceENIListener);
        if (bAPServiceENIListener == null) {
            this.logChannel.log(10000000, "[BAPModuleENI#setAppServiceListenerENI] serviceListener is null!");
            return;
        }
        if (this.getBapArrayDataENI().getUserList().isUpToDate()) {
            bAPServiceENIListener.onUserList(this.getBapArrayDataENI().users());
        }
        if (this.getBapArrayDataENI().getServiceList().isUpToDate()) {
            bAPServiceENIListener.onServiceList(this.getBapArrayDataENI().services());
        }
        if (this.communicationState.isUp()) {
            this.logChannel.log(10000000, "[BAPModuleENI#setAppServiceListenerENI] notify onCommunicationUp()");
            this.getAppServiceListenerENI().onCommunicationUp();
        }
    }

    protected void onCommunicationUp() {
        this.logChannel.log(10000000, "[BAPModuleENI#onCommunicationUp]");
        ((AbstractBAPModuleInitializationManagerASG)this.initializationManager).sendSetGetProperties();
        this.getAppServiceListenerENI().onCommunicationUp();
    }

    public BAPServiceENIListener getAppServiceListenerENI() {
        BAPServiceENIListener bAPServiceENIListener = (BAPServiceENIListener)this.appConnectorENI().getAppServiceListener();
        if (bAPServiceENIListener == null) {
            this.logChannel.log(10000000, "[BAPModuleENI#getAppServiceListenerENI] No app listener set. Returning a NullListener.");
            bAPServiceENIListener = (BAPServiceENIListener)NullObjectFactory.makeNullObjectFor(class$de$audi$atip$interapp$bap$eni$BAPServiceENIListener == null ? (class$de$audi$atip$interapp$bap$eni$BAPServiceENIListener = BAPModuleENI.class$("de.audi.atip.interapp.bap.eni.BAPServiceENIListener")) : class$de$audi$atip$interapp$bap$eni$BAPServiceENIListener);
        }
        return bAPServiceENIListener;
    }

    public BAPArrayDataENI getBapArrayDataENI() {
        return this.bapArrayDataEni;
    }

    public void destroy() {
        this.bapArrayDataEni.clear();
        super.destroy();
    }

    private AppConnectorENI appConnectorENI() {
        return (AppConnectorENI)this.getAppConnectors().get("AppBapENI");
    }

    private static int[] errorMapping() {
        int[] nArray = new int[]{65, 65, 65, 80, 65, 65, 66, 65, 34, 67};
        return nArray;
    }

    public void updateInitState(AbstractBAPModule abstractBAPModule, int n) {
        this.logChannel.log(10000000, "[BAPModuleENI#updateInitState] initState: %1", (long)n);
        this.communicationState.updateInitState(n);
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

