/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.generated.navsd.serializer;

import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.requests.SetGetProperty;
import de.vw.mib.bap.stream.BitStream;

public final class ActiveRgType_SetGet
implements SetGetProperty {
    public int rgtype;
    private static final int RG_TYPE_BITSIZE = 8;
    public static final int RG_TYPE_RGI_FROM_BAP_FUNCTION_MANEUVER_DESCRIPTIOR = 0;
    public static final int RG_TYPE_MOST_KDK = 1;
    public static final int RG_TYPE_COMPASS_FROM_BAP_FUNCTION_COMPASS_INFO = 2;
    public static final int RG_TYPE_MOST_MAP = 3;
    public static final int RG_TYPE_LVDS_MAP_VIDEO_STREAM_RECEIVED_VIA_LVDS_DF4_1 = 4;
    public static final int RG_TYPE_LVDS_KDK_VIDEO_STREAM_RECEIVED_VIA_LVDS_DF4_3 = 5;
    public static final int RG_TYPE_APPLY_ASG_DEFAULT_ROUTE_GUIDANCE_PRESENTATION = 255;

    public ActiveRgType_SetGet() {
        this.internalReset();
        this.customInitialization();
    }

    public ActiveRgType_SetGet(BitStream bitStream) {
        this();
        this.deserialize(bitStream);
    }

    private void internalReset() {
        this.rgtype = 0;
    }

    public void reset() {
        this.internalReset();
    }

    public boolean equalTo(BAPEntity bAPEntity) {
        ActiveRgType_SetGet activeRgType_SetGet = (ActiveRgType_SetGet)bAPEntity;
        return this.rgtype == activeRgType_SetGet.rgtype;
    }

    private void customInitialization() {
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("ActiveRgType_SetGet:");
        stringBuffer.append("\n - RGType: ");
        switch (this.rgtype) {
            case 0: {
                stringBuffer.append("0x00 (RGI (from BAP function ManeuverDescriptior))");
                break;
            }
            case 1: {
                stringBuffer.append("0x01 (MOST - KDK (data stream for JZ/EV received via MOST FBLOCK))");
                break;
            }
            case 2: {
                stringBuffer.append("0x02 (compass (from BAP function CompassInfo))");
                break;
            }
            case 3: {
                stringBuffer.append("0x03 (MOST - Map (data stream received via MOST FBLOCK) (DF4.1))");
                break;
            }
            case 4: {
                stringBuffer.append("0x04 (LVDS - Map (video stream received via LVDS) (DF4.1))");
                break;
            }
            case 5: {
                stringBuffer.append("0x05 (LVDS - KDK (video stream received via LVDS) (DF4.3))");
                break;
            }
            case 255: {
                stringBuffer.append("0xFF (apply ASG default route guidance presentation)");
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
        bitStream.pushByte((byte)this.rgtype);
    }

    public void deserialize(BitStream bitStream) {
        this.rgtype = bitStream.popFrontByte();
    }

    public static int functionId() {
        return 39;
    }

    public int getFunctionId() {
        return ActiveRgType_SetGet.functionId();
    }
}

