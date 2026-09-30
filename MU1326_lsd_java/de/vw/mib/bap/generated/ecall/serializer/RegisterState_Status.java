/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.generated.ecall.serializer;

import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.requests.StatusProperty;
import de.vw.mib.bap.stream.BitStream;

public final class RegisterState_Status
implements StatusProperty {
    public int registerStateVoice;
    public static final int REGISTER_STATE_VOICE_FUNCTION_NOT_SUPPORTED_BY_ME = 255;
    public static final int REGISTER_STATE_VOICE_REGISTERED_AND_ROAMING_ALTERNATIVE = 5;
    public static final int REGISTER_STATE_VOICE_REGISTERED_AND_ROAMING = 4;
    public static final int REGISTER_STATE_VOICE_REGISTRATION_DENIED = 3;
    public static final int REGISTER_STATE_VOICE_NOT_REGISTERED_AND_SEARCHING = 2;
    public static final int REGISTER_STATE_VOICE_REGISTERED = 1;
    public static final int REGISTER_STATE_VOICE_NOT_REGISTERED_AND_NOT_SEARCHING = 0;
    public int networkType;
    public static final int NETWORK_TYPE_LTE = 4;
    public static final int NETWORK_TYPE_CDMA = 3;
    public static final int NETWORK_TYPE_UMTS = 2;
    public static final int NETWORK_TYPE_GSM = 1;
    public static final int NETWORK_TYPE_UNKNOWN = 0;
    public int registerStateData;
    public static final int REGISTER_STATE_DATA_FUNCTION_NOT_SUPPORTED_BY_ME = 255;
    public static final int REGISTER_STATE_DATA_REGISTERED_AND_ROAMING_ALTERNATIVE = 5;
    public static final int REGISTER_STATE_DATA_REGISTERED_AND_ROAMING = 4;
    public static final int REGISTER_STATE_DATA_REGISTRATION_DENIED = 3;
    public static final int REGISTER_STATE_DATA_NOT_REGISTERED_AND_SEARCHING = 2;
    public static final int REGISTER_STATE_DATA_REGISTERED = 1;
    public static final int REGISTER_STATE_DATA_NOT_REGISTERED_AND_NOT_SEARCHING = 0;
    public int packetDataNetworkType;
    public static final int PACKET_DATA_NETWORK_TYPE_UNKNOWN_PACKET_DATA_NETWORK = 255;
    public static final int PACKET_DATA_NETWORK_TYPE_LTE = 6;
    public static final int PACKET_DATA_NETWORK_TYPE_CDMA = 5;
    public static final int PACKET_DATA_NETWORK_TYPE_HSUPA_HIGH_SPEED_UPLINK_PACKET_ACCESS = 4;
    public static final int PACKET_DATA_NETWORK_TYPE_HSDPA_HIGH_SPEED_DOWNLINK_PACKET_ACCESS = 3;
    public static final int PACKET_DATA_NETWORK_TYPE_GSM_EDGE = 2;
    public static final int PACKET_DATA_NETWORK_TYPE_GSM_GPRS = 1;
    public static final int PACKET_DATA_NETWORK_TYPE_NO_DATA_SERVICE = 0;

    public RegisterState_Status() {
        this.internalReset();
        this.customInitialization();
    }

    public RegisterState_Status(BitStream bitStream) {
        this();
        this.deserialize(bitStream);
    }

    private void internalReset() {
        this.registerStateVoice = 0;
        this.networkType = 0;
        this.registerStateData = 0;
        this.packetDataNetworkType = 0;
    }

    public void reset() {
        this.internalReset();
    }

    public boolean equalTo(BAPEntity bAPEntity) {
        RegisterState_Status registerState_Status = (RegisterState_Status)bAPEntity;
        return this.registerStateVoice == registerState_Status.registerStateVoice && this.networkType == registerState_Status.networkType && this.registerStateData == registerState_Status.registerStateData && this.packetDataNetworkType == registerState_Status.packetDataNetworkType;
    }

    private void customInitialization() {
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("RegisterState_Status");
        stringBuffer.append("\n - registerStateVoice:").append(this.registerStateVoice);
        stringBuffer.append("\n - networkType:").append(this.networkType);
        stringBuffer.append("\n - registerStateData:").append(this.registerStateData);
        stringBuffer.append("\n - packetDataNetworkType:").append(this.packetDataNetworkType);
        return stringBuffer.toString();
    }

    public int bitSize() {
        return 0;
    }

    public void serialize(BitStream bitStream) {
        bitStream.pushByte((byte)this.registerStateVoice);
        bitStream.pushByte((byte)this.networkType);
        bitStream.pushByte((byte)this.registerStateData);
        bitStream.pushByte((byte)this.packetDataNetworkType);
    }

    public void deserialize(BitStream bitStream) {
        this.registerStateVoice = bitStream.popFrontByte();
        this.networkType = bitStream.popFrontByte();
        this.registerStateData = bitStream.popFrontByte();
        this.packetDataNetworkType = bitStream.popFrontByte();
    }

    public static int functionId() {
        return 21;
    }

    public int getFunctionId() {
        return RegisterState_Status.functionId();
    }
}

