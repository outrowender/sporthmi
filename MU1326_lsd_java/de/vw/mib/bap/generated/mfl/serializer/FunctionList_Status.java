/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.generated.mfl.serializer;

import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.requests.StatusProperty;
import de.vw.mib.bap.stream.BitStream;

public final class FunctionList_Status
implements StatusProperty {
    public boolean reserved_bit_0;
    public boolean fct_GetAllAvailable;
    public boolean fct_Bap_ConfigAvailable;
    public boolean fct_FunctionListAvailable;
    public boolean fct_HeartBeatAvailable;
    private static final int RESERVED_BIT_5__13_BITSIZE;
    public boolean fct_Fsg_SetupAvailable;
    public boolean fct_Fsg_OperationStateAvailable;
    public boolean fct_InstrumentClusterFunctionsAvailable;
    public boolean fct_KeyConfigurationAvailable;
    public boolean fct_KeyActionAvailable;
    public boolean fct_Pu_ContentAvailable;
    public boolean fct_Pu_ActionAvailable;
    private static final int RESERVED_BIT_21__63_BITSIZE;
    private static final int FUNCTION_LIST_STATUS_BITSIZE;

    public FunctionList_Status() {
        this.internalReset();
        this.customInitialization();
    }

    public FunctionList_Status(BitStream bitStream) {
        this();
        this.deserialize(bitStream);
    }

    private void internalReset() {
        this.reserved_bit_0 = false;
        this.fct_GetAllAvailable = false;
        this.fct_Bap_ConfigAvailable = false;
        this.fct_FunctionListAvailable = false;
        this.fct_HeartBeatAvailable = false;
        this.fct_Fsg_SetupAvailable = false;
        this.fct_Fsg_OperationStateAvailable = false;
        this.fct_InstrumentClusterFunctionsAvailable = false;
        this.fct_KeyConfigurationAvailable = false;
        this.fct_KeyActionAvailable = false;
        this.fct_Pu_ContentAvailable = false;
        this.fct_Pu_ActionAvailable = false;
    }

    @Override
    public void reset() {
        this.internalReset();
    }

    @Override
    public boolean equalTo(BAPEntity bAPEntity) {
        FunctionList_Status functionList_Status = (FunctionList_Status)bAPEntity;
        return this.reserved_bit_0 == functionList_Status.reserved_bit_0 && this.fct_GetAllAvailable == functionList_Status.fct_GetAllAvailable && this.fct_Bap_ConfigAvailable == functionList_Status.fct_Bap_ConfigAvailable && this.fct_FunctionListAvailable == functionList_Status.fct_FunctionListAvailable && this.fct_HeartBeatAvailable == functionList_Status.fct_HeartBeatAvailable && this.fct_Fsg_SetupAvailable == functionList_Status.fct_Fsg_SetupAvailable && this.fct_Fsg_OperationStateAvailable == functionList_Status.fct_Fsg_OperationStateAvailable && this.fct_InstrumentClusterFunctionsAvailable == functionList_Status.fct_InstrumentClusterFunctionsAvailable && this.fct_KeyConfigurationAvailable == functionList_Status.fct_KeyConfigurationAvailable && this.fct_KeyActionAvailable == functionList_Status.fct_KeyActionAvailable && this.fct_Pu_ContentAvailable == functionList_Status.fct_Pu_ContentAvailable && this.fct_Pu_ActionAvailable == functionList_Status.fct_Pu_ActionAvailable;
    }

    private void customInitialization() {
    }

    @Override
    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("FunctionList_Status:");
        stringBuffer.append("\n - Bit 0: ");
        if (this.reserved_bit_0) {
            stringBuffer.append("true  (reserved");
        } else {
            stringBuffer.append("false  (reserved");
        }
        stringBuffer.append("\n - Bit 1: ");
        if (this.fct_GetAllAvailable) {
            stringBuffer.append("true  (Fct. \"GetAll\" available");
        } else {
            stringBuffer.append("false  (Fct. \"GetAll\" not available");
        }
        stringBuffer.append("\n - Bit 2: ");
        if (this.fct_Bap_ConfigAvailable) {
            stringBuffer.append("true  (Fct. \"BAP_Config\" available");
        } else {
            stringBuffer.append("false  (Fct. \"BAP_Config\" not available");
        }
        stringBuffer.append("\n - Bit 3: ");
        if (this.fct_FunctionListAvailable) {
            stringBuffer.append("true  (Fct. \"FunctionList\" available");
        } else {
            stringBuffer.append("false  (Fct. \"FunctionList\" not available");
        }
        stringBuffer.append("\n - Bit 4: ");
        if (this.fct_HeartBeatAvailable) {
            stringBuffer.append("true  (Fct. \"HeartBeat\" available");
        } else {
            stringBuffer.append("false  (Fct. \"HeartBeat\" not available");
        }
        stringBuffer.append("\n - Bit 14: ");
        if (this.fct_Fsg_SetupAvailable) {
            stringBuffer.append("true  (Fct. \"FSG_Setup\" available");
        } else {
            stringBuffer.append("false  (Fct. \"FSG_Setup\" not available");
        }
        stringBuffer.append("\n - Bit 15: ");
        if (this.fct_Fsg_OperationStateAvailable) {
            stringBuffer.append("true  (Fct. \"FSG_OperationState\" available");
        } else {
            stringBuffer.append("false  (Fct. \"FSG_OperationState\" not available");
        }
        stringBuffer.append("\n - Bit 16: ");
        if (this.fct_InstrumentClusterFunctionsAvailable) {
            stringBuffer.append("true  (Fct. \"InstrumentClusterFunctions\" available");
        } else {
            stringBuffer.append("false  (Fct. \"InstrumentClusterFunctions\" not available");
        }
        stringBuffer.append("\n - Bit 17: ");
        if (this.fct_KeyConfigurationAvailable) {
            stringBuffer.append("true  (Fct. \"KeyConfiguration\" available");
        } else {
            stringBuffer.append("false  (Fct. \"KeyConfiguration\" not available");
        }
        stringBuffer.append("\n - Bit 18: ");
        if (this.fct_KeyActionAvailable) {
            stringBuffer.append("true  (Fct. \"KeyAction\" available");
        } else {
            stringBuffer.append("false  (Fct. \"KeyAction\" not available");
        }
        stringBuffer.append("\n - Bit 19: ");
        if (this.fct_Pu_ContentAvailable) {
            stringBuffer.append("true  (Fct. \"PU_Content\" available");
        } else {
            stringBuffer.append("false  (Fct. \"PU_Content\" not available");
        }
        stringBuffer.append("\n - Bit 20: ");
        if (this.fct_Pu_ActionAvailable) {
            stringBuffer.append("true  (Fct. \"PU_Action\" available");
        } else {
            stringBuffer.append("false  (Fct. \"PU_Action\" not available");
        }
        return stringBuffer.toString();
    }

    @Override
    public int bitSize() {
        int n = 0;
        return n += 64;
    }

    @Override
    public void serialize(BitStream bitStream) {
        bitStream.pushBoolean(this.reserved_bit_0);
        bitStream.pushBoolean(this.fct_GetAllAvailable);
        bitStream.pushBoolean(this.fct_Bap_ConfigAvailable);
        bitStream.pushBoolean(this.fct_FunctionListAvailable);
        bitStream.pushBoolean(this.fct_HeartBeatAvailable);
        bitStream.resetBits(9);
        bitStream.pushBoolean(this.fct_Fsg_SetupAvailable);
        bitStream.pushBoolean(this.fct_Fsg_OperationStateAvailable);
        bitStream.pushBoolean(this.fct_InstrumentClusterFunctionsAvailable);
        bitStream.pushBoolean(this.fct_KeyConfigurationAvailable);
        bitStream.pushBoolean(this.fct_KeyActionAvailable);
        bitStream.pushBoolean(this.fct_Pu_ContentAvailable);
        bitStream.pushBoolean(this.fct_Pu_ActionAvailable);
        bitStream.resetBits(43);
    }

    @Override
    public void deserialize(BitStream bitStream) {
        this.reserved_bit_0 = bitStream.popFrontBoolean();
        this.fct_GetAllAvailable = bitStream.popFrontBoolean();
        this.fct_Bap_ConfigAvailable = bitStream.popFrontBoolean();
        this.fct_FunctionListAvailable = bitStream.popFrontBoolean();
        this.fct_HeartBeatAvailable = bitStream.popFrontBoolean();
        bitStream.discardBits(9);
        this.fct_Fsg_SetupAvailable = bitStream.popFrontBoolean();
        this.fct_Fsg_OperationStateAvailable = bitStream.popFrontBoolean();
        this.fct_InstrumentClusterFunctionsAvailable = bitStream.popFrontBoolean();
        this.fct_KeyConfigurationAvailable = bitStream.popFrontBoolean();
        this.fct_KeyActionAvailable = bitStream.popFrontBoolean();
        this.fct_Pu_ContentAvailable = bitStream.popFrontBoolean();
        this.fct_Pu_ActionAvailable = bitStream.popFrontBoolean();
        bitStream.discardBits(43);
    }

    public static int functionId() {
        return 3;
    }

    @Override
    public int getFunctionId() {
        return FunctionList_Status.functionId();
    }
}

