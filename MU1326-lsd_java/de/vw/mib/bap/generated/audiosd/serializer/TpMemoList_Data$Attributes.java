/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.generated.audiosd.serializer;

import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.stream.BitStream;

public final class TpMemoList_Data$Attributes
implements BAPEntity {
    private static final int RESERVED_BIT_3__7_BITSIZE;
    public boolean reserved_bit_2;
    public boolean reserved_bit_1;
    public boolean newMessage;
    private static final int ATTRIBUTES_BITSIZE;

    public TpMemoList_Data$Attributes() {
        this.internalReset();
        this.customInitialization();
    }

    public TpMemoList_Data$Attributes(BitStream bitStream) {
        this();
        this.deserialize(bitStream);
    }

    private void internalReset() {
        this.reserved_bit_2 = false;
        this.reserved_bit_1 = false;
        this.newMessage = false;
    }

    @Override
    public void reset() {
        this.internalReset();
    }

    @Override
    public boolean equalTo(BAPEntity bAPEntity) {
        TpMemoList_Data$Attributes tpMemoList_Data$Attributes = (TpMemoList_Data$Attributes)bAPEntity;
        return this.reserved_bit_2 == tpMemoList_Data$Attributes.reserved_bit_2 && this.reserved_bit_1 == tpMemoList_Data$Attributes.reserved_bit_1 && this.newMessage == tpMemoList_Data$Attributes.newMessage;
    }

    private void customInitialization() {
    }

    @Override
    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("Attributes:");
        stringBuffer.append("\n - Bit 2: ");
        if (this.reserved_bit_2) {
            stringBuffer.append("true  (reserved");
        } else {
            stringBuffer.append("false  (reserved");
        }
        stringBuffer.append("\n - Bit 1: ");
        if (this.reserved_bit_1) {
            stringBuffer.append("true  (reserved");
        } else {
            stringBuffer.append("false  (reserved");
        }
        stringBuffer.append("\n - Bit 0: ");
        if (this.newMessage) {
            stringBuffer.append("true  (new message");
        } else {
            stringBuffer.append("false  (message is not new");
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
        bitStream.resetBits(5);
        bitStream.pushBoolean(this.reserved_bit_2);
        bitStream.pushBoolean(this.reserved_bit_1);
        bitStream.pushBoolean(this.newMessage);
    }

    @Override
    public void deserialize(BitStream bitStream) {
        bitStream.discardBits(5);
        this.reserved_bit_2 = bitStream.popFrontBoolean();
        this.reserved_bit_1 = bitStream.popFrontBoolean();
        this.newMessage = bitStream.popFrontBoolean();
    }
}

