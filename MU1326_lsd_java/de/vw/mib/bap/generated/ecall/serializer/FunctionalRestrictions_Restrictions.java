/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.generated.ecall.serializer;

import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.stream.BitStream;

public final class FunctionalRestrictions_Restrictions
implements BAPEntity {
    private static final int RESERVED_BIT_3__7_BITSIZE = 5;
    public boolean audioDownlinkNotFullyFunctional;
    public boolean audioUplinkNotFullyFunctional;
    public boolean audioNotFullyFunctional;

    public FunctionalRestrictions_Restrictions() {
        this.internalReset();
        this.customInitialization();
    }

    public FunctionalRestrictions_Restrictions(BitStream bitStream) {
        this();
        this.deserialize(bitStream);
    }

    private void internalReset() {
        this.audioDownlinkNotFullyFunctional = false;
        this.audioUplinkNotFullyFunctional = false;
        this.audioNotFullyFunctional = false;
    }

    public void reset() {
        this.internalReset();
    }

    public boolean equalTo(BAPEntity bAPEntity) {
        FunctionalRestrictions_Restrictions functionalRestrictions_Restrictions = (FunctionalRestrictions_Restrictions)bAPEntity;
        return this.audioDownlinkNotFullyFunctional == functionalRestrictions_Restrictions.audioDownlinkNotFullyFunctional && this.audioUplinkNotFullyFunctional == functionalRestrictions_Restrictions.audioUplinkNotFullyFunctional && this.audioNotFullyFunctional == functionalRestrictions_Restrictions.audioNotFullyFunctional;
    }

    private void customInitialization() {
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("FunctionalRestrictions_Restrictions");
        stringBuffer.append("\n - audioDownlinkNotFullyFunctional:").append(this.audioDownlinkNotFullyFunctional);
        stringBuffer.append("\n - audioUplinkNotFullyFunctional:").append(this.audioUplinkNotFullyFunctional);
        stringBuffer.append("\n - audioNotFullyFunctional:").append(this.audioNotFullyFunctional);
        return stringBuffer.toString();
    }

    public int bitSize() {
        return 0;
    }

    public void serialize(BitStream bitStream) {
        bitStream.resetBits(5);
        bitStream.pushBoolean(this.audioDownlinkNotFullyFunctional);
        bitStream.pushBoolean(this.audioUplinkNotFullyFunctional);
        bitStream.pushBoolean(this.audioNotFullyFunctional);
    }

    public void deserialize(BitStream bitStream) {
        bitStream.discardBits(5);
        this.audioDownlinkNotFullyFunctional = bitStream.popFrontBoolean();
        this.audioUplinkNotFullyFunctional = bitStream.popFrontBoolean();
        this.audioNotFullyFunctional = bitStream.popFrontBoolean();
    }
}

