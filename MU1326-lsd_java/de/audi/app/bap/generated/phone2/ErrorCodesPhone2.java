/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.bap.generated.phone2;

import de.audi.app.bap.utils.IErrorCodes;
import de.esolutions.fw.util.commons.Buffer;

public final class ErrorCodesPhone2
implements IErrorCodes {
    private static final String DESCRIPTION_NO_ERROR;
    private static final String DESCRIPTION_BCL_MEDIA_NOT_ACCESSIBLE;
    private static final String DESCRIPTION_BCL_ILLEGAL_SEQUENCE_SEGMENTATION;
    private static final String DESCRIPTION_BCL_SEQUENCE_ERROR_SEGMENTATION;
    private static final String DESCRIPTION_BCL_TIMEOUT_SEGMENTATION;
    private static final String DESCRIPTION_BCL_OVERSIZE_SEGMENTATION;
    private static final String DESCRIPTION_BCL_BAD_DATA_LENGTH;
    private static final String DESCRIPTION_BCL_RECEIVED_DATA_LOST;
    private static final String DESCRIPTION_BPL_HEARTBEAT_TIMEOUT;
    private static final String DESCRIPTION_BPL_RETRY_TIMEOUT;
    private static final String DESCRIPTION_BPL_BUSY;
    private static final String DESCRIPTION_BPL_REQUEST_TIMEOUT;
    private static final String DESCRIPTION_BAL_WRONG_ADDRESSING;
    private static final String DESCRIPTION_BAL_INCOMPATIBLE_PROTOCOL_VERSION;
    private static final String DESCRIPTION_BAL_INCOMPATIBLE_FUNCTION_CATALOG_VERSION;
    private static final String DESCRIPTION_BAL_DATA_INVALID;
    private static final String DESCRIPTION_BAL_INVALID_STATE;
    private static final String DESCRIPTION_BAL_CACHE_NOT_AVAILABLE;
    private static final String DESCRIPTION_BAL_INVALID_ARGUMENT;
    private static final String DESCRIPTION_APP_ERR_OUT_OF_RANGE;
    private static final String DESCRIPTION_APP_ERR_TEMPORARY_NOT_AVAILABLE;
    private static final String DESCRIPTION_APP_ERR_MAX_DATA_LENGTH_EXCEEDED;
    private static final String DESCRIPTION_APP_ERR_UNIT_MISMATCH;
    private static final String DESCRIPTION_APP_ERR_PARAMETER_MISMATCH;
    private static final String DESCRIPTION_APP_ERR_INVALID_ARGUMENT;
    private static final String DESCRIPTION_APP_ERR_METHOD_ABORTED;
    private static final String DESCRIPTION_APP_ERR_UNKNOWN;
    private static final String DESCRIPTION_APP_ERR_NOT_SUCCESSFUL;
    private static final String DESCRIPTION_APP_ERR_OUT_OF_MEMORY;
    private static final String DESCRIPTION_APP_ERR_DATA_INVALID;
    private static final String DESCRIPTION_APP_ERR_NO_USER_ACTIVE;
    private static final String DESCRIPTION_APP_ERR_NO_NETWORK;
    private static final String DESCRIPTION_APP_ERR_NOT_SUPPORTED_BY_NETWORK;
    private static final String DESCRIPTION_APP_ERR_NOT_REGISTERED_EMERGENCY_CALL_ONLY;
    private static final String DESCRIPTION_APP_ERR_CURRENT_CODE_INVALID;
    private static final String DESCRIPTION_APP_ERR_NEW_CODE_INVALID;
    private static final String DESCRIPTION_APP_ERR_NO_CODE_REQUIRED;
    private static final String DESCRIPTION_APP_ERR_NO_REDIALNUMBER;
    private static final String DESCRIPTION_APP_ERR_ACTIVE_CALL_PRESENT_DIALING;
    private static final String DESCRIPTION_APP_ERR_HELD_CALL_PRESENT;
    private static final String DESCRIPTION_APP_ERR_ACTIVE_AND_HELD_CALL_PRESENT;
    private static final String DESCRIPTION_APP_ERR_NO_CALL;
    private static final String DESCRIPTION_APP_ERR_NO_CALL_RELATED_TO_CALL_ID;
    private static final String DESCRIPTION_APP_ERR_NO_ACTIVE_CALL;
    private static final String DESCRIPTION_APP_ERR_NO_CALL_ON_HOLD;
    private static final String DESCRIPTION_APP_ERR_NO_INCOMING_WAITING_CALL;
    private static final String DESCRIPTION_APP_ERR_NO_CONFERENCE;
    private static final String DESCRIPTION_APP_ERR_NO_MEMBER_OF_CONFERENCE;
    private static final String DESCRIPTION_APP_ERR_MAXIMUM_NUMBER_FOR_MEMBERS_OF_CONFERENCE_REACHED;
    private static final String DESCRIPTION_APP_ERR_FUNCTION_NOT_SUPPORTED_FOR_CONFERENCE_CALLS;
    private static final String DESCRIPTION_APP_ERR_PHONEBOOK_DOWNLOAD_IN_PROGRESS;
    private static final String DESCRIPTION_APP_ERR_NOT_SUPPORTED_BY_MOBILE_PHONE_HFP;
    private static final String DESCRIPTION_APP_ERR_NO_HEADSET_CONNECTED;
    private static final String DESCRIPTION_APP_ERR_NO_PAIRED_HEADSET;
    private static final String ERROR_ID_UNKNOWN;

    @Override
    public String getDescription(int n) {
        switch (n) {
            case 0: {
                return "0x0 (NO_ERROR)";
            }
            case 17: {
                return "0x11 (BCL_MEDIA_NOT_ACCESSIBLE)";
            }
            case 18: {
                return "0x12 (BCL_ILLEGAL_SEQUENCE_SEGMENTATION)";
            }
            case 19: {
                return "0x13 (BCL_SEQUENCE_ERROR_SEGMENTATION)";
            }
            case 20: {
                return "0x14 (BCL_TIMEOUT_SEGMENTATION)";
            }
            case 21: {
                return "0x15 (BCL_OVERSIZE_SEGMENTATION)";
            }
            case 22: {
                return "0x16 (BCL_BAD_DATA_LENGTH)";
            }
            case 23: {
                return "0x17 (BCL_RECEIVED_DATA_LOST)";
            }
            case 33: {
                return "0x21 (BPL_HEARTBEAT_TIMEOUT)";
            }
            case 34: {
                return "0x22 (BPL_RETRY_TIMEOUT)";
            }
            case 35: {
                return "0x23 (BPL_BUSY)";
            }
            case 36: {
                return "0x24 (BPL_REQUEST_TIMEOUT)";
            }
            case 49: {
                return "0x31 (BAL_WRONG_ADDRESSING)";
            }
            case 50: {
                return "0x32 (BAL_INCOMPATIBLE_PROTOCOL_VERSION)";
            }
            case 51: {
                return "0x33 (BAL_INCOMPATIBLE_FUNCTION_CATALOG_VERSION)";
            }
            case 52: {
                return "0x34 (BAL_DATA_INVALID)";
            }
            case 53: {
                return "0x35 (BAL_INVALID_STATE)";
            }
            case 54: {
                return "0x36 (BAL_CACHE_NOT_AVAILABLE)";
            }
            case 55: {
                return "0x37 (BAL_INVALID_ARGUMENT)";
            }
            case 65: {
                return "0x41 (APP_ERR_OUT_OF_RANGE)";
            }
            case 66: {
                return "0x42 (APP_ERR_TEMPORARY_NOT_AVAILABLE)";
            }
            case 67: {
                return "0x43 (APP_ERR_MAX_DATA_LENGTH_EXCEEDED)";
            }
            case 68: {
                return "0x44 (APP_ERR_UNIT_MISMATCH)";
            }
            case 69: {
                return "0x45 (APP_ERR_PARAMETER_MISMATCH)";
            }
            case 70: {
                return "0x46 (APP_ERR_INVALID_ARGUMENT)";
            }
            case 80: {
                return "0x50 (APP_ERR_METHOD_ABORTED)";
            }
            case 128: {
                return "0x80 (APP_ERR_UNKNOWN)";
            }
            case 129: {
                return "0x81 (APP_ERR_NOT_SUCCESSFUL)";
            }
            case 130: {
                return "0x82 (APP_ERR_OUT_OF_MEMORY)";
            }
            case 131: {
                return "0x83 (APP_ERR_DATA_INVALID)";
            }
            case 136: {
                return "0x88 (APP_ERR_NO_USER_ACTIVE)";
            }
            case 137: {
                return "0x89 (APP_ERR_NO_NETWORK)";
            }
            case 138: {
                return "0x8a (APP_ERR_NOT_SUPPORTED_BY_NETWORK)";
            }
            case 139: {
                return "0x8b (APP_ERR_NOT_REGISTERED_EMERGENCY_CALL_ONLY)";
            }
            case 140: {
                return "0x8c (APP_ERR_CURRENT_CODE_INVALID)";
            }
            case 141: {
                return "0x8d (APP_ERR_NEW_CODE_INVALID)";
            }
            case 142: {
                return "0x8e (APP_ERR_NO_CODE_REQUIRED)";
            }
            case 143: {
                return "0x8f (APP_ERR_NO_REDIALNUMBER)";
            }
            case 144: {
                return "0x90 (APP_ERR_ACTIVE_CALL_PRESENT_DIALING)";
            }
            case 145: {
                return "0x91 (APP_ERR_HELD_CALL_PRESENT)";
            }
            case 146: {
                return "0x92 (APP_ERR_ACTIVE_AND_HELD_CALL_PRESENT)";
            }
            case 147: {
                return "0x93 (APP_ERR_NO_CALL)";
            }
            case 148: {
                return "0x94 (APP_ERR_NO_CALL_RELATED_TO_CALL_ID)";
            }
            case 149: {
                return "0x95 (APP_ERR_NO_ACTIVE_CALL)";
            }
            case 150: {
                return "0x96 (APP_ERR_NO_CALL_ON_HOLD)";
            }
            case 151: {
                return "0x97 (APP_ERR_NO_INCOMING_WAITING_CALL)";
            }
            case 154: {
                return "0x9a (APP_ERR_NO_CONFERENCE)";
            }
            case 155: {
                return "0x9b (APP_ERR_NO_MEMBER_OF_CONFERENCE)";
            }
            case 156: {
                return "0x9c (APP_ERR_MAXIMUM_NUMBER_FOR_MEMBERS_OF_CONFERENCE_REACHED)";
            }
            case 157: {
                return "0x9d (APP_ERR_FUNCTION_NOT_SUPPORTED_FOR_CONFERENCE_CALLS)";
            }
            case 158: {
                return "0x9e (APP_ERR_PHONEBOOK_DOWNLOAD_IN_PROGRESS)";
            }
            case 160: {
                return "0xa0 (APP_ERR_NOT_SUPPORTED_BY_MOBILE_PHONE_HFP)";
            }
            case 161: {
                return "0xa1 (APP_ERR_NO_HEADSET_CONNECTED)";
            }
            case 162: {
                return "0xa2 (APP_ERR_NO_PAIRED_HEADSET)";
            }
        }
        Buffer buffer = new Buffer();
        buffer.append("0x");
        buffer.append(Integer.toHexString(n));
        buffer.append(" (UNKNOWN)");
        return buffer.toString();
    }
}

