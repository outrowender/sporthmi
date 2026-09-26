/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.generated.audiosd.serializer;

import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.requests.StatusProperty;
import de.vw.mib.bap.stream.BitStream;

public final class FunctionList_Status
implements StatusProperty {
    public boolean reserved_bit_0;
    public boolean fctGetAllAvailable;
    public boolean fctBap_ConfigAvailable;
    public boolean fctFunctionListAvailable;
    public boolean fctHeartBeatAvailable;
    private static final int RESERVED_BIT_5__13_BITSIZE;
    public boolean fctFsg_SetupAvailable;
    public boolean fctFsg_OperationStateAvailable;
    public boolean fctActiveSourceAvailable;
    public boolean fctActiveSourceNameAvailable;
    public boolean fctCurrentVolumeAvailable;
    public boolean fctMuteAvailable;
    public boolean fctSourceStateAvailable;
    public boolean fctCurrentStationInfoAvailable;
    public boolean fctCurrentStation_HandleAvailable;
    public boolean fctReceptionListAvailable;
    public boolean fctDedicatedAudioControlAvailable;
    public boolean fctGeneralInfoSwitchesAvailable;
    public boolean fctTpMemoInfoAvailable;
    public boolean fctTpMemoListAvailable;
    public boolean fctAnnouncementInfoAvailable;
    public boolean fctAnnouncementEscapeAvailable;
    public boolean fctInfoStatesAvailable;
    public boolean fctReceptionListTypeAvailable;
    public boolean fctSourceListAvailable;
    public boolean fctRadioTv_PresetListAvailable;
    public boolean fctSwitchSourceAvailable;
    public boolean fctMediaBrowser_FolderLevelAvailable;
    public boolean fctMediaBrowserAvailable;
    public boolean fctMediaPathAvailable;
    public boolean fctMediaBrowserControlAvailable;
    public boolean fctMediaFileInfoAvailable;
    public boolean fctPreferredListAvailable;
    public boolean fctSds_StateAvailable;
    public boolean fctFunctionSynchronisationAvailable;
    public boolean fctAsg_CapabilitiesAvailable;
    public boolean fctGetNextListPosAvailable;
    public boolean fctSwitchRadioMediaAvailable;
    public boolean fctMediaImportStateAvailable;
    public boolean fctCurrentVolumeExtendedAvailable;
    public boolean fctCustomerDownloadStateAvailable;
    public boolean fctOnlineMusic_StateAvailable;
    public boolean fctCommonListAvailable;
    public boolean fctCurrentStation_Handle2Available;
    public boolean fctPlayPositionAvailable;
    private static final int RESERVED_BIT_53__63_BITSIZE;
    private static final int FUNCTION_LIST_STATUS_BITSIZE;

    public FunctionList_Status() {
        this.internalReset();
        this.customInitialization();
    }

    public FunctionList_Status(BitStream bitStream) {
        this();
        this.deserialize(bitStream);
    }

    private void internalReset() {
        this.reserved_bit_0 = false;
        this.fctGetAllAvailable = false;
        this.fctBap_ConfigAvailable = false;
        this.fctFunctionListAvailable = false;
        this.fctHeartBeatAvailable = false;
        this.fctFsg_SetupAvailable = false;
        this.fctFsg_OperationStateAvailable = false;
        this.fctActiveSourceAvailable = false;
        this.fctActiveSourceNameAvailable = false;
        this.fctCurrentVolumeAvailable = false;
        this.fctMuteAvailable = false;
        this.fctSourceStateAvailable = false;
        this.fctCurrentStationInfoAvailable = false;
        this.fctCurrentStation_HandleAvailable = false;
        this.fctReceptionListAvailable = false;
        this.fctDedicatedAudioControlAvailable = false;
        this.fctGeneralInfoSwitchesAvailable = false;
        this.fctTpMemoInfoAvailable = false;
        this.fctTpMemoListAvailable = false;
        this.fctAnnouncementInfoAvailable = false;
        this.fctAnnouncementEscapeAvailable = false;
        this.fctInfoStatesAvailable = false;
        this.fctReceptionListTypeAvailable = false;
        this.fctSourceListAvailable = false;
        this.fctRadioTv_PresetListAvailable = false;
        this.fctSwitchSourceAvailable = false;
        this.fctMediaBrowser_FolderLevelAvailable = false;
        this.fctMediaBrowserAvailable = false;
        this.fctMediaPathAvailable = false;
        this.fctMediaBrowserControlAvailable = false;
        this.fctMediaFileInfoAvailable = false;
        this.fctPreferredListAvailable = false;
        this.fctSds_StateAvailable = false;
        this.fctFunctionSynchronisationAvailable = false;
        this.fctAsg_CapabilitiesAvailable = false;
        this.fctGetNextListPosAvailable = false;
        this.fctSwitchRadioMediaAvailable = false;
        this.fctMediaImportStateAvailable = false;
        this.fctCurrentVolumeExtendedAvailable = false;
        this.fctCustomerDownloadStateAvailable = false;
        this.fctOnlineMusic_StateAvailable = false;
        this.fctCommonListAvailable = false;
        this.fctCurrentStation_Handle2Available = false;
        this.fctPlayPositionAvailable = false;
    }

    @Override
    public void reset() {
        this.internalReset();
    }

    @Override
    public boolean equalTo(BAPEntity bAPEntity) {
        FunctionList_Status functionList_Status = (FunctionList_Status)bAPEntity;
        return this.reserved_bit_0 == functionList_Status.reserved_bit_0 && this.fctGetAllAvailable == functionList_Status.fctGetAllAvailable && this.fctBap_ConfigAvailable == functionList_Status.fctBap_ConfigAvailable && this.fctFunctionListAvailable == functionList_Status.fctFunctionListAvailable && this.fctHeartBeatAvailable == functionList_Status.fctHeartBeatAvailable && this.fctFsg_SetupAvailable == functionList_Status.fctFsg_SetupAvailable && this.fctFsg_OperationStateAvailable == functionList_Status.fctFsg_OperationStateAvailable && this.fctActiveSourceAvailable == functionList_Status.fctActiveSourceAvailable && this.fctActiveSourceNameAvailable == functionList_Status.fctActiveSourceNameAvailable && this.fctCurrentVolumeAvailable == functionList_Status.fctCurrentVolumeAvailable && this.fctMuteAvailable == functionList_Status.fctMuteAvailable && this.fctSourceStateAvailable == functionList_Status.fctSourceStateAvailable && this.fctCurrentStationInfoAvailable == functionList_Status.fctCurrentStationInfoAvailable && this.fctCurrentStation_HandleAvailable == functionList_Status.fctCurrentStation_HandleAvailable && this.fctReceptionListAvailable == functionList_Status.fctReceptionListAvailable && this.fctDedicatedAudioControlAvailable == functionList_Status.fctDedicatedAudioControlAvailable && this.fctGeneralInfoSwitchesAvailable == functionList_Status.fctGeneralInfoSwitchesAvailable && this.fctTpMemoInfoAvailable == functionList_Status.fctTpMemoInfoAvailable && this.fctTpMemoListAvailable == functionList_Status.fctTpMemoListAvailable && this.fctAnnouncementInfoAvailable == functionList_Status.fctAnnouncementInfoAvailable && this.fctAnnouncementEscapeAvailable == functionList_Status.fctAnnouncementEscapeAvailable && this.fctInfoStatesAvailable == functionList_Status.fctInfoStatesAvailable && this.fctReceptionListTypeAvailable == functionList_Status.fctReceptionListTypeAvailable && this.fctSourceListAvailable == functionList_Status.fctSourceListAvailable && this.fctRadioTv_PresetListAvailable == functionList_Status.fctRadioTv_PresetListAvailable && this.fctSwitchSourceAvailable == functionList_Status.fctSwitchSourceAvailable && this.fctMediaBrowser_FolderLevelAvailable == functionList_Status.fctMediaBrowser_FolderLevelAvailable && this.fctMediaBrowserAvailable == functionList_Status.fctMediaBrowserAvailable && this.fctMediaPathAvailable == functionList_Status.fctMediaPathAvailable && this.fctMediaBrowserControlAvailable == functionList_Status.fctMediaBrowserControlAvailable && this.fctMediaFileInfoAvailable == functionList_Status.fctMediaFileInfoAvailable && this.fctPreferredListAvailable == functionList_Status.fctPreferredListAvailable && this.fctSds_StateAvailable == functionList_Status.fctSds_StateAvailable && this.fctFunctionSynchronisationAvailable == functionList_Status.fctFunctionSynchronisationAvailable && this.fctAsg_CapabilitiesAvailable == functionList_Status.fctAsg_CapabilitiesAvailable && this.fctGetNextListPosAvailable == functionList_Status.fctGetNextListPosAvailable && this.fctSwitchRadioMediaAvailable == functionList_Status.fctSwitchRadioMediaAvailable && this.fctMediaImportStateAvailable == functionList_Status.fctMediaImportStateAvailable && this.fctCurrentVolumeExtendedAvailable == functionList_Status.fctCurrentVolumeExtendedAvailable && this.fctCustomerDownloadStateAvailable == functionList_Status.fctCustomerDownloadStateAvailable && this.fctOnlineMusic_StateAvailable == functionList_Status.fctOnlineMusic_StateAvailable && this.fctCommonListAvailable == functionList_Status.fctCommonListAvailable && this.fctCurrentStation_Handle2Available == functionList_Status.fctCurrentStation_Handle2Available && this.fctPlayPositionAvailable == functionList_Status.fctPlayPositionAvailable;
    }

    private void customInitialization() {
    }

    @Override
    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("FunctionList_Status:");
        stringBuffer.append("\n - Bit 0: ");
        if (this.reserved_bit_0) {
            stringBuffer.append("true  (reserved");
        } else {
            stringBuffer.append("false  (reserved");
        }
        stringBuffer.append("\n - Bit 1: ");
        if (this.fctGetAllAvailable) {
            stringBuffer.append("true  (Fct \"GetAll\" available");
        } else {
            stringBuffer.append("false  (Fct \"GetAll\" not available");
        }
        stringBuffer.append("\n - Bit 2: ");
        if (this.fctBap_ConfigAvailable) {
            stringBuffer.append("true  (Fct \"BAP_Config\" available");
        } else {
            stringBuffer.append("false  (Fct \"BAP_Config\" not available");
        }
        stringBuffer.append("\n - Bit 3: ");
        if (this.fctFunctionListAvailable) {
            stringBuffer.append("true  (Fct \"FunctionList\" available");
        } else {
            stringBuffer.append("false  (Fct \"FunctionList\" not available");
        }
        stringBuffer.append("\n - Bit 4: ");
        if (this.fctHeartBeatAvailable) {
            stringBuffer.append("true  (Fct \"HeartBeat\" available");
        } else {
            stringBuffer.append("false  (Fct \"HeartBeat\" not available");
        }
        stringBuffer.append("\n - Bit 14: ");
        if (this.fctFsg_SetupAvailable) {
            stringBuffer.append("true  (Fct \"FSG_Setup\" available");
        } else {
            stringBuffer.append("false  (Fct \"FSG_Setup\" not available");
        }
        stringBuffer.append("\n - Bit 15: ");
        if (this.fctFsg_OperationStateAvailable) {
            stringBuffer.append("true  (Fct \"FSG_OperationState\" available");
        } else {
            stringBuffer.append("false  (Fct \"FSG_OperationState\" not available");
        }
        stringBuffer.append("\n - Bit 16: ");
        if (this.fctActiveSourceAvailable) {
            stringBuffer.append("true  (Fct \"ActiveSource\" available");
        } else {
            stringBuffer.append("false  (Fct \"ActiveSource\" not available");
        }
        stringBuffer.append("\n - Bit 17: ");
        if (this.fctActiveSourceNameAvailable) {
            stringBuffer.append("true  (Fct \"ActiveSourceName\" available");
        } else {
            stringBuffer.append("false  (Fct \"ActiveSourceName\" not available");
        }
        stringBuffer.append("\n - Bit 18: ");
        if (this.fctCurrentVolumeAvailable) {
            stringBuffer.append("true  (Fct \"CurrentVolume\" available");
        } else {
            stringBuffer.append("false  (Fct \"CurrentVolume\" not available");
        }
        stringBuffer.append("\n - Bit 19: ");
        if (this.fctMuteAvailable) {
            stringBuffer.append("true  (Fct \"Mute\" available");
        } else {
            stringBuffer.append("false  (Fct \"Mute\" not available");
        }
        stringBuffer.append("\n - Bit 20: ");
        if (this.fctSourceStateAvailable) {
            stringBuffer.append("true  (Fct \"SourceState\" available");
        } else {
            stringBuffer.append("false  (Fct \"SourceState\" not available");
        }
        stringBuffer.append("\n - Bit 21: ");
        if (this.fctCurrentStationInfoAvailable) {
            stringBuffer.append("true  (Fct \"CurrentStationInfo\" available");
        } else {
            stringBuffer.append("false  (Fct \"CurrentStationInfo\" not available");
        }
        stringBuffer.append("\n - Bit 22: ");
        if (this.fctCurrentStation_HandleAvailable) {
            stringBuffer.append("true  (Fct \"CurrentStation_Handle\" available");
        } else {
            stringBuffer.append("false  (Fct \"CurrentStation_Handle\" not available");
        }
        stringBuffer.append("\n - Bit 23: ");
        if (this.fctReceptionListAvailable) {
            stringBuffer.append("true  (Fct \"ReceptionList\" available");
        } else {
            stringBuffer.append("false  (Fct \"ReceptionList\" not available");
        }
        stringBuffer.append("\n - Bit 24: ");
        if (this.fctDedicatedAudioControlAvailable) {
            stringBuffer.append("true  (Fct \"DedicatedAudioControl\" available");
        } else {
            stringBuffer.append("false  (Fct \"DedicatedAudioControl\" not available");
        }
        stringBuffer.append("\n - Bit 25: ");
        if (this.fctGeneralInfoSwitchesAvailable) {
            stringBuffer.append("true  (Fct \"GeneralInfoSwitches\" available");
        } else {
            stringBuffer.append("false  (Fct \"GeneralInfoSwitches\" not available");
        }
        stringBuffer.append("\n - Bit 26: ");
        if (this.fctTpMemoInfoAvailable) {
            stringBuffer.append("true  (Fct \"TpMemoInfo\" available");
        } else {
            stringBuffer.append("false  (Fct \"TpMemoInfo\" not available");
        }
        stringBuffer.append("\n - Bit 27: ");
        if (this.fctTpMemoListAvailable) {
            stringBuffer.append("true  (Fct \"TpMemoList\" available");
        } else {
            stringBuffer.append("false  (Fct \"TpMemoList\" not available");
        }
        stringBuffer.append("\n - Bit 28: ");
        if (this.fctAnnouncementInfoAvailable) {
            stringBuffer.append("true  (Fct \"AnnouncementInfo\" available");
        } else {
            stringBuffer.append("false  (Fct \"AnnouncementInfo\" not available");
        }
        stringBuffer.append("\n - Bit 29: ");
        if (this.fctAnnouncementEscapeAvailable) {
            stringBuffer.append("true  (Fct \"AnnouncementEscape\" available");
        } else {
            stringBuffer.append("false  (Fct \"AnnouncementEscape\" not available");
        }
        stringBuffer.append("\n - Bit 30: ");
        if (this.fctInfoStatesAvailable) {
            stringBuffer.append("true  (Fct \"InfoStates\" available");
        } else {
            stringBuffer.append("false  (Fct \"InfoStates\" not available");
        }
        stringBuffer.append("\n - Bit 31: ");
        if (this.fctReceptionListTypeAvailable) {
            stringBuffer.append("true  (Fct \"ReceptionListType\" available");
        } else {
            stringBuffer.append("false  (Fct \"ReceptionListType\" not available");
        }
        stringBuffer.append("\n - Bit 32: ");
        if (this.fctSourceListAvailable) {
            stringBuffer.append("true  (Fct \"SourceList\" available");
        } else {
            stringBuffer.append("false  (Fct \"SourceList\" not available");
        }
        stringBuffer.append("\n - Bit 33: ");
        if (this.fctRadioTv_PresetListAvailable) {
            stringBuffer.append("true  (Fct \"RadioTV_PresetList\" available");
        } else {
            stringBuffer.append("false  (Fct \"RadioTV_PresetList\" not available");
        }
        stringBuffer.append("\n - Bit 34: ");
        if (this.fctSwitchSourceAvailable) {
            stringBuffer.append("true  (Fct \"SwitchSource\" available");
        } else {
            stringBuffer.append("false  (Fct \"SwitchSource\" not available");
        }
        stringBuffer.append("\n - Bit 35: ");
        if (this.fctMediaBrowser_FolderLevelAvailable) {
            stringBuffer.append("true  (Fct \"MediaBrowser_FolderLevel\" available");
        } else {
            stringBuffer.append("false  (Fct \"MediaBrowser_FolderLevel\" not available");
        }
        stringBuffer.append("\n - Bit 36: ");
        if (this.fctMediaBrowserAvailable) {
            stringBuffer.append("true  (Fct \"MediaBrowser\" available");
        } else {
            stringBuffer.append("false  (Fct \"MediaBrowser\" not available");
        }
        stringBuffer.append("\n - Bit 37: ");
        if (this.fctMediaPathAvailable) {
            stringBuffer.append("true  (Fct \"MediaPath\" available");
        } else {
            stringBuffer.append("false  (Fct \"MediaPath\" not available");
        }
        stringBuffer.append("\n - Bit 38: ");
        if (this.fctMediaBrowserControlAvailable) {
            stringBuffer.append("true  (Fct \"MediaBrowserControl\" available");
        } else {
            stringBuffer.append("false  (Fct \"MediaBrowserControl\" not available");
        }
        stringBuffer.append("\n - Bit 39: ");
        if (this.fctMediaFileInfoAvailable) {
            stringBuffer.append("true  (Fct \"MediaFileInfo\" available");
        } else {
            stringBuffer.append("false  (Fct \"MediaFileInfo\" not available");
        }
        stringBuffer.append("\n - Bit 40: ");
        if (this.fctPreferredListAvailable) {
            stringBuffer.append("true  (Fct \"PreferredList\" available");
        } else {
            stringBuffer.append("false  (Fct \"PreferredList\" not available");
        }
        stringBuffer.append("\n - Bit 41: ");
        if (this.fctSds_StateAvailable) {
            stringBuffer.append("true  (Fct \"SDS_State\" available");
        } else {
            stringBuffer.append("false  (Fct \"SDS_State\" not available");
        }
        stringBuffer.append("\n - Bit 42: ");
        if (this.fctFunctionSynchronisationAvailable) {
            stringBuffer.append("true  (Fct \"FunctionSynchronisation\" available");
        } else {
            stringBuffer.append("false  (Fct \"FunctionSynchronisation\" not available");
        }
        stringBuffer.append("\n - Bit 43: ");
        if (this.fctAsg_CapabilitiesAvailable) {
            stringBuffer.append("true  (Fct \"ASG_Capabilities\" available");
        } else {
            stringBuffer.append("false  (Fct \"ASG_Capabilities\" not available");
        }
        stringBuffer.append("\n - Bit 44: ");
        if (this.fctGetNextListPosAvailable) {
            stringBuffer.append("true  (Fct \"GetNextListPos\" available");
        } else {
            stringBuffer.append("false  (Fct \"GetNextListPos\" not available");
        }
        stringBuffer.append("\n - Bit 45: ");
        if (this.fctSwitchRadioMediaAvailable) {
            stringBuffer.append("true  (Fct \"SwitchRadioMedia\" available");
        } else {
            stringBuffer.append("false  (Fct \"SwitchRadioMedia\" not available");
        }
        stringBuffer.append("\n - Bit 46: ");
        if (this.fctMediaImportStateAvailable) {
            stringBuffer.append("true  (Fct \"MediaImportState\" available");
        } else {
            stringBuffer.append("false  (Fct \"MediaImportState\" not available");
        }
        stringBuffer.append("\n - Bit 47: ");
        if (this.fctCurrentVolumeExtendedAvailable) {
            stringBuffer.append("true  (Fct \"CurrentVolumeExtended\" available");
        } else {
            stringBuffer.append("false  (Fct \"CurrentVolumeExtended\" not available");
        }
        stringBuffer.append("\n - Bit 48: ");
        if (this.fctCustomerDownloadStateAvailable) {
            stringBuffer.append("true  (Fct \"CustomerDownloadState\" available");
        } else {
            stringBuffer.append("false  (Fct \"CustomerDownloadState\" not available");
        }
        stringBuffer.append("\n - Bit 49: ");
        if (this.fctOnlineMusic_StateAvailable) {
            stringBuffer.append("true  (Fct \"OnlineMusic_State\" available");
        } else {
            stringBuffer.append("false  (Fct \"OnlineMusic_State\" not available");
        }
        stringBuffer.append("\n - Bit 50: ");
        if (this.fctCommonListAvailable) {
            stringBuffer.append("true  (Fct \"CommonList\" available");
        } else {
            stringBuffer.append("false  (Fct \"CommonList\" not available");
        }
        stringBuffer.append("\n - Bit 51: ");
        if (this.fctCurrentStation_Handle2Available) {
            stringBuffer.append("true  (Fct \"CurrentStation_Handle2\" available");
        } else {
            stringBuffer.append("false  (Fct \"CurrentStation_Handle2\" not available");
        }
        stringBuffer.append("\n - Bit 52: ");
        if (this.fctPlayPositionAvailable) {
            stringBuffer.append("true  (Fct \"PlayPosition\" available");
        } else {
            stringBuffer.append("false  (Fct \"PlayPosition\" not available");
        }
        return stringBuffer.toString();
    }

    @Override
    public int bitSize() {
        int n = 0;
        return n += 64;
    }

    @Override
    public void serialize(BitStream bitStream) {
        bitStream.pushBoolean(this.reserved_bit_0);
        bitStream.pushBoolean(this.fctGetAllAvailable);
        bitStream.pushBoolean(this.fctBap_ConfigAvailable);
        bitStream.pushBoolean(this.fctFunctionListAvailable);
        bitStream.pushBoolean(this.fctHeartBeatAvailable);
        bitStream.resetBits(9);
        bitStream.pushBoolean(this.fctFsg_SetupAvailable);
        bitStream.pushBoolean(this.fctFsg_OperationStateAvailable);
        bitStream.pushBoolean(this.fctActiveSourceAvailable);
        bitStream.pushBoolean(this.fctActiveSourceNameAvailable);
        bitStream.pushBoolean(this.fctCurrentVolumeAvailable);
        bitStream.pushBoolean(this.fctMuteAvailable);
        bitStream.pushBoolean(this.fctSourceStateAvailable);
        bitStream.pushBoolean(this.fctCurrentStationInfoAvailable);
        bitStream.pushBoolean(this.fctCurrentStation_HandleAvailable);
        bitStream.pushBoolean(this.fctReceptionListAvailable);
        bitStream.pushBoolean(this.fctDedicatedAudioControlAvailable);
        bitStream.pushBoolean(this.fctGeneralInfoSwitchesAvailable);
        bitStream.pushBoolean(this.fctTpMemoInfoAvailable);
        bitStream.pushBoolean(this.fctTpMemoListAvailable);
        bitStream.pushBoolean(this.fctAnnouncementInfoAvailable);
        bitStream.pushBoolean(this.fctAnnouncementEscapeAvailable);
        bitStream.pushBoolean(this.fctInfoStatesAvailable);
        bitStream.pushBoolean(this.fctReceptionListTypeAvailable);
        bitStream.pushBoolean(this.fctSourceListAvailable);
        bitStream.pushBoolean(this.fctRadioTv_PresetListAvailable);
        bitStream.pushBoolean(this.fctSwitchSourceAvailable);
        bitStream.pushBoolean(this.fctMediaBrowser_FolderLevelAvailable);
        bitStream.pushBoolean(this.fctMediaBrowserAvailable);
        bitStream.pushBoolean(this.fctMediaPathAvailable);
        bitStream.pushBoolean(this.fctMediaBrowserControlAvailable);
        bitStream.pushBoolean(this.fctMediaFileInfoAvailable);
        bitStream.pushBoolean(this.fctPreferredListAvailable);
        bitStream.pushBoolean(this.fctSds_StateAvailable);
        bitStream.pushBoolean(this.fctFunctionSynchronisationAvailable);
        bitStream.pushBoolean(this.fctAsg_CapabilitiesAvailable);
        bitStream.pushBoolean(this.fctGetNextListPosAvailable);
        bitStream.pushBoolean(this.fctSwitchRadioMediaAvailable);
        bitStream.pushBoolean(this.fctMediaImportStateAvailable);
        bitStream.pushBoolean(this.fctCurrentVolumeExtendedAvailable);
        bitStream.pushBoolean(this.fctCustomerDownloadStateAvailable);
        bitStream.pushBoolean(this.fctOnlineMusic_StateAvailable);
        bitStream.pushBoolean(this.fctCommonListAvailable);
        bitStream.pushBoolean(this.fctCurrentStation_Handle2Available);
        bitStream.pushBoolean(this.fctPlayPositionAvailable);
        bitStream.resetBits(11);
    }

    @Override
    public void deserialize(BitStream bitStream) {
        this.reserved_bit_0 = bitStream.popFrontBoolean();
        this.fctGetAllAvailable = bitStream.popFrontBoolean();
        this.fctBap_ConfigAvailable = bitStream.popFrontBoolean();
        this.fctFunctionListAvailable = bitStream.popFrontBoolean();
        this.fctHeartBeatAvailable = bitStream.popFrontBoolean();
        bitStream.discardBits(9);
        this.fctFsg_SetupAvailable = bitStream.popFrontBoolean();
        this.fctFsg_OperationStateAvailable = bitStream.popFrontBoolean();
        this.fctActiveSourceAvailable = bitStream.popFrontBoolean();
        this.fctActiveSourceNameAvailable = bitStream.popFrontBoolean();
        this.fctCurrentVolumeAvailable = bitStream.popFrontBoolean();
        this.fctMuteAvailable = bitStream.popFrontBoolean();
        this.fctSourceStateAvailable = bitStream.popFrontBoolean();
        this.fctCurrentStationInfoAvailable = bitStream.popFrontBoolean();
        this.fctCurrentStation_HandleAvailable = bitStream.popFrontBoolean();
        this.fctReceptionListAvailable = bitStream.popFrontBoolean();
        this.fctDedicatedAudioControlAvailable = bitStream.popFrontBoolean();
        this.fctGeneralInfoSwitchesAvailable = bitStream.popFrontBoolean();
        this.fctTpMemoInfoAvailable = bitStream.popFrontBoolean();
        this.fctTpMemoListAvailable = bitStream.popFrontBoolean();
        this.fctAnnouncementInfoAvailable = bitStream.popFrontBoolean();
        this.fctAnnouncementEscapeAvailable = bitStream.popFrontBoolean();
        this.fctInfoStatesAvailable = bitStream.popFrontBoolean();
        this.fctReceptionListTypeAvailable = bitStream.popFrontBoolean();
        this.fctSourceListAvailable = bitStream.popFrontBoolean();
        this.fctRadioTv_PresetListAvailable = bitStream.popFrontBoolean();
        this.fctSwitchSourceAvailable = bitStream.popFrontBoolean();
        this.fctMediaBrowser_FolderLevelAvailable = bitStream.popFrontBoolean();
        this.fctMediaBrowserAvailable = bitStream.popFrontBoolean();
        this.fctMediaPathAvailable = bitStream.popFrontBoolean();
        this.fctMediaBrowserControlAvailable = bitStream.popFrontBoolean();
        this.fctMediaFileInfoAvailable = bitStream.popFrontBoolean();
        this.fctPreferredListAvailable = bitStream.popFrontBoolean();
        this.fctSds_StateAvailable = bitStream.popFrontBoolean();
        this.fctFunctionSynchronisationAvailable = bitStream.popFrontBoolean();
        this.fctAsg_CapabilitiesAvailable = bitStream.popFrontBoolean();
        this.fctGetNextListPosAvailable = bitStream.popFrontBoolean();
        this.fctSwitchRadioMediaAvailable = bitStream.popFrontBoolean();
        this.fctMediaImportStateAvailable = bitStream.popFrontBoolean();
        this.fctCurrentVolumeExtendedAvailable = bitStream.popFrontBoolean();
        this.fctCustomerDownloadStateAvailable = bitStream.popFrontBoolean();
        this.fctOnlineMusic_StateAvailable = bitStream.popFrontBoolean();
        this.fctCommonListAvailable = bitStream.popFrontBoolean();
        this.fctCurrentStation_Handle2Available = bitStream.popFrontBoolean();
        this.fctPlayPositionAvailable = bitStream.popFrontBoolean();
        bitStream.discardBits(11);
    }

    public static int functionId() {
        return 3;
    }

    @Override
    public int getFunctionId() {
        return FunctionList_Status.functionId();
    }
}

