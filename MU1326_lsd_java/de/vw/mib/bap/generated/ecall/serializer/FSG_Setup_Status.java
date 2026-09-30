/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.generated.ecall.serializer;

import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.generated.ecall.serializer.FSG_Setup_GeneralSettings;
import de.vw.mib.bap.requests.StatusProperty;
import de.vw.mib.bap.stream.BitStream;

public final class FSG_Setup_Status
implements StatusProperty {
    public FSG_Setup_GeneralSettings generalSettings = new FSG_Setup_GeneralSettings();
    public int extension2;
    public static final int EXTENSION2_MIN = 0;
    public int extension3;
    public static final int EXTENSION3_MIN = 0;

    public FSG_Setup_Status() {
        this.internalReset();
        this.customInitialization();
    }

    public FSG_Setup_Status(BitStream bitStream) {
        this();
        this.deserialize(bitStream);
    }

    private void internalReset() {
        this.extension2 = 0;
        this.extension3 = 0;
    }

    public void reset() {
        this.internalReset();
        this.generalSettings.reset();
    }

    public boolean equalTo(BAPEntity bAPEntity) {
        FSG_Setup_Status fSG_Setup_Status = (FSG_Setup_Status)bAPEntity;
        return this.generalSettings.equalTo(fSG_Setup_Status.generalSettings) && this.extension2 == fSG_Setup_Status.extension2 && this.extension3 == fSG_Setup_Status.extension3;
    }

    private void customInitialization() {
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("FSG_Setup_Status");
        stringBuffer.append("\n - generalSettings:").append(this.generalSettings.toString());
        stringBuffer.append("\n - extension2:").append(this.extension2);
        stringBuffer.append("\n - extension3:").append(this.extension3);
        return stringBuffer.toString();
    }

    public int bitSize() {
        return 0;
    }

    public void serialize(BitStream bitStream) {
        this.generalSettings.serialize(bitStream);
        bitStream.pushByte((byte)this.extension2);
        bitStream.pushByte((byte)this.extension3);
    }

    public void deserialize(BitStream bitStream) {
        this.generalSettings.deserialize(bitStream);
        this.extension2 = bitStream.popFrontByte();
        this.extension3 = bitStream.popFrontByte();
    }

    public static int functionId() {
        return 14;
    }

    public int getFunctionId() {
        return FSG_Setup_Status.functionId();
    }
}

