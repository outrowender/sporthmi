/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.generated.ecall.serializer;

import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.stream.BitStream;

public final class SupportedServices_Services
implements BAPEntity {
    public boolean reserved_bit_7;
    public boolean testModeSupportedDf3_4;
    public boolean mecSupported;
    public boolean reserved_bit_4;
    public boolean infoCallSupported;
    public boolean usmSupportedDf3_7;
    public boolean serviceBreakdownCallSupported;
    public boolean reserved_bit_0;

    public SupportedServices_Services() {
        this.internalReset();
        this.customInitialization();
    }

    public SupportedServices_Services(BitStream bitStream) {
        this();
        this.deserialize(bitStream);
    }

    private void internalReset() {
        this.reserved_bit_7 = false;
        this.testModeSupportedDf3_4 = false;
        this.mecSupported = false;
        this.reserved_bit_4 = false;
        this.infoCallSupported = false;
        this.usmSupportedDf3_7 = false;
        this.serviceBreakdownCallSupported = false;
        this.reserved_bit_0 = false;
    }

    @Override
    public void reset() {
        this.internalReset();
    }

    @Override
    public boolean equalTo(BAPEntity bAPEntity) {
        SupportedServices_Services supportedServices_Services = (SupportedServices_Services)bAPEntity;
        return this.reserved_bit_7 == supportedServices_Services.reserved_bit_7 && this.testModeSupportedDf3_4 == supportedServices_Services.testModeSupportedDf3_4 && this.mecSupported == supportedServices_Services.mecSupported && this.reserved_bit_4 == supportedServices_Services.reserved_bit_4 && this.infoCallSupported == supportedServices_Services.infoCallSupported && this.usmSupportedDf3_7 == supportedServices_Services.usmSupportedDf3_7 && this.serviceBreakdownCallSupported == supportedServices_Services.serviceBreakdownCallSupported && this.reserved_bit_0 == supportedServices_Services.reserved_bit_0;
    }

    private void customInitialization() {
    }

    @Override
    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("SupportedServices_Services");
        stringBuffer.append("\n - reserved_bit_7:").append(this.reserved_bit_7);
        stringBuffer.append("\n - testModeSupportedDf3_4:").append(this.testModeSupportedDf3_4);
        stringBuffer.append("\n - mecSupported:").append(this.mecSupported);
        stringBuffer.append("\n - reserved_bit_4:").append(this.reserved_bit_4);
        stringBuffer.append("\n - infoCallSupported:").append(this.infoCallSupported);
        stringBuffer.append("\n - usmSupportedDf3_7:").append(this.usmSupportedDf3_7);
        stringBuffer.append("\n - serviceBreakdownCallSupported:").append(this.serviceBreakdownCallSupported);
        stringBuffer.append("\n - reserved_bit_0:").append(this.reserved_bit_0);
        return stringBuffer.toString();
    }

    @Override
    public int bitSize() {
        return 0;
    }

    @Override
    public void serialize(BitStream bitStream) {
        bitStream.pushBoolean(this.reserved_bit_7);
        bitStream.pushBoolean(this.testModeSupportedDf3_4);
        bitStream.pushBoolean(this.mecSupported);
        bitStream.pushBoolean(this.reserved_bit_4);
        bitStream.pushBoolean(this.infoCallSupported);
        bitStream.pushBoolean(this.usmSupportedDf3_7);
        bitStream.pushBoolean(this.serviceBreakdownCallSupported);
        bitStream.pushBoolean(this.reserved_bit_0);
    }

    @Override
    public void deserialize(BitStream bitStream) {
        this.reserved_bit_7 = bitStream.popFrontBoolean();
        this.testModeSupportedDf3_4 = bitStream.popFrontBoolean();
        this.mecSupported = bitStream.popFrontBoolean();
        this.reserved_bit_4 = bitStream.popFrontBoolean();
        this.infoCallSupported = bitStream.popFrontBoolean();
        this.usmSupportedDf3_7 = bitStream.popFrontBoolean();
        this.serviceBreakdownCallSupported = bitStream.popFrontBoolean();
        this.reserved_bit_0 = bitStream.popFrontBoolean();
    }
}

