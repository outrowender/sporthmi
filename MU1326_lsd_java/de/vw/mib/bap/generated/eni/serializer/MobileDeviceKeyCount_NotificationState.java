/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.generated.eni.serializer;

import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.stream.BitStream;

public final class MobileDeviceKeyCount_NotificationState
implements BAPEntity {
    private static final int RESERVED_BIT_1__3_BITSIZE = 3;
    public boolean vtanAvailableInBackendDf3_6;

    public MobileDeviceKeyCount_NotificationState() {
        this.internalReset();
        this.customInitialization();
    }

    public MobileDeviceKeyCount_NotificationState(BitStream bitStream) {
        this();
        this.deserialize(bitStream);
    }

    private void internalReset() {
        this.vtanAvailableInBackendDf3_6 = false;
    }

    public void reset() {
        this.internalReset();
    }

    public boolean equalTo(BAPEntity bAPEntity) {
        MobileDeviceKeyCount_NotificationState mobileDeviceKeyCount_NotificationState = (MobileDeviceKeyCount_NotificationState)bAPEntity;
        return this.vtanAvailableInBackendDf3_6 == mobileDeviceKeyCount_NotificationState.vtanAvailableInBackendDf3_6;
    }

    private void customInitialization() {
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("MobileDeviceKeyCount_NotificationState");
        stringBuffer.append("\n - vtanAvailableInBackendDf3_6:" + this.vtanAvailableInBackendDf3_6);
        return stringBuffer.toString();
    }

    public int bitSize() {
        return 0;
    }

    public void serialize(BitStream bitStream) {
        bitStream.resetBits(3);
        bitStream.pushBoolean(this.vtanAvailableInBackendDf3_6);
    }

    public void deserialize(BitStream bitStream) {
        bitStream.discardBits(3);
        this.vtanAvailableInBackendDf3_6 = bitStream.popFrontBoolean();
    }
}

