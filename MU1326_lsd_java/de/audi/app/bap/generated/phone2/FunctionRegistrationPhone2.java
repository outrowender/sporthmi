/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.bap.generated.phone2;

import de.audi.app.bap.fw.AbstractBAPModuleFSG;
import de.audi.app.bap.fw.IFunctionRegistrationFSG;
import de.audi.app.bap.fw.functiontypes.BAPFunctionArrayFSG;
import de.audi.app.bap.fw.functiontypes.BAPFunctionMethodFSG;
import de.audi.app.bap.fw.functiontypes.BAPFunctionPropertyFSG;
import de.audi.app.bap.fw.functiontypes.IBAPFunction;
import de.audi.app.bap.utils.FunctionIDs;
import de.audi.app.bap.utils.LSGIDs;
import de.audi.atip.log.LogChannel;
import de.vw.mib.bap.generated.telephone2.serializer.AutomaticCallForwarding_Status;
import de.vw.mib.bap.generated.telephone2.serializer.BAP_Config_Reset;
import de.vw.mib.bap.generated.telephone2.serializer.BAP_Config_Status;
import de.vw.mib.bap.generated.telephone2.serializer.ConnectionState_Status;
import de.vw.mib.bap.generated.telephone2.serializer.DataConnectionIndication2_Status;
import de.vw.mib.bap.generated.telephone2.serializer.EmailState_Status;
import de.vw.mib.bap.generated.telephone2.serializer.FSG_OperationState_Status;
import de.vw.mib.bap.generated.telephone2.serializer.FSG_Setup_Status;
import de.vw.mib.bap.generated.telephone2.serializer.FunctionList_Status;
import de.vw.mib.bap.generated.telephone2.serializer.LockState2_Status;
import de.vw.mib.bap.generated.telephone2.serializer.MobileServiceSupport_Status;
import de.vw.mib.bap.generated.telephone2.serializer.NetworkProvider2_Status;
import de.vw.mib.bap.generated.telephone2.serializer.PhoneModuleState_Status;
import de.vw.mib.bap.generated.telephone2.serializer.PhonebookDownloadProgress_Status;
import de.vw.mib.bap.generated.telephone2.serializer.RegisterState2_Status;
import de.vw.mib.bap.generated.telephone2.serializer.SignalQuality2_Status;
import de.vw.mib.bap.requests.ChangedArray;
import de.vw.mib.bap.requests.ResultMethod;
import de.vw.mib.bap.requests.StatusAckProperty;
import de.vw.mib.bap.requests.StatusArray;
import de.vw.mib.bap.requests.StatusProperty;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class FunctionRegistrationPhone2
implements IFunctionRegistrationFSG {
    private BAPFunctionPropertyFSG bapConfig;
    private BAPFunctionPropertyFSG functionList;
    private BAPFunctionPropertyFSG fsgSetup;
    private BAPFunctionPropertyFSG fsgOperationState;
    private BAPFunctionPropertyFSG mobileServiceSupport;
    private BAPFunctionPropertyFSG registerState2;
    private BAPFunctionPropertyFSG lockState2;
    private BAPFunctionPropertyFSG networkProvider2;
    private BAPFunctionPropertyFSG signalQuality2;
    private BAPFunctionPropertyFSG dataConnectionIndication2;
    private BAPFunctionPropertyFSG emailState;
    private BAPFunctionPropertyFSG phoneModuleState;
    private BAPFunctionPropertyFSG connectionState;
    private BAPFunctionPropertyFSG automaticCallForwarding;
    private BAPFunctionPropertyFSG phonebookDownloadProgress;
    private boolean initialized = false;
    private final LogChannel logChannel;
    private final List allProperties = new ArrayList(15);
    private final List allMethods = new ArrayList();
    private final List allArrays = new ArrayList();

    public FunctionRegistrationPhone2(AbstractBAPModuleFSG abstractBAPModuleFSG) {
        this.logChannel = abstractBAPModuleFSG.getLogChannel();
        this.initialize(abstractBAPModuleFSG);
    }

    private void initialize(AbstractBAPModuleFSG abstractBAPModuleFSG) {
        this.logChannel.log(10000000, "[FunctionRegistrationPhone2#initialize] start initialization");
        this.initializeProperties(abstractBAPModuleFSG);
        this.initialized = true;
        this.logChannel.log(10000000, "[FunctionRegistrationPhone2#initialize] initialization completed");
    }

    private void initializeProperties(AbstractBAPModuleFSG abstractBAPModuleFSG) {
        this.logChannel.log(10000000, "[FunctionRegistrationPhone2#initializeProperties] initialize properties");
        this.bapConfig = abstractBAPModuleFSG.createBAPFunctionPropertyFSG(2);
        this.bapConfig.setResetSerializer(new BAP_Config_Reset());
        this.allProperties.add(this.bapConfig);
        this.functionList = abstractBAPModuleFSG.createBAPFunctionPropertyFSG(3);
        this.allProperties.add(this.functionList);
        this.fsgSetup = abstractBAPModuleFSG.createBAPFunctionPropertyFSG(14);
        this.allProperties.add(this.fsgSetup);
        this.fsgOperationState = abstractBAPModuleFSG.createBAPFunctionPropertyFSG(15);
        this.allProperties.add(this.fsgOperationState);
        this.mobileServiceSupport = abstractBAPModuleFSG.createBAPFunctionPropertyFSG(16);
        this.allProperties.add(this.mobileServiceSupport);
        this.registerState2 = abstractBAPModuleFSG.createBAPFunctionPropertyFSG(17);
        this.allProperties.add(this.registerState2);
        this.lockState2 = abstractBAPModuleFSG.createBAPFunctionPropertyFSG(18);
        this.allProperties.add(this.lockState2);
        this.networkProvider2 = abstractBAPModuleFSG.createBAPFunctionPropertyFSG(19);
        this.allProperties.add(this.networkProvider2);
        this.signalQuality2 = abstractBAPModuleFSG.createBAPFunctionPropertyFSG(20);
        this.allProperties.add(this.signalQuality2);
        this.dataConnectionIndication2 = abstractBAPModuleFSG.createBAPFunctionPropertyFSG(21);
        this.allProperties.add(this.dataConnectionIndication2);
        this.emailState = abstractBAPModuleFSG.createBAPFunctionPropertyFSG(22);
        this.allProperties.add(this.emailState);
        this.phoneModuleState = abstractBAPModuleFSG.createBAPFunctionPropertyFSG(23);
        this.allProperties.add(this.phoneModuleState);
        this.connectionState = abstractBAPModuleFSG.createBAPFunctionPropertyFSG(24);
        this.allProperties.add(this.connectionState);
        this.automaticCallForwarding = abstractBAPModuleFSG.createBAPFunctionPropertyFSG(25);
        this.allProperties.add(this.automaticCallForwarding);
        this.phonebookDownloadProgress = abstractBAPModuleFSG.createBAPFunctionPropertyFSG(26);
        this.allProperties.add(this.phonebookDownloadProgress);
    }

    public BAPFunctionMethodFSG getBAPFunctionMethodFSG(int n) {
        try {
            return (BAPFunctionMethodFSG)this.getBAPFunction(n);
        }
        catch (ClassCastException classCastException) {
            this.logChannel.log(10000, "[FunctionRegistrationPhone2#getBAPFunctionMethod] function is not of type 'Method': fctID=%1", (Object)FunctionIDs.getDescription(41, n));
            return null;
        }
    }

    public BAPFunctionPropertyFSG getBAPFunctionPropertyFSG(int n) {
        try {
            return (BAPFunctionPropertyFSG)this.getBAPFunction(n);
        }
        catch (ClassCastException classCastException) {
            this.logChannel.log(10000, "[FunctionRegistrationPhone2#getBAPFunctionProperty] function is not of type 'Property': fctID=%1", (Object)FunctionIDs.getDescription(41, n));
            return null;
        }
    }

    public BAPFunctionArrayFSG getBAPFunctionArrayFSG(int n) {
        try {
            return (BAPFunctionArrayFSG)this.getBAPFunction(n);
        }
        catch (ClassCastException classCastException) {
            this.logChannel.log(10000, "[FunctionRegistrationPhone2#getBAPFunctionArray] function is not of type 'Array': fctID=%1", (Object)FunctionIDs.getDescription(41, n));
            return null;
        }
    }

    public IBAPFunction getBAPFunction(int n) {
        if (!this.initialized) {
            this.logChannel.log(10000, "[FunctionRegistrationPhone2#getBAPFunction] function registration not initialized yet for lsgID=%1", (Object)LSGIDs.getDescription(41), (long)n);
        }
        switch (n) {
            case 2: {
                return this.bapConfig;
            }
            case 3: {
                return this.functionList;
            }
            case 14: {
                return this.fsgSetup;
            }
            case 15: {
                return this.fsgOperationState;
            }
            case 16: {
                return this.mobileServiceSupport;
            }
            case 17: {
                return this.registerState2;
            }
            case 18: {
                return this.lockState2;
            }
            case 19: {
                return this.networkProvider2;
            }
            case 20: {
                return this.signalQuality2;
            }
            case 21: {
                return this.dataConnectionIndication2;
            }
            case 22: {
                return this.emailState;
            }
            case 23: {
                return this.phoneModuleState;
            }
            case 24: {
                return this.connectionState;
            }
            case 25: {
                return this.automaticCallForwarding;
            }
            case 26: {
                return this.phonebookDownloadProgress;
            }
        }
        this.logChannel.log(10000, "[FunctionRegistrationPhone2#getBAPFunction] function not supported by FSG: lsgID=%1, fctID=%2", (Object)LSGIDs.getDescription(41), (Object)FunctionIDs.getDescription(41, n));
        return null;
    }

    public List getAllProperties() {
        return this.allProperties;
    }

    public List getAllMethods() {
        return this.allMethods;
    }

    public List getAllArrays() {
        return this.allArrays;
    }

    public void resetBAPFunctions() {
        this.logChannel.log(10000000, "[FunctionRegistrationPhone2#resetBAPFunctions]");
        Iterator iterator = this.allArrays.iterator();
        while (iterator.hasNext()) {
            ((IBAPFunction)iterator.next()).reset();
        }
        iterator = this.allProperties.iterator();
        while (iterator.hasNext()) {
            ((IBAPFunction)iterator.next()).reset();
        }
        iterator = this.allMethods.iterator();
        while (iterator.hasNext()) {
            ((IBAPFunction)iterator.next()).reset();
        }
    }

    public ResultMethod createResultForMethodFSG(int n) {
        switch (n) {
            default: 
        }
        this.logChannel.log(10000, "[FunctionRegistrationPhone2#createResultForMethodFSG] function not supported by FSG: lsgID=%1, fctID=%2", (Object)LSGIDs.getDescription(41), (Object)FunctionIDs.getDescription(41, n));
        return null;
    }

    public StatusProperty createStatusForPropertyFSG(int n) {
        switch (n) {
            case 2: {
                return new BAP_Config_Status();
            }
            case 3: {
                return new FunctionList_Status();
            }
            case 14: {
                return new FSG_Setup_Status();
            }
            case 15: {
                return new FSG_OperationState_Status();
            }
            case 16: {
                return new MobileServiceSupport_Status();
            }
            case 17: {
                return new RegisterState2_Status();
            }
            case 18: {
                return new LockState2_Status();
            }
            case 19: {
                return new NetworkProvider2_Status();
            }
            case 20: {
                return new SignalQuality2_Status();
            }
            case 21: {
                return new DataConnectionIndication2_Status();
            }
            case 22: {
                return new EmailState_Status();
            }
            case 23: {
                return new PhoneModuleState_Status();
            }
            case 24: {
                return new ConnectionState_Status();
            }
            case 25: {
                return new AutomaticCallForwarding_Status();
            }
            case 26: {
                return new PhonebookDownloadProgress_Status();
            }
        }
        this.logChannel.log(10000, "[FunctionRegistrationPhone2#createStatusForPropertyFSG] function not supported by FSG: lsgID=%1, fctID=%2", (Object)LSGIDs.getDescription(41), (Object)FunctionIDs.getDescription(41, n));
        return null;
    }

    public StatusAckProperty createStatusAckForPropertyFSG(int n) {
        switch (n) {
            default: 
        }
        this.logChannel.log(10000, "[FunctionRegistrationPhone2#createStatusAckForPropertyFSG] function not supported by FSG: lsgID=%1, fctID=%2", (Object)LSGIDs.getDescription(41), (Object)FunctionIDs.getDescription(41, n));
        return null;
    }

    public StatusArray createStatusArrayForArrayFSG(int n) {
        switch (n) {
            default: 
        }
        this.logChannel.log(10000, "[FunctionRegistrationPhone2#createStatusArrayForArrayFSG] function not supported by FSG: lsgID=%1, fctID=%2", (Object)LSGIDs.getDescription(41), (Object)FunctionIDs.getDescription(41, n));
        return null;
    }

    public ChangedArray createChangedArrayForArrayFSG(int n) {
        switch (n) {
            default: 
        }
        this.logChannel.log(10000, "[FunctionRegistrationPhone2#createChangedArrayForArrayFSG] function not supported by FSG: lsgID=%1, fctID=%2", (Object)LSGIDs.getDescription(41), (Object)FunctionIDs.getDescription(41, n));
        return null;
    }
}

