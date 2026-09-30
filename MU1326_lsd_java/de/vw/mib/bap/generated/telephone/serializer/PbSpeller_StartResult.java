/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.generated.telephone.serializer;

import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.datatypes.BAPString;
import de.vw.mib.bap.requests.StartResultMethod;
import de.vw.mib.bap.stream.BitStream;

public final class PbSpeller_StartResult
implements StartResultMethod {
    public int mode;
    private static final int MODE_BITSIZE = 8;
    public static final int MODE_MATCH_SPELLER = 0;
    public static final int MODE_NEXT_CHARACTER = 1;
    public static final int MODE_PREVIOUS_CHARACTER = 2;
    public final BAPString searchString = new BAPString(50);
    private static final int MAX_SEARCH_STRING_LENGTH = 50;

    public PbSpeller_StartResult() {
        this.internalReset();
        this.customInitialization();
    }

    public PbSpeller_StartResult(BitStream bitStream) {
        this();
        this.deserialize(bitStream);
    }

    private void internalReset() {
        this.mode = 0;
    }

    public void reset() {
        this.internalReset();
        this.searchString.reset();
    }

    public boolean equalTo(BAPEntity bAPEntity) {
        PbSpeller_StartResult pbSpeller_StartResult = (PbSpeller_StartResult)bAPEntity;
        return this.mode == pbSpeller_StartResult.mode && this.searchString.equalTo(pbSpeller_StartResult.searchString);
    }

    private void customInitialization() {
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("PbSpeller_StartResult:");
        stringBuffer.append("\n - Mode: ");
        switch (this.mode) {
            case 0: {
                stringBuffer.append("0x00 (MatchSpeller)");
                break;
            }
            case 1: {
                stringBuffer.append("0x01 (next character)");
                break;
            }
            case 2: {
                stringBuffer.append("0x02 (previous character)");
                break;
            }
            default: {
                stringBuffer.append("UNKNOWN ENUM");
            }
        }
        stringBuffer.append("\n - SearchString - ");
        stringBuffer.append(this.searchString.toString());
        return stringBuffer.toString();
    }

    public int bitSize() {
        int n = 0;
        n += 8;
        return n += this.searchString.bitSize();
    }

    public void serialize(BitStream bitStream) {
        bitStream.pushByte((byte)this.mode);
        this.searchString.serialize(bitStream);
    }

    public void deserialize(BitStream bitStream) {
        this.mode = bitStream.popFrontByte();
        this.searchString.deserialize(bitStream);
    }

    public static int functionId() {
        return 53;
    }

    public int getFunctionId() {
        return PbSpeller_StartResult.functionId();
    }
}

