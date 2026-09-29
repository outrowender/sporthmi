/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.generated.audiosd.serializer;

import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.stream.BitStream;

public final class ActiveSource_Status$ListAvailable
implements BAPEntity {
    public boolean reserved_bit_3;
    public boolean mediaBrowserListAvailable;
    public boolean presetListAvailable;
    public boolean receptionListAvailable;
    private static final int LIST_AVAILABLE_BITSIZE;

    public ActiveSource_Status$ListAvailable() {
        this.internalReset();
        this.customInitialization();
    }

    public ActiveSource_Status$ListAvailable(BitStream bitStream) {
        this();
        this.deserialize(bitStream);
    }

    private void internalReset() {
        this.reserved_bit_3 = false;
        this.mediaBrowserListAvailable = false;
        this.presetListAvailable = false;
        this.receptionListAvailable = false;
    }

    @Override
    public void reset() {
        this.internalReset();
    }

    @Override
    public boolean equalTo(BAPEntity bAPEntity) {
        ActiveSource_Status$ListAvailable activeSource_Status$ListAvailable = (ActiveSource_Status$ListAvailable)bAPEntity;
        return this.reserved_bit_3 == activeSource_Status$ListAvailable.reserved_bit_3 && this.mediaBrowserListAvailable == activeSource_Status$ListAvailable.mediaBrowserListAvailable && this.presetListAvailable == activeSource_Status$ListAvailable.presetListAvailable && this.receptionListAvailable == activeSource_Status$ListAvailable.receptionListAvailable;
    }

    private void customInitialization() {
    }

    @Override
    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("ListAvailable:");
        stringBuffer.append("\n - Bit 3: ");
        if (this.reserved_bit_3) {
            stringBuffer.append("true  (reserved");
        } else {
            stringBuffer.append("false  (reserved");
        }
        stringBuffer.append("\n - Bit 2: ");
        if (this.mediaBrowserListAvailable) {
            stringBuffer.append("true  (media browser list available");
        } else {
            stringBuffer.append("false  (media browser list not available");
        }
        stringBuffer.append("\n - Bit 1: ");
        if (this.presetListAvailable) {
            stringBuffer.append("true  (preset list available");
        } else {
            stringBuffer.append("false  (preset list not available");
        }
        stringBuffer.append("\n - Bit 0: ");
        if (this.receptionListAvailable) {
            stringBuffer.append("true  (reception list available");
        } else {
            stringBuffer.append("false  (reception list not available");
        }
        return stringBuffer.toString();
    }

    @Override
    public int bitSize() {
        int n = 0;
        return n += 4;
    }

    @Override
    public void serialize(BitStream bitStream) {
        bitStream.pushBoolean(this.reserved_bit_3);
        bitStream.pushBoolean(this.mediaBrowserListAvailable);
        bitStream.pushBoolean(this.presetListAvailable);
        bitStream.pushBoolean(this.receptionListAvailable);
    }

    @Override
    public void deserialize(BitStream bitStream) {
        this.reserved_bit_3 = bitStream.popFrontBoolean();
        this.mediaBrowserListAvailable = bitStream.popFrontBoolean();
        this.presetListAvailable = bitStream.popFrontBoolean();
        this.receptionListAvailable = bitStream.popFrontBoolean();
    }
}

