/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.generated.remoteservices.serializer;

import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.datatypes.BAPString;
import de.vw.mib.bap.requests.StatusProperty;
import de.vw.mib.bap.stream.BitStream;

public final class MobDevKeyActiveKey_Status
implements StatusProperty {
    public int vehicleKeyNumber;
    public static final int VEHICLE_KEY_NUMBER_MIN = 0;
    public int vehicleKeyType;
    public static final int VEHICLE_KEY_TYPE_SMARTCARD = 3;
    public static final int VEHICLE_KEY_TYPE_MOBILE_DEVICE_KEY = 2;
    public static final int VEHICLE_KEY_TYPE_PHYSICAL_KEY = 1;
    public static final int VEHICLE_KEY_TYPE_INIT_UNKNOWN = 0;
    public final BAPString vehicleKeyIdentifier = new BAPString(17);
    private static final int MAX_VEHICLEKEYIDENTIFIER_LENGTH = 17;
    public int extension1;
    public static final int EXTENSION1_MIN = 0;
    public int extension2;
    public static final int EXTENSION2_MIN = 0;

    public MobDevKeyActiveKey_Status() {
        this.internalReset();
        this.customInitialization();
    }

    public MobDevKeyActiveKey_Status(BitStream bitStream) {
        this();
        this.deserialize(bitStream);
    }

    private void internalReset() {
        this.vehicleKeyNumber = 0;
        this.vehicleKeyType = 0;
        this.extension1 = 0;
        this.extension2 = 0;
    }

    public void reset() {
        this.internalReset();
        this.vehicleKeyIdentifier.reset();
    }

    public boolean equalTo(BAPEntity bAPEntity) {
        MobDevKeyActiveKey_Status mobDevKeyActiveKey_Status = (MobDevKeyActiveKey_Status)bAPEntity;
        return this.vehicleKeyNumber == mobDevKeyActiveKey_Status.vehicleKeyNumber && this.vehicleKeyType == mobDevKeyActiveKey_Status.vehicleKeyType && this.vehicleKeyIdentifier.equalTo(mobDevKeyActiveKey_Status.vehicleKeyIdentifier) && this.extension1 == mobDevKeyActiveKey_Status.extension1 && this.extension2 == mobDevKeyActiveKey_Status.extension2;
    }

    private void customInitialization() {
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("MobDevKeyActiveKey_Status");
        stringBuffer.append("\n - vehicleKeyNumber:").append(this.vehicleKeyNumber);
        stringBuffer.append("\n - vehicleKeyType:").append(this.vehicleKeyType);
        stringBuffer.append("\n - vehicleKeyIdentifier:").append(this.vehicleKeyIdentifier.toString());
        stringBuffer.append("\n - extension1:").append(this.extension1);
        stringBuffer.append("\n - extension2:").append(this.extension2);
        return stringBuffer.toString();
    }

    public int bitSize() {
        return 0;
    }

    public void serialize(BitStream bitStream) {
        bitStream.pushByte((byte)this.vehicleKeyNumber);
        bitStream.pushByte((byte)this.vehicleKeyType);
        this.vehicleKeyIdentifier.serialize(bitStream);
        bitStream.pushByte((byte)this.extension1);
        bitStream.pushByte((byte)this.extension2);
    }

    public void deserialize(BitStream bitStream) {
        this.vehicleKeyNumber = bitStream.popFrontByte();
        this.vehicleKeyType = bitStream.popFrontByte();
        this.vehicleKeyIdentifier.deserialize(bitStream);
        this.extension1 = bitStream.popFrontByte();
        this.extension2 = bitStream.popFrontByte();
    }

    public static int functionId() {
        return 22;
    }

    public int getFunctionId() {
        return MobDevKeyActiveKey_Status.functionId();
    }
}

