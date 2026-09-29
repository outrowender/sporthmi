/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.generated.ecall.serializer;

import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.requests.StatusProperty;
import de.vw.mib.bap.stream.BitStream;

public final class SignalQuality_Status
implements StatusProperty {
    public int quality;
    public static final int QUALITY_MIN;

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

    @Override
    public void reset() {
        this.internalReset();
    }

    @Override
    public boolean equalTo(BAPEntity bAPEntity) {
        SignalQuality_Status signalQuality_Status = (SignalQuality_Status)bAPEntity;
        return this.quality == signalQuality_Status.quality;
    }

    private void customInitialization() {
    }

    @Override
    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("SignalQuality_Status");
        stringBuffer.append("\n - quality:").append(this.quality);
        return stringBuffer.toString();
    }

    @Override
    public int bitSize() {
        return 0;
    }

    @Override
    public void serialize(BitStream bitStream) {
        bitStream.pushByte((byte)this.quality);
    }

    @Override
    public void deserialize(BitStream bitStream) {
        this.quality = bitStream.popFrontByte();
    }

    public static int functionId() {
        return 23;
    }

    @Override
    public int getFunctionId() {
        return SignalQuality_Status.functionId();
    }
}

