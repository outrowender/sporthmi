/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.generated.navsd.serializer;

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
        return 37;
    }

    public int getFunctionId() {
        return FunctionSynchronisation_Status.functionId();
    }

    public static final class FctList_1
    implements BAPEntity {
        private static final int RESERVED_BIT_0__15_BITSIZE = 16;
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
        private static final int RESERVED_BIT_41__42_BITSIZE = 2;
        public boolean fct_MapColorAndTypeIsToBeSynchronised;
        public boolean fct_MapViewAndOrientationIsToBeSynchronised;
        public boolean fct_MapScaleIsToBeSynchronised;
        public boolean fct_DestinationInfoIsToBeSynchronised;
        public boolean fct_AltitudeIsToBeSynchronised;
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

        public void reset() {
            this.internalReset();
        }

        public boolean equalTo(BAPEntity bAPEntity) {
            FctList_1 fctList_1 = (FctList_1)bAPEntity;
            return this.fctCompassInfoIsToBeSynchronised == fctList_1.fctCompassInfoIsToBeSynchronised && this.fctRg_StatusIsToBeSynchronised == fctList_1.fctRg_StatusIsToBeSynchronised && this.fctDistanceToNextManeuverIsToBeSynchronised == fctList_1.fctDistanceToNextManeuverIsToBeSynchronised && this.fctCurrentPositionInfoIsToBeSynchronised == fctList_1.fctCurrentPositionInfoIsToBeSynchronised && this.fctTurnToInfoIsToBeSynchronised == fctList_1.fctTurnToInfoIsToBeSynchronised && this.fctDistanceToDestinationIsToBeSynchronised == fctList_1.fctDistanceToDestinationIsToBeSynchronised && this.fctTimeToDestinationIsToBeSynchronised == fctList_1.fctTimeToDestinationIsToBeSynchronised && this.fctManeuverDescriptorIsToBeSynchronised == fctList_1.fctManeuverDescriptorIsToBeSynchronised && this.fctLaneGuidanceIsToBeSynchronised == fctList_1.fctLaneGuidanceIsToBeSynchronised && this.fctTmcinfoIsToBeSynchronised == fctList_1.fctTmcinfoIsToBeSynchronised && this.fctMagnetFieldZoneIsToBeSynchronised == fctList_1.fctMagnetFieldZoneIsToBeSynchronised && this.fctCalibrationIsToBeSynchronised == fctList_1.fctCalibrationIsToBeSynchronised && this.reserved_bit_28 == fctList_1.reserved_bit_28 && this.fctLastDest_ListIsToBeSynchronised == fctList_1.fctLastDest_ListIsToBeSynchronised && this.fctFavoriteDest_ListIsToBeSynchronised == fctList_1.fctFavoriteDest_ListIsToBeSynchronised && this.fctPreferredDest_ListIsToBeSynchronised == fctList_1.fctPreferredDest_ListIsToBeSynchronised && this.fctNavBookIsToBeSynchronised == fctList_1.fctNavBookIsToBeSynchronised && this.fctAddress_ListIsToBeSynchronised == fctList_1.fctAddress_ListIsToBeSynchronised && this.fctRg_ActDeactIsToBeSynchronised == fctList_1.fctRg_ActDeactIsToBeSynchronised && this.reserved_bit_35 == fctList_1.reserved_bit_35 && this.fctVoiceGuidanceIsToBeSynchronised == fctList_1.fctVoiceGuidanceIsToBeSynchronised && this.reserved_bit_37 == fctList_1.reserved_bit_37 && this.fctInfoStatesIsToBeSynchronised == fctList_1.fctInfoStatesIsToBeSynchronised && this.fctActiveRgTypeIsToBeSynchronised == fctList_1.fctActiveRgTypeIsToBeSynchronised && this.fctTrafficBlock_IndicationIsToBeSynchronised == fctList_1.fctTrafficBlock_IndicationIsToBeSynchronised && this.fct_MapColorAndTypeIsToBeSynchronised == fctList_1.fct_MapColorAndTypeIsToBeSynchronised && this.fct_MapViewAndOrientationIsToBeSynchronised == fctList_1.fct_MapViewAndOrientationIsToBeSynchronised && this.fct_MapScaleIsToBeSynchronised == fctList_1.fct_MapScaleIsToBeSynchronised && this.fct_DestinationInfoIsToBeSynchronised == fctList_1.fct_DestinationInfoIsToBeSynchronised && this.fct_AltitudeIsToBeSynchronised == fctList_1.fct_AltitudeIsToBeSynchronised;
        }

        private void customInitialization() {
        }

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

        public int bitSize() {
            int n = 0;
            return n += 48;
        }

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

    public static final class FctList_2
    implements BAPEntity {
        public boolean fct_OnlineNavigationStateIsToBeSynchronised;
        public boolean fct_ExitViewIsToBeSynchronised;
        public boolean fct_SemidynamicRouteGuidanceIsToBeSynchronised;
        private static final int RESERVED_BIT_3__4_BITSIZE = 2;
        public boolean fct_Fsg_SetupIsToBeSynchronised;
        public boolean fct_MapPresentationIsToBeSynchronised;
        public boolean reserved_bit_7;
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
            this.fct_OnlineNavigationStateIsToBeSynchronised = false;
            this.fct_ExitViewIsToBeSynchronised = false;
            this.fct_SemidynamicRouteGuidanceIsToBeSynchronised = false;
            this.fct_Fsg_SetupIsToBeSynchronised = false;
            this.fct_MapPresentationIsToBeSynchronised = false;
            this.reserved_bit_7 = false;
        }

        public void reset() {
            this.internalReset();
        }

        public boolean equalTo(BAPEntity bAPEntity) {
            FctList_2 fctList_2 = (FctList_2)bAPEntity;
            return this.fct_OnlineNavigationStateIsToBeSynchronised == fctList_2.fct_OnlineNavigationStateIsToBeSynchronised && this.fct_ExitViewIsToBeSynchronised == fctList_2.fct_ExitViewIsToBeSynchronised && this.fct_SemidynamicRouteGuidanceIsToBeSynchronised == fctList_2.fct_SemidynamicRouteGuidanceIsToBeSynchronised && this.fct_Fsg_SetupIsToBeSynchronised == fctList_2.fct_Fsg_SetupIsToBeSynchronised && this.fct_MapPresentationIsToBeSynchronised == fctList_2.fct_MapPresentationIsToBeSynchronised && this.reserved_bit_7 == fctList_2.reserved_bit_7;
        }

        private void customInitialization() {
        }

        public String toString() {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("FctList_2:");
            stringBuffer.append("\n - Bit 0: ");
            if (this.fct_OnlineNavigationStateIsToBeSynchronised) {
                stringBuffer.append("true  (Fct. OnlineNavigationState is to be synchronised");
            } else {
                stringBuffer.append("false  (Fct. OnlineNavigationState is not to be synchronised");
            }
            stringBuffer.append("\n - Bit 1: ");
            if (this.fct_ExitViewIsToBeSynchronised) {
                stringBuffer.append("true  (Fct. ExitView is to be synchronised");
            } else {
                stringBuffer.append("false  (Fct. ExitView is not to be synchronised");
            }
            stringBuffer.append("\n - Bit 2: ");
            if (this.fct_SemidynamicRouteGuidanceIsToBeSynchronised) {
                stringBuffer.append("true  (Fct. SemidynamicRouteGuidance is to be synchronised");
            } else {
                stringBuffer.append("false  (Fct. SemidynamicRouteGuidance is not to be synchronised");
            }
            stringBuffer.append("\n - Bit 5: ");
            if (this.fct_Fsg_SetupIsToBeSynchronised) {
                stringBuffer.append("true  (Fct. FSG_Setup is to be synchronised");
            } else {
                stringBuffer.append("false  (Fct. FSG_Setup is not to be synchronised");
            }
            stringBuffer.append("\n - Bit 6: ");
            if (this.fct_MapPresentationIsToBeSynchronised) {
                stringBuffer.append("true  (Fct. MapPresentation is to be synchronised");
            } else {
                stringBuffer.append("false  (Fct. MapPresentation is not to be synchronised");
            }
            stringBuffer.append("\n - Bit 7: ");
            if (this.reserved_bit_7) {
                stringBuffer.append("true  (reserved");
            } else {
                stringBuffer.append("false  (reserved");
            }
            return stringBuffer.toString();
        }

        public int bitSize() {
            int n = 0;
            return n += 8;
        }

        public void serialize(BitStream bitStream) {
            bitStream.pushBoolean(this.fct_OnlineNavigationStateIsToBeSynchronised);
            bitStream.pushBoolean(this.fct_ExitViewIsToBeSynchronised);
            bitStream.pushBoolean(this.fct_SemidynamicRouteGuidanceIsToBeSynchronised);
            bitStream.resetBits(2);
            bitStream.pushBoolean(this.fct_Fsg_SetupIsToBeSynchronised);
            bitStream.pushBoolean(this.fct_MapPresentationIsToBeSynchronised);
            bitStream.pushBoolean(this.reserved_bit_7);
        }

        public void deserialize(BitStream bitStream) {
            this.fct_OnlineNavigationStateIsToBeSynchronised = bitStream.popFrontBoolean();
            this.fct_ExitViewIsToBeSynchronised = bitStream.popFrontBoolean();
            this.fct_SemidynamicRouteGuidanceIsToBeSynchronised = bitStream.popFrontBoolean();
            bitStream.discardBits(2);
            this.fct_Fsg_SetupIsToBeSynchronised = bitStream.popFrontBoolean();
            this.fct_MapPresentationIsToBeSynchronised = bitStream.popFrontBoolean();
            this.reserved_bit_7 = bitStream.popFrontBoolean();
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

