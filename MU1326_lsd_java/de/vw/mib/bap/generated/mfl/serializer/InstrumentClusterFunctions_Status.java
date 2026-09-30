/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.generated.mfl.serializer;

import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.generated.mfl.serializer.InstrumentClusterFunctions_ConfigurationOptions;
import de.vw.mib.bap.requests.StatusProperty;
import de.vw.mib.bap.stream.BitStream;

public final class InstrumentClusterFunctions_Status
implements StatusProperty {
    public final InstrumentClusterFunctions_ConfigurationOptions configurationOptions = new InstrumentClusterFunctions_ConfigurationOptions();

    public InstrumentClusterFunctions_Status() {
        this.internalReset();
        this.customInitialization();
    }

    public InstrumentClusterFunctions_Status(BitStream bitStream) {
        this();
        this.deserialize(bitStream);
    }

    private void internalReset() {
    }

    public void reset() {
        this.internalReset();
        this.configurationOptions.reset();
    }

    public boolean equalTo(BAPEntity bAPEntity) {
        InstrumentClusterFunctions_Status instrumentClusterFunctions_Status = (InstrumentClusterFunctions_Status)bAPEntity;
        return this.configurationOptions.equalTo(instrumentClusterFunctions_Status.configurationOptions);
    }

    private void customInitialization() {
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("InstrumentClusterFunctions_Status:");
        stringBuffer.append("\n - ConfigurationOptions - ");
        stringBuffer.append(this.configurationOptions.toString());
        return stringBuffer.toString();
    }

    public int bitSize() {
        int n = 0;
        return n += this.configurationOptions.bitSize();
    }

    public void serialize(BitStream bitStream) {
        this.configurationOptions.serialize(bitStream);
    }

    public void deserialize(BitStream bitStream) {
        this.configurationOptions.deserialize(bitStream);
    }

    public static int functionId() {
        return 16;
    }

    public int getFunctionId() {
        return InstrumentClusterFunctions_Status.functionId();
    }
}

