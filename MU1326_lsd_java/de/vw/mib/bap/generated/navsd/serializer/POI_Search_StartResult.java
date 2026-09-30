/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.generated.navsd.serializer;

import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.requests.StartResultMethod;
import de.vw.mib.bap.stream.BitStream;

public final class POI_Search_StartResult
implements StartResultMethod {
    public int searchType;
    private static final int SEARCH_TYPE_BITSIZE = 8;
    public static final int SEARCH_TYPE_SEARCH_ALONG_THE_CURRENT_ROUTE_IN_CASE_OF_ACTIVE_RG = 0;
    public static final int SEARCH_TYPE_SEARCH_IN_THE_CIRCUMFERENCE_TO_THE_CURRENT_LOCATION = 1;
    public int poi_Type;
    private static final int POI_TYPE_BITSIZE = 8;
    public static final int POI_TYPE_GASSTATION_GENERAL = 63;
    public static final int POI_TYPE_PARKING_GENERAL = 103;

    public POI_Search_StartResult() {
        this.internalReset();
        this.customInitialization();
    }

    public POI_Search_StartResult(BitStream bitStream) {
        this();
        this.deserialize(bitStream);
    }

    private void internalReset() {
        this.searchType = 0;
        this.poi_Type = 0;
    }

    public void reset() {
        this.internalReset();
    }

    public boolean equalTo(BAPEntity bAPEntity) {
        POI_Search_StartResult pOI_Search_StartResult = (POI_Search_StartResult)bAPEntity;
        return this.searchType == pOI_Search_StartResult.searchType && this.poi_Type == pOI_Search_StartResult.poi_Type;
    }

    private void customInitialization() {
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("POI_Search_StartResult:");
        stringBuffer.append("\n - SearchType: ");
        switch (this.searchType) {
            case 0: {
                stringBuffer.append("0x00 (Search along the current route (in case of active RG))");
                break;
            }
            case 1: {
                stringBuffer.append("0x01 (Search in the circumference to the current location)");
                break;
            }
            default: {
                stringBuffer.append("UNKNOWN ENUM");
            }
        }
        stringBuffer.append("\n - POI_Type: ");
        switch (this.poi_Type) {
            case 63: {
                stringBuffer.append("0x3F (Gasstation (general))");
                break;
            }
            case 103: {
                stringBuffer.append("0x67 (Parking (general))");
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
        n += 8;
        return n += 8;
    }

    public void serialize(BitStream bitStream) {
        bitStream.pushByte((byte)this.searchType);
        bitStream.pushByte((byte)this.poi_Type);
    }

    public void deserialize(BitStream bitStream) {
        this.searchType = bitStream.popFrontByte();
        this.poi_Type = bitStream.popFrontByte();
    }

    public static int functionId() {
        return 51;
    }

    public int getFunctionId() {
        return POI_Search_StartResult.functionId();
    }
}

