/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.generated.navsd.serializer;

import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.requests.StatusProperty;
import de.vw.mib.bap.stream.BitStream;

public final class ActiveRgType_Status
implements StatusProperty {
    public int rgtype;
    private static final int RG_TYPE_BITSIZE;
    public static final int RG_TYPE_RGI_FROM_BAP_FUNCTION_MANEUVER_DESCRIPTIOR;
    public static final int RG_TYPE_MOST_KDK;
    public static final int RG_TYPE_COMPASS_FROM_BAP_FUNCTION_COMPASS_INFO;
    public static final int RG_TYPE_MOST_MAP;
    public static final int RG_TYPE_LVDS_MAP_VIDEO_STREAM_RECEIVED_VIA_LVDS_DF4_1;
    public static final int RG_TYPE_LVDS_KDK_VIDEO_STREAM_RECEIVED_VIA_LVDS_DF4_3;
    public static final int RG_TYPE_APPLY_ASG_DEFAULT_ROUTE_GUIDANCE_PRESENTATION;

    public ActiveRgType_Status() {
        this.internalReset();
        this.customInitialization();
    }

    public ActiveRgType_Status(BitStream bitStream) {
        this();
        this.deserialize(bitStream);
    }

    private void internalReset() {
        this.rgtype = 0;
    }

    @Override
    public void reset() {
        this.internalReset();
    }

    @Override
    public boolean equalTo(BAPEntity bAPEntity) {
        ActiveRgType_Status activeRgType_Status = (ActiveRgType_Status)bAPEntity;
        return this.rgtype == activeRgType_Status.rgtype;
    }

    private void customInitialization() {
    }

    @Override
    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("ActiveRgType_Status:");
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

    @Override
    public int bitSize() {
        int n = 0;
        return n += 8;
    }

    @Override
    public void serialize(BitStream bitStream) {
        bitStream.pushByte((byte)this.rgtype);
    }

    @Override
    public void deserialize(BitStream bitStream) {
        this.rgtype = bitStream.popFrontByte();
    }

    public static int functionId() {
        return 39;
    }

    @Override
    public int getFunctionId() {
        return ActiveRgType_Status.functionId();
    }
}

