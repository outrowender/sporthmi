/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.generated.navsd.serializer;

import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.requests.ResultMethod;
import de.vw.mib.bap.stream.BitStream;

public final class RG_ActDeact_Result
implements ResultMethod {
    public int rg_ActDeact_Result;
    private static final int RG_ACT_DEACT_RESULT_BITSIZE;
    public static final int RG_ACT_DEACT_RESULT_SUCCESSFUL;
    public static final int RG_ACT_DEACT_RESULT_NOT_SUCCESSFUL;
    public static final int RG_ACT_DEACT_RESULT_ABORT_SUCCESSFUL;
    public static final int RG_ACT_DEACT_RESULT_ABORT_NOT_SUCCESSFUL;
    public static final int RG_ACT_DEACT_RESULT_RG_NOT_ACTIVE;
    public static final int RG_ACT_DEACT_RESULT_RG_ALREADY_ACTIVE;
    public static final int RG_ACT_DEACT_RESULT_NOT_SUCCESSFUL_CONTROL_INFORMATION_DOES_NOT_MATCH_TO_FSG_INTERNAL_DESTINATION;
    public static final int RG_ACT_DEACT_RESULT_NOT_SUCCESSFUL_DESTINATION_ADDRESS_NEEDS_TO_BE_REFINED_DETAILED_AT_HEAD_UNIT;
    public static final int RG_ACT_DEACT_RESULT_NOT_SUCCESSFUL_HOME_ADDRESS_NOT_SPECIFIED_IN_FSG;
    public static final int RG_ACT_DEACT_RESULT_NOT_SUCCESSFUL_SELECT_ROUTE_AT_FSG;
    public static final int RG_ACT_DEACT_RESULT_NOT_SUCCESSFUL_SELECT_HOME_ADDRESS_AT_FSG;
    public static final int RG_ACT_DEACT_RESULT_NOT_SUCCESSFUL_NO_NAVIGATION_DATA_AVAILABLE;
    public static final int RG_ACT_DEACT_RESULT_NOT_SUCCESSFUL_NO_SEMI_DYNAMIC_ROUTE_AVAILABLE_DF4_1;
    public static final int RG_ACT_DEACT_RESULT_NOT_SUCCESSFUL_SELECT_SEMI_DYNAMIC_ROUTE_AT_FSG;

    @Override
    public int getResultCode() {
        return this.rg_ActDeact_Result;
    }

    public RG_ActDeact_Result() {
        this.internalReset();
        this.customInitialization();
    }

    public RG_ActDeact_Result(BitStream bitStream) {
        this();
        this.deserialize(bitStream);
    }

    private void internalReset() {
        this.rg_ActDeact_Result = 0;
    }

    @Override
    public void reset() {
        this.internalReset();
    }

    @Override
    public boolean equalTo(BAPEntity bAPEntity) {
        RG_ActDeact_Result rG_ActDeact_Result = (RG_ActDeact_Result)bAPEntity;
        return this.rg_ActDeact_Result == rG_ActDeact_Result.rg_ActDeact_Result;
    }

    private void customInitialization() {
    }

    @Override
    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("RG_ActDeact_Result:");
        stringBuffer.append("\n - RG_ActDeact_Result: ");
        switch (this.rg_ActDeact_Result) {
            case 0: {
                stringBuffer.append("0x00 (successful)");
                break;
            }
            case 1: {
                stringBuffer.append("0x01 (not successful)");
                break;
            }
            case 2: {
                stringBuffer.append("0x02 (abort successful)");
                break;
            }
            case 3: {
                stringBuffer.append("0x03 (abort not successful)");
                break;
            }
            case 4: {
                stringBuffer.append("0x04 (RG not active)");
                break;
            }
            case 5: {
                stringBuffer.append("0x05 (RG already active)");
                break;
            }
            case 6: {
                stringBuffer.append("0x06 (not successful - ControlInformation does not match to FSG internal destination (RG not started!))");
                break;
            }
            case 7: {
                stringBuffer.append("0x07 (not successful - destination address needs to be refined/detailed at head unit)");
                break;
            }
            case 8: {
                stringBuffer.append("0x08 (not successful - home address not specified in FSG)");
                break;
            }
            case 9: {
                stringBuffer.append("0x09 (not successful - select Route at FSG)");
                break;
            }
            case 10: {
                stringBuffer.append("0x0A (not successful - select home address at FSG (several home addresses available) (DF4.1))");
                break;
            }
            case 11: {
                stringBuffer.append("0x0B (not successful - no navigation data  (map data) available (DF4.1))");
                break;
            }
            case 12: {
                stringBuffer.append("0x0C (not successful - no semi-dynamic route available (DF4.1))");
                break;
            }
            case 13: {
                stringBuffer.append("0x0D (not successful - select semi-dynamic route at FSG (several semi-dynamic routes available) (DF4.1))");
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
        bitStream.pushByte((byte)this.rg_ActDeact_Result);
    }

    @Override
    public void deserialize(BitStream bitStream) {
        this.rg_ActDeact_Result = bitStream.popFrontByte();
    }

    public static int functionId() {
        return 34;
    }

    @Override
    public int getFunctionId() {
        return RG_ActDeact_Result.functionId();
    }
}

