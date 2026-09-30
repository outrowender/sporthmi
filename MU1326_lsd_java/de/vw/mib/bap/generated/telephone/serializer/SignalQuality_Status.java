/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.generated.telephone.serializer;

import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.requests.StatusProperty;
import de.vw.mib.bap.stream.BitStream;

public final class SignalQuality_Status
implements StatusProperty {
    public int quality;
    private static final int QUALITY_BITSIZE = 8;

    public SignalQuality_Status() {
        this.internalReset();
        this.customInitialization();
    }

    public SignalQuality_Status(BitStream bitStream) {
        this();
        this.deserialize(bitStream);
    }

    private void internalReset() {
        this.quality = 0;
    }

    public void reset() {
        this.internalReset();
    }

    public boolean equalTo(BAPEntity bAPEntity) {
        SignalQuality_Status signalQuality_Status = (SignalQuality_Status)bAPEntity;
        return this.quality == signalQuality_Status.quality;
    }

    private void customInitialization() {
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("SignalQuality_Status:");
        stringBuffer.append("\n - Quality - ");
        stringBuffer.append(this.quality);
        return stringBuffer.toString();
    }

    public int bitSize() {
        int n = 0;
        return n += 8;
    }

    public void serialize(BitStream bitStream) {
        bitStream.pushByte((byte)this.quality);
    }

    public void deserialize(BitStream bitStream) {
        this.quality = bitStream.popFrontByte();
    }

    public static int functionId() {
        return 21;
    }

    public int getFunctionId() {
        return SignalQuality_Status.functionId();
    }
}

