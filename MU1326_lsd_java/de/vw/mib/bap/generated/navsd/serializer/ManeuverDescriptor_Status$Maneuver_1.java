/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.generated.navsd.serializer;

import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.datatypes.BAPString;
import de.vw.mib.bap.stream.BitStream;

public final class ManeuverDescriptor_Status$Maneuver_1
implements BAPEntity {
    public int mainElement;
    private static final int MAIN_ELEMENT_BITSIZE;
    public static final int MAIN_ELEMENT_NO_SYMBOL;
    public static final int MAIN_ELEMENT_NO_INFO;
    public static final int MAIN_ELEMENT_DIRECTION_TO_DESTINATION;
    public static final int MAIN_ELEMENT_ARRIVED;
    public static final int MAIN_ELEMENT_NEAR_DESTINATION;
    public static final int MAIN_ELEMENT_ARRIVED_DESTINATION_OFFMAP;
    public static final int MAIN_ELEMENT_OFF_ROAD;
    public static final int MAIN_ELEMENT_OFF_MAP;
    public static final int MAIN_ELEMENT_NO_ROUTE;
    public static final int MAIN_ELEMENT_CALC_ROUTE;
    public static final int MAIN_ELEMENT_RECALC_ROUTE;
    public static final int MAIN_ELEMENT_FOLLOW_STREET;
    public static final int MAIN_ELEMENT_CHANGE_LANE;
    public static final int MAIN_ELEMENT_TURN;
    public static final int MAIN_ELEMENT_TURN_ON_MAINROAD;
    public static final int MAIN_ELEMENT_EXIT_RIGHT;
    public static final int MAIN_ELEMENT_EXIT_LEFT;
    public static final int MAIN_ELEMENT_SERVICE_ROAD_RIGHT;
    public static final int MAIN_ELEMENT_SERVICE_ROAD_LEFT;
    public static final int MAIN_ELEMENT_FORK_2;
    public static final int MAIN_ELEMENT_FORK_3;
    public static final int MAIN_ELEMENT_ROUNDABOUT_TRS_RIGHT;
    public static final int MAIN_ELEMENT_ROUNDABOUT_TRS_LEFT;
    public static final int MAIN_ELEMENT_SQUARE_TRS_RIGHT;
    public static final int MAIN_ELEMENT_SQUARE_TRS_LEFT;
    public static final int MAIN_ELEMENT_UTURN;
    public static final int MAIN_ELEMENT_EXIT_ROUNDABOUT_TRS_RIGHT;
    public static final int MAIN_ELEMENT_EXIT_ROUNDABOUT_TRS_LEFT;
    public static final int MAIN_ELEMENT_PREPARE_TURN;
    public static final int MAIN_ELEMENT_PREPARE_ROUNDABOUT;
    public static final int MAIN_ELEMENT_PREPARE_SQUARE;
    public static final int MAIN_ELEMENT_PREPARE_U_TURN;
    public static final int MAIN_ELEMENT_MICHIGANG_TURN;
    public static final int MAIN_ELEMENT_DOUBLE_TURN;
    public static final int MAIN_ELEMENT_DIRECTION_TO_WAYPOINT;
    public int direction;
    private static final int DIRECTION_BITSIZE;
    public int zLevelGuidance;
    private static final int Z_LEVEL_GUIDANCE_BITSIZE;
    public static final int Z_LEVEL_GUIDANCE_NO_Z_LEVEL_GUIDANCE;
    public static final int Z_LEVEL_GUIDANCE_UP;
    public static final int Z_LEVEL_GUIDANCE_DOWN;
    public static final int Z_LEVEL_GUIDANCE_NOT_SUPPORTED;
    public final BAPString sidestreets = new BAPString(17);
    private static final int MAX_SIDESTREETS_LENGTH;

    public ManeuverDescriptor_Status$Maneuver_1() {
        this.internalReset();
        this.customInitialization();
    }

    public ManeuverDescriptor_Status$Maneuver_1(BitStream bitStream) {
        this();
        this.deserialize(bitStream);
    }

    private void internalReset() {
        this.mainElement = 0;
        this.direction = 0;
        this.zLevelGuidance = 0;
    }

    @Override
    public void reset() {
        this.internalReset();
        this.sidestreets.reset();
    }

    @Override
    public boolean equalTo(BAPEntity bAPEntity) {
        ManeuverDescriptor_Status$Maneuver_1 maneuverDescriptor_Status$Maneuver_1 = (ManeuverDescriptor_Status$Maneuver_1)bAPEntity;
        return this.mainElement == maneuverDescriptor_Status$Maneuver_1.mainElement && this.direction == maneuverDescriptor_Status$Maneuver_1.direction && this.zLevelGuidance == maneuverDescriptor_Status$Maneuver_1.zLevelGuidance && this.sidestreets.equalTo(maneuverDescriptor_Status$Maneuver_1.sidestreets);
    }

    private void customInitialization() {
        this.sidestreets.setRawContent();
    }

    @Override
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

    @Override
    public int bitSize() {
        int n = 0;
        n += 8;
        n += 8;
        n += 8;
        return n += this.sidestreets.bitSize();
    }

    @Override
    public void serialize(BitStream bitStream) {
        bitStream.pushByte((byte)this.mainElement);
        bitStream.pushByte((byte)this.direction);
        bitStream.pushByte((byte)this.zLevelGuidance);
        this.sidestreets.serialize(bitStream);
    }

    @Override
    public void deserialize(BitStream bitStream) {
        this.mainElement = bitStream.popFrontByte();
        this.direction = bitStream.popFrontByte();
        this.zLevelGuidance = bitStream.popFrontByte();
        this.sidestreets.deserialize(bitStream);
    }
}

