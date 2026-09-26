/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.generated.navsd.serializer;

import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.stream.BitStream;

public final class FSG_Setup_Status$Supported_POI_Types
implements BAPEntity {
    private static final int RESERVED_BIT_1__7_BITSIZE;
    public boolean fuelStationAndParkingAreaSupported;
    private static final int SUPPORTED_POI_TYPES_BITSIZE;

    public FSG_Setup_Status$Supported_POI_Types() {
        this.internalReset();
        this.customInitialization();
    }

    public FSG_Setup_Status$Supported_POI_Types(BitStream bitStream) {
        this();
        this.deserialize(bitStream);
    }

    private void internalReset() {
        this.fuelStationAndParkingAreaSupported = false;
    }

    @Override
    public void reset() {
        this.internalReset();
    }

    @Override
    public boolean equalTo(BAPEntity bAPEntity) {
        FSG_Setup_Status$Supported_POI_Types fSG_Setup_Status$Supported_POI_Types = (FSG_Setup_Status$Supported_POI_Types)bAPEntity;
        return this.fuelStationAndParkingAreaSupported == fSG_Setup_Status$Supported_POI_Types.fuelStationAndParkingAreaSupported;
    }

    private void customInitialization() {
    }

    @Override
    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("Supported_POI_Types:");
        stringBuffer.append("\n - Bit 0: ");
        if (this.fuelStationAndParkingAreaSupported) {
            stringBuffer.append("true  (fuel station and parking area supported");
        } else {
            stringBuffer.append("false  (fuel station parking area not supported");
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
        bitStream.resetBits(7);
        bitStream.pushBoolean(this.fuelStationAndParkingAreaSupported);
    }

    @Override
    public void deserialize(BitStream bitStream) {
        bitStream.discardBits(7);
        this.fuelStationAndParkingAreaSupported = bitStream.popFrontBoolean();
    }
}

