/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.generated.onlinefunctions.serializer;

import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.requests.SetGetProperty;
import de.vw.mib.bap.stream.BitStream;

public final class FSG_Control_SetGet
implements SetGetProperty {
    public static final int EXTENSION1_MIN;
    public int extension1;
    private static final int EXTENSION1_BITSIZE;
    public static final int EXTENSION2_MIN;
    public int extension2;
    private static final int EXTENSION2_BITSIZE;

    public FSG_Control_SetGet() {
        this.internalReset();
        this.customInitialization();
    }

    public FSG_Control_SetGet(BitStream bitStream) {
        this();
        this.deserialize(bitStream);
    }

    private void internalReset() {
        this.extension1 = 0;
        this.extension2 = 0;
    }

    @Override
    public void reset() {
        this.internalReset();
    }

    @Override
    public boolean equalTo(BAPEntity bAPEntity) {
        FSG_Control_SetGet fSG_Control_SetGet = (FSG_Control_SetGet)bAPEntity;
        return this.extension1 == fSG_Control_SetGet.extension1 && this.extension2 == fSG_Control_SetGet.extension2;
    }

    private void customInitialization() {
    }

    @Override
    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("FSG_Control_SetGet:");
        stringBuffer.append("\n - Extension1 - ");
        stringBuffer.append(this.extension1);
        stringBuffer.append("\n - Extension2 - ");
        stringBuffer.append(this.extension2);
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
        bitStream.pushByte((byte)this.extension1);
        bitStream.pushByte((byte)this.extension2);
    }

    @Override
    public void deserialize(BitStream bitStream) {
        this.extension1 = bitStream.popFrontByte();
        this.extension2 = bitStream.popFrontByte();
    }

    public static int functionId() {
        return 13;
    }

    @Override
    public int getFunctionId() {
        return FSG_Control_SetGet.functionId();
    }
}

