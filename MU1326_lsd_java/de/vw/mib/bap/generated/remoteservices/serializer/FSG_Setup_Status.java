/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.generated.remoteservices.serializer;

import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.generated.remoteservices.serializer.FSG_Setup_Setup;
import de.vw.mib.bap.requests.StatusProperty;
import de.vw.mib.bap.stream.BitStream;

public final class FSG_Setup_Status
implements StatusProperty {
    public FSG_Setup_Setup setup = new FSG_Setup_Setup();

    public FSG_Setup_Status() {
        this.internalReset();
        this.customInitialization();
    }

    public FSG_Setup_Status(BitStream bitStream) {
        this();
        this.deserialize(bitStream);
    }

    private void internalReset() {
    }

    public void reset() {
        this.internalReset();
        this.setup.reset();
    }

    public boolean equalTo(BAPEntity bAPEntity) {
        FSG_Setup_Status fSG_Setup_Status = (FSG_Setup_Status)bAPEntity;
        return this.setup.equalTo(fSG_Setup_Status.setup);
    }

    private void customInitialization() {
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("FSG_Setup_Status");
        stringBuffer.append("\n - setup:").append(this.setup.toString());
        return stringBuffer.toString();
    }

    public int bitSize() {
        return 0;
    }

    public void serialize(BitStream bitStream) {
        this.setup.serialize(bitStream);
    }

    public void deserialize(BitStream bitStream) {
        this.setup.deserialize(bitStream);
    }

    public static int functionId() {
        return 14;
    }

    public int getFunctionId() {
        return FSG_Setup_Status.functionId();
    }
}

