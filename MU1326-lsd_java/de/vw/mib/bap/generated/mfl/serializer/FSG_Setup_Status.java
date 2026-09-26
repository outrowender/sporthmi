/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.generated.mfl.serializer;

import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.generated.mfl.serializer.FSG_Setup_Status$InstalledKeys;
import de.vw.mib.bap.requests.StatusProperty;
import de.vw.mib.bap.stream.BitStream;

public final class FSG_Setup_Status
implements StatusProperty {
    public final FSG_Setup_Status$InstalledKeys installedKeys = new FSG_Setup_Status$InstalledKeys();

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

    @Override
    public void reset() {
        this.internalReset();
        this.installedKeys.reset();
    }

    @Override
    public boolean equalTo(BAPEntity bAPEntity) {
        FSG_Setup_Status fSG_Setup_Status = (FSG_Setup_Status)bAPEntity;
        return this.installedKeys.equalTo(fSG_Setup_Status.installedKeys);
    }

    private void customInitialization() {
    }

    @Override
    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("FSG_Setup_Status:");
        stringBuffer.append("\n - InstalledKeys - ");
        stringBuffer.append(this.installedKeys.toString());
        return stringBuffer.toString();
    }

    @Override
    public int bitSize() {
        int n = 0;
        return n += this.installedKeys.bitSize();
    }

    @Override
    public void serialize(BitStream bitStream) {
        this.installedKeys.serialize(bitStream);
    }

    @Override
    public void deserialize(BitStream bitStream) {
        this.installedKeys.deserialize(bitStream);
    }

    public static int functionId() {
        return 14;
    }

    @Override
    public int getFunctionId() {
        return FSG_Setup_Status.functionId();
    }
}

