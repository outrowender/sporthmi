/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.generated.mfl.serializer;

import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.generated.mfl.serializer.InstrumentClusterFunctions_ConfigurationOptions;
import de.vw.mib.bap.requests.SetGetProperty;
import de.vw.mib.bap.stream.BitStream;

public final class InstrumentClusterFunctions_SetGet
implements SetGetProperty {
    public final InstrumentClusterFunctions_ConfigurationOptions configurationOptions = new InstrumentClusterFunctions_ConfigurationOptions();

    public InstrumentClusterFunctions_SetGet() {
        this.internalReset();
        this.customInitialization();
    }

    public InstrumentClusterFunctions_SetGet(BitStream bitStream) {
        this();
        this.deserialize(bitStream);
    }

    private void internalReset() {
    }

    @Override
    public void reset() {
        this.internalReset();
        this.configurationOptions.reset();
    }

    @Override
    public boolean equalTo(BAPEntity bAPEntity) {
        InstrumentClusterFunctions_SetGet instrumentClusterFunctions_SetGet = (InstrumentClusterFunctions_SetGet)bAPEntity;
        return this.configurationOptions.equalTo(instrumentClusterFunctions_SetGet.configurationOptions);
    }

    private void customInitialization() {
    }

    @Override
    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("InstrumentClusterFunctions_SetGet:");
        stringBuffer.append("\n - ConfigurationOptions - ");
        stringBuffer.append(this.configurationOptions.toString());
        return stringBuffer.toString();
    }

    @Override
    public int bitSize() {
        int n = 0;
        return n += this.configurationOptions.bitSize();
    }

    @Override
    public void serialize(BitStream bitStream) {
        this.configurationOptions.serialize(bitStream);
    }

    @Override
    public void deserialize(BitStream bitStream) {
        this.configurationOptions.deserialize(bitStream);
    }

    public static int functionId() {
        return 16;
    }

    @Override
    public int getFunctionId() {
        return InstrumentClusterFunctions_SetGet.functionId();
    }
}

