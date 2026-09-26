/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.generated.remoteservices.serializer;

import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.datatypes.BAPString;
import de.vw.mib.bap.requests.ResultMethod;
import de.vw.mib.bap.stream.BitStream;

public final class StartEngineChallenge_Result
implements ResultMethod {
    public final BAPString dataAcknowledge = new BAPString(11);
    private static final int MAX_DATAACKNOWLEDGE_LENGTH;

    public StartEngineChallenge_Result() {
        this.internalReset();
        this.customInitialization();
    }

    public StartEngineChallenge_Result(BitStream bitStream) {
        this();
        this.deserialize(bitStream);
    }

    private void internalReset() {
    }

    @Override
    public void reset() {
        this.internalReset();
        this.dataAcknowledge.reset();
    }

    @Override
    public boolean equalTo(BAPEntity bAPEntity) {
        StartEngineChallenge_Result startEngineChallenge_Result = (StartEngineChallenge_Result)bAPEntity;
        return this.dataAcknowledge.equalTo(startEngineChallenge_Result.dataAcknowledge);
    }

    private void customInitialization() {
    }

    @Override
    public int getResultCode() {
        return 0;
    }

    @Override
    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("StartEngineChallenge_Result");
        stringBuffer.append("\n - dataAcknowledge:").append(this.dataAcknowledge.toString());
        return stringBuffer.toString();
    }

    @Override
    public int bitSize() {
        return 0;
    }

    @Override
    public void serialize(BitStream bitStream) {
        this.dataAcknowledge.serialize(bitStream);
    }

    @Override
    public void deserialize(BitStream bitStream) {
        this.dataAcknowledge.deserialize(bitStream);
    }

    public static int functionId() {
        return 16;
    }

    @Override
    public int getFunctionId() {
        return StartEngineChallenge_Result.functionId();
    }
}

