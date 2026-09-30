/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.generated.eni.serializer;

import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.stream.BitStream;

public final class RemoteProcessCommands_SupportedCommands2
implements BAPEntity {
    private static final int RESERVED_BIT_1__7_BITSIZE = 7;
    public boolean requestNewLanguageSupportedDf3_4;

    public RemoteProcessCommands_SupportedCommands2() {
        this.internalReset();
        this.customInitialization();
    }

    public RemoteProcessCommands_SupportedCommands2(BitStream bitStream) {
        this();
        this.deserialize(bitStream);
    }

    private void internalReset() {
        this.requestNewLanguageSupportedDf3_4 = false;
    }

    public void reset() {
        this.internalReset();
    }

    public boolean equalTo(BAPEntity bAPEntity) {
        RemoteProcessCommands_SupportedCommands2 remoteProcessCommands_SupportedCommands2 = (RemoteProcessCommands_SupportedCommands2)bAPEntity;
        return this.requestNewLanguageSupportedDf3_4 == remoteProcessCommands_SupportedCommands2.requestNewLanguageSupportedDf3_4;
    }

    private void customInitialization() {
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("RemoteProcessCommands_SupportedCommands2");
        stringBuffer.append("\n - requestNewLanguageSupportedDf3_4:" + this.requestNewLanguageSupportedDf3_4);
        return stringBuffer.toString();
    }

    public int bitSize() {
        return 0;
    }

    public void serialize(BitStream bitStream) {
        bitStream.resetBits(7);
        bitStream.pushBoolean(this.requestNewLanguageSupportedDf3_4);
    }

    public void deserialize(BitStream bitStream) {
        bitStream.discardBits(7);
        this.requestNewLanguageSupportedDf3_4 = bitStream.popFrontBoolean();
    }
}

