/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.generated.telephone.serializer;

import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.generated.telephone.serializer.FSG_Setup_Status$PhoneCharacteristics;
import de.vw.mib.bap.requests.StatusProperty;
import de.vw.mib.bap.stream.BitStream;

public final class FSG_Setup_Status
implements StatusProperty {
    public final FSG_Setup_Status$PhoneCharacteristics phoneCharacteristics = new FSG_Setup_Status$PhoneCharacteristics();
    public int mobileConnectionType;
    private static final int MOBILE_CONNECTION_TYPE_BITSIZE;
    public static final int MOBILE_CONNECTION_TYPE_NO_CONNECTION;
    public static final int MOBILE_CONNECTION_TYPE_INTERNAL_SIM_CARD_READER;
    public static final int MOBILE_CONNECTION_TYPE_CABLE_CONNECTION;
    public static final int MOBILE_CONNECTION_TYPE_HANDS_FREE_PROFILE;
    public static final int MOBILE_CONNECTION_TYPE_REMOTE_SIM_ACCESS_PROFILE;
    public static final int MOBILE_CONNECTION_TYPE_APPLE_LINK_DF4_2;
    public static final int MOBILE_CONNECTION_TYPE_GOOGLE_LINK_DF4_2;
    public static final int MOBILE_CONNECTION_TYPE_BAIDU_LINK_DF4_3;

    public FSG_Setup_Status() {
        this.internalReset();
        this.customInitialization();
    }

    public FSG_Setup_Status(BitStream bitStream) {
        this();
        this.deserialize(bitStream);
    }

    private void internalReset() {
        this.mobileConnectionType = 0;
    }

    @Override
    public void reset() {
        this.internalReset();
        this.phoneCharacteristics.reset();
    }

    @Override
    public boolean equalTo(BAPEntity bAPEntity) {
        FSG_Setup_Status fSG_Setup_Status = (FSG_Setup_Status)bAPEntity;
        return this.phoneCharacteristics.equalTo(fSG_Setup_Status.phoneCharacteristics) && this.mobileConnectionType == fSG_Setup_Status.mobileConnectionType;
    }

    private void customInitialization() {
    }

    @Override
    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("FSG_Setup_Status:");
        stringBuffer.append("\n - PhoneCharacteristics - ");
        stringBuffer.append(this.phoneCharacteristics.toString());
        stringBuffer.append("\n - MobileConnectionType: ");
        switch (this.mobileConnectionType) {
            case 0: {
                stringBuffer.append("0x00 (NoConnection)");
                break;
            }
            case 1: {
                stringBuffer.append("0x01 (InternalSIMCardReader)");
                break;
            }
            case 2: {
                stringBuffer.append("0x02 (CableConnection)");
                break;
            }
            case 3: {
                stringBuffer.append("0x03 (HandsFreeProfile)");
                break;
            }
            case 4: {
                stringBuffer.append("0x04 (RemoteSIMAccessProfile)");
                break;
            }
            case 5: {
                stringBuffer.append("0x05 (AppleLink (DF4.2))");
                break;
            }
            case 6: {
                stringBuffer.append("0x06 (GoogleLink (DF4.2))");
                break;
            }
            case 7: {
                stringBuffer.append("0x07 (BaiduLink (DF4.3))");
                break;
            }
            default: {
                stringBuffer.append("UNKNOWN ENUM");
            }
        }
        return stringBuffer.toString();
    }

    @Override
    public int bitSize() {
        int n = 0;
        n += this.phoneCharacteristics.bitSize();
        return n += 8;
    }

    @Override
    public void serialize(BitStream bitStream) {
        this.phoneCharacteristics.serialize(bitStream);
        bitStream.pushByte((byte)this.mobileConnectionType);
    }

    @Override
    public void deserialize(BitStream bitStream) {
        this.phoneCharacteristics.deserialize(bitStream);
        this.mobileConnectionType = bitStream.popFrontByte();
    }

    public static int functionId() {
        return 14;
    }

    @Override
    public int getFunctionId() {
        return FSG_Setup_Status.functionId();
    }
}

