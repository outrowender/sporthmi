/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.generated.navsd.serializer;

import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.requests.StatusProperty;
import de.vw.mib.bap.stream.BitStream;

public final class CompassInfo_Status
implements StatusProperty {
    public int direction_Symbolic;
    private static final int DIRECTION_SYMBOLIC_BITSIZE;
    public static final int DIRECTION_SYMBOLIC_N;
    public static final int DIRECTION_SYMBOLIC_NNO;
    public static final int DIRECTION_SYMBOLIC_NO;
    public static final int DIRECTION_SYMBOLIC_ONO;
    public static final int DIRECTION_SYMBOLIC_O;
    public static final int DIRECTION_SYMBOLIC_OSO;
    public static final int DIRECTION_SYMBOLIC_SO;
    public static final int DIRECTION_SYMBOLIC_SSO;
    public static final int DIRECTION_SYMBOLIC_S;
    public static final int DIRECTION_SYMBOLIC_SSW;
    public static final int DIRECTION_SYMBOLIC_SW;
    public static final int DIRECTION_SYMBOLIC_WSW;
    public static final int DIRECTION_SYMBOLIC_W;
    public static final int DIRECTION_SYMBOLIC_WNW;
    public static final int DIRECTION_SYMBOLIC_NW;
    public static final int DIRECTION_SYMBOLIC_NNW;
    public static final int DIRECTION_SYMBOLIC_NOT_SUPPORTED;
    public int direction_Angle;
    private static final int DIRECTION_ANGLE_BITSIZE;

    public CompassInfo_Status() {
        this.internalReset();
        this.customInitialization();
    }

    public CompassInfo_Status(BitStream bitStream) {
        this();
        this.deserialize(bitStream);
    }

    private void internalReset() {
        this.direction_Symbolic = 0;
        this.direction_Angle = 0;
    }

    @Override
    public void reset() {
        this.internalReset();
    }

    @Override
    public boolean equalTo(BAPEntity bAPEntity) {
        CompassInfo_Status compassInfo_Status = (CompassInfo_Status)bAPEntity;
        return this.direction_Symbolic == compassInfo_Status.direction_Symbolic && this.direction_Angle == compassInfo_Status.direction_Angle;
    }

    private void customInitialization() {
    }

    @Override
    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("CompassInfo_Status:");
        stringBuffer.append("\n - Direction_Symbolic: ");
        switch (this.direction_Symbolic) {
            case 0: {
                stringBuffer.append("0x00 (N)");
                break;
            }
            case 1: {
                stringBuffer.append("0x01 (NNO)");
                break;
            }
            case 2: {
                stringBuffer.append("0x02 (NO)");
                break;
            }
            case 3: {
                stringBuffer.append("0x03 (ONO)");
                break;
            }
            case 4: {
                stringBuffer.append("0x04 (O)");
                break;
            }
            case 5: {
                stringBuffer.append("0x05 (OSO)");
                break;
            }
            case 6: {
                stringBuffer.append("0x06 (SO)");
                break;
            }
            case 7: {
                stringBuffer.append("0x07 (SSO)");
                break;
            }
            case 8: {
                stringBuffer.append("0x08 (S)");
                break;
            }
            case 9: {
                stringBuffer.append("0x09 (SSW)");
                break;
            }
            case 10: {
                stringBuffer.append("0x0A (SW)");
                break;
            }
            case 11: {
                stringBuffer.append("0x0B (WSW)");
                break;
            }
            case 12: {
                stringBuffer.append("0x0C (W)");
                break;
            }
            case 13: {
                stringBuffer.append("0x0D (WNW)");
                break;
            }
            case 14: {
                stringBuffer.append("0x0E (NW)");
                break;
            }
            case 15: {
                stringBuffer.append("0x0F (NNW)");
                break;
            }
            case 255: {
                stringBuffer.append("0xFF (not supported)");
                break;
            }
            default: {
                stringBuffer.append("UNKNOWN ENUM");
            }
        }
        stringBuffer.append("\n - Direction_Angle - ");
        stringBuffer.append(this.direction_Angle);
        return stringBuffer.toString();
    }

    @Override
    public int bitSize() {
        int n = 0;
        n += 8;
        return n += 16;
    }

    @Override
    public void serialize(BitStream bitStream) {
        bitStream.pushByte((byte)this.direction_Symbolic);
        bitStream.pushShort((short)this.direction_Angle);
    }

    @Override
    public void deserialize(BitStream bitStream) {
        this.direction_Symbolic = bitStream.popFrontByte();
        this.direction_Angle = bitStream.popFrontShort();
    }

    public static int functionId() {
        return 16;
    }

    @Override
    public int getFunctionId() {
        return CompassInfo_Status.functionId();
    }
}

