/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.generated.navsd.serializer;

import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.stream.BitStream;

public final class FunctionSynchronisation_Status$FctList_1
implements BAPEntity {
    private static final int RESERVED_BIT_0__15_BITSIZE;
    public boolean fctCompassInfoIsToBeSynchronised;
    public boolean fctRg_StatusIsToBeSynchronised;
    public boolean fctDistanceToNextManeuverIsToBeSynchronised;
    public boolean fctCurrentPositionInfoIsToBeSynchronised;
    public boolean fctTurnToInfoIsToBeSynchronised;
    public boolean fctDistanceToDestinationIsToBeSynchronised;
    public boolean fctTimeToDestinationIsToBeSynchronised;
    public boolean fctManeuverDescriptorIsToBeSynchronised;
    public boolean fctLaneGuidanceIsToBeSynchronised;
    public boolean fctTmcinfoIsToBeSynchronised;
    public boolean fctMagnetFieldZoneIsToBeSynchronised;
    public boolean fctCalibrationIsToBeSynchronised;
    public boolean reserved_bit_28;
    public boolean fctLastDest_ListIsToBeSynchronised;
    public boolean fctFavoriteDest_ListIsToBeSynchronised;
    public boolean fctPreferredDest_ListIsToBeSynchronised;
    public boolean fctNavBookIsToBeSynchronised;
    public boolean fctAddress_ListIsToBeSynchronised;
    public boolean fctRg_ActDeactIsToBeSynchronised;
    public boolean reserved_bit_35;
    public boolean fctVoiceGuidanceIsToBeSynchronised;
    public boolean reserved_bit_37;
    public boolean fctInfoStatesIsToBeSynchronised;
    public boolean fctActiveRgTypeIsToBeSynchronised;
    public boolean fctTrafficBlock_IndicationIsToBeSynchronised;
    private static final int RESERVED_BIT_41__42_BITSIZE;
    public boolean fct_MapColorAndTypeIsToBeSynchronised;
    public boolean fct_MapViewAndOrientationIsToBeSynchronised;
    public boolean fct_MapScaleIsToBeSynchronised;
    public boolean fct_DestinationInfoIsToBeSynchronised;
    public boolean fct_AltitudeIsToBeSynchronised;
    private static final int FCT_LIST_1_BITSIZE;

    public FunctionSynchronisation_Status$FctList_1() {
        this.internalReset();
        this.customInitialization();
    }

    public FunctionSynchronisation_Status$FctList_1(BitStream bitStream) {
        this();
        this.deserialize(bitStream);
    }

    private void internalReset() {
        this.fctCompassInfoIsToBeSynchronised = false;
        this.fctRg_StatusIsToBeSynchronised = false;
        this.fctDistanceToNextManeuverIsToBeSynchronised = false;
        this.fctCurrentPositionInfoIsToBeSynchronised = false;
        this.fctTurnToInfoIsToBeSynchronised = false;
        this.fctDistanceToDestinationIsToBeSynchronised = false;
        this.fctTimeToDestinationIsToBeSynchronised = false;
        this.fctManeuverDescriptorIsToBeSynchronised = false;
        this.fctLaneGuidanceIsToBeSynchronised = false;
        this.fctTmcinfoIsToBeSynchronised = false;
        this.fctMagnetFieldZoneIsToBeSynchronised = false;
        this.fctCalibrationIsToBeSynchronised = false;
        this.reserved_bit_28 = false;
        this.fctLastDest_ListIsToBeSynchronised = false;
        this.fctFavoriteDest_ListIsToBeSynchronised = false;
        this.fctPreferredDest_ListIsToBeSynchronised = false;
        this.fctNavBookIsToBeSynchronised = false;
        this.fctAddress_ListIsToBeSynchronised = false;
        this.fctRg_ActDeactIsToBeSynchronised = false;
        this.reserved_bit_35 = false;
        this.fctVoiceGuidanceIsToBeSynchronised = false;
        this.reserved_bit_37 = false;
        this.fctInfoStatesIsToBeSynchronised = false;
        this.fctActiveRgTypeIsToBeSynchronised = false;
        this.fctTrafficBlock_IndicationIsToBeSynchronised = false;
        this.fct_MapColorAndTypeIsToBeSynchronised = false;
        this.fct_MapViewAndOrientationIsToBeSynchronised = false;
        this.fct_MapScaleIsToBeSynchronised = false;
        this.fct_DestinationInfoIsToBeSynchronised = false;
        this.fct_AltitudeIsToBeSynchronised = false;
    }

    @Override
    public void reset() {
        this.internalReset();
    }

    @Override
    public boolean equalTo(BAPEntity bAPEntity) {
        FunctionSynchronisation_Status$FctList_1 functionSynchronisation_Status$FctList_1 = (FunctionSynchronisation_Status$FctList_1)bAPEntity;
        return this.fctCompassInfoIsToBeSynchronised == functionSynchronisation_Status$FctList_1.fctCompassInfoIsToBeSynchronised && this.fctRg_StatusIsToBeSynchronised == functionSynchronisation_Status$FctList_1.fctRg_StatusIsToBeSynchronised && this.fctDistanceToNextManeuverIsToBeSynchronised == functionSynchronisation_Status$FctList_1.fctDistanceToNextManeuverIsToBeSynchronised && this.fctCurrentPositionInfoIsToBeSynchronised == functionSynchronisation_Status$FctList_1.fctCurrentPositionInfoIsToBeSynchronised && this.fctTurnToInfoIsToBeSynchronised == functionSynchronisation_Status$FctList_1.fctTurnToInfoIsToBeSynchronised && this.fctDistanceToDestinationIsToBeSynchronised == functionSynchronisation_Status$FctList_1.fctDistanceToDestinationIsToBeSynchronised && this.fctTimeToDestinationIsToBeSynchronised == functionSynchronisation_Status$FctList_1.fctTimeToDestinationIsToBeSynchronised && this.fctManeuverDescriptorIsToBeSynchronised == functionSynchronisation_Status$FctList_1.fctManeuverDescriptorIsToBeSynchronised && this.fctLaneGuidanceIsToBeSynchronised == functionSynchronisation_Status$FctList_1.fctLaneGuidanceIsToBeSynchronised && this.fctTmcinfoIsToBeSynchronised == functionSynchronisation_Status$FctList_1.fctTmcinfoIsToBeSynchronised && this.fctMagnetFieldZoneIsToBeSynchronised == functionSynchronisation_Status$FctList_1.fctMagnetFieldZoneIsToBeSynchronised && this.fctCalibrationIsToBeSynchronised == functionSynchronisation_Status$FctList_1.fctCalibrationIsToBeSynchronised && this.reserved_bit_28 == functionSynchronisation_Status$FctList_1.reserved_bit_28 && this.fctLastDest_ListIsToBeSynchronised == functionSynchronisation_Status$FctList_1.fctLastDest_ListIsToBeSynchronised && this.fctFavoriteDest_ListIsToBeSynchronised == functionSynchronisation_Status$FctList_1.fctFavoriteDest_ListIsToBeSynchronised && this.fctPreferredDest_ListIsToBeSynchronised == functionSynchronisation_Status$FctList_1.fctPreferredDest_ListIsToBeSynchronised && this.fctNavBookIsToBeSynchronised == functionSynchronisation_Status$FctList_1.fctNavBookIsToBeSynchronised && this.fctAddress_ListIsToBeSynchronised == functionSynchronisation_Status$FctList_1.fctAddress_ListIsToBeSynchronised && this.fctRg_ActDeactIsToBeSynchronised == functionSynchronisation_Status$FctList_1.fctRg_ActDeactIsToBeSynchronised && this.reserved_bit_35 == functionSynchronisation_Status$FctList_1.reserved_bit_35 && this.fctVoiceGuidanceIsToBeSynchronised == functionSynchronisation_Status$FctList_1.fctVoiceGuidanceIsToBeSynchronised && this.reserved_bit_37 == functionSynchronisation_Status$FctList_1.reserved_bit_37 && this.fctInfoStatesIsToBeSynchronised == functionSynchronisation_Status$FctList_1.fctInfoStatesIsToBeSynchronised && this.fctActiveRgTypeIsToBeSynchronised == functionSynchronisation_Status$FctList_1.fctActiveRgTypeIsToBeSynchronised && this.fctTrafficBlock_IndicationIsToBeSynchronised == functionSynchronisation_Status$FctList_1.fctTrafficBlock_IndicationIsToBeSynchronised && this.fct_MapColorAndTypeIsToBeSynchronised == functionSynchronisation_Status$FctList_1.fct_MapColorAndTypeIsToBeSynchronised && this.fct_MapViewAndOrientationIsToBeSynchronised == functionSynchronisation_Status$FctList_1.fct_MapViewAndOrientationIsToBeSynchronised && this.fct_MapScaleIsToBeSynchronised == functionSynchronisation_Status$FctList_1.fct_MapScaleIsToBeSynchronised && this.fct_DestinationInfoIsToBeSynchronised == functionSynchronisation_Status$FctList_1.fct_DestinationInfoIsToBeSynchronised && this.fct_AltitudeIsToBeSynchronised == functionSynchronisation_Status$FctList_1.fct_AltitudeIsToBeSynchronised;
    }

    private void customInitialization() {
    }

    @Override
    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("FctList_1:");
        stringBuffer.append("\n - Bit 16: ");
        if (this.fctCompassInfoIsToBeSynchronised) {
            stringBuffer.append("true  (Fct CompassInfo is to be synchronised");
        } else {
            stringBuffer.append("false  (Fct CompassInfo is not to be synchronised");
        }
        stringBuffer.append("\n - Bit 17: ");
        if (this.fctRg_StatusIsToBeSynchronised) {
            stringBuffer.append("true  (Fct RG_Status is to be synchronised");
        } else {
            stringBuffer.append("false  (Fct RG_Status is not to be synchronised");
        }
        stringBuffer.append("\n - Bit 18: ");
        if (this.fctDistanceToNextManeuverIsToBeSynchronised) {
            stringBuffer.append("true  (Fct DistanceToNextManeuver is to be synchronised");
        } else {
            stringBuffer.append("false  (Fct DistanceToNextManeuver is not to be synchronised");
        }
        stringBuffer.append("\n - Bit 19: ");
        if (this.fctCurrentPositionInfoIsToBeSynchronised) {
            stringBuffer.append("true  (Fct CurrentPositionInfo is to be synchronised");
        } else {
            stringBuffer.append("false  (Fct CurrentPositionInfo is not to be synchronised");
        }
        stringBuffer.append("\n - Bit 20: ");
        if (this.fctTurnToInfoIsToBeSynchronised) {
            stringBuffer.append("true  (Fct TurnToInfo is to be synchronised");
        } else {
            stringBuffer.append("false  (Fct TurnToInfo is not to be synchronised");
        }
        stringBuffer.append("\n - Bit 21: ");
        if (this.fctDistanceToDestinationIsToBeSynchronised) {
            stringBuffer.append("true  (Fct DistanceToDestination is to be synchronised");
        } else {
            stringBuffer.append("false  (Fct DistanceToDestination is not to be synchronised");
        }
        stringBuffer.append("\n - Bit 22: ");
        if (this.fctTimeToDestinationIsToBeSynchronised) {
            stringBuffer.append("true  (Fct TimeToDestination is to be synchronised");
        } else {
            stringBuffer.append("false  (Fct TimeToDestination is not to be synchronised");
        }
        stringBuffer.append("\n - Bit 23: ");
        if (this.fctManeuverDescriptorIsToBeSynchronised) {
            stringBuffer.append("true  (Fct ManeuverDescriptor is to be synchronised");
        } else {
            stringBuffer.append("false  (Fct ManeuverDescriptor is not to be synchronised");
        }
        stringBuffer.append("\n - Bit 24: ");
        if (this.fctLaneGuidanceIsToBeSynchronised) {
            stringBuffer.append("true  (Fct LaneGuidance is to be synchronised");
        } else {
            stringBuffer.append("false  (Fct LaneGuidance is not to be synchronised");
        }
        stringBuffer.append("\n - Bit 25: ");
        if (this.fctTmcinfoIsToBeSynchronised) {
            stringBuffer.append("true  (Fct TMCinfo is to be synchronised");
        } else {
            stringBuffer.append("false  (Fct TMCinfo is not to be synchronised");
        }
        stringBuffer.append("\n - Bit 26: ");
        if (this.fctMagnetFieldZoneIsToBeSynchronised) {
            stringBuffer.append("true  (Fct MagnetFieldZone is to be synchronised");
        } else {
            stringBuffer.append("false  (Fct MagnetFieldZone is not to be synchronised");
        }
        stringBuffer.append("\n - Bit 27: ");
        if (this.fctCalibrationIsToBeSynchronised) {
            stringBuffer.append("true  (Fct Calibration is to be synchronised");
        } else {
            stringBuffer.append("false  (Fct Calibration is not to be synchronised");
        }
        stringBuffer.append("\n - Bit 28: ");
        if (this.reserved_bit_28) {
            stringBuffer.append("true  (reserved");
        } else {
            stringBuffer.append("false  (reserved");
        }
        stringBuffer.append("\n - Bit 29: ");
        if (this.fctLastDest_ListIsToBeSynchronised) {
            stringBuffer.append("true  (Fct LastDest_List is to be synchronised");
        } else {
            stringBuffer.append("false  (Fct LastDest_List is not to be synchronised");
        }
        stringBuffer.append("\n - Bit 30: ");
        if (this.fctFavoriteDest_ListIsToBeSynchronised) {
            stringBuffer.append("true  (Fct FavoriteDest_List is to be synchronised");
        } else {
            stringBuffer.append("false  (Fct FavoriteDest_List is not to be synchronised");
        }
        stringBuffer.append("\n - Bit 31: ");
        if (this.fctPreferredDest_ListIsToBeSynchronised) {
            stringBuffer.append("true  (Fct PreferredDest_List is to be synchronised");
        } else {
            stringBuffer.append("false  (Fct PreferredDest_List is not to be synchronised");
        }
        stringBuffer.append("\n - Bit 32: ");
        if (this.fctNavBookIsToBeSynchronised) {
            stringBuffer.append("true  (Fct NavBook is to be synchronised");
        } else {
            stringBuffer.append("false  (Fct NavBook  is not to be synchronised");
        }
        stringBuffer.append("\n - Bit 33: ");
        if (this.fctAddress_ListIsToBeSynchronised) {
            stringBuffer.append("true  (Fct Address_List  is to be synchronised");
        } else {
            stringBuffer.append("false  (Fct Address_List  is not to be synchronised");
        }
        stringBuffer.append("\n - Bit 34: ");
        if (this.fctRg_ActDeactIsToBeSynchronised) {
            stringBuffer.append("true  (Fct RG_ActDeact is to be synchronised");
        } else {
            stringBuffer.append("false  (Fct RG_ActDeact is not to be synchronised");
        }
        stringBuffer.append("\n - Bit 35: ");
        if (this.reserved_bit_35) {
            stringBuffer.append("true  (reserved");
        } else {
            stringBuffer.append("false  (reserved");
        }
        stringBuffer.append("\n - Bit 36: ");
        if (this.fctVoiceGuidanceIsToBeSynchronised) {
            stringBuffer.append("true  (Fct VoiceGuidance is to be synchronised");
        } else {
            stringBuffer.append("false  (Fct VoiceGuidance is not to be synchronised");
        }
        stringBuffer.append("\n - Bit 37: ");
        if (this.reserved_bit_37) {
            stringBuffer.append("true  (reserved");
        } else {
            stringBuffer.append("false  (reserved");
        }
        stringBuffer.append("\n - Bit 38: ");
        if (this.fctInfoStatesIsToBeSynchronised) {
            stringBuffer.append("true  (Fct InfoStates is to be synchronised");
        } else {
            stringBuffer.append("false  (Fct InfoStates is not to be synchronised");
        }
        stringBuffer.append("\n - Bit 39: ");
        if (this.fctActiveRgTypeIsToBeSynchronised) {
            stringBuffer.append("true  (Fct ActiveRgType is to be synchronised");
        } else {
            stringBuffer.append("false  (Fct ActiveRgType is not to be synchronised");
        }
        stringBuffer.append("\n - Bit 40: ");
        if (this.fctTrafficBlock_IndicationIsToBeSynchronised) {
            stringBuffer.append("true  (Fct TrafficBlock_Indication is to be synchronised");
        } else {
            stringBuffer.append("false  (Fct TrafficBlock_Indication is not to be synchronised");
        }
        stringBuffer.append("\n - Bit 43: ");
        if (this.fct_MapColorAndTypeIsToBeSynchronised) {
            stringBuffer.append("true  (Fct. MapColorAndType is to be synchronised");
        } else {
            stringBuffer.append("false  (Fct. MapColorAndType is not to be synchronised");
        }
        stringBuffer.append("\n - Bit 44: ");
        if (this.fct_MapViewAndOrientationIsToBeSynchronised) {
            stringBuffer.append("true  (Fct. MapViewAndOrientation is to be synchronised");
        } else {
            stringBuffer.append("false  (Fct. MapViewAndOrientation is not to be synchronised");
        }
        stringBuffer.append("\n - Bit 45: ");
        if (this.fct_MapScaleIsToBeSynchronised) {
            stringBuffer.append("true  (Fct. MapScale is to be synchronised");
        } else {
            stringBuffer.append("false  (Fct. MapScale is not to be synchronised");
        }
        stringBuffer.append("\n - Bit 46: ");
        if (this.fct_DestinationInfoIsToBeSynchronised) {
            stringBuffer.append("true  (Fct. DestinationInfo is to be synchronised");
        } else {
            stringBuffer.append("false  (Fct. DestinationInfo is not to be synchronised");
        }
        stringBuffer.append("\n - Bit 47: ");
        if (this.fct_AltitudeIsToBeSynchronised) {
            stringBuffer.append("true  (Fct. Altitude is to be synchronised");
        } else {
            stringBuffer.append("false  (Fct. Altitude is not to be synchronised");
        }
        return stringBuffer.toString();
    }

    @Override
    public int bitSize() {
        int n = 0;
        return n += 48;
    }

    @Override
    public void serialize(BitStream bitStream) {
        bitStream.resetBits(16);
        bitStream.pushBoolean(this.fctCompassInfoIsToBeSynchronised);
        bitStream.pushBoolean(this.fctRg_StatusIsToBeSynchronised);
        bitStream.pushBoolean(this.fctDistanceToNextManeuverIsToBeSynchronised);
        bitStream.pushBoolean(this.fctCurrentPositionInfoIsToBeSynchronised);
        bitStream.pushBoolean(this.fctTurnToInfoIsToBeSynchronised);
        bitStream.pushBoolean(this.fctDistanceToDestinationIsToBeSynchronised);
        bitStream.pushBoolean(this.fctTimeToDestinationIsToBeSynchronised);
        bitStream.pushBoolean(this.fctManeuverDescriptorIsToBeSynchronised);
        bitStream.pushBoolean(this.fctLaneGuidanceIsToBeSynchronised);
        bitStream.pushBoolean(this.fctTmcinfoIsToBeSynchronised);
        bitStream.pushBoolean(this.fctMagnetFieldZoneIsToBeSynchronised);
        bitStream.pushBoolean(this.fctCalibrationIsToBeSynchronised);
        bitStream.pushBoolean(this.reserved_bit_28);
        bitStream.pushBoolean(this.fctLastDest_ListIsToBeSynchronised);
        bitStream.pushBoolean(this.fctFavoriteDest_ListIsToBeSynchronised);
        bitStream.pushBoolean(this.fctPreferredDest_ListIsToBeSynchronised);
        bitStream.pushBoolean(this.fctNavBookIsToBeSynchronised);
        bitStream.pushBoolean(this.fctAddress_ListIsToBeSynchronised);
        bitStream.pushBoolean(this.fctRg_ActDeactIsToBeSynchronised);
        bitStream.pushBoolean(this.reserved_bit_35);
        bitStream.pushBoolean(this.fctVoiceGuidanceIsToBeSynchronised);
        bitStream.pushBoolean(this.reserved_bit_37);
        bitStream.pushBoolean(this.fctInfoStatesIsToBeSynchronised);
        bitStream.pushBoolean(this.fctActiveRgTypeIsToBeSynchronised);
        bitStream.pushBoolean(this.fctTrafficBlock_IndicationIsToBeSynchronised);
        bitStream.resetBits(2);
        bitStream.pushBoolean(this.fct_MapColorAndTypeIsToBeSynchronised);
        bitStream.pushBoolean(this.fct_MapViewAndOrientationIsToBeSynchronised);
        bitStream.pushBoolean(this.fct_MapScaleIsToBeSynchronised);
        bitStream.pushBoolean(this.fct_DestinationInfoIsToBeSynchronised);
        bitStream.pushBoolean(this.fct_AltitudeIsToBeSynchronised);
    }

    @Override
    public void deserialize(BitStream bitStream) {
        bitStream.discardBits(16);
        this.fctCompassInfoIsToBeSynchronised = bitStream.popFrontBoolean();
        this.fctRg_StatusIsToBeSynchronised = bitStream.popFrontBoolean();
        this.fctDistanceToNextManeuverIsToBeSynchronised = bitStream.popFrontBoolean();
        this.fctCurrentPositionInfoIsToBeSynchronised = bitStream.popFrontBoolean();
        this.fctTurnToInfoIsToBeSynchronised = bitStream.popFrontBoolean();
        this.fctDistanceToDestinationIsToBeSynchronised = bitStream.popFrontBoolean();
        this.fctTimeToDestinationIsToBeSynchronised = bitStream.popFrontBoolean();
        this.fctManeuverDescriptorIsToBeSynchronised = bitStream.popFrontBoolean();
        this.fctLaneGuidanceIsToBeSynchronised = bitStream.popFrontBoolean();
        this.fctTmcinfoIsToBeSynchronised = bitStream.popFrontBoolean();
        this.fctMagnetFieldZoneIsToBeSynchronised = bitStream.popFrontBoolean();
        this.fctCalibrationIsToBeSynchronised = bitStream.popFrontBoolean();
        this.reserved_bit_28 = bitStream.popFrontBoolean();
        this.fctLastDest_ListIsToBeSynchronised = bitStream.popFrontBoolean();
        this.fctFavoriteDest_ListIsToBeSynchronised = bitStream.popFrontBoolean();
        this.fctPreferredDest_ListIsToBeSynchronised = bitStream.popFrontBoolean();
        this.fctNavBookIsToBeSynchronised = bitStream.popFrontBoolean();
        this.fctAddress_ListIsToBeSynchronised = bitStream.popFrontBoolean();
        this.fctRg_ActDeactIsToBeSynchronised = bitStream.popFrontBoolean();
        this.reserved_bit_35 = bitStream.popFrontBoolean();
        this.fctVoiceGuidanceIsToBeSynchronised = bitStream.popFrontBoolean();
        this.reserved_bit_37 = bitStream.popFrontBoolean();
        this.fctInfoStatesIsToBeSynchronised = bitStream.popFrontBoolean();
        this.fctActiveRgTypeIsToBeSynchronised = bitStream.popFrontBoolean();
        this.fctTrafficBlock_IndicationIsToBeSynchronised = bitStream.popFrontBoolean();
        bitStream.discardBits(2);
        this.fct_MapColorAndTypeIsToBeSynchronised = bitStream.popFrontBoolean();
        this.fct_MapViewAndOrientationIsToBeSynchronised = bitStream.popFrontBoolean();
        this.fct_MapScaleIsToBeSynchronised = bitStream.popFrontBoolean();
        this.fct_DestinationInfoIsToBeSynchronised = bitStream.popFrontBoolean();
        this.fct_AltitudeIsToBeSynchronised = bitStream.popFrontBoolean();
    }
}

