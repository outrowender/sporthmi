/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.generated.remoteservices.serializer;

import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.datatypes.BAPString;
import de.vw.mib.bap.requests.StartResultMethod;
import de.vw.mib.bap.stream.BitStream;

public final class VTANDecryption_StartResult
implements StartResultMethod {
    public int asg_Id;
    public static final int ASG_ID_C_GW_OCU = 2;
    public static final int ASG_ID_HEAD_UNIT = 1;
    public static final int ASG_ID_DEFAULT_ASG = 0;
    public final BAPString vtandataEncrypted = new BAPString(700);
    private static final int MAX_VTANDATAENCRYPTED_LENGTH = 700;

    public VTANDecryption_StartResult() {
        this.internalReset();
        this.customInitialization();
    }

    public VTANDecryption_StartResult(BitStream bitStream) {
        this();
        this.deserialize(bitStream);
    }

    private void internalReset() {
        this.asg_Id = 0;
    }

    public void reset() {
        this.internalReset();
        this.vtandataEncrypted.reset();
    }

    public boolean equalTo(BAPEntity bAPEntity) {
        VTANDecryption_StartResult vTANDecryption_StartResult = (VTANDecryption_StartResult)bAPEntity;
        return this.asg_Id == vTANDecryption_StartResult.asg_Id && this.vtandataEncrypted.equalTo(vTANDecryption_StartResult.vtandataEncrypted);
    }

    private void customInitialization() {
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("VTANDecryption_StartResult");
        stringBuffer.append("\n - asg_Id:").append(this.asg_Id);
        stringBuffer.append("\n - vtandataEncrypted:").append(this.vtandataEncrypted.toString());
        return stringBuffer.toString();
    }

    public int bitSize() {
        return 0;
    }

    public void serialize(BitStream bitStream) {
        bitStream.pushByte((byte)this.asg_Id);
        this.vtandataEncrypted.serialize(bitStream);
    }

    public void deserialize(BitStream bitStream) {
        this.asg_Id = bitStream.popFrontByte();
        this.vtandataEncrypted.deserialize(bitStream);
    }

    public static int functionId() {
        return 25;
    }

    public int getFunctionId() {
        return VTANDecryption_StartResult.functionId();
    }
}

