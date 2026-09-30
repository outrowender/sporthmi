/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.generated.navsd.serializer;

import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.requests.ResultMethod;
import de.vw.mib.bap.stream.BitStream;

public final class POI_Search_Result
implements ResultMethod {
    public int amountOfFoundEntries;
    private static final int AMOUNT_OF_FOUND_ENTRIES_BITSIZE = 8;
    public int poi_Search_Result;
    private static final int POI_SEARCH_RESULT_BITSIZE = 8;
    public static final int POI_SEARCH_RESULT_SUCCESSFUL = 0;
    public static final int POI_SEARCH_RESULT_NOT_SUCCESSFUL = 1;
    public static final int POI_SEARCH_RESULT_ABORT_SUCCESSFUL = 2;
    public static final int POI_SEARCH_RESULT_ABORT_NOT_SUCCESSFUL = 3;
    public static final int POI_SEARCH_RESULT_NOT_SUCCESSFUL_ENTRY_NOT_FOUND = 4;
    public static final int POI_SEARCH_RESULT_NOT_SUCCESSFUL_POI_TYPE_DOES_NOT_MATCH_TO_FSG_INTERNAL_VALUE = 5;

    public POI_Search_Result() {
        this.internalReset();
        this.customInitialization();
    }

    public POI_Search_Result(BitStream bitStream) {
        this();
        this.deserialize(bitStream);
    }

    private void internalReset() {
        this.amountOfFoundEntries = 0;
        this.poi_Search_Result = 0;
    }

    public void reset() {
        this.internalReset();
    }

    public boolean equalTo(BAPEntity bAPEntity) {
        POI_Search_Result pOI_Search_Result = (POI_Search_Result)bAPEntity;
        return this.amountOfFoundEntries == pOI_Search_Result.amountOfFoundEntries && this.poi_Search_Result == pOI_Search_Result.poi_Search_Result;
    }

    private void customInitialization() {
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("POI_Search_Result:");
        stringBuffer.append("\n - AmountOfFoundEntries - ");
        stringBuffer.append(this.amountOfFoundEntries);
        stringBuffer.append("\n - POI_Search_Result: ");
        switch (this.poi_Search_Result) {
            case 0: {
                stringBuffer.append("0x00 (successful)");
                break;
            }
            case 1: {
                stringBuffer.append("0x01 (not successful)");
                break;
            }
            case 2: {
                stringBuffer.append("0x02 (abort successful)");
                break;
            }
            case 3: {
                stringBuffer.append("0x03 (abort not successful)");
                break;
            }
            case 4: {
                stringBuffer.append("0x04 (not successful - Entry not found)");
                break;
            }
            case 5: {
                stringBuffer.append("0x05 (not successful - POI_Type does not match to FSG internal value)");
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
        bitStream.pushByte((byte)this.amountOfFoundEntries);
        bitStream.pushByte((byte)this.poi_Search_Result);
    }

    public void deserialize(BitStream bitStream) {
        this.amountOfFoundEntries = bitStream.popFrontByte();
        this.poi_Search_Result = bitStream.popFrontByte();
    }

    public static int functionId() {
        return 51;
    }

    public int getFunctionId() {
        return POI_Search_Result.functionId();
    }

    public int getResultCode() {
        return this.poi_Search_Result;
    }
}

