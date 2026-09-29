/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.generated.remoteservices.serializer;

import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.stream.BitStream;

public final class MobDevKeySetup_Setup
implements BAPEntity {
    private static final int RESERVED_BIT_4__7_BITSIZE;
    public boolean smartcardActivationRequested;
    public boolean mobileDeviceKeyReset;
    public boolean smartcardEnabled;
    public boolean mobileDeviceKeyEnabled;

    public MobDevKeySetup_Setup() {
        this.internalReset();
        this.customInitialization();
    }

    public MobDevKeySetup_Setup(BitStream bitStream) {
        this();
        this.deserialize(bitStream);
    }

    private void internalReset() {
        this.smartcardActivationRequested = false;
        this.mobileDeviceKeyReset = false;
        this.smartcardEnabled = false;
        this.mobileDeviceKeyEnabled = false;
    }

    @Override
    public void reset() {
        this.internalReset();
    }

    @Override
    public boolean equalTo(BAPEntity bAPEntity) {
        MobDevKeySetup_Setup mobDevKeySetup_Setup = (MobDevKeySetup_Setup)bAPEntity;
        return this.smartcardActivationRequested == mobDevKeySetup_Setup.smartcardActivationRequested && this.mobileDeviceKeyReset == mobDevKeySetup_Setup.mobileDeviceKeyReset && this.smartcardEnabled == mobDevKeySetup_Setup.smartcardEnabled && this.mobileDeviceKeyEnabled == mobDevKeySetup_Setup.mobileDeviceKeyEnabled;
    }

    private void customInitialization() {
    }

    @Override
    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("MobDevKeySetup_Setup");
        stringBuffer.append("\n - smartcardActivationRequested:").append(this.smartcardActivationRequested);
        stringBuffer.append("\n - mobileDeviceKeyReset:").append(this.mobileDeviceKeyReset);
        stringBuffer.append("\n - smartcardEnabled:").append(this.smartcardEnabled);
        stringBuffer.append("\n - mobileDeviceKeyEnabled:").append(this.mobileDeviceKeyEnabled);
        return stringBuffer.toString();
    }

    @Override
    public int bitSize() {
        return 0;
    }

    @Override
    public void serialize(BitStream bitStream) {
        bitStream.resetBits(4);
        bitStream.pushBoolean(this.smartcardActivationRequested);
        bitStream.pushBoolean(this.mobileDeviceKeyReset);
        bitStream.pushBoolean(this.smartcardEnabled);
        bitStream.pushBoolean(this.mobileDeviceKeyEnabled);
    }

    @Override
    public void deserialize(BitStream bitStream) {
        bitStream.discardBits(4);
        this.smartcardActivationRequested = bitStream.popFrontBoolean();
        this.mobileDeviceKeyReset = bitStream.popFrontBoolean();
        this.smartcardEnabled = bitStream.popFrontBoolean();
        this.mobileDeviceKeyEnabled = bitStream.popFrontBoolean();
    }
}

