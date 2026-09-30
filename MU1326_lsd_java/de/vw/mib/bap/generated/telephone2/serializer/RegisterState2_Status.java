/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.generated.telephone2.serializer;

import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.requests.StatusProperty;
import de.vw.mib.bap.stream.BitStream;

public final class RegisterState2_Status
implements StatusProperty {
    public int registerState;
    private static final int REGISTER_STATE_BITSIZE = 8;
    public static final int REGISTER_STATE_NOT_REGISTERED_AND_NOT_SEARCHING = 0;
    public static final int REGISTER_STATE_REGISTERED = 1;
    public static final int REGISTER_STATE_NOT_REGISTERED_AND_SEARCHING = 2;
    public static final int REGISTER_STATE_REGISTRATION_DENIED = 3;
    public static final int REGISTER_STATE_REGISTERED_AND_ROAMING = 4;
    public static final int REGISTER_STATE_REGISTERED_AND_ROAMING_ALTERNATIVE = 5;
    public static final int REGISTER_STATE_FUNCTION_NOT_SUPPORTED_BY_ME = 255;
    public int networkType;
    private static final int NETWORK_TYPE_BITSIZE = 8;
    public static final int NETWORK_TYPE_UNKNOWN = 0;
    public static final int NETWORK_TYPE_GSM = 1;
    public static final int NETWORK_TYPE_UMTS = 2;
    public static final int NETWORK_TYPE_CDMA = 3;
    public static final int NETWORK_TYPE_LTE = 4;
    public static final int NETWORK_TYPE_HSPA_DF4_1 = 5;
    public static final int NETWORK_TYPE_LTE_ADVANCED_DF4_1 = 6;
    public int packetDataNetworkType;
    private static final int PACKET_DATA_NETWORK_TYPE_BITSIZE = 8;
    public static final int PACKET_DATA_NETWORK_TYPE_NO_DATA_SERVICE = 0;
    public static final int PACKET_DATA_NETWORK_TYPE_GSM_GPRS = 1;
    public static final int PACKET_DATA_NETWORK_TYPE_GSM_EDGE = 2;
    public static final int PACKET_DATA_NETWORK_TYPE_HSDPA_HIGH_SPEED_DOWNLINK_PACKET_ACCESS = 3;
    public static final int PACKET_DATA_NETWORK_TYPE_HSUPA_HIGH_SPEED_UPLINK_PACKET_ACCESS = 4;
    public static final int PACKET_DATA_NETWORK_TYPE_CDMA = 5;
    public static final int PACKET_DATA_NETWORK_TYPE_LTE = 6;
    public static final int PACKET_DATA_NETWORK_TYPE_HSPA_DF4_1 = 7;
    public static final int PACKET_DATA_NETWORK_TYPE_LTE_ADVANCED_DF4_1 = 8;
    public static final int PACKET_DATA_NETWORK_TYPE_UNKNOWN_PACKET_DATA_NETWORK = 255;

    public RegisterState2_Status() {
        this.internalReset();
        this.customInitialization();
    }

    public RegisterState2_Status(BitStream bitStream) {
        this();
        this.deserialize(bitStream);
    }

    private void internalReset() {
        this.registerState = 0;
        this.networkType = 0;
        this.packetDataNetworkType = 0;
    }

    public void reset() {
        this.internalReset();
    }

    public boolean equalTo(BAPEntity bAPEntity) {
        RegisterState2_Status registerState2_Status = (RegisterState2_Status)bAPEntity;
        return this.registerState == registerState2_Status.registerState && this.networkType == registerState2_Status.networkType && this.packetDataNetworkType == registerState2_Status.packetDataNetworkType;
    }

    private void customInitialization() {
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("RegisterState2_Status:");
        stringBuffer.append("\n - RegisterState: ");
        switch (this.registerState) {
            case 0: {
                stringBuffer.append("0x00 (not registered and not\n\t\t\t\t\t\t\t searching)");
                break;
            }
            case 1: {
                stringBuffer.append("0x01 (registered)");
                break;
            }
            case 2: {
                stringBuffer.append("0x02 (not registered and \t\t\t\t\t\t\t searching)");
                break;
            }
            case 3: {
                stringBuffer.append("0x03 (registration denied)");
                break;
            }
            case 4: {
                stringBuffer.append("0x04 (registered and roaming)");
                break;
            }
            case 5: {
                stringBuffer.append("0x05 (registered and roaming \t\t\t\t\t\t\t alternative)");
                break;
            }
            case 255: {
                stringBuffer.append("0xFF (function not supported by ME)");
                break;
            }
            default: {
                stringBuffer.append("UNKNOWN ENUM");
            }
        }
        stringBuffer.append("\n - NetworkType: ");
        switch (this.networkType) {
            case 0: {
                stringBuffer.append("0x00 (unknown)");
                break;
            }
            case 1: {
                stringBuffer.append("0x01 (GSM)");
                break;
            }
            case 2: {
                stringBuffer.append("0x02 (UMTS)");
                break;
            }
            case 3: {
                stringBuffer.append("0x03 (CDMA)");
                break;
            }
            case 4: {
                stringBuffer.append("0x04 (LTE)");
                break;
            }
            case 5: {
                stringBuffer.append("0x05 (HSPA+ (DF4.1))");
                break;
            }
            case 6: {
                stringBuffer.append("0x06 (LTE_advanced (DF4.1))");
                break;
            }
            default: {
                stringBuffer.append("UNKNOWN ENUM");
            }
        }
        stringBuffer.append("\n - PacketDataNetworkType: ");
        switch (this.packetDataNetworkType) {
            case 0: {
                stringBuffer.append("0x00 (no data service)");
                break;
            }
            case 1: {
                stringBuffer.append("0x01 (GSM-GPRS)");
                break;
            }
            case 2: {
                stringBuffer.append("0x02 (GSM-EDGE)");
                break;
            }
            case 3: {
                stringBuffer.append("0x03 (HSDPA (High Speed Downlink packet Access))");
                break;
            }
            case 4: {
                stringBuffer.append("0x04 (HSUPA (High Speed Uplink packet Access))");
                break;
            }
            case 5: {
                stringBuffer.append("0x05 (CDMA)");
                break;
            }
            case 6: {
                stringBuffer.append("0x06 (LTE)");
                break;
            }
            case 7: {
                stringBuffer.append("0x07 (HSPA+ (DF4.1))");
                break;
            }
            case 8: {
                stringBuffer.append("0x08 (LTE_advanced (DF4.1))");
                break;
            }
            case 255: {
                stringBuffer.append("0xFF (unknown packet data network)");
                break;
            }
            default: {
                stringBuffer.append("UNKNOWN ENUM");
            }
        }
        return stringBuffer.toString();
    }

    public int bitSize() {
        int n = 0;
        n += 8;
        n += 8;
        return n += 8;
    }

    public void serialize(BitStream bitStream) {
        bitStream.pushByte((byte)this.registerState);
        bitStream.pushByte((byte)this.networkType);
        bitStream.pushByte((byte)this.packetDataNetworkType);
    }

    public void deserialize(BitStream bitStream) {
        this.registerState = bitStream.popFrontByte();
        this.networkType = bitStream.popFrontByte();
        this.packetDataNetworkType = bitStream.popFrontByte();
    }

    public static int functionId() {
        return 17;
    }

    public int getFunctionId() {
        return RegisterState2_Status.functionId();
    }
}

