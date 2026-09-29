/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.generated.navsd.serializer;

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
    private static final int RESERVED_BIT_5__14_BITSIZE;
    public boolean fctFsg_OperationStateAvailable;
    public boolean fctCompassInfoAvailable;
    public boolean fctRg_StatusAvailable;
    public boolean fctDistanceToNextManeuverAvailable;
    public boolean fctCurrentPositionInfoAvailable;
    public boolean fctTurnToInfoAvailable;
    public boolean fctDistanceToDestinationAvailable;
    public boolean fctTimeToDestinationAvailable;
    public boolean fctManeuverDescriptorAvailable;
    public boolean fctLaneGuidanceAvailable;
    public boolean fctTmcinfoAvailable;
    public boolean fctMagnetFieldZoneAvailable;
    public boolean fctCalibrationAvailable;
    public boolean fctAsg_CapabilitiesAvailable;
    public boolean fctLastDest_ListAvailable;
    public boolean fctFavoriteDest_ListAvailable;
    public boolean fctPreferredDest_ListAvailable;
    public boolean fctNavBookAvailable;
    public boolean fctAddress_ListAvailable;
    public boolean fctRg_ActDeactAvailable;
    public boolean fctRepeatLastNavAnnouncementAvailable;
    public boolean fctVoiceGuidanceAvailable;
    public boolean fctFunctionSynchronisationAvailable;
    public boolean fctInfoStatesAvailable;
    public boolean fctActiveRgTypeAvailable;
    public boolean fctTrafficBlock_IndicationAvailable;
    public boolean fctGetNextListPosAvailable;
    public boolean fctNbSpellerAvailable;
    public boolean fctMapColorAndTypeAvailable;
    public boolean fctMapViewAndOrientationAvailable;
    public boolean fctMapScaleAvailable;
    public boolean fctDestinationInfoAvailable;
    public boolean fctAltitudeAvailable;
    public boolean fctOnlineNavigationStateAvailable;
    public boolean fctExitviewAvailable;
    public boolean fctSemidynamicRouteGuidanceAvailable;
    public boolean fctPoi_SearchAvailable;
    public boolean fctPoi_ListAvailable;
    public boolean fctFsg_SetupAvailable;
    public boolean fctMap_PresentationAvailable;
    public boolean fctManeuverStateAvailable;
    public boolean fctEtc_StatusAvailable;
    private static final int RESERVED_BIT_57__63_BITSIZE;
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
        this.fctFsg_OperationStateAvailable = false;
        this.fctCompassInfoAvailable = false;
        this.fctRg_StatusAvailable = false;
        this.fctDistanceToNextManeuverAvailable = false;
        this.fctCurrentPositionInfoAvailable = false;
        this.fctTurnToInfoAvailable = false;
        this.fctDistanceToDestinationAvailable = false;
        this.fctTimeToDestinationAvailable = false;
        this.fctManeuverDescriptorAvailable = false;
        this.fctLaneGuidanceAvailable = false;
        this.fctTmcinfoAvailable = false;
        this.fctMagnetFieldZoneAvailable = false;
        this.fctCalibrationAvailable = false;
        this.fctAsg_CapabilitiesAvailable = false;
        this.fctLastDest_ListAvailable = false;
        this.fctFavoriteDest_ListAvailable = false;
        this.fctPreferredDest_ListAvailable = false;
        this.fctNavBookAvailable = false;
        this.fctAddress_ListAvailable = false;
        this.fctRg_ActDeactAvailable = false;
        this.fctRepeatLastNavAnnouncementAvailable = false;
        this.fctVoiceGuidanceAvailable = false;
        this.fctFunctionSynchronisationAvailable = false;
        this.fctInfoStatesAvailable = false;
        this.fctActiveRgTypeAvailable = false;
        this.fctTrafficBlock_IndicationAvailable = false;
        this.fctGetNextListPosAvailable = false;
        this.fctNbSpellerAvailable = false;
        this.fctMapColorAndTypeAvailable = false;
        this.fctMapViewAndOrientationAvailable = false;
        this.fctMapScaleAvailable = false;
        this.fctDestinationInfoAvailable = false;
        this.fctAltitudeAvailable = false;
        this.fctOnlineNavigationStateAvailable = false;
        this.fctExitviewAvailable = false;
        this.fctSemidynamicRouteGuidanceAvailable = false;
        this.fctPoi_SearchAvailable = false;
        this.fctPoi_ListAvailable = false;
        this.fctFsg_SetupAvailable = false;
        this.fctMap_PresentationAvailable = false;
        this.fctManeuverStateAvailable = false;
        this.fctEtc_StatusAvailable = false;
    }

    @Override
    public void reset() {
        this.internalReset();
    }

    @Override
    public boolean equalTo(BAPEntity bAPEntity) {
        FunctionList_Status functionList_Status = (FunctionList_Status)bAPEntity;
        return this.reserved_bit_0 == functionList_Status.reserved_bit_0 && this.fctGetAllAvailable == functionList_Status.fctGetAllAvailable && this.fctBap_ConfigAvailable == functionList_Status.fctBap_ConfigAvailable && this.fctFunctionListAvailable == functionList_Status.fctFunctionListAvailable && this.fctHeartBeatAvailable == functionList_Status.fctHeartBeatAvailable && this.fctFsg_OperationStateAvailable == functionList_Status.fctFsg_OperationStateAvailable && this.fctCompassInfoAvailable == functionList_Status.fctCompassInfoAvailable && this.fctRg_StatusAvailable == functionList_Status.fctRg_StatusAvailable && this.fctDistanceToNextManeuverAvailable == functionList_Status.fctDistanceToNextManeuverAvailable && this.fctCurrentPositionInfoAvailable == functionList_Status.fctCurrentPositionInfoAvailable && this.fctTurnToInfoAvailable == functionList_Status.fctTurnToInfoAvailable && this.fctDistanceToDestinationAvailable == functionList_Status.fctDistanceToDestinationAvailable && this.fctTimeToDestinationAvailable == functionList_Status.fctTimeToDestinationAvailable && this.fctManeuverDescriptorAvailable == functionList_Status.fctManeuverDescriptorAvailable && this.fctLaneGuidanceAvailable == functionList_Status.fctLaneGuidanceAvailable && this.fctTmcinfoAvailable == functionList_Status.fctTmcinfoAvailable && this.fctMagnetFieldZoneAvailable == functionList_Status.fctMagnetFieldZoneAvailable && this.fctCalibrationAvailable == functionList_Status.fctCalibrationAvailable && this.fctAsg_CapabilitiesAvailable == functionList_Status.fctAsg_CapabilitiesAvailable && this.fctLastDest_ListAvailable == functionList_Status.fctLastDest_ListAvailable && this.fctFavoriteDest_ListAvailable == functionList_Status.fctFavoriteDest_ListAvailable && this.fctPreferredDest_ListAvailable == functionList_Status.fctPreferredDest_ListAvailable && this.fctNavBookAvailable == functionList_Status.fctNavBookAvailable && this.fctAddress_ListAvailable == functionList_Status.fctAddress_ListAvailable && this.fctRg_ActDeactAvailable == functionList_Status.fctRg_ActDeactAvailable && this.fctRepeatLastNavAnnouncementAvailable == functionList_Status.fctRepeatLastNavAnnouncementAvailable && this.fctVoiceGuidanceAvailable == functionList_Status.fctVoiceGuidanceAvailable && this.fctFunctionSynchronisationAvailable == functionList_Status.fctFunctionSynchronisationAvailable && this.fctInfoStatesAvailable == functionList_Status.fctInfoStatesAvailable && this.fctActiveRgTypeAvailable == functionList_Status.fctActiveRgTypeAvailable && this.fctTrafficBlock_IndicationAvailable == functionList_Status.fctTrafficBlock_IndicationAvailable && this.fctGetNextListPosAvailable == functionList_Status.fctGetNextListPosAvailable && this.fctNbSpellerAvailable == functionList_Status.fctNbSpellerAvailable && this.fctMapColorAndTypeAvailable == functionList_Status.fctMapColorAndTypeAvailable && this.fctMapViewAndOrientationAvailable == functionList_Status.fctMapViewAndOrientationAvailable && this.fctMapScaleAvailable == functionList_Status.fctMapScaleAvailable && this.fctDestinationInfoAvailable == functionList_Status.fctDestinationInfoAvailable && this.fctAltitudeAvailable == functionList_Status.fctAltitudeAvailable && this.fctOnlineNavigationStateAvailable == functionList_Status.fctOnlineNavigationStateAvailable && this.fctExitviewAvailable == functionList_Status.fctExitviewAvailable && this.fctSemidynamicRouteGuidanceAvailable == functionList_Status.fctSemidynamicRouteGuidanceAvailable && this.fctPoi_SearchAvailable == functionList_Status.fctPoi_SearchAvailable && this.fctPoi_ListAvailable == functionList_Status.fctPoi_ListAvailable && this.fctFsg_SetupAvailable == functionList_Status.fctFsg_SetupAvailable && this.fctMap_PresentationAvailable == functionList_Status.fctMap_PresentationAvailable && this.fctManeuverStateAvailable == functionList_Status.fctManeuverStateAvailable && this.fctEtc_StatusAvailable == functionList_Status.fctEtc_StatusAvailable;
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
        stringBuffer.append("\n - Bit 15: ");
        if (this.fctFsg_OperationStateAvailable) {
            stringBuffer.append("true  (Fct \"FSG_OperationState\" available");
        } else {
            stringBuffer.append("false  (Fct \"FSG_OperationState\" not available");
        }
        stringBuffer.append("\n - Bit 16: ");
        if (this.fctCompassInfoAvailable) {
            stringBuffer.append("true  (Fct \"CompassInfo\" available");
        } else {
            stringBuffer.append("false  (Fct \"CompassInfo\" not available");
        }
        stringBuffer.append("\n - Bit 17: ");
        if (this.fctRg_StatusAvailable) {
            stringBuffer.append("true  (Fct \"RG_Status\" available");
        } else {
            stringBuffer.append("false  (Fct \"RG_Status\" not available");
        }
        stringBuffer.append("\n - Bit 18: ");
        if (this.fctDistanceToNextManeuverAvailable) {
            stringBuffer.append("true  (Fct \"DistanceToNextManeuver\" available");
        } else {
            stringBuffer.append("false  (Fct \"DistanceToNextManeuver\" not available");
        }
        stringBuffer.append("\n - Bit 19: ");
        if (this.fctCurrentPositionInfoAvailable) {
            stringBuffer.append("true  (Fct \"CurrentPositionInfo\" available");
        } else {
            stringBuffer.append("false  (Fct \"CurrentPositionInfo\" not available");
        }
        stringBuffer.append("\n - Bit 20: ");
        if (this.fctTurnToInfoAvailable) {
            stringBuffer.append("true  (Fct \"TurnToInfo\" available");
        } else {
            stringBuffer.append("false  (Fct \"TurnToInfo\" not available");
        }
        stringBuffer.append("\n - Bit 21: ");
        if (this.fctDistanceToDestinationAvailable) {
            stringBuffer.append("true  (Fct \"DistanceToDestination\" available");
        } else {
            stringBuffer.append("false  (Fct \"DistanceToDestination\" not available");
        }
        stringBuffer.append("\n - Bit 22: ");
        if (this.fctTimeToDestinationAvailable) {
            stringBuffer.append("true  (Fct \"TimeToDestination\" available");
        } else {
            stringBuffer.append("false  (Fct \"TimeToDestination\" not available");
        }
        stringBuffer.append("\n - Bit 23: ");
        if (this.fctManeuverDescriptorAvailable) {
            stringBuffer.append("true  (Fct \"ManeuverDescriptor\" available");
        } else {
            stringBuffer.append("false  (Fct \"ManeuverDescriptor\" not available");
        }
        stringBuffer.append("\n - Bit 24: ");
        if (this.fctLaneGuidanceAvailable) {
            stringBuffer.append("true  (Fct \"LaneGuidance\" available");
        } else {
            stringBuffer.append("false  (Fct \"LaneGuidance\" not available");
        }
        stringBuffer.append("\n - Bit 25: ");
        if (this.fctTmcinfoAvailable) {
            stringBuffer.append("true  (Fct \"TMCinfo\" available");
        } else {
            stringBuffer.append("false  (Fct \"TMCinfo\" not available");
        }
        stringBuffer.append("\n - Bit 26: ");
        if (this.fctMagnetFieldZoneAvailable) {
            stringBuffer.append("true  (Fct \"MagnetFieldZone\" available");
        } else {
            stringBuffer.append("false  (Fct \"MagnetFieldZone\" not available");
        }
        stringBuffer.append("\n - Bit 27: ");
        if (this.fctCalibrationAvailable) {
            stringBuffer.append("true  (Fct \"Calibration\" available");
        } else {
            stringBuffer.append("false  (Fct \"Calibration\" not available");
        }
        stringBuffer.append("\n - Bit 28: ");
        if (this.fctAsg_CapabilitiesAvailable) {
            stringBuffer.append("true  (Fct \"ASG_Capabilities\" available");
        } else {
            stringBuffer.append("false  (Fct \"ASG_Capabilities\" not available");
        }
        stringBuffer.append("\n - Bit 29: ");
        if (this.fctLastDest_ListAvailable) {
            stringBuffer.append("true  (Fct \"LastDest_List\" available");
        } else {
            stringBuffer.append("false  (Fct \"LastDest_List\" not available");
        }
        stringBuffer.append("\n - Bit 30: ");
        if (this.fctFavoriteDest_ListAvailable) {
            stringBuffer.append("true  (Fct \"FavoriteDest_List\" available");
        } else {
            stringBuffer.append("false  (Fct \"FavoriteDest_List\" not available");
        }
        stringBuffer.append("\n - Bit 31: ");
        if (this.fctPreferredDest_ListAvailable) {
            stringBuffer.append("true  (Fct \"PreferredDest_List\" available");
        } else {
            stringBuffer.append("false  (Fct \"PreferredDest_List\" not available");
        }
        stringBuffer.append("\n - Bit 32: ");
        if (this.fctNavBookAvailable) {
            stringBuffer.append("true  (Fct \"NavBook\" available");
        } else {
            stringBuffer.append("false  (Fct \"NavBook\" not available");
        }
        stringBuffer.append("\n - Bit 33: ");
        if (this.fctAddress_ListAvailable) {
            stringBuffer.append("true  (Fct \"Address_List\" available");
        } else {
            stringBuffer.append("false  (Fct \"Address_List\" not available");
        }
        stringBuffer.append("\n - Bit 34: ");
        if (this.fctRg_ActDeactAvailable) {
            stringBuffer.append("true  (Fct \"RG_ActDeact\" available");
        } else {
            stringBuffer.append("false  (Fct \"RG_ActDeact\" not available");
        }
        stringBuffer.append("\n - Bit 35: ");
        if (this.fctRepeatLastNavAnnouncementAvailable) {
            stringBuffer.append("true  (Fct \"RepeatLastNavAnnouncement\" available");
        } else {
            stringBuffer.append("false  (Fct \"RepeatLastNavAnnouncement\" not available");
        }
        stringBuffer.append("\n - Bit 36: ");
        if (this.fctVoiceGuidanceAvailable) {
            stringBuffer.append("true  (Fct \"VoiceGuidance\" available");
        } else {
            stringBuffer.append("false  (Fct \"VoiceGuidance\" not available");
        }
        stringBuffer.append("\n - Bit 37: ");
        if (this.fctFunctionSynchronisationAvailable) {
            stringBuffer.append("true  (Fct \"FunctionSynchronisation\" available");
        } else {
            stringBuffer.append("false  (Fct \"FunctionSynchronisation\" not available");
        }
        stringBuffer.append("\n - Bit 38: ");
        if (this.fctInfoStatesAvailable) {
            stringBuffer.append("true  (Fct \"InfoStates\" available");
        } else {
            stringBuffer.append("false  (Fct \"InfoStates\" not available");
        }
        stringBuffer.append("\n - Bit 39: ");
        if (this.fctActiveRgTypeAvailable) {
            stringBuffer.append("true  (Fct \"ActiveRgType\" available");
        } else {
            stringBuffer.append("false  (Fct \"ActiveRgType\" not available");
        }
        stringBuffer.append("\n - Bit 40: ");
        if (this.fctTrafficBlock_IndicationAvailable) {
            stringBuffer.append("true  (Fct \"TrafficBlock_Indication\" available");
        } else {
            stringBuffer.append("false  (Fct \"TrafficBlock_Indication\" not available");
        }
        stringBuffer.append("\n - Bit 41: ");
        if (this.fctGetNextListPosAvailable) {
            stringBuffer.append("true  (Fct \"GetNextListPos\" available");
        } else {
            stringBuffer.append("false  (Fct \"GetNextListPos\" not available");
        }
        stringBuffer.append("\n - Bit 42: ");
        if (this.fctNbSpellerAvailable) {
            stringBuffer.append("true  (Fct \"NbSpeller\" available");
        } else {
            stringBuffer.append("false  (Fct \"NbSpeller\" not available");
        }
        stringBuffer.append("\n - Bit 43: ");
        if (this.fctMapColorAndTypeAvailable) {
            stringBuffer.append("true  (Fct \"MapColorAndType\" available");
        } else {
            stringBuffer.append("false  (Fct \"MapColorAndType\" not available");
        }
        stringBuffer.append("\n - Bit 44: ");
        if (this.fctMapViewAndOrientationAvailable) {
            stringBuffer.append("true  (Fct \"MapViewAndOrientation\" available");
        } else {
            stringBuffer.append("false  (Fct \"MapViewAndOrientation\" not available");
        }
        stringBuffer.append("\n - Bit 45: ");
        if (this.fctMapScaleAvailable) {
            stringBuffer.append("true  (Fct \"MapScale\" available");
        } else {
            stringBuffer.append("false  (Fct \"MapScale\" not available");
        }
        stringBuffer.append("\n - Bit 46: ");
        if (this.fctDestinationInfoAvailable) {
            stringBuffer.append("true  (Fct \"DestinationInfo\" available");
        } else {
            stringBuffer.append("false  (Fct \"DestinationInfo\" not available");
        }
        stringBuffer.append("\n - Bit 47: ");
        if (this.fctAltitudeAvailable) {
            stringBuffer.append("true  (Fct \"Altitude\" available");
        } else {
            stringBuffer.append("false  (Fct \"Altitude\" not available");
        }
        stringBuffer.append("\n - Bit 48: ");
        if (this.fctOnlineNavigationStateAvailable) {
            stringBuffer.append("true  (Fct \"OnlineNavigationState\" available");
        } else {
            stringBuffer.append("false  (Fct \"OnlineNavigationState\" not available");
        }
        stringBuffer.append("\n - Bit 49: ");
        if (this.fctExitviewAvailable) {
            stringBuffer.append("true  (Fct \"Exitview\" available");
        } else {
            stringBuffer.append("false  (Fct \"Exitview\" not available");
        }
        stringBuffer.append("\n - Bit 50: ");
        if (this.fctSemidynamicRouteGuidanceAvailable) {
            stringBuffer.append("true  (Fct \"SemidynamicRouteGuidance\" available");
        } else {
            stringBuffer.append("false  (Fct \"SemidynamicRouteGuidance\" not availalbe");
        }
        stringBuffer.append("\n - Bit 51: ");
        if (this.fctPoi_SearchAvailable) {
            stringBuffer.append("true  (Fct \"POI_Search\" available");
        } else {
            stringBuffer.append("false  (Fct \"POI_Search\" not available");
        }
        stringBuffer.append("\n - Bit 52: ");
        if (this.fctPoi_ListAvailable) {
            stringBuffer.append("true  (Fct \"POI_List\" available");
        } else {
            stringBuffer.append("false  (Fct \"POI_List\" not available");
        }
        stringBuffer.append("\n - Bit 53: ");
        if (this.fctFsg_SetupAvailable) {
            stringBuffer.append("true  (Fct \"FSG_Setup\" available");
        } else {
            stringBuffer.append("false  (Fct \"FSG_Setup\" not available");
        }
        stringBuffer.append("\n - Bit 54: ");
        if (this.fctMap_PresentationAvailable) {
            stringBuffer.append("true  (Fct \"Map_Presentation\" available");
        } else {
            stringBuffer.append("false  (Fct \"Map_Presentation\" not available");
        }
        stringBuffer.append("\n - Bit 55: ");
        if (this.fctManeuverStateAvailable) {
            stringBuffer.append("true  (Fct \"ManeuverState\" available");
        } else {
            stringBuffer.append("false  (Fct \"ManeuverState\" not available");
        }
        stringBuffer.append("\n - Bit 56: ");
        if (this.fctEtc_StatusAvailable) {
            stringBuffer.append("true  (Fct \"ETC_Status\" available");
        } else {
            stringBuffer.append("false  (Fct \"ETC_Status\" not available");
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
        bitStream.resetBits(10);
        bitStream.pushBoolean(this.fctFsg_OperationStateAvailable);
        bitStream.pushBoolean(this.fctCompassInfoAvailable);
        bitStream.pushBoolean(this.fctRg_StatusAvailable);
        bitStream.pushBoolean(this.fctDistanceToNextManeuverAvailable);
        bitStream.pushBoolean(this.fctCurrentPositionInfoAvailable);
        bitStream.pushBoolean(this.fctTurnToInfoAvailable);
        bitStream.pushBoolean(this.fctDistanceToDestinationAvailable);
        bitStream.pushBoolean(this.fctTimeToDestinationAvailable);
        bitStream.pushBoolean(this.fctManeuverDescriptorAvailable);
        bitStream.pushBoolean(this.fctLaneGuidanceAvailable);
        bitStream.pushBoolean(this.fctTmcinfoAvailable);
        bitStream.pushBoolean(this.fctMagnetFieldZoneAvailable);
        bitStream.pushBoolean(this.fctCalibrationAvailable);
        bitStream.pushBoolean(this.fctAsg_CapabilitiesAvailable);
        bitStream.pushBoolean(this.fctLastDest_ListAvailable);
        bitStream.pushBoolean(this.fctFavoriteDest_ListAvailable);
        bitStream.pushBoolean(this.fctPreferredDest_ListAvailable);
        bitStream.pushBoolean(this.fctNavBookAvailable);
        bitStream.pushBoolean(this.fctAddress_ListAvailable);
        bitStream.pushBoolean(this.fctRg_ActDeactAvailable);
        bitStream.pushBoolean(this.fctRepeatLastNavAnnouncementAvailable);
        bitStream.pushBoolean(this.fctVoiceGuidanceAvailable);
        bitStream.pushBoolean(this.fctFunctionSynchronisationAvailable);
        bitStream.pushBoolean(this.fctInfoStatesAvailable);
        bitStream.pushBoolean(this.fctActiveRgTypeAvailable);
        bitStream.pushBoolean(this.fctTrafficBlock_IndicationAvailable);
        bitStream.pushBoolean(this.fctGetNextListPosAvailable);
        bitStream.pushBoolean(this.fctNbSpellerAvailable);
        bitStream.pushBoolean(this.fctMapColorAndTypeAvailable);
        bitStream.pushBoolean(this.fctMapViewAndOrientationAvailable);
        bitStream.pushBoolean(this.fctMapScaleAvailable);
        bitStream.pushBoolean(this.fctDestinationInfoAvailable);
        bitStream.pushBoolean(this.fctAltitudeAvailable);
        bitStream.pushBoolean(this.fctOnlineNavigationStateAvailable);
        bitStream.pushBoolean(this.fctExitviewAvailable);
        bitStream.pushBoolean(this.fctSemidynamicRouteGuidanceAvailable);
        bitStream.pushBoolean(this.fctPoi_SearchAvailable);
        bitStream.pushBoolean(this.fctPoi_ListAvailable);
        bitStream.pushBoolean(this.fctFsg_SetupAvailable);
        bitStream.pushBoolean(this.fctMap_PresentationAvailable);
        bitStream.pushBoolean(this.fctManeuverStateAvailable);
        bitStream.pushBoolean(this.fctEtc_StatusAvailable);
        bitStream.resetBits(7);
    }

    @Override
    public void deserialize(BitStream bitStream) {
        this.reserved_bit_0 = bitStream.popFrontBoolean();
        this.fctGetAllAvailable = bitStream.popFrontBoolean();
        this.fctBap_ConfigAvailable = bitStream.popFrontBoolean();
        this.fctFunctionListAvailable = bitStream.popFrontBoolean();
        this.fctHeartBeatAvailable = bitStream.popFrontBoolean();
        bitStream.discardBits(10);
        this.fctFsg_OperationStateAvailable = bitStream.popFrontBoolean();
        this.fctCompassInfoAvailable = bitStream.popFrontBoolean();
        this.fctRg_StatusAvailable = bitStream.popFrontBoolean();
        this.fctDistanceToNextManeuverAvailable = bitStream.popFrontBoolean();
        this.fctCurrentPositionInfoAvailable = bitStream.popFrontBoolean();
        this.fctTurnToInfoAvailable = bitStream.popFrontBoolean();
        this.fctDistanceToDestinationAvailable = bitStream.popFrontBoolean();
        this.fctTimeToDestinationAvailable = bitStream.popFrontBoolean();
        this.fctManeuverDescriptorAvailable = bitStream.popFrontBoolean();
        this.fctLaneGuidanceAvailable = bitStream.popFrontBoolean();
        this.fctTmcinfoAvailable = bitStream.popFrontBoolean();
        this.fctMagnetFieldZoneAvailable = bitStream.popFrontBoolean();
        this.fctCalibrationAvailable = bitStream.popFrontBoolean();
        this.fctAsg_CapabilitiesAvailable = bitStream.popFrontBoolean();
        this.fctLastDest_ListAvailable = bitStream.popFrontBoolean();
        this.fctFavoriteDest_ListAvailable = bitStream.popFrontBoolean();
        this.fctPreferredDest_ListAvailable = bitStream.popFrontBoolean();
        this.fctNavBookAvailable = bitStream.popFrontBoolean();
        this.fctAddress_ListAvailable = bitStream.popFrontBoolean();
        this.fctRg_ActDeactAvailable = bitStream.popFrontBoolean();
        this.fctRepeatLastNavAnnouncementAvailable = bitStream.popFrontBoolean();
        this.fctVoiceGuidanceAvailable = bitStream.popFrontBoolean();
        this.fctFunctionSynchronisationAvailable = bitStream.popFrontBoolean();
        this.fctInfoStatesAvailable = bitStream.popFrontBoolean();
        this.fctActiveRgTypeAvailable = bitStream.popFrontBoolean();
        this.fctTrafficBlock_IndicationAvailable = bitStream.popFrontBoolean();
        this.fctGetNextListPosAvailable = bitStream.popFrontBoolean();
        this.fctNbSpellerAvailable = bitStream.popFrontBoolean();
        this.fctMapColorAndTypeAvailable = bitStream.popFrontBoolean();
        this.fctMapViewAndOrientationAvailable = bitStream.popFrontBoolean();
        this.fctMapScaleAvailable = bitStream.popFrontBoolean();
        this.fctDestinationInfoAvailable = bitStream.popFrontBoolean();
        this.fctAltitudeAvailable = bitStream.popFrontBoolean();
        this.fctOnlineNavigationStateAvailable = bitStream.popFrontBoolean();
        this.fctExitviewAvailable = bitStream.popFrontBoolean();
        this.fctSemidynamicRouteGuidanceAvailable = bitStream.popFrontBoolean();
        this.fctPoi_SearchAvailable = bitStream.popFrontBoolean();
        this.fctPoi_ListAvailable = bitStream.popFrontBoolean();
        this.fctFsg_SetupAvailable = bitStream.popFrontBoolean();
        this.fctMap_PresentationAvailable = bitStream.popFrontBoolean();
        this.fctManeuverStateAvailable = bitStream.popFrontBoolean();
        this.fctEtc_StatusAvailable = bitStream.popFrontBoolean();
        bitStream.discardBits(7);
    }

    public static int functionId() {
        return 3;
    }

    @Override
    public int getFunctionId() {
        return FunctionList_Status.functionId();
    }
}

