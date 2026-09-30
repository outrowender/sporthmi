/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.generated.telephone2.serializer;

import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.requests.StatusProperty;
import de.vw.mib.bap.stream.BitStream;

public final class FSG_Setup_Status
implements StatusProperty {
    public static final int EXTENSION_1_MIN = 0;
    public int extension_1;
    private static final int EXTENSION_1_BITSIZE = 8;
    public static final int EXTENSION_2_MIN = 0;
    public int extension_2;
    private static final int EXTENSION_2_BITSIZE = 8;
    public static final int EXTENSION_3_MIN = 0;
    public int extension_3;
    private static final int EXTENSION_3_BITSIZE = 8;
    public static final int EXTENSION_4_MIN = 0;
    public int extension_4;
    private static final int EXTENSION_4_BITSIZE = 8;
    public static final int EXTENSION_5_MIN = 0;
    public int extension_5;
    private static final int EXTENSION_5_BITSIZE = 8;
    public static final int EXTENSION_6_MIN = 0;
    public int extension_6;
    private static final int EXTENSION_6_BITSIZE = 8;

    public FSG_Setup_Status() {
        this.internalReset();
        this.customInitialization();
    }

    public FSG_Setup_Status(BitStream bitStream) {
        this();
        this.deserialize(bitStream);
    }

    private void internalReset() {
        this.extension_1 = 0;
        this.extension_2 = 0;
        this.extension_3 = 0;
        this.extension_4 = 0;
        this.extension_5 = 0;
        this.extension_6 = 0;
    }

    public void reset() {
        this.internalReset();
    }

    public boolean equalTo(BAPEntity bAPEntity) {
        FSG_Setup_Status fSG_Setup_Status = (FSG_Setup_Status)bAPEntity;
        return this.extension_1 == fSG_Setup_Status.extension_1 && this.extension_2 == fSG_Setup_Status.extension_2 && this.extension_3 == fSG_Setup_Status.extension_3 && this.extension_4 == fSG_Setup_Status.extension_4 && this.extension_5 == fSG_Setup_Status.extension_5 && this.extension_6 == fSG_Setup_Status.extension_6;
    }

    private void customInitialization() {
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("FSG_Setup_Status:");
        stringBuffer.append("\n - Extension_1 - ");
        stringBuffer.append(this.extension_1);
        stringBuffer.append("\n - Extension_2 - ");
        stringBuffer.append(this.extension_2);
        stringBuffer.append("\n - Extension_3 - ");
        stringBuffer.append(this.extension_3);
        stringBuffer.append("\n - Extension_4 - ");
        stringBuffer.append(this.extension_4);
        stringBuffer.append("\n - Extension_5 - ");
        stringBuffer.append(this.extension_5);
        stringBuffer.append("\n - Extension_6 - ");
        stringBuffer.append(this.extension_6);
        return stringBuffer.toString();
    }

    public int bitSize() {
        int n = 0;
        n += 8;
        n += 8;
        n += 8;
        n += 8;
        n += 8;
        return n += 8;
    }

    public void serialize(BitStream bitStream) {
        bitStream.pushByte((byte)this.extension_1);
        bitStream.pushByte((byte)this.extension_2);
        bitStream.pushByte((byte)this.extension_3);
        bitStream.pushByte((byte)this.extension_4);
        bitStream.pushByte((byte)this.extension_5);
        bitStream.pushByte((byte)this.extension_6);
    }

    public void deserialize(BitStream bitStream) {
        this.extension_1 = bitStream.popFrontByte();
        this.extension_2 = bitStream.popFrontByte();
        this.extension_3 = bitStream.popFrontByte();
        this.extension_4 = bitStream.popFrontByte();
        this.extension_5 = bitStream.popFrontByte();
        this.extension_6 = bitStream.popFrontByte();
    }

    public static int functionId() {
        return 14;
    }

    public int getFunctionId() {
        return FSG_Setup_Status.functionId();
    }
}

