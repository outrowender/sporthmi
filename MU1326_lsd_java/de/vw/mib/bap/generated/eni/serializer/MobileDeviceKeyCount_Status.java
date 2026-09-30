/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.generated.eni.serializer;

import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.generated.eni.serializer.MobileDeviceKeyCount_NotificationState;
import de.vw.mib.bap.requests.StatusProperty;
import de.vw.mib.bap.stream.BitStream;

public final class MobileDeviceKeyCount_Status
implements StatusProperty {
    public int keyCountBackend;
    public static final int KEY_COUNT_BACKEND_MIN = 0;
    public MobileDeviceKeyCount_NotificationState notificationState = new MobileDeviceKeyCount_NotificationState();
    public int keyCountBackendState;
    public static final int KEY_COUNT_BACKEND_STATE_DELETION_IN_PROGRESS = 2;
    public static final int KEY_COUNT_BACKEND_STATE_NORMAL_OPERATION = 1;
    public static final int KEY_COUNT_BACKEND_STATE_INIT_UNKNOWN = 0;
    private static final int KEY_COUNT_BACKEND_STATE_BITSIZE = 4;
    public int extension1;
    public static final int EXTENSION1_MIN = 0;
    public int extension2;
    public static final int EXTENSION2_MIN = 0;
    public int extension3;
    public static final int EXTENSION3_MIN = 0;
    public int extension4;
    public static final int EXTENSION4_MIN = 0;

    public MobileDeviceKeyCount_Status() {
        this.internalReset();
        this.customInitialization();
    }

    public MobileDeviceKeyCount_Status(BitStream bitStream) {
        this();
        this.deserialize(bitStream);
    }

    private void internalReset() {
        this.keyCountBackend = 0;
        this.keyCountBackendState = 0;
        this.extension1 = 0;
        this.extension2 = 0;
        this.extension3 = 0;
        this.extension4 = 0;
    }

    public void reset() {
        this.internalReset();
        this.notificationState.reset();
    }

    public boolean equalTo(BAPEntity bAPEntity) {
        MobileDeviceKeyCount_Status mobileDeviceKeyCount_Status = (MobileDeviceKeyCount_Status)bAPEntity;
        return this.keyCountBackend == mobileDeviceKeyCount_Status.keyCountBackend && this.notificationState.equalTo(mobileDeviceKeyCount_Status.notificationState) && this.keyCountBackendState == mobileDeviceKeyCount_Status.keyCountBackendState && this.extension1 == mobileDeviceKeyCount_Status.extension1 && this.extension2 == mobileDeviceKeyCount_Status.extension2 && this.extension3 == mobileDeviceKeyCount_Status.extension3 && this.extension4 == mobileDeviceKeyCount_Status.extension4;
    }

    private void customInitialization() {
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("MobileDeviceKeyCount_Status");
        stringBuffer.append("\n - keyCountBackend:" + this.keyCountBackend);
        stringBuffer.append("\n - notificationState:" + this.notificationState.toString());
        stringBuffer.append("\n - keyCountBackendState:" + this.keyCountBackendState);
        stringBuffer.append("\n - extension1:" + this.extension1);
        stringBuffer.append("\n - extension2:" + this.extension2);
        stringBuffer.append("\n - extension3:" + this.extension3);
        stringBuffer.append("\n - extension4:" + this.extension4);
        return stringBuffer.toString();
    }

    public int bitSize() {
        return 0;
    }

    public void serialize(BitStream bitStream) {
        bitStream.pushByte((byte)this.keyCountBackend);
        this.notificationState.serialize(bitStream);
        bitStream.pushBits(4, this.keyCountBackendState);
        bitStream.pushByte((byte)this.extension1);
        bitStream.pushByte((byte)this.extension2);
        bitStream.pushByte((byte)this.extension3);
        bitStream.pushByte((byte)this.extension4);
    }

    public void deserialize(BitStream bitStream) {
        this.keyCountBackend = bitStream.popFrontByte();
        this.notificationState.deserialize(bitStream);
        this.keyCountBackendState = bitStream.popFrontBits(4);
        this.extension1 = bitStream.popFrontByte();
        this.extension2 = bitStream.popFrontByte();
        this.extension3 = bitStream.popFrontByte();
        this.extension4 = bitStream.popFrontByte();
    }

    public static int functionId() {
        return 26;
    }

    public int getFunctionId() {
        return MobileDeviceKeyCount_Status.functionId();
    }
}

