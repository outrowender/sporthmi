/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.generated.audiosd.serializer;

import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.generated.audiosd.serializer.GeneralInfoSwitches_OnOffSwitches;
import de.vw.mib.bap.requests.SetGetProperty;
import de.vw.mib.bap.stream.BitStream;

public final class GeneralInfoSwitches_SetGet
implements SetGetProperty {
    public final GeneralInfoSwitches_OnOffSwitches onOffSwitches = new GeneralInfoSwitches_OnOffSwitches();
    public int reserve1;
    private static final int RESERVE1_BITSIZE = 8;

    public GeneralInfoSwitches_SetGet() {
        this.internalReset();
        this.customInitialization();
    }

    public GeneralInfoSwitches_SetGet(BitStream bitStream) {
        this();
        this.deserialize(bitStream);
    }

    private void internalReset() {
        this.reserve1 = 0;
    }

    public void reset() {
        this.internalReset();
        this.onOffSwitches.reset();
    }

    public boolean equalTo(BAPEntity bAPEntity) {
        GeneralInfoSwitches_SetGet generalInfoSwitches_SetGet = (GeneralInfoSwitches_SetGet)bAPEntity;
        return this.onOffSwitches.equalTo(generalInfoSwitches_SetGet.onOffSwitches) && this.reserve1 == generalInfoSwitches_SetGet.reserve1;
    }

    private void customInitialization() {
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("GeneralInfoSwitches_SetGet:");
        stringBuffer.append("\n - OnOffSwitches - ");
        stringBuffer.append(this.onOffSwitches.toString());
        stringBuffer.append("\n - Reserve1 - ");
        stringBuffer.append(this.reserve1);
        return stringBuffer.toString();
    }

    public int bitSize() {
        int n = 0;
        n += this.onOffSwitches.bitSize();
        return n += 8;
    }

    public void serialize(BitStream bitStream) {
        this.onOffSwitches.serialize(bitStream);
        bitStream.pushByte((byte)this.reserve1);
    }

    public void deserialize(BitStream bitStream) {
        this.onOffSwitches.deserialize(bitStream);
        this.reserve1 = bitStream.popFrontByte();
    }

    public static int functionId() {
        return 25;
    }

    public int getFunctionId() {
        return GeneralInfoSwitches_SetGet.functionId();
    }
}

