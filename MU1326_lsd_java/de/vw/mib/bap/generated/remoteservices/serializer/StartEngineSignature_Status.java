/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.generated.remoteservices.serializer;

import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.datatypes.BAPString;
import de.vw.mib.bap.requests.StatusProperty;
import de.vw.mib.bap.stream.BitStream;

public final class StartEngineSignature_Status
implements StatusProperty {
    public final BAPString data = new BAPString(36);
    private static final int MAX_DATA_LENGTH = 36;

    public StartEngineSignature_Status() {
        this.internalReset();
        this.customInitialization();
    }

    public StartEngineSignature_Status(BitStream bitStream) {
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
        StartEngineSignature_Status startEngineSignature_Status = (StartEngineSignature_Status)bAPEntity;
        return this.data.equalTo(startEngineSignature_Status.data);
    }

    private void customInitialization() {
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("StartEngineSignature_Status");
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
        return 18;
    }

    public int getFunctionId() {
        return StartEngineSignature_Status.functionId();
    }
}

