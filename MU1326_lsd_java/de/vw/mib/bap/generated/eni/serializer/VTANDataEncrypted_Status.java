/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.generated.eni.serializer;

import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.datatypes.BAPString;
import de.vw.mib.bap.requests.StatusProperty;
import de.vw.mib.bap.stream.BitStream;

public final class VTANDataEncrypted_Status
implements StatusProperty {
    public final BAPString vtandataEncrypted = new BAPString(700);
    private static final int MAX_VTANDATAENCRYPTED_LENGTH = 700;

    public VTANDataEncrypted_Status() {
        this.internalReset();
        this.customInitialization();
    }

    public VTANDataEncrypted_Status(BitStream bitStream) {
        this();
        this.deserialize(bitStream);
    }

    private void internalReset() {
    }

    public void reset() {
        this.internalReset();
        this.vtandataEncrypted.reset();
    }

    public boolean equalTo(BAPEntity bAPEntity) {
        VTANDataEncrypted_Status vTANDataEncrypted_Status = (VTANDataEncrypted_Status)bAPEntity;
        return this.vtandataEncrypted.equalTo(vTANDataEncrypted_Status.vtandataEncrypted);
    }

    private void customInitialization() {
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("VTANDataEncrypted_Status");
        stringBuffer.append("\n - vtandataEncrypted:" + this.vtandataEncrypted.toString());
        return stringBuffer.toString();
    }

    public int bitSize() {
        return 0;
    }

    public void serialize(BitStream bitStream) {
        this.vtandataEncrypted.serialize(bitStream);
    }

    public void deserialize(BitStream bitStream) {
        this.vtandataEncrypted.deserialize(bitStream);
    }

    public static int functionId() {
        return 27;
    }

    public int getFunctionId() {
        return VTANDataEncrypted_Status.functionId();
    }
}

