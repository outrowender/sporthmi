/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.generated.navsd.serializer;

import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.datatypes.BAPString;
import de.vw.mib.bap.requests.StartResultMethod;
import de.vw.mib.bap.stream.BitStream;

public final class NbSpeller_StartResult
implements StartResultMethod {
    public int mode;
    private static final int MODE_BITSIZE;
    public static final int MODE_MATCH_SPELLER;
    public static final int MODE_NEXT_CHARACTER;
    public static final int MODE_PREVIOUS_CHARACTER;
    public final BAPString searchString = new BAPString(51);
    private static final int MAX_SEARCH_STRING_LENGTH;

    public NbSpeller_StartResult() {
        this.internalReset();
        this.customInitialization();
    }

    public NbSpeller_StartResult(BitStream bitStream) {
        this();
        this.deserialize(bitStream);
    }

    private void internalReset() {
        this.mode = 0;
    }

    @Override
    public void reset() {
        this.internalReset();
        this.searchString.reset();
    }

    @Override
    public boolean equalTo(BAPEntity bAPEntity) {
        NbSpeller_StartResult nbSpeller_StartResult = (NbSpeller_StartResult)bAPEntity;
        return this.mode == nbSpeller_StartResult.mode && this.searchString.equalTo(nbSpeller_StartResult.searchString);
    }

    private void customInitialization() {
    }

    @Override
    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("NbSpeller_StartResult:");
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

    @Override
    public int bitSize() {
        int n = 0;
        n += 8;
        return n += this.searchString.bitSize();
    }

    @Override
    public void serialize(BitStream bitStream) {
        bitStream.pushByte((byte)this.mode);
        this.searchString.serialize(bitStream);
    }

    @Override
    public void deserialize(BitStream bitStream) {
        this.mode = bitStream.popFrontByte();
        this.searchString.deserialize(bitStream);
    }

    public static int functionId() {
        return 42;
    }

    @Override
    public int getFunctionId() {
        return NbSpeller_StartResult.functionId();
    }
}

