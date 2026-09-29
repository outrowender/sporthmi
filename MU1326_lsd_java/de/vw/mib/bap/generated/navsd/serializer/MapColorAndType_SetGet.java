/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.generated.navsd.serializer;

import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.requests.SetGetProperty;
import de.vw.mib.bap.stream.BitStream;

public final class MapColorAndType_SetGet
implements SetGetProperty {
    public int colour;
    private static final int COLOUR_BITSIZE;
    public static final int COLOUR_DAY;
    public static final int COLOUR_NIGHT;
    public static final int COLOUR_AUTO;
    public int activeMapType;
    private static final int ACTIVE_MAP_TYPE_BITSIZE;
    public static final int ACTIVE_MAP_TYPE_DESTINATION;
    public static final int ACTIVE_MAP_TYPE_POSITION_2D;
    public static final int ACTIVE_MAP_TYPE_POSITION_3D;
    public static final int ACTIVE_MAP_TYPE_OVERVIEW;
    public static final int ACTIVE_MAP_TYPE_RANGE_MAP;
    public int mainMapSetup;
    private static final int MAIN_MAP_SETUP_BITSIZE;
    public static final int MAIN_MAP_SETUP_INIT_NO_MAP_IN_ASG;
    public static final int MAIN_MAP_SETUP_MAIN_MAP_IN_ASG;
    public static final int MAIN_MAP_SETUP_MAIN_MAP_IN_FSG;
    public static final int MAIN_MAP_SETUP_NOT_SUPPORTED;
    public int reserve;
    private static final int RESERVE_BITSIZE;

    public MapColorAndType_SetGet() {
        this.internalReset();
        this.customInitialization();
    }

    public MapColorAndType_SetGet(BitStream bitStream) {
        this();
        this.deserialize(bitStream);
    }

    private void internalReset() {
        this.colour = 0;
        this.activeMapType = 0;
        this.mainMapSetup = 0;
        this.reserve = 0;
    }

    @Override
    public void reset() {
        this.internalReset();
    }

    @Override
    public boolean equalTo(BAPEntity bAPEntity) {
        MapColorAndType_SetGet mapColorAndType_SetGet = (MapColorAndType_SetGet)bAPEntity;
        return this.colour == mapColorAndType_SetGet.colour && this.activeMapType == mapColorAndType_SetGet.activeMapType && this.mainMapSetup == mapColorAndType_SetGet.mainMapSetup && this.reserve == mapColorAndType_SetGet.reserve;
    }

    private void customInitialization() {
    }

    @Override
    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("MapColorAndType_SetGet:");
        stringBuffer.append("\n - Colour: ");
        switch (this.colour) {
            case 0: {
                stringBuffer.append("0x00 (day)");
                break;
            }
            case 1: {
                stringBuffer.append("0x01 (night)");
                break;
            }
            case 2: {
                stringBuffer.append("0x02 (auto)");
                break;
            }
            default: {
                stringBuffer.append("UNKNOWN ENUM");
            }
        }
        stringBuffer.append("\n - ActiveMapType: ");
        switch (this.activeMapType) {
            case 0: {
                stringBuffer.append("0x00 (destination)");
                break;
            }
            case 1: {
                stringBuffer.append("0x01 (position 2D)");
                break;
            }
            case 2: {
                stringBuffer.append("0x02 (position 3D)");
                break;
            }
            case 3: {
                stringBuffer.append("0x03 (overview)");
                break;
            }
            case 4: {
                stringBuffer.append("0x04 (range map)");
                break;
            }
            default: {
                stringBuffer.append("UNKNOWN ENUM");
            }
        }
        stringBuffer.append("\n - MainMapSetup: ");
        switch (this.mainMapSetup) {
            case 0: {
                stringBuffer.append("0x00 (init (no map in ASG))");
                break;
            }
            case 1: {
                stringBuffer.append("0x01 (main map in ASG (primary map in ASG / instrument cluster))");
                break;
            }
            case 2: {
                stringBuffer.append("0x02 (main map in FSG (secondary map in ASG / instrument cluster))");
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
        stringBuffer.append("\n - Reserve - ");
        stringBuffer.append(this.reserve);
        return stringBuffer.toString();
    }

    @Override
    public int bitSize() {
        int n = 0;
        n += 8;
        n += 8;
        n += 8;
        return n += 8;
    }

    @Override
    public void serialize(BitStream bitStream) {
        bitStream.pushByte((byte)this.colour);
        bitStream.pushByte((byte)this.activeMapType);
        bitStream.pushByte((byte)this.mainMapSetup);
        bitStream.pushByte((byte)this.reserve);
    }

    @Override
    public void deserialize(BitStream bitStream) {
        this.colour = bitStream.popFrontByte();
        this.activeMapType = bitStream.popFrontByte();
        this.mainMapSetup = bitStream.popFrontByte();
        this.reserve = bitStream.popFrontByte();
    }

    public static int functionId() {
        return 43;
    }

    @Override
    public int getFunctionId() {
        return MapColorAndType_SetGet.functionId();
    }
}

