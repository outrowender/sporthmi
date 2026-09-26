/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.generated.navsd.serializer;

import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.requests.StatusProperty;
import de.vw.mib.bap.stream.BitStream;

public final class MagnetFieldZone_Status
implements StatusProperty {
    public int zone;
    private static final int ZONE_BITSIZE;
    public static final int ZONE_ZONE_1;
    public static final int ZONE_ZONE_2;
    public static final int ZONE_ZONE_3;
    public static final int ZONE_ZONE_4;
    public static final int ZONE_ZONE_5;
    public static final int ZONE_ZONE_6;
    public static final int ZONE_ZONE_7;
    public static final int ZONE_ZONE_8;
    public static final int ZONE_ZONE_9;
    public static final int ZONE_ZONE_10;
    public static final int ZONE_ZONE_11;
    public static final int ZONE_ZONE_12;
    public static final int ZONE_ZONE_13;
    public static final int ZONE_ZONE_14;
    public static final int ZONE_ZONE_15;

    public MagnetFieldZone_Status() {
        this.internalReset();
        this.customInitialization();
    }

    public MagnetFieldZone_Status(BitStream bitStream) {
        this();
        this.deserialize(bitStream);
    }

    private void internalReset() {
        this.zone = 0;
    }

    @Override
    public void reset() {
        this.internalReset();
    }

    @Override
    public boolean equalTo(BAPEntity bAPEntity) {
        MagnetFieldZone_Status magnetFieldZone_Status = (MagnetFieldZone_Status)bAPEntity;
        return this.zone == magnetFieldZone_Status.zone;
    }

    private void customInitialization() {
    }

    @Override
    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("MagnetFieldZone_Status:");
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

    @Override
    public int bitSize() {
        int n = 0;
        return n += 8;
    }

    @Override
    public void serialize(BitStream bitStream) {
        bitStream.pushByte((byte)this.zone);
    }

    @Override
    public void deserialize(BitStream bitStream) {
        this.zone = bitStream.popFrontByte();
    }

    public static int functionId() {
        return 26;
    }

    @Override
    public int getFunctionId() {
        return MagnetFieldZone_Status.functionId();
    }
}

