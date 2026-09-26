/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.generated.remoteservices.serializer;

import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.datatypes.BAPString;
import de.vw.mib.bap.requests.StartResultMethod;
import de.vw.mib.bap.stream.BitStream;

public final class StartEngineChallenge_StartResult
implements StartResultMethod {
    public final BAPString dataRequest = new BAPString(6);
    private static final int MAX_DATAREQUEST_LENGTH;

    public StartEngineChallenge_StartResult() {
        this.internalReset();
        this.customInitialization();
    }

    public StartEngineChallenge_StartResult(BitStream bitStream) {
        this();
        this.deserialize(bitStream);
    }

    private void internalReset() {
    }

    @Override
    public void reset() {
        this.internalReset();
        this.dataRequest.reset();
    }

    @Override
    public boolean equalTo(BAPEntity bAPEntity) {
        StartEngineChallenge_StartResult startEngineChallenge_StartResult = (StartEngineChallenge_StartResult)bAPEntity;
        return this.dataRequest.equalTo(startEngineChallenge_StartResult.dataRequest);
    }

    private void customInitialization() {
    }

    @Override
    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("StartEngineChallenge_StartResult");
        stringBuffer.append("\n - dataRequest:").append(this.dataRequest.toString());
        return stringBuffer.toString();
    }

    @Override
    public int bitSize() {
        return 0;
    }

    @Override
    public void serialize(BitStream bitStream) {
        this.dataRequest.serialize(bitStream);
    }

    @Override
    public void deserialize(BitStream bitStream) {
        this.dataRequest.deserialize(bitStream);
    }

    public static int functionId() {
        return 16;
    }

    @Override
    public int getFunctionId() {
        return StartEngineChallenge_StartResult.functionId();
    }
}

