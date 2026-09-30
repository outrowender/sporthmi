/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.generated.navsd.serializer;

import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.generated.navsd.serializer.MapViewAndOrientation_MapVisibility;
import de.vw.mib.bap.requests.StatusProperty;
import de.vw.mib.bap.stream.BitStream;

public final class MapViewAndOrientation_Status
implements StatusProperty {
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
    public final SupportedMapViews supportedMapViews = new SupportedMapViews();
    public final SupportedSupplementaryMapViews supportedSupplementaryMapViews = new SupportedSupplementaryMapViews();
    public final MapViewAndOrientation_MapVisibility mapVisibility = new MapViewAndOrientation_MapVisibility();
    public int mapOrientation;
    private static final int MAP_ORIENTATION_BITSIZE = 8;
    public static final int MAP_ORIENTATION_AUTOMATIC = 0;
    public static final int MAP_ORIENTATION_NORTH = 1;
    public static final int MAP_ORIENTATION_DIRECTION_OF_TRAVEL = 2;
    public final Modification modification = new Modification();

    public MapViewAndOrientation_Status() {
        this.internalReset();
        this.customInitialization();
    }

    public MapViewAndOrientation_Status(BitStream bitStream) {
        this();
        this.deserialize(bitStream);
    }

    private void internalReset() {
        this.mapView = 0;
        this.supplementaryMapView = 0;
        this.mapOrientation = 0;
    }

    public void reset() {
        this.internalReset();
        this.supportedMapViews.reset();
        this.supportedSupplementaryMapViews.reset();
        this.mapVisibility.reset();
        this.modification.reset();
    }

    public boolean equalTo(BAPEntity bAPEntity) {
        MapViewAndOrientation_Status mapViewAndOrientation_Status = (MapViewAndOrientation_Status)bAPEntity;
        return this.mapView == mapViewAndOrientation_Status.mapView && this.supplementaryMapView == mapViewAndOrientation_Status.supplementaryMapView && this.supportedMapViews.equalTo(mapViewAndOrientation_Status.supportedMapViews) && this.supportedSupplementaryMapViews.equalTo(mapViewAndOrientation_Status.supportedSupplementaryMapViews) && this.mapVisibility.equalTo(mapViewAndOrientation_Status.mapVisibility) && this.mapOrientation == mapViewAndOrientation_Status.mapOrientation && this.modification.equalTo(mapViewAndOrientation_Status.modification);
    }

    private void customInitialization() {
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("MapViewAndOrientation_Status:");
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
        stringBuffer.append("\n - SupportedMapViews - ");
        stringBuffer.append(this.supportedMapViews.toString());
        stringBuffer.append("\n - SupportedSupplementaryMapViews - ");
        stringBuffer.append(this.supportedSupplementaryMapViews.toString());
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
        stringBuffer.append("\n - Modification - ");
        stringBuffer.append(this.modification.toString());
        return stringBuffer.toString();
    }

    public int bitSize() {
        int n = 0;
        n += 8;
        n += 8;
        n += this.supportedMapViews.bitSize();
        n += this.supportedSupplementaryMapViews.bitSize();
        n += this.mapVisibility.bitSize();
        n += 8;
        return n += this.modification.bitSize();
    }

    public void serialize(BitStream bitStream) {
        bitStream.pushByte((byte)this.mapView);
        bitStream.pushByte((byte)this.supplementaryMapView);
        this.supportedMapViews.serialize(bitStream);
        this.supportedSupplementaryMapViews.serialize(bitStream);
        this.mapVisibility.serialize(bitStream);
        bitStream.pushByte((byte)this.mapOrientation);
        this.modification.serialize(bitStream);
    }

    public void deserialize(BitStream bitStream) {
        this.mapView = bitStream.popFrontByte();
        this.supplementaryMapView = bitStream.popFrontByte();
        this.supportedMapViews.deserialize(bitStream);
        this.supportedSupplementaryMapViews.deserialize(bitStream);
        this.mapVisibility.deserialize(bitStream);
        this.mapOrientation = bitStream.popFrontByte();
        this.modification.deserialize(bitStream);
    }

    public static int functionId() {
        return 44;
    }

    public int getFunctionId() {
        return MapViewAndOrientation_Status.functionId();
    }

    public static final class Modification
    implements BAPEntity {
        private static final int RESERVED_BIT_1__7_BITSIZE = 7;
        public boolean googleMapCanNotBeModified;
        private static final int MODIFICATION_BITSIZE = 8;

        public Modification() {
            this.internalReset();
            this.customInitialization();
        }

        public Modification(BitStream bitStream) {
            this();
            this.deserialize(bitStream);
        }

        private void internalReset() {
            this.googleMapCanNotBeModified = false;
        }

        public void reset() {
            this.internalReset();
        }

        public boolean equalTo(BAPEntity bAPEntity) {
            Modification modification = (Modification)bAPEntity;
            return this.googleMapCanNotBeModified == modification.googleMapCanNotBeModified;
        }

        private void customInitialization() {
        }

        public String toString() {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("Modification:");
            stringBuffer.append("\n - Bit 0: ");
            if (this.googleMapCanNotBeModified) {
                stringBuffer.append("true  (google map can not be modified");
            } else {
                stringBuffer.append("false  (google map can be modified");
            }
            return stringBuffer.toString();
        }

        public int bitSize() {
            int n = 0;
            return n += 8;
        }

        public void serialize(BitStream bitStream) {
            bitStream.resetBits(7);
            bitStream.pushBoolean(this.googleMapCanNotBeModified);
        }

        public void deserialize(BitStream bitStream) {
            bitStream.discardBits(7);
            this.googleMapCanNotBeModified = bitStream.popFrontBoolean();
        }
    }

    public static final class SupportedMapViews
    implements BAPEntity {
        private static final int RESERVED_BIT_3__7_BITSIZE = 5;
        public boolean trafficMapIsSupported;
        public boolean googleEarthMapIsSupported;
        public boolean standardMapIsSupported;
        private static final int SUPPORTED_MAP_VIEWS_BITSIZE = 8;

        public SupportedMapViews() {
            this.internalReset();
            this.customInitialization();
        }

        public SupportedMapViews(BitStream bitStream) {
            this();
            this.deserialize(bitStream);
        }

        private void internalReset() {
            this.trafficMapIsSupported = false;
            this.googleEarthMapIsSupported = false;
            this.standardMapIsSupported = false;
        }

        public void reset() {
            this.internalReset();
        }

        public boolean equalTo(BAPEntity bAPEntity) {
            SupportedMapViews supportedMapViews = (SupportedMapViews)bAPEntity;
            return this.trafficMapIsSupported == supportedMapViews.trafficMapIsSupported && this.googleEarthMapIsSupported == supportedMapViews.googleEarthMapIsSupported && this.standardMapIsSupported == supportedMapViews.standardMapIsSupported;
        }

        private void customInitialization() {
        }

        public String toString() {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("SupportedMapViews:");
            stringBuffer.append("\n - Bit 2: ");
            if (this.trafficMapIsSupported) {
                stringBuffer.append("true  (traffic map is supported");
            } else {
                stringBuffer.append("false  (traffic map is not supported");
            }
            stringBuffer.append("\n - Bit 1: ");
            if (this.googleEarthMapIsSupported) {
                stringBuffer.append("true  (GoogleEarth map is supported");
            } else {
                stringBuffer.append("false  (GoogleEarth map is not supported");
            }
            stringBuffer.append("\n - Bit 0: ");
            if (this.standardMapIsSupported) {
                stringBuffer.append("true  (standard map is supported");
            } else {
                stringBuffer.append("false  (standard map is not supported");
            }
            return stringBuffer.toString();
        }

        public int bitSize() {
            int n = 0;
            return n += 8;
        }

        public void serialize(BitStream bitStream) {
            bitStream.resetBits(5);
            bitStream.pushBoolean(this.trafficMapIsSupported);
            bitStream.pushBoolean(this.googleEarthMapIsSupported);
            bitStream.pushBoolean(this.standardMapIsSupported);
        }

        public void deserialize(BitStream bitStream) {
            bitStream.discardBits(5);
            this.trafficMapIsSupported = bitStream.popFrontBoolean();
            this.googleEarthMapIsSupported = bitStream.popFrontBoolean();
            this.standardMapIsSupported = bitStream.popFrontBoolean();
        }
    }

    public static final class SupportedSupplementaryMapViews
    implements BAPEntity {
        private static final int RESERVED_BIT_3__7_BITSIZE = 5;
        public boolean _1BoxSupported;
        public boolean compassSupported;
        public boolean intersectionZoomSupported;
        private static final int SUPPORTED_SUPPLEMENTARY_MAP_VIEWS_BITSIZE = 8;

        public SupportedSupplementaryMapViews() {
            this.internalReset();
            this.customInitialization();
        }

        public SupportedSupplementaryMapViews(BitStream bitStream) {
            this();
            this.deserialize(bitStream);
        }

        private void internalReset() {
            this._1BoxSupported = false;
            this.compassSupported = false;
            this.intersectionZoomSupported = false;
        }

        public void reset() {
            this.internalReset();
        }

        public boolean equalTo(BAPEntity bAPEntity) {
            SupportedSupplementaryMapViews supportedSupplementaryMapViews = (SupportedSupplementaryMapViews)bAPEntity;
            return this._1BoxSupported == supportedSupplementaryMapViews._1BoxSupported && this.compassSupported == supportedSupplementaryMapViews.compassSupported && this.intersectionZoomSupported == supportedSupplementaryMapViews.intersectionZoomSupported;
        }

        private void customInitialization() {
        }

        public String toString() {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("SupportedSupplementaryMapViews:");
            stringBuffer.append("\n - Bit 2: ");
            if (this._1BoxSupported) {
                stringBuffer.append("true  (3+1 Box supported");
            } else {
                stringBuffer.append("false  (3+1 Box not supported");
            }
            stringBuffer.append("\n - Bit 1: ");
            if (this.compassSupported) {
                stringBuffer.append("true  (compass supported");
            } else {
                stringBuffer.append("false  (compass not supported");
            }
            stringBuffer.append("\n - Bit 0: ");
            if (this.intersectionZoomSupported) {
                stringBuffer.append("true  (Intersection zoom supported");
            } else {
                stringBuffer.append("false  (Intersection zoom not supported");
            }
            return stringBuffer.toString();
        }

        public int bitSize() {
            int n = 0;
            return n += 8;
        }

        public void serialize(BitStream bitStream) {
            bitStream.resetBits(5);
            bitStream.pushBoolean(this._1BoxSupported);
            bitStream.pushBoolean(this.compassSupported);
            bitStream.pushBoolean(this.intersectionZoomSupported);
        }

        public void deserialize(BitStream bitStream) {
            bitStream.discardBits(5);
            this._1BoxSupported = bitStream.popFrontBoolean();
            this.compassSupported = bitStream.popFrontBoolean();
            this.intersectionZoomSupported = bitStream.popFrontBoolean();
        }
    }
}

