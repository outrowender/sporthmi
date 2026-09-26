/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.bap.generated.onlinefunctions;

import de.audi.app.bap.fw.AbstractBAPModuleFSG;
import de.audi.app.bap.fw.IFunctionRegistrationFSG;
import de.audi.app.bap.fw.functiontypes.BAPFunctionArrayFSG;
import de.audi.app.bap.fw.functiontypes.BAPFunctionMethodFSG;
import de.audi.app.bap.fw.functiontypes.BAPFunctionPropertyFSG;
import de.audi.app.bap.fw.functiontypes.IBAPFunction;
import de.audi.app.bap.utils.FunctionIDs;
import de.audi.app.bap.utils.LSGIDs;
import de.audi.atip.log.LogChannel;
import de.vw.mib.bap.generated.onlinefunctions.serializer.BAP_Config_Reset;
import de.vw.mib.bap.generated.onlinefunctions.serializer.BAP_Config_Status;
import de.vw.mib.bap.generated.onlinefunctions.serializer.FSG_Control_SetGet;
import de.vw.mib.bap.generated.onlinefunctions.serializer.FSG_Control_Status;
import de.vw.mib.bap.generated.onlinefunctions.serializer.FSG_OperationState_Status;
import de.vw.mib.bap.generated.onlinefunctions.serializer.FSG_Setup_Status;
import de.vw.mib.bap.generated.onlinefunctions.serializer.FunctionList_Status;
import de.vw.mib.bap.generated.onlinefunctions.serializer.TrafficLightOnline_Info_Status;
import de.vw.mib.bap.generated.onlinefunctions.serializer.TrafficLightOnline_Speed_Status;
import de.vw.mib.bap.generated.onlinefunctions.serializer.TrafficLightOnline_Time_Status;
import de.vw.mib.bap.requests.ChangedArray;
import de.vw.mib.bap.requests.ResultMethod;
import de.vw.mib.bap.requests.StatusAckProperty;
import de.vw.mib.bap.requests.StatusArray;
import de.vw.mib.bap.requests.StatusProperty;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class FunctionRegistrationOnlineFunctions
implements IFunctionRegistrationFSG {
    private BAPFunctionPropertyFSG bapConfig;
    private BAPFunctionPropertyFSG functionList;
    private BAPFunctionPropertyFSG fsgControl;
    private BAPFunctionPropertyFSG fsgSetup;
    private BAPFunctionPropertyFSG fsgOperationState;
    private BAPFunctionPropertyFSG trafficLightOnlineInfo;
    private BAPFunctionPropertyFSG trafficLightOnlineSpeed;
    private BAPFunctionPropertyFSG trafficLightOnlineTime;
    private boolean initialized = false;
    private final LogChannel logChannel;
    private final List allProperties = new ArrayList(8);
    private final List allMethods = new ArrayList();
    private final List allArrays = new ArrayList();

    public FunctionRegistrationOnlineFunctions(AbstractBAPModuleFSG abstractBAPModuleFSG) {
        this.logChannel = abstractBAPModuleFSG.getLogChannel();
        this.initialize(abstractBAPModuleFSG);
    }

    private void initialize(AbstractBAPModuleFSG abstractBAPModuleFSG) {
        this.logChannel.log(-2137614336, "[FunctionRegistrationOnlineFunctions#initialize] start initialization");
        this.initializeProperties(abstractBAPModuleFSG);
        this.initialized = true;
        this.logChannel.log(-2137614336, "[FunctionRegistrationOnlineFunctions#initialize] initialization completed");
    }

    private void initializeProperties(AbstractBAPModuleFSG abstractBAPModuleFSG) {
        this.logChannel.log(-2137614336, "[FunctionRegistrationOnlineFunctions#initializeProperties] initialize properties");
        this.bapConfig = abstractBAPModuleFSG.createBAPFunctionPropertyFSG(2);
        this.bapConfig.setResetSerializer(new BAP_Config_Reset());
        this.allProperties.add(this.bapConfig);
        this.functionList = abstractBAPModuleFSG.createBAPFunctionPropertyFSG(3);
        this.allProperties.add(this.functionList);
        this.fsgControl = abstractBAPModuleFSG.createBAPFunctionPropertyFSG(13);
        this.fsgControl.setSetGetSerializer(new FSG_Control_SetGet());
        this.allProperties.add(this.fsgControl);
        this.fsgSetup = abstractBAPModuleFSG.createBAPFunctionPropertyFSG(14);
        this.allProperties.add(this.fsgSetup);
        this.fsgOperationState = abstractBAPModuleFSG.createBAPFunctionPropertyFSG(15);
        this.allProperties.add(this.fsgOperationState);
        this.trafficLightOnlineInfo = abstractBAPModuleFSG.createBAPFunctionPropertyFSG(16);
        this.allProperties.add(this.trafficLightOnlineInfo);
        this.trafficLightOnlineSpeed = abstractBAPModuleFSG.createBAPFunctionPropertyFSG(17);
        this.allProperties.add(this.trafficLightOnlineSpeed);
        this.trafficLightOnlineTime = abstractBAPModuleFSG.createBAPFunctionPropertyFSG(18);
        this.allProperties.add(this.trafficLightOnlineTime);
    }

    @Override
    public BAPFunctionMethodFSG getBAPFunctionMethodFSG(int n) {
        try {
            return (BAPFunctionMethodFSG)this.getBAPFunction(n);
        }
        catch (ClassCastException classCastException) {
            this.logChannel.log(10000, "[FunctionRegistrationOnlineFunctions#getBAPFunctionMethod] function is not of type 'Method': fctID=%1", (Object)FunctionIDs.getDescription(42, n));
            return null;
        }
    }

    @Override
    public BAPFunctionPropertyFSG getBAPFunctionPropertyFSG(int n) {
        try {
            return (BAPFunctionPropertyFSG)this.getBAPFunction(n);
        }
        catch (ClassCastException classCastException) {
            this.logChannel.log(10000, "[FunctionRegistrationOnlineFunctions#getBAPFunctionProperty] function is not of type 'Property': fctID=%1", (Object)FunctionIDs.getDescription(42, n));
            return null;
        }
    }

    @Override
    public BAPFunctionArrayFSG getBAPFunctionArrayFSG(int n) {
        try {
            return (BAPFunctionArrayFSG)this.getBAPFunction(n);
        }
        catch (ClassCastException classCastException) {
            this.logChannel.log(10000, "[FunctionRegistrationOnlineFunctions#getBAPFunctionArray] function is not of type 'Array': fctID=%1", (Object)FunctionIDs.getDescription(42, n));
            return null;
        }
    }

    @Override
    public IBAPFunction getBAPFunction(int n) {
        if (!this.initialized) {
            this.logChannel.log(10000, "[FunctionRegistrationOnlineFunctions#getBAPFunction] function registration not initialized yet for lsgID=%1", (Object)LSGIDs.getDescription(42), (long)n);
        }
        switch (n) {
            case 2: {
                return this.bapConfig;
            }
            case 3: {
                return this.functionList;
            }
            case 13: {
                return this.fsgControl;
            }
            case 14: {
                return this.fsgSetup;
            }
            case 15: {
                return this.fsgOperationState;
            }
            case 16: {
                return this.trafficLightOnlineInfo;
            }
            case 17: {
                return this.trafficLightOnlineSpeed;
            }
            case 18: {
                return this.trafficLightOnlineTime;
            }
        }
        this.logChannel.log(10000, "[FunctionRegistrationOnlineFunctions#getBAPFunction] function not supported by FSG: lsgID=%1, fctID=%2", (Object)LSGIDs.getDescription(42), (Object)FunctionIDs.getDescription(42, n));
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
        this.logChannel.log(-2137614336, "[FunctionRegistrationOnlineFunctions#resetBAPFunctions]");
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
            default: 
        }
        this.logChannel.log(10000, "[FunctionRegistrationOnlineFunctions#createResultForMethodFSG] function not supported by FSG: lsgID=%1, fctID=%2", (Object)LSGIDs.getDescription(42), (Object)FunctionIDs.getDescription(42, n));
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
            case 13: {
                return new FSG_Control_Status();
            }
            case 14: {
                return new FSG_Setup_Status();
            }
            case 15: {
                return new FSG_OperationState_Status();
            }
            case 16: {
                return new TrafficLightOnline_Info_Status();
            }
            case 17: {
                return new TrafficLightOnline_Speed_Status();
            }
            case 18: {
                return new TrafficLightOnline_Time_Status();
            }
        }
        this.logChannel.log(10000, "[FunctionRegistrationOnlineFunctions#createStatusForPropertyFSG] function not supported by FSG: lsgID=%1, fctID=%2", (Object)LSGIDs.getDescription(42), (Object)FunctionIDs.getDescription(42, n));
        return null;
    }

    @Override
    public StatusAckProperty createStatusAckForPropertyFSG(int n) {
        switch (n) {
            default: 
        }
        this.logChannel.log(10000, "[FunctionRegistrationOnlineFunctions#createStatusAckForPropertyFSG] function not supported by FSG: lsgID=%1, fctID=%2", (Object)LSGIDs.getDescription(42), (Object)FunctionIDs.getDescription(42, n));
        return null;
    }

    @Override
    public StatusArray createStatusArrayForArrayFSG(int n) {
        switch (n) {
            default: 
        }
        this.logChannel.log(10000, "[FunctionRegistrationOnlineFunctions#createStatusArrayForArrayFSG] function not supported by FSG: lsgID=%1, fctID=%2", (Object)LSGIDs.getDescription(42), (Object)FunctionIDs.getDescription(42, n));
        return null;
    }

    @Override
    public ChangedArray createChangedArrayForArrayFSG(int n) {
        switch (n) {
            default: 
        }
        this.logChannel.log(10000, "[FunctionRegistrationOnlineFunctions#createChangedArrayForArrayFSG] function not supported by FSG: lsgID=%1, fctID=%2", (Object)LSGIDs.getDescription(42), (Object)FunctionIDs.getDescription(42, n));
        return null;
    }
}

