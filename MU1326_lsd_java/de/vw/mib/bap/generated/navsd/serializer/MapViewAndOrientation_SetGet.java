/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.generated.navsd.serializer;

import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.generated.navsd.serializer.MapViewAndOrientation_MapVisibility;
import de.vw.mib.bap.requests.SetGetProperty;
import de.vw.mib.bap.stream.BitStream;

public final class MapViewAndOrientation_SetGet
implements SetGetProperty {
    public int mapView;
    private static final int MAP_VIEW_BITSIZE = 8;
    public static final int MAP_VIEW_STANDARD = 0;
    public static final int MAP_VIEW_GOOGLE_EARTH = 1;
    public static final int MAP_VIEW_TRAFFIC = 2;
    public int supplementaryMapView;
    private static final int SUPPLEMENTARY_MAP_VIEW_BITSIZE = 8;
    public static final int SUPPLEMENTARY_MAP_VIEW_NO_SUPPLEMENTARY_MAP_VIEW = 0;
    public static final int SUPPLEMENTARY_MAP_VIEW_INTERSECTION_ZOOM = 1;
    public static final int SUPPLEMENTARY_MAP_VIEW_COMPASS = 2;
    public static final int SUPPLEMENTARY_MAP_VIEW_31_BOX = 3;
    public int reserve1;
    private static final int RESERVE1_BITSIZE = 8;
    public int reserve2;
    private static final int RESERVE2_BITSIZE = 8;
    public final MapViewAndOrientation_MapVisibility mapVisibility = new MapViewAndOrientation_MapVisibility();
    public int mapOrientation;
    private static final int MAP_ORIENTATION_BITSIZE = 8;
    public static final int MAP_ORIENTATION_AUTOMATIC = 0;
    public static final int MAP_ORIENTATION_NORTH = 1;
    public static final int MAP_ORIENTATION_DIRECTION_OF_TRAVEL = 2;
    public int reserve3;
    private static final int RESERVE3_BITSIZE = 8;

    public MapViewAndOrientation_SetGet() {
        this.internalReset();
        this.customInitialization();
    }

    public MapViewAndOrientation_SetGet(BitStream bitStream) {
        this();
        this.deserialize(bitStream);
    }

    private void internalReset() {
        this.mapView = 0;
        this.supplementaryMapView = 0;
        this.reserve1 = 0;
        this.reserve2 = 0;
        this.mapOrientation = 0;
        this.reserve3 = 0;
    }

    public void reset() {
        this.internalReset();
        this.mapVisibility.reset();
    }

    public boolean equalTo(BAPEntity bAPEntity) {
        MapViewAndOrientation_SetGet mapViewAndOrientation_SetGet = (MapViewAndOrientation_SetGet)bAPEntity;
        return this.mapView == mapViewAndOrientation_SetGet.mapView && this.supplementaryMapView == mapViewAndOrientation_SetGet.supplementaryMapView && this.reserve1 == mapViewAndOrientation_SetGet.reserve1 && this.reserve2 == mapViewAndOrientation_SetGet.reserve2 && this.mapVisibility.equalTo(mapViewAndOrientation_SetGet.mapVisibility) && this.mapOrientation == mapViewAndOrientation_SetGet.mapOrientation && this.reserve3 == mapViewAndOrientation_SetGet.reserve3;
    }

    private void customInitialization() {
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("MapViewAndOrientation_SetGet:");
        stringBuffer.append("\n - MapView: ");
        switch (this.mapView) {
            case 0: {
                stringBuffer.append("0x00 (standard)");
                break;
            }
            case 1: {
                stringBuffer.append("0x01 (google earth)");
                break;
            }
            case 2: {
                stringBuffer.append("0x02 (traffic)");
                break;
            }
            default: {
                stringBuffer.append("UNKNOWN ENUM");
            }
        }
        stringBuffer.append("\n - SupplementaryMapView: ");
        switch (this.supplementaryMapView) {
            case 0: {
                stringBuffer.append("0x00 (no supplementary map view)");
                break;
            }
            case 1: {
                stringBuffer.append("0x01 (Intersection zoom)");
                break;
            }
            case 2: {
                stringBuffer.append("0x02 (compass)");
                break;
            }
            case 3: {
                stringBuffer.append("0x03 (3+1 Box)");
                break;
            }
            default: {
                stringBuffer.append("UNKNOWN ENUM");
            }
        }
        stringBuffer.append("\n - Reserve1 - ");
        stringBuffer.append(this.reserve1);
        stringBuffer.append("\n - Reserve2 - ");
        stringBuffer.append(this.reserve2);
        stringBuffer.append("\n - MapVisibility - ");
        stringBuffer.append(this.mapVisibility.toString());
        stringBuffer.append("\n - MapOrientation: ");
        switch (this.mapOrientation) {
            case 0: {
                stringBuffer.append("0x00 (automatic)");
                break;
            }
            case 1: {
                stringBuffer.append("0x01 (north)");
                break;
            }
            case 2: {
                stringBuffer.append("0x02 (direction of travel)");
                break;
            }
            default: {
                stringBuffer.append("UNKNOWN ENUM");
            }
        }
        stringBuffer.append("\n - Reserve3 - ");
        stringBuffer.append(this.reserve3);
        return stringBuffer.toString();
    }

    public int bitSize() {
        int n = 0;
        n += 8;
        n += 8;
        n += 8;
        n += 8;
        n += this.mapVisibility.bitSize();
        n += 8;
        return n += 8;
    }

    public void serialize(BitStream bitStream) {
        bitStream.pushByte((byte)this.mapView);
        bitStream.pushByte((byte)this.supplementaryMapView);
        bitStream.pushByte((byte)this.reserve1);
        bitStream.pushByte((byte)this.reserve2);
        this.mapVisibility.serialize(bitStream);
        bitStream.pushByte((byte)this.mapOrientation);
        bitStream.pushByte((byte)this.reserve3);
    }

    public void deserialize(BitStream bitStream) {
        this.mapView = bitStream.popFrontByte();
        this.supplementaryMapView = bitStream.popFrontByte();
        this.reserve1 = bitStream.popFrontByte();
        this.reserve2 = bitStream.popFrontByte();
        this.mapVisibility.deserialize(bitStream);
        this.mapOrientation = bitStream.popFrontByte();
        this.reserve3 = bitStream.popFrontByte();
    }

    public static int functionId() {
        return 44;
    }

    public int getFunctionId() {
        return MapViewAndOrientation_SetGet.functionId();
    }
}

