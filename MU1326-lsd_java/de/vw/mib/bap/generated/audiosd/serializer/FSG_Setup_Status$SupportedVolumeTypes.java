/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.generated.audiosd.serializer;

import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.stream.BitStream;

public final class FSG_Setup_Status$SupportedVolumeTypes
implements BAPEntity {
    public boolean readMessageVolumeAvailable;
    public boolean carParkingFaderAvailable;
    public boolean phoneRingingVolumeAvailable;
    public boolean sdsVolumeAvailable;
    public boolean phoneVolumeAvailable;
    public boolean announcementVolumeAvailable;
    public boolean navigationVolumeAvailable;
    public boolean entertainmentVolumeAvaiblable;
    private static final int SUPPORTED_VOLUME_TYPES_BITSIZE;

    public FSG_Setup_Status$SupportedVolumeTypes() {
        this.internalReset();
        this.customInitialization();
    }

    public FSG_Setup_Status$SupportedVolumeTypes(BitStream bitStream) {
        this();
        this.deserialize(bitStream);
    }

    private void internalReset() {
        this.readMessageVolumeAvailable = false;
        this.carParkingFaderAvailable = false;
        this.phoneRingingVolumeAvailable = false;
        this.sdsVolumeAvailable = false;
        this.phoneVolumeAvailable = false;
        this.announcementVolumeAvailable = false;
        this.navigationVolumeAvailable = false;
        this.entertainmentVolumeAvaiblable = false;
    }

    @Override
    public void reset() {
        this.internalReset();
    }

    @Override
    public boolean equalTo(BAPEntity bAPEntity) {
        FSG_Setup_Status$SupportedVolumeTypes fSG_Setup_Status$SupportedVolumeTypes = (FSG_Setup_Status$SupportedVolumeTypes)bAPEntity;
        return this.readMessageVolumeAvailable == fSG_Setup_Status$SupportedVolumeTypes.readMessageVolumeAvailable && this.carParkingFaderAvailable == fSG_Setup_Status$SupportedVolumeTypes.carParkingFaderAvailable && this.phoneRingingVolumeAvailable == fSG_Setup_Status$SupportedVolumeTypes.phoneRingingVolumeAvailable && this.sdsVolumeAvailable == fSG_Setup_Status$SupportedVolumeTypes.sdsVolumeAvailable && this.phoneVolumeAvailable == fSG_Setup_Status$SupportedVolumeTypes.phoneVolumeAvailable && this.announcementVolumeAvailable == fSG_Setup_Status$SupportedVolumeTypes.announcementVolumeAvailable && this.navigationVolumeAvailable == fSG_Setup_Status$SupportedVolumeTypes.navigationVolumeAvailable && this.entertainmentVolumeAvaiblable == fSG_Setup_Status$SupportedVolumeTypes.entertainmentVolumeAvaiblable;
    }

    private void customInitialization() {
    }

    @Override
    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("SupportedVolumeTypes:");
        stringBuffer.append("\n - Bit 7: ");
        if (this.readMessageVolumeAvailable) {
            stringBuffer.append("true  (read message volume available (DF4.1)");
        } else {
            stringBuffer.append("false  (read message volume n/a (DF4.11)");
        }
        stringBuffer.append("\n - Bit 6: ");
        if (this.carParkingFaderAvailable) {
            stringBuffer.append("true  (car parking fader available (DF4.1)");
        } else {
            stringBuffer.append("false  (car parking fader n/a (DF4.1)");
        }
        stringBuffer.append("\n - Bit 5: ");
        if (this.phoneRingingVolumeAvailable) {
            stringBuffer.append("true  (phone ringing volume available (DF4.1)");
        } else {
            stringBuffer.append("false  (phone ringing volume n/a (DF4.11)");
        }
        stringBuffer.append("\n - Bit 4: ");
        if (this.sdsVolumeAvailable) {
            stringBuffer.append("true  (SDS volume available");
        } else {
            stringBuffer.append("false  (SDS volume n/a");
        }
        stringBuffer.append("\n - Bit 3: ");
        if (this.phoneVolumeAvailable) {
            stringBuffer.append("true  (phone volume available");
        } else {
            stringBuffer.append("false  (phone volume n/a");
        }
        stringBuffer.append("\n - Bit 2: ");
        if (this.announcementVolumeAvailable) {
            stringBuffer.append("true  (announcement volume (TA volume) available");
        } else {
            stringBuffer.append("false  (announcement volume (TA volume) n/a");
        }
        stringBuffer.append("\n - Bit 1: ");
        if (this.navigationVolumeAvailable) {
            stringBuffer.append("true  (navigation volume available");
        } else {
            stringBuffer.append("false  (navigation volume n/a");
        }
        stringBuffer.append("\n - Bit 0: ");
        if (this.entertainmentVolumeAvaiblable) {
            stringBuffer.append("true  (entertainment volume avaiblable");
        } else {
            stringBuffer.append("false  (entertainment volume n/a");
        }
        return stringBuffer.toString();
    }

    @Override
    public int bitSize() {
        int n = 0;
        return n += 8;
    }

    @Override
    public void serialize(BitStream bitStream) {
        bitStream.pushBoolean(this.readMessageVolumeAvailable);
        bitStream.pushBoolean(this.carParkingFaderAvailable);
        bitStream.pushBoolean(this.phoneRingingVolumeAvailable);
        bitStream.pushBoolean(this.sdsVolumeAvailable);
        bitStream.pushBoolean(this.phoneVolumeAvailable);
        bitStream.pushBoolean(this.announcementVolumeAvailable);
        bitStream.pushBoolean(this.navigationVolumeAvailable);
        bitStream.pushBoolean(this.entertainmentVolumeAvaiblable);
    }

    @Override
    public void deserialize(BitStream bitStream) {
        this.readMessageVolumeAvailable = bitStream.popFrontBoolean();
        this.carParkingFaderAvailable = bitStream.popFrontBoolean();
        this.phoneRingingVolumeAvailable = bitStream.popFrontBoolean();
        this.sdsVolumeAvailable = bitStream.popFrontBoolean();
        this.phoneVolumeAvailable = bitStream.popFrontBoolean();
        this.announcementVolumeAvailable = bitStream.popFrontBoolean();
        this.navigationVolumeAvailable = bitStream.popFrontBoolean();
        this.entertainmentVolumeAvaiblable = bitStream.popFrontBoolean();
    }
}

