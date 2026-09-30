/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.generated.ecall.serializer;

import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.generated.ecall.serializer.FunctionalRestrictions_Restrictions;
import de.vw.mib.bap.requests.StatusProperty;
import de.vw.mib.bap.stream.BitStream;

public final class FunctionalRestrictions_Status
implements StatusProperty {
    public FunctionalRestrictions_Restrictions restrictions = new FunctionalRestrictions_Restrictions();
    public int extension_3;
    public static final int EXTENSION_3_MIN = 0;
    public int extension_4;
    public static final int EXTENSION_4_MIN = 0;
    public int extension_5;
    public static final int EXTENSION_5_MIN = 0;
    public int extension_1;
    public static final int EXTENSION_1_MIN = 0;
    public int extension_2;
    public static final int EXTENSION_2_MIN = 0;

    public FunctionalRestrictions_Status() {
        this.internalReset();
        this.customInitialization();
    }

    public FunctionalRestrictions_Status(BitStream bitStream) {
        this();
        this.deserialize(bitStream);
    }

    private void internalReset() {
        this.extension_3 = 0;
        this.extension_4 = 0;
        this.extension_5 = 0;
        this.extension_1 = 0;
        this.extension_2 = 0;
    }

    public void reset() {
        this.internalReset();
        this.restrictions.reset();
    }

    public boolean equalTo(BAPEntity bAPEntity) {
        FunctionalRestrictions_Status functionalRestrictions_Status = (FunctionalRestrictions_Status)bAPEntity;
        return this.restrictions.equalTo(functionalRestrictions_Status.restrictions) && this.extension_3 == functionalRestrictions_Status.extension_3 && this.extension_4 == functionalRestrictions_Status.extension_4 && this.extension_5 == functionalRestrictions_Status.extension_5 && this.extension_1 == functionalRestrictions_Status.extension_1 && this.extension_2 == functionalRestrictions_Status.extension_2;
    }

    private void customInitialization() {
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("FunctionalRestrictions_Status");
        stringBuffer.append("\n - restrictions:").append(this.restrictions.toString());
        stringBuffer.append("\n - extension_3:").append(this.extension_3);
        stringBuffer.append("\n - extension_4:").append(this.extension_4);
        stringBuffer.append("\n - extension_5:").append(this.extension_5);
        stringBuffer.append("\n - extension_1:").append(this.extension_1);
        stringBuffer.append("\n - extension_2:").append(this.extension_2);
        return stringBuffer.toString();
    }

    public int bitSize() {
        return 0;
    }

    public void serialize(BitStream bitStream) {
        this.restrictions.serialize(bitStream);
        bitStream.pushByte((byte)this.extension_3);
        bitStream.pushByte((byte)this.extension_4);
        bitStream.pushByte((byte)this.extension_5);
        bitStream.pushByte((byte)this.extension_1);
        bitStream.pushByte((byte)this.extension_2);
    }

    public void deserialize(BitStream bitStream) {
        this.restrictions.deserialize(bitStream);
        this.extension_3 = bitStream.popFrontByte();
        this.extension_4 = bitStream.popFrontByte();
        this.extension_5 = bitStream.popFrontByte();
        this.extension_1 = bitStream.popFrontByte();
        this.extension_2 = bitStream.popFrontByte();
    }

    public static int functionId() {
        return 28;
    }

    public int getFunctionId() {
        return FunctionalRestrictions_Status.functionId();
    }
}

