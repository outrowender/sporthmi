/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.generated.navsd.serializer;

import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.requests.StatusProperty;
import de.vw.mib.bap.stream.BitStream;

public final class InfoStates_Status
implements StatusProperty {
    public int states;
    private static final int STATES_BITSIZE = 8;
    public static final int STATES_NO_ERROR_NO_INFORMATION = 0;
    public static final int STATES_NO_NAVIGATION_DATA_MEDIUM_INSERTED = 1;
    public static final int STATES_NAVIGATION_DATABASE_CORRUPTED = 2;
    public static final int STATES_NO_GPS_SIGNAL_AVAILABLE = 3;
    public static final int STATES_NAVIGATION_DATABASE_UPDATE_ONGOING_IN_PROGRESS_DF4_1 = 4;
    public static final int STATES_INITIALIZING_MOST_MAP_DF4_2 = 5;
    public static final int STATES_NAVIGATION_IN_MOBILE_DEVICE_ACTIVE_DF_4_3 = 6;
    public static final int STATES_UNKNOWN = 255;

    public InfoStates_Status() {
        this.internalReset();
        this.customInitialization();
    }

    public InfoStates_Status(BitStream bitStream) {
        this();
        this.deserialize(bitStream);
    }

    private void internalReset() {
        this.states = 0;
    }

    public void reset() {
        this.internalReset();
    }

    public boolean equalTo(BAPEntity bAPEntity) {
        InfoStates_Status infoStates_Status = (InfoStates_Status)bAPEntity;
        return this.states == infoStates_Status.states;
    }

    private void customInitialization() {
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("InfoStates_Status:");
        stringBuffer.append("\n - States: ");
        switch (this.states) {
            case 0: {
                stringBuffer.append("0x00 (no error/no information)");
                break;
            }
            case 1: {
                stringBuffer.append("0x01 (no navigation data medium inserted)");
                break;
            }
            case 2: {
                stringBuffer.append("0x02 (navigation database corrupted)");
                break;
            }
            case 3: {
                stringBuffer.append("0x03 (no GPS signal available)");
                break;
            }
            case 4: {
                stringBuffer.append("0x04 (navigation database update ongoing/in progress (DF4.1))");
                break;
            }
            case 5: {
                stringBuffer.append("0x05 (Initializing MOST Map (DF4.2))");
                break;
            }
            case 6: {
                stringBuffer.append("0x06 (Navigation in mobile device active (DF 4.3))");
                break;
            }
            case 255: {
                stringBuffer.append("0xFF (unknown )");
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
        return n += 8;
    }

    public void serialize(BitStream bitStream) {
        bitStream.pushByte((byte)this.states);
    }

    public void deserialize(BitStream bitStream) {
        this.states = bitStream.popFrontByte();
    }

    public static int functionId() {
        return 38;
    }

    public int getFunctionId() {
        return InfoStates_Status.functionId();
    }
}

