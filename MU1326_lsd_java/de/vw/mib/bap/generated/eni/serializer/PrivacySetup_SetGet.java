/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.generated.eni.serializer;

import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.generated.eni.serializer.PrivacySetup_Setup;
import de.vw.mib.bap.requests.SetGetProperty;
import de.vw.mib.bap.stream.BitStream;

public final class PrivacySetup_SetGet
implements SetGetProperty {
    public PrivacySetup_Setup setup = new PrivacySetup_Setup();
    public int reserve1;
    public static final int RESERVE1_MIN = 0;
    private static final int RESERVE1_BITSIZE = 4;
    public int reserve2;
    public static final int RESERVE2_MIN = 0;
    private static final int RESERVE2_BITSIZE = 4;

    public PrivacySetup_SetGet() {
        this.internalReset();
        this.customInitialization();
    }

    public PrivacySetup_SetGet(BitStream bitStream) {
        this();
        this.deserialize(bitStream);
    }

    private void internalReset() {
        this.reserve1 = 0;
        this.reserve2 = 0;
    }

    public void reset() {
        this.internalReset();
        this.setup.reset();
    }

    public boolean equalTo(BAPEntity bAPEntity) {
        PrivacySetup_SetGet privacySetup_SetGet = (PrivacySetup_SetGet)bAPEntity;
        return this.setup.equalTo(privacySetup_SetGet.setup) && this.reserve1 == privacySetup_SetGet.reserve1 && this.reserve2 == privacySetup_SetGet.reserve2;
    }

    private void customInitialization() {
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("PrivacySetup_SetGet");
        stringBuffer.append("\n - setup:" + this.setup.toString());
        stringBuffer.append("\n - reserve1:" + this.reserve1);
        stringBuffer.append("\n - reserve2:" + this.reserve2);
        return stringBuffer.toString();
    }

    public int bitSize() {
        return 0;
    }

    public void serialize(BitStream bitStream) {
        this.setup.serialize(bitStream);
        bitStream.pushBits(4, this.reserve1);
        bitStream.pushBits(4, this.reserve2);
    }

    public void deserialize(BitStream bitStream) {
        this.setup.deserialize(bitStream);
        this.reserve1 = bitStream.popFrontBits(4);
        this.reserve2 = bitStream.popFrontBits(4);
    }

    public static int functionId() {
        return 24;
    }

    public int getFunctionId() {
        return PrivacySetup_SetGet.functionId();
    }
}

