/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.bap.generated.mfl;

import de.audi.app.bap.fw.AbstractBAPModuleFSG;
import de.audi.app.bap.fw.IFunctionRegistrationFSG;
import de.audi.app.bap.fw.functiontypes.BAPFunctionArrayFSG;
import de.audi.app.bap.fw.functiontypes.BAPFunctionMethodFSG;
import de.audi.app.bap.fw.functiontypes.BAPFunctionPropertyFSG;
import de.audi.app.bap.fw.functiontypes.IBAPFunction;
import de.audi.app.bap.utils.FunctionIDs;
import de.audi.app.bap.utils.LSGIDs;
import de.audi.atip.log.LogChannel;
import de.vw.mib.bap.generated.mfl.serializer.BAP_Config_Reset;
import de.vw.mib.bap.generated.mfl.serializer.BAP_Config_Status;
import de.vw.mib.bap.generated.mfl.serializer.FSG_OperationState_Status;
import de.vw.mib.bap.generated.mfl.serializer.FSG_Setup_Status;
import de.vw.mib.bap.generated.mfl.serializer.FunctionList_Status;
import de.vw.mib.bap.generated.mfl.serializer.InstrumentClusterFunctions_SetGet;
import de.vw.mib.bap.generated.mfl.serializer.InstrumentClusterFunctions_Status;
import de.vw.mib.bap.generated.mfl.serializer.KeyAction_Status;
import de.vw.mib.bap.generated.mfl.serializer.KeyConfiguration_Ack;
import de.vw.mib.bap.generated.mfl.serializer.KeyConfiguration_Status;
import de.vw.mib.bap.generated.mfl.serializer.KeyConfiguration_StatusAck;
import de.vw.mib.bap.generated.mfl.serializer.PU_Action_Result;
import de.vw.mib.bap.generated.mfl.serializer.PU_Action_StartResult;
import de.vw.mib.bap.generated.mfl.serializer.PU_Content_Status;
import de.vw.mib.bap.requests.ChangedArray;
import de.vw.mib.bap.requests.ResultMethod;
import de.vw.mib.bap.requests.StatusAckProperty;
import de.vw.mib.bap.requests.StatusArray;
import de.vw.mib.bap.requests.StatusProperty;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class FunctionRegistrationMFL
implements IFunctionRegistrationFSG {
    private BAPFunctionPropertyFSG bapConfig;
    private BAPFunctionPropertyFSG functionList;
    private BAPFunctionPropertyFSG fsgSetup;
    private BAPFunctionPropertyFSG fsgOperationState;
    private BAPFunctionPropertyFSG instrumentClusterFunctions;
    private BAPFunctionPropertyFSG keyConfiguration;
    private BAPFunctionPropertyFSG keyAction;
    private BAPFunctionPropertyFSG puContent;
    private BAPFunctionMethodFSG puAction;
    private boolean initialized = false;
    private final LogChannel logChannel;
    private final List allProperties = new ArrayList(8);
    private final List allMethods = new ArrayList(1);
    private final List allArrays = new ArrayList();

    public FunctionRegistrationMFL(AbstractBAPModuleFSG abstractBAPModuleFSG) {
        this.logChannel = abstractBAPModuleFSG.getLogChannel();
        this.initialize(abstractBAPModuleFSG);
    }

    private void initialize(AbstractBAPModuleFSG abstractBAPModuleFSG) {
        this.logChannel.log(-2137614336, "[FunctionRegistrationMFL#initialize] start initialization");
        this.initializeProperties(abstractBAPModuleFSG);
        this.initializeMethods(abstractBAPModuleFSG);
        this.initialized = true;
        this.logChannel.log(-2137614336, "[FunctionRegistrationMFL#initialize] initialization completed");
    }

    private void initializeProperties(AbstractBAPModuleFSG abstractBAPModuleFSG) {
        this.logChannel.log(-2137614336, "[FunctionRegistrationMFL#initializeProperties] initialize properties");
        this.bapConfig = abstractBAPModuleFSG.createBAPFunctionPropertyFSG(2);
        this.bapConfig.setResetSerializer(new BAP_Config_Reset());
        this.allProperties.add(this.bapConfig);
        this.functionList = abstractBAPModuleFSG.createBAPFunctionPropertyFSG(3);
        this.allProperties.add(this.functionList);
        this.fsgSetup = abstractBAPModuleFSG.createBAPFunctionPropertyFSG(14);
        this.allProperties.add(this.fsgSetup);
        this.fsgOperationState = abstractBAPModuleFSG.createBAPFunctionPropertyFSG(15);
        this.allProperties.add(this.fsgOperationState);
        this.instrumentClusterFunctions = abstractBAPModuleFSG.createBAPFunctionPropertyFSG(16);
        this.instrumentClusterFunctions.setSetGetSerializer(new InstrumentClusterFunctions_SetGet());
        this.allProperties.add(this.instrumentClusterFunctions);
        this.keyConfiguration = abstractBAPModuleFSG.createBAPFunctionPropertyFSG(17);
        this.keyConfiguration.setAckSerializer(new KeyConfiguration_Ack());
        this.allProperties.add(this.keyConfiguration);
        this.keyAction = abstractBAPModuleFSG.createBAPFunctionPropertyFSG(18);
        this.allProperties.add(this.keyAction);
        this.puContent = abstractBAPModuleFSG.createBAPFunctionPropertyFSG(19);
        this.allProperties.add(this.puContent);
    }

    private void initializeMethods(AbstractBAPModuleFSG abstractBAPModuleFSG) {
        this.logChannel.log(-2137614336, "[FunctionRegistrationMFL#initializeMethods] initialize methods");
        this.puAction = abstractBAPModuleFSG.createBAPFunctionMethodFSG(20);
        this.puAction.setStartResultSerializer(new PU_Action_StartResult());
        this.allMethods.add(this.puAction);
    }

    @Override
    public BAPFunctionMethodFSG getBAPFunctionMethodFSG(int n) {
        try {
            return (BAPFunctionMethodFSG)this.getBAPFunction(n);
        }
        catch (ClassCastException classCastException) {
            this.logChannel.log(10000, "[FunctionRegistrationMFL#getBAPFunctionMethod] function is not of type 'Method': fctID=%1", (Object)FunctionIDs.getDescription(52, n));
            return null;
        }
    }

    @Override
    public BAPFunctionPropertyFSG getBAPFunctionPropertyFSG(int n) {
        try {
            return (BAPFunctionPropertyFSG)this.getBAPFunction(n);
        }
        catch (ClassCastException classCastException) {
            this.logChannel.log(10000, "[FunctionRegistrationMFL#getBAPFunctionProperty] function is not of type 'Property': fctID=%1", (Object)FunctionIDs.getDescription(52, n));
            return null;
        }
    }

    @Override
    public BAPFunctionArrayFSG getBAPFunctionArrayFSG(int n) {
        try {
            return (BAPFunctionArrayFSG)this.getBAPFunction(n);
        }
        catch (ClassCastException classCastException) {
            this.logChannel.log(10000, "[FunctionRegistrationMFL#getBAPFunctionArray] function is not of type 'Array': fctID=%1", (Object)FunctionIDs.getDescription(52, n));
            return null;
        }
    }

    @Override
    public IBAPFunction getBAPFunction(int n) {
        if (!this.initialized) {
            this.logChannel.log(10000, "[FunctionRegistrationMFL#getBAPFunction] function registration not initialized yet for lsgID=%1", (Object)LSGIDs.getDescription(52), (long)n);
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
                return this.instrumentClusterFunctions;
            }
            case 17: {
                return this.keyConfiguration;
            }
            case 18: {
                return this.keyAction;
            }
            case 19: {
                return this.puContent;
            }
            case 20: {
                return this.puAction;
            }
        }
        this.logChannel.log(10000, "[FunctionRegistrationMFL#getBAPFunction] function not supported by FSG: lsgID=%1, fctID=%2", (Object)LSGIDs.getDescription(52), (Object)FunctionIDs.getDescription(52, n));
        return null;
    }

    @Override
    public List getAllProperties() {
        return this.allProperties;
    }

    @Override
    public List getAllMethods() {
        return this.allMethods;
    }

    @Override
    public List getAllArrays() {
        return this.allArrays;
    }

    @Override
    public void resetBAPFunctions() {
        this.logChannel.log(-2137614336, "[FunctionRegistrationMFL#resetBAPFunctions]");
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

    @Override
    public ResultMethod createResultForMethodFSG(int n) {
        switch (n) {
            case 20: {
                return new PU_Action_Result();
            }
        }
        this.logChannel.log(10000, "[FunctionRegistrationMFL#createResultForMethodFSG] function not supported by FSG: lsgID=%1, fctID=%2", (Object)LSGIDs.getDescription(52), (Object)FunctionIDs.getDescription(52, n));
        return null;
    }

    @Override
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
                return new InstrumentClusterFunctions_Status();
            }
            case 17: {
                return new KeyConfiguration_Status();
            }
            case 18: {
                return new KeyAction_Status();
            }
            case 19: {
                return new PU_Content_Status();
            }
        }
        this.logChannel.log(10000, "[FunctionRegistrationMFL#createStatusForPropertyFSG] function not supported by FSG: lsgID=%1, fctID=%2", (Object)LSGIDs.getDescription(52), (Object)FunctionIDs.getDescription(52, n));
        return null;
    }

    @Override
    public StatusAckProperty createStatusAckForPropertyFSG(int n) {
        switch (n) {
            case 17: {
                return new KeyConfiguration_StatusAck();
            }
        }
        this.logChannel.log(10000, "[FunctionRegistrationMFL#createStatusAckForPropertyFSG] function not supported by FSG: lsgID=%1, fctID=%2", (Object)LSGIDs.getDescription(52), (Object)FunctionIDs.getDescription(52, n));
        return null;
    }

    @Override
    public StatusArray createStatusArrayForArrayFSG(int n) {
        switch (n) {
            default: 
        }
        this.logChannel.log(10000, "[FunctionRegistrationMFL#createStatusArrayForArrayFSG] function not supported by FSG: lsgID=%1, fctID=%2", (Object)LSGIDs.getDescription(52), (Object)FunctionIDs.getDescription(52, n));
        return null;
    }

    @Override
    public ChangedArray createChangedArrayForArrayFSG(int n) {
        switch (n) {
            default: 
        }
        this.logChannel.log(10000, "[FunctionRegistrationMFL#createChangedArrayForArrayFSG] function not supported by FSG: lsgID=%1, fctID=%2", (Object)LSGIDs.getDescription(52), (Object)FunctionIDs.getDescription(52, n));
        return null;
    }
}

