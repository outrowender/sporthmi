/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.generated.telephone.serializer;

import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.datatypes.BAPString;
import de.vw.mib.bap.requests.StartResultMethod;
import de.vw.mib.bap.stream.BitStream;

public final class DialNumber_StartResult
implements StartResultMethod {
    public final BAPString telNumber = new BAPString(41);
    private static final int MAX_TEL_NUMBER_LENGTH = 41;
    public final BAPString name = new BAPString(150);
    private static final int MAX_NAME_LENGTH = 150;

    public DialNumber_StartResult() {
        this.internalReset();
        this.customInitialization();
    }

    public DialNumber_StartResult(BitStream bitStream) {
        this();
        this.deserialize(bitStream);
    }

    private void internalReset() {
    }

    public void reset() {
        this.internalReset();
        this.telNumber.reset();
        this.name.reset();
    }

    public boolean equalTo(BAPEntity bAPEntity) {
        DialNumber_StartResult dialNumber_StartResult = (DialNumber_StartResult)bAPEntity;
        return this.telNumber.equalTo(dialNumber_StartResult.telNumber) && this.name.equalTo(dialNumber_StartResult.name);
    }

    private void customInitialization() {
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("DialNumber_StartResult:");
        stringBuffer.append("\n - TelNumber - ");
        stringBuffer.append(this.telNumber.toString());
        stringBuffer.append("\n - Name - ");
        stringBuffer.append(this.name.toString());
        return stringBuffer.toString();
    }

    public int bitSize() {
        int n = 0;
        n += this.telNumber.bitSize();
        return n += this.name.bitSize();
    }

    public void serialize(BitStream bitStream) {
        this.telNumber.serialize(bitStream);
        this.name.serialize(bitStream);
    }

    public void deserialize(BitStream bitStream) {
        this.telNumber.deserialize(bitStream);
        this.name.deserialize(bitStream);
    }

    public static int functionId() {
        return 26;
    }

    public int getFunctionId() {
        return DialNumber_StartResult.functionId();
    }
}

