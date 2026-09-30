/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.generated.ecall.serializer;

import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.generated.ecall.serializer.SupportedServices_Services;
import de.vw.mib.bap.requests.StatusProperty;
import de.vw.mib.bap.stream.BitStream;

public final class SupportedServices_Status
implements StatusProperty {
    public SupportedServices_Services services = new SupportedServices_Services();
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

    public SupportedServices_Status() {
        this.internalReset();
        this.customInitialization();
    }

    public SupportedServices_Status(BitStream bitStream) {
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
        this.services.reset();
    }

    public boolean equalTo(BAPEntity bAPEntity) {
        SupportedServices_Status supportedServices_Status = (SupportedServices_Status)bAPEntity;
        return this.services.equalTo(supportedServices_Status.services) && this.extension_3 == supportedServices_Status.extension_3 && this.extension_4 == supportedServices_Status.extension_4 && this.extension_5 == supportedServices_Status.extension_5 && this.extension_1 == supportedServices_Status.extension_1 && this.extension_2 == supportedServices_Status.extension_2;
    }

    private void customInitialization() {
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("SupportedServices_Status");
        stringBuffer.append("\n - services:").append(this.services.toString());
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
        this.services.serialize(bitStream);
        bitStream.pushByte((byte)this.extension_3);
        bitStream.pushByte((byte)this.extension_4);
        bitStream.pushByte((byte)this.extension_5);
        bitStream.pushByte((byte)this.extension_1);
        bitStream.pushByte((byte)this.extension_2);
    }

    public void deserialize(BitStream bitStream) {
        this.services.deserialize(bitStream);
        this.extension_3 = bitStream.popFrontByte();
        this.extension_4 = bitStream.popFrontByte();
        this.extension_5 = bitStream.popFrontByte();
        this.extension_1 = bitStream.popFrontByte();
        this.extension_2 = bitStream.popFrontByte();
    }

    public static int functionId() {
        return 27;
    }

    public int getFunctionId() {
        return SupportedServices_Status.functionId();
    }
}

