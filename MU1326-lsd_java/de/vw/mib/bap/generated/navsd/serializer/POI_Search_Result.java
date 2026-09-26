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
    private static final int AMOUNT_OF_FOUND_ENTRIES_BITSIZE;
    public int poi_Search_Result;
    private static final int POI_SEARCH_RESULT_BITSIZE;
    public static final int POI_SEARCH_RESULT_SUCCESSFUL;
    public static final int POI_SEARCH_RESULT_NOT_SUCCESSFUL;
    public static final int POI_SEARCH_RESULT_ABORT_SUCCESSFUL;
    public static final int POI_SEARCH_RESULT_ABORT_NOT_SUCCESSFUL;
    public static final int POI_SEARCH_RESULT_NOT_SUCCESSFUL_ENTRY_NOT_FOUND;
    public static final int POI_SEARCH_RESULT_NOT_SUCCESSFUL_POI_TYPE_DOES_NOT_MATCH_TO_FSG_INTERNAL_VALUE;

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

    @Override
    public void reset() {
        this.internalReset();
    }

    @Override
    public boolean equalTo(BAPEntity bAPEntity) {
        POI_Search_Result pOI_Search_Result = (POI_Search_Result)bAPEntity;
        return this.amountOfFoundEntries == pOI_Search_Result.amountOfFoundEntries && this.poi_Search_Result == pOI_Search_Result.poi_Search_Result;
    }

    private void customInitialization() {
    }

    @Override
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

    @Override
    public int bitSize() {
        int n = 0;
        n += 8;
        return n += 8;
    }

    @Override
    public void serialize(BitStream bitStream) {
        bitStream.pushByte((byte)this.amountOfFoundEntries);
        bitStream.pushByte((byte)this.poi_Search_Result);
    }

    @Override
    public void deserialize(BitStream bitStream) {
        this.amountOfFoundEntries = bitStream.popFrontByte();
        this.poi_Search_Result = bitStream.popFrontByte();
    }

    public static int functionId() {
        return 51;
    }

    @Override
    public int getFunctionId() {
        return POI_Search_Result.functionId();
    }

    @Override
    public int getResultCode() {
        return this.poi_Search_Result;
    }
}

