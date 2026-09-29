/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.generated.remoteservices.serializer;

import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.stream.BitStream;

public final class FunctionList_FctList
implements BAPEntity {
    public boolean reserved_bit_0;
    public boolean fctGetAllAvailable;
    public boolean fctBap_ConfigAvailable;
    public boolean fctFunctionListAvailable;
    public boolean fctHeartbeatAvailable;
    private static final int RESERVED_BIT_5__12_BITSIZE;
    public boolean fctFsg_ControlAvailable;
    public boolean fctFsg_SetupAvailable;
    public boolean fctFsg_OperationStateAvailable;
    public boolean fctStartEngineChallengeAvailable;
    public boolean fctStartEngineAuthenticationAvailable;
    public boolean fctStartEngineSignatureAvailable;
    public boolean fctMobDevKeyChallengeAvailable;
    public boolean fctMobDevKeyAuthAvailable;
    public boolean fctMobDevKeyCommandAvailable;
    public boolean fctMobDevKeyActiveKeyAvailable;
    public boolean fctMobDevKeySetupAvailable;
    public boolean fctVtanauthDataAvailable;
    public boolean fctVtandecryptionAvailable;
    public boolean fctMobDevKeyControlAvailable;
    private static final int RESERVED_BIT_27__63_BITSIZE;

    public FunctionList_FctList() {
        this.internalReset();
        this.customInitialization();
    }

    public FunctionList_FctList(BitStream bitStream) {
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
        this.fctStartEngineChallengeAvailable = false;
        this.fctStartEngineAuthenticationAvailable = false;
        this.fctStartEngineSignatureAvailable = false;
        this.fctMobDevKeyChallengeAvailable = false;
        this.fctMobDevKeyAuthAvailable = false;
        this.fctMobDevKeyCommandAvailable = false;
        this.fctMobDevKeyActiveKeyAvailable = false;
        this.fctMobDevKeySetupAvailable = false;
        this.fctVtanauthDataAvailable = false;
        this.fctVtandecryptionAvailable = false;
        this.fctMobDevKeyControlAvailable = false;
    }

    @Override
    public void reset() {
        this.internalReset();
    }

    @Override
    public boolean equalTo(BAPEntity bAPEntity) {
        FunctionList_FctList functionList_FctList = (FunctionList_FctList)bAPEntity;
        return this.reserved_bit_0 == functionList_FctList.reserved_bit_0 && this.fctGetAllAvailable == functionList_FctList.fctGetAllAvailable && this.fctBap_ConfigAvailable == functionList_FctList.fctBap_ConfigAvailable && this.fctFunctionListAvailable == functionList_FctList.fctFunctionListAvailable && this.fctHeartbeatAvailable == functionList_FctList.fctHeartbeatAvailable && this.fctFsg_ControlAvailable == functionList_FctList.fctFsg_ControlAvailable && this.fctFsg_SetupAvailable == functionList_FctList.fctFsg_SetupAvailable && this.fctFsg_OperationStateAvailable == functionList_FctList.fctFsg_OperationStateAvailable && this.fctStartEngineChallengeAvailable == functionList_FctList.fctStartEngineChallengeAvailable && this.fctStartEngineAuthenticationAvailable == functionList_FctList.fctStartEngineAuthenticationAvailable && this.fctStartEngineSignatureAvailable == functionList_FctList.fctStartEngineSignatureAvailable && this.fctMobDevKeyChallengeAvailable == functionList_FctList.fctMobDevKeyChallengeAvailable && this.fctMobDevKeyAuthAvailable == functionList_FctList.fctMobDevKeyAuthAvailable && this.fctMobDevKeyCommandAvailable == functionList_FctList.fctMobDevKeyCommandAvailable && this.fctMobDevKeyActiveKeyAvailable == functionList_FctList.fctMobDevKeyActiveKeyAvailable && this.fctMobDevKeySetupAvailable == functionList_FctList.fctMobDevKeySetupAvailable && this.fctVtanauthDataAvailable == functionList_FctList.fctVtanauthDataAvailable && this.fctVtandecryptionAvailable == functionList_FctList.fctVtandecryptionAvailable && this.fctMobDevKeyControlAvailable == functionList_FctList.fctMobDevKeyControlAvailable;
    }

    private void customInitialization() {
    }

    @Override
    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("FunctionList_FctList");
        stringBuffer.append("\n - reserved_bit_0:").append(this.reserved_bit_0);
        stringBuffer.append("\n - fctGetAllAvailable:").append(this.fctGetAllAvailable);
        stringBuffer.append("\n - fctBap_ConfigAvailable:").append(this.fctBap_ConfigAvailable);
        stringBuffer.append("\n - fctFunctionListAvailable:").append(this.fctFunctionListAvailable);
        stringBuffer.append("\n - fctHeartbeatAvailable:").append(this.fctHeartbeatAvailable);
        stringBuffer.append("\n - fctFsg_ControlAvailable:").append(this.fctFsg_ControlAvailable);
        stringBuffer.append("\n - fctFsg_SetupAvailable:").append(this.fctFsg_SetupAvailable);
        stringBuffer.append("\n - fctFsg_OperationStateAvailable:").append(this.fctFsg_OperationStateAvailable);
        stringBuffer.append("\n - fctStartEngineChallengeAvailable:").append(this.fctStartEngineChallengeAvailable);
        stringBuffer.append("\n - fctStartEngineAuthenticationAvailable:").append(this.fctStartEngineAuthenticationAvailable);
        stringBuffer.append("\n - fctStartEngineSignatureAvailable:").append(this.fctStartEngineSignatureAvailable);
        stringBuffer.append("\n - fctMobDevKeyChallengeAvailable:").append(this.fctMobDevKeyChallengeAvailable);
        stringBuffer.append("\n - fctMobDevKeyAuthAvailable:").append(this.fctMobDevKeyAuthAvailable);
        stringBuffer.append("\n - fctMobDevKeyCommandAvailable:").append(this.fctMobDevKeyCommandAvailable);
        stringBuffer.append("\n - fctMobDevKeyActiveKeyAvailable:").append(this.fctMobDevKeyActiveKeyAvailable);
        stringBuffer.append("\n - fctMobDevKeySetupAvailable:").append(this.fctMobDevKeySetupAvailable);
        stringBuffer.append("\n - fctVtanauthDataAvailable:").append(this.fctVtanauthDataAvailable);
        stringBuffer.append("\n - fctVtandecryptionAvailable:").append(this.fctVtandecryptionAvailable);
        stringBuffer.append("\n - fctMobDevKeyControlAvailable:").append(this.fctMobDevKeyControlAvailable);
        return stringBuffer.toString();
    }

    @Override
    public int bitSize() {
        return 0;
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
        bitStream.pushBoolean(this.fctStartEngineChallengeAvailable);
        bitStream.pushBoolean(this.fctStartEngineAuthenticationAvailable);
        bitStream.pushBoolean(this.fctStartEngineSignatureAvailable);
        bitStream.pushBoolean(this.fctMobDevKeyChallengeAvailable);
        bitStream.pushBoolean(this.fctMobDevKeyAuthAvailable);
        bitStream.pushBoolean(this.fctMobDevKeyCommandAvailable);
        bitStream.pushBoolean(this.fctMobDevKeyActiveKeyAvailable);
        bitStream.pushBoolean(this.fctMobDevKeySetupAvailable);
        bitStream.pushBoolean(this.fctVtanauthDataAvailable);
        bitStream.pushBoolean(this.fctVtandecryptionAvailable);
        bitStream.pushBoolean(this.fctMobDevKeyControlAvailable);
        bitStream.resetBits(37);
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
        this.fctStartEngineChallengeAvailable = bitStream.popFrontBoolean();
        this.fctStartEngineAuthenticationAvailable = bitStream.popFrontBoolean();
        this.fctStartEngineSignatureAvailable = bitStream.popFrontBoolean();
        this.fctMobDevKeyChallengeAvailable = bitStream.popFrontBoolean();
        this.fctMobDevKeyAuthAvailable = bitStream.popFrontBoolean();
        this.fctMobDevKeyCommandAvailable = bitStream.popFrontBoolean();
        this.fctMobDevKeyActiveKeyAvailable = bitStream.popFrontBoolean();
        this.fctMobDevKeySetupAvailable = bitStream.popFrontBoolean();
        this.fctVtanauthDataAvailable = bitStream.popFrontBoolean();
        this.fctVtandecryptionAvailable = bitStream.popFrontBoolean();
        this.fctMobDevKeyControlAvailable = bitStream.popFrontBoolean();
        bitStream.discardBits(37);
    }
}

