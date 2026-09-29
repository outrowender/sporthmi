/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.generated.navsd.serializer;

import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.stream.BitStream;

public final class DistanceToNextManeuver_Status$BargraphInfo
implements BAPEntity {
    public int bargraphOnOff;
    private static final int BARGRAPH_ON_OFF_BITSIZE;
    public static final int BARGRAPH_ON_OFF_BARGRAPH_SHALL_NOT_BE_DISPLAYED;
    public static final int BARGRAPH_ON_OFF_DISPLAY_BARGRAPH;
    public static final int BARGRAPH_ON_OFF_NOT_SUPPORTED;
    public int bargraph;
    private static final int BARGRAPH_BITSIZE;

    public DistanceToNextManeuver_Status$BargraphInfo() {
        this.internalReset();
        this.customInitialization();
    }

    public DistanceToNextManeuver_Status$BargraphInfo(BitStream bitStream) {
        this();
        this.deserialize(bitStream);
    }

    private void internalReset() {
        this.bargraphOnOff = 0;
        this.bargraph = 0;
    }

    @Override
    public void reset() {
        this.internalReset();
    }

    @Override
    public boolean equalTo(BAPEntity bAPEntity) {
        DistanceToNextManeuver_Status$BargraphInfo distanceToNextManeuver_Status$BargraphInfo = (DistanceToNextManeuver_Status$BargraphInfo)bAPEntity;
        return this.bargraphOnOff == distanceToNextManeuver_Status$BargraphInfo.bargraphOnOff && this.bargraph == distanceToNextManeuver_Status$BargraphInfo.bargraph;
    }

    private void customInitialization() {
    }

    @Override
    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("BargraphInfo:");
        stringBuffer.append("\n - BargraphOnOff: ");
        switch (this.bargraphOnOff) {
            case 0: {
                stringBuffer.append("0x00 (bargraph shall not be displayed)");
                break;
            }
            case 1: {
                stringBuffer.append("0x01 (display bargraph)");
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
        stringBuffer.append("\n - Bargraph - ");
        stringBuffer.append(this.bargraph);
        return stringBuffer.toString();
    }

    @Override
    public int bitSize() {
        int n = 0;
        n += 8;
        return n += 8;
    }

    @Override
    public void serialize(BitStream bitStream) {
        bitStream.pushByte((byte)this.bargraphOnOff);
        bitStream.pushByte((byte)this.bargraph);
    }

    @Override
    public void deserialize(BitStream bitStream) {
        this.bargraphOnOff = bitStream.popFrontByte();
        this.bargraph = bitStream.popFrontByte();
    }
}

