/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.generated.telephone.serializer;

import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.requests.ResultMethod;
import de.vw.mib.bap.stream.BitStream;

public final class PbSpeller_Result
implements ResultMethod {
    public int pbSpeller_Result;
    private static final int PB_SPELLER_RESULT_BITSIZE = 8;
    public static final int PB_SPELLER_RESULT_SUCCESSFUL = 0;
    public static final int PB_SPELLER_RESULT_NOT_SUCCESSFUL = 1;
    public static final int PB_SPELLER_RESULT_ABORT_SUCCESSFUL = 2;
    public static final int PB_SPELLER_RESULT_ABORT_NOT_SUCCESSFUL = 3;
    public static final int PB_SPELLER_RESULT_NOT_SUCCESSFUL_FIRST_CHARACTER_REACHED = 4;
    public static final int PB_SPELLER_RESULT_NOT_SUCCESSFUL_LAST_CHARACTER_REACHED = 5;
    public int matchingEntries;
    private static final int MATCHING_ENTRIES_BITSIZE = 16;
    public int pos;
    private static final int POS_BITSIZE = 16;

    public int getResultCode() {
        return this.pbSpeller_Result;
    }

    public PbSpeller_Result() {
        this.internalReset();
        this.customInitialization();
    }

    public PbSpeller_Result(BitStream bitStream) {
        this();
        this.deserialize(bitStream);
    }

    private void internalReset() {
        this.pbSpeller_Result = 0;
        this.matchingEntries = 0;
        this.pos = 0;
    }

    public void reset() {
        this.internalReset();
    }

    public boolean equalTo(BAPEntity bAPEntity) {
        PbSpeller_Result pbSpeller_Result = (PbSpeller_Result)bAPEntity;
        return this.pbSpeller_Result == pbSpeller_Result.pbSpeller_Result && this.matchingEntries == pbSpeller_Result.matchingEntries && this.pos == pbSpeller_Result.pos;
    }

    private void customInitialization() {
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("PbSpeller_Result:");
        stringBuffer.append("\n - PbSpeller_Result: ");
        switch (this.pbSpeller_Result) {
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
                stringBuffer.append("0x04 (not successful - first character reached)");
                break;
            }
            case 5: {
                stringBuffer.append("0x05 (not successful - last character reached)");
                break;
            }
            default: {
                stringBuffer.append("UNKNOWN ENUM");
            }
        }
        stringBuffer.append("\n - MatchingEntries - ");
        stringBuffer.append(this.matchingEntries);
        stringBuffer.append("\n - Pos - ");
        stringBuffer.append(this.pos);
        return stringBuffer.toString();
    }

    public int bitSize() {
        int n = 0;
        n += 8;
        n += 16;
        return n += 16;
    }

    public void serialize(BitStream bitStream) {
        bitStream.pushByte((byte)this.pbSpeller_Result);
        bitStream.pushShort((short)this.matchingEntries);
        bitStream.pushShort((short)this.pos);
    }

    public void deserialize(BitStream bitStream) {
        this.pbSpeller_Result = bitStream.popFrontByte();
        this.matchingEntries = bitStream.popFrontShort();
        this.pos = bitStream.popFrontShort();
    }

    public static int functionId() {
        return 53;
    }

    public int getFunctionId() {
        return PbSpeller_Result.functionId();
    }
}

