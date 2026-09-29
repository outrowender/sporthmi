/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.generated.onlinefunctions.serializer;

import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.requests.StatusProperty;
import de.vw.mib.bap.stream.BitStream;

public final class FunctionList_Status
implements StatusProperty {
    public boolean reserved_bit_0;
    public boolean fctGetAllAvailable;
    public boolean fctBap_ConfigAvailable;
    public boolean fctFunctionListAvailable;
    public boolean fctHeartbeatAvailable;
    private static final int RESERVED_BIT_5__12_BITSIZE;
    public boolean fctFsg_ControlAvailable;
    public boolean fctFsg_SetupAvailable;
    public boolean fctFsg_OperationStateAvailable;
    public boolean fctTrafficLightOnline_InfoAvailable;
    public boolean fctTrafficLightOnline_SpeedAvailable;
    public boolean fctTrafficLightOnline_TimeAvailable;
    private static final int RESERVED_BIT_19__63_BITSIZE;
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
        this.fctGetAllAvailable = false;
        this.fctBap_ConfigAvailable = false;
        this.fctFunctionListAvailable = false;
        this.fctHeartbeatAvailable = false;
        this.fctFsg_ControlAvailable = false;
        this.fctFsg_SetupAvailable = false;
        this.fctFsg_OperationStateAvailable = false;
        this.fctTrafficLightOnline_InfoAvailable = false;
        this.fctTrafficLightOnline_SpeedAvailable = false;
        this.fctTrafficLightOnline_TimeAvailable = false;
    }

    @Override
    public void reset() {
        this.internalReset();
    }

    @Override
    public boolean equalTo(BAPEntity bAPEntity) {
        FunctionList_Status functionList_Status = (FunctionList_Status)bAPEntity;
        return this.reserved_bit_0 == functionList_Status.reserved_bit_0 && this.fctGetAllAvailable == functionList_Status.fctGetAllAvailable && this.fctBap_ConfigAvailable == functionList_Status.fctBap_ConfigAvailable && this.fctFunctionListAvailable == functionList_Status.fctFunctionListAvailable && this.fctHeartbeatAvailable == functionList_Status.fctHeartbeatAvailable && this.fctFsg_ControlAvailable == functionList_Status.fctFsg_ControlAvailable && this.fctFsg_SetupAvailable == functionList_Status.fctFsg_SetupAvailable && this.fctFsg_OperationStateAvailable == functionList_Status.fctFsg_OperationStateAvailable && this.fctTrafficLightOnline_InfoAvailable == functionList_Status.fctTrafficLightOnline_InfoAvailable && this.fctTrafficLightOnline_SpeedAvailable == functionList_Status.fctTrafficLightOnline_SpeedAvailable && this.fctTrafficLightOnline_TimeAvailable == functionList_Status.fctTrafficLightOnline_TimeAvailable;
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
        if (this.fctGetAllAvailable) {
            stringBuffer.append("true  (Fct \"GetAll\" available");
        } else {
            stringBuffer.append("false  (Fct \"GetAll\" not available");
        }
        stringBuffer.append("\n - Bit 2: ");
        if (this.fctBap_ConfigAvailable) {
            stringBuffer.append("true  (Fct \"BAP_Config\" available");
        } else {
            stringBuffer.append("false  (Fct \"BAP_Config\" not available");
        }
        stringBuffer.append("\n - Bit 3: ");
        if (this.fctFunctionListAvailable) {
            stringBuffer.append("true  (Fct \"FunctionList\" available");
        } else {
            stringBuffer.append("false  (Fct \"FunctionList\" not available");
        }
        stringBuffer.append("\n - Bit 4: ");
        if (this.fctHeartbeatAvailable) {
            stringBuffer.append("true  (Fct \"Heartbeat\" available");
        } else {
            stringBuffer.append("false  (Fct \"Heartbeat\" not available");
        }
        stringBuffer.append("\n - Bit 13: ");
        if (this.fctFsg_ControlAvailable) {
            stringBuffer.append("true  (Fct \"FSG_Control\" available");
        } else {
            stringBuffer.append("false  (Fct \"FSG_Control\" not available");
        }
        stringBuffer.append("\n - Bit 14: ");
        if (this.fctFsg_SetupAvailable) {
            stringBuffer.append("true  (Fct \"FSG_Setup\" available");
        } else {
            stringBuffer.append("false  (Fct \"FSG_Setup\" not available");
        }
        stringBuffer.append("\n - Bit 15: ");
        if (this.fctFsg_OperationStateAvailable) {
            stringBuffer.append("true  (Fct \"FSG_OperationState\" available");
        } else {
            stringBuffer.append("false  (Fct \"FSG_OperationState\" not available");
        }
        stringBuffer.append("\n - Bit 16: ");
        if (this.fctTrafficLightOnline_InfoAvailable) {
            stringBuffer.append("true  (Fct \"TrafficLightOnline_Info\" available");
        } else {
            stringBuffer.append("false  (Fct \"TrafficLightOnline_Info\" not available");
        }
        stringBuffer.append("\n - Bit 17: ");
        if (this.fctTrafficLightOnline_SpeedAvailable) {
            stringBuffer.append("true  (Fct \"TrafficLightOnline_Speed\" available");
        } else {
            stringBuffer.append("false  (Fct \"TrafficLightOnline_Speed\" not available");
        }
        stringBuffer.append("\n - Bit 18: ");
        if (this.fctTrafficLightOnline_TimeAvailable) {
            stringBuffer.append("true  (Fct \"TrafficLightOnline_Time\" available");
        } else {
            stringBuffer.append("false  (Fct \"TrafficLightOnline_Time\" not available");
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
        bitStream.pushBoolean(this.fctGetAllAvailable);
        bitStream.pushBoolean(this.fctBap_ConfigAvailable);
        bitStream.pushBoolean(this.fctFunctionListAvailable);
        bitStream.pushBoolean(this.fctHeartbeatAvailable);
        bitStream.resetBits(8);
        bitStream.pushBoolean(this.fctFsg_ControlAvailable);
        bitStream.pushBoolean(this.fctFsg_SetupAvailable);
        bitStream.pushBoolean(this.fctFsg_OperationStateAvailable);
        bitStream.pushBoolean(this.fctTrafficLightOnline_InfoAvailable);
        bitStream.pushBoolean(this.fctTrafficLightOnline_SpeedAvailable);
        bitStream.pushBoolean(this.fctTrafficLightOnline_TimeAvailable);
        bitStream.resetBits(45);
    }

    @Override
    public void deserialize(BitStream bitStream) {
        this.reserved_bit_0 = bitStream.popFrontBoolean();
        this.fctGetAllAvailable = bitStream.popFrontBoolean();
        this.fctBap_ConfigAvailable = bitStream.popFrontBoolean();
        this.fctFunctionListAvailable = bitStream.popFrontBoolean();
        this.fctHeartbeatAvailable = bitStream.popFrontBoolean();
        bitStream.discardBits(8);
        this.fctFsg_ControlAvailable = bitStream.popFrontBoolean();
        this.fctFsg_SetupAvailable = bitStream.popFrontBoolean();
        this.fctFsg_OperationStateAvailable = bitStream.popFrontBoolean();
        this.fctTrafficLightOnline_InfoAvailable = bitStream.popFrontBoolean();
        this.fctTrafficLightOnline_SpeedAvailable = bitStream.popFrontBoolean();
        this.fctTrafficLightOnline_TimeAvailable = bitStream.popFrontBoolean();
        bitStream.discardBits(45);
    }

    public static int functionId() {
        return 3;
    }

    @Override
    public int getFunctionId() {
        return FunctionList_Status.functionId();
    }
}

