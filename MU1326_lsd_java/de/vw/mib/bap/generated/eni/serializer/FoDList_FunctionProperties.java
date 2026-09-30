/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.generated.eni.serializer;

import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.stream.BitStream;

public final class FoDList_FunctionProperties
implements BAPEntity {
    private static final int RESERVED_BIT_2__7_BITSIZE = 6;
    public boolean licenseExpiryWarningMustNotBeDisabled;
    public boolean licenseExpiryWarningNecessary;

    public FoDList_FunctionProperties() {
        this.internalReset();
        this.customInitialization();
    }

    public FoDList_FunctionProperties(BitStream bitStream) {
        this();
        this.deserialize(bitStream);
    }

    private void internalReset() {
        this.licenseExpiryWarningMustNotBeDisabled = false;
        this.licenseExpiryWarningNecessary = false;
    }

    public void reset() {
        this.internalReset();
    }

    public boolean equalTo(BAPEntity bAPEntity) {
        FoDList_FunctionProperties foDList_FunctionProperties = (FoDList_FunctionProperties)bAPEntity;
        return this.licenseExpiryWarningMustNotBeDisabled == foDList_FunctionProperties.licenseExpiryWarningMustNotBeDisabled && this.licenseExpiryWarningNecessary == foDList_FunctionProperties.licenseExpiryWarningNecessary;
    }

    private void customInitialization() {
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("FoDList_FunctionProperties");
        stringBuffer.append("\n - licenseExpiryWarningMustNotBeDisabled:" + this.licenseExpiryWarningMustNotBeDisabled);
        stringBuffer.append("\n - licenseExpiryWarningNecessary:" + this.licenseExpiryWarningNecessary);
        return stringBuffer.toString();
    }

    public int bitSize() {
        return 0;
    }

    public void serialize(BitStream bitStream) {
        bitStream.resetBits(6);
        bitStream.pushBoolean(this.licenseExpiryWarningMustNotBeDisabled);
        bitStream.pushBoolean(this.licenseExpiryWarningNecessary);
    }

    public void deserialize(BitStream bitStream) {
        bitStream.discardBits(6);
        this.licenseExpiryWarningMustNotBeDisabled = bitStream.popFrontBoolean();
        this.licenseExpiryWarningNecessary = bitStream.popFrontBoolean();
    }
}

