/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.generated.remoteservices.serializer;

import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.generated.remoteservices.serializer.MobDevKeySetup_Setup;
import de.vw.mib.bap.requests.SetGetProperty;
import de.vw.mib.bap.stream.BitStream;

public final class MobDevKeySetup_SetGet
implements SetGetProperty {
    public MobDevKeySetup_Setup setup = new MobDevKeySetup_Setup();
    public int reserve1;
    public static final int RESERVE1_MIN = 0;
    private static final int RESERVE1_BITSIZE = 4;
    public int reserve2;
    public static final int RESERVE2_MIN = 0;
    private static final int RESERVE2_BITSIZE = 4;
    public int reserve3;
    public static final int RESERVE3_MIN = 0;
    private static final int RESERVE3_BITSIZE = 4;
    public int reserve4;
    public static final int RESERVE4_MIN = 0;
    private static final int RESERVE4_BITSIZE = 4;
    public int reserve5;
    public static final int RESERVE5_MIN = 0;
    private static final int RESERVE5_BITSIZE = 4;
    public int reserve6;
    public static final int RESERVE6_MIN = 0;
    private static final int RESERVE6_BITSIZE = 4;
    public int extension1;
    public static final int EXTENSION1_MIN = 0;
    public int extension2;
    public static final int EXTENSION2_MIN = 0;

    public MobDevKeySetup_SetGet() {
        this.internalReset();
        this.customInitialization();
    }

    public MobDevKeySetup_SetGet(BitStream bitStream) {
        this();
        this.deserialize(bitStream);
    }

    private void internalReset() {
        this.reserve1 = 0;
        this.reserve2 = 0;
        this.reserve3 = 0;
        this.reserve4 = 0;
        this.reserve5 = 0;
        this.reserve6 = 0;
        this.extension1 = 0;
        this.extension2 = 0;
    }

    public void reset() {
        this.internalReset();
        this.setup.reset();
    }

    public boolean equalTo(BAPEntity bAPEntity) {
        MobDevKeySetup_SetGet mobDevKeySetup_SetGet = (MobDevKeySetup_SetGet)bAPEntity;
        return this.setup.equalTo(mobDevKeySetup_SetGet.setup) && this.reserve1 == mobDevKeySetup_SetGet.reserve1 && this.reserve2 == mobDevKeySetup_SetGet.reserve2 && this.reserve3 == mobDevKeySetup_SetGet.reserve3 && this.reserve4 == mobDevKeySetup_SetGet.reserve4 && this.reserve5 == mobDevKeySetup_SetGet.reserve5 && this.reserve6 == mobDevKeySetup_SetGet.reserve6 && this.extension1 == mobDevKeySetup_SetGet.extension1 && this.extension2 == mobDevKeySetup_SetGet.extension2;
    }

    private void customInitialization() {
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("MobDevKeySetup_SetGet");
        stringBuffer.append("\n - setup:").append(this.setup.toString());
        stringBuffer.append("\n - reserve1:").append(this.reserve1);
        stringBuffer.append("\n - reserve2:").append(this.reserve2);
        stringBuffer.append("\n - reserve3:").append(this.reserve3);
        stringBuffer.append("\n - reserve4:").append(this.reserve4);
        stringBuffer.append("\n - reserve5:").append(this.reserve5);
        stringBuffer.append("\n - reserve6:").append(this.reserve6);
        stringBuffer.append("\n - extension1:").append(this.extension1);
        stringBuffer.append("\n - extension2:").append(this.extension2);
        return stringBuffer.toString();
    }

    public int bitSize() {
        return 0;
    }

    public void serialize(BitStream bitStream) {
        this.setup.serialize(bitStream);
        bitStream.pushBits(4, this.reserve1);
        bitStream.pushBits(4, this.reserve2);
        bitStream.pushBits(4, this.reserve3);
        bitStream.pushBits(4, this.reserve4);
        bitStream.pushBits(4, this.reserve5);
        bitStream.pushBits(4, this.reserve6);
        bitStream.pushByte((byte)this.extension1);
        bitStream.pushByte((byte)this.extension2);
    }

    public void deserialize(BitStream bitStream) {
        this.setup.deserialize(bitStream);
        this.reserve1 = bitStream.popFrontBits(4);
        this.reserve2 = bitStream.popFrontBits(4);
        this.reserve3 = bitStream.popFrontBits(4);
        this.reserve4 = bitStream.popFrontBits(4);
        this.reserve5 = bitStream.popFrontBits(4);
        this.reserve6 = bitStream.popFrontBits(4);
        this.extension1 = bitStream.popFrontByte();
        this.extension2 = bitStream.popFrontByte();
    }

    public static int functionId() {
        return 23;
    }

    public int getFunctionId() {
        return MobDevKeySetup_SetGet.functionId();
    }
}

