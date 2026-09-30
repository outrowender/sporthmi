/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.generated.navsd.serializer;

import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.datatypes.BAPString;
import de.vw.mib.bap.requests.StatusProperty;
import de.vw.mib.bap.stream.BitStream;

public final class ManeuverDescriptor_Status
implements StatusProperty {
    public final Maneuver_1 maneuver_1 = new Maneuver_1();
    public final Maneuver_2 maneuver_2 = new Maneuver_2();
    public final Maneuver_3 maneuver_3 = new Maneuver_3();

    public ManeuverDescriptor_Status() {
        this.internalReset();
        this.customInitialization();
    }

    public ManeuverDescriptor_Status(BitStream bitStream) {
        this();
        this.deserialize(bitStream);
    }

    private void internalReset() {
    }

    public void reset() {
        this.internalReset();
        this.maneuver_1.reset();
        this.maneuver_2.reset();
        this.maneuver_3.reset();
    }

    public boolean equalTo(BAPEntity bAPEntity) {
        ManeuverDescriptor_Status maneuverDescriptor_Status = (ManeuverDescriptor_Status)bAPEntity;
        return this.maneuver_1.equalTo(maneuverDescriptor_Status.maneuver_1) && this.maneuver_2.equalTo(maneuverDescriptor_Status.maneuver_2) && this.maneuver_3.equalTo(maneuverDescriptor_Status.maneuver_3);
    }

    private void customInitialization() {
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("ManeuverDescriptor_Status:");
        stringBuffer.append("\n - Maneuver_1 - ");
        stringBuffer.append(this.maneuver_1.toString());
        stringBuffer.append("\n - Maneuver_2 - ");
        stringBuffer.append(this.maneuver_2.toString());
        stringBuffer.append("\n - Maneuver_3 - ");
        stringBuffer.append(this.maneuver_3.toString());
        return stringBuffer.toString();
    }

    public int bitSize() {
        int n = 0;
        n += this.maneuver_1.bitSize();
        n += this.maneuver_2.bitSize();
        return n += this.maneuver_3.bitSize();
    }

    public void serialize(BitStream bitStream) {
        this.maneuver_1.serialize(bitStream);
        this.maneuver_2.serialize(bitStream);
        this.maneuver_3.serialize(bitStream);
    }

    public void deserialize(BitStream bitStream) {
        this.maneuver_1.deserialize(bitStream);
        this.maneuver_2.deserialize(bitStream);
        this.maneuver_3.deserialize(bitStream);
    }

    public static int functionId() {
        return 23;
    }

    public int getFunctionId() {
        return ManeuverDescriptor_Status.functionId();
    }

    public static final class Maneuver_1
    implements BAPEntity {
        public int mainElement;
        private static final int MAIN_ELEMENT_BITSIZE = 8;
        public static final int MAIN_ELEMENT_NO_SYMBOL = 0;
        public static final int MAIN_ELEMENT_NO_INFO = 1;
        public static final int MAIN_ELEMENT_DIRECTION_TO_DESTINATION = 2;
        public static final int MAIN_ELEMENT_ARRIVED = 3;
        public static final int MAIN_ELEMENT_NEAR_DESTINATION = 4;
        public static final int MAIN_ELEMENT_ARRIVED_DESTINATION_OFFMAP = 5;
        public static final int MAIN_ELEMENT_OFF_ROAD = 6;
        public static final int MAIN_ELEMENT_OFF_MAP = 7;
        public static final int MAIN_ELEMENT_NO_ROUTE = 8;
        public static final int MAIN_ELEMENT_CALC_ROUTE = 9;
        public static final int MAIN_ELEMENT_RECALC_ROUTE = 10;
        public static final int MAIN_ELEMENT_FOLLOW_STREET = 11;
        public static final int MAIN_ELEMENT_CHANGE_LANE = 12;
        public static final int MAIN_ELEMENT_TURN = 13;
        public static final int MAIN_ELEMENT_TURN_ON_MAINROAD = 14;
        public static final int MAIN_ELEMENT_EXIT_RIGHT = 15;
        public static final int MAIN_ELEMENT_EXIT_LEFT = 16;
        public static final int MAIN_ELEMENT_SERVICE_ROAD_RIGHT = 17;
        public static final int MAIN_ELEMENT_SERVICE_ROAD_LEFT = 18;
        public static final int MAIN_ELEMENT_FORK_2 = 19;
        public static final int MAIN_ELEMENT_FORK_3 = 20;
        public static final int MAIN_ELEMENT_ROUNDABOUT_TRS_RIGHT = 21;
        public static final int MAIN_ELEMENT_ROUNDABOUT_TRS_LEFT = 22;
        public static final int MAIN_ELEMENT_SQUARE_TRS_RIGHT = 23;
        public static final int MAIN_ELEMENT_SQUARE_TRS_LEFT = 24;
        public static final int MAIN_ELEMENT_UTURN = 25;
        public static final int MAIN_ELEMENT_EXIT_ROUNDABOUT_TRS_RIGHT = 26;
        public static final int MAIN_ELEMENT_EXIT_ROUNDABOUT_TRS_LEFT = 27;
        public static final int MAIN_ELEMENT_PREPARE_TURN = 28;
        public static final int MAIN_ELEMENT_PREPARE_ROUNDABOUT = 29;
        public static final int MAIN_ELEMENT_PREPARE_SQUARE = 30;
        public static final int MAIN_ELEMENT_PREPARE_U_TURN = 31;
        public static final int MAIN_ELEMENT_MICHIGANG_TURN = 34;
        public static final int MAIN_ELEMENT_DOUBLE_TURN = 35;
        public static final int MAIN_ELEMENT_DIRECTION_TO_WAYPOINT = 38;
        public int direction;
        private static final int DIRECTION_BITSIZE = 8;
        public int zLevelGuidance;
        private static final int Z_LEVEL_GUIDANCE_BITSIZE = 8;
        public static final int Z_LEVEL_GUIDANCE_NO_Z_LEVEL_GUIDANCE = 0;
        public static final int Z_LEVEL_GUIDANCE_UP = 1;
        public static final int Z_LEVEL_GUIDANCE_DOWN = 2;
        public static final int Z_LEVEL_GUIDANCE_NOT_SUPPORTED = 255;
        public final BAPString sidestreets = new BAPString(17);
        private static final int MAX_SIDESTREETS_LENGTH = 17;

        public Maneuver_1() {
            this.internalReset();
            this.customInitialization();
        }

        public Maneuver_1(BitStream bitStream) {
            this();
            this.deserialize(bitStream);
        }

        private void internalReset() {
            this.mainElement = 0;
            this.direction = 0;
            this.zLevelGuidance = 0;
        }

        public void reset() {
            this.internalReset();
            this.sidestreets.reset();
        }

        public boolean equalTo(BAPEntity bAPEntity) {
            Maneuver_1 maneuver_1 = (Maneuver_1)bAPEntity;
            return this.mainElement == maneuver_1.mainElement && this.direction == maneuver_1.direction && this.zLevelGuidance == maneuver_1.zLevelGuidance && this.sidestreets.equalTo(maneuver_1.sidestreets);
        }

        private void customInitialization() {
            this.sidestreets.setRawContent();
        }

        public String toString() {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("Maneuver_1:");
            stringBuffer.append("\n - MainElement: ");
            switch (this.mainElement) {
                case 0: {
                    stringBuffer.append("0x00 (NoSymbol)");
                    break;
                }
                case 1: {
                    stringBuffer.append("0x01 (NoInfo)");
                    break;
                }
                case 2: {
                    stringBuffer.append("0x02 (DirectionToDestination)");
                    break;
                }
                case 3: {
                    stringBuffer.append("0x03 (Arrived)");
                    break;
                }
                case 4: {
                    stringBuffer.append("0x04 (NearDestination)");
                    break;
                }
                case 5: {
                    stringBuffer.append("0x05 (ArrivedDestinationOffmap)");
                    break;
                }
                case 6: {
                    stringBuffer.append("0x06 (OffRoad)");
                    break;
                }
                case 7: {
                    stringBuffer.append("0x07 (OffMap)");
                    break;
                }
                case 8: {
                    stringBuffer.append("0x08 (NoRoute)");
                    break;
                }
                case 9: {
                    stringBuffer.append("0x09 (CalcRoute)");
                    break;
                }
                case 10: {
                    stringBuffer.append("0x0A (RecalcRoute)");
                    break;
                }
                case 11: {
                    stringBuffer.append("0x0B (FollowStreet)");
                    break;
                }
                case 12: {
                    stringBuffer.append("0x0C (ChangeLane)");
                    break;
                }
                case 13: {
                    stringBuffer.append("0x0D (Turn)");
                    break;
                }
                case 14: {
                    stringBuffer.append("0x0E (TurnOnMainroad)");
                    break;
                }
                case 15: {
                    stringBuffer.append("0x0F (ExitRight)");
                    break;
                }
                case 16: {
                    stringBuffer.append("0x10 (ExitLeft)");
                    break;
                }
                case 17: {
                    stringBuffer.append("0x11 (ServiceRoadRight)");
                    break;
                }
                case 18: {
                    stringBuffer.append("0x12 (ServiceRoadLeft)");
                    break;
                }
                case 19: {
                    stringBuffer.append("0x13 (Fork-2)");
                    break;
                }
                case 20: {
                    stringBuffer.append("0x14 (Fork-3)");
                    break;
                }
                case 21: {
                    stringBuffer.append("0x15 (RoundaboutTrsRight)");
                    break;
                }
                case 22: {
                    stringBuffer.append("0x16 (RoundaboutTrsLeft)");
                    break;
                }
                case 23: {
                    stringBuffer.append("0x17 (SquareTrsRight)");
                    break;
                }
                case 24: {
                    stringBuffer.append("0x18 (SquareTrsLeft)");
                    break;
                }
                case 25: {
                    stringBuffer.append("0x19 (Uturn)");
                    break;
                }
                case 26: {
                    stringBuffer.append("0x1A (ExitRoundaboutTrsRight)");
                    break;
                }
                case 27: {
                    stringBuffer.append("0x1B (ExitRoundaboutTrsLeft)");
                    break;
                }
                case 28: {
                    stringBuffer.append("0x1C (PrepareTurn)");
                    break;
                }
                case 29: {
                    stringBuffer.append("0x1D (PrepareRoundabout)");
                    break;
                }
                case 30: {
                    stringBuffer.append("0x1E (PrepareSquare)");
                    break;
                }
                case 31: {
                    stringBuffer.append("0x1F (PrepareUTurn)");
                    break;
                }
                case 34: {
                    stringBuffer.append("0x22 (MichigangTurn)");
                    break;
                }
                case 35: {
                    stringBuffer.append("0x23 (DoubleTurn)");
                    break;
                }
                case 38: {
                    stringBuffer.append("0x26 (DirectionToWaypoint)");
                    break;
                }
                default: {
                    stringBuffer.append("UNKNOWN ENUM");
                }
            }
            stringBuffer.append("\n - Direction - ");
            stringBuffer.append(this.direction);
            stringBuffer.append("\n - Z-LevelGuidance: ");
            switch (this.zLevelGuidance) {
                case 0: {
                    stringBuffer.append("0x00 (no Z-LevelGuidance)");
                    break;
                }
                case 1: {
                    stringBuffer.append("0x01 (up)");
                    break;
                }
                case 2: {
                    stringBuffer.append("0x02 (down)");
                    break;
                }
                case 255: {
                    stringBuffer.append("0xFF (not supported)");
                    break;
                }
                default: {
                    stringBuffer.append("UNKNOWN ENUM");
                }
            }
            stringBuffer.append("\n - Sidestreets - ");
            stringBuffer.append(this.sidestreets.toString());
            return stringBuffer.toString();
        }

        public int bitSize() {
            int n = 0;
            n += 8;
            n += 8;
            n += 8;
            return n += this.sidestreets.bitSize();
        }

        public void serialize(BitStream bitStream) {
            bitStream.pushByte((byte)this.mainElement);
            bitStream.pushByte((byte)this.direction);
            bitStream.pushByte((byte)this.zLevelGuidance);
            this.sidestreets.serialize(bitStream);
        }

        public void deserialize(BitStream bitStream) {
            this.mainElement = bitStream.popFrontByte();
            this.direction = bitStream.popFrontByte();
            this.zLevelGuidance = bitStream.popFrontByte();
            this.sidestreets.deserialize(bitStream);
        }
    }

    public static final class Maneuver_2
    implements BAPEntity {
        public int mainElement;
        private static final int MAIN_ELEMENT_BITSIZE = 8;
        public static final int MAIN_ELEMENT_NO_SYMBOL = 0;
        public static final int MAIN_ELEMENT_NO_INFO = 1;
        public static final int MAIN_ELEMENT_DIRECTION_TO_DESTINATION = 2;
        public static final int MAIN_ELEMENT_ARRIVED = 3;
        public static final int MAIN_ELEMENT_NEAR_DESTINATION = 4;
        public static final int MAIN_ELEMENT_ARRIVED_DESTINATION_OFFMAP = 5;
        public static final int MAIN_ELEMENT_OFF_ROAD = 6;
        public static final int MAIN_ELEMENT_OFF_MAP = 7;
        public static final int MAIN_ELEMENT_NO_ROUTE = 8;
        public static final int MAIN_ELEMENT_CALC_ROUTE = 9;
        public static final int MAIN_ELEMENT_RECALC_ROUTE = 10;
        public static final int MAIN_ELEMENT_FOLLOW_STREET = 11;
        public static final int MAIN_ELEMENT_CHANGE_LANE = 12;
        public static final int MAIN_ELEMENT_TURN = 13;
        public static final int MAIN_ELEMENT_TURN_ON_MAINROAD = 14;
        public static final int MAIN_ELEMENT_EXIT_RIGHT = 15;
        public static final int MAIN_ELEMENT_EXIT_LEFT = 16;
        public static final int MAIN_ELEMENT_SERVICE_ROAD_RIGHT = 17;
        public static final int MAIN_ELEMENT_SERVICE_ROAD_LEFT = 18;
        public static final int MAIN_ELEMENT_FORK_2 = 19;
        public static final int MAIN_ELEMENT_FORK_3 = 20;
        public static final int MAIN_ELEMENT_ROUNDABOUT_TRS_RIGHT = 21;
        public static final int MAIN_ELEMENT_ROUNDABOUT_TRS_LEFT = 22;
        public static final int MAIN_ELEMENT_SQUARE_TRS_RIGHT = 23;
        public static final int MAIN_ELEMENT_SQUARE_TRS_LEFT = 24;
        public static final int MAIN_ELEMENT_UTURN = 25;
        public static final int MAIN_ELEMENT_EXIT_ROUNDABOUT_TRS_RIGHT = 26;
        public static final int MAIN_ELEMENT_EXIT_ROUNDABOUT_TRS_LEFT = 27;
        public static final int MAIN_ELEMENT_PREPARE_TURN = 28;
        public static final int MAIN_ELEMENT_PREPARE_ROUNDABOUT = 29;
        public static final int MAIN_ELEMENT_PREPARE_SQUARE = 30;
        public static final int MAIN_ELEMENT_PREPARE_U_TURN = 31;
        public static final int MAIN_ELEMENT_MICHIGANG_TURN = 34;
        public static final int MAIN_ELEMENT_DOUBLE_TURN = 35;
        public static final int MAIN_ELEMENT_DIRECTION_TO_WAYPOINT = 38;
        public int direction;
        private static final int DIRECTION_BITSIZE = 8;
        public int zLevelGuidance;
        private static final int Z_LEVEL_GUIDANCE_BITSIZE = 8;
        public static final int Z_LEVEL_GUIDANCE_NO_Z_LEVEL_GUIDANCE = 0;
        public static final int Z_LEVEL_GUIDANCE_UP = 1;
        public static final int Z_LEVEL_GUIDANCE_DOWN = 2;
        public static final int Z_LEVEL_GUIDANCE_NOT_SUPPORTED = 255;
        public final BAPString sidestreets = new BAPString(17);
        private static final int MAX_SIDESTREETS_LENGTH = 17;

        public Maneuver_2() {
            this.internalReset();
            this.customInitialization();
        }

        public Maneuver_2(BitStream bitStream) {
            this();
            this.deserialize(bitStream);
        }

        private void internalReset() {
            this.mainElement = 0;
            this.direction = 0;
            this.zLevelGuidance = 0;
        }

        public void reset() {
            this.internalReset();
            this.sidestreets.reset();
        }

        public boolean equalTo(BAPEntity bAPEntity) {
            Maneuver_2 maneuver_2 = (Maneuver_2)bAPEntity;
            return this.mainElement == maneuver_2.mainElement && this.direction == maneuver_2.direction && this.zLevelGuidance == maneuver_2.zLevelGuidance && this.sidestreets.equalTo(maneuver_2.sidestreets);
        }

        private void customInitialization() {
            this.sidestreets.setRawContent();
        }

        public String toString() {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("Maneuver_2:");
            stringBuffer.append("\n - MainElement: ");
            switch (this.mainElement) {
                case 0: {
                    stringBuffer.append("0x00 (NoSymbol)");
                    break;
                }
                case 1: {
                    stringBuffer.append("0x01 (NoInfo)");
                    break;
                }
                case 2: {
                    stringBuffer.append("0x02 (DirectionToDestination)");
                    break;
                }
                case 3: {
                    stringBuffer.append("0x03 (Arrived)");
                    break;
                }
                case 4: {
                    stringBuffer.append("0x04 (NearDestination)");
                    break;
                }
                case 5: {
                    stringBuffer.append("0x05 (ArrivedDestinationOffmap)");
                    break;
                }
                case 6: {
                    stringBuffer.append("0x06 (OffRoad)");
                    break;
                }
                case 7: {
                    stringBuffer.append("0x07 (OffMap)");
                    break;
                }
                case 8: {
                    stringBuffer.append("0x08 (NoRoute)");
                    break;
                }
                case 9: {
                    stringBuffer.append("0x09 (CalcRoute)");
                    break;
                }
                case 10: {
                    stringBuffer.append("0x0A (RecalcRoute)");
                    break;
                }
                case 11: {
                    stringBuffer.append("0x0B (FollowStreet)");
                    break;
                }
                case 12: {
                    stringBuffer.append("0x0C (ChangeLane)");
                    break;
                }
                case 13: {
                    stringBuffer.append("0x0D (Turn)");
                    break;
                }
                case 14: {
                    stringBuffer.append("0x0E (TurnOnMainroad)");
                    break;
                }
                case 15: {
                    stringBuffer.append("0x0F (ExitRight)");
                    break;
                }
                case 16: {
                    stringBuffer.append("0x10 (ExitLeft)");
                    break;
                }
                case 17: {
                    stringBuffer.append("0x11 (ServiceRoadRight)");
                    break;
                }
                case 18: {
                    stringBuffer.append("0x12 (ServiceRoadLeft)");
                    break;
                }
                case 19: {
                    stringBuffer.append("0x13 (Fork-2)");
                    break;
                }
                case 20: {
                    stringBuffer.append("0x14 (Fork-3)");
                    break;
                }
                case 21: {
                    stringBuffer.append("0x15 (RoundaboutTrsRight)");
                    break;
                }
                case 22: {
                    stringBuffer.append("0x16 (RoundaboutTrsLeft)");
                    break;
                }
                case 23: {
                    stringBuffer.append("0x17 (SquareTrsRight)");
                    break;
                }
                case 24: {
                    stringBuffer.append("0x18 (SquareTrsLeft)");
                    break;
                }
                case 25: {
                    stringBuffer.append("0x19 (Uturn)");
                    break;
                }
                case 26: {
                    stringBuffer.append("0x1A (ExitRoundaboutTrsRight)");
                    break;
                }
                case 27: {
                    stringBuffer.append("0x1B (ExitRoundaboutTrsLeft)");
                    break;
                }
                case 28: {
                    stringBuffer.append("0x1C (PrepareTurn)");
                    break;
                }
                case 29: {
                    stringBuffer.append("0x1D (PrepareRoundabout)");
                    break;
                }
                case 30: {
                    stringBuffer.append("0x1E (PrepareSquare)");
                    break;
                }
                case 31: {
                    stringBuffer.append("0x1F (PrepareUTurn)");
                    break;
                }
                case 34: {
                    stringBuffer.append("0x22 (MichigangTurn)");
                    break;
                }
                case 35: {
                    stringBuffer.append("0x23 (DoubleTurn)");
                    break;
                }
                case 38: {
                    stringBuffer.append("0x26 (DirectionToWaypoint)");
                    break;
                }
                default: {
                    stringBuffer.append("UNKNOWN ENUM");
                }
            }
            stringBuffer.append("\n - Direction - ");
            stringBuffer.append(this.direction);
            stringBuffer.append("\n - Z-LevelGuidance: ");
            switch (this.zLevelGuidance) {
                case 0: {
                    stringBuffer.append("0x00 (no Z-LevelGuidance)");
                    break;
                }
                case 1: {
                    stringBuffer.append("0x01 (up)");
                    break;
                }
                case 2: {
                    stringBuffer.append("0x02 (down)");
                    break;
                }
                case 255: {
                    stringBuffer.append("0xFF (not supported)");
                    break;
                }
                default: {
                    stringBuffer.append("UNKNOWN ENUM");
                }
            }
            stringBuffer.append("\n - Sidestreets - ");
            stringBuffer.append(this.sidestreets.toString());
            return stringBuffer.toString();
        }

        public int bitSize() {
            int n = 0;
            n += 8;
            n += 8;
            n += 8;
            return n += this.sidestreets.bitSize();
        }

        public void serialize(BitStream bitStream) {
            bitStream.pushByte((byte)this.mainElement);
            bitStream.pushByte((byte)this.direction);
            bitStream.pushByte((byte)this.zLevelGuidance);
            this.sidestreets.serialize(bitStream);
        }

        public void deserialize(BitStream bitStream) {
            this.mainElement = bitStream.popFrontByte();
            this.direction = bitStream.popFrontByte();
            this.zLevelGuidance = bitStream.popFrontByte();
            this.sidestreets.deserialize(bitStream);
        }
    }

    public static final class Maneuver_3
    implements BAPEntity {
        public int mainElement;
        private static final int MAIN_ELEMENT_BITSIZE = 8;
        public static final int MAIN_ELEMENT_NO_SYMBOL = 0;
        public static final int MAIN_ELEMENT_NO_INFO = 1;
        public static final int MAIN_ELEMENT_DIRECTION_TO_DESTINATION = 2;
        public static final int MAIN_ELEMENT_ARRIVED = 3;
        public static final int MAIN_ELEMENT_NEAR_DESTINATION = 4;
        public static final int MAIN_ELEMENT_ARRIVED_DESTINATION_OFFMAP = 5;
        public static final int MAIN_ELEMENT_OFF_ROAD = 6;
        public static final int MAIN_ELEMENT_OFF_MAP = 7;
        public static final int MAIN_ELEMENT_NO_ROUTE = 8;
        public static final int MAIN_ELEMENT_CALC_ROUTE = 9;
        public static final int MAIN_ELEMENT_RECALC_ROUTE = 10;
        public static final int MAIN_ELEMENT_FOLLOW_STREET = 11;
        public static final int MAIN_ELEMENT_CHANGE_LANE = 12;
        public static final int MAIN_ELEMENT_TURN = 13;
        public static final int MAIN_ELEMENT_TURN_ON_MAINROAD = 14;
        public static final int MAIN_ELEMENT_EXIT_RIGHT = 15;
        public static final int MAIN_ELEMENT_EXIT_LEFT = 16;
        public static final int MAIN_ELEMENT_SERVICE_ROAD_RIGHT = 17;
        public static final int MAIN_ELEMENT_SERVICE_ROAD_LEFT = 18;
        public static final int MAIN_ELEMENT_FORK_2 = 19;
        public static final int MAIN_ELEMENT_FORK_3 = 20;
        public static final int MAIN_ELEMENT_ROUNDABOUT_TRS_RIGHT = 21;
        public static final int MAIN_ELEMENT_ROUNDABOUT_TRS_LEFT = 22;
        public static final int MAIN_ELEMENT_SQUARE_TRS_RIGHT = 23;
        public static final int MAIN_ELEMENT_SQUARE_TRS_LEFT = 24;
        public static final int MAIN_ELEMENT_UTURN = 25;
        public static final int MAIN_ELEMENT_EXIT_ROUNDABOUT_TRS_RIGHT = 26;
        public static final int MAIN_ELEMENT_EXIT_ROUNDABOUT_TRS_LEFT = 27;
        public static final int MAIN_ELEMENT_PREPARE_TURN = 28;
        public static final int MAIN_ELEMENT_PREPARE_ROUNDABOUT = 29;
        public static final int MAIN_ELEMENT_PREPARE_SQUARE = 30;
        public static final int MAIN_ELEMENT_PREPARE_U_TURN = 31;
        public static final int MAIN_ELEMENT_MICHIGANG_TURN = 34;
        public static final int MAIN_ELEMENT_DOUBLE_TURN = 35;
        public static final int MAIN_ELEMENT_DIRECTION_TO_WAYPOINT = 38;
        public int direction;
        private static final int DIRECTION_BITSIZE = 8;
        public int zLevelGuidance;
        private static final int Z_LEVEL_GUIDANCE_BITSIZE = 8;
        public static final int Z_LEVEL_GUIDANCE_NO_Z_LEVEL_GUIDANCE = 0;
        public static final int Z_LEVEL_GUIDANCE_UP = 1;
        public static final int Z_LEVEL_GUIDANCE_DOWN = 2;
        public static final int Z_LEVEL_GUIDANCE_NOT_SUPPORTED = 255;
        public final BAPString sidestreets = new BAPString(17);
        private static final int MAX_SIDESTREETS_LENGTH = 17;

        public Maneuver_3() {
            this.internalReset();
            this.customInitialization();
        }

        public Maneuver_3(BitStream bitStream) {
            this();
            this.deserialize(bitStream);
        }

        private void internalReset() {
            this.mainElement = 0;
            this.direction = 0;
            this.zLevelGuidance = 0;
        }

        public void reset() {
            this.internalReset();
            this.sidestreets.reset();
        }

        public boolean equalTo(BAPEntity bAPEntity) {
            Maneuver_3 maneuver_3 = (Maneuver_3)bAPEntity;
            return this.mainElement == maneuver_3.mainElement && this.direction == maneuver_3.direction && this.zLevelGuidance == maneuver_3.zLevelGuidance && this.sidestreets.equalTo(maneuver_3.sidestreets);
        }

        private void customInitialization() {
            this.sidestreets.setRawContent();
        }

        public String toString() {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("Maneuver_3:");
            stringBuffer.append("\n - MainElement: ");
            switch (this.mainElement) {
                case 0: {
                    stringBuffer.append("0x00 (NoSymbol)");
                    break;
                }
                case 1: {
                    stringBuffer.append("0x01 (NoInfo)");
                    break;
                }
                case 2: {
                    stringBuffer.append("0x02 (DirectionToDestination)");
                    break;
                }
                case 3: {
                    stringBuffer.append("0x03 (Arrived)");
                    break;
                }
                case 4: {
                    stringBuffer.append("0x04 (NearDestination)");
                    break;
                }
                case 5: {
                    stringBuffer.append("0x05 (ArrivedDestinationOffmap)");
                    break;
                }
                case 6: {
                    stringBuffer.append("0x06 (OffRoad)");
                    break;
                }
                case 7: {
                    stringBuffer.append("0x07 (OffMap)");
                    break;
                }
                case 8: {
                    stringBuffer.append("0x08 (NoRoute)");
                    break;
                }
                case 9: {
                    stringBuffer.append("0x09 (CalcRoute)");
                    break;
                }
                case 10: {
                    stringBuffer.append("0x0A (RecalcRoute)");
                    break;
                }
                case 11: {
                    stringBuffer.append("0x0B (FollowStreet)");
                    break;
                }
                case 12: {
                    stringBuffer.append("0x0C (ChangeLane)");
                    break;
                }
                case 13: {
                    stringBuffer.append("0x0D (Turn)");
                    break;
                }
                case 14: {
                    stringBuffer.append("0x0E (TurnOnMainroad)");
                    break;
                }
                case 15: {
                    stringBuffer.append("0x0F (ExitRight)");
                    break;
                }
                case 16: {
                    stringBuffer.append("0x10 (ExitLeft)");
                    break;
                }
                case 17: {
                    stringBuffer.append("0x11 (ServiceRoadRight)");
                    break;
                }
                case 18: {
                    stringBuffer.append("0x12 (ServiceRoadLeft)");
                    break;
                }
                case 19: {
                    stringBuffer.append("0x13 (Fork-2)");
                    break;
                }
                case 20: {
                    stringBuffer.append("0x14 (Fork-3)");
                    break;
                }
                case 21: {
                    stringBuffer.append("0x15 (RoundaboutTrsRight)");
                    break;
                }
                case 22: {
                    stringBuffer.append("0x16 (RoundaboutTrsLeft)");
                    break;
                }
                case 23: {
                    stringBuffer.append("0x17 (SquareTrsRight)");
                    break;
                }
                case 24: {
                    stringBuffer.append("0x18 (SquareTrsLeft)");
                    break;
                }
                case 25: {
                    stringBuffer.append("0x19 (Uturn)");
                    break;
                }
                case 26: {
                    stringBuffer.append("0x1A (ExitRoundaboutTrsRight)");
                    break;
                }
                case 27: {
                    stringBuffer.append("0x1B (ExitRoundaboutTrsLeft)");
                    break;
                }
                case 28: {
                    stringBuffer.append("0x1C (PrepareTurn)");
                    break;
                }
                case 29: {
                    stringBuffer.append("0x1D (PrepareRoundabout)");
                    break;
                }
                case 30: {
                    stringBuffer.append("0x1E (PrepareSquare)");
                    break;
                }
                case 31: {
                    stringBuffer.append("0x1F (PrepareUTurn)");
                    break;
                }
                case 34: {
                    stringBuffer.append("0x22 (MichigangTurn)");
                    break;
                }
                case 35: {
                    stringBuffer.append("0x23 (DoubleTurn)");
                    break;
                }
                case 38: {
                    stringBuffer.append("0x26 (DirectionToWaypoint)");
                    break;
                }
                default: {
                    stringBuffer.append("UNKNOWN ENUM");
                }
            }
            stringBuffer.append("\n - Direction - ");
            stringBuffer.append(this.direction);
            stringBuffer.append("\n - Z-LevelGuidance: ");
            switch (this.zLevelGuidance) {
                case 0: {
                    stringBuffer.append("0x00 (no Z-LevelGuidance)");
                    break;
                }
                case 1: {
                    stringBuffer.append("0x01 (up)");
                    break;
                }
                case 2: {
                    stringBuffer.append("0x02 (down)");
                    break;
                }
                case 255: {
                    stringBuffer.append("0xFF (not supported)");
                    break;
                }
                default: {
                    stringBuffer.append("UNKNOWN ENUM");
                }
            }
            stringBuffer.append("\n - Sidestreets - ");
            stringBuffer.append(this.sidestreets.toString());
            return stringBuffer.toString();
        }

        public int bitSize() {
            int n = 0;
            n += 8;
            n += 8;
            n += 8;
            return n += this.sidestreets.bitSize();
        }

        public void serialize(BitStream bitStream) {
            bitStream.pushByte((byte)this.mainElement);
            bitStream.pushByte((byte)this.direction);
            bitStream.pushByte((byte)this.zLevelGuidance);
            this.sidestreets.serialize(bitStream);
        }

        public void deserialize(BitStream bitStream) {
            this.mainElement = bitStream.popFrontByte();
            this.direction = bitStream.popFrontByte();
            this.zLevelGuidance = bitStream.popFrontByte();
            this.sidestreets.deserialize(bitStream);
        }
    }
}

