/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.generated.remoteservices.serializer;

import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.datatypes.BAPString;
import de.vw.mib.bap.requests.ResultMethod;
import de.vw.mib.bap.stream.BitStream;

public final class MobDevKeyChallenge_Result
implements ResultMethod {
    public final BAPString dataAcknowledge = new BAPString(700);
    private static final int MAX_DATAACKNOWLEDGE_LENGTH = 700;

    public MobDevKeyChallenge_Result() {
        this.internalReset();
        this.customInitialization();
    }

    public MobDevKeyChallenge_Result(BitStream bitStream) {
        this();
        this.deserialize(bitStream);
    }

    private void internalReset() {
    }

    public void reset() {
        this.internalReset();
        this.dataAcknowledge.reset();
    }

    public boolean equalTo(BAPEntity bAPEntity) {
        MobDevKeyChallenge_Result mobDevKeyChallenge_Result = (MobDevKeyChallenge_Result)bAPEntity;
        return this.dataAcknowledge.equalTo(mobDevKeyChallenge_Result.dataAcknowledge);
    }

    private void customInitialization() {
    }

    public int getResultCode() {
        return 0;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("MobDevKeyChallenge_Result");
        stringBuffer.append("\n - dataAcknowledge:").append(this.dataAcknowledge.toString());
        return stringBuffer.toString();
    }

    public int bitSize() {
        return 0;
    }

    public void serialize(BitStream bitStream) {
        this.dataAcknowledge.serialize(bitStream);
    }

    public void deserialize(BitStream bitStream) {
        this.dataAcknowledge.deserialize(bitStream);
    }

    public static int functionId() {
        return 19;
    }

    public int getFunctionId() {
        return MobDevKeyChallenge_Result.functionId();
    }
}

