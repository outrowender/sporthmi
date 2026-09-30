/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.generated.mfl.serializer;

import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.requests.StatusProperty;
import de.vw.mib.bap.stream.BitStream;

public final class KeyAction_Status
implements StatusProperty {
    public int fsgactionKey1;
    private static final int FSG_ACTION_KEY1_BITSIZE = 8;
    public static final int FSG_ACTION_KEY1_IDLE_NO_ACTION = 0;
    public static final int FSG_ACTION_KEY1_VOICE_GUIDANCE_COMPLETE = 1;
    public static final int FSG_ACTION_KEY1_VOICE_GUIDANCE_OFF = 2;
    public static final int FSG_ACTION_KEY1_SWITCH_MAP_COLOR_TO_DAY = 3;
    public static final int FSG_ACTION_KEY1_SWITCH_MAP_COLOR_TO_NIGHT = 4;
    public static final int FSG_ACTION_KEY1_TRAFFIC_ANNOUNCEMENT_ON = 5;
    public static final int FSG_ACTION_KEY1_TRAFFIC_ANNOUNCEMENT_OFF = 6;
    public static final int FSG_ACTION_KEY1_NAVIGATE_TO_HOME = 7;
    public static final int FSG_ACTION_KEY1_AUXILIARY_HEATING_ON = 8;
    public static final int FSG_ACTION_KEY1_AUXILIARY_HEATING_OFF = 9;
    public static final int FSG_ACTION_KEY1_DISPLAY_OFF = 10;
    public static final int FSG_ACTION_KEY1_DISPLAY_ON = 11;
    public static final int FSG_ACTION_KEY1_VOICE_GUIDANCE_TRAFFIC_DF3_1 = 12;
    public static final int FSG_ACTION_KEY1_VOICE_GUIDANCE_SHORT_DF3_1 = 13;
    public static final int FSG_ACTION_KEY1_MAP_INFO_OFF_DF3_1 = 14;
    public static final int FSG_ACTION_KEY1_MAP_INFO_ROUTE_DF3_1 = 15;
    public static final int FSG_ACTION_KEY1_MAP_INFO_OVERVIEW_MAP_DF3_1 = 16;
    public static final int FSG_ACTION_KEY1_POI_CALL_UNAVAILABLE_CALL_ACTIVE_DF3_2 = 17;
    public static final int FSG_ACTION_KEY1_POI_CALL_UNAVAILABLE_NO_SIM_DF3_2 = 18;
    public static final int FSG_ACTION_KEY1_POI_CALL_UNAVAILABLE_GENERAL_ERROR_DF3_2 = 19;
    public static final int FSG_ACTION_KEY1_POI_CALL_UNAVAILABLE_NO_PHONE_DF3_3 = 20;
    public static final int FSG_ACTION_KEY1_STEERINGWHEELHEATER_OFF_DF3_3 = 21;
    public static final int FSG_ACTION_KEY1_STEERINGWHEELHEATER_ON_DF3_3 = 22;
    public static final int FSG_ACTION_KEY1_STEERINGWHEELHEATER_ON_WEAK_DF3_3 = 23;
    public static final int FSG_ACTION_KEY1_STEERINGWHEELHEATER_ON_MEDIUM_DF3_3 = 24;
    public static final int FSG_ACTION_KEY1_STEERINGWHEELHEATER_ON_STRONG_DF3_3 = 25;
    public int fsgactionKey2;
    private static final int FSG_ACTION_KEY2_BITSIZE = 8;
    public static final int FSG_ACTION_KEY2_IDLE_NO_ACTION = 0;
    public static final int FSG_ACTION_KEY2_VOICE_GUIDANCE_COMPLETE = 1;
    public static final int FSG_ACTION_KEY2_VOICE_GUIDANCE_OFF = 2;
    public static final int FSG_ACTION_KEY2_SWITCH_MAP_COLOR_TO_DAY = 3;
    public static final int FSG_ACTION_KEY2_SWITCH_MAP_COLOR_TO_NIGHT = 4;
    public static final int FSG_ACTION_KEY2_TRAFFIC_ANNOUNCEMENT_ON = 5;
    public static final int FSG_ACTION_KEY2_TRAFFIC_ANNOUNCEMENT_OFF = 6;
    public static final int FSG_ACTION_KEY2_NAVIGATE_TO_HOME = 7;
    public static final int FSG_ACTION_KEY2_AUXILIARY_HEATING_ON = 8;
    public static final int FSG_ACTION_KEY2_AUXILIARY_HEATING_OFF = 9;
    public static final int FSG_ACTION_KEY2_DISPLAY_OFF = 10;
    public static final int FSG_ACTION_KEY2_DISPLAY_ON = 11;
    public static final int FSG_ACTION_KEY2_VOICE_GUIDANCE_TRAFFIC_DF3_1 = 12;
    public static final int FSG_ACTION_KEY2_VOICE_GUIDANCE_SHORT_DF3_1 = 13;
    public static final int FSG_ACTION_KEY2_MAP_INFO_OFF_DF3_1 = 14;
    public static final int FSG_ACTION_KEY2_MAP_INFO_ROUTE_DF3_1 = 15;
    public static final int FSG_ACTION_KEY2_MAP_INFO_OVERVIEW_MAP_DF3_1 = 16;
    public static final int FSG_ACTION_KEY2_POI_CALL_UNAVAILABLE_CALL_ACTIVE_DF3_2 = 17;
    public static final int FSG_ACTION_KEY2_POI_CALL_UNAVAILABLE_NO_SIM_DF3_2 = 18;
    public static final int FSG_ACTION_KEY2_POI_CALL_UNAVAILABLE_GENERAL_ERROR_DF3_2 = 19;
    public static final int FSG_ACTION_KEY2_POI_CALL_UNAVAILABLE_NO_PHONE_DF3_3 = 20;
    public static final int FSG_ACTION_KEY2_STEERINGWHEELHEATER_OFF_DF3_3 = 21;
    public static final int FSG_ACTION_KEY2_STEERINGWHEELHEATER_ON_DF3_3 = 22;
    public static final int FSG_ACTION_KEY2_STEERINGWHEELHEATER_ON_WEAK_DF3_3 = 23;
    public static final int FSG_ACTION_KEY2_STEERINGWHEELHEATER_ON_MEDIUM_DF3_3 = 24;
    public static final int FSG_ACTION_KEY2_STEERINGWHEELHEATER_ON_STRONG_DF3_3 = 25;
    public int fsgkeyNoFunc;
    private static final int FSG_KEY_NO_FUNC_BITSIZE = 8;
    public static final int FSG_KEY_NO_FUNC_IDLE_NO_ACTION = 0;
    public static final int FSG_KEY_NO_FUNC_I_NAV_NO_FUNCTIONALITY = 1;
    public static final int FSG_KEY_NO_FUNC_SDS_NO_FUNCTIONALITY = 2;
    public static final int FSG_KEY_NO_FUNC_JOKER_KEY_ACTION_NOT_SUCCESSFUL = 3;
    public static final int FSG_KEY_NO_FUNC_JOKER_KEY_AUXILIARY_HEATING_SYSTEM_ERROR = 4;
    public static final int FSG_KEY_NO_FUNC_JOKER_KEY_AUXILIARY_HEATING_LOW_FUEL = 5;
    public static final int FSG_KEY_NO_FUNC_JOKER_KEY_AUXILIARY_HEATING_LOW_VOLTAGE = 6;
    public static final int FSG_KEY_NO_FUNC_TELEPHONE_NO_FUNCTIONALITY_DF3_1 = 7;
    public static final int FSG_KEY_NO_FUNC_JOKER_KEY_PARKING_CURBVIEW_NOT_POSSIBLE_DF3_3 = 8;
    public static final int FSG_KEY_NO_FUNC_JOKER_KEY_PARKING_PANORAMAVIEW_NOT_POSSIBLE_DF3_3 = 9;
    public static final int FSG_KEY_NO_FUNC_JOKER_KEY_STEERING_WHEEL_HEATER_NOT_FUNCTIONAL_DF3_3 = 10;

    public KeyAction_Status() {
        this.internalReset();
        this.customInitialization();
    }

    public KeyAction_Status(BitStream bitStream) {
        this();
        this.deserialize(bitStream);
    }

    private void internalReset() {
        this.fsgactionKey1 = 0;
        this.fsgactionKey2 = 0;
        this.fsgkeyNoFunc = 0;
    }

    public void reset() {
        this.internalReset();
    }

    public boolean equalTo(BAPEntity bAPEntity) {
        KeyAction_Status keyAction_Status = (KeyAction_Status)bAPEntity;
        return this.fsgactionKey1 == keyAction_Status.fsgactionKey1 && this.fsgactionKey2 == keyAction_Status.fsgactionKey2 && this.fsgkeyNoFunc == keyAction_Status.fsgkeyNoFunc;
    }

    private void customInitialization() {
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("KeyAction_Status:");
        stringBuffer.append("\n - FSGActionKey1: ");
        switch (this.fsgactionKey1) {
            case 0: {
                stringBuffer.append("0x00 (idle / no action)");
                break;
            }
            case 1: {
                stringBuffer.append("0x01 (voice guidance - complete)");
                break;
            }
            case 2: {
                stringBuffer.append("0x02 (voice guidance - off)");
                break;
            }
            case 3: {
                stringBuffer.append("0x03 (switch map color to day)");
                break;
            }
            case 4: {
                stringBuffer.append("0x04 (switch map color to night)");
                break;
            }
            case 5: {
                stringBuffer.append("0x05 (traffic announcement on)");
                break;
            }
            case 6: {
                stringBuffer.append("0x06 (traffic announcement off)");
                break;
            }
            case 7: {
                stringBuffer.append("0x07 (navigate to home)");
                break;
            }
            case 8: {
                stringBuffer.append("0x08 (auxiliary heating on)");
                break;
            }
            case 9: {
                stringBuffer.append("0x09 (auxiliary heating off)");
                break;
            }
            case 10: {
                stringBuffer.append("0x0A (display off)");
                break;
            }
            case 11: {
                stringBuffer.append("0x0B (display on)");
                break;
            }
            case 12: {
                stringBuffer.append("0x0C (voice guidance - traffic (DF3.1))");
                break;
            }
            case 13: {
                stringBuffer.append("0x0D (voice guidance - short (DF3.1))");
                break;
            }
            case 14: {
                stringBuffer.append("0x0E (map info - off (DF3.1))");
                break;
            }
            case 15: {
                stringBuffer.append("0x0F (map info - route (DF3.1))");
                break;
            }
            case 16: {
                stringBuffer.append("0x10 (map info - overview map (DF3.1))");
                break;
            }
            case 17: {
                stringBuffer.append("0x11 (POI_Call unavailable - call active (DF3.2))");
                break;
            }
            case 18: {
                stringBuffer.append("0x12 (POI_Call unavailable - no SIM (DF3.2))");
                break;
            }
            case 19: {
                stringBuffer.append("0x13 (POI_Call unavailable - general error (DF3.2))");
                break;
            }
            case 20: {
                stringBuffer.append("0x14 (POI_Call unavailable - no phone (DF3.3))");
                break;
            }
            case 21: {
                stringBuffer.append("0x15 (Steeringwheelheater off (DF3.3))");
                break;
            }
            case 22: {
                stringBuffer.append("0x16 (Steeringwheelheater on (DF3.3))");
                break;
            }
            case 23: {
                stringBuffer.append("0x17 (Steeringwheelheater on - weak (DF3.3))");
                break;
            }
            case 24: {
                stringBuffer.append("0x18 (Steeringwheelheater on - medium (DF3.3))");
                break;
            }
            case 25: {
                stringBuffer.append("0x19 (Steeringwheelheater on - strong (DF3.3))");
                break;
            }
            default: {
                stringBuffer.append("UNKNOWN ENUM");
            }
        }
        stringBuffer.append("\n - FSGActionKey2: ");
        switch (this.fsgactionKey2) {
            case 0: {
                stringBuffer.append("0x00 (idle / no action)");
                break;
            }
            case 1: {
                stringBuffer.append("0x01 (voice guidance - complete)");
                break;
            }
            case 2: {
                stringBuffer.append("0x02 (voice guidance - off)");
                break;
            }
            case 3: {
                stringBuffer.append("0x03 (switch map color to day)");
                break;
            }
            case 4: {
                stringBuffer.append("0x04 (switch map color to night)");
                break;
            }
            case 5: {
                stringBuffer.append("0x05 (traffic announcement on)");
                break;
            }
            case 6: {
                stringBuffer.append("0x06 (traffic announcement off)");
                break;
            }
            case 7: {
                stringBuffer.append("0x07 (navigate to home)");
                break;
            }
            case 8: {
                stringBuffer.append("0x08 (auxiliary heating on)");
                break;
            }
            case 9: {
                stringBuffer.append("0x09 (auxiliary heating off)");
                break;
            }
            case 10: {
                stringBuffer.append("0x0A (display off)");
                break;
            }
            case 11: {
                stringBuffer.append("0x0B (display on)");
                break;
            }
            case 12: {
                stringBuffer.append("0x0C (voice guidance - traffic (DF3.1))");
                break;
            }
            case 13: {
                stringBuffer.append("0x0D (voice guidance - short (DF3.1))");
                break;
            }
            case 14: {
                stringBuffer.append("0x0E (map info - off (DF3.1))");
                break;
            }
            case 15: {
                stringBuffer.append("0x0F (map info - route (DF3.1))");
                break;
            }
            case 16: {
                stringBuffer.append("0x10 (map info - overview map (DF3.1))");
                break;
            }
            case 17: {
                stringBuffer.append("0x11 (POI_Call unavailable - call active (DF3.2))");
                break;
            }
            case 18: {
                stringBuffer.append("0x12 (POI_Call unavailable - no SIM (DF3.2))");
                break;
            }
            case 19: {
                stringBuffer.append("0x13 (POI_Call unavailable - general error (DF3.2))");
                break;
            }
            case 20: {
                stringBuffer.append("0x14 (POI_Call unavailable - no phone (DF3.3))");
                break;
            }
            case 21: {
                stringBuffer.append("0x15 (Steeringwheelheater off (DF3.3))");
                break;
            }
            case 22: {
                stringBuffer.append("0x16 (Steeringwheelheater on (DF3.3))");
                break;
            }
            case 23: {
                stringBuffer.append("0x17 (Steeringwheelheater on - weak (DF3.3))");
                break;
            }
            case 24: {
                stringBuffer.append("0x18 (Steeringwheelheater on - medium (DF3.3))");
                break;
            }
            case 25: {
                stringBuffer.append("0x19 (Steeringwheelheater on - strong (DF3.3))");
                break;
            }
            default: {
                stringBuffer.append("UNKNOWN ENUM");
            }
        }
        stringBuffer.append("\n - FSGKeyNoFunc: ");
        switch (this.fsgkeyNoFunc) {
            case 0: {
                stringBuffer.append("0x00 (idle / no action)");
                break;
            }
            case 1: {
                stringBuffer.append("0x01 (iNav - no functionality)");
                break;
            }
            case 2: {
                stringBuffer.append("0x02 (SDS - no functionality)");
                break;
            }
            case 3: {
                stringBuffer.append("0x03 (Joker Key - action not successful)");
                break;
            }
            case 4: {
                stringBuffer.append("0x04 (Joker Key - Auxiliary heating system error)");
                break;
            }
            case 5: {
                stringBuffer.append("0x05 (Joker Key - Auxiliary heating low fuel)");
                break;
            }
            case 6: {
                stringBuffer.append("0x06 (Joker Key - Auxiliary heating low voltage)");
                break;
            }
            case 7: {
                stringBuffer.append("0x07 (Telephone - no functionality (DF3.1))");
                break;
            }
            case 8: {
                stringBuffer.append("0x08 (Joker Key - parking curbview not possible (DF3.3))");
                break;
            }
            case 9: {
                stringBuffer.append("0x09 (Joker Key - parking panoramaview not possible (DF3.3))");
                break;
            }
            case 10: {
                stringBuffer.append("0x0A (Joker Key - Steering wheel heater not functional (DF3.3))");
                break;
            }
            default: {
                stringBuffer.append("UNKNOWN ENUM");
            }
        }
        return stringBuffer.toString();
    }

    public int bitSize() {
        int n = 0;
        n += 8;
        n += 8;
        return n += 8;
    }

    public void serialize(BitStream bitStream) {
        bitStream.pushByte((byte)this.fsgactionKey1);
        bitStream.pushByte((byte)this.fsgactionKey2);
        bitStream.pushByte((byte)this.fsgkeyNoFunc);
    }

    public void deserialize(BitStream bitStream) {
        this.fsgactionKey1 = bitStream.popFrontByte();
        this.fsgactionKey2 = bitStream.popFrontByte();
        this.fsgkeyNoFunc = bitStream.popFrontByte();
    }

    public static int functionId() {
        return 18;
    }

    public int getFunctionId() {
        return KeyAction_Status.functionId();
    }
}

