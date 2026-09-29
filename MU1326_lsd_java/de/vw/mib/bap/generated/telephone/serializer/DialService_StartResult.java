/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.generated.telephone.serializer;

import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.requests.StartResultMethod;
import de.vw.mib.bap.stream.BitStream;

public final class DialService_StartResult
implements StartResultMethod {
    public int serviceType;
    private static final int SERVICE_TYPE_BITSIZE;
    public static final int SERVICE_TYPE_VOICE_MAILBOX;
    public static final int SERVICE_TYPE_INFO_CALL;
    public static final int SERVICE_TYPE_SERVICE_CALL;
    public static final int SERVICE_TYPE_EMERGENCY_CALL;

    public DialService_StartResult() {
        this.internalReset();
        this.customInitialization();
    }

    public DialService_StartResult(BitStream bitStream) {
        this();
        this.deserialize(bitStream);
    }

    private void internalReset() {
        this.serviceType = 0;
    }

    @Override
    public void reset() {
        this.internalReset();
    }

    @Override
    public boolean equalTo(BAPEntity bAPEntity) {
        DialService_StartResult dialService_StartResult = (DialService_StartResult)bAPEntity;
        return this.serviceType == dialService_StartResult.serviceType;
    }

    private void customInitialization() {
    }

    @Override
    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("DialService_StartResult:");
        stringBuffer.append("\n - ServiceType: ");
        switch (this.serviceType) {
            case 0: {
                stringBuffer.append("0x00 (voice mailbox)");
                break;
            }
            case 1: {
                stringBuffer.append("0x01 (info call)");
                break;
            }
            case 2: {
                stringBuffer.append("0x02 (service call)");
                break;
            }
            case 3: {
                stringBuffer.append("0x03 (emergency call)");
                break;
            }
            default: {
                stringBuffer.append("UNKNOWN ENUM");
            }
        }
        return stringBuffer.toString();
    }

    @Override
    public int bitSize() {
        int n = 0;
        return n += 8;
    }

    @Override
    public void serialize(BitStream bitStream) {
        bitStream.pushByte((byte)this.serviceType);
    }

    @Override
    public void deserialize(BitStream bitStream) {
        this.serviceType = bitStream.popFrontByte();
    }

    public static int functionId() {
        return 27;
    }

    @Override
    public int getFunctionId() {
        return DialService_StartResult.functionId();
    }
}

