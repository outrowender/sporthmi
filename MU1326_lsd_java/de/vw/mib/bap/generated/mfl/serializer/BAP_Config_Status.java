/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.generated.mfl.serializer;

import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.requests.StatusProperty;
import de.vw.mib.bap.stream.BitStream;

public final class BAP_Config_Status
implements StatusProperty {
    public static final int BAP_VERSION_MAJOR_MIN = 3;
    public int bap_VersionMajor;
    private static final int BAP_VERSION_MAJOR_BITSIZE = 8;
    public static final int BAP_VERSION_MINOR_MIN = 1;
    public int bap_VersionMinor;
    private static final int BAP_VERSION_MINOR_BITSIZE = 8;
    public static final int LSG_CLASS_MIN = 52;
    public int lsg_Class;
    private static final int LSG_CLASS_BITSIZE = 8;
    public static final int LSG_SUB_CLASS_MIN = 0;
    public int lsg_SubClass;
    private static final int LSG_SUB_CLASS_BITSIZE = 8;
    public static final int LSG_VERSION_MAJOR_MIN = 3;
    public int lsg_VersionMajor;
    private static final int LSG_VERSION_MAJOR_BITSIZE = 8;
    public static final int LSG_VERSION_MINOR_MIN = 3;
    public int lsg_VersionMinor;
    private static final int LSG_VERSION_MINOR_BITSIZE = 8;

    public BAP_Config_Status() {
        this.internalReset();
        this.customInitialization();
    }

    public BAP_Config_Status(BitStream bitStream) {
        this();
        this.deserialize(bitStream);
    }

    private void internalReset() {
        this.bap_VersionMajor = 3;
        this.bap_VersionMinor = 1;
        this.lsg_Class = 52;
        this.lsg_SubClass = 0;
        this.lsg_VersionMajor = 3;
        this.lsg_VersionMinor = 3;
    }

    public void reset() {
        this.internalReset();
    }

    public boolean equalTo(BAPEntity bAPEntity) {
        BAP_Config_Status bAP_Config_Status = (BAP_Config_Status)bAPEntity;
        return this.bap_VersionMajor == bAP_Config_Status.bap_VersionMajor && this.bap_VersionMinor == bAP_Config_Status.bap_VersionMinor && this.lsg_Class == bAP_Config_Status.lsg_Class && this.lsg_SubClass == bAP_Config_Status.lsg_SubClass && this.lsg_VersionMajor == bAP_Config_Status.lsg_VersionMajor && this.lsg_VersionMinor == bAP_Config_Status.lsg_VersionMinor;
    }

    private void customInitialization() {
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("BAP_Config_Status:");
        stringBuffer.append("\n - BAP_VersionMajor - ");
        stringBuffer.append(this.bap_VersionMajor);
        stringBuffer.append("\n - BAP_VersionMinor - ");
        stringBuffer.append(this.bap_VersionMinor);
        stringBuffer.append("\n - LSG_Class - ");
        stringBuffer.append(this.lsg_Class);
        stringBuffer.append("\n - LSG_SubClass - ");
        stringBuffer.append(this.lsg_SubClass);
        stringBuffer.append("\n - LSG_VersionMajor - ");
        stringBuffer.append(this.lsg_VersionMajor);
        stringBuffer.append("\n - LSG_VersionMinor - ");
        stringBuffer.append(this.lsg_VersionMinor);
        return stringBuffer.toString();
    }

    public int bitSize() {
        int n = 0;
        n += 8;
        n += 8;
        n += 8;
        n += 8;
        n += 8;
        return n += 8;
    }

    public void serialize(BitStream bitStream) {
        bitStream.pushByte((byte)this.bap_VersionMajor);
        bitStream.pushByte((byte)this.bap_VersionMinor);
        bitStream.pushByte((byte)this.lsg_Class);
        bitStream.pushByte((byte)this.lsg_SubClass);
        bitStream.pushByte((byte)this.lsg_VersionMajor);
        bitStream.pushByte((byte)this.lsg_VersionMinor);
    }

    public void deserialize(BitStream bitStream) {
        this.bap_VersionMajor = bitStream.popFrontByte();
        this.bap_VersionMinor = bitStream.popFrontByte();
        this.lsg_Class = bitStream.popFrontByte();
        this.lsg_SubClass = bitStream.popFrontByte();
        this.lsg_VersionMajor = bitStream.popFrontByte();
        this.lsg_VersionMinor = bitStream.popFrontByte();
    }

    public static int functionId() {
        return 2;
    }

    public int getFunctionId() {
        return BAP_Config_Status.functionId();
    }
}

