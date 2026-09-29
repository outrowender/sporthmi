/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.generated.ecall.serializer;

import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.stream.BitStream;

public final class ServiceRequest_Extension2
implements BAPEntity {
    private static final int RESERVED_BIT_0__7_BITSIZE;

    public ServiceRequest_Extension2() {
        this.internalReset();
        this.customInitialization();
    }

    public ServiceRequest_Extension2(BitStream bitStream) {
        this();
        this.deserialize(bitStream);
    }

    private void internalReset() {
    }

    @Override
    public void reset() {
        this.internalReset();
    }

    @Override
    public boolean equalTo(BAPEntity bAPEntity) {
        ServiceRequest_Extension2 serviceRequest_Extension2 = (ServiceRequest_Extension2)bAPEntity;
        return this.equals(serviceRequest_Extension2);
    }

    private void customInitialization() {
    }

    @Override
    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("ServiceRequest_Extension2");
        return stringBuffer.toString();
    }

    @Override
    public int bitSize() {
        return 0;
    }

    @Override
    public void serialize(BitStream bitStream) {
        bitStream.resetBits(8);
    }

    @Override
    public void deserialize(BitStream bitStream) {
        bitStream.discardBits(8);
    }
}

