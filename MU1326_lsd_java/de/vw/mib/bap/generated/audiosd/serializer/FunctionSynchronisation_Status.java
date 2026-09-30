/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.generated.audiosd.serializer;

import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.requests.StatusProperty;
import de.vw.mib.bap.stream.BitStream;

public final class FunctionSynchronisation_Status
implements StatusProperty {
    public final FctList_1 fctList_1 = new FctList_1();
    public final FctList_2 fctList_2 = new FctList_2();
    public final FctList_3 fctList_3 = new FctList_3();

    public FunctionSynchronisation_Status() {
        this.internalReset();
        this.customInitialization();
    }

    public FunctionSynchronisation_Status(BitStream bitStream) {
        this();
        this.deserialize(bitStream);
    }

    private void internalReset() {
    }

    public void reset() {
        this.internalReset();
        this.fctList_1.reset();
        this.fctList_2.reset();
        this.fctList_3.reset();
    }

    public boolean equalTo(BAPEntity bAPEntity) {
        FunctionSynchronisation_Status functionSynchronisation_Status = (FunctionSynchronisation_Status)bAPEntity;
        return this.fctList_1.equalTo(functionSynchronisation_Status.fctList_1) && this.fctList_2.equalTo(functionSynchronisation_Status.fctList_2) && this.fctList_3.equalTo(functionSynchronisation_Status.fctList_3);
    }

    private void customInitialization() {
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("FunctionSynchronisation_Status:");
        stringBuffer.append("\n - FctList_1 - ");
        stringBuffer.append(this.fctList_1.toString());
        stringBuffer.append("\n - FctList_2 - ");
        stringBuffer.append(this.fctList_2.toString());
        stringBuffer.append("\n - FctList_3 - ");
        stringBuffer.append(this.fctList_3.toString());
        return stringBuffer.toString();
    }

    public int bitSize() {
        int n = 0;
        n += this.fctList_1.bitSize();
        n += this.fctList_2.bitSize();
        return n += this.fctList_3.bitSize();
    }

    public void serialize(BitStream bitStream) {
        this.fctList_1.serialize(bitStream);
        this.fctList_2.serialize(bitStream);
        this.fctList_3.serialize(bitStream);
    }

    public void deserialize(BitStream bitStream) {
        this.fctList_1.deserialize(bitStream);
        this.fctList_2.deserialize(bitStream);
        this.fctList_3.deserialize(bitStream);
    }

    public static int functionId() {
        return 42;
    }

    public int getFunctionId() {
        return FunctionSynchronisation_Status.functionId();
    }

    public static final class FctList_1
    implements BAPEntity {
        public boolean reserved_bit_0;
        private static final int RESERVED_BIT_1__15_BITSIZE = 15;
        public boolean fctActiveSourceIsToBeSynchronised;
        public boolean fctActiveSourceNameIsToBeSynchronised;
        public boolean fctCurrentVolumeIsToBeSynchronised;
        public boolean fctMuteIsToBeSynchronised;
        public boolean fctSourceStateIsToBeSynchronised;
        public boolean fctCurrentStationInfoIsToBeSynchronised;
        public boolean fctCurrentStation_HandleIsToBeSynchronised;
        public boolean fctReceptionListIsNotToBeSynchronised;
        public boolean fctDedicatedAudioControlIsNotToBeSynchronised;
        public boolean fctGeneralInfoSwitchesIsToBeSynchronised;
        public boolean fctTpMemoInfoIsToBeSynchronised;
        public boolean fctTpMemoListIsNotToBeSynchronised;
        public boolean fctAnnouncementInfoIsToBeSynchronised;
        public boolean fctAnnouncementEscapeIsNotToBeSynchronised;
        public boolean fctInfoStatesIsToBeSynchronised;
        public boolean fctReceptionListTypeIsToBeSynchronised;
        public boolean fctSourceListIsNotToBeSynchronised;
        public boolean fctRadioTv_PresetListIsNotToBeSynchronised;
        public boolean fctSwitchSourceIsNotToBeSynchronised;
        public boolean fctMediaBrowser_FolderLevelIsToBeSynchronised;
        public boolean fctMediaBrowserIsNotToBeSynchronised;
        public boolean fctMediaPathIsToBeSynchronised;
        public boolean fctMediaBrowserControlIsNotToBeSynchronised;
        public boolean fctMediaFileInfoIsToBeSynchronised;
        public boolean fctPreferredListIsToBeSynchronised;
        public boolean fctSds_StateIsToBeSynchronised;
        public boolean fctFunctionSynchronisationIsNotToBeSynchronised;
        public boolean fctAsg_CapabilitiesIsNotToBeSynchronised;
        public boolean fctGetNextListPosIsNotToBeSynchronised;
        public boolean fctSwitchRadioMediaIsNotToBeSynchronised;
        public boolean fctMediaImportStateIsToBeSynchronised;
        public boolean fctCurrentVolumeExtendedIsToBeSynchronised;
        private static final int FCT_LIST_1_BITSIZE = 48;

        public FctList_1() {
            this.internalReset();
            this.customInitialization();
        }

        public FctList_1(BitStream bitStream) {
            this();
            this.deserialize(bitStream);
        }

        private void internalReset() {
            this.reserved_bit_0 = false;
            this.fctActiveSourceIsToBeSynchronised = false;
            this.fctActiveSourceNameIsToBeSynchronised = false;
            this.fctCurrentVolumeIsToBeSynchronised = false;
            this.fctMuteIsToBeSynchronised = false;
            this.fctSourceStateIsToBeSynchronised = false;
            this.fctCurrentStationInfoIsToBeSynchronised = false;
            this.fctCurrentStation_HandleIsToBeSynchronised = false;
            this.fctReceptionListIsNotToBeSynchronised = false;
            this.fctDedicatedAudioControlIsNotToBeSynchronised = false;
            this.fctGeneralInfoSwitchesIsToBeSynchronised = false;
            this.fctTpMemoInfoIsToBeSynchronised = false;
            this.fctTpMemoListIsNotToBeSynchronised = false;
            this.fctAnnouncementInfoIsToBeSynchronised = false;
            this.fctAnnouncementEscapeIsNotToBeSynchronised = false;
            this.fctInfoStatesIsToBeSynchronised = false;
            this.fctReceptionListTypeIsToBeSynchronised = false;
            this.fctSourceListIsNotToBeSynchronised = false;
            this.fctRadioTv_PresetListIsNotToBeSynchronised = false;
            this.fctSwitchSourceIsNotToBeSynchronised = false;
            this.fctMediaBrowser_FolderLevelIsToBeSynchronised = false;
            this.fctMediaBrowserIsNotToBeSynchronised = false;
            this.fctMediaPathIsToBeSynchronised = false;
            this.fctMediaBrowserControlIsNotToBeSynchronised = false;
            this.fctMediaFileInfoIsToBeSynchronised = false;
            this.fctPreferredListIsToBeSynchronised = false;
            this.fctSds_StateIsToBeSynchronised = false;
            this.fctFunctionSynchronisationIsNotToBeSynchronised = false;
            this.fctAsg_CapabilitiesIsNotToBeSynchronised = false;
            this.fctGetNextListPosIsNotToBeSynchronised = false;
            this.fctSwitchRadioMediaIsNotToBeSynchronised = false;
            this.fctMediaImportStateIsToBeSynchronised = false;
            this.fctCurrentVolumeExtendedIsToBeSynchronised = false;
        }

        public void reset() {
            this.internalReset();
        }

        public boolean equalTo(BAPEntity bAPEntity) {
            FctList_1 fctList_1 = (FctList_1)bAPEntity;
            return this.reserved_bit_0 == fctList_1.reserved_bit_0 && this.fctActiveSourceIsToBeSynchronised == fctList_1.fctActiveSourceIsToBeSynchronised && this.fctActiveSourceNameIsToBeSynchronised == fctList_1.fctActiveSourceNameIsToBeSynchronised && this.fctCurrentVolumeIsToBeSynchronised == fctList_1.fctCurrentVolumeIsToBeSynchronised && this.fctMuteIsToBeSynchronised == fctList_1.fctMuteIsToBeSynchronised && this.fctSourceStateIsToBeSynchronised == fctList_1.fctSourceStateIsToBeSynchronised && this.fctCurrentStationInfoIsToBeSynchronised == fctList_1.fctCurrentStationInfoIsToBeSynchronised && this.fctCurrentStation_HandleIsToBeSynchronised == fctList_1.fctCurrentStation_HandleIsToBeSynchronised && this.fctReceptionListIsNotToBeSynchronised == fctList_1.fctReceptionListIsNotToBeSynchronised && this.fctDedicatedAudioControlIsNotToBeSynchronised == fctList_1.fctDedicatedAudioControlIsNotToBeSynchronised && this.fctGeneralInfoSwitchesIsToBeSynchronised == fctList_1.fctGeneralInfoSwitchesIsToBeSynchronised && this.fctTpMemoInfoIsToBeSynchronised == fctList_1.fctTpMemoInfoIsToBeSynchronised && this.fctTpMemoListIsNotToBeSynchronised == fctList_1.fctTpMemoListIsNotToBeSynchronised && this.fctAnnouncementInfoIsToBeSynchronised == fctList_1.fctAnnouncementInfoIsToBeSynchronised && this.fctAnnouncementEscapeIsNotToBeSynchronised == fctList_1.fctAnnouncementEscapeIsNotToBeSynchronised && this.fctInfoStatesIsToBeSynchronised == fctList_1.fctInfoStatesIsToBeSynchronised && this.fctReceptionListTypeIsToBeSynchronised == fctList_1.fctReceptionListTypeIsToBeSynchronised && this.fctSourceListIsNotToBeSynchronised == fctList_1.fctSourceListIsNotToBeSynchronised && this.fctRadioTv_PresetListIsNotToBeSynchronised == fctList_1.fctRadioTv_PresetListIsNotToBeSynchronised && this.fctSwitchSourceIsNotToBeSynchronised == fctList_1.fctSwitchSourceIsNotToBeSynchronised && this.fctMediaBrowser_FolderLevelIsToBeSynchronised == fctList_1.fctMediaBrowser_FolderLevelIsToBeSynchronised && this.fctMediaBrowserIsNotToBeSynchronised == fctList_1.fctMediaBrowserIsNotToBeSynchronised && this.fctMediaPathIsToBeSynchronised == fctList_1.fctMediaPathIsToBeSynchronised && this.fctMediaBrowserControlIsNotToBeSynchronised == fctList_1.fctMediaBrowserControlIsNotToBeSynchronised && this.fctMediaFileInfoIsToBeSynchronised == fctList_1.fctMediaFileInfoIsToBeSynchronised && this.fctPreferredListIsToBeSynchronised == fctList_1.fctPreferredListIsToBeSynchronised && this.fctSds_StateIsToBeSynchronised == fctList_1.fctSds_StateIsToBeSynchronised && this.fctFunctionSynchronisationIsNotToBeSynchronised == fctList_1.fctFunctionSynchronisationIsNotToBeSynchronised && this.fctAsg_CapabilitiesIsNotToBeSynchronised == fctList_1.fctAsg_CapabilitiesIsNotToBeSynchronised && this.fctGetNextListPosIsNotToBeSynchronised == fctList_1.fctGetNextListPosIsNotToBeSynchronised && this.fctSwitchRadioMediaIsNotToBeSynchronised == fctList_1.fctSwitchRadioMediaIsNotToBeSynchronised && this.fctMediaImportStateIsToBeSynchronised == fctList_1.fctMediaImportStateIsToBeSynchronised && this.fctCurrentVolumeExtendedIsToBeSynchronised == fctList_1.fctCurrentVolumeExtendedIsToBeSynchronised;
        }

        private void customInitialization() {
        }

        public String toString() {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("FctList_1:");
            stringBuffer.append("\n - Bit 0: ");
            if (this.reserved_bit_0) {
                stringBuffer.append("true  (reserved");
            } else {
                stringBuffer.append("false  (reserved");
            }
            stringBuffer.append("\n - Bit 16: ");
            if (this.fctActiveSourceIsToBeSynchronised) {
                stringBuffer.append("true  (Fct \"activeSource\" is to be synchronised");
            } else {
                stringBuffer.append("false  (Fct \"activeSource\" is not to be synchronised");
            }
            stringBuffer.append("\n - Bit 17: ");
            if (this.fctActiveSourceNameIsToBeSynchronised) {
                stringBuffer.append("true  (Fct \"activeSourceName\" is to be synchronised");
            } else {
                stringBuffer.append("false  (Fct \"activeSourceName\" is not to be synchronised");
            }
            stringBuffer.append("\n - Bit 18: ");
            if (this.fctCurrentVolumeIsToBeSynchronised) {
                stringBuffer.append("true  (Fct \"currentVolume\" is to be synchronised");
            } else {
                stringBuffer.append("false  (Fct \"currentVolume\" is not to be synchronised");
            }
            stringBuffer.append("\n - Bit 19: ");
            if (this.fctMuteIsToBeSynchronised) {
                stringBuffer.append("true  (Fct \"Mute\" is to be synchronised");
            } else {
                stringBuffer.append("false  (Fct \"Mute\" is not to be synchronised");
            }
            stringBuffer.append("\n - Bit 20: ");
            if (this.fctSourceStateIsToBeSynchronised) {
                stringBuffer.append("true  (Fct \"SourceState\" is to be synchronised");
            } else {
                stringBuffer.append("false  (Fct \"SourceState\" is not to be synchronised");
            }
            stringBuffer.append("\n - Bit 21: ");
            if (this.fctCurrentStationInfoIsToBeSynchronised) {
                stringBuffer.append("true  (Fct \"currentStationInfo\" is to be synchronised");
            } else {
                stringBuffer.append("false  (Fct \"currentStationInfo\" is not to be synchronised");
            }
            stringBuffer.append("\n - Bit 22: ");
            if (this.fctCurrentStation_HandleIsToBeSynchronised) {
                stringBuffer.append("true  (Fct \"currentStation_Handle\" is to be synchronised");
            } else {
                stringBuffer.append("false  (Fct \"currentStation_Handle\" is not to be synchronised");
            }
            stringBuffer.append("\n - Bit 23: ");
            if (this.fctReceptionListIsNotToBeSynchronised) {
                stringBuffer.append("true  (reserved");
            } else {
                stringBuffer.append("false  (Fct \"ReceptionList\" is not to be synchronised");
            }
            stringBuffer.append("\n - Bit 24: ");
            if (this.fctDedicatedAudioControlIsNotToBeSynchronised) {
                stringBuffer.append("true  (reserved");
            } else {
                stringBuffer.append("false  (Fct \"dedicatedAudioControl\" is not to be synchronised");
            }
            stringBuffer.append("\n - Bit 25: ");
            if (this.fctGeneralInfoSwitchesIsToBeSynchronised) {
                stringBuffer.append("true  (Fct \"generalInfoSwitches\" is to be synchronised");
            } else {
                stringBuffer.append("false  (Fct \"generalInfoSwitches\" is not to be synchronised");
            }
            stringBuffer.append("\n - Bit 26: ");
            if (this.fctTpMemoInfoIsToBeSynchronised) {
                stringBuffer.append("true  (Fct \"TpMemoInfo\" is to be synchronised");
            } else {
                stringBuffer.append("false  (Fct \"TpMemoInfo\" is not to be synchronised");
            }
            stringBuffer.append("\n - Bit 27: ");
            if (this.fctTpMemoListIsNotToBeSynchronised) {
                stringBuffer.append("true  (reserved");
            } else {
                stringBuffer.append("false  (Fct \"TpMemoList\" is not to be synchronised");
            }
            stringBuffer.append("\n - Bit 28: ");
            if (this.fctAnnouncementInfoIsToBeSynchronised) {
                stringBuffer.append("true  (Fct \"AnnouncementInfo\" is to be synchronised");
            } else {
                stringBuffer.append("false  (Fct \"AnnouncementInfo\" is not to be synchronised");
            }
            stringBuffer.append("\n - Bit 29: ");
            if (this.fctAnnouncementEscapeIsNotToBeSynchronised) {
                stringBuffer.append("true  (reserved");
            } else {
                stringBuffer.append("false  (Fct \"AnnouncementEscape\" is not to be synchronised");
            }
            stringBuffer.append("\n - Bit 30: ");
            if (this.fctInfoStatesIsToBeSynchronised) {
                stringBuffer.append("true  (Fct \"InfoStates\" is to be synchronised");
            } else {
                stringBuffer.append("false  (Fct \"InfoStates\" is not to be synchronised");
            }
            stringBuffer.append("\n - Bit 31: ");
            if (this.fctReceptionListTypeIsToBeSynchronised) {
                stringBuffer.append("true  (Fct \"ReceptionListType\" is to be synchronised");
            } else {
                stringBuffer.append("false  (Fct \"ReceptionListType\" is not to be synchronised");
            }
            stringBuffer.append("\n - Bit 32: ");
            if (this.fctSourceListIsNotToBeSynchronised) {
                stringBuffer.append("true  (reserved");
            } else {
                stringBuffer.append("false  (Fct \"SourceList\" is not to be synchronised");
            }
            stringBuffer.append("\n - Bit 33: ");
            if (this.fctRadioTv_PresetListIsNotToBeSynchronised) {
                stringBuffer.append("true  (reserved");
            } else {
                stringBuffer.append("false  (Fct \"RadioTV_PresetList\" is not to be synchronised");
            }
            stringBuffer.append("\n - Bit 34: ");
            if (this.fctSwitchSourceIsNotToBeSynchronised) {
                stringBuffer.append("true  (reserved");
            } else {
                stringBuffer.append("false  (Fct \"SwitchSource\" is not to be synchronised");
            }
            stringBuffer.append("\n - Bit 35: ");
            if (this.fctMediaBrowser_FolderLevelIsToBeSynchronised) {
                stringBuffer.append("true  (Fct \"MediaBrowser_FolderLevel\" is to be synchronised");
            } else {
                stringBuffer.append("false  (Fct \"MediaBrowser_FolderLevel\" is not to be synchronised");
            }
            stringBuffer.append("\n - Bit 36: ");
            if (this.fctMediaBrowserIsNotToBeSynchronised) {
                stringBuffer.append("true  (reserved");
            } else {
                stringBuffer.append("false  (Fct \"MediaBrowser\" is not to be synchronised");
            }
            stringBuffer.append("\n - Bit 37: ");
            if (this.fctMediaPathIsToBeSynchronised) {
                stringBuffer.append("true  (Fct \"MediaPath\" is to be synchronised");
            } else {
                stringBuffer.append("false  (Fct \"MediaPath\" is not to be synchronised");
            }
            stringBuffer.append("\n - Bit 38: ");
            if (this.fctMediaBrowserControlIsNotToBeSynchronised) {
                stringBuffer.append("true  (reserved");
            } else {
                stringBuffer.append("false  (Fct \"MediaBrowserControl\" is not to be synchronised");
            }
            stringBuffer.append("\n - Bit 39: ");
            if (this.fctMediaFileInfoIsToBeSynchronised) {
                stringBuffer.append("true  (Fct \"MediaFileInfo\" is to be synchronised");
            } else {
                stringBuffer.append("false  (Fct \"MediaFileInfo\" is not to be synchronised");
            }
            stringBuffer.append("\n - Bit 40: ");
            if (this.fctPreferredListIsToBeSynchronised) {
                stringBuffer.append("true  (Fct \"PreferredList\" is to be synchronised");
            } else {
                stringBuffer.append("false  (Fct \"PreferredList\" is not to be synchronised");
            }
            stringBuffer.append("\n - Bit 41: ");
            if (this.fctSds_StateIsToBeSynchronised) {
                stringBuffer.append("true  (Fct \"SDS_State\" is to be synchronised");
            } else {
                stringBuffer.append("false  (Fct \"SDS_State\" is not to be synchronised");
            }
            stringBuffer.append("\n - Bit 42: ");
            if (this.fctFunctionSynchronisationIsNotToBeSynchronised) {
                stringBuffer.append("true  (reserved");
            } else {
                stringBuffer.append("false  (Fct \"FunctionSynchronisation\" is not to be synchronised");
            }
            stringBuffer.append("\n - Bit 43: ");
            if (this.fctAsg_CapabilitiesIsNotToBeSynchronised) {
                stringBuffer.append("true  (reserved");
            } else {
                stringBuffer.append("false  (Fct \"ASG_Capabilities\" is not to be synchronised");
            }
            stringBuffer.append("\n - Bit 44: ");
            if (this.fctGetNextListPosIsNotToBeSynchronised) {
                stringBuffer.append("true  (reserved");
            } else {
                stringBuffer.append("false  (Fct \"GetNextListPos\" is not to be synchronised");
            }
            stringBuffer.append("\n - Bit 45: ");
            if (this.fctSwitchRadioMediaIsNotToBeSynchronised) {
                stringBuffer.append("true  (reserved");
            } else {
                stringBuffer.append("false  (Fct \"SwitchRadioMedia\" is not to be synchronised");
            }
            stringBuffer.append("\n - Bit 46: ");
            if (this.fctMediaImportStateIsToBeSynchronised) {
                stringBuffer.append("true  (Fct \"MediaImportState\" is to be synchronised");
            } else {
                stringBuffer.append("false  (Fct \"MediaImportState\" is not to be synchronised");
            }
            stringBuffer.append("\n - Bit 47: ");
            if (this.fctCurrentVolumeExtendedIsToBeSynchronised) {
                stringBuffer.append("true  (Fct \"CurrentVolumeExtended\" is to be synchronised");
            } else {
                stringBuffer.append("false  (Fct \"CurrentVolumeExtended\" is not to be synchronised");
            }
            return stringBuffer.toString();
        }

        public int bitSize() {
            int n = 0;
            return n += 48;
        }

        public void serialize(BitStream bitStream) {
            bitStream.pushBoolean(this.reserved_bit_0);
            bitStream.resetBits(15);
            bitStream.pushBoolean(this.fctActiveSourceIsToBeSynchronised);
            bitStream.pushBoolean(this.fctActiveSourceNameIsToBeSynchronised);
            bitStream.pushBoolean(this.fctCurrentVolumeIsToBeSynchronised);
            bitStream.pushBoolean(this.fctMuteIsToBeSynchronised);
            bitStream.pushBoolean(this.fctSourceStateIsToBeSynchronised);
            bitStream.pushBoolean(this.fctCurrentStationInfoIsToBeSynchronised);
            bitStream.pushBoolean(this.fctCurrentStation_HandleIsToBeSynchronised);
            bitStream.pushBoolean(this.fctReceptionListIsNotToBeSynchronised);
            bitStream.pushBoolean(this.fctDedicatedAudioControlIsNotToBeSynchronised);
            bitStream.pushBoolean(this.fctGeneralInfoSwitchesIsToBeSynchronised);
            bitStream.pushBoolean(this.fctTpMemoInfoIsToBeSynchronised);
            bitStream.pushBoolean(this.fctTpMemoListIsNotToBeSynchronised);
            bitStream.pushBoolean(this.fctAnnouncementInfoIsToBeSynchronised);
            bitStream.pushBoolean(this.fctAnnouncementEscapeIsNotToBeSynchronised);
            bitStream.pushBoolean(this.fctInfoStatesIsToBeSynchronised);
            bitStream.pushBoolean(this.fctReceptionListTypeIsToBeSynchronised);
            bitStream.pushBoolean(this.fctSourceListIsNotToBeSynchronised);
            bitStream.pushBoolean(this.fctRadioTv_PresetListIsNotToBeSynchronised);
            bitStream.pushBoolean(this.fctSwitchSourceIsNotToBeSynchronised);
            bitStream.pushBoolean(this.fctMediaBrowser_FolderLevelIsToBeSynchronised);
            bitStream.pushBoolean(this.fctMediaBrowserIsNotToBeSynchronised);
            bitStream.pushBoolean(this.fctMediaPathIsToBeSynchronised);
            bitStream.pushBoolean(this.fctMediaBrowserControlIsNotToBeSynchronised);
            bitStream.pushBoolean(this.fctMediaFileInfoIsToBeSynchronised);
            bitStream.pushBoolean(this.fctPreferredListIsToBeSynchronised);
            bitStream.pushBoolean(this.fctSds_StateIsToBeSynchronised);
            bitStream.pushBoolean(this.fctFunctionSynchronisationIsNotToBeSynchronised);
            bitStream.pushBoolean(this.fctAsg_CapabilitiesIsNotToBeSynchronised);
            bitStream.pushBoolean(this.fctGetNextListPosIsNotToBeSynchronised);
            bitStream.pushBoolean(this.fctSwitchRadioMediaIsNotToBeSynchronised);
            bitStream.pushBoolean(this.fctMediaImportStateIsToBeSynchronised);
            bitStream.pushBoolean(this.fctCurrentVolumeExtendedIsToBeSynchronised);
        }

        public void deserialize(BitStream bitStream) {
            this.reserved_bit_0 = bitStream.popFrontBoolean();
            bitStream.discardBits(15);
            this.fctActiveSourceIsToBeSynchronised = bitStream.popFrontBoolean();
            this.fctActiveSourceNameIsToBeSynchronised = bitStream.popFrontBoolean();
            this.fctCurrentVolumeIsToBeSynchronised = bitStream.popFrontBoolean();
            this.fctMuteIsToBeSynchronised = bitStream.popFrontBoolean();
            this.fctSourceStateIsToBeSynchronised = bitStream.popFrontBoolean();
            this.fctCurrentStationInfoIsToBeSynchronised = bitStream.popFrontBoolean();
            this.fctCurrentStation_HandleIsToBeSynchronised = bitStream.popFrontBoolean();
            this.fctReceptionListIsNotToBeSynchronised = bitStream.popFrontBoolean();
            this.fctDedicatedAudioControlIsNotToBeSynchronised = bitStream.popFrontBoolean();
            this.fctGeneralInfoSwitchesIsToBeSynchronised = bitStream.popFrontBoolean();
            this.fctTpMemoInfoIsToBeSynchronised = bitStream.popFrontBoolean();
            this.fctTpMemoListIsNotToBeSynchronised = bitStream.popFrontBoolean();
            this.fctAnnouncementInfoIsToBeSynchronised = bitStream.popFrontBoolean();
            this.fctAnnouncementEscapeIsNotToBeSynchronised = bitStream.popFrontBoolean();
            this.fctInfoStatesIsToBeSynchronised = bitStream.popFrontBoolean();
            this.fctReceptionListTypeIsToBeSynchronised = bitStream.popFrontBoolean();
            this.fctSourceListIsNotToBeSynchronised = bitStream.popFrontBoolean();
            this.fctRadioTv_PresetListIsNotToBeSynchronised = bitStream.popFrontBoolean();
            this.fctSwitchSourceIsNotToBeSynchronised = bitStream.popFrontBoolean();
            this.fctMediaBrowser_FolderLevelIsToBeSynchronised = bitStream.popFrontBoolean();
            this.fctMediaBrowserIsNotToBeSynchronised = bitStream.popFrontBoolean();
            this.fctMediaPathIsToBeSynchronised = bitStream.popFrontBoolean();
            this.fctMediaBrowserControlIsNotToBeSynchronised = bitStream.popFrontBoolean();
            this.fctMediaFileInfoIsToBeSynchronised = bitStream.popFrontBoolean();
            this.fctPreferredListIsToBeSynchronised = bitStream.popFrontBoolean();
            this.fctSds_StateIsToBeSynchronised = bitStream.popFrontBoolean();
            this.fctFunctionSynchronisationIsNotToBeSynchronised = bitStream.popFrontBoolean();
            this.fctAsg_CapabilitiesIsNotToBeSynchronised = bitStream.popFrontBoolean();
            this.fctGetNextListPosIsNotToBeSynchronised = bitStream.popFrontBoolean();
            this.fctSwitchRadioMediaIsNotToBeSynchronised = bitStream.popFrontBoolean();
            this.fctMediaImportStateIsToBeSynchronised = bitStream.popFrontBoolean();
            this.fctCurrentVolumeExtendedIsToBeSynchronised = bitStream.popFrontBoolean();
        }
    }

    public static final class FctList_2
    implements BAPEntity {
        public boolean fctCustomerDownloadStateIsToBeSynchronised;
        public boolean fctOnlineMusic_StateIsToBeSynchronised;
        public boolean fct_CommonListIsNotToBeSynchronised;
        public boolean fctCurrentStation_Handle2IsToBeSynchronised;
        public boolean fctPlayPositionIsToBeSynchronised;
        private static final int RESERVED_BIT_5__7_BITSIZE = 3;
        private static final int FCT_LIST_2_BITSIZE = 8;

        public FctList_2() {
            this.internalReset();
            this.customInitialization();
        }

        public FctList_2(BitStream bitStream) {
            this();
            this.deserialize(bitStream);
        }

        private void internalReset() {
            this.fctCustomerDownloadStateIsToBeSynchronised = false;
            this.fctOnlineMusic_StateIsToBeSynchronised = false;
            this.fct_CommonListIsNotToBeSynchronised = false;
            this.fctCurrentStation_Handle2IsToBeSynchronised = false;
            this.fctPlayPositionIsToBeSynchronised = false;
        }

        public void reset() {
            this.internalReset();
        }

        public boolean equalTo(BAPEntity bAPEntity) {
            FctList_2 fctList_2 = (FctList_2)bAPEntity;
            return this.fctCustomerDownloadStateIsToBeSynchronised == fctList_2.fctCustomerDownloadStateIsToBeSynchronised && this.fctOnlineMusic_StateIsToBeSynchronised == fctList_2.fctOnlineMusic_StateIsToBeSynchronised && this.fct_CommonListIsNotToBeSynchronised == fctList_2.fct_CommonListIsNotToBeSynchronised && this.fctCurrentStation_Handle2IsToBeSynchronised == fctList_2.fctCurrentStation_Handle2IsToBeSynchronised && this.fctPlayPositionIsToBeSynchronised == fctList_2.fctPlayPositionIsToBeSynchronised;
        }

        private void customInitialization() {
        }

        public String toString() {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("FctList_2:");
            stringBuffer.append("\n - Bit 0: ");
            if (this.fctCustomerDownloadStateIsToBeSynchronised) {
                stringBuffer.append("true  (Fct \"CustomerDownloadState\" is to be synchronised");
            } else {
                stringBuffer.append("false  (Fct \"CustomerDownloadState\" is not to be synchronised");
            }
            stringBuffer.append("\n - Bit 1: ");
            if (this.fctOnlineMusic_StateIsToBeSynchronised) {
                stringBuffer.append("true  (Fct \"OnlineMusic_State\" is to be synchronised");
            } else {
                stringBuffer.append("false  (Fct \"OnlineMusic_State\" is not to be synchronised");
            }
            stringBuffer.append("\n - Bit 2: ");
            if (this.fct_CommonListIsNotToBeSynchronised) {
                stringBuffer.append("true  (reserved");
            } else {
                stringBuffer.append("false  (Fct. \"CommonList\" is not to be synchronised");
            }
            stringBuffer.append("\n - Bit 3: ");
            if (this.fctCurrentStation_Handle2IsToBeSynchronised) {
                stringBuffer.append("true  (Fct \"CurrentStation_Handle2\" is to be synchronised");
            } else {
                stringBuffer.append("false  (Fct \"CurrentStation_Handle2\" is not to be synchronised");
            }
            stringBuffer.append("\n - Bit 4: ");
            if (this.fctPlayPositionIsToBeSynchronised) {
                stringBuffer.append("true  (Fct \"PlayPosition\" is to be synchronised");
            } else {
                stringBuffer.append("false  (Fct \"PlayPosition\" is not to be synchronised");
            }
            return stringBuffer.toString();
        }

        public int bitSize() {
            int n = 0;
            return n += 8;
        }

        public void serialize(BitStream bitStream) {
            bitStream.pushBoolean(this.fctCustomerDownloadStateIsToBeSynchronised);
            bitStream.pushBoolean(this.fctOnlineMusic_StateIsToBeSynchronised);
            bitStream.pushBoolean(this.fct_CommonListIsNotToBeSynchronised);
            bitStream.pushBoolean(this.fctCurrentStation_Handle2IsToBeSynchronised);
            bitStream.pushBoolean(this.fctPlayPositionIsToBeSynchronised);
            bitStream.resetBits(3);
        }

        public void deserialize(BitStream bitStream) {
            this.fctCustomerDownloadStateIsToBeSynchronised = bitStream.popFrontBoolean();
            this.fctOnlineMusic_StateIsToBeSynchronised = bitStream.popFrontBoolean();
            this.fct_CommonListIsNotToBeSynchronised = bitStream.popFrontBoolean();
            this.fctCurrentStation_Handle2IsToBeSynchronised = bitStream.popFrontBoolean();
            this.fctPlayPositionIsToBeSynchronised = bitStream.popFrontBoolean();
            bitStream.discardBits(3);
        }
    }

    public static final class FctList_3
    implements BAPEntity {
        private static final int RESERVED_BIT_0__7_BITSIZE = 8;
        private static final int FCT_LIST_3_BITSIZE = 8;

        public FctList_3() {
            this.internalReset();
            this.customInitialization();
        }

        public FctList_3(BitStream bitStream) {
            this();
            this.deserialize(bitStream);
        }

        private void internalReset() {
        }

        public void reset() {
            this.internalReset();
        }

        public boolean equalTo(BAPEntity bAPEntity) {
            return true;
        }

        private void customInitialization() {
        }

        public String toString() {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("FctList_3:");
            return stringBuffer.toString();
        }

        public int bitSize() {
            int n = 0;
            return n += 8;
        }

        public void serialize(BitStream bitStream) {
            bitStream.resetBits(8);
        }

        public void deserialize(BitStream bitStream) {
            bitStream.discardBits(8);
        }
    }
}

