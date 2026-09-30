/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.generated.navsd.serializer;

import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.requests.ResultMethod;
import de.vw.mib.bap.stream.BitStream;

public final class NbSpeller_Result
implements ResultMethod {
    public int nbSpeller_Result;
    private static final int NB_SPELLER_RESULT_BITSIZE = 8;
    public static final int NB_SPELLER_RESULT_SUCCESSFUL = 0;
    public static final int NB_SPELLER_RESULT_NOT_SUCCESSFUL = 1;
    public static final int NB_SPELLER_RESULT_ABORT_SUCCESSFUL = 2;
    public static final int NB_SPELLER_RESULT_ABORT_NOT_SUCCESSFUL = 3;
    public int matchingEntries;
    private static final int MATCHING_ENTRIES_BITSIZE = 16;
    public int pos;
    private static final int POS_BITSIZE = 16;

    public int getResultCode() {
        return this.nbSpeller_Result;
    }

    public NbSpeller_Result() {
        this.internalReset();
        this.customInitialization();
    }

    public NbSpeller_Result(BitStream bitStream) {
        this();
        this.deserialize(bitStream);
    }

    private void internalReset() {
        this.nbSpeller_Result = 0;
        this.matchingEntries = 0;
        this.pos = 0;
    }

    public void reset() {
        this.internalReset();
    }

    public boolean equalTo(BAPEntity bAPEntity) {
        NbSpeller_Result nbSpeller_Result = (NbSpeller_Result)bAPEntity;
        return this.nbSpeller_Result == nbSpeller_Result.nbSpeller_Result && this.matchingEntries == nbSpeller_Result.matchingEntries && this.pos == nbSpeller_Result.pos;
    }

    private void customInitialization() {
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("NbSpeller_Result:");
        stringBuffer.append("\n - NbSpeller_Result: ");
        switch (this.nbSpeller_Result) {
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
        bitStream.pushByte((byte)this.nbSpeller_Result);
        bitStream.pushShort((short)this.matchingEntries);
        bitStream.pushShort((short)this.pos);
    }

    public void deserialize(BitStream bitStream) {
        this.nbSpeller_Result = bitStream.popFrontByte();
        this.matchingEntries = bitStream.popFrontShort();
        this.pos = bitStream.popFrontShort();
    }

    public static int functionId() {
        return 42;
    }

    public int getFunctionId() {
        return NbSpeller_Result.functionId();
    }
}

