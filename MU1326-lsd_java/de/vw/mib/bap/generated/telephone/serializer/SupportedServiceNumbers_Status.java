/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.generated.telephone.serializer;

import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.generated.telephone.serializer.SupportedServiceNumbers_Status$ServiceNumbers;
import de.vw.mib.bap.requests.StatusProperty;
import de.vw.mib.bap.stream.BitStream;

public final class SupportedServiceNumbers_Status
implements StatusProperty {
    public final SupportedServiceNumbers_Status$ServiceNumbers serviceNumbers = new SupportedServiceNumbers_Status$ServiceNumbers();
    public static final int EXTENSION_1_MIN;
    public int extension_1;
    private static final int EXTENSION_1_BITSIZE;
    public static final int EXTENSION_2_MIN;
    public int extension_2;
    private static final int EXTENSION_2_BITSIZE;

    public SupportedServiceNumbers_Status() {
        this.internalReset();
        this.customInitialization();
    }

    public SupportedServiceNumbers_Status(BitStream bitStream) {
        this();
        this.deserialize(bitStream);
    }

    private void internalReset() {
        this.extension_1 = 0;
        this.extension_2 = 0;
    }

    @Override
    public void reset() {
        this.internalReset();
        this.serviceNumbers.reset();
    }

    @Override
    public boolean equalTo(BAPEntity bAPEntity) {
        SupportedServiceNumbers_Status supportedServiceNumbers_Status = (SupportedServiceNumbers_Status)bAPEntity;
        return this.serviceNumbers.equalTo(supportedServiceNumbers_Status.serviceNumbers) && this.extension_1 == supportedServiceNumbers_Status.extension_1 && this.extension_2 == supportedServiceNumbers_Status.extension_2;
    }

    private void customInitialization() {
    }

    @Override
    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("SupportedServiceNumbers_Status:");
        stringBuffer.append("\n - ServiceNumbers - ");
        stringBuffer.append(this.serviceNumbers.toString());
        stringBuffer.append("\n - Extension_1 - ");
        stringBuffer.append(this.extension_1);
        stringBuffer.append("\n - Extension_2 - ");
        stringBuffer.append(this.extension_2);
        return stringBuffer.toString();
    }

    @Override
    public int bitSize() {
        int n = 0;
        n += this.serviceNumbers.bitSize();
        n += 8;
        return n += 8;
    }

    @Override
    public void serialize(BitStream bitStream) {
        this.serviceNumbers.serialize(bitStream);
        bitStream.pushByte((byte)this.extension_1);
        bitStream.pushByte((byte)this.extension_2);
    }

    @Override
    public void deserialize(BitStream bitStream) {
        this.serviceNumbers.deserialize(bitStream);
        this.extension_1 = bitStream.popFrontByte();
        this.extension_2 = bitStream.popFrontByte();
    }

    public static int functionId() {
        return 59;
    }

    @Override
    public int getFunctionId() {
        return SupportedServiceNumbers_Status.functionId();
    }
}

