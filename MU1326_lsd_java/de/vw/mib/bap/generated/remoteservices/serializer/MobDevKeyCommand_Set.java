/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.generated.remoteservices.serializer;

import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.datatypes.BAPString;
import de.vw.mib.bap.requests.SetProperty;
import de.vw.mib.bap.stream.BitStream;

public final class MobDevKeyCommand_Set
implements SetProperty {
    public final BAPString data = new BAPString(700);
    private static final int MAX_DATA_LENGTH = 700;

    public MobDevKeyCommand_Set() {
        this.internalReset();
        this.customInitialization();
    }

    public MobDevKeyCommand_Set(BitStream bitStream) {
        this();
        this.deserialize(bitStream);
    }

    private void internalReset() {
    }

    public void reset() {
        this.internalReset();
        this.data.reset();
    }

    public boolean equalTo(BAPEntity bAPEntity) {
        MobDevKeyCommand_Set mobDevKeyCommand_Set = (MobDevKeyCommand_Set)bAPEntity;
        return this.data.equalTo(mobDevKeyCommand_Set.data);
    }

    private void customInitialization() {
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("MobDevKeyCommand_Set");
        stringBuffer.append("\n - data:").append(this.data.toString());
        return stringBuffer.toString();
    }

    public int bitSize() {
        return 0;
    }

    public void serialize(BitStream bitStream) {
        this.data.serialize(bitStream);
    }

    public void deserialize(BitStream bitStream) {
        this.data.deserialize(bitStream);
    }

    public static int functionId() {
        return 21;
    }

    public int getFunctionId() {
        return MobDevKeyCommand_Set.functionId();
    }
}

