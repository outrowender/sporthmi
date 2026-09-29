/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.generated.navsd.serializer;

import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.requests.StatusProperty;
import de.vw.mib.bap.stream.BitStream;

public final class TrafficBlock_Indication_Status
implements StatusProperty {
    public int tmc_Symbol;
    private static final int TMC_SYMBOL_BITSIZE;
    public static final int TMC_SYMBOL_NO_TMC_SYMBOL;
    public static final int TMC_SYMBOL_GENERAL_DANGER_PART_1;
    public static final int TMC_SYMBOL_GENERAL_DANGER_PART_2;
    public static final int TMC_SYMBOL_GENERAL_DANGER_PART_3;
    public static final int TMC_SYMBOL_ROAD_WORKS;
    public static final int TMC_SYMBOL_STATIONARY_TRAFFIC_JAM;
    public static final int TMC_SYMBOL_SLOW_HEAVY_TRAFFIC;
    public static final int TMC_SYMBOL_ROAD_NARROWED_ROAD_WIDTH_REDUCED_ON_BOTH_SIDES;
    public static final int TMC_SYMBOL_SNOWFALL;
    public static final int TMC_SYMBOL_SLIPPERY_ROAD;
    public static final int TMC_SYMBOL_HEAVY_WINDS_STORM;
    public static final int TMC_SYMBOL_ROCKFALL_LANDSLIP;
    public static final int TMC_SYMBOL_PEOPLE_ON_THE_ROAD;
    public static final int TMC_SYMBOL_BIKER_ON_THE_ROAD;
    public static final int TMC_SYMBOL_ANIMALS_ON_ROAD;
    public static final int TMC_SYMBOL_SMOG;
    public static final int TMC_SYMBOL_CLOSED_ROAD;
    public static final int TMC_SYMBOL_OVERTAKE_RESTRICTION;
    public static final int TMC_SYMBOL_END_OF_OVERTAKE_RESTRICTION;
    public static final int TMC_SYMBOL_END_OF_ALL_RESTRICTIONS;
    public static final int TMC_SYMBOL_SNOW_CHAINS_MANDATORY;
    public static final int TMC_SYMBOL_DELAY;
    public static final int TMC_SYMBOL_ROAD_NARROWED_ON_LEFT_HAND_SIDE;
    public static final int TMC_SYMBOL_ROAD_NARROWED_ON_RIGHT_HAND_SIDE;
    public static final int TMC_SYMBOL_UNKNOWN_TMC_SYMBOL;

    public TrafficBlock_Indication_Status() {
        this.internalReset();
        this.customInitialization();
    }

    public TrafficBlock_Indication_Status(BitStream bitStream) {
        this();
        this.deserialize(bitStream);
    }

    private void internalReset() {
        this.tmc_Symbol = 0;
    }

    @Override
    public void reset() {
        this.internalReset();
    }

    @Override
    public boolean equalTo(BAPEntity bAPEntity) {
        TrafficBlock_Indication_Status trafficBlock_Indication_Status = (TrafficBlock_Indication_Status)bAPEntity;
        return this.tmc_Symbol == trafficBlock_Indication_Status.tmc_Symbol;
    }

    private void customInitialization() {
    }

    @Override
    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("TrafficBlock_Indication_Status:");
        stringBuffer.append("\n - TMC_Symbol: ");
        switch (this.tmc_Symbol) {
            case 0: {
                stringBuffer.append("0x00 (no TMC symbol)");
                break;
            }
            case 1: {
                stringBuffer.append("0x01 (general danger  (part 1))");
                break;
            }
            case 2: {
                stringBuffer.append("0x02 (general danger  (part 2) )");
                break;
            }
            case 3: {
                stringBuffer.append("0x03 (general danger  (part 3))");
                break;
            }
            case 4: {
                stringBuffer.append("0x04 (road works )");
                break;
            }
            case 5: {
                stringBuffer.append("0x05 (stationary traffic / jam )");
                break;
            }
            case 6: {
                stringBuffer.append("0x06 (slow / heavy traffic  )");
                break;
            }
            case 7: {
                stringBuffer.append("0x07 (road narrowed (road width reduced) (on both sides))");
                break;
            }
            case 8: {
                stringBuffer.append("0x08 (snowfall )");
                break;
            }
            case 9: {
                stringBuffer.append("0x09 (slippery road  )");
                break;
            }
            case 10: {
                stringBuffer.append("0x0A (heavy winds / storm )");
                break;
            }
            case 11: {
                stringBuffer.append("0x0B (rockfall, landslip )");
                break;
            }
            case 12: {
                stringBuffer.append("0x0C (people on the road )");
                break;
            }
            case 13: {
                stringBuffer.append("0x0D (biker on the road )");
                break;
            }
            case 14: {
                stringBuffer.append("0x0E (animals on road )");
                break;
            }
            case 15: {
                stringBuffer.append("0x0F (smog )");
                break;
            }
            case 16: {
                stringBuffer.append("0x10 (closed road )");
                break;
            }
            case 17: {
                stringBuffer.append("0x11 (overtake restriction )");
                break;
            }
            case 18: {
                stringBuffer.append("0x12 (end of overtake restriction )");
                break;
            }
            case 19: {
                stringBuffer.append("0x13 (end of all restrictions )");
                break;
            }
            case 20: {
                stringBuffer.append("0x14 (snow chains mandatory )");
                break;
            }
            case 21: {
                stringBuffer.append("0x15 (delay )");
                break;
            }
            case 22: {
                stringBuffer.append("0x16 (road narrowed on left hand side (road width reduced) (DF4.1))");
                break;
            }
            case 23: {
                stringBuffer.append("0x17 (road narrowed on right hand side (road width reduced) (DF4.1))");
                break;
            }
            case 255: {
                stringBuffer.append("0xFF (unknown TMC symbol)");
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
        return n += 8;
    }

    @Override
    public void serialize(BitStream bitStream) {
        bitStream.pushByte((byte)this.tmc_Symbol);
    }

    @Override
    public void deserialize(BitStream bitStream) {
        this.tmc_Symbol = bitStream.popFrontByte();
    }

    public static int functionId() {
        return 40;
    }

    @Override
    public int getFunctionId() {
        return TrafficBlock_Indication_Status.functionId();
    }
}

