/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.generated.telephone2.serializer;

import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.requests.StatusProperty;
import de.vw.mib.bap.stream.BitStream;

public final class PhoneModuleState_Status
implements StatusProperty {
    public int moduleState;
    private static final int MODULE_STATE_BITSIZE = 8;
    public static final int MODULE_STATE_PHONE_MODULE_NOT_INSTALLED = 0;
    public static final int MODULE_STATE_PHONE_MODULE_OFF = 1;
    public static final int MODULE_STATE_PHONE_MODULE_ON = 2;
    public static final int MODULE_STATE_PHONE_MODULE_SWITCHING_OFF = 3;
    public static final int MODULE_STATE_PHONE_MODULE_SWITCHING_ON = 4;
    public static final int MODULE_STATE_PHONE_MODULE_NOT_FUNCTIONAL = 5;
    public static final int MODULE_STATE_PHONE_MODULE_OFF_HIGH_TEMPERATURE = 6;
    public int moduleSupportedServices;
    private static final int MODULE_SUPPORTED_SERVICES_BITSIZE = 8;
    public static final int MODULE_SUPPORTED_SERVICES_INVALID_UNKNOWN = 0;
    public static final int MODULE_SUPPORTED_SERVICES_TELEPHONE_AND_DATA_SERVICE_SUPPORTED = 1;
    public static final int MODULE_SUPPORTED_SERVICES_TELEPHONE_ONLY_SUPPORTED = 2;
    public static final int MODULE_SUPPORTED_SERVICES_DATA_SERVICE_ONLY_SUPPORTED = 3;
    public int moduleActiveServices;
    private static final int MODULE_ACTIVE_SERVICES_BITSIZE = 8;
    public static final int MODULE_ACTIVE_SERVICES_I_HW_IS_NOT_BEING_USED = 0;
    public static final int MODULE_ACTIVE_SERVICES_HW_IS_BEING_USED_FOR_TELEPHONY_AND_DATA_SERVICE = 1;
    public static final int MODULE_ACTIVE_SERVICES_HW_IS_BEING_USED_FOR_TELEPHONY = 2;
    public static final int MODULE_ACTIVE_SERVICES_HW_IS_BEING_USED_FOR_DATA_SERVICE = 3;
    public int simstate;
    private static final int SIM_STATE_BITSIZE = 8;
    public static final int SIM_STATE_INVALID_UNKNOWN = 0;
    public static final int SIM_STATE_NO_SIM_INSERTED = 1;
    public static final int SIM_STATE_SIM_INSERTED = 2;
    public static final int EXTENSION_1_MIN = 0;
    public int extension_1;
    private static final int EXTENSION_1_BITSIZE = 8;

    public PhoneModuleState_Status() {
        this.internalReset();
        this.customInitialization();
    }

    public PhoneModuleState_Status(BitStream bitStream) {
        this();
        this.deserialize(bitStream);
    }

    private void internalReset() {
        this.moduleState = 0;
        this.moduleSupportedServices = 0;
        this.moduleActiveServices = 0;
        this.simstate = 0;
        this.extension_1 = 0;
    }

    public void reset() {
        this.internalReset();
    }

    public boolean equalTo(BAPEntity bAPEntity) {
        PhoneModuleState_Status phoneModuleState_Status = (PhoneModuleState_Status)bAPEntity;
        return this.moduleState == phoneModuleState_Status.moduleState && this.moduleSupportedServices == phoneModuleState_Status.moduleSupportedServices && this.moduleActiveServices == phoneModuleState_Status.moduleActiveServices && this.simstate == phoneModuleState_Status.simstate && this.extension_1 == phoneModuleState_Status.extension_1;
    }

    private void customInitialization() {
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("PhoneModuleState_Status:");
        stringBuffer.append("\n - ModuleState: ");
        switch (this.moduleState) {
            case 0: {
                stringBuffer.append("0x00 (Phone module not installed)");
                break;
            }
            case 1: {
                stringBuffer.append("0x01 (Phone module off)");
                break;
            }
            case 2: {
                stringBuffer.append("0x02 (Phone module on)");
                break;
            }
            case 3: {
                stringBuffer.append("0x03 (Phone module switching off)");
                break;
            }
            case 4: {
                stringBuffer.append("0x04 (Phone module switching on)");
                break;
            }
            case 5: {
                stringBuffer.append("0x05 (Phone module not functional)");
                break;
            }
            case 6: {
                stringBuffer.append("0x06 (Phone module off high temperature)");
                break;
            }
            default: {
                stringBuffer.append("UNKNOWN ENUM");
            }
        }
        stringBuffer.append("\n - ModuleSupportedServices: ");
        switch (this.moduleSupportedServices) {
            case 0: {
                stringBuffer.append("0x00 (invalid / unknown)");
                break;
            }
            case 1: {
                stringBuffer.append("0x01 (telephone and data service supported)");
                break;
            }
            case 2: {
                stringBuffer.append("0x02 (telephone only supported)");
                break;
            }
            case 3: {
                stringBuffer.append("0x03 (data service only supported)");
                break;
            }
            default: {
                stringBuffer.append("UNKNOWN ENUM");
            }
        }
        stringBuffer.append("\n - ModuleActiveServices: ");
        switch (this.moduleActiveServices) {
            case 0: {
                stringBuffer.append("0x00 (iHW is not being used)");
                break;
            }
            case 1: {
                stringBuffer.append("0x01 (HW is being used for telephony and data service)");
                break;
            }
            case 2: {
                stringBuffer.append("0x02 (HW is being used for telephony)");
                break;
            }
            case 3: {
                stringBuffer.append("0x03 (HW is being used for data service)");
                break;
            }
            default: {
                stringBuffer.append("UNKNOWN ENUM");
            }
        }
        stringBuffer.append("\n - SIMState: ");
        switch (this.simstate) {
            case 0: {
                stringBuffer.append("0x00 (invalid / unknown)");
                break;
            }
            case 1: {
                stringBuffer.append("0x01 (no SIM inserted)");
                break;
            }
            case 2: {
                stringBuffer.append("0x02 (SIM inserted)");
                break;
            }
            default: {
                stringBuffer.append("UNKNOWN ENUM");
            }
        }
        stringBuffer.append("\n - Extension_1 - ");
        stringBuffer.append(this.extension_1);
        return stringBuffer.toString();
    }

    public int bitSize() {
        int n = 0;
        n += 8;
        n += 8;
        n += 8;
        n += 8;
        return n += 8;
    }

    public void serialize(BitStream bitStream) {
        bitStream.pushByte((byte)this.moduleState);
        bitStream.pushByte((byte)this.moduleSupportedServices);
        bitStream.pushByte((byte)this.moduleActiveServices);
        bitStream.pushByte((byte)this.simstate);
        bitStream.pushByte((byte)this.extension_1);
    }

    public void deserialize(BitStream bitStream) {
        this.moduleState = bitStream.popFrontByte();
        this.moduleSupportedServices = bitStream.popFrontByte();
        this.moduleActiveServices = bitStream.popFrontByte();
        this.simstate = bitStream.popFrontByte();
        this.extension_1 = bitStream.popFrontByte();
    }

    public static int functionId() {
        return 23;
    }

    public int getFunctionId() {
        return PhoneModuleState_Status.functionId();
    }
}

