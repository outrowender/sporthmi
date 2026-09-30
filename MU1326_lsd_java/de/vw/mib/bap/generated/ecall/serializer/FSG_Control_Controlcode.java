/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.generated.ecall.serializer;

import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.stream.BitStream;

public final class FSG_Control_Controlcode
implements BAPEntity {
    private static final int RESERVED_BIT_5__7_BITSIZE = 3;
    public boolean on;
    private static final int RESERVED_BIT_1__3_BITSIZE = 3;
    public boolean setDefault;

    public FSG_Control_Controlcode() {
        this.internalReset();
        this.customInitialization();
    }

    public FSG_Control_Controlcode(BitStream bitStream) {
        this();
        this.deserialize(bitStream);
    }

    private void internalReset() {
        this.on = false;
        this.setDefault = false;
    }

    public void reset() {
        this.internalReset();
    }

    public boolean equalTo(BAPEntity bAPEntity) {
        FSG_Control_Controlcode fSG_Control_Controlcode = (FSG_Control_Controlcode)bAPEntity;
        return this.on == fSG_Control_Controlcode.on && this.setDefault == fSG_Control_Controlcode.setDefault;
    }

    private void customInitialization() {
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("FSG_Control_Controlcode");
        stringBuffer.append("\n - on:").append(this.on);
        stringBuffer.append("\n - setDefault:").append(this.setDefault);
        return stringBuffer.toString();
    }

    public int bitSize() {
        return 0;
    }

    public void serialize(BitStream bitStream) {
        bitStream.resetBits(3);
        bitStream.pushBoolean(this.on);
        bitStream.resetBits(3);
        bitStream.pushBoolean(this.setDefault);
    }

    public void deserialize(BitStream bitStream) {
        bitStream.discardBits(3);
        this.on = bitStream.popFrontBoolean();
        bitStream.discardBits(3);
        this.setDefault = bitStream.popFrontBoolean();
    }
}

