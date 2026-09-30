/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.generated.navsd.serializer;

import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.requests.SetGetProperty;
import de.vw.mib.bap.stream.BitStream;

public final class MagnetFieldZone_SetGet
implements SetGetProperty {
    public int zone;
    private static final int ZONE_BITSIZE = 8;
    public static final int ZONE_ZONE_1 = 1;
    public static final int ZONE_ZONE_2 = 2;
    public static final int ZONE_ZONE_3 = 3;
    public static final int ZONE_ZONE_4 = 4;
    public static final int ZONE_ZONE_5 = 5;
    public static final int ZONE_ZONE_6 = 6;
    public static final int ZONE_ZONE_7 = 7;
    public static final int ZONE_ZONE_8 = 8;
    public static final int ZONE_ZONE_9 = 9;
    public static final int ZONE_ZONE_10 = 10;
    public static final int ZONE_ZONE_11 = 11;
    public static final int ZONE_ZONE_12 = 12;
    public static final int ZONE_ZONE_13 = 13;
    public static final int ZONE_ZONE_14 = 14;
    public static final int ZONE_ZONE_15 = 15;

    public MagnetFieldZone_SetGet() {
        this.internalReset();
        this.customInitialization();
    }

    public MagnetFieldZone_SetGet(BitStream bitStream) {
        this();
        this.deserialize(bitStream);
    }

    private void internalReset() {
        this.zone = 0;
    }

    public void reset() {
        this.internalReset();
    }

    public boolean equalTo(BAPEntity bAPEntity) {
        MagnetFieldZone_SetGet magnetFieldZone_SetGet = (MagnetFieldZone_SetGet)bAPEntity;
        return this.zone == magnetFieldZone_SetGet.zone;
    }

    private void customInitialization() {
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("MagnetFieldZone_SetGet:");
        stringBuffer.append("\n - Zone: ");
        switch (this.zone) {
            case 1: {
                stringBuffer.append("0x01 (zone 1)");
                break;
            }
            case 2: {
                stringBuffer.append("0x02 (zone 2)");
                break;
            }
            case 3: {
                stringBuffer.append("0x03 (zone 3)");
                break;
            }
            case 4: {
                stringBuffer.append("0x04 (zone 4)");
                break;
            }
            case 5: {
                stringBuffer.append("0x05 (zone 5)");
                break;
            }
            case 6: {
                stringBuffer.append("0x06 (zone 6)");
                break;
            }
            case 7: {
                stringBuffer.append("0x07 (zone 7)");
                break;
            }
            case 8: {
                stringBuffer.append("0x08 (zone 8)");
                break;
            }
            case 9: {
                stringBuffer.append("0x09 (zone 9)");
                break;
            }
            case 10: {
                stringBuffer.append("0x0A (zone 10)");
                break;
            }
            case 11: {
                stringBuffer.append("0x0B (zone 11)");
                break;
            }
            case 12: {
                stringBuffer.append("0x0C (zone 12)");
                break;
            }
            case 13: {
                stringBuffer.append("0x0D (zone 13)");
                break;
            }
            case 14: {
                stringBuffer.append("0x0E (zone 14)");
                break;
            }
            case 15: {
                stringBuffer.append("0x0F (zone 15)");
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
        bitStream.pushByte((byte)this.zone);
    }

    public void deserialize(BitStream bitStream) {
        this.zone = bitStream.popFrontByte();
    }

    public static int functionId() {
        return 26;
    }

    public int getFunctionId() {
        return MagnetFieldZone_SetGet.functionId();
    }
}

