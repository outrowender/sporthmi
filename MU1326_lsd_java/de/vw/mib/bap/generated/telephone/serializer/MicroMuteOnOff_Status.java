/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.generated.telephone.serializer;

import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.generated.telephone.serializer.MicroMuteOnOff_MicroMuteOnOff;
import de.vw.mib.bap.requests.StatusProperty;
import de.vw.mib.bap.stream.BitStream;

public final class MicroMuteOnOff_Status
implements StatusProperty {
    public final MicroMuteOnOff_MicroMuteOnOff microMuteOnOff = new MicroMuteOnOff_MicroMuteOnOff();

    public MicroMuteOnOff_Status() {
        this.internalReset();
        this.customInitialization();
    }

    public MicroMuteOnOff_Status(BitStream bitStream) {
        this();
        this.deserialize(bitStream);
    }

    private void internalReset() {
    }

    public void reset() {
        this.internalReset();
        this.microMuteOnOff.reset();
    }

    public boolean equalTo(BAPEntity bAPEntity) {
        MicroMuteOnOff_Status microMuteOnOff_Status = (MicroMuteOnOff_Status)bAPEntity;
        return this.microMuteOnOff.equalTo(microMuteOnOff_Status.microMuteOnOff);
    }

    private void customInitialization() {
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("MicroMuteOnOff_Status:");
        stringBuffer.append("\n - MicroMuteOnOff - ");
        stringBuffer.append(this.microMuteOnOff.toString());
        return stringBuffer.toString();
    }

    public int bitSize() {
        int n = 0;
        return n += this.microMuteOnOff.bitSize();
    }

    public void serialize(BitStream bitStream) {
        this.microMuteOnOff.serialize(bitStream);
    }

    public void deserialize(BitStream bitStream) {
        this.microMuteOnOff.deserialize(bitStream);
    }

    public static int functionId() {
        return 34;
    }

    public int getFunctionId() {
        return MicroMuteOnOff_Status.functionId();
    }
}

