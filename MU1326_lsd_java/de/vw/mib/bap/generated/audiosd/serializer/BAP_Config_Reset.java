/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.generated.audiosd.serializer;

import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.stream.BitStream;

public final class BAP_Config_Reset
implements BAPEntity {
    public static final int BAP_VERSION_MAJOR_MIN = 3;
    public int bap_Version_major;
    private static final int BAP_VERSION_MAJOR_BITSIZE = 8;
    public static final int BAP_VERSION_MINOR_MIN = 0;
    public int bap_Version_minor;
    private static final int BAP_VERSION_MINOR_BITSIZE = 8;
    public static final int LSG_CLASS_MIN = 49;
    public int lsg_Class;
    private static final int LSG_CLASS_BITSIZE = 8;
    public static final int LSG_SUB_CLASS_MIN = 0;
    public int lsg_Sub_Class;
    private static final int LSG_SUB_CLASS_BITSIZE = 8;
    public static final int LSG_VERSION_MAJOR_MIN = 4;
    public int lsg_Version_major;
    private static final int LSG_VERSION_MAJOR_BITSIZE = 8;
    public static final int LSG_VERSION_MINOR_MIN = 4;
    public int lsg_Version_minor;
    private static final int LSG_VERSION_MINOR_BITSIZE = 8;

    public BAP_Config_Reset() {
        this.internalReset();
        this.customInitialization();
    }

    public BAP_Config_Reset(BitStream bitStream) {
        this();
        this.deserialize(bitStream);
    }

    private void internalReset() {
        this.bap_Version_major = 3;
        this.bap_Version_minor = 0;
        this.lsg_Class = 49;
        this.lsg_Sub_Class = 0;
        this.lsg_Version_major = 4;
        this.lsg_Version_minor = 4;
    }

    public void reset() {
        this.internalReset();
    }

    public boolean equalTo(BAPEntity bAPEntity) {
        BAP_Config_Reset bAP_Config_Reset = (BAP_Config_Reset)bAPEntity;
        return this.bap_Version_major == bAP_Config_Reset.bap_Version_major && this.bap_Version_minor == bAP_Config_Reset.bap_Version_minor && this.lsg_Class == bAP_Config_Reset.lsg_Class && this.lsg_Sub_Class == bAP_Config_Reset.lsg_Sub_Class && this.lsg_Version_major == bAP_Config_Reset.lsg_Version_major && this.lsg_Version_minor == bAP_Config_Reset.lsg_Version_minor;
    }

    private void customInitialization() {
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("BAP_Config_Reset:");
        stringBuffer.append("\n - BAP_Version_major - ");
        stringBuffer.append(this.bap_Version_major);
        stringBuffer.append("\n - BAP_Version_minor - ");
        stringBuffer.append(this.bap_Version_minor);
        stringBuffer.append("\n - LSG_Class - ");
        stringBuffer.append(this.lsg_Class);
        stringBuffer.append("\n - LSG_Sub_Class - ");
        stringBuffer.append(this.lsg_Sub_Class);
        stringBuffer.append("\n - LSG_Version_major - ");
        stringBuffer.append(this.lsg_Version_major);
        stringBuffer.append("\n - LSG_Version_minor - ");
        stringBuffer.append(this.lsg_Version_minor);
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
        bitStream.pushByte((byte)this.bap_Version_major);
        bitStream.pushByte((byte)this.bap_Version_minor);
        bitStream.pushByte((byte)this.lsg_Class);
        bitStream.pushByte((byte)this.lsg_Sub_Class);
        bitStream.pushByte((byte)this.lsg_Version_major);
        bitStream.pushByte((byte)this.lsg_Version_minor);
    }

    public void deserialize(BitStream bitStream) {
        this.bap_Version_major = bitStream.popFrontByte();
        this.bap_Version_minor = bitStream.popFrontByte();
        this.lsg_Class = bitStream.popFrontByte();
        this.lsg_Sub_Class = bitStream.popFrontByte();
        this.lsg_Version_major = bitStream.popFrontByte();
        this.lsg_Version_minor = bitStream.popFrontByte();
    }

    public static int functionId() {
        return 2;
    }

    public int getFunctionId() {
        return BAP_Config_Reset.functionId();
    }
}

