/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.generated.mfl.serializer;

import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.requests.StatusProperty;
import de.vw.mib.bap.stream.BitStream;

public final class KeyConfiguration_Status
implements StatusProperty {
    public int configKey1;
    private static final int CONFIG_KEY1_BITSIZE;
    public static final int CONFIG_KEY1_FSG_INTERNAL_FUNCTION_NOT_CONFIGURED;
    public static final int CONFIG_KEY1_ASG_SCREENSAVER_ON_OFF;
    public static final int CONFIG_KEY1_ASG_TRAFFIC_SIGNS_ON_OFF;
    public static final int CONFIG_KEY1_ASG_CONTEXT_SWITCH_TO_PHONE_BOOK;
    public static final int CONFIG_KEY1_ASG_CONTEXT_SWITCH_TO_LAST_DESTINATIONS_LIST;
    public static final int CONFIG_KEY1_ASG_CONTEXT_SWITCH_TO_TRAFFIC_SIGN_INFORMATION;
    public static final int CONFIG_KEY1_ASG_CONTEXT_SWITCH_TO_DIGITAL_SPEED;
    public int configKey2;
    private static final int CONFIG_KEY2_BITSIZE;
    public static final int CONFIG_KEY2_FSG_INTERNAL_FUNCTION_NOT_CONFIGURED;
    public static final int CONFIG_KEY2_ASG_SCREENSAVER_ON_OFF;
    public static final int CONFIG_KEY2_ASG_TRAFFIC_SIGNS_ON_OFF;
    public static final int CONFIG_KEY2_ASG_CONTEXT_SWITCH_TO_PHONE_BOOK;
    public static final int CONFIG_KEY2_ASG_CONTEXT_SWITCH_TO_LAST_DESTINATIONS_LIST;
    public static final int CONFIG_KEY2_ASG_CONTEXT_SWITCH_TO_TRAFFIC_SIGN_INFORMATION;
    public static final int CONFIG_KEY2_ASG_CONTEXT_SWITCH_TO_DIGITAL_SPEED;
    public int configKey3;
    private static final int CONFIG_KEY3_BITSIZE;
    public static final int CONFIG_KEY3_FSG_INTERNAL_FUNCTION_NOT_CONFIGURED;
    public static final int CONFIG_KEY3_ASG_SCREENSAVER_ON_OFF;
    public static final int CONFIG_KEY3_ASG_TRAFFIC_SIGNS_ON_OFF;
    public static final int CONFIG_KEY3_ASG_CONTEXT_SWITCH_TO_PHONE_BOOK;
    public static final int CONFIG_KEY3_ASG_CONTEXT_SWITCH_TO_LAST_DESTINATIONS_LIST;
    public static final int CONFIG_KEY3_ASG_CONTEXT_SWITCH_TO_TRAFFIC_SIGN_INFORMATION;
    public static final int CONFIG_KEY3_ASG_CONTEXT_SWITCH_TO_DIGITAL_SPEED;
    public int configKey4;
    private static final int CONFIG_KEY4_BITSIZE;
    public static final int CONFIG_KEY4_FSG_INTERNAL_FUNCTION_NOT_CONFIGURED;
    public static final int CONFIG_KEY4_ASG_SCREENSAVER_ON_OFF;
    public static final int CONFIG_KEY4_ASG_TRAFFIC_SIGNS_ON_OFF;
    public static final int CONFIG_KEY4_ASG_CONTEXT_SWITCH_TO_PHONE_BOOK;
    public static final int CONFIG_KEY4_ASG_CONTEXT_SWITCH_TO_LAST_DESTINATIONS_LIST;
    public static final int CONFIG_KEY4_ASG_CONTEXT_SWITCH_TO_TRAFFIC_SIGN_INFORMATION;
    public static final int CONFIG_KEY4_ASG_CONTEXT_SWITCH_TO_DIGITAL_SPEED;
    public int configKey5;
    private static final int CONFIG_KEY5_BITSIZE;
    public static final int CONFIG_KEY5_FSG_INTERNAL_FUNCTION_NOT_CONFIGURED;
    public static final int CONFIG_KEY5_ASG_SCREENSAVER_ON_OFF;
    public static final int CONFIG_KEY5_ASG_TRAFFIC_SIGNS_ON_OFF;
    public static final int CONFIG_KEY5_ASG_CONTEXT_SWITCH_TO_PHONE_BOOK;
    public static final int CONFIG_KEY5_ASG_CONTEXT_SWITCH_TO_LAST_DESTINATIONS_LIST;
    public static final int CONFIG_KEY5_ASG_CONTEXT_SWITCH_TO_TRAFFIC_SIGN_INFORMATION;
    public static final int CONFIG_KEY5_ASG_CONTEXT_SWITCH_TO_DIGITAL_SPEED;

    public KeyConfiguration_Status() {
        this.internalReset();
        this.customInitialization();
    }

    public KeyConfiguration_Status(BitStream bitStream) {
        this();
        this.deserialize(bitStream);
    }

    private void internalReset() {
        this.configKey1 = 0;
        this.configKey2 = 0;
        this.configKey3 = 0;
        this.configKey4 = 0;
        this.configKey5 = 0;
    }

    @Override
    public void reset() {
        this.internalReset();
    }

    @Override
    public boolean equalTo(BAPEntity bAPEntity) {
        KeyConfiguration_Status keyConfiguration_Status = (KeyConfiguration_Status)bAPEntity;
        return this.configKey1 == keyConfiguration_Status.configKey1 && this.configKey2 == keyConfiguration_Status.configKey2 && this.configKey3 == keyConfiguration_Status.configKey3 && this.configKey4 == keyConfiguration_Status.configKey4 && this.configKey5 == keyConfiguration_Status.configKey5;
    }

    private void customInitialization() {
    }

    @Override
    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("KeyConfiguration_Status:");
        stringBuffer.append("\n - ConfigKey1: ");
        switch (this.configKey1) {
            case 0: {
                stringBuffer.append("0x00 (FSG internal function / not configured)");
                break;
            }
            case 1: {
                stringBuffer.append("0x01 (ASG: Screensaver on/off)");
                break;
            }
            case 2: {
                stringBuffer.append("0x02 (ASG: traffic signs on/off)");
                break;
            }
            case 3: {
                stringBuffer.append("0x03 (ASG: context switch to phone book)");
                break;
            }
            case 4: {
                stringBuffer.append("0x04 (ASG: context switch to last destinations list)");
                break;
            }
            case 5: {
                stringBuffer.append("0x05 (ASG: context switch to traffic sign information)");
                break;
            }
            case 6: {
                stringBuffer.append("0x06 (ASG: context switch to digital speed)");
                break;
            }
            default: {
                stringBuffer.append("UNKNOWN ENUM");
            }
        }
        stringBuffer.append("\n - ConfigKey2: ");
        switch (this.configKey2) {
            case 0: {
                stringBuffer.append("0x00 (FSG internal function / not configured)");
                break;
            }
            case 1: {
                stringBuffer.append("0x01 (ASG: Screensaver on/off)");
                break;
            }
            case 2: {
                stringBuffer.append("0x02 (ASG: traffic signs on/off)");
                break;
            }
            case 3: {
                stringBuffer.append("0x03 (ASG: context switch to phone book)");
                break;
            }
            case 4: {
                stringBuffer.append("0x04 (ASG: context switch to last destinations list)");
                break;
            }
            case 5: {
                stringBuffer.append("0x05 (ASG: context switch to traffic sign information)");
                break;
            }
            case 6: {
                stringBuffer.append("0x06 (ASG: context switch to digital speed)");
                break;
            }
            default: {
                stringBuffer.append("UNKNOWN ENUM");
            }
        }
        stringBuffer.append("\n - ConfigKey3: ");
        switch (this.configKey3) {
            case 0: {
                stringBuffer.append("0x00 (FSG internal function / not configured)");
                break;
            }
            case 1: {
                stringBuffer.append("0x01 (ASG: Screensaver on/off)");
                break;
            }
            case 2: {
                stringBuffer.append("0x02 (ASG: traffic signs on/off)");
                break;
            }
            case 3: {
                stringBuffer.append("0x03 (ASG: context switch to phone book)");
                break;
            }
            case 4: {
                stringBuffer.append("0x04 (ASG: context switch to last destinations list)");
                break;
            }
            case 5: {
                stringBuffer.append("0x05 (ASG: context switch to traffic sign information)");
                break;
            }
            case 6: {
                stringBuffer.append("0x06 (ASG: context switch to digital speed)");
                break;
            }
            default: {
                stringBuffer.append("UNKNOWN ENUM");
            }
        }
        stringBuffer.append("\n - ConfigKey4: ");
        switch (this.configKey4) {
            case 0: {
                stringBuffer.append("0x00 (FSG internal function / not configured)");
                break;
            }
            case 1: {
                stringBuffer.append("0x01 (ASG: Screensaver on/off)");
                break;
            }
            case 2: {
                stringBuffer.append("0x02 (ASG: traffic signs on/off)");
                break;
            }
            case 3: {
                stringBuffer.append("0x03 (ASG: context switch to phone book)");
                break;
            }
            case 4: {
                stringBuffer.append("0x04 (ASG: context switch to last destinations list)");
                break;
            }
            case 5: {
                stringBuffer.append("0x05 (ASG: context switch to traffic sign information)");
                break;
            }
            case 6: {
                stringBuffer.append("0x06 (ASG: context switch to digital speed)");
                break;
            }
            default: {
                stringBuffer.append("UNKNOWN ENUM");
            }
        }
        stringBuffer.append("\n - ConfigKey5: ");
        switch (this.configKey5) {
            case 0: {
                stringBuffer.append("0x00 (FSG internal function / not configured)");
                break;
            }
            case 1: {
                stringBuffer.append("0x01 (ASG: Screensaver on/off)");
                break;
            }
            case 2: {
                stringBuffer.append("0x02 (ASG: traffic signs on/off)");
                break;
            }
            case 3: {
                stringBuffer.append("0x03 (ASG: context switch to phone book)");
                break;
            }
            case 4: {
                stringBuffer.append("0x04 (ASG: context switch to last destinations list)");
                break;
            }
            case 5: {
                stringBuffer.append("0x05 (ASG: context switch to traffic sign information)");
                break;
            }
            case 6: {
                stringBuffer.append("0x06 (ASG: context switch to digital speed)");
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
        n += 8;
        n += 8;
        n += 8;
        n += 8;
        return n += 8;
    }

    @Override
    public void serialize(BitStream bitStream) {
        bitStream.pushByte((byte)this.configKey1);
        bitStream.pushByte((byte)this.configKey2);
        bitStream.pushByte((byte)this.configKey3);
        bitStream.pushByte((byte)this.configKey4);
        bitStream.pushByte((byte)this.configKey5);
    }

    @Override
    public void deserialize(BitStream bitStream) {
        this.configKey1 = bitStream.popFrontByte();
        this.configKey2 = bitStream.popFrontByte();
        this.configKey3 = bitStream.popFrontByte();
        this.configKey4 = bitStream.popFrontByte();
        this.configKey5 = bitStream.popFrontByte();
    }

    public static int functionId() {
        return 17;
    }

    @Override
    public int getFunctionId() {
        return KeyConfiguration_Status.functionId();
    }
}

