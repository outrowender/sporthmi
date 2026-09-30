/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.generated.audiosd.serializer;

import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.requests.StatusProperty;
import de.vw.mib.bap.stream.BitStream;

public final class FSG_Setup_Status
implements StatusProperty {
    public int maxVolume;
    private static final int MAX_VOLUME_BITSIZE = 8;
    public final SupportedVolumeTypes supportedVolumeTypes = new SupportedVolumeTypes();
    public final ReceptionList_AutoUpdate receptionList_AutoUpdate = new ReceptionList_AutoUpdate();
    public final Setup_Extensions setup_Extensions = new Setup_Extensions();

    public FSG_Setup_Status() {
        this.internalReset();
        this.customInitialization();
    }

    public FSG_Setup_Status(BitStream bitStream) {
        this();
        this.deserialize(bitStream);
    }

    private void internalReset() {
        this.maxVolume = 0;
    }

    public void reset() {
        this.internalReset();
        this.supportedVolumeTypes.reset();
        this.receptionList_AutoUpdate.reset();
        this.setup_Extensions.reset();
    }

    public boolean equalTo(BAPEntity bAPEntity) {
        FSG_Setup_Status fSG_Setup_Status = (FSG_Setup_Status)bAPEntity;
        return this.maxVolume == fSG_Setup_Status.maxVolume && this.supportedVolumeTypes.equalTo(fSG_Setup_Status.supportedVolumeTypes) && this.receptionList_AutoUpdate.equalTo(fSG_Setup_Status.receptionList_AutoUpdate) && this.setup_Extensions.equalTo(fSG_Setup_Status.setup_Extensions);
    }

    private void customInitialization() {
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("FSG_Setup_Status:");
        stringBuffer.append("\n - maxVolume - ");
        stringBuffer.append(this.maxVolume);
        stringBuffer.append("\n - supportedVolumeTypes - ");
        stringBuffer.append(this.supportedVolumeTypes.toString());
        stringBuffer.append("\n - ReceptionList_AutoUpdate - ");
        stringBuffer.append(this.receptionList_AutoUpdate.toString());
        stringBuffer.append("\n - Setup_Extensions - ");
        stringBuffer.append(this.setup_Extensions.toString());
        return stringBuffer.toString();
    }

    public int bitSize() {
        int n = 0;
        n += 8;
        n += this.supportedVolumeTypes.bitSize();
        n += this.receptionList_AutoUpdate.bitSize();
        return n += this.setup_Extensions.bitSize();
    }

    public void serialize(BitStream bitStream) {
        bitStream.pushByte((byte)this.maxVolume);
        this.supportedVolumeTypes.serialize(bitStream);
        this.receptionList_AutoUpdate.serialize(bitStream);
        this.setup_Extensions.serialize(bitStream);
    }

    public void deserialize(BitStream bitStream) {
        this.maxVolume = bitStream.popFrontByte();
        this.supportedVolumeTypes.deserialize(bitStream);
        this.receptionList_AutoUpdate.deserialize(bitStream);
        this.setup_Extensions.deserialize(bitStream);
    }

    public static int functionId() {
        return 14;
    }

    public int getFunctionId() {
        return FSG_Setup_Status.functionId();
    }

    public static final class Setup_Extensions
    implements BAPEntity {
        private static final int RESERVED_BIT_2__7_BITSIZE = 6;
        public boolean commonListIsAutomaticallyUpdated;
        public boolean dabServiceSortedList;
        private static final int SETUP_EXTENSIONS_BITSIZE = 8;

        public Setup_Extensions() {
            this.internalReset();
            this.customInitialization();
        }

        public Setup_Extensions(BitStream bitStream) {
            this();
            this.deserialize(bitStream);
        }

        private void internalReset() {
            this.commonListIsAutomaticallyUpdated = false;
            this.dabServiceSortedList = false;
        }

        public void reset() {
            this.internalReset();
        }

        public boolean equalTo(BAPEntity bAPEntity) {
            Setup_Extensions setup_Extensions = (Setup_Extensions)bAPEntity;
            return this.commonListIsAutomaticallyUpdated == setup_Extensions.commonListIsAutomaticallyUpdated && this.dabServiceSortedList == setup_Extensions.dabServiceSortedList;
        }

        private void customInitialization() {
        }

        public String toString() {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("Setup_Extensions:");
            stringBuffer.append("\n - Bit 1: ");
            if (this.commonListIsAutomaticallyUpdated) {
                stringBuffer.append("true  (CommonList is automatically updated (DF4.1)");
            } else {
                stringBuffer.append("false  (CommonList is NOT automatically updated (DF4.1)");
            }
            stringBuffer.append("\n - Bit 0: ");
            if (this.dabServiceSortedList) {
                stringBuffer.append("true  (DAB service sorted list");
            } else {
                stringBuffer.append("false  (DAB ensemble sorted list");
            }
            return stringBuffer.toString();
        }

        public int bitSize() {
            int n = 0;
            return n += 8;
        }

        public void serialize(BitStream bitStream) {
            bitStream.resetBits(6);
            bitStream.pushBoolean(this.commonListIsAutomaticallyUpdated);
            bitStream.pushBoolean(this.dabServiceSortedList);
        }

        public void deserialize(BitStream bitStream) {
            bitStream.discardBits(6);
            this.commonListIsAutomaticallyUpdated = bitStream.popFrontBoolean();
            this.dabServiceSortedList = bitStream.popFrontBoolean();
        }
    }

    public static final class SupportedVolumeTypes
    implements BAPEntity {
        public boolean readMessageVolumeAvailable;
        public boolean carParkingFaderAvailable;
        public boolean phoneRingingVolumeAvailable;
        public boolean sdsVolumeAvailable;
        public boolean phoneVolumeAvailable;
        public boolean announcementVolumeAvailable;
        public boolean navigationVolumeAvailable;
        public boolean entertainmentVolumeAvaiblable;
        private static final int SUPPORTED_VOLUME_TYPES_BITSIZE = 8;

        public SupportedVolumeTypes() {
            this.internalReset();
            this.customInitialization();
        }

        public SupportedVolumeTypes(BitStream bitStream) {
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

        public void reset() {
            this.internalReset();
        }

        public boolean equalTo(BAPEntity bAPEntity) {
            SupportedVolumeTypes supportedVolumeTypes = (SupportedVolumeTypes)bAPEntity;
            return this.readMessageVolumeAvailable == supportedVolumeTypes.readMessageVolumeAvailable && this.carParkingFaderAvailable == supportedVolumeTypes.carParkingFaderAvailable && this.phoneRingingVolumeAvailable == supportedVolumeTypes.phoneRingingVolumeAvailable && this.sdsVolumeAvailable == supportedVolumeTypes.sdsVolumeAvailable && this.phoneVolumeAvailable == supportedVolumeTypes.phoneVolumeAvailable && this.announcementVolumeAvailable == supportedVolumeTypes.announcementVolumeAvailable && this.navigationVolumeAvailable == supportedVolumeTypes.navigationVolumeAvailable && this.entertainmentVolumeAvaiblable == supportedVolumeTypes.entertainmentVolumeAvaiblable;
        }

        private void customInitialization() {
        }

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

        public int bitSize() {
            int n = 0;
            return n += 8;
        }

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

    public static final class ReceptionList_AutoUpdate
    implements BAPEntity {
        public boolean onlineRadioReceptionListIsAutomaticallyUpdated;
        public boolean tvDvbReceptionListIsAutomaticallyUpdated;
        public boolean amSwReceptionListIsAutomaticallyUpdated;
        public boolean amLwReceptionListIsAutomaticallyUpdated;
        public boolean sdarsReceptionListIsAutomaticallyUpdated;
        public boolean dabReceptionListIsAutomaticallyUpdated;
        public boolean amReceptionListIsAutomaticallyUpdated;
        public boolean fmReceptionListIsAutomaticallyUpdated;
        private static final int RECEPTION_LIST_AUTO_UPDATE_BITSIZE = 8;

        public ReceptionList_AutoUpdate() {
            this.internalReset();
            this.customInitialization();
        }

        public ReceptionList_AutoUpdate(BitStream bitStream) {
            this();
            this.deserialize(bitStream);
        }

        private void internalReset() {
            this.onlineRadioReceptionListIsAutomaticallyUpdated = false;
            this.tvDvbReceptionListIsAutomaticallyUpdated = false;
            this.amSwReceptionListIsAutomaticallyUpdated = false;
            this.amLwReceptionListIsAutomaticallyUpdated = false;
            this.sdarsReceptionListIsAutomaticallyUpdated = false;
            this.dabReceptionListIsAutomaticallyUpdated = false;
            this.amReceptionListIsAutomaticallyUpdated = false;
            this.fmReceptionListIsAutomaticallyUpdated = false;
        }

        public void reset() {
            this.internalReset();
        }

        public boolean equalTo(BAPEntity bAPEntity) {
            ReceptionList_AutoUpdate receptionList_AutoUpdate = (ReceptionList_AutoUpdate)bAPEntity;
            return this.onlineRadioReceptionListIsAutomaticallyUpdated == receptionList_AutoUpdate.onlineRadioReceptionListIsAutomaticallyUpdated && this.tvDvbReceptionListIsAutomaticallyUpdated == receptionList_AutoUpdate.tvDvbReceptionListIsAutomaticallyUpdated && this.amSwReceptionListIsAutomaticallyUpdated == receptionList_AutoUpdate.amSwReceptionListIsAutomaticallyUpdated && this.amLwReceptionListIsAutomaticallyUpdated == receptionList_AutoUpdate.amLwReceptionListIsAutomaticallyUpdated && this.sdarsReceptionListIsAutomaticallyUpdated == receptionList_AutoUpdate.sdarsReceptionListIsAutomaticallyUpdated && this.dabReceptionListIsAutomaticallyUpdated == receptionList_AutoUpdate.dabReceptionListIsAutomaticallyUpdated && this.amReceptionListIsAutomaticallyUpdated == receptionList_AutoUpdate.amReceptionListIsAutomaticallyUpdated && this.fmReceptionListIsAutomaticallyUpdated == receptionList_AutoUpdate.fmReceptionListIsAutomaticallyUpdated;
        }

        private void customInitialization() {
        }

        public String toString() {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("ReceptionList_AutoUpdate:");
            stringBuffer.append("\n - Bit 7: ");
            if (this.onlineRadioReceptionListIsAutomaticallyUpdated) {
                stringBuffer.append("true  (online radio reception list is automatically updated (DF4.1)");
            } else {
                stringBuffer.append("false  (online radio reception list is NOT automatically updated (DF4.1)");
            }
            stringBuffer.append("\n - Bit 6: ");
            if (this.tvDvbReceptionListIsAutomaticallyUpdated) {
                stringBuffer.append("true  (TV / DVB  reception list is automatically updated");
            } else {
                stringBuffer.append("false  (TV / DVB reception list is NOT automatically updated");
            }
            stringBuffer.append("\n - Bit 5: ");
            if (this.amSwReceptionListIsAutomaticallyUpdated) {
                stringBuffer.append("true  (AM-SW reception list is automatically updated");
            } else {
                stringBuffer.append("false  (AM-SW reception list is NOT automatically updated");
            }
            stringBuffer.append("\n - Bit 4: ");
            if (this.amLwReceptionListIsAutomaticallyUpdated) {
                stringBuffer.append("true  (AM-LW  reception list is automatically updated");
            } else {
                stringBuffer.append("false  (AM-LW reception list is NOT automatically updated");
            }
            stringBuffer.append("\n - Bit 3: ");
            if (this.sdarsReceptionListIsAutomaticallyUpdated) {
                stringBuffer.append("true  (SDARS reception list is automatically updated");
            } else {
                stringBuffer.append("false  (SDARS reception list is NOT automatically updated");
            }
            stringBuffer.append("\n - Bit 2: ");
            if (this.dabReceptionListIsAutomaticallyUpdated) {
                stringBuffer.append("true  (DAB reception list is automatically updated");
            } else {
                stringBuffer.append("false  (DAB reception list is NOT automatically updated");
            }
            stringBuffer.append("\n - Bit 1: ");
            if (this.amReceptionListIsAutomaticallyUpdated) {
                stringBuffer.append("true  (AM reception list is automatically updated");
            } else {
                stringBuffer.append("false  (AM reception list is NOT automatically updated");
            }
            stringBuffer.append("\n - Bit 0: ");
            if (this.fmReceptionListIsAutomaticallyUpdated) {
                stringBuffer.append("true  (FM reception list is automatically updated");
            } else {
                stringBuffer.append("false  (FM reception list is NOT automatically updated");
            }
            return stringBuffer.toString();
        }

        public int bitSize() {
            int n = 0;
            return n += 8;
        }

        public void serialize(BitStream bitStream) {
            bitStream.pushBoolean(this.onlineRadioReceptionListIsAutomaticallyUpdated);
            bitStream.pushBoolean(this.tvDvbReceptionListIsAutomaticallyUpdated);
            bitStream.pushBoolean(this.amSwReceptionListIsAutomaticallyUpdated);
            bitStream.pushBoolean(this.amLwReceptionListIsAutomaticallyUpdated);
            bitStream.pushBoolean(this.sdarsReceptionListIsAutomaticallyUpdated);
            bitStream.pushBoolean(this.dabReceptionListIsAutomaticallyUpdated);
            bitStream.pushBoolean(this.amReceptionListIsAutomaticallyUpdated);
            bitStream.pushBoolean(this.fmReceptionListIsAutomaticallyUpdated);
        }

        public void deserialize(BitStream bitStream) {
            this.onlineRadioReceptionListIsAutomaticallyUpdated = bitStream.popFrontBoolean();
            this.tvDvbReceptionListIsAutomaticallyUpdated = bitStream.popFrontBoolean();
            this.amSwReceptionListIsAutomaticallyUpdated = bitStream.popFrontBoolean();
            this.amLwReceptionListIsAutomaticallyUpdated = bitStream.popFrontBoolean();
            this.sdarsReceptionListIsAutomaticallyUpdated = bitStream.popFrontBoolean();
            this.dabReceptionListIsAutomaticallyUpdated = bitStream.popFrontBoolean();
            this.amReceptionListIsAutomaticallyUpdated = bitStream.popFrontBoolean();
            this.fmReceptionListIsAutomaticallyUpdated = bitStream.popFrontBoolean();
        }
    }
}

