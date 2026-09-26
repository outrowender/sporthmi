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
    private static final int PB_SPELLER_RESULT_BITSIZE;
    public static final int PB_SPELLER_RESULT_SUCCESSFUL;
    public static final int PB_SPELLER_RESULT_NOT_SUCCESSFUL;
    public static final int PB_SPELLER_RESULT_ABORT_SUCCESSFUL;
    public static final int PB_SPELLER_RESULT_ABORT_NOT_SUCCESSFUL;
    public static final int PB_SPELLER_RESULT_NOT_SUCCESSFUL_FIRST_CHARACTER_REACHED;
    public static final int PB_SPELLER_RESULT_NOT_SUCCESSFUL_LAST_CHARACTER_REACHED;
    public int matchingEntries;
    private static final int MATCHING_ENTRIES_BITSIZE;
    public int pos;
    private static final int POS_BITSIZE;

    @Override
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

    @Override
    public void reset() {
        this.internalReset();
    }

    @Override
    public boolean equalTo(BAPEntity bAPEntity) {
        PbSpeller_Result pbSpeller_Result = (PbSpeller_Result)bAPEntity;
        return this.pbSpeller_Result == pbSpeller_Result.pbSpeller_Result && this.matchingEntries == pbSpeller_Result.matchingEntries && this.pos == pbSpeller_Result.pos;
    }

    private void customInitialization() {
    }

    @Override
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

    @Override
    public int bitSize() {
        int n = 0;
        n += 8;
        n += 16;
        return n += 16;
    }

    @Override
    public void serialize(BitStream bitStream) {
        bitStream.pushByte((byte)this.pbSpeller_Result);
        bitStream.pushShort((short)this.matchingEntries);
        bitStream.pushShort((short)this.pos);
    }

    @Override
    public void deserialize(BitStream bitStream) {
        this.pbSpeller_Result = bitStream.popFrontByte();
        this.matchingEntries = bitStream.popFrontShort();
        this.pos = bitStream.popFrontShort();
    }

    public static int functionId() {
        return 53;
    }

    @Override
    public int getFunctionId() {
        return PbSpeller_Result.functionId();
    }
}

